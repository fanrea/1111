package com.component.lottie;

import java.util.concurrent.Callable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements Callable<bb<t>> {
    final /* synthetic */ int a;
    final /* synthetic */ LottieAnimationView b;

    h(LottieAnimationView lottieAnimationView, int i) {
        this.b = lottieAnimationView;
        this.a = i;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bb<t> call() {
        if (this.b.k) {
            return u.b(this.b.getContext(), this.a);
        }
        return u.b(this.b.getContext(), this.a, null);
    }
}
