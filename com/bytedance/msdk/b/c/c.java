package com.bytedance.msdk.b.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.bytedance.msdk.api.activity.TTTransparentActivity;
import com.bytedance.msdk.core.hc;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class c extends tc {
    protected boolean cb;
    private boolean d;
    private Handler de;
    private volatile boolean hc;
    private int he;
    private String j;
    private SoftReference<Activity> jh;
    private int np;
    private final Application.ActivityLifecycleCallbacks s;
    private SoftReference<Activity> sy;
    private int v;
    private com.bytedance.msdk.hc.b vv;
    private int yi;
    private Object zw;

    protected void d(Activity activity, Object obj, String str) {
    }

    public c(Context context) {
        super(context);
        this.d = false;
        this.cb = true;
        this.hc = false;
        this.jh = new SoftReference<>(null);
        this.sy = new SoftReference<>(null);
        this.v = 0;
        this.np = 2;
        this.yi = 0;
        this.he = 15000;
        this.s = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.b.c.c.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- onActivityCreated: activity: ".concat(String.valueOf(activity)));
                Activity activity2 = (Activity) c.this.sy.get();
                if (activity2 == null) {
                    com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- onActivityCreated: start transparent activity");
                    if (activity instanceof TTTransparentActivity) {
                        c.this.sy = new SoftReference(activity);
                        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- onActivityCreated: start transparent activity, callSuperShowAd");
                        c cVar = c.this;
                        cVar.hc(cVar.vv, activity, c.this.zw, c.this.j);
                        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- onActivityCreated: end");
                        return;
                    }
                    return;
                }
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- onActivityCreated again, showingActivity: ".concat(String.valueOf(activity2)));
                String name = activity.getClass().getName();
                if ((activity2 instanceof TTTransparentActivity) && com.bytedance.msdk.core.admanager.d.hc(name)) {
                    com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- onActivityCreated again, is adn ad activity: ".concat(String.valueOf(activity)));
                    activity2.finish();
                    c.this.sy = new SoftReference(activity);
                } else {
                    com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- onActivityCreated again, is not adn ad activity");
                }
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- onActivityCreated: end 2");
            }
        };
    }

    public void hc(com.bytedance.msdk.api.d.hc hcVar) {
        d(hcVar);
        if (this.h != null) {
            this.yi = this.h.uo();
            if (b()) {
                this.np = this.h.k();
                int iTt = this.h.tt(this.h.ba());
                this.he = iTt;
                if (iTt <= 0) {
                    this.he = 15000;
                }
                this.de = new Handler(Looper.getMainLooper());
                return;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- inter full refresh is not enabled");
        }
    }

    private boolean b() {
        return this.yi != 0;
    }

    private void c() {
        if (this.hc) {
            return;
        }
        Application applicationD = hc.d.d();
        if (applicationD == null) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- app is null, 插全屏轮播直接return");
            return;
        }
        applicationD.unregisterActivityLifecycleCallbacks(this.s);
        applicationD.registerActivityLifecycleCallbacks(this.s);
        this.hc = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(com.bytedance.msdk.hc.b bVar, Activity activity, Object obj, String str) {
        super.d(bVar, activity, obj, str);
    }

    @Override // com.bytedance.msdk.b.c.tc
    public void d(com.bytedance.msdk.hc.b bVar, Activity activity, Object obj, String str) {
        if (b()) {
            c();
            this.jh = new SoftReference<>(activity);
            this.vv = bVar;
            this.c = bVar;
            this.zw = obj;
            this.j = str;
            Intent intent = new Intent(com.bytedance.msdk.core.hc.getContext(), (Class<?>) TTTransparentActivity.class);
            intent.addFlags(268435456);
            com.bytedance.msdk.core.hc.getContext().startActivity(intent);
            return;
        }
        super.d(bVar, activity, obj, str);
    }

    @Override // com.bytedance.msdk.b.c.tc
    protected boolean sy() {
        return this.d;
    }

    private void d(final Handler handler, final Activity activity) {
        int i = this.he - 2000;
        if (i <= 0) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.bytedance.msdk.b.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.d(activity)) {
                    c.this.u();
                    return;
                }
                Toast toastMakeText = Toast.makeText(com.bytedance.msdk.core.hc.getContext(), "2秒后播放下一个广告", 0);
                toastMakeText.show();
                handler.postDelayed(new d(toastMakeText, 1, handler), 1000L);
            }
        }, i);
    }

    private static class d implements Runnable {
        private final Handler b;
        private Toast d;
        private final int hc;

        private d(Toast toast, int i, Handler handler) {
            this.d = toast;
            this.hc = i;
            this.b = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hc > 0) {
                this.d.cancel();
                Toast toastMakeText = Toast.makeText(com.bytedance.msdk.core.hc.getContext(), this.hc + "秒后播放下一个广告", 0);
                this.d = toastMakeText;
                toastMakeText.show();
                Handler handler = this.b;
                handler.postDelayed(new d(this.d, this.hc - 1, handler), 1000L);
                return;
            }
            this.d.cancel();
        }
    }

    protected final void de() {
        if (b()) {
            this.cb = true;
            this.v++;
            final Activity activity = this.jh.get();
            final Activity activity2 = this.sy.get();
            final com.bytedance.msdk.hc.b bVar = this.vv;
            if (!d(activity2, activity, bVar)) {
                u();
                return;
            }
            Handler handler = this.de;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                d(this.de, activity2);
                this.de.postDelayed(new Runnable() { // from class: com.bytedance.msdk.b.c.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.d(activity2)) {
                            c.this.u();
                            return;
                        }
                        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播 开始，先showingActivity finish");
                        c.this.cb = false;
                        activity2.finish();
                        bVar.yo();
                        c.this.sy = new SoftReference(null);
                        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播开始 showingActivity finish end");
                        c.this.d = true;
                        c cVar = c.this;
                        cVar.d(activity, cVar.zw, c.this.j);
                    }
                }, this.he);
            }
        }
    }

    protected final void v() {
        if (b()) {
            if (this.cb) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 用户关闭了广告，停止轮播");
                Activity activity = this.sy.get();
                if (activity instanceof TTTransparentActivity) {
                    com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 用户关闭了广告，finish showingActivity");
                    activity.finish();
                    this.sy = new SoftReference<>(null);
                }
                u();
                return;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 调用finish触发了close回调");
        }
    }

    protected final void np() {
        if (b()) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 用户点击了广告，停止轮播");
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Handler handler = this.de;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Application applicationD = hc.d.d();
        if (applicationD != null) {
            applicationD.unregisterActivityLifecycleCallbacks(this.s);
        }
    }

    private boolean d(com.bytedance.msdk.core.tc.tc tcVar) {
        return tcVar.hv() && tcVar.d() != 1;
    }

    private boolean c(com.bytedance.msdk.hc.b bVar) {
        return bVar.wz() && bVar.np() != 1;
    }

    private boolean d(Activity activity, Activity activity2, com.bytedance.msdk.hc.b bVar) {
        if (this.v >= this.np) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播，轮播次数已达上限: " + this.np);
            return false;
        }
        if (activity2 == null) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播 停止轮播 developerActivity为null");
            return false;
        }
        if (bVar == null) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播，ttBaseAd为null，不轮播");
            return false;
        }
        if (c(bVar)) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播，展示的是自定义adn，则不轮播");
            return false;
        }
        if (com.bytedance.msdk.core.admanager.d.d(bVar.nw(), bVar.el(), bVar.nv())) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播，当前展示的广告不支持轮播: " + bVar.nw() + ", adtype: " + bVar.el() + ", subType: " + bVar.nv());
            com.bytedance.msdk.u.an.d(this.an, 81011);
            return false;
        }
        if (activity != null) {
            return true;
        }
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播，showingActivity是null，停止轮播");
        com.bytedance.msdk.u.an.d(this.an, 81010);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播，showingActivity正在finish或已经destroy，停止轮播");
            return false;
        }
        int iAn = an();
        if (iAn == 2) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播，无任何广告可用，停止轮播");
            com.bytedance.msdk.u.an.d(this.an, 81008);
            return false;
        }
        if (iAn == 1) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播，仅有自定义adn广告可用，停止轮播");
            com.bytedance.msdk.u.an.d(this.an, 81009);
            return false;
        }
        int iHc = hc(this.u);
        if (iHc == 0) {
            return true;
        }
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==--- 插全屏轮播，命中了展示频控，停止轮播");
        com.bytedance.msdk.u.an.d(this.an, iHc);
        return false;
    }

    private int an() {
        CopyOnWriteArrayList<com.bytedance.msdk.hc.b> copyOnWriteArrayListH;
        CopyOnWriteArrayList<com.bytedance.msdk.hc.b> copyOnWriteArrayListTc;
        CopyOnWriteArrayList<com.bytedance.msdk.hc.b> copyOnWriteArrayListGb;
        boolean z;
        List<com.bytedance.msdk.core.tc.tc> listHc = null;
        if (this.b != null) {
            copyOnWriteArrayListH = this.b.h();
            copyOnWriteArrayListTc = this.b.tc();
            copyOnWriteArrayListGb = this.b.gb();
        } else {
            copyOnWriteArrayListH = null;
            copyOnWriteArrayListTc = null;
            copyOnWriteArrayListGb = null;
        }
        if (copyOnWriteArrayListH == null || copyOnWriteArrayListH.size() <= 0) {
            z = false;
        } else {
            z = false;
            for (com.bytedance.msdk.hc.b bVar : copyOnWriteArrayListH) {
                if (bVar != null && bVar.ba(this.u) && !bVar.xp()) {
                    if (!c(bVar) && !com.bytedance.msdk.core.admanager.d.d(bVar.nw(), bVar.el(), bVar.nv())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        if (copyOnWriteArrayListGb != null && copyOnWriteArrayListGb.size() > 0) {
            for (com.bytedance.msdk.hc.b bVar2 : copyOnWriteArrayListGb) {
                if (bVar2 != null && bVar2.ba(this.u) && !bVar2.xp()) {
                    if (!c(bVar2) && !com.bytedance.msdk.core.admanager.d.d(bVar2.nw(), bVar2.el(), bVar2.nv())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        if (copyOnWriteArrayListTc != null && copyOnWriteArrayListTc.size() > 0) {
            for (com.bytedance.msdk.hc.b bVar3 : copyOnWriteArrayListTc) {
                if (bVar3 != null && bVar3.ba(this.u) && !bVar3.xp()) {
                    if (!c(bVar3) && !com.bytedance.msdk.core.admanager.d.d(bVar3.nw(), bVar3.el(), bVar3.nv())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        try {
            listHc = hc();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        if (listHc != null && listHc.size() > 0) {
            for (com.bytedance.msdk.core.tc.tc tcVar : listHc) {
                String strYo = tcVar.yo();
                if (tcVar.jh() && com.bytedance.msdk.core.u.d.d.d().c(this.u, strYo, rf()) && com.bytedance.msdk.core.u.d.d.d().d(strYo, this.an, false) == 3) {
                    if (!d(tcVar) && !com.bytedance.msdk.core.admanager.d.d(tcVar.e(), tcVar.uo(), tcVar.an())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        return z ? 1 : 2;
    }
}
