package com.alliance.ssp.ad.impl.interstitial;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.activity.AppInfoViewActivity;
import com.alliance.ssp.ad.activity.SAAllianceWebViewActivity;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.YTAdInfo;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAdInteractionListener;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAdLoadListener;
import com.alliance.ssp.ad.bean.Interaction;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import com.alliance.ssp.ad.bean.Shake;
import com.alliance.ssp.ad.d0.g;
import com.alliance.ssp.ad.http.action.BaseNetAction;
import com.alliance.ssp.ad.l.a;
import com.alliance.ssp.ad.l.c;
import com.alliance.ssp.ad.l.l;
import com.alliance.ssp.ad.o0.h;
import com.alliance.ssp.ad.o0.j;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.r.i;
import com.alliance.ssp.ad.template.SAAllianceContainerView;
import com.alliance.ssp.ad.video.VideoController;
import com.alliance.ssp.ad.video.f;
import com.alliance.ssp.ad.w.e;
import com.alliance.ssp.ad.w.k;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;

/* compiled from: NMInterstitialAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends com.alliance.ssp.ad.w.a implements f.a {
    public boolean A1;
    public boolean B1;
    public Handler C1;
    public a D0;
    public Handler D1;
    public Activity E0;
    public com.alliance.ssp.ad.l.c E1;
    public View F0;
    public Shake F1;
    public k G0;
    public a.b G1;
    public FrameLayout H0;
    public SAAllianceAdData H1;
    public FrameLayout I0;
    public String I1;
    public FrameLayout J0;
    public boolean J1;
    public ImageView K0;
    public boolean K1;
    public ImageView L0;
    public VideoController L1;
    public FrameLayout M0;
    public int M1;
    public ImageView N0;
    public int N1;
    public TextView O0;
    public boolean O1;
    public TextView P0;
    public int P1;
    public TextView Q0;
    public int Q1;
    public LinearLayout R0;
    public com.alliance.ssp.ad.m0.a R1;
    public LinearLayout S0;
    public boolean S1;
    public FrameLayout T0;
    public boolean T1;
    public FrameLayout U0;
    public boolean U1;
    public FrameLayout V0;
    public boolean V1;
    public FrameLayout W0;
    public FrameLayout X0;
    public FrameLayout Y0;
    public RelativeLayout Z0;
    public boolean a1;
    public int b1;
    public int c1;
    public Dialog d1;
    public Bitmap e1;
    public Bitmap f1;
    public Material g1;
    public l h1;
    public float i1;
    public int j1;
    public String k1;
    public String l1;
    public String m1;
    public int n1;
    public int o1;
    public int p1;
    public int q1;
    public long r1;
    public boolean s1;
    public boolean t1;
    public boolean u1;
    public boolean v1;
    public int w1;
    public String x1;
    public int y1;
    public int z1;

    /* compiled from: NMInterstitialAdImpl.java */
    /* renamed from: com.alliance.ssp.ad.impl.interstitial.a$a, reason: collision with other inner class name */
    public class ViewTreeObserverOnGlobalLayoutListenerC0088a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ Activity a;

        public ViewTreeObserverOnGlobalLayoutListenerC0088a(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] iArr = new int[2];
            a.this.R0.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            a.this.f0 = com.alliance.ssp.ad.a.f.a("", i);
            a.this.g0 = com.alliance.ssp.ad.a.f.a("", i2);
            a.this.h0 = com.alliance.ssp.ad.a.b.a("").append(h.a(this.a, a.this.z1)).toString();
            a.this.i0 = com.alliance.ssp.ad.a.b.a("").append(h.a(this.a, a.this.Q1)).toString();
        }
    }

    public a(int i, WeakReference<Activity> weakReference, SAAllianceAdParams sAAllianceAdParams, SAInterstitialAdLoadListener sAInterstitialAdLoadListener, g gVar) {
        super(i, weakReference, "", "", sAAllianceAdParams, sAInterstitialAdLoadListener, null, gVar);
        this.E0 = null;
        this.G0 = null;
        this.K0 = null;
        this.L0 = null;
        this.M0 = null;
        this.Q0 = null;
        this.a1 = false;
        this.b1 = 0;
        this.c1 = -1;
        this.d1 = null;
        this.e1 = null;
        this.f1 = null;
        this.h1 = null;
        this.j1 = 1;
        this.k1 = "";
        this.l1 = "1";
        this.m1 = "";
        this.o1 = 0;
        this.p1 = 0;
        this.q1 = 1;
        this.r1 = 0L;
        this.s1 = false;
        this.t1 = false;
        this.u1 = false;
        this.v1 = false;
        this.w1 = 0;
        this.y1 = 0;
        this.z1 = 0;
        this.A1 = false;
        this.B1 = false;
        this.G1 = null;
        this.J1 = false;
        this.K1 = true;
        this.M1 = 0;
        this.N1 = 0;
        this.O1 = false;
        this.P1 = 0;
        this.Q1 = 32;
        this.S1 = false;
        this.T1 = false;
        this.U1 = false;
        this.V1 = false;
        gVar.c = this;
        this.D0 = this;
        this.x1 = sAAllianceAdParams.getPosId();
        a(sAAllianceAdParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Activity activityB = com.alliance.ssp.ad.o0.b.b();
        Dialog dialog = this.d1;
        if (dialog == null || !dialog.isShowing() || activityB == null || activityB.isFinishing()) {
            return;
        }
        this.d1.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        int i = com.alliance.ssp.ad.o0.l.a;
        i.a().a(this.g1.getAdm(), new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(double d2) {
        FrameLayout frameLayout;
        if (d2 < 3.0d || (frameLayout = this.I0) == null || this.S0 == null || this.q1 != 1 || !this.v1) {
            return;
        }
        frameLayout.setVisibility(8);
        this.S0.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (this.w1 != 1 || this.n1 == 1) {
            a("user", 0, false);
        }
    }

    public final void E() {
        l lVar = this.h1;
        if (lVar != null) {
            lVar.b();
        }
        VideoController videoController = this.L1;
        if (videoController != null && !this.u1 && videoController.f()) {
            k("", "", this.h);
        }
        this.q = true;
        com.alliance.ssp.ad.l.c cVar = this.E1;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void F() {
        l lVar = this.h1;
        if (lVar != null) {
            lVar.c();
        }
        VideoController videoController = this.L1;
        if (videoController != null && !this.u1 && videoController.i()) {
            b(this.h);
        }
        this.q = false;
        com.alliance.ssp.ad.l.c cVar = this.E1;
        if (cVar != null) {
            cVar.f();
        }
    }

    public final void G() {
        TextView textView;
        TextView textView2;
        Material material = this.g1;
        if (material == null) {
            int i = com.alliance.ssp.ad.o0.l.a;
            return;
        }
        if (material.getTitle() != null && !this.g1.getTitle().isEmpty() && (textView2 = this.O0) != null) {
            textView2.setText(com.alliance.ssp.ad.n0.c.a(this.g1.getTitle(), 7));
        } else if (this.n1 != 1) {
            this.O0.setText("查看网页");
        } else {
            this.O0.setText("Android 应用");
        }
        if (this.g1.getDesc() != null && !this.g1.getDesc().isEmpty() && (textView = this.P0) != null) {
            textView.setText(this.g1.getDesc());
        }
        if (this.g1.getIconurl() != null && !this.g1.getIconurl().isEmpty() && this.N0 != null) {
            i.a().a(this.g1.getIconurl(), new com.alliance.ssp.ad.w.d(this));
        } else if (this.n1 != 1) {
            this.N0.setImageResource(R.drawable.nmadssp_h5_icon_default);
        } else {
            this.N0.setImageResource(R.drawable.nmadssp_app_icon_default);
        }
    }

    public final View H() {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            int i = com.alliance.ssp.ad.o0.l.a;
            return null;
        }
        View viewInflate = LayoutInflater.from(contextA).inflate(R.layout.layout_nmssp_ad_interstitial_fullscreen_landscape, (ViewGroup) null, false);
        if (viewInflate == null) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            return null;
        }
        SAAllianceContainerView sAAllianceContainerView = (SAAllianceContainerView) viewInflate.findViewById(R.id.sa_alliance_container_view);
        if (sAAllianceContainerView != null) {
            sAAllianceContainerView.setImpl(this.D0);
        }
        this.K0 = (ImageView) viewInflate.findViewById(R.id.xml_interstitial_iv_gif_content);
        this.J0 = (FrameLayout) viewInflate.findViewById(R.id.xml_interstitial_video_content);
        this.Q0 = (TextView) viewInflate.findViewById(R.id.xml_interstitial_tv_close_cd);
        this.L0 = (ImageView) viewInflate.findViewById(R.id.xml_interstitial_iv_logo);
        this.M0 = (FrameLayout) viewInflate.findViewById(R.id.xml_interstitial_iv_audio_switch);
        this.H0 = (FrameLayout) viewInflate.findViewById(R.id.xml_interstitial_fl_six_element_container);
        this.Z0 = (RelativeLayout) viewInflate.findViewById(R.id.xml_interstitial_rl_show_container);
        this.R0 = (LinearLayout) viewInflate.findViewById(R.id.cta);
        this.W0 = (FrameLayout) viewInflate.findViewById(R.id.xml_interstitial_fl_show_container);
        this.N0 = (ImageView) viewInflate.findViewById(R.id.xml_interstitial_iv_app_icon);
        this.O0 = (TextView) viewInflate.findViewById(R.id.xml_interstitial_tv_app_name);
        this.P0 = (TextView) viewInflate.findViewById(R.id.xml_interstitial_tv_app_intro);
        G();
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.xml_interstitial_fl_shake_container);
        this.I0 = frameLayout;
        if (this.v1) {
            frameLayout.setVisibility(0);
            a(contextA);
        } else {
            frameLayout.setVisibility(8);
        }
        if (this.l1.equals("2")) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.I0.getLayoutParams();
            layoutParams.height = h.b(contextA, 108.0f);
            layoutParams.width = h.b(contextA, 108.0f);
            FrameLayout frameLayout2 = (FrameLayout) viewInflate.findViewById(R.id.express_show_view);
            this.U0 = frameLayout2;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout2.getLayoutParams();
            layoutParams2.height = h.b(contextA, this.y1);
            layoutParams2.width = h.b(contextA, 608.0f);
        }
        return viewInflate;
    }

    public void K() {
        t();
        int i = com.alliance.ssp.ad.o0.l.a;
        final Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        Runnable runnable = new Runnable() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(contextA);
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.J();
            }
        };
        this.g1.getAdm();
        if (!this.t1) {
            if (this.g1.getAdm().endsWith(PictureMimeType.GIF) && contextA != null) {
                n.d.a.execute(runnable);
                return;
            } else {
                if (this.g1.getAdm() == null || this.g1.getAdm().length() <= 0) {
                    return;
                }
                n.d.a.execute(runnable2);
                return;
            }
        }
        VideoController videoController = new VideoController(contextA, this.m1, this.J0, false, false, this.K1, this);
        this.L1 = videoController;
        this.p = videoController;
        boolean z = this.A1;
        if (z && (this.p1 != 1 || this.q1 != 1)) {
            videoController.D = true;
            videoController.E = true;
            return;
        }
        if (z || (this.p1 == 1 && this.q1 == 1)) {
            videoController.b().setVideoScalingMode(2);
            return;
        }
        if (this.l1.equals("1") && this.q1 == 2) {
            VideoController videoController2 = this.L1;
            videoController2.D = true;
            videoController2.E = true;
        } else if (this.l1.equals("2") && this.q1 == 2 && this.p1 == 1) {
            this.L1.b().setVideoScalingMode(2);
            VideoController videoController3 = this.L1;
            videoController3.D = false;
            videoController3.E = false;
        }
    }

    public final boolean L() throws JSONException, PackageManager.NameNotFoundException, IOException {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            int i = com.alliance.ssp.ad.o0.l.a;
            return false;
        }
        try {
            AppInfoViewActivity.f = this;
            Intent intent = new Intent(contextA, (Class<?>) AppInfoViewActivity.class);
            intent.putExtra("app_info_ad_data_copy", this.h.copy());
            contextA.startActivity(intent);
            z();
            return true;
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 032: ")), e);
            return false;
        }
    }

    public final void M() {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            return;
        }
        com.alliance.ssp.ad.m0.a aVar = new com.alliance.ssp.ad.m0.a(new com.alliance.ssp.ad.m0.c() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda5
            @Override // com.alliance.ssp.ad.m0.c
            public final void a(Object obj) {
                this.f$0.a((Intent) obj);
            }
        }, contextA);
        this.R1 = aVar;
        aVar.b("SA_TARGET_YT_WEB_ACTIVITY_FINISHED");
    }

    public final void N() {
        VideoController videoController = this.L1;
        if (videoController != null) {
            videoController.g();
        }
        com.alliance.ssp.ad.l.c cVar = this.E1;
        if (cVar != null) {
            cVar.g();
        }
        this.q = false;
        com.alliance.ssp.ad.m0.a aVar = this.R1;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(final int i, final int i2, final String str) {
        n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(i, i2, str);
            }
        });
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void b(int i) {
    }

    public final void e(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
                this.f$0.d(view2);
            }
        });
    }

    @Override // com.alliance.ssp.ad.t.a
    public void m() {
        Dialog dialog = this.d1;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        p();
    }

    @Override // com.alliance.ssp.ad.t.a
    public void n() {
        F();
    }

    @Override // com.alliance.ssp.ad.t.a
    public void o() {
        E();
        VideoController videoController = this.L1;
        if (videoController != null) {
            boolean zF = videoController.f();
            if (this.u1 || !zF) {
                return;
            }
            k("", "", this.h);
        }
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void onError(MediaPlayer mediaPlayer, int i, int i2) {
        int i3 = com.alliance.ssp.ad.o0.l.a;
        a("Show failure", 100006, "1", "素材不可用");
        q("", "", this.h);
        b(100006, "1", "加载素材失败");
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        VideoController videoController;
        int i3 = com.alliance.ssp.ad.o0.l.a;
        if (i != 3 || (videoController = this.L1) == null) {
            return;
        }
        videoController.b(false);
    }

    @Override // com.alliance.ssp.ad.t.a
    public void q() {
    }

    @Override // com.alliance.ssp.ad.t.a
    public void r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Context context) {
        int i = com.alliance.ssp.ad.o0.l.a;
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        j.a().a(context, this.g1.getAdm(), "aaaccc" + strReplace, new c(strReplace));
    }

    public static void a(a aVar, int i, String str, String str2) {
        Handler handler;
        aVar.getClass();
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (aVar.H1 != null && (handler = aVar.D1) != null) {
            handler.removeCallbacksAndMessages(null);
            aVar.D1.sendEmptyMessage(0);
        } else {
            aVar.a(i, str, str2);
            com.alliance.ssp.ad.t.i.a(aVar.w, aVar.x1, i, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (this.w1 == 1) {
            a(this.R0, "1");
        } else {
            a(view, (String) null);
        }
    }

    public final void b(final View view) {
        SAAllianceAdData sAAllianceAdData = this.h;
        if (sAAllianceAdData != null && sAAllianceAdData.getInteraction() != null && this.h.getInteraction().getAutoCloseCountdownTime() != null && this.h.getInteraction().getAutoCloseCountdownTime().intValue() > 0) {
            float fIntValue = this.h.getInteraction().getAutoCloseCountdownTime().intValue();
            this.i1 = fIntValue;
            if (this.A >= fIntValue) {
                this.A = fIntValue - 1.0f;
            }
        } else if (this.A >= 50.0f) {
            this.A = 49.0f;
        }
        float f = this.i1;
        if (f > 0.0f || this.A > 0.0f || this.v1) {
            this.h1 = l.a(Math.max((long) (Math.max(f, this.A) * 1000.0f), com.alipay.sdk.m.u.b.a), 100L, new l.a() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda0
                @Override // com.alliance.ssp.ad.l.l.a
                public final void a(double d2, double d3) throws JSONException, PackageManager.NameNotFoundException, IOException {
                    this.f$0.a(view, d2, d3);
                }
            });
        }
    }

    /* compiled from: NMInterstitialAdImpl.java */
    public class d implements i.a {
        public d() {
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Bitmap bitmap) {
            a aVar = a.this;
            aVar.v = bitmap;
            aVar.e1 = bitmap;
            aVar.B1 = bitmap.getWidth() > bitmap.getHeight();
            a.this.s();
            a aVar2 = a.this;
            long jCurrentTimeMillis = System.currentTimeMillis();
            a aVar3 = a.this;
            aVar2.r1 = jCurrentTimeMillis - aVar3.r1;
            long j = aVar3.r1;
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Exception exc) {
            exc.getMessage();
            int i = com.alliance.ssp.ad.o0.l.a;
            a.this.b(100006, "1", "加载image素材失败");
        }
    }

    public static void a(a aVar, String str) {
        SAAllianceAdData sAAllianceAdDataCopy;
        aVar.getClass();
        int i = com.alliance.ssp.ad.o0.l.a;
        Context contextA = com.alliance.ssp.ad.o0.b.a(aVar.f);
        if (contextA == null || (sAAllianceAdDataCopy = aVar.h.copy()) == null) {
            return;
        }
        if (sAAllianceAdDataCopy.getMaterial() == null) {
            sAAllianceAdDataCopy.setMaterial(new Material(null));
        }
        sAAllianceAdDataCopy.getMaterial().setLdp(str);
        if (sAAllianceAdDataCopy.getInteraction() == null) {
            sAAllianceAdDataCopy.setInteraction(new Interaction(null));
        }
        sAAllianceAdDataCopy.setInteraction(aVar.h.getInteraction());
        Intent intent = new Intent(contextA, (Class<?>) SAAllianceWebViewActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("extra_name_land_page_ad_data", sAAllianceAdDataCopy);
        contextA.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(double d2) {
        this.Q0.setText((((int) d2) + 1) + " | 关闭");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, String str) {
        SAInterstitialAdInteractionListener sAInterstitialAdInteractionListener;
        synchronized (k.g) {
            try {
                k kVar = this.G0;
                if (kVar != null && (sAInterstitialAdInteractionListener = kVar.c) != null) {
                    if (i == 0) {
                        sAInterstitialAdInteractionListener.onAdShow();
                    } else if (i != 1) {
                        if (i == 2) {
                            sAInterstitialAdInteractionListener.onAdDismiss();
                        } else if (i == 3) {
                            sAInterstitialAdInteractionListener.onAdError(i2, str);
                        } else if (i == 4) {
                            sAInterstitialAdInteractionListener.onSkippedVideo();
                        }
                    } else if (this.N1 != 1) {
                        sAInterstitialAdInteractionListener.onAdClick();
                        x();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: NMInterstitialAdImpl.java */
    public class c implements j.b {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(int i) {
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(File file) {
            Bitmap bitmapDecodeFile;
            a.this.k1 = file.getAbsolutePath() + "/aaaccc" + this.a + PictureMimeType.GIF;
            a aVar = a.this;
            String str = aVar.k1;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int i3 = 1;
            while (true) {
                i /= 2;
                if (i < 100 || (i2 = i2 / 2) < 100) {
                    break;
                } else {
                    i3 *= 2;
                }
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i3;
            try {
                bitmapDecodeFile = BitmapFactory.decodeFile(str, options2);
            } catch (OutOfMemoryError e) {
                e.getMessage();
                int i4 = com.alliance.ssp.ad.o0.l.a;
                bitmapDecodeFile = null;
            }
            aVar.e1 = bitmapDecodeFile;
            a aVar2 = a.this;
            Bitmap bitmap = aVar2.e1;
            if (bitmap != null) {
                aVar2.B1 = bitmap.getWidth() > a.this.e1.getHeight();
            }
            a.this.s();
            a aVar3 = a.this;
            long jCurrentTimeMillis = System.currentTimeMillis();
            a aVar4 = a.this;
            aVar3.r1 = jCurrentTimeMillis - aVar4.r1;
            long j = aVar4.r1;
            int i5 = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(Exception exc) {
            exc.getMessage();
            int i = com.alliance.ssp.ad.o0.l.a;
            a.this.b(100006, "1", "加载gif素材失败");
        }
    }

    public static void a(final a aVar, SAAllianceAdData sAAllianceAdData, SAAllianceAdData sAAllianceAdData2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        aVar.getClass();
        try {
            if (sAAllianceAdData == null) {
                aVar.h = sAAllianceAdData2;
                aVar.I1 = aVar.w;
            } else if (sAAllianceAdData2 != null && sAAllianceAdData.getPriceD() <= sAAllianceAdData2.getPriceD()) {
                aVar.h = sAAllianceAdData2;
                aVar.I1 = aVar.w;
            } else {
                aVar.h = sAAllianceAdData;
                aVar.I1 = sAAllianceAdData.getRequestid();
                aVar.h.setParentCrequestid(sAAllianceAdData.getRequestid());
            }
            if (aVar.h.getInteraction() != null) {
                if (aVar.h.getInteraction().getShake() != null) {
                    aVar.v1 = true;
                    aVar.F1 = aVar.h.getInteraction().getShake();
                } else {
                    aVar.h.getInteraction().getSwipe();
                }
            }
            aVar.b1 = aVar.h.getDlConfig();
            aVar.h.setCrequestid(aVar.w);
            aVar.E.a(aVar.x1, aVar.I1);
            int i = com.alliance.ssp.ad.o0.l.a;
            aVar.h.setSpostype(Integer.parseInt(aVar.j0));
            aVar.N1 = aVar.h.getClickCallbackSwitch();
            String tagCode = aVar.h.getTagCode();
            if (tagCode != null && !tagCode.isEmpty()) {
                aVar.o = tagCode;
            }
            String price = aVar.h.getPrice();
            aVar.s = price;
            if (price == null || price.isEmpty()) {
                aVar.s = "-1";
            }
            if (aVar.h.getMaterial() == null) {
                aVar.a(8196, "001", "广告素材为空，请联系运营检查代码位ID配置情况。01");
                com.alliance.ssp.ad.t.i.a(aVar.w, aVar.x1, 8196, "广告素材为空，请联系运营检查代码位ID配置情况。01");
                return;
            }
            SAAllianceAdData sAAllianceAdData3 = aVar.h;
            if (sAAllianceAdData3 != null) {
                aVar.g1 = sAAllianceAdData3.getMaterial();
                int renderRatio = aVar.h.getRenderRatio();
                aVar.p1 = renderRatio;
                if (renderRatio != 0 && renderRatio != 1) {
                    aVar.p1 = 0;
                }
                aVar.l1 = "" + aVar.h.getRsize();
                int rdirection = aVar.h.getRdirection();
                aVar.q1 = rdirection;
                if (rdirection != 1 && rdirection != 2) {
                    aVar.q1 = 1;
                }
            }
            Material material = aVar.g1;
            if (material != null) {
                aVar.n1 = material.getLdptype();
            }
            SAAllianceAdData sAAllianceAdData4 = aVar.h;
            if (sAAllianceAdData4 != null && sAAllianceAdData4.getInteraction() != null) {
                int i2 = aVar.h.getInteraction().clickArea;
                aVar.w1 = i2;
                if (i2 == -1) {
                    aVar.w1 = 0;
                }
            }
            SAAllianceAdParams sAAllianceAdParams = aVar.g;
            if (sAAllianceAdParams != null && sAAllianceAdParams.getUserId() != null && !aVar.g.getUserId().isEmpty()) {
                aVar.h.setUserId(aVar.g.getUserId());
            }
            k kVar = new k(aVar.v, aVar.D0);
            aVar.G0 = kVar;
            kVar.a = aVar.s;
            String videourl = aVar.g1.getVideourl();
            aVar.m1 = videourl;
            if (videourl != null && !videourl.isEmpty()) {
                aVar.t1 = true;
                aVar.G0.b = new YTAdInfo(new ArrayList<String>() { // from class: com.alliance.ssp.ad.impl.interstitial.NMInterstitialAdImpl$3
                    {
                        add(this.this$0.m1);
                    }
                });
            } else {
                aVar.G0.b = new YTAdInfo(new ArrayList<String>() { // from class: com.alliance.ssp.ad.impl.interstitial.NMInterstitialAdImpl$4
                    {
                        add(this.this$0.g1.getAdm());
                    }
                });
            }
            aVar.a(aVar.G0);
            com.alliance.ssp.ad.t.i.a(aVar.w, aVar.x1);
            aVar.J1 = true;
            System.currentTimeMillis();
            aVar.K();
        } catch (Exception e) {
            e.toString();
            int i3 = com.alliance.ssp.ad.o0.l.a;
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMInterstitialAdImpl 002: ")), e);
            aVar.a(8194, "001", "渲染失败。");
            com.alliance.ssp.ad.t.i.a(aVar.w, aVar.x1, 8194, "渲染失败。");
        }
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void b(MediaPlayer mediaPlayer) {
        s();
        if (this.t1) {
            l("", "", this.h);
        }
        System.currentTimeMillis();
        int i = com.alliance.ssp.ad.o0.l.a;
        this.A1 = this.L1.b().getVideoWidth() >= this.L1.b().getVideoHeight();
    }

    /* compiled from: NMInterstitialAdImpl.java */
    public class b implements com.alliance.ssp.ad.p.a<SAAllianceEngineData> {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(SAAllianceEngineData sAAllianceEngineData) throws JSONException, PackageManager.NameNotFoundException, IOException {
            SAAllianceEngineData sAAllianceEngineData2 = sAAllianceEngineData;
            if (sAAllianceEngineData2 == null) {
                a.a(a.this, 8193, "002", "无广告填充，请联系技术进行排查。");
                return;
            }
            try {
                List<SAAllianceAdData> data = sAAllianceEngineData2.getData();
                if (data == null) {
                    a.a(a.this, sAAllianceEngineData2.getCode(), "001", sAAllianceEngineData2.getMessage());
                    return;
                }
                if (data.size() > 0 && sAAllianceEngineData2.getData() != null && !sAAllianceEngineData2.getData().isEmpty()) {
                    for (SAAllianceAdData sAAllianceAdData : data) {
                        sAAllianceAdData.setDeadlineTime(a.this.E.a(sAAllianceAdData.getCacheTimeout()));
                        sAAllianceAdData.setPriceD(a.this.E.a(sAAllianceAdData.getPrice()));
                        a aVar = a.this;
                        com.alliance.ssp.ad.t.h hVar = aVar.E;
                        if (hVar != null) {
                            hVar.a(this.a, aVar.x1, sAAllianceAdData.getWaitLoadTimeout());
                            if (sAAllianceAdData.isNeedCache()) {
                                sAAllianceAdData.setRequestid(a.this.w);
                                a aVar2 = a.this;
                                aVar2.E.a(this.a, sAAllianceAdData, aVar2.x1);
                            }
                        }
                        a aVar3 = a.this;
                        if (!aVar3.J1) {
                            Handler handler = aVar3.D1;
                            if (handler != null) {
                                handler.removeCallbacksAndMessages(null);
                                a.this.D1 = null;
                            }
                            a aVar4 = a.this;
                            a.a(aVar4, aVar4.H1, sAAllianceAdData);
                        }
                    }
                    return;
                }
                a.a(a.this, sAAllianceEngineData2.getCode(), "003", sAAllianceEngineData2.getMessage());
            } catch (Exception e) {
                e.toString();
                int i = com.alliance.ssp.ad.o0.l.a;
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMInterstitialAdImpl 001: ")), e);
                a.this.a(8194, "001", "渲染失败。");
                a aVar5 = a.this;
                com.alliance.ssp.ad.t.i.a(aVar5.w, aVar5.x1, 8194, "渲染失败。");
            }
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            a.a(a.this, i, "004", str);
        }
    }

    public final void a(SAAllianceAdParams sAAllianceAdParams) {
        int i = com.alliance.ssp.ad.o0.l.a;
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        SAAllianceAdData sAAllianceAdDataA = a(contextA, this.x1);
        this.H1 = sAAllianceAdDataA;
        if (sAAllianceAdDataA != null) {
            long jA = this.E.a(contextA, this.x1);
            com.alliance.ssp.ad.w.g gVar = new com.alliance.ssp.ad.w.g(this, Looper.getMainLooper());
            this.D1 = gVar;
            gVar.sendEmptyMessageDelayed(0, jA);
        }
        this.r1 = System.currentTimeMillis();
        sAAllianceAdParams.setImageAcceptedWidth(SAAllianceAdParams.Screen_Width);
        sAAllianceAdParams.setImageAcceptedHeight(SAAllianceAdParams.Screen_Height);
        this.K1 = sAAllianceAdParams.getMute();
        sAAllianceAdParams.setSpostype(5);
        com.alliance.ssp.ad.http.action.b bVar = new com.alliance.ssp.ad.http.action.b(sAAllianceAdParams, this.w, this.C0, 0, new b(contextA), BaseNetAction.Method.POST);
        com.alliance.ssp.ad.t.i.a(this.w, this.x1, null, "0", "插屏");
        bVar.a();
    }

    public final void a(View view) {
        if (this.Q0 == null) {
            int i = com.alliance.ssp.ad.o0.l.a;
            return;
        }
        final View viewFindViewById = view.findViewById(R.id.express_show_view);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        this.Q0.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                this.f$0.a(viewFindViewById, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, View view2) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.A <= 0.0f && b()) {
            if (this.w1 == 1) {
                a(this.R0, (String) null);
            } else {
                a(view, (String) null);
            }
            if (a("close_button", 0, false)) {
                this.B = true;
                c(2);
                if (this.n1 != 1) {
                    E();
                    return;
                }
                return;
            }
        }
        E();
        N();
        Activity activityB = com.alliance.ssp.ad.o0.b.b();
        Dialog dialog = this.d1;
        if (dialog != null && dialog.isShowing() && activityB != null && !activityB.isFinishing()) {
            this.d1.dismiss();
        }
        if (activityB != null) {
            activityB.setRequestedOrientation(this.j1);
        }
        a(2, 0, (String) null);
        p();
    }

    public final void a(Context context) {
        try {
            com.alliance.ssp.ad.l.c cVar = new com.alliance.ssp.ad.l.c(context, 1, this.l1.equals("2") ? 108 : 128, this.F1, new c.b() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda6
                @Override // com.alliance.ssp.ad.l.c.b
                public final void a(int[] iArr) {
                    this.f$0.a(iArr);
                }
            });
            this.E1 = cVar;
            this.I0.addView(cVar.h);
            this.I0.setVisibility(0);
            this.M1 = this.F1.getResetSensitivity();
        } catch (Exception e) {
            e.getMessage();
            int i = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int[] iArr) {
        if (this.q) {
            return;
        }
        int i = com.alliance.ssp.ad.o0.l.a;
        this.q = true;
        this.C = iArr;
        if (a("shake", 0, false)) {
            return;
        }
        this.q = false;
    }

    public final void a(Window window, Activity activity, String str) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        window.getDecorView().setPadding(0, 0, 0, 0);
        if (str.equals("1")) {
            window.setBackgroundDrawable(new ColorDrawable(-16777216));
        } else if (str.equals("2")) {
            window.setBackgroundDrawable(new ColorDrawable(805306368));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28 && this.q1 == 2) {
            window.getAttributes().layoutInDisplayCutoutMode = 1;
            window.addFlags(67108864);
            window.getDecorView().setSystemUiVisibility(6);
        }
        window.setFlags(1024, 1024);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        if (str.equals("1")) {
            if (this.q1 == 1) {
                this.z1 = 52;
                this.Q1 = 28;
                this.T = com.alliance.ssp.ad.a.f.a("", i);
                this.U = com.alliance.ssp.ad.a.f.a("", i2);
            } else {
                this.z1 = 240;
                this.Q1 = 32;
                this.T = com.alliance.ssp.ad.a.f.a("", i2);
                this.U = com.alliance.ssp.ad.a.f.a("", i);
            }
        } else if (str.equals("2")) {
            if (this.q1 == 1) {
                if (this.p1 == 0) {
                    this.z1 = 52;
                    this.Q1 = 28;
                    this.T = com.alliance.ssp.ad.a.b.a("").append(h.b(activity, 270.0f)).toString();
                    this.U = com.alliance.ssp.ad.a.b.a("").append(h.b(activity, 560.0f)).toString();
                } else {
                    this.z1 = 240;
                    this.Q1 = 32;
                    this.T = com.alliance.ssp.ad.a.b.a("").append(h.b(activity, 252.0f)).toString();
                    this.U = com.alliance.ssp.ad.a.b.a("").append(h.b(activity, 387.0f)).toString();
                }
            } else if (this.p1 == 0) {
                this.z1 = 240;
                this.Q1 = 32;
                this.T = com.alliance.ssp.ad.a.b.a("").append(h.b(activity, 608.0f)).toString();
                this.U = com.alliance.ssp.ad.a.b.a("").append(h.b(activity, 320.0f)).toString();
            } else {
                this.z1 = 240;
                this.Q1 = 32;
                this.T = com.alliance.ssp.ad.a.b.a("").append(h.b(activity, 608.0f)).toString();
                this.U = com.alliance.ssp.ad.a.b.a("").append(h.b(activity, 320.0f)).toString();
            }
        }
        this.R0.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0088a(activity));
        this.e0 = "100";
        window.setContentView(this.F0);
        if (i3 < 21 || this.c1 == -1) {
            return;
        }
        this.W0.setOutlineProvider(new com.alliance.ssp.ad.w.l(h.b(activity, 8.0f), this.c1));
        this.W0.setClipToOutline(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r10, int r11, boolean r12) throws java.lang.IllegalStateException, org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException, java.security.NoSuchAlgorithmException, java.io.IOException, java.security.InvalidKeyException {
        /*
            r9 = this;
            r9.x = r10
            r0 = 0
            r1 = 1
            if (r11 != r1) goto L8
            r11 = r1
            goto L9
        L8:
            r11 = r0
        L9:
            r9.D = r11
            java.lang.String r2 = "unuser"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L1c
            java.lang.String r2 = "close_button"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L21
        L1c:
            int r10 = r9.w1
            if (r10 != r1) goto L21
            r11 = r1
        L21:
            int r10 = r9.n1
            r2 = 0
            if (r10 != r1) goto L97
            int r10 = r9.r
            if (r10 == 0) goto L67
            if (r10 == r1) goto L53
            r12 = 2
            if (r10 == r12) goto L33
            r12 = 3
            if (r10 == r12) goto L53
            goto L93
        L33:
            int r10 = r9.w1
            if (r10 != 0) goto L49
            r9.c()
            r9.w()
            com.alliance.ssp.ad.bean.SAAllianceAdData r10 = r9.h
            java.lang.String r11 = ""
            r9.a(r11, r11, r10)
            r9.a(r1, r0, r2)
            r0 = r1
            goto L93
        L49:
            boolean r0 = r9.L()
            if (r0 == 0) goto L93
            r9.E()
            goto L93
        L53:
            int r10 = r9.b1
            if (r10 == 0) goto L5d
            int r10 = r9.w1
            if (r10 != r1) goto L93
            if (r11 != 0) goto L93
        L5d:
            boolean r0 = r9.L()
            if (r0 == 0) goto L93
            r9.E()
            goto L93
        L67:
            int r10 = r9.b1
            int r3 = com.alliance.ssp.ad.o0.l.a
            if (r12 != 0) goto L7f
            if (r10 == 0) goto L75
            int r10 = r9.w1
            if (r10 != r1) goto L7f
            if (r11 != 0) goto L7f
        L75:
            boolean r0 = r9.L()
            if (r0 == 0) goto L93
            r9.E()
            goto L93
        L7f:
            com.alliance.ssp.ad.bean.Material r4 = r9.g1
            com.alliance.ssp.ad.bean.SAAllianceAdData r5 = r9.h
            r6 = 0
            r7 = 0
            r8 = 0
            r3 = r9
            boolean r10 = r3.a(r4, r5, r6, r7, r8)
            if (r10 == 0) goto L92
            r9.u = r1
            r9.a(r1, r0, r2)
        L92:
            r0 = r10
        L93:
            r9.a(r0)
            return r0
        L97:
            com.alliance.ssp.ad.bean.Material r10 = r9.g1
            com.alliance.ssp.ad.bean.SAAllianceAdData r11 = r9.h
            boolean r10 = r9.a(r10, r11, r0)
            if (r10 == 0) goto Lab
            r9.u = r1
            if (r10 == 0) goto Lab
            r9.a(r1, r0, r2)
            r9.M()
        Lab:
            r9.a(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.impl.interstitial.a.a(java.lang.String, int, boolean):boolean");
    }

    public final void a(boolean z) {
        com.alliance.ssp.ad.l.c cVar;
        if (z && (cVar = this.E1) != null && this.M1 == 1) {
            cVar.a(50.0d, 35.0d, 2000.0d);
            SAAllianceAdData sAAllianceAdData = this.h;
            if (sAAllianceAdData == null || sAAllianceAdData.getInteraction() == null || !this.v1) {
                return;
            }
            this.h.getInteraction().getShake().setAcceleration(50.0d);
            this.h.getInteraction().getShake().setRotationAngle(35.0d);
            this.h.getInteraction().getShake().setOperationTime(2.0d);
        }
    }

    public final void a(Context context, View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i;
        int i2;
        if (view == null) {
            return;
        }
        this.z1 = 52;
        if (this.q1 == 2 || (this.p1 == 1 && this.l1.equals("2"))) {
            this.z1 = 240;
            i = 3;
        } else {
            i = 4;
        }
        if (this.n1 == 1) {
            i2 = this.a1 ? 4 : 1;
        } else {
            i2 = 5;
        }
        try {
            this.F = new com.alliance.ssp.ad.l.a(context, this.z1, i, i2, new a.c() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda7
                @Override // com.alliance.ssp.ad.l.a.c
                public final void a(int i3, boolean z) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
                    this.f$0.a(i3, z);
                }
            });
            FrameLayout frameLayout = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 16;
            frameLayout.setLayoutParams(layoutParams);
            ((LinearLayout) view).addView(frameLayout);
            FrameLayout frameLayout2 = this.F.o;
            if (frameLayout2 != null) {
                frameLayout.addView(frameLayout2);
            }
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 014: ")), e);
        }
        this.G1 = this.F.n;
        this.q0 = new e(this, Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, boolean z) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        if (i == 1) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            a("user", 1, z);
            return;
        }
        if (i == 2) {
            int i3 = com.alliance.ssp.ad.o0.l.a;
            D();
            a("", "", this.h);
            this.F.a(true);
            this.r = 3;
            return;
        }
        if (i == 3) {
            int i4 = com.alliance.ssp.ad.o0.l.a;
            C();
            a("", "", this.h);
            this.r = 1;
            this.F.a(false);
            return;
        }
        if (i != 4) {
            if (i != 5) {
                return;
            }
            int i5 = com.alliance.ssp.ad.o0.l.a;
            a("user", 1, z);
            return;
        }
        int i6 = com.alliance.ssp.ad.o0.l.a;
        c();
        w();
        a("", "", this.h);
        a(1, 0, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Intent intent) {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("SA_TARGET_YT_WEB_ACTIVITY_FINISHED")) {
            return;
        }
        F();
        this.R1.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final double d2, final double d3) throws JSONException, PackageManager.NameNotFoundException, IOException {
        com.alliance.ssp.ad.l.c cVar;
        try {
            if (this.i1 > 0.0f && this.Q0 != null) {
                n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(d3);
                    }
                });
            }
            if (!this.S1 && d2 > 0.0d && (cVar = this.E1) != null) {
                this.S1 = true;
                cVar.b();
            }
            n nVar = n.d;
            nVar.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c(d2);
                }
            });
            float f = this.i1;
            if (f > 0.0f && d2 >= f) {
                int i = com.alliance.ssp.ad.o0.l.a;
                if (this.G0 != null) {
                    a(2, 0, (String) null);
                    this.p0 = true;
                    Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
                    if (contextA != null) {
                        if (contextA instanceof Activity) {
                            ((Activity) contextA).setRequestedOrientation(this.j1);
                        } else {
                            Activity activityB = com.alliance.ssp.ad.o0.b.b();
                            if (activityB != null) {
                                activityB.setRequestedOrientation(this.j1);
                            }
                        }
                    }
                    nVar.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                            this.f$0.I();
                        }
                    });
                    nVar.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(d2);
                        }
                    });
                    N();
                    p();
                    return;
                }
                return;
            }
            float f2 = this.A;
            if (f2 > 0.0f && ((float) d2) == f2 && b()) {
                nVar.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.interstitial.a$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(view);
                    }
                });
                if (a("unuser", 0, false)) {
                    this.B = true;
                    c(1);
                    VideoController videoController = this.L1;
                    if (videoController == null || this.u1 || this.n1 == 1 || !videoController.f()) {
                        return;
                    }
                    k("", "", this.h);
                }
            }
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMInterstitialAdImpl 009: ")), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(double d2) {
        FrameLayout frameLayout;
        if (d2 < 3.0d || (frameLayout = this.I0) == null || this.S0 == null || this.q1 != 1 || !this.v1) {
            return;
        }
        frameLayout.setVisibility(8);
        this.S0.setVisibility(0);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a() {
        b(this.h);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a(int i) {
        if (i >= 25 && !this.T1) {
            this.T1 = true;
            g("", "", this.h);
        }
        if (i >= 50 && !this.U1) {
            this.U1 = true;
            y();
            i("", "", this.h);
        }
        if (i < 75 || this.V1) {
            return;
        }
        this.V1 = true;
        n("", "", this.h);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a(MediaPlayer mediaPlayer) {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (!this.s1) {
            this.s1 = true;
            p("", "", this.h);
        }
        this.u1 = true;
    }
}
