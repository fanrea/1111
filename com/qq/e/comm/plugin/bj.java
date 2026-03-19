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
public class bj implements an {
    private static final String a = "kg";

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
        String strA;
        int iA;
        aw awVarA = aVar.a();
        if (awVarA.a()) {
            return aVar.a(awVarA);
        }
        Map<String, String> mapP = awVarA.p();
        if (mapP != null) {
            String str = mapP.get("IAS_REQ_TYPE");
            String strE = awVarA.e();
            if (str != null && !TextUtils.isEmpty(strE)) {
                strA = wr.a(awVarA.h(), 1);
                str.hashCode();
                switch (str) {
                    case "c":
                        Pair<Boolean, String> pairA = aj.b().a(strA, "c");
                        qm$h$$ExternalSyntheticBackport0.m(pairA);
                        if (((Boolean) pairA.first).booleanValue() && !TextUtils.isEmpty((CharSequence) pairA.second)) {
                            try {
                                hw hwVarA = a((String) pairA.second, awVarA);
                                int iA2 = hwVarA == null ? 0 : hwVarA.a();
                                if (iA2 == 200 || (as.a(iA2) && !awVarA.j())) {
                                    aj.b().a(2);
                                    return hwVarA;
                                }
                            } catch (Exception e) {
                                e.toString();
                            }
                            hw hwVarA2 = aVar.a(awVarA);
                            iA = hwVarA2 != null ? hwVarA2.a() : 0;
                            if (iA == 200 || (as.a(iA) && !awVarA.j())) {
                                aj.b().b(2);
                            }
                            return hwVarA2;
                        }
                        break;
                    case "v":
                        Pair<Boolean, String> pairA2 = aj.b().a(strA, "v");
                        qm$h$$ExternalSyntheticBackport0.m(pairA2);
                        if (((Boolean) pairA2.first).booleanValue() && !TextUtils.isEmpty((CharSequence) pairA2.second)) {
                            try {
                                hw hwVarA3 = a((String) pairA2.second, awVarA);
                                int iA3 = hwVarA3 == null ? 0 : hwVarA3.a();
                                if (iA3 == 200 || iA3 == 204) {
                                    aj.b().a(3);
                                    return hwVarA3;
                                }
                            } catch (Exception e2) {
                                e2.toString();
                            }
                            hw hwVarA4 = aVar.a(awVarA);
                            iA = hwVarA4 != null ? hwVarA4.a() : 0;
                            if (iA == 200 || iA == 204) {
                                aj.b().b(3);
                            }
                            return hwVarA4;
                        }
                        break;
                    case "mi":
                        Pair<Boolean, String> pairA3 = aj.b().a(strA, "mi");
                        qm$h$$ExternalSyntheticBackport0.m(pairA3);
                        if (((Boolean) pairA3.first).booleanValue() && !TextUtils.isEmpty((CharSequence) pairA3.second)) {
                            try {
                                hw hwVarA5 = a((String) pairA3.second, awVarA);
                                if (hwVarA5 != null && hwVarA5.a() == 200) {
                                    aj.b().a(1);
                                    return hwVarA5;
                                }
                            } catch (Exception e3) {
                                e3.toString();
                            }
                            hw hwVarA6 = aVar.a(awVarA);
                            if (hwVarA6 != null && hwVarA6.a() == 200) {
                                aj.b().b(1);
                            }
                            return hwVarA6;
                        }
                        break;
                }
            }
        }
        return aVar.a(awVarA);
    }

    private HttpURLConnection a(aw awVar, HttpURLConnection httpURLConnection) {
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
        return httpURLConnection;
    }

    private hw a(String str, aw awVar) throws Exception {
        URL url = new URL(str);
        HttpURLConnection httpURLConnectionA = a(awVar, (HttpURLConnection) url.openConnection());
        pr.c cVarA = new pr.c(bw.b(awVar)).a();
        try {
            hw hwVarA = awVar.a(a(awVar, url, httpURLConnectionA));
            pr.a().a(cVarA.a(true));
            return hwVarA;
        } catch (Exception e) {
            pr.a().a(cVarA.a(false));
            throw e;
        }
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
