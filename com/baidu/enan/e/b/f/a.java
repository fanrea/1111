package com.baidu.enan.e.b.f;

import android.text.TextUtils;
import com.baidu.enan.f.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static JSONArray a() {
        Throwable th;
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray();
        } catch (Throwable th2) {
            th = th2;
            jSONArray = null;
        }
        try {
            if (a(b.a("L3N5cy9kZXZpY2VzL3ZpcnR1YWwvbmV0L3R1bjA="))) {
                jSONArray.put("3167");
            }
            if (a(b.a("L3N5cy9kZXZpY2VzL3ZpcnR1YWwvYmRpL3Zib3hzZi0x"))) {
                jSONArray.put("11039");
            }
            if (a(b.a("L2RhdGEvbWlzYy9wcm9maWxlcy9yZWYvY29tLnZtb3Mucm9tZXg="))) {
                jSONArray.put("13082");
            }
            if (a(b.a("L2RhdGEvZGF0YS9jb20udm1vcy5yb21leA=="))) {
                jSONArray.put("13085");
            }
            if (a(b.a("L3N5c3RlbS9mcmFtZXdvcmsvb3JnLmxpbmVhZ2Vvcy5wbGF0Zm9ybS5qYXI="))) {
                jSONArray.put("17761");
            }
            if (a(b.a("L3NiaW4vLm1hZ2lzaw=="))) {
                jSONArray.put("17827");
            }
            if (a(b.a("L3N5c3RlbS9saWIvbGlicmlydWxvYWRlci5zbw=="))) {
                jSONArray.put("17932");
            }
            if (a(b.a("L2RhdGEvZGF0YS9vcmcubWVvd2NhdC5lZHhwb3NlZC5tYW5hZ2Vy"))) {
                jSONArray.put("17949");
            }
            if (a(b.a("L3N5c3RlbS94cG9zZWQucHJvcA=="))) {
                jSONArray.put("17902");
            }
            if (a(b.a("L2RhdGEvZGFsdmlrLWNhY2hlL3hwb3NlZF9YUmVzb3VyY2VzU3VwZXJDbGFzcy5kZXg="))) {
                jSONArray.put("17907");
            }
            if (b(b.a("cGVyc2lzdC52bW9zLnJvb3QuZW5hYmxl"))) {
                jSONArray.put("13083");
            }
            if (b(b.a("cGVyc2lzdC52bW9zLnRvb2wuc2hvdw=="))) {
                jSONArray.put("13084");
            }
            if (b(b.a("cm8ubGluZWFnZS5kZXZpY2U="))) {
                jSONArray.put("17758");
            }
            if (c(b.a("Y29tLnl6dGMuc3R1ZGlvLnBsdWdpbg=="))) {
                jSONArray.put("17964");
            }
            if (a(23946)) {
                jSONArray.put("17997");
            }
            if (a(27042)) {
                jSONArray.put("17991");
                jSONArray.put("17992");
            }
            if (a(27043)) {
                jSONArray.put("17993");
                jSONArray.put("17994");
            }
            a(jSONArray);
        } catch (Throwable th3) {
            th = th3;
            com.baidu.enan.f.a.a(th);
            return jSONArray;
        }
        return jSONArray;
    }

    public static boolean b(String str) {
        try {
            return !TextUtils.isEmpty(com.baidu.enan.e.d.b.a(str, ""));
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        com.baidu.enan.f.a.a(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        r3 = move-exception;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.lang.String r3) {
        /*
            java.lang.String r0 = "L3Byb2Mvc2VsZi9tYXBz"
            java.lang.String r0 = com.baidu.enan.f.b.a(r0)     // Catch: java.lang.Throwable -> L2c
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2c
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L2c
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2c
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2c
        L10:
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L2a
            if (r0 == 0) goto L26
            boolean r0 = r0.contains(r3)     // Catch: java.lang.Throwable -> L2a
            if (r0 == 0) goto L10
            r1.close()     // Catch: java.lang.Throwable -> L20
            goto L24
        L20:
            r3 = move-exception
            com.baidu.enan.f.a.a(r3)
        L24:
            r3 = 1
            return r3
        L26:
            r1.close()     // Catch: java.lang.Throwable -> L37
            goto L3b
        L2a:
            r3 = move-exception
            goto L2e
        L2c:
            r3 = move-exception
            r1 = 0
        L2e:
            com.baidu.enan.f.a.a(r3)     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L3b
            r1.close()     // Catch: java.lang.Throwable -> L37
            goto L3b
        L37:
            r3 = move-exception
            com.baidu.enan.f.a.a(r3)
        L3b:
            r3 = 0
            return r3
        L3d:
            r3 = move-exception
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Throwable -> L44
            goto L48
        L44:
            r0 = move-exception
            com.baidu.enan.f.a.a(r0)
        L48:
            goto L4a
        L49:
            throw r3
        L4a:
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.enan.e.b.f.a.c(java.lang.String):boolean");
    }

    private static void a(JSONArray jSONArray) throws IOException {
        BufferedReader bufferedReader;
        File file;
        try {
            file = new File(b.a("L3Byb2MvbW91bnRz"));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        if (file.exists()) {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (line.contains(b.a("dmJveHNm")) && !jSONArray.toString().contains("17807")) {
                            jSONArray.put("17807");
                        }
                        if (line.contains(b.a("bWFnaXNr")) && !jSONArray.toString().contains("17805")) {
                            jSONArray.put("17805");
                        }
                        if (line.contains(b.a("Y2dyb3VwIC9zeXMvZnMvY2dyb3VwL2h1Z2V0bGIgY2dyb3VwIHJv")) && !jSONArray.toString().contains("17821")) {
                            jSONArray.put("17821");
                        }
                        if (line.contains(b.a("ZGV2cHRzIC9kZXYvdHR5MyBkZXZwdHMgcnc=")) && !jSONArray.toString().contains("17823")) {
                            jSONArray.put("17823");
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        com.baidu.enan.f.a.a(th);
                        if (bufferedReader == null) {
                            return;
                        }
                        bufferedReader.close();
                        return;
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                            }
                        }
                        throw th3;
                    }
                }
                try {
                    bufferedReader.close();
                    return;
                } catch (IOException e2) {
                    return;
                }
            }
        }
    }

    public static boolean a(String str) {
        try {
            return new File(str).exists();
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return false;
        }
    }

    public static boolean a(int i) {
        Throwable th;
        ServerSocket serverSocket;
        ServerSocket serverSocket2 = null;
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName("127.0.0.1"), i);
            serverSocket = new ServerSocket();
            try {
                serverSocket.bind(inetSocketAddress);
                try {
                    serverSocket.close();
                } catch (Throwable th2) {
                    com.baidu.enan.f.a.a(th2);
                }
                return false;
            } catch (BindException e) {
                serverSocket2 = serverSocket;
                if (serverSocket2 == null) {
                    return true;
                }
                try {
                    serverSocket2.close();
                    return true;
                } catch (Throwable th3) {
                    com.baidu.enan.f.a.a(th3);
                    return true;
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    com.baidu.enan.f.a.a(th);
                    return false;
                } finally {
                    if (serverSocket != null) {
                        try {
                            serverSocket.close();
                        } catch (Throwable th5) {
                            com.baidu.enan.f.a.a(th5);
                        }
                    }
                }
            }
        } catch (BindException e2) {
        } catch (Throwable th6) {
            th = th6;
            serverSocket = null;
        }
    }
}
