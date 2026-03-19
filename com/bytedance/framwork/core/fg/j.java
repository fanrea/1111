package com.bytedance.framwork.core.fg;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.common.utility.NetworkUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: MonitorNetUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class j {
    private static b a;

    /* compiled from: MonitorNetUtil.java */
    public interface b {
        String a(String str, byte[] bArr);
    }

    /* compiled from: MonitorNetUtil.java */
    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int d;

        a(int i) {
            this.d = i;
        }
    }

    /* compiled from: MonitorNetUtil.java */
    public enum c {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        final int g;

        c(int i) {
            this.g = i;
        }

        public int a() {
            return this.g;
        }
    }

    public static c a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return c.WIFI;
                }
                if (type == 0) {
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return c.MOBILE_3G;
                        case 4:
                        case 7:
                        case 11:
                        default:
                            return c.MOBILE;
                        case 13:
                            return c.MOBILE_4G;
                    }
                }
                return c.MOBILE;
            }
            return c.NONE;
        } catch (Throwable unused) {
            return c.MOBILE;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static com.bytedance.framwork.core.cd.a a(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        byte[] bArrA;
        GZIPInputStream gZIPInputStream;
        DataOutputStream dataOutputStream;
        InputStream inputStream = null;
        try {
            b bVar = a;
            if (bVar != null) {
                str = bVar.a(str, bArr);
            }
            LinkedList<Pair> linkedList = new LinkedList();
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                NetworkUtils.setupSSLFactory(httpURLConnection2);
                if (z2 && !linkedList.isEmpty()) {
                    for (Pair pair : linkedList) {
                        if (pair != null) {
                            httpURLConnection2.setRequestProperty((String) pair.first, (String) pair.second);
                        }
                    }
                }
                if (z) {
                    httpURLConnection2.setDoOutput(true);
                } else {
                    httpURLConnection2.setDoOutput(false);
                }
                if (str2 != null) {
                    httpURLConnection2.setRequestProperty("Content-Type", str2);
                }
                if (str3 != null) {
                    httpURLConnection2.setRequestProperty("Content-Encoding", str3);
                }
                httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                httpURLConnection2.setRequestProperty("Version-Code", "1");
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                            httpURLConnection2.setRequestProperty(key, value);
                        }
                    }
                }
                if (str4 == null) {
                    throw new IllegalArgumentException("request method is not null");
                }
                httpURLConnection2.setRequestMethod(str4);
                if (bArr != null && bArr.length > 0) {
                    try {
                        dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream = null;
                    }
                    try {
                        dataOutputStream.write(bArr);
                        dataOutputStream.flush();
                        e.a(dataOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        e.a(dataOutputStream);
                        throw th;
                    }
                }
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode == 200) {
                    InputStream inputStream2 = httpURLConnection2.getInputStream();
                    try {
                        String contentEncoding = httpURLConnection2.getContentEncoding();
                        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.equalsIgnoreCase("gzip")) {
                            try {
                                gZIPInputStream = new GZIPInputStream(inputStream2);
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                bArrA = a(gZIPInputStream);
                                e.a(gZIPInputStream);
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = gZIPInputStream;
                                e.a(inputStream);
                                throw th;
                            }
                        } else {
                            bArrA = a(inputStream2);
                        }
                        Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                        HashMap map2 = new HashMap();
                        for (String str5 : headerFields.keySet()) {
                            List<String> list = headerFields.get(str5);
                            if (list != null && !g.a(list)) {
                                map2.put(str5, list.get(0));
                            }
                        }
                        com.bytedance.framwork.core.cd.a aVar = new com.bytedance.framwork.core.cd.a(responseCode, map2, bArrA);
                        e.a(inputStream2);
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        return aVar;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = inputStream2;
                        Throwable th6 = th;
                        httpURLConnection = httpURLConnection2;
                        th = th6;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            e.a(inputStream);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th7;
                        }
                    }
                }
                throw new d(responseCode, httpURLConnection2.getResponseMessage());
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Throwable th9) {
            th = th9;
            httpURLConnection = null;
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
        if (inputStream != null) {
            inputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] a(byte[] bArr, Map<String, String> map) {
        if (bArr.length <= 128) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                map.put("Content-Encoding", "gzip");
                return byteArray;
            } catch (IOException e) {
                throw e;
            }
        } catch (Throwable th) {
            gZIPOutputStream.close();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.framwork.core.cd.a a(java.lang.String r10, byte[] r11, com.bytedance.framwork.core.fg.j.a r12, java.lang.String r13, boolean r14, java.util.Map<java.lang.String, java.lang.String> r15) {
        /*
            r2 = 0
            if (r10 != 0) goto L4
            return r2
        L4:
            r3 = 0
            if (r11 != 0) goto La
            byte[] r4 = new byte[r3]
            goto Lb
        La:
            r4 = r11
        Lb:
            int r5 = r4.length
            com.bytedance.framwork.core.fg.j$a r6 = com.bytedance.framwork.core.fg.j.a.GZIP
            r7 = 128(0x80, float:1.8E-43)
            r8 = 8192(0x2000, float:1.148E-41)
            if (r6 != r12) goto L31
            if (r5 <= r7) goto L31
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>(r8)
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream
            r3.<init>(r1)
            r3.write(r4)     // Catch: java.lang.Throwable -> L2d
            r3.close()
            byte[] r1 = r1.toByteArray()
            java.lang.String r2 = "gzip"
            goto L60
        L2d:
            r3.close()
            return r2
        L31:
            com.bytedance.framwork.core.fg.j$a r6 = com.bytedance.framwork.core.fg.j.a.DEFLATER
            if (r6 != r12) goto L62
            if (r5 <= r7) goto L62
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>(r8)
            java.util.zip.Deflater r2 = new java.util.zip.Deflater
            r2.<init>()
            r2.setInput(r4)
            r2.finish()
            byte[] r4 = new byte[r8]
        L49:
            boolean r5 = r2.finished()
            if (r5 != 0) goto L57
            int r5 = r2.deflate(r4)
            r1.write(r4, r3, r5)
            goto L49
        L57:
            r2.end()
            byte[] r1 = r1.toByteArray()
            java.lang.String r2 = "deflate"
        L60:
            r5 = r2
            goto L64
        L62:
            r5 = r2
            r1 = r4
        L64:
            if (r14 == 0) goto L93
            int r2 = r1.length
            byte[] r2 = com.bytedance.applog.encryptor.EncryptorUtil.encrypt(r1, r2)
            if (r2 == 0) goto L86
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r0 = r1.append(r10)
            java.lang.String r1 = "&tt_data=a"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "application/octet-stream;tt-data=a"
            r4 = r1
            r3 = r2
            r2 = r0
            goto L89
        L86:
            r2 = r10
            r4 = r13
            r3 = r1
        L89:
            r7 = 1
            r8 = 1
            java.lang.String r6 = "POST"
            r9 = r15
            com.bytedance.framwork.core.cd.a r0 = a(r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        L93:
            r6 = 1
            r7 = 0
            java.lang.String r4 = "POST"
            r0 = r10
            r2 = r13
            r3 = r5
            r5 = r6
            r6 = r7
            r7 = r15
            com.bytedance.framwork.core.cd.a r0 = a(r0, r1, r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.framwork.core.fg.j.a(java.lang.String, byte[], com.bytedance.framwork.core.fg.j$a, java.lang.String, boolean, java.util.Map):com.bytedance.framwork.core.cd.a");
    }
}
