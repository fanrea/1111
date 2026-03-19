package com.kwad.components.ct.detail.photo.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.detail.photo.related.RelatedVideoPanel;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.related.RelatedVideoDetailParam;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.glide.load.resource.bitmap.t;
import com.kwad.sdk.utils.ac;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j extends a<View> {
    private SlidePlayViewPager aok;
    private ViewStub awB;
    private RelatedVideoPanel awC;
    private com.kwad.components.ct.detail.photo.related.c awE;
    private ImageView awF;
    private View awG;
    private View awH;
    private Runnable awI;
    private TextView awJ;
    private boolean awK;
    private com.kwad.sdk.lib.b.f awa;
    private CtAdTemplate mAdTemplate;
    private int duration = 260;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.e.j.4
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            if (!TextUtils.isEmpty(com.kwad.components.ct.detail.a.b.ze())) {
                j.this.awJ.setText(com.kwad.components.ct.detail.a.b.ze());
            }
            if (com.kwad.components.ct.response.a.a.eH(j.this.aop.mAdTemplate) || !com.kwad.components.ct.home.config.b.FJ()) {
                return;
            }
            j.this.BK();
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            j.this.o(false, true);
            j.this.mHandler.removeCallbacks(j.this.awI);
            if (j.this.awE != null) {
                j.this.awE.release();
                j.this.awE.b(j.this.awa);
            }
        }
    };
    private final int awD = R.layout.ksad_content_photo_related_bottom_button;

    static /* synthetic */ CtAdTemplate a(j jVar, List list) {
        return y(list);
    }

    @Override // com.kwad.components.ct.detail.photo.e.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awB = (ViewStub) findViewById(R.id.ksad_related_panel_view_stub);
        this.awF = (ImageView) findViewById(R.id.ksad_photo_related_cover);
        this.awG = findViewById(R.id.ksad_photo_related_look_layout);
        this.awH = findViewById(R.id.ksad_photo_related_cover_layout);
        this.awJ = (TextView) findViewById(R.id.ksad_title_look_related);
        this.awq.setOnClickListener(this);
    }

    @Override // com.kwad.components.ct.detail.photo.e.d
    public final View Ag() {
        return com.kwad.sdk.c.a.a.a((ViewGroup) this.aul, this.awD, false);
    }

    @Override // com.kwad.components.ct.detail.photo.e.a, com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aop.aoF = true;
        this.aok = this.aop.aok;
        this.mAdTemplate = this.aop.mAdTemplate;
        o(false, true);
        this.aop.aoq.add(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.awC != null) {
            this.aop.aor.remove(this.awC);
            this.awC.setVisibility(8);
            this.awC.release();
        }
        this.aok.setEnabled(true);
        o(false, true);
        this.aop.aoq.remove(this.aoQ);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.components.ct.response.a.a.eH(this.aop.mAdTemplate)) {
            ac.ae(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
        } else if (com.kwad.components.ct.detail.d.yk().U(com.kwad.components.ct.response.a.a.bg(this.mAdTemplate)) != null && !com.kwad.components.ct.home.config.b.FK()) {
            BL();
        } else {
            BI();
        }
        BH();
    }

    private void BH() {
        com.kwad.components.ct.e.b.JK().h(this.mAdTemplate, this.awH.getVisibility() == 0 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CtAdTemplate ctAdTemplate) {
        if (ctAdTemplate != null) {
            RelatedVideoDetailParam relatedVideoDetailParam = new RelatedVideoDetailParam();
            if (ctAdTemplate.mAdScene != null) {
                relatedVideoDetailParam.mEntryScene = ctAdTemplate.mAdScene.entryScene;
            }
            relatedVideoDetailParam.mSourcePhotoId = String.valueOf(com.kwad.components.ct.response.a.a.bg(ctAdTemplate));
            com.kwad.components.ct.related.b.a(this.aop.aoy, 1000, relatedVideoDetailParam);
        }
    }

    private void BI() {
        if (this.awB == null) {
            return;
        }
        RelatedVideoPanel relatedVideoPanel = this.awC;
        if (relatedVideoPanel == null || relatedVideoPanel.getVisibility() != 0) {
            if (this.awB.getParent() != null) {
                this.awC = (RelatedVideoPanel) this.awB.inflate();
            }
            RelatedVideoPanel relatedVideoPanel2 = (RelatedVideoPanel) findViewById(R.id.ksad_related_panel);
            this.awC = relatedVideoPanel2;
            relatedVideoPanel2.setRelatedPanelListener(new RelatedVideoPanel.a() { // from class: com.kwad.components.ct.detail.photo.e.j.1
                @Override // com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.a
                public final void Bv() {
                    j.this.aok.setEnabled(false);
                    j.this.aop.aoA = true;
                }

                @Override // com.kwad.components.ct.detail.photo.related.RelatedVideoPanel.a
                public final void Bw() {
                    j.this.aok.setEnabled(true);
                    j.this.aop.aoA = false;
                }
            });
            this.aop.aor.add(this.awC);
            this.awC.a(this.aop.aoy, this.aop.mAdTemplate);
            this.aok.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CtAdTemplate ctAdTemplate, boolean z) {
        if (ctAdTemplate == null || TextUtils.isEmpty(ctAdTemplate.photoInfo.coverInfo.coverUrl)) {
            return;
        }
        com.kwad.sdk.glide.c.h(this.aop.aoy).hh(ctAdTemplate.photoInfo.coverInfo.coverUrl).a(new t(com.kwad.sdk.c.a.a.a(getContext(), 4.0f))).b(this.awF);
        com.kwad.components.ct.e.b.JK().aa(this.mAdTemplate);
        if (z) {
            o(true, true);
            k(this.awH, true);
            k(this.awG, false);
            return;
        }
        o(true, false);
    }

    private static CtAdTemplate y(List<CtAdTemplate> list) {
        for (CtAdTemplate ctAdTemplate : list) {
            if (!TextUtils.isEmpty(ctAdTemplate.photoInfo.coverInfo.coverUrl)) {
                return ctAdTemplate;
            }
        }
        return null;
    }

    private com.kwad.sdk.lib.b.f BJ() {
        return new com.kwad.sdk.lib.b.g() { // from class: com.kwad.components.ct.detail.photo.e.j.2
            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public final void n(boolean z, boolean z2) {
                j jVar = j.this;
                CtAdTemplate ctAdTemplateA = j.a(jVar, jVar.awE.getItems());
                if (!j.this.awK) {
                    j.this.g(ctAdTemplateA);
                    return;
                }
                com.kwad.components.ct.detail.d.yk().a(com.kwad.components.ct.response.a.a.bg(j.this.mAdTemplate), ctAdTemplateA);
                j.this.a(ctAdTemplateA, true);
                j.this.awK = false;
            }
        };
    }

    private void k(final View view, final boolean z) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        ObjectAnimator objectAnimatorOfFloat3;
        if (view == null) {
            return;
        }
        if (z) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 0.0f, 1.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f, 0.0f);
        }
        if (z) {
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setDuration(this.duration);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.detail.photo.e.j.3
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator, boolean z2) {
                if (j.this.awG.getVisibility() != 4) {
                    j.this.awG.setVisibility(4);
                }
                if (z) {
                    return;
                }
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                view.setAlpha(1.0f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, boolean z2) {
        this.awG.setVisibility(z2 ? 0 : 4);
        this.awH.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BK() {
        CtAdTemplate ctAdTemplateU = com.kwad.components.ct.detail.d.yk().U(com.kwad.components.ct.response.a.a.bg(this.mAdTemplate));
        if (ctAdTemplateU == null) {
            Runnable runnable = new Runnable() { // from class: com.kwad.components.ct.detail.photo.e.j.5
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.awK = true;
                    j.this.BL();
                }
            };
            this.awI = runnable;
            this.mHandler.postDelayed(runnable, com.kwad.components.ct.home.config.b.FI());
            return;
        }
        a(ctAdTemplateU, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BL() {
        com.kwad.components.ct.detail.photo.related.c cVar = this.awE;
        if (cVar != null) {
            cVar.release();
            this.awE.b(this.awa);
        }
        this.awE = new com.kwad.components.ct.detail.photo.related.c(this.aop.mAdTemplate);
        if (this.awa == null) {
            this.awa = BJ();
        }
        this.awE.a(this.awa);
        this.awE.refresh();
    }
}
