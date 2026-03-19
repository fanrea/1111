package com.component.feed;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements View.OnClickListener {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mobads.container.adrequest.j jVarE;
        if ((this.a.r instanceof com.baidu.mobads.container.a.d) && (jVarE = ((com.baidu.mobads.container.a.d) this.a.r).e()) != null && jVarE.getOriginJsonObject() != null) {
            int iOptInt = jVarE.getOriginJsonObject().optInt("dl_dialog", -1);
            if (iOptInt == 0) {
                this.a.J = false;
            } else if (iOptInt == 1) {
                this.a.J = true;
            }
        }
        this.a.r.handleClick(view, this.a.J);
    }
}
