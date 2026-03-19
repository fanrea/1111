package com.baidu.mobstat.forbes;

import android.content.Context;
import java.lang.Thread;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class a implements Thread.UncaughtExceptionHandler {
    private static final a a = new a();
    private Thread.UncaughtExceptionHandler b;
    private Context c;

    public static a a() {
        return a;
    }

    private a() {
    }

    public void a(Context context) {
        this.c = context;
        if (this.b == null) {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!CooperService.instance().isCloseTrace()) {
            ExceptionAnalysis.getInstance().saveCrashInfo(this.c, th, true);
        }
        if (!this.b.equals(this)) {
            this.b.uncaughtException(thread, th);
        }
    }
}
