package com.baidu.mobads.container.rewardvideo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.activity.b;
import com.baidu.mobads.container.rewardvideo.a;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.bs;
import com.baidu.mobads.container.util.k;
import com.baidu.mobads.sdk.api.IActivityImpl;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.component.a.g.a;
import com.component.a.g.c.aa;
import com.component.a.g.c.bm;
import com.component.a.g.c.br;
import com.component.a.g.c.bx;
import com.component.a.g.c.m;
import com.component.a.g.g;
import com.component.interfaces.RemoteReflectInterface;
import com.sigmob.windad.WindAds;
import com.style.widget.viewpager2.PageItem;
import com.style.widget.viewpager2.State;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class NativeRewardActivity implements IActivityImpl, IOAdEventListener {
    private static final long P = 100;
    public static final String REWARD_SERVICE_URL = "https://cpu-openapi.baidu.com/api/bes/s";
    public static final String SCREEN_LANDSCAPE = "landscape";
    public static final String SCREEN_PORTRAIT = "portrait";
    protected static final String TAG = "RemoteRewardActivity";
    protected static final int UPDATE_INTERVAL = 100;
    private static final int V = 3;
    private static final int W = 5;
    private static final long bf = System.currentTimeMillis();
    private static final String d = "skiptime";
    private static final String e = "end_frame";
    private static final String f = "rs_id";
    private static final long g = 2000;
    public static boolean mVideoPlaying;
    private View A;
    private final Handler B;
    private double C;
    private String D;
    private String E;
    private boolean F;
    private boolean G;
    private boolean H;
    private float I;
    private boolean J;

    /* renamed from: K, reason: collision with root package name */
    private String f738K;
    private com.baidu.mobads.container.util.bq L;
    private com.baidu.mobads.container.bridge.i M;
    private final com.baidu.mobads.container.v.d N;
    private String O;
    private boolean Q;
    private int R;
    private int S;
    private boolean T;
    private String U;
    private String X;
    private int Y;
    private String Z;
    ObjectAnimator a;
    private com.component.a.a.d aA;
    private com.component.a.a.f aB;
    private View aC;
    private com.component.a.a.b aD;
    private View aE;
    private com.baidu.mobads.container.d.a aF;
    private int aG;
    private int aH;
    private int aI;
    private boolean aJ;
    private int aK;
    private int aL;
    private boolean aM;
    private View aN;
    private int aO;
    private int aP;
    private int aQ;
    private Handler aR;
    private TextView aS;
    private View aT;
    private boolean aU;
    private int aV;
    private int aW;
    private boolean aX;
    private int aY;
    private int aZ;
    private String aa;
    private com.baidu.mobads.container.components.i.a ab;
    private com.component.a.g.d ac;
    private a.C0132a ad;
    private PageItem ae;
    private boolean af;
    private String ag;
    private int ah;
    private boolean ai;
    private View aj;
    private TextView ak;
    private String al;
    private TextView am;
    private TextView an;
    private com.baidu.mobads.container.s.ab ao;
    private br.a ap;
    private aa.c aq;
    private aa.a ar;
    private aa.b as;
    private String at;
    private String au;
    private com.component.a.a.d av;
    private com.component.a.d.c aw;
    private com.component.a.a.q ax;
    private List<aa.j> ay;
    private m.a az;
    com.baidu.mobads.container.bridge.ao b;
    private View ba;
    private final Map<Integer, String> bb;
    private final StringBuffer bc;
    private final StringBuffer bd;
    private final StringBuffer be;
    private com.component.a.b.e bg;
    private boolean bh;
    private final e bi;
    private final d bj;
    private Runnable bk;
    private Runnable bl;
    private long bm;
    Runnable c;
    protected boolean clickedBeforeJumpedOut;
    protected RelativeLayout fatherOfFullScreen;
    private boolean h;
    protected boolean hasCurrentPageEverBeenResumed;
    private com.baidu.mobads.container.ax i;
    protected boolean isCurrentPageResumed;
    protected boolean isCurrentPageSelected;
    private ImageView j;
    private RelativeLayout k;
    private boolean l;
    private RelativeLayout m;
    protected Activity mActivity;
    protected final com.baidu.mobads.container.activity.b mActivityLifecycle;
    protected final com.baidu.mobads.container.adrequest.t mAdContainerCxt;
    protected com.baidu.mobads.container.adrequest.j mAdInstanceInfo;
    protected Context mAppContext;
    protected int mCurrentRewardMode;
    protected g mDialogManager;
    protected com.baidu.mobads.container.components.command.b mDownloadStateChangeListener;
    protected int mDuration;
    protected com.component.a.a.f mEggLottieView;
    protected int mIsShowRewardCountdownTips;
    protected com.baidu.mobads.container.s.ab mNativeShakeView;
    protected m.b mRewardCountdownView;
    protected int mRewardMode;
    protected int mRewardTime;
    protected View mRootTemplateView;
    protected boolean mSegReward;
    protected AtomicBoolean mSendImpressionLog;
    protected dq mSharedMediator;
    protected com.component.a.d.c mSharedParent;
    protected View mSkipView;
    protected boolean mTimingReward;
    private boolean n;
    private int o;
    private int p;
    private View q;
    private int r;
    private View s;
    protected String showAdType;
    private ViewGroup t;
    private Bitmap u;
    private boolean v;
    private boolean w;
    private com.component.player.c x;
    private Map<String, WeakReference<com.baidu.mobads.container.components.command.b>> y;
    private boolean z;

    public NativeRewardActivity(com.baidu.mobads.container.adrequest.t tVar) {
        this.h = false;
        this.l = false;
        this.n = false;
        this.o = 0;
        this.p = 0;
        this.r = 0;
        this.v = false;
        this.w = false;
        this.y = new HashMap();
        this.B = new Handler();
        this.mSendImpressionLog = new AtomicBoolean(false);
        this.G = false;
        this.H = false;
        this.J = true;
        this.L = com.baidu.mobads.container.util.bq.a();
        this.O = SCREEN_PORTRAIT;
        this.R = 0;
        this.S = 0;
        this.T = false;
        this.U = "";
        this.Y = 3;
        this.af = false;
        this.ag = "";
        this.ah = 7;
        this.ai = false;
        this.al = "倒计时%秒";
        this.ay = new ArrayList();
        this.aG = 0;
        this.aH = 0;
        this.aI = 0;
        this.aJ = false;
        this.mRewardTime = 30000;
        this.aK = 30000;
        this.aL = 30000;
        this.aM = true;
        this.mRewardMode = 0;
        this.mCurrentRewardMode = 0;
        this.mSegReward = false;
        this.mTimingReward = false;
        this.mActivityLifecycle = new com.baidu.mobads.container.activity.b();
        this.hasCurrentPageEverBeenResumed = false;
        this.isCurrentPageSelected = false;
        this.clickedBeforeJumpedOut = false;
        this.mIsShowRewardCountdownTips = 0;
        this.aO = 0;
        this.aP = 0;
        this.aQ = 500;
        this.aR = new Handler();
        this.aU = false;
        this.aV = 1;
        this.aW = 1;
        this.aX = false;
        this.aY = -1;
        this.aZ = 0;
        this.showAdType = "video";
        this.bb = new HashMap();
        this.bc = new StringBuffer();
        this.bd = new StringBuffer();
        this.be = new StringBuffer();
        this.bh = false;
        this.b = new y(this);
        this.bi = new e();
        this.bj = new d();
        this.bk = null;
        this.bl = null;
        this.c = new bd(this);
        this.bm = 0L;
        this.mAdContainerCxt = tVar;
        this.N = new com.baidu.mobads.container.v.d(this.mAdContainerCxt);
        this.X = this.mAdContainerCxt.z();
        this.mAdInstanceInfo = this.mAdContainerCxt.q();
        this.mActivityLifecycle.a(new c(this, null));
    }

    public NativeRewardActivity(com.baidu.mobads.container.adrequest.t tVar, PageItem pageItem) {
        this(tVar);
        this.ae = pageItem;
        this.ai = true;
        this.mActivity = tVar.u();
        if (this.mActivity != null) {
            this.mActivityLifecycle.a(this.mActivity);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        if (activity != null && activity != this.mActivity) {
            this.mActivityLifecycle.c();
            this.mActivityLifecycle.a(activity);
        }
        this.mActivity = activity;
        if (this.mAdContainerCxt != null) {
            this.mAdContainerCxt.a(this.mActivity);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        mVideoPlaying = true;
        if (this.mActivity == null) {
            return;
        }
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.O = intent.getStringExtra("orientation");
            if (TextUtils.isEmpty(this.O)) {
                this.O = SCREEN_PORTRAIT;
            }
            this.Q = intent.getBooleanExtra("useSurfaceView", false);
            this.G = intent.getBooleanExtra("showDialogOnSkip", false);
            this.Y = intent.getIntExtra("downloadConfirmPolicy", 3);
            this.Z = intent.getStringExtra("userid");
            this.aa = intent.getStringExtra("extra");
            g();
        }
        c();
        h();
        y();
        if (!this.ai) {
            initScreenConfiguration(this.mActivity);
            if (com.baidu.mobads.container.util.bv.j(this.mActivity) && this.O.equals(SCREEN_PORTRAIT)) {
                this.mActivity.setContentView(com.baidu.mobads.container.util.bv.a(this.mActivity, this.fatherOfFullScreen, false));
            } else {
                this.mActivity.setContentView(this.fatherOfFullScreen);
            }
        }
    }

    private class c extends b.a {
        private c() {
        }

        /* synthetic */ c(NativeRewardActivity nativeRewardActivity, i iVar) {
            this();
        }

        @Override // com.baidu.mobads.container.activity.b.a
        public void onActivityResumed(com.baidu.mobads.container.activity.b bVar) {
            NativeRewardActivity.this.a(1, new Object[0]);
        }

        @Override // com.baidu.mobads.container.activity.b.a
        public void onActivityStopped(com.baidu.mobads.container.activity.b bVar) {
            NativeRewardActivity.this.a(2, new Object[0]);
        }
    }

    public RelativeLayout getRootView() {
        return this.fatherOfFullScreen;
    }

    public void setSharedItemMediator(dq dqVar) {
        this.mSharedMediator = dqVar;
        this.mSharedParent = this.mSharedMediator.e;
        if (isFirstPage()) {
            this.mSharedMediator.g = this.bi;
        }
    }

    public void setRewardItemAdCallback(a.C0132a c0132a) {
        this.ad = c0132a;
    }

    protected boolean isFirstPage() {
        return this.ae == null || this.ae.getPageIndex() == 0;
    }

    protected boolean isLastPage() {
        return this.ae == null || this.ae.getPageIndex() == this.ae.getPageCount() - 1;
    }

    protected int getPageIndex() {
        if (this.ae != null) {
            return this.ae.getPageIndex();
        }
        return -1;
    }

    public void onPageSelected(int i) {
        this.isCurrentPageSelected = this.ae != null && this.ae.getPageIndex() == i;
        if (this.F && this.ae != null && this.ae.getPageIndex() != i) {
            clearSlideGuideAnim();
            J();
        }
    }

    private void b() {
        if (!this.hasCurrentPageEverBeenResumed) {
            this.hasCurrentPageEverBeenResumed = true;
            e(this.r);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
        a(com.component.a.g.b.b.h);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
        c(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        this.isCurrentPageResumed = false;
        videoPause(this.ah, i);
        this.ah = 7;
        this.aM = false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
        this.aM = false;
        a(com.component.a.g.b.b.g);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
        this.isCurrentPageResumed = true;
        b();
        a(true);
        if (!this.H) {
            try {
                videoResume();
                o();
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.f(th.getMessage());
            }
        }
        this.aM = true;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        if (this.ar != null) {
            this.ar.k();
            return true;
        }
        return true;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        this.aR.removeCallbacksAndMessages(null);
        mVideoPlaying = false;
        p();
        if (this.i != null) {
            this.i.destroy();
            this.i = null;
        }
        if (this.x != null) {
            this.x.e();
            this.x = null;
        }
        if (this.fatherOfFullScreen != null) {
            this.fatherOfFullScreen.removeAllViews();
        }
        setActivity(null);
        this.aM = false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
        this.L.b(TAG, "onWindowFocusChanged" + z);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.L.b(TAG, "onTouchEvent");
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
    public void onAttachedToWindow() {
        this.L.b(TAG, "onAttachedToWindow");
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
        mVideoPlaying = false;
        this.L.b(TAG, "onDetachedFromWindow");
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    private void c() {
        this.mAppContext = this.mActivity.getApplicationContext();
        this.fatherOfFullScreen = new RelativeLayout(this.mAppContext);
        this.N.setAdContainerView(this.mAdInstanceInfo.getUniqueId(), this.fatherOfFullScreen);
        this.fatherOfFullScreen.removeAllViews();
        this.fatherOfFullScreen.setLayoutParams(f());
        this.fatherOfFullScreen.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout = new RelativeLayout(this.mActivity);
        relativeLayout.setLayoutParams(this.fatherOfFullScreen.getLayoutParams());
        relativeLayout.setBackgroundColor(-16777216);
        this.fatherOfFullScreen.addView(relativeLayout);
        this.aN = new View(this.mAppContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
        this.aN.setVisibility(4);
        this.aN.setOnClickListener(new i(this));
        this.fatherOfFullScreen.addView(this.aN, layoutParams);
        this.D = this.mAdInstanceInfo.getVideoUrl();
        this.f738K = this.mAdContainerCxt.k();
        try {
            JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
            if (originJsonObject != null) {
                this.U = originJsonObject.optString(e, "");
                if (m()) {
                    this.r = 5;
                }
                if (originJsonObject.has(d)) {
                    this.r = originJsonObject.optInt(d, this.r);
                }
                if (originJsonObject.has(f)) {
                    this.S = originJsonObject.optInt(f, 0);
                }
                this.ab = new com.baidu.mobads.container.components.i.a(this.mAppContext, originJsonObject);
                this.ag = originJsonObject.optString(com.baidu.mobads.container.components.command.j.L);
            }
            this.z = "true".equals(this.mAdInstanceInfo.getMute());
        } catch (Throwable th) {
        }
        this.mAdContainerCxt.s().addEventListener(com.baidu.mobads.container.components.k.b.F, this);
        this.bg = new ac(this, "ad");
        ap apVar = new ap(this);
        this.bg.a("pause_video", apVar);
        this.bg.a("resume_video", apVar);
        initVideoView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.component.a.b.j jVar) {
        a(jVar, (com.component.a.b.o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.component.a.b.j jVar, com.component.a.b.o oVar) {
        if (this.bg != null) {
            this.bg.a(jVar, oVar);
        }
    }

    private boolean d() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return com.baidu.mobads.container.v.c.a;
    }

    private RelativeLayout.LayoutParams f() {
        int iC;
        int iB;
        if (this.O.equals(SCREEN_PORTRAIT)) {
            iC = com.baidu.mobads.container.util.ab.b(this.mActivity);
            iB = com.baidu.mobads.container.util.ab.c(this.mActivity);
        } else if (!this.O.equals(SCREEN_LANDSCAPE)) {
            iC = 0;
            iB = 0;
        } else {
            iC = com.baidu.mobads.container.util.ab.c(this.mActivity);
            iB = com.baidu.mobads.container.util.ab.b(this.mActivity);
        }
        return new RelativeLayout.LayoutParams(iC, iB);
    }

    private void g() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        com.baidu.mobads.container.util.h.a(this.mActivity);
        if (com.baidu.mobads.container.util.x.a(this.mAppContext).a() > 26) {
            if (this.O.equals(SCREEN_PORTRAIT)) {
                this.mActivity.setRequestedOrientation(1);
            } else if (this.O.equals(SCREEN_LANDSCAPE)) {
                this.mActivity.setRequestedOrientation(0);
            }
        }
    }

    protected void initVideoView() {
        this.mSendImpressionLog.set(false);
        this.x = new com.component.player.c(this.mAppContext);
        this.x.a(new ba(this));
        this.x.setId(com.baidu.mobads.container.util.cf.a());
        this.x.a(new be(this));
    }

    protected void onInitializeComponents(int i) {
        int i2;
        if (this.mEggLottieView != null && (this.ad == null || this.ad.a() || !this.ad.b())) {
            this.mEggLottieView.c(30000.0f / Math.min(getUserRewardTime(), i));
            this.mEggLottieView.f();
        }
        if (this.mRewardCountdownView != null) {
            if (this.ad != null && !this.ad.a()) {
                this.mSegReward = false;
                this.mRewardCountdownView.b(this.ad.b());
            }
            if (this.mSegReward) {
                this.mRewardCountdownView.a(new bf(this));
                i2 = 2;
            } else {
                i = getUserRewardTime();
                i2 = 1;
            }
            this.mRewardCountdownView.a(i, getUserRewardTime(), i2);
            this.mRewardCountdownView.e();
        }
    }

    private void a(boolean z) {
        if (this.bh) {
            return;
        }
        this.bh = true;
        if (z) {
            sendRVideoLog(1);
        } else {
            sendRVideoLog(2);
        }
    }

    private void h() {
        if (this.mAdInstanceInfo != null) {
            try {
                this.L.b(TAG, "startRender");
                this.mDialogManager = new g();
                this.mDialogManager.a(new bg(this));
                this.ac = new com.component.a.g.d(this.N, this.mAdInstanceInfo);
                a.C0317a c0317a = new a.C0317a();
                c0317a.a(this.bg);
                c0317a.a(com.component.a.g.b.c.b, new bh(this));
                c0317a.a(true, (bx.a) null);
                c0317a.a(true, new bm.a());
                c0317a.a(new bi(this, this.N, this.mAdInstanceInfo));
                com.component.a.e.d.b bVarOnAdjustAdapterParams = onAdjustAdapterParams(c0317a);
                this.ac.a(c0317a);
                JSONObject optimizedTemplateJson = getOptimizedTemplateJson(this.ac, bVarOnAdjustAdapterParams);
                com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.b.a.l, new com.component.a.f.e(optimizedTemplateJson).l(""));
                com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_START);
                this.mRootTemplateView = this.ac.a(this.fatherOfFullScreen, optimizedTemplateJson, new j(this));
                if (this.q != null && this.aU) {
                    this.aT = this.N.createPxCloseView(this.q, this.aV, this.aW, new t(this));
                    a(this.aT, 8);
                }
                if (this.mRootTemplateView == null) {
                    com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_FAILED);
                    processAdError(com.baidu.mobads.container.c.a.RENDER_PROCESS_FAILED, "激励视频渲染异常，请检查模板内容");
                    a(false);
                } else {
                    com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_SUCCESS);
                    onNativeRenderComplete(this.mRootTemplateView);
                    if (this.i != null && this.ao != null) {
                        this.ao.a(this.i);
                    }
                }
            } catch (Throwable th) {
                processAdError(com.baidu.mobads.container.c.a.RENDER_PROCESS_FAILED, "激励视频渲染异常，请检查模板内容");
                a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.component.a.f.d dVar) {
        String strJ;
        if (dVar == null) {
            strJ = "";
        } else {
            strJ = dVar.j();
        }
        if (!this.aX && this.aU && dVar != null && "close_view".equals(strJ)) {
            dVar.a("pixel_click_view", "pixel_click_view");
            dVar.a(4);
            a(view, false, dVar);
        } else {
            if ("coupon_float_close_view".equals(strJ)) {
                if (this.aE != null) {
                    com.baidu.mobads.container.util.cf.b(this.aE);
                    return;
                }
                return;
            }
            d(a(dVar, "close_type", 0));
        }
    }

    protected com.component.a.e.d.b onAdjustAdapterParams(a.C0317a c0317a) {
        return new com.component.a.e.d.b(false);
    }

    protected void onViewCreate(View view, String str, String str2) {
    }

    protected void onNativeRenderComplete(View view) {
        if (this.mSharedMediator != null) {
            this.mSharedMediator.c(view);
        }
        com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_START);
    }

    protected void onDialogShow(View view) {
        if (view == null) {
            return;
        }
        if (this.mSharedMediator == null || !this.mSharedMediator.d(view)) {
            if (view == this.k) {
                c(3);
            } else {
                c(2);
            }
        }
    }

    protected void onDialogDismiss(View view) {
        State stateB;
        if (view == null) {
            return;
        }
        if (this.mSharedMediator == null || !this.mSharedMediator.e(view)) {
            if (this.ae != null) {
                stateB = this.ae.getLifecycle().getCurrentState();
            } else {
                stateB = this.mActivityLifecycle.b();
            }
            if (stateB.isAtLeast(State.RESUMED)) {
                onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    private boolean a(View view) {
        if (view == null) {
            return false;
        }
        view.setVisibility(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.l && this.k != null) {
            this.k.setVisibility(8);
            this.l = false;
        }
        if (this.n && this.m != null) {
            this.m.setVisibility(4);
            this.n = false;
        }
        if (this.aq != null) {
            this.aq.k();
        }
        if (this.ar != null) {
            this.ar.k();
        }
        Iterator<aa.j> it = this.ay.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        a(this.q, 0);
        a(this.aT, 0);
        a(this.aS, 4);
    }

    protected void showSkipView() {
        a(this.mSkipView, 0);
        controlSkipViewLevel();
    }

    protected void controlSkipViewLevel() {
        if (this.aO == 1) {
            this.mSkipView.bringToFront();
        }
    }

    protected void dismissSkipView() {
        a(this.mSkipView, 8);
        if (this.aF != null) {
            this.aF.a_();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.component.a.f.d dVar, String str, int i) {
        if (dVar != null) {
            return a(dVar.f(), str, i);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.component.a.f.e eVar, String str, int i) {
        JSONObject jSONObjectC;
        if (eVar != null && (jSONObjectC = eVar.c()) != null) {
            return jSONObjectC.optInt(str, i);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (i == 1 && !isLastPage()) {
            this.n = a(this.m);
        } else {
            handleCloseAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, int i) {
        if (this.mSharedMediator == null || !this.mSharedMediator.a(view, i)) {
            a(i);
        }
    }

    void a(int i) {
        switch (i) {
            case 0:
                if (!this.T) {
                    this.l = a(this.k);
                    break;
                } else {
                    q();
                    break;
                }
            case 1:
                q();
                break;
            case 2:
                handleCloseAd();
                break;
            default:
                if (!this.T && this.G) {
                    this.l = a(this.k);
                    break;
                } else {
                    q();
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (TextUtils.isEmpty(str) || this.mActivity == null) {
            return;
        }
        com.style.widget.b.i iVarA = com.style.widget.b.i.a(this.mActivity, str);
        iVarA.a(true);
        iVarA.a(new u(this));
        iVarA.a();
    }

    public void registerDownloadListeners(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null && com.baidu.mobads.container.components.k.b.u.equals(iOAdEvent.getType())) {
            try {
                String message = iOAdEvent.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    this.y = com.baidu.mobads.container.b.c.a().b();
                    if (this.y != null && this.y.size() > 0) {
                        for (String str : this.y.keySet()) {
                            if (str.contains(message) && this.y.get(str) != null && this.y.get(str).get() != null) {
                                this.y.get(str).get().a();
                                a(4, message);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                this.L.a(th);
            }
        }
    }

    private void a(WebView webView) {
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setDownloadListener(new v(this));
        webView.setWebViewClient(new w(this));
        this.M = new com.baidu.mobads.container.v.b(this.N, webView, this.b, this.mAdContainerCxt);
        String intHtmlSnippet = this.mAdContainerCxt.q().getIntHtmlSnippet();
        if (!webView.getSettings().getJavaScriptEnabled()) {
            com.baidu.mobads.container.l.g.b().e("JavaScriptEnabled被禁用，尾帧交互可能存在问题，建议媒体开启");
        }
        if (TextUtils.isEmpty(intHtmlSnippet)) {
            com.baidu.mobads.container.l.g.b().e("广告物料异常：无尾帧素材");
        }
        if (A()) {
            webView.loadUrl(this.U);
        } else {
            webView.loadDataWithBaseURL(null, intHtmlSnippet, "text/html", "UTF-8", null);
        }
        com.baidu.mobads.container.l.g.b().c("尾帧视图创建成功");
        if (A()) {
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.aN != null) {
            com.baidu.mobads.container.util.h.a(new x(this));
        }
    }

    private boolean k() {
        JSONObject originJsonObject;
        if (!ab.a.APP_DOWNLOAD.equals(com.baidu.mobads.container.util.ab.a(this.mAppContext, this.mAdInstanceInfo)) || (originJsonObject = this.mAdInstanceInfo.getOriginJsonObject()) == null || a("dl_desc", 1) == 0) {
            return false;
        }
        return (TextUtils.isEmpty(originJsonObject.optString(com.baidu.mobads.container.components.command.j.I)) || TextUtils.isEmpty(originJsonObject.optString("app_version")) || TextUtils.isEmpty(originJsonObject.optString("privacy_link")) || TextUtils.isEmpty(originJsonObject.optString(com.baidu.mobads.container.components.command.j.L))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.x == null) {
            return;
        }
        if (this.z) {
            this.x.b(true);
            com.component.b.a.a().a(this.j, "ic_white_voice_mute");
        } else {
            this.x.b(false);
            com.component.b.a.a().a(this.j, "ic_white_voice");
        }
    }

    private boolean m() {
        return "fvideo".equals(this.f738K);
    }

    protected void startTimer() {
        this.B.removeCallbacksAndMessages(null);
        if (!this.B.hasCallbacks(this.bi)) {
            this.B.postDelayed(this.bi, 0L);
        }
        if (!this.B.hasCallbacks(this.bj)) {
            this.B.postDelayed(this.bj, 0L);
        }
    }

    protected void stopTimer() {
        stopTimer(false);
    }

    protected void stopTimer(boolean z) {
        if (z) {
            this.B.removeCallbacks(this.bi);
        } else {
            this.B.removeCallbacksAndMessages(null);
        }
    }

    private void n() {
        if (this.mNativeShakeView != null) {
            this.mNativeShakeView.j();
        }
        if (this.ao != null) {
            this.ao.j();
        }
        if (this.aD != null) {
            this.aD.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.mNativeShakeView != null && this.mNativeShakeView.b() && this.mNativeShakeView.getVisibility() == 0 && this.isCurrentPageResumed && this.J && this.F && !this.l) {
            this.mNativeShakeView.i();
        }
        if (this.ao != null && this.ao.b() && this.ao.getVisibility() == 0 && this.isCurrentPageResumed && this.x == null && this.i != null && !this.n) {
            this.ao.i();
        }
        if (this.aD != null && this.aD.getVisibility() == 0 && this.isCurrentPageResumed && this.J && this.F && !this.l) {
            this.aD.d();
        }
    }

    private void p() {
        if (this.mNativeShakeView != null) {
            this.mNativeShakeView.m();
        }
        if (this.ao != null) {
            this.ao.m();
        }
        if (this.aD != null) {
            this.aD.f();
        }
    }

    protected void handleCloseAd() {
        p();
        a(this.mActivity, false);
        stopTimer();
        J();
        K();
        mVideoPlaying = false;
        if (this.x != null) {
            com.baidu.mobads.container.util.ce.a(v(), this.C, this.mAdInstanceInfo, this.mAdContainerCxt, 0, 6);
        }
        sendRVideoLog(7);
        HashMap map = new HashMap();
        map.put("play_scale", Float.valueOf(this.I));
        this.mAdInstanceInfo.setCloseTrackers(new ArrayList());
        if (this.ad == null || !this.ad.b(this.mAdInstanceInfo, this.I)) {
            this.mAdContainerCxt.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.E, (HashMap<String, Object>) map));
        }
        com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId());
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        sendRVideoLog(15);
        if (this.ad == null || !this.ad.a(this.mAdInstanceInfo, this.I)) {
            this.mAdContainerCxt.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.m, "" + this.I));
        }
        if (this.x != null) {
            com.baidu.mobads.container.util.ce.a(v(), this.C, this.mAdInstanceInfo, this.mAdContainerCxt, 0, 6);
        }
        addEndPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.ad != null) {
            this.ad.d(this.mAdInstanceInfo);
        }
        b(false);
    }

    public void videoPause(int i, int i2) {
        n();
        stopTimer(this.mTimingReward && i2 == 2);
        if (this.x != null && this.J) {
            this.x.b();
            com.baidu.mobads.container.util.ce.a(v(), this.C, this.mAdInstanceInfo, this.mAdContainerCxt, 0, i);
            this.C = v();
            if (this.mEggLottieView != null) {
                this.mEggLottieView.t();
            }
            if (this.mRewardCountdownView != null) {
                this.mRewardCountdownView.g();
            }
        }
    }

    public void videoResume() {
        this.isCurrentPageResumed = true;
        b(true);
        if (this.x != null && this.J) {
            if (this.v) {
                t();
            } else {
                s();
            }
        }
    }

    private void s() {
        this.x.c();
        if (this.F) {
            startTimer();
        }
        com.baidu.mobads.container.util.ce.a(this.mAdInstanceInfo, this.mAdContainerCxt, 0, v());
        if (this.mEggLottieView != null) {
            com.component.a.i.f fVarA = com.component.a.i.f.a((View) this.mEggLottieView);
            if ((fVarA != null && fVarA.h() == 3) || this.mEggLottieView.w() >= 1.0f) {
                return;
            }
            this.mEggLottieView.g();
        }
    }

    private void t() {
        if (this.t != null && this.x != null && !this.w) {
            a(this.t, (Bitmap) null, -1);
            this.x.c();
            com.baidu.mobads.container.util.ce.a(this.mAdInstanceInfo, this.mAdContainerCxt, 0, v());
        }
    }

    private int u() {
        if (this.x == null) {
            return 0;
        }
        return this.x.g() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double v() {
        if (this.x == null) {
            return 0.0d;
        }
        double dG = this.x.g();
        Double.isNaN(dG);
        return dG / 1000.0d;
    }

    protected void videoPlayCompletion() {
        if (this.ad == null || !this.ad.c(this.mAdInstanceInfo)) {
            this.mAdContainerCxt.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.I));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TranslateAnimation b(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, view.getMeasuredHeight(), 0.0f);
        translateAnimation.setDuration(P);
        translateAnimation.setInterpolator(new LinearInterpolator());
        return translateAnimation;
    }

    public static void initScreenConfiguration(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().setFormat(-2);
            if (com.baidu.mobads.container.util.x.a(activity).a() > 22) {
                activity.getWindow().requestFeature(1);
                activity.getWindow().addFlags(128);
                activity.getWindow().addFlags(1024);
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } catch (Throwable th) {
            com.baidu.mobads.container.util.bq.a().a(TAG, "exception when requestWindowFeature");
        }
    }

    private void a(Activity activity, boolean z) {
        if (activity == null) {
            return;
        }
        if (z) {
            activity.getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } else {
            activity.getWindow().getDecorView().setSystemUiVisibility(2048);
        }
    }

    protected int getCurrentTimeMillis() {
        if (this.x != null) {
            return this.x.g();
        }
        return this.mDuration;
    }

    protected int getUserRewardTime() {
        if (this.ai && this.ad != null) {
            if (this.ad.a()) {
                if (this.aL == -1) {
                    return this.mDuration;
                }
                return Math.min(this.aL, this.mDuration);
            }
            if (this.aK == -1) {
                return 30000;
            }
            return this.ad.d();
        }
        if (this.mRewardTime == -1) {
            return this.mDuration;
        }
        return Math.min(this.mRewardTime, this.mDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float w() {
        return getUserRewardTime() * 0.9f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        return (this.ad == null || this.ad.a()) ? false : true;
    }

    static class a {
        final Map<Runnable, Integer> a = new ConcurrentHashMap();
        long b = -200;

        a() {
        }

        public void a(Runnable runnable, int i) {
            this.a.put(runnable, Integer.valueOf(i));
        }

        public void a(Runnable runnable) {
            this.a.remove(runnable);
        }

        protected void a(int i, int i2) {
            if (i2 <= 0) {
                return;
            }
            for (Runnable runnable : this.a.keySet()) {
                Integer num = this.a.get(runnable);
                int iIntValue = num != null ? num.intValue() : -1;
                if (iIntValue >= 0 && (i >= iIntValue || i >= i2)) {
                    this.a.put(runnable, -1);
                    runnable.run();
                }
            }
        }
    }

    class e extends a implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NativeRewardActivity.this.ak == null && NativeRewardActivity.this.an == null && NativeRewardActivity.this.am == null) {
                return;
            }
            int iMin = Math.min(NativeRewardActivity.this.getCurrentTimeMillis(), NativeRewardActivity.this.mDuration);
            if (iMin - this.b >= 200) {
                this.b += 200;
                NativeRewardActivity.this.a(com.component.a.g.b.b.e, new com.component.a.b.o().b("timer", Long.valueOf(this.b)));
            }
            a(iMin, NativeRewardActivity.this.mDuration);
            if (NativeRewardActivity.this.az != null && NativeRewardActivity.this.az.i()) {
                NativeRewardActivity.this.az.b(iMin);
            }
            if (iMin < NativeRewardActivity.this.mDuration) {
                NativeRewardActivity.this.B.postDelayed(NativeRewardActivity.this.bi, NativeRewardActivity.P);
            } else {
                NativeRewardActivity.this.onTimeUp();
            }
            if (NativeRewardActivity.this.mDuration > 0) {
                NativeRewardActivity.this.I = (iMin * 1.0f) / NativeRewardActivity.this.mDuration;
            }
            float fA = com.baidu.mobads.container.util.ab.a(NativeRewardActivity.this.I);
            if (fA >= 0.0f) {
                NativeRewardActivity.this.I = fA;
            }
        }
    }

    class d extends a implements Runnable {
        int c = 0;
        int d = 0;

        d() {
        }

        private int a() {
            if (NativeRewardActivity.this.x()) {
                int iC = NativeRewardActivity.this.ad.c();
                NativeRewardActivity.this.ad.a(iC + 100);
                return iC;
            }
            if (NativeRewardActivity.this.x != null) {
                int iG = NativeRewardActivity.this.x.g();
                if (iG - this.c >= 100) {
                    this.c = iG;
                } else {
                    this.c += 100;
                }
            } else {
                this.c += 100;
            }
            return this.c;
        }

        public void a(int i) {
            if (NativeRewardActivity.this.x()) {
                NativeRewardActivity.this.ad.a(Math.min(NativeRewardActivity.this.getUserRewardTime(), NativeRewardActivity.this.ad.c() + i));
            } else {
                this.d += i;
            }
        }

        private int b(int i) {
            if (NativeRewardActivity.this.x()) {
                return Math.min(NativeRewardActivity.this.getUserRewardTime(), i);
            }
            return Math.min(i + this.d, NativeRewardActivity.this.mDuration);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NativeRewardActivity.this.ak == null && NativeRewardActivity.this.an == null && NativeRewardActivity.this.am == null) {
                return;
            }
            int iMin = Math.min(a(), NativeRewardActivity.this.mDuration);
            int iB = b(iMin);
            a(iB, NativeRewardActivity.this.mDuration);
            int iMax = Math.max(0, NativeRewardActivity.this.getUserRewardTime() - iB);
            if (NativeRewardActivity.this.mDuration > 0) {
                int i = iB + 100;
                if (NativeRewardActivity.this.ad == null || !NativeRewardActivity.this.ad.a(i, iMax)) {
                    NativeRewardActivity.this.onUserRewardTimeUpdate(i, iMax);
                }
            }
            if (iMin < NativeRewardActivity.this.mDuration) {
                NativeRewardActivity.this.B.postDelayed(NativeRewardActivity.this.bj, NativeRewardActivity.P);
            }
            if ((NativeRewardActivity.this.mRewardCountdownView == null || !NativeRewardActivity.this.mSegReward) && iB >= NativeRewardActivity.this.w()) {
                NativeRewardActivity.this.rewardVerify();
            }
        }
    }

    protected void onUserRewardTimeUpdate(int i, int i2) {
        if (this.mRewardCountdownView != null) {
            this.mRewardCountdownView.b(i);
        }
        if (i2 >= 0 && (this.mSharedMediator == null || !this.mSharedMediator.a(i, i2))) {
            b(i2);
        }
        if (i2 <= 0) {
            if (this.mIsShowRewardCountdownTips == 1) {
                if (this.an != null) {
                    this.an.setText("已领取奖励");
                }
                if (this.ak != null) {
                    this.ak.setText("已领取奖励");
                    return;
                }
                return;
            }
            if (this.an != null) {
                this.an.setVisibility(8);
            }
            if (this.aj != null) {
                this.aj.setVisibility(8);
            }
        }
    }

    protected void onTimeUp() {
        if (this.mSharedMediator != null) {
            this.mSharedMediator.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, WebView webView) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            com.baidu.mobads.container.util.bj.a(webView.getContext(), str);
        } else if (str.startsWith(com.baidu.mobads.container.util.o.e(com.baidu.mobads.container.i.b.a))) {
            webView.loadUrl(str);
        } else {
            this.ah = 4;
            com.baidu.mobads.container.adrequest.j jVarQ = this.mAdContainerCxt.q();
            jVarQ.setClickThroughUrl(str);
            jVarQ.setActionType(1);
            new com.baidu.mobads.container.components.k.c().a((com.baidu.mobads.container.k) this.N, jVarQ, (Boolean) true, (HashMap<String, Object>) null);
        }
        return true;
    }

    private HashMap<String, Object> a(com.baidu.mobads.container.adrequest.t tVar, com.baidu.mobads.container.adrequest.j jVar) {
        return com.baidu.mobads.container.f.b(tVar, jVar);
    }

    public void processAdStart() {
        if (this.ad == null || !this.ad.a(this.mAdInstanceInfo)) {
            this.mAdContainerCxt.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.v));
        }
    }

    public void processAdError(com.baidu.mobads.container.c.a aVar, String str) {
        HashMap map = new HashMap();
        map.put("error_message", str);
        map.put("error_code", Integer.valueOf(aVar.b()));
        this.mAdContainerCxt.s().dispatchEvent(new com.baidu.mobads.container.util.cm("AdError", (HashMap<String, Object>) map));
    }

    void a() {
        if (!this.T) {
            this.T = true;
            a(3, new Object[0]);
        }
    }

    public void rewardVerify() {
        if (!this.mSegReward && this.T) {
            return;
        }
        if (this.mSharedMediator != null) {
            this.mSharedMediator.a();
        }
        a();
        if (this.mAdInstanceInfo != null && this.mAdInstanceInfo.isServerVerify() && this.mAdContainerCxt != null) {
            try {
                HashMap map = new HashMap();
                map.put(WindAds.TRANS_ID, this.mAdInstanceInfo.getQueryKey());
                map.put("user_id", this.Z);
                map.put("extra", this.aa);
                map.put("apid", this.mAdContainerCxt.l());
                map.put("appid", this.mAdContainerCxt.z());
                map.put("os_type", "1");
                map.put("oaid", com.baidu.mobads.container.util.f.z.a(this.mAppContext));
                map.put("android_id", "");
                map.put(com.baidu.mobads.container.adrequest.g.z, IDManager.getInstance().c(this.mAppContext));
                map.put("cuid", IDManager.getInstance().a(this.mAppContext));
                map.put("creative_id", this.mAdInstanceInfo.getAdId());
                com.baidu.mobads.container.components.g.f fVar = new com.baidu.mobads.container.components.g.f(1, com.baidu.mobads.container.util.o.a("https://cpu-openapi.baidu.com/api/bes/s", (HashMap<String, String>) map));
                fVar.a(3000);
                fVar.b(3000);
                fVar.a(new z(this));
                fVar.a();
                return;
            } catch (Throwable th) {
                b("0");
                return;
            }
        }
        b("1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            if (this.ad == null || !this.ad.a(this.mAdInstanceInfo, str)) {
                HashMap map = new HashMap();
                map.put("serverVerify", str);
                this.mAdContainerCxt.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.M, (HashMap<String, Object>) map));
                sendRVideoLog(16);
            }
            f(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void y() {
        if (this.fatherOfFullScreen == null) {
            return;
        }
        this.fatherOfFullScreen.getViewTreeObserver().addOnPreDrawListener(new aa(this));
    }

    private void z() {
        ViewPropertyAnimator viewPropertyAnimatorTranslationY;
        try {
            com.baidu.mobads.container.util.h.b(this.mActivity);
            if (this.mActivity == null) {
                viewPropertyAnimatorTranslationY = null;
            } else {
                View decorView = this.mActivity.getWindow().getDecorView();
                decorView.setTranslationY(0.0f);
                viewPropertyAnimatorTranslationY = decorView.animate().setDuration(P).translationY(decorView.getHeight());
            }
            if (com.baidu.mobads.container.util.x.a(this.mAppContext).a() >= 16 && viewPropertyAnimatorTranslationY != null) {
                viewPropertyAnimatorTranslationY.withEndAction(new ab(this));
            } else if (this.mActivity != null) {
                this.mActivity.finish();
            }
        } catch (Exception e2) {
            this.L.c(e2);
        }
    }

    public void finish() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        try {
            if (this.mSkipView != null && this.mSkipView.getVisibility() != 0) {
                if (i < 0) {
                    i = 0;
                }
                if (this.aF == null) {
                    this.aF = new ad(this);
                }
                if (i == 0) {
                    showSkipView();
                } else if (this.mTimingReward) {
                    this.bj.a(this.aF, i * 1000);
                } else {
                    this.bi.a(this.aF, i * 1000);
                }
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.f(th.getMessage());
        }
    }

    private void a(Runnable runnable, int i) {
        com.baidu.mobads.container.d.b.a().a(new af(this, runnable), i, TimeUnit.SECONDS);
    }

    private boolean A() {
        return !TextUtils.isEmpty(this.U);
    }

    private void B() {
        if (this.A != null && this.A.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.baidu.mobads.container.util.ab.a(this.mActivity, 30.0f));
            layoutParams.addRule(10);
            layoutParams.addRule(0, 1001);
            layoutParams.setMargins(0, com.baidu.mobads.container.util.ab.a(this.mActivity, 12.0f), com.baidu.mobads.container.util.ab.a(this.mActivity, 12.0f), 0);
            this.A.setLayoutParams(layoutParams);
        }
    }

    private void C() {
        if (this.j != null && this.j.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.mActivity, 30.0f), com.baidu.mobads.container.util.ab.a(this.mActivity, 30.0f));
            layoutParams.addRule(10);
            layoutParams.addRule(0, 1001);
            layoutParams.setMargins(0, com.baidu.mobads.container.util.ab.a(this.mActivity, 12.0f), com.baidu.mobads.container.util.ab.a(this.mActivity, 12.0f), 0);
            this.j.setLayoutParams(layoutParams);
        }
    }

    private RelativeLayout.LayoutParams D() {
        int iB;
        int i;
        if (this.S == 20035) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = this.x.getLayoutParams().height;
            return layoutParams;
        }
        if (this.O.equals(SCREEN_PORTRAIT)) {
            iB = com.baidu.mobads.container.util.ab.b(this.mActivity, com.baidu.mobads.container.util.ab.b(this.mActivity));
            double d2 = iB;
            Double.isNaN(d2);
            i = (int) (0.029d * d2);
        } else if (!this.O.equals(SCREEN_LANDSCAPE)) {
            iB = 0;
            i = 0;
        } else {
            iB = com.baidu.mobads.container.util.ab.b(this.mActivity, com.baidu.mobads.container.util.ab.c(this.mActivity));
            double d3 = iB;
            Double.isNaN(d3);
            i = (int) (d3 * 0.235d);
        }
        int i2 = iB - (i * 2);
        if (this.S != 20036) {
            iB = i2;
        } else {
            int iB2 = (com.baidu.mobads.container.util.ab.b(this.mActivity, com.baidu.mobads.container.util.ab.c(this.mActivity)) - ((iB * 9) / 16)) / 2;
            i = 17;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.mActivity, iB), -2);
        layoutParams2.addRule(13);
        if (this.S == 20036) {
            layoutParams2.addRule(2, this.x.getId());
            float f2 = i;
            layoutParams2.setMargins(com.baidu.mobads.container.util.ab.a(this.mActivity, f2), com.baidu.mobads.container.util.ab.a(this.mActivity, 40.0f), com.baidu.mobads.container.util.ab.a(this.mActivity, f2), 0);
        } else {
            layoutParams2.addRule(12, -1);
            float f3 = i;
            layoutParams2.setMargins(com.baidu.mobads.container.util.ab.a(this.mActivity, f3), 0, com.baidu.mobads.container.util.ab.a(this.mActivity, f3), com.baidu.mobads.container.util.ab.a(this.mActivity, 20.0f));
        }
        return layoutParams2;
    }

    private RelativeLayout.LayoutParams E() {
        int iB;
        int i;
        if (this.S == 20035) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = this.x.getLayoutParams().height;
            return layoutParams;
        }
        if (this.O.equals(SCREEN_PORTRAIT)) {
            d = this.S == 20037 ? 2.375d : 4.466d;
            iB = com.baidu.mobads.container.util.ab.b(this.mActivity, com.baidu.mobads.container.util.ab.b(this.mActivity));
            double d2 = iB;
            Double.isNaN(d2);
            i = (int) (0.029d * d2);
        } else if (!this.O.equals(SCREEN_LANDSCAPE)) {
            iB = 0;
            i = 0;
        } else {
            iB = com.baidu.mobads.container.util.ab.b(this.mActivity, com.baidu.mobads.container.util.ab.c(this.mActivity));
            double d3 = iB;
            Double.isNaN(d3);
            i = (int) (d3 * 0.235d);
        }
        int i2 = iB - (i * 2);
        double d4 = i2;
        Double.isNaN(d4);
        int iB2 = (int) (d4 / d);
        if (this.S != 20036) {
            iB = i2;
        } else {
            iB2 = ((com.baidu.mobads.container.util.ab.b(this.mActivity, com.baidu.mobads.container.util.ab.c(this.mActivity)) - ((iB * 9) / 16)) / 2) - 40;
            i = 0;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.mActivity, iB), com.baidu.mobads.container.util.ab.a(this.mActivity, iB2));
        layoutParams2.addRule(13);
        if (this.S == 20036) {
            layoutParams2.addRule(2, this.x.getId());
            float f2 = i;
            layoutParams2.setMargins(com.baidu.mobads.container.util.ab.b(this.mActivity, f2), com.baidu.mobads.container.util.ab.b(this.mActivity, 40.0f), com.baidu.mobads.container.util.ab.b(this.mActivity, f2), 0);
        } else {
            layoutParams2.addRule(12, -1);
            float f3 = i;
            layoutParams2.setMargins(com.baidu.mobads.container.util.ab.b(this.mActivity, f3), 0, com.baidu.mobads.container.util.ab.b(this.mActivity, f3), com.baidu.mobads.container.util.ab.b(this.mActivity, 20.0f));
        }
        return layoutParams2;
    }

    private void F() {
        String str;
        BitmapDrawable bitmapDrawable;
        if (this.fatherOfFullScreen == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.baidu.mobads.container.util.ab.a(this.mActivity, 40));
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, com.baidu.mobads.container.util.ab.a(this.mActivity, 100.0f));
        if (this.mAdInstanceInfo.getActionType() == 1) {
            bitmapDrawable = new BitmapDrawable(com.component.b.a.a().b("ic_white_link"));
            str = "查看详情";
        } else if (this.mAdInstanceInfo.getActionType() == 2) {
            bitmapDrawable = new BitmapDrawable(com.component.b.a.a().b("ic_white_dl"));
            str = "立即下载";
        } else if (this.mAdInstanceInfo.getActionType() != 512) {
            str = "";
            bitmapDrawable = null;
        } else {
            bitmapDrawable = new BitmapDrawable(com.component.b.a.a().b("ic_white_apo"));
            str = "立即打开";
        }
        float f2 = 20;
        com.baidu.mobads.container.util.bs bsVarA = new bs.a().e(com.baidu.mobads.container.util.ab.a(this.mActivity, f2)).h(com.baidu.mobads.container.util.ab.a(this.mActivity, f2)).a(Color.parseColor("#000000")).b(180).a(str).d(Color.parseColor("#ffffffff")).a(new ag(this)).c(12).a(this.mActivity);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, com.baidu.mobads.container.util.ab.a(this.mActivity, 18.0f), com.baidu.mobads.container.util.ab.a(this.mActivity, 18.0f));
            bsVarA.setCompoundDrawablePadding(com.baidu.mobads.container.util.ab.a(this.mActivity, 5.0f));
            bsVarA.setCompoundDrawables(bitmapDrawable, null, null, null);
        }
        this.fatherOfFullScreen.addView(bsVarA, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Object... objArr) {
        switch (i) {
            case 1:
                this.clickedBeforeJumpedOut = false;
                if (this.as != null && this.mCurrentRewardMode == 1 && !this.T && this.as.g()) {
                    this.bj.a(getUserRewardTime());
                    e(0);
                    break;
                }
                break;
            case 2:
                if (this.as != null && this.mCurrentRewardMode == 1 && !this.T) {
                    this.as.a(this.clickedBeforeJumpedOut);
                    break;
                }
                break;
            case 3:
                if (this.as != null) {
                    if ((this.mCurrentRewardMode == 1 || this.mCurrentRewardMode == 2) && this.aw != null && (com.component.a.i.f.d(this.aw) instanceof Drawable)) {
                        this.aw.setBackground((Drawable) com.component.a.i.f.d(this.aw));
                        break;
                    }
                }
                break;
            case 4:
                if (objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
                    String str = (String) objArr[0];
                    if (this.mCurrentRewardMode == 1 && !this.T && this.mDownloadStateChangeListener != null && TextUtils.equals(str, this.mAdInstanceInfo.getAppPackageName())) {
                        this.mDownloadStateChangeListener.a();
                        break;
                    }
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.component.a.a.f fVarH;
        if (this.mRewardMode == 2 && this.as != null) {
            int iA = com.component.a.i.f.a((View) this.as, "delay_time", 3000);
            int iA2 = com.component.a.i.f.a((View) this.as, com.baidu.mobads.container.adrequest.n.m, 5000);
            boolean z = com.component.a.i.f.a((View) this.as, "reward_method", 0) == 1;
            String strA = com.component.a.i.f.a(this.as, "reward_prefix", "点击广告");
            String strA2 = com.component.a.i.f.a(this.as, "reward_postfix", "领取奖励");
            JSONObject jSONObjectOptJSONObject = com.component.a.i.n.c(com.component.a.i.f.a(this.as, "amend_info", "")).optJSONObject("segmented_countdown_first_text_hint");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            String strOptString = jSONObjectOptJSONObject.optString("background_color");
            double dOptDouble = jSONObjectOptJSONObject.optDouble("background_alpha");
            boolean z2 = com.component.a.i.f.a((View) this.as, "hint_type", 0) == 1;
            if (!z2) {
                fVarH = null;
            } else {
                fVarH = this.as.h();
            }
            this.bi.a(new ah(this, z, strOptString, dOptDouble, strA2, strA, z2, fVarH), iA);
            if (z2) {
                this.bi.a(new ai(this, fVarH), iA + iA2);
            } else {
                this.bi.a(new aj(this), iA);
            }
        }
    }

    private void H() {
        if (this.mCurrentRewardMode == 1 && !this.T && this.as != null) {
            String appPackageName = this.mAdInstanceInfo.getAppPackageName();
            if (com.baidu.mobads.container.util.ab.b(this.mAppContext, this.mAdInstanceInfo) == 200) {
                this.as.f();
                return;
            }
            if (!TextUtils.isEmpty(appPackageName)) {
                ak akVar = new ak(this);
                if (RemoteReflectInterface.getDownloadStatus(appPackageName) == 101) {
                    this.N.setContainerEventListener(new al(this, appPackageName, akVar));
                    return;
                } else {
                    this.mDownloadStateChangeListener = new am(this, appPackageName, akVar);
                    return;
                }
            }
            return;
        }
        if (this.mCurrentRewardMode == 2 && !this.T) {
            this.bj.a(getUserRewardTime());
            e(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Runnable runnable) {
        this.fatherOfFullScreen.post(new an(this, str, runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        try {
            if (!isLastPage() && this.ap != null && this.ap.c()) {
                int iD = this.ap.d();
                int iE = this.ap.e();
                int iF = this.ap.f();
                switch (i) {
                    case 0:
                        if (iD == 1 && iE < 0) {
                            I();
                            break;
                        }
                        break;
                    case 1:
                        if (iD == 1 && iE >= 0) {
                            this.bl = new aq(this);
                            this.bk = new ar(this);
                            this.bi.a(this.bl, iE);
                            this.bi.a(this.bk, iE + iF);
                            break;
                        }
                        break;
                    case 2:
                        if (iD == 2 && iE >= 0) {
                            this.B.postDelayed(new as(this), iE);
                            this.B.postDelayed(new at(this), iE + iF);
                            break;
                        }
                        break;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearSlideGuideAnim() {
        if (this.bl != null) {
            this.bi.a(this.bl);
            this.bl = null;
        }
        if (this.bk != null) {
            this.bi.a(this.bk);
            this.bk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.ap != null) {
            if (this.ad != null && !this.ad.a() && this.ad.b()) {
                this.ap.a("上滑查看更多精彩视频");
            }
            this.ap.setVisibility(0);
            this.ap.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.ap != null) {
            this.ap.setVisibility(8);
            this.ap.b();
        }
    }

    private void K() {
        if (this.aB != null) {
            this.aB.s();
            this.aB.setVisibility(8);
        }
    }

    protected void addEndPage() {
        try {
            if (this.v) {
                return;
            }
            this.v = true;
            this.J = false;
            this.h = false;
            if (this.A != null) {
                this.A.setVisibility(4);
            }
            a(com.component.a.g.b.b.f);
            Q();
            if (this.az != null) {
                this.az.c();
            }
            if (this.aC != null) {
                this.aC.setVisibility(8);
            }
            stopTimer();
            if (this.mNativeShakeView != null) {
                this.mNativeShakeView.j();
            }
            if (this.aD != null) {
                this.aD.f();
            }
            if (this.ap != null && this.ap.d() == 1) {
                J();
            }
            K();
            b(false);
            dismissSkipView();
            if (this.j != null) {
                this.j.setVisibility(4);
            }
            if (this.t != null && this.x != null) {
                M();
                if (!b(this.x, this.t)) {
                    showEndPage(false);
                }
            } else {
                showEndPage(false);
            }
            if (x() && !this.T) {
                double userRewardTime = getUserRewardTime() - this.ad.c();
                Double.isNaN(userRewardTime);
                int iMax = Math.max(0, (int) Math.round(userRewardTime / 1000.0d));
                if (iMax >= 0) {
                    Toast.makeText(this.mAppContext, String.format(Locale.CHINA, "还差%d秒才能领取奖励哦，下滑再看一个视频吧～", Integer.valueOf(iMax)), 1).show();
                }
            }
        } catch (Throwable th) {
            this.L.d(TAG, th);
            showEndPage(false);
        }
    }

    protected void showEndPage(boolean z) {
        try {
            if (z) {
                this.J = true;
                t();
            } else if (this.x != null) {
                this.x.n();
                this.x.e();
                this.x = null;
            }
            if (this.ao != null && this.ao.b()) {
                this.ao.i();
            }
            P();
            if (this.aE != null) {
                com.baidu.mobads.container.util.cf.b(this.aE);
            }
            a(this.s, 0);
            L();
            f(2);
            if (this.i != null) {
                a((WebView) this.i);
            }
            this.R = A() ? 3 : this.o;
            if (this.R > 0 && this.aS != null) {
                this.R *= 1000;
                a(this.aS, 0);
                this.aR.post(this.c);
            }
            a(new au(this), this.R);
            if (A() && this.fatherOfFullScreen != null) {
                this.fatherOfFullScreen.addView(new k.a().a(this.mActivity).a());
                sendRVideoLog(12);
            }
            sendRVideoLog(10);
            if (!this.aJ && this.aI == 1 && this.mAdInstanceInfo.getActionType() == 1) {
                this.aJ = true;
                com.baidu.mobads.container.o.b bVar = new com.baidu.mobads.container.o.b();
                bVar.a(3);
                bVar.a("auto_c");
                bVar.b("auto_c");
                a(false, false, bVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void L() {
        com.component.a.f.e eVarB;
        com.component.a.i.f fVarA = com.component.a.i.f.a(this.s);
        if (fVarA != null && (eVarB = fVarA.b()) != null) {
            JSONObject jSONObjectC = eVarB.c();
            int iOptInt = jSONObjectC.optInt("auto_playnext", 0);
            int iOptInt2 = jSONObjectC.optInt("delay_time", 3000);
            if (iOptInt == 1) {
                this.B.postDelayed(new av(this), iOptInt2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, Bitmap bitmap, int i) {
        if (view != null) {
            if (bitmap != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (i > 0) {
                    bitmapDrawable.setColorFilter(new LightingColorFilter(i, 0));
                }
                view.setBackgroundDrawable(bitmapDrawable);
                return;
            }
            view.setBackgroundDrawable(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    private void M() {
        Object parent;
        if (this.s == null || (parent = this.s.getParent()) == null) {
            return;
        }
        int i = 0;
        ?? parent2 = this.x.getParent();
        while (i < 3 && (parent2 instanceof View)) {
            Object parent3 = parent2.getParent();
            View view = (View) parent2;
            view.setBackgroundColor(0);
            if (parent != parent3) {
                i++;
                parent2 = parent3;
            } else {
                if (parent instanceof ViewGroup) {
                    a((ViewGroup) parent, this.s, view);
                    a((View) parent3, this.u, 8947848);
                    return;
                }
                return;
            }
        }
    }

    private void a(ViewGroup viewGroup, View view, View view2) {
        int iIndexOfChild;
        if (viewGroup != null && view != null && view2 != null && (iIndexOfChild = viewGroup.indexOfChild(view)) > 0) {
            for (int i = 0; i < iIndexOfChild; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null && childAt != view2) {
                    childAt.setVisibility(4);
                }
            }
        }
    }

    private View a(com.component.player.c cVar, View view) {
        if (cVar != null && view != null) {
            if (a((View) cVar, view)) {
                Object obj = cVar.c;
                cVar.setBackgroundColor(0);
                if (obj instanceof View) {
                    return (View) obj;
                }
                return null;
            }
            Object parent = cVar.getParent();
            if (parent instanceof com.component.a.d.c) {
                return (View) parent;
            }
            return null;
        }
        return null;
    }

    private boolean a(View view, View view2) {
        try {
            return c(view).contains(c(view2));
        } catch (Throwable th) {
            this.L.d(TAG, th);
            return false;
        }
    }

    private Rect c(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }

    private boolean b(com.component.player.c cVar, View view) {
        View viewA = a(cVar, view);
        if (viewA == null) {
            return false;
        }
        viewA.getGlobalVisibleRect(new Rect());
        view.getGlobalVisibleRect(new Rect());
        float f2 = (((r2.left + r2.right) - r1.left) - r1.right) / 2.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewA, "translationX", 0.0f, f2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewA, "translationY", 0.0f, (((r2.top + r2.bottom) - r1.top) - r1.bottom) / 2.0f);
        float width = view.getWidth() / viewA.getWidth();
        float height = view.getHeight() / viewA.getHeight();
        if (Float.isNaN(width) || Float.isNaN(height)) {
            return false;
        }
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewA, "scaleX", 1.0f, width);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewA, "scaleY", 1.0f, height);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new aw(this));
        animatorSet.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        try {
            if (this.t != null && this.x != null) {
                String mainPictureUrl = this.mAdInstanceInfo.getMainPictureUrl();
                if (!TextUtils.isEmpty(mainPictureUrl)) {
                    com.baidu.mobads.container.util.d.d.a(this.mAppContext).a(mainPictureUrl, false, (com.baidu.mobads.container.util.d.a) new b(this));
                } else {
                    this.u = this.x.a();
                }
            }
        } catch (Throwable th) {
            this.L.d(TAG, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        try {
            if (this.ba != null) {
                this.a = ObjectAnimator.ofFloat(this.ba, "translationY", 0.0f, -this.aZ);
                this.a.setDuration(300L);
                this.a.start();
            }
        } catch (Throwable th) {
        }
    }

    private void P() {
        try {
            if (this.ba != null && this.ba.getParent() != null) {
                com.baidu.mobads.container.util.cf.b(this.ba);
                this.ba = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void playClick() {
        this.mAdInstanceInfo.setInapp(true);
        this.mAdInstanceInfo.setAutoOpen(true);
        String appStoreLink = this.mAdInstanceInfo.getAppStoreLink();
        if (this.mAdInstanceInfo.getActionType() == 2 && com.baidu.mobads.container.util.e.a.k(this.mAppContext) && !com.baidu.mobads.container.util.e.a.i(this.mAppContext).booleanValue() && TextUtils.isEmpty(appStoreLink)) {
            com.baidu.mobads.container.util.ab.a(this.mActivity, new ax(this));
        }
        a(false, true, (com.baidu.mobads.container.o.b) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, com.component.a.f.d dVar) {
        if (this.mSharedMediator == null || !this.mSharedMediator.a(view, z, dVar)) {
            if (this.mNativeShakeView != null) {
                this.mNativeShakeView.setVisibility(8);
                this.mNativeShakeView.m();
                this.mNativeShakeView = null;
            }
            if (dVar != null) {
                a(false, z, dVar.a());
            } else {
                a(false, z, (com.baidu.mobads.container.o.b) null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    void a(boolean z, boolean z2, com.baidu.mobads.container.o.b bVar) {
        int i;
        boolean z3;
        if (bVar == null) {
            bVar = new com.baidu.mobads.container.o.b();
        }
        bVar.b(this.fatherOfFullScreen);
        com.baidu.mobads.container.o.a aVar = new com.baidu.mobads.container.o.a(bVar);
        aVar.a(this.bm);
        this.N.setClickInfoForCK(bVar, this.bm);
        this.aJ = true;
        a(com.component.a.g.b.b.c);
        if (this.az != null) {
            this.az.c();
        }
        H();
        if (this.mAdInstanceInfo != null) {
            this.clickedBeforeJumpedOut = true;
            if (z) {
                i = 17;
            } else if (this.h) {
                i = 8;
            } else {
                i = 9;
            }
            if (a(this.mAdInstanceInfo)) {
                JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
                char c2 = 65535;
                if (originJsonObject == null) {
                    z3 = false;
                } else {
                    int iA = a("dialog_scene", 0);
                    ?? OptInt = z2;
                    if (iA == 0) {
                        OptInt = originJsonObject.optInt("dl_dialog", -1);
                    } else if (iA != 1) {
                        OptInt = -1;
                    }
                    z3 = originJsonObject.optInt("notice_dl_non_wifi", 0) == 1;
                    c2 = OptInt;
                }
                if (c2 != 1) {
                    if (1 != this.Y) {
                        if (2 == this.Y) {
                            this.ah = 1;
                            a(this.mAdInstanceInfo, i, aVar);
                            return;
                        } else {
                            a(false, false, i, aVar);
                            return;
                        }
                    }
                    boolean zBooleanValue = com.baidu.mobads.container.util.e.a.i(this.mAppContext).booleanValue();
                    if (!zBooleanValue && z3) {
                        this.ah = 1;
                        a(this.mAdInstanceInfo, i, aVar);
                        return;
                    } else {
                        a(false, zBooleanValue, i, aVar);
                        return;
                    }
                }
                this.ah = 1;
                a(true, false, i, aVar);
                return;
            }
            this.ah = 1;
            a(false, false, i, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, int i, com.baidu.mobads.container.o.a aVar) {
        if (!this.mSendImpressionLog.getAndSet(true)) {
            sendRVideoLog(5);
            dp.a(this.fatherOfFullScreen, this.mAdInstanceInfo, this.mAdContainerCxt);
        }
        sendRVideoLog(i, aVar);
        XAdInstanceInfoExt xAdInstanceInfoExt = new XAdInstanceInfoExt(this.mAdInstanceInfo);
        xAdInstanceInfoExt.setThirdClickTrackingUrls(dp.a(this.mAdInstanceInfo, this.fatherOfFullScreen, aVar.a()));
        xAdInstanceInfoExt.setActionOnlyWifi(z2);
        HashMap<String, Object> mapA = a(this.mAdContainerCxt, this.mAdInstanceInfo);
        if (mapA == null) {
            mapA = new HashMap<>();
        }
        mapA.put("use_dialog_frame", Boolean.valueOf(z));
        if (a(com.baidu.mobads.container.components.k.c.a, 1) == 1) {
            if (i == 9) {
                mapA.put(com.baidu.mobads.container.components.k.c.b, a(com.baidu.mobads.container.components.k.c.c, com.baidu.mobads.container.components.k.c.d));
            } else {
                mapA.put(com.baidu.mobads.container.components.k.c.b, a(com.baidu.mobads.container.components.k.c.b, com.baidu.mobads.container.components.k.c.d));
            }
        }
        new com.baidu.mobads.container.components.k.c(this).a((com.baidu.mobads.container.k) this.N, (com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExt, (Boolean) true, mapA);
        if (this.ad != null) {
            this.ad.b(this.mAdInstanceInfo);
        }
        this.aX = true;
        com.baidu.mobads.container.util.h.a(new ay(this));
    }

    private void a(com.baidu.mobads.container.adrequest.j jVar, int i, com.baidu.mobads.container.o.a aVar) {
        if (jVar == null || this.mActivity == null) {
            return;
        }
        this.H = true;
        c(1);
        com.baidu.mobads.container.util.ab.b(this.mActivity, new az(this, i, aVar, jVar));
    }

    private boolean a(com.baidu.mobads.container.adrequest.j jVar) {
        int iOptInt;
        boolean zB;
        JSONObject jSONObject;
        if (jVar != null) {
            int actionType = jVar.getActionType();
            String appPackageName = jVar.getAppPackageName();
            if (actionType == 2) {
                if (com.baidu.mobads.container.util.j.b(this.mAppContext, appPackageName)) {
                    return false;
                }
                return !com.baidu.mobads.container.util.bk.b(this.mAppContext, jVar.getAppStoreLink());
            }
            if (actionType == 512) {
                try {
                    jSONObject = new JSONObject(jVar.getAppOpenStrs());
                    iOptInt = jSONObject.optInt("fb_act", 0);
                } catch (Throwable th) {
                    th = th;
                    iOptInt = 0;
                }
                try {
                    zB = com.baidu.mobads.container.util.bk.b(this.mAppContext, jSONObject.optString("page", ""));
                } catch (Throwable th2) {
                    th = th2;
                    this.L.b(TAG, "Parse apoStr error: " + th.getMessage());
                    zB = false;
                    if (zB) {
                        return false;
                    }
                    return !com.baidu.mobads.container.util.j.b(this.mAppContext, appPackageName);
                }
                if (zB && iOptInt == 2) {
                    return !com.baidu.mobads.container.util.j.b(this.mAppContext, appPackageName);
                }
            }
        }
        return false;
    }

    private int a(String str, int i) {
        if (this.ab != null) {
            return this.ab.a(str, i);
        }
        return i;
    }

    private String a(String str, String str2) {
        if (this.ab != null) {
            return this.ab.a(str, str2);
        }
        return str2;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onConfigurationChanged(Configuration configuration) {
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
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        registerDownloadListeners(iOAdEvent);
        if (iOAdEvent != null && TextUtils.equals(iOAdEvent.getType(), com.baidu.mobads.container.components.k.b.F)) {
            a(com.component.a.g.b.b.d);
        }
    }

    void b(int i) {
        double d2 = i;
        Double.isNaN(d2);
        String strValueOf = String.valueOf((int) Math.round(d2 / 1000.0d));
        if (this.an != null) {
            this.an.setText(strValueOf + "s秒后可领取奖励");
        }
        if (this.ak != null) {
            this.ak.setText(this.al.replace("%", strValueOf));
        }
        if (this.mEggLottieView != null) {
            this.mEggLottieView.d(1.0f - (i / getUserRewardTime()));
        }
        if (this.am != null) {
            this.am.setText("再看" + strValueOf + "秒，可领取奖励");
        }
    }

    private void Q() {
        if (this.an != null) {
            this.an.setVisibility(8);
        }
        if (this.aj != null) {
            this.aj.setVisibility(8);
        }
        if (this.mEggLottieView != null) {
            this.mEggLottieView.s();
        }
        if (this.mRewardCountdownView != null) {
            this.mRewardCountdownView.h();
        }
    }

    protected JSONObject getOptimizedTemplateJson(com.component.a.g.d dVar, g.a aVar) {
        JSONObject jSONObjectA = dVar.a(aVar, new bb(this));
        try {
            JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject("config");
            if (jSONObjectOptJSONObject != null) {
                this.aH = jSONObjectOptJSONObject.optInt("delay_click_type", this.aH);
                this.aG = jSONObjectOptJSONObject.optInt("delay_click", this.aG);
                this.mRewardTime = jSONObjectOptJSONObject.optInt("reward_time", this.mRewardTime);
                this.mRewardMode = jSONObjectOptJSONObject.optInt("reward_mode", this.mRewardMode);
                this.aK = jSONObjectOptJSONObject.optInt("single_reward_time", this.mRewardTime);
                this.aL = jSONObjectOptJSONObject.optInt("multi_reward_time", this.mRewardTime);
                this.aI = jSONObjectOptJSONObject.optInt("auto_c", this.aI);
                this.mSegReward = jSONObjectOptJSONObject.optInt("seg_reward", 0) == 1;
                this.mTimingReward = jSONObjectOptJSONObject.optInt("timing_reward", 0) == 1;
                if (isFirstPage() && this.mSharedMediator != null) {
                    this.mSharedMediator.a(jSONObjectOptJSONObject);
                }
                if (isFirstPage() && this.ad != null) {
                    this.ad.b(this.aK);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObjectA;
    }

    private void R() {
        a(new bc(this), this.aG);
    }

    static class b extends com.baidu.mobads.container.util.d.a {
        private final SoftReference<NativeRewardActivity> a;

        public b(NativeRewardActivity nativeRewardActivity) {
            this.a = new SoftReference<>(nativeRewardActivity);
        }

        @Override // com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, Bitmap bitmap) {
            NativeRewardActivity nativeRewardActivity = this.a.get();
            if (bitmap != null && nativeRewardActivity != null) {
                nativeRewardActivity.u = bitmap;
            }
        }
    }

    protected void sendRVideoLog(int i) {
        sendRVideoLog(i, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void sendRVideoLog(int r11, com.baidu.mobads.container.o.a r12) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.rewardvideo.NativeRewardActivity.sendRVideoLog(int, com.baidu.mobads.container.o.a):void");
    }

    protected HashMap<String, String> getPlayerInfo() {
        if (this.x != null) {
            return this.x.j().g();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(this.bc.toString())) {
                this.bc.append(",");
            }
            this.bc.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) throws NumberFormatException {
        int i;
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("^\\d{4}").matcher(str);
            if (matcher.find()) {
                try {
                    i = Integer.parseInt(matcher.group());
                } catch (Exception e2) {
                    com.baidu.mobads.container.l.g.d(e2);
                    i = -1;
                }
                if (!this.bb.containsKey(Integer.valueOf(i)) && i > 0) {
                    this.bb.put(Integer.valueOf(i), str);
                    if (!TextUtils.isEmpty(this.bd.toString())) {
                        this.bd.append(",");
                    }
                    this.bd.append(str);
                    if (!TextUtils.isEmpty(this.be.toString())) {
                        this.be.append(",");
                    }
                    this.be.append(com.baidu.mobads.container.o.j.a(i));
                }
            }
        }
    }
}
