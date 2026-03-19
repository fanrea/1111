package com.qq.e.comm.plugin.callback.biz;

import com.qq.e.comm.plugin.ls;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class VideoDownloadErrorCallbackImpl implements VideoDownloadErrorCallback {
    private ls<Void> a = null;

    @Override // com.qq.e.comm.plugin.callback.biz.VideoDownloadErrorCallback
    public ls<Void> y() {
        if (this.a == null) {
            this.a = new ls<>();
        }
        return this.a;
    }
}
