package com.kwad.sdk.core.webview.b;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.alipay.sdk.m.p.e;
import com.baidu.mobads.sdk.internal.ca;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.w;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private static final Map<String, com.kwad.sdk.core.webview.b.a.b> bLX = new ConcurrentHashMap();
    private static final Map<String, String> bLY = new ConcurrentHashMap();

    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.h.a.b bVar, b.a aVar, boolean z) throws Throwable {
        com.kwad.sdk.core.webview.b.a.b bVarA;
        try {
            bVarA = a(context, bVar, str, aVar);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            aVar.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e);
            bVarA = null;
        }
        if (bVarA == null) {
            b(z, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "获取配置文件失败";
            }
            return null;
        }
        if (TextUtils.isEmpty(bVarA.bMf)) {
            b(z, "getResource [" + str + "] getFilePath from url fail");
            aVar.msg = "getFilePath from url fail";
            return null;
        }
        if (!com.kwad.sdk.core.webview.b.c.c.gy(bVarA.bMb)) {
            b(z, "mimetype为: " + bVarA.bMb + "不在拦截范围的文件");
            aVar.msg = "mimetype为: " + bVarA.bMb + "不在拦截范围的文件";
            return null;
        }
        BufferedInputStream bufferedInputStreamIk = w.ik(bVarA.bMf);
        if (bufferedInputStreamIk == null) {
            b(z, "getResource [" + str + "] inputStream is null");
            aVar.msg = "inputStream is null,本地加载路径：" + bVarA.bMf;
            return null;
        }
        return a(bufferedInputStreamIk, bVarA);
    }

    private static void b(boolean z, String str) {
        if (z) {
            return;
        }
        c.d("HybridResourceManager", str);
    }

    private static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.b.a.b bVar) {
        String str = bVar.bMb;
        if (Build.VERSION.SDK_INT >= 21) {
            HashMap map = new HashMap();
            map.put("Access-Control-Allow-Origin", bVar.bMe.bLZ);
            map.put("Access-Control-Allow-Credentials", "true");
            map.put("Timing-Allow-Origin", bVar.bMe.bMa);
            map.put(e.f, str);
            map.put("Date", bVar.bMe.bMc);
            map.put("union-cache ", "1");
            return new WebResourceResponse(bVar.bMb, "", bVar.status, ca.k, map, inputStream);
        }
        return new WebResourceResponse(str, "UTF-8", inputStream);
    }

    private static com.kwad.sdk.core.webview.b.a.b a(Context context, com.kwad.sdk.h.a.b bVar, String str, b.a aVar) throws Throwable {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String strGr = gr(bVar.packageId);
            com.kwad.sdk.core.webview.b.a.b bVarGq = !TextUtils.isEmpty(strGr) ? gq(aj(strGr, str)) : null;
            if (bVarGq != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return bVarGq;
            }
            String strY = com.kwad.sdk.core.webview.b.c.a.Y(context, bVar.cbm);
            if (strY == null) {
                aVar.msg = "获取配置文件失败 offlinepackage 为空";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(strY);
            if (!file.exists()) {
                aVar.msg = "获取配置文件失败 下载文件路径不存在 " + strY;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
                try {
                    String strB = h.b(inputStreamReader);
                    if (TextUtils.isEmpty(strB)) {
                        aVar.msg = "获取配置文件失败 mainfest文件不存在";
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(strB);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        com.kwad.sdk.core.webview.b.a.b bVar2 = new com.kwad.sdk.core.webview.b.a.b();
                        bVar2.parseJson(jSONObject2);
                        String host = Uri.parse("https://" + next).getHost();
                        bVar2.bMg = host;
                        bVar2.bMf = com.kwad.sdk.core.webview.b.c.a.X(context, bVar.cbm) + "/" + next;
                        if (TextUtils.isEmpty(bVar2.bMb)) {
                            bVar2.bMb = URLConnection.getFileNameMap().getContentTypeFor(bVar2.bMf);
                        }
                        a(next, bVar2);
                        strGr = host;
                    }
                    ak(bVar.packageId, strGr);
                    com.kwad.sdk.core.webview.b.a.b bVarGq2 = gq(aj(strGr, str));
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return bVarGq2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    private static void a(String str, com.kwad.sdk.core.webview.b.a.b bVar) {
        bLX.put(String.valueOf(str.hashCode()), bVar);
    }

    private static com.kwad.sdk.core.webview.b.a.b gq(String str) {
        return bLX.get(String.valueOf(str.hashCode()));
    }

    private static String aj(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    private static void ak(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        bLY.put(str, str2);
    }

    private static String gr(String str) {
        return bLY.get(str);
    }
}
