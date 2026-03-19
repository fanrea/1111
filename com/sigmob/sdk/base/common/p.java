package com.sigmob.sdk.base.common;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.logger.SigmobLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class p extends AsyncTask<String, Void, HashMap<String, String>> {
    private static final int a = 10;
    private final a b;

    public interface a {
        void a(final String fileName, String url);

        void a(final String message, final Throwable throwable);
    }

    private p(a listener) {
        this.b = listener;
    }

    public static String a(final String urlString) {
        if (!urlString.toLowerCase().contains(".apk")) {
            return null;
        }
        String strB = b(urlString);
        if (!TextUtils.isEmpty(strB)) {
            return strB;
        }
        String strC = c(urlString);
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        return strC;
    }

    private static String a(String baseUrl, HttpURLConnection httpUrlConnection) throws URISyntaxException, IOException {
        int responseCode = httpUrlConnection.getResponseCode();
        if (responseCode < 200 || responseCode >= 400) {
            return null;
        }
        try {
            return URLUtil.guessFileName(baseUrl, httpUrlConnection.getHeaderField("Content-Disposition"), null);
        } catch (IllegalArgumentException unused) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + baseUrl);
            throw new URISyntaxException(baseUrl, "Unable to parse invalid URL");
        } catch (NullPointerException e) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + baseUrl);
            throw e;
        }
    }

    public static void a(String urlString, a listener) {
        try {
            String strA = a(urlString);
            if (TextUtils.isEmpty(strA)) {
                new p(listener).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), urlString);
            } else {
                listener.a(strA, urlString);
            }
        } catch (Throwable th) {
            listener.a("Failed to resolve url", th);
        }
    }

    public static String b(String contentDisposition) {
        try {
            Matcher matcher = Pattern.compile("(fsname=)(.*?apk)", 2).matcher(contentDisposition);
            if (matcher.find()) {
                return matcher.group(2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(String contentDisposition) {
        try {
            Matcher matcher = Pattern.compile("[\\w\\.]+\\.apk", 2).matcher(contentDisposition);
            if (matcher.find()) {
                return matcher.group(0);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String d(String urlString) throws URISyntaxException, IOException {
        String str = null;
        while (urlString != null) {
            try {
                str = urlString;
                urlString = e(urlString);
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                return urlString;
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[DONT_GENERATE, PHI: r0 r4
  0x0032: PHI (r0v3 java.lang.String) = (r0v0 java.lang.String), (r0v4 java.lang.String) binds: [B:18:0x003f, B:11:0x0030] A[DONT_GENERATE, DONT_INLINE]
  0x0032: PHI (r4v3 java.net.HttpURLConnection) = (r4v2 java.net.HttpURLConnection), (r4v5 java.net.HttpURLConnection) binds: [B:18:0x003f, B:11:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(final java.lang.String r4) throws java.net.URISyntaxException, java.io.IOException {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L38
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L38
            java.net.URLConnection r4 = r1.openConnection()     // Catch: java.lang.Throwable -> L38
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L38
            r1 = 0
            r4.setInstanceFollowRedirects(r1)     // Catch: java.lang.Throwable -> L36
            com.czhj.sdk.common.network.ResponseHeader r1 = com.czhj.sdk.common.network.ResponseHeader.USER_AGENT     // Catch: java.lang.Throwable -> L36
            java.lang.String r1 = r1.getKey()     // Catch: java.lang.Throwable -> L36
            java.lang.String r2 = com.czhj.sdk.common.network.Networking.getUserAgent()     // Catch: java.lang.Throwable -> L36
            r4.addRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L36
            int r1 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L36
            java.lang.String r2 = "Location"
            java.lang.String r2 = r4.getHeaderField(r2)     // Catch: java.lang.Throwable -> L36
            r3 = 300(0x12c, float:4.2E-43)
            if (r1 < r3) goto L30
            r3 = 400(0x190, float:5.6E-43)
            if (r1 >= r3) goto L30
            r0 = r2
        L30:
            if (r4 == 0) goto L42
        L32:
            r4.disconnect()
            goto L42
        L36:
            r1 = move-exception
            goto L3a
        L38:
            r1 = move-exception
            r4 = r0
        L3a:
            java.lang.String r2 = "resolveRedirectLocation fail"
            com.czhj.sdk.logger.SigmobLog.e(r2, r1)     // Catch: java.lang.Throwable -> L43
            if (r4 == 0) goto L42
            goto L32
        L42:
            return r0
        L43:
            r0 = move-exception
            if (r4 == 0) goto L49
            r4.disconnect()
        L49:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.p.e(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String f(final java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto Ld
            java.lang.String r8 = a(r8)     // Catch: java.lang.Throwable -> L99
            goto L90
        Ld:
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L99
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L99
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L99
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L99
            r2 = 0
            r1.setInstanceFollowRedirects(r2)     // Catch: java.lang.Throwable -> L97
            com.czhj.sdk.common.network.ResponseHeader r2 = com.czhj.sdk.common.network.ResponseHeader.USER_AGENT     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = r2.getKey()     // Catch: java.lang.Throwable -> L97
            java.lang.String r3 = com.czhj.sdk.common.network.Networking.getUserAgent()     // Catch: java.lang.Throwable -> L97
            r1.addRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = a(r8, r1)     // Catch: java.lang.Throwable -> L97
            java.lang.String r3 = ".apk"
            if (r2 == 0) goto L4c
            java.lang.String r4 = "fsname="
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L97
            if (r4 == 0) goto L3e
            java.lang.String r8 = b(r8)     // Catch: java.lang.Throwable -> L97
            goto L8f
        L3e:
            boolean r8 = r2.contains(r3)     // Catch: java.lang.Throwable -> L97
            if (r8 == 0) goto L49
            java.lang.String r8 = c(r2)     // Catch: java.lang.Throwable -> L97
            goto L8f
        L49:
            r0 = r1
            r8 = r2
            goto L90
        L4c:
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L97
            if (r4 != 0) goto L8e
            android.net.Uri r4 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L97
            java.lang.String r4 = r4.getPath()     // Catch: java.lang.Throwable -> L97
            java.lang.String r5 = "/"
            java.lang.String[] r4 = r4.split(r5)     // Catch: java.lang.Throwable -> L97
            int r5 = r4.length     // Catch: java.lang.Throwable -> L97
            r6 = 1
            if (r5 <= r6) goto L68
            int r2 = r4.length     // Catch: java.lang.Throwable -> L97
            int r2 = r2 - r6
            r2 = r4[r2]     // Catch: java.lang.Throwable -> L97
        L68:
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L97
            if (r4 != 0) goto L78
            java.lang.String r2 = r2.toLowerCase()     // Catch: java.lang.Throwable -> L97
            boolean r2 = r2.endsWith(r3)     // Catch: java.lang.Throwable -> L97
            if (r2 != 0) goto L8e
        L78:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
            r2.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r8 = com.czhj.sdk.common.utils.Md5Util.md5(r8)     // Catch: java.lang.Throwable -> L97
            java.lang.StringBuilder r8 = r2.append(r8)     // Catch: java.lang.Throwable -> L97
            java.lang.StringBuilder r8 = r8.append(r3)     // Catch: java.lang.Throwable -> L97
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L97
            goto L8f
        L8e:
            r8 = r0
        L8f:
            r0 = r1
        L90:
            if (r0 == 0) goto L95
            r0.disconnect()
        L95:
            r0 = r8
            goto La5
        L97:
            r8 = move-exception
            goto L9b
        L99:
            r8 = move-exception
            r1 = r0
        L9b:
            java.lang.String r2 = "getDownloadUrlFilename"
            com.czhj.sdk.logger.SigmobLog.e(r2, r8)     // Catch: java.lang.Throwable -> La6
            if (r1 == 0) goto La5
            r1.disconnect()
        La5:
            return r0
        La6:
            r8 = move-exception
            if (r1 == 0) goto Lac
            r1.disconnect()
        Lac:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.p.f(java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<String, String> doInBackground(String... urls) {
        if (urls == null || urls.length == 0) {
            return null;
        }
        HashMap<String, String> map = new HashMap<>();
        try {
            String strD = urls[0];
            try {
                strD = d(strD);
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
            map.put("url", strD);
            map.put("fileName", f(strD));
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(final HashMap<String, String> map) {
        String str;
        String str2 = null;
        if (map != null) {
            str2 = map.get("fileName");
            str = map.get("url");
        } else {
            str = null;
        }
        this.b.a(str2, str);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.b.a("Task for resolving url was cancelled", (Throwable) null);
    }
}
