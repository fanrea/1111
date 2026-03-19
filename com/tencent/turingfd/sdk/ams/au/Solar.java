package com.tencent.turingfd.sdk.ams.au;

import aegon.chrome.net.NetError;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class Solar implements Aquila {
    public Pyxis a;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Solar$do, reason: invalid class name */
    public class Cdo implements ServiceConnection {
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ Object c;

        public Cdo(Solar solar, AtomicReference atomicReference, AtomicReference atomicReference2, Object obj) {
            this.a = atomicReference;
            this.b = atomicReference2;
            this.c = obj;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.a.set(iBinder);
            this.b.set(this);
            synchronized (this.c) {
                try {
                    this.c.notifyAll();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public abstract String a(IBinder iBinder) throws Exception;

    @Override // com.tencent.turingfd.sdk.ams.au.Aquila
    public void a(Context context) {
        this.a = c(context);
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Aquila
    public Pyxis b(Context context) {
        Pyxis pyxis = this.a;
        if (pyxis == null || pyxis.b != 0) {
            this.a = c(context);
        }
        return this.a;
    }

    public final Pyxis c(Context context) {
        int iA;
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set("");
        try {
            AtomicReference<IBinder> atomicReference2 = new AtomicReference<>();
            AtomicReference<ServiceConnection> atomicReference3 = new AtomicReference<>();
            iA = a(context, atomicReference2, atomicReference3);
            if (iA == 0) {
                try {
                    iA = a(context, atomicReference2, atomicReference3, atomicReference);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            iA = -1;
        }
        return new Pyxis(atomicReference.get(), iA);
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Solar$if, reason: invalid class name */
    public class Cif extends Thread {
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ AtomicReference c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ AtomicReference e;
        public final /* synthetic */ Object f;

        public Cif(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3, Context context, AtomicReference atomicReference4, Object obj) {
            this.a = atomicReference;
            this.b = atomicReference2;
            this.c = atomicReference3;
            this.d = context;
            this.e = atomicReference4;
            this.f = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String strA = "";
            try {
                strA = Solar.this.a((IBinder) this.a.get());
            } catch (Throwable unused) {
                this.b.set(Integer.valueOf(NetError.ERR_CONNECTION_REFUSED));
            }
            this.c.set(strA);
            try {
                this.d.unbindService((ServiceConnection) this.e.get());
            } catch (Throwable unused2) {
                this.b.set(-103);
            }
            synchronized (this.f) {
                try {
                    this.f.notifyAll();
                } catch (Throwable unused3) {
                }
            }
        }
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2) {
        Object obj = new Object();
        Intent intent = new Intent(Cfinally.a(Cfinally.k));
        intent.setComponent(new ComponentName(Cfinally.a(Cfinally.g), Cfinally.a(Cfinally.h)));
        if (!context.bindService(intent, new Cdo(this, atomicReference, atomicReference2, obj), 1)) {
            return -100;
        }
        if (atomicReference.get() == null) {
            synchronized (obj) {
                try {
                    obj.wait(1000L);
                } catch (Throwable unused) {
                }
            }
        }
        return atomicReference.get() == null ? -105 : 0;
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2, AtomicReference<String> atomicReference3) {
        Object obj = new Object();
        AtomicReference atomicReference4 = new AtomicReference(0);
        new Cif(atomicReference, atomicReference4, atomicReference3, context, atomicReference2, obj).start();
        synchronized (obj) {
            try {
                obj.wait(1000L);
            } catch (Throwable unused) {
            }
        }
        return ((Integer) atomicReference4.get()).intValue();
    }
}
