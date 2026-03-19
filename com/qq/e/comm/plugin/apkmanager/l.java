package com.qq.e.comm.plugin.apkmanager;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.qq.e.ads.cfg.MultiProcessFlag;
import com.qq.e.comm.plugin.apkmanager.r;
import com.qq.e.comm.plugin.e3;
import com.qq.e.comm.plugin.g10;
import com.qq.e.comm.plugin.j3;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.t3;
import com.qq.e.comm.plugin.xo;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class l {
    private static final l g = new l();
    private final Context a;
    private g10 b;
    private boolean c = false;
    private r d;
    private ServiceConnection e;
    private final k f;

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.a();
        }
    }

    /* compiled from: A */
    private class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            l.this.d = r.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            l.this.d = null;
        }

        /* synthetic */ b(l lVar, a aVar) {
            this();
        }
    }

    private l() {
        Context contextA = r1.d().a();
        this.a = contextA;
        if (MultiProcessFlag.isMultiProcess()) {
            f();
            t3.a(1, r1.d().b().f());
        }
        this.f = new k(contextA);
    }

    public static l e() {
        return g;
    }

    private void f() {
        this.c = true;
        this.e = new b(this, null);
        i();
        xo.a(new a(), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        this.b = new g10();
        new j(this.b).a(this.a);
    }

    private void i() {
        try {
            this.a.startService(i.a(this.a));
        } catch (Throwable unused) {
        }
    }

    public void c(ApkDownloadTask apkDownloadTask) {
        try {
            j3.a(apkDownloadTask.r()).h = 2;
            if (this.a.startService(i.a(this.a, apkDownloadTask)) == null) {
                t3.a(1100914, (Integer) 1, apkDownloadTask);
            }
            t3.a(1100901, apkDownloadTask);
        } catch (Throwable unused) {
            t3.a(1100914, (Integer) 2, apkDownloadTask);
        }
    }

    public List<ApkDownloadTask> d() {
        if (!this.c) {
            return this.f.c();
        }
        r rVar = this.d;
        if (rVar != null) {
            try {
                return rVar.g();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public void g() {
        if (e3.h()) {
            try {
                this.a.startService(i.c(this.a));
            } catch (Throwable unused) {
            }
        }
    }

    public void h() {
        try {
            this.a.startService(i.d(this.a));
        } catch (Throwable unused) {
        }
    }

    public List<ApkDownloadTask> c() {
        if (this.c) {
            r rVar = this.d;
            if (rVar != null) {
                try {
                    return rVar.f();
                } catch (RemoteException unused) {
                }
            }
            return null;
        }
        return this.f.b();
    }

    public int d(ApkDownloadTask apkDownloadTask) {
        if (this.c) {
            r rVar = this.d;
            if (rVar != null) {
                try {
                    return rVar.c(apkDownloadTask);
                } catch (RemoteException unused) {
                }
            }
            return 0;
        }
        return this.f.c(apkDownloadTask);
    }

    public ApkDownloadTask c(String str) {
        if (this.c) {
            r rVar = this.d;
            if (rVar != null) {
                try {
                    return rVar.f(str);
                } catch (RemoteException unused) {
                }
            }
            return null;
        }
        return this.f.a(str);
    }

    public void a(com.qq.e.comm.plugin.m mVar) {
        if (this.c) {
            this.b.a(mVar);
        } else {
            com.qq.e.comm.plugin.n.a().a(mVar);
        }
    }

    public void b(com.qq.e.comm.plugin.m mVar) {
        if (this.c) {
            this.b.b(mVar);
        } else {
            com.qq.e.comm.plugin.n.a().b(mVar);
        }
    }

    public void a(String str, com.qq.e.comm.plugin.m mVar) {
        if (this.c) {
            this.b.a(str, mVar);
        } else {
            com.qq.e.comm.plugin.n.a().a(str, mVar);
        }
    }

    public int a(String str) {
        if (this.c) {
            r rVar = this.d;
            if (rVar != null) {
                try {
                    return rVar.d(str);
                } catch (RemoteException unused) {
                }
            }
            return 0;
        }
        return com.qq.e.comm.plugin.n.a().c(this.a, str);
    }

    void a() {
        if (this.d != null) {
            return;
        }
        try {
            this.a.bindService(i.b(this.a), this.e, 1);
        } catch (Throwable unused) {
        }
    }

    public ApkDownloadTask a(int i) {
        if (this.c) {
            r rVar = this.d;
            if (rVar != null) {
                try {
                    return rVar.f(i);
                } catch (RemoteException unused) {
                }
            }
            return null;
        }
        return this.f.a(i);
    }

    public int a(String str, int i) {
        if (this.c) {
            r rVar = this.d;
            if (rVar != null) {
                try {
                    return rVar.b(str, i);
                } catch (RemoteException unused) {
                }
            }
            return 0;
        }
        return this.f.b(str, i);
    }

    public void b(String str, com.qq.e.comm.plugin.m mVar) {
        if (this.c) {
            this.b.b(str, mVar);
        } else {
            com.qq.e.comm.plugin.n.a().b(str, mVar);
        }
    }

    public int b(String str) {
        r rVar;
        if (this.c && (rVar = this.d) != null) {
            try {
                return rVar.c(str);
            } catch (RemoteException unused) {
            }
        }
        return com.qq.e.comm.plugin.n.a().d(this.a, str);
    }

    public boolean a(ApkDownloadTask apkDownloadTask) {
        if (this.c) {
            r rVar = this.d;
            if (rVar != null) {
                try {
                    return rVar.b(apkDownloadTask);
                } catch (RemoteException unused) {
                }
            }
            return false;
        }
        return this.f.a(apkDownloadTask, 1);
    }

    public List<ApkDownloadTask> b() {
        if (this.c) {
            r rVar = this.d;
            if (rVar != null) {
                try {
                    return rVar.h();
                } catch (RemoteException unused) {
                }
            }
            return null;
        }
        return this.f.a();
    }

    public boolean a(ApkDownloadTask apkDownloadTask, boolean z) {
        if (this.c) {
            r rVar = this.d;
            if (rVar != null) {
                try {
                    return rVar.a(apkDownloadTask, z);
                } catch (RemoteException unused) {
                }
            }
            return false;
        }
        return this.f.a(apkDownloadTask, z);
    }

    public boolean b(ApkDownloadTask apkDownloadTask) {
        if (this.c) {
            r rVar = this.d;
            if (rVar != null) {
                try {
                    return rVar.d(apkDownloadTask);
                } catch (RemoteException unused) {
                }
            }
            return false;
        }
        return this.f.b(apkDownloadTask);
    }

    public boolean a(int i, int i2, long j) {
        if (this.c) {
            r rVar = this.d;
            if (rVar != null) {
                try {
                    return rVar.a(i, i2, j);
                } catch (RemoteException unused) {
                }
            }
            return false;
        }
        return this.f.a(i, i2, j);
    }
}
