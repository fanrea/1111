package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.splashscreen.presenter.e {
    private AnimatorSet JX;
    private TextView JY;
    private ViewGroup JZ;
    private ViewGroup Ka;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        mI();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        AnimatorSet animatorSet = this.JX;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    private void mI() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.Ka, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.JY, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.JZ, "scaleX", 0.8f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.JZ, "scaleY", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.JX = animatorSet;
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        this.JX.setDuration(300L);
        this.JX.start();
    }

    private void initView() {
        this.JY = (TextView) findViewById(R.id.ksad_ad_developer_text);
        this.JZ = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_view);
        this.Ka = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
    }
}
