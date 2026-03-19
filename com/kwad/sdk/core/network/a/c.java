package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.bx;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private static final Pattern bDv = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String bDw = "UTF-8";
    private static OkHttpClient bDx = null;
    public static OkHttpClient bDy = aav();

    public static OkHttpClient aau() {
        if (com.kwad.framework.a.a.qr.booleanValue()) {
            if (bDx == null) {
                bDx = bDy.newBuilder().build();
            }
            return bDx;
        }
        return bDy;
    }

    private static OkHttpClient aav() {
        if (bDy == null) {
            OkHttpClient.Builder builderConnectionSpecs = new OkHttpClient.Builder().connectTimeout(com.alipay.sdk.m.u.b.a, TimeUnit.MILLISECONDS).readTimeout(6000L, TimeUnit.MILLISECONDS).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
            try {
                builderConnectionSpecs.dns(new d());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
            bDy = builderConnectionSpecs.build();
        }
        return bDy;
    }

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true, true);
    }

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z, boolean z2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            if (z2) {
                a(builderUrl);
            }
            a(builderUrl, map);
            Response responseExecute = aau().newCall(builderUrl.build()).execute();
            cVar.code = responseExecute.code();
            cVar.bCq = cVar.code;
            cVar.bCs = z ? a(responseExecute) : "";
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    private static void a(Request.Builder builder) {
        builder.addHeader("User-Agent", p.getUserAgent());
        builder.addHeader("BrowserUa", p.aar());
        builder.addHeader("SystemUa", p.aaq());
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            a(builderUrl);
            a(builderUrl, map);
            a(builderUrl, jSONObject);
            Response responseExecute = aau().newCall(builderUrl.build()).execute();
            cVar.code = responseExecute.code();
            cVar.bCq = cVar.code;
            cVar.bCs = a(responseExecute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            a(builderUrl);
            a(builderUrl, map);
            b(builderUrl, map2);
            Response responseExecute = aau().newCall(builderUrl.build()).execute();
            cVar.code = responseExecute.code();
            cVar.bCq = cVar.code;
            cVar.bCs = a(responseExecute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            final MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            if (adHttpBodyBuilder != null) {
                adHttpBodyBuilder.buildFormData(new AdHttpFormDataBuilder() { // from class: com.kwad.sdk.core.network.a.c.1
                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3) {
                        type.addFormDataPart(str2, str3);
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3, String str4, byte[] bArr) {
                        type.addFormDataPart(str2, str3, RequestBody.create(MediaType.parse(str4), bArr));
                    }
                });
            }
            Request.Builder builderPost = new Request.Builder().url(str).post(type.build());
            a(builderPost, map);
            Response responseExecute = aau().newCall(builderPost.build()).execute();
            cVar.code = responseExecute.code();
            cVar.bCq = cVar.code;
            cVar.bCs = a(responseExecute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j, boolean z, AdHttpResponseListener adHttpResponseListener) throws Throwable {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        Request.Builder builderUrl = new Request.Builder().url(str);
        HashMap map = new HashMap();
        map.put("Accept-Language", "zh-CN");
        if (z) {
            map.put("Connection", "keep-alive");
        } else {
            map.put("Connection", "close");
        }
        map.put("Charset", "UTF-8");
        a(builderUrl);
        a(builderUrl, map);
        Response responseExecute = aau().newCall(builderUrl.build()).execute();
        cVar.code = responseExecute.code();
        cVar.bCq = cVar.code;
        if (responseExecute.code() != 200) {
            throw new FileNotFoundException(str);
        }
        a(responseExecute, outputStream, j, adHttpResponseListener);
        return true;
    }

    private static void a(com.kwad.sdk.core.network.c cVar, Exception exc) {
        String message;
        cVar.bCr = exc;
        if (cVar.bCq == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = bDv.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.bCq = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
        if (exc instanceof SocketTimeoutException) {
            cVar.code = e.bCt.errorCode;
            cVar.bCs = e.bCt.msg;
        } else {
            cVar.code = e.bCu.errorCode;
            cVar.bCs = e.bCu.msg + "/" + bx.A(exc);
        }
        if (com.kwad.framework.a.a.qr.booleanValue()) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(exc);
        }
    }

    private static void a(Request.Builder builder, Map<String, String> map) {
        if (builder == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    builder.removeHeader(entry.getKey());
                    builder.addHeader(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    private static void a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse(MediaTypeUtils.APPLICATION_JSON), jSONObject.toString()));
    }

    private static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBodyBuild;
        if (map == null || map.isEmpty()) {
            formBodyBuild = null;
        } else {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), encode(entry.getValue()));
                    } catch (Exception unused) {
                    }
                }
            }
            formBodyBuild = builder2.build();
        }
        if (builder == null || formBodyBuild == null) {
            return;
        }
        builder.post(formBodyBuild);
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    private static String a(Response response) throws Throwable {
        InputStream inputStreamByteStream;
        InputStream inputStream;
        ?? inputStreamReader;
        InputStream gZIPInputStream;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStreamByteStream = response.body().byteStream();
            try {
                List<String> listHeaders = response.headers("Content-Encoding");
                boolean z = false;
                if (listHeaders != null) {
                    Iterator<String> it = listHeaders.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if ("gzip".equalsIgnoreCase(it.next())) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    gZIPInputStream = new GZIPInputStream(inputStreamByteStream);
                    inputStream = gZIPInputStream;
                } else {
                    inputStream = null;
                    gZIPInputStream = inputStreamByteStream;
                }
                try {
                    inputStreamReader = new InputStreamReader(gZIPInputStream, bDw);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader, 8);
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line != null) {
                                    sb.append(line);
                                } else {
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) inputStreamReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                                    return sb.toString();
                                }
                            } catch (Throwable th) {
                                bufferedReader = bufferedReader2;
                                th = th;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) inputStreamReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                inputStreamReader = inputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) inputStreamReader);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamByteStream = null;
            inputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:4:0x0010, B:6:0x001f, B:7:0x0023, B:9:0x0029, B:14:0x003c), top: B:50:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055 A[Catch: all -> 0x0097, LOOP:1: B:21:0x0055->B:62:?, LOOP_START, PHI: r11
  0x0055: PHI (r11v3 long) = (r11v0 long), (r11v4 long) binds: [B:20:0x0053, B:62:?] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x0097, blocks: (B:19:0x004c, B:21:0x0055, B:23:0x005b, B:28:0x0069, B:29:0x006f, B:32:0x0077, B:33:0x007a, B:37:0x0086), top: B:54:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(okhttp3.Response r16, java.io.OutputStream r17, long r18, com.kwad.sdk.export.proxy.AdHttpResponseListener r20) throws java.lang.Throwable {
        /*
            r0 = r17
            r1 = r20
            r2 = 0
            com.kwad.sdk.export.proxy.AdHttpResponseHelper.notifyResponseStart(r20)     // Catch: java.lang.Throwable -> La5
            okhttp3.ResponseBody r3 = r16.body()     // Catch: java.lang.Throwable -> La5
            java.io.InputStream r3 = r3.byteStream()     // Catch: java.lang.Throwable -> La5
            java.lang.String r4 = "Content-Encoding"
            r5 = r16
            java.util.List r4 = r5.headers(r4)     // Catch: java.lang.Throwable -> La0
            long r5 = b(r16)     // Catch: java.lang.Throwable -> La0
            r8 = 0
            if (r4 == 0) goto L39
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> La0
        L23:
            boolean r9 = r4.hasNext()     // Catch: java.lang.Throwable -> La0
            if (r9 == 0) goto L39
            java.lang.Object r9 = r4.next()     // Catch: java.lang.Throwable -> La0
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = "gzip"
            boolean r9 = r10.equalsIgnoreCase(r9)     // Catch: java.lang.Throwable -> La0
            if (r9 == 0) goto L23
            r4 = 1
            goto L3a
        L39:
            r4 = r8
        L3a:
            if (r4 == 0) goto L43
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> La0
            r4.<init>(r3)     // Catch: java.lang.Throwable -> La0
            r9 = r4
            goto L45
        L43:
            r9 = r2
            r4 = r3
        L45:
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L9c
            r10.<init>(r4)     // Catch: java.lang.Throwable -> L9c
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L97
            r11 = 0
            int r13 = (r18 > r11 ? 1 : (r18 == r11 ? 0 : -1))
            r14 = -1
            if (r13 <= 0) goto L65
        L55:
            int r0 = r10.read(r4)     // Catch: java.lang.Throwable -> L97
            if (r0 == r14) goto L89
            long r7 = (long) r0     // Catch: java.lang.Throwable -> L97
            long r11 = r11 + r7
            com.kwad.sdk.export.proxy.AdHttpResponseHelper.notifyResponseProgress(r1, r11, r5)     // Catch: java.lang.Throwable -> L97
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto L55
            goto L89
        L65:
            if (r13 >= 0) goto L89
            if (r0 == 0) goto L6f
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L97
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L97
            r2 = r7
        L6f:
            int r0 = r10.read(r4)     // Catch: java.lang.Throwable -> L97
            if (r0 == r14) goto L84
            if (r2 == 0) goto L7a
            r2.write(r4, r8, r0)     // Catch: java.lang.Throwable -> L97
        L7a:
            long r14 = (long) r0     // Catch: java.lang.Throwable -> L97
            long r11 = r11 + r14
            boolean r0 = com.kwad.sdk.export.proxy.AdHttpResponseHelper.notifyResponseProgress(r1, r11, r5)     // Catch: java.lang.Throwable -> L97
            if (r0 != 0) goto L84
            r14 = -1
            goto L6f
        L84:
            if (r2 == 0) goto L89
            r2.flush()     // Catch: java.lang.Throwable -> L97
        L89:
            com.kwad.sdk.crash.utils.b.closeQuietly(r10)
            com.kwad.sdk.crash.utils.b.closeQuietly(r2)
            com.kwad.sdk.crash.utils.b.closeQuietly(r9)
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)
            r0 = 1
            return r0
        L97:
            r0 = move-exception
            r1 = r0
            r0 = r2
            r2 = r10
            goto Laa
        L9c:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto Laa
        La0:
            r0 = move-exception
            r1 = r0
            r0 = r2
            r9 = r0
            goto Laa
        La5:
            r0 = move-exception
            r1 = r0
            r0 = r2
            r3 = r0
            r9 = r3
        Laa:
            com.kwad.sdk.crash.utils.b.closeQuietly(r2)
            com.kwad.sdk.crash.utils.b.closeQuietly(r0)
            com.kwad.sdk.crash.utils.b.closeQuietly(r9)
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.network.a.c.a(okhttp3.Response, java.io.OutputStream, long, com.kwad.sdk.export.proxy.AdHttpResponseListener):boolean");
    }

    private static long b(Response response) {
        try {
            return Long.parseLong(response.header("content-length"));
        } catch (Throwable unused) {
            return -1L;
        }
    }
}
