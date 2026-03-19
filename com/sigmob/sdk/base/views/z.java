package com.sigmob.sdk.base.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.d;
import com.sigmob.windad.WindAdError;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class z extends Dialog implements DialogInterface.OnShowListener {
    protected com.sigmob.sdk.base.common.s a;
    private View b;
    private Window c;
    private a d;
    private RelativeLayout e;
    private com.sigmob.sdk.videoAd.a f;
    private BaseAdUnit g;
    private com.sigmob.sdk.mraid.d h;
    private Context i;
    private int j;
    private int k;
    private boolean l;

    public interface a {
        void onCloseClick();
    }

    public z(Context context, BaseAdUnit adUnit, com.sigmob.sdk.videoAd.a videoConfig) {
        super(context, com.sigmob.sdk.base.k.e());
        this.c = null;
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.i = context.getApplicationContext();
        this.g = adUnit;
        this.f = videoConfig;
        this.b = b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.s sVar) {
        if (sVar != null) {
            this.a = sVar;
            return;
        }
        com.sigmob.sdk.base.common.s sVar2 = new com.sigmob.sdk.base.common.s();
        this.a = sVar2;
        sVar2.a(this.g);
    }

    private void d() {
        Window window = getWindow();
        this.c = window;
        if (window == null) {
            return;
        }
        window.setGravity(80);
        int iG = com.sigmob.sdk.base.k.g();
        if (iG != 0) {
            this.c.setWindowAnimations(iG);
        }
        this.c.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = this.c.getAttributes();
        int i = this.i.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.i.getResources().getDisplayMetrics().heightPixels;
        int i3 = this.k;
        if (i3 - 1 <= i) {
            attributes.width = -1;
        } else {
            attributes.width = i3;
        }
        int i4 = this.j;
        if (i4 - 1 <= i2) {
            attributes.height = -1;
        } else {
            attributes.height = i4;
        }
        SigmobLog.i("RecommendDialog windowDeploy: " + i + "====" + i2 + "====" + attributes.width + "====" + attributes.height);
        this.c.setAttributes(attributes);
    }

    public void a(a closeClickListener) {
        this.d = closeClickListener;
    }

    public void a(String event) {
        com.sigmob.sdk.base.common.s sVar = this.a;
        if (sVar == null) {
            return;
        }
        sVar.a(event, 0);
    }

    public boolean a() {
        if (this.k <= 0 || this.j <= 0) {
            this.l = true;
        }
        return this.l;
    }

    public View b() {
        if (this.h == null) {
            this.h = new com.sigmob.sdk.mraid.d(this.i, this.g, PlacementType.INTERSTITIAL);
        }
        this.h.a(new d.f() { // from class: com.sigmob.sdk.base.views.z.1
            @Override // com.sigmob.sdk.mraid.d.f
            public void a() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void a(Integer duration) {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void a(Map<String, String> params) {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void b() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void b(Map<String, String> params) {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void c() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void d() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void e() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void f() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void g() {
            }

            @Override // com.sigmob.sdk.mraid.d.f
            public void h() {
            }
        });
        this.h.a(new d.a() { // from class: com.sigmob.sdk.base.views.z.2
            private int i() {
                WindowInsets rootWindowInsets;
                if (Build.VERSION.SDK_INT < 28 || (rootWindowInsets = z.this.getWindow().getDecorView().getRootWindowInsets()) == null || rootWindowInsets.getDisplayCutout() == null) {
                    return 0;
                }
                return rootWindowInsets.getDisplayCutout().getSafeInsetTop();
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a() {
                SigmobLog.d("RecommendDialog onEndCardShow()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(float cvTime) {
                SigmobLog.d("RecommendDialog onReward()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(int width, int height, int offsetX, int offsetY, a.EnumC0738a closePosition, boolean allowOffscreen) {
                int i = z.this.i.getResources().getDisplayMetrics().widthPixels;
                int i2 = z.this.i.getResources().getDisplayMetrics().heightPixels;
                int iN = com.sigmob.sdk.videoplayer.c.n(z.this.getContext());
                int i3 = i();
                SigmobLog.i("RecommendDialog Origin onResize :" + width + "==" + height + "==" + offsetX + "==" + offsetY + "==" + allowOffscreen);
                z zVar = z.this;
                zVar.k = Dips.dipsToIntPixels(width, zVar.i);
                z zVar2 = z.this;
                zVar2.j = Dips.dipsToIntPixels(height, zVar2.i);
                int iDipsToIntPixels = Dips.dipsToIntPixels(offsetX, z.this.i);
                int iDipsToIntPixels2 = Dips.dipsToIntPixels(offsetY, z.this.i) - Math.max(iN, i3);
                if (z.this.b == null) {
                    return;
                }
                if (!allowOffscreen) {
                    iDipsToIntPixels = Math.min(Math.max(iDipsToIntPixels, 0), i);
                    iDipsToIntPixels2 = Math.min(Math.max(iDipsToIntPixels2, 0), i2);
                    if (z.this.k + iDipsToIntPixels > i) {
                        z.this.k = i - iDipsToIntPixels;
                    }
                    if (z.this.j + iDipsToIntPixels2 > i2) {
                        z.this.j = i2 - iDipsToIntPixels2;
                    }
                }
                SigmobLog.i("RecommendDialog onResize: " + z.this.k + "==" + z.this.j + "==" + iDipsToIntPixels + "==" + iDipsToIntPixels2);
                if (z.this.k <= 0 || z.this.j <= 0) {
                    z.this.l = true;
                }
                z.this.b.setX(iDipsToIntPixels);
                z.this.b.setY(iDipsToIntPixels2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(z.this.k, z.this.j);
                layoutParams.addRule(12);
                z.this.b.setLayoutParams(layoutParams);
                z.this.b.requestLayout();
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(View view) {
                SigmobLog.d("RecommendDialog onLoaded()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(final WindAdError error) {
                SigmobLog.i("RecommendDialog onRenderProcessGone:" + error.toString());
                z.this.l = true;
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(String ext) {
                SigmobLog.i("RecommendDialog onCompanionClick:" + ext);
                boolean z = true;
                if (!TextUtils.isEmpty(ext)) {
                    try {
                        JSONObject jSONObject = new JSONObject(ext);
                        int iOptInt = jSONObject.optInt("type");
                        z.this.h.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                        if (iOptInt != 1) {
                            z.this.a(com.sigmob.sdk.base.common.a.w);
                        } else {
                            z = false;
                        }
                    } catch (Exception unused) {
                        z.this.h.a("0", "0");
                        z.this.a(com.sigmob.sdk.base.common.a.w);
                    }
                }
                z.this.f.a(com.sigmob.sdk.base.a.ENDCARD, z.this.h.a(), z);
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
            @Override // com.sigmob.sdk.mraid.d.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a(java.net.URI r11, int r12, java.lang.String r13) {
                /*
                    r10 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "RecommendDialog  onOpen:"
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.StringBuilder r0 = r0.append(r11)
                    java.lang.String r1 = "======"
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.StringBuilder r12 = r0.append(r12)
                    java.lang.String r0 = "====="
                    java.lang.StringBuilder r12 = r12.append(r0)
                    java.lang.StringBuilder r12 = r12.append(r13)
                    java.lang.String r12 = r12.toString()
                    com.czhj.sdk.logger.SigmobLog.i(r12)
                    boolean r12 = android.text.TextUtils.isEmpty(r13)
                    java.lang.String r0 = "click"
                    r1 = 0
                    java.lang.String r2 = "0"
                    r3 = 1
                    r4 = 0
                    if (r12 != 0) goto L98
                    org.json.JSONObject r12 = new org.json.JSONObject     // Catch: java.lang.Exception -> L87
                    r12.<init>(r13)     // Catch: java.lang.Exception -> L87
                    java.lang.String r13 = "type"
                    int r13 = r12.optInt(r13)     // Catch: java.lang.Exception -> L86
                    java.lang.String r4 = "x"
                    int r4 = r12.optInt(r4)     // Catch: java.lang.Exception -> L86
                    java.lang.String r5 = "y"
                    int r5 = r12.optInt(r5)     // Catch: java.lang.Exception -> L86
                    java.lang.String r6 = "disable_landing"
                    boolean r6 = r12.optBoolean(r6)     // Catch: java.lang.Exception -> L86
                    java.lang.String r7 = "feDisable"
                    boolean r7 = r12.optBoolean(r7)     // Catch: java.lang.Exception -> L82
                    if (r7 != 0) goto L61
                    r7 = r3
                    goto L62
                L61:
                    r7 = r1
                L62:
                    com.sigmob.sdk.base.views.z r8 = com.sigmob.sdk.base.views.z.this     // Catch: java.lang.Exception -> L80
                    com.sigmob.sdk.mraid.d r8 = com.sigmob.sdk.base.views.z.b(r8)     // Catch: java.lang.Exception -> L80
                    java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Exception -> L80
                    java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> L80
                    r8.a(r4, r5)     // Catch: java.lang.Exception -> L80
                    if (r13 == r3) goto L7b
                    com.sigmob.sdk.base.views.z r13 = com.sigmob.sdk.base.views.z.this     // Catch: java.lang.Exception -> L80
                    r13.a(r0)     // Catch: java.lang.Exception -> L80
                    r1 = r3
                L7b:
                    r8 = r12
                    r9 = r6
                    r6 = r1
                    r1 = r9
                    goto La9
                L80:
                    r4 = r12
                    goto L84
                L82:
                    r4 = r12
                    r7 = r3
                L84:
                    r1 = r6
                    goto L88
                L86:
                    r4 = r12
                L87:
                    r7 = r3
                L88:
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.d r12 = com.sigmob.sdk.base.views.z.b(r12)
                    r12.a(r2, r2)
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    r12.a(r0)
                    r6 = r3
                    goto La8
                L98:
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.d r12 = com.sigmob.sdk.base.views.z.b(r12)
                    r12.a(r2, r2)
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    r12.a(r0)
                    r6 = r3
                    r7 = r6
                La8:
                    r8 = r4
                La9:
                    if (r1 != 0) goto Ld3
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.base.models.BaseAdUnit r12 = com.sigmob.sdk.base.views.z.h(r12)
                    java.lang.String r12 = r12.getLanding_page()
                    boolean r12 = android.text.TextUtils.isEmpty(r12)
                    if (r12 == 0) goto Lbc
                    goto Ld3
                Lbc:
                    com.sigmob.sdk.base.views.z r11 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.videoAd.a r2 = com.sigmob.sdk.base.views.z.c(r11)
                    com.sigmob.sdk.base.a r3 = com.sigmob.sdk.base.a.ENDCARD
                    r4 = 0
                    com.sigmob.sdk.base.views.z r11 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.d r11 = com.sigmob.sdk.base.views.z.b(r11)
                    java.lang.String r5 = r11.a()
                    r2.a(r3, r4, r5, r6, r7)
                    goto Lec
                Ld3:
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.videoAd.a r2 = com.sigmob.sdk.base.views.z.c(r12)
                    com.sigmob.sdk.base.a r3 = com.sigmob.sdk.base.a.ENDCARD
                    java.lang.String r4 = r11.toString()
                    com.sigmob.sdk.base.views.z r11 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.d r11 = com.sigmob.sdk.base.views.z.b(r11)
                    java.lang.String r5 = r11.a()
                    r2.a(r3, r4, r5, r6, r7, r8)
                Lec:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.z.AnonymousClass2.a(java.net.URI, int, java.lang.String):void");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void a(boolean isMute) {
                SigmobLog.d("RecommendDialog onMute()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void b() {
                SigmobLog.d("RecommendDialog onShowSkipTime()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void b(float progress) {
                SigmobLog.d("RecommendDialog onSkip()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void c() {
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void d() {
                SigmobLog.d("RecommendDialog onExpand()");
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void e() {
                SigmobLog.i("RecommendDialog onFailedToLoad()");
                z.this.l = true;
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void f() {
                SigmobLog.i("RecommendDialog onUnload()");
                z.this.dismiss();
                z.this.a(com.sigmob.sdk.base.common.a.e);
                z.this.c();
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void g() {
            }

            @Override // com.sigmob.sdk.mraid.d.a
            public void h() {
                SigmobLog.i("RecommendDialog onClose()");
                if (z.this.d != null) {
                    z.this.d.onCloseClick();
                }
            }
        });
        String closeCardHtmlData = this.g.getCloseCardHtmlData();
        if (!TextUtils.isEmpty(closeCardHtmlData)) {
            this.h.a(closeCardHtmlData, new d.b() { // from class: com.sigmob.sdk.base.views.z$$ExternalSyntheticLambda0
                @Override // com.sigmob.sdk.mraid.d.b
                public final void onReady(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.s sVar) {
                    this.f$0.a(pVar, sVar);
                }
            });
        }
        return this.h.q();
    }

    public void c() {
        com.sigmob.sdk.mraid.d dVar = this.h;
        if (dVar == null) {
            return;
        }
        this.d = null;
        dVar.m();
        this.h = null;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.e = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.e.setBackgroundColor(0);
        setContentView(this.e);
        setOnShowListener(this);
        SigmobLog.i("RecommendDialog onCreate:" + this.k + ":" + this.j);
        View view = this.b;
        if (view != null) {
            this.e.addView(view);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        d();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialog) {
        SigmobLog.i("RecommendDialog  onShow");
        a(com.sigmob.sdk.base.common.a.d);
        this.h.a(0);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        this.c = window;
        com.sigmob.sdk.videoplayer.c.a(window);
    }
}
