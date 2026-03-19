package com.kwad.components.ct.tube.panel.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.tube.panel.b.a {
    private LinearLayout aYe;
    private ObjectAnimator aYf;
    private final com.kwad.components.ct.tube.panel.a.b aYg = new AnonymousClass1();

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        com.kwad.components.ct.tube.panel.a.c.KJ().a(this.aYg);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_tube_pannel);
        this.aYe = linearLayout;
        linearLayout.setTranslationY(com.kwad.sdk.c.a.a.a(getContext(), 630.0f));
    }

    @Override // com.kwad.components.ct.tube.panel.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.aYe, "translationY", com.kwad.sdk.c.a.a.a(getContext(), 630.0f), 0.0f);
        this.aYf = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(300L);
        this.aYf.start();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ct.tube.panel.a.c.KJ().b(this.aYg);
    }

    /* renamed from: com.kwad.components.ct.tube.panel.c.e$1, reason: invalid class name */
    final class AnonymousClass1 implements com.kwad.components.ct.tube.panel.a.b {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ct.tube.panel.a.b
        public final void f(KsFragment ksFragment) {
            if (ksFragment != e.this.aXj.alG) {
                return;
            }
            e eVar = e.this;
            eVar.aYf = ObjectAnimator.ofFloat(eVar.aYe, "translationY", 0.0f, com.kwad.sdk.c.a.a.a(e.this.getContext(), 630.0f));
            e.this.aYf.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.tube.panel.c.e.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    e.this.aYe.post(new bh() { // from class: com.kwad.components.ct.tube.panel.c.e.1.1.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            KsFragment parentFragment = e.this.aXj.alG.getParentFragment();
                            if (parentFragment != null) {
                                parentFragment.getChildFragmentManager().beginTransaction().remove(e.this.aXj.alG).commitAllowingStateLoss();
                            }
                        }
                    });
                }
            });
            e.this.aYf.setDuration(300L);
            e.this.aYf.start();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.aYf.isRunning()) {
            this.aYf.cancel();
        }
    }
}
