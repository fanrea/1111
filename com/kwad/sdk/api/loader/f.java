package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f implements Thread.UncaughtExceptionHandler {
    private static f bsl;
    private Thread.UncaughtExceptionHandler bsm;
    private int bsn;
    private long bsp;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean bso = new AtomicBoolean();

    public static f bi(Context context) {
        if (bsl == null) {
            synchronized (f.class) {
                if (bsl == null) {
                    bsl = new f(context);
                }
            }
        }
        return bsl;
    }

    private f(Context context) {
        this.mContext = context;
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.bsm = uncaughtExceptionHandler;
        }
    }

    public final void eb(int i) {
        this.bsp = System.currentTimeMillis();
        this.bsn = i;
        if (this.DEBUG) {
            Log.d("test.chen", "startCheck:");
        }
    }

    public final void cancel() {
        if (this.DEBUG) {
            Log.d("test.chen", "AutoRevertHandler cancel:");
        }
        this.bso.set(true);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.DEBUG) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.bsp + ",mMaxDuration:" + this.bsn + ",mIsCancel:" + this.bso.get());
            }
            if (!this.bso.get() && this.bsp > 0 && System.currentTimeMillis() - this.bsp <= this.bsn) {
                Boolean bool = (Boolean) com.kwad.sdk.api.b.g("filterStack", th);
                boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
                Context context = this.mContext;
                if (context != null && zBooleanValue) {
                    b.a(context, i.bst, true);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.bsm;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.bsm;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            } catch (Throwable th3) {
                if (this.bsm != null) {
                    this.bsm.uncaughtException(thread, th);
                }
                throw th3;
            }
        }
    }
}
