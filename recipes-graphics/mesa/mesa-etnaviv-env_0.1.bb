SUMMARY = "Mesa environment variables for etnaviv on xserver"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch

SRC_URI = "file://mesa-etnaviv.conf"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    # MESA global envirronment variables

    # systemd
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/systemd/system.conf.d
        install -m 644 ${WORKDIR}/mesa-etnaviv.conf ${D}${sysconfdir}/systemd/system.conf.d/
    fi

    # sysvinit - TODO
}

ALLOW_EMPTY_${PN} = "1"
