package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KSCouponLabelTextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class n extends d implements View.OnClickListener {
    private TextView DO;
    private ViewGroup EG;
    private LinearLayout EM;
    private KsPriceView EN;
    private TextView EO;
    private View EP;
    private KSCornerImageView EQ;
    private b ER;
    private a ES;
    private KSCornerImageView fY;
    private ViewGroup lz;

    public interface a {
        void iI();
    }

    static /* synthetic */ View a(n nVar, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return a(context, couponInfo, viewGroup);
    }

    public n(ViewGroup viewGroup, b bVar) {
        this.lz = viewGroup;
        this.ER = bVar;
        initView();
    }

    public final void a(a aVar) {
        this.ES = aVar;
    }

    private void initView() {
        this.EG = (ViewGroup) this.lz.findViewById(R.id.ksad_reward_order_root);
        this.fY = (KSCornerImageView) this.lz.findViewById(R.id.ksad_reward_order_icon);
        this.DO = (TextView) this.lz.findViewById(R.id.ksad_reward_order_title);
        this.EM = (LinearLayout) this.lz.findViewById(R.id.ksad_reward_order_coupon_list);
        this.EN = (KsPriceView) this.lz.findViewById(R.id.ksad_reward_order_price);
        this.EO = (TextView) this.lz.findViewById(R.id.ksad_reward_order_btn_buy);
        this.EP = this.lz.findViewById(R.id.ksad_reward_order_text_area);
        this.EQ = (KSCornerImageView) this.lz.findViewById(R.id.ksad_reward_order_kwai_logo);
        this.EO.setText(com.kwad.components.ad.e.b.aI());
        this.EO.setOnClickListener(this);
        this.fY.setOnClickListener(this);
        this.EP.setOnClickListener(this);
        Context context = this.lz.getContext();
        if (aq.apb()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.lz.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.lz.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.sdk.core.response.b.a.dj(com.kwad.sdk.core.response.b.e.eP(rVar.getAdTemplate())), rVar.getAdTemplate());
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hT() {
        return this.EG;
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.fY, adProductInfo.getIcon(), adTemplate);
        this.DO.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.EM.setVisibility(8);
            this.ES.iI();
        } else {
            this.EM.setVisibility(0);
            this.EM.post(new bh() { // from class: com.kwad.components.ad.reward.n.n.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        n nVar = n.this;
                        View viewA = n.a(nVar, nVar.EM.getContext(), couponInfo, n.this.EM);
                        ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        n.this.EM.addView(viewA, layoutParams);
                        com.kwad.components.core.u.l.a(new com.kwad.components.core.widget.f(), n.this.EM);
                    }
                    if (n.this.ES != null) {
                        if (n.this.EM.getChildCount() > 0) {
                            n.this.EM.getChildAt(0).post(new bh() { // from class: com.kwad.components.ad.reward.n.n.1.1
                                @Override // com.kwad.sdk.utils.bh
                                public final void doTask() {
                                    n.this.ES.iI();
                                }
                            });
                        } else {
                            n.this.ES.iI();
                        }
                    }
                }
            });
        }
        this.EN.h(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String strAJ = com.kwad.components.ad.e.b.aJ();
        if (bq.isNullString(strAJ)) {
            return;
        }
        KSImageLoader.loadImage(this.EQ, strAJ, adTemplate);
    }

    private static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) com.kwad.sdk.p.m.a(context, R.layout.ksad_reward_order_card_coupon, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.ER == null) {
            return;
        }
        if (view.equals(this.EO)) {
            this.ER.hX();
        } else if (view.equals(this.fY)) {
            this.ER.jw();
        } else if (view.equals(this.EP)) {
            this.ER.jx();
        }
    }
}
