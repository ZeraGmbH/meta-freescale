IMX_OPENGL_PKGCONFIGS_REMOVE        = ""
IMX_OPENGL_PKGCONFIGS_REMOVE_imxgpu = "glamor"
OPENGL_PKGCONFIGS_remove_mx6        = "${IMX_OPENGL_PKGCONFIGS_REMOVE}"
OPENGL_PKGCONFIGS_remove_mx7        = "${IMX_OPENGL_PKGCONFIGS_REMOVE}"
OPENGL_PKGCONFIGS_remove_mx8        = "${IMX_OPENGL_PKGCONFIGS_REMOVE}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI_append_imxgpu2d = " file://0003-Remove-check-for-useSIGIO-option.patch"
SRC_URI_append_use-mainline-bsp = " file://0001-Allow-to-enable-atomic-in-modesetting-DDX.patch"
