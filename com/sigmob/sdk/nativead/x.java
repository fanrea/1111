package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.af;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.d;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.WindNativeAdData;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class x extends com.sigmob.sdk.base.common.i {
    private static p g;
    public final long f;
    private ac h;
    private ac i;
    private RelativeLayout j;
    private FrameLayout k;
    private BaseAdUnit l;
    private d m;
    private com.sigmob.sdk.mraid.d n;
    private View o;
    private WindNativeAdData p;
    private APKStatusBroadcastReceiver q;
    private ImageView r;
    private com.sigmob.sdk.base.views.q s;
    private boolean t;
    private boolean u;

    public x(Activity activity, BaseAdUnit baseAdUnit, Bundle intentExtras, Bundle savedInstanceState, String broadcastIdentifier, com.sigmob.sdk.base.common.j baseAdViewControllerListener) {
        super(activity, broadcastIdentifier, baseAdViewControllerListener);
        this.f = 300L;
        this.t = false;
        this.l = baseAdUnit;
        d dVar = (d) baseAdUnit.getAdConfig();
        this.m = dVar;
        dVar.a(n(), this.l, (q.b) null);
        this.h = (ac) intentExtras.getParcelable("attr");
        k().a(1);
        int iA = com.sigmob.sdk.base.k.a();
        if (iA == 0) {
            return;
        }
        n().getTheme().applyStyle(iA, true);
    }

    private void a(Context context) {
        if (this.r != null) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.r = imageView;
        imageView.setImageBitmap(com.sigmob.sdk.base.views.s.CLOSE.a());
        this.r.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.r.setImageAlpha(127);
        this.r.setClickable(true);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.nativead.x$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        int iDipsToIntPixels = Dips.dipsToIntPixels(20.0f, this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        int i = iDipsToIntPixels / 2;
        layoutParams.setMargins(i, i, 0, 0);
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null) {
            relativeLayout.addView(this.r, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        k().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.s sVar) {
    }

    public static void a(k sigAdView) {
        if (sigAdView instanceof p) {
            g = (p) sigAdView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        if (z) {
            s();
        } else if (g == null) {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        k().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.s sVar) {
    }

    private int r() {
        DisplayMetrics displayMetrics = ClientMetadata.getInstance().getDisplayMetrics();
        return Math.min((int) (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) / this.l.getAdPercent()), Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels) / 2);
    }

    private void s() {
        ImageView imageView = this.r;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(4);
    }

    private void t() {
        if (this.r == null) {
            a(n());
        }
        this.r.setVisibility(0);
    }

    private void u() {
        this.u = true;
        if (g == null) {
            k().a();
            return;
        }
        new ad(this.k, this.i, this.h, 300L).a();
        this.j.setVisibility(8);
        this.k.postDelayed(new Runnable() { // from class: com.sigmob.sdk.nativead.x$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.v();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        p pVar = g;
        if (pVar != null) {
            pVar.setUIStyle(h.PREVIEW);
        }
        k().a();
    }

    public af a() {
        af sessionManager = this.l.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        g gVar = new g();
        gVar.a(this.l);
        return gVar;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Bundle outState) {
    }

    @Override // com.sigmob.sdk.base.common.i
    public void e() {
        m().removeAllViews();
        k().onSetContentView(m());
        this.l.getClickCommon().click_scene = "template";
        RelativeLayout relativeLayout = new RelativeLayout(l());
        this.j = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        this.o = p();
        com.sigmob.sdk.mraid.d dVar = this.n;
        if (dVar != null) {
            dVar.a(n());
        }
        this.j.addView(this.o, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        p pVar = g;
        if (pVar != null) {
            WindNativeAdData nativeAdUnit = pVar.getNativeAdUnit();
            this.p = nativeAdUnit;
            if (nativeAdUnit != null) {
                layoutParams.setMargins(0, r(), 0, 0);
            }
        }
        m().addView(this.j, layoutParams);
        if (g != null) {
            this.k = new FrameLayout(n());
            g.setBackClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.nativead.x$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.b(view);
                }
            });
            m().addView(this.k, new RelativeLayout.LayoutParams(-1, r()));
            g.getSigVideoAdController().c();
            this.k.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.sigmob.sdk.nativead.x.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (x.g == null || x.this.k == null) {
                        return false;
                    }
                    x.this.k.getViewTreeObserver().removeOnPreDrawListener(this);
                    x.g.setUIStyle(h.DETAIL_PAGE);
                    ViewGroup videoContainer = x.g.getVideoContainer();
                    if (videoContainer != null) {
                        com.sigmob.sdk.base.utils.o.a(videoContainer);
                        x.this.k.addView(videoContainer, new FrameLayout.LayoutParams(-1, -1));
                    }
                    x.this.i = new ac();
                    int[] iArr = new int[2];
                    x.this.k.getLocationOnScreen(iArr);
                    x.this.i.a(iArr[0]);
                    x.this.i.b(0);
                    x.this.i.c(x.this.k.getMeasuredWidth());
                    x.this.i.d(x.this.k.getMeasuredHeight());
                    new ad(x.this.k, x.this.h, x.this.i, 300L).a();
                    x.this.h.b(x.this.h.b() - iArr[1]);
                    if (x.this.j != null) {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration(300L);
                        x.this.j.setAnimation(alphaAnimation);
                        alphaAnimation.start();
                    }
                    return true;
                }
            });
        }
        a(IntentActions.ACTION_NATIVE_TEMPLIE_SHOW, 100);
    }

    @Override // com.sigmob.sdk.base.common.i
    public void f() {
        r sigVideoAdController;
        p pVar = g;
        if (pVar == null || this.u || (sigVideoAdController = pVar.getSigVideoAdController()) == null) {
            return;
        }
        sigVideoAdController.a();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void g() {
        r sigVideoAdController;
        p pVar = g;
        if (pVar != null && (sigVideoAdController = pVar.getSigVideoAdController()) != null) {
            sigVideoAdController.c();
        }
        com.sigmob.sdk.mraid.d dVar = this.n;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void h() {
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.q;
        if (aPKStatusBroadcastReceiver != null) {
            aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            this.q = null;
        }
        com.sigmob.sdk.base.views.q qVar = this.s;
        if (qVar != null) {
            qVar.dismiss();
            this.s.c();
            this.s = null;
        }
        com.sigmob.sdk.mraid.d dVar = this.n;
        if (dVar != null) {
            dVar.m();
            this.n = null;
        }
        p pVar = g;
        if (pVar != null) {
            pVar.setBackClickListener(null);
            g = null;
        }
        a(IntentActions.ACTION_NATIVE_TEMPLE_DISMISS);
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.i
    public boolean j() {
        p pVar = g;
        if (pVar != null && pVar.b()) {
            return false;
        }
        u();
        return false;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void o() {
    }

    public View p() {
        if (this.n == null) {
            this.n = new com.sigmob.sdk.mraid.d(this.a, this.l, PlacementType.INTERSTITIAL);
        }
        this.n.a(new d.a() { // from class: com.sigmob.sdk.nativead.x.2
            @Override // com.sigmob.sdk.mraid.d.a
            public void a() {
                SigmobLog.d("SigNativeAdLandViewController onEndCardShow()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(float cvTime) {
                SigmobLog.d("SigNativeAdLandViewController onReward()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(int width, int height, int offsetX, int offsetY, a.EnumC0738a closePosition, boolean allowOffscreen) {
                SigmobLog.i("SigNativeAdLandViewController onResize()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(View view) {
                SigmobLog.d("SigNativeAdLandViewController onLoaded()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(WindAdError error) {
                SigmobLog.i("SigNativeAdLandViewController onRenderProcessGone:" + error.toString());
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(String ext) {
                SigmobLog.i("SigNativeAdLandViewController onCompanionClick:" + ext);
                boolean z = true;
                if (!TextUtils.isEmpty(ext)) {
                    try {
                        x.this.l.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                        x.this.l.getClickCommon().is_final_click = true;
                        JSONObject jSONObject = new JSONObject(ext);
                        int iOptInt = jSONObject.optInt("type");
                        x.this.n.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                        if (iOptInt != 1) {
                            x.this.a().a("click", 0);
                        } else {
                            z = false;
                        }
                    } catch (Exception unused) {
                        x.this.n.a("0", "0");
                        x.this.a().a("click", 0);
                    }
                }
                x.this.m.a(com.sigmob.sdk.base.a.COMPANION, x.this.n.a(), z);
                x.this.a(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
            @Override // com.sigmob.sdk.mraid.d.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a(java.net.URI r8, int r9, java.lang.String r10) {
                /*
                    r7 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "SigNativeAdLandViewController  onOpen:"
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.StringBuilder r0 = r0.append(r8)
                    java.lang.String r1 = "======"
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.StringBuilder r9 = r0.append(r9)
                    java.lang.String r0 = "====="
                    java.lang.StringBuilder r9 = r9.append(r0)
                    java.lang.StringBuilder r9 = r9.append(r10)
                    java.lang.String r9 = r9.toString()
                    com.czhj.sdk.logger.SigmobLog.i(r9)
                    boolean r9 = android.text.TextUtils.isEmpty(r10)
                    r0 = 0
                    r1 = 1
                    if (r9 != 0) goto L97
                    com.sigmob.sdk.nativead.x r9 = com.sigmob.sdk.nativead.x.this     // Catch: java.lang.Exception -> L93
                    com.sigmob.sdk.base.models.BaseAdUnit r9 = com.sigmob.sdk.nativead.x.g(r9)     // Catch: java.lang.Exception -> L93
                    com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()     // Catch: java.lang.Exception -> L93
                    java.lang.String r2 = "btn"
                    r9.click_area = r2     // Catch: java.lang.Exception -> L93
                    com.sigmob.sdk.nativead.x r9 = com.sigmob.sdk.nativead.x.this     // Catch: java.lang.Exception -> L93
                    com.sigmob.sdk.base.models.BaseAdUnit r9 = com.sigmob.sdk.nativead.x.g(r9)     // Catch: java.lang.Exception -> L93
                    com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()     // Catch: java.lang.Exception -> L93
                    r9.is_final_click = r1     // Catch: java.lang.Exception -> L93
                    org.json.JSONObject r9 = new org.json.JSONObject     // Catch: java.lang.Exception -> L93
                    r9.<init>(r10)     // Catch: java.lang.Exception -> L93
                    java.lang.String r10 = "type"
                    int r10 = r9.optInt(r10)     // Catch: java.lang.Exception -> L93
                    java.lang.String r2 = "x"
                    int r2 = r9.optInt(r2)     // Catch: java.lang.Exception -> L93
                    java.lang.String r3 = "y"
                    int r3 = r9.optInt(r3)     // Catch: java.lang.Exception -> L93
                    java.lang.String r4 = "disable_landing"
                    boolean r4 = r9.optBoolean(r4)     // Catch: java.lang.Exception -> L93
                    java.lang.String r5 = "feDisable"
                    boolean r9 = r9.optBoolean(r5)     // Catch: java.lang.Exception -> L90
                    if (r9 != 0) goto L76
                    r9 = r1
                    goto L77
                L76:
                    r9 = r0
                L77:
                    com.sigmob.sdk.nativead.x r5 = com.sigmob.sdk.nativead.x.this     // Catch: java.lang.Exception -> L91
                    com.sigmob.sdk.mraid.d r5 = com.sigmob.sdk.nativead.x.k(r5)     // Catch: java.lang.Exception -> L91
                    java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L91
                    java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L91
                    r5.a(r2, r3)     // Catch: java.lang.Exception -> L91
                    if (r10 != r1) goto L8b
                    goto L8c
                L8b:
                    r0 = r1
                L8c:
                    r6 = r9
                    r5 = r0
                    r0 = r4
                    goto L99
                L90:
                    r9 = r1
                L91:
                    r0 = r4
                    goto L94
                L93:
                    r9 = r1
                L94:
                    r6 = r9
                    r5 = r1
                    goto L99
                L97:
                    r5 = r1
                    r6 = r5
                L99:
                    if (r0 != 0) goto Lb6
                    com.sigmob.sdk.nativead.x r9 = com.sigmob.sdk.nativead.x.this
                    com.sigmob.sdk.base.models.BaseAdUnit r9 = com.sigmob.sdk.nativead.x.g(r9)
                    java.lang.String r9 = r9.getLanding_page()
                    boolean r9 = android.text.TextUtils.isEmpty(r9)
                    if (r9 == 0) goto Lac
                    goto Lb6
                Lac:
                    com.sigmob.sdk.nativead.x r8 = com.sigmob.sdk.nativead.x.this
                    com.sigmob.sdk.nativead.d r1 = com.sigmob.sdk.nativead.x.h(r8)
                    com.sigmob.sdk.base.a r2 = com.sigmob.sdk.base.a.ENDCARD
                    r3 = 0
                    goto Lc2
                Lb6:
                    com.sigmob.sdk.nativead.x r9 = com.sigmob.sdk.nativead.x.this
                    com.sigmob.sdk.nativead.d r1 = com.sigmob.sdk.nativead.x.h(r9)
                    com.sigmob.sdk.base.a r2 = com.sigmob.sdk.base.a.ENDCARD
                    java.lang.String r3 = r8.toString()
                Lc2:
                    com.sigmob.sdk.nativead.x r8 = com.sigmob.sdk.nativead.x.this
                    com.sigmob.sdk.mraid.d r8 = com.sigmob.sdk.nativead.x.k(r8)
                    java.lang.String r4 = r8.a()
                    r1.a(r2, r3, r4, r5, r6)
                    com.sigmob.sdk.nativead.x r8 = com.sigmob.sdk.nativead.x.this
                    java.lang.String r9 = "action.native.temple.click"
                    com.sigmob.sdk.nativead.x.c(r8, r9)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.nativead.x.AnonymousClass2.a(java.net.URI, int, java.lang.String):void");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(boolean isMute) {
                SigmobLog.d("SigNativeAdLandViewController onMute()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void b() {
                SigmobLog.d("SigNativeAdLandViewController onShowSkipTime()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void b(float progress) {
                SigmobLog.d("SigNativeAdLandViewController onSkip()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void c() {
                SigmobLog.d("SigNativeAdLandViewController onFeedBack()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void d() {
                SigmobLog.d("SigNativeAdLandViewController onExpand()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void e() {
                SigmobLog.i("SigNativeAdLandViewController onFailedToLoad()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void f() {
                SigmobLog.i("SigNativeAdLandViewController onUnload()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void g() {
                SigmobLog.i("SigNativeAdLandViewController onOpenFourElements()");
                if (x.this.s == null) {
                    x.this.s = new com.sigmob.sdk.base.views.q(x.this.n(), x.this.l);
                    x.this.s.a(new q.b() { // from class: com.sigmob.sdk.nativead.x.2.1
                        @Override // com.sigmob.sdk.base.views.q.b
                        public void a() {
                            if (x.this.s != null) {
                                x.this.s.dismiss();
                                x.this.s.c();
                                x.this.s = null;
                                x.this.t = false;
                            }
                            x.this.l.getClickCommon().click_scene = "template";
                            x.this.a().a(com.sigmob.sdk.base.common.a.g, 0);
                        }

                        @Override // com.sigmob.sdk.base.views.q.b
                        public void a(Error error) {
                        }

                        @Override // com.sigmob.sdk.base.views.q.b
                        public void a(String url, String clickCoordinate) {
                            x.this.l.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                            x.this.l.getClickCommon().click_scene = "appinfo";
                            x.this.l.getClickCommon().is_final_click = true;
                            if (x.this.m != null) {
                                x.this.m.a(com.sigmob.sdk.base.a.COMPANION, url, clickCoordinate, true);
                                x.this.a(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
                            }
                        }

                        @Override // com.sigmob.sdk.base.views.q.b
                        public void b() {
                            x.this.a().a(com.sigmob.sdk.base.common.a.f, 0);
                        }
                    });
                }
                if (x.this.s == null || !x.this.s.a() || x.this.t) {
                    return;
                }
                x.this.l.getClickCommon().click_area = "appinfo";
                x.this.l.getClickCommon().is_final_click = false;
                x.this.a().a("click", 0);
                x.this.s.show();
                x.this.t = true;
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void h() {
                SigmobLog.i("SigNativeAdLandViewController onClose()");
                x.this.k().onBackPressed();
            }
        });
        if (!TextUtils.isEmpty(this.l.getHtmlUrl())) {
            this.n.b(this.l.getHtmlUrl(), new d.b() { // from class: com.sigmob.sdk.nativead.x$$ExternalSyntheticLambda2
                @Override // com.sigmob.sdk.mraid.d.b
                public final void onReady(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.s sVar) {
                    x.b(pVar, sVar);
                }
            });
        } else if (!TextUtils.isEmpty(this.l.getHtmlData())) {
            this.n.a(this.l.getHtmlData(), new d.b() { // from class: com.sigmob.sdk.nativead.x$$ExternalSyntheticLambda3
                @Override // com.sigmob.sdk.mraid.d.b
                public final void onReady(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.s sVar) {
                    x.a(pVar, sVar);
                }
            });
        }
        this.n.a(new d.e() { // from class: com.sigmob.sdk.nativead.x$$ExternalSyntheticLambda4
            @Override // com.sigmob.sdk.mraid.d.e
            public final void useCustomCloseChanged(boolean z) {
                this.f$0.a(z);
            }
        });
        return this.n.q();
    }
}
