package com.bytedance.sdk.djx.core.business.web.bridge;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
interface IJsBridge {
    void invoke(String str);

    void on(String str);

    void release();

    void send(String str);

    void sendOn(String str, Java2jsMsg java2jsMsg);

    String version();
}
