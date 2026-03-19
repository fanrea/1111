package com.baidu.mobads.container;

import android.R;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.bridge.ak;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class au extends k {
    protected static final String TAG = "XBaseHtmlAdContainer";
    private ViewGroup a;
    protected ak.c expandCloseListener;
    protected com.baidu.mobads.container.bridge.ak expandedLayout;
    protected com.baidu.mobads.container.bridge.i mBridgeHandler;
    protected ax mWebView;
    protected boolean shouldUseCustomUse;

    protected abstract void initBridgeHandler();

    public ax getWebView() {
        return this.mWebView;
    }

    public com.baidu.mobads.container.bridge.i getBridge() {
        return this.mBridgeHandler;
    }

    public au(com.baidu.mobads.container.adrequest.t tVar) {
        super(tVar);
        this.expandCloseListener = new av(this);
    }

    public void handleExpand(boolean z) {
        try {
            if (a() == null) {
                return;
            }
            this.expandedLayout = new com.baidu.mobads.container.bridge.ak(this.mAppContext, com.component.b.a.a().b("ic_gray_cross_black_round"));
            this.expandedLayout.a(this.expandCloseListener);
            this.mAdContainerCxt.v().removeView(this.mWebView);
            this.expandedLayout.addView(this.mWebView, new FrameLayout.LayoutParams(-1, -1));
            a().addView(this.expandedLayout, new ViewGroup.LayoutParams(-1, -1));
            this.expandedLayout.a(new aw(this));
            this.expandedLayout.setFocusableInTouchMode(true);
            this.expandedLayout.setFocusable(true);
            this.expandedLayout.requestFocus();
            this.mBridgeHandler.q();
        } catch (Exception e) {
            this.mAdLogger.a(e);
        }
    }

    public void handleUseCustomClose(boolean z) {
        try {
            this.shouldUseCustomUse = z;
            if (this.expandedLayout != null) {
                this.expandedLayout.a(!z);
            }
        } catch (Exception e) {
            this.mAdLogger.a(e);
        }
    }

    public void closeExpand() {
        try {
            ViewGroup viewGroupA = a();
            if (viewGroupA == null) {
                return;
            }
            viewGroupA.removeView(this.expandedLayout);
            this.expandedLayout.removeAllViews();
            this.expandedLayout = null;
            this.mAdContainerCxt.v().addView(this.mWebView, new RelativeLayout.LayoutParams(-1, -1));
            this.mBridgeHandler.r();
        } catch (Exception e) {
            this.mAdLogger.a(e);
        }
    }

    private ViewGroup a() {
        if (this.a == null) {
            if (com.baidu.mobads.container.util.x.a(null).a() >= 19 && !this.mAdContainerCxt.v().isAttachedToWindow()) {
                return null;
            }
            this.a = (ViewGroup) this.mAdContainerCxt.v().getRootView().findViewById(R.id.content);
        }
        return this.a;
    }

    @Override // com.baidu.mobads.container.k
    public void destroy() {
        if (this.mWebView != null) {
            this.mWebView.destroy();
        }
    }
}
