package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.ls;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class UIChangedCallbackImpl implements UIChangedCallback {
    private ls<String> a = null;
    private ls<String> b = null;

    @Override // com.qq.e.comm.plugin.callback.biz.UIChangedCallback
    public ls<String> r() {
        if (this.a == null) {
            this.a = new ls<>();
        }
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.callback.biz.UIChangedCallback
    public ls<String> e() {
        if (this.b == null) {
            this.b = new ls<>();
        }
        return this.b;
    }
}
