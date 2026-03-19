package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.ls;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class JumpOutBizCallbackImpl implements JumpOutBizCallback {
    private ls<Integer> a = null;
    private ls<Integer> b = null;
    private ls<Integer> c = null;
    private ls<Integer> d = null;

    @Override // com.qq.e.comm.plugin.callback.biz.JumpOutBizCallback
    public ls<Integer> h() {
        if (this.a == null) {
            this.a = new ls<>();
        }
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.callback.biz.JumpOutBizCallback
    public ls<Integer> d() {
        if (this.b == null) {
            this.b = new ls<>();
        }
        return this.b;
    }

    @Override // com.qq.e.comm.plugin.callback.biz.JumpOutBizCallback
    public ls<Integer> x() {
        if (this.c == null) {
            this.c = new ls<>();
        }
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.callback.biz.JumpOutBizCallback
    public ls<Integer> a0() {
        if (this.d == null) {
            this.d = new ls<>();
        }
        return this.d;
    }
}
