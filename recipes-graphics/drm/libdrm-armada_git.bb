SUMMARY = "Userspace interface to kernel DRM services"
SECTION = "x11/base"
LICENSE = "GPLv2 & BSD"

LIC_FILES_CHKSUM = "file://libdrm_lists.h;beginline=1;endline=25;md5=2af1df1026ba1d24c8e7c370e68ed198"

DEPENDS = "libdrm"

SRCREV = "607c697d7c403356601cd0d5fa6407b61a45e8ed"
PV = "0.1+git${SRCPV}"
SRC_URI = "git://github.com/g0hl1n/libdrm-armada.git;protocol=https"

inherit autotools pkgconfig

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE ?= "(imx|use-mainline-bsp)"
