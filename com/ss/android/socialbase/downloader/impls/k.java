package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.CSJIndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.mk;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class k extends com.ss.android.socialbase.downloader.downloader.d implements ServiceConnection {
    private static final String u = "k";
    private com.ss.android.socialbase.downloader.downloader.mk an;
    private int gb = -1;
    private com.ss.android.socialbase.downloader.downloader.cb h;

    @Override // com.ss.android.socialbase.downloader.downloader.d
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.an.d.hc(u, "bindService");
            Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.e.an.d()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.uo.d.b().d("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.d
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.ss.android.socialbase.downloader.an.d.hc(u, "stopService");
        this.hc = false;
        Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.d, com.ss.android.socialbase.downloader.downloader.w
    public IBinder d(Intent intent) throws JSONException {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            com.bytedance.sdk.component.utils.mq.hc(u, "downloader process sync database on main process!");
            com.ss.android.socialbase.downloader.uo.d.d("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.an.d.hc(u, "onBind IndependentDownloadBinder");
        return new uo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.d, com.ss.android.socialbase.downloader.downloader.w
    public void hc(com.ss.android.socialbase.downloader.h.c cVar) {
        if (cVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.hc(u, "tryDownload aidlService == null:" + (this.an == null));
        if (this.an == null) {
            d(cVar);
            startService(com.ss.android.socialbase.downloader.downloader.b.tr(), this);
            return;
        }
        h();
        try {
            this.an.d(com.ss.android.socialbase.downloader.e.h.d(cVar));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    private void h() {
        SparseArray<List<com.ss.android.socialbase.downloader.h.c>> sparseArrayClone;
        try {
            synchronized (this.d) {
                sparseArrayClone = this.d.clone();
                this.d.clear();
            }
            if (sparseArrayClone == null || sparseArrayClone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.b.j() == null) {
                return;
            }
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<com.ss.android.socialbase.downloader.h.c> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    Iterator<com.ss.android.socialbase.downloader.h.c> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.an.d(com.ss.android.socialbase.downloader.e.h.d(it.next()));
                        } catch (RemoteException e) {
                            com.bytedance.sdk.component.utils.mq.d(e);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.an.d.hc(u, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.d, com.ss.android.socialbase.downloader.downloader.w
    public void b(com.ss.android.socialbase.downloader.h.c cVar) {
        if (cVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.d().d(cVar.w(), true);
        d dVarJ = com.ss.android.socialbase.downloader.downloader.b.j();
        if (dVarJ != null) {
            dVarJ.d(cVar);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = u;
        com.ss.android.socialbase.downloader.an.d.hc(str, "onServiceConnected ");
        this.an = mk.d.d(iBinder);
        com.ss.android.socialbase.downloader.downloader.cb cbVar = this.h;
        if (cbVar != null) {
            cbVar.d(iBinder);
        }
        com.ss.android.socialbase.downloader.an.d.hc(str, "onServiceConnected aidlService!=null" + (this.an != null) + " pendingTasks.size:" + this.d.size());
        if (this.an != null) {
            com.ss.android.socialbase.downloader.downloader.c.d().hc();
            this.hc = true;
            this.c = false;
            int i = this.gb;
            if (i != -1) {
                try {
                    this.an.mq(i);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
            }
            if (this.an != null) {
                h();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.an.d.hc(u, "onServiceDisconnected ");
        this.an = null;
        this.hc = false;
        com.ss.android.socialbase.downloader.downloader.cb cbVar = this.h;
        if (cbVar != null) {
            cbVar.gb();
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.an = null;
        com.ss.android.socialbase.downloader.downloader.cb cbVar = this.h;
        if (cbVar != null) {
            cbVar.gb();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.d, com.ss.android.socialbase.downloader.downloader.w
    public void d(com.ss.android.socialbase.downloader.downloader.cb cbVar) {
        this.h = cbVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.d, com.ss.android.socialbase.downloader.downloader.w
    public void d(int i) {
        com.ss.android.socialbase.downloader.downloader.mk mkVar = this.an;
        if (mkVar == null) {
            this.gb = i;
            return;
        }
        try {
            mkVar.mq(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.d, com.ss.android.socialbase.downloader.downloader.w
    public void startService() {
        if (this.an == null) {
            startService(com.ss.android.socialbase.downloader.downloader.b.tr(), this);
        }
    }
}
