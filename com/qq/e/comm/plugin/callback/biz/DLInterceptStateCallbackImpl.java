package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.ls;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class DLInterceptStateCallbackImpl implements DLInterceptStateCallback {
    private ls<Integer> a = null;

    @Override // com.qq.e.comm.plugin.callback.biz.DLInterceptStateCallback
    public ls<Integer> E() {
        if (this.a == null) {
            this.a = new ls<>();
        }
        return this.a;
    }
}
