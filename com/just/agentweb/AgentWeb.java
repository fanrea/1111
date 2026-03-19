package com.just.agentweb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.just.agentweb.DefaultWebClient;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class AgentWeb {
    private static final int ACTIVITY_TAG = 0;
    private static final int FRAGMENT_TAG = 1;
    private static final String TAG = "AgentWeb";
    private Activity mActivity;
    private AgentWeb mAgentWeb;
    private AgentWebJsInterfaceCompat mAgentWebJsInterfaceCompat;
    private IAgentWebSettings mAgentWebSettings;
    private boolean mEnableIndicator;
    private EventInterceptor mEventInterceptor;
    private IEventHandler mIEventHandler;
    private IUrlLoader mIUrlLoader;
    private IVideo mIVideo;
    private IndicatorController mIndicatorController;
    private boolean mIsInterceptUnkownUrl;
    private ArrayMap<String, Object> mJavaObjects;
    private JsAccessEntrace mJsAccessEntrace;
    private JsInterfaceHolder mJsInterfaceHolder;
    private MiddlewareWebClientBase mMiddleWrareWebClientBaseHeader;
    private MiddlewareWebChromeBase mMiddlewareWebChromeBaseHeader;
    private PermissionInterceptor mPermissionInterceptor;
    private SecurityType mSecurityType;
    private int mTagTarget;
    private android.webkit.WebChromeClient mTargetChromeClient;
    private int mUrlHandleWays;
    private ViewGroup mViewGroup;
    private WebChromeClient mWebChromeClient;
    private boolean mWebClientHelper;
    private WebCreator mWebCreator;
    private WebLifeCycle mWebLifeCycle;
    private WebListenerManager mWebListenerManager;
    private WebSecurityCheckLogic mWebSecurityCheckLogic;
    private WebSecurityController<WebSecurityCheckLogic> mWebSecurityController;
    private WebViewClient mWebViewClient;

    public static final class AgentBuilder {
        private Activity mActivity;
        private IAgentWebSettings mAgentWebSettings;
        private AbsAgentWebUIController mAgentWebUIController;
        private BaseIndicatorView mBaseIndicatorView;
        private int mErrorLayout;
        private View mErrorView;
        private Fragment mFragment;
        private IEventHandler mIEventHandler;
        private boolean mIsNeedDefaultProgress;
        private ArrayMap<String, Object> mJavaObject;
        private MiddlewareWebClientBase mMiddlewareWebClientBaseHeader;
        private MiddlewareWebClientBase mMiddlewareWebClientBaseTail;
        private int mReloadId;
        private ViewGroup mViewGroup;
        private WebChromeClient mWebChromeClient;
        private WebCreator mWebCreator;
        private WebView mWebView;
        private WebViewClient mWebViewClient;
        private int mIndex = -1;
        private IndicatorController mIndicatorController = null;
        private boolean mEnableIndicator = true;
        private ViewGroup.LayoutParams mLayoutParams = null;
        private int mIndicatorColor = -1;
        private HttpHeaders mHttpHeaders = null;
        private int mHeight = -1;
        private SecurityType mSecurityType = SecurityType.DEFAULT_CHECK;
        private boolean mWebClientHelper = true;
        private IWebLayout mWebLayout = null;
        private PermissionInterceptor mPermissionInterceptor = null;
        private DefaultWebClient.OpenOtherPageWays mOpenOtherPage = null;
        private boolean mIsInterceptUnkownUrl = true;
        private MiddlewareWebChromeBase mChromeMiddleWareHeader = null;
        private MiddlewareWebChromeBase mChromeMiddleWareTail = null;
        private int mTag = 0;

        public AgentBuilder(Activity activity) {
            this.mActivity = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addHeader(String str, String str2, String str3) {
            if (this.mHttpHeaders == null) {
                this.mHttpHeaders = HttpHeaders.create();
            }
            this.mHttpHeaders.additionalHttpHeader(str, str2, str3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addJavaObject(String str, Object obj) {
            if (this.mJavaObject == null) {
                this.mJavaObject = new ArrayMap<>();
            }
            this.mJavaObject.put(str, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PreAgentWeb buildAgentWeb() {
            if (this.mTag == 1 && this.mViewGroup == null) {
                throw new NullPointerException("ViewGroup is null,Please check your parameters .");
            }
            return new PreAgentWeb(HookManager.hookAgentWeb(new AgentWeb(this), this));
        }

        public IndicatorBuilder setAgentWebParent(ViewGroup viewGroup, int i, ViewGroup.LayoutParams layoutParams) {
            this.mViewGroup = viewGroup;
            this.mLayoutParams = layoutParams;
            this.mIndex = i;
            return new IndicatorBuilder(this);
        }

        public AgentBuilder(Activity activity, Fragment fragment) {
            this.mActivity = activity;
            this.mFragment = fragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addHeader(String str, Map<String, String> map) {
            if (this.mHttpHeaders == null) {
                this.mHttpHeaders = HttpHeaders.create();
            }
            this.mHttpHeaders.additionalHttpHeaders(str, map);
        }

        public IndicatorBuilder setAgentWebParent(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
            this.mViewGroup = viewGroup;
            this.mLayoutParams = layoutParams;
            return new IndicatorBuilder(this);
        }
    }

    public static class CommonBuilder {
        private AgentBuilder mAgentBuilder;

        public CommonBuilder(AgentBuilder agentBuilder) {
            this.mAgentBuilder = agentBuilder;
        }

        public CommonBuilder addJavascriptInterface(String str, Object obj) {
            this.mAgentBuilder.addJavaObject(str, obj);
            return this;
        }

        public CommonBuilder additionalHttpHeader(String str, String str2, String str3) {
            this.mAgentBuilder.addHeader(str, str2, str3);
            return this;
        }

        public CommonBuilder closeWebViewClientHelper() {
            this.mAgentBuilder.mWebClientHelper = false;
            return this;
        }

        public PreAgentWeb createAgentWeb() {
            return this.mAgentBuilder.buildAgentWeb();
        }

        public CommonBuilder interceptUnkownUrl() {
            this.mAgentBuilder.mIsInterceptUnkownUrl = true;
            return this;
        }

        public CommonBuilder isInterceptUnkownUrl(boolean z) {
            this.mAgentBuilder.mIsInterceptUnkownUrl = z;
            return this;
        }

        public CommonBuilder setAgentWebUIController(AgentWebUIControllerImplBase agentWebUIControllerImplBase) {
            this.mAgentBuilder.mAgentWebUIController = agentWebUIControllerImplBase;
            return this;
        }

        public CommonBuilder setAgentWebWebSettings(IAgentWebSettings iAgentWebSettings) {
            this.mAgentBuilder.mAgentWebSettings = iAgentWebSettings;
            return this;
        }

        public CommonBuilder setEventHanadler(IEventHandler iEventHandler) {
            this.mAgentBuilder.mIEventHandler = iEventHandler;
            return this;
        }

        public CommonBuilder setMainFrameErrorView(int i, int i2) {
            this.mAgentBuilder.mErrorLayout = i;
            this.mAgentBuilder.mReloadId = i2;
            return this;
        }

        public CommonBuilder setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays openOtherPageWays) {
            this.mAgentBuilder.mOpenOtherPage = openOtherPageWays;
            return this;
        }

        public CommonBuilder setPermissionInterceptor(PermissionInterceptor permissionInterceptor) {
            this.mAgentBuilder.mPermissionInterceptor = permissionInterceptor;
            return this;
        }

        public CommonBuilder setSecurityType(SecurityType securityType) {
            this.mAgentBuilder.mSecurityType = securityType;
            return this;
        }

        public CommonBuilder setWebChromeClient(WebChromeClient webChromeClient) {
            this.mAgentBuilder.mWebChromeClient = webChromeClient;
            return this;
        }

        public CommonBuilder setWebLayout(IWebLayout iWebLayout) {
            this.mAgentBuilder.mWebLayout = iWebLayout;
            return this;
        }

        public CommonBuilder setWebView(WebView webView) {
            this.mAgentBuilder.mWebView = webView;
            return this;
        }

        public CommonBuilder setWebViewClient(WebViewClient webViewClient) {
            this.mAgentBuilder.mWebViewClient = webViewClient;
            return this;
        }

        public CommonBuilder useMiddlewareWebChrome(MiddlewareWebChromeBase middlewareWebChromeBase) {
            if (middlewareWebChromeBase == null) {
                return this;
            }
            if (this.mAgentBuilder.mChromeMiddleWareHeader == null) {
                AgentBuilder agentBuilder = this.mAgentBuilder;
                agentBuilder.mChromeMiddleWareHeader = agentBuilder.mChromeMiddleWareTail = middlewareWebChromeBase;
            } else {
                this.mAgentBuilder.mChromeMiddleWareTail.enq(middlewareWebChromeBase);
                this.mAgentBuilder.mChromeMiddleWareTail = middlewareWebChromeBase;
            }
            return this;
        }

        public CommonBuilder useMiddlewareWebClient(MiddlewareWebClientBase middlewareWebClientBase) {
            if (middlewareWebClientBase == null) {
                return this;
            }
            if (this.mAgentBuilder.mMiddlewareWebClientBaseHeader == null) {
                AgentBuilder agentBuilder = this.mAgentBuilder;
                agentBuilder.mMiddlewareWebClientBaseHeader = agentBuilder.mMiddlewareWebClientBaseTail = middlewareWebClientBase;
            } else {
                this.mAgentBuilder.mMiddlewareWebClientBaseTail.enq(middlewareWebClientBase);
                this.mAgentBuilder.mMiddlewareWebClientBaseTail = middlewareWebClientBase;
            }
            return this;
        }

        public CommonBuilder additionalHttpHeader(String str, Map<String, String> map) {
            this.mAgentBuilder.addHeader(str, map);
            return this;
        }

        public CommonBuilder setMainFrameErrorView(View view) {
            this.mAgentBuilder.mErrorView = view;
            return this;
        }
    }

    public static class IndicatorBuilder {
        private AgentBuilder mAgentBuilder;

        public IndicatorBuilder(AgentBuilder agentBuilder) {
            this.mAgentBuilder = agentBuilder;
        }

        public CommonBuilder closeIndicator() {
            this.mAgentBuilder.mEnableIndicator = false;
            this.mAgentBuilder.mIndicatorColor = -1;
            this.mAgentBuilder.mHeight = -1;
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder setCustomIndicator(BaseIndicatorView baseIndicatorView) {
            AgentBuilder agentBuilder;
            boolean z = true;
            if (baseIndicatorView != null) {
                this.mAgentBuilder.mEnableIndicator = true;
                this.mAgentBuilder.mBaseIndicatorView = baseIndicatorView;
                agentBuilder = this.mAgentBuilder;
                z = false;
            } else {
                this.mAgentBuilder.mEnableIndicator = true;
                agentBuilder = this.mAgentBuilder;
            }
            agentBuilder.mIsNeedDefaultProgress = z;
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder useDefaultIndicator() {
            this.mAgentBuilder.mEnableIndicator = true;
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder useDefaultIndicator(int i) {
            this.mAgentBuilder.mEnableIndicator = true;
            this.mAgentBuilder.mIndicatorColor = i;
            return new CommonBuilder(this.mAgentBuilder);
        }

        public CommonBuilder useDefaultIndicator(int i, int i2) {
            this.mAgentBuilder.mIndicatorColor = i;
            this.mAgentBuilder.mHeight = i2;
            return new CommonBuilder(this.mAgentBuilder);
        }
    }

    private static final class PermissionInterceptorWrapper implements PermissionInterceptor {
        private WeakReference<PermissionInterceptor> mWeakReference;

        private PermissionInterceptorWrapper(PermissionInterceptor permissionInterceptor) {
            this.mWeakReference = new WeakReference<>(permissionInterceptor);
        }

        @Override // com.just.agentweb.PermissionInterceptor
        public boolean intercept(String str, String[] strArr, String str2) {
            if (this.mWeakReference.get() == null) {
                return false;
            }
            return this.mWeakReference.get().intercept(str, strArr, str2);
        }
    }

    public static class PreAgentWeb {
        private boolean isReady = false;
        private AgentWeb mAgentWeb;

        PreAgentWeb(AgentWeb agentWeb) {
            this.mAgentWeb = agentWeb;
        }

        public AgentWeb get() {
            ready();
            return this.mAgentWeb;
        }

        public AgentWeb go(String str) {
            if (!this.isReady) {
                ready();
            }
            return this.mAgentWeb.go(str);
        }

        public PreAgentWeb ready() {
            if (!this.isReady) {
                this.mAgentWeb.ready();
                this.isReady = true;
            }
            return this;
        }
    }

    public enum SecurityType {
        DEFAULT_CHECK,
        STRICT_CHECK
    }

    private AgentWeb(AgentBuilder agentBuilder) {
        byte b = 0;
        this.mAgentWeb = null;
        this.mJavaObjects = new ArrayMap<>();
        this.mTagTarget = 0;
        this.mWebSecurityController = null;
        this.mWebSecurityCheckLogic = null;
        this.mSecurityType = SecurityType.DEFAULT_CHECK;
        this.mAgentWebJsInterfaceCompat = null;
        this.mJsAccessEntrace = null;
        this.mIUrlLoader = null;
        this.mIVideo = null;
        this.mWebClientHelper = true;
        this.mIsInterceptUnkownUrl = true;
        this.mUrlHandleWays = -1;
        this.mJsInterfaceHolder = null;
        this.mTagTarget = agentBuilder.mTag;
        this.mActivity = agentBuilder.mActivity;
        this.mViewGroup = agentBuilder.mViewGroup;
        this.mIEventHandler = agentBuilder.mIEventHandler;
        this.mEnableIndicator = agentBuilder.mEnableIndicator;
        this.mWebCreator = agentBuilder.mWebCreator == null ? configWebCreator(agentBuilder.mBaseIndicatorView, agentBuilder.mIndex, agentBuilder.mLayoutParams, agentBuilder.mIndicatorColor, agentBuilder.mHeight, agentBuilder.mWebView, agentBuilder.mWebLayout) : agentBuilder.mWebCreator;
        this.mIndicatorController = agentBuilder.mIndicatorController;
        this.mWebChromeClient = agentBuilder.mWebChromeClient;
        this.mWebViewClient = agentBuilder.mWebViewClient;
        this.mAgentWeb = this;
        this.mAgentWebSettings = agentBuilder.mAgentWebSettings;
        if (agentBuilder.mJavaObject != null && !agentBuilder.mJavaObject.isEmpty()) {
            this.mJavaObjects.putAll((Map<? extends String, ? extends Object>) agentBuilder.mJavaObject);
            LogUtils.i(TAG, "mJavaObject size:" + this.mJavaObjects.size());
        }
        this.mPermissionInterceptor = agentBuilder.mPermissionInterceptor != null ? new PermissionInterceptorWrapper(agentBuilder.mPermissionInterceptor) : null;
        this.mSecurityType = agentBuilder.mSecurityType;
        this.mIUrlLoader = new UrlLoaderImpl(this.mWebCreator.create().getWebView(), agentBuilder.mHttpHeaders);
        if (this.mWebCreator.getWebParentLayout() instanceof WebParentLayout) {
            WebParentLayout webParentLayout = (WebParentLayout) this.mWebCreator.getWebParentLayout();
            webParentLayout.bindController(agentBuilder.mAgentWebUIController == null ? AgentWebUIControllerImplBase.build() : agentBuilder.mAgentWebUIController);
            webParentLayout.setErrorLayoutRes(agentBuilder.mErrorLayout, agentBuilder.mReloadId);
            webParentLayout.setErrorView(agentBuilder.mErrorView);
        }
        this.mWebLifeCycle = new DefaultWebLifeCycleImpl(this.mWebCreator.getWebView());
        this.mWebSecurityController = new WebSecurityControllerImpl(this.mWebCreator.getWebView(), this.mAgentWeb.mJavaObjects, this.mSecurityType);
        this.mWebClientHelper = agentBuilder.mWebClientHelper;
        this.mIsInterceptUnkownUrl = agentBuilder.mIsInterceptUnkownUrl;
        if (agentBuilder.mOpenOtherPage != null) {
            this.mUrlHandleWays = agentBuilder.mOpenOtherPage.code;
        }
        this.mMiddleWrareWebClientBaseHeader = agentBuilder.mMiddlewareWebClientBaseHeader;
        this.mMiddlewareWebChromeBaseHeader = agentBuilder.mChromeMiddleWareHeader;
        init();
    }

    private WebCreator configWebCreator(BaseIndicatorView baseIndicatorView, int i, ViewGroup.LayoutParams layoutParams, int i2, int i3, WebView webView, IWebLayout iWebLayout) {
        return (baseIndicatorView == null || !this.mEnableIndicator) ? this.mEnableIndicator ? new DefaultWebCreator(this.mActivity, this.mViewGroup, layoutParams, i, i2, i3, webView, iWebLayout) : new DefaultWebCreator(this.mActivity, this.mViewGroup, layoutParams, i, webView, iWebLayout) : new DefaultWebCreator(this.mActivity, this.mViewGroup, layoutParams, i, baseIndicatorView, webView, iWebLayout);
    }

    private void doCompat() {
        ArrayMap<String, Object> arrayMap = this.mJavaObjects;
        AgentWebJsInterfaceCompat agentWebJsInterfaceCompat = new AgentWebJsInterfaceCompat(this, this.mActivity);
        this.mAgentWebJsInterfaceCompat = agentWebJsInterfaceCompat;
        arrayMap.put("agentWeb", agentWebJsInterfaceCompat);
    }

    private void doSafeCheck() {
        WebSecurityCheckLogic webSecurityLogicImpl = this.mWebSecurityCheckLogic;
        if (webSecurityLogicImpl == null) {
            webSecurityLogicImpl = WebSecurityLogicImpl.getInstance(this.mWebCreator.getWebViewType());
            this.mWebSecurityCheckLogic = webSecurityLogicImpl;
        }
        this.mWebSecurityController.check(webSecurityLogicImpl);
    }

    private android.webkit.WebChromeClient getChromeClient() {
        IndicatorController indicatorControllerInJectIndicator = this.mIndicatorController;
        if (indicatorControllerInJectIndicator == null) {
            indicatorControllerInJectIndicator = IndicatorHandler.getInstance().inJectIndicator(this.mWebCreator.offer());
        }
        IndicatorController indicatorController = indicatorControllerInJectIndicator;
        Activity activity = this.mActivity;
        this.mIndicatorController = indicatorController;
        IVideo iVideo = getIVideo();
        this.mIVideo = iVideo;
        DefaultChromeClient defaultChromeClient = new DefaultChromeClient(activity, indicatorController, null, iVideo, this.mPermissionInterceptor, this.mWebCreator.getWebView());
        LogUtils.i(TAG, "WebChromeClient:" + this.mWebChromeClient);
        MiddlewareWebChromeBase middlewareWebChromeBase = this.mMiddlewareWebChromeBaseHeader;
        WebChromeClient webChromeClient = this.mWebChromeClient;
        if (webChromeClient != null) {
            webChromeClient.enq(middlewareWebChromeBase);
            middlewareWebChromeBase = this.mWebChromeClient;
        }
        if (middlewareWebChromeBase == null) {
            this.mTargetChromeClient = defaultChromeClient;
            return defaultChromeClient;
        }
        int i = 1;
        MiddlewareWebChromeBase next = middlewareWebChromeBase;
        while (next.next() != null) {
            next = next.next();
            i++;
        }
        LogUtils.i(TAG, "MiddlewareWebClientBase middleware count:" + i);
        next.setDelegate(defaultChromeClient);
        this.mTargetChromeClient = middlewareWebChromeBase;
        return middlewareWebChromeBase;
    }

    private IVideo getIVideo() {
        IVideo iVideo = this.mIVideo;
        return iVideo == null ? new VideoImpl(this.mActivity, this.mWebCreator.getWebView()) : iVideo;
    }

    private EventInterceptor getInterceptor() {
        EventInterceptor eventInterceptor = this.mEventInterceptor;
        if (eventInterceptor != null) {
            return eventInterceptor;
        }
        IVideo iVideo = this.mIVideo;
        if (!(iVideo instanceof VideoImpl)) {
            return null;
        }
        EventInterceptor eventInterceptor2 = (EventInterceptor) iVideo;
        this.mEventInterceptor = eventInterceptor2;
        return eventInterceptor2;
    }

    private android.webkit.WebViewClient getWebViewClient() {
        LogUtils.i(TAG, "getDelegate:" + this.mMiddleWrareWebClientBaseHeader);
        DefaultWebClient defaultWebClientBuild = DefaultWebClient.createBuilder().setActivity(this.mActivity).setWebClientHelper(this.mWebClientHelper).setPermissionInterceptor(this.mPermissionInterceptor).setWebView(this.mWebCreator.getWebView()).setInterceptUnkownUrl(this.mIsInterceptUnkownUrl).setUrlHandleWays(this.mUrlHandleWays).build();
        MiddlewareWebClientBase middlewareWebClientBase = this.mMiddleWrareWebClientBaseHeader;
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient != null) {
            webViewClient.enq(middlewareWebClientBase);
            middlewareWebClientBase = this.mWebViewClient;
        }
        if (middlewareWebClientBase == null) {
            return defaultWebClientBuild;
        }
        int i = 1;
        MiddlewareWebClientBase next = middlewareWebClientBase;
        while (next.next() != null) {
            next = next.next();
            i++;
        }
        LogUtils.i(TAG, "MiddlewareWebClientBase middleware count:" + i);
        next.setDelegate(defaultWebClientBuild);
        return middlewareWebClientBase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AgentWeb go(String str) {
        IndicatorController indicatorController;
        getUrlLoader().loadUrl(str);
        if (!TextUtils.isEmpty(str) && (indicatorController = getIndicatorController()) != null && indicatorController.offerIndicator() != null) {
            getIndicatorController().offerIndicator().show();
        }
        return this;
    }

    private void init() {
        doCompat();
        doSafeCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AgentWeb ready() {
        AgentWebConfig.initCookiesManager(this.mActivity.getApplicationContext());
        IAgentWebSettings absAgentWebSettings = this.mAgentWebSettings;
        if (absAgentWebSettings == null) {
            absAgentWebSettings = AbsAgentWebSettings.getInstance();
            this.mAgentWebSettings = absAgentWebSettings;
        }
        boolean z = absAgentWebSettings instanceof AbsAgentWebSettings;
        if (z) {
            ((AbsAgentWebSettings) absAgentWebSettings).bindAgentWeb(this);
        }
        if (this.mWebListenerManager == null && z) {
            this.mWebListenerManager = (WebListenerManager) absAgentWebSettings;
        }
        absAgentWebSettings.toSetting(this.mWebCreator.getWebView());
        if (this.mJsInterfaceHolder == null) {
            this.mJsInterfaceHolder = JsInterfaceHolderImpl.getJsInterfaceHolder(this.mWebCreator, this.mSecurityType);
        }
        LogUtils.i(TAG, "mJavaObjects:" + this.mJavaObjects.size());
        ArrayMap<String, Object> arrayMap = this.mJavaObjects;
        if (arrayMap != null && !arrayMap.isEmpty()) {
            this.mJsInterfaceHolder.addJavaObjects(this.mJavaObjects);
        }
        WebListenerManager webListenerManager = this.mWebListenerManager;
        if (webListenerManager != null) {
            webListenerManager.setDownloader(this.mWebCreator.getWebView(), null);
            this.mWebListenerManager.setWebChromeClient(this.mWebCreator.getWebView(), getChromeClient());
            this.mWebListenerManager.setWebViewClient(this.mWebCreator.getWebView(), getWebViewClient());
        }
        return this;
    }

    public static AgentBuilder with(Activity activity) {
        if (activity != null) {
            return new AgentBuilder(activity);
        }
        throw new NullPointerException("activity can not be null .");
    }

    public boolean back() {
        if (this.mIEventHandler == null) {
            this.mIEventHandler = EventHandlerImpl.getInstantce(this.mWebCreator.getWebView(), getInterceptor());
        }
        return this.mIEventHandler.back();
    }

    public AgentWeb clearWebCache() {
        if (getWebCreator().getWebView() != null) {
            AgentWebUtils.clearWebViewAllCache(this.mActivity, getWebCreator().getWebView());
        } else {
            AgentWebUtils.clearWebViewAllCache(this.mActivity);
        }
        return this;
    }

    public void destroy() {
        this.mWebLifeCycle.onDestroy();
    }

    Activity getActivity() {
        return this.mActivity;
    }

    public IAgentWebSettings getAgentWebSettings() {
        return this.mAgentWebSettings;
    }

    public IEventHandler getIEventHandler() {
        IEventHandler iEventHandler = this.mIEventHandler;
        if (iEventHandler != null) {
            return iEventHandler;
        }
        EventHandlerImpl instantce = EventHandlerImpl.getInstantce(this.mWebCreator.getWebView(), getInterceptor());
        this.mIEventHandler = instantce;
        return instantce;
    }

    public IndicatorController getIndicatorController() {
        return this.mIndicatorController;
    }

    public JsAccessEntrace getJsAccessEntrace() {
        JsAccessEntrace jsAccessEntrace = this.mJsAccessEntrace;
        if (jsAccessEntrace != null) {
            return jsAccessEntrace;
        }
        JsAccessEntraceImpl jsAccessEntraceImpl = JsAccessEntraceImpl.getInstance(this.mWebCreator.getWebView());
        this.mJsAccessEntrace = jsAccessEntraceImpl;
        return jsAccessEntraceImpl;
    }

    public JsInterfaceHolder getJsInterfaceHolder() {
        return this.mJsInterfaceHolder;
    }

    public PermissionInterceptor getPermissionInterceptor() {
        return this.mPermissionInterceptor;
    }

    public IUrlLoader getUrlLoader() {
        return this.mIUrlLoader;
    }

    public WebCreator getWebCreator() {
        return this.mWebCreator;
    }

    public WebLifeCycle getWebLifeCycle() {
        return this.mWebLifeCycle;
    }

    public boolean handleKeyEvent(int i, KeyEvent keyEvent) {
        if (this.mIEventHandler == null) {
            this.mIEventHandler = EventHandlerImpl.getInstantce(this.mWebCreator.getWebView(), getInterceptor());
        }
        return this.mIEventHandler.onKeyDown(i, keyEvent);
    }

    public static AgentBuilder with(Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return new AgentBuilder(activity, fragment);
        }
        throw new NullPointerException("activity can not be null .");
    }
}
