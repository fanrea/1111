package com.kwad.framework.filedownloader.event;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus bgd;
    private final Class<?> bge;

    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.bgd = connectStatus;
        this.bge = cls;
    }

    public final ConnectStatus Od() {
        return this.bgd;
    }
}
