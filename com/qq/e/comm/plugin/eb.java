package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.qq.e.comm.pi.ACTD;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class eb implements f, ACTD, zk {
    private jm a;
    private Activity b;

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.values().length];
            a = iArr;
            try {
                iArr[g.DownloadClosed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private String b() {
        return r1.d().f().b("dmpurl", "https://qzonestyle.gtimg.cn/qzone/biz/gdt/mob/sdk/v2/android01/download.html");
    }

    @Override // com.qq.e.comm.plugin.zk
    public e2 a() {
        return null;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        com.qq.e.comm.plugin.apkmanager.l.e().h();
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

    @Override // com.qq.e.comm.plugin.f
    public void a(e eVar) {
        if (a.a[eVar.a().ordinal()] != 1) {
            return;
        }
        c();
    }

    public eb(Activity activity) {
        this.b = activity;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        c();
    }

    private void c() {
        this.b.finish();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        e();
        ViewParent parent = this.a.a().getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.a.a());
        }
        this.b.setContentView(this.a.a());
        d();
    }

    private void d() {
        this.a.loadUrl(b());
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        jm jmVar = this.a;
        if (jmVar != null) {
            jmVar.d();
        }
    }

    private void e() {
        jm jmVarA = new qh(this.b.getApplicationContext(), (h4) null, this).a(true).a(this).a();
        this.a = jmVarA;
        jmVarA.b().a(jo.b()).a(kw.b()).a(vt.b()).a(ov.b()).a(rx.b()).a(o30.b());
    }
}
