package com.kwai.video.ksvodplayerkit.HttpDns;

import com.alipay.sdk.m.l.a;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public enum ResolverType {
    LOCAL("local"),
    HTTP(a.r),
    LOCAL_AND_HTTP("local|http");

    public final String mValue;

    ResolverType(String str) {
        this.mValue = str;
    }
}
