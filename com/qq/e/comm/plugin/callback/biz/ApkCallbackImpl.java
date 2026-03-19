package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.ls;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class ApkCallbackImpl implements ApkCallback {
    private ls<Integer> a = null;
    private ls<Integer> b = null;

    @Override // com.qq.e.comm.plugin.callback.biz.ApkCallback
    public ls<Integer> b0() {
        if (this.a == null) {
            this.a = new ls<>();
        }
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.callback.biz.ApkCallback
    public ls<Integer> g() {
        if (this.b == null) {
            this.b = new ls<>();
        }
        return this.b;
    }
}
