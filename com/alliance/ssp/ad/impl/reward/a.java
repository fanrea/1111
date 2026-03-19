package com.alliance.ssp.ad.impl.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.YTAdInfo;
import com.alliance.ssp.ad.api.reward.SARewardVideoAdInteractionListener;
import com.alliance.ssp.ad.api.reward.SARewardVideoAdLoadListener;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.RewardInfo;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import com.alliance.ssp.ad.bean.SARewardVerifyData;
import com.alliance.ssp.ad.d0.g;
import com.alliance.ssp.ad.http.action.BaseNetAction;
import com.alliance.ssp.ad.l.l;
import com.alliance.ssp.ad.m0.c;
import com.alliance.ssp.ad.o0.b;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.o0.q;
import com.alliance.ssp.ad.p.d;
import com.alliance.ssp.ad.r.c;
import com.alliance.ssp.ad.t.h;
import com.alliance.ssp.ad.t.i;
import com.alliance.ssp.ad.video.VideoController;
import com.alliance.ssp.ad.video.f;
import com.alliance.ssp.ad.y.e;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: NMRewardVideoAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends com.alliance.ssp.ad.y.a implements f.a {
    public static Map<String, VideoController> g1 = new HashMap();
    public String D0;
    public boolean E0;
    public boolean F0;
    public boolean G0;
    public boolean H0;
    public int I0;
    public boolean J0;
    public com.alliance.ssp.ad.y.f K0;
    public Activity L0;
    public Material M0;
    public String N0;
    public Handler O0;
    public boolean P0;
    public long Q0;
    public int R0;
    public int S0;
    public String T0;
    public int U0;
    public VideoController V0;
    public Handler W0;
    public SAAllianceAdData X0;
    public String Y0;
    public boolean Z0;
    public l a1;
    public FrameLayout b1;
    public int c1;
    public int d1;
    public com.alliance.ssp.ad.m0.a e1;
    public boolean f1;

    public a(int i, WeakReference<Activity> weakReference, SAAllianceAdParams sAAllianceAdParams, SARewardVideoAdLoadListener sARewardVideoAdLoadListener, g gVar) {
        super(i, weakReference, "", "", sAAllianceAdParams, sARewardVideoAdLoadListener, null, gVar);
        this.D0 = "delivery/request/getad/serverReward";
        this.E0 = false;
        this.F0 = false;
        this.G0 = false;
        this.H0 = true;
        this.I0 = 1;
        this.J0 = false;
        this.K0 = null;
        this.P0 = false;
        this.Q0 = 0L;
        this.R0 = 0;
        this.S0 = 0;
        this.Z0 = false;
        this.a1 = null;
        this.b1 = null;
        this.c1 = 0;
        this.d1 = 0;
        this.f1 = false;
        gVar.d = this;
        this.T0 = sAAllianceAdParams.getPosId();
        a(sAAllianceAdParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, RewardInfo rewardInfo) {
        SARewardVideoAdInteractionListener sARewardVideoAdInteractionListener;
        synchronized (com.alliance.ssp.ad.y.f.d) {
            try {
                com.alliance.ssp.ad.y.f fVar = this.K0;
                if (fVar != null && (sARewardVideoAdInteractionListener = fVar.c) != null) {
                    if (i == 0) {
                        sARewardVideoAdInteractionListener.onAdShow();
                    } else if (i == 1) {
                        sARewardVideoAdInteractionListener.onAdClose();
                    } else if (i == 2) {
                        sARewardVideoAdInteractionListener.onVideoComplete();
                    } else if (i == 3) {
                        sARewardVideoAdInteractionListener.onVideoError();
                    } else if (i != 4) {
                        if (i == 5) {
                            sARewardVideoAdInteractionListener.onRewardVerify(rewardInfo);
                            this.h.setRewardValid(this.f1);
                            new com.alliance.ssp.ad.d0.f().a(3, 0, this.h, this.w, "", 0);
                        }
                    } else if (this.d1 != 1) {
                        sARewardVideoAdInteractionListener.onAdClick();
                        x();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void E() throws JSONException, PackageManager.NameNotFoundException, IOException {
        int i = com.alliance.ssp.ad.o0.l.a;
        try {
            t();
            Context contextA = b.a(this.f);
            if (contextA != null && (!(contextA instanceof Activity) || !((Activity) contextA).isFinishing())) {
                View viewInflate = LayoutInflater.from(contextA).inflate(R.layout.layout_nmssp_reward_video_verify_dialog, (ViewGroup) null, false);
                if (viewInflate != null) {
                    this.b1 = (FrameLayout) viewInflate.findViewById(R.id.fl_nm_reward_video_view);
                }
                VideoController videoController = new VideoController(contextA, this.N0, this.b1, false, false, this.H0, this);
                this.V0 = videoController;
                this.p = videoController;
                videoController.D = false;
                return;
            }
            a(8198, "001", "渲染失败，请检查Activity状态。");
            i.a(this.w, this.T0, 8198, "渲染失败，请检查Activity状态。");
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMRewardVideoAdImpl 002: ")), e);
        }
    }

    public void F() {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (this.K0 != null) {
            if (this.c1 != 1) {
                a(5, (RewardInfo) null);
                return;
            }
            SARewardVerifyData sARewardVerifyData = new SARewardVerifyData();
            sARewardVerifyData.setAppId(com.alliance.ssp.ad.o0.i.a);
            sARewardVerifyData.setExtraInfo(this.g.getExtraInfo());
            sARewardVerifyData.setPrice(this.s);
            sARewardVerifyData.setPlacementId(this.T0);
            sARewardVerifyData.setUserId(this.g.getUserId());
            sARewardVerifyData.setTransId(this.w);
            d dVar = new d(new Gson().toJson(sARewardVerifyData), 1500, 1500, "POST", this.L0, this.D0, new com.alliance.ssp.ad.y.d(this));
            new com.alliance.ssp.ad.d0.f().a(3, 2, this.h, this.w, "", 0);
            Runnable runnable = dVar.a;
            if (runnable != null) {
                n.d.a.execute(runnable);
            }
        }
    }

    public final void G() {
        Context contextA = b.a(this.f);
        if (contextA == null) {
            return;
        }
        com.alliance.ssp.ad.m0.a aVar = new com.alliance.ssp.ad.m0.a(new c() { // from class: com.alliance.ssp.ad.impl.reward.a$$ExternalSyntheticLambda1
            @Override // com.alliance.ssp.ad.m0.c
            public final void a(Object obj) {
                this.f$0.a((Intent) obj);
            }
        }, contextA);
        this.e1 = aVar;
        aVar.b("SA_TARGET_YT_WEB_ACTIVITY_FINISHED");
    }

    public void H() {
        com.alliance.ssp.ad.m0.a aVar = this.e1;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void I() {
        a("", "", this.h);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a() {
    }

    public final void a(final int i, final RewardInfo rewardInfo) {
        n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.reward.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(i, rewardInfo);
            }
        });
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void b(int i) {
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void onError(MediaPlayer mediaPlayer, int i, int i2) {
        int i3 = com.alliance.ssp.ad.o0.l.a;
        a(3, (RewardInfo) null);
        b(100006, "1", "加载素材失败, error.what = " + i + ", error.extra = " + i2);
        q("", "", this.h);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        VideoController videoController;
        int i3 = com.alliance.ssp.ad.o0.l.a;
        if (i != 3 || (videoController = this.V0) == null) {
            return;
        }
        videoController.b(false);
    }

    public static RewardInfo a(a aVar, String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
        RewardInfo rewardInfo;
        aVar.getClass();
        if (str != null && !str.isEmpty()) {
            try {
                rewardInfo = (RewardInfo) new Gson().fromJson(str, new e(aVar).getType());
                aVar.f1 = rewardInfo.isValid();
            } catch (Exception e) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, new StringBuilder().append("NMRewardVideoAdImpl ").append("004").append(": ")), e);
                return null;
            }
        } else {
            rewardInfo = new RewardInfo();
            rewardInfo.setValid(false);
            rewardInfo.setExtraInfo(aVar.g.getExtraInfo());
            rewardInfo.setTransId(aVar.T0);
            rewardInfo.setUserId(aVar.g.getUserId());
            rewardInfo.setTransId(aVar.h.getRequestid());
        }
        aVar.f1 = rewardInfo.isValid();
        return rewardInfo;
    }

    public static void a(final a aVar, SAAllianceAdData sAAllianceAdData, SAAllianceAdData sAAllianceAdData2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        aVar.getClass();
        try {
            if (sAAllianceAdData == null) {
                aVar.h = sAAllianceAdData2;
                aVar.Y0 = aVar.w;
            } else if (sAAllianceAdData2 != null && sAAllianceAdData.getPriceD() <= sAAllianceAdData2.getPriceD()) {
                aVar.h = sAAllianceAdData2;
                aVar.Y0 = aVar.w;
            } else {
                aVar.h = sAAllianceAdData;
                aVar.Y0 = sAAllianceAdData.getRequestid();
                aVar.h.setParentCrequestid(sAAllianceAdData.getRequestid());
            }
            aVar.h.setCrequestid(aVar.w);
            aVar.E.a(aVar.T0, aVar.Y0);
            int i = com.alliance.ssp.ad.o0.l.a;
            aVar.h.setSpostype(Integer.parseInt(aVar.j0));
            String tagCode = aVar.h.getTagCode();
            if (tagCode != null && !tagCode.isEmpty()) {
                aVar.o = tagCode;
            }
            String price = aVar.h.getPrice();
            aVar.s = price;
            if (price == null || price.isEmpty()) {
                aVar.s = "-1";
            }
            int rdirection = aVar.h.getRdirection();
            aVar.I0 = rdirection;
            if (rdirection == 2) {
                aVar.T = "" + Math.max(SAAllianceAdParams.Screen_Width, SAAllianceAdParams.Screen_Height);
                aVar.U = "" + Math.min(SAAllianceAdParams.Screen_Width, SAAllianceAdParams.Screen_Height);
            } else {
                aVar.T = "" + Math.min(SAAllianceAdParams.Screen_Width, SAAllianceAdParams.Screen_Height);
                aVar.U = "" + Math.max(SAAllianceAdParams.Screen_Width, SAAllianceAdParams.Screen_Height);
            }
            aVar.c1 = aVar.h.getVerifyWithServer();
            aVar.d1 = aVar.h.getClickCallbackSwitch();
            if (aVar.h.getInteraction() != null) {
                int i2 = aVar.h.getInteraction().clickArea;
                aVar.S0 = i2;
                if (i2 == -1) {
                    aVar.S0 = 0;
                }
            }
            if (aVar.h.getMaterial() == null) {
                aVar.a(8196, "001", "广告素材为空，请联系运营检查代码位ID配置情况。01");
                i.a(aVar.w, aVar.T0, 8196, "广告素材为空，请联系运营检查代码位ID配置情况。01");
                return;
            }
            Material material = aVar.h.getMaterial();
            aVar.M0 = material;
            aVar.N0 = material.getVideourl();
            SAAllianceAdParams sAAllianceAdParams = aVar.g;
            if (sAAllianceAdParams != null && sAAllianceAdParams.getUserId() != null && !aVar.g.getUserId().isEmpty()) {
                aVar.h.setUserId(aVar.g.getUserId());
            }
            com.alliance.ssp.ad.y.f fVar = new com.alliance.ssp.ad.y.f();
            aVar.K0 = fVar;
            fVar.a = aVar.s;
            fVar.b = new YTAdInfo(new ArrayList<String>() { // from class: com.alliance.ssp.ad.impl.reward.NMRewardVideoAdImpl$3
                {
                    add(this.this$0.N0);
                }
            });
            aVar.a(aVar.K0);
            i.a(aVar.w, aVar.g.getPosId());
            aVar.Z0 = true;
            System.currentTimeMillis();
            aVar.E();
        } catch (Exception e) {
            e.toString();
            int i3 = com.alliance.ssp.ad.o0.l.a;
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMRewardVideoAdImpl 001: ")), e);
            aVar.a(8194, "001", "渲染失败。");
            i.a(aVar.w, aVar.T0, 8194, "渲染失败。");
        }
    }

    public void b(Activity activity) {
        int i = com.alliance.ssp.ad.o0.l.a;
        a(3, (RewardInfo) null);
        activity.finish();
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void b(MediaPlayer mediaPlayer) {
        String str = this.N0;
        if (str != null) {
            ((HashMap) g1).put(str, this.V0);
        }
        this.V0.D = false;
        DisplayMetrics displayMetrics = b.a(this.f).getResources().getDisplayMetrics();
        int iMax = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int iMin = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        boolean z = mediaPlayer.getVideoHeight() < mediaPlayer.getVideoWidth();
        this.J0 = z;
        if (this.I0 != 2) {
            this.V0.a(iMin, iMax);
        } else if (!z) {
            this.V0.a((iMin * 9) / 16, iMin);
        } else {
            this.V0.a(iMax, iMin);
        }
        mediaPlayer.setVideoScalingMode(2);
        s();
        l("", "", this.h);
        this.Q0 = System.currentTimeMillis() - this.Q0;
        System.currentTimeMillis();
        int i = com.alliance.ssp.ad.o0.l.a;
    }

    /* compiled from: NMRewardVideoAdImpl.java */
    /* renamed from: com.alliance.ssp.ad.impl.reward.a$a, reason: collision with other inner class name */
    public class C0089a implements com.alliance.ssp.ad.p.a<SAAllianceEngineData> {
        public final /* synthetic */ Context a;

        public C0089a(Context context) {
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
                        h hVar = aVar.E;
                        if (hVar != null) {
                            hVar.a(this.a, aVar.T0, sAAllianceAdData.getWaitLoadTimeout());
                            if (sAAllianceAdData.isNeedCache()) {
                                sAAllianceAdData.setRequestid(a.this.w);
                                a aVar2 = a.this;
                                aVar2.E.a(this.a, sAAllianceAdData, aVar2.T0);
                            }
                        }
                        a aVar3 = a.this;
                        if (!aVar3.Z0) {
                            Handler handler = aVar3.W0;
                            if (handler != null) {
                                handler.removeCallbacksAndMessages(null);
                                a.this.W0 = null;
                            }
                            a aVar4 = a.this;
                            a.a(aVar4, aVar4.X0, sAAllianceAdData);
                        }
                    }
                    return;
                }
                a.a(a.this, sAAllianceEngineData2.getCode(), "003", sAAllianceEngineData2.getMessage());
            } catch (Exception e) {
                e.toString();
                int i = com.alliance.ssp.ad.o0.l.a;
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMRewardVideoAdImpl 001: ")), e);
                a.this.a(8194, "001", "渲染失败。");
                a aVar5 = a.this;
                i.a(aVar5.w, aVar5.T0, 8194, "渲染失败。");
            }
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            a.a(a.this, i, "004", str);
        }
    }

    public final void a(SAAllianceAdParams sAAllianceAdParams) {
        System.currentTimeMillis();
        int i = com.alliance.ssp.ad.o0.l.a;
        Context contextA = b.a(this.f);
        SAAllianceAdData sAAllianceAdDataA = a(contextA, this.T0);
        this.X0 = sAAllianceAdDataA;
        if (sAAllianceAdDataA != null) {
            long jA = this.E.a(contextA, this.T0);
            this.X0.getRequestid();
            this.X0.getPriceD();
            com.alliance.ssp.ad.y.b bVar = new com.alliance.ssp.ad.y.b(this, Looper.getMainLooper());
            this.W0 = bVar;
            bVar.sendEmptyMessageDelayed(0, jA);
        }
        this.Q0 = System.currentTimeMillis();
        sAAllianceAdParams.getPosId();
        SharedPreferences sharedPreferences = q.a().a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.clear();
            editorEdit.commit();
        }
        this.e0 = "100";
        sAAllianceAdParams.setImageAcceptedWidth(SAAllianceAdParams.Screen_Width);
        sAAllianceAdParams.setImageAcceptedHeight(SAAllianceAdParams.Screen_Height);
        this.H0 = sAAllianceAdParams.getMute();
        sAAllianceAdParams.setSpostype(6);
        com.alliance.ssp.ad.http.action.b bVar2 = new com.alliance.ssp.ad.http.action.b(sAAllianceAdParams, this.w, this.C0, 0, new C0089a(contextA), BaseNetAction.Method.POST);
        i.a(this.w, this.T0, null, "0", "激励视频");
        bVar2.a();
    }

    public static void a(a aVar, int i, String str, String str2) {
        Handler handler;
        if (aVar.X0 != null && (handler = aVar.W0) != null) {
            handler.removeCallbacksAndMessages(null);
            aVar.W0.sendEmptyMessage(0);
        } else {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            aVar.a(i, str, str2);
            i.a(aVar.w, aVar.g.getPosId(), i, str2);
        }
    }

    public boolean a(Activity activity, int i, c.b bVar) {
        boolean zA;
        this.D = i == 1;
        int i2 = com.alliance.ssp.ad.o0.l.a;
        this.f = new WeakReference<>(activity);
        Material material = this.M0;
        if (material != null) {
            this.U0 = material.getLdptype();
        }
        if (this.U0 == 1) {
            zA = a(this.h.getMaterial(), this.h, false, (c.b) null, (com.alliance.ssp.ad.c0.a) null);
        } else {
            zA = a(this.h.getMaterial(), this.h, true);
        }
        if (zA) {
            this.u = true;
            if (this.K0 != null) {
                a(4, (RewardInfo) null);
                G();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Intent intent) {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("SA_TARGET_YT_WEB_ACTIVITY_FINISHED")) {
            return;
        }
        l lVar = this.a1;
        if (lVar != null) {
            lVar.c();
        }
        this.e1.a();
    }

    public void a(Activity activity) {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (this.K0 != null) {
            a(1, (RewardInfo) null);
            H();
        }
        activity.finish();
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a(int i) {
        if (i >= 25 && !this.E0) {
            this.E0 = true;
            g("", "", this.h);
        }
        if (i >= 50 && !this.F0) {
            this.F0 = true;
            y();
            i("", "", this.h);
        }
        if (i < 75 || this.G0) {
            return;
        }
        this.G0 = true;
        n("", "", this.h);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a(MediaPlayer mediaPlayer) {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (this.P0) {
            return;
        }
        this.P0 = true;
        a(2, (RewardInfo) null);
        if (this.F0) {
            p("", "", this.h);
        }
    }
}
