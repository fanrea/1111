package com.github.gzuliyujiang.oaid;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface IRegisterCallback {
    default void onComplete(String str, Exception exc) {
    }

    @Deprecated
    default void onComplete() {
        onComplete("", null);
    }
}
