package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.h;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.j.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends com.kwad.components.core.n.a {
    public IAdLiveOfflineView fq;
    public boolean kz;
    public boolean lb;
    public AdResultData mAdResultData;
    public com.kwad.components.ad.reward.e.d mAdRewardStepListener;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public boolean mCheckExposureResult;
    private Handler mHandler;
    public long mPageEnterTime;
    public JSONObject mReportExtData;
    private boolean mRewardVerifyCalled;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public bw mTimerHelper;
    public KsVideoPlayConfig mVideoPlayConfig;
    public boolean on;
    private final PriorityQueue<com.kwad.components.ad.reward.e.g> tA;
    public final List<com.kwad.components.ad.reward.k.a> tB;
    private final List<s> tC;
    private final List<com.kwad.components.ad.reward.m.c> tD;
    public Set<com.kwad.components.ad.reward.e.e> tE;
    private com.kwad.components.core.webview.tachikoma.f.a tF;
    private boolean tG;
    private boolean tH;
    public boolean tI;
    public boolean tJ;
    public boolean tK;
    public boolean tL;
    private boolean tM;
    public boolean tN;
    public boolean tO;
    public List<Integer> tP;
    public int tQ;
    public int tR;
    public int tS;
    public boolean tT;
    public com.kwad.components.ad.reward.n.p tU;
    public boolean tV;
    private PlayableSource tW;
    private boolean tX;
    public long tY;
    private List<DialogInterface.OnDismissListener> tZ;
    public boolean ts;
    public com.kwad.components.ad.reward.e.b tt;
    public com.kwad.components.ad.reward.m.e tu;
    public com.kwad.components.core.playable.a tv;
    public RewardActionBarControl tw;
    public j tx;
    public com.kwad.components.ad.l.a ty;
    public d tz;
    public com.kwad.components.ad.reward.e.o ua;
    public boolean ub;
    public com.kwad.components.ad.reward.l.b.a uc;
    public com.kwad.components.ad.reward.l.a.a ud;
    public int ue;
    private int uf;
    public long ug;
    public long uh;
    public boolean ui;
    private boolean uj;
    private boolean uk;
    public boolean ul;
    public boolean um;
    public LoadStrategy un;
    private RewardRenderResult uo;
    private List<a> up;
    private List<b> uq;
    private List<a.InterfaceC0474a> ur;

    public interface a {
        void hh();

        void hi();

        void hj();

        void hk();
    }

    public interface b {
        boolean interceptPlayCardResume();
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.s(adResultData);
    }

    public g(com.kwad.components.core.n.b<?> bVar) {
        super(bVar);
        this.ts = false;
        this.tA = new PriorityQueue<>();
        this.tB = new CopyOnWriteArrayList();
        this.tC = new CopyOnWriteArrayList();
        this.tD = new CopyOnWriteArrayList();
        this.tE = new HashSet();
        this.tG = false;
        this.tH = false;
        this.tJ = false;
        this.tK = false;
        this.tL = false;
        this.tM = false;
        this.tN = false;
        this.mRewardVerifyCalled = false;
        this.tO = false;
        this.tP = new ArrayList();
        this.mCheckExposureResult = true;
        this.tQ = 1;
        this.tR = 1;
        this.tS = 0;
        this.tT = false;
        this.tV = false;
        this.tW = null;
        this.tX = false;
        this.lb = false;
        this.tZ = new CopyOnWriteArrayList();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.ub = false;
        this.uf = 2;
        this.uj = false;
        this.uk = false;
        this.ul = false;
        this.um = false;
        this.un = LoadStrategy.FULL_TK;
        this.up = new CopyOnWriteArrayList();
        this.uq = new CopyOnWriteArrayList();
        this.ur = new CopyOnWriteArrayList();
        this.Th.add(new com.kwad.components.core.n.a.a() { // from class: com.kwad.components.ad.reward.g.1
            @Override // com.kwad.components.core.n.a.a
            public final void hc() {
                g.this.gG();
            }

            @Override // com.kwad.components.core.n.a.a
            public final void c(com.kwad.components.core.proxy.f fVar) {
                g.this.gH();
            }

            @Override // com.kwad.components.core.n.a.a
            public final void d(com.kwad.components.core.proxy.f fVar) {
                g.this.gI();
            }

            @Override // com.kwad.components.core.n.a.a
            public final void hd() {
                g.this.gJ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG() {
        Iterator<a> it = this.up.iterator();
        while (it.hasNext()) {
            it.next().hh();
        }
    }

    public final void gH() {
        if (this.tH || this.tG || this.uj) {
            return;
        }
        boolean zInterceptPlayCardResume = false;
        Iterator<b> it = this.uq.iterator();
        while (it.hasNext()) {
            zInterceptPlayCardResume |= it.next().interceptPlayCardResume();
        }
        if (zInterceptPlayCardResume) {
            return;
        }
        Iterator<a> it2 = this.up.iterator();
        while (it2.hasNext()) {
            it2.next().hi();
        }
    }

    public final void gI() {
        Iterator<a> it = this.up.iterator();
        while (it.hasNext()) {
            it.next().hj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ() {
        Iterator<a> it = this.up.iterator();
        while (it.hasNext()) {
            it.next().hk();
        }
    }

    public final void A(boolean z) {
        this.tH = z;
        if (z) {
            gI();
        } else {
            gH();
        }
    }

    public final boolean gK() {
        return this.tH;
    }

    public final void a(a aVar) {
        this.up.add(aVar);
    }

    public final void b(a aVar) {
        this.up.remove(aVar);
    }

    public final void a(b bVar) {
        this.uq.add(bVar);
    }

    public final void b(b bVar) {
        this.uq.remove(bVar);
    }

    public final void a(com.kwad.components.ad.reward.k.a aVar) {
        this.tB.add(aVar);
    }

    public final void b(com.kwad.components.ad.reward.k.a aVar) {
        this.tB.remove(aVar);
    }

    public final void a(s sVar) {
        this.tC.add(sVar);
    }

    public final void b(s sVar) {
        this.tC.remove(sVar);
    }

    public final void a(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.tD.add(cVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.tD.remove(cVar);
        }
    }

    public final void gL() {
        a(this.tD, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.m.c>() { // from class: com.kwad.components.ad.reward.g.5
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.m.c cVar) {
                c(cVar);
            }

            private static void c(com.kwad.components.ad.reward.m.c cVar) {
                cVar.jF();
            }
        });
    }

    public static <T> void a(List<T> list, com.kwad.sdk.g.a<T> aVar) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    public final String gM() {
        if (this.mAdTemplate.tkLiveShopItemInfo == null) {
            return null;
        }
        return this.mAdTemplate.tkLiveShopItemInfo.itemId;
    }

    @Override // com.kwad.components.core.n.a, com.kwad.sdk.mvp.a
    public final void release() {
        gN();
        com.kwad.components.ad.reward.m.e eVar = this.tu;
        if (eVar != null) {
            eVar.release();
        }
    }

    private void gN() {
        this.tA.clear();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        j jVar = this.tx;
        if (jVar != null) {
            jVar.release();
        }
        d dVar = this.tz;
        if (dVar != null) {
            dVar.release();
        }
        Set<com.kwad.components.ad.reward.e.e> set = this.tE;
        if (set != null) {
            set.clear();
        }
    }

    public static boolean g(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.b.g(adInfo) && !com.kwad.components.ad.reward.a.b.k(adInfo);
    }

    public final void b(com.kwad.components.ad.reward.e.g gVar) {
        this.tA.offer(gVar);
    }

    public final void c(com.kwad.components.ad.reward.e.g gVar) {
        this.tA.remove(gVar);
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void gO() {
        if (isMainThread()) {
            gP();
        } else {
            this.mHandler.post(new bh() { // from class: com.kwad.components.ad.reward.g.6
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    g.this.gP();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gP() {
        try {
            int size = this.tA.size();
            for (int i = 0; i < size; i++) {
                com.kwad.components.ad.reward.e.g gVarPoll = this.tA.poll();
                if (gVarPoll != null) {
                    gVarPoll.dc();
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void a(long j, long j2, int i) {
        Iterator<com.kwad.components.ad.reward.e.e> it = this.tE.iterator();
        while (it.hasNext()) {
            it.next().dv();
        }
    }

    public final void a(int i, Context context, int i2, int i3) {
        b(i, context, i2, i3);
    }

    public final void b(int i, Context context, int i2, int i3) {
        a(i, context, i2, i3, 0L, false, null);
    }

    public final void a(int i, Context context, int i2, int i3, long j) {
        a(1, context, 40, 1, j, false, null);
    }

    public final void a(int i, Context context, final int i2, int i3, long j, boolean z, final com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.e.d.a.a(new a.C0469a(context).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aq(false).aG(i3).A(j).aF(i2).aE(i).aq(gM()).a(new Callable<String>() { // from class: com.kwad.components.ad.reward.g.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: hf, reason: merged with bridge method [inline-methods] */
            public String call() {
                if (g.this.tu != null) {
                    return g.this.tu.lb().getCurrentShowShopItemInfo().itemId;
                }
                return null;
            }
        }).a(new a.b() { // from class: com.kwad.components.ad.reward.g.7
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    g.this.a(i2, bVar);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.eP(i);
        bVar.f(this.mRootContainer.getTouchCoords());
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, (String) null, (String) null, bVar, this.mReportExtData);
        com.kwad.components.ad.reward.c.a.hZ().c(this.mAdTemplate, com.kwad.components.ad.reward.c.b.STATUS_NONE);
        this.tt.db();
    }

    public final void Z(int i) {
        this.uf = i;
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.tZ.add(onDismissListener);
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.tZ.remove(onDismissListener);
    }

    public final void d(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.tZ.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.o oVar) {
        this.ua = oVar;
    }

    public final boolean gQ() {
        return this.uk;
    }

    public final void B(boolean z) {
        this.uk = z;
    }

    public final void gR() {
        com.kwad.components.core.webview.tachikoma.f.a aVar = this.tF;
        if (aVar == null) {
            return;
        }
        aVar.ko();
    }

    public final void a(com.kwad.components.core.webview.tachikoma.f.a aVar) {
        this.tF = aVar;
    }

    public final boolean gS() {
        return this.tM;
    }

    public final PlayableSource gT() {
        return this.tW;
    }

    public final void d(PlayableSource playableSource) {
        this.tW = playableSource;
    }

    public final boolean gU() {
        return this.tX;
    }

    public final void C(boolean z) {
        this.tX = true;
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.hZ().a(this.mAdTemplate, bVar);
    }

    public final void a(final com.kwad.components.core.j.c cVar) {
        final com.kwad.components.core.j.d dVarR = com.kwad.components.ad.reward.e.f.R(this.mAdTemplate.getUniqueId());
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.g.9
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.components.core.j.d dVar = dVarR;
                if (dVar != null) {
                    dVar.c(cVar);
                }
            }
        });
    }

    public final void b(final com.kwad.components.core.j.c cVar) {
        final com.kwad.components.core.j.d dVarR = com.kwad.components.ad.reward.e.f.R(this.mAdTemplate.getUniqueId());
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.g.10
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.components.core.j.d dVar = dVarR;
                if (dVar != null) {
                    dVar.d(cVar);
                }
            }
        });
    }

    public final List<a.InterfaceC0474a> gV() {
        return this.ur;
    }

    public final void a(a.InterfaceC0474a interfaceC0474a) {
        List<a.InterfaceC0474a> list = this.ur;
        if (list != null) {
            list.add(interfaceC0474a);
        }
    }

    public final void b(a.InterfaceC0474a interfaceC0474a) {
        List<a.InterfaceC0474a> list = this.ur;
        if (list != null) {
            list.remove(interfaceC0474a);
        }
    }

    public static com.kwad.components.core.j.c a(List<com.kwad.components.core.j.c> list, long j) {
        if (j >= 0 && list != null) {
            for (com.kwad.components.core.j.c cVar : list) {
                if (com.kwad.sdk.core.response.b.e.eV(cVar.getAdTemplate()) == j) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public final void a(RewardRenderResult rewardRenderResult) {
        this.uo = rewardRenderResult;
    }

    public final RewardRenderResult gW() {
        return this.uo;
    }

    public final boolean gX() {
        return RewardRenderResult.NEO_TK.equals(this.uo);
    }

    public final boolean gY() {
        return this.uj;
    }

    public final void D(boolean z) {
        this.uj = true;
    }

    public final boolean gZ() {
        return this.tG;
    }

    public final void E(boolean z) {
        this.tG = z;
    }

    public final boolean ha() {
        return this.mRewardVerifyCalled;
    }

    public final void F(final boolean z) {
        if (z != this.mRewardVerifyCalled) {
            a(this.tC, new com.kwad.sdk.g.a<s>() { // from class: com.kwad.components.ad.reward.g.11
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void accept(s sVar) {
                    sVar.ab(z);
                }
            });
        }
        this.mRewardVerifyCalled = z;
    }

    public static void a(Context context, g gVar, ViewGroup viewGroup) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(gVar.mAdTemplate);
        com.kwad.components.core.p.a.b.a aVar = (com.kwad.components.core.p.a.b.a) com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.b.a.class);
        if (aVar != null && aVar.qI() && com.kwad.sdk.core.response.b.a.df(com.kwad.sdk.core.response.b.e.eP(gVar.mAdTemplate))) {
            IAdLiveOfflineView iAdLiveOfflineViewA = null;
            try {
                iAdLiveOfflineViewA = com.kwad.components.ad.j.c.a(aVar, context, com.kwad.sdk.core.response.b.a.bl(adInfoEP) == 8 ? 1 : 0);
            } catch (Throwable unused) {
            }
            if (iAdLiveOfflineViewA != null) {
                View view = iAdLiveOfflineViewA.getView();
                gVar.fq = iAdLiveOfflineViewA;
                viewGroup.addView(view);
                gVar.tu.a(2, new com.kwad.components.ad.reward.f.a(gVar.mAdTemplate, aVar.getAdLivePlayModule(iAdLiveOfflineViewA, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cD(adInfoEP)), com.kwad.sdk.core.response.b.a.cE(adInfoEP), com.kwad.sdk.core.response.b.a.cF(adInfoEP))));
            }
        }
    }

    public static boolean O(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.eP(adTemplate)));
    }

    public static boolean P(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.P(adTemplate);
    }

    public static boolean Q(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.b.a.dl(com.kwad.sdk.core.response.b.e.eP(adTemplate))) {
            return false;
        }
        return O(adTemplate) || P(adTemplate);
    }

    public static long a(long j, AdInfo adInfo) {
        return Math.min(com.kwad.sdk.core.response.b.a.ai(adInfo), j);
    }

    public static boolean b(g gVar) {
        return gVar.tG;
    }

    public static void a(g gVar, final h.c cVar, final h.a aVar) {
        if (!gVar.tu.la()) {
            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(gVar.mAdTemplate);
            bVarC = com.kwad.components.ad.reward.a.b.j(adInfoEP) || com.kwad.sdk.core.response.b.a.ct(adInfoEP) == 2 ? c(gVar) : null;
            if (bVarC == null) {
                bVarC = d(gVar);
            }
        }
        com.kwad.components.ad.reward.k.a.b bVar = bVarC;
        if (bVar != null) {
            com.kwad.components.ad.reward.k.a.b.a(bVar, gVar.getActivity(), gVar.tu.getPlayDuration(), aVar, new e.a() { // from class: com.kwad.components.ad.reward.g.12
                @Override // com.kwad.components.core.webview.tachikoma.d.e.a
                public final boolean hg() {
                    g.b(g.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(gVar, cVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(g gVar, h.c cVar, h.a aVar) {
        boolean zB = b(gVar);
        com.kwad.sdk.core.d.c.d("RewardCallerContext", "showNativeCloseDialog isCloseDialogShowing: " + zB);
        if (zB) {
            return;
        }
        h.a(gVar.getActivity(), gVar.mAdTemplate, cVar, aVar);
    }

    public final void d(final boolean z, final boolean z2) {
        if (this.tu.la()) {
            bx.runOnUiThreadDelay(new bh() { // from class: com.kwad.components.ad.reward.g.2
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    com.kwad.components.ad.reward.f.a aVarLb = g.this.tu.lb();
                    if (aVarLb != null) {
                        aVarLb.setAudioEnabled(z, z2);
                    }
                }
            }, 500L);
        }
    }

    public final void F(String str) {
        int iA = -1;
        try {
            if (com.kwad.sdk.core.config.e.Uv()) {
                iA = com.kwad.components.ad.reward.j.a.a(getActivity());
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        com.kwad.components.ad.reward.j.b.a(this.mContext, this.mAdTemplate, str, iA, this.mReportExtData);
    }

    public final void hb() {
        long j = this.uh;
        com.kwad.sdk.core.adlog.c.i(this.mAdTemplate, com.kwad.sdk.core.response.b.a.ag(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate)), j != 0 ? (int) (j / 1000) : 0);
    }

    private static com.kwad.components.ad.reward.k.a.b c(g gVar) {
        e.b bVar = new e.b();
        bVar.a(gVar.mAdResultData);
        bVar.bo(com.kwad.sdk.core.response.b.b.en(gVar.mAdTemplate));
        bVar.bf(false);
        bVar.bg(true);
        return com.kwad.components.ad.reward.k.a.b.a(gVar, bVar);
    }

    private static com.kwad.components.ad.reward.k.a.b d(g gVar) {
        if (com.kwad.sdk.core.response.b.a.ct(com.kwad.sdk.core.response.b.e.eP(gVar.mAdTemplate)) == 4 || com.kwad.sdk.core.response.b.a.ct(com.kwad.sdk.core.response.b.e.eP(gVar.mAdTemplate)) == 3) {
            return c(gVar);
        }
        return null;
    }

    public static void a(Activity activity, g gVar) {
        com.kwad.sdk.core.d.c.d("RewardCallerContext", "showExtraDialog");
        com.kwad.components.ad.reward.k.a.b.a(gVar, activity, gVar.tu.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.g.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                g.this.d(dialogInterface);
                com.kwad.sdk.core.c.b.aaf();
                Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (currentActivity == null || !currentActivity.equals(g.this.getActivity())) {
                    return;
                }
                g.this.tu.resume();
            }
        }, new h.b() { // from class: com.kwad.components.ad.reward.g.4
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void he() {
                g.this.tu.pause();
            }
        });
    }
}
