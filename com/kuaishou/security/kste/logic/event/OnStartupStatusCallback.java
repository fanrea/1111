package com.kuaishou.security.kste.logic.event;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface OnStartupStatusCallback {
    void onError(KSTEException kSTEException);

    void onFailture(String str);

    void onSuccess(String str);

    void report(String str, String str2);
}
