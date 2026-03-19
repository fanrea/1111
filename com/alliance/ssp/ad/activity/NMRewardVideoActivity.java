package com.alliance.ssp.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.a.g;
import com.alliance.ssp.ad.a.h;
import com.alliance.ssp.ad.a.i;
import com.alliance.ssp.ad.a.j;
import com.alliance.ssp.ad.bean.Interaction;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.RewardInfo;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.Shake;
import com.alliance.ssp.ad.d0.f;
import com.alliance.ssp.ad.l.a;
import com.alliance.ssp.ad.l.c;
import com.alliance.ssp.ad.l.d;
import com.alliance.ssp.ad.l.l;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.o0.q;
import com.alliance.ssp.ad.template.SAAllianceContainerView;
import com.alliance.ssp.ad.video.VideoController;
import com.alliance.ssp.ad.video.e;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class NMRewardVideoActivity extends Activity {
    public static com.alliance.ssp.ad.impl.reward.a v0;
    public SAAllianceAdData I;
    public Material J;

    /* renamed from: K, reason: collision with root package name */
    public String f714K;
    public c L;
    public Shake M;
    public int N;
    public boolean O;
    public int P;
    public com.alliance.ssp.ad.l.a Q;
    public Bitmap R;
    public long S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public boolean Y;
    public boolean Z;
    public boolean a0;
    public com.alliance.ssp.ad.q0.c b;
    public boolean b0;
    public FrameLayout c;
    public boolean c0;
    public VideoController d;
    public int d0;
    public View e;
    public boolean e0;
    public int f0;
    public ImageView g0;
    public ImageView h0;
    public ImageView i0;
    public View.OnAttachStateChangeListener j0;
    public View.OnClickListener k0;
    public View.OnClickListener l0;
    public View.OnClickListener m0;
    public View.OnClickListener n0;
    public View.OnClickListener o0;
    public a.b p0;
    public FrameLayout q0;
    public int r0;
    public boolean s0;
    public boolean t0;
    public int u0;
    public Activity a = null;
    public FrameLayout f = null;
    public LinearLayout g = null;
    public LinearLayout h = null;
    public LinearLayout i = null;
    public LinearLayout j = null;
    public LinearLayout k = null;
    public LinearLayout l = null;
    public LinearLayout m = null;
    public FrameLayout n = null;
    public FrameLayout o = null;
    public FrameLayout p = null;
    public FrameLayout q = null;
    public FrameLayout r = null;
    public FrameLayout s = null;
    public TextView t = null;
    public TextView u = null;
    public TextView v = null;
    public TextView w = null;
    public TextView x = null;
    public TextView y = null;
    public TextView z = null;
    public TextView A = null;
    public ImageView B = null;
    public ImageView C = null;
    public ImageView D = null;
    public ImageView E = null;
    public LinearLayout F = null;
    public LinearLayout G = null;
    public LinearLayout H = null;

    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
            int i = l.a;
            NMRewardVideoActivity nMRewardVideoActivity = NMRewardVideoActivity.this;
            com.alliance.ssp.ad.impl.reward.a aVar = NMRewardVideoActivity.v0;
            nMRewardVideoActivity.getClass();
            FrameLayout frameLayout = (FrameLayout) nMRewardVideoActivity.findViewById(R.id.fl_nm_reward_video_view);
            nMRewardVideoActivity.c = frameLayout;
            if (frameLayout != null || nMRewardVideoActivity.d != null) {
                if (NMRewardVideoActivity.v0 != null) {
                    Map<String, VideoController> map = com.alliance.ssp.ad.impl.reward.a.g1;
                }
                FrameLayout frameLayout2 = nMRewardVideoActivity.n;
                VideoController videoController = nMRewardVideoActivity.d;
                frameLayout2.addView(videoController.r.a(new com.alliance.ssp.ad.video.b(videoController, new i(nMRewardVideoActivity))));
                nMRewardVideoActivity.c.addView(NMRewardVideoActivity.v0.V0.t);
                TextView textView = nMRewardVideoActivity.t;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                LinearLayout linearLayout = nMRewardVideoActivity.g;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            }
            NMRewardVideoActivity.this.g0.setBackground(null);
            NMRewardVideoActivity.this.i0.setBackground(null);
            NMRewardVideoActivity.this.h0.setBackground(null);
            NMRewardVideoActivity nMRewardVideoActivity2 = NMRewardVideoActivity.this;
            if (nMRewardVideoActivity2.g0 != null) {
                if (nMRewardVideoActivity2.J.getIconurl() == null || NMRewardVideoActivity.this.J.getIconurl().isEmpty()) {
                    NMRewardVideoActivity nMRewardVideoActivity3 = NMRewardVideoActivity.this;
                    if (nMRewardVideoActivity3.T != 1) {
                        nMRewardVideoActivity3.g0.setImageResource(R.drawable.nmadssp_h5_icon_default);
                        NMRewardVideoActivity.this.h0.setImageResource(R.drawable.nmadssp_h5_icon_default);
                        NMRewardVideoActivity.this.i0.setImageResource(R.drawable.nmadssp_h5_icon_default);
                    } else {
                        nMRewardVideoActivity3.g0.setImageResource(R.drawable.nmadssp_app_icon_default);
                        NMRewardVideoActivity.this.h0.setImageResource(R.drawable.nmadssp_app_icon_default);
                        NMRewardVideoActivity.this.i0.setImageResource(R.drawable.nmadssp_app_icon_default);
                    }
                } else {
                    NMRewardVideoActivity nMRewardVideoActivity4 = NMRewardVideoActivity.this;
                    com.alliance.ssp.ad.r.i.a().a(nMRewardVideoActivity4.J.getIconurl(), new h(nMRewardVideoActivity4));
                }
            }
            if (NMRewardVideoActivity.this.J.getTitle() == null || NMRewardVideoActivity.this.J.getTitle().isEmpty()) {
                NMRewardVideoActivity nMRewardVideoActivity5 = NMRewardVideoActivity.this;
                if (nMRewardVideoActivity5.T != 1) {
                    nMRewardVideoActivity5.v.setText("查看网页");
                    NMRewardVideoActivity.this.x.setText("查看网页");
                    NMRewardVideoActivity.this.w.setText("查看网页");
                } else {
                    nMRewardVideoActivity5.v.setText("Android应用");
                    NMRewardVideoActivity.this.x.setText("Android应用");
                    NMRewardVideoActivity.this.w.setText("Android应用");
                }
            } else {
                NMRewardVideoActivity nMRewardVideoActivity6 = NMRewardVideoActivity.this;
                nMRewardVideoActivity6.v.setText(com.alliance.ssp.ad.n0.c.a(nMRewardVideoActivity6.J.getTitle(), 7));
                NMRewardVideoActivity nMRewardVideoActivity7 = NMRewardVideoActivity.this;
                nMRewardVideoActivity7.x.setText(com.alliance.ssp.ad.n0.c.a(nMRewardVideoActivity7.J.getTitle(), 7));
                NMRewardVideoActivity nMRewardVideoActivity8 = NMRewardVideoActivity.this;
                nMRewardVideoActivity8.w.setText(com.alliance.ssp.ad.n0.c.a(nMRewardVideoActivity8.J.getTitle(), 7));
            }
            com.alliance.ssp.ad.impl.reward.a aVar2 = NMRewardVideoActivity.v0;
            if (aVar2 != null) {
                NMRewardVideoActivity nMRewardVideoActivity9 = NMRewardVideoActivity.this;
                if (nMRewardVideoActivity9.c == null) {
                    aVar2.b(nMRewardVideoActivity9.a);
                    NMRewardVideoActivity.this.n();
                    com.alliance.ssp.ad.impl.reward.a aVar3 = NMRewardVideoActivity.v0;
                    if (aVar3 != null) {
                        aVar3.a(NMRewardVideoActivity.this.a);
                        return;
                    }
                    return;
                }
                if (nMRewardVideoActivity9.d != null) {
                    aVar2.a(0, (RewardInfo) null);
                    SharedPreferences sharedPreferences = q.a().a;
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.clear();
                        editorEdit.commit();
                    }
                    aVar2.X = "0";
                    aVar2.Y = "0";
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    aVar2.G = "" + jCurrentTimeMillis;
                    aVar2.H = String.valueOf((int) (jCurrentTimeMillis / 1000));
                    aVar2.B();
                    aVar2.t("", "", aVar2.h);
                    Context contextA = com.alliance.ssp.ad.o0.b.a(aVar2.f);
                    VideoController videoController2 = aVar2.V0;
                    if (videoController2 != null) {
                        videoController2.i();
                    }
                    com.alliance.ssp.ad.l.l lVar = aVar2.a1;
                    if (lVar != null) {
                        lVar.c();
                    }
                    com.alliance.ssp.ad.t.h hVar = aVar2.E;
                    if (hVar != null) {
                        hVar.a(contextA, aVar2.T0, aVar2.Y0);
                    }
                    NMRewardVideoActivity.this.d.c();
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            int i = l.a;
        }
    }

    public class b implements VideoController.h {
        public b(NMRewardVideoActivity nMRewardVideoActivity) {
        }

        @Override // com.alliance.ssp.ad.video.VideoController.h
        public void a(boolean z) {
            com.alliance.ssp.ad.impl.reward.a aVar = NMRewardVideoActivity.v0;
            if (aVar != null) {
                if (z) {
                    aVar.o("", "", aVar.h);
                } else {
                    aVar.j("", "", aVar.h);
                }
            }
        }
    }

    public NMRewardVideoActivity() {
        new AtomicInteger(0);
        this.I = null;
        this.N = 0;
        this.O = false;
        this.P = 0;
        this.Q = null;
        this.U = 0;
        this.V = 1;
        this.Y = false;
        this.Z = false;
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = 0;
        this.e0 = false;
        this.f0 = 0;
        this.p0 = null;
        this.s0 = false;
        this.t0 = false;
        this.u0 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final double d, final double d2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        c cVar;
        try {
            n nVar = n.d;
            nVar.c.post(new Runnable() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(d2);
                }
            });
            if (!this.s0 && d > 0.0d && (cVar = this.L) != null) {
                this.s0 = true;
                cVar.b();
            }
            nVar.c.post(new Runnable() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(d);
                }
            });
            if ((d >= this.S || d2 <= 0.0d) && !this.Y) {
                this.Y = true;
                com.alliance.ssp.ad.impl.reward.a aVar = v0;
                if (aVar != null) {
                    aVar.F();
                }
            }
            if (d >= this.r0 || d2 <= 0.0d) {
                this.Z = true;
                nVar.c.post(new Runnable() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, IOException {
                        this.f$0.i();
                    }
                });
                c();
            }
            com.alliance.ssp.ad.impl.reward.a aVar2 = v0;
            if (aVar2 != null) {
                float f = aVar2.A;
                if (f > 0.0f && ((float) d) == f && aVar2.b()) {
                    nVar.c.post(new Runnable() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda9
                        @Override // java.lang.Runnable
                        public final void run() throws IllegalStateException {
                            this.f$0.h();
                        }
                    });
                }
            }
        } catch (Exception e) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMRewardVideoActivity 009: ")), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, IOException {
        int i = l.a;
        com.alliance.ssp.ad.impl.reward.a aVar = v0;
        if (aVar != null) {
            if (aVar.A <= 0.0f && aVar.b()) {
                if (this.N == 1) {
                    v0.a(this.F, "1");
                } else {
                    v0.a(this.e, (String) null);
                }
                if (a("close_button", 0, false)) {
                    com.alliance.ssp.ad.impl.reward.a aVar2 = v0;
                    aVar2.B = true;
                    aVar2.c(2);
                    if (this.T != 1) {
                        a();
                        return;
                    }
                    return;
                }
            }
            com.alliance.ssp.ad.q0.c cVar = new com.alliance.ssp.ad.q0.c(this);
            this.b = cVar;
            cVar.setCanceledOnTouchOutside(false);
            this.b.i = getResources().getString(R.string.nm_reward_video_close_tip);
            com.alliance.ssp.ad.q0.c cVar2 = this.b;
            int i2 = R.string.nm_abandon;
            View.OnClickListener onClickListener = this.m0;
            cVar2.e = cVar2.getContext().getString(i2);
            cVar2.g = onClickListener;
            com.alliance.ssp.ad.q0.c cVar3 = this.b;
            int i3 = R.string.nm_continue;
            View.OnClickListener onClickListener2 = this.n0;
            cVar3.d = cVar3.getContext().getString(i3);
            cVar3.f = onClickListener2;
            try {
                if (isFinishing() || this.b.isShowing() || this.c0) {
                    return;
                }
                this.b.show();
                a();
            } catch (Exception e) {
                new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMRewardVideoActivity 011: ")), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, IOException {
        com.alliance.ssp.ad.r.f fVar;
        int i = l.a;
        com.alliance.ssp.ad.impl.reward.a aVar = v0;
        if (aVar != null && aVar.A <= 0.0f && aVar.b()) {
            if (this.N == 1) {
                v0.a(this.F, "1");
            } else {
                v0.a(this.e, (String) null);
            }
            if (a("close_button", 0, false)) {
                com.alliance.ssp.ad.impl.reward.a aVar2 = v0;
                aVar2.B = true;
                aVar2.c(2);
                if (this.T != 1) {
                    a();
                    return;
                }
                return;
            }
        }
        n();
        try {
            com.alliance.ssp.ad.impl.reward.a aVar3 = v0;
            if (aVar3 != null && (fVar = aVar3.x0) != null && this.U == 1) {
                fVar.a(aVar3.y0.b);
            }
        } catch (Exception e) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMRewardVideoActivity 001: ")), e);
        }
        com.alliance.ssp.ad.impl.reward.a aVar4 = v0;
        if (aVar4 != null) {
            aVar4.a(this.a);
            v0.p();
            v0.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        try {
            if (this.t.getVisibility() != 0) {
                return;
            }
            int i = l.a;
            TextView textView = this.u;
            if (textView != null) {
                textView.setOnClickListener(this.o0);
            }
            TextView textView2 = this.t;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            LinearLayout linearLayout = this.g;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } catch (Exception e) {
            e.getMessage();
            int i2 = l.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() throws IllegalStateException {
        com.alliance.ssp.ad.impl.reward.a aVar = v0;
        if (aVar.S0 == 1) {
            aVar.a(this.F, "1");
        } else {
            aVar.a(this.e, (String) null);
        }
        if (a("unuser", 0, false)) {
            com.alliance.ssp.ad.impl.reward.a aVar2 = v0;
            aVar2.B = true;
            aVar2.c(1);
            VideoController videoController = this.d;
            if (videoController == null || this.T == 1) {
                return;
            }
            boolean zF = videoController.f();
            com.alliance.ssp.ad.impl.reward.a aVar3 = v0;
            if (aVar3 == null || !zF) {
                return;
            }
            aVar3.k("", "", aVar3.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [android.media.MediaMetadataRetriever] */
    /* JADX WARN: Type inference failed for: r1v21, types: [android.widget.ImageView] */
    public void i() throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, IOException {
        Material material;
        Bitmap frameAtTime;
        e eVar;
        int i = this.V;
        if (i == 1) {
            this.d.j();
            this.n.setVisibility(8);
            try {
                FrameLayout frameLayout = this.Q.v;
                if (frameLayout != null) {
                    if (frameLayout.getParent() != null) {
                        return;
                    } else {
                        this.H.addView(frameLayout);
                    }
                }
                FrameLayout frameLayout2 = this.r;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(8);
                }
                LinearLayout linearLayout = this.i;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                LinearLayout linearLayout2 = this.h;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                FrameLayout frameLayout3 = this.f;
                if (frameLayout3 != null) {
                    frameLayout3.setVisibility(0);
                }
                TextView textView = this.w;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                FrameLayout frameLayout4 = this.s;
                if (frameLayout4 != null) {
                    frameLayout4.setVisibility(0);
                }
                FrameLayout frameLayout5 = this.p;
                if (frameLayout5 == null || !this.a0) {
                    if (this.a0) {
                        return;
                    }
                    this.l.setVisibility(8);
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) frameLayout5.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.p);
                }
                LinearLayout linearLayout3 = this.l;
                if (linearLayout3 != null) {
                    linearLayout3.addView(this.p);
                }
                this.p.setVisibility(0);
                return;
            } catch (Exception e) {
                new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl createVerticalFinishView: ")), e);
                return;
            }
        }
        if (i == 2) {
            boolean z = this.d.f;
            this.n.removeAllViews();
            FrameLayout frameLayout6 = this.o;
            VideoController videoController = this.d;
            frameLayout6.addView(videoController.r.a(new com.alliance.ssp.ad.video.b(videoController, new b(this))));
            VideoController videoController2 = this.d;
            if (videoController2.w != null && (eVar = videoController2.r) != null) {
                if (z) {
                    eVar.a(2);
                } else {
                    eVar.a(1);
                }
            }
            VideoController videoController3 = this.d;
            videoController3.D = true;
            if (!this.b0) {
                float f = this.X * 0.5f;
                videoController3.a((int) f, (int) ((f * 9.0f) / 16.0f));
            }
            this.n.setVisibility(8);
            this.o.setVisibility(0);
            try {
                FrameLayout frameLayout7 = this.Q.v;
                if (frameLayout7 != null) {
                    if (frameLayout7.getParent() != null) {
                        return;
                    } else {
                        this.G.addView(frameLayout7);
                    }
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.r.getLayoutParams();
                layoutParams.width = (int) (this.X * 0.5f);
                this.r.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.width = (int) (this.X * 0.5f);
                this.m.setLayoutParams(layoutParams2);
                if (this.g != null) {
                    int iB = com.alliance.ssp.ad.o0.h.b(this, 20.0f);
                    int iB2 = com.alliance.ssp.ad.o0.h.b(this, 20.0f);
                    ((FrameLayout.LayoutParams) this.g.getLayoutParams()).setMargins(0, iB, iB2, 0);
                    ((FrameLayout.LayoutParams) this.t.getLayoutParams()).setMargins(iB2, iB, 0, 0);
                }
                ImageView imageView = this.B;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                LinearLayout linearLayout4 = this.i;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                LinearLayout linearLayout5 = this.h;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                }
                LinearLayout linearLayout6 = this.j;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
                FrameLayout frameLayout8 = this.s;
                if (frameLayout8 != null) {
                    frameLayout8.setVisibility(0);
                }
                ImageView imageView2 = this.C;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                if (this.d != null && this.b0 && (material = this.J) != null) {
                    String videourl = material.getVideourl();
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(videourl);
                            frameAtTime = mediaMetadataRetriever.getFrameAtTime((Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000) - 1000, 3);
                        } catch (RuntimeException e2) {
                            e2.printStackTrace();
                            mediaMetadataRetriever.release();
                            frameAtTime = null;
                        }
                        mediaMetadataRetriever = this.D;
                        if (mediaMetadataRetriever != 0) {
                            mediaMetadataRetriever.setImageBitmap(frameAtTime);
                        }
                        ImageView imageView3 = this.E;
                        if (imageView3 != null) {
                            imageView3.setVisibility(8);
                        }
                    } finally {
                        mediaMetadataRetriever.release();
                    }
                }
                TextView textView2 = this.x;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                if (this.e != null) {
                    LinearLayout linearLayout7 = this.k;
                    if (linearLayout7 == null || !this.a0) {
                        if (this.a0) {
                            return;
                        }
                        this.l.setVisibility(8);
                    } else {
                        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) linearLayout7.getLayoutParams();
                        layoutParams3.width = (int) (this.X * 0.5f);
                        this.k.setLayoutParams(layoutParams3);
                        this.p.setVisibility(0);
                    }
                }
            } catch (Exception e3) {
                new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e3, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl createHorizontalFinishView: ")), e3);
            }
        }
    }

    public final void c() {
        n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.g();
            }
        });
    }

    public final void d() {
        this.j0 = new a();
        this.k0 = new View.OnClickListener() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
                this.f$0.a(view);
            }
        };
        this.l0 = new View.OnClickListener() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.b(view);
            }
        };
        this.m0 = new View.OnClickListener() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.c(view);
            }
        };
        this.n0 = new View.OnClickListener() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.d(view);
            }
        };
        this.o0 = new View.OnClickListener() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.e(view);
            }
        };
    }

    public final boolean f() throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i = l.a;
        try {
            String videourl = this.J.getVideourl();
            this.f714K = videourl;
            VideoController videoController = (VideoController) ((HashMap) com.alliance.ssp.ad.impl.reward.a.g1).get(videourl);
            this.d = videoController;
            if (videoController != null) {
                return true;
            }
            com.alliance.ssp.ad.impl.reward.a aVar = v0;
            if (aVar != null) {
                aVar.b(this);
            }
            return false;
        } catch (Exception e) {
            e.toString();
            int i2 = l.a;
            com.alliance.ssp.ad.impl.reward.a aVar2 = v0;
            if (aVar2 != null) {
                aVar2.b(this);
            }
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMRewardVideoActivity 007: ")), e);
            return false;
        }
    }

    public final View k() throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i = l.a;
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_nmssp_ad_reward, (ViewGroup) null, false);
        if (viewInflate == null || this.J == null || TextUtils.isEmpty(this.f714K)) {
            return null;
        }
        this.v = (TextView) viewInflate.findViewById(R.id.tv_nm_reward_video_appname);
        this.x = (TextView) viewInflate.findViewById(R.id.tv_nm_reward_video_appname_ending_landscape);
        this.w = (TextView) viewInflate.findViewById(R.id.tv_nm_reward_video_appname_ending_protrait);
        this.h = (LinearLayout) viewInflate.findViewById(R.id.ll_nm_reward_video_bottom_shake);
        this.i = (LinearLayout) viewInflate.findViewById(R.id.ll_nm_reward_video_bottom_bar);
        this.f = (FrameLayout) viewInflate.findViewById(R.id.fl_nm_reward_video_ending);
        this.k = (LinearLayout) viewInflate.findViewById(R.id.ll_nm_reward_video_shake_container);
        SAAllianceContainerView sAAllianceContainerView = (SAAllianceContainerView) viewInflate.findViewById(R.id.sa_alliance_container_view);
        if (sAAllianceContainerView != null) {
            sAAllianceContainerView.setImpl(v0);
        }
        this.t = (TextView) viewInflate.findViewById(R.id.tv_nm_reward_video_count_down);
        this.n = (FrameLayout) viewInflate.findViewById(R.id.iv_nm_reward_audio_switch);
        this.o = (FrameLayout) viewInflate.findViewById(R.id.iv_nm_reward_audio_switch_ending);
        this.u = (TextView) viewInflate.findViewById(R.id.tv_nm_reward_video_close);
        this.g = (LinearLayout) viewInflate.findViewById(R.id.layout_nm_reward_video_control);
        this.F = (LinearLayout) viewInflate.findViewById(R.id.cta_nm_show);
        this.G = (LinearLayout) viewInflate.findViewById(R.id.cta_nm_ending_landscape);
        this.H = (LinearLayout) viewInflate.findViewById(R.id.cta_nm_ending_portrait);
        this.B = (ImageView) viewInflate.findViewById(R.id.iv_nm_logo);
        this.g0 = (ImageView) viewInflate.findViewById(R.id.iv_nm_reward_video_icon);
        this.h0 = (ImageView) viewInflate.findViewById(R.id.iv_nm_reward_video_ending_icon_protrait);
        this.i0 = (ImageView) viewInflate.findViewById(R.id.iv_nm_reward_video_ending_icon_landscape);
        this.y = (TextView) viewInflate.findViewById(R.id.tv_nm_reward_video_apptitle);
        this.z = (TextView) viewInflate.findViewById(R.id.tv_nm_reward_video_apptitle_ending_protrait);
        this.A = (TextView) viewInflate.findViewById(R.id.tv_nm_reward_video_apptitle_ending_landscape);
        if (this.J.getDesc() != null && !this.J.getDesc().isEmpty()) {
            this.y.setText(this.J.getDesc());
            this.z.setText(this.J.getDesc());
            this.A.setText(this.J.getDesc());
        }
        this.p = (FrameLayout) viewInflate.findViewById(R.id.xml_reward_fl_shake_container);
        this.q = (FrameLayout) viewInflate.findViewById(R.id.fl_nm_reward_video_bottom_view);
        this.j = (LinearLayout) viewInflate.findViewById(R.id.ll_nm_reward_video_ending_view_landscape);
        this.D = (ImageView) viewInflate.findViewById(R.id.iv_nm_reward_video_ending_img_landscape);
        this.E = (ImageView) viewInflate.findViewById(R.id.iv_nm_reward_video_img_landscape_back);
        this.l = (LinearLayout) viewInflate.findViewById(R.id.ll_nm_reward_video_ending_shake);
        this.m = (LinearLayout) viewInflate.findViewById(R.id.ll_nm_reward_video_landscape_ending_cover);
        this.r = (FrameLayout) viewInflate.findViewById(R.id.fl_nm_reward_video_show_container);
        com.alliance.ssp.ad.impl.reward.a aVar = v0;
        if (aVar != null) {
            aVar.a0 = com.alliance.ssp.ad.a.b.a("").append(this.J.getDuration()).toString();
        }
        if (this.t != null) {
            this.t.setText(String.format(getResources().getString(R.string.nm_reward_video_count_down_tip), Integer.valueOf(this.r0)));
        }
        TextView textView = this.u;
        if (textView != null) {
            textView.setOnClickListener(this.l0);
        }
        if (this.p != null && this.a0) {
            a(this.a);
        }
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.xml_reward_fl_six_element_container);
        this.q0 = frameLayout;
        if (this.T == 1) {
            d.b bVarA = new d.b().a(this.q0, 1, this.V == 0, 31);
            Material material = this.J;
            d dVar = bVarA.a;
            dVar.c = this;
            dVar.d = material;
            dVar.e = new g(this);
            bVarA.a();
        } else {
            frameLayout.setVisibility(8);
            ImageView imageView = this.B;
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.bottomMargin = 16;
                this.B.setLayoutParams(marginLayoutParams);
            }
        }
        ImageView imageView2 = this.B;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.nmadssp_logo_ad);
        }
        return viewInflate;
    }

    public final boolean l() throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (this.a == null) {
            int i = l.a;
            return false;
        }
        try {
            AppInfoViewActivity.g = this;
            Intent intent = new Intent(this.a, (Class<?>) AppInfoViewActivity.class);
            intent.putExtra("app_info_ad_data_copy", this.I.copy());
            this.a.startActivity(intent);
            v0.z();
            return true;
        } catch (Exception e) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 032: ")), e);
            return false;
        }
    }

    public final boolean m() throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i = l.a;
        String deeplink = this.J.getDeeplink();
        if (this.T == 1 && deeplink != null && !deeplink.isEmpty()) {
            String str = getExternalCacheDir() + "/nmssp_download/";
            String deeplink2 = this.J.getDeeplink();
            if (deeplink2 != null) {
                int iLastIndexOf = deeplink2.lastIndexOf(47) + 1;
                v0.z0 = deeplink2.substring(iLastIndexOf, deeplink2.indexOf(".apk", iLastIndexOf)) + ".apk";
                com.alliance.ssp.ad.r.a aVar = new com.alliance.ssp.ad.r.a(this);
                try {
                    SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                    com.alliance.ssp.ad.r.g gVarA = aVar.a(writableDatabase, deeplink2);
                    if (gVarA.d > 0) {
                        try {
                            if (com.alliance.ssp.ad.r.e.a(new File(str, gVarA.a)) == 0) {
                                gVarA.d = 0;
                                aVar.a(writableDatabase, gVarA);
                            } else if (gVarA.d == gVarA.c) {
                                this.U = 2;
                                return true;
                            }
                        } catch (Exception e) {
                            new f().a(0, 0, "004", "NMRewardVideoActivity 009: " + e.getMessage(), e);
                        }
                    }
                } catch (Exception e2) {
                    new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMRewardVideoActivity 010: ")), e2);
                }
            }
        }
        return false;
    }

    public final void n() {
        VideoController videoController = this.d;
        if (videoController != null) {
            videoController.g();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws JSONException, PackageManager.NameNotFoundException, IOException {
        VideoController videoController;
        com.alliance.ssp.ad.impl.reward.a aVar;
        super.onCreate(bundle);
        int i = l.a;
        this.a = this;
        try {
            getWindow().setFlags(1024, 1024);
            if (v0 == null) {
                return;
            }
            Intent intent = getIntent();
            if (intent == null) {
                com.alliance.ssp.ad.impl.reward.a aVar2 = v0;
                if (aVar2 != null) {
                    aVar2.b(this);
                    return;
                }
                return;
            }
            SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) intent.getParcelableExtra("extra_name_land_page_ad_data");
            this.I = sAAllianceAdData;
            if (sAAllianceAdData == null) {
                com.alliance.ssp.ad.impl.reward.a aVar3 = v0;
                if (aVar3 != null) {
                    aVar3.b(this);
                    return;
                }
                return;
            }
            if (sAAllianceAdData.getInteraction() != null) {
                if (this.I.getInteraction().getShake() != null) {
                    this.a0 = true;
                    this.M = this.I.getInteraction().getShake();
                }
                int i2 = this.I.getInteraction().clickArea;
                this.N = i2;
                if (i2 == -1) {
                    this.N = 1;
                }
            }
            this.f0 = this.I.getDlConfig();
            Material material = this.I.getMaterial();
            this.J = material;
            if (material == null) {
                com.alliance.ssp.ad.impl.reward.a aVar4 = v0;
                if (aVar4 != null) {
                    aVar4.b(this);
                    return;
                }
                return;
            }
            if (material.getDuration() == 0) {
                this.J.setDuration(30);
            }
            this.S = this.I.getRewardTime();
            if (this.r0 <= 0) {
                this.r0 = this.J.getDuration();
            }
            long j = this.S;
            if (j <= 0 || j > this.r0) {
                this.S = this.r0;
            }
            Material material2 = this.J;
            if (material2 != null) {
                this.T = material2.getLdptype();
            }
            this.I.getRestype();
            com.alliance.ssp.ad.impl.reward.a aVar5 = v0;
            if (aVar5 != null) {
                int i3 = aVar5.I0;
                this.V = i3;
                if (i3 == 2) {
                    setRequestedOrientation(0);
                } else if (i3 == 1) {
                    setRequestedOrientation(1);
                } else {
                    setRequestedOrientation(1);
                }
            }
            if (f()) {
                e();
                d();
                this.e0 = m();
                this.W = Math.min(this.a.getResources().getDisplayMetrics().widthPixels, this.a.getResources().getDisplayMetrics().heightPixels);
                this.X = Math.max(this.a.getResources().getDisplayMetrics().widthPixels, this.a.getResources().getDisplayMetrics().heightPixels);
                View viewK = k();
                this.e = viewK;
                if (viewK != null) {
                    viewK.addOnAttachStateChangeListener(this.j0);
                    this.e.setOnTouchListener(null);
                    this.e.setOnClickListener(this.k0);
                }
                a(this.a, this.F);
                this.F.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda0
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        this.f$0.j();
                    }
                });
                setContentView(this.e);
                this.b0 = this.d.b().getVideoHeight() > this.d.b().getVideoWidth();
                this.C = (ImageView) findViewById(R.id.iv_nm_img_video_back);
                this.s = (FrameLayout) findViewById(R.id.fl_nm_black_cover);
                this.c = (FrameLayout) findViewById(R.id.fl_nm_reward_video_view);
                VideoController videoController2 = this.d;
                if (videoController2 != null && this.C != null) {
                    Bitmap bitmapA = videoController2.a(1L);
                    Bitmap bitmapA2 = com.alliance.ssp.ad.n0.c.a(getWindow(), this.a, bitmapA, (this.b0 || this.V != 1) ? this.V : 2);
                    Bitmap bitmapA3 = com.alliance.ssp.ad.n0.d.a(bitmapA2, 20.0f);
                    this.R = bitmapA3;
                    if (bitmapA3 != null) {
                        this.C.setImageBitmap(bitmapA3);
                    }
                    if (bitmapA != null) {
                        bitmapA.recycle();
                    }
                    if (bitmapA2 != null) {
                        bitmapA2.recycle();
                    }
                }
                int i4 = this.V;
                if (i4 != 2 || this.d == null) {
                    if (i4 != 1 || (videoController = this.d) == null || (aVar = v0) == null || aVar.J0) {
                        return;
                    }
                    int videoHeight = ((int) ((this.X - (this.d.b().getVideoHeight() * ((this.W * 1.0d) / videoController.b().getVideoWidth()))) / 2.0d)) + com.alliance.ssp.ad.o0.h.b(this, 8.0f);
                    int iB = com.alliance.ssp.ad.o0.h.b(this, 16.0f);
                    ((FrameLayout.LayoutParams) this.g.getLayoutParams()).setMargins(0, videoHeight, iB, 0);
                    ((FrameLayout.LayoutParams) this.t.getLayoutParams()).setMargins(iB, videoHeight, 0, 0);
                    return;
                }
                ImageView imageView = this.C;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    Window window = getWindow();
                    window.getAttributes().layoutInDisplayCutoutMode = 1;
                    window.addFlags(67108864);
                }
                ((FrameLayout.LayoutParams) this.q.getLayoutParams()).setMargins(com.alliance.ssp.ad.o0.h.b(this, 98.0f), 0, com.alliance.ssp.ad.o0.h.b(this, 98.0f), com.alliance.ssp.ad.o0.h.b(this, com.alliance.ssp.ad.o0.h.b(this, 8.0f)));
                int iB2 = com.alliance.ssp.ad.o0.h.b(this, 20.0f);
                int iB3 = com.alliance.ssp.ad.o0.h.b(this, 93.0f);
                ((FrameLayout.LayoutParams) this.g.getLayoutParams()).setMargins(0, iB2, iB3, 0);
                ((FrameLayout.LayoutParams) this.t.getLayoutParams()).setMargins(iB3, iB2, 0, 0);
                if (this.b0) {
                    FrameLayout frameLayout = this.c;
                    if (frameLayout != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                        int i5 = this.W;
                        layoutParams.height = i5;
                        layoutParams.width = (i5 * 9) / 16;
                        this.c.setLayoutParams(layoutParams);
                    }
                    this.s.setVisibility(0);
                    this.C.setVisibility(0);
                }
            }
        } catch (Exception e) {
            com.alliance.ssp.ad.impl.reward.a aVar6 = v0;
            if (aVar6 != null) {
                aVar6.b(this);
            }
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMRewardVideoActivity 004: ")), e);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int i = l.a;
        v0 = null;
        Bitmap bitmap = this.R;
        if (bitmap != null) {
            bitmap.recycle();
        }
        com.alliance.ssp.ad.r.c.a(this.J.getDeeplink());
        n();
        if (this.p0 != null) {
            this.p0 = null;
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        com.alliance.ssp.ad.impl.reward.a aVar;
        super.onResume();
        if (this.d != null && (aVar = v0) != null) {
            aVar.u = false;
        }
        b();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() throws IllegalStateException {
        super.onStop();
        int i = l.a;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int[] iArr = new int[2];
        this.F.getLocationOnScreen(iArr);
        com.alliance.ssp.ad.impl.reward.a aVar = v0;
        if (aVar != null) {
            aVar.getClass();
            int i = iArr[0];
            int i2 = iArr[1];
            aVar.f0 = com.alliance.ssp.ad.a.f.a("", i);
            aVar.g0 = com.alliance.ssp.ad.a.f.a("", i2);
            aVar.h0 = com.alliance.ssp.ad.a.b.a("").append(com.alliance.ssp.ad.o0.h.a(aVar.L0, 52.0f)).toString();
            aVar.i0 = com.alliance.ssp.ad.a.b.a("").append(com.alliance.ssp.ad.o0.h.a(aVar.L0, 28.0f)).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i = l.a;
        n();
        if (v0 != null) {
            try {
                ((HashMap) com.alliance.ssp.ad.impl.reward.a.g1).remove(this.f714K);
            } catch (Exception e) {
                new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMRewardVideoActivity 006: ")), e);
            }
            com.alliance.ssp.ad.impl.reward.a aVar = v0;
            aVar.m("", "", aVar.h);
            v0.a(this.a);
            v0.p();
            com.alliance.ssp.ad.impl.reward.a aVar2 = v0;
            aVar2.getClass();
            new f().a(3, 1, aVar2.h, aVar2.w, "", 0);
            v0.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(double d) {
        FrameLayout frameLayout;
        if (d < 3.0d || (frameLayout = this.p) == null || this.h == null || !this.a0 || this.Z) {
            return;
        }
        frameLayout.setVisibility(8);
        this.h.setVisibility(0);
    }

    public final void b() {
        com.alliance.ssp.ad.impl.reward.a aVar = v0;
        if (aVar != null) {
            com.alliance.ssp.ad.l.l lVar = aVar.a1;
            if (lVar != null) {
                lVar.c();
            }
            this.c0 = false;
            VideoController videoController = this.d;
            if (videoController != null && videoController.i()) {
                com.alliance.ssp.ad.impl.reward.a aVar2 = v0;
                aVar2.b(aVar2.h);
            }
            this.O = false;
            c cVar = this.L;
            if (cVar != null) {
                cVar.f();
            }
        }
    }

    public final void e() {
        com.alliance.ssp.ad.impl.reward.a aVar = v0;
        if (aVar == null) {
            return;
        }
        float f = aVar.A;
        int i = this.r0;
        if (f >= i) {
            aVar.A = i - 1;
        }
        aVar.a1 = com.alliance.ssp.ad.l.l.a(Math.max(i * 1000, com.alipay.sdk.m.u.b.a), 100L, new l.a() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda5
            @Override // com.alliance.ssp.ad.l.l.a
            public final void a(double d, double d2) throws JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.a(d, d2);
            }
        });
    }

    public static void a(NMRewardVideoActivity nMRewardVideoActivity, String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
        nMRewardVideoActivity.getClass();
        int i = com.alliance.ssp.ad.o0.l.a;
        SAAllianceAdData sAAllianceAdDataCopy = nMRewardVideoActivity.I.copy();
        if (sAAllianceAdDataCopy != null) {
            if (sAAllianceAdDataCopy.getMaterial() == null) {
                sAAllianceAdDataCopy.setMaterial(new Material(null));
            }
            sAAllianceAdDataCopy.getMaterial().setLdp(str);
            if (sAAllianceAdDataCopy.getInteraction() == null) {
                sAAllianceAdDataCopy.setInteraction(new Interaction(null));
            }
            sAAllianceAdDataCopy.setInteraction(nMRewardVideoActivity.I.getInteraction());
            Intent intent = new Intent(nMRewardVideoActivity, (Class<?>) SAAllianceWebViewActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("extra_name_land_page_ad_data", sAAllianceAdDataCopy);
            nMRewardVideoActivity.startActivity(intent);
        }
    }

    public final void a(Context context) {
        try {
            if (context != null) {
                int i = 108;
                if (this.J.getTempid() != null && !this.J.getTempid().isEmpty()) {
                    i = 128;
                }
                c cVar = new c(context, 1, i, this.M, new c.b() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda11
                    @Override // com.alliance.ssp.ad.l.c.b
                    public final void a(int[] iArr) {
                        this.f$0.a(iArr);
                    }
                });
                this.L = cVar;
                this.p.addView(cVar.h);
                this.p.setVisibility(0);
                this.P = this.M.getResetSensitivity();
                return;
            }
            this.p.setVisibility(8);
        } catch (Exception e) {
            e.getMessage();
            int i2 = com.alliance.ssp.ad.o0.l.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        int i = com.alliance.ssp.ad.o0.l.a;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr) {
        if (this.O) {
            return;
        }
        int i = com.alliance.ssp.ad.o0.l.a;
        this.O = true;
        v0.C = iArr;
        if (a("shake", 0, false)) {
            return;
        }
        this.O = false;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        float f = i;
        float f2 = i2;
        float height = (1.0f * f2) / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale((f * 1.0f) / bitmap.getWidth(), height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f3 = i3;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f, f2), f3, f3, paint);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        if (v0 == null) {
            int i = com.alliance.ssp.ad.o0.l.a;
        } else if (this.N != 1 || this.T == 1) {
            a("user", 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(double d) {
        TextView textView = this.t;
        if (textView != null) {
            textView.setText(String.format(getResources().getString(R.string.nm_reward_video_count_down_tip), Integer.valueOf(((int) d) + 1)));
        }
    }

    public final void a() throws IllegalStateException {
        com.alliance.ssp.ad.impl.reward.a aVar = v0;
        if (aVar != null) {
            com.alliance.ssp.ad.l.l lVar = aVar.a1;
            if (lVar != null) {
                lVar.b();
            }
            VideoController videoController = this.d;
            if (videoController != null) {
                boolean zF = videoController.f();
                com.alliance.ssp.ad.impl.reward.a aVar2 = v0;
                if (aVar2 != null && zF) {
                    aVar2.k("", "", aVar2.h);
                }
            }
            this.O = true;
            c cVar = this.L;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r6, int r7, boolean r8) throws java.lang.IllegalStateException, org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException, java.security.NoSuchAlgorithmException, java.io.IOException, java.security.InvalidKeyException {
        /*
            r5 = this;
            com.alliance.ssp.ad.impl.reward.a r0 = com.alliance.ssp.ad.activity.NMRewardVideoActivity.v0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lf
            r0.x = r6
            if (r7 != r2) goto Lc
            r3 = r2
            goto Ld
        Lc:
            r3 = r1
        Ld:
            r0.D = r3
        Lf:
            if (r7 != r2) goto L13
            r0 = r2
            goto L14
        L13:
            r0 = r1
        L14:
            java.lang.String r3 = "unuser"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L25
            java.lang.String r3 = "close_button"
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L2a
        L25:
            int r6 = r5.N
            if (r6 != r2) goto L2a
            r0 = r2
        L2a:
            com.alliance.ssp.ad.video.VideoController r6 = r5.d
            if (r6 == 0) goto Lb9
            com.alliance.ssp.ad.impl.reward.a r6 = com.alliance.ssp.ad.activity.NMRewardVideoActivity.v0
            if (r6 == 0) goto Lb9
            int r3 = r5.T
            r4 = 0
            if (r3 != r2) goto Laa
            int r3 = r5.U
            if (r3 == 0) goto L86
            if (r3 == r2) goto L70
            r7 = 2
            if (r3 == r7) goto L44
            r6 = 3
            if (r3 == r6) goto L70
            goto La6
        L44:
            int r7 = r5.N
            if (r7 != 0) goto L64
            r6.c()
            com.alliance.ssp.ad.impl.reward.a r6 = com.alliance.ssp.ad.activity.NMRewardVideoActivity.v0
            r6.w()
            com.alliance.ssp.ad.impl.reward.a r6 = com.alliance.ssp.ad.activity.NMRewardVideoActivity.v0
            r6.I()
            com.alliance.ssp.ad.impl.reward.a r6 = com.alliance.ssp.ad.activity.NMRewardVideoActivity.v0
            com.alliance.ssp.ad.y.f r7 = r6.K0
            if (r7 == 0) goto L62
            r7 = 4
            r6.a(r7, r4)
            r6.G()
        L62:
            r1 = r2
            goto La6
        L64:
            boolean r1 = r5.l()
            if (r1 == 0) goto La6
            r5.c0 = r2
            r5.a()
            goto La6
        L70:
            int r6 = r5.f0
            if (r6 == 0) goto L7a
            int r6 = r5.N
            if (r6 != r2) goto La6
            if (r0 != 0) goto La6
        L7a:
            boolean r1 = r5.l()
            if (r1 == 0) goto La6
            r5.c0 = r2
            r5.a()
            goto La6
        L86:
            int r1 = r5.f0
            int r3 = com.alliance.ssp.ad.o0.l.a
            if (r8 != 0) goto La0
            if (r1 == 0) goto L94
            int r8 = r5.N
            if (r8 != r2) goto La0
            if (r0 != 0) goto La0
        L94:
            boolean r1 = r5.l()
            if (r1 == 0) goto La6
            r5.c0 = r2
            r5.a()
            goto La6
        La0:
            android.app.Activity r8 = r5.a
            boolean r1 = r6.a(r8, r7, r4)
        La6:
            r5.a(r1)
            return r1
        Laa:
            r5.a()
            com.alliance.ssp.ad.impl.reward.a r6 = com.alliance.ssp.ad.activity.NMRewardVideoActivity.v0
            android.app.Activity r8 = r5.a
            boolean r6 = r6.a(r8, r7, r4)
            r5.a(r6)
            return r6
        Lb9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.activity.NMRewardVideoActivity.a(java.lang.String, int, boolean):boolean");
    }

    public final void a(Context context, View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i;
        int i2;
        if (view == null) {
            return;
        }
        this.d0 = 52;
        if (this.Z) {
            this.d0 = 240;
            i = 5;
        } else {
            i = 4;
        }
        if (this.T == 1) {
            i2 = this.e0 ? 4 : 1;
        } else {
            i2 = 5;
        }
        try {
            this.Q = new com.alliance.ssp.ad.l.a(context, this.d0, i, i2, new a.c() { // from class: com.alliance.ssp.ad.activity.NMRewardVideoActivity$$ExternalSyntheticLambda4
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
            FrameLayout frameLayout2 = this.Q.o;
            if (frameLayout2 != null) {
                frameLayout.addView(frameLayout2);
            }
        } catch (Exception e) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 014: ")), e);
        }
        this.p0 = this.Q.n;
        com.alliance.ssp.ad.impl.reward.a aVar = v0;
        if (aVar != null) {
            aVar.q0 = new j(this, Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        if (i == 1) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            a("user", 1, z);
            return;
        }
        if (i == 2) {
            int i3 = com.alliance.ssp.ad.o0.l.a;
            v0.D();
            v0.I();
            this.Q.a(true);
            this.U = 3;
            return;
        }
        if (i == 3) {
            int i4 = com.alliance.ssp.ad.o0.l.a;
            v0.C();
            v0.I();
            this.U = 1;
            this.Q.a(false);
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
        v0.c();
        v0.w();
        v0.I();
        com.alliance.ssp.ad.impl.reward.a aVar = v0;
        if (aVar.K0 != null) {
            aVar.a(4, (RewardInfo) null);
            aVar.G();
        }
    }

    public final void a(boolean z) {
        c cVar;
        if (z && (cVar = this.L) != null && this.P == 1) {
            cVar.a(50.0d, 35.0d, 2000.0d);
            com.alliance.ssp.ad.impl.reward.a aVar = v0;
            SAAllianceAdData sAAllianceAdData = aVar.h;
            if (sAAllianceAdData == null || sAAllianceAdData.getInteraction() == null || aVar.h.getInteraction().getShake() == null) {
                return;
            }
            aVar.h.getInteraction().getShake().setAcceleration(50.0d);
            aVar.h.getInteraction().getShake().setRotationAngle(35.0d);
            aVar.h.getInteraction().getShake().setOperationTime(2.0d);
        }
    }
}
