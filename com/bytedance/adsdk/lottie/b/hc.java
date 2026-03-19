package com.bytedance.adsdk.lottie.b;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements an {
    @Override // com.bytedance.adsdk.lottie.b.an
    public c d(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new d(httpURLConnection);
    }
}
