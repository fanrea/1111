package com.baidu.mobads.container.i;

import android.widget.RelativeLayout;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.util.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j extends b {
    private static final String e = "XH5BannerAdContainer";

    public j(t tVar) {
        super(tVar);
    }

    @Override // com.baidu.mobads.container.k
    protected void resetAdContainerName() {
        this.mAdContainerName = e;
    }

    @Override // com.baidu.mobads.container.k
    public void onAttachedToWindow() {
        if (this.mWebView != null) {
            e();
        }
    }

    @Override // com.baidu.mobads.container.k
    public void onDetachedFromWindow() {
        this.mBridgeHandler.p();
    }

    @Override // com.baidu.mobads.container.k
    public void onWindowVisibilityChanged(int i) {
    }

    @Override // com.baidu.mobads.container.k
    public void onWindowFocusChanged(boolean z) {
        this.mAdLogger.a(e, "onWindowFocusChanged hasWindowFocus: " + z);
        if (z) {
            e();
        } else {
            pause();
        }
    }

    @Override // com.baidu.mobads.container.k
    protected void doStartOnUIThread() {
        if (this.mAdState != 2) {
            this.mAdContainerCxt.v().addView(this.mWebView, new RelativeLayout.LayoutParams(-1, -1));
            this.mWebView.loadUrl(o.e(b.a));
            displayVersion4DebugMode();
            return;
        }
        this.mAdLogger.a("XH5SplashAdContainer: ad state is stopped, so can not show ad");
    }

    @Override // com.baidu.mobads.container.k
    protected void doLoadOnUIThread() {
        start();
    }

    @Override // com.baidu.mobads.container.k
    public void pause() {
        if (a()) {
            this.mAdLogger.a("AdContainer.pause");
            this.mBridgeHandler.l();
        }
    }

    public void e() {
        if (a()) {
            this.mAdLogger.a("AdContainer.play");
            this.mBridgeHandler.k();
        }
    }

    @Override // com.baidu.mobads.container.i.b, com.baidu.mobads.container.au
    protected void initBridgeHandler() {
        this.mBridgeHandler = new k(this, this.mWebView, this.d, this.mAdContainerCxt);
    }
}
