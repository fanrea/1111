package com.component.a.g.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.util.animation.a;
import com.component.a.g.c.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class u extends m.f.a {
    final /* synthetic */ m.f d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    u(m.f fVar, ViewGroup viewGroup, com.component.feed.ax axVar, com.component.a.a.f fVar2, com.component.a.a.q qVar) {
        super(viewGroup, axVar, fVar2, qVar);
        this.d = fVar;
    }

    @Override // com.component.a.g.c.m.f.a, com.component.a.g.c.m.c
    public void a(boolean z) {
        a("已领取更多奖励");
        if (this.a != null) {
            boolean z2 = com.component.a.i.w.a(this.a) || this.d.k();
            for (int i = 0; i < this.a.getChildCount(); i++) {
                View childAt = this.a.getChildAt(i);
                if (!z2) {
                    childAt.setAlpha(0.5f);
                } else {
                    com.baidu.mobads.container.util.animation.a.a(childAt).a(200).b("1").c("0.5").a(a.b.ALPHA).i();
                }
            }
        }
    }
}
