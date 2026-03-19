package com.baidu.mobads.container.rewardvideo;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.components.a;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.aa;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.bs;
import com.baidu.mobads.container.util.k;
import com.baidu.mobads.sdk.api.IActivityImpl;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.component.a.g.a;
import com.component.a.g.c.bx;
import com.sigmob.windad.WindAds;
import com.style.widget.ac;
import com.style.widget.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class RemoteRewardActivity implements IActivityImpl, IOAdEventListener {
    private static final int A = 100;
    public static final double BANNER_DEFAULT_RATING = 4.8d;
    public static final int BANNER_MAX_COMMENTS = 990000;
    public static final int BANNER_MIN_COMMENTS = 10000;
    public static final String JSON_BANNER_COMMENTS_ID = "comments";
    public static final String JSON_BANNER_DESC_ID = "desc";
    public static final String JSON_BANNER_RATING_ID = "rating";
    public static final String JSON_BANNER_SCORE_ID = "score";
    public static final String REWARD_SERVICE_URL = "https://cpu-openapi.baidu.com/api/bes/s";
    protected static final String TAG = "RemoteRewardActivity";
    private static final long W = 100;
    private static final int X = 30000;
    private static final int Y = 27000;
    private static final int ai = 3;
    private static final int aj = 5;
    private static final String b = "landscape";
    private static final String c = "portrait";
    private static final String d = "skiptime";
    private static final String e = "end_frame";
    private static final String f = "关闭广告";
    private static final String g = "跳过";
    private static final String h = "rs_id";
    private static final String i = "stars";
    private static final String j = "main_view";
    private static final String k = "content";
    private static final String l = "title";
    public static boolean mVideoPlaying = false;
    private static final long o = 2000;
    private View B;
    private int E;
    private double F;
    private com.baidu.mobads.container.adrequest.j G;
    private String H;
    private String I;
    private boolean J;
    private float N;
    private com.baidu.mobads.container.adrequest.t P;
    private String Q;
    private Context R;
    private com.baidu.mobads.container.bridge.i T;
    private com.baidu.mobads.container.v.d U;
    private boolean Z;
    private com.baidu.mobads.container.d.a ag;
    private String ak;
    private String am;
    private String an;
    private AnimatorSet ao;
    private com.baidu.mobads.container.components.i.a ap;
    private com.component.a.g.d aq;
    private com.baidu.mobads.container.util.aa av;
    private Activity m;
    private RelativeLayout n;
    private View q;
    private com.baidu.mobads.container.ax r;
    private ImageView s;
    private TextView t;
    private com.component.player.c u;
    private ImageView v;
    private com.style.widget.u w;
    private boolean y;
    private int z;
    private boolean p = false;
    private Map<String, WeakReference<com.baidu.mobads.container.components.command.b>> x = new HashMap();
    private final Handler C = new Handler();
    private final Handler D = new Handler();

    /* renamed from: K, reason: collision with root package name */
    private AtomicBoolean f739K = new AtomicBoolean(false);
    private boolean L = false;
    private boolean M = false;
    private boolean O = true;
    private com.baidu.mobads.container.util.bq S = com.baidu.mobads.container.util.bq.a();
    private String V = "portrait";
    private int aa = 0;
    private int ab = 0;
    private int ac = 0;
    private boolean ad = false;
    private boolean ae = false;
    private boolean af = false;
    private String ah = "";
    private int al = 3;
    private boolean ar = false;
    private int as = -1;
    private int at = 7;
    private final com.baidu.mobads.container.o.b au = new com.baidu.mobads.container.o.b();
    protected String showAdType = "video";
    com.baidu.mobads.container.bridge.ao a = new by(this);
    private Runnable aw = new cd(this);
    private long ax = 0;

    public RemoteRewardActivity(com.baidu.mobads.container.adrequest.t tVar) {
        this.P = tVar;
        this.U = new com.baidu.mobads.container.v.d(this.P);
        this.ak = this.P.z();
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        this.m = activity;
        if (this.P != null) {
            this.P.a(this.m);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        mVideoPlaying = true;
        if (this.m == null) {
            return;
        }
        Intent intent = this.m.getIntent();
        if (intent != null) {
            this.m.getWindow().setFormat(-2);
            this.V = intent.getStringExtra("orientation");
            if (TextUtils.isEmpty(this.V)) {
                this.V = "portrait";
            }
            this.Z = intent.getBooleanExtra("useSurfaceView", false);
            this.L = intent.getBooleanExtra("showDialogOnSkip", false);
            this.af = intent.getBooleanExtra("useRewardCountdown", false);
            this.al = intent.getIntExtra("downloadConfirmPolicy", 3);
            this.am = intent.getStringExtra("userid");
            this.an = intent.getStringExtra("extra");
            e();
        }
        a();
        try {
            if (com.baidu.mobads.container.util.x.a(this.m).a() > 22) {
                this.m.getWindow().requestFeature(1);
                this.m.getWindow().addFlags(128);
                this.m.getWindow().addFlags(1024);
            }
        } catch (Throwable th) {
            this.S.a(TAG, "exception when requestWindowFeature");
        }
        a(this.m, true);
        f();
        I();
        if (com.baidu.mobads.container.util.bv.j(this.m) && this.V.equals("portrait")) {
            this.m.setContentView(com.baidu.mobads.container.util.bv.a(this.m, this.n, false));
        } else {
            this.m.setContentView(this.n);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
        a(this.at);
        this.at = 7;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
        try {
            a(this.m, true);
            if (this.J && !this.M) {
                D();
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.f(th.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        return true;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        mVideoPlaying = false;
        K();
        k();
        if (this.q != null) {
            this.D.removeCallbacksAndMessages(null);
            if (!this.ar && (this.q instanceof com.baidu.mobads.container.ax)) {
                ((com.baidu.mobads.container.ax) this.q).destroy();
            }
            this.q = null;
        }
        if (this.r != null) {
            this.r.destroy();
            this.r = null;
        }
        if (this.u != null) {
            this.u.e();
            this.u = null;
        }
        if (this.n != null) {
            this.n.removeAllViews();
        }
        setActivity(null);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
        this.S.b(TAG, "onWindowFocusChanged" + z);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.S.b(TAG, "onTouchEvent");
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onAttachedToWindow() {
        this.S.b(TAG, "onAttachedToWindow");
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
        mVideoPlaying = false;
        this.S.b(TAG, "onDetachedFromWindow");
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    private void a() {
        this.R = this.m.getApplicationContext();
        this.n = new bk(this, this.m);
        this.n.removeAllViews();
        this.n.setLayoutParams(d());
        this.n.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout = new RelativeLayout(this.m);
        relativeLayout.setLayoutParams(this.n.getLayoutParams());
        relativeLayout.setBackgroundColor(-16777216);
        this.n.addView(relativeLayout);
        this.G = this.P.q();
        this.z = this.G.getCloseType();
        this.H = this.G.getVideoUrl();
        this.Q = this.P.k();
        this.af &= !y();
        try {
            JSONObject originJsonObject = this.G.getOriginJsonObject();
            if (originJsonObject != null) {
                this.ah = originJsonObject.optString(e, "");
                if (y()) {
                    this.ab = 5;
                }
                if (originJsonObject.has(d)) {
                    this.ab = originJsonObject.optInt(d, this.ab);
                }
                if (originJsonObject.has(h)) {
                    this.ac = originJsonObject.optInt(h, 0);
                }
                this.ap = new com.baidu.mobads.container.components.i.a(this.R, originJsonObject);
                JSONObject jSONObjectA = this.ap.a("rvideo_config");
                if (jSONObjectA != null) {
                    try {
                        this.as = Integer.parseInt(jSONObjectA.optString("skiptype", String.valueOf(this.as)));
                    } catch (Exception e2) {
                        this.as = -1;
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    private boolean b() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return com.baidu.mobads.container.v.c.a;
    }

    private RelativeLayout.LayoutParams d() {
        int iC;
        int iB;
        if (this.V.equals("portrait")) {
            iC = com.baidu.mobads.container.util.ab.b(this.m);
            iB = com.baidu.mobads.container.util.ab.c(this.m);
        } else if (!this.V.equals("landscape")) {
            iC = 0;
            iB = 0;
        } else {
            iC = com.baidu.mobads.container.util.ab.c(this.m);
            iB = com.baidu.mobads.container.util.ab.b(this.m);
        }
        return new RelativeLayout.LayoutParams(iC, iB);
    }

    private void e() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        com.baidu.mobads.container.util.h.a(this.m);
        if (com.baidu.mobads.container.util.x.a(this.R).a() > 26) {
            if (this.V.equals("portrait")) {
                this.m.setRequestedOrientation(1);
            } else if (this.V.equals("landscape")) {
                this.m.setRequestedOrientation(0);
            }
        }
    }

    private void f() {
        this.S.b(TAG, "startRender");
        if (!TextUtils.isEmpty(this.H)) {
            boolean z = true;
            sendRVideoLog(1);
            try {
                if (a("native_rvideo", 0) != 1) {
                    z = false;
                }
                this.ar = z;
                if (this.ac == 20035 && "portrait".equals(this.V)) {
                    l();
                } else {
                    h();
                }
                i();
                g();
                return;
            } catch (Exception e2) {
                this.S.b(TAG, "addVideoView异常" + e2.getMessage());
                sendRVideoLog(2);
                return;
            }
        }
        J();
    }

    private void g() {
        if (this.u != null && this.R != null && this.G != null && a("video_click", 0) == 1) {
            this.u.setOnClickListener(new bw(this));
        }
    }

    private void h() {
        boolean z;
        this.f739K.set(false);
        this.u = new com.component.player.c(this.m);
        this.u.a(new ci(this));
        this.u.setId(1005);
        this.u.a(new cq(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        try {
            if (this.ac == 20036) {
                int iB = com.baidu.mobads.container.util.ab.b(this.m);
                int iC = com.baidu.mobads.container.util.ab.c(this.m);
                int i2 = (iB * 9) / 16;
                if (iB > 0) {
                    layoutParams.height = i2;
                    layoutParams.addRule(13);
                }
                if (this.w == null) {
                    this.w = new com.style.widget.u(this.R);
                    if (a("rvideo_dl_pause", 0) != 1) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.w.d(z);
                    this.w.setId(1006);
                    Double.isNaN(com.baidu.mobads.container.util.ab.b(this.m, com.baidu.mobads.container.util.ab.b(this.m)));
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.m, r11 - (((int) (r14 * 0.029d)) * 2)), com.baidu.mobads.container.util.ab.a(this.m, 38.0f));
                    layoutParams2.addRule(14);
                    layoutParams2.addRule(3, this.u.getId());
                    layoutParams2.topMargin = (((iC - i2) / 2) / 2) - com.baidu.mobads.container.util.ab.a(this.m, 20.0f);
                    this.w.d(-1);
                    this.w.e(com.baidu.mobads.container.util.ab.a(this.R, 14.0f));
                    this.w.a(Typeface.defaultFromStyle(1));
                    this.w.b(Color.parseColor("#4E6EF2"));
                    this.w.setBackgroundColor(Color.parseColor("#D7E6FF"));
                    if (this.G.getActionType() == 2) {
                        this.w.a("立即下载");
                        this.w.b(this.G.getAppPackageName());
                        com.baidu.mobads.container.b.c.a().a(this.G.getAppPackageName(), this.w);
                    } else {
                        this.w.a("查看详情");
                    }
                    String actRefinedText = this.G.getActRefinedText();
                    if (!TextUtils.isEmpty(actRefinedText)) {
                        this.w.a(actRefinedText);
                    }
                    this.w.setOnClickListener(new cr(this));
                    j();
                    if (this.n != null) {
                        this.n.addView(this.w, layoutParams2);
                    }
                    a(this.w, com.baidu.mobads.container.util.ab.a(this.m, 9.0f));
                    m();
                    View adLogoView = getAdLogoView();
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams3.addRule(11);
                    layoutParams3.addRule(12);
                    layoutParams3.bottomMargin = com.baidu.mobads.container.util.bv.a((Context) this.m, 12.0f);
                    layoutParams3.rightMargin = com.baidu.mobads.container.util.bv.a((Context) this.m, 12.0f);
                    if (adLogoView != null && this.n != null) {
                        this.n.addView(adLogoView, layoutParams3);
                    }
                }
            }
        } catch (Throwable th) {
            this.S.c(TAG, th.getLocalizedMessage());
        }
        if (this.n != null) {
            this.n.addView(this.u, layoutParams);
        }
        if ((this.V.equals("landscape") || this.ac != 20036) && this.ar) {
            View adLogoView2 = getAdLogoView();
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(11);
            layoutParams4.addRule(12);
            layoutParams4.bottomMargin = com.baidu.mobads.container.util.bv.a((Context) this.m, 12.0f);
            layoutParams4.rightMargin = com.baidu.mobads.container.util.bv.a((Context) this.m, 12.0f);
            if (adLogoView2 != null && this.n != null) {
                this.n.addView(adLogoView2, layoutParams4);
            }
        }
        this.u.e();
        this.u.c(this.Z);
        this.u.a(new cs(this));
        this.u.a(this.H);
        this.u.d();
    }

    private void i() {
        TextView textView = new TextView(this.R);
        if (this.G != null) {
            textView.setText(com.component.a.g.c.k.a(this.G.getBuyer()));
        }
        textView.setTextSize(1, 10.0f);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.getPaint().setShadowLayer(2.0f, 3.0f, 3.0f, -16777216);
        textView.setAlpha(0.3f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.leftMargin = com.baidu.mobads.container.util.ab.a(this.R, 25.0f);
        layoutParams.bottomMargin = com.baidu.mobads.container.util.ab.a(this.R, 4.0f);
        if (this.n != null) {
            this.n.addView(textView, layoutParams);
        }
    }

    public void registerDwonloadListeners(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null && com.baidu.mobads.container.components.k.b.u.equals(iOAdEvent.getType())) {
            try {
                String message = iOAdEvent.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    this.x = com.baidu.mobads.container.b.c.a().b();
                    if (this.x != null && this.x.size() > 0) {
                        for (String str : this.x.keySet()) {
                            if (str.contains(message) && this.x.get(str) != null && this.x.get(str).get() != null) {
                                this.x.get(str).get().a();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                this.S.a(th);
            }
        }
    }

    private void j() {
        try {
            if (this.G == null || this.R == null || this.n == null || a("banner_click", 3) != 0) {
                return;
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.R);
            relativeLayout.setBackgroundColor(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, this.u.getId());
            layoutParams.addRule(12);
            relativeLayout.setOnClickListener(new ct(this));
            this.n.addView(relativeLayout, layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(View view, int i2) {
        int btnStyleType = this.G.getBtnStyleType();
        int[] iArr = new int[4];
        iArr[0] = -35564;
        iArr[1] = -648683;
        iArr[2] = -3602220;
        iArr[3] = -194648;
        List<String> btnStyleColors = this.G.getBtnStyleColors();
        if (btnStyleColors != null && btnStyleColors.size() == 4) {
            for (int i3 = 0; i3 < btnStyleColors.size(); i3++) {
                iArr[i3] = Color.parseColor(btnStyleColors.get(i3));
            }
        }
        this.ao = com.baidu.mobads.container.util.animation.j.a(view, i2, btnStyleType, iArr, a.EnumC0133a.PAINT);
        if (this.P != null) {
            com.baidu.mobads.container.util.by.a(this.P, (AbstractData) null, this.G, 1);
        }
    }

    private void k() {
        com.baidu.mobads.container.util.h.a(new cu(this));
    }

    private void l() {
        this.f739K.set(false);
        this.u = new com.component.player.c(this.m);
        this.u.a(new cv(this));
        this.u.setId(1036);
        this.u.a(new bl(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int iB = com.baidu.mobads.container.util.ab.b(this.m);
        if (iB > 0) {
            layoutParams.height = (iB * 9) / 16;
            layoutParams.addRule(10);
        }
        if (this.n != null) {
            this.n.addView(this.u, layoutParams);
        }
        this.u.e();
        this.u.c(this.Z);
        this.u.a(new bn(this));
        this.u.a(this.H);
        this.u.d();
        ax.c cVar = new ax.c();
        cVar.a = b();
        this.r = com.baidu.mobads.container.ax.a(this.m, com.baidu.mobads.container.util.bq.a(), true, true, cVar);
        this.r.setBackgroundColor(-16777216);
        a((WebView) this.r, true);
        this.v = new ImageView(this.m);
        this.v.setScaleType(ImageView.ScaleType.CENTER_CROP);
        com.baidu.mobads.container.util.d.d.a(this.R).b(this.v, this.G.getMainPictureUrl());
        this.v.setOnClickListener(new bo(this));
    }

    private void m() {
        JSONObject originJsonObject = this.G.getOriginJsonObject();
        if (originJsonObject == null || a("dl_desc", 1) == 0) {
            return;
        }
        String strOptString = originJsonObject.optString(com.baidu.mobads.container.components.command.j.I);
        String strOptString2 = originJsonObject.optString("app_version");
        String strOptString3 = originJsonObject.optString("privacy_link");
        String strOptString4 = originJsonObject.optString(com.baidu.mobads.container.components.command.j.L);
        String strOptString5 = originJsonObject.optString(com.baidu.mobads.container.components.command.j.M);
        if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString4) && a(this.G)) {
            v.a aVarA = new v.a(this.m).a(strOptString2, strOptString, strOptString3, strOptString4, strOptString5).a(true).a(-1711276033).a(new bp(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            double d2 = this.m.getResources().getDisplayMetrics().heightPixels;
            Double.isNaN(d2);
            layoutParams.bottomMargin = (int) (d2 * 0.042d);
            if (this.n != null) {
                this.n.addView(aVarA.a(), layoutParams);
            }
        }
    }

    private void a(WebView webView, boolean z) {
        this.p = z;
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setDownloadListener(new bq(this));
        webView.setWebViewClient(new br(this));
        this.T = new com.baidu.mobads.container.v.b(this.U, webView, this.a, this.P);
        if (z) {
            webView.loadDataWithBaseURL(null, this.P.q().getBannerHtmlSnippet(), "text/html", "UTF-8", null);
            RelativeLayout.LayoutParams layoutParamsP = P();
            if (this.n != null) {
                this.n.addView(webView, layoutParamsP);
                return;
            }
            return;
        }
        String intHtmlSnippet = this.P.q().getIntHtmlSnippet();
        if (L()) {
            webView.loadUrl(this.ah);
        } else {
            webView.loadDataWithBaseURL(null, intHtmlSnippet, "text/html", "UTF-8", null);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (this.n != null) {
            this.n.addView(webView, layoutParams);
        }
        if (L()) {
            Q();
        }
    }

    private boolean n() {
        JSONObject originJsonObject;
        if (!ab.a.APP_DOWNLOAD.equals(com.baidu.mobads.container.util.ab.a(this.R, this.G)) || (originJsonObject = this.G.getOriginJsonObject()) == null || a("dl_desc", 1) == 0) {
            return false;
        }
        return (TextUtils.isEmpty(originJsonObject.optString(com.baidu.mobads.container.components.command.j.I)) || TextUtils.isEmpty(originJsonObject.optString("app_version")) || TextUtils.isEmpty(originJsonObject.optString("privacy_link")) || TextUtils.isEmpty(originJsonObject.optString(com.baidu.mobads.container.components.command.j.L))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String strOptString;
        String str;
        try {
            JSONObject originJsonObject = this.G.getOriginJsonObject();
            if (originJsonObject == null) {
                return;
            }
            JSONObject jSONObjectA = this.ap.a("reward_video");
            if (jSONObjectA == null) {
                strOptString = null;
            } else {
                strOptString = jSONObjectA.optString("json_view");
            }
            if (this.ac == 20036) {
                str = com.component.a.e.a.a;
            } else if (this.ac == 20037) {
                if (n()) {
                    str = com.component.a.e.a.g;
                } else {
                    str = com.component.a.e.a.f;
                }
            } else if (n()) {
                str = com.component.a.e.a.c;
            } else {
                str = com.component.a.e.a.e;
            }
            if (this.V.equals("landscape")) {
                if (n()) {
                    str = com.component.a.e.a.b;
                } else {
                    str = com.component.a.e.a.d;
                }
            }
            JSONObject jSONObjectA2 = com.component.a.i.n.a(strOptString, str);
            int iA = a("banner_click", 0);
            this.aq = new com.component.a.g.d(this.U, this.G);
            a.C0317a c0317a = new a.C0317a();
            c0317a.a(true, (bx.a) null);
            c0317a.a(new bs(this, this.U, this.G, iA));
            this.aq.a(c0317a);
            bt btVar = new bt(this, originJsonObject);
            if (this.ac == 20036 && this.V.equals("portrait")) {
                this.q = this.aq.a(this.n, jSONObjectA2, O(), btVar);
            } else {
                this.q = this.aq.a(this.n, jSONObjectA2, btVar);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        ax.c cVar = new ax.c();
        cVar.a = b();
        this.q = com.baidu.mobads.container.ax.a(this.m, com.baidu.mobads.container.util.bq.a(), true, true, cVar);
        this.q.setVisibility(4);
        a((WebView) this.q, true);
        this.D.postDelayed(new bu(this), o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str, JSONObject jSONObject) {
        if (JSON_BANNER_SCORE_ID.equals(str)) {
            view.setVisibility(q() ? 0 : 8);
            return;
        }
        if (JSON_BANNER_RATING_ID.equals(str) && (view instanceof TextView)) {
            if (q()) {
                ((TextView) view).setText(String.valueOf(new BigDecimal(jSONObject.optDouble(JSON_BANNER_RATING_ID, 4.8d)).setScale(1, 4).doubleValue()));
                return;
            } else {
                view.setVisibility(8);
                return;
            }
        }
        if (i.equals(str) && (view instanceof RelativeLayout)) {
            if (!q()) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (JSON_BANNER_COMMENTS_ID.equals(str) && (view instanceof TextView)) {
            if (q()) {
                int i2 = BANNER_MAX_COMMENTS;
                int iOptInt = jSONObject.optInt(JSON_BANNER_COMMENTS_ID, BANNER_MAX_COMMENTS);
                if (iOptInt <= 10000) {
                    i2 = 10000;
                } else if (iOptInt < 990000) {
                    i2 = iOptInt;
                }
                ((TextView) view).setText(new BigDecimal(i2 / 10000).setScale(1, 4).doubleValue() + "万个评分");
                return;
            }
            view.setVisibility(8);
            return;
        }
        if (JSON_BANNER_DESC_ID.equals(str) && (view instanceof TextView)) {
            if ((this.V.equals("landscape") || this.ac != 20036) && q()) {
                view.setVisibility(8);
            } else if (TextUtils.isEmpty(this.G.getDescription())) {
                ((TextView) view).setText(this.G.getTitle());
            }
        }
    }

    private boolean q() {
        return this.G.getActionType() == 2 || this.G.getActionType() == 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        u();
        if (this.t != null && this.n != null) {
            this.n.removeView(this.t);
            this.t = null;
        }
        int iA = com.baidu.mobads.container.util.ab.a(this.m, 15.0f);
        this.t = new bs.a().a(Color.parseColor("#333333")).b(85).d(Color.parseColor("#ffffff")).a(str).c(this.af ? 14 : 16).e(iA).h(iA).g(iA).f(iA).a(new bv(this)).a(this.m);
        this.t.setId(1001);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.baidu.mobads.container.util.ab.a(this.m, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        layoutParams.setMargins(0, com.baidu.mobads.container.util.ab.a(this.m, 12.0f), com.baidu.mobads.container.util.ab.a(this.m, 12.0f), 0);
        if (this.n != null) {
            this.n.addView(this.t, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.s = new ImageView(this.m);
        this.y = this.G.getMute().equals("true");
        s();
        this.s.setOnClickListener(new bx(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.m, 20.0f), com.baidu.mobads.container.util.ab.a(this.m, 20.0f));
        layoutParams.addRule(10);
        if (this.af) {
            layoutParams.addRule(9);
        } else if (w()) {
            layoutParams.addRule(0, 1001);
        } else {
            layoutParams.addRule(11);
        }
        int iA = com.baidu.mobads.container.util.ab.a(this.m, 17.0f);
        layoutParams.setMargins(iA, com.baidu.mobads.container.util.ab.a(this.m, 17.0f), iA, 0);
        if (this.n != null) {
            this.n.addView(this.s, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.u == null) {
            return;
        }
        if (this.y) {
            this.u.b(true);
            com.component.b.a.a().a(this.s, "ic_white_voice_mute");
        } else {
            this.u.b(false);
            com.component.b.a.a().a(this.s, "ic_white_voice");
        }
    }

    private void a(View view, Bitmap bitmap) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            ImageView.class.getMethod("setBackground", BitmapDrawable.class).invoke(view, new BitmapDrawable(this.m.getResources(), bitmap));
        } catch (Exception e2) {
            view.setBackgroundDrawable(new BitmapDrawable(this.m.getResources(), bitmap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            if (this.af) {
                this.B = com.style.widget.ac.a(this.m, new ac.a().a(a.b.TEXT).e(-1).a(14.0f).f(Color.parseColor("#333333")).b(0.25f).c(0.5f));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.baidu.mobads.container.util.ab.a(this.m, 30.0f));
                if (w()) {
                    layoutParams.addRule(0, 1001);
                } else {
                    layoutParams.addRule(11);
                }
                layoutParams.addRule(10);
                layoutParams.setMargins(0, com.baidu.mobads.container.util.ab.a(this.m, 12.0f), com.baidu.mobads.container.util.ab.a(this.m, 12.0f), 0);
                if (this.n != null) {
                    this.n.addView(this.B, layoutParams);
                }
                return;
            }
            this.B = com.style.widget.ac.b(this.m, new ac.a().a(a.b.CIRCLE).a(-1).b(com.baidu.mobads.container.util.ab.a(this.m, 2.0f)).c(-7697782).d(com.baidu.mobads.container.util.ab.a(this.m, 2.0f)).e(-1).a(14.0f).f(-16777216).b(0.5f));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.m, 30.0f), com.baidu.mobads.container.util.ab.a(this.m, 30.0f));
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            layoutParams2.setMargins(com.baidu.mobads.container.util.ab.a(this.m, 12.0f), com.baidu.mobads.container.util.ab.a(this.m, 12.0f), 0, 0);
            if (this.n != null) {
                this.n.addView(this.B, layoutParams2);
            }
        } catch (Exception e2) {
        }
    }

    private void u() {
        if (this.av == null) {
            aa.a aVar = new aa.a(this.m);
            aVar.a("继续观看", new ca(this));
            if (L()) {
                aVar.b("即刻试玩", new cb(this));
            } else {
                aVar.b("残忍关闭", new cc(this));
            }
            this.av = aVar.a();
            this.av.setCancelable(false);
            this.av.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.av.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        this.z = this.G.getCloseType();
        return this.z == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        this.z = this.G.getCloseType();
        if (this.z == 6) {
            return true;
        }
        return false;
    }

    private boolean y() {
        return "fvideo".equals(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.B != null) {
            this.C.removeCallbacksAndMessages(null);
            this.C.postDelayed(this.aw, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.B != null) {
            this.C.removeCallbacksAndMessages(null);
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        a(this.m, false);
        A();
        this.D.removeCallbacksAndMessages(null);
        mVideoPlaying = false;
        if (this.u != null) {
            com.baidu.mobads.container.util.ce.a(G(), this.F, this.G, this.P, 0, 6);
        }
        sendRVideoLog(7);
        HashMap map = new HashMap();
        map.put("play_scale", Float.valueOf(this.N));
        this.G.setCloseTrackers(new ArrayList());
        this.P.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.E, (HashMap<String, Object>) map));
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        sendRVideoLog(15);
        this.P.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.m, "" + this.N));
        this.D.removeCallbacksAndMessages(null);
        if (this.u != null) {
            com.baidu.mobads.container.util.ce.a(G(), this.F, this.G, this.P, 0, 6);
        }
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        if (this.u != null && this.u != null && this.O) {
            this.u.b();
            A();
            com.baidu.mobads.container.util.ce.a(G(), this.F, this.G, this.P, 0, i2);
            this.F = G();
        }
    }

    private void D() {
        if (this.u == null) {
            return;
        }
        if ((this.av == null || !this.av.isShowing()) && this.u != null && this.O) {
            E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        this.u.c();
        z();
        com.baidu.mobads.container.util.ce.a(this.G, this.P, 0, G());
    }

    private int F() {
        if (this.u == null) {
            return 0;
        }
        return this.u.g() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double G() {
        if (this.u == null) {
            return 0.0d;
        }
        double dG = this.u.g();
        Double.isNaN(dG);
        return dG / 1000.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.P.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.I));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TranslateAnimation a(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, view.getMeasuredHeight(), 0.0f);
        translateAnimation.setDuration(W);
        translateAnimation.setInterpolator(new LinearInterpolator());
        return translateAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, boolean z) {
        if (activity == null) {
            return;
        }
        if (z) {
            activity.getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } else {
            activity.getWindow().getDecorView().setSystemUiVisibility(2048);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, WebView webView) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            com.baidu.mobads.container.util.bj.a(webView.getContext(), str);
        } else if (str.startsWith(com.baidu.mobads.container.util.o.e(com.baidu.mobads.container.i.b.a))) {
            webView.loadUrl(str);
        } else {
            this.at = 4;
            com.baidu.mobads.container.adrequest.j jVarQ = this.P.q();
            jVarQ.setClickThroughUrl(str);
            jVarQ.setActionType(1);
            new com.baidu.mobads.container.components.k.c().a((com.baidu.mobads.container.k) this.U, jVarQ, (Boolean) true, (HashMap<String, Object>) null);
        }
        return true;
    }

    private HashMap<String, Object> a(com.baidu.mobads.container.adrequest.t tVar, com.baidu.mobads.container.adrequest.j jVar) {
        return com.baidu.mobads.container.f.b(tVar, jVar);
    }

    public void processAdStart() {
        this.P.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.v));
    }

    public void processAdError(com.baidu.mobads.container.c.a aVar, String str) {
        HashMap map = new HashMap();
        map.put("error_message", str);
        map.put("error_code", Integer.valueOf(aVar.b()));
        this.P.s().dispatchEvent(new com.baidu.mobads.container.util.cm("AdError", (HashMap<String, Object>) map));
    }

    public void rewardVerify() {
        if (this.ae) {
            return;
        }
        this.ae = true;
        if (this.G != null && this.G.isServerVerify() && this.P != null) {
            try {
                HashMap map = new HashMap();
                map.put(WindAds.TRANS_ID, this.G.getQueryKey());
                map.put("user_id", this.am);
                map.put("extra", this.an);
                map.put("apid", this.P.l());
                map.put("appid", this.P.z());
                map.put("os_type", "1");
                map.put("oaid", com.baidu.mobads.container.util.f.z.a(this.R));
                map.put("android_id", "");
                map.put(com.baidu.mobads.container.adrequest.g.z, IDManager.getInstance().c(this.R));
                map.put("cuid", IDManager.getInstance().a(this.R));
                map.put("creative_id", this.G.getAdId());
                com.baidu.mobads.container.components.g.f fVar = new com.baidu.mobads.container.components.g.f(1, com.baidu.mobads.container.util.o.a("https://cpu-openapi.baidu.com/api/bes/s", (HashMap<String, String>) map));
                fVar.a(3000);
                fVar.b(3000);
                fVar.a(new ce(this));
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
            HashMap map = new HashMap();
            map.put("serverVerify", str);
            this.P.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.M, (HashMap<String, Object>) map));
            sendRVideoLog(16);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void I() {
        if (this.n == null) {
            return;
        }
        this.n.getViewTreeObserver().addOnPreDrawListener(new cf(this));
    }

    private void J() {
        ViewPropertyAnimator viewPropertyAnimatorTranslationY;
        try {
            com.baidu.mobads.container.util.h.b(this.m);
            if (this.n == null) {
                viewPropertyAnimatorTranslationY = null;
            } else {
                this.n.setTranslationY(0.0f);
                viewPropertyAnimatorTranslationY = this.n.animate().setDuration(W).translationY(this.n.getMeasuredHeight());
            }
            if (com.baidu.mobads.container.util.x.a(this.R).a() >= 16 && viewPropertyAnimatorTranslationY != null) {
                viewPropertyAnimatorTranslationY.withEndAction(new cg(this));
            } else if (this.m != null) {
                this.m.finish();
            }
        } catch (Exception e2) {
            this.S.c(e2);
        }
    }

    public void finish() {
    }

    private void a(Runnable runnable) {
        JSONObject jSONObjectA;
        if (this.aa <= 0) {
            int i2 = 0;
            try {
                if (this.G != null && this.ap != null && (jSONObjectA = this.ap.a("reward_video")) != null) {
                    i2 = Integer.parseInt(jSONObjectA.optString("rvideo_delay_close", "0"));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            com.baidu.mobads.container.d.b.a().a(new ch(this, runnable), i2, TimeUnit.SECONDS);
            return;
        }
        this.ag = new cj(this, runnable);
        com.baidu.mobads.container.d.b.a().a(this.ag, this.aa, TimeUnit.SECONDS);
    }

    private void K() {
        if (this.ag != null) {
            this.ag.a_();
            this.ag = null;
        }
    }

    private boolean L() {
        return !TextUtils.isEmpty(this.ah);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.B != null && this.B.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.baidu.mobads.container.util.ab.a(this.m, 30.0f));
            layoutParams.addRule(10);
            layoutParams.addRule(0, 1001);
            layoutParams.setMargins(0, com.baidu.mobads.container.util.ab.a(this.m, 12.0f), com.baidu.mobads.container.util.ab.a(this.m, 12.0f), 0);
            this.B.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.s != null && this.s.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.m, 20.0f), com.baidu.mobads.container.util.ab.a(this.m, 20.0f));
            layoutParams.addRule(10);
            layoutParams.addRule(0, 1001);
            layoutParams.setMargins(0, com.baidu.mobads.container.util.ab.a(this.m, 17.0f), com.baidu.mobads.container.util.ab.a(this.m, 17.0f), 0);
            this.s.setLayoutParams(layoutParams);
        }
    }

    private RelativeLayout.LayoutParams O() {
        int iB;
        int i2;
        if (this.ac == 20035) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = this.u.getLayoutParams().height;
            return layoutParams;
        }
        if (this.V.equals("portrait")) {
            iB = com.baidu.mobads.container.util.ab.b(this.m, com.baidu.mobads.container.util.ab.b(this.m));
            double d2 = iB;
            Double.isNaN(d2);
            i2 = (int) (0.029d * d2);
        } else if (!this.V.equals("landscape")) {
            iB = 0;
            i2 = 0;
        } else {
            iB = com.baidu.mobads.container.util.ab.b(this.m, com.baidu.mobads.container.util.ab.c(this.m));
            double d3 = iB;
            Double.isNaN(d3);
            i2 = (int) (d3 * 0.235d);
        }
        int i3 = iB - (i2 * 2);
        if (this.ac != 20036) {
            iB = i3;
        } else {
            int iB2 = (com.baidu.mobads.container.util.ab.b(this.m, com.baidu.mobads.container.util.ab.c(this.m)) - ((iB * 9) / 16)) / 2;
            i2 = 17;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.m, iB), -2);
        layoutParams2.addRule(13);
        if (this.ac == 20036) {
            layoutParams2.addRule(2, this.u.getId());
            float f2 = i2;
            layoutParams2.setMargins(com.baidu.mobads.container.util.ab.a(this.m, f2), com.baidu.mobads.container.util.ab.a(this.m, 40.0f), com.baidu.mobads.container.util.ab.a(this.m, f2), 0);
        } else {
            layoutParams2.addRule(12, -1);
            float f3 = i2;
            layoutParams2.setMargins(com.baidu.mobads.container.util.ab.a(this.m, f3), 0, com.baidu.mobads.container.util.ab.a(this.m, f3), com.baidu.mobads.container.util.ab.a(this.m, 20.0f));
        }
        return layoutParams2;
    }

    private RelativeLayout.LayoutParams P() {
        int iB;
        int i2;
        if (this.ac == 20035) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = this.u.getLayoutParams().height;
            return layoutParams;
        }
        if (this.V.equals("portrait")) {
            d = this.ac == 20037 ? 2.375d : 4.466d;
            iB = com.baidu.mobads.container.util.ab.b(this.m, com.baidu.mobads.container.util.ab.b(this.m));
            double d2 = iB;
            Double.isNaN(d2);
            i2 = (int) (0.029d * d2);
        } else if (!this.V.equals("landscape")) {
            iB = 0;
            i2 = 0;
        } else {
            iB = com.baidu.mobads.container.util.ab.b(this.m, com.baidu.mobads.container.util.ab.c(this.m));
            double d3 = iB;
            Double.isNaN(d3);
            i2 = (int) (d3 * 0.235d);
        }
        int i3 = iB - (i2 * 2);
        double d4 = i3;
        Double.isNaN(d4);
        int iB2 = (int) (d4 / d);
        if (this.ac != 20036) {
            iB = i3;
        } else {
            iB2 = ((com.baidu.mobads.container.util.ab.b(this.m, com.baidu.mobads.container.util.ab.c(this.m)) - ((iB * 9) / 16)) / 2) - 40;
            i2 = 0;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.m, iB), com.baidu.mobads.container.util.ab.a(this.m, iB2));
        layoutParams2.addRule(13);
        if (this.ac == 20036) {
            layoutParams2.addRule(2, this.u.getId());
            float f2 = i2;
            layoutParams2.setMargins(com.baidu.mobads.container.util.ab.a(this.m, f2), com.baidu.mobads.container.util.ab.a(this.m, 40.0f), com.baidu.mobads.container.util.ab.a(this.m, f2), 0);
        } else {
            layoutParams2.addRule(12, -1);
            float f3 = i2;
            layoutParams2.setMargins(com.baidu.mobads.container.util.ab.a(this.m, f3), 0, com.baidu.mobads.container.util.ab.a(this.m, f3), com.baidu.mobads.container.util.ab.a(this.m, 20.0f));
        }
        return layoutParams2;
    }

    private void Q() {
        String str;
        BitmapDrawable bitmapDrawable;
        if (this.n == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.baidu.mobads.container.util.ab.a(this.m, 40));
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, com.baidu.mobads.container.util.ab.a(this.m, 100.0f));
        if (this.G.getActionType() == 1) {
            bitmapDrawable = new BitmapDrawable(com.component.b.a.a().b("ic_white_link"));
            str = "查看详情";
        } else if (this.G.getActionType() == 2) {
            bitmapDrawable = new BitmapDrawable(com.component.b.a.a().b("ic_white_dl"));
            str = "立即下载";
        } else if (this.G.getActionType() != 512) {
            str = "";
            bitmapDrawable = null;
        } else {
            bitmapDrawable = new BitmapDrawable(com.component.b.a.a().b("ic_white_apo"));
            str = "立即打开";
        }
        float f2 = 20;
        com.baidu.mobads.container.util.bs bsVarA = new bs.a().e(com.baidu.mobads.container.util.ab.a(this.m, f2)).h(com.baidu.mobads.container.util.ab.a(this.m, f2)).a(Color.parseColor("#000000")).b(180).a(str).d(Color.parseColor("#ffffffff")).a(new ck(this)).c(12).a(this.m);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, com.baidu.mobads.container.util.ab.a(this.m, 18.0f), com.baidu.mobads.container.util.ab.a(this.m, 18.0f));
            bsVarA.setCompoundDrawablePadding(com.baidu.mobads.container.util.ab.a(this.m, 5.0f));
            bsVarA.setCompoundDrawables(bitmapDrawable, null, null, null);
        }
        this.n.addView(bsVarA, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        try {
            this.O = false;
            if (this.B != null) {
                this.B.setVisibility(4);
            }
            A();
            if (this.ac == 20035) {
                if (this.v != null && this.u != null && this.n != null) {
                    this.n.addView(this.v, this.u.getLayoutParams());
                    this.u.setVisibility(4);
                }
            } else {
                if (this.q != null) {
                    this.q.setVisibility(4);
                }
                ax.c cVar = new ax.c();
                cVar.a = b();
                this.r = com.baidu.mobads.container.ax.a(this.m, com.baidu.mobads.container.util.bq.a(), true, true, cVar);
                a((WebView) this.r, false);
            }
            if (this.u != null) {
                this.u.n();
                this.u.e();
                this.u = null;
            }
            if (this.s != null) {
                this.s.setVisibility(4);
            }
            this.aa = L() ? 3 : 0;
            if (this.t != null && this.n != null) {
                this.n.removeView(this.t);
                this.t = null;
            }
            a(new cl(this));
            if (L() && this.n != null) {
                this.n.addView(new k.a().a(this.m).a());
                sendRVideoLog(12);
            }
            sendRVideoLog(10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void playClick() {
        this.G.setInapp(true);
        this.G.setAutoOpen(true);
        String appStoreLink = this.G.getAppStoreLink();
        if (this.G.getActionType() == 2 && com.baidu.mobads.container.util.e.a.k(this.R) && !com.baidu.mobads.container.util.e.a.i(this.R).booleanValue() && TextUtils.isEmpty(appStoreLink)) {
            com.baidu.mobads.container.util.ab.a(this.m, new cm(this));
        }
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        a(false, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public void a(boolean z, boolean z2) {
        int i2;
        boolean z3;
        if (this.G != null) {
            if (z) {
                i2 = 17;
            } else if (this.p) {
                i2 = 8;
            } else {
                i2 = 9;
            }
            if (a(this.G)) {
                JSONObject originJsonObject = this.G.getOriginJsonObject();
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
                if (c2 == 1) {
                    this.at = 1;
                    a(true, false, i2);
                    return;
                }
                if (1 != this.al) {
                    if (2 == this.al) {
                        this.at = 1;
                        a(this.G, i2);
                        return;
                    } else {
                        a(false, false, i2);
                        return;
                    }
                }
                boolean zBooleanValue = com.baidu.mobads.container.util.e.a.i(this.R).booleanValue();
                if (!zBooleanValue && z3) {
                    this.at = 1;
                    a(this.G, i2);
                    return;
                } else {
                    a(false, zBooleanValue, i2);
                    return;
                }
            }
            this.at = 1;
            a(false, false, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, int i2) {
        if (!this.f739K.getAndSet(true)) {
            sendRVideoLog(5);
            dp.a(this.n, this.G, this.P);
        }
        this.au.b(this.n);
        com.baidu.mobads.container.o.a aVar = new com.baidu.mobads.container.o.a(this.au);
        aVar.a(this.ax);
        sendRVideoLog(i2, aVar);
        XAdInstanceInfoExt xAdInstanceInfoExt = new XAdInstanceInfoExt(this.G);
        xAdInstanceInfoExt.setThirdClickTrackingUrls(dp.a(this.G, this.n, this.au));
        xAdInstanceInfoExt.setActionOnlyWifi(z2);
        HashMap<String, Object> mapA = a(this.P, this.G);
        if (mapA == null) {
            mapA = new HashMap<>();
        }
        mapA.put("use_dialog_frame", Boolean.valueOf(z));
        if (a(com.baidu.mobads.container.components.k.c.a, 1) == 1 && (i2 == 9 || i2 == 8)) {
            mapA.put(com.baidu.mobads.container.components.k.c.b, a(com.baidu.mobads.container.components.k.c.c, com.baidu.mobads.container.components.k.c.d));
        }
        new com.baidu.mobads.container.components.k.c(this).a((com.baidu.mobads.container.k) this.U, (com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExt, (Boolean) true, mapA);
    }

    private void a(com.baidu.mobads.container.adrequest.j jVar, int i2) {
        if (jVar == null || this.m == null) {
            return;
        }
        this.M = true;
        onPause();
        com.baidu.mobads.container.util.ab.b(this.m, new cn(this, i2, jVar));
    }

    private boolean a(com.baidu.mobads.container.adrequest.j jVar) {
        int iOptInt;
        boolean zB;
        JSONObject jSONObject;
        if (jVar != null) {
            int actionType = jVar.getActionType();
            String appPackageName = jVar.getAppPackageName();
            if (actionType == 2) {
                if (com.baidu.mobads.container.util.j.b(this.R, appPackageName)) {
                    return false;
                }
                return !com.baidu.mobads.container.util.bk.b(this.R, jVar.getAppStoreLink());
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
                    zB = com.baidu.mobads.container.util.bk.b(this.R, jSONObject.optString("page", ""));
                } catch (Throwable th2) {
                    th = th2;
                    this.S.b(TAG, "Parse apoStr error: " + th.getMessage());
                    zB = false;
                    if (zB) {
                        return false;
                    }
                    return !com.baidu.mobads.container.util.j.b(this.R, appPackageName);
                }
                if (zB && iOptInt == 2) {
                    return !com.baidu.mobads.container.util.j.b(this.R, appPackageName);
                }
            }
        }
        return false;
    }

    private int a(String str, int i2) {
        if (this.ap != null) {
            return this.ap.a(str, i2);
        }
        return i2;
    }

    private String a(String str, String str2) {
        if (this.ap != null) {
            return this.ap.a(str, str2);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.m == null) {
            return;
        }
        ImageView imageView = new ImageView(this.m);
        a(imageView, com.component.b.a.a().b("ic_white_cross_dark_round"));
        imageView.setOnClickListener(new co(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.m, 30.0f), com.baidu.mobads.container.util.ab.a(this.m, 30.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, com.baidu.mobads.container.util.ab.a(this.m, 12.0f), com.baidu.mobads.container.util.ab.a(this.m, 12.0f), 0);
        if (this.n != null) {
            this.n.addView(imageView, layoutParams);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
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
    public void overridePendingTransition(int i2, int i3) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setLpBussParam(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (a("rvideo_progress", 0) == 1) {
            registerDwonloadListeners(iOAdEvent);
        }
    }

    public View getAdLogoView() {
        try {
            View viewA = com.baidu.mobads.container.util.ba.a(this.m);
            viewA.setOnClickListener(new cp(this));
            return viewA;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    protected void sendRVideoLog(int i2) {
        sendRVideoLog(i2, null);
    }

    protected void sendRVideoLog(int i2, com.baidu.mobads.container.o.a aVar) {
        HashMap<String, String> mapC;
        HashMap<String, String> map;
        if (i2 == 5) {
            this.ax = System.currentTimeMillis();
        }
        if (aVar == null) {
            mapC = null;
        } else {
            mapC = aVar.c();
        }
        HashMap<String, String> mapA = com.baidu.mobads.container.o.e.a(this.R).a(this.Q);
        if (mapC == null) {
            map = mapA;
        } else {
            mapC.putAll(mapA);
            map = mapC;
        }
        if ("rvideo".equals(this.Q)) {
            com.baidu.mobads.container.util.bk.a(this.P, i2, 601, getPlayerInfo(), map, -1, this.showAdType);
        } else if ("fvideo".equals(this.Q)) {
            com.baidu.mobads.container.util.bk.a(this.P, i2, 603, getPlayerInfo(), map, -1, this.showAdType);
        }
    }

    protected HashMap<String, String> getPlayerInfo() {
        if (this.u != null) {
            return this.u.j().g();
        }
        return null;
    }
}
