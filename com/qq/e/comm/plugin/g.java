package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum g {
    ADLoadSucc,
    ADLoadFail,
    ADReady,
    Exposured,
    Clicked,
    PopupDisplay,
    PopupClosed,
    ADSpecMeasured,
    ADClosed,
    ADLeftApplication,
    ADOpenOverlay,
    ADCloseOverlay,
    DownloadClosed,
    ConfirmDialogOpened,
    ConfirmDialogClosed;

    public static g a(String str) {
        for (g gVar : values()) {
            if (gVar.name().equals(str)) {
                return gVar;
            }
        }
        return null;
    }
}
