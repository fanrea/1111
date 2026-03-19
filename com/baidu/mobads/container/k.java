package com.baidu.mobads.container;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.components.a;
import com.baidu.mobads.container.components.j.c;
import com.baidu.mobads.container.o.j;
import com.baidu.mobads.container.s.ab;
import com.baidu.mobads.container.s.k;
import com.baidu.mobads.container.s.p;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.ba;
import com.baidu.mobads.container.util.bh;
import com.baidu.mobads.container.util.bj;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bu;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cc;
import com.baidu.mobads.container.util.cd;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.cn;
import com.baidu.mobads.container.util.d.d;
import com.baidu.mobads.container.util.z;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.component.a.a.b;
import com.sigmob.sdk.base.models.ClickCommon;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import com.style.widget.ac;
import com.style.widget.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class k extends cn implements IOAdEventListener {
    public static final int Baidu_Ad_IMG_ID = 16972527;
    public static final String CC_REGION_CLICK = "region_click";
    public static final String DISPLAY_CLICK_BUTTON = "displayClickButton";
    protected static final int SPLASH_BOTTOM_VIEW_ID = 4097;
    protected static final int SPLASH_BUTTON = 1;
    protected static final int SPLASH_NO = 4;
    protected static final int SPLASH_PRO = 5;
    protected static final int SPLASH_SKIP_BTN_BORDER = 0;
    protected static final int SPLASH_SKIP_BTN_CAPSULE = 1;
    protected static final int SPLASH_SKIP_BTN_CIRCLE = 2;
    protected static final int STATE_LOAD = 1;
    protected static final int STATE_STOP = 2;
    protected static final String TAG = "XBaseAdContainer";
    public static final String TIEBA_APPID = "bb3808eb";
    public static final String USE_DIALOG_FRAME = "use_dialog_frame";
    private static final int a = 1;
    private boolean c;
    private String e;
    public boolean hasPlayed;
    private AnimatorSet i;
    private com.baidu.mobads.container.u.b k;
    private com.baidu.mobads.container.s.g l;
    protected Activity mActivity;
    protected com.baidu.mobads.container.components.i.a mAdCloudConfigs;
    protected final com.baidu.mobads.container.adrequest.t mAdContainerCxt;
    protected String mAdContainerName;
    public com.baidu.mobads.container.adrequest.j mAdInstanceInfo;
    protected int mAdSource;
    protected Context mAppContext;
    protected Object mAppSmallLogo;
    public com.baidu.mobads.container.util.z mCKUtil;
    protected Runnable mCacheAssetTimer;
    protected cn mContainerEvtListener;
    protected HashMap<String, String> mCustomerParameters;
    protected boolean mIsAdaptiveSplashAd;
    protected boolean mIsSplashPreferFullscreen;
    protected List<ObjectAnimator> mObjectAnimatorList;
    protected boolean mPopDialogIfDl;
    public com.baidu.mobads.container.components.a mProgressView;
    protected int mShakeLogoSize;
    protected int mTwistBgColor;
    protected int mTwistLogoHeightDp;
    private View n;
    private com.baidu.mobads.container.s.p r;
    private IOAdEventListener t;
    protected int mAdState = 0;
    public ImageView imageBaidu = null;
    public ImageView imageAd = null;
    private boolean b = false;
    public int windowFocusState = -1;
    private Map<String, WeakReference<com.baidu.mobads.container.components.command.b>> d = new HashMap();
    protected boolean mDisplayClickButton = false;
    protected boolean mLimitRegionClick = false;
    protected int mBottomViewHeight = 0;
    protected int mExtraBottomMargin = 0;
    private boolean f = false;
    private com.baidu.mobads.container.s.k g = null;
    private com.baidu.mobads.container.s.ab h = null;
    protected AtomicBoolean mCacheAssetTimeRunning = new AtomicBoolean(false);
    protected AtomicBoolean isSendValidSplashImpressionLoged = new AtomicBoolean(false);
    protected int reasonValue = 7;
    protected boolean clickSkip = false;
    private boolean j = true;
    protected AtomicBoolean isTwistCompleted = new AtomicBoolean(false);
    private final Map<String, WeakReference<View>> m = new HashMap();
    protected final com.baidu.mobads.container.o.b mClickTracker = new com.baidu.mobads.container.o.b();
    private boolean o = false;
    private boolean p = false;
    private final ArrayList<String> q = new ArrayList<>(Arrays.asList(com.baidu.mobads.container.u.n.i, com.baidu.mobads.container.u.n.j, com.baidu.mobads.container.u.n.k, com.baidu.mobads.container.u.n.l, com.baidu.mobads.container.u.n.m));
    public StringBuffer mSNameMsgs = new StringBuffer();
    private int s = 0;
    protected String showRecord = null;
    private bh u = null;
    protected final bq mAdLogger = bq.a();

    protected abstract void resetAdContainerName();

    public k(com.baidu.mobads.container.adrequest.t tVar) {
        this.mIsAdaptiveSplashAd = false;
        this.mIsSplashPreferFullscreen = false;
        this.mAdSource = 0;
        this.mAdContainerCxt = tVar;
        this.mAppContext = tVar.t();
        this.mActivity = tVar.u();
        this.mContainerEvtListener = tVar.s();
        this.mAdInstanceInfo = this.mAdContainerCxt.q();
        try {
            this.c = Boolean.parseBoolean(this.mAdContainerCxt.w().optString("countDownNew", "true"));
            this.mIsAdaptiveSplashAd = Boolean.parseBoolean(this.mAdContainerCxt.w().optString(SplashAd.KEY_USE_ADAPTIVE_AD, "false"));
            this.mIsSplashPreferFullscreen = Boolean.parseBoolean(this.mAdContainerCxt.w().optString(SplashAd.KEY_PREFER_FULLSCREEN, "false"));
            this.mAdSource = this.mAdContainerCxt.w().optInt("adSrc", 0);
        } catch (Exception e) {
        }
        resetAdContainerName();
        com.baidu.mobads.container.adrequest.j jVarQ = this.mAdContainerCxt.q();
        this.mAdCloudConfigs = new com.baidu.mobads.container.components.i.a(this.mAppContext, jVarQ != null ? jVarQ.getOriginJsonObject() : null);
        e();
        cacheBubblesLottie();
    }

    public Boolean processKeyEvent(int i, KeyEvent keyEvent) {
        return false;
    }

    public void setParameters(HashMap<String, String> map) {
        this.mCustomerParameters = map;
    }

    public HashMap<String, String> getParameters() {
        return this.mCustomerParameters;
    }

    public void load() {
        this.mAdLogger.a(TAG, "load");
        this.mAdState = 1;
        com.baidu.mobads.container.util.h.a(new l(this));
    }

    public com.baidu.mobads.container.adrequest.t getAdContainerContext() {
        return this.mAdContainerCxt;
    }

    public void start() {
        this.hasPlayed = true;
        this.mAdLogger.a(TAG, "start");
        com.baidu.mobads.container.util.h.a(new w(this));
    }

    public void stop() {
        com.baidu.mobads.container.util.h.a(new al(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addDownloadDescT(JSONObject jSONObject, int i) {
        int i2;
        int i3;
        float f;
        if (jSONObject != null) {
            if (!ab.a.APP_DOWNLOAD.equals(com.baidu.mobads.container.util.ab.a(this.mAppContext, this.mAdInstanceInfo))) {
                return;
            }
            String strOptString = jSONObject.optString(com.baidu.mobads.container.components.command.j.I);
            String strOptString2 = jSONObject.optString("app_version");
            String strOptString3 = jSONObject.optString("privacy_link");
            String strOptString4 = jSONObject.optString(com.baidu.mobads.container.components.command.j.L);
            String strOptString5 = jSONObject.optString(com.baidu.mobads.container.components.command.j.M);
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString4)) {
                return;
            }
            new com.baidu.mobads.container.components.i.a(this.mAppContext, jSONObject).a("skip_btn");
            if (this.mExtraBottomMargin <= 0) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.mAdContainerCxt.t());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (f()) {
                layoutParams.setMargins(0, 0, 0, i + bv.a(this.mAppContext, 12.0f));
            } else {
                layoutParams.setMargins(0, 0, 0, i);
            }
            relativeLayout.setLayoutParams(layoutParams);
            if (this.l != null && this.l.getVisibility() == 0) {
                i3 = -2171170;
                f = 0.7f;
            } else {
                i3 = -10066330;
                f = 0.3f;
            }
            com.style.widget.v vVarA = new v.a(this.mAdContainerCxt.t()).a(strOptString2, strOptString, strOptString3, strOptString4, strOptString5).a(i3).a(true).b(i2).a(new ao(this)).a();
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            vVarA.setGravity(17);
            relativeLayout.addView(vVarA, layoutParams2);
            this.mAdContainerCxt.v().addView(relativeLayout);
            addDownloadAppname(jSONObject, f);
        }
    }

    protected void addDownloadAppname(JSONObject jSONObject, float f) {
        String strOptString = "精选推荐";
        if (jSONObject != null) {
            try {
                strOptString = jSONObject.optString("appname", "精选推荐");
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (strOptString.length() > 11) {
            strOptString = strOptString.substring(0, 11);
        }
        TextView textView = new TextView(this.mAppContext);
        textView.setText(strOptString);
        textView.setTextColor(-1);
        textView.setTextSize(1, 9.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            gradientDrawable.setAlpha((int) (f * 255.0f));
            gradientDrawable.setColor(-13421773);
            float fA = bv.a(this.mAppContext, 3.0f);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setPadding(5, 2, 5, 2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.leftMargin = bv.a(this.mAppContext, f() ? 12.0f : 0.0f);
        layoutParams.bottomMargin = bv.a(this.mAppContext, f() ? 12.0f : 0.0f);
        this.mAdContainerCxt.v().addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addAppSmallLogo() {
        if (f() && 1 == this.mAdCloudConfigs.a("media_logo", 1)) {
            ImageView imageView = new ImageView(this.mAppContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            this.mAdCloudConfigs.a(layoutParams, "media_style", "media_logo", 5, true, this.mBottomViewHeight);
            if (this.mAppSmallLogo instanceof Integer) {
                imageView.setImageResource(((Integer) this.mAppSmallLogo).intValue());
                this.mAdContainerCxt.v().addView(imageView, layoutParams);
            } else if (this.mAppSmallLogo instanceof byte[]) {
                byte[] bArr = (byte[]) this.mAppSmallLogo;
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (bitmapDecodeByteArray != null) {
                    imageView.setImageBitmap(bitmapDecodeByteArray);
                    this.mAdContainerCxt.v().addView(imageView, layoutParams);
                }
            }
        }
    }

    public void handlePause(com.baidu.mobads.container.adrequest.j jVar) {
        if (this.mProgressView != null) {
            this.mProgressView.f();
        }
        if (jVar != null && this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adDownloadWindow", 1));
        }
        com.baidu.mobads.container.util.h.a(new ap(this));
    }

    public void handleResume(com.baidu.mobads.container.adrequest.j jVar) {
        if (this.mProgressView != null) {
            this.mProgressView.d();
        }
        if (jVar != null && this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adDownloadWindow", 0));
        }
        com.baidu.mobads.container.util.h.a(new aq(this));
    }

    public void onPermissionShow(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null && this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adPermissionClick", 1));
        }
    }

    public void onPermissionClose(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null && this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adPermissionClick", 0));
        }
    }

    public void onFunctionClick(com.baidu.mobads.container.adrequest.j jVar) {
        if (this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adFunctionClick"));
        }
    }

    public void onFunctionLpClose(com.baidu.mobads.container.adrequest.j jVar) {
        if (this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("onADFunctionLpClose"));
        }
    }

    public void onPrivacyClick(com.baidu.mobads.container.adrequest.j jVar) {
        if (this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adPrivacyClick"));
        }
    }

    public void onPrivacyLpClose(com.baidu.mobads.container.adrequest.j jVar) {
        if (this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("onADPrivacyLpClose"));
        }
    }

    public void handleDislikeClick(com.baidu.mobads.container.adrequest.j jVar, View view, com.component.a.f.d dVar) {
        Context context;
        try {
            if (this.mActivity != null) {
                context = this.mActivity;
            } else {
                context = this.mAppContext;
            }
            com.style.widget.a aVarA = com.style.widget.a.a(context);
            aVarA.a(new ar(this, jVar));
            new ArrayList(new com.baidu.mobads.container.util.an().a().keySet());
            aVarA.a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dispatchDislikeEvent(com.baidu.mobads.container.adrequest.j jVar, String str, String str2) {
        if (this.mAdContainerCxt != null) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("type", str);
            if (TextUtils.equals("click", str)) {
                map.put("reason", str2);
            }
            onDislikeEvent(jVar, map);
        }
    }

    protected void onDislikeEvent(com.baidu.mobads.container.adrequest.j jVar, HashMap<String, Object> map) {
        if (this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.N, map));
        }
    }

    public void sendDislikeClickLog(String str, com.baidu.mobads.container.adrequest.j jVar) {
        Integer num = new com.baidu.mobads.container.util.an().a().get(str);
        if (num != null) {
            sendDislikeClickLog(num.intValue(), jVar);
        }
    }

    public void sendDislikeClickLog(int i, com.baidu.mobads.container.adrequest.j jVar) {
        if (!this.f) {
            new com.baidu.mobads.container.util.an().a(i, jVar.getDislikeTrackers());
            this.f = true;
        }
    }

    public void setContainerEventListener(IOAdEventListener iOAdEventListener) {
        this.t = iOAdEventListener;
    }

    public void onAdClick(com.baidu.mobads.container.adrequest.j jVar, View view) {
        if (this.t != null) {
            this.t.run(new cm(IAdInterListener.AdCommandType.AD_CLICK));
        }
    }

    public void beforeSendLog(com.baidu.mobads.container.adrequest.j jVar, View view) {
    }

    public void beforeSendLog(com.baidu.mobads.container.adrequest.j jVar, View view, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addLawText() {
        if (a() || b()) {
            return;
        }
        boolean zF = f();
        JSONObject jSONObjectA = this.mAdCloudConfigs.a("ad_logo_style");
        if ((jSONObjectA != null ? jSONObjectA.optInt("type", 0) : 0) == 1) {
            this.mAdCloudConfigs.a(52, 13);
            loadAdImage(h.k, zF);
            loadBaiduAdImage(h.m, zF);
        } else {
            this.mAdCloudConfigs.a(25, 13);
            loadAdImage(h.k, zF);
            loadAdImage(h.l, zF);
        }
    }

    public void addDspId(RelativeLayout relativeLayout, int i) {
        if (this.mAdContainerCxt == null || relativeLayout == null || this.mAdInstanceInfo == null) {
            return;
        }
        TextView textView = new TextView(this.mAppContext);
        textView.setText(com.component.a.g.c.k.a(this.mAdInstanceInfo.getBuyer()));
        textView.setTextSize(1, 9.0f);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setAlpha(0.3f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(13);
        layoutParams.bottomMargin = com.baidu.mobads.container.util.ab.a(this.mAppContext, i);
        relativeLayout.addView(textView, layoutParams);
    }

    public void loadBaiduAdImage(String str, boolean z) {
        if (this.mAppContext != null) {
            ImageView imageView = new ImageView(this.mAppContext);
            if (h.m.equals(str)) {
                imageView.setImageBitmap(com.baidu.mobads.container.util.n.c());
            }
            com.baidu.mobads.container.util.h.a(new as(this, imageView, str, z));
        }
    }

    public void loadAdImage(String str, boolean z) {
        if (this.mAppContext != null) {
            ImageView imageView = new ImageView(this.mAppContext);
            if (com.baidu.mobads.container.util.d.d.a(this.mAppContext).g(str)) {
                com.baidu.mobads.container.util.d.d.a(this.mAppContext).b(imageView, str);
            } else if (str.equals(h.k)) {
                imageView.setImageBitmap(com.baidu.mobads.container.util.n.a());
            } else if (str.equals(h.l)) {
                imageView.setImageBitmap(com.baidu.mobads.container.util.n.b());
            }
            ba.b(this.mAppContext, str);
            com.baidu.mobads.container.util.h.a(new at(this, imageView, str, z));
        }
    }

    private boolean a() {
        try {
            JSONObject originJsonObject = this.mAdContainerCxt.q().getOriginJsonObject();
            if (originJsonObject != null) {
                return originJsonObject.optInt("logo", 1) == 0;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean b() {
        try {
            String strZ = this.mAdContainerCxt.z();
            JSONObject originJsonObject = this.mAdContainerCxt.q().getOriginJsonObject();
            if (originJsonObject != null) {
                int iOptInt = originJsonObject.optInt("pattern");
                if (TIEBA_APPID.equals(strZ) && iOptInt == 1) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, String str, boolean z) {
        if (this.mAdContainerCxt != null && this.mAdContainerCxt.v() != null && this.mAppContext != null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (str.equals(h.k)) {
                imageView.setTag("BAIDU_LOGO");
                float f = 13;
                layoutParams.width = bv.a(this.mAppContext, f);
                layoutParams.height = bv.a(this.mAppContext, f);
                this.mAdCloudConfigs.a(layoutParams, "ad_logo", "bd_logo", 10, z, this.mBottomViewHeight);
            } else if (str.equals(h.l)) {
                imageView.setTag("AD_LOGO");
                layoutParams.width = bv.a(this.mAppContext, 25);
                layoutParams.height = bv.a(this.mAppContext, 13);
                this.mAdCloudConfigs.a(layoutParams, "ad_logo", "ad_logo", 10, z, this.mBottomViewHeight);
            } else if (str.equals(h.m)) {
                imageView.setTag("BQT_AD_LOGO");
                layoutParams.width = bv.a(this.mAppContext, 52);
                layoutParams.height = bv.a(this.mAppContext, 13);
                this.mAdCloudConfigs.a(layoutParams, "ad_logo", "bqt_ad_logo", 10, z, this.mBottomViewHeight);
            }
            imageView.setId(Baidu_Ad_IMG_ID);
            this.mAdContainerCxt.v().addView(imageView, layoutParams);
            this.imageBaidu = (ImageView) this.mAdContainerCxt.v().findViewWithTag("BAIDU_LOGO");
            Object tag = imageView.getTag();
            if ("AD_LOGO".equals(tag)) {
                this.imageAd = (ImageView) this.mAdContainerCxt.v().findViewWithTag("AD_LOGO");
            } else if ("BQT_AD_LOGO".equals(tag)) {
                this.imageAd = (ImageView) this.mAdContainerCxt.v().findViewWithTag("BQT_AD_LOGO");
            }
            this.b = false;
            if (this.imageBaidu != null && this.imageAd != null) {
                this.imageAd.setOnClickListener(new m(this));
                this.imageBaidu.setOnClickListener(new n(this));
            }
        }
    }

    public void checkAPO(int i) {
        try {
            JSONObject originJsonObject = this.mAdContainerCxt.q().getOriginJsonObject();
            if (originJsonObject.optInt("act") == 2) {
                String strOptString = originJsonObject.optString("apo", "");
                if (!TextUtils.isEmpty(strOptString)) {
                    String strOptString2 = new JSONObject(strOptString).optString("page", "");
                    String strOptString3 = originJsonObject.optString("pk", "");
                    if (com.baidu.mobads.container.util.j.b(this.mAppContext, strOptString3)) {
                        if (!TextUtils.isEmpty(strOptString2)) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strOptString2));
                            intent.addFlags(268435456);
                            if (this.mAppContext.getPackageManager().resolveActivity(intent, 65536) != null) {
                                this.mAppContext.startActivity(intent);
                                bk.a(this.mAppContext, this.mAdContainerCxt, strOptString3, strOptString2, i);
                            }
                            return;
                        }
                        return;
                    }
                    bk.A.put(strOptString3, strOptString2);
                }
            }
        } catch (Throwable th) {
            this.mAdLogger.a(th);
        }
    }

    public void displayVersion4DebugMode() {
        if (j.c.booleanValue() && this.mAppContext != null) {
            TextView textView = new TextView(this.mAppContext);
            textView.setTextColor(-16776961);
            textView.setTextSize(15.0f);
            textView.setText("P : " + com.baidu.mobads.container.config.b.a().j() + "\nR : 9.40");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = 10;
            layoutParams.addRule(13);
            this.mAdContainerCxt.v().addView(textView, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            XAdInstanceInfoExt xAdInstanceInfoExt = (XAdInstanceInfoExt) ((XAdInstanceInfoExt) this.mAdContainerCxt.q()).clone();
            xAdInstanceInfoExt.setClickThroughUrl(com.baidu.mobads.container.adrequest.h.g);
            xAdInstanceInfoExt.setActionType(1);
            new com.baidu.mobads.container.components.k.c().a(this, (com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExt, (Boolean) true, (HashMap<String, Object>) null);
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.h(TAG).f("Show url error: " + th.getMessage());
        }
    }

    protected void doStartOnUIThread() {
    }

    protected void doLoadOnUIThread() {
    }

    protected void doStopOnUIThread() {
        cancelAnimators();
        removeShakeView();
        com.baidu.mobads.container.util.h.a(new o(this));
    }

    public void resize(int i, int i2) {
    }

    public void close() {
    }

    public void pause() {
    }

    public void resume() {
    }

    @Override // com.baidu.mobads.container.util.cn
    public void dispose() {
    }

    public void onAttachedToWindow() {
    }

    public void onDetachedFromWindow() {
    }

    public void onWindowVisibilityChanged(int i) {
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            this.windowFocusState = 1;
        } else {
            this.windowFocusState = 0;
        }
    }

    public void processAdError(com.baidu.mobads.container.c.a aVar, String str) {
        if (this.mAdContainerCxt != null) {
            HashMap map = new HashMap();
            map.put("error_message", str);
            this.mAdContainerCxt.s().dispatchEvent(new cm("AdError", aVar.b(), (HashMap<String, Object>) map));
        }
    }

    public void processAdError(com.baidu.mobads.container.c.a aVar, String str, String str2) {
        if (this.mAdContainerCxt != null) {
            HashMap map = new HashMap();
            map.put("error_message", str);
            this.mAdContainerCxt.s().dispatchEvent(new cm(str2, aVar.b(), (HashMap<String, Object>) map));
        }
    }

    public void processAdError(HashMap<String, Object> map) {
        if (this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("AdError", map));
        }
    }

    public void processAdStart() {
        processAdStart(null);
    }

    public void processAdStart(HashMap<String, Object> map) {
        this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.v, map));
        d();
    }

    private void d() {
        try {
            if ("rsplash".equals(this.mAdContainerCxt.k()) && com.baidu.mobads.container.config.a.a().b()) {
                by.a.a(this.mAppContext).a(821).a("containerType", getClass().getSimpleName()).a(this.mAdInstanceInfo).f();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean processShouldOverrideUrlLoading(String str, WebView webView) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            bj.a(webView.getContext(), str);
        } else if (str.startsWith(com.baidu.mobads.container.util.o.e(com.baidu.mobads.container.i.b.a))) {
            webView.loadUrl(str);
        } else {
            if ("rsplash".equals(this.mAdContainerCxt.k())) {
                if (!this.isSendValidSplashImpressionLoged.getAndSet(true)) {
                    sendImpressionLog(this.mAdContainerCxt.q());
                    send3rdImpressionLog(webView);
                    sendSplashViewStateInClick(0, true, 2, bu.aL, "");
                }
                bk.a(this.mAppContext, this.mAdContainerCxt, bk.L, 8);
            }
            com.baidu.mobads.container.adrequest.j jVarQ = this.mAdContainerCxt.q();
            jVarQ.setClickThroughUrl(str);
            jVarQ.setActionType(1);
            new com.baidu.mobads.container.components.k.c().a(this, jVarQ, (Boolean) true, (HashMap<String, Object>) null);
            com.baidu.mobads.container.components.h.d.a(jVarQ.getUniqueId(), com.baidu.mobads.container.components.h.a.EVENT_CLICK);
            com.baidu.mobads.container.components.h.d.a(jVarQ.getUniqueId(), com.baidu.mobads.container.components.h.a.EVENT_CLICK_LP);
        }
        return true;
    }

    protected void handleClick() {
    }

    public HashMap<String, Object> getShouBaiLpFlag(com.baidu.mobads.container.adrequest.t tVar, com.baidu.mobads.container.adrequest.j jVar) {
        return f.b(tVar, jVar);
    }

    public void destroy() {
        cancelAnimators();
        removeShakeView();
        getSplashTransition().d();
        if (this.g != null) {
            this.g = null;
        }
        try {
            if (this.mObjectAnimatorList != null && this.mObjectAnimatorList.size() > 0) {
                Iterator<ObjectAnimator> it = this.mObjectAnimatorList.iterator();
                while (it.hasNext()) {
                    it.next().cancel();
                }
            }
        } catch (Exception e) {
        }
    }

    public void send3rdImpressionLog(View view) {
        send3rdImpressionLog(view, false);
    }

    public void send3rdImpressionLog(View view, boolean z) {
        com.baidu.mobads.container.adrequest.j jVarQ = this.mAdContainerCxt.q();
        send3rdLog(com.baidu.mobads.container.o.c.a(jVarQ.getThirdImpressionTrackingUrls(), view, z), jVarQ, c.d.c);
    }

    protected void send3rdLog(List<String> list, com.baidu.mobads.container.adrequest.j jVar, String str) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("appsid", this.mAdContainerCxt.z());
                } catch (Throwable th) {
                }
                String strA = com.baidu.mobads.container.f.a.a().a(this.mAppContext, str2, jSONObject);
                sendUrlWithFailedLog(strA, str, "", "", "", i, jVar);
                if (c.d.c.equals(str)) {
                    cc.a(this.mAppContext, strA, cc.a.THIRDSHOW);
                }
            }
        }
    }

    protected void sendUrlWithFailedLog(String str, String str2, String str3, String str4, String str5, int i, com.baidu.mobads.container.adrequest.j jVar) {
        com.baidu.mobads.container.components.j.c.a().a(this.mAdContainerCxt.z(), this.mAdContainerCxt.k(), this.mAdContainerCxt.l(), jVar, str2, str3, str4, str5, i, str);
    }

    public String getRemoteVersion() {
        return "9.40";
    }

    public String getAdContainerName() {
        return this.mAdContainerName;
    }

    public int getAdStateForTest() {
        return this.mAdState;
    }

    public void setAdStateForTest(int i) {
        this.mAdState = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doAddProgressView() {
        int iB;
        int iOptInt;
        com.baidu.mobads.container.adrequest.j jVarQ = this.mAdContainerCxt.q();
        int iOptInt2 = this.mAdContainerCxt.w().optInt("splashTipStyle", 4);
        if (jVarQ.getOriginJsonObject().has("closetype")) {
            iOptInt2 = jVarQ.getOriginJsonObject().optInt("closetype", 4);
        }
        if (this.mAdCloudConfigs == null) {
            iB = 1;
            iOptInt = 0;
        } else {
            iB = this.mAdCloudConfigs.b("skip_btn_style", 1);
            JSONObject jSONObjectA = this.mAdCloudConfigs.a("skip_btn");
            if (jSONObjectA == null) {
                iOptInt = 0;
            } else {
                iOptInt = jSONObjectA.optInt("border", 0);
            }
        }
        a(iOptInt2, iB, iOptInt);
        if (!"video".equals(jVarQ.getCreativeType().b())) {
            this.mProgressView.a(5000L);
            this.mProgressView.d();
        }
        if (iOptInt2 == 5) {
            this.mProgressView.setVisibility(0);
            if (this.o && this.n != null) {
                this.n.setVisibility(0);
            }
        } else if (iOptInt2 == 1) {
            this.mProgressView.setVisibility(0);
            if (this.o && this.n != null) {
                this.n.setVisibility(0);
            }
        }
        getSplashTransition().c();
    }

    private void a(int i, int i2, int i3) {
        String str;
        a.b bVar;
        boolean z;
        int i4;
        int i5;
        String str2;
        try {
            if (i2 == 2) {
                a.b bVar2 = a.b.CIRCLE;
                this.mProgressView = (com.baidu.mobads.container.components.a) com.style.widget.ac.b(this.mAppContext, new ac.a().a(bVar2).a(-12956454).b(bv.a(this.mAppContext, 2.0f)).c(-7697782).d(bv.a(this.mAppContext, 2.0f)).a("跳过").e(-1).a(10.0f).f(-16777216).b(0.5f));
                i4 = 40;
                str2 = "skip_btn";
                i5 = 40;
            } else {
                if (i != 1) {
                    str = "跳过";
                    bVar = a.b.TEXT;
                    z = true;
                } else {
                    bVar = a.b.TEXT;
                    str = "跳过广告";
                    z = false;
                }
                this.mProgressView = (com.baidu.mobads.container.components.a) com.style.widget.ac.a(this.mAppContext, new ac.a().a(bVar).a(str).e(-1).a(13.0f).f(-16777216).b(0.25f).c(0.5f).g(5).a(z));
                i4 = 72;
                i5 = 36;
                str2 = "skip_btn_capsule";
            }
            this.mProgressView.setVisibility(4);
            this.mProgressView.setOnClickListener(new p(this));
            this.mProgressView.a(new q(this));
            float f = i3;
            this.mProgressView.a(new RectF(f, f, i3 + i4, i3 + i5));
            int i6 = i3 * 2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bv.a(this.mAppContext, i4 + i6), bv.a(this.mAppContext, i5 + i6));
            this.mAdCloudConfigs.a(layoutParams, "skip_btn", str2, 9, f(), this.mBottomViewHeight);
            int iA = bv.a(this.mAppContext, f);
            layoutParams.setMargins(layoutParams.leftMargin - iA, layoutParams.topMargin - iA, layoutParams.rightMargin - iA, layoutParams.bottomMargin - iA);
            this.mAdContainerCxt.v().addView(this.mProgressView, layoutParams);
            a(this.mProgressView);
            if (this.n != null) {
                this.n.setVisibility(4);
            }
        } catch (Exception e) {
        }
    }

    protected Bitmap getCloseBitmap() {
        return null;
    }

    protected void closeAd(String str) {
        if (this.mAdContainerCxt != null) {
            HashMap map = new HashMap();
            map.put("video_close_reason", str);
            this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.E, (HashMap<String, Object>) map));
            com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId());
            com.baidu.mobads.container.util.h.a(new r(this));
        }
    }

    protected void sendSplashViewState(int i, boolean z, int i2, int i3, String str) {
        recordAdShowStatus(this.mAdContainerCxt.q(), this.mAdContainerCxt.v());
        com.baidu.mobads.container.v.a.a(this.mAdContainerCxt, i, z, i2, i3, str, "0");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendSplashViewStateInClick(int i, boolean z, int i2, int i3, String str) {
        recordAdShowStatus(this.mAdContainerCxt.q(), this.mAdContainerCxt.v());
        com.baidu.mobads.container.v.a.a(this.mAdContainerCxt, i, z, i2, i3, str, "2");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendImpressionLog(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar == null) {
            return;
        }
        Set<String> impressionUrls = jVar.getImpressionUrls();
        if (impressionUrls != null) {
            ArrayList arrayList = new ArrayList();
            Object[] array = impressionUrls.toArray();
            for (int i = 0; i < array.length; i++) {
                if (jVar.isEncryptionExpose()) {
                    arrayList.add(cd.b(jVar, (String) array[i], this.mAdContainerCxt.z(), this.mAdContainerCxt.l()));
                } else {
                    arrayList.add((String) array[i]);
                }
            }
            impressionUrls.clear();
            cd.a(jVar, this.mAdContainerCxt);
            send3rdLog(arrayList, jVar, c.d.a);
        }
        this.mAdContainerCxt.s().dispatchEvent(new cm("AdImpression", jVar.getUniqueId()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recordAdShowStatus(com.baidu.mobads.container.adrequest.j jVar, View view) {
        com.baidu.mobads.container.adrequest.n.a(jVar, com.baidu.mobads.container.adrequest.n.H);
        com.baidu.mobads.container.adrequest.n.b(jVar, com.baidu.mobads.container.adrequest.n.j, com.baidu.mobads.container.adrequest.n.c);
        com.baidu.mobads.container.adrequest.n.a(jVar, com.baidu.mobads.container.adrequest.n.k, com.baidu.mobads.container.adrequest.n.G);
        if (view != null) {
            com.baidu.mobads.container.adrequest.n.a(jVar, "lw", view.getWidth());
            com.baidu.mobads.container.adrequest.n.a(jVar, "lh", view.getHeight());
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            com.baidu.mobads.container.adrequest.n.c(jVar, com.baidu.mobads.container.adrequest.n.E, String.valueOf(iArr[0]));
            com.baidu.mobads.container.adrequest.n.c(jVar, com.baidu.mobads.container.adrequest.n.F, String.valueOf(iArr[1]));
        }
    }

    protected void recordAdClickStatus(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null) {
            com.baidu.mobads.container.adrequest.n.a(jVar, com.baidu.mobads.container.adrequest.n.I);
            com.baidu.mobads.container.o.a aVar = new com.baidu.mobads.container.o.a(this.mClickTracker);
            aVar.a(com.baidu.mobads.container.adrequest.n.b(jVar, com.baidu.mobads.container.adrequest.n.H, 0L));
            HashMap<String, String> mapC = aVar.c();
            JSONObject adStatus = jVar.getAdStatus();
            if (adStatus == null) {
                adStatus = new JSONObject();
                jVar.setAdStatus(adStatus);
            }
            try {
                for (String str : mapC.keySet()) {
                    if (!"lw".equals(str) && !"lh".equals(str)) {
                        adStatus.put(str, mapC.get(str));
                    }
                }
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
            }
        }
    }

    protected void sendRsplashExpClickLog(int i) {
        sendSplashViewStateInClick(9, false, i, 424, this.showRecord);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkAndSendRsplashShowLog(int i, HashMap<String, Object> map) {
        if (this.mAdContainerCxt != null) {
            if (this.mAdContainerCxt.q() != null) {
                com.baidu.mobads.container.components.h.d.a(this.mAdContainerCxt.q().getUniqueId(), com.baidu.mobads.container.components.h.a.EVENT_IMPRESSION);
                com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdContainerCxt.q().getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_START);
                com.baidu.mobads.container.adrequest.n.e(this.mAdContainerCxt.q(), "splash_comps", this.mSNameMsgs.toString());
            }
            if (i == 1 || i == 2) {
                int iD = com.baidu.mobads.container.util.r.d(this.mAdContainerCxt.v());
                if (iD == 0) {
                    processAdStart(map);
                    sendImpressionLog(this.mAdContainerCxt.q());
                    send3rdImpressionLog(this.mAdContainerCxt.v());
                    sendSplashViewState(iD, true, i, bu.aL, "");
                    com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdContainerCxt.q().getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_SUCCESS);
                    this.isSendValidSplashImpressionLoged.set(true);
                    return;
                }
                try {
                    if (this.h != null) {
                        this.h.j();
                    }
                    processAdStart(map);
                    sendSplashViewState(iD, false, i, bu.aL, "1");
                    this.showRecord = "";
                    this.showRecord += iD;
                    if (this.u != null) {
                        this.u.b();
                        this.u = null;
                    }
                    this.u = new bh(3000);
                    this.u.a(new s(this, i));
                    this.u.a();
                    sendSplashViewState(iD, false, i, bu.aL, "2");
                    return;
                } catch (Exception e) {
                    sendSplashViewState(iD, false, i, 423, "exception");
                    this.mAdLogger.a(e);
                    return;
                }
            }
            processAdStart(map);
            sendSplashViewState(com.baidu.mobads.container.util.r.d(this.mAdContainerCxt.v()), true, i, bu.aL, "");
            sendImpressionLog(this.mAdContainerCxt.q());
            send3rdImpressionLog(this.mAdContainerCxt.v());
            com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdContainerCxt.q().getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_SUCCESS);
            this.isSendValidSplashImpressionLoged.set(true);
        }
    }

    public void switchContext(Activity activity) {
        this.mActivity = activity;
        com.baidu.mobads.container.adrequest.t adContainerContext = getAdContainerContext();
        if (adContainerContext instanceof com.baidu.mobads.container.adrequest.o) {
            adContainerContext.a(activity);
            com.baidu.mobads.container.adrequest.o oVar = (com.baidu.mobads.container.adrequest.o) adContainerContext;
            if (oVar.d != null) {
                oVar.d.setAdContainer(null);
            }
        }
        this.imageAd = null;
        this.imageBaidu = null;
        this.mProgressView = null;
    }

    protected void registerState(long j, String str, com.baidu.mobads.container.adrequest.j jVar) {
    }

    public void run(IOAdEvent iOAdEvent) {
        com.baidu.mobads.container.components.command.b bVar;
        if (iOAdEvent != null && com.baidu.mobads.container.components.k.b.u.equals(iOAdEvent.getType())) {
            try {
                String message = iOAdEvent.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    if (this.mAdContainerCxt != null && this.mAdContainerCxt.r() != null) {
                        Iterator<com.baidu.mobads.container.adrequest.j> it = this.mAdContainerCxt.r().o().iterator();
                        while (it.hasNext()) {
                            com.baidu.mobads.container.adrequest.j next = it.next();
                            if (message.equals(next.getAppPackageName())) {
                                this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.u, next.getUniqueId()));
                            }
                        }
                    }
                    this.d = com.baidu.mobads.container.b.c.a().b();
                    if (this.d != null && this.d.size() > 0) {
                        Iterator<String> it2 = this.d.keySet().iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            WeakReference<com.baidu.mobads.container.components.command.b> weakReference = this.d.get(next2);
                            if (weakReference != null && (bVar = weakReference.get()) != null) {
                                if (next2.contains(message)) {
                                    bVar.a();
                                }
                            } else {
                                it2.remove();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                this.mAdLogger.a(th);
            }
        }
    }

    public View getAdView() {
        return null;
    }

    protected com.baidu.mobads.container.adrequest.j getAdInstanceInfoByJson(JSONObject jSONObject) {
        ArrayList<com.baidu.mobads.container.adrequest.j> arrayListO;
        if (jSONObject != null && jSONObject.has("uniqueId")) {
            String strOptString = jSONObject.optString("uniqueId");
            if (!TextUtils.isEmpty(strOptString) && this.mAdContainerCxt != null && this.mAdContainerCxt.r() != null && (arrayListO = this.mAdContainerCxt.r().o()) != null) {
                for (com.baidu.mobads.container.adrequest.j jVar : arrayListO) {
                    if (jVar != null && strOptString.equals(jVar.getUniqueId())) {
                        return jVar;
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public void handleEvent(JSONObject jSONObject, Map<String, Object> map) {
        boolean zA;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE);
            try {
                if ("splash_focus_start_activity".equals(strOptString)) {
                    com.baidu.mobads.container.util.animation.ak.a((Intent) map.get("splash_focus_user_intent"), this);
                    return;
                }
                if ("splash_focus_register_transition".equals(strOptString)) {
                    com.baidu.mobads.container.util.animation.ak.a((Activity) map.get("splash_focus_activity"), jSONObject.optJSONObject("splash_focus_params"));
                    return;
                }
                if ("splash_logo".equals(strOptString)) {
                    this.mAppSmallLogo = map.get("appLogo");
                    return;
                }
                if (!"splash_focus_card".equals(strOptString)) {
                    if ("splash_focus_card_enable".equals(strOptString)) {
                        map.put("splash_focus_card_enable", Boolean.valueOf(getSplashTransition().a()));
                        return;
                    } else {
                        if ("x_event".equals(strOptString)) {
                            a(jSONObject);
                            return;
                        }
                        return;
                    }
                }
                Activity activity = (Activity) map.get("splash_focus_activity");
                if (!getSplashTransition().a()) {
                    zA = false;
                } else {
                    getSplashTransition().a(getCloseBitmap());
                    zA = getSplashTransition().a(activity);
                }
                map.put("splash_focus_card_show", Boolean.valueOf(zA));
            } catch (Throwable th) {
                bq.a().c(th);
            }
        }
    }

    public void handleBottomView() {
        RelativeLayout relativeLayoutV;
        if (this.mAdContainerCxt != null && (relativeLayoutV = this.mAdContainerCxt.v()) != null) {
            try {
                View viewFindViewById = relativeLayoutV.findViewById(4097);
                if (viewFindViewById != null) {
                    if (this.mIsAdaptiveSplashAd && g()) {
                        viewFindViewById.setVisibility(8);
                        this.mBottomViewHeight = 0;
                    } else {
                        viewFindViewById.setVisibility(0);
                        this.mBottomViewHeight = viewFindViewById.getMeasuredHeight();
                    }
                }
            } catch (Throwable th) {
                this.mAdLogger.b(TAG, "handleBottomView: " + th.getMessage());
            }
        }
    }

    public void addMantle() {
        this.g = new k.b().a(this.mAdContainerCxt.q()).b(f()).i(this.mBottomViewHeight).a(this.mLimitRegionClick).l(this.mExtraBottomMargin).a(new u(this)).a(new t(this)).a(this.mAppContext);
        this.g.setOnTouchListener(new v(this));
        this.g.setId(100);
        this.g.a(this.mAdContainerCxt.v());
        b(String.valueOf(com.baidu.mobads.container.o.j.b("splash_action_view")));
    }

    public void addActionView() {
        if (this.g != null) {
            this.g.a(this, this.mAdContainerCxt.v());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addSlideView() {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.k.addSlideView():void");
    }

    private void e() {
        com.baidu.mobads.container.d.b.a().a(new z(this));
    }

    public void cacheBubblesLottie() {
        com.baidu.mobads.container.d.b.a().a(new ab(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, ArrayList<String> arrayList, String str) throws JSONException {
        if (jSONArray != null) {
            int length = jSONArray.length();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 5; i++) {
                arrayList2.add(Integer.valueOf(i));
            }
            if (length < 5) {
                Collections.shuffle(arrayList2, new Random());
            }
            for (int i2 = 0; i2 < jSONArray.length() && i2 < 5; i2++) {
                try {
                    int iIntValue = ((Integer) arrayList2.get(i2)).intValue();
                    String string = jSONArray.getString(i2);
                    JSONObject jSONObject = new JSONObject(arrayList.get(iIntValue));
                    jSONObject.getJSONArray("lottie").getJSONObject(0).getJSONObject("images").put(str, string);
                    arrayList.set(iIntValue, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public void addShakeView() {
        JSONObject originJsonObject;
        try {
            if (this.mAdInstanceInfo != null && (originJsonObject = this.mAdInstanceInfo.getOriginJsonObject()) != null) {
                String strOptString = originJsonObject.optString("cloud_control");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    int iOptInt = jSONObject.optInt(ILogConst.E_AD_SHAKE, 0);
                    int iOptInt2 = jSONObject.optInt("splash_turn", 2);
                    new com.baidu.mobads.container.components.i.a(this.mAppContext, originJsonObject).a("splash_actview");
                    if ((iOptInt == 0 && iOptInt2 != 1) || hasSlide()) {
                        return;
                    }
                    this.h = createSplashShakeView(this.mShakeLogoSize, -1, iOptInt, iOptInt2, true);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bv.a(this.mAppContext, 300.0f));
                    boolean zIsLottieShakeView = isLottieShakeView();
                    if (this.g != null) {
                        this.g.a(this.h, layoutParams, zIsLottieShakeView);
                    } else {
                        layoutParams.addRule(12);
                        layoutParams.bottomMargin = bv.a(this.mAppContext, 39.0f);
                        if (this.mAdContainerCxt != null && this.mAdContainerCxt.v() != null) {
                            this.mAdContainerCxt.v().addView(this.h, layoutParams);
                        }
                    }
                    if (iOptInt == 1) {
                        sendSplashShakeLog("onadshow");
                    } else {
                        sendSplashShakeLog("onadtwistshow");
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean addMixInteractView() {
        RelativeLayout relativeLayoutV = this.mAdContainerCxt.v();
        if (relativeLayoutV == null) {
            return false;
        }
        this.l = com.baidu.mobads.container.s.g.a(relativeLayoutV, this, this.mAdInstanceInfo);
        if (this.l != null) {
            com.baidu.mobads.container.components.i.a aVar = new com.baidu.mobads.container.components.i.a(null, this.mAdInstanceInfo.getOriginJsonObject());
            b(com.baidu.mobads.container.o.j.b("splash_multiple_interactions_view") + com.baidu.mobads.container.o.j.a + ((float) aVar.a("mutable_shake_speed", 6.0d)) + com.baidu.mobads.container.o.j.a + ((float) aVar.a("mutable_shake_angle", 0.0d)));
            sendSplashShakeLog("onAdMixInterShow");
            this.l.a(new ad(this));
        }
        return this.l != null;
    }

    public com.baidu.mobads.container.s.ab createSplashShakeView(int i, int i2, int i3, int i4, boolean z) {
        float f;
        float fOptDouble;
        int iOptInt;
        int i5;
        float f2;
        int i6;
        int i7;
        float f3;
        int i8;
        float f4;
        boolean z2;
        String str;
        float f5;
        int i9;
        int i10;
        float fA;
        float fA2;
        k kVar;
        boolean z3;
        com.baidu.mobads.container.s.ab abVar;
        int i11;
        String strA = "扭转手机 查看更多";
        int iOptInt2 = (i2 == 1 || i2 == 2) ? i2 : 1;
        try {
            com.baidu.mobads.container.components.i.a aVar = new com.baidu.mobads.container.components.i.a(this.mAppContext, this.mAdInstanceInfo.getOriginJsonObject());
            JSONObject jSONObjectA = aVar.a("shake_config");
            if (jSONObjectA != null && i3 == 1) {
                float fOptDouble2 = (float) jSONObjectA.optDouble("velocity", 7.0d);
                if (i2 != 1 && i2 != 2) {
                    iOptInt2 = jSONObjectA.optInt(Config.INPUT_DEF_VERSION, iOptInt2);
                }
                int iOptInt3 = jSONObjectA.optInt("interval_time", 190);
                iOptInt = jSONObjectA.optInt("detection_times", 1);
                i5 = iOptInt3;
                fOptDouble = (float) jSONObjectA.optDouble(b.e.a, 6.0d);
                f = fOptDouble2;
            } else {
                f = 7.0f;
                fOptDouble = 6.0f;
                iOptInt = 1;
                i5 = 190;
            }
            float f6 = fOptDouble;
            int i12 = iOptInt;
            float f7 = f;
            float fA3 = (float) aVar.a("shake_angle", 0.0d);
            float fA4 = (float) aVar.a("shake_optime", 0.0d);
            float fA5 = (float) aVar.a("startup_rate", 4.0d);
            boolean z4 = aVar.a("twoway_switch", 0) == 1;
            float fA6 = (float) aVar.a("twoway_angle", 35.0d);
            int iA = aVar.a("splash_shake_click", 1);
            String strA2 = aVar.a("splash_shake_text", "摇动手机  了解更多");
            String strA3 = aVar.a("splash_shake_lottie", "");
            if (i4 == 1 && i3 == 0) {
                float fA7 = (float) aVar.a("splash_turn_velocity", 7.0d);
                int iA2 = aVar.a("splash_turn_intervalTime", 190);
                int iA3 = aVar.a("splash_turn_detectionTimes", 1);
                float fA8 = (float) aVar.a("splash_turn_speed", 6.0d);
                fA = (float) aVar.a("splash_turn_angle", 0.0d);
                fA2 = (float) aVar.a("splash_turn_optime", 0.0d);
                boolean z5 = aVar.a("splash_turn_twoway_switch", 0) == 1;
                float fA9 = (float) aVar.a("splash_turn_twoway_angle", 35.0d);
                float fA10 = (float) aVar.a("startup_rate", 4.0d);
                int iA4 = aVar.a("splash_turn_style", 1);
                int iA5 = aVar.a("splash_turn_click", 1);
                strA = aVar.a("splash_turn_text", "扭转或点击 查看更多");
                strA3 = aVar.a("splash_turn_lottie", strA3);
                f4 = fA10;
                i7 = iA2;
                f3 = fA7;
                f2 = fA8;
                str = strA2;
                f5 = fA9;
                i9 = iA4;
                i6 = iA5;
                z2 = z5;
                i8 = iA3;
                i10 = 2;
            } else {
                f2 = f6;
                i6 = iA;
                i7 = i5;
                f3 = f7;
                i8 = i12;
                f4 = fA5;
                z2 = z4;
                str = strA2;
                f5 = fA6;
                i9 = 0;
                i10 = iOptInt2;
                fA = fA3;
                fA2 = fA4;
            }
            try {
                float f8 = f3;
                ab.b bVarA = new ab.b().a(f3).g(i).f(i10).n(i7).o(i8).d(fA).e(fA2).g(f4).c(f2).d(z2).f(f5).a(strA3);
                if (i4 != 1 || i3 != 0) {
                    kVar = this;
                    if (i3 == 1) {
                        z3 = z;
                        if (z3) {
                            bVarA.d(str);
                            kVar.b(com.baidu.mobads.container.o.j.b("shake_view") + com.baidu.mobads.container.o.j.a + f8 + com.baidu.mobads.container.o.j.a + fA);
                        }
                    } else {
                        z3 = z;
                    }
                } else {
                    kVar = this;
                    bVarA.a(true).e(i9).d(strA).h(kVar.mTwistBgColor).i(kVar.mTwistLogoHeightDp);
                    kVar.b(com.baidu.mobads.container.o.j.b("splash_twist") + com.baidu.mobads.container.o.j.a + f8 + com.baidu.mobads.container.o.j.a + fA);
                    z3 = z;
                }
                if (z3) {
                    abVar = new com.baidu.mobads.container.s.ab(kVar.mAppContext, bVarA, false, null, this, kVar.mAdInstanceInfo, true);
                    i11 = i6;
                } else {
                    abVar = new com.baidu.mobads.container.s.ab(kVar.mAppContext, bVarA, false, null);
                    i11 = i6;
                }
                abVar.a(new ae(this, abVar, i10, i3, i4));
                abVar.a(new ah(kVar, i11, z3, i10));
                return abVar;
            } catch (Throwable th) {
                th = th;
                com.baidu.mobads.container.l.g.b().f(th.getMessage());
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void removeShakeView() {
        if (this.h != null) {
            this.h.m();
            if (this.g != null) {
                RelativeLayout relativeLayout = (RelativeLayout) this.g.getParent();
                if (relativeLayout != null) {
                    relativeLayout.removeView(this.h);
                    return;
                }
                return;
            }
            if (this.mAdContainerCxt != null && this.mAdContainerCxt.v() != null) {
                this.mAdContainerCxt.v().removeView(this.h);
            }
        }
    }

    public void cancelAnimators() {
        if (this.g != null) {
            this.g.a();
        }
        com.baidu.mobads.container.util.h.a(new ai(this));
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            MotionEvent motionEventObtain = MotionEvent.obtain(jSONObject.optLong("e_d_t"), jSONObject.optLong("e_e_t"), jSONObject.optInt("e_a"), (float) jSONObject.optDouble("e_x"), (float) jSONObject.optDouble("e_y"), jSONObject.optInt("e_m_s"));
            this.mClickTracker.a(0);
            this.mClickTracker.a(motionEventObtain);
        }
    }

    protected int getSplashLogType() {
        return 0;
    }

    protected void onSplashAdClick(String str, com.baidu.mobads.container.o.b bVar) {
    }

    public void splashAdClick(String str, String str2) {
        splashAdClick(str, str2, str2);
    }

    public void splashAdClick(String str, String str2, String str3) {
        this.mClickTracker.a(str2);
        this.mClickTracker.b(str3);
        if (TextUtils.equals(str, "shake") || TextUtils.equals(str, "twist")) {
            this.mClickTracker.a(2);
        } else if (TextUtils.equals(str, ILogConst.DRAW_ENTER_TYPE_SLIDE)) {
            this.mClickTracker.a(1);
        } else if (TextUtils.equals(str, "close")) {
            this.mClickTracker.a(4);
            this.mClickTracker.b(j.a.PX_CLOSE.c());
        } else {
            this.mClickTracker.a(0);
        }
        this.mClickTracker.b(this.mAdContainerCxt.v());
        splashAdClick(str, this.mClickTracker);
    }

    public void splashAdClick(String str, com.baidu.mobads.container.o.b bVar) {
        long jOptLong;
        if (bVar != null) {
            this.mClickTracker.a(bVar);
            JSONObject adStatus = this.mAdContainerCxt.q().getAdStatus();
            if (adStatus == null) {
                jOptLong = 0;
            } else {
                jOptLong = adStatus.optLong(com.baidu.mobads.container.adrequest.n.H, 0L);
            }
            setClickInfoForCK(bVar, jOptLong);
        }
        onSplashAdClick(str, this.mClickTracker);
        if (this.n != null && this.o) {
            this.n.setVisibility(8);
            this.n = null;
        }
        this.p = true;
        if (!this.isSendValidSplashImpressionLoged.getAndSet(true)) {
            sendImpressionLog(this.mAdContainerCxt.q());
            send3rdImpressionLog(this.mAdContainerCxt.v());
            sendSplashViewStateInClick(0, true, getSplashLogType(), bu.aL, "");
        }
        com.baidu.mobads.container.o.a aVar = new com.baidu.mobads.container.o.a(bVar);
        aVar.a(com.baidu.mobads.container.adrequest.n.b(this.mAdInstanceInfo, com.baidu.mobads.container.adrequest.n.H, 0L));
        bk.a(this.mAppContext, this.mAdContainerCxt, bk.L, 8, aVar.c());
        HashMap<String, Object> shouBaiLpFlag = getShouBaiLpFlag(this.mAdContainerCxt, this.mAdContainerCxt.q());
        if (shouBaiLpFlag == null) {
            shouBaiLpFlag = new HashMap<>();
        }
        if (TextUtils.equals(str, "icon")) {
            shouBaiLpFlag.put("use_dialog_frame", Integer.valueOf(this.s));
        } else {
            shouBaiLpFlag.put("use_dialog_frame", Boolean.valueOf(this.mPopDialogIfDl));
        }
        if (this.mAdInstanceInfo != null) {
            this.mAdInstanceInfo.setActionOnlyWifi(false);
        }
        if (getCloudControlInt(com.baidu.mobads.container.components.k.c.a, 1) == 1) {
            shouBaiLpFlag.put(com.baidu.mobads.container.components.k.c.b, getCloudControlStr(com.baidu.mobads.container.components.k.c.c, com.baidu.mobads.container.components.k.c.d));
        }
        new com.baidu.mobads.container.components.k.c().a(this, this.mAdContainerCxt.q(), (Boolean) true, shouBaiLpFlag);
    }

    public void setClickInfoForCK(com.baidu.mobads.container.o.b bVar, long j) {
        z.a aVar = new z.a();
        aVar.g = j;
        aVar.a = bVar.x();
        aVar.b = bVar.h();
        aVar.c = bVar.i();
        aVar.d = bVar.y();
        aVar.e = bVar.f();
        aVar.f = bVar.g();
        aVar.h = bVar.l() != 0 ? bVar.l() : bVar.n();
        aVar.i = bVar.m() != 0 ? bVar.m() : bVar.o();
        aVar.j = bVar.j();
        aVar.k = bVar.k();
        switch (bVar.a()) {
            case 0:
                aVar.l = z.b.TOUCH;
                break;
            case 1:
                aVar.l = z.b.SLIDE;
                break;
            case 2:
                aVar.l = z.b.SHAKE;
                aVar.a = System.currentTimeMillis();
                aVar.d = aVar.a;
                break;
            case 3:
                aVar.l = z.b.AUTO;
                aVar.a = System.currentTimeMillis();
                aVar.d = aVar.a;
                break;
            case 4:
                aVar.l = z.b.TOUCH;
                break;
            default:
                aVar.l = z.b.TOUCH;
                break;
        }
        setCKString(com.baidu.mobads.container.util.z.a(aVar, this.mAdContainerCxt));
    }

    private boolean f() {
        if (this.mAdContainerCxt.v() == null || this.mAppContext == null) {
            return true;
        }
        return this.mBottomViewHeight <= 0 && ((WindowManager) this.mAppContext.getSystemService("window")).getDefaultDisplay().getHeight() - this.mAdContainerCxt.v().getHeight() <= com.baidu.mobads.container.util.ab.a(this.mAppContext, 44.0f);
    }

    private boolean g() {
        try {
            JSONObject originJsonObject = this.mAdContainerCxt.q().getOriginJsonObject();
            if (originJsonObject != null) {
                if (originJsonObject.optInt("pattern", this.mIsSplashPreferFullscreen ? 1 : 0) == 1) {
                    return true;
                }
            }
        } catch (Throwable th) {
            this.mAdLogger.b(TAG, "Parse ad data: " + th.getMessage());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public class a extends com.baidu.mobads.container.util.d.a {
        private boolean b = false;

        protected a() {
        }

        public void a(String str) {
            this.b = true;
            String uniqueId = k.this.mAdInstanceInfo.getUniqueId();
            com.baidu.mobads.container.components.h.c.f fVarA = com.baidu.mobads.container.components.h.c.f.a(k.this.mAppContext);
            fVarA.a(uniqueId, com.baidu.mobads.container.components.h.a.AD_EVENT_CACHE_START);
            fVarA.a(uniqueId, "ty", "video".equals(k.this.mAdInstanceInfo.getCreativeType().b()) ? "im" : "vd");
        }

        @Override // com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, int i) {
            if (this.b) {
                com.baidu.mobads.container.components.h.c.f.a(k.this.mAppContext).a(k.this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.b.a.h, String.valueOf(i));
            }
        }

        @Override // com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, com.baidu.mobads.container.util.d.c cVar) {
            if (this.b) {
                com.baidu.mobads.container.components.h.c.f.a(k.this.mAppContext).a(k.this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.b.a.i, str2);
                com.baidu.mobads.container.components.h.c.f.a(k.this.mAppContext).a(k.this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.b.a.j, String.valueOf(cVar.a()));
                com.baidu.mobads.container.components.h.c.f.a(k.this.mAppContext).a(k.this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_CACHE_FAILED);
            }
            k.this.try2SendInterceptUrlLog(str2, cVar);
        }

        @Override // com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
        public void a(String str, String str2, View view, Bitmap bitmap) {
            if (this.b) {
                com.baidu.mobads.container.components.h.c.f.a(k.this.mAppContext).a(k.this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_CACHE_SUCCESS);
            }
        }
    }

    protected void loadMaterialForURLString(String str, a aVar) {
        startCacheAssetTimer(aVar);
        if (!(this.mAdContainerCxt instanceof com.baidu.mobads.container.adrequest.o) || ((com.baidu.mobads.container.adrequest.o) this.mAdContainerCxt).a(aVar) == 0) {
            aVar.a(str);
            com.baidu.mobads.container.util.d.d.a(this.mAppContext, str).c.a(1000, 2000).a((d.InterfaceC0136d) aVar);
        }
    }

    protected void startCacheAssetTimer(com.baidu.mobads.container.util.d.a aVar) {
        if (this.mAdContainerCxt instanceof com.baidu.mobads.container.adrequest.o) {
            if (this.mCacheAssetTimer == null) {
                this.mCacheAssetTimer = new aj(this, aVar);
            }
            this.mCacheAssetTimeRunning.set(true);
            ((com.baidu.mobads.container.adrequest.o) this.mAdContainerCxt).a(this.mCacheAssetTimer, 3000);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void disposeCacheAssetTimer() {
        if (this.mAdContainerCxt instanceof com.baidu.mobads.container.adrequest.o) {
            ((com.baidu.mobads.container.adrequest.o) this.mAdContainerCxt).a(this.mCacheAssetTimer);
            this.mCacheAssetTimer = null;
        }
    }

    protected void sendSplashShakeLog(String str) {
        try {
            by.a.a(this.mAppContext.getApplicationContext()).a(804).b(getAdContainerContext().l()).a(this.mAdInstanceInfo).a("prod", "rsplash").a("reason", str).a("materialtype", this.mAdInstanceInfo.getMaterialType()).g();
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.h(TAG).f(th.getMessage());
        }
    }

    public void setAdContainerView(String str, View view) {
        this.m.put(str, new WeakReference<>(view));
    }

    public View getAdContainerView(String str) {
        WeakReference<View> weakReference = this.m.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        return getAdContainerContext().v();
    }

    public com.baidu.mobads.container.o.b getClickInfo() {
        return this.mClickTracker;
    }

    public void setCKString(String str) {
        this.e = str;
    }

    public String getCkString() {
        return this.e;
    }

    public void clearCKInfo() {
        this.e = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasSlide() {
        int iOptInt;
        if (this.mAdInstanceInfo == null || this.mAdCloudConfigs == null) {
            return false;
        }
        JSONObject jSONObjectA = this.mAdCloudConfigs.a("slide_config");
        if (jSONObjectA == null) {
            iOptInt = 0;
        } else {
            iOptInt = jSONObjectA.optInt("ad_slide", 0);
        }
        return iOptInt == 1;
    }

    protected boolean clickRegionUsed() {
        return (this.mLimitRegionClick || this.mDisplayClickButton) && !hasSlide();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addAtmosphereView() {
        List<String> arrayList;
        int iOptInt;
        try {
            if (com.baidu.mobads.container.util.x.a(null).a() < 25) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            int i = 1;
            int iOptDouble = 3500;
            double dOptDouble = 0.25d;
            if (this.mAdInstanceInfo != null && this.mAdCloudConfigs != null) {
                JSONObject jSONObjectA = this.mAdCloudConfigs.a("atmosphere");
                if (jSONObjectA == null) {
                    iOptInt = 0;
                } else {
                    iOptInt = jSONObjectA.optInt("ad_atmosphere", 0);
                    this.j = jSONObjectA.optInt("click", 1) == 1;
                    iOptDouble = (int) (jSONObjectA.optDouble("duration", 3.5d) * 1000.0d);
                    dOptDouble = jSONObjectA.optDouble("size", 0.25d);
                }
                if (iOptInt == 0) {
                    return;
                }
                String str = com.baidu.mobads.container.o.j.b("atmosphere_view") + com.baidu.mobads.container.o.j.a + iOptDouble;
                try {
                    JSONObject jSONObjectOptJSONObject = this.mAdInstanceInfo.getOriginJsonObject().optJSONObject("cloud_control");
                    if (jSONObjectOptJSONObject != null && (jSONArray = jSONObjectOptJSONObject.optJSONArray("atmosphere_pic")) != null) {
                        str = str + com.baidu.mobads.container.o.j.a + c(jSONArray.getString(0));
                    }
                } catch (Exception e) {
                }
                b(str);
                List<String> imageList = getImageList(jSONArray);
                if (imageList != null) {
                    arrayList = imageList;
                } else {
                    arrayList = new ArrayList();
                }
                if (arrayList.size() == 0) {
                    Integer numA = com.component.b.a.a().a("rsp_big_red_heart");
                    if (numA != null) {
                        arrayList.add(numA + "");
                    }
                    Integer numA2 = com.component.b.a.a().a("rsp_small_red_heart");
                    if (numA2 != null) {
                        arrayList.add(numA2 + "");
                    }
                    if (numA == null && numA2 == null) {
                        return;
                    }
                }
                this.mObjectAnimatorList = new ArrayList();
                int iC = com.baidu.mobads.container.util.ab.c(this.mAppContext);
                int iB = com.baidu.mobads.container.util.ab.b(this.mAppContext);
                RelativeLayout relativeLayout = new RelativeLayout(this.mAppContext);
                this.mAdContainerCxt.v().addView(relativeLayout, new RelativeLayout.LayoutParams(iB, iC));
                int i2 = 3;
                while (i2 <= 12) {
                    ImageView imageView = new ImageView(this.mAppContext);
                    if (this.j) {
                        imageView.setOnClickListener(new ak(this));
                    }
                    String randomImageString = getRandomImageString(arrayList, i2);
                    try {
                        if (randomImageString.contains(com.alipay.sdk.m.l.a.r)) {
                            com.baidu.mobads.container.util.d.d.a(this.mAppContext).b(imageView, randomImageString);
                        } else {
                            imageView.setImageResource(Integer.parseInt(randomImageString));
                        }
                    } catch (Exception e2) {
                    }
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    double dB = com.baidu.mobads.container.util.ab.b(this.mAppContext);
                    Double.isNaN(dB);
                    int i3 = (int) (dB * dOptDouble);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
                    int iB2 = (com.baidu.mobads.container.util.ab.b(this.mAppContext) / 3) - i3;
                    int iC2 = (com.baidu.mobads.container.util.ab.c(this.mAppContext) / 4) - i3;
                    int i4 = i2 == 0 ? 0 : (i2 - 1) / 3;
                    int i5 = i2 % 3 == 0 ? 2 : (i2 % 3) - 1;
                    if (i2 % 3 == i) {
                        double d = iB2;
                        double dRandom = Math.random();
                        Double.isNaN(d);
                        layoutParams.setMargins(((int) (d * dRandom)) + ((i5 * com.baidu.mobads.container.util.ab.b(this.mAppContext)) / 3), (-iC) + iC2 + ((i4 * com.baidu.mobads.container.util.ab.c(this.mAppContext)) / 4), 0, 0);
                    } else if (i2 % 3 == 2) {
                        double d2 = iB2;
                        double dRandom2 = Math.random();
                        Double.isNaN(d2);
                        layoutParams.setMargins(((int) (d2 * dRandom2)) + ((i5 * com.baidu.mobads.container.util.ab.b(this.mAppContext)) / 3), (-iC) + ((i4 * com.baidu.mobads.container.util.ab.c(this.mAppContext)) / 4), 0, 0);
                    } else if (i2 % 3 == 0) {
                        double d3 = iB2;
                        double dRandom3 = Math.random();
                        Double.isNaN(d3);
                        int iB3 = ((int) (d3 * dRandom3)) + ((i5 * com.baidu.mobads.container.util.ab.b(this.mAppContext)) / 3);
                        int i6 = -iC;
                        double d4 = iC2;
                        Double.isNaN(d4);
                        layoutParams.setMargins(iB3, i6 + ((int) (d4 * 0.5d)) + ((i4 * com.baidu.mobads.container.util.ab.c(this.mAppContext)) / 4), 0, 0);
                    }
                    relativeLayout.addView(imageView, layoutParams);
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationY", 0.0f, com.baidu.mobads.container.util.ab.c(this.mAppContext) * 2);
                    objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                    if (i2 % 3 == 0) {
                        double d5 = iOptDouble * 2;
                        Double.isNaN(d5);
                        objectAnimatorOfFloat.setDuration((long) (d5 * 0.93d));
                    } else {
                        objectAnimatorOfFloat.setDuration(iOptDouble * 2);
                    }
                    this.mObjectAnimatorList.add(objectAnimatorOfFloat);
                    objectAnimatorOfFloat.start();
                    i2++;
                    i = 1;
                }
            }
        } catch (Throwable th) {
        }
    }

    protected List<String> getImageList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (com.baidu.mobads.container.util.d.d.a(this.mAppContext).e(string) != null) {
                            arrayList.add(string);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        if (jSONArray != null && arrayList.size() == jSONArray.length()) {
            return arrayList;
        }
        return new ArrayList();
    }

    protected String getRandomImageString(List<String> list, int i) {
        if (list != null && list.size() > 0) {
            String str = list.get(0);
            try {
                if (list.size() == 2) {
                    return list.get(i % 2);
                }
                double dRandom = Math.random();
                double size = list.size();
                Double.isNaN(size);
                return list.get((int) (dRandom * size));
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addBubbleView() {
        if (com.baidu.mobads.container.util.x.a(null).a() < 25) {
            return;
        }
        try {
            if (this.mAdInstanceInfo != null && this.mAdCloudConfigs != null && this.mAdCloudConfigs.a("bubble_enable", 0) == 1) {
                int iA = this.mAdCloudConfigs.a("bubble_click", 1);
                int iA2 = this.mAdCloudConfigs.a("bubble_duration", 5);
                JSONArray jSONArrayB = this.mAdCloudConfigs.b("bubble_images");
                String str = com.baidu.mobads.container.o.j.b("bubble_widget") + com.baidu.mobads.container.o.j.a + "0" + com.baidu.mobads.container.o.j.a + iA2;
                if (jSONArrayB != null) {
                    try {
                        if (jSONArrayB.length() > 0) {
                            str = str + com.baidu.mobads.container.o.j.a + c(jSONArrayB.getString(0));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                b(str);
                this.r = new com.baidu.mobads.container.s.p(this.mAppContext, new p.a().a(iA).b(iA2).a(this.q), this, this.mAdInstanceInfo);
                this.r.a(new am(this));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                if (this.mAdContainerCxt != null && this.mAdContainerCxt.v() != null) {
                    this.mAdContainerCxt.v().addView(this.r, layoutParams);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void sendSplashFailedLog(String str) {
        try {
            if (!com.baidu.mobads.container.config.a.a().b()) {
                return;
            }
            by.a.a(this.mAppContext).a(822).a("msg", "曝光失败").a("status", str).a(this.mAdInstanceInfo).f();
        } catch (Throwable th) {
        }
    }

    public void try2SendInterceptUrlLog(String str, com.baidu.mobads.container.util.d.c cVar) {
        if (cVar != null) {
            try {
                String strC = cVar.c();
                if (cVar.a() == -1 && !TextUtils.isEmpty(strC)) {
                    by.a.a(this.mAppContext).a(432).a("msg", "intercept").a(this.mAdContainerCxt.z()).c(this.mAdContainerCxt.k()).b(this.mAdContainerCxt.l()).a(this.mAdInstanceInfo).a(ClickCommon.CLICK_AREA_MATERIAL, a(str)).a("url", a(strC)).f();
                }
            } catch (Throwable th) {
                this.mAdLogger.a(th);
            }
        }
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 128) {
            return str.substring(0, 125) + "...";
        }
        return str;
    }

    public boolean isLottieShakeView() {
        JSONObject originJsonObject;
        JSONObject jSONObjectOptJSONObject;
        try {
            if (com.baidu.mobads.container.util.x.a(null).a() > 25 && (originJsonObject = this.mAdInstanceInfo.getOriginJsonObject()) != null && (jSONObjectOptJSONObject = originJsonObject.optJSONObject("cloud_control")) != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt(ILogConst.E_AD_SHAKE, 0);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("splash_turn", 0);
                if (iOptInt2 == 1 && iOptInt == 0) {
                    String strOptString = jSONObjectOptJSONObject.optString("splash_turn_lottie");
                    if (!TextUtils.isEmpty(strOptString) && com.baidu.mobads.container.util.d.d.a(this.mAppContext).b(strOptString, d.e.COMMON)) {
                        return true;
                    }
                }
                if (iOptInt2 == 0 && iOptInt == 1) {
                    String strOptString2 = jSONObjectOptJSONObject.optString("splash_shake_lottie");
                    if (!TextUtils.isEmpty(strOptString2)) {
                        if (com.baidu.mobads.container.util.d.d.a(this.mAppContext).b(strOptString2, d.e.COMMON)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public String parseDlToast(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("cloud_control")) != null && 1 == jSONObjectOptJSONObject.optInt(com.baidu.mobads.container.components.k.c.a, 1)) {
            return jSONObjectOptJSONObject.optString(com.baidu.mobads.container.components.k.c.b, com.baidu.mobads.container.components.k.c.d);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getCloudControlStr(String str, String str2) {
        if (this.mAdCloudConfigs != null) {
            return this.mAdCloudConfigs.a(str, str2);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCloudControlInt(String str, int i) {
        if (this.mAdCloudConfigs != null) {
            return this.mAdCloudConfigs.a(str, i);
        }
        return i;
    }

    protected com.baidu.mobads.container.u.b getSplashTransition() {
        if (this.k == null) {
            synchronized (com.baidu.mobads.container.u.b.class) {
                if (this.k == null) {
                    this.k = new com.baidu.mobads.container.u.b(this, this.mAdInstanceInfo);
                    com.baidu.mobads.container.components.i.a aVar = new com.baidu.mobads.container.components.i.a(this.mAppContext, this.mAdInstanceInfo.getOriginJsonObject());
                    int iA = aVar.a("splash_focus_style", 1);
                    this.s = aVar.a("focus_dl_dialog", 0);
                    if (iA == 1) {
                        b(String.valueOf(com.baidu.mobads.container.o.j.b("splash_focus_card")));
                    } else {
                        b(String.valueOf(com.baidu.mobads.container.o.j.b("splash_focus_zoom_out")));
                    }
                }
            }
        }
        return this.k;
    }

    public void skipBtnClick() {
        cm cmVar = new cm(com.baidu.mobads.container.components.k.b.m);
        if (this.mAdContainerCxt != null && this.mAdContainerCxt.s() != null) {
            this.mAdContainerCxt.s().dispatchEvent(cmVar);
        }
        this.reasonValue = 6;
        this.clickSkip = true;
        closeAd("user_close");
        if (this.mProgressView != null) {
            this.mProgressView.f();
        }
    }

    private void a(View view) {
        try {
            JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
            if (originJsonObject != null) {
                String strOptString = originJsonObject.optString("cloud_control");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    this.o = jSONObject.optInt("px_close", 0) != 0;
                    int iOptInt = jSONObject.optInt("px_close_w", 1);
                    int iOptInt2 = jSONObject.optInt("px_close_h", 1);
                    if (this.o) {
                        if (iOptInt <= 0) {
                            iOptInt = 1;
                        }
                        int i = iOptInt2 > 0 ? iOptInt2 : 1;
                        b(com.baidu.mobads.container.o.j.b("pixel_click_view") + com.baidu.mobads.container.o.j.a + iOptInt + com.baidu.mobads.container.o.j.a + i);
                        this.n = createPxCloseView(view, iOptInt, i, new an(this));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public View createPxCloseView(View view, int i, int i2, View.OnClickListener onClickListener) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof RelativeLayout)) {
            RelativeLayout relativeLayout = (RelativeLayout) view.getParent();
            RelativeLayout relativeLayout2 = new RelativeLayout(this.mAppContext);
            View view2 = new View(this.mAppContext);
            view2.setOnClickListener(onClickListener);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bv.a(this.mAppContext, i), bv.a(this.mAppContext, i2));
            layoutParams.addRule(13);
            relativeLayout2.addView(view2, layoutParams);
            relativeLayout.addView(relativeLayout2, view.getLayoutParams());
            return relativeLayout2;
        }
        return null;
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(this.mSNameMsgs.toString())) {
            this.mSNameMsgs.append(",");
        }
        this.mSNameMsgs.append(str);
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf == -1 || iLastIndexOf == str.length() - 1) {
            return str;
        }
        return str.substring(iLastIndexOf + 1);
    }
}
