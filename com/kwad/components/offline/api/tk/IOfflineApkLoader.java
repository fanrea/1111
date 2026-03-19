package com.kwad.components.offline.api.tk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface IOfflineApkLoader {
    void addLoadStatusListener(IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener);

    void cancelDownload();

    void clearFileCache();

    void installApp();

    void openApp();

    void pauseDownload();

    void resumeDownload();

    void setCustomReportParam(String str);

    void startDownload();

    void stopDownload();

    void uninstallApp();
}
