require coreboot-utils.inc

SUMMARY = "Dumps chipset-specific MSR registers."
DEPENDS += "pciutils"
S = "${UNPACKDIR}/${BP}/util/msrtool"
export PREFIX = "${prefix}"
inherit autotools-brokensep
