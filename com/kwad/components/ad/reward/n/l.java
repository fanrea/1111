package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.bx;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l extends s implements View.OnClickListener {
    private Set<ImageView> EA = new HashSet();
    private TextView EB;
    private Animator ED;
    private ImageView Ex;
    private TextView Ey;
    private View Ez;
    private TextView hf;
    private TextView hg;
    private TextView hh;
    private ImageView jY;
    private com.kwad.components.ad.reward.g vb;

    static /* synthetic */ Animator a(l lVar, View view) {
        return t(view);
    }

    static /* synthetic */ Animator a(l lVar, View view, long j, float f) {
        return a(view, 100L, 8.0f);
    }

    public l(com.kwad.components.ad.reward.g gVar) {
        this.vb = gVar;
    }

    public final void h(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_reward_live_subscribe_stub, R.id.ksad_reward_live_subscribe_root);
        initView();
    }

    private void initView() {
        if (this.xM == null) {
            return;
        }
        this.Ey = (TextView) this.xM.findViewById(R.id.ksad_reward_live_subscribe_badge);
        this.Ex = (ImageView) this.xM.findViewById(R.id.ksad_reward_live_subscribe_kwai_logo);
        this.jY = (ImageView) this.xM.findViewById(R.id.ksad_reward_live_subscribe_icon);
        this.hf = (TextView) this.xM.findViewById(R.id.ksad_reward_live_subscribe_name);
        this.hg = (TextView) this.xM.findViewById(R.id.ksad_reward_live_subscribe_desc);
        this.hh = (TextView) this.xM.findViewById(R.id.ksad_reward_live_subscribe_btn_follow);
        this.Ez = this.xM.findViewById(R.id.ksad_reward_live_subscribe_follower_area);
        ImageView imageView = (ImageView) this.xM.findViewById(R.id.ksad_reward_live_subscribe_follower_icon1);
        ImageView imageView2 = (ImageView) this.xM.findViewById(R.id.ksad_reward_live_subscribe_follower_icon2);
        ImageView imageView3 = (ImageView) this.xM.findViewById(R.id.ksad_reward_live_subscribe_follower_icon3);
        this.EA.add(imageView);
        this.EA.add(imageView2);
        this.EA.add(imageView3);
        this.EB = (TextView) this.xM.findViewById(R.id.ksad_reward_live_subscribe_count);
        this.xM.setOnClickListener(this);
        this.hh.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void a(r rVar) throws Resources.NotFoundException {
        super.a(rVar);
        AdTemplate adTemplate = rVar.getAdTemplate();
        if (adTemplate != null) {
            a(com.kwad.components.ad.reward.model.a.T(adTemplate));
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void onUnbind() {
        super.onUnbind();
        Animator animator = this.ED;
        if (animator != null) {
            animator.cancel();
            this.ED = null;
        }
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) throws Resources.NotFoundException {
        this.hf.setText(aVar.getTitle());
        this.hg.setText(aVar.iv());
        this.hh.setText(aVar.is());
        String strHs = aVar.hs();
        Drawable drawable = this.jY.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar);
        KSImageLoader.loadCircleIcon(this.jY, strHs, drawable);
        String strAJ = com.kwad.components.ad.e.b.aJ();
        if (!bq.isNullString(strAJ)) {
            KSImageLoader.loadImage(this.Ex, strAJ, aVar.im());
        }
        if (aVar.it()) {
            this.Ez.setVisibility(0);
            String strIr = aVar.ir();
            if (!TextUtils.isEmpty(strIr)) {
                this.EB.setText(String.format("%s已预约直播", strIr));
            }
            if (aVar.iu() != null) {
                List<String> listIu = aVar.iu();
                int i = 0;
                for (ImageView imageView : this.EA) {
                    if (i < listIu.size()) {
                        imageView.setVisibility(0);
                        KSImageLoader.loadCircleIcon(imageView, listIu.get(i), drawable);
                    }
                    i++;
                }
                return;
            }
            return;
        }
        this.Ez.setVisibility(8);
    }

    public final void ln() {
        lo();
        lp();
    }

    private void lo() {
        this.Ey.postDelayed(new bh() { // from class: com.kwad.components.ad.reward.n.l.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                l lVar = l.this;
                lVar.ED = l.a(lVar, lVar.Ey, 100L, 8.0f);
                l.this.ED.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.l.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (l.this.ED != null) {
                            l.this.ED.start();
                        }
                    }
                });
                l.this.ED.start();
            }
        }, 500L);
    }

    private void lp() {
        bx.runOnUiThreadDelay(new bh() { // from class: com.kwad.components.ad.reward.n.l.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                l lVar = l.this;
                l.a(lVar, lVar.Ez).start();
            }
        }, 2000L);
    }

    private static Animator a(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(view.getHeight());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(100L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f).setDuration(j);
        float f2 = -f;
        long j2 = j * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f, f2).setDuration(j2);
        duration2.setInterpolator(interpolatorCreate);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f2, f).setDuration(j2);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f, f2).setDuration(j2);
        duration4.setInterpolator(interpolatorCreate);
        animatorSet.playSequentially(objectAnimatorOfFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f2, 0.0f).setDuration(j));
        return animatorSet;
    }

    private static Animator t(View view) {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", view.getResources().getDimension(R.dimen.ksad_live_subscribe_card_count_area_trans_y)).setDuration(250L);
        duration.setInterpolator(interpolatorCreate);
        return duration;
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void ac(boolean z) {
        super.ac(z);
        Context context = this.xM.getContext();
        if (aq.apb()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.xM.getLayoutParams();
        layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.xM.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.hh)) {
            this.vb.a(1, view.getContext(), 29, 1);
        } else if (view.equals(this.xM)) {
            this.vb.a(1, view.getContext(), 53, 2);
        }
    }
}
