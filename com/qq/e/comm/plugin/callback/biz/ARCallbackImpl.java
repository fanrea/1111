package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.ls;
import com.qq.e.comm.plugin.y1;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class ARCallbackImpl implements ARCallback {
    private ls<y1> a = null;

    @Override // com.qq.e.comm.plugin.callback.biz.ARCallback
    public ls<y1> J() {
        if (this.a == null) {
            this.a = new ls<>();
        }
        return this.a;
    }
}
