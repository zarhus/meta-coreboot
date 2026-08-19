DESCRIPTION = "coreboot tools"
HOMEPAGE = "https://doc.coreboot.org/util.html"
SECTION = "coreboot"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

PV = "4.21+git${SRCPV}"

SRC_URI = " \
    git://github.com/Dasharo/coreboot.git;protocol=https;branch=dasharo-4.21\
"
SRC_URI:append = " \
    file://0002-treewide-Work-around-GCC-15-Werror-unterminated-stri.patch;patchdir=${PATCHDIR} \
"

SRCREV = "d08d5eaa98b1204b5e665d3ae4f63fb6f84a0d77"

PATCHDIR = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}"
