SUMMARY = "X.org graphics driver for KMS based systems with pluggable GPU backend"
DESCRIPTION = "The xf86-video-armada module is a 2D graphics driver for the X Window \
System as implemented by X.org, supporting these DRM KMS drivers: \
\
	Freescale i.MX \
	Marvell Armada 510 (Dove) \
\
and GPU drivers: \
	Vivante libGAL (Armada only) \
	Etnaviv (Armada and i.MX) with galcore kernel driver \
	Etnaviv (Armada and i.MX) with etnaviv DRM kernel driver \
"
LICENSE = "BSD"

require recipes-graphics/xorg-driver/xorg-driver-video.inc

DEPENDS += "libdrm-armada xorgproto libxcb"

LIC_FILES_CHKSUM = " \
    file://README;md5=d5271074fb6ad959b7b6cfa68b4adaf0 \
    file://etna_viv/LICENSE;md5=9d4853905d85f044ed013e75def30a76 \
"

SRCREV = "49a26eef17383187ef6b0d0c9fcd5061f3babf01"

PV = "0.1+git${SRCPV}"

SRC_URI = " \
    git://github.com/ilbers/xf86-video-armada.git;branch=unstable;protocol=https \
    file://0001-configure.ac-Do-not-ask-for-dri3-header.patch \
    file://0002-Shuffle-includes-to-fix-build.patch \
"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "xserver-xorg-module-exa \
                  xserver-xorg-extension-dri \
                  xserver-xorg-extension-dri2 \
                  xserver-xorg-extension-glx \
                  "

EXTRA_OECONF = "--disable-vivante \
                --with-etnaviv-source=${S}/etna_viv \
                "

COMPATIBLE_MACHINE = "(imx|use-mainline-bsp)"
