package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.ls;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class ClickCallbackImpl implements ClickCallback {
    private ls<Void> a = null;

    @Override // com.qq.e.comm.plugin.callback.biz.ClickCallback
    public ls<Void> O() {
        if (this.a == null) {
            this.a = new ls<>();
        }
        return this.a;
    }
}
