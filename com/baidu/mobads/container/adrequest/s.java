package com.baidu.mobads.container.adrequest;

import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class s implements Runnable {
    final /* synthetic */ o a;

    s(o oVar) {
        this.a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ax.a(this.a.u(), bq.a(), true, true).loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
        } catch (Exception e) {
        }
    }
}
