package com.baidu.mobads.container.util.animation;

import android.animation.AnimatorSet;
import android.view.View;
import com.baidu.mobads.container.util.animation.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class v extends e.a {
    final /* synthetic */ View a;

    v(View view) {
        this.a = view;
    }

    @Override // com.baidu.mobads.container.util.animation.e.a
    public void a(AnimatorSet animatorSet) {
        e.a(this.a, animatorSet);
        animatorSet.start();
    }
}
