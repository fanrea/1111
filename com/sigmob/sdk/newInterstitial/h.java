package com.sigmob.sdk.newInterstitial;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.common.utils.ViewUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.google.android.material.timepicker.TimeModel;
import com.sigmob.sdk.base.common.aa;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.af;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.InterstitialSetting;
import com.sigmob.sdk.base.utils.j;
import com.sigmob.sdk.base.utils.n;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView;
import com.sigmob.sdk.videoplayer.k;
import com.sigmob.windad.natives.WindNativeAdData;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h extends com.sigmob.sdk.videoAd.b {
    public static final String f = "h";
    private boolean A;
    private boolean B;
    private j C;
    private com.sigmob.sdk.nativead.a D;
    private final View.OnClickListener E;
    private final BaseAdUnit g;
    private final Bundle h;
    private final com.sigmob.sdk.base.common.h i;
    private f j;
    private RelativeLayout k;
    private final List<String> l;
    private final List<String> m;
    private com.sigmob.sdk.videoplayer.a n;
    private g o;
    private InterstitialSetting p;
    private final boolean q;
    private NewInterstitialHeaderView r;
    private int s;
    private String t;
    private long u;
    private int v;
    private final Handler w;
    private boolean x;
    private boolean y;
    private q z;

    /* renamed from: com.sigmob.sdk.newInterstitial.h$6, reason: invalid class name */
    class AnonymousClass6 implements k {
        private boolean b;

        AnonymousClass6() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public /* synthetic */ void b(com.sigmob.sdk.videoplayer.d dVar) {
            SigmobLog.i("video player state change " + dVar);
            switch (AnonymousClass8.a[dVar.ordinal()]) {
                case 1:
                    if (h.this.n != null) {
                        h hVar = h.this;
                        hVar.s = (int) hVar.n.getDuration();
                        if (h.this.s == 0) {
                            h hVar2 = h.this;
                            hVar2.s = hVar2.g.getDuration();
                        }
                        h.this.g.getVideoCommon().video_time = (int) (h.this.s / 1000.0f);
                    }
                    h.this.g.getVideoCommon().is_first = 1;
                    h.this.g.getVideoCommon().type = 1;
                    h.this.g.getVideoCommon().scene = 1;
                    h.this.g.getVideoCommon().is_auto_play = 1;
                    h.this.g.getVideoCommon().is_last = 0;
                    h.this.g.getVideoCommon().end_time = 0;
                    h hVar3 = h.this;
                    hVar3.x = hVar3.g.getIsMute() != 0;
                    if (h.this.n != null) {
                        h.this.n.setMute(h.this.x);
                        h.this.r.setSoundStatus(h.this.x);
                        h.this.r.showSoundIcon();
                        break;
                    }
                    break;
                case 2:
                    if (this.b) {
                        h.this.g.getVideoCommon().type = 2;
                    }
                    this.b = false;
                    if (h.this.a() != null) {
                        h.this.a().a("video_start", 0);
                    }
                    if (h.this.n != null) {
                        h.this.g.getVideoCommon().begin_time = (int) (h.this.n.getCurrentPositionWhenPlaying() / 1000.0f);
                        break;
                    }
                    break;
                case 3:
                    if (h.this.n != null) {
                        ac.a("video", h.this.n.getErrorCode(), h.this.n.getErrorMessage(), h.this.g);
                    }
                    h.this.p();
                    break;
                case 4:
                    if (h.this.a() != null) {
                        h.this.a().a("complete", 0);
                    }
                    if (!h.this.g.hasEndCard()) {
                        h.this.g.getVideoCommon().type = 3;
                        h.this.z();
                        break;
                    }
                    h.this.p();
                    break;
                case 5:
                    h.this.p();
                    break;
                case 6:
                    h.this.C();
                    h.this.A();
                    break;
                case 7:
                    h.this.D();
                    h.this.z();
                    break;
                case 8:
                    if (h.this.a() != null) {
                        h.this.a().a("video_pause", 0);
                    }
                    this.b = true;
                    break;
            }
        }

        @Override // com.sigmob.sdk.videoplayer.k
        public void a(long position, long duration) {
            SigmobLog.d("position " + position + " duration " + duration);
            for (com.sigmob.sdk.videoAd.d dVar : h.this.i.a(position, h.this.s)) {
                h.this.b(dVar.getEvent());
                dVar.setTracked();
            }
            if (position > h.this.s) {
                h.this.p();
            }
        }

        @Override // com.sigmob.sdk.videoplayer.k
        public void a(final com.sigmob.sdk.videoplayer.d state) {
            if (h.this.n == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.h$6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(state);
                }
            });
        }
    }

    /* renamed from: com.sigmob.sdk.newInterstitial.h$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.sigmob.sdk.videoplayer.d.values().length];
            a = iArr;
            try {
                iArr[com.sigmob.sdk.videoplayer.d.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_AUTO_COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_PAUSE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public h(Activity activity, BaseAdUnit adUnit, Bundle intentExtras, Bundle savedInstanceState, String broadcastIdentifier, com.sigmob.sdk.base.common.j controllerListener) throws IllegalStateException {
        super(activity, broadcastIdentifier, controllerListener);
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.w = new Handler(Looper.getMainLooper());
        this.E = new View.OnClickListener() { // from class: com.sigmob.sdk.newInterstitial.h.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity activityN = h.this.n();
                if (activityN == null || h.this.g == null) {
                    return;
                }
                h hVar = h.this;
                if (hVar.a(hVar.D)) {
                    return;
                }
                h.this.D = new com.sigmob.sdk.nativead.a(activityN, h.this.g);
                h.this.D.a();
                h.this.D.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.newInterstitial.h.7.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        h.this.g();
                        h.this.E();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int position, String value, boolean enforce) {
                        h.this.g();
                        h.this.E();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                        h.this.f();
                    }
                });
            }
        };
        this.g = adUnit;
        this.h = intentExtras;
        com.sigmob.sdk.base.common.h adConfig = adUnit.getAdConfig();
        this.i = adConfig;
        adConfig.a(n(), adUnit, new q.b() { // from class: com.sigmob.sdk.newInterstitial.h.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                h.this.A = false;
                h.this.z();
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(Error error) {
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String url, String clickCoordinate) {
                h.this.g.getClickCommon().click_area = "appinfo";
                h.this.g.getClickCommon().is_final_click = true;
                h.this.r();
                af afVarA = h.this.a();
                if (afVarA == null) {
                    return;
                }
                afVarA.a("click", 0);
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                h.this.A = true;
                h.this.A();
            }
        });
        k().a(7);
        this.q = adUnit.getTemplateType() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        G();
        com.sigmob.sdk.videoplayer.a aVar = this.n;
        if (aVar == null) {
            return;
        }
        aVar.j();
    }

    private void B() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.sigmob.sdk.videoAd.d("play_quarter", 0.25f));
        arrayList.add(new com.sigmob.sdk.videoAd.d("play_two_quarters", 0.5f));
        arrayList.add(new com.sigmob.sdk.videoAd.d("play_three_quarters", 0.75f));
        this.i.a((List<com.sigmob.sdk.videoAd.d>) arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout == null || relativeLayout.getVisibility() == 0) {
            return;
        }
        this.u = System.currentTimeMillis();
        this.k.setVisibility(0);
        this.t = "loading";
        int i = this.v + 1;
        this.v = i;
        if (i > 2) {
            return;
        }
        this.w.postDelayed(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.h$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.J();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.l.add(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Long.valueOf(System.currentTimeMillis() - this.u)));
            this.m.add(String.format(Locale.getDefault(), "%.2f", Float.valueOf(((int) this.n.getCurrentPositionWhenPlaying()) / 1000.0f)));
            this.t = "play";
            this.w.removeCallbacksAndMessages(null);
            this.k.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.sigmob.sdk.nativead.a aVar = this.D;
        if (aVar == null) {
            return;
        }
        aVar.dismiss();
        this.D.b();
        this.D = null;
    }

    private void F() {
        if (this.y) {
            return;
        }
        com.sigmob.sdk.videoplayer.a aVar = this.n;
        if (aVar != null) {
            aVar.r();
            this.n = null;
        }
        this.y = true;
        if (this.o == null) {
            g gVar = new g(this.a);
            this.o = gVar;
            gVar.a(this.E);
            a(this.o.getCTAButton(), com.sigmob.sdk.base.a.ENDCARD);
            this.o.a(this.g.getIconUrl(), this.g.getEndCardImageUrl(), this.g.getAppName(), this.g.getCreativeTitle(), this.g.getCTAText());
            SigAdPrivacyInfoView adPrivacyInfo = this.o.getAdPrivacyInfo();
            if (n.b(adPrivacyInfo)) {
                View privacyLl = adPrivacyInfo.getPrivacyLl();
                if (n.b(privacyLl)) {
                    privacyLl.setBackgroundColor(0);
                    a(adPrivacyInfo, com.sigmob.sdk.base.a.ENDCARD);
                }
            }
            this.o.getCloseButton().setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.newInterstitial.h$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(view);
                }
            });
        }
        this.r.hideSoundIcon();
        ViewUtil.removeFromParent(this.j);
        m().addView(this.o, new ViewGroup.LayoutParams(-1, -1));
    }

    private void G() {
        j jVar = this.C;
        if (jVar == null) {
            return;
        }
        jVar.c();
    }

    private void H() {
        j jVar = this.C;
        if (jVar == null) {
            return;
        }
        jVar.d();
    }

    private void I() {
        j jVar = this.C;
        if (jVar == null) {
            return;
        }
        jVar.e();
        this.C = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        this.w.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        s();
    }

    private void a(ViewGroup adContainer) {
        int templateId = this.g.getTemplateId();
        if (templateId == 6001) {
            com.sigmob.sdk.videoplayer.a aVarY = y();
            this.n = aVarY;
            adContainer.addView(aVarY, new ViewGroup.LayoutParams(-1, -1));
            this.n.a();
            return;
        }
        if (templateId != 6002) {
            return;
        }
        ImageView imageView = new ImageView(this.a);
        adContainer.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        com.sigmob.sdk.base.common.g.a().load(this.g.getMainImage()).into(imageView);
    }

    private void a(Button button, final com.sigmob.sdk.base.a clickUIType) {
        button.setText(this.g.getCTAText());
        button.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.newInterstitial.h.2
            private MotionEvent c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) throws UnsupportedEncodingException {
                String coordinate;
                if (event.getAction() == 0) {
                    this.c = event;
                } else if (event.getAction() == 1) {
                    SigMacroCommon macroCommon = h.this.g.getMacroCommon();
                    if (macroCommon != null) {
                        macroCommon.updateClickMarco(this.c, event, false);
                        coordinate = macroCommon.getCoordinate();
                    } else {
                        coordinate = "";
                    }
                    h.this.g.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                    h.this.g.getClickCommon().click_scene = clickUIType == com.sigmob.sdk.base.a.AD ? "ad" : "endcard";
                    h.this.g.getClickCommon().is_final_click = h.this.g.noHasDownloadDialog();
                    h.this.g.getAdConfig().a(clickUIType, coordinate, true);
                }
                return false;
            }
        });
        this.g.getAdConfig().a(new aa() { // from class: com.sigmob.sdk.newInterstitial.h$$ExternalSyntheticLambda3
            @Override // com.sigmob.sdk.base.common.aa
            public final void onAdClick(boolean z, com.sigmob.sdk.base.a aVar) {
                this.f$0.a(z, aVar);
            }
        });
    }

    private void a(SigAdPrivacyInfoView adPrivacyInfo, final com.sigmob.sdk.base.a type) {
        if (adPrivacyInfo == null) {
            return;
        }
        adPrivacyInfo.a(this.g.getAd_source_logo(), n.b(this.g.getadPrivacy()));
        adPrivacyInfo.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.newInterstitial.h.4
            private MotionEvent c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) throws UnsupportedEncodingException {
                int action = event.getAction();
                if (action == 0) {
                    this.c = event;
                } else if (action == 1) {
                    SigMacroCommon macroCommon = h.this.g.getMacroCommon();
                    if (n.b(macroCommon)) {
                        macroCommon.updateClickMarco(this.c, event, false);
                    }
                    h.this.a(type);
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, com.sigmob.sdk.base.a aVar) {
        if (this.g.getClickCommon().is_final_click) {
            r();
        }
        af afVarA = a();
        if (afVarA == null) {
            return;
        }
        afVarA.a("click", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(final com.sigmob.sdk.base.a type) {
        try {
            Activity activityN = n();
            if (this.z == null && activityN != null) {
                q qVar = new q(n(), this.g);
                this.z = qVar;
                qVar.a(new q.b() { // from class: com.sigmob.sdk.newInterstitial.h.5
                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a() {
                        h.this.z();
                        h.this.x();
                        h.this.A = false;
                        af afVarA = h.this.a();
                        if (afVarA == null) {
                            return;
                        }
                        afVarA.a(com.sigmob.sdk.base.common.a.g, 0);
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a(Error error) {
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a(String url, String clickCoordinate) throws UnsupportedEncodingException {
                        if (h.this.g == null) {
                            return;
                        }
                        h.this.g.getClickCommon().is_final_click = true;
                        h.this.g.getAdConfig().a(type, url, clickCoordinate, true);
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void b() {
                        h.this.A();
                        af afVarA = h.this.a();
                        if (afVarA == null) {
                            return;
                        }
                        afVarA.a(com.sigmob.sdk.base.common.a.f, 0);
                    }
                });
            }
            q qVar2 = this.z;
            if (qVar2 == null || !qVar2.a() || this.A) {
                return false;
            }
            this.g.getClickCommon().click_area = "appinfo";
            this.g.getClickCommon().click_scene = type == com.sigmob.sdk.base.a.AD ? "ad" : "endcard";
            this.g.getClickCommon().is_final_click = false;
            if (a() != null) {
                a().a("click", 0);
            }
            this.z.show();
            this.A = true;
            return true;
        } catch (Exception e) {
            SigmobLog.e("openFourElements fail:" + e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        boolean z = !this.x;
        this.x = z;
        this.r.setSoundStatus(z);
        com.sigmob.sdk.videoplayer.a aVar = this.n;
        if (aVar == null) {
            return;
        }
        aVar.setMute(this.x);
    }

    private void q() {
        Context context;
        String str;
        this.j = new f(this.a);
        int iScreenHeightAsIntDips = Dips.screenHeightAsIntDips(this.a);
        int iScreenWidthAsIntDips = Dips.screenWidthAsIntDips(this.a);
        if (this.q) {
            context = this.a;
            str = "sig_new_interstitial_full_layout";
        } else if (iScreenHeightAsIntDips * 0.8f <= 553.0f || iScreenWidthAsIntDips * 0.8f <= 287.0f) {
            context = this.a;
            str = "sig_new_interstitial_small_layout";
        } else {
            context = this.a;
            str = "sig_new_interstitial_layout";
        }
        this.j.a(ResourceUtil.getLayoutId(context, str));
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        ViewGroup mainAdContainer = this.j.getMainAdContainer();
        this.p = this.g.getNewInterstitialSetting();
        m().addView(this.j, new ViewGroup.LayoutParams(-1, -1));
        a(mainAdContainer);
        w();
        t();
        a(this.j.getCTAButton(), com.sigmob.sdk.base.a.AD);
        if (this.p == null) {
            return;
        }
        m().postDelayed(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.h$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.v();
            }
        }, this.p.charge_time.intValue() * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.sigmob.sdk.base.utils.c.a(f, this.g);
        a(IntentActions.ACTION_INTERSTITIAL_CLICK);
    }

    private void s() {
        k().a();
    }

    private void t() {
        NewInterstitialHeaderView headerView = this.j.getHeaderView();
        this.r = headerView;
        boolean z = true;
        headerView.showFeedback(this.n != null, this.E);
        this.r.setAdHeaderViewStateListener(new NewInterstitialHeaderView.a() { // from class: com.sigmob.sdk.newInterstitial.h.3
            @Override // com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView.a
            public void a() {
                h.this.v();
                af afVarA = h.this.a();
                if (afVarA == null) {
                    return;
                }
                afVarA.a("show_close", 0);
            }

            @Override // com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView.a
            public void b() {
                h.this.v();
                af afVarA = h.this.a();
                if (afVarA == null) {
                    return;
                }
                afVarA.a("show_skip", 0);
            }
        });
        this.r.setSoundClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.newInterstitial.h$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.d(view);
            }
        });
        this.r.setCloseClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.newInterstitial.h$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        });
        this.r.setSkipClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.newInterstitial.h$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        InterstitialSetting interstitialSetting = this.p;
        if (interstitialSetting == null) {
            return;
        }
        if (!interstitialSetting.skip_close_ad.booleanValue() && this.g.hasEndCard()) {
            z = false;
        }
        this.r.startAdTimer(this.p.show_skip_seconds.intValue(), z);
    }

    private void u() {
        af afVarA = a();
        if (n.b(afVarA)) {
            afVarA.a("skip", 0);
        }
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.B) {
            return;
        }
        this.B = true;
        af afVarA = a();
        if (afVarA == null) {
            return;
        }
        afVarA.a("charge", 0);
    }

    private void w() {
        SigAdInfoView adInfView = this.j.getAdInfView();
        if (adInfView == null) {
            return;
        }
        adInfView.setAppInfoView(this.g.getIconUrl(), this.g.getAppName(), this.g.getCreativeTitle());
        SigAdPrivacyInfoView adPrivacyInfo = adInfView.getAdPrivacyInfo();
        if (adPrivacyInfo == null) {
            return;
        }
        adPrivacyInfo.getPrivacyAdText().setTextColor(-1);
        a(adInfView.getAdPrivacyInfo(), com.sigmob.sdk.base.a.AD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        q qVar = this.z;
        if (qVar == null) {
            return;
        }
        qVar.dismiss();
        this.z.c();
        this.z = null;
    }

    private com.sigmob.sdk.videoplayer.a y() {
        if (this.n == null) {
            com.sigmob.sdk.videoplayer.a aVar = new com.sigmob.sdk.videoplayer.a(l());
            this.n = aVar;
            aVar.setVideoPlayerStatusListener(new AnonymousClass6());
            B();
        }
        this.n.setUp(this.g.getProxyVideoUrl());
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        H();
        com.sigmob.sdk.videoplayer.a aVar = this.n;
        if (aVar == null) {
            return;
        }
        aVar.d();
    }

    public af a() {
        BaseAdUnit baseAdUnit = this.g;
        if (baseAdUnit == null) {
            return null;
        }
        af sessionManager = baseAdUnit.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        c cVar = new c();
        cVar.a(this.g);
        return cVar;
    }

    public void a(int seconds, j.a listener) {
        this.C = new j(seconds * 1000, 1000L);
        if (n.b(listener)) {
            this.C.a(listener);
        }
        this.C.a();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Bundle outState) {
    }

    void b(final String adEvent) {
        af afVarA = a();
        if (afVarA == null) {
            return;
        }
        afVarA.a(adEvent, (int) this.n.getCurrentPositionWhenPlaying());
    }

    @Override // com.sigmob.sdk.videoAd.b, com.sigmob.sdk.base.common.i
    public void e() {
        super.e();
        n().getWindow().addFlags(1024);
        b();
        b(n(), 7, this.h);
        q();
        af afVarA = a();
        if (afVarA == null) {
            return;
        }
        afVarA.a("start", 0);
        a(IntentActions.ACTION_INTERSTITIAL_SHOW);
    }

    @Override // com.sigmob.sdk.base.common.i
    public void f() {
        if (this.A) {
            return;
        }
        A();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void g() {
        if (this.A) {
            return;
        }
        z();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void h() {
        a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        I();
        com.sigmob.sdk.videoplayer.a aVar = this.n;
        if (aVar != null) {
            aVar.r();
            this.n = null;
        }
        x();
        E();
        this.g.destroy();
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.i
    public void o() {
    }

    public void p() {
        D();
        F();
    }
}
