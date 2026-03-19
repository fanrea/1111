package com.baidu.mobads.container.rewardvideo;

import android.animation.Animator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aw implements Animator.AnimatorListener {
    final /* synthetic */ NativeRewardActivity a;

    aw(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a.L.a("RemoteRewardActivity", "Tail view anim start.");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.L.a("RemoteRewardActivity", "Tail view anim end.");
        this.a.showEndPage(true);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a.L.b("RemoteRewardActivity", "Tail view anim cancel.");
        this.a.showEndPage(true);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.a.L.a("RemoteRewardActivity", "Tail view anim repeat.");
    }
}
