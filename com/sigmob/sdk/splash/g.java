package com.sigmob.sdk.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.af;
import com.sigmob.sdk.base.common.ak;
import com.sigmob.sdk.base.common.al;
import com.sigmob.sdk.base.common.am;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.utils.n;
import com.sigmob.sdk.base.utils.o;
import com.sigmob.sdk.base.views.aa;
import com.sigmob.sdk.base.views.ae;
import com.sigmob.sdk.base.views.ag;
import com.sigmob.sdk.base.views.ai;
import com.sigmob.sdk.base.views.an;
import com.sigmob.sdk.base.views.ao;
import com.sigmob.sdk.base.views.au;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.base.views.v;
import com.sigmob.sdk.base.views.x;
import com.sigmob.windad.WindAdError;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g extends RelativeLayout {
    public static final String a = "g";
    private static float b = 25.0f;
    private static float c = 13.0f;
    private final RelativeLayout d;
    private b e;
    private final Context f;
    private BaseAdUnit g;
    private a h;
    private boolean i;
    private RelativeLayout j;
    private View.OnTouchListener k;
    private float l;
    private volatile boolean m;
    private boolean n;
    private boolean o;
    private ae p;
    private ak.a q;
    private v r;
    private boolean s;
    private float t;

    /* renamed from: com.sigmob.sdk.splash.g$2, reason: invalid class name */
    class AnonymousClass2 implements ak.b {
        final /* synthetic */ au a;

        AnonymousClass2(final au val$actionView) {
            this.a = val$actionView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            g.this.a((String) null);
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            if (info == null || g.this.g == null || g.this.m) {
                return;
            }
            g.this.m = true;
            Number number = info.get("turn_x");
            Number number2 = info.get("turn_y");
            Number number3 = info.get("turn_z");
            Number number4 = info.get("turn_time");
            if (number != null) {
                g.this.g.getClickCommon().turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                g.this.g.getClickCommon().turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                g.this.g.getClickCommon().turn_z = String.valueOf(number3.intValue());
            }
            g.this.g.getClickCommon().turn_time = String.valueOf(number4);
            g.this.g.getClickCommon().sld = "5";
            g.this.g.getClickCommon().click_area = "component";
            g.this.g.getClickCommon().click_scene = "ad";
            this.a.postDelayed(new Runnable() { // from class: com.sigmob.sdk.splash.g$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.splash.g$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[al.values().length];
            a = iArr;
            try {
                iArr[al.FOLLOW_PACKAGE_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[al.IGNORE_ABOUT_SCHEME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[al.MINI_PROGRAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[al.FOLLOW_DEEP_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[al.MARKET_SCHEME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[al.DOWNLOAD_APK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[al.OPEN_WITH_BROWSER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[al.NOOP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* renamed from: com.sigmob.sdk.splash.g$5, reason: invalid class name */
    class AnonymousClass5 implements am.b {
        final /* synthetic */ BaseAdUnit a;

        AnonymousClass5(final BaseAdUnit val$adUnit) {
            this.a = val$adUnit;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(str);
                Map options = pointEntitySigmob.getOptions();
                options.put("app_package_name", g.this.g.getAndroidMarket().app_package_name);
                options.put("store_package_name", g.this.g.getAndroidMarket().appstore_package_name);
                pointEntitySigmob.setOptions(options);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(str);
                Map options = pointEntitySigmob.getOptions();
                options.put("app_package_name", g.this.g.getAndroidMarket().app_package_name);
                options.put("store_package_name", g.this.g.getAndroidMarket().appstore_package_name);
                pointEntitySigmob.setOptions(options);
            }
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(final String url, al urlAction) {
            SigmobLog.i("urlHandlingSucceeded: " + urlAction.name() + " url: " + url);
            if (g.this.g == null) {
                SigmobLog.e("adUnit is null");
                return;
            }
            g.this.g.getClickCommon().is_final_click = true;
            if (!this.a.getAd().forbiden_parse_landingpage.booleanValue()) {
                ac.a(this.a, urlAction.name(), url);
            }
            g.this.f();
            int i = AnonymousClass3.a[urlAction.ordinal()];
            if (i == 3) {
                Log.d(g.a, "打开小程序成功：" + urlAction);
                com.sigmob.sdk.manager.b.b(this.a, "open_deeplink", url);
            } else if (i == 5) {
                AndroidMarket androidMarket = g.this.g.getAndroidMarket();
                if (androidMarket != null) {
                    ac.a(PointCategory.APK_CLICK, ((Integer) Wire.get(androidMarket.type, 0)).intValue() == 0 ? "market" : "mimarket", g.this.g);
                    if (!TextUtils.isEmpty(androidMarket.app_package_name)) {
                        try {
                            FileUtil.writeToCache(g.this.g, new File(com.sigmob.sdk.base.utils.i.g(), androidMarket.app_package_name + ".log").getAbsolutePath());
                        } catch (Throwable th) {
                            SigmobLog.e("write ad info with package error " + th.getMessage());
                        }
                    }
                }
                ac.a(PointCategory.OPEN_MARKET, (String) null, g.this.g, new ac.a() { // from class: com.sigmob.sdk.splash.g$5$$ExternalSyntheticLambda0
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        this.f$0.b(url, obj);
                    }
                });
            } else if (i == 6) {
                if (g.this.h.j()) {
                    g.this.g.getClickCommon().is_final_click = false;
                } else {
                    g.this.a(true);
                    g.this.h.f(url);
                }
            }
            af sessionManager = this.a.getSessionManager();
            if (sessionManager == null) {
                return;
            }
            sessionManager.a("click", 0);
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void b(final String url, al urlAction) {
            SigmobLog.i("urlHandlingFailed: " + urlAction.name() + " url: " + url);
            if (g.this.g == null) {
                return;
            }
            g.this.g.getClickCommon().is_final_click = true;
            int i = AnonymousClass3.a[urlAction.ordinal()];
            if (i == 3 || i == 4) {
                Log.d(g.a, "打开小程序失败：" + urlAction);
                com.sigmob.sdk.manager.b.b(this.a, "open_deeplink_failed", url);
                return;
            }
            if (i == 5) {
                ac.a(PointCategory.OPEN_MARKET_FAILED, (String) null, g.this.g, new ac.a() { // from class: com.sigmob.sdk.splash.g$5$$ExternalSyntheticLambda1
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        this.f$0.a(url, obj);
                    }
                });
                return;
            }
            if (i != 8) {
                return;
            }
            if (!this.a.getAd().forbiden_parse_landingpage.booleanValue()) {
                ac.a(this.a, urlAction.name(), url);
            }
            g.this.g.getClickCommon().is_final_click = true;
            af sessionManager = this.a.getSessionManager();
            if (sessionManager != null) {
                sessionManager.a("click", 0);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.splash.g$6, reason: invalid class name */
    class AnonymousClass6 implements ak.b {
        AnonymousClass6() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            g.this.a((String) null);
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            if (info == null || g.this.g == null || g.this.m) {
                return;
            }
            g.this.m = true;
            Number number = info.get("x_max_acc");
            Number number2 = info.get("y_max_acc");
            Number number3 = info.get("z_max_acc");
            g.this.g.getClickCommon().sld = "2";
            g.this.g.getClickCommon().click_area = "component";
            g.this.g.getClickCommon().click_scene = "ad";
            if (number != null) {
                g.this.g.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                g.this.g.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                g.this.g.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            g.this.r.postDelayed(new Runnable() { // from class: com.sigmob.sdk.splash.g$6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.splash.g$7, reason: invalid class name */
    class AnonymousClass7 implements ak.b {
        AnonymousClass7() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            g.this.a((String) null);
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
            if (g.this.r instanceof com.sigmob.sdk.base.views.ak) {
                ((com.sigmob.sdk.base.views.ak) g.this.r).a(progress);
            }
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            if (info == null || g.this.g == null || g.this.m) {
                return;
            }
            g.this.m = true;
            Number number = info.get("turn_x");
            Number number2 = info.get("turn_y");
            Number number3 = info.get("turn_z");
            Number number4 = info.get("turn_time");
            if (number != null) {
                g.this.g.getClickCommon().turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                g.this.g.getClickCommon().turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                g.this.g.getClickCommon().turn_z = String.valueOf(number3.intValue());
            }
            g.this.g.getClickCommon().turn_time = String.valueOf(number4);
            g.this.g.getClickCommon().sld = "5";
            g.this.g.getClickCommon().click_area = "component";
            g.this.g.getClickCommon().click_scene = "ad";
            g.this.r.postDelayed(new Runnable() { // from class: com.sigmob.sdk.splash.g$7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.splash.g$9, reason: invalid class name */
    class AnonymousClass9 implements ak.b {
        AnonymousClass9() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            g.this.a((String) null);
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
            if (g.this.r instanceof an) {
                ((an) g.this.r).a(progress);
            }
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            if (info == null || g.this.g == null || g.this.m) {
                return;
            }
            g.this.m = true;
            Number number = info.get("x_max_acc");
            Number number2 = info.get("y_max_acc");
            Number number3 = info.get("z_max_acc");
            if (number != null) {
                g.this.g.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                g.this.g.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                g.this.g.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            g.this.g.getClickCommon().sld = "2";
            g.this.g.getClickCommon().click_area = "component";
            g.this.g.getClickCommon().click_scene = "ad";
            g.this.r.postDelayed(new Runnable() { // from class: com.sigmob.sdk.splash.g$9$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    public g(Context context) {
        super(context);
        this.l = 1.0f;
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext;
        RelativeLayout relativeLayout = new RelativeLayout(applicationContext);
        this.d = relativeLayout;
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void a(Activity activity) {
        Context context = getContext();
        com.sigmob.sdk.videoplayer.c.c(activity);
        com.sigmob.sdk.videoplayer.c.f(activity);
        int iDipsToIntPixels = Dips.dipsToIntPixels(12.0f, context);
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(68.0f, context);
        int iDipsToIntPixels3 = Dips.dipsToIntPixels(25.0f, context);
        ae aeVar = new ae(context);
        this.p = aeVar;
        aeVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels2, iDipsToIntPixels3);
        layoutParams.addRule(11);
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.splash.g$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        layoutParams.setMargins(0, iDipsToIntPixels * 3, iDipsToIntPixels, 0);
        addView(this.p, layoutParams);
    }

    private void a(Context context) {
        b bVarA = b.a(context, this.g);
        this.e = bVarA;
        if (bVarA == null) {
            return;
        }
        bVarA.setAspectRatio(this.t);
        this.d.addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
        this.j = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int iDipsToIntPixels = Dips.dipsToIntPixels(b, this.f);
        layoutParams.setMargins(iDipsToIntPixels, (int) (iDipsToIntPixels * 2.5d), iDipsToIntPixels, iDipsToIntPixels);
        this.j.setClickable(true);
        this.j.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.splash.g$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return g.a(view, motionEvent);
            }
        });
        this.d.addView(this.j, layoutParams);
        this.k = new View.OnTouchListener() { // from class: com.sigmob.sdk.splash.g.4
            private MotionEvent b;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (g.this.g == null) {
                    SigmobLog.e("adUnit is null");
                    return false;
                }
                if (event.getAction() == 0) {
                    this.b = MotionEvent.obtain(event);
                } else if (event.getAction() == 1) {
                    if (this.b == null) {
                        this.b = event;
                    }
                    try {
                        g.this.g.getClickCommon().sld = "0";
                        g.this.g.getClickCommon().click_area = "companion";
                        g.this.g.getClickCommon().click_scene = "ad";
                        g.this.g.getMacroCommon().updateClickMarco(this.b, event, false);
                    } catch (Throwable th) {
                        SigmobLog.e("splash click macro set " + th.getMessage());
                    }
                    g.this.a((String) null);
                }
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.s = true;
        BaseAdUnit baseAdUnit = this.g;
        if (baseAdUnit == null) {
            return;
        }
        af sessionManager = baseAdUnit.getSessionManager();
        if (sessionManager != null) {
            sessionManager.a("skip", 0);
        }
        BaseBroadcastReceiver.a(this.f, this.g.getUuid(), IntentActions.ACTION_SPLAH_SKIP);
    }

    private void a(BaseAdUnit adUnit, String coordinate) {
        SigmobLog.d("handleUrlAction");
        if (adUnit == null) {
            SigmobLog.e("adUnit is null");
        } else {
            new am.a().a(al.IGNORE_ABOUT_SCHEME, al.DOWNLOAD_APK, al.MARKET_SCHEME, al.OPEN_WITH_BROWSER, al.FOLLOW_PACKAGE_NAME, al.FOLLOW_DEEP_LINK, al.MINI_PROGRAM).a(new AnonymousClass5(adUnit)).a(adUnit.isSkipSigmobBrowser()).a(adUnit).b(adUnit.getAd().forbiden_parse_landingpage.booleanValue()).a().a(com.sigmob.sdk.b.e(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String coordinate) {
        SigmobLog.d("handleClick");
        if (this.g == null) {
            SigmobLog.e("adUnit is null");
            return;
        }
        this.m = true;
        if (com.sigmob.sdk.b.i() == null) {
            com.sigmob.sdk.b.a(o.c(this));
        }
        a(this.g, coordinate);
    }

    private void a(String title, String desc) {
        Context context = getContext();
        ao aoVar = new ao(context);
        aoVar.setTitle(title);
        aoVar.setDescription(desc);
        int iDipsToIntPixels = Dips.dipsToIntPixels(82.0f, context);
        if (this.g.getClickType() == 1) {
            aoVar.setOnTouchListener(this.k);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, iDipsToIntPixels);
        addView(aoVar, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.sigmob.sdk.base.utils.c.a(a, this.g);
        BaseBroadcastReceiver.a(this.f, this.g.getUuid(), IntentActions.ACTION_INTERSTITIAL_CLICK);
    }

    private void g() {
        Context context = getContext();
        int iDipsToIntPixels = Dips.dipsToIntPixels(10.0f, context);
        Dips.dipsToIntPixels(75.0f, context);
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(25.0f, context);
        TextView textView = new TextView(context);
        textView.setText("互动广告");
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(Color.parseColor("#ccffffff"));
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, iDipsToIntPixels2);
        layoutParams.addRule(0, this.p.getId());
        layoutParams.addRule(6, this.p.getId());
        layoutParams.setMargins(0, 0, iDipsToIntPixels, 0);
        addView(textView, layoutParams);
    }

    private void h() {
        Context context = getContext();
        this.r = new com.sigmob.sdk.base.views.ac(context);
        int iDipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, iDipsToIntPixels2);
        if (this.g.getClickType() == 1) {
            this.r.setOnTouchListener(this.k);
        }
        ak.a aVar = new ak.a(context, new AnonymousClass6(), ak.c.SHAKE);
        this.q = aVar;
        aVar.c(this.g.getSensitivity());
        this.q.a();
        addView(this.r, layoutParams);
    }

    private void i() {
        Context context = getContext();
        this.r = new com.sigmob.sdk.base.views.ak(context);
        int iDipsToIntPixels = Dips.dipsToIntPixels(92.0f, context);
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, iDipsToIntPixels2);
        if (this.g.getClickType() == 1) {
            this.r.setOnTouchListener(this.k);
        }
        ak.a aVar = new ak.a(context, new AnonymousClass7(), ak.c.SLOPE);
        this.q = aVar;
        aVar.c(this.g.getSensitivity());
        this.q.a();
        addView(this.r, layoutParams);
    }

    private void j() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.splash.g.8
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Context context;
                g.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (g.this.g == null || (context = g.this.getContext()) == null) {
                    return;
                }
                g.this.getLocationOnScreen(new int[2]);
                g.this.g.getClickCommon().adarea_x = String.valueOf(Dips.pixelsToIntDips(r1[0], context));
                g.this.g.getClickCommon().adarea_y = String.valueOf(Dips.pixelsToIntDips(r1[1], context));
                g.this.g.getClickCommon().adarea_w = String.valueOf(Dips.pixelsToIntDips(g.this.getWidth(), context));
                g.this.g.getClickCommon().adarea_h = String.valueOf(Dips.pixelsToIntDips(g.this.getHeight(), context));
            }
        });
    }

    private void k() {
        Context context = getContext();
        this.r = new an(context);
        int iDipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, iDipsToIntPixels2);
        if (this.g.getClickType() == 1) {
            this.r.setOnTouchListener(this.k);
        }
        ak.a aVar = new ak.a(context, new AnonymousClass9(), ak.c.SWING);
        this.q = aVar;
        aVar.c(this.g.getSensitivity());
        this.q.a();
        addView(this.r, layoutParams);
    }

    private void l() {
        Context context = getContext();
        ai aiVar = new ai(context);
        int iDipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        if (this.g.getClickType() == 1) {
            aiVar.setOnTouchListener(this.k);
        }
        int i = 50;
        int sensitivity = this.g.getSensitivity();
        if (sensitivity == 10) {
            i = 0;
        } else if (sensitivity > 0 && sensitivity < 10) {
            i = ((10 - sensitivity) + 1) * 10;
        }
        final int iDipsToIntPixels2 = Dips.dipsToIntPixels(i, com.sigmob.sdk.b.e());
        this.j.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.splash.g.10
            private MotionEvent c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) throws UnsupportedEncodingException {
                if (g.this.g == null) {
                    return false;
                }
                if (event.getAction() == 0) {
                    this.c = MotionEvent.obtain(event);
                    g.this.m = false;
                } else {
                    if ((event.getAction() != 2 && event.getAction() != 1) || g.this.m) {
                        return true;
                    }
                    float x = event.getX();
                    float y = event.getY();
                    if (((float) Math.sqrt(Math.pow(Math.abs(x - this.c.getX()), 2.0d) + Math.pow(Math.abs(y - this.c.getY()), 2.0d))) >= iDipsToIntPixels2) {
                        g.this.m = true;
                        SigMacroCommon macroCommon = g.this.g.getMacroCommon();
                        if (macroCommon != null) {
                            macroCommon.updateClickMarco(this.c, event, false);
                        }
                        g.this.a((String) null);
                    }
                }
                return true;
            }
        });
        int iDipsToIntPixels3 = Dips.dipsToIntPixels(145.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, iDipsToIntPixels3);
        addView(aiVar, layoutParams);
    }

    private void m() {
        Context context = getContext();
        aa aaVar = new aa(context);
        aaVar.setButtonColor(this.g.getButtonColor());
        aaVar.a(this.g.getDesc(), null);
        int iDipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        aaVar.setOnTouchListener(this.k);
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(100.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, iDipsToIntPixels2);
        addView(aaVar, layoutParams);
    }

    private void n() {
        Context context = getContext();
        ag agVar = new ag(context);
        String title = this.g.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = "点击查看详情";
        }
        agVar.a(title, this.g.getDesc());
        int iDipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(40.0f, context);
        agVar.setOnTouchListener(this.k);
        int iDipsToIntPixels3 = Dips.dipsToIntPixels(100.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(iDipsToIntPixels2, 0, iDipsToIntPixels2, iDipsToIntPixels3);
        addView(agVar, layoutParams);
    }

    private void o() {
        Context context = getContext();
        com.sigmob.sdk.base.views.i iVar = new com.sigmob.sdk.base.views.i(context);
        int iDipsToIntPixels = Dips.dipsToIntPixels(183.0f, context);
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(40.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(iVar, layoutParams);
        iVar.setOnTouchListener(this.k);
        String title = this.g.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = "点击前往";
        }
        ao aoVar = new ao(context);
        aoVar.setTitle(title);
        aoVar.setDescription(this.g.getDesc());
        aoVar.setOnTouchListener(this.k);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        layoutParams2.setMargins(0, 0, 0, iDipsToIntPixels2);
        addView(aoVar, layoutParams2);
    }

    private void p() {
        Context context = getContext();
        x xVar = new x(context);
        int iDipsToIntPixels = Dips.dipsToIntPixels(20.0f, context);
        boolean z = this.g.getadPrivacy() != null;
        if (z) {
            xVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.splash.g.11
                private MotionEvent b;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent event) {
                    if (g.this.g == null) {
                        return false;
                    }
                    if (event.getAction() == 0) {
                        this.b = MotionEvent.obtain(event);
                    } else if (event.getAction() == 1) {
                        g.this.g.getClickCommon().click_area = "appinfo";
                        g.this.g.getClickCommon().click_scene = "ad";
                        com.sigmob.sdk.base.utils.c.a(g.a, g.this.g);
                        if (this.b == null) {
                            this.b = event;
                        }
                        try {
                            g.this.g.getMacroCommon().updateClickMarco(this.b, event, false);
                        } catch (Throwable th) {
                            SigmobLog.e("splash click macro set " + th.getMessage());
                        }
                        g.this.h.i();
                    }
                    return true;
                }
            });
        }
        xVar.a(this.g.getAd_source_logo(), z);
        xVar.setAlpha(0.5f);
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(5.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(iDipsToIntPixels2, 0, iDipsToIntPixels2, iDipsToIntPixels2);
        addView(xVar, layoutParams);
    }

    private void q() {
        Context context = getContext();
        au auVar = new au(context);
        int iDipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, iDipsToIntPixels2);
        if (this.g.getClickType() == 1) {
            auVar.setOnTouchListener(this.k);
        }
        ak.a aVar = new ak.a(context, new AnonymousClass2(auVar), ak.c.WRING);
        this.q = aVar;
        aVar.c(this.g.getSensitivity());
        this.q.a();
        addView(auVar, layoutParams);
    }

    protected void a() {
        super.setVisibility(8);
        b bVar = this.e;
        if (bVar != null) {
            bVar.setVisibility(8);
        }
    }

    void a(boolean hasClose) {
        if (hasClose) {
            BaseBroadcastReceiver.a(this.f, this.g.getUuid(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
            this.p.setOnClickListener(null);
            com.sigmob.sdk.base.common.g.b(this.g);
            this.g = null;
        }
        ak.a aVar = this.q;
        if (aVar != null) {
            aVar.c();
            this.q = null;
        }
        v vVar = this.r;
        if (vVar != null) {
            vVar.b();
        }
        this.e.setOnTouchListener(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0127 A[Catch: all -> 0x0144, TryCatch #0 {all -> 0x0144, blocks: (B:3:0x0001, B:6:0x0031, B:36:0x012f, B:7:0x0035, B:31:0x0123, B:33:0x0127, B:34:0x012a, B:8:0x0052, B:9:0x006f, B:10:0x008c, B:13:0x009f, B:14:0x00bf, B:15:0x00c3, B:18:0x00d6, B:19:0x00db, B:22:0x00ee, B:23:0x00f3, B:26:0x0106, B:27:0x010b, B:30:0x011e), top: B:41:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.sigmob.sdk.base.models.BaseAdUnit r5, android.app.Activity r6) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.splash.g.a(com.sigmob.sdk.base.models.BaseAdUnit, android.app.Activity):boolean");
    }

    protected void b() {
        super.setVisibility(4);
    }

    public boolean c() {
        BaseAdUnit baseAdUnit = this.g;
        if (baseAdUnit != null && baseAdUnit.getSplashFilePath() != null) {
            return this.e.a(this.g);
        }
        SigmobLog.e("adUnit or splashFilePath is null");
        return false;
    }

    public void d() {
        this.m = false;
        ak.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
        this.e.b();
    }

    public void e() {
        ak.a aVar = this.q;
        if (aVar != null) {
            aVar.a();
        }
        v vVar = this.r;
        if (vVar != null) {
            vVar.a();
        }
        this.e.c();
    }

    public int getDuration() {
        return this.e.getDuration();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g == null) {
            SigmobLog.e("adUnit is null");
            return;
        }
        a aVar = this.h;
        if (aVar == null) {
            return;
        }
        aVar.a(o.c(this), this.g, new q.b() { // from class: com.sigmob.sdk.splash.g.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                SigmobLog.d(g.a + "#onCloseClick");
                g.this.n = false;
                g.this.m = false;
                if (g.this.o) {
                    g.this.a(true);
                } else if (g.this.q != null) {
                    g.this.q.a();
                }
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(Error error) {
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String url, String clickCoordinate) {
                SigmobLog.d(g.a + "#onCloseClick");
                if (g.this.g == null) {
                    return;
                }
                ClickCommon clickCommon = g.this.g.getClickCommon();
                clickCommon.click_scene = "appinfo";
                clickCommon.click_area = ClickCommon.CLICK_AREA_BTN;
                clickCommon.is_final_click = true;
                g.this.f();
                af sessionManager = g.this.g.getSessionManager();
                if (sessionManager == null) {
                    return;
                }
                sessionManager.a("click", 0);
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                SigmobLog.d(g.a + "#onShowSuccess");
                if (g.this.q != null) {
                    g.this.q.b();
                }
                g.this.n = true;
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ak.a aVar = this.q;
        if (aVar != null) {
            aVar.c();
        }
        v vVar = this.r;
        if (vVar != null) {
            vVar.b();
        }
        removeAllViews();
    }

    public void setAspectRatio(float v) {
        this.t = v;
    }

    public void setDuration(int duration) {
        if (this.g == null) {
            return;
        }
        if (duration > 0 && n.b(this.p)) {
            this.p.a(duration);
            return;
        }
        this.o = true;
        ac.a("complete", (String) null, this.g);
        if (n.b(Boolean.valueOf(this.n)) || this.s) {
            a(true);
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener l) {
        b bVar = this.e;
        if (bVar == null) {
            return;
        }
        bVar.setOnTouchListener(l);
    }

    public void setShowAppLogo(boolean showAppLogo) {
        this.i = showAppLogo;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        af sessionManager;
        if (visibility != 0) {
            try {
                ac.a(PointCategory.SPLASHADBLOCK, WindAdError.ERROR_SPLASH_ADBLOCK.getErrorCode(), Preconditions.NoThrow.getLineInfo(), this.g);
                SigmobLog.e("debug " + Preconditions.NoThrow.getLineInfo());
                return;
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                return;
            }
        }
        this.p.setVisibility(0);
        this.e.a();
        BaseAdUnit baseAdUnit = this.g;
        if (baseAdUnit != null && (sessionManager = baseAdUnit.getSessionManager()) != null) {
            sessionManager.a("start", 0);
        }
        super.setVisibility(visibility);
    }
}
