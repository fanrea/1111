package com.baidu.mobads.container.util.animation;

import android.animation.Animator;
import java.util.Comparator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class u implements Comparator<Animator> {
    u() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Animator animator, Animator animator2) {
        long startDelay = animator.getStartDelay();
        long startDelay2 = animator2.getStartDelay();
        if (startDelay > startDelay2) {
            return -1;
        }
        if (startDelay < startDelay2) {
            return 1;
        }
        return 0;
    }
}
