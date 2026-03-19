package com.kwad.components.ad.reward.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.n.d;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends d implements View.OnClickListener {
    private TextView hg;
    private final ViewGroup lz;
    private TextView mf;
    private ImageView vA;
    private TextView vB;
    private Button vC;
    private b vD;
    private int[] vy;
    private View vz;

    public interface b {
        void hX();

        void hY();
    }

    static /* synthetic */ Animator a(a aVar, View view) {
        return o(view);
    }

    static /* synthetic */ Animator a(a aVar, ImageView imageView, long j) {
        return a(imageView, j);
    }

    public a(Context context, ViewGroup viewGroup, int[] iArr) {
        this.vy = iArr;
        ViewGroup viewGroup2 = (ViewGroup) m.a(context, R.layout.ksad_reward_coupon_dialog, viewGroup, false);
        this.lz = viewGroup2;
        d(viewGroup2);
    }

    public final void a(b bVar) {
        this.vD = bVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hT() {
        return this.lz;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(C0434a.R(rVar.getAdTemplate()));
        this.lz.post(new AnonymousClass1(rVar, com.kwad.components.ad.reward.a.b.hM()));
    }

    /* renamed from: com.kwad.components.ad.reward.b.a$1, reason: invalid class name */
    final class AnonymousClass1 extends bh {
        final /* synthetic */ r vE;
        final /* synthetic */ long vF;

        AnonymousClass1(r rVar, long j) {
            this.vE = rVar;
            this.vF = j;
        }

        @Override // com.kwad.sdk.utils.bh
        public final void doTask() {
            a aVar = a.this;
            final Animator animatorA = a.a(aVar, aVar.vz);
            animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    animatorA.removeListener(this);
                    com.kwad.sdk.core.adlog.c.b(AnonymousClass1.this.vE.getAdTemplate(), 169, (JSONObject) null);
                    a.a(a.this, a.this.vA, AnonymousClass1.this.vF).start();
                    bx.a(new Runnable() { // from class: com.kwad.components.ad.reward.b.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.hU();
                        }
                    }, null, AnonymousClass1.this.vF);
                }
            });
            animatorA.start();
        }
    }

    private void a(C0434a c0434a) {
        if (c0434a == null) {
            return;
        }
        TextView textView = this.mf;
        if (textView != null) {
            textView.setText(c0434a.getTitle());
        }
        TextView textView2 = this.vB;
        if (textView2 != null) {
            textView2.setText(c0434a.Q(this.lz.getContext()));
        }
        TextView textView3 = this.hg;
        if (textView3 != null) {
            textView3.setText(c0434a.hV());
        }
        Button button = this.vC;
        if (button != null) {
            button.setText(c0434a.hW());
        }
    }

    private void d(ViewGroup viewGroup) {
        this.vz = viewGroup.findViewById(R.id.ksad_coupon_dialog_card);
        this.vA = (ImageView) viewGroup.findViewById(R.id.ksad_coupon_dialog_bg);
        this.mf = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_title);
        this.vB = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_content);
        this.hg = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_desc);
        Button button = (Button) viewGroup.findViewById(R.id.ksad_coupon_dialog_btn_action);
        this.vC = button;
        button.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar;
        if (!view.equals(this.vC) || (bVar = this.vD) == null) {
            return;
        }
        bVar.hX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU() {
        final Animator animatorP = p(this.vz);
        animatorP.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animatorP.removeListener(this);
                if (a.this.vD != null) {
                    a.this.vD.hY();
                }
            }
        });
        animatorP.start();
    }

    private static Animator o(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }

    private static Animator a(ImageView imageView, long j) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "alpha", imageView.getAlpha(), 0.0f);
        objectAnimatorOfFloat.setDuration(j);
        return objectAnimatorOfFloat;
    }

    private Animator p(View view) {
        ObjectAnimator objectAnimatorOfFloat;
        int[] iArrAa;
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        objectAnimatorOfFloat2.setInterpolator(interpolatorCreate);
        objectAnimatorOfFloat3.setInterpolator(interpolatorCreate);
        int[] iArr = this.vy;
        ObjectAnimator objectAnimatorOfFloat4 = null;
        if (iArr == null || iArr.length < 2 || (iArrAa = com.kwad.sdk.c.a.a.aa(view)) == null) {
            objectAnimatorOfFloat = null;
        } else {
            Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "translationX", this.vy[0] - iArrAa[0]);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", this.vy[1] - iArrAa[1]);
            objectAnimatorOfFloat4.setInterpolator(interpolatorCreate2);
            objectAnimatorOfFloat.setInterpolator(interpolatorCreate2);
        }
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat5.setDuration(200L);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat6.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat5, objectAnimatorOfFloat6);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        if (objectAnimatorOfFloat4 != null) {
            animatorSet2.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, animatorSet, objectAnimatorOfFloat4, objectAnimatorOfFloat);
        } else {
            animatorSet2.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, animatorSet);
        }
        return animatorSet2;
    }

    /* renamed from: com.kwad.components.ad.reward.b.a$a, reason: collision with other inner class name */
    static class C0434a {
        private CharSequence title;
        private CharSequence vL;
        private CharSequence vM;
        private CharSequence vN;

        private C0434a(CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.vL = couponInfo.displayValue;
            if (TextUtils.isEmpty(couponInfo.displayBase)) {
                this.vM = "";
            } else {
                this.vM = String.format("满%s可用", couponInfo.displayBase);
            }
            this.vN = couponInfo.displayActionWords;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final CharSequence Q(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.ksad_coupon_dialog_value_prefix_text_size));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.vL));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public final CharSequence hV() {
            return this.vM;
        }

        public final CharSequence hW() {
            return this.vN;
        }

        public static C0434a R(AdTemplate adTemplate) {
            AdProductInfo adProductInfoDj = com.kwad.sdk.core.response.b.a.dj(e.eP(adTemplate));
            if (adProductInfoDj == null || adProductInfoDj.couponList == null || adProductInfoDj.couponList.size() <= 0) {
                return null;
            }
            return a(adProductInfoDj.couponList.get(0));
        }

        private static C0434a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C0434a(couponInfo);
        }
    }
}
