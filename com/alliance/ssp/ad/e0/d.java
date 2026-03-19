package com.alliance.ssp.ad.e0;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* compiled from: InitConfigRequester.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    public static final d b = new d();
    public OkHttpClient a = new OkHttpClient().newBuilder().connectTimeout(com.alipay.sdk.m.u.b.a, TimeUnit.MILLISECONDS).build();
}
