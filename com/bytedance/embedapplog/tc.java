package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class tc<SERVICE, RESULT> {
    private final hc<SERVICE, RESULT> b;
    private final Context c;
    private final CountDownLatch d = new CountDownLatch(1);
    private final Intent hc;

    interface hc<T, RESULT> {
        T d(IBinder iBinder);

        RESULT d(T t);
    }

    tc(Context context, Intent intent, hc<SERVICE, RESULT> hcVar) {
        this.c = context;
        this.hc = intent;
        this.b = hcVar;
    }

    RESULT d() {
        tc<SERVICE, RESULT>.d dVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            um.b("Don't do this in ui thread.", null);
            return null;
        }
        try {
            dVar = new d(this.d, this.b);
            this.c.bindService(this.hc, dVar, 1);
            this.d.await();
        } catch (Throwable th) {
            th = th;
            dVar = null;
        }
        try {
            return this.b.d((hc<SERVICE, RESULT>) dVar.d);
        } catch (Throwable th2) {
            th = th2;
            try {
                um.d(th);
                return null;
            } finally {
                d(dVar);
            }
        }
    }

    private void d(tc<SERVICE, RESULT>.d dVar) {
        if (dVar != null) {
            try {
                this.c.unbindService(dVar);
            } catch (Throwable th) {
                um.d(th);
            }
        }
    }

    class d implements ServiceConnection {
        private final CountDownLatch b;
        private final hc<SERVICE, RESULT> c;
        SERVICE d;

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        d(CountDownLatch countDownLatch, hc<SERVICE, RESULT> hcVar) {
            this.b = countDownLatch;
            this.c = hcVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            um.d("ServiceBlockBinder#onServiceConnected ".concat(String.valueOf(componentName)));
            try {
                this.d = this.c.d(iBinder);
            } catch (Throwable th) {
                try {
                    um.b("ServiceBlockBinder#onServiceConnected", th);
                    try {
                        this.b.countDown();
                    } catch (Exception e) {
                        um.d(e);
                    }
                } finally {
                    try {
                        this.b.countDown();
                    } catch (Exception e2) {
                        um.d(e2);
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            um.d("ServiceBlockBinder#onServiceDisconnected".concat(String.valueOf(componentName)));
            try {
                this.b.countDown();
            } catch (Exception e) {
                um.d(e);
            }
        }
    }
}
