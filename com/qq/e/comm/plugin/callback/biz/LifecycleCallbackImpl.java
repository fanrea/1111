package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.ls;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class LifecycleCallbackImpl implements LifecycleCallback {
    private ls<LifecycleCallback.a> a = null;

    @Override // com.qq.e.comm.plugin.callback.biz.LifecycleCallback
    public ls<LifecycleCallback.a> I() {
        if (this.a == null) {
            this.a = new ls<>();
        }
        return this.a;
    }
}
