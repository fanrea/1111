package com.component.a.g.c;

import android.animation.AnimatorSet;
import android.view.View;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.animation.e;
import com.component.a.g.c.aa;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aj extends e.a {
    final /* synthetic */ View a;
    final /* synthetic */ aa.c b;

    aj(aa.c cVar, View view) {
        this.b = cVar;
        this.a = view;
    }

    @Override // com.baidu.mobads.container.util.animation.e.a
    public void a(AnimatorSet animatorSet) {
        animatorSet.play(com.baidu.mobads.container.util.animation.j.b(com.baidu.mobads.container.util.animation.a.a(this.a).a(240).b("0").c("1").a(a.b.ALPHA)));
        com.baidu.mobads.container.util.animation.e.a(this.a, animatorSet);
        animatorSet.start();
    }
}
