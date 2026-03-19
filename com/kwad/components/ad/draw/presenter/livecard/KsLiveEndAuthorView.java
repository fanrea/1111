package com.kwad.components.ad.draw.presenter.livecard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsLiveEndAuthorView extends KsLiveAuthorView {
    private boolean go;

    public KsLiveEndAuthorView(Context context) {
        super(context);
    }

    public KsLiveEndAuthorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsLiveEndAuthorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public KsLiveEndAuthorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView
    public final void A(Context context) {
        m.inflate(context, R.layout.ksad_draw_author_end_icon, this);
        this.fW = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.fY = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.fX = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.fZ = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.ga = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.gg = findViewById(R.id.ksad_author_icon_layout);
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView
    public final void k(AdTemplate adTemplate) {
        String strCC = com.kwad.sdk.core.response.b.a.cC(e.eP(adTemplate));
        if (!TextUtils.isEmpty(strCC)) {
            KSImageLoader.loadImage(this.fY, strCC, adTemplate);
        }
        this.dC.sendEmptyMessageAtTime(1, 500L);
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView, com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        if (message.what != 1) {
            return;
        }
        c.d("KsLiveEndAuthorView", "handleMsg MSG_CHECKING");
        final Animator animatorA = a((View) this.fZ, 900L);
        final Animator animatorA2 = a((View) this.ga, 1000L);
        final Animator animatorA3 = a((View) this.fY, false);
        if (this.go) {
            return;
        }
        if (animatorA != null && animatorA2 != null && animatorA3 != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(animatorA3, animatorA, animatorA2);
            animatorSet.start();
            this.go = true;
            animatorA3.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.presenter.livecard.KsLiveEndAuthorView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(animatorA, animatorA2, animatorA3);
                    animatorSet2.start();
                }
            });
            return;
        }
        this.dC.sendEmptyMessageDelayed(1, 500L);
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView
    public float getWaveEndSize() {
        return getResources().getDimension(R.dimen.ksad_draw_author_end_icon_width);
    }
}
