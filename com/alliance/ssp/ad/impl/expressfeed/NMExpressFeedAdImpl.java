package com.alliance.ssp.ad.impl.expressfeed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.activity.AppInfoViewActivity;
import com.alliance.ssp.ad.activity.SAAllianceWebViewActivity;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdInteractionListener;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdLoadListener;
import com.alliance.ssp.ad.bean.Interaction;
import com.alliance.ssp.ad.bean.Lereplay;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.Monitor;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import com.alliance.ssp.ad.http.action.BaseNetAction;
import com.alliance.ssp.ad.l.a;
import com.alliance.ssp.ad.l.c;
import com.alliance.ssp.ad.l.d;
import com.alliance.ssp.ad.l.l;
import com.alliance.ssp.ad.n0.f;
import com.alliance.ssp.ad.o0.j;
import com.alliance.ssp.ad.r.i;
import com.alliance.ssp.ad.template.SAAllianceContainerView;
import com.alliance.ssp.ad.video.VideoController;
import com.alliance.ssp.ad.video.f;
import com.google.android.material.badge.BadgeDrawable;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class NMExpressFeedAdImpl extends com.alliance.ssp.ad.v.a implements f.a {
    public boolean A1;
    public com.alliance.ssp.ad.c0.b B1;
    public Handler C1;
    public NMExpressFeedAdImpl D0;
    public SAAllianceAdData D1;
    public EXPRESS_STATE E0;
    public String E1;
    public SHOWING_STATE F0;
    public boolean F1;
    public int G0;
    public HashMap<Integer, HashMap<Integer, String>> G1;
    public int H0;
    public Handler H1;
    public int I0;
    public HandlerThread I1;
    public int J0;
    public int J1;
    public int K0;
    public Handler K1;
    public boolean L0;
    public volatile boolean L1;
    public int M0;
    public final Object M1;
    public int N0;
    public com.alliance.ssp.ad.l.l N1;
    public com.alliance.ssp.ad.impl.expressfeed.b O0;
    public boolean O1;
    public View P0;
    public View P1;
    public int Q0;
    public boolean Q1;
    public boolean R0;
    public boolean R1;
    public int S0;
    public com.alliance.ssp.ad.m0.a S1;
    public boolean T0;
    public Handler T1;
    public boolean U0;
    public Handler U1;
    public boolean V0;
    public Handler V1;
    public boolean W0;
    public Handler W1;
    public boolean X0;
    public boolean X1;
    public boolean Y0;
    public int Y1;
    public boolean Z0;
    public boolean Z1;
    public int a1;
    public boolean a2;
    public boolean b1;
    public boolean b2;
    public boolean c1;
    public boolean d1;
    public int e1;
    public Material f1;
    public int g1;
    public String h1;
    public String i1;
    public String j1;
    public String k1;
    public String l1;
    public List<String> m1;
    public com.alliance.ssp.ad.n0.b n1;
    public View o1;
    public List<View> p1;
    public String q1;
    public View r1;
    public View s1;
    public Bitmap t1;
    public VideoController u1;
    public a.b v1;
    public float w1;
    public boolean x1;
    public boolean y1;
    public volatile boolean z1;

    public enum EXPRESS_STATE {
        IDLE,
        REQUESTING,
        LOADING,
        RENDERING,
        SHOWING,
        NO_FORE,
        DESTROY,
        ERROR
    }

    public enum SHOWING_STATE {
        IDLE,
        IMAGE,
        VIDEO,
        INTERACTIVE,
        FINISH,
        ERROR
    }

    public class b implements d.c {
        public b() {
        }

        @Override // com.alliance.ssp.ad.l.d.c
        public void a(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
            ((TextView) view).setHighlightColor(0);
            NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
            NMExpressFeedAdImpl.a(nMExpressFeedAdImpl, nMExpressFeedAdImpl.f1.getPermissionUrl());
            int i = com.alliance.ssp.ad.o0.l.a;
            NMExpressFeedAdImpl.this.d(4);
        }

        @Override // com.alliance.ssp.ad.l.d.c
        public void b(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
            ((TextView) view).setHighlightColor(0);
            NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
            NMExpressFeedAdImpl.a(nMExpressFeedAdImpl, nMExpressFeedAdImpl.f1.getPrivacyUrl());
            int i = com.alliance.ssp.ad.o0.l.a;
            NMExpressFeedAdImpl.this.d(4);
        }

        @Override // com.alliance.ssp.ad.l.d.c
        public void c(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
            ((TextView) view).setHighlightColor(0);
            NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
            NMExpressFeedAdImpl.a(nMExpressFeedAdImpl, nMExpressFeedAdImpl.f1.getAppIntro());
            int i = com.alliance.ssp.ad.o0.l.a;
            NMExpressFeedAdImpl.this.d(4);
        }
    }

    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            super.handleMessage(message);
            try {
                if (NMExpressFeedAdImpl.this.P0.getVisibility() != 0) {
                    NMExpressFeedAdImpl.a(NMExpressFeedAdImpl.this, 100);
                    NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
                    if (nMExpressFeedAdImpl.a1 >= 2000) {
                        nMExpressFeedAdImpl.a("信息流广告展示超时", 100006, "1", "加载超时导致素材不可用");
                        return;
                    } else {
                        nMExpressFeedAdImpl.K1.sendEmptyMessageDelayed(0, 100L);
                        return;
                    }
                }
                NMExpressFeedAdImpl nMExpressFeedAdImpl2 = NMExpressFeedAdImpl.this;
                com.alliance.ssp.ad.c0.b bVar = nMExpressFeedAdImpl2.B1;
                if (bVar == null) {
                    nMExpressFeedAdImpl2.E();
                    return;
                }
                float fA = bVar.a(nMExpressFeedAdImpl2.P0);
                NMExpressFeedAdImpl.this.x1 = fA >= 50.0f;
                NMExpressFeedAdImpl.f(NMExpressFeedAdImpl.this, true);
                NMExpressFeedAdImpl nMExpressFeedAdImpl3 = NMExpressFeedAdImpl.this;
                if (nMExpressFeedAdImpl3.x1) {
                    nMExpressFeedAdImpl3.E();
                }
            } catch (Exception e) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 020: ")), e);
            }
        }
    }

    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            super.handleMessage(message);
            try {
                NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
                if (nMExpressFeedAdImpl.X0) {
                    return;
                }
                NMExpressFeedAdImpl.a(nMExpressFeedAdImpl, 100);
                NMExpressFeedAdImpl nMExpressFeedAdImpl2 = NMExpressFeedAdImpl.this;
                if (nMExpressFeedAdImpl2.a1 < 5000) {
                    nMExpressFeedAdImpl2.T1.sendEmptyMessageDelayed(0, 100L);
                    return;
                }
                nMExpressFeedAdImpl2.q("", "", nMExpressFeedAdImpl2.h);
                NMExpressFeedAdImpl.this.a(3, (View) null, 200007, "模板信息流视频素材加载超时");
                NMExpressFeedAdImpl.this.b(100006, "2", "视频下载超时");
                NMExpressFeedAdImpl.this.S();
            } catch (Exception e) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 022: ")), e);
            }
        }
    }

    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
            View view;
            View view2;
            View view3;
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            super.handleMessage(message);
            try {
                HashMap<Integer, String> map = NMExpressFeedAdImpl.this.G1.get(0);
                if (map == null || map.get(2) == null || !map.get(2).contains("finish")) {
                    NMExpressFeedAdImpl.a(NMExpressFeedAdImpl.this, 100);
                    NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
                    if (nMExpressFeedAdImpl.a1 >= 6000) {
                        nMExpressFeedAdImpl.a("gif01加载超时", 100006, "1", "加载超时导致素材不可用");
                        return;
                    } else {
                        nMExpressFeedAdImpl.U1.sendEmptyMessageDelayed(0, 100L);
                        return;
                    }
                }
                if (map.get(3) == null || map.get(3).isEmpty()) {
                    return;
                }
                ImageView imageView = new ImageView(com.alliance.ssp.ad.o0.b.a(NMExpressFeedAdImpl.this.f));
                imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                com.alliance.ssp.ad.o0.d.a(NMExpressFeedAdImpl.this.f, imageView, map.get(3), 0.1f);
                NMExpressFeedAdImpl nMExpressFeedAdImpl2 = NMExpressFeedAdImpl.this;
                if (nMExpressFeedAdImpl2.I0 != 4) {
                    View view4 = nMExpressFeedAdImpl2.o1;
                    if (view4 != null) {
                        ((ViewGroup) view4).addView(imageView);
                        NMExpressFeedAdImpl nMExpressFeedAdImpl3 = NMExpressFeedAdImpl.this;
                        nMExpressFeedAdImpl3.a(nMExpressFeedAdImpl3.o1, 4.0f);
                        NMExpressFeedAdImpl nMExpressFeedAdImpl4 = NMExpressFeedAdImpl.this;
                        com.alliance.ssp.ad.n0.b bVar = nMExpressFeedAdImpl4.n1;
                        if (bVar != null && (view = bVar.v) != null) {
                            ((ViewGroup) nMExpressFeedAdImpl4.o1).addView(view);
                        }
                    }
                } else if (!nMExpressFeedAdImpl2.p1.isEmpty() && NMExpressFeedAdImpl.this.p1.get(0) != null) {
                    ((ViewGroup) NMExpressFeedAdImpl.this.p1.get(0)).removeAllViews();
                    ((ViewGroup) NMExpressFeedAdImpl.this.p1.get(0)).addView(imageView);
                    NMExpressFeedAdImpl nMExpressFeedAdImpl5 = NMExpressFeedAdImpl.this;
                    nMExpressFeedAdImpl5.a(nMExpressFeedAdImpl5.p1.get(0), 4.0f);
                }
                NMExpressFeedAdImpl nMExpressFeedAdImpl6 = NMExpressFeedAdImpl.this;
                if (nMExpressFeedAdImpl6.F0 != SHOWING_STATE.INTERACTIVE || (view2 = nMExpressFeedAdImpl6.s1) == null || (view3 = nMExpressFeedAdImpl6.o1) == null) {
                    return;
                }
                ((ViewGroup) view3).bringChildToFront(view2);
                NMExpressFeedAdImpl.this.o1.requestLayout();
                NMExpressFeedAdImpl.this.o1.invalidate();
            } catch (Exception e) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 023: ")), e);
            }
        }
    }

    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
            View view;
            View view2;
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            super.handleMessage(message);
            try {
                HashMap<Integer, String> map = NMExpressFeedAdImpl.this.G1.get(1);
                if (map == null || map.get(2) == null || !map.get(2).contains("finish")) {
                    NMExpressFeedAdImpl.a(NMExpressFeedAdImpl.this, 100);
                    NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
                    if (nMExpressFeedAdImpl.a1 >= 6000) {
                        nMExpressFeedAdImpl.a("gif02加载超时", 100006, "1", "加载超时导致素材不可用");
                        return;
                    } else {
                        nMExpressFeedAdImpl.V1.sendEmptyMessageDelayed(0, 100L);
                        return;
                    }
                }
                if (map.get(3) == null || map.get(3).isEmpty()) {
                    return;
                }
                ImageView imageView = new ImageView(com.alliance.ssp.ad.o0.b.a(NMExpressFeedAdImpl.this.f));
                imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                com.alliance.ssp.ad.o0.d.a(NMExpressFeedAdImpl.this.f, imageView, map.get(3), 0.1f);
                if (!NMExpressFeedAdImpl.this.p1.isEmpty() && NMExpressFeedAdImpl.this.p1.get(1) != null) {
                    ((ViewGroup) NMExpressFeedAdImpl.this.p1.get(1)).removeAllViews();
                    ((ViewGroup) NMExpressFeedAdImpl.this.p1.get(1)).addView(imageView);
                    NMExpressFeedAdImpl nMExpressFeedAdImpl2 = NMExpressFeedAdImpl.this;
                    nMExpressFeedAdImpl2.a(nMExpressFeedAdImpl2.p1.get(1), 4.0f);
                }
                NMExpressFeedAdImpl nMExpressFeedAdImpl3 = NMExpressFeedAdImpl.this;
                if (nMExpressFeedAdImpl3.F0 != SHOWING_STATE.INTERACTIVE || (view = nMExpressFeedAdImpl3.s1) == null || (view2 = nMExpressFeedAdImpl3.o1) == null) {
                    return;
                }
                ((ViewGroup) view2).bringChildToFront(view);
                NMExpressFeedAdImpl.this.o1.requestLayout();
                NMExpressFeedAdImpl.this.o1.invalidate();
            } catch (Exception e) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 024: ")), e);
            }
        }
    }

    public class g extends Handler {
        public g(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
            View view;
            View view2;
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            super.handleMessage(message);
            try {
                HashMap<Integer, String> map = NMExpressFeedAdImpl.this.G1.get(2);
                if (map == null || map.get(2) == null || !map.get(2).contains("finish")) {
                    NMExpressFeedAdImpl.a(NMExpressFeedAdImpl.this, 100);
                    NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
                    if (nMExpressFeedAdImpl.a1 >= 6000) {
                        nMExpressFeedAdImpl.a("gif03加载超时", 100006, "1", "加载超时导致素材不可用");
                        return;
                    } else {
                        nMExpressFeedAdImpl.W1.sendEmptyMessageDelayed(0, 100L);
                        return;
                    }
                }
                if (map.get(3) == null || map.get(3).isEmpty()) {
                    return;
                }
                ImageView imageView = new ImageView(com.alliance.ssp.ad.o0.b.a(NMExpressFeedAdImpl.this.f));
                imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                com.alliance.ssp.ad.o0.d.a(NMExpressFeedAdImpl.this.f, imageView, map.get(3), 0.1f);
                if (!NMExpressFeedAdImpl.this.p1.isEmpty() && NMExpressFeedAdImpl.this.p1.get(2) != null) {
                    ((ViewGroup) NMExpressFeedAdImpl.this.p1.get(2)).removeAllViews();
                    ((ViewGroup) NMExpressFeedAdImpl.this.p1.get(2)).addView(imageView);
                    NMExpressFeedAdImpl nMExpressFeedAdImpl2 = NMExpressFeedAdImpl.this;
                    nMExpressFeedAdImpl2.a(nMExpressFeedAdImpl2.p1.get(2), 4.0f);
                }
                NMExpressFeedAdImpl nMExpressFeedAdImpl3 = NMExpressFeedAdImpl.this;
                if (nMExpressFeedAdImpl3.F0 != SHOWING_STATE.INTERACTIVE || (view = nMExpressFeedAdImpl3.s1) == null || (view2 = nMExpressFeedAdImpl3.o1) == null) {
                    return;
                }
                ((ViewGroup) view2).bringChildToFront(view);
                NMExpressFeedAdImpl.this.o1.requestLayout();
                NMExpressFeedAdImpl.this.o1.invalidate();
            } catch (Exception e) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 025: ")), e);
            }
        }
    }

    public class h implements VideoController.h {
        public h() {
        }

        @Override // com.alliance.ssp.ad.video.VideoController.h
        public void a(boolean z) {
            if (z) {
                NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
                nMExpressFeedAdImpl.o("", "", nMExpressFeedAdImpl.h);
            } else {
                NMExpressFeedAdImpl nMExpressFeedAdImpl2 = NMExpressFeedAdImpl.this;
                nMExpressFeedAdImpl2.j("", "", nMExpressFeedAdImpl2.h);
            }
        }
    }

    public class o implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Context b;

        public o(View view, Context context) {
            this.a = view;
            this.b = context;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] iArr = new int[2];
            this.a.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            NMExpressFeedAdImpl.this.f0 = com.alliance.ssp.ad.a.f.a("", i);
            NMExpressFeedAdImpl.this.g0 = com.alliance.ssp.ad.a.f.a("", i2);
            NMExpressFeedAdImpl.this.h0 = com.alliance.ssp.ad.a.b.a("").append(com.alliance.ssp.ad.o0.h.a(this.b, NMExpressFeedAdImpl.this.J0)).toString();
            NMExpressFeedAdImpl.this.i0 = com.alliance.ssp.ad.a.b.a("").append(NMExpressFeedAdImpl.this.J1).toString();
        }
    }

    public NMExpressFeedAdImpl(int i2, WeakReference<Activity> weakReference, SAAllianceAdParams sAAllianceAdParams, SAExpressFeedAdLoadListener sAExpressFeedAdLoadListener, com.alliance.ssp.ad.d0.g gVar) throws JSONException, PackageManager.NameNotFoundException, IOException {
        super(i2, weakReference, "", null, "", sAAllianceAdParams, sAExpressFeedAdLoadListener, null, gVar);
        this.D0 = null;
        this.E0 = EXPRESS_STATE.IDLE;
        this.F0 = SHOWING_STATE.IDLE;
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = 1;
        this.K0 = 0;
        this.L0 = true;
        this.M0 = 0;
        this.O0 = null;
        this.P0 = null;
        this.Q0 = 1;
        this.R0 = false;
        this.S0 = 0;
        this.T0 = false;
        this.U0 = false;
        this.V0 = true;
        this.W0 = false;
        this.X0 = false;
        this.Y0 = false;
        this.Z0 = false;
        this.a1 = 0;
        this.b1 = false;
        this.c1 = false;
        this.d1 = false;
        this.e1 = 0;
        this.o1 = null;
        this.p1 = new ArrayList();
        this.q1 = "";
        this.v1 = null;
        this.w1 = 0.0f;
        this.x1 = true;
        this.y1 = false;
        this.z1 = false;
        this.A1 = false;
        this.F1 = false;
        this.G1 = new HashMap<Integer, HashMap<Integer, String>>() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl.1
            {
                put(0, new HashMap<Integer, String>() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl.1.1
                    {
                        put(1, "false");
                        put(2, "");
                        put(3, "");
                    }
                });
                put(1, new HashMap<Integer, String>() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl.1.2
                    {
                        put(1, "false");
                        put(2, "");
                        put(3, "");
                    }
                });
                put(2, new HashMap<Integer, String>() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl.1.3
                    {
                        put(1, "false");
                        put(2, "");
                        put(3, "");
                    }
                });
            }
        };
        this.H1 = null;
        this.I1 = null;
        this.K1 = new c(Looper.getMainLooper());
        this.L1 = false;
        this.M1 = new Object();
        this.N1 = null;
        this.O1 = false;
        this.Q1 = false;
        this.R1 = false;
        this.T1 = new d(Looper.getMainLooper());
        this.U1 = new e(Looper.getMainLooper());
        this.V1 = new f(Looper.getMainLooper());
        this.W1 = new g(Looper.getMainLooper());
        this.X1 = false;
        this.Y1 = 0;
        this.Z1 = false;
        this.a2 = false;
        this.b2 = false;
        gVar.f = this;
        this.l1 = sAAllianceAdParams.getPosId();
        this.D0 = this;
        a(sAAllianceAdParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        VideoController videoController = this.u1;
        if (videoController != null) {
            videoController.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        VideoController videoController = this.u1;
        if (videoController != null) {
            videoController.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.M0 == 1) {
            a(this.n1.k, "1");
        } else {
            a(this.P0, (String) null);
        }
        if (a("unuser", 0, false)) {
            this.B = true;
            c(1);
            d(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.s1.setVisibility(8);
        View view = this.n1.y;
        this.P1 = view;
        if (view != null) {
            Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(contextA.getResources(), R.drawable.nmadssp_toast_shack);
            ImageView imageView = new ImageView(contextA);
            imageView.setImageBitmap(bitmapDecodeResource);
            ((ViewGroup) this.P1).addView(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        ((ViewGroup) this.o1).removeView(this.r1);
        this.Y0 = false;
        this.Z1 = false;
        this.a2 = false;
        this.b2 = false;
        this.F0 = SHOWING_STATE.VIDEO;
        if (this.R1) {
            return;
        }
        SAAllianceAdData sAAllianceAdData = this.h;
        this.u0 = false;
        this.v0 = false;
        if (sAAllianceAdData == null) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
        } else {
            Objects.toString(sAAllianceAdData);
            int i3 = com.alliance.ssp.ad.o0.l.a;
            Monitor monitor = sAAllianceAdData.getMonitor();
            Objects.toString(monitor);
            if (monitor != null) {
                if (monitor.getAdvml() == null) {
                    new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "BaseAllianceAdImpl 013: monitor-Advml is null, The old version will be incompatible ", (Exception) null);
                } else {
                    List<Lereplay> lereplay = monitor.getAdvml().getLereplay();
                    if (lereplay != null && !lereplay.isEmpty()) {
                        Iterator<Lereplay> it = lereplay.iterator();
                        while (it.hasNext()) {
                            String url = it.next().getUrl();
                            if (!TextUtils.isEmpty(url)) {
                                String strB = b(url);
                                new com.alliance.ssp.ad.http.action.a(strB, new com.alliance.ssp.ad.t.c(this, strB), this.o, false, BaseNetAction.Method.GET).a();
                            }
                        }
                    }
                    int i4 = com.alliance.ssp.ad.o0.l.a;
                }
            }
        }
        b(this.h);
        this.R1 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            SHOWING_STATE showing_state = this.F0;
            SHOWING_STATE showing_state2 = SHOWING_STATE.FINISH;
            if (showing_state != showing_state2 && this.r1.getParent() == null) {
                ((ViewGroup) this.o1).addView(this.r1);
                this.F0 = showing_state2;
            }
            VideoController videoController = this.u1;
            if (videoController != null) {
                View viewA = videoController.a(new VideoController.f() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda0
                    @Override // com.alliance.ssp.ad.video.VideoController.f
                    public final void a() throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
                        this.f$0.L();
                    }
                });
                View view = this.n1.w;
                if (view != null && viewA != null) {
                    ((ViewGroup) view).removeAllViews();
                    ((ViewGroup) view).addView(viewA);
                }
            }
            com.alliance.ssp.ad.l.a aVar = this.F;
            if (aVar != null) {
                FrameLayout frameLayout = aVar.r;
                View view2 = this.n1.x;
                if (view2 == null || frameLayout == null) {
                    return;
                }
                ((ViewGroup) view2).removeAllViews();
                ((ViewGroup) view2).addView(frameLayout);
                frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f$0.b(view3);
                    }
                });
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 019: ")), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            SHOWING_STATE showing_state = this.F0;
            SHOWING_STATE showing_state2 = SHOWING_STATE.FINISH;
            if (showing_state == showing_state2 || this.r1.getParent() != null) {
                return;
            }
            ((ViewGroup) this.o1).addView(this.r1);
            this.F0 = showing_state2;
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 011: ")), e2);
        }
    }

    public static /* synthetic */ boolean f(NMExpressFeedAdImpl nMExpressFeedAdImpl, boolean z) {
        nMExpressFeedAdImpl.getClass();
        return z;
    }

    public final synchronized void E() {
        if (this.z1) {
            return;
        }
        this.z1 = true;
        A();
        t("", "", this.h);
        F();
        if (this.G0 == 2) {
            v();
            if (this.L0) {
                j("", "", this.h);
            }
        }
        this.E0 = EXPRESS_STATE.SHOWING;
        VideoController videoController = this.u1;
        if (videoController != null) {
            videoController.i();
        }
        T();
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        com.alliance.ssp.ad.t.h hVar = this.E;
        if (hVar != null) {
            hVar.a(contextA, this.l1, this.E1);
        }
        d(3);
    }

    public final void F() {
        this.N1 = com.alliance.ssp.ad.l.l.a((long) (Math.max(this.A, Math.max(3, ((int) this.w1) + 1)) * 1000.0f), 100L, new l.a() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda4
            @Override // com.alliance.ssp.ad.l.l.a
            public final void a(double d2, double d3) throws JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.a(d2, d3);
            }
        });
    }

    public final boolean G() {
        View view;
        EXPRESS_STATE express_state = this.E0;
        return (express_state == EXPRESS_STATE.IDLE || express_state == EXPRESS_STATE.DESTROY || express_state == EXPRESS_STATE.ERROR || (view = this.P0) == null || view.getVisibility() != 0 || !this.x1) ? false : true;
    }

    public final void O() throws JSONException, PackageManager.NameNotFoundException, IOException {
        final Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            return;
        }
        int i3 = com.alliance.ssp.ad.o0.l.a;
        this.E0 = EXPRESS_STATE.LOADING;
        Runnable runnable = new Runnable() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() throws JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.a(contextA);
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() throws JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.b(contextA);
            }
        };
        Runnable runnable3 = new Runnable() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() throws JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.c(contextA);
            }
        };
        try {
            if (this.G0 == 2) {
                VideoController videoController = new VideoController(contextA, this.j1, this.o1, false, false, this.L0, this);
                this.u1 = videoController;
                this.p = videoController;
            } else {
                com.alliance.ssp.ad.o0.n nVar = com.alliance.ssp.ad.o0.n.d;
                nVar.a.execute(runnable);
                if (this.I0 == 4) {
                    nVar.a.execute(runnable2);
                }
            }
            Material material = this.f1;
            if (material != null && material.getIconurl() != null && !this.f1.getIconurl().isEmpty()) {
                com.alliance.ssp.ad.o0.n.d.a.execute(runnable3);
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 010: ")), e2);
        }
        int[] iArr = new int[2];
        this.P0.getLocationInWindow(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        this.X = com.alliance.ssp.ad.a.f.a("", i4);
        this.Y = com.alliance.ssp.ad.a.f.a("", i5);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.G = "" + jCurrentTimeMillis;
        this.H = String.valueOf((int) (jCurrentTimeMillis / 1000));
        int i6 = com.alliance.ssp.ad.o0.l.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0228 A[Catch: Exception -> 0x02ee, TryCatch #1 {Exception -> 0x02ee, blocks: (B:106:0x0224, B:108:0x0228, B:110:0x0237, B:112:0x024f, B:114:0x0269, B:116:0x0280, B:118:0x0288, B:121:0x0293, B:123:0x02a1, B:126:0x02ac, B:128:0x02b4, B:129:0x02b9, B:130:0x02be, B:132:0x02c6, B:133:0x02cb, B:134:0x02d0, B:135:0x02d6, B:137:0x02da, B:139:0x02e2, B:140:0x02e8, B:113:0x0255), top: B:148:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0237 A[Catch: Exception -> 0x02ee, TryCatch #1 {Exception -> 0x02ee, blocks: (B:106:0x0224, B:108:0x0228, B:110:0x0237, B:112:0x024f, B:114:0x0269, B:116:0x0280, B:118:0x0288, B:121:0x0293, B:123:0x02a1, B:126:0x02ac, B:128:0x02b4, B:129:0x02b9, B:130:0x02be, B:132:0x02c6, B:133:0x02cb, B:134:0x02d0, B:135:0x02d6, B:137:0x02da, B:139:0x02e2, B:140:0x02e8, B:113:0x0255), top: B:148:0x0224 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void P() throws org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 793
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl.P():void");
    }

    public final boolean Q() throws JSONException, PackageManager.NameNotFoundException, IOException {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            return false;
        }
        try {
            AppInfoViewActivity.f = this;
            Intent intent = new Intent(contextA, (Class<?>) AppInfoViewActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("app_info_ad_data_copy", this.h.copy());
            contextA.startActivity(intent);
            int i3 = com.alliance.ssp.ad.o0.l.a;
            z();
            return true;
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 032: ")), e2);
            return false;
        }
    }

    public final void R() {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            return;
        }
        com.alliance.ssp.ad.m0.a aVar = new com.alliance.ssp.ad.m0.a(new com.alliance.ssp.ad.m0.c() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda17
            @Override // com.alliance.ssp.ad.m0.c
            public final void a(Object obj) {
                this.f$0.a((Intent) obj);
            }
        }, contextA);
        this.S1 = aVar;
        aVar.b("SA_TARGET_YT_WEB_ACTIVITY_FINISHED");
    }

    public final void S() {
        VideoController videoController = this.u1;
        if (videoController != null) {
            videoController.g();
            this.u1 = null;
        }
    }

    public final void T() throws JSONException, PackageManager.NameNotFoundException, IOException {
        com.alliance.ssp.ad.n0.b bVar;
        View view;
        if (this.h.getInteraction().getShake() == null || (bVar = this.n1) == null) {
            return;
        }
        int i2 = this.I0;
        if (i2 == 5 || i2 == 1) {
            this.N0 = 1;
        } else if (i2 == 4) {
            this.N0 = 3;
        } else {
            this.N0 = 2;
        }
        try {
            View viewA = bVar.a(this.N0, 2, this.h.getInteraction().getShake(), new c.b() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda5
                @Override // com.alliance.ssp.ad.l.c.b
                public final void a(int[] iArr) {
                    this.f$0.a(iArr);
                }
            });
            this.s1 = viewA;
            this.y1 = true;
            if (viewA == null || (view = this.o1) == null) {
                return;
            }
            SHOWING_STATE showing_state = this.F0;
            SHOWING_STATE showing_state2 = SHOWING_STATE.INTERACTIVE;
            if (showing_state != showing_state2) {
                ((ViewGroup) view).addView(viewA);
                ((ViewGroup) this.o1).bringChildToFront(this.s1);
                this.o1.requestLayout();
                this.o1.invalidate();
                this.F0 = showing_state2;
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 018: ")), e2);
        }
    }

    public final synchronized void U() {
        Objects.toString(this.F0);
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (this.G0 == 2 && this.o1 != null && this.n1 != null && this.F0 == SHOWING_STATE.VIDEO) {
            View view = this.s1;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.P1;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (this.r1 == null) {
                int i3 = this.I0;
                if (i3 == 5 || i3 == 1) {
                    com.alliance.ssp.ad.n0.b bVar = this.n1;
                    bVar.getClass();
                    FrameLayout frameLayout = new FrameLayout(bVar.b);
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    frameLayout.setBackgroundColor(Color.parseColor("#42000000"));
                    FrameLayout frameLayout2 = new FrameLayout(bVar.b);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.a((float) (bVar.c * 0.22d)), bVar.a((float) (bVar.c * 0.06d)));
                    layoutParams.gravity = 17;
                    frameLayout2.setLayoutParams(layoutParams);
                    ImageView imageView = new ImageView(bVar.b);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(bVar.a((float) (bVar.c * 0.117d)), bVar.a((float) (bVar.c * 0.05d)));
                    layoutParams2.gravity = BadgeDrawable.BOTTOM_START;
                    imageView.setLayoutParams(layoutParams2);
                    imageView.setImageResource(R.drawable.nmadssp_logo_ad);
                    FrameLayout frameLayout3 = new FrameLayout(bVar.b);
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(bVar.a((float) (bVar.c * 0.13d)), bVar.a((float) (bVar.c * 0.05d)));
                    layoutParams3.gravity = BadgeDrawable.BOTTOM_END;
                    layoutParams3.setMargins(0, 0, bVar.a(2.0f), bVar.a(4.0f));
                    frameLayout3.setLayoutParams(layoutParams3);
                    frameLayout.addView(frameLayout2);
                    frameLayout.addView(imageView);
                    frameLayout.addView(frameLayout3);
                    bVar.w = frameLayout3;
                    bVar.x = frameLayout2;
                    this.r1 = frameLayout;
                } else {
                    com.alliance.ssp.ad.n0.b bVar2 = this.n1;
                    Bitmap bitmap = this.t1;
                    String apkname = this.h.getMaterial().getApkname();
                    bVar2.getClass();
                    FrameLayout frameLayout4 = new FrameLayout(bVar2.b);
                    frameLayout4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    frameLayout4.setBackgroundColor(Color.parseColor("#42000000"));
                    FrameLayout frameLayout5 = new FrameLayout(bVar2.b);
                    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams4.gravity = 17;
                    frameLayout5.setLayoutParams(layoutParams4);
                    LinearLayout linearLayoutA = bVar2.a(-2, -2, 1.0f, 1);
                    linearLayoutA.setBackgroundColor(0);
                    frameLayout5.addView(linearLayoutA);
                    frameLayout4.addView(frameLayout5);
                    if (bitmap != null) {
                        ImageView imageView2 = new ImageView(bVar2.b);
                        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(bVar2.a((float) (bVar2.c * 0.22d)), bVar2.a((float) (bVar2.c * 0.16d)));
                        layoutParams5.gravity = 1;
                        imageView2.setLayoutParams(layoutParams5);
                        imageView2.setImageBitmap(bitmap);
                        linearLayoutA.addView(imageView2);
                    }
                    if (apkname == null || apkname.isEmpty()) {
                        FrameLayout frameLayout6 = new FrameLayout(bVar2.b);
                        frameLayout6.setLayoutParams(new FrameLayout.LayoutParams(bVar2.a((float) (bVar2.c * 0.22d)), bVar2.a((float) (bVar2.c * 0.07d))));
                        linearLayoutA.addView(frameLayout6);
                    } else {
                        FrameLayout frameLayout7 = new FrameLayout(bVar2.b);
                        frameLayout7.setLayoutParams(new FrameLayout.LayoutParams(bVar2.a((float) (bVar2.c * 0.22d)), bVar2.a((float) (bVar2.c * 0.07d))));
                        frameLayout7.setBackgroundColor(Color.parseColor("#00000000"));
                        TextView textView = new TextView(bVar2.b);
                        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams6.gravity = 17;
                        textView.setText(apkname);
                        textView.setTextSize(11.0f);
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                        textView.setMaxLines(1);
                        int i4 = bVar2.c;
                        if (i4 <= 180) {
                            textView.setTextSize(8.0f);
                        } else if (i4 <= 240) {
                            textView.setTextSize(9.0f);
                        } else if (i4 <= 300) {
                            textView.setTextSize(10.0f);
                        }
                        textView.setTextColor(Color.parseColor("#ffffffff"));
                        frameLayout7.addView(textView, layoutParams6);
                        linearLayoutA.addView(frameLayout7);
                    }
                    FrameLayout frameLayout8 = new FrameLayout(bVar2.b);
                    FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(bVar2.a((float) (bVar2.c * 0.22d)), bVar2.a((float) (bVar2.c * 0.06d)));
                    layoutParams7.gravity = 17;
                    frameLayout8.setLayoutParams(layoutParams7);
                    linearLayoutA.addView(frameLayout8);
                    int i5 = bVar2.a;
                    if (i5 != 2 && i5 != 3) {
                        ImageView imageView3 = new ImageView(bVar2.b);
                        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(bVar2.a((float) (bVar2.c * 0.117d)), bVar2.a((float) (bVar2.c * 0.05d)));
                        layoutParams8.gravity = BadgeDrawable.BOTTOM_START;
                        layoutParams8.setMargins(bVar2.a(8.0f), 0, 0, bVar2.a(8.0f));
                        imageView3.setLayoutParams(layoutParams8);
                        imageView3.setImageResource(R.drawable.nmadssp_logo_ad);
                        frameLayout4.addView(imageView3);
                    }
                    FrameLayout frameLayout9 = new FrameLayout(bVar2.b);
                    FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(bVar2.a((float) (bVar2.c * 0.13d)), bVar2.a((float) (bVar2.c * 0.05d)));
                    layoutParams9.gravity = BadgeDrawable.BOTTOM_END;
                    layoutParams9.setMargins(0, 0, bVar2.a(4.0f), bVar2.a(4.0f));
                    frameLayout9.setLayoutParams(layoutParams9);
                    frameLayout4.addView(frameLayout9);
                    bVar2.w = frameLayout9;
                    bVar2.x = frameLayout8;
                    this.r1 = frameLayout4;
                }
                if (this.r1 == null) {
                } else {
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda11
                        @Override // java.lang.Runnable
                        public final void run() throws JSONException, PackageManager.NameNotFoundException, IOException {
                            this.f$0.M();
                        }
                    });
                }
            } else {
                com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException, PackageManager.NameNotFoundException, IOException {
                        this.f$0.N();
                    }
                });
            }
        }
    }

    public final void a(final int i2, final View view, final int i3, final String str) {
        com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i2, i3, str, view);
            }
        });
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void b(int i2) {
    }

    @Override // com.alliance.ssp.ad.t.a
    public void n() {
        VideoController videoController = this.u1;
        if (videoController != null) {
            this.T0 = false;
            this.u = false;
            if (videoController != null) {
                videoController.i();
            }
            if (this.V0 || this.Y0 || this.R1) {
                this.V0 = false;
            } else {
                b(this.h);
                this.R1 = true;
            }
        }
        d(3);
        d(6);
    }

    @Override // com.alliance.ssp.ad.t.a
    public void o() {
        this.V0 = false;
        d(5);
        if (this.u1 != null && !this.u) {
            this.T0 = true;
        }
        d(4);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void onError(MediaPlayer mediaPlayer, int i2, int i3) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i4 = com.alliance.ssp.ad.o0.l.a;
        a("Show failure", 100006, "1", "素材不可用");
        new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.f.a("NMExpressFeedAdImpl 006: 视频错误，what = ", i2), (Exception) null);
        b(100006, "1", "视频素材出现错误");
        q("", "", this.h);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        int i4 = com.alliance.ssp.ad.o0.l.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i2 = com.alliance.ssp.ad.o0.l.a;
        for (int i3 = 1; i3 < Math.min(this.m1.size(), 3); i3++) {
            try {
                com.alliance.ssp.ad.r.i.a().a(this.m1.get(i3), new l(i3, context));
                if (this.m1.get(i3).endsWith(PictureMimeType.GIF)) {
                    String str = UUID.randomUUID().toString().replace("-", "") + "aaaccc" + i3;
                    HashMap<Integer, String> map = this.G1.get(Integer.valueOf(i3));
                    if (map != null) {
                        map.put(1, "true");
                        map.put(2, "download");
                    }
                    com.alliance.ssp.ad.o0.j.a().a(context, this.m1.get(i3), str, new m(this, i3, map, str));
                }
            } catch (Exception e2) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 008: ")), e2);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i2 = com.alliance.ssp.ad.o0.l.a;
        try {
            com.alliance.ssp.ad.r.i.a().a(this.f1.getIconurl(), new n(context));
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 009: ")), e2);
        }
    }

    public final void d(Context context, View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (this.g1 != 1 || view == null) {
            return;
        }
        d.b bVar = new d.b();
        com.alliance.ssp.ad.l.d dVar = bVar.a;
        dVar.f = false;
        dVar.b = (ViewGroup) view;
        dVar.a = 2;
        dVar.g = 55;
        Material material = this.f1;
        dVar.c = context;
        dVar.d = material;
        dVar.e = new b();
        bVar.a();
    }

    public static void a(NMExpressFeedAdImpl nMExpressFeedAdImpl, int i2, String str, String str2) {
        Handler handler;
        nMExpressFeedAdImpl.getClass();
        int i3 = com.alliance.ssp.ad.o0.l.a;
        if (nMExpressFeedAdImpl.D1 != null && (handler = nMExpressFeedAdImpl.C1) != null) {
            handler.removeCallbacksAndMessages(null);
            nMExpressFeedAdImpl.C1.sendEmptyMessage(0);
        } else {
            nMExpressFeedAdImpl.a(i2, str, str2);
            com.alliance.ssp.ad.t.i.a(nMExpressFeedAdImpl.w, nMExpressFeedAdImpl.l1, i2, str2);
        }
    }

    public class k implements j.b {
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ String b;

        public k(NMExpressFeedAdImpl nMExpressFeedAdImpl, HashMap map, String str) {
            this.a = map;
            this.b = str;
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(int i) {
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(File file) {
            int i = com.alliance.ssp.ad.o0.l.a;
            HashMap map = this.a;
            if (map != null) {
                map.put(2, "finish");
                this.a.put(3, file.getAbsolutePath() + "/" + this.b + PictureMimeType.GIF);
            }
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(Exception exc) {
            Objects.toString(exc);
            int i = com.alliance.ssp.ad.o0.l.a;
        }
    }

    public class m implements j.b {
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ String b;

        public m(NMExpressFeedAdImpl nMExpressFeedAdImpl, int i, HashMap map, String str) {
            this.a = map;
            this.b = str;
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(int i) {
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(File file) {
            int i = com.alliance.ssp.ad.o0.l.a;
            HashMap map = this.a;
            if (map != null) {
                map.put(2, "finish");
                this.a.put(3, file.getAbsolutePath() + "/" + this.b + PictureMimeType.GIF);
            }
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(Exception exc) {
            Objects.toString(exc);
            int i = com.alliance.ssp.ad.o0.l.a;
        }
    }

    public class n implements i.a {
        public final /* synthetic */ Context a;

        public n(Context context) {
            this.a = context;
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Bitmap bitmap) {
            int i = com.alliance.ssp.ad.o0.l.a;
            NMExpressFeedAdImpl.this.t1 = NMExpressFeedAdImpl.a(NMExpressFeedAdImpl.this, bitmap, com.alliance.ssp.ad.l.b.a(this.a, 56.0f), com.alliance.ssp.ad.l.b.a(this.a, 56.0f), com.alliance.ssp.ad.l.b.a(this.a, 8.0f));
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Exception exc) {
            Objects.toString(exc);
            int i = com.alliance.ssp.ad.o0.l.a;
        }
    }

    public class a implements i.a {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Context c;

        public a(ImageView imageView, View view, Context context) {
            this.a = imageView;
            this.b = view;
            this.c = context;
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Bitmap bitmap) throws JSONException, PackageManager.NameNotFoundException, IOException {
            try {
                this.a.setImageBitmap(NMExpressFeedAdImpl.a(NMExpressFeedAdImpl.this, bitmap, 80, 80, 40));
                ((ViewGroup) this.b).addView(this.a);
            } catch (Exception e) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 017: ")), e);
            }
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Exception exc) {
            int i = com.alliance.ssp.ad.o0.l.a;
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.nmadssp_ic_launcher);
            if (bitmapDecodeResource != null) {
                this.a.setImageBitmap(bitmapDecodeResource);
                ((ViewGroup) this.b).addView(this.a);
            }
        }
    }

    public final void c(Context context, View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i2;
        int i3;
        if (view == null) {
            return;
        }
        this.J1 = com.alliance.ssp.ad.o0.h.a(context, (int) (this.J0 * 0.06d));
        int i4 = this.I0;
        int i5 = 5;
        if (i4 == 1 || i4 == 5) {
            this.J1 = com.alliance.ssp.ad.o0.h.a(context, (int) (this.J0 * 0.05d));
            i2 = 2;
        } else {
            i2 = 1;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new o(view, context));
        if (this.g1 != 1) {
            i3 = i5;
        } else if (this.R0) {
            i5 = 4;
            i3 = i5;
        } else {
            i3 = 1;
        }
        try {
            this.F = new com.alliance.ssp.ad.l.a(context, this.J0, i2, i3, new a.c() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda14
                @Override // com.alliance.ssp.ad.l.a.c
                public final void a(int i6, boolean z) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
                    this.f$0.a(i6, z);
                }
            });
            FrameLayout frameLayout = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 16;
            frameLayout.setLayoutParams(layoutParams);
            ((LinearLayout) view).addView(frameLayout);
            FrameLayout frameLayout2 = this.F.o;
            if (frameLayout2 != null) {
                frameLayout.addView(frameLayout2);
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 014: ")), e2);
        }
        this.v1 = this.F.n;
        this.q0 = new com.alliance.ssp.ad.v.d(this, Looper.getMainLooper());
    }

    public static Bitmap a(NMExpressFeedAdImpl nMExpressFeedAdImpl, Bitmap bitmap, int i2, int i3, int i4) throws JSONException, PackageManager.NameNotFoundException, IOException {
        nMExpressFeedAdImpl.getClass();
        if (bitmap == null) {
            return null;
        }
        try {
            float f2 = i2;
            float f3 = i3;
            float height = (1.0f * f3) / bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.setScale((f2 * 1.0f) / bitmap.getWidth(), height);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint(1);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(matrix);
            paint.setShader(bitmapShader);
            float f4 = i4;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, f2, f3), f4, f4, paint);
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 028: ")), e2);
            return null;
        }
    }

    public final void d(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
                this.f$0.c(view2);
            }
        });
    }

    public final void d(int i2) {
        if (this.I1 == null) {
            int i3 = com.alliance.ssp.ad.o0.l.a;
            return;
        }
        Handler handler = this.H1;
        if (handler != null) {
            synchronized (handler) {
                Handler handler2 = this.H1;
                if (handler2 != null) {
                    Message messageObtainMessage = handler2.obtainMessage();
                    messageObtainMessage.what = i2;
                    this.H1.sendMessage(messageObtainMessage);
                }
            }
        }
    }

    public class l implements i.a {
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;

        public l(int i, Context context) {
            this.a = i;
            this.b = context;
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Bitmap bitmap) {
            int i = this.a;
            int i2 = com.alliance.ssp.ad.o0.l.a;
            if (NMExpressFeedAdImpl.this.p1.get(i) != null) {
                if (NMExpressFeedAdImpl.this.n1 != null) {
                    Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
                    NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
                    nMExpressFeedAdImpl.n1.a(nMExpressFeedAdImpl.p1.get(this.a), com.alliance.ssp.ad.n0.d.a(bitmapCopy, 10.0f));
                }
                ImageView imageView = new ImageView(this.b);
                imageView.setImageBitmap(bitmap);
                ((ViewGroup) NMExpressFeedAdImpl.this.p1.get(this.a)).addView(imageView);
            }
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Exception exc) {
            int i = com.alliance.ssp.ad.o0.l.a;
        }
    }

    public static void a(NMExpressFeedAdImpl nMExpressFeedAdImpl, String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
        nMExpressFeedAdImpl.getClass();
        int i2 = com.alliance.ssp.ad.o0.l.a;
        Context contextA = com.alliance.ssp.ad.o0.b.a(nMExpressFeedAdImpl.f);
        if (contextA == null) {
            return;
        }
        try {
            SAAllianceAdData sAAllianceAdDataCopy = nMExpressFeedAdImpl.h.copy();
            if (sAAllianceAdDataCopy != null) {
                if (sAAllianceAdDataCopy.getMaterial() == null) {
                    sAAllianceAdDataCopy.setMaterial(new Material(null));
                }
                sAAllianceAdDataCopy.getMaterial().setLdp(str);
                if (sAAllianceAdDataCopy.getInteraction() == null) {
                    sAAllianceAdDataCopy.setInteraction(new Interaction(null));
                }
                sAAllianceAdDataCopy.setInteraction(nMExpressFeedAdImpl.h.getInteraction());
                Intent intent = new Intent(contextA, (Class<?>) SAAllianceWebViewActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("extra_name_land_page_ad_data", sAAllianceAdDataCopy);
                contextA.startActivity(intent);
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 031: ")), e2);
        }
    }

    public final void b(Context context, View view) {
        if (view == null) {
            return;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.nmadssp_icon_close_gray);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        imageView.setImageBitmap(bitmapDecodeResource);
        ((ViewGroup) view).addView(imageView);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.a(view2);
            }
        });
    }

    public final boolean b(Context context, String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (this.g1 == 1 && context != null && str != null && !str.isEmpty()) {
            String str2 = context.getExternalCacheDir() + "/nmssp_download/";
            String deeplink = this.f1.getDeeplink();
            int iLastIndexOf = deeplink.lastIndexOf(47) + 1;
            this.z0 = deeplink.substring(iLastIndexOf, deeplink.indexOf(".apk", iLastIndexOf)) + ".apk";
            com.alliance.ssp.ad.r.a aVar = new com.alliance.ssp.ad.r.a(context);
            try {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                com.alliance.ssp.ad.r.g gVarA = aVar.a(writableDatabase, deeplink);
                if (gVarA.d > 0) {
                    try {
                        if (com.alliance.ssp.ad.r.e.a(new File(str2, gVarA.a)) == 0) {
                            gVarA.d = 0;
                            aVar.a(writableDatabase, gVarA);
                        } else if (gVarA.d == gVarA.c) {
                            this.r = 2;
                            return true;
                        }
                    } catch (Exception e2) {
                        new com.alliance.ssp.ad.d0.f().a(0, 0, "004", "NMExpressFeedImpl 005: " + e2.getMessage(), e2);
                    }
                }
            } catch (Exception e3) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e3, com.alliance.ssp.ad.a.b.a("NMExpressFeedImpl 004: ")), e3);
            }
        }
        return false;
    }

    public static /* synthetic */ int a(NMExpressFeedAdImpl nMExpressFeedAdImpl, int i2) {
        int i3 = nMExpressFeedAdImpl.a1 + i2;
        nMExpressFeedAdImpl.a1 = i3;
        return i3;
    }

    public static void a(NMExpressFeedAdImpl nMExpressFeedAdImpl, SAAllianceAdData sAAllianceAdData, SAAllianceAdData sAAllianceAdData2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        String str;
        nMExpressFeedAdImpl.getClass();
        try {
            if (sAAllianceAdData == null) {
                nMExpressFeedAdImpl.h = sAAllianceAdData2;
                nMExpressFeedAdImpl.E1 = nMExpressFeedAdImpl.w;
            } else if (sAAllianceAdData2 != null && sAAllianceAdData.getPriceD() <= sAAllianceAdData2.getPriceD()) {
                nMExpressFeedAdImpl.h = sAAllianceAdData2;
                nMExpressFeedAdImpl.E1 = nMExpressFeedAdImpl.w;
            } else {
                nMExpressFeedAdImpl.h = sAAllianceAdData;
                nMExpressFeedAdImpl.E1 = sAAllianceAdData.getRequestid();
                nMExpressFeedAdImpl.h.setParentCrequestid(sAAllianceAdData.getRequestid());
            }
            nMExpressFeedAdImpl.h.setCrequestid(nMExpressFeedAdImpl.w);
            nMExpressFeedAdImpl.E.a(nMExpressFeedAdImpl.l1, nMExpressFeedAdImpl.E1);
            int i2 = com.alliance.ssp.ad.o0.l.a;
            nMExpressFeedAdImpl.h.setSpostype(Integer.parseInt(nMExpressFeedAdImpl.j0));
            nMExpressFeedAdImpl.S0 = nMExpressFeedAdImpl.h.getClickCallbackSwitch();
            if (nMExpressFeedAdImpl.h.getMaterial() == null) {
                nMExpressFeedAdImpl.a(8196, "001", "广告素材为空，请联系运营检查代码位ID配置情况。01");
                com.alliance.ssp.ad.t.i.a(nMExpressFeedAdImpl.w, nMExpressFeedAdImpl.l1, 8196, "广告素材为空，请联系运营检查代码位ID配置情况。01");
                return;
            }
            nMExpressFeedAdImpl.H0 = nMExpressFeedAdImpl.h.getDlConfig();
            Material material = nMExpressFeedAdImpl.h.getMaterial();
            nMExpressFeedAdImpl.f1 = material;
            nMExpressFeedAdImpl.m1 = material.getImgurl();
            nMExpressFeedAdImpl.j1 = nMExpressFeedAdImpl.f1.getVideourl();
            nMExpressFeedAdImpl.g1 = nMExpressFeedAdImpl.f1.getLdptype();
            float validExposeTime = nMExpressFeedAdImpl.h.getValidExposeTime();
            nMExpressFeedAdImpl.w1 = validExposeTime;
            if (validExposeTime <= 0.0f) {
                nMExpressFeedAdImpl.w1 = 1.0f;
            }
            List<String> list = nMExpressFeedAdImpl.m1;
            if ((list != null && !list.isEmpty()) || ((str = nMExpressFeedAdImpl.j1) != null && !str.isEmpty())) {
                String tagCode = nMExpressFeedAdImpl.h.getTagCode();
                if (tagCode != null && !tagCode.isEmpty()) {
                    nMExpressFeedAdImpl.o = tagCode;
                }
                String price = nMExpressFeedAdImpl.h.getPrice();
                nMExpressFeedAdImpl.s = price;
                if (price == null || price.isEmpty()) {
                    nMExpressFeedAdImpl.s = "-1";
                }
                if (nMExpressFeedAdImpl.h.getRstyle() != null && !nMExpressFeedAdImpl.h.getRstyle().isEmpty()) {
                    nMExpressFeedAdImpl.I0 = Integer.parseInt(nMExpressFeedAdImpl.h.getRstyle());
                }
                if (nMExpressFeedAdImpl.h.getInteraction().getClickArea() != -1) {
                    nMExpressFeedAdImpl.M0 = nMExpressFeedAdImpl.h.getInteraction().getClickArea();
                }
                nMExpressFeedAdImpl.h1 = nMExpressFeedAdImpl.f1.getTitle();
                nMExpressFeedAdImpl.i1 = nMExpressFeedAdImpl.f1.getDesc();
                nMExpressFeedAdImpl.k1 = nMExpressFeedAdImpl.f1.getTempid();
                SAAllianceAdParams sAAllianceAdParams = nMExpressFeedAdImpl.g;
                if (sAAllianceAdParams != null && sAAllianceAdParams.getUserId() != null && !nMExpressFeedAdImpl.g.getUserId().isEmpty()) {
                    nMExpressFeedAdImpl.h.setUserId(nMExpressFeedAdImpl.g.getUserId());
                }
                nMExpressFeedAdImpl.P();
                com.alliance.ssp.ad.t.i.a(nMExpressFeedAdImpl.w, nMExpressFeedAdImpl.l1);
                nMExpressFeedAdImpl.F1 = true;
                if (nMExpressFeedAdImpl.I1 == null) {
                    nMExpressFeedAdImpl.I1 = new HandlerThread("ExpressHandlerThread");
                }
                if (!nMExpressFeedAdImpl.Q1) {
                    nMExpressFeedAdImpl.I1.start();
                    nMExpressFeedAdImpl.Q1 = true;
                }
                nMExpressFeedAdImpl.H1 = new com.alliance.ssp.ad.impl.expressfeed.a(nMExpressFeedAdImpl, nMExpressFeedAdImpl.I1.getLooper());
                return;
            }
            nMExpressFeedAdImpl.a(8196, "002", "广告素材为空，请联系运营检查代码位ID配置情况。02");
            com.alliance.ssp.ad.t.i.a(nMExpressFeedAdImpl.w, nMExpressFeedAdImpl.l1, 8196, "广告素材为空，请联系运营检查代码位ID配置情况。02");
        } catch (Exception e2) {
            e2.toString();
            int i3 = com.alliance.ssp.ad.o0.l.a;
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 003: ")), e2);
            nMExpressFeedAdImpl.a(8194, "001", "渲染失败。");
            com.alliance.ssp.ad.t.i.a(nMExpressFeedAdImpl.w, nMExpressFeedAdImpl.l1, 8194, "渲染失败。");
        }
    }

    public class j implements i.a {
        public final /* synthetic */ Context a;

        public j(Context context) {
            this.a = context;
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Bitmap bitmap) throws JSONException, PackageManager.NameNotFoundException, IOException {
            NMExpressFeedAdImpl nMExpressFeedAdImpl;
            com.alliance.ssp.ad.n0.b bVar;
            View view;
            int i = com.alliance.ssp.ad.o0.l.a;
            ImageView imageView = new ImageView(this.a);
            imageView.setImageBitmap(bitmap);
            NMExpressFeedAdImpl.this.s();
            NMExpressFeedAdImpl nMExpressFeedAdImpl2 = NMExpressFeedAdImpl.this;
            if (nMExpressFeedAdImpl2.I0 == 4) {
                if (nMExpressFeedAdImpl2.p1.get(0) == null) {
                    NMExpressFeedAdImpl nMExpressFeedAdImpl3 = NMExpressFeedAdImpl.this;
                    if (nMExpressFeedAdImpl3.O0.e != 40) {
                        nMExpressFeedAdImpl3.a(3, (View) null, 200002, "模板信息流多图布局加载失败");
                    }
                    NMExpressFeedAdImpl.this.b(100006, "1", "多图布局失败");
                    return;
                }
                if (NMExpressFeedAdImpl.this.n1 != null) {
                    Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
                    NMExpressFeedAdImpl nMExpressFeedAdImpl4 = NMExpressFeedAdImpl.this;
                    nMExpressFeedAdImpl4.n1.a(nMExpressFeedAdImpl4.p1.get(0), com.alliance.ssp.ad.n0.d.a(bitmapCopy, 10.0f));
                }
                ((ViewGroup) NMExpressFeedAdImpl.this.p1.get(0)).addView(imageView);
                NMExpressFeedAdImpl nMExpressFeedAdImpl5 = NMExpressFeedAdImpl.this;
                nMExpressFeedAdImpl5.F0 = SHOWING_STATE.IMAGE;
                nMExpressFeedAdImpl5.d1 = true;
                NMExpressFeedAdImpl nMExpressFeedAdImpl6 = NMExpressFeedAdImpl.this;
                if (nMExpressFeedAdImpl6.c1) {
                    nMExpressFeedAdImpl6.a(4, nMExpressFeedAdImpl6.P0, 0, (String) null);
                    return;
                }
                return;
            }
            if (nMExpressFeedAdImpl2.o1 == null) {
                if (nMExpressFeedAdImpl2.O0.e != 40) {
                    nMExpressFeedAdImpl2.a(3, (View) null, 200002, "模板信息流布局加载失败");
                }
                NMExpressFeedAdImpl.this.b(100006, "1", "布局失败");
                return;
            }
            if (nMExpressFeedAdImpl2.n1 != null) {
                Bitmap bitmapCopy2 = bitmap.copy(bitmap.getConfig(), true);
                NMExpressFeedAdImpl nMExpressFeedAdImpl7 = NMExpressFeedAdImpl.this;
                nMExpressFeedAdImpl7.n1.a(nMExpressFeedAdImpl7.o1, com.alliance.ssp.ad.n0.d.a(bitmapCopy2, 10.0f));
            }
            ((ViewGroup) NMExpressFeedAdImpl.this.o1).addView(imageView);
            NMExpressFeedAdImpl nMExpressFeedAdImpl8 = NMExpressFeedAdImpl.this;
            nMExpressFeedAdImpl8.a(nMExpressFeedAdImpl8.o1, 4.0f);
            if (!NMExpressFeedAdImpl.this.m1.get(0).endsWith(PictureMimeType.GIF) && (bVar = (nMExpressFeedAdImpl = NMExpressFeedAdImpl.this).n1) != null && (view = bVar.v) != null) {
                ((ViewGroup) nMExpressFeedAdImpl.o1).addView(view);
            }
            NMExpressFeedAdImpl nMExpressFeedAdImpl9 = NMExpressFeedAdImpl.this;
            nMExpressFeedAdImpl9.F0 = SHOWING_STATE.IMAGE;
            nMExpressFeedAdImpl9.d1 = true;
            NMExpressFeedAdImpl nMExpressFeedAdImpl10 = NMExpressFeedAdImpl.this;
            if (nMExpressFeedAdImpl10.c1) {
                nMExpressFeedAdImpl10.a(4, nMExpressFeedAdImpl10.P0, 0, (String) null);
            }
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Exception exc) {
            Objects.toString(exc);
            int i = com.alliance.ssp.ad.o0.l.a;
            NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
            if (nMExpressFeedAdImpl.O0.e != 40) {
                nMExpressFeedAdImpl.a(3, (View) null, 200002, "模板信息流图片素材加载失败");
            }
            NMExpressFeedAdImpl.this.b(100006, "1", "加载素材失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (a("user", 1, false)) {
            d(1);
        }
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void b(MediaPlayer mediaPlayer) throws JSONException, PackageManager.NameNotFoundException, IOException {
        View view;
        View view2;
        try {
            this.X0 = true;
            Handler handler = this.T1;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            s();
            l("", "", this.h);
            int i2 = com.alliance.ssp.ad.o0.l.a;
            if (!this.W0) {
                this.W0 = true;
                this.d1 = true;
                if (this.c1) {
                    a(4, this.P0, 0, (String) null);
                }
            }
            if (this.u1 == null || this.o1 == null) {
                return;
            }
            if (this.n1 != null && mediaPlayer != null && mediaPlayer.getVideoWidth() < mediaPlayer.getVideoHeight()) {
                this.n1.a(this.o1, this.u1.a(1L));
            }
            if (this.u1.t.getParent() == null) {
                ((ViewGroup) this.o1).addView(this.u1.t);
            }
            a(this.o1, 4.0f);
            com.alliance.ssp.ad.n0.b bVar = this.n1;
            if (bVar == null || (view = bVar.v) == null) {
                return;
            }
            if (view.getParent() == null) {
                ((ViewGroup) this.o1).addView(this.n1.v);
            }
            this.F0 = SHOWING_STATE.VIDEO;
            View view3 = this.n1.s;
            if (view3 != null) {
                float f2 = 8.0f;
                int i3 = this.I0;
                if (i3 != 5 && i3 != 1) {
                    f2 = 11.0f;
                }
                ((ViewGroup) view3).removeAllViews();
                ((ViewGroup) this.n1.s).addView(this.u1.a(f2));
            }
            View view4 = this.n1.t;
            if (view4 != null) {
                ((ViewGroup) view4).removeAllViews();
                ViewGroup viewGroup = (ViewGroup) this.n1.t;
                VideoController videoController = this.u1;
                if (videoController.x == null) {
                    videoController.x = new SeekBar(videoController.c);
                }
                viewGroup.addView(videoController.r.a(videoController.x, "#2F80ED", "#F2F6F9"));
            }
            if (this.L0 || (view2 = this.n1.u) == null) {
                return;
            }
            ((ViewGroup) view2).removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) this.n1.u;
            VideoController videoController2 = this.u1;
            viewGroup2.addView(videoController2.r.a(new com.alliance.ssp.ad.video.b(videoController2, new h())));
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 026: ")), e2);
        }
    }

    public class i implements com.alliance.ssp.ad.p.a<SAAllianceEngineData> {
        public final /* synthetic */ Context a;

        public i(Context context) {
            this.a = context;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(SAAllianceEngineData sAAllianceEngineData) throws JSONException, PackageManager.NameNotFoundException, IOException {
            SAAllianceEngineData sAAllianceEngineData2 = sAAllianceEngineData;
            if (sAAllianceEngineData2 == null) {
                NMExpressFeedAdImpl.a(NMExpressFeedAdImpl.this, 8193, "002", "无广告填充，请联系技术进行排查。");
                return;
            }
            try {
                List<SAAllianceAdData> data = sAAllianceEngineData2.getData();
                if (data == null) {
                    NMExpressFeedAdImpl.a(NMExpressFeedAdImpl.this, sAAllianceEngineData2.getCode(), "001", sAAllianceEngineData2.getMessage());
                    return;
                }
                if (data.size() > 0 && sAAllianceEngineData2.getData() != null && !sAAllianceEngineData2.getData().isEmpty()) {
                    for (SAAllianceAdData sAAllianceAdData : data) {
                        if (sAAllianceAdData.getLoadtype() == 1) {
                            NMExpressFeedAdImpl.this.a(8195, "001", "广告渲染方式和代码位ID类型不符，请联系运营排查。");
                            NMExpressFeedAdImpl nMExpressFeedAdImpl = NMExpressFeedAdImpl.this;
                            com.alliance.ssp.ad.t.i.a(nMExpressFeedAdImpl.w, nMExpressFeedAdImpl.l1, 8195, "广告渲染方式和代码位ID类型不符，请联系运营排查。");
                            Handler handler = NMExpressFeedAdImpl.this.C1;
                            if (handler != null) {
                                handler.removeCallbacksAndMessages(null);
                                NMExpressFeedAdImpl.this.C1 = null;
                                return;
                            }
                            return;
                        }
                        sAAllianceAdData.setDeadlineTime(NMExpressFeedAdImpl.this.E.a(sAAllianceAdData.getCacheTimeout()));
                        sAAllianceAdData.setPriceD(NMExpressFeedAdImpl.this.E.a(sAAllianceAdData.getPrice()));
                        NMExpressFeedAdImpl nMExpressFeedAdImpl2 = NMExpressFeedAdImpl.this;
                        com.alliance.ssp.ad.t.h hVar = nMExpressFeedAdImpl2.E;
                        if (hVar != null) {
                            hVar.a(this.a, nMExpressFeedAdImpl2.l1, sAAllianceAdData.getWaitLoadTimeout());
                            if (sAAllianceAdData.isNeedCache()) {
                                sAAllianceAdData.setRequestid(NMExpressFeedAdImpl.this.w);
                                NMExpressFeedAdImpl nMExpressFeedAdImpl3 = NMExpressFeedAdImpl.this;
                                nMExpressFeedAdImpl3.E.a(this.a, sAAllianceAdData, nMExpressFeedAdImpl3.l1);
                            }
                        }
                        NMExpressFeedAdImpl nMExpressFeedAdImpl4 = NMExpressFeedAdImpl.this;
                        if (!nMExpressFeedAdImpl4.F1) {
                            Handler handler2 = nMExpressFeedAdImpl4.C1;
                            if (handler2 != null) {
                                handler2.removeCallbacksAndMessages(null);
                                NMExpressFeedAdImpl.this.C1 = null;
                            }
                            NMExpressFeedAdImpl nMExpressFeedAdImpl5 = NMExpressFeedAdImpl.this;
                            NMExpressFeedAdImpl.a(nMExpressFeedAdImpl5, nMExpressFeedAdImpl5.D1, sAAllianceAdData);
                        }
                    }
                    return;
                }
                NMExpressFeedAdImpl.a(NMExpressFeedAdImpl.this, sAAllianceEngineData2.getCode(), "003", sAAllianceEngineData2.getMessage());
            } catch (Exception e) {
                e.toString();
                int i = com.alliance.ssp.ad.o0.l.a;
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 001: ")), e);
                NMExpressFeedAdImpl.this.a(8194, "001", "渲染失败。");
                NMExpressFeedAdImpl nMExpressFeedAdImpl6 = NMExpressFeedAdImpl.this;
                com.alliance.ssp.ad.t.i.a(nMExpressFeedAdImpl6.w, nMExpressFeedAdImpl6.l1, 8194, "渲染失败。");
            }
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            NMExpressFeedAdImpl.a(NMExpressFeedAdImpl.this, i, "004", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        if (this.M0 == 0) {
            this.x = "user";
            if (a("user", 0, false)) {
                d(1);
                return;
            }
            return;
        }
        if (this.g1 == 1) {
            a("user", 0, false);
        }
    }

    @Override // com.alliance.ssp.ad.t.a
    public void c() throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
            if (contextA != null && !com.alliance.ssp.ad.r.f.h.contains("nmssp_download")) {
                com.alliance.ssp.ad.r.f.h = contextA.getExternalCacheDir() + "/nmssp_download/";
            }
            com.alliance.ssp.ad.o0.i.a(contextA, com.alliance.ssp.ad.r.f.h, this.z0);
            h("", "", this.h);
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 030: ")), e2);
        }
    }

    public final void a(SAAllianceAdParams sAAllianceAdParams) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i2 = com.alliance.ssp.ad.o0.l.a;
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        this.J0 = this.g.getImageAcceptedWidth();
        this.K0 = this.g.getImageAcceptedHeight();
        this.L0 = this.g.getMute();
        int i3 = f.a.a[this.g.getTheme().ordinal()];
        if (i3 == 1) {
            com.alliance.ssp.ad.n0.f.g = com.alliance.ssp.ad.n0.f.e;
        } else if (i3 == 2) {
            com.alliance.ssp.ad.n0.f.g = com.alliance.ssp.ad.n0.f.f;
        } else if (i3 == 3 && contextA != null) {
            if ((contextA.getResources().getConfiguration().uiMode & 48) == 32) {
                com.alliance.ssp.ad.n0.f.g = com.alliance.ssp.ad.n0.f.f;
            } else {
                com.alliance.ssp.ad.n0.f.g = com.alliance.ssp.ad.n0.f.e;
            }
        }
        if (this.J0 <= 0) {
            a(FragmentTransaction.TRANSIT_FRAGMENT_FADE, "001", "请求失败，请检查是否设置广告宽度。");
            com.alliance.ssp.ad.t.i.a(FragmentTransaction.TRANSIT_FRAGMENT_FADE, "请求失败，请检查是否设置广告宽度。");
            return;
        }
        try {
            SAAllianceAdData sAAllianceAdDataA = a(contextA, this.l1);
            this.D1 = sAAllianceAdDataA;
            if (sAAllianceAdDataA != null) {
                long jA = this.E.a(contextA, this.l1);
                this.D1.getRequestid();
                this.D1.getPriceD();
                com.alliance.ssp.ad.v.e eVar = new com.alliance.ssp.ad.v.e(this, Looper.getMainLooper());
                this.C1 = eVar;
                eVar.sendEmptyMessageDelayed(0, jA);
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 002: ")), e2);
        }
        System.currentTimeMillis();
        this.E0 = EXPRESS_STATE.REQUESTING;
        sAAllianceAdParams.setSpostype(3);
        com.alliance.ssp.ad.http.action.b bVar = new com.alliance.ssp.ad.http.action.b(sAAllianceAdParams, this.w, this.C0, 0, new i(contextA), BaseNetAction.Method.POST);
        String str = this.w;
        String str2 = this.l1;
        String.valueOf(this.K0);
        com.alliance.ssp.ad.t.i.a(str, str2, String.valueOf(this.J0), "0", "原生-模版渲染");
        bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i2 = com.alliance.ssp.ad.o0.l.a;
        try {
            com.alliance.ssp.ad.r.i.a().a(this.m1.get(0), new j(context));
            if (this.m1.get(0).endsWith(PictureMimeType.GIF)) {
                String str = UUID.randomUUID().toString().replace("-", "") + "aaaccc";
                HashMap<Integer, String> map = this.G1.get(0);
                if (map != null) {
                    map.put(1, "true");
                    map.put(2, "download");
                }
                com.alliance.ssp.ad.o0.j.a().a(context, this.m1.get(0), str, new k(this, map, str));
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 007: ")), e2);
        }
    }

    public final void a(Context context, View view, View view2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (view != null) {
            try {
                TextView textView = new TextView(context);
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                textView.setTextSize(17.0f);
                int i2 = this.J0;
                if (i2 <= 180) {
                    textView.setTextSize(11.0f);
                } else if (i2 <= 240) {
                    textView.setTextSize(13.0f);
                } else if (i2 <= 300) {
                    textView.setTextSize(15.0f);
                }
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setMaxLines(2);
                textView.setText(this.q1);
                textView.setTextColor(Color.parseColor(com.alliance.ssp.ad.n0.f.g.c));
                textView.setGravity(BadgeDrawable.BOTTOM_START);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 16;
                ((ViewGroup) view).addView(textView, layoutParams);
            } catch (Exception e2) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 012: ")), e2);
            }
        }
        if (view2 != null) {
            try {
                if (this.f1.getApkname() == null || this.f1.getApkname().isEmpty()) {
                    return;
                }
                TextView textView2 = new TextView(context);
                textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                textView2.setTextSize(12.0f);
                int i3 = this.J0;
                if (i3 <= 180) {
                    textView2.setTextSize(9.0f);
                } else if (i3 <= 240) {
                    textView2.setTextSize(10.0f);
                } else if (i3 <= 300) {
                    textView2.setTextSize(11.0f);
                }
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setMaxLines(1);
                textView2.setTextColor(Color.parseColor(com.alliance.ssp.ad.n0.f.g.d));
                textView2.setText(this.f1.getApkname());
                textView2.setGravity(BadgeDrawable.BOTTOM_START);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.gravity = 16;
                ((ViewGroup) view2).addView(textView2, layoutParams2);
            } catch (Exception e3) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e3, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 013: ")), e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i2, boolean z) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        d(1);
        if (i2 == 1) {
            int i3 = com.alliance.ssp.ad.o0.l.a;
            if (a("user", 1, z)) {
                d(1);
                return;
            }
            return;
        }
        if (i2 == 2) {
            int i4 = com.alliance.ssp.ad.o0.l.a;
            D();
            a("", "", this.h);
            this.F.a(true);
            this.r = 3;
            return;
        }
        if (i2 == 3) {
            int i5 = com.alliance.ssp.ad.o0.l.a;
            C();
            a("", "", this.h);
            this.r = 1;
            this.F.a(false);
            return;
        }
        if (i2 == 4) {
            int i6 = com.alliance.ssp.ad.o0.l.a;
            c();
            w();
            a("", "", this.h);
            a(0, (View) null, 0, (String) null);
            return;
        }
        if (i2 != 5) {
            return;
        }
        int i7 = com.alliance.ssp.ad.o0.l.a;
        if (a("user", 1, z)) {
            d(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i2 = com.alliance.ssp.ad.o0.l.a;
        try {
            if (this.A <= 0.0f && b()) {
                if (this.M0 == 1) {
                    a(this.n1.k, "1");
                } else {
                    a(this.P0, (String) null);
                }
                if (a("close_button", 0, false)) {
                    this.B = true;
                    c(2);
                    d(1);
                    return;
                }
            }
            a(2, (View) null, 0, (String) null);
            p();
            S();
            d(4);
            com.alliance.ssp.ad.c0.b bVar = this.B1;
            if (bVar != null) {
                bVar.a();
                this.B1 = null;
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 016: ")), e2);
        }
    }

    public final void a(Context context, View view) {
        if (view == null || this.f1.getIconurl() == null || this.f1.getIconurl().isEmpty()) {
            return;
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        com.alliance.ssp.ad.r.i.a().a(this.f1.getIconurl(), new a(imageView, view, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int[] iArr) {
        if (this.A1 || this.q || this.E0 != EXPRESS_STATE.SHOWING || !G()) {
            return;
        }
        this.q = true;
        this.C = iArr;
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (a("shake", 0, false)) {
            d(1);
        } else {
            this.q = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d2, double d3) throws JSONException, PackageManager.NameNotFoundException, IOException {
        View view;
        com.alliance.ssp.ad.n0.b bVar;
        try {
            synchronized (this.M1) {
                if (!this.L1 && ((float) d2) >= this.w1) {
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.I();
                        }
                    });
                    B();
                    a(1, (View) null, 0, (String) null);
                    this.L1 = true;
                }
            }
            if (!this.O1 && d2 > 0.0d && (bVar = this.n1) != null) {
                this.O1 = true;
                com.alliance.ssp.ad.l.c cVar = bVar.A;
                if (cVar != null) {
                    cVar.b();
                }
            }
            if (!this.B) {
                float f2 = this.A;
                if (f2 > 0.0f && ((float) d2) == f2 && b() && G()) {
                    com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.J();
                        }
                    });
                }
            }
            if (!this.A1 && ((int) d2) == 3 && this.N0 == 2 && (view = this.s1) != null && view.getVisibility() == 0 && this.F0 == SHOWING_STATE.INTERACTIVE) {
                com.alliance.ssp.ad.o0.n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.K();
                    }
                });
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 021: ")), e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r11, int r12, boolean r13) throws java.lang.IllegalStateException, org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException, java.security.NoSuchAlgorithmException, java.io.IOException, java.security.InvalidKeyException {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl.a(java.lang.String, int, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Intent intent) {
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("SA_TARGET_YT_WEB_ACTIVITY_FINISHED")) {
            return;
        }
        d(3);
        this.S1.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, String str, View view) {
        SAExpressFeedAdInteractionListener sAExpressFeedAdInteractionListener;
        synchronized (com.alliance.ssp.ad.impl.expressfeed.b.h) {
            try {
                com.alliance.ssp.ad.impl.expressfeed.b bVar = this.O0;
                if (bVar != null && (sAExpressFeedAdInteractionListener = bVar.c) != null) {
                    if (i2 != 0) {
                        if (i2 == 1) {
                            sAExpressFeedAdInteractionListener.onAdShow();
                        } else if (i2 == 2) {
                            sAExpressFeedAdInteractionListener.onAdClose();
                        } else if (i2 == 3) {
                            sAExpressFeedAdInteractionListener.onRenderFail(i3, str);
                        } else if (i2 == 4) {
                            SAAllianceContainerView sAAllianceContainerView = new SAAllianceContainerView(com.alliance.ssp.ad.o0.b.a(this.f), this.D0);
                            sAAllianceContainerView.addView(view);
                            this.O0.c.onRenderSuccess(sAAllianceContainerView);
                        }
                    } else if (this.S0 != 1) {
                        sAExpressFeedAdInteractionListener.onAdClick();
                        x();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a() {
        this.Y0 = false;
        if (this.R1) {
            return;
        }
        this.R1 = true;
        b(this.h);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a(int i2) {
        if (i2 >= 25 && !this.Z1) {
            this.Z1 = true;
            g("", "", this.h);
        }
        if (i2 >= 50 && !this.a2) {
            this.a2 = true;
            y();
            i("", "", this.h);
        }
        if (i2 < 75 || this.b2) {
            return;
        }
        this.b2 = true;
        n("", "", this.h);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a(MediaPlayer mediaPlayer) {
        int i2 = com.alliance.ssp.ad.o0.l.a;
        this.w0 = false;
        if (this.R1) {
            p("", "", this.h);
            this.Y0 = true;
            this.R1 = false;
        }
        if (this.Z0 && this.y1) {
            View view = this.s1;
            if (view == null || view.getVisibility() != 0) {
                if (this.F0 == SHOWING_STATE.INTERACTIVE) {
                    this.F0 = SHOWING_STATE.VIDEO;
                }
                U();
                return;
            }
            return;
        }
        if (this.y1) {
            return;
        }
        View view2 = this.s1;
        if (view2 == null || view2.getVisibility() != 0) {
            if (this.F0 == SHOWING_STATE.INTERACTIVE) {
                this.F0 = SHOWING_STATE.VIDEO;
            }
            U();
        }
    }

    public final void a(View view, float f2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            ((ViewGroup) view).addView(new com.alliance.ssp.ad.n0.e(com.alliance.ssp.ad.o0.b.a(this.f), f2), new FrameLayout.LayoutParams(-1, -1));
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMExpressFeedAdImpl 033: ")), e2);
        }
    }
}
