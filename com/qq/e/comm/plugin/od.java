package com.qq.e.comm.plugin;

import android.app.Activity;
import android.os.Build;
import android.view.WindowManager;
import com.qq.e.comm.plugin.jk;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class od {
    private static final String d = "od";
    private final Activity a;
    private final int b;
    private final jk c;

    public void c() {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        this.c.start();
        b();
    }

    public od(Activity activity, int i) {
        this.a = activity;
        this.b = i;
        int i2 = Build.VERSION.SDK_INT;
        long refreshRate = i2 >= 23 ? (long) (1.0E9f / ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getMode().getRefreshRate()) : 16666666L;
        if (i2 >= 24) {
            this.c = new nd(activity, refreshRate);
        } else {
            this.c = new md(activity, refreshRate);
        }
    }

    /* compiled from: A */
    class a extends a1 {
        a() {
        }

        @Override // com.qq.e.comm.plugin.a1, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            super.onActivityDestroyed(activity);
            if (activity != od.this.a) {
                return;
            }
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            String unused = od.d;
            od.this.c.stop();
            od.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        jk.a aVarA = this.c.a();
        long j = (aVarA.e * 1000000000) + (aVarA.d * 1000000) + (aVarA.c * 1000) + aVarA.b + 0;
        wt wtVar = new wt(this.b);
        wtVar.b(j);
        b10.a(wtVar);
    }

    private void b() {
        this.a.getApplication().registerActivityLifecycleCallbacks(new a());
    }
}
