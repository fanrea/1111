package com.kwad.components.ct.detail.ad.presenter.comment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.ct.detail.photo.comment.h;
import com.kwad.components.ct.detail.photo.comment.i;
import com.kwad.components.ct.f.d;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseLinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CommentBottomAdPanel extends AdBaseLinearLayout {
    private TextView EI;
    private TextView apD;
    private h apJ;
    private TextView apP;
    private View apQ;
    private View apR;
    private View apS;
    private AnimatorSet apT;
    private boolean apU;
    private List<b> apV;
    private View.OnClickListener apW;
    private a apX;
    private View apY;
    private ImageView apZ;
    private KsAppDownloadListener fJ;
    private AdInfo mAdInfo;
    private CtAdTemplate mAdTemplate;
    private c mApkDownloadHelper;

    public interface a {
        void onClick();
    }

    public interface b {
        void onClose();
    }

    public void setAdClickListener(a aVar) {
        this.apX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, boolean z2) {
        ViewGroup.LayoutParams layoutParams;
        TextView textView = this.apP;
        if (textView == null || (layoutParams = textView.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            layoutParams.width = this.apU ? com.kwad.sdk.c.a.a.a(getContext(), 104.0f) : -2;
            layoutParams.height = -2;
            this.apP.setMaxEms(10);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.apP.setMaxEms(6);
        }
        this.apP.setSelected(z2);
        this.apP.setLayoutParams(layoutParams);
    }

    public CommentBottomAdPanel(Context context) {
        super(context);
        this.apV = new ArrayList();
        this.apW = new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentBottomAdPanel.this.eQ();
                com.kwad.sdk.core.adlog.c.cp(CommentBottomAdPanel.this.mAdTemplate);
            }
        };
        this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.2
            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                super.onPaused(i);
                CommentBottomAdPanel.this.j(true, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.abJ());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                CommentBottomAdPanel.this.j(false, false);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.aI(CommentBottomAdPanel.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                CommentBottomAdPanel.this.j(true, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.fu(i));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                CommentBottomAdPanel.this.j(false, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.cB(CommentBottomAdPanel.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                CommentBottomAdPanel.this.j(false, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.ae(CommentBottomAdPanel.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                CommentBottomAdPanel.this.j(false, false);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.aI(CommentBottomAdPanel.this.mAdInfo));
            }
        };
        initView();
    }

    public CommentBottomAdPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apV = new ArrayList();
        this.apW = new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentBottomAdPanel.this.eQ();
                com.kwad.sdk.core.adlog.c.cp(CommentBottomAdPanel.this.mAdTemplate);
            }
        };
        this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.2
            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                super.onPaused(i);
                CommentBottomAdPanel.this.j(true, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.abJ());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                CommentBottomAdPanel.this.j(false, false);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.aI(CommentBottomAdPanel.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                CommentBottomAdPanel.this.j(true, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.fu(i));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                CommentBottomAdPanel.this.j(false, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.cB(CommentBottomAdPanel.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                CommentBottomAdPanel.this.j(false, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.ae(CommentBottomAdPanel.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                CommentBottomAdPanel.this.j(false, false);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.aI(CommentBottomAdPanel.this.mAdInfo));
            }
        };
        initView();
    }

    public CommentBottomAdPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apV = new ArrayList();
        this.apW = new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentBottomAdPanel.this.eQ();
                com.kwad.sdk.core.adlog.c.cp(CommentBottomAdPanel.this.mAdTemplate);
            }
        };
        this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.2
            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i2) {
                super.onPaused(i2);
                CommentBottomAdPanel.this.j(true, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.abJ());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                CommentBottomAdPanel.this.j(false, false);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.aI(CommentBottomAdPanel.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                CommentBottomAdPanel.this.j(true, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.fu(i2));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                CommentBottomAdPanel.this.j(false, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.cB(CommentBottomAdPanel.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                CommentBottomAdPanel.this.j(false, true);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.ae(CommentBottomAdPanel.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                CommentBottomAdPanel.this.j(false, false);
                CommentBottomAdPanel.this.apP.setText(com.kwad.sdk.core.response.b.a.aI(CommentBottomAdPanel.this.mAdInfo));
            }
        };
        initView();
    }

    private void initView() {
        int i;
        com.kwad.sdk.core.d.c.d("commentBottomAdPanel", "initView");
        this.apJ = ((i) d.Kb().a(i.class)).zV();
        this.apU = com.kwad.components.ct.detail.a.b.yQ() == 1;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        if (this.apU) {
            i = R.layout.ksad_comment_bottom_ad_panel_layout;
        } else {
            i = R.layout.ksad_comment_bottom_ad_panel_layout_2;
        }
        layoutInflaterFrom.inflate(i, (ViewGroup) this, true);
        if (!this.apU) {
            View viewFindViewById = findViewById(R.id.kasd_comment_bottom_ad_divider);
            this.apY = viewFindViewById;
            g.c(viewFindViewById, this.apJ.asv);
        }
        TextView textView = (TextView) findViewById(R.id.kasd_comment_bottom_ad_author_name);
        this.apD = textView;
        g.a(textView, this.apJ.aso);
        TextView textView2 = (TextView) findViewById(R.id.kasd_comment_bottom_ad_content);
        this.EI = textView2;
        g.a(textView2, this.apJ.asp);
        this.apP = (TextView) findViewById(R.id.kasd_comment_bottom_ad_link_btn);
        this.apS = findViewById(R.id.kasd_comment_bottom_ad_link_btn_layout);
        this.apQ = findViewById(R.id.kasd_comment_bottom_ad_close_btn);
        ImageView imageView = (ImageView) findViewById(R.id.kasd_comment_bottom_ad_close_btn_icon);
        this.apZ = imageView;
        g.a(imageView, this.apJ.asw);
        View viewFindViewById2 = findViewById(R.id.kasd_comment_bottom_ad_layout);
        this.apR = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentBottomAdPanel.this.b(35, 2, false);
            }
        });
        this.apS.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentBottomAdPanel.this.b(34, 1, true);
            }
        });
        this.apD.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentBottomAdPanel.this.b(90, 2, false);
            }
        });
        this.EI.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentBottomAdPanel.this.b(91, 2, false);
            }
        });
        this.apQ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CommentBottomAdPanel.this.apW != null) {
                    CommentBottomAdPanel.this.apW.onClick(view);
                }
            }
        });
        if (this.apU) {
            com.kwad.sdk.core.view.d.a(this, g.parseColor(this.apJ.asr), com.kwad.sdk.c.a.a.a(getContext(), 6.0f), Color.parseColor("#14000000"), com.kwad.sdk.c.a.a.a(getContext(), 4.0f), 0, 1);
        } else {
            com.kwad.sdk.core.view.d.a(this, g.getDrawable(getContext(), this.apJ.asq));
        }
        setTranslationY(com.kwad.sdk.c.a.a.a(getContext(), 80.0f));
    }

    public final void a(CtAdTemplate ctAdTemplate, c cVar) {
        if (ctAdTemplate == null) {
            return;
        }
        this.mAdTemplate = ctAdTemplate;
        this.mAdInfo = com.kwad.components.ct.response.a.a.eP(ctAdTemplate);
        this.mApkDownloadHelper = cVar;
        this.EI.setText(com.kwad.components.ct.response.a.a.aQ(ctAdTemplate));
        this.apD.setText(com.kwad.components.ct.response.a.a.aL(ctAdTemplate));
        j(false, false);
        this.apP.setText(com.kwad.sdk.core.response.b.a.aI(com.kwad.components.ct.response.a.a.eP(ctAdTemplate)));
        c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(this.fJ);
        }
        if (this.apU) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            int iA = com.kwad.sdk.c.a.a.a(getContext(), 8.0f);
            marginLayoutParams.setMargins(iA, iA, iA, iA);
            setLayoutParams(marginLayoutParams);
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) getLayoutParams();
            int iA2 = com.kwad.sdk.c.a.a.a(getContext(), 0.0f);
            marginLayoutParams2.setMargins(iA2, iA2, iA2, iA2);
            setLayoutParams(marginLayoutParams2);
        }
        invalidate();
    }

    public void setName(String str) {
        this.apD.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ() {
        Iterator<b> it = this.apV.iterator();
        while (it.hasNext()) {
            it.next().onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, boolean z) {
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(i2).aq(z).aF(i).d(getTouchCoords()).as(true));
        a aVar = this.apX;
        if (aVar != null) {
            aVar.onClick();
        }
    }

    public final void a(b bVar) {
        this.apV.add(bVar);
    }

    public final void b(b bVar) {
        this.apV.remove(bVar);
    }

    public final void yN() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.fJ);
        }
        this.apV.clear();
    }

    public final void k(final boolean z, boolean z2) {
        if (z2) {
            setVisibility(8);
        }
        AnimatorSet animatorSet = this.apT;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.apT.removeAllListeners();
            this.apT.cancel();
        }
        this.apT = new AnimatorSet();
        int iA = com.kwad.sdk.c.a.a.a(getContext(), 80.0f);
        com.kwad.sdk.core.d.c.d("commentBottomAdPanel", "bottomViewAnimate + isShow : " + z);
        String name = View.TRANSLATION_Y.getName();
        float[] fArr = new float[1];
        fArr[0] = z ? 0.0f : iA;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, name, fArr);
        objectAnimatorOfFloat.setDuration(z ? 350L : 300L);
        this.apT.playTogether(objectAnimatorOfFloat);
        this.apT.removeAllListeners();
        this.apT.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.detail.ad.presenter.comment.CommentBottomAdPanel.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (z) {
                    return;
                }
                CommentBottomAdPanel.this.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                CommentBottomAdPanel.this.setVisibility(z ? 4 : 0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z) {
                    CommentBottomAdPanel.this.setVisibility(0);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public final void onAnimationPause(Animator animator) {
                super.onAnimationPause(animator);
                CommentBottomAdPanel.this.setVisibility(z ? 4 : 0);
            }
        });
        this.apT.start();
    }
}
