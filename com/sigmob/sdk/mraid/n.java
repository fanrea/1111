package com.sigmob.sdk.mraid;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.aa;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.views.ap;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.base.views.w;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.d;
import com.sigmob.sdk.mraid.t;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class n extends com.sigmob.sdk.videoAd.b implements aa {
    public static final String f = "n";
    protected com.sigmob.sdk.base.common.s g;
    private final Bundle h;
    private int i;
    private com.sigmob.sdk.videoAd.a j;
    private int k;
    private boolean l;
    private BaseAdUnit m;
    private d n;
    private r o;
    private ap p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private com.sigmob.sdk.base.views.q u;
    private boolean v;
    private com.sigmob.sdk.nativead.a w;
    private w x;
    private JSONObject y;
    private final View.OnClickListener z;

    /* renamed from: com.sigmob.sdk.mraid.n$3, reason: invalid class name */
    class AnonymousClass3 implements d.a {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) throws NumberFormatException {
            if (b.a(str) == null || n.this.g == null) {
                return;
            }
            Float fValueOf = Float.valueOf(str);
            if (fValueOf.floatValue() < 0.999f && !n.this.r) {
                n.this.r = true;
                n.this.b("skip");
            }
            if (n.this.l || n.this.m.getAd_type() == 4 || fValueOf.floatValue() <= n.this.m.getFinishedTime()) {
                return;
            }
            n.this.l = true;
            n.this.g.a("reward", n.this.n.f().intValue());
            n.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void a() {
            n.this.b("show");
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void a(float cvtime) {
            n.this.l = true;
            n.this.b("reward");
            n.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void a(int width, int height, int offsetX, int offsetY, a.EnumC0738a closePosition, boolean allowOffscreen) {
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void a(View view) {
            n.this.b("start");
            n.this.a(IntentActions.ACTION_INTERSTITIAL_SHOW);
            SigmobLog.d("onLoaded() called");
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void a(WindAdError error) {
            SigmobLog.d("Finishing the activity due to a problem: " + error);
            n.this.b("error");
            if (n.this.b != null) {
                n.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            n.this.d.a();
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void a(String ext) {
            boolean z = true;
            if (!TextUtils.isEmpty(ext)) {
                try {
                    JSONObject jSONObject = new JSONObject(ext);
                    int iOptInt = jSONObject.optInt("type");
                    if (jSONObject.has("x") && jSONObject.has("y")) {
                        n.this.n.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                    }
                    if (iOptInt != 1) {
                        n.this.y = jSONObject.optJSONObject("log_data");
                    } else {
                        z = false;
                    }
                } catch (Exception unused) {
                    n.this.n.a("0", "0");
                }
            }
            n.this.j.a(com.sigmob.sdk.base.a.COMPANION, n.this.n.a(), z);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
        @Override // com.sigmob.sdk.mraid.d.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(java.net.URI r11, int r12, java.lang.String r13) {
            /*
                r10 = this;
                java.lang.String r12 = "y"
                java.lang.String r0 = "x"
                boolean r1 = android.text.TextUtils.isEmpty(r13)
                r2 = 0
                r3 = 1
                r4 = 0
                if (r1 != 0) goto L6a
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L66
                r1.<init>(r13)     // Catch: java.lang.Exception -> L66
                java.lang.String r13 = "type"
                int r13 = r1.optInt(r13)     // Catch: java.lang.Exception -> L65
                boolean r4 = r1.has(r0)     // Catch: java.lang.Exception -> L65
                if (r4 == 0) goto L40
                boolean r4 = r1.has(r12)     // Catch: java.lang.Exception -> L65
                if (r4 == 0) goto L40
                int r0 = r1.optInt(r0)     // Catch: java.lang.Exception -> L65
                int r12 = r1.optInt(r12)     // Catch: java.lang.Exception -> L65
                com.sigmob.sdk.mraid.n r4 = com.sigmob.sdk.mraid.n.this     // Catch: java.lang.Exception -> L65
                com.sigmob.sdk.mraid.d r4 = com.sigmob.sdk.mraid.n.b(r4)     // Catch: java.lang.Exception -> L65
                java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Exception -> L65
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Exception -> L65
                r4.a(r0, r12)     // Catch: java.lang.Exception -> L65
            L40:
                java.lang.String r12 = "disable_landing"
                boolean r12 = r1.optBoolean(r12)     // Catch: java.lang.Exception -> L65
                java.lang.String r0 = "feDisable"
                boolean r0 = r1.optBoolean(r0)     // Catch: java.lang.Exception -> L64
                r0 = r0 ^ r3
                if (r13 == r3) goto L5f
                com.sigmob.sdk.mraid.n r13 = com.sigmob.sdk.mraid.n.this     // Catch: java.lang.Exception -> L5c
                java.lang.String r2 = "log_data"
                org.json.JSONObject r2 = r1.optJSONObject(r2)     // Catch: java.lang.Exception -> L5c
                com.sigmob.sdk.mraid.n.a(r13, r2)     // Catch: java.lang.Exception -> L5c
                r2 = r3
                goto L5f
            L5c:
                r2 = r12
                r4 = r1
                goto L67
            L5f:
                r8 = r0
                r9 = r1
                r7 = r2
                r2 = r12
                goto L6d
            L64:
                r2 = r12
            L65:
                r4 = r1
            L66:
                r0 = r3
            L67:
                r8 = r0
                r7 = r3
                goto L6c
            L6a:
                r7 = r3
                r8 = r7
            L6c:
                r9 = r4
            L6d:
                if (r2 == 0) goto L89
                com.sigmob.sdk.mraid.n r12 = com.sigmob.sdk.mraid.n.this
                com.sigmob.sdk.videoAd.a r3 = com.sigmob.sdk.mraid.n.c(r12)
                com.sigmob.sdk.base.a r4 = com.sigmob.sdk.base.a.ENDCARD
                java.lang.String r5 = r11.toString()
                com.sigmob.sdk.mraid.n r11 = com.sigmob.sdk.mraid.n.this
                com.sigmob.sdk.mraid.d r11 = com.sigmob.sdk.mraid.n.b(r11)
                java.lang.String r6 = r11.a()
                r3.a(r4, r5, r6, r7, r8, r9)
                goto L9f
            L89:
                com.sigmob.sdk.mraid.n r11 = com.sigmob.sdk.mraid.n.this
                com.sigmob.sdk.videoAd.a r3 = com.sigmob.sdk.mraid.n.c(r11)
                com.sigmob.sdk.base.a r4 = com.sigmob.sdk.base.a.ENDCARD
                r5 = 0
                com.sigmob.sdk.mraid.n r11 = com.sigmob.sdk.mraid.n.this
                com.sigmob.sdk.mraid.d r11 = com.sigmob.sdk.mraid.n.b(r11)
                java.lang.String r6 = r11.a()
                r3.a(r4, r5, r6, r7, r8)
            L9f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid.n.AnonymousClass3.a(java.net.URI, int, java.lang.String):void");
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void a(boolean isMute) {
            n nVar;
            String str;
            if (isMute) {
                nVar = n.this;
                str = com.sigmob.sdk.base.common.a.D;
            } else {
                nVar = n.this;
                str = com.sigmob.sdk.base.common.a.E;
            }
            nVar.b(str);
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void b() {
            n.this.b("show_skip");
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void b(float progress) {
            if (n.this.r) {
                return;
            }
            n.this.r = true;
            n.this.b("skip");
            n.this.a(IntentActions.ACTION_REWARDED_VIDEO_SKIP);
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void c() {
            Activity activityN = n.this.n();
            if (activityN == null || n.this.m == null) {
                return;
            }
            n nVar = n.this;
            if (nVar.a(nVar.w)) {
                return;
            }
            n.this.w = new com.sigmob.sdk.nativead.a(activityN, n.this.m);
            n.this.w.a();
            n.this.w.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid.n.3.1
                @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                public void onCancel() {
                    n.this.c("feedbackDidDisappear");
                    n.this.s();
                }

                @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                public void onSelected(int position, String value, boolean enforce) {
                    n.this.c("feedbackDidDisappear");
                    n.this.s();
                }

                @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                public void onShow() {
                    n.this.c("feedbackDidAppear");
                }
            });
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void d() {
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void e() {
            SigmobLog.d("MraidActivity failed to load. Finishing the activity");
            if (n.this.b != null) {
                n.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            n.this.d.a();
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void f() {
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void g() {
            if (n.this.u == null) {
                n.this.u = new com.sigmob.sdk.base.views.q(n.this.n(), n.this.m);
                n.this.u.a(new q.b() { // from class: com.sigmob.sdk.mraid.n.3.2
                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a() {
                        n.this.p();
                        if (n.this.g != null) {
                            n.this.g.a(com.sigmob.sdk.base.common.a.g, 0);
                        }
                        n.this.c("fourElementsDidDisappear");
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a(Error error) {
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a(String url, String clickCoordinate) {
                        if (n.this.j != null) {
                            n.this.j.a(com.sigmob.sdk.base.a.ENDCARD, url, clickCoordinate, true);
                        }
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void b() {
                        if (n.this.g != null) {
                            n.this.g.a(com.sigmob.sdk.base.common.a.f, 0);
                        }
                        n.this.c("fourElementsDidAppear");
                    }
                });
            }
            if (n.this.u == null || !n.this.u.a() || n.this.v) {
                return;
            }
            n.this.u.show();
            n.this.v = true;
        }

        @Override // com.sigmob.sdk.mraid.d.a
        public void h() {
            n.this.n.a(new ValueCallback() { // from class: com.sigmob.sdk.mraid.n$3$$ExternalSyntheticLambda0
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) throws NumberFormatException {
                    this.f$0.b((String) obj);
                }
            });
            n.this.a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
            n.this.s = true;
            n.this.d.a();
        }
    }

    /* renamed from: com.sigmob.sdk.mraid.n$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.sigmob.sdk.base.a.values().length];
            b = iArr;
            try {
                iArr[com.sigmob.sdk.base.a.COMPANION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[com.sigmob.sdk.base.a.VIDEO_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ConsoleMessage.MessageLevel.values().length];
            a = iArr2;
            try {
                iArr2[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(Activity activity, BaseAdUnit baseAdUnit, Bundle intentExtras, Bundle savedInstanceState, String mBroadcastIdentifier, com.sigmob.sdk.base.common.j baseAdViewControllerListener) {
        super(activity, mBroadcastIdentifier, baseAdViewControllerListener);
        this.s = false;
        this.t = false;
        this.v = false;
        this.z = new View.OnClickListener() { // from class: com.sigmob.sdk.mraid.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity activityN = n.this.n();
                if (activityN == null || n.this.m == null) {
                    return;
                }
                n nVar = n.this;
                if (nVar.a(nVar.w)) {
                    return;
                }
                n.this.w = new com.sigmob.sdk.nativead.a(activityN, n.this.m);
                n.this.w.a();
                n.this.w.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid.n.5.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        n.this.s();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int position, String value, boolean enforce) {
                        n.this.s();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                    }
                });
            }
        };
        this.m = baseAdUnit;
        this.h = intentExtras;
        com.sigmob.sdk.videoAd.a aVar = (com.sigmob.sdk.videoAd.a) baseAdUnit.getAdConfig();
        this.j = aVar;
        aVar.a(n(), this.m, new q.b() { // from class: com.sigmob.sdk.mraid.n.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                n.this.c("fourElementsDidDisappear");
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(Error error) {
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String url, String clickCoordinate) {
                n.this.m.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                n.this.m.getClickCommon().click_scene = "appinfo";
                n.this.m.getClickCommon().is_final_click = true;
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                n.this.c("fourElementsDidAppear");
            }
        });
        this.j.a((aa) this);
        this.k = ClientMetadata.getInstance().getInsetBottom();
        m().setBackgroundColor(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets a(View view, WindowInsets windowInsets) {
        this.n.a(windowInsets);
        return windowInsets;
    }

    private void a(Context context, int initialVisibility) {
        if (this.p != null) {
            return;
        }
        ap apVar = new ap(context);
        this.p = apVar;
        apVar.setVisibility(initialVisibility);
        this.p.setId(ClientMetadata.generateViewId());
        int iDipsToIntPixels = Dips.dipsToIntPixels(10.0f, this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(iDipsToIntPixels, iDipsToIntPixels * 2, iDipsToIntPixels, iDipsToIntPixels);
        m().addView(this.p, layoutParams);
        this.p.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.mraid.n.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    n.this.s = true;
                    n.this.j.b(n.this.l(), n.this.q, n.this.m);
                    n.this.k().a();
                }
                return true;
            }
        });
        this.p.a(this.m);
        String strF = this.j.f();
        if (strF != null) {
            this.p.a(strF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(p pVar, com.sigmob.sdk.base.common.s sVar) {
        if (sVar != null) {
            this.g = sVar;
            return;
        }
        com.sigmob.sdk.base.common.s sVar2 = new com.sigmob.sdk.base.common.s();
        this.g = sVar2;
        sVar2.a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Integer num, String str2) {
        try {
            if (this.g == null) {
                return;
            }
            if (b.a(str2) == null) {
                if (str.equals("show_skip")) {
                    this.g.a(false, 0);
                }
                this.g.a(str, 0);
                return;
            }
            float f2 = Float.parseFloat(str2);
            float fIntValue = -1.0f;
            if (f2 > 1.0E-7d && num != null && num.intValue() > 0) {
                fIntValue = f2 * num.intValue();
            }
            if (str.equals("show_skip")) {
                this.g.a(false, (int) fIntValue);
            }
            this.g.a(str, (int) fIntValue);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(Context context, int visibility) {
        if (this.x == null) {
            w wVar = new w(context);
            this.x = wVar;
            wVar.setText("反馈");
            this.x.setOnClickListener(this.z);
            this.x.setId(ClientMetadata.generateViewId());
            int iDipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.p.getId());
            layoutParams.addRule(6, this.p.getId());
            layoutParams.setMargins(0, -iDipsToIntPixels, 0, 0);
            m().addView(this.x, layoutParams);
        }
        w wVar2 = this.x;
        if (wVar2 != null) {
            wVar2.setVisibility(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(p pVar, com.sigmob.sdk.base.common.s sVar) {
        if (sVar != null) {
            this.g = sVar;
            return;
        }
        com.sigmob.sdk.base.common.s sVar2 = new com.sigmob.sdk.base.common.s();
        this.g = sVar2;
        sVar2.a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z) {
        if (z) {
            q();
        } else {
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String event) {
        b bVarE;
        d dVar = this.n;
        if (dVar == null || dVar.g() == null || (bVarE = this.n.e()) == null) {
            return;
        }
        bVarE.a(event, (HashMap<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.sigmob.sdk.base.views.q qVar = this.u;
        if (qVar == null) {
            return;
        }
        qVar.dismiss();
        this.u.c();
        this.u = null;
        this.v = false;
    }

    private void q() {
        ap apVar = this.p;
        if (apVar != null) {
            apVar.setVisibility(4);
        }
        w wVar = this.x;
        if (wVar != null) {
            wVar.setVisibility(4);
        }
    }

    private void r() {
        if (this.p == null) {
            a(this.a, 0);
        }
        this.p.setVisibility(0);
        b(l(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.sigmob.sdk.nativead.a aVar = this.w;
        if (aVar == null) {
            return;
        }
        aVar.dismiss();
        this.w.b();
        this.w = null;
    }

    public View a() {
        String str = this.b;
        t.a aVarA = str != null ? t.a(str) : null;
        this.n = (aVarA == null || aVarA.d() == null) ? new d(this.a, this.m, PlacementType.INTERSTITIAL) : aVarA.d();
        if (Build.VERSION.SDK_INT >= 20) {
            a(new View.OnApplyWindowInsetsListener() { // from class: com.sigmob.sdk.mraid.n$$ExternalSyntheticLambda1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return this.f$0.a(view, windowInsets);
                }
            });
        }
        this.n.a(this.e);
        this.n.a(new d.f() { // from class: com.sigmob.sdk.mraid.n.2
            private boolean b;

            @Override // com.sigmob.sdk.mraid.d.f
            public void a() {
                SigmobLog.d("adImpression() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void a(Integer duration) {
                n.this.q = duration == null ? -1 : duration.intValue();
                n.this.g.a(n.this.q, n.this.j.l());
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void a(Map<String, String> params) {
                try {
                    params.get("id");
                    String str2 = params.get("url");
                    if (!params.get("playerHandles").equalsIgnoreCase("false")) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.startsWith(com.alipay.sdk.m.l.a.r)) {
                                n.this.m.setCustomLandPageUrl(str2);
                            } else {
                                n.this.m.setCustomDeeplink(str2);
                            }
                        }
                        n.this.j.a(com.sigmob.sdk.base.a.ENDCARD, n.this.n.a(), true);
                    }
                    SigmobLog.d("adClickThru() called" + params);
                } catch (Throwable th) {
                    SigmobLog.e("adClickThru", th);
                }
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void b() {
                if (this.b) {
                    return;
                }
                n.this.b("pause");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void b(Map<String, String> params) {
                SigmobLog.d("adError() called " + params);
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void c() {
                SigmobLog.d("adPlaying() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void d() {
                this.b = true;
                n.this.b("complete");
                SigmobLog.d("adVideoComplete() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void e() {
                n.this.b("play_quarter");
                SigmobLog.d("adVideoFirstQuartile() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void f() {
                n.this.b("play_three_quarters");
                SigmobLog.d("adVideoThirdQuartile() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void g() {
                n.this.b("play_two_quarters");
                SigmobLog.d("adVideoMidpoint() called");
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void h() {
                n.this.b(com.sigmob.sdk.base.common.a.P);
                n.this.a(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
                SigmobLog.d("adVideoStart() called");
            }
        });
        this.n.a(new AnonymousClass3());
        this.n.a(new d.e() { // from class: com.sigmob.sdk.mraid.n$$ExternalSyntheticLambda2
            @Override // com.sigmob.sdk.mraid.d.e
            public final void useCustomCloseChanged(boolean z) {
                this.f$0.b(z);
            }
        });
        if (aVarA != null) {
            this.g = aVarA.c();
        } else if (!TextUtils.isEmpty(this.m.getHtmlData())) {
            this.n.a(this.m.getHtmlData(), new d.b() { // from class: com.sigmob.sdk.mraid.n$$ExternalSyntheticLambda3
                @Override // com.sigmob.sdk.mraid.d.b
                public final void onReady(p pVar, com.sigmob.sdk.base.common.s sVar) {
                    this.f$0.b(pVar, sVar);
                }
            });
        } else if (!TextUtils.isEmpty(this.m.getHtmlUrl())) {
            this.n.b(this.m.getHtmlUrl(), new d.b() { // from class: com.sigmob.sdk.mraid.n$$ExternalSyntheticLambda4
                @Override // com.sigmob.sdk.mraid.d.b
                public final void onReady(p pVar, com.sigmob.sdk.base.common.s sVar) {
                    this.f$0.a(pVar, sVar);
                }
            });
        }
        return this.n.q();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Configuration configuration) {
        this.n.a(configuration.orientation);
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Bundle outState) {
    }

    public void a(r debugListener) {
        this.o = debugListener;
        d dVar = this.n;
        if (dVar == null) {
            return;
        }
        dVar.a(debugListener);
    }

    public void b(final String event) {
        final Integer numF = this.n.f();
        this.n.a(new ValueCallback() { // from class: com.sigmob.sdk.mraid.n$$ExternalSyntheticLambda0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                this.f$0.a(event, numF, (String) obj);
            }
        });
    }

    @Override // com.sigmob.sdk.videoAd.b, com.sigmob.sdk.base.common.i
    public void e() {
        super.e();
        b(n(), this.i, this.h);
        n().getWindow().addFlags(16778240);
        com.sigmob.sdk.base.common.s sVar = this.g;
        if (sVar != null) {
            sVar.a("show", 0);
        }
        m().addView(a(), new FrameLayout.LayoutParams(-1, -1));
        d dVar = this.n;
        if (dVar != null) {
            dVar.a(n());
        }
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        a(new r() { // from class: com.sigmob.sdk.mraid.n.6
            @Override // com.sigmob.sdk.mraid.r
            public boolean a(ConsoleMessage consoleMessage) {
                if (AnonymousClass7.a[consoleMessage.messageLevel().ordinal()] != 1) {
                    return false;
                }
                SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                ac.a("h5_error", "mraid1", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, n.this.m, (ac.a) null);
                return false;
            }

            @Override // com.sigmob.sdk.mraid.r
            public boolean a(String message, JsResult result) {
                return false;
            }
        });
    }

    @Override // com.sigmob.sdk.base.common.i
    public void f() {
        if (!this.s) {
            this.n.b();
        } else {
            this.t = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void g() {
        this.n.c();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void h() {
        com.sigmob.sdk.base.common.s sVar = this.g;
        if (sVar != null) {
            sVar.a();
            this.g = null;
        }
        d dVar = this.n;
        if (dVar != null) {
            dVar.m();
        }
        s();
        p();
        if (!this.s || !this.t) {
            this.t = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
        BaseAdUnit baseAdUnit = this.m;
        if (baseAdUnit != null) {
            baseAdUnit.destroy();
        }
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.i
    public boolean j() {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void o() {
    }

    @Override // com.sigmob.sdk.base.common.aa
    public void onAdClick(boolean isRecord, com.sigmob.sdk.base.a type) {
        String str;
        com.sigmob.sdk.base.utils.c.a(f, this.m);
        a(IntentActions.ACTION_INTERSTITIAL_CLICK);
        ClickCommon clickCommon = this.m.getClickCommon();
        if (isRecord) {
            int i = AnonymousClass7.b[type.ordinal()];
            if (i == 1) {
                ac.a(com.sigmob.sdk.base.a.COMPANION, "click", this.m, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, this.q, this.y);
                str = com.sigmob.sdk.base.common.a.w;
            } else if (i != 2) {
                ac.a(com.sigmob.sdk.base.a.ENDCARD, "click", this.m, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, this.q, this.y);
                str = "click";
            } else {
                ac.a(com.sigmob.sdk.base.a.VIDEO_CLICK, "click", this.m, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, this.q, this.y);
                str = "full_video_click";
            }
            b(str);
        }
        this.y = null;
    }
}
