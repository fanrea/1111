package com.just.agentweb;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DefaultWebCreator implements WebCreator {
    private static final String TAG = "DefaultWebCreator";
    private Activity mActivity;
    private BaseIndicatorSpec mBaseIndicatorSpec;
    private int mColor;
    private FrameLayout mFrameLayout;
    private int mHeight;
    private IWebLayout mIWebLayout;
    private int mIndex;
    private boolean mIsCreated;
    private boolean mIsNeedDefaultProgress;
    private ViewGroup.LayoutParams mLayoutParams;
    private BaseIndicatorView mProgressView;
    private View mTargetProgress;
    private ViewGroup mViewGroup;
    private WebView mWebView;
    private int mWebViewType;

    protected DefaultWebCreator(Activity activity, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, int i3, WebView webView, IWebLayout iWebLayout) {
        this.mIsCreated = false;
        this.mFrameLayout = null;
        this.mWebViewType = 1;
        this.mActivity = activity;
        this.mViewGroup = viewGroup;
        this.mIsNeedDefaultProgress = true;
        this.mIndex = i;
        this.mColor = i2;
        this.mLayoutParams = layoutParams;
        this.mHeight = i3;
        this.mWebView = webView;
        this.mIWebLayout = iWebLayout;
    }

    private ViewGroup createLayout() {
        View viewWebLayout;
        BaseIndicatorView baseIndicatorView;
        Activity activity = this.mActivity;
        WebParentLayout webParentLayout = new WebParentLayout(activity);
        webParentLayout.setId(R.id.web_parent_layout_id);
        webParentLayout.setBackgroundColor(-1);
        if (this.mIWebLayout == null) {
            WebView webViewCreateWebView = createWebView();
            this.mWebView = webViewCreateWebView;
            viewWebLayout = webViewCreateWebView;
        } else {
            viewWebLayout = webLayout();
        }
        webParentLayout.addView(viewWebLayout, new FrameLayout.LayoutParams(-1, -1));
        webParentLayout.bindWebView(this.mWebView);
        LogUtils.i(TAG, "  instanceof  AgentWebView:" + (this.mWebView instanceof AgentWebView));
        if (this.mWebView instanceof AgentWebView) {
            this.mWebViewType = 2;
        }
        ViewStub viewStub = new ViewStub(activity);
        viewStub.setId(R.id.mainframe_error_viewsub_id);
        webParentLayout.addView(viewStub, new FrameLayout.LayoutParams(-1, -1));
        boolean z = this.mIsNeedDefaultProgress;
        if (z) {
            WebIndicator webIndicator = new WebIndicator(activity);
            FrameLayout.LayoutParams layoutParams = this.mHeight > 0 ? new FrameLayout.LayoutParams(-2, AgentWebUtils.dp2px(activity, this.mHeight)) : webIndicator.offerLayoutParams();
            int i = this.mColor;
            if (i != -1) {
                webIndicator.setColor(i);
            }
            layoutParams.gravity = 48;
            this.mBaseIndicatorSpec = webIndicator;
            webParentLayout.addView(webIndicator, layoutParams);
            webIndicator.setVisibility(8);
        } else if (!z && (baseIndicatorView = this.mProgressView) != null) {
            this.mBaseIndicatorSpec = baseIndicatorView;
            webParentLayout.addView(baseIndicatorView, baseIndicatorView.offerLayoutParams());
            this.mProgressView.setVisibility(8);
        }
        return webParentLayout;
    }

    private WebView createWebView() {
        int i;
        WebView lollipopFixedWebView = this.mWebView;
        if (lollipopFixedWebView != null) {
            i = 3;
        } else if (AgentWebConfig.IS_KITKAT_OR_BELOW_KITKAT) {
            lollipopFixedWebView = new AgentWebView(this.mActivity);
            i = 2;
        } else {
            lollipopFixedWebView = new LollipopFixedWebView(this.mActivity);
            i = 1;
        }
        this.mWebViewType = i;
        return lollipopFixedWebView;
    }

    private View webLayout() {
        WebView webView = this.mIWebLayout.getWebView();
        if (webView == null) {
            webView = createWebView();
            this.mIWebLayout.getLayout().addView(webView, -1, -1);
            LogUtils.i(TAG, "add webview");
        } else {
            this.mWebViewType = 3;
        }
        this.mWebView = webView;
        return this.mIWebLayout.getLayout();
    }

    @Override // com.just.agentweb.WebCreator
    public DefaultWebCreator create() {
        if (this.mIsCreated) {
            return this;
        }
        this.mIsCreated = true;
        ViewGroup viewGroup = this.mViewGroup;
        if (viewGroup == null) {
            FrameLayout frameLayout = (FrameLayout) createLayout();
            this.mFrameLayout = frameLayout;
            this.mActivity.setContentView(frameLayout);
        } else if (this.mIndex == -1) {
            FrameLayout frameLayout2 = (FrameLayout) createLayout();
            this.mFrameLayout = frameLayout2;
            viewGroup.addView(frameLayout2, this.mLayoutParams);
        } else {
            FrameLayout frameLayout3 = (FrameLayout) createLayout();
            this.mFrameLayout = frameLayout3;
            viewGroup.addView(frameLayout3, this.mIndex, this.mLayoutParams);
        }
        return this;
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public View getTargetProgress() {
        return this.mTargetProgress;
    }

    @Override // com.just.agentweb.WebCreator
    public FrameLayout getWebParentLayout() {
        return this.mFrameLayout;
    }

    @Override // com.just.agentweb.WebCreator
    public WebView getWebView() {
        return this.mWebView;
    }

    @Override // com.just.agentweb.WebCreator
    public int getWebViewType() {
        return this.mWebViewType;
    }

    @Override // com.just.agentweb.IWebIndicator
    public BaseIndicatorSpec offer() {
        return this.mBaseIndicatorSpec;
    }

    public void setTargetProgress(View view) {
        this.mTargetProgress = view;
    }

    public void setWebView(WebView webView) {
        this.mWebView = webView;
    }

    protected DefaultWebCreator(Activity activity, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, WebView webView, IWebLayout iWebLayout) {
        this.mColor = -1;
        this.mIsCreated = false;
        this.mFrameLayout = null;
        this.mWebViewType = 1;
        this.mActivity = activity;
        this.mViewGroup = viewGroup;
        this.mIsNeedDefaultProgress = false;
        this.mIndex = i;
        this.mLayoutParams = layoutParams;
        this.mWebView = webView;
        this.mIWebLayout = iWebLayout;
    }

    protected DefaultWebCreator(Activity activity, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, BaseIndicatorView baseIndicatorView, WebView webView, IWebLayout iWebLayout) {
        this.mColor = -1;
        this.mIsCreated = false;
        this.mFrameLayout = null;
        this.mWebViewType = 1;
        this.mActivity = activity;
        this.mViewGroup = viewGroup;
        this.mIsNeedDefaultProgress = false;
        this.mIndex = i;
        this.mLayoutParams = layoutParams;
        this.mProgressView = baseIndicatorView;
        this.mWebView = webView;
        this.mIWebLayout = iWebLayout;
    }
}
