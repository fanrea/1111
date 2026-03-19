package com.kwad.components.ad.reward.b;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.b.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    private AdTemplate mAdTemplate;
    private boolean vR = false;

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.vR = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = this.vb.mAdTemplate;
    }

    private static boolean l(AdInfo adInfo) {
        AdProductInfo adProductInfoDj = com.kwad.sdk.core.response.b.a.dj(adInfo);
        return (!com.kwad.components.ad.reward.a.b.i(adInfo) || adProductInfoDj == null || adProductInfoDj.isCouponListEmpty()) ? false : true;
    }

    @Override // com.kwad.components.ad.reward.b.b.a
    public final void hX() {
        this.vb.a(1, getContext(), 29, 1);
    }

    public final void showDialog() {
        com.kwad.sdk.core.d.c.d("RewardCouponDialogPresenter", "onBind hasShown : " + this.vR);
        if (this.vR) {
            return;
        }
        AdInfo adInfoEP = e.eP(this.mAdTemplate);
        ViewGroup viewGroup = (ViewGroup) this.vb.mRootContainer.findViewById(R.id.ksad_reward_order_coupon_list);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        View childAt = viewGroup;
        if (childCount > 0) {
            childAt = viewGroup.getChildAt(0);
        }
        final int[] iArrAa = com.kwad.sdk.c.a.a.aa(childAt);
        if (!l(adInfoEP) || iArrAa == null) {
            return;
        }
        childAt.post(new bh() { // from class: com.kwad.components.ad.reward.b.c.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("RewardCouponDialogPresenter", "targetView x: " + iArrAa[0] + ", y: " + iArrAa[1]);
                b.a(c.this.getActivity(), c.this.mAdTemplate, c.this, iArrAa);
                c.a(c.this, true);
            }
        });
    }
}
