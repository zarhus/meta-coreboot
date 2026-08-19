require coreboot-utils.inc

SUMMARY = "Tool for manipulating CBFS file"

SRC_URI += " \
    git://review.coreboot.org/vboot.git;destsuffix=${BB_GIT_DEFAULT_DESTSUFFIX}/3rdparty/vboot;name=vboot;protocol=https;branch=main \
    file://0003-cbfstool-fix-const-discarding-warning-in-extract_con.patch;patchdir=${PATCHDIR}/3rdparty/vboot \
"

SRCREV_vboot = "0c11187c755394683d1b75bdb103cb1959fa6d40"
SRCREV_FORMAT = "vboot"

TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OEMAKE = " \
    DESTDIR=\"${D}\" \
    PREFIX=\"${prefix}\" \
"

INSANE_SKIP:${PN} = "textrel"

do_compile () {
    # strip build paths from binaries to fix buildpaths QA error
    export TOOLCFLAGS="${DEBUG_PREFIX_MAP}"
    # assigned to CFLAGS in vboot Makefile. Cannot export CFLAGS since it's unset
    # in cbfstool Makefile
    export CPPFLAGS="${DEBUG_PREFIX_MAP}"
    oe_runmake -C util/cbfstool cbfstool
}

do_install () {
    install -d ${D}/${sbindir}
    install ${S}/util/${PN}/${PN} ${D}/${sbindir}
}
