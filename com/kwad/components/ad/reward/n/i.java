package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i extends d implements View.OnClickListener {
    private ViewGroup DU;
    private KsPriceView DV;
    private TextView DW;
    private KsStyledTextButton DX;
    private TextView DY;
    private TextView DZ;
    private View Ea;
    private ImageView Eb;
    private TextView hg;
    private KsLogoView mLogoView;
    private TextView mf;
    private KSCornerImageView pJ;
    private com.kwad.components.ad.reward.g vb;
    private ViewGroup xM;

    static /* synthetic */ Animator a(i iVar, View view, float f) {
        return a(view, f);
    }

    public i(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.vb = gVar;
        this.mLogoView = ksLogoView;
        this.DU = viewGroup;
        initView();
    }

    private void initView() {
        this.xM = (ViewGroup) this.DU.findViewById(R.id.ksad_reward_jinniu_root);
        this.pJ = (KSCornerImageView) this.DU.findViewById(R.id.ksad_reward_jinniu_icon);
        this.mf = (TextView) this.DU.findViewById(R.id.ksad_reward_jinniu_title);
        this.hg = (TextView) this.DU.findViewById(R.id.ksad_reward_jinniu_desc);
        this.DV = (KsPriceView) this.DU.findViewById(R.id.ksad_reward_jinniu_price);
        this.DW = (TextView) this.DU.findViewById(R.id.ksad_reward_jinniu_right_label);
        this.DX = (KsStyledTextButton) this.DU.findViewById(R.id.ksad_reward_jinniu_btn_buy);
        this.Eb = (ImageView) this.DU.findViewById(R.id.ksad_reward_jinniu_light_sweep);
        this.Ea = this.DU.findViewById(R.id.ksad_reward_jinniu_coupon_layout);
        this.DY = (TextView) this.DU.findViewById(R.id.ksad_reward_jinniu_coupon);
        this.DZ = (TextView) this.DU.findViewById(R.id.ksad_reward_jinniu_coupon_prefix);
        this.xM.setOnClickListener(this);
        KsStyledTextButton ksStyledTextButton = this.DX;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.xM.getContext();
        if (aq.apb()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.xM.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.xM.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) throws Resources.NotFoundException {
        super.a(rVar);
        if (rVar == null) {
            return;
        }
        a(rVar.getAdTemplate(), a.aa(rVar.getAdTemplate()));
        ViewGroup viewGroup = this.xM;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    i iVar = i.this;
                    Animator animatorA = iVar.a(iVar.xM, i.this.DX, i.this.mLogoView);
                    if (animatorA != null) {
                        animatorA.start();
                    }
                }
            }, com.alipay.sdk.m.u.b.a);
            this.xM.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (i.this.DX == null || i.this.DX.getWidth() == 0) {
                        return;
                    }
                    float width = i.this.DX.getWidth();
                    i iVar = i.this;
                    final Animator animatorA = i.a(iVar, iVar.Eb, width);
                    if (animatorA != null) {
                        animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.i.2.1
                            private int Ed = 1;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (this.Ed >= 3) {
                                    return;
                                }
                                animatorA.start();
                                this.Ed++;
                            }
                        });
                        animatorA.start();
                    }
                }
            }, 5000L);
        }
    }

    private void a(AdTemplate adTemplate, a aVar) throws Resources.NotFoundException {
        if (aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.pJ, aVar.hs(), adTemplate, 4);
        TextView textView = this.mf;
        if (textView != null) {
            textView.setText(aVar.getTitle());
        }
        TextView textView2 = this.hg;
        if (textView2 != null) {
            textView2.setText(aVar.ht());
        }
        KsPriceView ksPriceView = this.DV;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
            this.DV.getConfig().as(dimensionPixelSize).au(dimensionPixelSize).at(this.DV.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
            this.DV.d(aVar.lj(), aVar.eG(), true);
        }
        if (this.DW != null) {
            if (!TextUtils.isEmpty(aVar.lm())) {
                this.DW.setText(aVar.lm());
            } else if (!TextUtils.isEmpty(aVar.getRating())) {
                this.DW.setText(aVar.getRating());
            } else {
                this.DW.setVisibility(8);
            }
        }
        if (this.DY != null && !TextUtils.isEmpty(aVar.lk())) {
            this.DY.setText(aVar.lk());
        }
        if (this.DX != null && !TextUtils.isEmpty(aVar.ll())) {
            this.DX.setText(aVar.ll());
        }
        int i = TextUtils.isEmpty(aVar.lk()) ? 8 : 0;
        View view = this.Ea;
        if (view != null) {
            view.setVisibility(i);
        }
        if (this.DZ == null || TextUtils.isEmpty(aVar.il())) {
            return;
        }
        this.DZ.setText(aVar.il());
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hT() {
        return this.xM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(final View view, View view2, final View view3) {
        final int height = view.getHeight();
        if (height <= 0 || view.getLayoutParams() == null) {
            return null;
        }
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.51f, 0.0f, 0.67f, 1.0f);
        ValueAnimator duration = ValueAnimator.ofInt(height, view.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_card_height_full)).setDuration(500L);
        duration.setInterpolator(interpolatorCreate);
        view.getContext();
        if (aq.apb() && view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            final int i = marginLayoutParams.bottomMargin;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.n.i.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    int i2 = iIntValue - height;
                    marginLayoutParams.bottomMargin = i + i2;
                    view3.setLayoutParams(marginLayoutParams);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = iIntValue;
                        view.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 0.0f).setDuration(200L);
        Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.86f, 0.0f, 0.83f, 1.0f);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f).setDuration(300L);
        duration3.setInterpolator(interpolatorCreate2);
        animatorSet.playSequentially(duration2, duration3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(duration, animatorSet);
        return animatorSet2;
    }

    private static Animator a(View view, float f) {
        if (view == null || view.getWidth() <= 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", view.getResources().getDimension(R.dimen.ksad_jinniu_light_sweep_width) + f).setDuration(1000L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2);
        return animatorSet;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.xM)) {
            this.vb.a(1, view.getContext(), 118, 2);
        } else if (view.equals(this.DX)) {
            this.vb.a(1, view.getContext(), 1, 1);
        }
    }

    static class a {
        private String El;
        private String Em;
        private String En;
        private String Eo;
        private String iconUrl;
        private String po;
        private String rating;
        private String title;
        private String uM;
        private String wJ;

        private a() {
        }

        static a aa(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
            AdProductInfo adProductInfoDj = com.kwad.sdk.core.response.b.a.dj(adInfoEP);
            a aVar = new a();
            String name = adProductInfoDj.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.b.a.aA(adInfoEP);
            }
            aVar.En = com.kwad.sdk.core.response.b.a.aH(adInfoEP);
            aVar.iconUrl = adProductInfoDj.getIcon();
            aVar.uM = com.kwad.sdk.core.response.b.a.aw(adInfoEP);
            aVar.El = adProductInfoDj.getPrice();
            aVar.po = adProductInfoDj.getOriginPrice();
            aVar.Eo = adProductInfoDj.getVolume();
            aVar.rating = adProductInfoDj.getRating();
            if (!adProductInfoDj.isCouponListEmpty() && (firstCouponList = adProductInfoDj.getFirstCouponList()) != null) {
                aVar.Em = CouponInfo.jinniuFormatCoupon(firstCouponList);
                aVar.U(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }

        public final String hs() {
            return this.iconUrl;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String ht() {
            return this.uM;
        }

        public final String lj() {
            return this.El;
        }

        public final String eG() {
            return this.po;
        }

        public final String lk() {
            return this.Em;
        }

        public final String ll() {
            return this.En;
        }

        public final String lm() {
            return this.Eo;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String il() {
            return this.wJ;
        }

        private void U(String str) {
            this.wJ = str;
        }
    }
}
