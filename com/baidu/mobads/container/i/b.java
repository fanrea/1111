package com.baidu.mobads.container.i;

import android.content.Context;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.au;
import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.bridge.x;
import com.baidu.mobads.container.util.bq;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class b extends au {
    public static final String a = "http://mobads.baidu.com/ads/index.htm";
    private static boolean e;
    public long b;
    public long c;
    x d;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;

    public boolean a() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public b(t tVar) {
        super(tVar);
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.d = new c(this);
        a(tVar.u());
    }

    private void a(Context context) {
        this.mWebView = ax.a(context, bq.a(), true, true);
        this.mWebView.setWebViewClient(new e(this));
        initBridgeHandler();
    }

    @Override // com.baidu.mobads.container.au
    protected void initBridgeHandler() {
        this.mBridgeHandler = new a(this, this.mWebView, this.d, this.mAdContainerCxt);
    }

    public void b(boolean z) {
    }

    public void b() {
    }

    public void a(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.mAdLogger.a("adContainer.retryLoading");
        this.g = true;
        com.baidu.mobads.container.d.b.a().a(new h(this), 5L, TimeUnit.SECONDS);
    }

    public void c() {
        this.i = true;
        if (this.f) {
            this.mAdLogger.a("AdContainer.onDetached");
            this.mBridgeHandler.p();
        }
    }
}
