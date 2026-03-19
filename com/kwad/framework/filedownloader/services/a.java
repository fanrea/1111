package com.kwad.framework.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {
    private volatile INTERFACE bgH;
    private final Class<?> bge;
    private final HashMap<String, Object> bgI = new HashMap<>();
    private final List<Context> bgJ = new ArrayList();
    private final ArrayList<Runnable> bdS = new ArrayList<>();
    private final CALLBACK bgG = (CALLBACK) Nb();

    protected abstract CALLBACK Nb();

    protected abstract void a(INTERFACE r1, CALLBACK callback);

    protected abstract INTERFACE b(IBinder iBinder);

    protected final INTERFACE OA() {
        return this.bgH;
    }

    protected a(Class<?> cls) {
        this.bge = cls;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.bgH = (INTERFACE) b(iBinder);
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceConnected %s %s", componentName, this.bgH);
        }
        try {
            a((a<CALLBACK, INTERFACE>) this.bgH, (INTERFACE) this.bgG);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        List list = (List) this.bdS.clone();
        this.bdS.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        com.kwad.framework.filedownloader.f.MK().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.bge));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceDisconnected %s %s", componentName, this.bgH);
        }
        cl(true);
    }

    private void cl(boolean z) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "release connect resources %s", this.bgH);
        }
        this.bgH = null;
        com.kwad.framework.filedownloader.f.MK().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.bge));
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void aR(Context context) {
        a(context, (Runnable) null);
    }

    private void a(Context context, Runnable runnable) {
        if (com.kwad.framework.filedownloader.f.f.aU(context)) {
            throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
        }
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
        }
        Intent intent = new Intent(context, this.bge);
        if (!this.bgJ.contains(context)) {
            this.bgJ.add(context);
        }
        context.bindService(intent, this, 1);
        context.startService(intent);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return OA() != null;
    }
}
