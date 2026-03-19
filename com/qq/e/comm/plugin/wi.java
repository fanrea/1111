package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.dhylive.app.R;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.util.AdErrorConvertor;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class wi implements ACTD, View.OnClickListener, sh {
    private final Activity a;
    private HybridADListener b;
    private HybridADSetting c;
    private RelativeLayout d;
    private m20 e;
    private jm f;
    private ProgressBar g;
    private boolean h;
    private String i;

    @Override // com.qq.e.comm.plugin.sh
    public void a(int i) {
    }

    @Override // com.qq.e.comm.plugin.sh
    public void a(int i, String str, String str2) {
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

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    private void d() {
        this.d = new RelativeLayout(this.a);
        m20 m20Var = new m20(this.a, this.c);
        this.e = m20Var;
        m20Var.setId(R.string.a_delay);
        this.e.a().setOnClickListener(this);
        this.e.c().setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, yu.a((Context) this.a, this.c.getTitleBarHeight()));
        layoutParams.addRule(10, -1);
        this.d.addView(this.e, layoutParams);
        jm jmVarA = new qh(this.a).a();
        this.f = jmVarA;
        jmVarA.a(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(3, R.string.a_delay);
        this.d.addView(this.f.a(), layoutParams2);
        ProgressBar progressBar = new ProgressBar(this.a);
        this.g = progressBar;
        progressBar.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(yu.a((Context) this.a, 46), yu.a((Context) this.a, 46));
        layoutParams3.addRule(13, -1);
        this.d.addView(this.g, layoutParams3);
        this.a.setContentView(this.d, new ViewGroup.LayoutParams(-1, -1));
    }

    public wi(Activity activity) {
        this.a = activity;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.a.requestWindowFeature(1);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        String stringExtra = this.a.getIntent().getStringExtra("objectId");
        this.i = stringExtra;
        yi yiVar = (yi) zm.a(stringExtra, yi.class);
        this.b = yiVar.a();
        this.c = yiVar.b();
        String stringExtra2 = this.a.getIntent().getStringExtra("url");
        if (this.b != null && this.c != null) {
            if (TextUtils.isEmpty(stringExtra2)) {
                this.a.finish();
                return;
            }
            d();
            if (this.c.getType() != 1) {
                b(4001);
                this.a.finish();
                return;
            } else {
                ii iiVar = new ii();
                this.f.b().a(iiVar.a(), iiVar);
                this.f.loadUrl(stringExtra2);
                b10.a(21042, null, 2);
                return;
            }
        }
        zm.a(yi.class);
        this.a.finish();
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            wi.this.b.onError(AdErrorConvertor.formatErrorCode(this.a));
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        jm jmVar = this.f;
        if (jmVar != null) {
            jmVar.d();
        }
        xo.a((Object) null);
        zm.b(this.i, yi.class);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        b();
    }

    private void b() {
        if (this.f.canGoBackOrForward(-1)) {
            this.f.goBack();
        } else {
            a();
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            wi.this.b.onClose();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131755009) {
            b();
            b10.a(21052, (f5) null);
        } else {
            if (id != 2131755011) {
                return;
            }
            a();
            b10.a(21062, (f5) null);
        }
    }

    private void a() {
        xo.a((Runnable) new b());
        this.a.finish();
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            wi.this.b.onLoadFinished();
        }
    }

    @Override // com.qq.e.comm.plugin.sh
    public void c(String str) {
        if (!this.h) {
            xo.a((Runnable) new c());
            b10.a(21042, null, 3);
            this.h = true;
        }
        this.g.setVisibility(8);
        if (this.f.canGoBackOrForward(-1)) {
            this.e.b().setVisibility(0);
            this.e.c().setVisibility(0);
        } else {
            this.e.b().setVisibility(4);
            this.e.c().setVisibility(4);
        }
    }

    @Override // com.qq.e.comm.plugin.sh
    public void b(String str) {
        HybridADSetting hybridADSetting = this.c;
        if (hybridADSetting == null || TextUtils.isEmpty(hybridADSetting.getTitle())) {
            this.e.d().setText(str);
        }
    }

    private void b(int i) {
        xo.a((Runnable) new a(i));
    }

    @Override // com.qq.e.comm.plugin.sh
    public void a(String str, Bitmap bitmap) {
        this.g.setVisibility(0);
    }
}
