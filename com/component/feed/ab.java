package com.component.feed;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ m a;

    ab(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.ao) {
            com.component.b.a.a().a(this.a.ap, "ic_white_voice");
        } else {
            com.component.b.a.a().a(this.a.ap, "ic_white_voice_mute");
        }
        this.a.ao = !this.a.ao;
        k.a().a(this.a.ao);
        this.a.x.b(this.a.ao);
    }
}
