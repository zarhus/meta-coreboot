require coreboot-utils.inc

SUMMARY = "\
    Provides information about the Intel CPU/chipset hardware \
    configuration (register contents, MSRs, etc).\
"

DEPENDS += "pciutils zlib"

EXTRA_OEMAKE = ' \
               DESTDIR="${D}" \
               PREFIX="${prefix}" \
               '

do_compile () {
  oe_runmake -C util/inteltool
}

do_install () {
  oe_runmake -C util/inteltool install
}
