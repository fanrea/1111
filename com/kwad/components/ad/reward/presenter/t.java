package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class t extends b implements View.OnClickListener, com.kwad.components.ad.reward.e.o, com.kwad.sdk.core.g.b {
    private com.kwad.sdk.core.g.d iQ;
    private Vibrator iS;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.t.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            if (t.this.me != null) {
                t.this.me.setVisibility(8);
            }
            if (t.this.mk != null) {
                t.this.mk.setVisibility(8);
            }
            if (t.this.iQ != null) {
                t.this.iQ.bX(t.this.getContext());
            }
            if (t.this.mm != null) {
                t.this.mm.cancel();
                t.this.mm = null;
            }
        }
    };
    private ViewGroup me;
    private TextView mf;
    private TextView mg;
    private ImageView mh;
    private FrameLayout mi;
    private ImageView mj;
    private FrameLayout mk;
    private TextView ml;
    private Animator mm;

    @Override // com.kwad.sdk.core.g.b
    public final void ci() {
    }

    @Override // com.kwad.components.ad.reward.e.o
    public final int dw() {
        return com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_reward_shake_tips_title_marginBottom) + com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_reward_shake_tips_height);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() throws Resources.NotFoundException {
        super.ay();
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate);
        this.vb.a(this);
        this.vb.b(this.mPlayEndPageListener);
        dx();
        initView();
        a(adInfoEP);
        float fEs = com.kwad.sdk.core.response.b.b.es(adInfoEP);
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(fEs);
            this.iQ = dVar2;
            dVar2.a(this);
        } else {
            dVar.K(fEs);
        }
        this.iQ.bW(getContext());
        Context context = getContext();
        if (context != null) {
            this.iS = (Vibrator) context.getSystemService("vibrator");
        }
    }

    private void dx() throws Resources.NotFoundException {
        final int dimensionPixelSize;
        int dimensionPixelSize2;
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) com.kwad.sdk.p.m.a(getContext(), R.layout.ksad_shake_center, adBaseFrameLayout, false);
        this.me = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.me.getResources();
        try {
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        boolean z = com.kwad.sdk.core.response.b.a.bl(com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate)) == 8;
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginLeft);
        if (this.vb.mScreenOrientation == 1) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginBottom) + com.kwad.sdk.c.a.a.a(getContext(), 50.0f);
        } else if (z) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_live_shop_marginBottom);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginBottom);
        }
        if (this.vb.mScreenOrientation == 1) {
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_marginBottom) + com.kwad.sdk.c.a.a.a(getContext(), 50.0f);
        } else if (z) {
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_live_shop_marginBottom);
        } else {
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_marginBottom);
        }
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_height);
        FrameLayout frameLayout = (FrameLayout) com.kwad.sdk.p.m.a(getContext(), R.layout.ksad_shake_tips_title, adBaseFrameLayout, false);
        this.mk = frameLayout;
        this.ml = (TextView) frameLayout.findViewById(R.id.ksad_shake_tips_label);
        this.mk.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize3;
        layoutParams.bottomMargin = dimensionPixelSize2;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.mk, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.me, layoutParams2);
        com.kwad.sdk.core.adlog.c.b(this.vb.mAdTemplate, 185, (JSONObject) null);
        this.me.post(new bh() { // from class: com.kwad.components.ad.reward.presenter.t.6
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                int height = adBaseFrameLayout.getHeight();
                t tVar = t.this;
                tVar.mm = tVar.c(dimensionPixelSize3, height - dimensionPixelSize);
                if (t.this.mm != null) {
                    t.this.mm.start();
                }
            }
        });
    }

    private void initView() {
        this.mf = (TextView) this.me.findViewById(R.id.ksad_shake_center_title);
        this.mg = (TextView) this.me.findViewById(R.id.ksad_shake_center_sub_title);
        this.mh = (ImageView) this.me.findViewById(R.id.ksad_shake_center_icon);
        this.mi = (FrameLayout) this.me.findViewById(R.id.ksad_shake_center_circle_area);
        this.mj = (ImageView) this.me.findViewById(R.id.ksad_shake_center_circle_area_bg);
        this.mf.setOnClickListener(this);
        this.mg.setOnClickListener(this);
        this.mi.setOnClickListener(this);
        this.ml.setOnClickListener(this);
    }

    private void a(AdInfo adInfo) {
        String strEu = com.kwad.sdk.core.response.b.b.eu(adInfo);
        TextView textView = this.mf;
        if (textView != null) {
            textView.setText(strEu);
        }
        TextView textView2 = this.ml;
        if (textView2 != null) {
            textView2.setText(strEu);
        }
        String strA = a(this.vb, adInfo);
        TextView textView3 = this.mg;
        if (textView3 != null) {
            textView3.setText("或点击" + strA);
        }
    }

    private static String a(com.kwad.components.ad.reward.g gVar, AdInfo adInfo) {
        String strEw = com.kwad.sdk.core.response.b.b.ew(adInfo);
        com.kwad.components.core.e.d.c cVar = gVar.mApkDownloadHelper;
        if (!com.kwad.sdk.core.response.b.a.aJ(adInfo) || cVar == null) {
            return strEw;
        }
        int iPK = cVar.pK();
        AdMatrixInfo.DownloadTexts downloadTextsEy = com.kwad.sdk.core.response.b.b.ey(adInfo);
        if (iPK == 8) {
            return downloadTextsEy.installAppLabel;
        }
        if (iPK == 12) {
            return downloadTextsEy.openAppLabel;
        }
        return downloadTextsEy.adActionDescription;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator c(float f, float f2) throws Resources.NotFoundException {
        if (this.me == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.me.getResources();
        Animator animatorA = com.kwad.components.core.u.r.a((View) this.mh, (Interpolator) null, 100L, 16.0f);
        animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                t.this.mh.setPivotX(t.this.mh.getWidth());
                t.this.mh.setPivotY(t.this.mh.getHeight());
            }
        });
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.me, "translationX", f - (this.me.getLeft() + (this.me.getWidth() / 2.0f)));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.me, "translationY", f2 - (this.me.getTop() + (this.me.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.ksad_reward_shake_tips_height);
        final float dimension2 = resources.getDimension(R.dimen.ksad_reward_shake_tips_icon_size);
        float width = this.mi.getWidth();
        float width2 = this.mh.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(width, dimension);
        valueAnimatorOfFloat.addUpdateListener(new com.kwad.components.ad.widget.a(this.mj) { // from class: com.kwad.components.ad.reward.presenter.t.8
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float fFloatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) fFloatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(width2, dimension2);
        valueAnimatorOfFloat2.addUpdateListener(new com.kwad.components.ad.widget.a(this.mh) { // from class: com.kwad.components.ad.reward.presenter.t.9
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float fFloatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) fFloatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        int color = resources.getColor(R.color.ksad_shake_icon_bg_start_color);
        final int color2 = resources.getColor(R.color.ksad_reward_main_color);
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_stroke_size);
        ValueAnimator valueAnimatorOfArgb = com.kwad.sdk.widget.b.ofArgb(color, color2);
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) t.this.mj.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(iIntValue);
                    if (iIntValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    t.this.mj.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setDuration(200L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    t.this.mf.setAlpha(fFloatValue);
                    t.this.mg.setAlpha(fFloatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(this.mf.getHeight(), 0.0f);
        valueAnimatorOfFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.mf) { // from class: com.kwad.components.ad.reward.presenter.t.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator valueAnimatorOfFloat5 = ValueAnimator.ofFloat(this.mg.getHeight(), 0.0f);
        valueAnimatorOfFloat5.addUpdateListener(new com.kwad.components.ad.widget.a(this.mg) { // from class: com.kwad.components.ad.reward.presenter.t.13
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfArgb, valueAnimatorOfFloat4, valueAnimatorOfFloat5);
        AnimatorSet animatorSet3 = new AnimatorSet();
        final Animator animatorClone = animatorA.clone();
        animatorClone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.2
            private boolean mo = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                t.this.mh.setPivotX(dimension2);
                t.this.mh.setPivotY(dimension2);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.mo = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.mo) {
                    return;
                }
                animatorClone.start();
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.mk.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_reward_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    t.this.mk.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    t.this.mk.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(animatorClone, duration, ObjectAnimator.ofFloat(this.ml, "alpha", 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(animatorA, animatorA.clone(), animatorA.clone(), valueAnimatorOfFloat3, animatorSet2, animatorSet3);
        return animatorSet;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.me;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.me.getParent()).removeView(this.me);
            }
            this.me = null;
        }
        bx.b(getContext(), this.iS);
        this.iS = null;
        Animator animator = this.mm;
        if (animator != null) {
            animator.cancel();
            this.mm = null;
        }
        this.vb.c(this.mPlayEndPageListener);
    }

    @Override // com.kwad.sdk.core.g.b
    public final void d(double d) {
        com.kwad.sdk.core.c.b.aaf();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z = activity != null && activity.equals(currentActivity);
        if (com.kwad.components.core.e.c.b.pe() || !z) {
            bx.a(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.t.4
                @Override // java.lang.Runnable
                public final void run() {
                    t.this.iQ.abR();
                }
            }, null, 500L);
            return;
        }
        if (this.vb != null && !this.vb.gZ()) {
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            bVar.o(d);
            this.vb.a(1, getContext(), 157, 1, 0L, false, bVar);
        }
        bx.a(new bh() { // from class: com.kwad.components.ad.reward.presenter.t.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("RewardShakePresenter", "onShakeEvent openGate2");
                t.this.iQ.abR();
            }
        }, null, 500L);
        com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate);
        if (this.vb.gZ()) {
            return;
        }
        bx.a(getContext(), this.iS);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.core.response.b.b.eq(com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate))) {
            this.vb.a(1, getContext(), 158, 1);
        }
    }
}
