package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.ls;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class LPCallbackImpl implements LPCallback {
    private ls<Void> a = null;
    private ls<Void> b = null;

    @Override // com.qq.e.comm.plugin.callback.biz.LPCallback
    public ls<Void> o() {
        if (this.a == null) {
            this.a = new ls<>();
        }
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.callback.biz.LPCallback
    public ls<Void> onClose() {
        if (this.b == null) {
            this.b = new ls<>();
        }
        return this.b;
    }
}
