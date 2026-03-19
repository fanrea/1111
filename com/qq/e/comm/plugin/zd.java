package com.qq.e.comm.plugin;

import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.qq.e.comm.plugin.fs.FSCallback;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class zd extends fz {
    private final Cif a;
    private final h4 b;
    private final FSCallback c;
    private boolean d = false;

    public zd(Cif cif, h4 h4Var, FSCallback fSCallback) {
        this.a = cif;
        this.b = h4Var;
        this.c = fSCallback;
        yq yqVarP0 = h4Var.p0();
        if (yqVarP0 != null && yqVarP0.G()) {
            xo.a(new a(), xc.a("rewardPageCountDelayTime", h4Var.y0(), 5, h4Var.x0()) * 1000);
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zd.this.a();
        }
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void c(String str) {
        yq yqVarP0 = this.b.p0();
        if (yqVarP0 == null) {
            return;
        }
        if (yqVarP0.G()) {
            a();
        }
        Cif cif = this.a;
        if (cif != null) {
            cif.b(0);
        }
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void d(String str) {
        Cif cif = this.a;
        if (cif != null) {
            cif.d(str);
        }
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh.a
    public void a(String str) {
        Cif cif = this.a;
        if (cif != null) {
            cif.d(str);
        }
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
    public void a(int i, String str, String str2) {
        Cif cif = this.a;
        if (cif != null) {
            cif.b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.d) {
            return;
        }
        this.c.G().a();
        this.d = true;
    }

    @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh.a
    public void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Cif cif;
        if (Build.VERSION.SDK_INT >= 21 && (cif = this.a) != null) {
            cif.b(webResourceResponse.getStatusCode());
        }
    }
}
