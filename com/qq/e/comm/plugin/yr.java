package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.an;
import com.qq.e.comm.plugin.aw;
import com.qq.e.comm.plugin.pr;
import java.io.BufferedOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yr implements an {
    private static final String c = "jh";
    private String a;
    private Pair<Integer, Integer> b;

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[aw.a.values().length];
            a = iArr;
            try {
                iArr[aw.a.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[aw.a.GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.qq.e.comm.plugin.an
    public hw a(an.a aVar) throws Exception {
        HttpURLConnection httpURLConnection;
        boolean zBooleanValue;
        Pair<HttpURLConnection, Boolean> pairB;
        aw awVarA = aVar.a();
        if (awVarA.a()) {
            String str = jh.e;
            return aVar.a(awVarA);
        }
        if (!a(awVarA)) {
            return aVar.a(awVarA);
        }
        HttpURLConnection httpURLConnectionA = null;
        try {
            URL url = new URL(wr.a(awVarA.h(), 1));
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                if (!awVarA.k() || (pairB = as.b(httpURLConnection2, url)) == null) {
                    httpURLConnection = httpURLConnection2;
                    zBooleanValue = false;
                } else {
                    HttpURLConnection httpURLConnection3 = (HttpURLConnection) pairB.first;
                    try {
                        zBooleanValue = ((Boolean) pairB.second).booleanValue();
                        if (httpURLConnection3 == null) {
                            return null;
                        }
                        httpURLConnection = httpURLConnection3;
                    } catch (Exception e) {
                        e = e;
                        httpURLConnectionA = httpURLConnection3;
                        e.toString();
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                        return aVar.a(awVarA);
                    }
                }
                httpURLConnectionA = a(awVarA, httpURLConnection);
                pr.c cVarA = new pr.c(bw.b(awVarA)).a();
                try {
                    httpURLConnectionA = a(awVarA, url, httpURLConnectionA);
                    hw hwVarA = awVarA.a(httpURLConnectionA);
                    pr.a().a(cVarA.a(true));
                    if (!zBooleanValue) {
                        as.a(httpURLConnectionA, url);
                    }
                    return hwVarA;
                } catch (Exception e2) {
                    pr.a().a(cVarA.a(false));
                    throw e2;
                }
            } catch (Exception e3) {
                httpURLConnectionA = httpURLConnection2;
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    private HttpURLConnection a(aw awVar, HttpURLConnection httpURLConnection) {
        Pair<Integer, Integer> pair;
        for (Map.Entry<String, String> entry : awVar.q().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnection.setRequestProperty(r30.b(), r30.a());
        if (awVar.g() > 0) {
            httpURLConnection.setConnectTimeout(awVar.g());
        } else {
            httpURLConnection.setConnectTimeout(30000);
        }
        if (awVar.b() > 0) {
            httpURLConnection.setReadTimeout(awVar.b());
        } else {
            httpURLConnection.setReadTimeout(30000);
        }
        if (!TextUtils.isEmpty(this.a) && (pair = this.b) != null && ((Integer) pair.first).intValue() > 0 && ((Integer) this.b.second).intValue() > 0) {
            httpURLConnection.setConnectTimeout(((Integer) this.b.first).intValue());
            int iIntValue = ((Integer) this.b.second).intValue() - ((Integer) this.b.first).intValue();
            if (iIntValue <= 0) {
                iIntValue = ((Integer) this.b.first).intValue();
            }
            httpURLConnection.setReadTimeout(iIntValue);
            qm$h$$ExternalSyntheticBackport0.m(this.b.first);
            qm$h$$ExternalSyntheticBackport0.m(this.b.second);
        }
        return httpURLConnection;
    }

    private boolean a(aw awVar) {
        Map<String, String> mapP = awVar.p();
        if (mapP == null) {
            return false;
        }
        String str = mapP.get("NET_STRATEGY");
        this.a = str;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Pair<Integer, Integer> pairA = jh.c().a(this.a);
        this.b = pairA;
        if (pairA == null || ((Integer) pairA.first).intValue() <= 0 || ((Integer) this.b.second).intValue() <= 0) {
            return false;
        }
        qm$h$$ExternalSyntheticBackport0.m(this.b.first);
        qm$h$$ExternalSyntheticBackport0.m(this.b.second);
        mapP.put("CURRENT_NET", String.valueOf(jh.c().b()));
        return true;
    }

    private HttpURLConnection a(aw awVar, URL url, HttpURLConnection httpURLConnection) throws Exception {
        int i = a.a[awVar.o().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return httpURLConnection;
            }
            url.toString();
            boolean zJ = awVar.j();
            httpURLConnection.setInstanceFollowRedirects(zJ);
            return zJ ? as.a(httpURLConnection) : httpURLConnection;
        }
        httpURLConnection.setDoOutput(true);
        if (!awVar.j()) {
            httpURLConnection.setInstanceFollowRedirects(false);
        }
        if (awVar.d()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        byte[] bArrC = awVar.c();
        if (bArrC == null || bArrC.length <= 0) {
            return httpURLConnection;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bArrC);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        return httpURLConnection;
    }
}
