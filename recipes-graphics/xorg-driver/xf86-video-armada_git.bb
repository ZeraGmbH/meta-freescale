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

DEPENDS += "libdrm-armada"

LIC_FILES_CHKSUM = " \
    file://README;md5=398023ad112dd65d0461eef7380a005f \
    file://etna_viv/LICENSE;md5=9d4853905d85f044ed013e75def30a76 \
    "

SRCREV = "85a21724f8f0e2dd55ccee8841ee260b275a853b"

PV = "0.1+git${SRCPV}"

SRC_URI = "git://github.com/xobs/xserver-xorg-video-armada.git;branch=novena-r2;protocol=https"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "xserver-xorg-module-exa \
                  xserver-xorg-extension-dri \
                  xserver-xorg-extension-dri2 \
                  xserver-xorg-extension-glx \
                  "

EXTRA_OECONF = "--disable-etnaviv \
                --disable-vivante \
                --with-etnaviv-source=${S}/etna_viv \
                "

COMPATIBLE_MACHINE = "(imx|use-mainline-bsp)"
