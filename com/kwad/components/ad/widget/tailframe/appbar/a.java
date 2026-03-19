package com.kwad.components.ad.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a extends LinearLayout {
    private Runnable DA;
    protected View Do;
    protected Button Dp;
    protected Button Dq;
    protected KsAppTagsView Dw;
    protected com.kwad.components.ad.j.a Dz;
    protected AppScoreView Gh;
    protected TextProgressBar Gx;
    protected View Iv;
    protected TextView ON;
    protected TextView im;
    protected ValueAnimator nA;
    protected ImageView pi;
    protected TextView pj;

    public abstract int getLayoutId();

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        initView();
    }

    private void initView() {
        this.Iv = m.inflate(getContext(), getLayoutId(), this);
        this.pi = (ImageView) findViewById(R.id.ksad_app_icon);
        this.pj = (TextView) findViewById(R.id.ksad_app_name);
        this.Gh = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.im = (TextView) findViewById(R.id.ksad_app_download_count);
        this.ON = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.Gx = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.Gx.setTextColor(-1);
        this.Dw = (KsAppTagsView) findViewById(R.id.ksad_reward_apk_info_tags);
        this.Dp = (Button) findViewById(R.id.ksad_reward_apk_info_install_action);
        this.Dq = (Button) findViewById(R.id.ksad_reward_apk_info_install_start);
        this.Do = findViewById(R.id.ksad_reward_apk_info_install_container);
        this.Dz = new com.kwad.components.ad.j.a(this.Iv);
    }

    public void k(AdTemplate adTemplate) {
        AdInfo adInfoEP = e.eP(adTemplate);
        if (e.P(adTemplate)) {
            KSImageLoader.loadAppIcon(this.pi, com.kwad.sdk.core.response.b.a.dc(adInfoEP), adTemplate, 12);
        } else {
            KSImageLoader.loadAppIcon(this.pi, com.kwad.sdk.core.response.b.a.cC(adInfoEP), adTemplate, 12);
        }
        this.pj.setText(com.kwad.sdk.core.response.b.a.cz(adInfoEP));
        if (!e.P(adTemplate)) {
            float fAD = com.kwad.sdk.core.response.b.a.aD(adInfoEP);
            if (fAD >= 3.0f) {
                this.Gh.setScore(fAD);
                this.Gh.setVisibility(0);
            } else {
                this.Gh.setVisibility(8);
            }
            String strAC = com.kwad.sdk.core.response.b.a.aC(adInfoEP);
            if (!TextUtils.isEmpty(strAC)) {
                this.im.setText(strAC);
                this.im.setVisibility(0);
            } else {
                this.im.setVisibility(8);
            }
        }
        this.ON.setText(com.kwad.sdk.core.response.b.a.aw(adInfoEP));
        if (e.P(adTemplate)) {
            this.Gx.setVisibility(8);
            this.Do.setVisibility(0);
            this.Dq.setText("查看详情");
            this.Dp.setText(String.format("浏览详情页%s秒，领取奖励", new StringBuilder().append(com.kwad.sdk.core.config.e.Yp()).toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.DA == null) {
                    this.DA = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        @Override // java.lang.Runnable
                        public final void run() throws Resources.NotFoundException {
                            a.this.Dz.ji();
                        }
                    };
                }
                this.Do.postDelayed(this.DA, 1600L);
            }
        } else {
            this.Gx.setVisibility(0);
            this.Do.setVisibility(8);
            Runnable runnable = this.DA;
            if (runnable != null) {
                this.Do.removeCallbacks(runnable);
                this.DA = null;
            }
            D(e.eP(adTemplate));
        }
        if (e.P(adTemplate)) {
            List<String> listEG = d.eG(adTemplate);
            if (listEG.size() > 0) {
                this.Dw.setVisibility(0);
            } else {
                this.Dw.setVisibility(8);
            }
            this.Dw.setAppTags(listEG);
        }
    }

    public TextProgressBar getTextProgressBar() {
        return this.Gx;
    }

    public View getBtnInstallContainer() {
        return this.Do;
    }

    public final void D(AdInfo adInfo) {
        int i = adInfo.status;
        if (i == 1 || i == 2 || i == 3) {
            lz();
        } else {
            oa();
        }
    }

    public final void lz() {
        ValueAnimator valueAnimator = this.nA;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.nA.cancel();
            this.nA.end();
        }
        Runnable runnable = this.DA;
        if (runnable != null) {
            this.Do.removeCallbacks(runnable);
            this.DA = null;
        }
        this.Dz.nI();
    }

    private void oa() {
        ValueAnimator valueAnimator = this.nA;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.nA = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(1200L);
            this.nA.setRepeatCount(-1);
            this.nA.setRepeatMode(1);
            this.nA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    a.this.Gx.setScaleY(fFloatValue);
                    a.this.Gx.setScaleX(fFloatValue);
                }
            });
            this.nA.start();
        }
    }
}
