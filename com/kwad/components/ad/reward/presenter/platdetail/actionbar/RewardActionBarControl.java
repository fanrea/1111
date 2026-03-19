package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class RewardActionBarControl {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private g vb;
    private b zP;
    private d zT;
    private c zU;
    private final long zW;
    private a zV = new a(0);
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean zX = false;
    private boolean zY = false;

    public enum ShowActionBarResult {
        SHOW_NATIVE_DEFAULT,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_ORDER,
        SHOW_NATIVE_ORDER,
        SHOW_NATIVE_JINNIU,
        SHOW_NATIVE_PLAYABLE_PORTRAIT,
        SHOW_NATIVE_LIVE_SUBSCRIBE,
        SHOW_NATIVE_ORIGIN_LIVE
    }

    public interface b {
        void a(boolean z, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface c {
        void e(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface d {
        boolean f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    static /* synthetic */ boolean a(RewardActionBarControl rewardActionBarControl, boolean z) {
        rewardActionBarControl.zX = true;
        return true;
    }

    public RewardActionBarControl(g gVar, Context context, AdTemplate adTemplate) {
        this.vb = gVar;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        long jCS = com.kwad.sdk.core.response.b.b.cS(adTemplate) > 0 ? com.kwad.sdk.core.response.b.b.cS(adTemplate) : 1000L;
        this.zW = jCS > 0 ? jCS : 1000L;
    }

    public final void P(boolean z) {
        ShowActionBarResult showActionBarResultQ = Q(z);
        com.kwad.sdk.core.d.c.d("ActionBarControl", "showActionBarOnVideoStart result: " + showActionBarResultQ);
        if (showActionBarResultQ != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.mHandler.postDelayed(new bh() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                RewardActionBarControl.a(RewardActionBarControl.this, true);
                com.kwad.sdk.core.d.c.d("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.zT == null || RewardActionBarControl.this.zY || !RewardActionBarControl.this.zT.f(RewardActionBarControl.this.zV)) {
                    com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.zW);
                    com.kwad.components.core.q.a.ss().j(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.zW);
                    com.kwad.components.ad.reward.monitor.c.a(RewardActionBarControl.this.vb.mAdTemplate, RewardActionBarControl.this.vb.tI, "play_card", com.kwad.sdk.core.response.b.b.cR(RewardActionBarControl.this.vb.mAdTemplate), RewardActionBarControl.this.zW, 1);
                    RewardActionBarControl.this.R(true);
                    return;
                }
                com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.zW);
            }
        }, this.zW);
    }

    public final void ju() {
        if (this.zX) {
            com.kwad.sdk.core.d.c.i("ActionBarControl", "showWebActionBar time out on pageStatus");
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
            Q(true);
        }
    }

    private ShowActionBarResult Q(boolean z) {
        c cVar;
        if (com.kwad.components.ad.reward.a.b.i(this.mAdInfo) && (cVar = this.zU) != null) {
            cVar.e(this.zV);
            return ShowActionBarResult.SHOW_ORDER;
        }
        if (!com.kwad.sdk.core.response.b.b.cU(this.mAdTemplate) || com.kwad.sdk.core.response.b.a.bj(this.mAdInfo) || this.zT == null) {
            R(z);
            return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
        }
        com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar success in " + this.zW);
        if (this.zT.f(this.zV)) {
            return ShowActionBarResult.SHOW_H5_SUCCESS;
        }
        return ShowActionBarResult.SHOW_H5_FAILURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(boolean z) {
        if (this.zP != null) {
            com.kwad.sdk.core.d.c.d("ActionBarControl", "showNativeActionBar");
            this.zY = true;
            this.zP.a(z, this.zV);
        }
    }

    public final void a(b bVar) {
        this.zP = bVar;
    }

    public final void a(d dVar) {
        this.zT = dVar;
    }

    public final void a(c cVar) {
        this.zU = cVar;
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.zV.c(aVar);
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.zV.d(aVar);
    }

    public final ShowActionBarResult jv() {
        return this.zV.Ae;
    }

    public static void a(final com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar, final View view, final ShowActionBarResult showActionBarResult) {
        if (aVar != null) {
            view.post(new bh() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    aVar.a(showActionBarResult, view);
                }
            });
        }
    }

    static class a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        private List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> Ad;
        private ShowActionBarResult Ae;

        private a() {
            this.Ad = new CopyOnWriteArrayList();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void c(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.Ad.add(aVar);
        }

        public final void d(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.Ad.remove(aVar);
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view) {
            com.kwad.sdk.core.d.c.d("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
            this.Ae = showActionBarResult;
            Iterator<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> it = this.Ad.iterator();
            while (it.hasNext()) {
                it.next().a(showActionBarResult, view);
            }
        }
    }
}
