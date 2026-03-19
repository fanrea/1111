package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.callback.biz.LPCallback;
import com.qq.e.comm.plugin.tn;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class wn extends LinearLayout implements fk, tn.a {
    private p7 a;
    private jm b;
    private bc c;
    private final h4 d;
    private boolean e;
    private boolean f;
    private Boolean g;
    private boolean h;
    private boolean i;
    private final ja j;
    private final boolean m;
    private final Runnable n;

    @Override // com.qq.e.comm.plugin.tn.a
    public void a() {
    }

    wn(Context context, h4 h4Var) {
        super(context);
        this.n = new d();
        setBackgroundColor(-16777216);
        this.d = h4Var;
        this.j = new ja();
        this.m = r1.d().f().a("dwajwl", h4Var.y0(), 0) == 1;
        a(h4Var);
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (wn.this.b.canGoBack()) {
                wn.this.b.goBack();
            } else if (wn.this.c != null) {
                wn.this.c.a();
            }
        }
    }

    /* compiled from: A */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (wn.this.c != null) {
                wn.this.c.a();
            }
        }
    }

    /* compiled from: A */
    class c implements sh {
        @Override // com.qq.e.comm.plugin.sh
        public void a(int i) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void a(String str, Bitmap bitmap) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public boolean a(ValueCallback<Uri[]> valueCallback, Intent intent) {
            return false;
        }

        @Override // com.qq.e.comm.plugin.sh
        public void b(ValueCallback<Uri> valueCallback, Intent intent) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void c() {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void d(String str) {
        }

        c() {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void c(String str) throws JSONException {
            wn.this.j.a("wu", str);
            b10.a(1020051, f5.a(wn.this.d));
            if (wn.this.g == null) {
                gc.d(f5.a(wn.this.d), 3);
                wn.this.g = Boolean.TRUE;
                if (wn.this.f) {
                    wn.this.d();
                }
            }
        }

        @Override // com.qq.e.comm.plugin.sh
        public void a(int i, String str, String str2) throws JSONException {
            wn.this.j.a("wu", str2);
            b10.b(1020052, f5.a(wn.this.d), Integer.valueOf(i), wn.this.j);
            gc.a(f5.a(wn.this.d), 3, i, wn.this.j);
            if (wn.this.g == null) {
                wn.this.g = Boolean.FALSE;
                if (wn.this.f) {
                    wn.this.b();
                }
            }
        }

        @Override // com.qq.e.comm.plugin.sh
        public void b(String str) {
            if (wn.this.a != null) {
                wn.this.a.a(str);
            }
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (wn.this.b.canGoBack()) {
                wn.this.a.b();
            } else {
                xo.a(this, 500L);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.fk
    public void show() {
        a(true);
    }

    @Override // com.qq.e.comm.plugin.fk
    public void c() {
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.h) {
            return;
        }
        gc.b(f5.a(this.d), 3, 9001, this.j);
        this.h = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.h) {
            return;
        }
        gc.f(f5.a(this.d), 3);
        this.h = true;
    }

    @Override // com.qq.e.comm.plugin.fk
    public void e() {
        bc bcVar = this.c;
        if (bcVar != null) {
            bcVar.g();
        }
        show();
    }

    @Override // com.qq.e.comm.plugin.fk
    public void onDestroy() {
        if (this.f) {
            ((LPCallback) x5.b(this.d.s0(), LPCallback.class)).onClose().a();
        }
        x5.c(this.d.s0(), LPCallback.class);
        jm jmVar = this.b;
        if (jmVar != null) {
            jmVar.d();
        }
        u2.a().b(this);
        if (this.g == null) {
            gc.a(f5.a(this.d), 3);
        }
        if (this.e && !this.f) {
            gc.e(f5.a(this.d), 3);
        }
        xo.e(this.n);
    }

    @Override // com.qq.e.comm.plugin.fk
    public void a(ViewGroup viewGroup) {
        if (getParent() == null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private void a(h4 h4Var) {
        setOrientation(1);
        this.a = new p7(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, yu.a(getContext(), 45));
        layoutParams.gravity = 48;
        this.a.setLayoutParams(layoutParams);
        this.a.setBackgroundColor(-1);
        this.a.a(new a());
        this.a.b(new b());
        addView(this.a);
        jm jmVarA = new qh(getContext(), h4Var).a();
        this.b = jmVarA;
        jmVarA.a(new c());
        this.b.c(this.m);
        tn tnVar = new tn(this.d, this.b);
        tnVar.a(this);
        this.b.a().setOnTouchListener(tnVar);
        addView(this.b.a(), new RelativeLayout.LayoutParams(-1, -1));
        ua.b(this, 0);
        u2.a().a(this, this.d);
        xo.a(this.n, 500L);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            b10.a(1403022, f5.a(this.d));
            return;
        }
        if (vn.a(this.d.y0(), this.d.I())) {
            str = vn.a(str, "2");
        }
        String strA = vn.a(str, this.d, false);
        jm jmVar = this.b;
        if (jmVar == null || this.i) {
            return;
        }
        jmVar.loadUrl(strA);
        this.i = true;
        gc.c(f5.a(this.d), 3);
    }

    @Override // com.qq.e.comm.plugin.tn.a
    public void a(i6 i6Var) {
        b10.a(1020050, f5.a(this.d));
        b10.a(1403017, f5.a(this.d));
        bc bcVar = this.c;
        if (bcVar != null) {
            i6Var.e = false;
            bcVar.a(i6Var, true);
        }
    }

    @Override // com.qq.e.comm.plugin.em
    public boolean a(j40 j40Var, long j, long j2) {
        h4 h4Var = this.d;
        if (!(h4Var instanceof lk)) {
            return false;
        }
        if (!this.e) {
            a(h4Var.i0());
            this.e = true;
        }
        if (j40Var == j40.STOP || j40Var == j40.ERROR || j40Var == j40.END) {
            show();
        }
        return true;
    }

    @Override // com.qq.e.comm.plugin.fk
    public void a(bc bcVar) {
        this.c = bcVar;
    }

    public void a(boolean z) {
        this.f = true;
        setVisibility(0);
        h4 h4Var = this.d;
        if ((h4Var instanceof lk) && !this.e) {
            a(h4Var.i0());
            this.e = true;
        }
        this.a.setVisibility(z ? 0 : 8);
        bc bcVar = this.c;
        if (bcVar != null) {
            bcVar.h();
        }
        ((LPCallback) x5.b(this.d.s0(), LPCallback.class)).o().a();
        gc.b(f5.a(this.d), 3);
        if (Boolean.TRUE.equals(this.g)) {
            d();
        } else if (Boolean.FALSE.equals(this.g)) {
            b();
        }
    }
}
