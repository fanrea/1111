package com.kwai.video.ksliveplayer.switcher;

import com.alipay.sdk.m.l.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public enum ResolverType {
    LOCAL("local"),
    HTTP(a.r),
    LOCAL_AND_HTTP("local|http");

    public final String mValue;

    ResolverType(String str) {
        this.mValue = str;
    }
}
