package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.l.b;
import com.kwad.components.core.j.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class s extends b implements com.kwad.components.ad.reward.e.g, a.InterfaceC0474a, y.b {
    private List<com.kwad.components.core.j.c> dw;
    private com.kwad.components.ad.reward.d tz;
    private ImageView xp;
    private boolean yH;

    /* renamed from: yq, reason: collision with root package name */
    private View f769yq;
    private KsLogoView yr;
    private DetailVideoView ys;
    private int yt;
    private View yu;
    private FrameLayout yv;
    private Animator yw;
    private Animator yx;
    private Animator yy;
    private AdTemplate yz;
    private int yp = 1;
    private long yA = 500;
    private long yB = 50;
    private float yC = 1.2254902f;
    private float yD = 0.80472106f;
    private float yE = 0.0f;
    private boolean yF = false;
    private long showTime = -1;
    private long yG = -1;
    private com.kwad.components.core.video.o lv = new com.kwad.components.core.video.o() { // from class: com.kwad.components.ad.reward.presenter.s.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) throws JSONException {
            s.this.k(j2);
        }
    };
    private com.kwad.sdk.core.webview.d.a.a gF = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.s.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar != null && !com.kwad.sdk.core.response.b.e.b(s.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                com.kwad.components.core.j.c cVarA = com.kwad.components.ad.reward.g.a((List<com.kwad.components.core.j.c>) s.this.dw, aVar.creativeId);
                if (cVarA != null) {
                    s.this.vb.a(cVarA);
                    return;
                }
                return;
            }
            s.this.vb.tt.db();
        }
    };

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j) throws JSONException {
        AdTemplate adTemplate = this.yz;
        if (adTemplate == null || this.yH) {
            return;
        }
        if (this.showTime <= 0) {
            this.showTime = com.kwad.sdk.core.response.b.b.cY(adTemplate);
            this.yG = com.kwad.sdk.core.response.b.b.cX(this.yz) + this.showTime;
        }
        long j2 = this.showTime;
        if (j2 > 0 && !this.yF && j > j2) {
            this.yH = !J(true);
            com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "showError: " + this.yH);
            if (this.yH) {
                return;
            } else {
                this.yF = true;
            }
        }
        boolean z = this.yp == 3;
        long j3 = this.yG;
        if (j3 <= 0 || z || j <= j3) {
            return;
        }
        K(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f769yq = findViewById(R.id.ksad_middle_end_card);
        this.ys = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.yr = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.xp = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        this.yu = findViewById(R.id.ksad_play_web_card_webView);
        this.yv = (FrameLayout) findViewById(R.id.ksad_middle_end_card_webview_container);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.vb.tu.a(this.lv);
        this.vb.b((com.kwad.components.ad.reward.e.g) this);
        this.vb.a(this);
        this.yt = com.kwad.sdk.c.a.a.ab(this.ys);
        com.kwad.sdk.c.a.a.u(this.ys, 49);
        this.yr.aQ(this.mAdTemplate);
    }

    private void g(List<AdTemplate> list) {
        this.tz = new com.kwad.components.ad.reward.d(list, this.vb.mReportExtData, this);
        this.vb.tz = this.tz;
        this.tz.setShowLandingPage(com.kwad.sdk.core.response.b.b.db(this.mAdTemplate));
        this.tz.a(this.gF);
        this.tz.a(this.yv, this.vb.mRootContainer, this.mAdTemplate, this.vb.mApkDownloadHelper, this.vb.mScreenOrientation);
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.tz.a(new b.InterfaceC0426b() { // from class: com.kwad.components.ad.reward.presenter.s.2
            @Override // com.kwad.components.ad.l.b.InterfaceC0426b
            public final void iY() {
                com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                s.this.vb.ub = true;
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.ub = false;
        this.vb.tu.b(this.lv);
        this.vb.c(this);
        this.vb.b((a.InterfaceC0474a) this);
        com.kwad.components.ad.reward.d dVar = this.tz;
        if (dVar != null) {
            dVar.nC();
        }
        Animator animator = this.yy;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.ys;
        if (detailVideoView != null) {
            com.kwad.sdk.c.a.a.u(detailVideoView, this.yt);
        }
        Animator animator2 = this.yw;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.yy = null;
        this.yw = null;
    }

    private boolean J(boolean z) throws Resources.NotFoundException {
        int iC = c(iW());
        ab(iC);
        com.kwad.components.ad.reward.d dVar = this.tz;
        boolean zBb = dVar != null ? dVar.bb() : false;
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "webLoadSuccess: " + zBb);
        if (!zBb) {
            return false;
        }
        int iB = b(iW());
        float f = -iC;
        this.yE = f;
        Animator animatorA = a(true, f, iB, true, z);
        this.yw = animatorA;
        animatorA.start();
        Animator animatorIV = iV();
        this.yy = animatorIV;
        animatorIV.start();
        this.yp = 2;
        return true;
    }

    private void ab(int i) {
        ViewGroup.LayoutParams layoutParams = this.f769yq.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = -i;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
            layoutParams3.height = i;
            layoutParams3.bottomMargin = -i;
            this.f769yq.setLayoutParams(layoutParams3);
        }
    }

    private void K(boolean z) throws JSONException {
        Animator animatorA = a(false, (iW() - iX()) + this.yE, b(iX()), false, z);
        this.yx = animatorA;
        animatorA.start();
        com.kwad.sdk.core.local.a.aah();
        com.kwad.sdk.core.local.a.cy(this.yz);
        this.yp = 3;
        com.kwad.components.ad.reward.d dVar = this.tz;
        if (dVar != null) {
            dVar.gz();
        }
    }

    private Animator iV() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.yu, "alpha", 255.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        objectAnimatorOfFloat.setDuration(200L);
        return objectAnimatorOfFloat;
    }

    private Animator a(boolean z, float f, int i, boolean z2, boolean z3) {
        ValueAnimator valueAnimatorOfFloat;
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f + ", videoTargetHeight: " + i);
        if (z) {
            valueAnimatorOfFloat = ObjectAnimator.ofFloat(this.f769yq, "translationY", f);
        } else {
            int height = this.f769yq.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.f769yq.getLayoutParams();
            valueAnimatorOfFloat = ValueAnimator.ofFloat(height, Math.abs(f));
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.f769yq.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator objectAnimatorOfFloat = z2 ? ObjectAnimator.ofFloat(this.yr, "alpha", 0.0f, 255.0f) : null;
        final ViewGroup.LayoutParams layoutParams2 = this.xp.getLayoutParams();
        ValueAnimator valueAnimatorA = this.ys.a(this.mAdTemplate, i, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = iIntValue;
                    s.this.xp.setLayoutParams(layoutParams2);
                }
            }
        });
        long j = z3 ? this.yA : this.yB;
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(interpolatorCreate);
        if (objectAnimatorOfFloat != null) {
            if (z3) {
                animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat, valueAnimatorA);
            } else {
                animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat);
            }
        } else if (z3) {
            animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorA);
        } else {
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
        return animatorSet;
    }

    private int b(float f) {
        return (int) (com.kwad.sdk.c.a.a.p(getActivity()) - f);
    }

    private int c(float f) throws Resources.NotFoundException {
        return (int) (f + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_height) + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private float iW() {
        return com.kwad.sdk.c.a.a.o(getActivity()) / this.yC;
    }

    private float iX() {
        return com.kwad.sdk.c.a.a.o(getActivity()) / this.yD;
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0474a
    public final void onError(int i, String str) {
        com.kwad.sdk.core.d.c.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0474a
    public final void onRequestResult(int i) {
        com.kwad.sdk.core.d.c.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i);
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0474a
    public final void f(List<com.kwad.components.core.j.c> list) {
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
        if (list == null || list.size() == 0) {
            return;
        }
        this.yz = list.get(0).getAdTemplate();
        this.dw = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAdTemplate);
        arrayList.addAll(com.kwad.components.core.j.c.p(list));
        g(arrayList);
    }

    @Override // com.kwad.components.core.webview.jshandler.y.b
    public final void X(AdTemplate adTemplate) {
        com.kwad.components.core.j.c cVar = new com.kwad.components.core.j.c(adTemplate, com.kwad.components.core.j.e.AGGREGATION);
        if (this.vb != null) {
            this.vb.b(cVar);
        }
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void dc() throws JSONException, Resources.NotFoundException {
        int i;
        if (this.yz == null || (i = this.yp) == 3) {
            return;
        }
        if (i == 1) {
            J(false);
            K(false);
        } else if (i == 2) {
            K(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
