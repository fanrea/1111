package com.kwad.framework.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class o implements e.a, u {
    private static Class<?> bdR;
    private final ArrayList<Runnable> bdS = new ArrayList<>();
    private com.kwad.framework.filedownloader.services.e bdT;

    o() {
    }

    private static Class<?> MZ() {
        if (bdR == null) {
            bdR = FileDownloadService.SharedMainProcessService.class;
        }
        return bdR;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.j(str, str2, z);
        }
        this.bdT.b(str, str2, z, i, i2, i3, z2, bVar, z3);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean df(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.df(i);
        }
        return this.bdT.df(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte dg(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.dg(i);
        }
        return this.bdT.dg(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.bdT != null;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void aR(Context context) {
        a(context, null);
    }

    private void a(Context context, Runnable runnable) {
        context.startService(new Intent(context, MZ()));
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean dh(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.dh(i);
        }
        return this.bdT.dh(i);
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void a(com.kwad.framework.filedownloader.services.e eVar) {
        this.bdT = eVar;
        List list = (List) this.bdS.clone();
        this.bdS.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        f.MK().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, MZ()));
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void onDisconnected() {
        this.bdT = null;
        f.MK().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, MZ()));
    }
}
