package com.baidu.mobads.container.landingpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.bg;
import com.baidu.mobads.container.util.bj;
import com.baidu.mobads.container.util.bp;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cl;
import com.baidu.mobads.container.y.c;
import com.baidu.mobads.sdk.api.IActivityImpl;
import com.baidu.mobstat.forbes.Config;
import com.blankj.utilcode.util.ToastUtils;
import com.luck.picture.lib.config.SelectMimeType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class App2Activity implements View.OnTouchListener, IActivityImpl {
    protected static final int ACTIONBAR_VIEW_ID = 1001;
    private static final int ANIMATION_DURATION_ACTIVITY_EXIT = 300;
    private static final int ANIMATION_DURATION_BOTTOM_ENTER = 500;
    private static final int ANIMATION_DURATION_BOTTOM_EXIT = 250;
    private static final String CPU_DOMAIN = "https://cpu.baidu.com/";
    public static final String EXTRA_DATA = "EXTRA_DATA";
    public static final String EXTRA_LP_FLAG = "EXTRA_LP_FLAG";
    private static final String FINISH_LP_BACK_BTN = "backBtnFinish";
    private static final String FINISH_LP_BACK_HOUSE = "backHouseFinish";
    private static final String FINISH_LP_BACK_KEY = "backKeyFinish";
    private static final String FINISH_LP_BY_SHOUBAI = "pauseShoubaiFinish";
    private static final String FINISH_LP_DATA_ERROR = " dataErrorFinish";
    private static final String FINISH_LP_DEAL_DOWNLOAD = "dealDownloadFinish";
    private static final String FINISH_LP_OPEN_INTENT = "openIntentFinish";
    private static final String FINISH_LP_OPEN_TIMEOUT = "openTimeoutFinish";
    private static final String FINISH_LP_VIDEO_RETURN = "videoBackFinish";
    private static final long LOAD_URL_DELAY_TIME = 500;
    public static final String LP_STYLE_FLOATING_VIDEO = "floating_video_and_web";
    public static final String LP_STYLE_SHOUBAI = "1";
    public static final String LP_STYLE_VIDEO = "video_and_web";
    public static final String LP_STYLE_VR = "lp_vr";
    public static final String MURL_SECOND_CONFIRM_NEW = "murl_second_confirm";
    public static final String MURL_WEB_NEW = "murl_web";
    public static final int WEBVIEW_ID = 17;
    private CookieManager cookieManager;
    public com.baidu.mobads.container.ax curWebview;
    private long delta;
    private boolean existWebView;
    private XDLJsInterface jsInterface;
    private String mAdTitle;
    private String mAdUniqueId;
    private Context mAppContext;
    private String mAppsid;
    private View mBackgroundView;
    private com.baidu.mobads.container.bridge.b mBaiduJsInterface;
    protected ay mBottomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private String mCustomizedBar;
    private int mFirstDownY;
    private ImageView mFullScreenBackButton;
    private View mFullScreenView;
    private ViewGroup mFullScreenViewParent;
    private com.baidu.mobads.container.bridge.am mKeyboardOptimizeJsUtils;
    private as mLandingPageTrackingInfo;
    private LinearLayout mLlContainer;
    private by.b mLogInfo;
    private long mLpExeOnCreateTime;
    private View.OnLayoutChangeListener mMTJOnLayoutChangeListener;
    private View.OnLayoutChangeListener mOnLayoutChangeListener;
    private c mPageFinishedListener;
    private Activity mProxyActivity;
    private JSONObject mRetainDialogJSON;
    private RelativeLayout mRetainDialogView;
    private RelativeLayout mRlContainer;
    private XAdRemoteLandingPageExtraInfo mTmpExtraInfo;
    private com.component.a.g.d nativeViewMediator;
    RelativeLayout wvTool;
    private static final String TAG = App2Activity.class.getSimpleName();
    private static AtomicBoolean isAppActivityOpening = new AtomicBoolean(false);
    public static AtomicBoolean MURL_SECOND_CONFIRM = new AtomicBoolean(false);
    public static AtomicBoolean MURL_WEB = new AtomicBoolean(false);
    public static int ANIMATION_DURATION_ACTIVITY_ENTER = 0;
    private static boolean mCanLpShowWhenLocked = false;
    public static boolean SHOUBAI_LP_APO_START = false;
    public static long SHOUBAI_LP_APO_START_TIME = 0;
    TextView tipView = null;
    float ratioH = 1.0f;
    float ratioW = 1.0f;
    private boolean mIsPreloaded = false;
    am actionBar = null;
    private float mPostY = 0.0f;
    private float mCurDy = 0.0f;
    private float mRlViewTop = 0.0f;
    private int mVideoHeight = 0;
    private Interpolator mInterpolator = new DecelerateInterpolator();
    private int order = 0;
    int from = 0;
    private long mEnterLpTimestamp = 0;
    int urlclicks = 0;
    int mLploadtime = -1;
    private boolean mIsThemeTranslucent = false;
    private int e75 = 1;
    private int e753 = 0;
    private boolean isLuLandingPage = false;
    private boolean isTouched = false;
    private boolean hasClked = false;
    int maxOpenedTabs = 1;
    String closeCause = "barC";
    private final HashMap<String, Long> mTrackingParams = new HashMap<>();
    private final String keyPreloaded = "preloaded";
    private final String keyPrePageStart = "prePageStart";
    private final String keyPrePageFinish = "prePageFinish";
    private final String keyPreSslError = "preSslError";
    private final String keyClickLp = "clickLp";
    private final String keyOnCreate = "onCreate";
    private final String keyPageStart = "pageStart";
    private final String keyPageFinish = "pageFinish";
    private bq mAdLogger = bq.a();
    private boolean mCanOpenAppForAPO = true;
    View mSpinnerImageView = null;
    private boolean isRecordPageStart = false;
    private boolean isRecordLpLoad = false;
    private boolean isRecordPageFinish = false;
    protected boolean mBottomViewIsShowing = false;
    private af videoView = null;
    private com.baidu.mobads.container.x.a floatingVideoLayout = null;
    private boolean floatingClosed = false;
    private AtomicBoolean closeLp = new AtomicBoolean(false);
    private String DOMAIN = "";
    private ArrayList<String> mLuTwoHopAddress = new ArrayList<>();
    private String mBuyer = "";
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private boolean mUserAutoFinish = false;
    private String mLpFinishState = "";
    private int mUseLocalResource = 0;
    private boolean mIsCpuLandingPage = false;
    private boolean mIsDarkModeStyle = false;
    private boolean mIsCpuNativePreRender = false;
    private boolean mIsFullScreenVideo = false;
    private a mSActionBarColorTheme = new a(-5987164, -6842473, -11113262, -328966);
    private boolean mIsShowActionBarTit = true;
    private int mRetainDialogConfig = 0;
    private boolean mIsCpuShareRender = false;
    private boolean mIsNeedInjectKeyboardOptimizeJS = true;
    private boolean mIsShowKeyboard = false;
    private long mlastScrollTime = 0;
    private int mScrollTime = 0;
    private int mTouchTime = 0;
    private int mLinkTime = 0;
    private boolean mAPO = false;
    private boolean mIsDownload = false;
    private boolean mIsKeyBoardUp = false;
    private long mActivityLiveTime = 0;
    private long mResumeTime = 0;
    private String mApid = "";
    private boolean mOpenBundleForbid = false;
    private boolean mBundleSetBD = false;
    private String finishUrl = null;
    private boolean isReLoadURL = false;
    private int mForbidTimes = 0;
    private String mForbidHost = "";
    private long mWebLoadStartTime = 0;
    private long mWebViewLoadTime = 0;

    public interface c {
        void a(WebView webView);
    }

    static /* synthetic */ int access$2008(App2Activity app2Activity) {
        int i = app2Activity.mScrollTime;
        app2Activity.mScrollTime = i + 1;
        return i;
    }

    static /* synthetic */ int access$2608(App2Activity app2Activity) {
        int i = app2Activity.mLinkTime;
        app2Activity.mLinkTime = i + 1;
        return i;
    }

    static /* synthetic */ int access$3308(App2Activity app2Activity) {
        int i = app2Activity.mForbidTimes;
        app2Activity.mForbidTimes = i + 1;
        return i;
    }

    static /* synthetic */ int access$4708(App2Activity app2Activity) {
        int i = app2Activity.order;
        app2Activity.order = i + 1;
        return i;
    }

    static /* synthetic */ int access$4908(App2Activity app2Activity) {
        int i = app2Activity.mUseLocalResource;
        app2Activity.mUseLocalResource = i + 1;
        return i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.isTouched = true;
        try {
        } catch (Exception e) {
            this.mAdLogger.a(TAG, e.getMessage());
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mTouchTime++;
                this.hasClked = true;
                this.mCurDy = 0.0f;
                this.mFirstDownY = (int) motionEvent.getRawY();
                this.mPostY = motionEvent.getRawY();
                return false;
            case 1:
                boolean zRunVideoAnimation = runVideoAnimation(this.mCurDy);
                if (this.videoView != null) {
                    if (this.mRlViewTop == 0.0f) {
                        switchVideoLayout(false);
                    } else {
                        switchVideoLayout(true);
                        this.curWebview.a(false);
                    }
                }
                if (this.videoView != null && this.mVideoHeight > 0 && Math.abs(((int) motionEvent.getRawY()) - this.mFirstDownY) >= ViewConfiguration.get(this.mProxyActivity).getScaledTouchSlop()) {
                    return zRunVideoAnimation;
                }
                this.mLandingPageTrackingInfo.G.incrementAndGet();
                view.performClick();
                return false;
            case 2:
                if (this.mVideoHeight > 0) {
                    this.mCurDy = motionEvent.getRawY() - this.mPostY;
                    this.mPostY = motionEvent.getRawY();
                    if (this.curWebview.c()) {
                        if (this.mCurDy >= 0.0f && this.mRlViewTop <= 0.0f) {
                            this.mRlViewTop += this.mCurDy;
                            if (this.mRlViewTop > 0.0f) {
                                this.mRlViewTop = 0.0f;
                            }
                            this.mRlContainer.setTranslationY(this.mRlViewTop);
                            return true;
                        }
                        if (this.mCurDy <= 0.0f && this.mRlViewTop > (-this.mVideoHeight)) {
                            this.mRlViewTop += this.mCurDy;
                            if (this.mRlViewTop < (-this.mVideoHeight)) {
                                this.mRlViewTop = -this.mVideoHeight;
                                if (this.videoView != null) {
                                    switchVideoLayout(true);
                                }
                            }
                            this.mRlContainer.setTranslationY(this.mRlViewTop);
                            return true;
                        }
                    }
                }
                return false;
            default:
                this.mAdLogger.a(TAG, "unprocessed action=" + motionEvent.getAction());
                return false;
        }
    }

    class b extends View {
        private Paint b;
        private int c;
        private int d;

        public b(Context context) {
            super(context);
            this.c = 0;
            this.d = 0;
            this.b = new Paint();
            this.b.setColor(App2Activity.this.mSActionBarColorTheme.c);
            this.d = bv.a(App2Activity.this.mProxyActivity.getApplicationContext()).width();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(0.0f, 0.0f, (this.d * this.c) / 100.0f, getLayoutParams().height, this.b);
        }

        public void a(int i) {
            if (i != this.c) {
                this.c = i;
                postInvalidate();
            }
        }
    }

    private RelativeLayout initFrame(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        RelativeLayout relativeLayout = new RelativeLayout(this.mProxyActivity);
        b bVar = new b(this.mProxyActivity);
        ax.c cVar = new ax.c();
        cVar.a = false;
        String strB = bp.a().b(this.mTmpExtraInfo.a().getOriginJsonObject());
        if (!TextUtils.isEmpty(strB) && cl.a(strB)) {
            this.mOpenBundleForbid = true;
            if (cl.a(this.mAppContext)) {
                this.mBundleSetBD = true;
            }
        }
        if (this.mTmpExtraInfo != null && (LP_STYLE_VR.equals(this.mTmpExtraInfo.D) || isLpVideoStyle())) {
            cVar.a = false;
        }
        this.mWebLoadStartTime = System.currentTimeMillis();
        if (this.mIsCpuNativePreRender) {
            this.curWebview = com.baidu.mobads.container.y.k.a().a(this.mProxyActivity, str);
            this.mIsPreloaded = this.curWebview != null;
        }
        if (this.curWebview == null) {
            this.curWebview = com.baidu.mobads.container.y.k.a().b(this.mProxyActivity, this.mIsCpuNativePreRender);
        }
        this.curWebview.setId(17);
        if (isLpVideoStyle() && com.baidu.mobads.container.util.x.a(this.mAppContext).a() >= 17) {
            this.curWebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        d dVarDealWithPreloadedWebView = dealWithPreloadedWebView();
        this.curWebview.a = str;
        try {
            WebSettings.class.getMethod("setDisplayZoomControls", Boolean.TYPE).invoke(this.curWebview.getSettings(), false);
        } catch (Exception e) {
            this.mAdLogger.a(TAG, e.getMessage());
        }
        this.curWebview.setWebChromeClient(new com.baidu.mobads.container.landingpage.b(this, bVar));
        if (com.baidu.mobads.container.util.x.a(this.mAppContext).a() >= 23) {
            this.curWebview.setOnScrollChangeListener(new m(this));
        }
        this.curWebview.setOnTouchListener(this);
        this.curWebview.setDownloadListener(new t(this));
        this.curWebview.setWebViewClient(new u(this, dVarDealWithPreloadedWebView));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.curWebview.setBackgroundColor(this.mIsDarkModeStyle ? -16777216 : -1);
        relativeLayout.addView(this.curWebview, layoutParams);
        this.jsInterface = new XDLJsInterface(this.curWebview, this.mProxyActivity, this.mAppsid);
        if (this.mTmpExtraInfo != null) {
            if (this.mBaiduJsInterface == null) {
                this.mBaiduJsInterface = new com.baidu.mobads.container.bridge.b(this.mProxyActivity.getApplicationContext(), this.curWebview, this.mTmpExtraInfo.a(), this.mTmpExtraInfo.a, this.mAppsid, this.mApid);
                this.mLogInfo = new by.b(this.mAppsid, this.mApid, this.mTmpExtraInfo.a);
                this.mBaiduJsInterface.a(this.mLogInfo);
            }
            if (this.mIsCpuLandingPage) {
                this.mBaiduJsInterface.a(this.mProxyActivity);
            }
        }
        this.mProxyActivity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.mSpinnerImageView = getSpinnerBar();
        relativeLayout.addView(this.mSpinnerImageView);
        relativeLayout.addView(bVar, new RelativeLayout.LayoutParams(-1, bv.b(this.mProxyActivity.getApplicationContext(), 2)));
        return relativeLayout;
    }

    private View getSpinnerBar() {
        bc bcVar = new bc(this.mProxyActivity);
        int iB = bv.b((Context) this.mProxyActivity, 38);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB, iB);
        layoutParams.addRule(13);
        bcVar.setLayoutParams(layoutParams);
        return bcVar;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
        Parcelable parcelableExtra;
        if (intent != null && com.baidu.mobads.container.util.b.a().c(this.mProxyActivity.getApplicationContext()) && (parcelableExtra = intent.getParcelableExtra("EXTRA_DATA")) != null) {
            XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo = (XAdRemoteLandingPageExtraInfo) parcelableExtra;
            if (this.mTmpExtraInfo != null && xAdRemoteLandingPageExtraInfo != null && !TextUtils.equals(this.mTmpExtraInfo.e, xAdRemoteLandingPageExtraInfo.e)) {
                this.mTmpExtraInfo = xAdRemoteLandingPageExtraInfo;
                this.mBuyer = parseAdBuyer(xAdRemoteLandingPageExtraInfo);
                if (this.wvTool != null && this.mProxyActivity != null) {
                    this.wvTool.removeAllViews();
                    addGlobalViews(this.mTmpExtraInfo.e);
                    this.wvTool.setBackgroundColor(-1);
                    this.mProxyActivity.setContentView(this.wvTool);
                }
                if (this.curWebview != null) {
                    this.curWebview.loadUrl(this.mTmpExtraInfo.e);
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onAttachedToWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        this.mProxyActivity = activity;
        this.mAppContext = this.mProxyActivity.getApplicationContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e0  */
    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r13) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 859
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.landingpage.App2Activity.onCreate(android.os.Bundle):void");
    }

    private int getAnimationDurationActivityEnter(JSONObject jSONObject) {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("control_flags");
            try {
                if (!TextUtils.isEmpty(strOptString)) {
                    return new JSONObject(strOptString).optInt("cutscenes_time", 0);
                }
            } catch (JSONException e) {
            }
        }
        return 0;
    }

    private void keyboardOptimization() {
        try {
            if (!isNeedLpKeyboardOptimize()) {
                return;
            }
            this.mProxyActivity.getWindow().setSoftInputMode(16);
            if (this.mVideoHeight > 0) {
                this.mKeyboardOptimizeJsUtils = new com.baidu.mobads.container.bridge.am();
                this.mOnLayoutChangeListener = new z(this);
                this.mProxyActivity.getWindow().getDecorView().addOnLayoutChangeListener(this.mOnLayoutChangeListener);
            }
        } catch (Exception e) {
            this.mAdLogger.a(TAG, e.getMessage());
        }
    }

    private void mtjKeyboardTrack() {
        try {
            this.mProxyActivity.getWindow().setSoftInputMode(16);
            this.mKeyboardOptimizeJsUtils = new com.baidu.mobads.container.bridge.am();
            this.mMTJOnLayoutChangeListener = new aa(this);
            this.mProxyActivity.getWindow().getDecorView().addOnLayoutChangeListener(this.mMTJOnLayoutChangeListener);
        } catch (Exception e) {
            this.mAdLogger.a(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedLpKeyboardOptimize() {
        if (this.mTmpExtraInfo != null && this.mTmpExtraInfo.a() != null) {
            return this.mTmpExtraInfo.a().getLpKeyboardOptimize();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
    }

    private void parseJsonInfo(com.baidu.mobads.container.adrequest.j jVar, JSONObject jSONObject) {
        try {
            Iterator<com.component.a.f.e> it = new com.component.a.f.e(jSONObject).iterator();
            while (it.hasNext()) {
                com.component.a.f.e next = it.next();
                if ("rvideo_lp_retain_view".equals(next.m(""))) {
                    this.mRetainDialogJSON = next.f();
                } else if ("int_lp_retain_view".equals(next.m(""))) {
                    this.mRetainDialogJSON = next.f();
                } else if ("splash_lp_retain_view".equals(next.m(""))) {
                    this.mRetainDialogJSON = next.f();
                }
            }
            if ("rsplash".equals(this.mTmpExtraInfo.a)) {
                this.mRetainDialogConfig = new com.baidu.mobads.container.components.i.a(this.mAppContext, jVar.getOriginJsonObject()).a("lp_retain_type", 0);
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
            if (jSONObjectOptJSONObject != null) {
                this.mRetainDialogConfig = jSONObjectOptJSONObject.optInt("lp_retain_type", 0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showVideo(Context context, com.baidu.mobads.container.adrequest.j jVar) {
        this.videoView = new af(context, jVar);
        this.videoView.a(new com.baidu.mobads.container.landingpage.c(this));
        if (this.mTmpExtraInfo != null && LP_STYLE_FLOATING_VIDEO.equals(this.mTmpExtraInfo.D)) {
            initFloatingVideo(context, jVar);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.videoView.getLayoutParams();
        this.mVideoHeight = layoutParams.height;
        this.videoView.setId(1001);
        this.mLlContainer.addView(this.videoView, 0, layoutParams);
        this.videoView.a();
    }

    private void initFloatingVideo(Context context, com.baidu.mobads.container.adrequest.j jVar) {
        int i;
        int i2;
        double videoHeight = jVar.getVideoHeight();
        double videoWidth = jVar.getVideoWidth();
        Double.isNaN(videoHeight);
        Double.isNaN(videoWidth);
        double d2 = videoHeight / videoWidth;
        if (d2 > 1.0d) {
            double dC = com.baidu.mobads.container.util.ab.c(context);
            Double.isNaN(dC);
            double d3 = dC / 3.0d;
            i = (int) d3;
            i2 = (int) (d3 / d2);
        } else {
            double dB = com.baidu.mobads.container.util.ab.b(context);
            Double.isNaN(dB);
            double d4 = dB * 0.45d;
            i = (int) (d4 * d2);
            i2 = (int) d4;
        }
        this.floatingVideoLayout = com.baidu.mobads.container.x.a.a(this.wvTool, i2, i);
        this.floatingVideoLayout.a(this.videoView.g());
        this.floatingVideoLayout.a(new com.baidu.mobads.container.landingpage.d(this));
        this.floatingVideoLayout.setVisibility(4);
    }

    void showAutoPlayVideoPrompt(Context context, com.baidu.mobads.container.adrequest.j jVar) {
        bd bdVar = new bd(context);
        int iB = com.baidu.mobads.container.util.ab.b(context);
        int videoHeight = (jVar.getVideoHeight() * iB) / jVar.getVideoWidth();
        this.mVideoHeight = videoHeight;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iB, videoHeight);
        layoutParams.addRule(10);
        bdVar.setId(1001);
        bdVar.a(new e(this, bdVar));
        this.mLlContainer.addView(bdVar, layoutParams);
    }

    private void addGlobalViews(String str) {
        this.wvTool = new RelativeLayout(this.mProxyActivity);
        this.mLlContainer = new LinearLayout(this.mProxyActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.mLlContainer.setOrientation(1);
        this.wvTool.addView(this.mLlContainer, layoutParams);
        this.mLandingPageTrackingInfo.p = this.mTmpExtraInfo.D;
        if (secondConfirm() && isVideoAvailable()) {
            if (com.baidu.mobads.container.util.ab.f(this.mProxyActivity)) {
                showVideo(this.mProxyActivity, this.mTmpExtraInfo.b);
            } else {
                showAutoPlayVideoPrompt(this.mProxyActivity, this.mTmpExtraInfo.b);
            }
        } else {
            initActionBar();
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, bv.b((Context) this.mProxyActivity, 46));
            this.actionBar.setId(1001);
            this.mLlContainer.addView(this.actionBar, layoutParams2);
            updateActionBarIfCpuLp();
        }
        if (!this.existWebView) {
            MURL_SECOND_CONFIRM.set(false);
            MURL_WEB.set(false);
        }
        this.mRlContainer = initFrame(str);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        if (this.mVideoHeight > 0) {
            layoutParams3.height = getDisplayHeight();
        }
        this.mLlContainer.addView(this.mRlContainer, layoutParams3);
        if (this.mIsThemeTranslucent && canSupportAnimate()) {
            com.baidu.mobads.container.util.h.b(this.mProxyActivity);
            this.wvTool.getViewTreeObserver().addOnPreDrawListener(new f(this));
        }
    }

    private void updateActionBarIfCpuLp() {
        JSONObject jSONObjectB;
        if (!this.mIsCpuLandingPage || this.actionBar == null || this.nativeViewMediator == null) {
            return;
        }
        this.actionBar.removeAllViews();
        if (this.mIsDarkModeStyle) {
            jSONObjectB = com.component.a.i.n.b(am.a);
        } else {
            jSONObjectB = com.component.a.i.n.b(am.b);
        }
        this.nativeViewMediator.a(this.actionBar, jSONObjectB, new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.mFullScreenView == null) {
            return;
        }
        if (this.mProxyActivity != null && !this.mIsThemeTranslucent && this.mProxyActivity.getRequestedOrientation() != 1) {
            this.mProxyActivity.setRequestedOrientation(1);
            this.mIsFullScreenVideo = false;
        }
        this.mFullScreenView.setVisibility(8);
        if (this.mFullScreenViewParent != null && this.mFullScreenView != null) {
            this.mFullScreenViewParent.removeView(this.mFullScreenView);
        }
        if (this.mFullScreenViewParent != null) {
            this.mFullScreenViewParent.setVisibility(8);
        }
        if (this.mFullScreenViewParent != null && this.mFullScreenBackButton != null) {
            this.mFullScreenViewParent.removeView(this.mFullScreenBackButton);
        }
        if (this.mCustomViewCallback != null) {
            this.mCustomViewCallback.onCustomViewHidden();
        }
        this.mFullScreenView = null;
        if (this.mRlContainer != null) {
            this.mRlContainer.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFullScreenBackButton() {
        Context applicationContext = this.mProxyActivity.getApplicationContext();
        if (this.mFullScreenBackButton == null) {
            this.mFullScreenBackButton = new ImageView(applicationContext);
            int iB = bv.b(applicationContext, 6);
            this.mFullScreenBackButton.setPadding(iB, iB, iB, iB);
            this.mFullScreenBackButton.setImageBitmap(com.baidu.mobads.container.util.ah.a(com.baidu.mobads.container.x.k.a));
            this.mFullScreenBackButton.setOnClickListener(new h(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bv.b(applicationContext, 24), bv.b(applicationContext, 24));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = bv.b(applicationContext, 15);
            layoutParams.topMargin = bv.b(applicationContext, 15);
            this.mFullScreenBackButton.setLayoutParams(layoutParams);
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(new OvalShape());
            shapeDrawable.getPaint().setColor(Color.argb(50, 186, 183, 185));
            if (com.baidu.mobads.container.util.x.a(this.mAppContext).a() >= 16) {
                this.mFullScreenBackButton.setBackground(shapeDrawable);
            }
        }
        this.mFullScreenViewParent.addView(this.mFullScreenBackButton);
    }

    private boolean isLpVideoStyle() {
        return this.mTmpExtraInfo != null && (LP_STYLE_VIDEO.equals(this.mTmpExtraInfo.D) || LP_STYLE_FLOATING_VIDEO.equals(this.mTmpExtraInfo.D));
    }

    private boolean secondConfirm() {
        return this.existWebView ? (TextUtils.isEmpty(this.mTmpExtraInfo.E) && isLpVideoStyle()) || MURL_SECOND_CONFIRM_NEW.equals(this.mTmpExtraInfo.E) : !(MURL_SECOND_CONFIRM.get() || !isLpVideoStyle() || MURL_WEB.get()) || MURL_SECOND_CONFIRM.get();
    }

    private boolean isVideoAvailable() {
        return this.mTmpExtraInfo != null && this.mTmpExtraInfo.b != null && this.mTmpExtraInfo.b.getVideoWidth() > 0 && this.mTmpExtraInfo.b.getVideoHeight() > 0;
    }

    protected boolean canSupportAnimate() {
        try {
            if (isLpVideoStyle()) {
                return false;
            }
            return com.baidu.mobads.container.util.x.a(this.mAppContext).a() >= 12;
        } catch (Exception e) {
            this.mAdLogger.c(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkGoBack() {
        try {
            if (!this.mOpenBundleForbid || TextUtils.isEmpty(this.finishUrl) || this.curWebview.a.equals(this.finishUrl) || !this.isReLoadURL || !this.finishUrl.startsWith(com.alipay.sdk.m.l.a.r)) {
                return false;
            }
            HashMap map = new HashMap();
            if (!this.finishUrl.contains(".baidu.")) {
                String str = "";
                if (this.mBundleSetBD) {
                    str = "com.baidu.searchbox";
                }
                map.put("x-requested-with", str);
                this.curWebview.loadUrl(this.finishUrl, map);
            } else {
                this.curWebview.loadUrl(this.finishUrl);
            }
            this.isReLoadURL = false;
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    protected void initActionBar() {
        this.actionBar = new am(this.mProxyActivity, this.mSActionBarColorTheme);
        this.actionBar.setId(1001);
        this.actionBar.a(new i(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomView() {
        initBackgroundView();
        initBottomView();
        this.wvTool.addView(this.mBackgroundView);
        this.wvTool.addView(this.mBottomView);
        if (canSupportAnimate()) {
            this.mBottomView.getViewTreeObserver().addOnPreDrawListener(new j(this));
        }
    }

    private void initBackgroundView() {
        this.mBackgroundView = new View(this.mProxyActivity);
        this.mBackgroundView.setOnClickListener(new k(this));
        if (canSupportAnimate()) {
            this.mBackgroundView.setBackgroundColor(-16777216);
            this.mBackgroundView.setAlpha(0.0f);
        }
        this.mBackgroundView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    protected void initBottomView() {
        this.mBottomView = new ay(this.mProxyActivity, isShowShareButton());
        this.mBottomView.a(new l(this));
        if (canSupportAnimate()) {
            this.mBottomView.setAlpha(0.0f);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mBottomView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowShareButton() {
        try {
            if (this.mIsCpuShareRender) {
                if ("cpu.baidu.com".equals(Uri.parse(this.curWebview.getUrl()).getHost())) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            this.mAdLogger.a(TAG, e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshWebView() {
        if (this.curWebview != null) {
            this.curWebview.reload();
        }
    }

    protected void runBottomViewEnterAnimation(View view, View view2) {
        this.mBottomViewIsShowing = true;
        try {
            view.animate().setDuration(LOAD_URL_DELAY_TIME).alpha(0.5f);
            view2.setTranslationY(view2.getHeight());
            view2.animate().setDuration(LOAD_URL_DELAY_TIME).alpha(1.0f).translationY(0.0f);
        } catch (Exception e) {
            this.mAdLogger.c(e);
        }
    }

    protected void runBottomViewExitAnimation(View view, View view2) {
        this.mBottomViewIsShowing = false;
        if (!canSupportAnimate()) {
            removeFromParent(view2);
            removeFromParent(view);
            return;
        }
        try {
            view.clearAnimation();
            view.animate().setDuration(250L).alpha(0.0f);
            view2.setTranslationY(0.0f);
            ViewPropertyAnimator viewPropertyAnimatorTranslationY = view2.animate().setDuration(250L).alpha(0.0f).translationY(view2.getHeight());
            if (com.baidu.mobads.container.util.x.a(this.mAppContext).a() >= 16) {
                viewPropertyAnimatorTranslationY.withEndAction(new n(this, view2, view));
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new o(this, view2, view), 250L);
            }
        } catch (Exception e) {
            this.mAdLogger.c(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runActivityStartAnimation(View view) {
        try {
            if (ANIMATION_DURATION_ACTIVITY_ENTER < 0 || ANIMATION_DURATION_ACTIVITY_ENTER > 2000) {
                ANIMATION_DURATION_ACTIVITY_ENTER = 0;
            }
            view.animate().setDuration(ANIMATION_DURATION_ACTIVITY_ENTER);
            view.setTranslationX(view.getWidth());
            view.animate().setDuration(ANIMATION_DURATION_ACTIVITY_ENTER).translationX(0.0f);
        } catch (Exception e) {
            this.mAdLogger.c(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exit() {
        if (this.mRetainDialogConfig == 1 && this.mRetainDialogView != null) {
            this.mRetainDialogView.setVisibility(0);
        } else {
            runActivityExitAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runActivityExitAnimation() {
        this.closeLp.set(true);
        sendLpBroadcast();
        com.baidu.mobads.container.activity.d.a().b();
        this.mUserAutoFinish = true;
        if (!canSupportAnimate()) {
            finishActivity();
            return;
        }
        try {
            RelativeLayout relativeLayout = this.wvTool;
            if (this.mIsThemeTranslucent) {
                com.baidu.mobads.container.util.h.b(this.mProxyActivity);
                relativeLayout.setTranslationX(0.0f);
                ViewPropertyAnimator viewPropertyAnimatorTranslationX = relativeLayout.animate().setDuration(300L).translationX(relativeLayout.getWidth());
                if (com.baidu.mobads.container.util.x.a(this.mAppContext).a() >= 16) {
                    viewPropertyAnimatorTranslationX.withEndAction(new p(this));
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new q(this), 300L);
                }
                return;
            }
            finishActivity();
        } catch (Exception e) {
            this.mAdLogger.c(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromParent(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Exception e) {
                this.mAdLogger.c(e);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
        } catch (Exception e) {
            this.mAdLogger.a(TAG, e.getMessage());
        }
        if (i == 4) {
            if (this.videoView == null || !this.videoView.f()) {
                if (this.mBottomViewIsShowing) {
                    runBottomViewExitAnimation(this.mBackgroundView, this.mBottomView);
                } else if (this.mFullScreenView != null || this.mIsFullScreenVideo) {
                    hideCustomView();
                } else if (this.curWebview.canGoBack()) {
                    this.mVideoHeight = 0;
                    this.curWebview.goBack();
                } else {
                    this.closeCause = "backC";
                    if (!this.closeLp.get()) {
                        updateLpState(FINISH_LP_BACK_KEY);
                        exit();
                    }
                }
            }
            this.mLandingPageTrackingInfo.W++;
            return true;
        }
        if (i == 46) {
            this.curWebview.reload();
            return true;
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        JSONObject jSONObjectOptJSONObject;
        if (this.mBaiduJsInterface != null) {
            this.mBaiduJsInterface.e();
        }
        try {
            if (this.tipView != null) {
                this.tipView.clearAnimation();
            }
            if (this.mOnLayoutChangeListener != null) {
                this.mProxyActivity.getWindow().getDecorView().removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
            }
            if (this.mMTJOnLayoutChangeListener != null) {
                this.mProxyActivity.getWindow().getDecorView().removeOnLayoutChangeListener(this.mMTJOnLayoutChangeListener);
            }
            if (this.curWebview != null) {
                ((ViewGroup) this.curWebview.getParent()).removeView(this.curWebview);
            }
        } catch (Exception e) {
            this.mAdLogger.a(TAG, e.getMessage());
        }
        isAppActivityOpening.set(false);
        if (this.mLandingPageTrackingInfo != null) {
            this.mLandingPageTrackingInfo.a = this.closeCause;
            as asVar = this.mLandingPageTrackingInfo;
            int i = this.order;
            this.order = i + 1;
            asVar.o = i;
            this.mLandingPageTrackingInfo.q = this.curWebview != null ? this.curWebview.getContentHeight() : 0;
            this.mLandingPageTrackingInfo.F = this.curWebview != null ? this.curWebview.getProgress() : 0;
            this.mLandingPageTrackingInfo.H = this.urlclicks;
            this.mLandingPageTrackingInfo.I = this.mLploadtime;
            this.mLandingPageTrackingInfo.J = System.currentTimeMillis() - this.mEnterLpTimestamp;
            this.mLandingPageTrackingInfo.L = this.e75;
            this.mLandingPageTrackingInfo.M = this.e753;
            this.mLandingPageTrackingInfo.N = this.from;
            this.mLandingPageTrackingInfo.O = this.maxOpenedTabs;
        }
        sendLpCloseLog(this.mProxyActivity.getApplicationContext());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "bqtLpTrack");
            jSONObject.put("url", this.mTmpExtraInfo.a().getClickThroughUrl());
            jSONObject.put("appsid", this.mAppsid);
            jSONObject.put("qk", this.mTmpExtraInfo.a().getQueryKey());
            jSONObject.put(com.baidu.mobads.container.components.command.j.f, this.mTmpExtraInfo.a().getBuyer());
            jSONObject.put("adId", this.mTmpExtraInfo.a().getAdId());
            jSONObject.put("startstamp", this.mEnterLpTimestamp);
            jSONObject.put("exitstamp", System.currentTimeMillis());
            jSONObject.put("scrollcount", this.mScrollTime);
            jSONObject.put("touchcount", this.mTouchTime);
            jSONObject.put("lpcount", this.mLinkTime);
            jSONObject.put("apo", this.mAPO);
            jSONObject.put("download", this.mIsDownload);
            jSONObject.put("keyboardshow", this.mIsKeyBoardUp);
            jSONObject.put("prod", this.mTmpExtraInfo.a);
            jSONObject.put("live_time", this.mActivityLiveTime);
            try {
                JSONObject originJsonObject = this.mTmpExtraInfo.a().getOriginJsonObject();
                if (originJsonObject != null) {
                    jSONObject.put("t_qk", originJsonObject.optString("qk", ""));
                    jSONObject.put("title", originJsonObject.optString("tit", "") + "|" + originJsonObject.optString(RemoteRewardActivity.JSON_BANNER_DESC_ID, "") + "|" + originJsonObject.optString("appname", ""));
                    if (this.mTmpExtraInfo.a().getActionType() == 512 && (jSONObjectOptJSONObject = originJsonObject.optJSONObject("apo")) != null) {
                        jSONObject.put("apo_url", jSONObjectOptJSONObject.optString("fallback", ""));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            jSONObject.put("apid", this.mApid);
            com.baidu.mobads.container.r.c.a(jSONObject);
        } catch (Throwable th2) {
        }
        try {
            this.mAdLogger.a(TAG, "onDestroy");
            com.baidu.mobads.container.y.k.a().a(this.curWebview);
        } catch (Exception e2) {
            this.mAdLogger.a(TAG, e2.getMessage());
        }
        disposeAnimation();
        MURL_SECOND_CONFIRM.set(false);
        if (this.existWebView) {
            Process.killProcess(Process.myPid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disposeAnimation() {
        if (this.mSpinnerImageView != null) {
            removeFromParent(this.mSpinnerImageView);
            this.mSpinnerImageView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        if (com.baidu.mobads.container.ax.a(r8) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean broswer(android.webkit.WebView r7, java.lang.String r8, java.lang.Runnable r9, java.lang.Runnable r10) {
        /*
            r6 = this;
            r0 = 1
            android.net.Uri r1 = android.net.Uri.parse(r8)     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r1.getScheme()     // Catch: java.lang.Exception -> L29
            java.lang.String r3 = "mobadssdk"
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Exception -> L29
            if (r2 == 0) goto L28
            com.baidu.mobads.container.landingpage.XDLJsInterface r2 = r6.jsInterface     // Catch: java.lang.Exception -> L29
            if (r2 != 0) goto L22
            com.baidu.mobads.container.landingpage.XDLJsInterface r2 = new com.baidu.mobads.container.landingpage.XDLJsInterface     // Catch: java.lang.Exception -> L29
            com.baidu.mobads.container.ax r3 = r6.curWebview     // Catch: java.lang.Exception -> L29
            android.app.Activity r4 = r6.mProxyActivity     // Catch: java.lang.Exception -> L29
            java.lang.String r5 = r6.mAppsid     // Catch: java.lang.Exception -> L29
            r2.<init>(r3, r4, r5)     // Catch: java.lang.Exception -> L29
            r6.jsInterface = r2     // Catch: java.lang.Exception -> L29
        L22:
            com.baidu.mobads.container.landingpage.XDLJsInterface r2 = r6.jsInterface     // Catch: java.lang.Exception -> L29
            r2.handleShouldOverrideUrlLoading(r1)     // Catch: java.lang.Exception -> L29
            return r0
        L28:
            goto L35
        L29:
            r1 = move-exception
            com.baidu.mobads.container.util.bq r2 = r6.mAdLogger
            java.lang.String r3 = com.baidu.mobads.container.landingpage.App2Activity.TAG
            java.lang.String r1 = r1.getMessage()
            r2.a(r3, r1)
        L35:
            com.baidu.mobads.container.bridge.b r1 = r6.mBaiduJsInterface     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L47
            com.baidu.mobads.container.bridge.b r1 = r6.mBaiduJsInterface     // Catch: java.lang.Throwable -> L48
            boolean r1 = r1.c(r8)     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L47
            com.baidu.mobads.container.bridge.b r1 = r6.mBaiduJsInterface     // Catch: java.lang.Throwable -> L48
            r1.a(r8)     // Catch: java.lang.Throwable -> L48
            return r0
        L47:
            goto L54
        L48:
            r1 = move-exception
            com.baidu.mobads.container.util.bq r2 = r6.mAdLogger
            java.lang.String r3 = com.baidu.mobads.container.landingpage.App2Activity.TAG
            java.lang.String r1 = r1.getMessage()
            r2.a(r3, r1)
        L54:
            boolean r1 = r6.mCanOpenAppForAPO     // Catch: java.lang.Exception -> Lcc
            if (r1 == 0) goto L5f
            boolean r1 = com.baidu.mobads.container.ax.i(r8)     // Catch: java.lang.Exception -> Lcc
            if (r1 == 0) goto Lc5
            goto L65
        L5f:
            boolean r1 = com.baidu.mobads.container.ax.a(r8)     // Catch: java.lang.Exception -> Lcc
            if (r1 == 0) goto Lc5
        L65:
            boolean r10 = com.baidu.mobads.container.ax.h(r8)     // Catch: java.lang.Exception -> Lcc
            java.lang.String r1 = "android.intent.action.VIEW"
            if (r10 == 0) goto L83
            android.content.Intent r10 = new android.content.Intent     // Catch: java.lang.Exception -> Lcc
            r10.<init>(r1)     // Catch: java.lang.Exception -> Lcc
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch: java.lang.Exception -> Lcc
            java.lang.String r1 = "audio/*"
            r10.setDataAndType(r8, r1)     // Catch: java.lang.Exception -> Lcc
            android.content.Context r7 = r7.getContext()     // Catch: java.lang.Exception -> Lcc
            r7.startActivity(r10)     // Catch: java.lang.Exception -> Lcc
            goto Lbf
        L83:
            boolean r10 = com.baidu.mobads.container.ax.g(r8)     // Catch: java.lang.Exception -> Lcc
            if (r10 == 0) goto L9f
            android.content.Intent r10 = new android.content.Intent     // Catch: java.lang.Exception -> Lcc
            r10.<init>(r1)     // Catch: java.lang.Exception -> Lcc
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch: java.lang.Exception -> Lcc
            java.lang.String r1 = "video/*"
            r10.setDataAndType(r8, r1)     // Catch: java.lang.Exception -> Lcc
            android.content.Context r7 = r7.getContext()     // Catch: java.lang.Exception -> Lcc
            r7.startActivity(r10)     // Catch: java.lang.Exception -> Lcc
            goto Lbf
        L9f:
            com.baidu.mobads.container.landingpage.XAdRemoteLandingPageExtraInfo r10 = r6.mTmpExtraInfo     // Catch: java.lang.Exception -> Lcc
            if (r10 == 0) goto Lb8
            android.content.Context r10 = r7.getContext()     // Catch: java.lang.Exception -> Lcc
            com.baidu.mobads.container.landingpage.XAdRemoteLandingPageExtraInfo r1 = r6.mTmpExtraInfo     // Catch: java.lang.Exception -> Lcc
            com.baidu.mobads.container.adrequest.j r1 = r1.a()     // Catch: java.lang.Exception -> Lcc
            com.baidu.mobads.container.util.by$b r2 = r6.mLogInfo     // Catch: java.lang.Exception -> Lcc
            com.baidu.mobads.container.ax r3 = r6.curWebview     // Catch: java.lang.Exception -> Lcc
            java.lang.String r3 = r3.getUrl()     // Catch: java.lang.Exception -> Lcc
            com.baidu.mobads.container.util.by.a(r10, r1, r2, r8, r3)     // Catch: java.lang.Exception -> Lcc
        Lb8:
            android.content.Context r7 = r7.getContext()     // Catch: java.lang.Exception -> Lcc
            com.baidu.mobads.container.util.bj.a(r7, r8)     // Catch: java.lang.Exception -> Lcc
        Lbf:
            if (r9 == 0) goto Lc4
            r9.run()     // Catch: java.lang.Exception -> Lcc
        Lc4:
            return r0
        Lc5:
            if (r10 == 0) goto Lcb
            r10.run()     // Catch: java.lang.Exception -> Lcc
            return r0
        Lcb:
            goto Ld8
        Lcc:
            r7 = move-exception
            com.baidu.mobads.container.util.bq r8 = r6.mAdLogger
            java.lang.String r9 = com.baidu.mobads.container.landingpage.App2Activity.TAG
            java.lang.String r7 = r7.getMessage()
            r8.a(r9, r7)
        Ld8:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.landingpage.App2Activity.broswer(android.webkit.WebView, java.lang.String, java.lang.Runnable, java.lang.Runnable):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadAPK(String str, com.baidu.mobads.container.adrequest.j jVar) {
        Context context = this.mProxyActivity != null ? this.mProxyActivity : this.curWebview.getContext();
        String appPackageName = jVar.getAppPackageName();
        if (TextUtils.isEmpty(appPackageName)) {
            appPackageName = com.baidu.mobads.container.util.ap.a(str);
        }
        jVar.setAppPackageName(appPackageName);
        jVar.setClickThroughUrl(str);
        jVar.setOriginClickUrl(str);
        jVar.setAdId(this.mLandingPageTrackingInfo.d);
        com.baidu.mobads.container.f.a(context, this.mLandingPageTrackingInfo.h, jVar, this.mTmpExtraInfo.a, "lp_normal", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void myLoadUrl(WebView webView, String str, boolean z, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (webView != null) {
            injectCookie(str);
            if (this.hasClked) {
                this.urlclicks++;
                this.mLandingPageTrackingInfo.G.decrementAndGet();
                this.hasClked = false;
            }
            if (z && str2.equals("ignore")) {
                try {
                    this.curWebview.loadUrl(str);
                } catch (Exception e) {
                }
            } else {
                try {
                    HashMap map = new HashMap();
                    if (!needInjectJSWhenPageFinished()) {
                        executeJavaScript("javascript:(function(){window.baidu={};window.baidu.mobads={};window.baidu.mobads.Sdk={isIOS:false};var Sdk=window.baidu.mobads.Sdk;Sdk.isIOS=(/iphone|ipad|ipod/i).test(window.navigator.userAgent.toLowerCase());var mob=window.baidu.mobads;mob.Act={LP:1,DL:2,MAP:4,SMS:8,MAIL:16,PHONE:32,VIDEO:64,RM:128,NA:256,APO:512};var win=window;win.MobadsSdk=win.MobadsSdk||{};var MobadsSdk=win.MobadsSdk;var send3rdLog=function(isShowLog,ad){if(!ad||!ad.mon){return}var url;for(var i=0;i<ad.mon.length;++i){url=isShowLog?ad.mon[i].s:ad.mon[i].c;if(!url){continue}new Image().src=url}};Sdk.setActionUrl=function(url,inapp,act,title,close){var opt={};if(\"[object Object]\"===Object.prototype.toString.call(url)){opt=url;url=opt.url;inapp=opt.inapp;act=opt.act;title=opt.title;close=opt.close}opt.url=url||\"\";opt.inapp=inapp||false;opt.act=act||1;opt.title=title||\"\";opt.close=close||false;opt.logurl=opt.logurl||\"\";opt.weibo=opt.weibo||\"\";opt.map=opt.map||\"\";opt.search=opt.search||\"\";opt.sms=opt.sms||\"\";opt.at=opt.at||1;opt.tid=opt.tid||\"\";opt.erciqueren=true;if(MobadsSdk.setActionUrl){var DUMP_PAR=opt.inapp;MobadsSdk.setActionUrl(JSON.stringify(opt),DUMP_PAR)}};Sdk.sendClickLog=function(logurl){new Image().src=logurl};Sdk.onAdPlayEnd=function(){if(MobadsSdk.onAdPlayEnd){setTimeout(function(){MobadsSdk.onAdPlayEnd()},300)}};Sdk.open=function(url,options){var option={url:url,inapp:true,act:mob.Act.LP};Sdk.setActionUrl(option);send3rdLog(false,options)};Sdk.startDownload=function(url,options){var ad={};ad=options||{};ad.tit=options&&options.tit||options.appname||\"应用\";var mobadsJumpUrl=url;if(/^itms-services:\\/\\// .test(url)){Sdk.setActionUrl(url,false,mob.Act.DL,ad.tit,true);return}if(Sdk.isIOS){var tid=options&&options.pinfo&&options.pinfo.tid;if(tid){Sdk.sendClickLog(mobadsJumpUrl)}Sdk.setActionUrl({url:url,tid:tid||\"\",inapp:true,act:mob.Act.DL});return}var mon=options&&options.mon||[];var id=options&&options.id||1;var pk=options&&options.pk||\"\";var qk=options&&options.qk||\"\";var exp2=options&&options.exp2||{};var wi=options&&options.wi?true:false;var title=ad.tit;var jsonpar={url:mobadsJumpUrl,act:mob.Act.DL,inapp:true,close:true,adid:id,originUrl:mobadsJumpUrl,dlTunnel:3,autoOpen:true,popNotif:true,canCancel:true,canDelete:5,mon:mon,pk:pk,qk:qk,adid:id,title:ad.tit};Sdk.setActionUrl(jsonpar);if(MobadsSdk.sendActivate){MobadsSdk.sendActivate(JSON.stringify(jsonpar));}send3rdLog(false,options);};Sdk.openScheme=function(url,options){var ad={};ad=options||{};ad.tit=options &&options.tit||\"应用\";var pk=options&&options.pk||\"\";var option={url:url,inapp:true,act:ad.act,title:ad.tit,close:true,pk:pk};Sdk.setActionUrl(option);send3rdLog(false,options);};Sdk.handleClick=function(options){var ad=options||{};var Act=mob.Act;if(Act.LP==ad.act){Sdk.open(ad.curl,ad)}else if(Act.DL==ad.act){Sdk.startDownload(ad.curl,ad)}else if(Act.APO==ad.act){new Image().src=ad.curl;Sdk.openScheme(ad.apo,ad);}};Sdk.onAdPlayEnd=function(){if(MobadsSdk.onAdPlayEnd){MobadsSdk.onAdPlayEnd();}};Sdk.f=function(){if(arguments.length===0){return '';}else if(arguments.length===1){return arguments[0];}var res=arguments[0];for(var i=1;i<arguments.length;++i){var re=new RegExp('\\\\{'+(i-1)+'\\\\}','g');res=res.replace(re,arguments[i]);}return res;};Sdk.randomInt=function(min,max){return Math.floor(Math.random()*(max-min+1)+min);};Sdk.isFunction=function(source){return '[object Function]'===Object.prototype.toString.call(source);};Sdk.natFireEvent=function(token,res){res=res||'';if(token!==''&&Sdk.__events&&Sdk.__events[token]&&Sdk.isFunction(Sdk.__events[token])){Sdk.__events[token](res);if(Sdk.__events[token]&&!Sdk.__events[token].multi){delete Sdk.__events[token];}}};Sdk.natRegEv=function(eventHandler,eventType){eventType=eventType||'';Sdk.__events=Sdk.__events||{};var token=Sdk.f('_{0}_{1}_{2}',eventType,new Date().getTime(),Sdk.randomInt(0,4294967296));Sdk.__events[token]=eventHandler;return token;};Sdk.isInstalled=function(pk,onready){var token=Sdk.natRegEv(onready);if(MobadsSdk.isInstalled){MobadsSdk.isInstalled(token,pk);}else{Sdk.natFireEvent(token,'false');}};Sdk.getDownloadStatus=function(callback,pkg){var token=Sdk.natRegEv(callback);if(MobadsSdk.getDownloadStatus){MobadsSdk.getDownloadStatus(token,pkg);}};Sdk.pauseDownload=function(pkg){if(MobadsSdk.pauseDownload){MobadsSdk.pauseDownload(pkg);}};window.MobadsSdk=window.MobadsSdk||{};window.MobadsSdk.pauseDownload=function(pkg){window.location='mobadssdk://pauseDownload?pkg='+pkg;};window.MobadsSdk.getDownloadStatus=function(token,pkg){window.location='mobadssdk://getDownloadStatus?token='+token+'&pkg='+pkg;};window.MobadsSdk.setActionUrl=function(jsonPar,inapp){window.location='mobadssdk://setActionUrl?json='+jsonPar;};})();");
                    }
                    this.curWebview.getClass().getMethod("loadUrl", String.class, Map.class).invoke(this.curWebview, str, map);
                } catch (Exception e2) {
                    try {
                        this.curWebview.loadUrl(str);
                    } catch (Exception e3) {
                        this.mAdLogger.a(TAG, e2.getMessage());
                    }
                }
            }
            this.curWebview.clearHistory();
        }
    }

    public boolean needInjectJSWhenPageFinished() {
        return com.baidu.mobads.container.util.x.a(this.mAppContext).a() >= 24 || com.baidu.mobads.container.util.ab.a(this.mProxyActivity.getApplicationContext()) >= 24;
    }

    public void executeJavaScript(String str) {
        if (this.curWebview != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                try {
                    if (!str.startsWith("javascript:")) {
                        str = "javascript:" + str;
                    }
                    if (com.baidu.mobads.container.util.x.a(this.mAppContext).a() < 19) {
                        this.curWebview.loadUrl(str);
                        return;
                    } else {
                        this.curWebview.evaluateJavascript(str, new r(this));
                        return;
                    }
                } catch (Exception e) {
                    this.mAdLogger.a(TAG, e.getMessage());
                    return;
                }
            }
            com.baidu.mobads.container.d.b.a().a(new s(this, str));
            return;
        }
        this.mAdLogger.a(TAG, "webview is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isQuickAppUrl(String str) {
        if (str.contains("/127.0.0.1:55555")) {
            return true;
        }
        return !com.baidu.mobads.container.util.o.g(str);
    }

    public void sendQuickAppLog(Context context, String str) {
        try {
            by.a aVarA = by.a.a(context).a(431).a("url", str).a("appear_scene", "lp").a("lpState", this.mLpFinishState).a("lpLiveTime", (System.currentTimeMillis() - this.mLpExeOnCreateTime) + "").a("delta", this.delta + "");
            if (this.mTmpExtraInfo != null && this.mTmpExtraInfo.a() != null) {
                aVarA.a(this.mTmpExtraInfo.a());
            }
            aVarA.g();
        } catch (Exception e) {
            com.baidu.mobads.container.l.g.b(TAG, e.getMessage());
        }
    }

    private void sendXRequestWithLog(Context context, String str) {
        try {
            by.a aVarA = by.a.a(context).a(433).a("url", str);
            if (this.mTmpExtraInfo != null && this.mTmpExtraInfo.a() != null) {
                aVarA.a(this.mTmpExtraInfo.a());
            }
            aVarA.g();
        } catch (Exception e) {
            com.baidu.mobads.container.l.g.b(TAG, e.getMessage());
        }
    }

    public void sendLpCloseLog(Context context) {
        try {
            by.a aVarA = by.a.a(context).a(39).a("apid", this.mApid).a("webFinishLoad", this.mWebViewLoadTime).a("lpState", this.mLpFinishState).a("lpLiveTime", (System.currentTimeMillis() - this.mLpExeOnCreateTime) + "").a("delta", this.delta + "");
            if (this.mTmpExtraInfo != null && this.mTmpExtraInfo.a() != null) {
                aVarA.a(this.mTmpExtraInfo.a());
            }
            stateEvent(com.baidu.mobads.container.components.h.a.EVENT_LP_CLOSE);
            stateEvent(com.baidu.mobads.container.components.h.b.d, this.urlclicks + "");
            stateEvent(com.baidu.mobads.container.components.h.b.m);
            com.baidu.mobads.container.components.h.d.b(this.mAdUniqueId);
            aVarA.a("clickLp", queryTrackingParams("clickLp", 0L));
            aVarA.a("onCreate", queryTrackingParams("onCreate", 0L));
            aVarA.a("npr", this.mIsCpuNativePreRender);
            aVarA.a("use_cache", this.mUseLocalResource);
            aVarA.a("preloaded", this.mIsPreloaded);
            aVarA.a("prePageStart", queryTrackingParams("prePageStart", 0L));
            aVarA.a("prePageFinish", queryTrackingParams("prePageFinish", 0L));
            if (this.mLandingPageTrackingInfo != null) {
                aVarA.a(this.mLandingPageTrackingInfo.c());
            }
            if (this.mOpenBundleForbid && this.mForbidTimes > 0) {
                aVarA.a("fbts", this.mForbidTimes);
                if (!TextUtils.isEmpty(this.mForbidHost)) {
                    aVarA.a("fbht", this.mForbidHost);
                }
            }
            aVarA.g();
        } catch (Exception e) {
            this.mAdLogger.a(TAG, e.getMessage());
        }
    }

    static class d {
        boolean a = false;
        String b = "";
        boolean c = false;
        boolean d = true;

        d() {
        }
    }

    public void setPageFinishedListener(c cVar) {
        this.mPageFinishedListener = cVar;
    }

    private int getThemeId() throws NoSuchMethodException, SecurityException {
        try {
            Method method = Context.class.getMethod("getThemeResId", new Class[0]);
            method.setAccessible(true);
            return ((Integer) method.invoke(this.mProxyActivity, new Object[0])).intValue();
        } catch (Exception e) {
            this.mAdLogger.c(e);
            return -1;
        }
    }

    private boolean isThemeTranslucent() {
        try {
            return 16973840 == getThemeId();
        } catch (Exception e) {
            this.mAdLogger.c(e);
            return false;
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
        if (this.videoView != null) {
            this.videoView.b();
        }
        if (this.floatingVideoLayout != null && this.floatingVideoLayout.getVisibility() == 0) {
            this.floatingVideoLayout.f();
        }
        if (this.mIsCpuLandingPage && this.curWebview != null) {
            this.curWebview.onPause();
        }
        if (SHOUBAI_LP_APO_START) {
            if (!this.mUserAutoFinish) {
                updateLpState(FINISH_LP_BY_SHOUBAI);
            }
            SHOUBAI_LP_APO_START = false;
            finishActivity();
        }
        this.mActivityLiveTime += System.currentTimeMillis() - this.mResumeTime;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
    }

    public static void canLpShowWhenLocked(boolean z) {
        mCanLpShowWhenLocked = z;
    }

    private void initCookieManager() {
        try {
            CookieSyncManager.createInstance(this.mProxyActivity.getApplicationContext());
        } catch (Throwable th) {
        }
        try {
            this.cookieManager = CookieManager.getInstance();
            this.cookieManager.setAcceptCookie(true);
        } catch (Throwable th2) {
        }
    }

    private void injectCookie(String str) {
        Uri uri = Uri.parse(str);
        Iterator<String> it = this.mLuTwoHopAddress.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (uri.getHost().contains(next) || uri.getPath().contains(next)) {
                this.DOMAIN = uri.getScheme() + "://" + uri.getHost();
                HashMap<String, String> map = new HashMap<>();
                map.put("bd_cuid", IDManager.getInstance().a(this.mProxyActivity));
                map.put("wifi_mac", "");
                map.put("wifi_name", getSSid());
                setCookie("BDUD", com.baidu.mobads.container.util.u.a(hashMapToString(map)));
            }
        }
        double dB = com.baidu.mobads.container.j.b();
        if ("4".equals(this.mBuyer)) {
            this.DOMAIN = "http://aden.baidu.com/";
            setCookie("MobAdsV", Double.valueOf(dB));
            this.DOMAIN = "https://aden.baidu.com/";
            setCookie("MobAdsV", Double.valueOf(dB));
        }
        if (this.mIsCpuLandingPage) {
            setCookie(CPU_DOMAIN, Double.valueOf(dB));
        }
    }

    private String getSSid() {
        return "";
    }

    private String hashMapToString(HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            int i = 0;
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    i++;
                    if (i == 1) {
                        sb.append(str).append("=").append(str2);
                    } else {
                        sb.append("\\0").append(str).append("=").append(str2);
                    }
                }
            }
        }
        return sb.toString();
    }

    private void setCookie(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("=");
        stringBuffer.append(obj);
        stringBuffer.append(com.alipay.sdk.m.u.i.b);
        try {
            this.cookieManager.setCookie(this.DOMAIN, stringBuffer.toString());
        } catch (Throwable th) {
        }
    }

    private void addTwoHopAddress() {
        this.mLuTwoHopAddress.add("m.baidu.com");
        this.mLuTwoHopAddress.add("cpro.baidu.com");
        this.mLuTwoHopAddress.add("ada.baidu.com");
        this.mLuTwoHopAddress.add("mobads.php");
        this.mLuTwoHopAddress.add("baidu.php");
        this.mLuTwoHopAddress.add("uijs.php");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        this.mUserAutoFinish = true;
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
        }
        this.mProxyActivity.finish();
        stopAndRelease();
    }

    private void stopAndRelease() {
        if (this.videoView != null) {
            this.videoView.d();
        }
        if (this.floatingVideoLayout != null) {
            this.floatingVideoLayout.j();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
        if (this.videoView != null && this.mRlViewTop > -0.01f) {
            this.videoView.c();
        }
        if (this.floatingVideoLayout != null && this.floatingVideoLayout.getVisibility() == 0) {
            this.floatingVideoLayout.g();
        }
        if (this.mIsCpuLandingPage && this.curWebview != null) {
            this.curWebview.onResume();
        }
        this.mResumeTime = System.currentTimeMillis();
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onConfigurationChanged(Configuration configuration) {
        if ((this.mTmpExtraInfo != null && this.mTmpExtraInfo.u) || this.mIsFullScreenVideo) {
            this.mProxyActivity.getWindow().addFlags(1024);
        } else {
            this.mProxyActivity.getWindow().clearFlags(1024);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onRestoreInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void overridePendingTransition(int i, int i2) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setLpBussParam(JSONObject jSONObject) {
        if (jSONObject != null) {
            setActionBarColor(jSONObject.optInt("bar_close_color", -5987164), jSONObject.optInt("bar_title_color", -6842473), jSONObject.optInt("bar_pro_color", -11113262), jSONObject.optInt("bar_bg_color", -328966));
            canLpShowWhenLocked(jSONObject.optBoolean("showWhenLocked", false));
            this.mIsShowActionBarTit = jSONObject.optBoolean("isShowActionBarTit", true);
        }
    }

    private void setActionBarColor(int i, int i2, int i3, int i4) {
        this.mSActionBarColorTheme = new a(i, i2, i3, i4);
    }

    static class a {
        public int a;
        public int b;
        public int c;
        public int d;

        public a(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLpState(String str) {
        this.mLpFinishState = str;
    }

    private boolean runVideoAnimation(float f) {
        float f2;
        if (this.mVideoHeight <= 0 || !this.curWebview.c()) {
            return false;
        }
        if (f > 0.0f) {
            f2 = -this.mRlViewTop;
            this.mRlViewTop = 0.0f;
        } else if (f < 0.0f || this.mRlViewTop < this.mVideoHeight * (-0.25f)) {
            f2 = this.mVideoHeight + this.mRlViewTop;
            this.mRlViewTop = -this.mVideoHeight;
        } else {
            f2 = -this.mRlViewTop;
            this.mRlViewTop = 0.0f;
        }
        long j = (long) ((f2 * 200.0f) / this.mVideoHeight);
        if (j > 0) {
            this.mRlContainer.animate().setDuration(j).setInterpolator(this.mInterpolator).translationY(this.mRlViewTop);
        }
        if (this.mRlViewTop == 0.0f) {
            this.floatingClosed = false;
        }
        return j > 0;
    }

    private void switchVideoLayout(boolean z) {
        boolean zC;
        if (this.videoView != null && this.floatingVideoLayout != null) {
            if (z) {
                zC = this.videoView.e().c();
            } else {
                zC = this.floatingVideoLayout.c();
            }
            switchVideoLayout(z, zC);
            return;
        }
        if (this.videoView != null) {
            if (z) {
                this.videoView.b();
            } else {
                this.videoView.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchVideoLayout(boolean z, boolean z2) {
        if (this.videoView == null || this.floatingVideoLayout == null) {
            return;
        }
        if (z && this.floatingVideoLayout.getVisibility() == 4) {
            com.baidu.mobads.container.x.k kVarE = this.videoView.e();
            if (!kVarE.d() && !this.floatingClosed) {
                Bitmap bitmapA = kVarE.a();
                com.component.player.c cVarC = kVarE.c(true);
                this.floatingVideoLayout.setVisibility(0);
                this.floatingVideoLayout.a(cVarC);
                if (z2) {
                    this.floatingVideoLayout.g();
                    return;
                } else {
                    this.floatingVideoLayout.a(bitmapA);
                    this.floatingVideoLayout.f();
                    return;
                }
            }
            return;
        }
        if (!z && this.floatingVideoLayout.getVisibility() == 0) {
            Bitmap bitmapD = this.floatingVideoLayout.d();
            com.component.player.c cVarC2 = this.floatingVideoLayout.c(true);
            this.floatingVideoLayout.setVisibility(4);
            com.baidu.mobads.container.x.k kVarE2 = this.videoView.e();
            kVarE2.a(cVarC2);
            if (z2) {
                this.videoView.c();
            } else {
                kVarE2.a(bitmapD);
                this.videoView.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDisplayHeight() {
        if (this.mProxyActivity != null) {
            try {
                if (this.mProxyActivity.getRequestedOrientation() == 1) {
                    if (isNeedLpKeyboardOptimize()) {
                        int statusBarVisibleHeight = getStatusBarVisibleHeight(this.mProxyActivity);
                        return (com.baidu.mobads.container.util.ab.c(this.mProxyActivity) - statusBarVisibleHeight) - com.baidu.mobads.container.util.be.a(this.mAppContext);
                    }
                    return com.baidu.mobads.container.util.ab.c(this.mProxyActivity) - getStatusBarHeight(this.mAppContext);
                }
                return 0;
            } catch (Throwable th) {
                return 0;
            }
        }
        return 0;
    }

    private int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    private int getStatusBarVisibleHeight(Context context) {
        Resources resources;
        int identifier;
        try {
            if (((((Activity) context).getWindow().getAttributes().flags & 1024) == 0 || com.baidu.mobads.container.util.x.a(null).a() >= 28 || bg.a(context)) && (identifier = (resources = context.getResources()).getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
        } catch (Exception e) {
            this.mAdLogger.a(TAG, e.getMessage());
        }
        return 0;
    }

    private void parseCpuQueryParams(String str) {
        if (this.mIsCpuLandingPage && !TextUtils.isEmpty(str)) {
            try {
                Uri uri = Uri.parse(str);
                if ("cpu.baidu.com".equals(uri.getHost())) {
                    this.mIsCpuNativePreRender = "1".equals(uri.getQueryParameter("npr"));
                    this.mIsDarkModeStyle = ToastUtils.MODE.DARK.equals(uri.getQueryParameter("preferscolortheme"));
                    this.mCustomizedBar = uri.getQueryParameter("customizedBar");
                    this.mIsCpuShareRender = "1".equals(uri.getQueryParameter("shareRender"));
                }
            } catch (Throwable th) {
                this.mAdLogger.a(TAG, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stateEvent(String str) {
        if (!TextUtils.isEmpty(this.mAdUniqueId)) {
            com.baidu.mobads.container.components.h.d.a(this.mAdUniqueId, str, String.valueOf(System.currentTimeMillis() - com.baidu.mobads.container.components.h.d.c(this.mAdUniqueId, com.baidu.mobads.container.components.h.b.g)));
        }
    }

    private void stateEvent(String str, String str2) {
        if (!TextUtils.isEmpty(this.mAdUniqueId)) {
            com.baidu.mobads.container.components.h.d.a(this.mAdUniqueId, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stateEvent(com.baidu.mobads.container.components.h.a aVar) {
        if (!TextUtils.isEmpty(this.mAdUniqueId)) {
            com.baidu.mobads.container.components.h.d.a(this.mAdUniqueId, aVar);
        }
    }

    private void getAdUniqueId() {
        if (this.mTmpExtraInfo != null && this.mTmpExtraInfo.b != null) {
            this.mAdUniqueId = this.mTmpExtraInfo.b.getUniqueId();
            if (TextUtils.isEmpty(this.mAdUniqueId)) {
                this.mAdUniqueId = com.baidu.mobads.container.components.h.d.a(this.mTmpExtraInfo.b.getQueryKey());
            }
        }
    }

    private String parseAdBuyer(XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo) {
        com.baidu.mobads.container.adrequest.j jVarA;
        if (xAdRemoteLandingPageExtraInfo != null && (jVarA = xAdRemoteLandingPageExtraInfo.a()) != null) {
            return jVarA.getBuyer();
        }
        return "";
    }

    private void sendLpLifeCircleLog(String str) {
        try {
            if (this.mTmpExtraInfo != null && this.mTmpExtraInfo.a != null) {
                if ("rvideo".equals(this.mTmpExtraInfo.a) || "fvideo".equals(this.mTmpExtraInfo.a)) {
                    HashMap map = new HashMap();
                    if (this.mTmpExtraInfo != null && this.mTmpExtraInfo.a() != null) {
                        map.put("qk", this.mTmpExtraInfo.a().getQueryKey());
                        map.put("adId", this.mTmpExtraInfo.a().getAdId());
                        map.put("prod", this.mTmpExtraInfo.a);
                        try {
                            map.put(com.baidu.mobads.container.components.command.j.f, this.mTmpExtraInfo.a().getBuyer());
                            map.put("act", String.valueOf(this.mTmpExtraInfo.a().getActionType()));
                            map.put("curl", URLEncoder.encode(this.mTmpExtraInfo.e, "UTF-8"));
                        } catch (Exception e) {
                        }
                    }
                    map.put(Config.LAUNCH_INFO, str);
                    if (!TextUtils.isEmpty(this.mApid)) {
                        map.put("apid", this.mApid);
                    }
                    by.a(this.mProxyActivity, 703, (HashMap<String, String>) map);
                }
            }
        } catch (Exception e2) {
        }
    }

    private void sendLpBroadcast() {
        if (this.mProxyActivity != null) {
            Intent intent = new Intent();
            intent.setAction("lp_close");
            this.mProxyActivity.sendBroadcast(intent);
        }
    }

    private d dealWithPreloadedWebView() {
        d dVar = new d();
        this.mTrackingParams.put("preloaded", Long.valueOf(this.mIsPreloaded ? 1L : 0L));
        if (this.mIsPreloaded) {
            this.curWebview.onResume();
            if (this.actionBar != null && this.mIsShowActionBarTit) {
                this.actionBar.a(this.curWebview.getTitle());
            }
            com.baidu.mobads.container.y.c cVarA = this.curWebview.a();
            this.curWebview.b();
            if (cVarA != null) {
                if (cVarA.c != null) {
                    this.mBaiduJsInterface = cVarA.c;
                    this.mBaiduJsInterface.a(this);
                }
                c.a aVarA = cVarA.a(0);
                if (aVarA != null) {
                    this.mTrackingParams.put("prePageStart", Long.valueOf(aVarA.c));
                    this.mTrackingParams.put("prePageFinish", Long.valueOf(aVarA.d));
                    this.mTrackingParams.put("preSslError", Long.valueOf(aVarA.e));
                    if (aVarA.c > 0) {
                        dVar.b = aVarA.a;
                        dVar.a = cVarA.a;
                        dVar.d = false;
                        dVar.c = false;
                    }
                    if (aVarA.d > 0) {
                        dVar.b = "";
                        dVar.a = false;
                        dVar.d = true;
                        dVar.c = true;
                    }
                }
                if (!TextUtils.isEmpty(cVarA.b)) {
                    if (com.baidu.mobads.container.ax.h(cVarA.b)) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.parse(cVarA.b), SelectMimeType.SYSTEM_AUDIO);
                        this.curWebview.getContext().startActivity(intent);
                    } else if (com.baidu.mobads.container.ax.g(cVarA.b)) {
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setDataAndType(Uri.parse(cVarA.b), SelectMimeType.SYSTEM_VIDEO);
                        this.curWebview.getContext().startActivity(intent2);
                    } else {
                        bj.a(this.curWebview.getContext(), cVarA.b);
                    }
                }
            }
        }
        return dVar;
    }

    public long queryTrackingParams(String str, long j) {
        Long l;
        if (!TextUtils.isEmpty(str) && (l = this.mTrackingParams.get(str)) != null) {
            return l.longValue();
        }
        return j;
    }

    public void recordSchemes() {
    }
}
