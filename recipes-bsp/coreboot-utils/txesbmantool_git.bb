SUMMARY = "Utility for generating TXE Secure Boot manifests"
HOMEPAGE = "https://github.com/Dasharo/coreboot"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "\
    file://${UNPACKDIR}/${BP}/LICENSES/GPL-2.0-only.txt;md5=5430828348d2cf7d4b5e8395f774a68e\
"

DEPENDS += "wolfssl"

PV = "1.0+git${SRCPV}"

# hardkernel_odroid_h4_v0.9.1 is a Dasharo release tag. bitbake checks at
# unpack time that it resolves to SRCREV. Dasharo branches can be rebased or
# deleted, so nobranch=1 makes the fetch depend on the tag alone.
SRC_URI = "\
    git://github.com/Dasharo/coreboot.git;tag=hardkernel_odroid_h4_v0.9.1;nobranch=1;protocol=https \
"

SRCREV = "7d10ea629b5783add25bdcd201dc898e6bd2b2c1"

S = "${UNPACKDIR}/${BP}/util/txesbmantool"

inherit pkgconfig

EXTRA_OEMAKE = ' \
               DESTDIR="${D}" \
               PREFIX="${prefix}" \
               '

do_configure:prepend(){
    export PKG_CONFIG_PATH="${STAGING_LIBDIR}/pkgconfig:${STAGING_DIR_HOST}/usr/lib/pkgconfig"
}

do_compile:prepend() {
    export PKG_CONFIG_PATH="${STAGING_LIBDIR}/pkgconfig:${STAGING_DIR_HOST}/usr/lib/pkgconfig"
}

do_install() {
    oe_runmake 'DESTDIR=${D}' install
}

INSANE_SKIP:${PN} += "ldflags"

FILES:${PN} += "\
    ${bindir}/txesbmantool\
"
