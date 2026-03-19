package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class e0 extends Dialog implements ComponentCallbacks {
    private static final String i = "com.qq.e.comm.plugin.e0";
    private static volatile long j;
    protected final Context a;
    protected final h4 b;
    protected final rs c;
    protected final boolean d;
    protected f9 e;
    protected View f;
    protected f5 g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        xo.a((Runnable) new c());
    }

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    protected abstract void e();

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    public e0(Context context, h4 h4Var, rs rsVar) {
        super(context);
        this.h = false;
        this.a = context;
        this.b = h4Var;
        this.c = rsVar;
        this.d = r1.d().c().A();
        setOnDismissListener(new a());
    }

    /* compiled from: A */
    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            e0 e0Var = e0.this;
            e0Var.c.b(e0Var.h);
            e0.this.d();
            long unused = e0.j = 0L;
            f9 f9Var = e0.this.e;
            if (f9Var != null) {
                f9Var.c();
            }
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Window window = getWindow();
        window.getAttributes().width = -1;
        window.getAttributes().height = -1;
        window.getAttributes().gravity = 17;
        if ((window.getAttributes().flags & 1024) == 1024 || this.d) {
            window.addFlags(1024);
        } else {
            window.clearFlags(1024);
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            decorView.setPadding(0, 0, 0, 0);
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (Build.VERSION.SDK_INT > 19) {
                if (this.d) {
                    systemUiVisibility |= 4;
                }
                systemUiVisibility |= InputDeviceCompat.SOURCE_TOUCHSCREEN;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
        }
        setCanceledOnTouchOutside(false);
        getContext().registerComponentCallbacks(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setContentView(this.f, layoutParams);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
        this.e.a(new b(this.e, this.b));
    }

    /* compiled from: A */
    class b extends gf {
        @Override // com.qq.e.comm.plugin.gf
        public void b() {
        }

        b(f9 f9Var, h4 h4Var) {
            super(f9Var, h4Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void a(i6 i6Var, h8 h8Var) {
            super.a(i6Var, h8Var);
            e0.this.h = true;
            boolean zA = e0.this.c.a(h8Var.c);
            e0.this.c();
            if (zA) {
                e0.this.f();
            }
        }

        @Override // com.qq.e.comm.plugin.gf
        public void c(h8 h8Var) {
            super.c(h8Var);
            e0.this.h = true;
            e0.this.c.onCancel();
            e0.this.b();
            e0.this.f();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterComponentCallbacks(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.c.onCancel();
        b();
        f();
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.f == null) {
            this.c.a(false);
            return;
        }
        if (j == 0 || System.currentTimeMillis() - j >= 1000) {
            j = System.currentTimeMillis();
            super.show();
            this.c.a(true);
            e();
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Activity activityA = c1.a(e0.this.a);
                if (activityA == null || c1.a(activityA)) {
                    e0.this.dismiss();
                }
            } catch (Throwable unused) {
                String unused2 = e0.i;
            }
        }
    }
}
