package com.kwad.sdk.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bs;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e implements View.OnClickListener {
    private int aJS;
    private final boolean brE;
    private final boolean brF;
    private View brG;
    private ImageView brH;
    private TextView brI;
    private Button brJ;
    private int brK;
    private boolean brL;
    private final AdInfo mAdInfo;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private View mRootView = VJ();

    public e(Context context, AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.brE = z;
        this.brF = z2;
        this.brL = z3;
        ny();
    }

    private View VJ() throws Resources.NotFoundException {
        if (this.brE && this.brF) {
            this.mRootView = m.inflate(this.mContext, R.layout.ksad_install_tips_bottom, null);
        } else {
            this.mRootView = m.inflate(this.mContext, R.layout.ksad_install_tips, null);
        }
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(R.dimen.ksad_install_tips_card_elevation));
        this.brG = this.mRootView.findViewById(R.id.ksad_install_tips_close);
        this.brH = (ImageView) this.mRootView.findViewById(R.id.ksad_install_tips_icon);
        this.brI = (TextView) this.mRootView.findViewById(R.id.ksad_install_tips_content);
        this.brJ = (Button) this.mRootView.findViewById(R.id.ksad_install_tips_install);
        return this.mRootView;
    }

    private void ny() {
        this.brJ.setText(this.brE ? "安装" : "打开");
        this.brG.setOnClickListener(this);
        this.brJ.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.brH, com.kwad.sdk.core.response.b.a.cC(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate)), this.mAdTemplate, 8);
        String strAy = com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate));
        if (strAy.length() >= 8) {
            strAy = strAy.substring(0, 7) + "...";
        }
        this.brI.setText(this.mContext.getString(this.brE ? R.string.ksad_install_tips : R.string.ksad_launch_tips, strAy));
    }

    public final void b(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.brE && this.brF) {
            d(frameLayout);
        } else {
            c(frameLayout);
        }
        this.mRootView.postDelayed(new bh() { // from class: com.kwad.sdk.a.a.e.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                e.this.dismiss();
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    private void c(FrameLayout frameLayout) throws Resources.NotFoundException {
        FrameLayout.LayoutParams layoutParams;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_margin);
        this.aJS = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        }
        layoutParams.gravity = 48;
        layoutParams.leftMargin = dimensionPixelSize2;
        layoutParams.rightMargin = dimensionPixelSize2;
        layoutParams.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.aJS);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    private void d(FrameLayout frameLayout) throws Resources.NotFoundException {
        FrameLayout.LayoutParams layoutParams;
        int screenWidth = bs.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_left);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_bottom);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ksad_install_tips_bottom_height);
        this.brK = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        }
        layoutParams.gravity = 80;
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.brK);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator animatorU = U(this.mRootView);
        animatorU.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.a.a.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(e.this.mRootView);
            }
        });
        animatorU.start();
        c.VC().VG();
    }

    private Animator U(View view) {
        ObjectAnimator objectAnimatorOfFloat;
        if (this.brE && this.brF) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, 0.0f, this.brK);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, -this.aJS);
        }
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        objectAnimatorOfFloat.setDuration(260L);
        return objectAnimatorOfFloat;
    }

    private void show() {
        ObjectAnimator objectAnimatorOfFloat;
        if (this.brE && this.brF) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_X, this.brK, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mRootView, (Property<View, Float>) View.TRANSLATION_Y, -this.aJS, 0.0f);
        }
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        dismiss();
        if (view.getId() == R.id.ksad_install_tips_install) {
            if (this.brE) {
                if (this.brL) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    bVar.eR(29);
                    bVar.eY(23);
                    com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, (JSONObject) null, bVar);
                } else {
                    com.kwad.sdk.core.adlog.c.q(this.mAdTemplate, 45);
                }
                as.a(com.kwad.sdk.core.response.b.a.I(this.mAdInfo), new as.a() { // from class: com.kwad.sdk.a.a.e.3
                    @Override // com.kwad.sdk.utils.as.a
                    public final void qa() {
                        com.kwad.sdk.core.adlog.c.i(e.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.a.a.bz(e.this.mAdTemplate);
                    }

                    @Override // com.kwad.sdk.utils.as.a
                    public final void g(Throwable th) {
                        com.kwad.sdk.commercial.a.a.i(e.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }
                });
                return;
            }
            if (as.aH(this.mContext, com.kwad.sdk.core.response.b.a.aB(this.mAdInfo))) {
                com.kwad.sdk.core.adlog.c.cj(this.mAdTemplate);
            }
            com.kwad.sdk.core.adlog.c.p(this.mAdTemplate, 47);
            return;
        }
        if (view.getId() == R.id.ksad_install_tips_close) {
            if (this.brE) {
                if (this.brL) {
                    com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                    bVar2.eR(69);
                    bVar2.eY(23);
                    bVar2.fc(1);
                    com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, (JSONObject) null, bVar2);
                    return;
                }
                com.kwad.sdk.core.adlog.c.q(this.mAdTemplate, 46);
                return;
            }
            com.kwad.sdk.core.adlog.c.p(this.mAdTemplate, 48);
        }
    }
}
