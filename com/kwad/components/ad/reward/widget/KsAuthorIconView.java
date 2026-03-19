package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.u.l;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.f;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.cb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsAuthorIconView extends FrameLayout implements cb.a {
    private View FI;
    private View FJ;
    private final cb dC;
    private ViewGroup fW;
    private KSCornerImageView fX;
    private KSCornerImageView fY;
    private KSCornerImageView fZ;
    private KSCornerImageView ga;
    private TextView gb;
    private ImageView gc;
    private View gd;
    private View ge;
    private View gf;
    private View gg;

    public KsAuthorIconView(Context context) {
        super(context);
        this.dC = new cb(this);
        A(context);
    }

    public KsAuthorIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dC = new cb(this);
        A(context);
    }

    public KsAuthorIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dC = new cb(this);
        A(context);
    }

    public KsAuthorIconView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.dC = new cb(this);
        A(context);
    }

    private void A(Context context) {
        m.inflate(context, R.layout.ksad_author_icon, this);
        this.fW = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.fY = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.fX = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.fZ = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.ga = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.gb = (TextView) findViewById(R.id.ksad_fans_count);
        this.FJ = findViewById(R.id.ksad_fans_hot_icon);
        this.FI = findViewById(R.id.ksad_author_btn_follow);
        this.gc = (ImageView) findViewById(R.id.ksad_author_arrow_down);
        this.ge = findViewById(R.id.ksad_origin_live_bottom_layout);
        this.gd = findViewById(R.id.ksad_top_layout);
        this.gg = findViewById(R.id.ksad_author_icon_layout);
        this.gf = findViewById(R.id.ksad_top_flag_layout);
    }

    public final void k(AdTemplate adTemplate) {
        AdInfo adInfoEP = e.eP(adTemplate);
        String strCC = a.cC(adInfoEP);
        if (!TextUtils.isEmpty(strCC)) {
            KSImageLoader.loadImage(this.fY, strCC, adTemplate);
        }
        int iBl = a.bl(adInfoEP);
        if (a.df(e.eP(adTemplate))) {
            this.gb.setText("直播中");
            this.FJ.setVisibility(8);
            this.FI.setVisibility(8);
            if (iBl == 8) {
                this.gf.setVisibility(8);
                this.gc.setVisibility(8);
                this.ge.setVisibility(0);
            } else {
                this.ge.setVisibility(8);
                this.gc.setVisibility(0);
                this.ge.setVisibility(8);
            }
        } else {
            this.gb.setText(a.da(adInfoEP));
        }
        this.dC.sendEmptyMessageAtTime(1, 500L);
    }

    private static Animator a(View view, int i) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.setPivotX(width / 2.0f);
        view.setPivotY(height);
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet.setInterpolator(interpolatorCreate);
        animatorSet.setDuration(250L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet2.setInterpolator(interpolatorCreate2);
        animatorSet2.setDuration(250L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.setDuration(500L);
        return animatorSet3;
    }

    private static Animator a(View view, boolean z) {
        float width = view.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f = 0.9f * width;
        c.d("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(width, f);
        valueAnimatorOfFloat.addUpdateListener(b(view, false));
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setInterpolator(interpolatorCreate);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(f, width);
        valueAnimatorOfFloat2.addUpdateListener(b(view, false));
        Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        valueAnimatorOfFloat2.setDuration(500L);
        valueAnimatorOfFloat2.setInterpolator(interpolatorCreate2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        return animatorSet;
    }

    private Animator a(View view, long j) {
        if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(view.getWidth(), getResources().getDimension(R.dimen.ksad_reward_author_icon_width));
        valueAnimatorOfFloat.addUpdateListener(b(view, false));
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(interpolatorCreate);
        animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat);
        return animatorSet;
    }

    private static ValueAnimator.AnimatorUpdateListener b(final View view, final boolean z) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    int i = (int) fFloatValue;
                    layoutParams.width = i;
                    if (!z) {
                        layoutParams.height = i;
                    }
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public final void a(f fVar) {
        l.a(fVar, this);
        this.gc.setImageResource(R.drawable.ksad_reward_follow_arrow_down);
        a(fVar, this.fZ.getBackground());
        a(fVar, this.fX.getBackground());
        a(fVar, this.ga.getBackground());
        a(fVar, this.fW.getBackground());
    }

    private void a(f fVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.ksad_reward_author_icon_stroke_width), fVar.wH());
        }
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        if (message.what != 1) {
            return;
        }
        c.d("KsAuthorIconView", "handleMsg MSG_CHECKING");
        final Animator animatorA = a((View) this.fZ, 900L);
        final Animator animatorA2 = a((View) this.ga, 1000L);
        final Animator animatorA3 = a((View) this.fY, false);
        final Animator animatorA4 = a(this.gd, 500);
        if (animatorA4 != null && animatorA != null && animatorA2 != null && animatorA3 != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(animatorA3, animatorA, animatorA2);
            animatorSet.start();
            animatorA3.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    animatorA.start();
                    animatorA2.start();
                    animatorA3.start();
                    animatorA4.start();
                }
            });
            return;
        }
        this.dC.sendEmptyMessageDelayed(1, 500L);
    }
}
