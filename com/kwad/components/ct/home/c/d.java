package com.kwad.components.ct.home.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.cb;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.home.e implements cb.a {
    private View aJL;
    private View aJM;
    private View aJN;
    private TextView aJO;
    private TextView aJP;
    private ImageView aJQ;
    private ViewStub aJR;
    private int aJS;
    private AnimatorSet apT;
    private cb dC;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aJR = (ViewStub) findViewById(R.id.ksad_home_banner_layout_vs);
        this.aJS = -com.kwad.sdk.c.a.a.a(getContext(), 100.0f);
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        R(this.aJR);
        cb cbVarA = com.kwad.sdk.core.threads.a.a(this);
        this.dC = cbVarA;
        cbVarA.sendEmptyMessageDelayed(6666, com.kwad.sdk.core.config.c.bxF.Zq());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.dC.removeCallbacksAndMessages(null);
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        com.kwad.sdk.utils.h.execute(new bh() { // from class: com.kwad.components.ct.home.c.d.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.components.ct.home.download.a.Gc().Gf();
            }
        });
    }

    private void R(View view) {
        int statusBarHeight = com.kwad.components.core.u.e.e(getActivity()) ? 0 + com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0;
        if (statusBarHeight > 0 && view != null) {
            int iJ = com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_home_banner_margin);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin = iJ + statusBarHeight;
            view.setLayoutParams(marginLayoutParams);
        }
        this.aJS = (-com.kwad.sdk.c.a.a.a(getContext(), 100.0f)) - statusBarHeight;
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        if (message.what == 6666) {
            if (com.kwad.components.ct.home.download.a.Gc().Gg()) {
                return;
            }
            com.kwad.sdk.core.d.c.d("HomeAdBannerPresenter", "handleMsg MSG_CHECK_DELAY");
            final CtAdTemplate ctAdTemplateGd = com.kwad.components.ct.home.download.a.Gc().Gd();
            if (ctAdTemplateGd != null) {
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.home.c.d.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        d.this.b(ctAdTemplateGd, false);
                    }
                });
                com.kwad.sdk.core.d.c.d("HomeAdBannerPresenter", "handleMsg MSG_CHECK_DELAY downloadData not null, showBanner");
                com.kwad.components.ct.home.download.a.Gc().bO(com.kwad.sdk.core.response.b.a.aB(com.kwad.components.ct.response.a.a.eP(ctAdTemplateGd)));
                this.dC.sendEmptyMessageDelayed(8888, com.kwad.sdk.core.config.c.bxF.Zr());
                return;
            }
            final CtAdTemplate ctAdTemplateGe = com.kwad.components.ct.home.download.a.Gc().Ge();
            if (ctAdTemplateGe != null) {
                bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.home.c.d.3
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        d.this.b(ctAdTemplateGe, true);
                    }
                });
                com.kwad.sdk.core.d.c.d("HomeAdBannerPresenter", "handleMsg MSG_CHECK_DELAY installedData not null, showBanner");
                com.kwad.components.ct.home.download.a.Gc().bO(com.kwad.sdk.core.response.b.a.aB(com.kwad.components.ct.response.a.a.eP(ctAdTemplateGe)));
                this.dC.sendEmptyMessageDelayed(8888, com.kwad.sdk.core.config.c.bxF.Zr());
                return;
            }
            return;
        }
        if (message.what == 8888) {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.home.c.d.4
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    d.this.GE();
                }
            });
            com.kwad.sdk.core.d.c.d("HomeAdBannerPresenter", "handleMsg MSG_BANNER_SHOW_DURATION hideBanner");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final CtAdTemplate ctAdTemplate, final boolean z) {
        int i;
        ViewStub viewStub;
        if (ctAdTemplate == null || !com.kwad.components.ct.response.a.a.eH(ctAdTemplate) || GF()) {
            return;
        }
        if (this.aJL == null && (viewStub = this.aJR) != null) {
            this.aJL = viewStub.inflate();
        }
        View view = this.aJL;
        if (view == null) {
            return;
        }
        this.aJM = view.findViewById(R.id.ksad_home_banner_close_btn);
        this.aJO = (TextView) this.aJL.findViewById(R.id.ksad_home_banner_ad_content);
        this.aJP = (TextView) this.aJL.findViewById(R.id.ksad_home_banner_ad_link_btn);
        this.aJN = this.aJL.findViewById(R.id.ksad_home_banner_ad_link_btn_layout);
        this.aJQ = (ImageView) this.aJL.findViewById(R.id.ksad_home_banner_ad_img);
        com.kwad.sdk.glide.c.cy(getContext()).hh(com.kwad.components.ct.response.a.a.bf(ctAdTemplate)).a(com.kwad.sdk.glide.load.engine.h.bTp).a(new com.kwad.components.ct.home.f.a(getContext(), com.kwad.sdk.c.a.a.a(getContext(), 4.0f), 0, 1, Color.parseColor("#eaeaea"), 15)).b(this.aJQ);
        Context context = getContext();
        if (z) {
            i = R.string.ksad_home_banner_installed_format;
        } else {
            i = R.string.ksad_home_banner_uninstalled_format;
        }
        this.aJO.setText(String.format(context.getString(i), com.kwad.sdk.core.response.b.a.ay(com.kwad.components.ct.response.a.a.eP(ctAdTemplate))));
        this.aJP.setText(z ? "立即体验" : "安装");
        this.aJL.setTranslationY(this.aJS);
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(ctAdTemplate);
        this.aJN.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.home.c.d.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (z) {
                    if (d.this.mApkDownloadHelper != null) {
                        d.this.mApkDownloadHelper.pS();
                    }
                    com.kwad.sdk.core.adlog.c.o(ctAdTemplate, 47);
                } else {
                    if (d.this.mApkDownloadHelper != null) {
                        d.this.mApkDownloadHelper.pU();
                    }
                    com.kwad.sdk.core.adlog.c.o(ctAdTemplate, 45);
                }
                d.this.GE();
            }
        });
        this.aJM.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.home.c.d.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.kwad.sdk.core.adlog.c.o(ctAdTemplate, z ? 48 : 46);
                d.this.GE();
            }
        });
        bQ(true);
        com.kwad.sdk.core.adlog.c.c(ctAdTemplate, z ? 93 : 92, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE() {
        bQ(false);
    }

    private void bQ(final boolean z) {
        if (this.aJL == null) {
            return;
        }
        AnimatorSet animatorSet = this.apT;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.apT.removeAllListeners();
            this.apT.cancel();
        }
        this.apT = new AnimatorSet();
        com.kwad.sdk.core.d.c.d("HomeAdBannerPresenter", "bottomViewAnimate + isShow : " + z);
        View view = this.aJL;
        String name = View.TRANSLATION_Y.getName();
        float[] fArr = new float[1];
        fArr[0] = z ? 0.0f : this.aJS;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, name, fArr);
        objectAnimatorOfFloat.setDuration(z ? 300L : 260L);
        this.apT.playTogether(objectAnimatorOfFloat);
        this.apT.removeAllListeners();
        this.apT.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.home.c.d.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (z) {
                    return;
                }
                d.this.aJL.setVisibility(4);
                d.this.aGP.aol.aHo = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                d.this.aJL.setVisibility(z ? 4 : 0);
                d.this.aGP.aol.aHo = !z;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z) {
                    d.this.aJL.setVisibility(0);
                    d.this.aGP.aol.aHo = true;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public final void onAnimationPause(Animator animator) {
                super.onAnimationPause(animator);
                d.this.aJL.setVisibility(z ? 4 : 0);
                d.this.aGP.aol.aHo = !z;
            }
        });
        this.apT.start();
    }

    private boolean GF() {
        return (this.aGP.aol.aHp || this.aGP.aol.aHo) ? false : true;
    }
}
