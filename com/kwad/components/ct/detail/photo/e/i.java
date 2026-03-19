package com.kwad.components.ct.detail.photo.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i extends FrameLayout {
    private int arH;
    private TextView arI;
    private LottieAnimationView arJ;
    private ImageView dZ;

    public i(Context context) {
        this(context, null);
    }

    private i(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.arH = 1;
        this.dZ = null;
        this.arI = null;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_photo_like_button_2, (ViewGroup) this, true);
        this.dZ = (ImageView) findViewById(R.id.ksad_photo_like_button_image);
        this.arI = (TextView) findViewById(R.id.ksad_photo_like_count_text);
        this.arJ = (LottieAnimationView) findViewById(R.id.ksad_photo_like_animation_view);
    }

    public final void b(int i, long j) {
        this.arH = i;
        setImageView(i);
        setLikeCount(j);
    }

    public final int getLikeState() {
        return this.arH;
    }

    public final boolean zI() {
        return this.arH == 2;
    }

    public final void setLikeState(int i) {
        this.arH = i;
        setImageViewWithAnimator(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageView(int i) {
        int i2;
        if (i == 1) {
            i2 = R.drawable.ksad_photo_like_button_2_normal;
        } else {
            i2 = R.drawable.ksad_photo_like_button_2_selected;
        }
        this.dZ.setImageResource(i2);
    }

    private void setImageViewWithAnimator(int i) {
        setImageView(i);
        bC(i);
    }

    private void bC(final int i) {
        int i2;
        this.arJ.Qa();
        final boolean z = i == 2;
        this.arJ.setSpeed(z ? 1.2f : 1.0f);
        this.arJ.co(true);
        if (z) {
            i2 = R.raw.ksad_detail_right_button_like_anim_2;
        } else {
            i2 = R.raw.ksad_detail_right_button_unlike_anim_2;
        }
        this.arJ.setAnimation(i2);
        this.arJ.setVisibility(0);
        this.dZ.setVisibility(8);
        this.arJ.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.detail.photo.e.i.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                i.this.setImageView(i);
                i.this.dZ.setVisibility(0);
                i.this.arJ.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                i.this.setImageView(i);
                i.this.dZ.setVisibility(0);
                i.this.arJ.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (!z) {
                    i.this.setImageView(i);
                    i.this.dZ.setVisibility(0);
                } else {
                    i.this.dZ.setVisibility(8);
                }
            }
        });
        this.arJ.PZ();
    }

    public final void zJ() {
        if (this.arJ.isAnimating()) {
            this.arJ.Qa();
        }
    }

    public final void setLikeCount(long j) {
        this.arI.setText(bq.b(j, "赞"));
    }
}
