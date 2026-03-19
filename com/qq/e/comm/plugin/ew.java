package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.aw;
import java.io.BufferedOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ew implements an {
    private boolean a = false;

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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[PHI: r0
  0x0059: PHI (r0v5 java.net.HttpURLConnection) = (r0v4 java.net.HttpURLConnection), (r0v13 java.net.HttpURLConnection), (r0v13 java.net.HttpURLConnection) binds: [B:11:0x0036, B:13:0x0042, B:15:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    @Override // com.qq.e.comm.plugin.an
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.qq.e.comm.plugin.hw a(com.qq.e.comm.plugin.an.a r8) throws java.lang.Exception {
        /*
            r7 = this;
            com.qq.e.comm.plugin.aw r8 = r8.a()
            java.lang.String r0 = r8.h()
            r1 = 1
            java.lang.String r0 = com.qq.e.comm.plugin.wr.a(r0, r1)
            java.net.URL r2 = new java.net.URL
            r2.<init>(r0)
            boolean r0 = r7.a(r8)
            r3 = 0
            if (r0 == 0) goto L34
            java.lang.String r0 = com.qq.e.comm.plugin.jh.e
            com.qq.e.comm.plugin.jh r0 = com.qq.e.comm.plugin.jh.c()
            android.net.Network r0 = r0.d()
            if (r0 == 0) goto L34
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 21
            if (r4 < r5) goto L34
            java.net.URLConnection r0 = r0.openConnection(r2)
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            r7.a = r1
            goto L35
        L34:
            r0 = r3
        L35:
            r4 = 0
            if (r0 != 0) goto L59
            java.net.URLConnection r0 = r2.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            boolean r5 = r8.k()
            if (r5 == 0) goto L59
            android.util.Pair r5 = com.qq.e.comm.plugin.as.b(r0, r2)
            if (r5 == 0) goto L59
            java.lang.Object r0 = r5.first
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            java.lang.Object r5 = r5.second
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r0 != 0) goto L5a
            return r3
        L59:
            r5 = 0
        L5a:
            java.net.HttpURLConnection r0 = r7.a(r8, r0)
            float r3 = com.qq.e.comm.plugin.bw.b(r8)
            com.qq.e.comm.plugin.pr$c r6 = new com.qq.e.comm.plugin.pr$c
            r6.<init>(r3)
            com.qq.e.comm.plugin.pr$c r3 = r6.a()
            java.net.HttpURLConnection r0 = r7.a(r8, r2, r0)     // Catch: java.lang.Exception -> L93
            com.qq.e.comm.plugin.hw r8 = r8.a(r0)     // Catch: java.lang.Exception -> L93
            com.qq.e.comm.plugin.pr r6 = com.qq.e.comm.plugin.pr.a()     // Catch: java.lang.Exception -> L93
            com.qq.e.comm.plugin.pr$c r1 = r3.a(r1)     // Catch: java.lang.Exception -> L93
            r6.a(r1)     // Catch: java.lang.Exception -> L93
            if (r5 != 0) goto L87
            boolean r1 = r7.a
            if (r1 != 0) goto L87
            com.qq.e.comm.plugin.as.a(r0, r2)
        L87:
            if (r8 == 0) goto L92
            boolean r0 = r7.a
            if (r0 == 0) goto L92
            java.lang.String r0 = com.qq.e.comm.plugin.jh.e
            r8.a()
        L92:
            return r8
        L93:
            r8 = move-exception
            com.qq.e.comm.plugin.pr r0 = com.qq.e.comm.plugin.pr.a()
            com.qq.e.comm.plugin.pr$c r1 = r3.a(r4)
            r0.a(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.ew.a(com.qq.e.comm.plugin.an$a):com.qq.e.comm.plugin.hw");
    }

    private boolean a(aw awVar) throws NumberFormatException {
        Map<String, String> mapP;
        boolean z = false;
        if (awVar == null || (mapP = awVar.p()) == null || TextUtils.isEmpty(mapP.get("NET_STRATEGY")) || TextUtils.isEmpty(mapP.get("CURRENT_NET"))) {
            return false;
        }
        try {
            String str = mapP.get("NET_STRATEGY");
            int i = Integer.parseInt(mapP.get("CURRENT_NET"));
            if (!TextUtils.equals(str, "1") || i == 2) {
                return false;
            }
            z = true;
            String str2 = jh.e;
            return true;
        } catch (Exception unused) {
            return z;
        }
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

    private HttpURLConnection a(aw awVar, URL url, HttpURLConnection httpURLConnection) throws Exception {
        int i = a.a[awVar.o().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return httpURLConnection;
            }
            url.toString();
            boolean zJ = awVar.j();
            httpURLConnection.setInstanceFollowRedirects(zJ);
            if (!zJ) {
                return httpURLConnection;
            }
            if (this.a) {
                return as.a(httpURLConnection, jh.c().d());
            }
            return as.a(httpURLConnection);
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
