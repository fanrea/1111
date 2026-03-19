package com.kwad.framework.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.n;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends b.a implements i {
    private final g bgT;
    private final WeakReference<FileDownloadServiceProxy> bgU;

    public interface a {
        void a(e eVar);

        void onDisconnected();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final IBinder OM() {
        return null;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void a(com.kwad.framework.filedownloader.c.a aVar) {
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(com.kwad.framework.filedownloader.c.a aVar) {
    }

    e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.bgU = weakReference;
        this.bgT = gVar;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean C(String str, String str2) {
        return this.bgT.E(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        this.bgT.b(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean df(int i) {
        return this.bgT.df(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void pauseAllTasks() {
        this.bgT.OO();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean dz(int i) {
        return this.bgT.dz(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long dA(int i) {
        return this.bgT.dL(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long dB(int i) {
        return this.bgT.dB(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final byte dg(int i) {
        return this.bgT.dg(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean isIdle() {
        return this.bgT.isIdle();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void startForeground(int i, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.bgU;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.bgU.get().context.startForeground(i, notification);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void stopForeground(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.bgU;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.bgU.get().context.stopForeground(z);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean dh(int i) {
        return this.bgT.dh(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void Of() {
        this.bgT.Of();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void OL() {
        n.MX().a(this);
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void onDestroy() {
        n.MX().onDisconnected();
    }
}
