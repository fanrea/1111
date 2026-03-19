package com.qq.e.comm.plugin.callback.biz;

import android.util.Pair;
import com.qq.e.comm.plugin.h4;
import com.qq.e.comm.plugin.ls;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class DynamicAdCallbackImpl implements DynamicAdCallback {
    private ls<String> a = null;
    private ls<Pair<String, h4>> b = null;

    @Override // com.qq.e.comm.plugin.callback.biz.DynamicAdCallback
    public ls<String> loadAd() {
        if (this.a == null) {
            this.a = new ls<>();
        }
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.callback.biz.DynamicAdCallback
    public ls<Pair<String, h4>> N() {
        if (this.b == null) {
            this.b = new ls<>();
        }
        return this.b;
    }
}
