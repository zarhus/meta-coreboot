require coreboot-utils.inc

SUMMARY = " \
    A utility similar to inteltool, which dumps useful information on AMD CPUs \
    for porting boards to coreboot. \
"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/GPL-2.0-or-later.txt;md5=261bea1168c0bdfa73232ee90df11eb6"

DEPENDS += "pciutils zlib"

EXTRA_OEMAKE = ' \
               DESTDIR="${D}" \
               PREFIX="${prefix}" \
               '

SRC_URI = " \
    git://github.com/coreboot/coreboot.git;branch=main;protocol=https \
    file://coreboot-amdtool.patch \
"
SRC_URI:remove = "file://0002-treewide-Work-around-GCC-15-Werror-unterminated-stri.patch;patchdir=${PATCHDIR}"

SRCREV = "e59c5abd13e6be052281a77c076037bc85de7084"

do_compile () {
  oe_runmake -C util/amdtool
}

do_install () {
  oe_runmake -C util/amdtool install
}
