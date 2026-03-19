package com.ss.android.socialbase.downloader.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.b.b;
import com.ss.android.socialbase.downloader.b.hc;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.sy;
import com.ss.android.socialbase.downloader.mk.tt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an implements ServiceConnection, sy {
    private static int b;
    private static long c;
    private static boolean hc;
    private b d;
    private b.d.InterfaceC0786d h;
    private Future<?> tt;
    private Handler u = new Handler(Looper.getMainLooper());
    private hc an = null;
    private Runnable gb = new Runnable() { // from class: com.ss.android.socialbase.downloader.b.an.1
        @Override // java.lang.Runnable
        public void run() {
            if (an.hc || an.this.h == null) {
                return;
            }
            an.this.h.d();
        }
    };
    private CountDownLatch tc = new CountDownLatch(1);

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ArrayList<tt> k(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean d(int i, Map<Long, tt> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public Map<Long, tt> mq(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void uo(int i) {
    }

    public an() {
        SqlDownloadCacheService.d(com.ss.android.socialbase.downloader.downloader.b.tr(), this);
    }

    public void d(b.d.InterfaceC0786d interfaceC0786d) {
        this.h = interfaceC0786d;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        hc = true;
        this.u.removeCallbacks(this.gb);
        try {
            this.d = b.d.d(iBinder);
        } catch (Throwable th) {
            mq.d(th);
        }
        this.tt = com.ss.android.socialbase.downloader.downloader.b.mk().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.an.2
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                IBinder.DeathRecipient deathRecipient;
                synchronized (this) {
                    try {
                        try {
                            if (an.this.an != null && an.this.d != null) {
                                an.this.d.d(an.this.an);
                            }
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.b.an.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = an.hc = false;
                                    if (an.this.h() || an.this.h == null) {
                                        return;
                                    }
                                    an.this.u.postDelayed(an.this.gb, 2000L);
                                }
                            };
                        } catch (Throwable th2) {
                            try {
                                com.ss.android.socialbase.downloader.an.d.hc("SqlDownloadCacheAidlWra", "onServiceConnected fail", th2);
                                if (an.this.h != null) {
                                    an.this.h.d();
                                }
                                an.this.tc.countDown();
                                iBinder2 = iBinder;
                                deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.b.an.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused = an.hc = false;
                                        if (an.this.h() || an.this.h == null) {
                                            return;
                                        }
                                        an.this.u.postDelayed(an.this.gb, 2000L);
                                    }
                                };
                            } finally {
                                an.this.tc.countDown();
                                try {
                                    iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.b.an.2.1
                                        @Override // android.os.IBinder.DeathRecipient
                                        public void binderDied() {
                                            boolean unused = an.hc = false;
                                            if (an.this.h() || an.this.h == null) {
                                                return;
                                            }
                                            an.this.u.postDelayed(an.this.gb, 2000L);
                                        }
                                    }, 0);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        iBinder2.linkToDeath(deathRecipient, 0);
                    } catch (Throwable unused2) {
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.d = null;
        hc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (Build.VERSION.SDK_INT >= 26 || hc) {
            return false;
        }
        if (b > 5) {
            com.ss.android.socialbase.downloader.an.d.c("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - c < 15000) {
            com.ss.android.socialbase.downloader.an.d.c("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        b++;
        c = jCurrentTimeMillis;
        this.u.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.an.3
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.d(com.ss.android.socialbase.downloader.downloader.b.tr(), an.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.sy
    public void d(final SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.h.hc>> sparseArray2, final c cVar) {
        com.ss.android.socialbase.downloader.downloader.b.mk().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.an.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                c cVar2;
                Future future;
                an.this.d(new hc.d() { // from class: com.ss.android.socialbase.downloader.b.an.4.1
                    @Override // com.ss.android.socialbase.downloader.b.hc
                    public void d(Map map, Map map2) {
                        com.ss.android.socialbase.downloader.e.an.d(sparseArray, map);
                        com.ss.android.socialbase.downloader.e.an.d(sparseArray2, map2);
                        cVar.d();
                        an.this.d((hc) null);
                    }
                });
                try {
                    z = !an.this.tc.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    mq.d(th);
                    z = false;
                }
                if (z && (future = an.this.tt) != null) {
                    future.cancel(true);
                }
                an.this.d();
                if (!z || (cVar2 = cVar) == null) {
                    return;
                }
                cVar2.d();
            }
        });
    }

    public void d(hc hcVar) {
        synchronized (this) {
            b bVar = this.d;
            if (bVar != null) {
                try {
                    bVar.d(hcVar);
                } catch (RemoteException e) {
                    mq.d(e);
                }
            } else {
                this.an = hcVar;
            }
        }
    }

    public void d() {
        try {
            b bVar = this.d;
            if (bVar != null) {
                bVar.d();
            }
        } catch (RemoteException e) {
            mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b hc(int i) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.hc(i);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.b> d(String str) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.d(str);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.b> hc(String str) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.hc(str);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.b> b(String str) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.b(str);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.b> c(String str) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.c(str);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.b> hc() {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.hc();
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public List<com.ss.android.socialbase.downloader.h.hc> b(int i) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.b(i);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void c(int i) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                bVar.c(i);
            }
        } catch (RemoteException e) {
            mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(com.ss.android.socialbase.downloader.h.hc hcVar) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                bVar.d(hcVar);
            }
        } catch (RemoteException e) {
            mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void hc(com.ss.android.socialbase.downloader.h.hc hcVar) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                bVar.hc(hcVar);
            }
        } catch (RemoteException e) {
            mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(int i, int i2, long j) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                bVar.d(i, i2, j);
            }
        } catch (RemoteException e) {
            mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(int i, int i2, int i3, long j) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                bVar.d(i, i2, i3, j);
            }
        } catch (RemoteException e) {
            mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(int i, int i2, int i3, int i4) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                bVar.d(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
            mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b d(int i, int i2) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.d(i, i2);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
        try {
            b bVar2 = this.d;
            if (bVar2 != null) {
                return bVar2.d(bVar);
            }
            return false;
        } catch (RemoteException e) {
            mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean u(int i) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.u(i);
            }
            return false;
        } catch (RemoteException e) {
            mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean an(int i) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.an(i);
            }
            return false;
        } catch (RemoteException e) {
            mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void b() {
        try {
            b bVar = this.d;
            if (bVar != null) {
                bVar.b();
            }
        } catch (RemoteException e) {
            mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b h(int i) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.h(i);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b d(int i, long j, String str, String str2) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.d(i, j, str, str2);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b d(int i, long j) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.d(i, j);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b hc(int i, long j) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.hc(i, j);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b gb(int i) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.gb(i);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b b(int i, long j) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.b(i, j);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b c(int i, long j) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.c(i, j);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b tt(int i) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.tt(i);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public com.ss.android.socialbase.downloader.h.b tc(int i) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.tc(i);
            }
            return null;
        } catch (RemoteException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean c() {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.c();
            }
            return false;
        } catch (RemoteException e) {
            mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean u() {
        try {
            b bVar = this.d;
            if (bVar != null) {
                return bVar.u();
            }
            return false;
        } catch (RemoteException e) {
            mq.d(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
        try {
            b bVar2 = this.d;
            if (bVar2 != null) {
                bVar2.hc(bVar);
            }
        } catch (RemoteException e) {
            mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void d(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                bVar.d(i, list);
            }
        } catch (RemoteException e) {
            mq.d(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void hc(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
        try {
            b bVar = this.d;
            if (bVar != null) {
                bVar.hc(i, list);
            }
        } catch (RemoteException e) {
            mq.d(e);
        }
    }
}
