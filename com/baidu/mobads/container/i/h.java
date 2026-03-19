package com.baidu.mobads.container.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h extends com.baidu.mobads.container.d.a {
    final /* synthetic */ b a;

    h(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        try {
            if (!this.a.i) {
                if (com.baidu.mobads.container.util.e.a.k(this.a.mAppContext)) {
                    this.a.mAdContainerCxt.v().post(new i(this));
                } else if (!this.a.mWebView.e()) {
                    this.a.e();
                }
            }
            return null;
        } catch (Exception e) {
            this.a.mAdLogger.a(e);
            return null;
        }
    }
}
