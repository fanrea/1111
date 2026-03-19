package com.baidu.mobads.container.e;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Handler;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSIllegalArgumentException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.activity.o;
import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.bridge.JavascriptHelper;
import com.baidu.mobads.container.components.j.c;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.o.j;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cf;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.component.a.f.e;
import com.component.a.g.a;
import com.component.a.g.c.bm;
import com.component.a.g.c.bo;
import com.component.a.g.c.bx;
import com.component.a.g.c.m;
import com.style.widget.a;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class l extends com.baidu.mobads.container.k {

    /* renamed from: K, reason: collision with root package name */
    private static final int f730K = 100;
    protected static final String a = "ExpressInterstitialAdContainer";
    private TextView A;
    private String B;
    private ImageView C;
    private View D;
    private View E;
    private boolean F;
    private int G;
    private int H;
    private int I;
    private final Handler J;
    private boolean L;
    private View M;
    private View N;
    private View O;
    private View P;
    private boolean Q;
    private TextView R;
    private int S;
    private com.baidu.mobads.container.e.a T;
    private boolean U;
    private boolean V;
    private a.EnumC0796a W;
    private View X;
    private List<ImageView> Y;
    private String Z;
    private TextView aA;
    private ArrayList<ObjectAnimator> aB;
    private int aC;
    private int aD;
    private View aE;
    private View aF;
    private boolean aG;
    private Handler aH;
    private boolean aI;
    private int aJ;
    private boolean aK;
    private m.a aL;
    private m.d aM;
    private m.f aN;
    private int aO;
    private int aP;
    private long aQ;
    private View aR;
    private ObjectAnimator aS;
    private AnimatorSet aT;
    private int aU;
    private int aV;
    private int aW;
    private TextView aX;
    private String aY;
    private View aZ;
    private String aa;
    private boolean ab;
    private boolean ac;
    private final Handler ad;
    private int ae;
    private boolean af;
    private View ag;
    private int ah;
    private int ai;
    private int aj;
    private boolean ak;
    private int al;
    private int am;
    private int an;
    private int ao;
    private int ap;
    private int aq;
    private int ar;
    private com.baidu.mobads.container.ax as;
    private int at;
    private int au;
    private int av;
    private double aw;
    private Handler ax;
    private TextView ay;
    private TextView az;
    f b;
    private View ba;
    private int bb;
    private View bc;
    private boolean bd;
    private int be;
    private int bf;
    private boolean bg;
    private View bh;
    private View bi;
    private final com.component.a.b.e bj;
    private final Handler bk;
    private long bl;
    private View bm;
    private boolean bn;
    private int bo;
    private int bp;
    private ObjectAnimator bq;
    private final Map<Integer, String> br;
    private final StringBuffer bs;
    private final StringBuffer bt;
    private final StringBuffer bu;
    private long bv;
    private boolean bw;
    private com.component.player.o bx;
    com.baidu.mobads.container.activity.v c;
    com.baidu.mobads.container.activity.o d;
    RelativeLayout e;
    Handler f;
    View g;
    ObjectAnimator h;
    ArrayList<View> i;
    ArrayList<View> j;
    protected AtomicBoolean k;
    Runnable l;
    Runnable m;
    Runnable n;
    Runnable o;
    Runnable p;
    private boolean q;
    private IOAdEventListener r;
    private int s;
    private int t;
    private TextView u;
    private TextView v;
    private ArrayList<String> w;
    private double x;
    private View y;
    private bo.b z;

    static /* synthetic */ long a(l lVar, long j) {
        long j2 = lVar.bl + j;
        lVar.bl = j2;
        return j2;
    }

    public l(com.baidu.mobads.container.adrequest.t tVar) {
        super(tVar);
        this.q = false;
        this.B = "%ds";
        this.F = true;
        this.H = 3;
        this.J = new Handler();
        this.L = true;
        this.Q = true;
        this.S = 7;
        this.U = true;
        this.V = true;
        this.W = a.EnumC0796a.WITH_CANCEL_TEXT;
        this.Y = new ArrayList();
        this.Z = "";
        this.aa = "";
        this.ab = false;
        this.ac = false;
        this.ad = new Handler();
        this.ae = 0;
        this.af = false;
        this.ah = 0;
        this.ai = 10;
        this.aj = 0;
        this.ak = false;
        this.al = 0;
        this.am = 0;
        this.an = 0;
        this.ao = 0;
        this.ap = -1;
        this.aq = 1;
        this.ar = 0;
        this.f = new Handler();
        this.at = 0;
        this.au = 0;
        this.av = 500;
        this.aw = -1.0d;
        this.ax = new Handler();
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.aB = new ArrayList<>();
        this.aC = -1;
        this.aD = 0;
        this.aG = true;
        this.aH = new Handler();
        this.aI = false;
        this.aJ = 200;
        this.aK = false;
        this.aO = 0;
        this.aP = 0;
        this.aQ = 0L;
        this.aU = 0;
        this.aV = 0;
        this.aW = -1;
        this.aY = "";
        this.bb = 0;
        this.k = new AtomicBoolean(false);
        this.bd = false;
        this.be = 1;
        this.bf = 1;
        this.bg = false;
        this.bk = new Handler();
        this.bl = 0L;
        this.bn = false;
        this.bo = 0;
        this.bp = 0;
        this.br = new HashMap();
        this.bs = new StringBuffer();
        this.bt = new StringBuffer();
        this.bu = new StringBuffer();
        this.bv = 0L;
        this.bw = false;
        this.bx = new au(this);
        this.l = new az(this);
        this.m = new ba(this);
        this.n = new bh(this);
        this.o = new bk(this);
        this.p = new bu(this);
        this.mAdContainerCxt.s().addEventListener(com.baidu.mobads.container.components.k.b.F, this);
        this.bj = new m(this, "ad");
        z zVar = new z(this);
        this.bj.a("pause_video", zVar);
        this.bj.a("resume_video", zVar);
    }

    @Override // com.baidu.mobads.container.k
    protected void resetAdContainerName() {
        this.mAdContainerName = a;
    }

    @Override // com.baidu.mobads.container.k
    public void load() {
        super.load();
        if (this.mAdInstanceInfo != null) {
            com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_START);
        }
        start();
    }

    @Override // com.baidu.mobads.container.k
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // com.baidu.mobads.container.k
    protected void doStopOnUIThread() {
        if (this.b != null) {
            this.b.s();
            this.b = null;
        }
        if (this.mAppContext != null && this.r != null) {
            com.baidu.mobads.container.landingpage.ad.a(this.mAppContext.getApplicationContext()).b();
            this.r = null;
        }
        u();
        if (this.N != null && (this.N instanceof com.baidu.mobads.container.s.ab)) {
            ((com.baidu.mobads.container.s.ab) this.N).m();
        }
        if (this.O != null && (this.O instanceof com.baidu.mobads.container.s.ab)) {
            ((com.baidu.mobads.container.s.ab) this.O).m();
        }
        if (this.P != null && (this.P instanceof com.baidu.mobads.container.s.ab)) {
            ((com.baidu.mobads.container.s.ab) this.P).m();
        }
    }

    @Override // com.baidu.mobads.container.k
    public void stop() {
        this.mAdState = 2;
        super.stop();
    }

    @Override // com.baidu.mobads.container.k
    public void destroy() {
        super.destroy();
        a();
    }

    @Override // com.baidu.mobads.container.k
    protected void doStartOnUIThread() {
        int i;
        if (this.mAdState != 2) {
            try {
            } catch (Exception e) {
                this.mAdLogger.a(a, e);
                processAdError(com.baidu.mobads.container.c.a.MCACHE_FETCH_FAILED, "exception=" + Log.getStackTraceString(e));
            }
            if (this.mAdInstanceInfo != null && this.mAppContext != null) {
                this.mAdInstanceInfo.setActionOnlyWifi(false);
                JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
                int iOptInt = originJsonObject.optInt("h", 0);
                int iOptInt2 = originJsonObject.optInt("w", 0);
                com.component.a.g.d dVar = new com.component.a.g.d(this, this.mAdInstanceInfo);
                JSONObject jSONObjectA = dVar.a(new com.component.a.e.b.b(iOptInt2, iOptInt, v()));
                if (!TextUtils.isEmpty(d())) {
                    jSONObjectA = com.component.a.i.n.b(d());
                }
                a(jSONObjectA);
                JSONObject jSONObjectW = this.mAdContainerCxt.w();
                boolean zOptBoolean = jSONObjectW.optBoolean("use_dialog_frame", false);
                this.ab = jSONObjectW.optBoolean("use_dialog_container", false);
                if (!zOptBoolean) {
                    i = 0;
                } else {
                    i = 1;
                }
                this.q = originJsonObject.optInt("dl_dialog", i) == 1;
                Rect rect = new Rect();
                ViewGroup viewGroupO = o();
                if (viewGroupO != null) {
                    viewGroupO.getWindowVisibleDisplayFrame(rect);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (this.mAdContainerCxt.v() != null && this.mAdContainerCxt.v().getParent() != null && (this.mAdContainerCxt.v().getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.mAdContainerCxt.v().getParent()).removeView(this.mAdContainerCxt.v());
                    }
                    viewGroupO.addView(this.mAdContainerCxt.v(), layoutParams);
                }
                this.mAdContainerCxt.v().setBackgroundColor(0);
                this.mAdContainerCxt.v().setFocusableInTouchMode(true);
                this.mAdContainerCxt.v().setFocusable(true);
                this.mAdContainerCxt.v().requestFocus();
                if (this.g == null) {
                    this.g = new View(this.mAppContext);
                    this.g.setVisibility(4);
                    this.g.setTag("bd_shake_click_view");
                    this.g.setOnClickListener(new ap(this));
                    this.mAdContainerCxt.v().addView(this.g);
                }
                com.baidu.mobads.container.c.a().a(this.mAppContext);
                if (!this.ab) {
                    a(this.mAppContext, new bb(this, jSONObjectA, dVar));
                } else if (this.T != null) {
                    a(jSONObjectA, dVar);
                    this.T.b();
                } else {
                    this.mAdLogger.c("插屏模板展示失败!");
                }
                this.k.set(false);
                com.baidu.mobads.container.d.b.a().a(new bq(this));
                return;
            }
            return;
        }
        this.mAdLogger.a("XExpressInterstitialAdContainer: ad state is stopped, so can not show ad");
    }

    private ViewGroup o() {
        Activity activityU;
        if (!this.ab) {
            this.e = new bv(this, this.mAppContext);
            return this.e;
        }
        if (this.mActivity != null) {
            activityU = this.mActivity;
        } else {
            activityU = this.mAdContainerCxt.u();
            if (activityU == null) {
                this.mAdLogger.c("Interstitial ad can only displayed in activity context.");
                return null;
            }
        }
        this.T = new com.baidu.mobads.container.e.a(activityU);
        this.T.a(new bw(this));
        return this.T.a();
    }

    public void a() {
        if (!this.bw) {
            this.bw = true;
            s();
        }
        if (this.bk != null) {
            this.bk.removeCallbacksAndMessages(null);
        }
        if (this.bq != null) {
            this.bq.cancel();
        }
        this.aH.removeCallbacksAndMessages(null);
        this.ax.removeCallbacksAndMessages(null);
        if (this.N != null && (this.N instanceof com.baidu.mobads.container.s.ab)) {
            ((com.baidu.mobads.container.s.ab) this.N).m();
        }
        if (this.O != null && (this.O instanceof com.baidu.mobads.container.s.ab)) {
            ((com.baidu.mobads.container.s.ab) this.O).m();
        }
        com.baidu.mobads.container.util.h.a(new bx(this));
        com.baidu.mobads.container.util.h.a(new by(this));
        if (this.as != null) {
            this.as.destroy();
            this.as = null;
        }
        this.ad.removeCallbacksAndMessages(null);
        this.f.removeCallbacksAndMessages(null);
        stop();
        com.baidu.mobads.container.util.h.a(new n(this));
    }

    private void a(JSONObject jSONObject) {
        if (this.mAdContainerCxt == null || this.mAdInstanceInfo == null || this.mAdInstanceInfo.getOriginJsonObject() == null) {
            return;
        }
        JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
        b(jSONObject);
        try {
            com.baidu.mobads.container.components.i.a aVar = new com.baidu.mobads.container.components.i.a(this.mAppContext, originJsonObject);
            if (aVar.a(com.baidu.mobads.container.components.k.c.a, 1) == 1) {
                this.aY = aVar.a(com.baidu.mobads.container.components.k.c.b, com.baidu.mobads.container.components.k.c.d);
            }
            JSONObject jSONObjectA = aVar.a("express_int");
            if (jSONObjectA != null) {
                this.H = jSONObjectA.optInt("skipTime", this.H);
                this.G = jSONObjectA.optInt("close_display_style", this.G);
            }
            if (this.G == 1 && !v()) {
                this.H = 0;
            }
            if (this.G == 1 && v()) {
                this.aw = 0.0d;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.component.a.b.j jVar) {
        a(jVar, (com.component.a.b.o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.component.a.b.j jVar, com.component.a.b.o oVar) {
        if (this.bj != null) {
            this.bj.a(jVar, oVar);
        }
    }

    public void a(JSONObject jSONObject, com.component.a.g.d dVar) {
        float f;
        try {
            if (this.mAdContainerCxt != null && this.mAdInstanceInfo != null && this.mAdInstanceInfo.getOriginJsonObject() != null) {
                this.c = new o(this);
                h();
                JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
                int iOptInt = originJsonObject.optInt("h", 0);
                int iOptInt2 = originJsonObject.optInt("w", 0);
                if (!v() && iOptInt2 > iOptInt && iOptInt != 0) {
                    f = 1.778f;
                } else {
                    f = 0.0f;
                }
                this.x = Math.random() + 4.0d;
                this.x = new BigDecimal(String.valueOf(this.x)).setScale(1, 4).doubleValue();
                this.z = new bo.b();
                com.baidu.mobads.container.adrequest.j jVar = this.mAdInstanceInfo;
                dVar.a(new a.C0317a().a(this.bj).a(com.component.a.g.b.c.b, new r(this)).a(true, new bx.a().a(Math.round(this.x))).e(true).a(true, (bm.a) null).a(true, new bo.a().a(this.z).a(v() ? false : true).a(this.H).a(new s(this))).a(new p(this, this, jVar, jVar)).a(true).d(this.q).a(1.778f, f, 0.0f));
                if (v()) {
                    e();
                }
                n();
                com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.b.a.l, new com.component.a.f.e(jSONObject).l(""));
                com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_START);
                View viewA = dVar.a(this.mAdContainerCxt.v(), jSONObject, new t(this, jVar));
                this.bl = 0L;
                a(com.component.a.g.b.b.b);
                this.bk.post(this.p);
                if (this.C != null && this.bd) {
                    this.bc = createPxCloseView(this.C, this.be, this.bf, new v(this));
                    if (this.bc != null) {
                        a(this.bc);
                    }
                }
                if (viewA == null) {
                    com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_FAILED);
                    a();
                    return;
                }
                B();
                if (this.as != null) {
                    a(this.as);
                }
                if (!(this.N instanceof com.baidu.mobads.container.s.ab) || !((com.baidu.mobads.container.s.ab) this.N).b()) {
                    com.baidu.mobads.container.util.h.a(new w(this));
                }
                if (v()) {
                    com.baidu.mobads.container.util.h.a(new x(this));
                }
                if (this.aL != null) {
                    this.aK = true;
                    C();
                }
                if (this.at == 1) {
                    if (this.E != null) {
                        this.E.bringToFront();
                    }
                    if (this.C != null) {
                        this.C.bringToFront();
                    }
                    if (this.bc != null) {
                        this.bc.bringToFront();
                    }
                }
                if (!(this.O instanceof com.baidu.mobads.container.s.ab) || !((com.baidu.mobads.container.s.ab) this.O).b()) {
                    com.baidu.mobads.container.util.h.a(new y(this));
                }
                com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(jVar.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_SUCCESS);
                if (!v() || (this.X == null && v())) {
                    Handler handler = new Handler();
                    aa aaVar = new aa(this);
                    double d = this.H;
                    Double.isNaN(d);
                    handler.postDelayed(aaVar, (long) ((d + 0.1d) * 1000.0d));
                } else {
                    Handler handler2 = new Handler();
                    ac acVar = new ac(this);
                    double d2 = this.H;
                    Double.isNaN(d2);
                    handler2.postDelayed(acVar, (long) ((d2 + 0.1d) * 1000.0d));
                    if (this.aw != -1.0d) {
                        this.ax.post(this.n);
                    }
                }
                try {
                    if (TextUtils.isEmpty(this.mAdInstanceInfo.getMainPictureUrl()) && this.b != null && this.Y != null && this.Y.size() > 0) {
                        this.b.a(this.Y);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.aq == -1) {
                    b();
                }
                r();
                q();
                if (this.aR != null) {
                    com.baidu.mobads.container.util.h.a(new af(this));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a();
        }
    }

    @Override // com.baidu.mobads.container.k, com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        super.run(iOAdEvent);
        if (iOAdEvent != null && com.baidu.mobads.container.components.k.b.F.equals(iOAdEvent.getType())) {
            a(com.component.a.g.b.b.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.C != null) {
            this.C.setVisibility(0);
        }
        if (this.bc != null) {
            this.bc.setVisibility(0);
        }
        if (this.E != null) {
            this.E.setVisibility(0);
        }
    }

    private void a(com.baidu.mobads.container.ax axVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (axVar == null) {
            return;
        }
        axVar.setVerticalScrollBarEnabled(false);
        axVar.setHorizontalScrollBarEnabled(false);
        JavascriptHelper javascriptHelper = new JavascriptHelper();
        javascriptHelper.setJsListener(new ag(this));
        axVar.addJavascriptInterface(javascriptHelper, JavascriptHelper.BD_JS_BRIDGE_NAME);
        axVar.setWebViewClient(new ah(this));
        try {
            WebSettings.class.getMethod("setDisplayZoomControls", Boolean.TYPE).invoke(axVar.getSettings(), false);
            axVar.getSettings().setUseWideViewPort(true);
            axVar.getSettings().setBuiltInZoomControls(false);
            axVar.getSettings().setLoadWithOverviewMode(true);
            axVar.getSettings().setSupportZoom(false);
        } catch (Exception e) {
            this.mAdLogger.a(a, e.getMessage());
        }
        try {
            axVar.loadUrl(this.mAdInstanceInfo.getActUrl());
        } catch (Exception e2) {
            this.mAdLogger.a(a, e2.getMessage());
        }
    }

    private void q() {
        if (this.ap != -1 && this.D != null) {
            this.f.postDelayed(new ai(this), this.ap + 2300);
        }
    }

    private void r() {
        if (this.C != null && this.D != null) {
            cf.a(this.C, new aj(this));
            cf.a(this.D, new ak(this));
        }
    }

    public void b() {
        try {
            if (this.D != null && this.D.getParent() != null) {
                ((ViewGroup) this.D.getParent()).removeView(this.D);
                this.D = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c() {
        try {
            if (this.D != null) {
                this.f.removeCallbacksAndMessages(null);
                this.h = ObjectAnimator.ofFloat(this.D, "translationY", 0.0f, -this.ar);
                this.h.setDuration(300L);
                this.h.start();
            }
        } catch (Throwable th) {
        }
    }

    public String d() {
        JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
        boolean z = false;
        int iOptInt = originJsonObject.optInt("h", 0);
        int iOptInt2 = originJsonObject.optInt("w", 0);
        String strOptString = "";
        try {
            JSONObject jSONObjectA = new com.baidu.mobads.container.components.i.a(this.mAppContext, originJsonObject).a("express_int");
            if (jSONObjectA != null) {
                String strOptString2 = jSONObjectA.optString("json_view");
                if (jSONObjectA.optDouble("sdk_version", -1.0d) <= com.baidu.mobads.container.j.b()) {
                    z = true;
                }
                if (!TextUtils.isEmpty(strOptString2) && z) {
                    JSONObject jSONObject = new JSONObject(strOptString2);
                    strOptString = iOptInt2 > iOptInt ? v() ? jSONObject.optString("express_int_horizon_video") : jSONObject.optString("express_int_horizon_image") : v() ? jSONObject.optString("express_int_vertical_video") : jSONObject.optString("express_int_vertical_image");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return strOptString;
    }

    public void e() {
        boolean z;
        this.b = new f(this.mAppContext);
        this.b.c(this.ac);
        this.b.a((AbstractData) new com.baidu.mobads.container.a.a(this, this.mAdInstanceInfo));
        if (!"true".equals(this.mAdInstanceInfo.getMute())) {
            z = false;
        } else {
            z = true;
        }
        this.b.a(z);
        View viewH = this.b.h();
        if (viewH != null) {
            viewH.setOnClickListener(new al(this, viewH));
        }
        this.b.a(this.bx);
        this.b.a((e) new am(this));
    }

    public void a(String str) {
        com.baidu.mobads.container.adrequest.n.a(this.mAdInstanceInfo, com.baidu.mobads.container.adrequest.n.k, com.baidu.mobads.container.adrequest.n.G);
        com.baidu.mobads.container.adrequest.n.b(this.mAdInstanceInfo, com.baidu.mobads.container.adrequest.n.j, com.baidu.mobads.container.adrequest.n.c);
        this.aQ = System.currentTimeMillis();
        com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_SUCCESS);
        sendImpressionLog(this.mAdInstanceInfo);
        send3rdImpressionLog(this.mAdContainerCxt.v(), true);
        try {
            this.bv = System.currentTimeMillis();
            sendUrlWithFailedLog(by.a.a(this.mAppContext).a(818).a("reason", "expressInterstitialAdShow").a("expressType", j()).a(com.baidu.mobads.container.adrequest.n.D, y()).a("prod", "int").a("impressionFrom", str).a(com.baidu.mobads.container.components.command.j.C, com.baidu.mobads.container.util.bk.a(this.mAdInstanceInfo)).a("adSrc", this.mAdSource).a("time", System.currentTimeMillis()).a(this.mAdInstanceInfo, "int").a(com.baidu.mobads.container.adrequest.n.B, this.bs.toString()).b(this.mAdContainerCxt.l()).a(this.mAdInstanceInfo).d(), c.d.e, "818", "", "show", 0, this.mAdInstanceInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.k.set(true);
    }

    public boolean f() {
        return this.mAdInstanceInfo.getOriginJsonObject().optInt("auto_play", 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        this.r = new a(null);
        com.baidu.mobads.container.landingpage.ad.a(context).a();
        com.baidu.mobads.container.landingpage.ad.a(context).addEventListener(com.baidu.mobads.container.components.k.b.F, this.r);
    }

    private static class a implements IOAdEventListener {
        private a() {
        }

        /* synthetic */ a(m mVar) {
            this();
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            if (com.baidu.mobads.container.components.k.b.F.equals(iOAdEvent.getType())) {
                com.baidu.mobads.container.activity.e.a().a(6);
            }
            if (com.baidu.mobads.container.components.k.b.G.equals(iOAdEvent.getType())) {
                com.baidu.mobads.container.activity.e.a().a(9);
            }
        }
    }

    public void a(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar == null) {
            return;
        }
        try {
            if (this.mAppContext == null) {
                return;
            }
            by.a.a(this.mAppContext).a(818).a("reason", "expressInterstitialRenderClick").a("expressType", j()).a(com.baidu.mobads.container.adrequest.n.D, y()).a("prod", "int").a("adSrc", this.mAdSource).b(this.mAdContainerCxt.l()).a(jVar).f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(com.baidu.mobads.container.adrequest.j jVar, String str) {
        if (jVar == null) {
            return;
        }
        try {
            if (this.mAppContext == null) {
                return;
            }
            by.a.a(this.mAppContext).a(818).a("reason", "expressInterstitialwebviewRequest").a("requestUrl", str).a("expressType", j()).a(com.baidu.mobads.container.adrequest.n.D, y()).a("prod", "int").a("adSrc", this.mAdSource).b(this.mAdContainerCxt.l()).a(jVar).f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(com.baidu.mobads.container.adrequest.j jVar, com.component.a.f.d dVar) {
        a(jVar, dVar.a());
    }

    public void a(com.baidu.mobads.container.adrequest.j jVar, com.baidu.mobads.container.o.b bVar) {
        long jY;
        bVar.b(this.mAdContainerCxt.v());
        com.baidu.mobads.container.o.a aVar = new com.baidu.mobads.container.o.a(bVar);
        aVar.a(this.aQ);
        if (jVar == null) {
            return;
        }
        try {
            if (this.mAppContext == null) {
                return;
            }
            if (this.b == null) {
                jY = 0;
            } else {
                jY = this.b.y();
            }
            if (!this.k.getAndSet(true)) {
                a("2");
            }
            sendUrlWithFailedLog(by.a.a(this.mAppContext).a(818).a("reason", "expressInterstitialAdClick").a("expressType", j()).a(com.baidu.mobads.container.adrequest.n.D, y()).a(aVar.c()).a("prod", "int").a("progress", jY).a("adSrc", this.mAdSource).b(this.mAdContainerCxt.l()).a(this.mAdInstanceInfo).d(), c.d.e, "818", "", "click", 0, this.mAdInstanceInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void s() {
        try {
            try {
                sendUrlWithFailedLog(by.a.a(this.mAppContext).a(818).a("reason", "expressInterstitialAdClose").a("expressType", j()).a(com.baidu.mobads.container.adrequest.n.D, y()).a(com.baidu.mobads.container.adrequest.n.B, this.bt.toString()).a(com.baidu.mobads.container.adrequest.n.C, this.bu.toString()).a("time", System.currentTimeMillis()).a(com.baidu.mobads.container.adrequest.n.m, System.currentTimeMillis() - this.bv).a("prod", "int").a("adSrc", this.mAdSource).b(this.mAdContainerCxt.l()).a(this.mAdInstanceInfo).d(), c.d.e, "818", "", "close", 0, this.mAdInstanceInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(boolean z, double d) {
        try {
            if (this.mAdInstanceInfo != null && this.mAppContext != null) {
                by.a aVarA = by.a.a(this.mAppContext).a(819).a("expressType", j()).a(com.baidu.mobads.container.adrequest.n.D, y()).a("spaceEnough", z ? 1L : 0L).a("prod", "int");
                StringBuilder sb = new StringBuilder();
                double dRound = Math.round(d * 100.0d);
                Double.isNaN(dRound);
                aVarA.a("distance", sb.append(dRound / 100.0d).append("").toString()).a("adSrc", this.mAdSource).b(this.mAdContainerCxt.l()).a(this.mAdInstanceInfo).f();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Activity activity) {
        if (activity != null) {
            this.mActivity = activity;
        }
    }

    public void a(String str, View view) {
        com.component.a.f.e eVarB;
        e.h hVarA;
        String strC = "";
        if ("countdown_view".equals(str)) {
            this.y = view;
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(view);
            for (View view2 : mapA.keySet()) {
                com.component.a.f.e eVar = mapA.get(view2);
                if (eVar != null && TextUtils.equals("skip_text", eVar.m(""))) {
                    this.A = (TextView) view2;
                }
            }
            if (v() && !f()) {
                this.y.setVisibility(8);
            }
        } else if ("close_view".equals(str) && (view instanceof ImageView)) {
            this.C = (ImageView) view;
            if (this.C != null) {
                a((View) this.C);
            }
        } else if ("notice_view".equals(str)) {
            this.D = view;
        } else if ("transp_close_view".equals(str)) {
            if (this.F) {
                this.E = view;
                if (this.E != null) {
                    a(this.E);
                }
            }
        } else if ("tail_view".equals(str)) {
            this.M = view;
            this.M.setVisibility(4);
        } else if ("desc_view".equals(str) && (view instanceof TextView)) {
            this.R = (TextView) view;
        } else if ("shake_view".equals(str) && (view instanceof com.baidu.mobads.container.s.ab)) {
            this.N = view;
            if (!v()) {
                if (com.baidu.mobads.container.h.a.a().v()) {
                    this.ad.postDelayed(this.l, 0L);
                } else {
                    z();
                }
            } else if (this.N != null) {
                this.N.setVisibility(8);
            }
        } else if (com.component.a.g.c.bm.d.equals(str) && (view instanceof com.baidu.mobads.container.s.ab) && v()) {
            this.O = view;
            if (com.baidu.mobads.container.h.a.a().v()) {
                this.ad.postDelayed(this.m, 0L);
            } else if (((com.baidu.mobads.container.s.ab) this.O).b()) {
                ((com.baidu.mobads.container.s.ab) this.O).i();
            }
        } else if (com.component.a.g.c.bm.e.equals(str)) {
            this.P = view;
        } else if ("front_slide_view".equals(str) && v()) {
            if (view != null && view.getVisibility() == 0) {
                this.i.add(view);
            }
        } else if ("slide_view".equals(str)) {
            if (view != null && v()) {
                view.setVisibility(8);
                this.j.add(view);
            }
        } else if ("front_easter_egg".equals(str) && v()) {
            if (view != null && view.getVisibility() == 0) {
                this.i.add(view);
            }
        } else if ("easter_egg".equals(str)) {
            if (view != null && v()) {
                view.setVisibility(8);
                this.j.add(view);
            }
        } else if ("compliance_app_name".equals(str)) {
            this.ag = view;
        } else if ("notice_desc_view".equals(str) && (view instanceof TextView)) {
            String strOptString = this.mAdInstanceInfo.getOriginJsonObject().optString("noti_bar_title", "");
            if (!TextUtils.isEmpty(strOptString)) {
                ((TextView) view).setText(strOptString);
            }
        } else if ("adv_webview".equals(str) && (view instanceof RelativeLayout)) {
            ax.c cVar = new ax.c();
            cVar.a = false;
            this.as = com.baidu.mobads.container.ax.a(this.mAppContext, com.baidu.mobads.container.util.bq.a(), true, true, cVar);
            ((RelativeLayout) view).addView(this.as, new ViewGroup.LayoutParams(-1, -1));
        } else if ("close_countdown_view".equals(str) && (view instanceof TextView)) {
            if (this.aw != -1.0d && this.G != 1) {
                this.ay = (TextView) view;
            } else {
                view.setVisibility(4);
            }
        } else if ("shake_view_text".equals(str) && (view instanceof TextView)) {
            this.aA = (TextView) view;
        } else if ("front_shake_view_text".equals(str) && (view instanceof TextView)) {
            this.az = (TextView) view;
            this.i.add(this.az);
        } else if ("envel_card".equals(str) && view != null) {
            this.aE = view;
        } else if ("envel_slide_arrow".equals(str) && view != null && view.getVisibility() == 0) {
            this.aF = view;
        } else if ("temp_view".equals(str) && view != null) {
            this.aR = view;
        } else if ("dc_view".equals(str) && (view instanceof m.a) && com.component.a.i.f.c(view).e(1) == 1) {
            try {
                this.aL = (m.a) view;
                this.aP = this.aL.b() + this.aL.a();
                this.aL.a(new aq(this));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if ("segmented_countdown_gift".equals(str) && (view instanceof m.d) && view.getVisibility() == 0) {
            this.aM = (m.d) view;
        } else if ("segmented_countdown_text".equals(str)) {
            if ((view instanceof m.f) && view.getVisibility() == 0) {
                this.aN = (m.f) view;
            }
        } else if ("dl_pub".equals(str) && (view instanceof TextView)) {
            this.aX = (TextView) view;
            this.aX.post(new ar(this));
        } else if ("rvideo_tail_retain_view".equals(str) && view != null) {
            this.aZ = view;
            view.setVisibility(4);
        } else if ("coupon_flip_page".equals(str) && view != null) {
            this.bi = view;
        } else if ("coupon_float".equals(str) && view != null) {
            this.bh = view;
        } else if ("bubble_widget".equals(str) && view != null) {
            this.bm = view;
            this.bn = true;
        }
        if (view instanceof com.component.a.a.f) {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null && (eVarB = fVarA.b()) != null && (hVarA = com.baidu.mobads.container.o.j.a(eVarB)) != null) {
                strC = hVarA.c("");
            }
            if ("cover_shake_lottie".equals(strC)) {
                ((com.component.a.a.f) view).a(new as(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.y != null && this.z != null) {
            this.z.b(this.I);
            this.z.a(new at(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.y != null) {
            this.J.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        return (this.mAdInstanceInfo == null || !this.mAdInstanceInfo.getCreativeType().b().equals("video") || TextUtils.isEmpty(this.mAdInstanceInfo.getVideoUrl())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.M != null) {
            this.M.setVisibility(0);
        }
        a(com.component.a.g.b.b.f);
        Iterator<View> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        Iterator<View> it2 = this.j.iterator();
        while (it2.hasNext()) {
            it2.next().setVisibility(0);
        }
        if (this.aA != null) {
            this.aA.setVisibility(0);
        }
        if (this.N != null && (this.N instanceof com.baidu.mobads.container.s.ab) && this.Q && ((com.baidu.mobads.container.s.ab) this.N).b()) {
            ((com.baidu.mobads.container.s.ab) this.N).i();
            this.N.setVisibility(0);
        }
        if (this.O != null && (this.O instanceof com.baidu.mobads.container.s.ab) && ((com.baidu.mobads.container.s.ab) this.O).b()) {
            ((com.baidu.mobads.container.s.ab) this.O).j();
            this.O.setVisibility(8);
        }
        if (this.ag != null) {
            this.ag.setVisibility(4);
        }
        if (!this.ak && this.aj == 1 && this.mAdInstanceInfo.getActionType() == 1) {
            this.ak = true;
            this.mClickTracker.a(3);
            a(false);
            com.baidu.mobads.container.o.b bVar = new com.baidu.mobads.container.o.b();
            bVar.a("auto_c");
            bVar.b("auto_c");
            bVar.a(3);
            a(this.mAdInstanceInfo, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.M != null) {
            this.M.setVisibility(4);
        }
        Iterator<View> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(0);
        }
        Iterator<View> it2 = this.j.iterator();
        while (it2.hasNext()) {
            it2.next().setVisibility(8);
        }
        if (this.N != null && (this.N instanceof com.baidu.mobads.container.s.ab) && ((com.baidu.mobads.container.s.ab) this.N).b()) {
            ((com.baidu.mobads.container.s.ab) this.N).j();
            ((com.baidu.mobads.container.s.ab) this.N).setVisibility(8);
        }
        if (this.aA != null) {
            this.aA.setVisibility(8);
        }
        if (this.O != null && (this.O instanceof com.baidu.mobads.container.s.ab) && this.Q && ((com.baidu.mobads.container.s.ab) this.O).b()) {
            ((com.baidu.mobads.container.s.ab) this.O).i();
            ((com.baidu.mobads.container.s.ab) this.O).setVisibility(0);
        }
        if (this.ag != null) {
            this.ag.setVisibility(0);
        }
    }

    public String g() {
        String str;
        Exception e;
        try {
            if (this.w == null || this.w.size() <= 0) {
                return "经典热门";
            }
            int size = this.w.size() - 1;
            double dRandom = Math.random();
            double d = size;
            Double.isNaN(d);
            int i = (int) (dRandom * d);
            str = this.w.get(i);
            try {
                this.w.remove(i);
                return str;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e3) {
            str = "经典热门";
            e = e3;
        }
    }

    public void h() {
        this.w = new ArrayList<>();
        this.w.add("星标优选");
        this.w.add("口碑推荐");
        this.w.add("热门排行");
        this.w.add("社区优选");
        this.w.add("平台推荐");
        this.w.add("人气极佳");
        this.w.add("实时排行");
    }

    public List<String> i() {
        try {
            if (TextUtils.isEmpty("vrepeatedplay") || this.mAdInstanceInfo == null || this.mAdInstanceInfo.getOriginJsonObject() == null) {
                return null;
            }
            JSONObject jSONObjectOptJSONObject = this.mAdInstanceInfo.getOriginJsonObject().optJSONObject("monitors");
            ArrayList arrayList = new ArrayList();
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if ("vrepeatedplay".equals(next)) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(next);
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i));
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String j() {
        try {
            JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
            if (originJsonObject.optInt("w", 0) > originJsonObject.optInt("h", 0)) {
                if (v()) {
                    return "4";
                }
                return "3";
            }
            if (v()) {
                return "2";
            }
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public boolean k() {
        try {
            if (this.mAdInstanceInfo != null) {
                JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
                if (originJsonObject.optInt("w", 0) > originJsonObject.optInt("h", 0)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void a(int i, int i2, int i3, int i4, JSONArray jSONArray) throws JSONException {
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i4 < 0) {
            i4 = 0;
        }
        if (jSONArray != null) {
            try {
                jSONArray.put(0, i);
                jSONArray.put(1, i2);
                jSONArray.put(2, i3);
                jSONArray.put(3, i4);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int l() {
        if (f()) {
            return 0;
        }
        return 1;
    }

    public int m() {
        if (this.b != null) {
            return (int) this.b.y();
        }
        return 0;
    }

    @Override // com.baidu.mobads.container.k
    public void handlePause(com.baidu.mobads.container.adrequest.j jVar) {
        super.handlePause(jVar);
        if (this.b != null && v()) {
            this.S = 1;
            a(this.S);
        }
    }

    @Override // com.baidu.mobads.container.k
    public void handleResume(com.baidu.mobads.container.adrequest.j jVar) {
        super.handleResume(jVar);
        this.S = 7;
        a(this.S);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        if (this.mAdInstanceInfo == null || this.mAppContext == null) {
            return;
        }
        setClickInfoForCK(this.mClickTracker, this.aQ);
        a(com.component.a.g.b.b.c);
        F();
        K();
        if (this.mAdInstanceInfo.getActionType() == 512 && TextUtils.equals(this.mAdInstanceInfo.getAppPackageName(), "com.baidu.searchbox")) {
            z2 = true;
        } else {
            z2 = false;
        }
        HashMap<String, Object> shouBaiLpFlag = getShouBaiLpFlag(this.mAdContainerCxt, this.mAdInstanceInfo);
        if (shouBaiLpFlag == null) {
            shouBaiLpFlag = new HashMap<>();
        }
        shouBaiLpFlag.put(com.baidu.mobads.container.components.k.c.b, this.aY);
        if (z2) {
            new com.baidu.mobads.container.p.a(this.mAppContext, this.mAdContainerCxt.z(), this.mAdContainerCxt.l(), this.mAdContainerCxt.k()).a(this.mAdInstanceInfo, new aw(this, shouBaiLpFlag));
        } else {
            shouBaiLpFlag.put("use_dialog_frame", Boolean.valueOf(z));
            new com.baidu.mobads.container.components.k.c(this).a((com.baidu.mobads.container.k) this, this.mAdInstanceInfo, (Boolean) true, shouBaiLpFlag);
        }
        if (this.af) {
            try {
                if (!com.baidu.mobads.container.util.ab.a(this.mAppContext, this.mAdInstanceInfo).equals(ab.a.APP_DOWNLOAD)) {
                    a();
                    this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.E));
                }
            } catch (Exception e) {
            }
        }
        this.bg = true;
        com.baidu.mobads.container.util.h.a(new ax(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.b != null) {
            this.b.a(i);
        }
    }

    private void b(JSONObject jSONObject) {
        int iOptInt;
        int iOptInt2;
        int iOptInt3;
        int iOptInt4;
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
                if (jSONObjectOptJSONObject != null) {
                    this.af = jSONObjectOptJSONObject.optInt("auto_close", 0) == 1;
                    this.ah = jSONObjectOptJSONObject.optInt("bg_blur", this.ah);
                    this.ai = jSONObjectOptJSONObject.optInt("blur_extent", this.ai);
                    this.aj = jSONObjectOptJSONObject.optInt("auto_c", this.aj);
                    this.aD = jSONObjectOptJSONObject.optInt("envel_anim", this.aD);
                    this.aC = jSONObjectOptJSONObject.optInt("envel_anim_number", this.aC);
                }
            } catch (Exception e) {
            }
        }
        Map<String, com.component.a.f.e> mapC = com.component.a.i.n.c(jSONObject);
        for (String str : mapC.keySet()) {
            com.component.a.f.e eVar = mapC.get(str);
            String strM = eVar.m("");
            if ("dislike".equals(eVar.q(""))) {
                try {
                    switch (eVar.c().optInt("type", -1)) {
                        case 0:
                            this.W = a.EnumC0796a.WITH_CLOSE_ICON;
                            continue;
                        case 1:
                            this.W = a.EnumC0796a.WITH_CANCEL_TEXT;
                            continue;
                        default:
                            continue;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                e2.printStackTrace();
            } else if ("close_view".equals(strM)) {
                JSONObject jSONObjectC = eVar.c();
                this.G = jSONObjectC.optInt("close_display_style", this.G);
                this.H = jSONObjectC.optInt("skipTime", this.H);
                this.at = jSONObjectC.optInt("dis_frt", this.at);
                this.aw = jSONObjectC.optDouble("close_countdown_time", this.aw);
                if (this.aw != -1.0d) {
                    this.aw *= 1000.0d;
                }
                this.aG = jSONObjectC.optInt("location_type", 1) != 3;
                this.bb = jSONObjectC.optInt("close_type", this.bb);
                this.bd = 1 == jSONObjectC.optInt("px_close", 0);
                if (jSONObjectC.optInt("px_close_w", 1) > 0) {
                    iOptInt = jSONObjectC.optInt("px_close_w", 1);
                } else {
                    iOptInt = this.be;
                }
                this.be = iOptInt;
                if (jSONObjectC.optInt("px_close_h", 1) > 0) {
                    iOptInt2 = jSONObjectC.optInt("px_close_h", 1);
                } else {
                    iOptInt2 = this.bf;
                }
                this.bf = iOptInt2;
                if (this.bd) {
                    b(com.baidu.mobads.container.o.j.b("pixel_click_view") + com.baidu.mobads.container.o.j.a + this.be + com.baidu.mobads.container.o.j.a + this.bf);
                }
            } else if ("mute_view".equals(strM)) {
                JSONObject jSONObjectC2 = eVar.c();
                this.Z = jSONObjectC2.optString("mute_img", "");
                this.aa = jSONObjectC2.optString("un_mute_img", "");
            } else if ("video_view".equals(strM)) {
                this.ac = eVar.c().optInt("transparent", 0) == 1;
            } else if ("transp_close_view".equals(strM)) {
                this.F = eVar.e(0) != -1;
            } else if ("notice_view".equals(strM)) {
                try {
                    this.aq = eVar.e(1);
                    this.ap = eVar.c().optInt(com.baidu.mobads.container.adrequest.n.m, this.ap);
                } catch (Throwable th) {
                }
            } else if ("temp_view".equals(strM)) {
                try {
                    JSONObject jSONObjectC3 = eVar.c();
                    this.aU = jSONObjectC3.optInt("temp_anim", this.aU);
                    this.aV = jSONObjectC3.optInt("delay_time", this.aV);
                    this.aW = jSONObjectC3.optInt("show_count", this.aW);
                } catch (Throwable th2) {
                }
            } else if ("bubble_widget".equals(strM)) {
                this.bo = eVar.c().optInt(com.baidu.mobads.container.adrequest.n.m, this.bo);
                this.bn = true;
                b(com.baidu.mobads.container.o.j.g(strM, eVar));
            } else if (str != null && str.contains("big_white_finger_content")) {
                if (com.baidu.mobads.container.o.j.a(this.mAdInstanceInfo.getOriginJsonObject(), str).contains("big_white_finger_content")) {
                    b(com.baidu.mobads.container.o.j.d("big_white_finger", eVar));
                } else if (com.baidu.mobads.container.o.j.a(this.mAdInstanceInfo.getOriginJsonObject(), str).contains("atmosphere_view")) {
                    b(com.baidu.mobads.container.o.j.c("atmosphere_view", eVar));
                }
            } else if (str != null && str.contains("coc_lottie")) {
                b(com.baidu.mobads.container.o.j.e("big_coc_view", eVar));
            } else if ("shake_view".equals(strM)) {
                if (eVar.e(1) == 1) {
                    b(com.baidu.mobads.container.o.j.a(strM, eVar));
                }
            } else if ("coupon_flip_page".equals(strM)) {
                b(com.baidu.mobads.container.o.j.f(strM, eVar));
            } else if ("coupon_float".equals(strM)) {
                b(com.baidu.mobads.container.o.j.a(this.mAdInstanceInfo.getOriginJsonObject(), strM, eVar));
            } else if ("interact_front_lucky_bag".equals(strM)) {
                b(com.baidu.mobads.container.o.j.i(strM, eVar));
            } else if ("interact_front_pack_rain".equals(strM)) {
                b(com.baidu.mobads.container.o.j.m(strM, eVar));
            } else if ("interact_front_flip_card".equals(strM)) {
                b(com.baidu.mobads.container.o.j.m(strM, eVar));
            } else if ("interact_back_coupon".equals(strM)) {
                b(com.baidu.mobads.container.o.j.n(strM, eVar));
            } else if ("interact_back_welfare".equals(strM)) {
                b(com.baidu.mobads.container.o.j.j(strM, eVar));
            } else if ("front_slide_view".equals(strM) && v()) {
                if (eVar.e(1) == 1) {
                    b(com.baidu.mobads.container.o.j.b(strM) + "");
                }
            } else if ("slide_view".equals(strM)) {
                b(com.baidu.mobads.container.o.j.b(strM) + "");
            } else if ("front_easter_egg".equals(strM) && v()) {
                b(com.baidu.mobads.container.o.j.b(strM, eVar));
            } else if ("easter_egg".equals(strM)) {
                b(com.baidu.mobads.container.o.j.b(strM, eVar));
            } else if ("dynamic_barrage".equals(strM)) {
                b(com.baidu.mobads.container.o.j.h("dynamic_barrage", eVar));
            } else if ("bookmark".equals(strM)) {
                b(j.a.BOOKMARK.b() + "");
            } else if ("dc_view".equals(strM) && eVar.e(1) == 1) {
                if (eVar.c() != null) {
                    iOptInt3 = eVar.c().optInt("delay_time", 0);
                    iOptInt4 = eVar.c().optInt(com.baidu.mobads.container.adrequest.n.m, 0);
                } else {
                    iOptInt3 = 0;
                    iOptInt4 = 0;
                }
                b(com.baidu.mobads.container.o.j.b(strM) + com.baidu.mobads.container.o.j.a + iOptInt3 + com.baidu.mobads.container.o.j.a + iOptInt4);
            } else if (com.component.a.g.c.bm.d.equals(strM) && v()) {
                if (eVar.e(1) == 1) {
                    b(com.baidu.mobads.container.o.j.a(strM, eVar));
                }
            } else if (com.component.a.g.c.bm.e.equals(strM)) {
                b(com.baidu.mobads.container.o.j.a(strM, eVar));
            } else if ("one_purchase".equals(strM)) {
                b(com.baidu.mobads.container.o.j.p(strM, eVar));
            } else if ("coupon_discount".equals(strM)) {
                b(com.baidu.mobads.container.o.j.q(strM, eVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView) {
        if (TextUtils.isEmpty(this.Z) || com.baidu.mobads.container.util.d.d.a(this.mAppContext).b(imageView, this.Z) == null) {
            com.component.b.a.a().a(imageView, "ic_white_voice_mute");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImageView imageView) {
        if (TextUtils.isEmpty(this.aa) || com.baidu.mobads.container.util.d.d.a(this.mAppContext).b(imageView, this.aa) == null) {
            com.component.b.a.a().a(imageView, "ic_white_voice");
        }
    }

    private void a(Context context, o.a aVar) {
        if (context == null || this.e == null) {
            com.baidu.mobads.container.l.g.b().e(a, "activity启动异常");
        } else {
            com.baidu.mobads.container.util.h.a(new ay(this, aVar, context));
        }
    }

    public void a(View view) {
        if (v() && !f()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
        try {
            if (this.G == 1) {
                view.setVisibility(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String y() {
        JSONObject jSONObjectOptJSONObject;
        try {
            return (this.mAdInstanceInfo == null || (jSONObjectOptJSONObject = this.mAdInstanceInfo.getOriginJsonObject().optJSONObject("st_op")) == null) ? "" : jSONObjectOptJSONObject.optString(com.baidu.mobads.container.adrequest.n.D, "");
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.mAdInstanceInfo != null && !v() && ((com.baidu.mobads.container.s.ab) this.N).b()) {
            ((com.baidu.mobads.container.s.ab) this.N).i();
        }
    }

    public void n() {
        Bitmap bitmapA;
        if (this.ah == 1 && this.mAdContainerCxt.v() != null && this.mAppContext != null) {
            try {
                Bitmap bitmapA2 = A();
                if (bitmapA2 != null && (bitmapA = a(bitmapA2, this.ai)) != null) {
                    ImageView imageView = new ImageView(this.mAppContext);
                    imageView.setImageBitmap(bitmapA);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.mAdContainerCxt.v().addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private Bitmap A() {
        if (this.mActivity != null) {
            Bitmap bitmapA = cf.a(this.mActivity.getWindow().getDecorView());
            return Bitmap.createBitmap(bitmapA, 0, com.baidu.mobads.container.util.bv.h(this.mAppContext), bitmapA.getWidth(), (bitmapA.getHeight() - com.baidu.mobads.container.util.bv.h(this.mAppContext)) - com.baidu.mobads.container.util.bv.i(this.mAppContext), (Matrix) null, true);
        }
        return null;
    }

    private Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null || com.baidu.mobads.container.util.x.a(null).a() < 17) {
            return null;
        }
        try {
            if (f <= 0.0f || f > 25.0f) {
                throw new RSIllegalArgumentException("GaussianRadius out of range (0 < r <= 25).");
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.4f), Math.round(bitmap.getHeight() * 0.4f), true);
            RenderScript renderScriptCreate = RenderScript.create(this.mAppContext);
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
            Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            scriptIntrinsicBlurCreate.setRadius(f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            allocationCreateTyped.copyTo(bitmapCreateScaledBitmap);
            renderScriptCreate.destroy();
            return bitmapCreateScaledBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return bitmap;
        }
    }

    private void B() {
        if (this.aD == 1) {
            if (this.aC > 0 || this.aC == -1) {
                if (this.aE != null) {
                    if (this.aE.getParent() != null && (this.aE.getParent() instanceof RelativeLayout)) {
                        RelativeLayout relativeLayout = (RelativeLayout) this.aE.getParent();
                        relativeLayout.setClipChildren(false);
                        if (relativeLayout.getParent() != null && (relativeLayout.getParent() instanceof RelativeLayout)) {
                            ((RelativeLayout) relativeLayout.getParent()).setClipChildren(false);
                        }
                    }
                    com.baidu.mobads.container.util.h.a(new bc(this));
                }
                if (this.aF != null) {
                    com.baidu.mobads.container.util.h.a(new bd(this));
                }
                if (this.C != null && this.aG) {
                    com.baidu.mobads.container.util.h.a(new be(this));
                }
                if (!v() && this.y != null && this.aG) {
                    com.baidu.mobads.container.util.h.a(new bf(this));
                }
                if (v() && this.ay != null && this.aG) {
                    com.baidu.mobads.container.util.h.a(new bg(this));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i) {
        try {
            float f = i;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -com.baidu.mobads.container.util.ab.a(this.mAppContext, f), 0.0f, -com.baidu.mobads.container.util.ab.a(this.mAppContext, f), 0.0f, 0.0f, 0.0f, 0.0f);
            this.aB.add(objectAnimatorOfFloat);
            objectAnimatorOfFloat.setDuration(2240L);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            if (this.aC == -1) {
                objectAnimatorOfFloat.setRepeatCount(-1);
            } else {
                objectAnimatorOfFloat.setRepeatCount(this.aC - 1);
            }
            objectAnimatorOfFloat.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (!this.aI) {
            this.aH.post(this.o);
            this.aI = true;
        }
    }

    private void D() {
        this.bn = false;
        com.baidu.mobads.container.util.h.a(new bl(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        com.baidu.mobads.container.util.h.a(new bo(this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E() {
        if (this.aK && this.aL != null && this.aO <= this.aP) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (this.aK && this.aL != null) {
            com.baidu.mobads.container.util.h.a(new bp(this));
            this.aK = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:10:0x0022, B:16:0x0033, B:18:0x003c, B:17:0x0037, B:5:0x0007), top: B:22:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.ObjectAnimator a(android.view.View r3, int r4, int r5, int r6) {
        /*
            r2 = this;
            r0 = 0
            switch(r4) {
                case 1: goto L7;
                default: goto L5;
            }
        L5:
            r3 = r0
            goto L1f
        L7:
            java.lang.String r4 = "Rotation"
            r1 = 7
            float[] r1 = new float[r1]     // Catch: java.lang.Throwable -> L1d
            r1 = {x004a: FILL_ARRAY_DATA , data: [0, 1077936128, -1069547520, 1077936128, 0, 0, 0} // fill-array     // Catch: java.lang.Throwable -> L1d
            android.animation.ObjectAnimator r3 = android.animation.ObjectAnimator.ofFloat(r3, r4, r1)     // Catch: java.lang.Throwable -> L1d
            long r4 = (long) r5     // Catch: java.lang.Throwable -> L1d
            r3.setStartDelay(r4)     // Catch: java.lang.Throwable -> L1d
            r4 = 1920(0x780, double:9.486E-321)
            r3.setDuration(r4)     // Catch: java.lang.Throwable -> L1d
            goto L1f
        L1d:
            r3 = move-exception
            goto L40
        L1f:
            if (r3 != 0) goto L22
            return r0
        L22:
            android.view.animation.LinearInterpolator r4 = new android.view.animation.LinearInterpolator     // Catch: java.lang.Throwable -> L1d
            r4.<init>()     // Catch: java.lang.Throwable -> L1d
            r3.setInterpolator(r4)     // Catch: java.lang.Throwable -> L1d
            r4 = -1
            if (r6 > 0) goto L31
            if (r6 != r4) goto L30
            goto L31
        L30:
            return r0
        L31:
            if (r6 != r4) goto L37
            r3.setRepeatCount(r4)     // Catch: java.lang.Throwable -> L1d
            goto L3c
        L37:
            int r6 = r6 + (-1)
            r3.setRepeatCount(r6)     // Catch: java.lang.Throwable -> L1d
        L3c:
            r3.start()     // Catch: java.lang.Throwable -> L1d
            return r3
        L40:
            r3.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.e.l.a(android.view.View, int, int, int):android.animation.ObjectAnimator");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072 A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #0 {all -> 0x006d, blocks: (B:26:0x0072, B:5:0x0007, B:11:0x002d, B:13:0x0036, B:19:0x0057, B:21:0x0060, B:20:0x005b, B:12:0x0031), top: B:30:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.AnimatorSet b(android.view.View r8, int r9, int r10, int r11) {
        /*
            r7 = this;
            r0 = 0
            switch(r9) {
                case 2: goto L7;
                default: goto L5;
            }
        L5:
            r10 = r0
            goto L6f
        L7:
            java.lang.String r9 = "scaleX"
            r1 = 7
            float[] r2 = new float[r1]     // Catch: java.lang.Throwable -> L6d
            r2 = {x0080: FILL_ARRAY_DATA , data: [1065353216, 1064514355, 1065353216, 1064514355, 1065353216, 1065353216, 1065353216} // fill-array     // Catch: java.lang.Throwable -> L6d
            android.animation.ObjectAnimator r9 = android.animation.ObjectAnimator.ofFloat(r8, r9, r2)     // Catch: java.lang.Throwable -> L6d
            long r2 = (long) r10     // Catch: java.lang.Throwable -> L6d
            r9.setStartDelay(r2)     // Catch: java.lang.Throwable -> L6d
            r4 = 1920(0x780, double:9.486E-321)
            r9.setDuration(r4)     // Catch: java.lang.Throwable -> L6d
            android.view.animation.LinearInterpolator r10 = new android.view.animation.LinearInterpolator     // Catch: java.lang.Throwable -> L6d
            r10.<init>()     // Catch: java.lang.Throwable -> L6d
            r9.setInterpolator(r10)     // Catch: java.lang.Throwable -> L6d
            r10 = -1
            if (r11 > 0) goto L2b
            if (r11 != r10) goto L2a
            goto L2b
        L2a:
            return r0
        L2b:
            if (r11 != r10) goto L31
            r9.setRepeatCount(r10)     // Catch: java.lang.Throwable -> L6d
            goto L36
        L31:
            int r6 = r11 + (-1)
            r9.setRepeatCount(r6)     // Catch: java.lang.Throwable -> L6d
        L36:
            java.lang.String r6 = "scaleY"
            float[] r1 = new float[r1]     // Catch: java.lang.Throwable -> L6d
            r1 = {x0092: FILL_ARRAY_DATA , data: [1065353216, 1064514355, 1065353216, 1064514355, 1065353216, 1065353216, 1065353216} // fill-array     // Catch: java.lang.Throwable -> L6d
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r6, r1)     // Catch: java.lang.Throwable -> L6d
            r8.setStartDelay(r2)     // Catch: java.lang.Throwable -> L6d
            r8.setDuration(r4)     // Catch: java.lang.Throwable -> L6d
            android.view.animation.LinearInterpolator r1 = new android.view.animation.LinearInterpolator     // Catch: java.lang.Throwable -> L6d
            r1.<init>()     // Catch: java.lang.Throwable -> L6d
            r8.setInterpolator(r1)     // Catch: java.lang.Throwable -> L6d
            if (r11 > 0) goto L55
            if (r11 != r10) goto L54
            goto L55
        L54:
            return r0
        L55:
            if (r11 != r10) goto L5b
            r8.setRepeatCount(r10)     // Catch: java.lang.Throwable -> L6d
            goto L60
        L5b:
            int r11 = r11 + (-1)
            r8.setRepeatCount(r11)     // Catch: java.lang.Throwable -> L6d
        L60:
            android.animation.AnimatorSet r10 = new android.animation.AnimatorSet     // Catch: java.lang.Throwable -> L6d
            r10.<init>()     // Catch: java.lang.Throwable -> L6d
            android.animation.AnimatorSet$Builder r9 = r10.play(r9)     // Catch: java.lang.Throwable -> L6d
            r9.with(r8)     // Catch: java.lang.Throwable -> L6d
            goto L6f
        L6d:
            r8 = move-exception
            goto L76
        L6f:
            if (r10 != 0) goto L72
            return r0
        L72:
            r10.start()     // Catch: java.lang.Throwable -> L6d
            return r10
        L76:
            r8.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.e.l.b(android.view.View, int, int, int):android.animation.AnimatorSet");
    }

    private void G() {
        a();
        this.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.E));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.component.a.f.d dVar) {
        String strM = dVar.f().m("");
        if (!this.bg && this.bd && "close_view".equals(strM)) {
            dVar.a("pixel_click_view", "pixel_click_view");
            dVar.a(4);
            a(this.q);
            a(this.mAdInstanceInfo, dVar);
            return;
        }
        if ("coupon_float_close_view".equals(strM)) {
            if (this.bh != null) {
                cf.b(this.bh);
                this.bh = null;
                return;
            }
            return;
        }
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.aZ != null && this.bb == 1) {
            I();
        } else {
            G();
        }
    }

    private void I() {
        com.baidu.mobads.container.util.h.a(new br(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        com.baidu.mobads.container.util.h.a(new bs(this));
    }

    private void K() {
        if (this.Q) {
            com.baidu.mobads.container.util.h.a(new bt(this));
            this.Q = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.bm != null && this.bn) {
            if (this.bp >= this.bo) {
                D();
            } else {
                this.bp += this.aJ;
            }
        }
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(this.bs.toString())) {
            this.bs.append(",");
        }
        this.bs.append(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) throws NumberFormatException {
        int i;
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("^\\d{4}").matcher(str);
            if (matcher.find()) {
                try {
                    i = Integer.parseInt(matcher.group());
                } catch (Exception e) {
                    com.baidu.mobads.container.l.g.d(e);
                    i = -1;
                }
                if (!this.br.containsKey(Integer.valueOf(i)) && i > 0) {
                    this.br.put(Integer.valueOf(i), str);
                    if (!TextUtils.isEmpty(this.bt.toString())) {
                        this.bt.append(",");
                    }
                    this.bt.append(str);
                    if (!TextUtils.isEmpty(this.bu.toString())) {
                        this.bu.append(",");
                    }
                    this.bu.append(com.baidu.mobads.container.o.j.a(i));
                }
            }
        }
    }
}
