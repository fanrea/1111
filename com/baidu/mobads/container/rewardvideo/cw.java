package com.baidu.mobads.container.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.aa;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.bs;
import com.baidu.mobads.sdk.api.IActivityImpl;
import com.sigmob.windad.WindAds;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class cw implements IActivityImpl {
    private static final String H = "残忍关闭";
    private static final String I = "继续观看";
    private static final int J = 100;
    private static final int X = 10001;
    public static final String a = "https://cpu-openapi.baidu.com/api/bes/s";
    private static final long ah = System.currentTimeMillis();
    protected static final String b = "RemoteRewardBrowseAty";
    public static boolean c = false;
    public static final int d = 10000;
    private static final String h = "landscape";
    private static final String i = "portrait";
    private static final String j = "skiptime";
    private static final long y = 100;
    private com.baidu.mobads.container.d.a C;
    private String E;
    private String F;
    private com.baidu.mobads.container.components.i.a G;
    private String N;
    private ImageView O;
    private View P;
    private ImageView W;
    private com.baidu.mobads.container.bridge.a ae;
    public com.baidu.mobads.container.util.aa e;
    public com.baidu.mobads.container.ax f;
    private Activity k;
    private RelativeLayout l;
    private com.baidu.mobads.container.adrequest.j n;
    private float q;
    private com.baidu.mobads.container.adrequest.t r;
    private String s;
    private Context t;
    private com.baidu.mobads.container.bridge.i v;
    private com.baidu.mobads.container.v.d w;
    private final Handler m = new Handler();
    private boolean o = false;
    private boolean p = false;
    private com.baidu.mobads.container.util.bq u = com.baidu.mobads.container.util.bq.a();
    private String x = "portrait";
    private int z = 5;
    private boolean A = false;
    private boolean B = false;
    private int D = 3;

    /* renamed from: K, reason: collision with root package name */
    private int f740K = 15000;
    private int L = 0;
    private int M = 0;
    private int Q = -2;
    private int R = 30;
    private int S = 23;
    private int T = 0;
    private int U = 0;
    private int V = 10;
    private int Y = 22;
    private int Z = 22;
    private int aa = 28;
    private int ab = 0;
    private int ac = 0;
    private int ad = 17;
    private int af = -1;
    private final com.baidu.mobads.container.o.b ag = new com.baidu.mobads.container.o.b();
    private AtomicBoolean ai = new AtomicBoolean(false);
    private Runnable aj = new df(this);
    private long ak = 0;
    com.baidu.mobads.container.bridge.x g = new db(this);

    static /* synthetic */ int a(cw cwVar, int i2) {
        int i3 = cwVar.L + i2;
        cwVar.L = i3;
        return i3;
    }

    public cw(com.baidu.mobads.container.adrequest.t tVar) {
        this.r = tVar;
        this.w = new com.baidu.mobads.container.v.d(this.r);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        this.k = activity;
        if (this.r != null) {
            this.r.a(this.k);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        c = true;
        if (this.k == null) {
            return;
        }
        Intent intent = this.k.getIntent();
        if (intent != null) {
            this.k.getWindow().setFormat(-2);
            this.x = intent.getStringExtra("orientation");
            if (TextUtils.isEmpty(this.x)) {
                this.x = "portrait";
            }
            this.o = intent.getBooleanExtra("showDialogOnSkip", true);
            this.D = intent.getIntExtra("downloadConfirmPolicy", 3);
            this.E = intent.getStringExtra("userid");
            this.F = intent.getStringExtra("extra");
            f();
        }
        e();
        try {
            if (com.baidu.mobads.container.util.x.a(this.k).a() > 22) {
                this.k.getWindow().requestFeature(1);
                this.k.getWindow().addFlags(128);
                this.k.getWindow().addFlags(1024);
            }
        } catch (Throwable th) {
            this.u.a(b, "exception when requestWindowFeature");
        }
        a(this.k, true);
        a();
        q();
        if (com.baidu.mobads.container.util.bv.j(this.k)) {
            this.k.setContentView(com.baidu.mobads.container.util.bv.a(this.k, this.l, false));
        } else {
            this.k.setContentView(this.l);
        }
    }

    private void e() {
        try {
            this.t = this.k.getApplicationContext();
            this.l = new cx(this, this.k);
            this.l.removeAllViews();
            this.l.setLayoutParams(h());
            this.l.setBackgroundColor(-16777216);
            RelativeLayout relativeLayout = new RelativeLayout(this.k);
            relativeLayout.setLayoutParams(this.l.getLayoutParams());
            relativeLayout.setBackgroundColor(-16777216);
            this.l.addView(relativeLayout);
            this.n = this.r.q();
            this.s = this.r.k();
            try {
                JSONObject originJsonObject = this.n.getOriginJsonObject();
                if (originJsonObject != null) {
                    this.G = new com.baidu.mobads.container.components.i.a(this.t, originJsonObject);
                    JSONObject jSONObjectA = this.G.a("rvideo_config");
                    this.f740K = this.G.a("rvideo_count_down", 15) * 1000;
                    if (originJsonObject.has(j)) {
                        this.z = originJsonObject.optInt(j, this.z);
                        this.z = Math.min(this.z * 1000, this.f740K) / 1000;
                    }
                    if (jSONObjectA != null) {
                        try {
                            this.af = Integer.parseInt(jSONObjectA.optString("skiptype", String.valueOf(this.af)));
                        } catch (Exception e) {
                            this.af = -1;
                            e.printStackTrace();
                        }
                    }
                    this.N = originJsonObject.optString("page_url", "");
                }
            } catch (Throwable th) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
        x();
        if (this.e != null) {
            this.e.dismiss();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
    }

    private void f() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        com.baidu.mobads.container.util.h.a(this.k);
        if (com.baidu.mobads.container.util.x.a(this.t).a() > 26) {
            if (this.x.equals("portrait")) {
                this.k.setRequestedOrientation(1);
            } else if (this.x.equals("landscape")) {
                this.k.setRequestedOrientation(0);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
        a(this.k, true);
        if (!this.p) {
            y();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        try {
            if (this.f != null) {
                this.f.goBack();
                return true;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        c = false;
        m();
        if (this.f != null) {
            this.f.destroy();
            this.f = null;
        }
        if (this.l != null) {
            this.l.removeAllViews();
        }
        setActivity(null);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
        this.u.b(b, "onWindowFocusChanged" + z);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.u.b(b, "onTouchEvent");
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
        this.u.b(b, "onAttachedToWindow");
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
        c = false;
        this.u.b(b, "onDetachedFromWindow");
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    private boolean g() {
        return false;
    }

    private RelativeLayout.LayoutParams h() {
        int iC;
        int iB;
        if (this.x.equals("portrait")) {
            iC = com.baidu.mobads.container.util.ab.b(this.k);
            iB = com.baidu.mobads.container.util.ab.c(this.k);
        } else if (!this.x.equals("landscape")) {
            iC = 0;
            iB = 0;
        } else {
            iC = com.baidu.mobads.container.util.ab.c(this.k);
            iB = com.baidu.mobads.container.util.ab.b(this.k);
        }
        return new RelativeLayout.LayoutParams(iC, iB);
    }

    public void a() {
        this.u.b(b, "startRender");
        if (!TextUtils.isEmpty(this.N)) {
            try {
                i();
                j();
                o();
                a(5);
                dp.a(this.l, this.n, this.r);
                this.ai.set(true);
                b();
                return;
            } catch (Exception e) {
                this.u.b(b, "addView异常" + e.getMessage());
                return;
            }
        }
        r();
    }

    private void i() {
        ViewGroup viewGroup;
        try {
            if (this.O != null && (viewGroup = (ViewGroup) this.O.getParent()) != null) {
                viewGroup.removeView(this.O);
            }
            this.O = new ImageView(this.k);
            com.component.b.a.a().a(this.O, "ic_white_ad_logo");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.k, 46.0f), com.baidu.mobads.container.util.ab.a(this.k, 13.0f));
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.setMargins(com.baidu.mobads.container.util.ab.a(this.k, 17.0f), com.baidu.mobads.container.util.ab.a(this.k, 30.0f), 0, 0);
            this.O.setOnClickListener(new dc(this));
            if (this.l != null) {
                this.l.addView(this.O, layoutParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void j() {
        ViewGroup viewGroup;
        try {
            if (this.P != null && (viewGroup = (ViewGroup) this.P.getParent()) != null) {
                viewGroup.removeView(this.P);
            }
            int iA = com.baidu.mobads.container.util.ab.a(this.k, 15.0f);
            this.P = new bs.a().a(Color.parseColor("#FFFFFF")).b(50).d(Color.parseColor("#FFFFFF")).c(14).e(iA).h(iA).g(iA).f(iA).a(this.k);
            this.P.setId(10000);
            RelativeLayout.LayoutParams layoutParamsU = u();
            layoutParamsU.addRule(11);
            layoutParamsU.addRule(10);
            if (this.l != null) {
                this.l.addView(this.P, layoutParamsU);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ViewGroup viewGroup;
        try {
            if (this.W != null && (viewGroup = (ViewGroup) this.W.getParent()) != null) {
                viewGroup.removeView(this.W);
            }
            this.W = new ImageView(this.k);
            com.component.b.a.a().a(this.W, "ic_white_cross_dark_round");
            this.W.setId(10001);
            this.W.setOnClickListener(new dd(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.k, this.Y), com.baidu.mobads.container.util.ab.a(this.k, this.Z));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.setMargins(com.baidu.mobads.container.util.ab.a(this.k, this.ac), com.baidu.mobads.container.util.ab.a(this.k, this.aa), com.baidu.mobads.container.util.ab.a(this.k, this.ad), com.baidu.mobads.container.util.ab.a(this.k, this.ab));
            if (this.l != null) {
                this.l.addView(this.W, layoutParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void l() {
        if (this.P != null) {
            this.m.removeCallbacksAndMessages(null);
            this.m.postDelayed(this.aj, y);
        }
    }

    private void m() {
        if (this.P != null) {
            this.m.removeCallbacksAndMessages(null);
        }
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        a(this.k, false);
        m();
        c = false;
        if (this.L < this.f740K && this.L / 1000 != this.M / 1000) {
            dp.a(this.L / 1000, this.M / 1000, this.n, this.r);
        }
        dp.c(this.n, this.r);
        a(7);
        HashMap map = new HashMap();
        map.put("play_scale", Float.valueOf(this.q));
        this.n.setCloseTrackers(new ArrayList());
        this.r.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.E, (HashMap<String, Object>) map));
        r();
    }

    private void a(Activity activity, boolean z) {
        if (activity == null) {
            return;
        }
        try {
            if (z) {
                activity.getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            } else {
                activity.getWindow().getDecorView().setSystemUiVisibility(2048);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void o() {
        try {
            this.ai.set(false);
            ax.c cVar = new ax.c();
            cVar.a = g();
            this.f = com.baidu.mobads.container.ax.a(this.k, com.baidu.mobads.container.util.bq.a(), true, true, cVar);
            this.f.setBackgroundColor(-16777216);
            this.f.setVerticalScrollBarEnabled(false);
            this.f.setHorizontalScrollBarEnabled(false);
            this.f.setWebViewClient(new de(this));
            this.ae = new com.baidu.mobads.container.bridge.a(this.t, this.f, this.r.q(), this.r.k(), this.r.z(), this.g);
            this.v = new com.baidu.mobads.container.v.b(this.w, this.f, this.g, this.r);
            this.f.loadUrl(this.N);
            this.f.setBackgroundColor(-1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, 10000);
            layoutParams.setMargins(0, com.baidu.mobads.container.util.ab.a(this.k, 8.0f), 0, 0);
            if (this.l != null) {
                this.l.addView(this.f, layoutParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.r.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.I));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, WebView webView) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            com.baidu.mobads.container.util.bj.a(webView.getContext(), str);
            return true;
        }
        return true;
    }

    private HashMap<String, Object> a(com.baidu.mobads.container.adrequest.t tVar, com.baidu.mobads.container.adrequest.j jVar) {
        return com.baidu.mobads.container.f.b(tVar, jVar);
    }

    public void b() {
        this.r.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.v));
    }

    public void a(com.baidu.mobads.container.c.a aVar, String str) {
        HashMap map = new HashMap();
        map.put("error_message", str);
        map.put("error_code", Integer.valueOf(aVar.b()));
        this.r.s().dispatchEvent(new com.baidu.mobads.container.util.cm("AdError", (HashMap<String, Object>) map));
    }

    public void c() {
        if (this.B) {
            return;
        }
        this.B = true;
        if (this.n != null && this.n.isServerVerify() && this.r != null) {
            try {
                HashMap map = new HashMap();
                map.put(WindAds.TRANS_ID, this.n.getQueryKey());
                map.put("user_id", this.E);
                map.put("extra", this.F);
                map.put("apid", this.r.l());
                map.put("appid", this.r.z());
                map.put("os_type", "1");
                map.put("oaid", com.baidu.mobads.container.util.f.z.a(this.t));
                map.put("android_id", "");
                map.put(com.baidu.mobads.container.adrequest.g.z, IDManager.getInstance().c(this.t));
                map.put("cuid", IDManager.getInstance().a(this.t));
                map.put("creative_id", this.n.getAdId());
                com.baidu.mobads.container.components.g.f fVar = new com.baidu.mobads.container.components.g.f(1, com.baidu.mobads.container.util.o.a("https://cpu-openapi.baidu.com/api/bes/s", (HashMap<String, String>) map));
                fVar.a(3000);
                fVar.b(3000);
                fVar.a(new dg(this));
                fVar.a();
                return;
            } catch (Throwable th) {
                a("0");
                return;
            }
        }
        a("1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            HashMap map = new HashMap();
            map.put("serverVerify", str);
            this.r.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.M, (HashMap<String, Object>) map));
            a(16);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void q() {
        if (this.l == null) {
            return;
        }
        this.l.getViewTreeObserver().addOnPreDrawListener(new dh(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TranslateAnimation a(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, view.getMeasuredHeight(), 0.0f);
        translateAnimation.setDuration(y);
        translateAnimation.setInterpolator(new LinearInterpolator());
        return translateAnimation;
    }

    private void r() {
        ViewPropertyAnimator viewPropertyAnimatorTranslationY;
        try {
            com.baidu.mobads.container.util.h.b(this.k);
            if (this.l == null) {
                viewPropertyAnimatorTranslationY = null;
            } else {
                this.l.setTranslationY(0.0f);
                viewPropertyAnimatorTranslationY = this.l.animate().setDuration(y).translationY(this.l.getMeasuredHeight());
            }
            if (com.baidu.mobads.container.util.x.a(this.t).a() >= 16 && viewPropertyAnimatorTranslationY != null) {
                viewPropertyAnimatorTranslationY.withEndAction(new di(this));
            } else if (this.k != null) {
                this.k.finish();
            }
        } catch (Exception e) {
            this.u.c(e);
        }
    }

    public void d() {
    }

    private void s() {
        if (this.C != null) {
            this.C.a_();
            this.C = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.P != null && this.P.getVisibility() == 0) {
            RelativeLayout.LayoutParams layoutParamsU = u();
            layoutParamsU.addRule(10);
            layoutParamsU.addRule(0, 10001);
            this.P.setLayoutParams(layoutParamsU);
        }
    }

    private RelativeLayout.LayoutParams u() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.Q, com.baidu.mobads.container.util.ab.a(this.k, this.R));
        layoutParams.setMargins(com.baidu.mobads.container.util.ab.a(this.k, this.U), com.baidu.mobads.container.util.ab.a(this.k, this.S), com.baidu.mobads.container.util.ab.a(this.k, this.V), com.baidu.mobads.container.util.ab.a(this.k, this.T));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        String strSubstring;
        String string;
        int iIndexOf;
        if (this.o) {
            x();
            if ((this.P instanceof com.baidu.mobads.container.util.bs) && (iIndexOf = (string = ((com.baidu.mobads.container.util.bs) this.P).getText().toString()).indexOf("s后可领取奖励")) >= 0 && iIndexOf <= string.length() - 1) {
                strSubstring = string.substring(0, iIndexOf);
            } else {
                strSubstring = "";
            }
            a(this.k, "再看" + strSubstring + "秒可领取奖励哦", new dj(this));
            return;
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public void a(boolean z) {
        boolean z2;
        if (this.n != null) {
            if (a(this.n)) {
                JSONObject originJsonObject = this.n.getOriginJsonObject();
                char c2 = 65535;
                if (originJsonObject == null) {
                    z2 = false;
                } else {
                    int iA = a("dialog_scene", 0);
                    ?? OptInt = z;
                    if (iA == 0) {
                        OptInt = originJsonObject.optInt("dl_dialog", -1);
                    } else if (iA != 1) {
                        OptInt = -1;
                    }
                    z2 = originJsonObject.optInt("notice_dl_non_wifi", 0) == 1;
                    c2 = OptInt;
                }
                if (c2 == 1) {
                    a(true, false, 18);
                    return;
                }
                if (1 != this.D) {
                    if (2 == this.D) {
                        a(this.n, 18);
                        return;
                    } else {
                        a(false, false, 18);
                        return;
                    }
                }
                boolean zBooleanValue = com.baidu.mobads.container.util.e.a.i(this.t).booleanValue();
                if (!zBooleanValue && z2) {
                    a(this.n, 18);
                    return;
                } else {
                    a(false, zBooleanValue, 18);
                    return;
                }
            }
            a(false, false, 18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, int i2) {
        this.ag.b(this.l);
        com.baidu.mobads.container.o.a aVar = new com.baidu.mobads.container.o.a(this.ag);
        aVar.a(this.ak);
        if (!this.ai.getAndSet(true)) {
            a(5);
            dp.a(this.l, this.n, this.r);
        }
        a(i2, aVar);
        XAdInstanceInfoExt xAdInstanceInfoExt = new XAdInstanceInfoExt(this.n);
        xAdInstanceInfoExt.setThirdClickTrackingUrls(dp.a(this.n, this.l, this.ag));
        xAdInstanceInfoExt.setActionOnlyWifi(z2);
        HashMap<String, Object> mapA = a(this.r, this.n);
        if (mapA == null) {
            mapA = new HashMap<>();
        }
        mapA.put("use_dialog_frame", Boolean.valueOf(z));
        new com.baidu.mobads.container.components.k.c(this.ae).a((com.baidu.mobads.container.k) this.w, (com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExt, (Boolean) true, mapA);
    }

    private void a(com.baidu.mobads.container.adrequest.j jVar, int i2) {
        if (jVar == null || this.k == null) {
            return;
        }
        this.p = true;
        onPause();
        com.baidu.mobads.container.util.ab.b(this.k, new cy(this, i2, jVar));
    }

    public void a(Context context, String str, ab.b bVar) {
        if (bVar == null || !(context instanceof Activity)) {
            return;
        }
        this.e = new aa.a(context).b(str).a(16).a(I, new da(this, bVar)).b(H, new cz(this, bVar)).a();
        this.e.setCancelable(false);
        if (this.e.b() != null) {
            this.e.b().setTextColor(Color.parseColor("#1F1F1F"));
        }
        if (this.e.a() != null) {
            this.e.a().setTextColor(Color.parseColor("#4E6EF2"));
        }
        LinearLayout linearLayoutC = this.e.c();
        int childCount = linearLayoutC.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (linearLayoutC.getChildAt(i2) instanceof TextView) {
                TextView textView = (TextView) linearLayoutC.getChildAt(i2);
                if (str.equals(textView.getText().toString())) {
                    textView.getLayoutParams().height = com.baidu.mobads.container.util.ab.a(context, 99.0f);
                    textView.setTextColor(Color.parseColor("#1F1F1F"));
                    textView.getPaint().setFakeBoldText(true);
                }
            }
        }
        this.e.show();
    }

    private boolean a(com.baidu.mobads.container.adrequest.j jVar) {
        int iOptInt;
        boolean zB;
        JSONObject jSONObject;
        if (jVar != null) {
            int actionType = jVar.getActionType();
            String appPackageName = jVar.getAppPackageName();
            if (actionType == 2) {
                if (com.baidu.mobads.container.util.j.b(this.t, appPackageName)) {
                    return false;
                }
                return !com.baidu.mobads.container.util.bk.b(this.t, jVar.getAppStoreLink());
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
                    zB = com.baidu.mobads.container.util.bk.b(this.t, jSONObject.optString("page", ""));
                } catch (Throwable th2) {
                    th = th2;
                    this.u.b(b, "Parse apoStr error: " + th.getMessage());
                    zB = false;
                    if (zB) {
                        return false;
                    }
                    return !com.baidu.mobads.container.util.j.b(this.t, appPackageName);
                }
                if (zB && iOptInt == 2) {
                    return !com.baidu.mobads.container.util.j.b(this.t, appPackageName);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String w() {
        return com.baidu.mobads.container.v.c.a;
    }

    private int a(String str, int i2) {
        if (this.G != null) {
            return this.G.a(str, i2);
        }
        return i2;
    }

    private void x() {
        m();
        if (this.L < this.f740K) {
            dp.a(this.L / 1000, this.M / 1000, this.n, this.r);
            this.M = this.L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        l();
        if (this.L < this.f740K) {
            dp.b(this.n, this.r);
        }
    }

    protected void a(int i2) {
        a(i2, (com.baidu.mobads.container.o.a) null);
    }

    protected void a(int i2, com.baidu.mobads.container.o.a aVar) {
        HashMap<String, String> mapC;
        if (i2 == 5) {
            this.ak = System.currentTimeMillis();
        }
        if (aVar == null) {
            mapC = null;
        } else {
            mapC = aVar.c();
        }
        HashMap map = new HashMap();
        map.put(com.baidu.mobads.container.adrequest.n.j, "");
        map.put("time", System.currentTimeMillis() + "");
        map.put("init_time", String.valueOf(ah));
        JSONObject adStatus = this.n.getAdStatus();
        com.baidu.mobads.container.adrequest.n.a(this.n, com.baidu.mobads.container.adrequest.n.k, com.baidu.mobads.container.adrequest.n.G);
        if (adStatus != null) {
            map.put(com.baidu.mobads.container.adrequest.n.d, String.valueOf(adStatus.optLong(com.baidu.mobads.container.adrequest.n.d, 0L)));
            map.put(com.baidu.mobads.container.adrequest.n.e, String.valueOf(adStatus.optLong(com.baidu.mobads.container.adrequest.n.e, 0L)));
            map.put(com.baidu.mobads.container.adrequest.n.g, String.valueOf(adStatus.optLong(com.baidu.mobads.container.adrequest.n.g, -2L)));
            map.put(com.baidu.mobads.container.adrequest.n.i, String.valueOf(adStatus.optLong(com.baidu.mobads.container.adrequest.n.i, 0L)));
            map.put(com.baidu.mobads.container.adrequest.n.h, String.valueOf(adStatus.optLong(com.baidu.mobads.container.adrequest.n.h, 0L)));
            map.put(com.baidu.mobads.container.adrequest.n.k, String.valueOf(adStatus.optLong(com.baidu.mobads.container.adrequest.n.k, 0L)));
            map.put(com.baidu.mobads.container.adrequest.n.A, adStatus.optString(com.baidu.mobads.container.adrequest.n.A, ""));
        }
        map.putAll(com.baidu.mobads.container.o.e.a(this.t).a(this.s));
        com.baidu.mobads.container.util.bk.a(this.r, i2, 601, map, mapC, -1, "html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        try {
            Intent intent = new Intent();
            intent.putExtra("privacy_link", com.baidu.mobads.container.adrequest.h.g);
            com.baidu.mobads.container.util.h.a(this.k, intent);
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.h(b).f("Show url error: " + th.getMessage());
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
}
