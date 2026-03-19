package com.component.feed;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p implements View.OnClickListener {
    final /* synthetic */ m a;

    p(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.x != null && !this.a.x.f()) {
            return;
        }
        if (this.a.aq == 0.75f) {
            this.a.aq = 1.0f;
            com.component.b.a.a().a(this.a.ar, "ic_white_speed100");
        } else if (this.a.aq == 1.0f) {
            this.a.aq = 1.25f;
            com.component.b.a.a().a(this.a.ar, "ic_white_speed125");
        } else if (this.a.aq == 1.25f) {
            this.a.aq = 1.5f;
            com.component.b.a.a().a(this.a.ar, "ic_white_speed150");
        } else if (this.a.aq == 1.5f) {
            this.a.aq = 1.75f;
            com.component.b.a.a().a(this.a.ar, "ic_white_speed175");
        } else if (this.a.aq == 1.75f) {
            this.a.aq = 2.0f;
            com.component.b.a.a().a(this.a.ar, "ic_white_speed200");
        } else if (this.a.aq == 2.0f) {
            this.a.aq = 0.75f;
            com.component.b.a.a().a(this.a.ar, "ic_white_speed075");
        }
        if (this.a.x != null) {
            this.a.x.a(this.a.aq);
        }
        k.a().a(this.a.aq);
    }
}
