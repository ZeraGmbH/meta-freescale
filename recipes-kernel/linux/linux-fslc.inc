# Copyright (C) 2012-2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

SRC_URI = " \
    git://github.com/Freescale/linux-fslc.git;branch=${SRCBRANCH} \
    file://defconfig \
    file://0001-USB-serial-pl2303-add-support-for-PL2303HXN.patch \
"
LOCALVERSION = "-fslc"

do_install_append() {
    rm -f ${D}/boot/uImage
    mv ${D}/boot/uImage* ${D}/boot/uImage
}
