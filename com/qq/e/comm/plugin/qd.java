package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.FrameLayout;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qd implements ACTD {
    private static final String j = "qd";
    private final Activity a;
    private FrameLayout b;
    private ae c;
    private fk d;
    private fe e;
    private sd f;
    private h4 g;
    private String h;
    private d4 i;

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    public qd(Activity activity) {
        this.a = activity;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        i20.a().b(1).b("beforeCreate", 2302100, null);
        this.a.requestWindowFeature(1);
        Window window = this.a.getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.setBackgroundDrawable(new ColorDrawable(-16777216));
            }
            window.setFlags(16778368, 16778368);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        String stringExtra = this.a.getIntent().getStringExtra("objectId");
        this.h = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            GDTLogger.e(j + " 全屏视频广告页Activity创建失败，OBJECT_ID为空");
            a((FSCallback) null);
            return;
        }
        FSCallback fSCallback = (FSCallback) x5.b(this.h, FSCallback.class);
        h4 h4VarA = ((ud) zm.a(this.h, ud.class)).a();
        this.g = h4VarA;
        if (h4VarA == null) {
            GDTLogger.e(j + " 全屏视频广告页Activity创建失败，广告数据为空");
            a(fSCallback);
            return;
        }
        h4VarA.f(3);
        sd sdVarA = td.a(this.g);
        this.f = sdVarA;
        if (sdVarA == null) {
            GDTLogger.e(j + " 全屏视频广告页Activity创建失败，业务数据为空");
            a(fSCallback);
            return;
        }
        ke.h(this.g);
        d();
        c();
        a().I().b(LifecycleCallback.a.AFTER_CREATED);
        fSCallback.M().a();
        if (this.e != null && e()) {
            this.e.m();
        }
        i20.a().b(1).b("afterCreate", 2302101, f5.a(this.g));
        if (yp.e()) {
            new od(this.a, 2302103).c();
        }
        this.i = new e4(this, this.g);
    }

    private void d() {
        ua.c(this.a, ua.a(this.g));
        this.c = new ae(this.a, this.g, this.f);
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        a aVar = new a(this.a);
        this.b = aVar;
        aVar.setBackgroundColor(-16777216);
        this.b.addView(this.c, new FrameLayout.LayoutParams(-1, -1));
        sd sdVar = this.f;
        if (sdVar != null && sdVar.s()) {
            a(this.f);
        }
        this.a.setContentView(this.b, new FrameLayout.LayoutParams(-1, -1));
        this.b.post(new b());
    }

    /* compiled from: A */
    class a extends FrameLayout {
        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            r5 r5VarD = u2.a().d(qd.this.b);
            if (r5VarD != null) {
                r5VarD.a(motionEvent, false);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        a(Context context) {
            super(context);
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u2.a().a(qd.this.b, qd.this.g);
            le.f(qd.this.g);
        }
    }

    private void c() {
        fe feVar = this.e;
        if (feVar != null) {
            feVar.o();
        }
        fe feVarA = ge.a(this.a, this.g, this.f);
        this.e = feVarA;
        feVarA.a(this.b, this.c, this.d);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        i20.a().b(1).a("onResume", 2302102, f5.a(this.g));
        a().I().b(LifecycleCallback.a.RESUMED);
        d4 d4Var = this.i;
        if (d4Var != null) {
            d4Var.onResume();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        a().I().b(LifecycleCallback.a.PAUSED);
        d4 d4Var = this.i;
        if (d4Var != null) {
            d4Var.onPause();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
        a().I().b(LifecycleCallback.a.STOPPED);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        fk fkVar = this.d;
        if (fkVar != null) {
            fkVar.onDestroy();
            this.d = null;
        }
        d4 d4Var = this.i;
        if (d4Var != null) {
            d4Var.onDestroy();
        }
        fe feVar = this.e;
        if (feVar != null) {
            feVar.o();
        }
        ae aeVar = this.c;
        if (aeVar != null) {
            b50.a(aeVar);
        }
        a().I().b(LifecycleCallback.a.DESTROYED);
        zm.b(this.h, ud.class);
        u2.a().b(this.b);
        i20.a().a(1);
        yp.g();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        fe feVar = this.e;
        if (feVar != null) {
            feVar.n();
        }
    }

    private boolean e() {
        yq yqVarP0 = this.g.p0();
        return yqVarP0 == null || !yqVarP0.G();
    }

    private LifecycleCallback a() {
        return (LifecycleCallback) x5.b(this.h, LifecycleCallback.class);
    }

    ae b() {
        return this.c;
    }

    private void a(FSCallback fSCallback) {
        if (fSCallback != null) {
            fSCallback.C().b(5001);
        }
        zm.a(ud.class);
        this.a.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(sd sdVar) {
        Activity activity = this.a;
        h4 h4Var = this.g;
        String strD = sdVar.d();
        h4 h4Var2 = this.g;
        fk fkVarA = cc.a(activity, h4Var, strD, dx.a(h4Var2, ((lk) h4Var2).b()), sdVar);
        this.d = fkVarA;
        fkVarA.a(this.b);
        this.d.c();
    }
}
