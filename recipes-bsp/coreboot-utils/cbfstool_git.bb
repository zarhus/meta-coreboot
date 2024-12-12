require coreboot-utils.inc

SUMMARY = "Tool for manipulating CBFS file"

SRC_URI += " \
    git://review.coreboot.org/vboot.git;destsuffix=git/3rdparty/vboot;name=vboot;protocol=https;branch=main \
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
    oe_runmake -C util/cbfstool cbfstool
}

do_install () {
    install -d ${D}/${sbindir}
    install ${S}/util/${PN}/${PN} ${D}/${sbindir}
}
