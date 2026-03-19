package com.kwad.components.ct.detail.photo.comment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CommentLikeButton extends LinearLayout implements View.OnClickListener {
    private int arH;
    private TextView arI;
    private LottieAnimationView arJ;
    private long arK;
    private a arL;
    private ImageView dZ;

    public interface a {
        void bD(int i);
    }

    public CommentLikeButton(Context context) {
        super(context);
        this.arH = 1;
        this.dZ = null;
        this.arI = null;
        initView();
    }

    public CommentLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arH = 1;
        this.dZ = null;
        this.arI = null;
        initView();
    }

    public CommentLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arH = 1;
        this.dZ = null;
        this.arI = null;
        initView();
    }

    private void initView() {
        m.a(getContext(), R.layout.ksad_content_alliance_comment_like_button_2, this, true);
        this.dZ = (ImageView) findViewById(R.id.ksad_photo_comment_like_button_image);
        this.arI = (TextView) findViewById(R.id.ksad_photo_comment_like_count_text);
        this.arJ = (LottieAnimationView) findViewById(R.id.ksad_photo_comment_like_animation_view);
        setOnClickListener(this);
    }

    public final void b(int i, long j) {
        this.arH = i;
        setImageView(i);
        this.arJ.setVisibility(8);
        this.arK = j;
        setLikeCount(j);
        setLikeCountColor(i);
    }

    public void setLikeStateListener(a aVar) {
        this.arL = aVar;
    }

    public int getLikeState() {
        return this.arH;
    }

    private boolean zI() {
        return this.arH == 2;
    }

    public void setLikeState(int i) {
        this.arH = i;
        setImageViewWithAnimator(i);
        setLikeCountColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageView(int i) {
        int i2;
        if (i == 1) {
            i2 = R.drawable.ksad_photo_comment_like_button_2_normal;
        } else {
            i2 = R.drawable.ksad_photo_comment_like_button_2_selected;
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
        boolean z = i == 2;
        this.arJ.co(true);
        if (z) {
            i2 = R.raw.ksad_detail_comment_like_anim_2;
        } else {
            i2 = R.raw.ksad_detail_comment_unlike_anim_2;
        }
        this.arJ.setAnimation(i2);
        this.arJ.setVisibility(0);
        this.arJ.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.detail.photo.comment.CommentLikeButton.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                CommentLikeButton.this.setImageView(i);
                CommentLikeButton.this.dZ.setVisibility(0);
                CommentLikeButton.this.arJ.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CommentLikeButton.this.setImageView(i);
                CommentLikeButton.this.dZ.setVisibility(0);
                CommentLikeButton.this.arJ.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                CommentLikeButton.this.dZ.setVisibility(8);
            }
        });
        this.arJ.PZ();
    }

    private void zJ() {
        if (this.arJ.isAnimating()) {
            this.arJ.Qa();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zJ();
    }

    public void setLikeCount(long j) {
        this.arI.setText(bq.b(j, ""));
    }

    public void setLikeCountColor(int i) {
        this.arI.setTextColor(i == 2 ? -61862 : -7828591);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (zI()) {
            setLikeState(1);
            a aVar = this.arL;
            if (aVar != null) {
                aVar.bD(1);
            }
            long j = this.arK - 1;
            this.arK = j;
            setLikeCount(j);
            return;
        }
        setLikeState(2);
        a aVar2 = this.arL;
        if (aVar2 != null) {
            aVar2.bD(2);
        }
        long j2 = this.arK + 1;
        this.arK = j2;
        setLikeCount(j2);
    }
}
