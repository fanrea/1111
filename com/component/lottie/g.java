package com.component.lottie;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements ay<Throwable> {
    final /* synthetic */ LottieAnimationView a;

    g(LottieAnimationView lottieAnimationView) {
        this.a = lottieAnimationView;
    }

    @Override // com.component.lottie.ay
    public void a(Throwable th) {
        if (this.a.f != 0) {
            this.a.setImageResource(this.a.f);
        }
        (this.a.e == null ? LottieAnimationView.b : this.a.e).a(th);
    }
}
