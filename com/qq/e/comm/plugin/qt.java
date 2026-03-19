package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qt {
    private final int a;
    private final int b;
    private final boolean c;
    private String d;

    public qt(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    private HttpURLConnection a(String str, long j, long j2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(wr.a(str, 2)).openConnection();
        String str2 = this.d;
        if (str2 != null && !str2.startsWith(ILogConst.CACHE_PLAY_REASON_NULL)) {
            httpURLConnection.setRequestProperty(r30.b(), r30.a(this.d));
        } else {
            httpURLConnection.setRequestProperty(r30.b(), r30.a());
        }
        httpURLConnection.setConnectTimeout(this.a);
        httpURLConnection.setReadTimeout(this.b);
        if (this.c) {
            String strA = a(j, j2);
            if (!TextUtils.isEmpty(strA)) {
                httpURLConnection.setRequestProperty("Range", strA);
            }
        }
        return httpURLConnection;
    }

    private String a(long j, long j2) {
        if (j < 0) {
            return null;
        }
        if (j2 > 0) {
            return "bytes=" + j + "-" + ((j + j2) - 1);
        }
        return "bytes=" + j + "-";
    }

    public pt a(String str, long j, long j2, boolean z) throws IOException {
        HttpURLConnection httpURLConnectionA = a(str, j, j2);
        if (z) {
            httpURLConnectionA.setRequestMethod("HEAD");
        } else {
            httpURLConnectionA.setRequestMethod("GET");
        }
        return new pt(httpURLConnectionA, 0, null);
    }

    public void a(String str) {
        this.d = str;
    }
}
