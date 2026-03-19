package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class e extends com.kwad.framework.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus bdx;

    public abstract void MH();

    public abstract void MI();

    @Override // com.kwad.framework.filedownloader.event.c
    public final boolean a(com.kwad.framework.filedownloader.event.b bVar) {
        if (!(bVar instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        DownloadServiceConnectChangedEvent.ConnectStatus connectStatusOd = ((DownloadServiceConnectChangedEvent) bVar).Od();
        this.bdx = connectStatusOd;
        if (connectStatusOd == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            MH();
            return false;
        }
        MI();
        return false;
    }

    public final DownloadServiceConnectChangedEvent.ConnectStatus MJ() {
        return this.bdx;
    }
}
