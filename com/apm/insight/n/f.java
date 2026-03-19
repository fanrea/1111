package com.apm.insight.n;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.apm.insight.Npth;
import com.apm.insight.o.j;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import io.reactivex.annotations.SchedulerSupport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f {
    public static boolean a = false;
    private static k b;

    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int d;

        a(int i) {
            this.d = i;
        }
    }

    public static p a(long j, String str, byte[] bArr, a aVar, String str2, boolean z) {
        String str3;
        StringBuilder sb;
        if (!Npth.isStopUpload() && str != null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            int length = bArr.length;
            String str4 = null;
            if (a.GZIP == aVar && length > 128) {
                bArr = b(bArr);
                str4 = "gzip";
            } else if (a.DEFLATER == aVar && length > 128) {
                bArr = a(bArr);
                str4 = "deflate";
            }
            String str5 = str4;
            byte[] bArr2 = bArr;
            if (bArr2 == null) {
                return new p(202);
            }
            if (!z) {
                return a(str, bArr2, str2, str5, "POST", true, false);
            }
            byte[] bArrA = com.apm.insight.g.h().getEncryptImpl().a(bArr2);
            if (bArrA != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    str3 = "?";
                    if (!str.endsWith("?")) {
                        sb = new StringBuilder();
                        str = sb.append(str).append(str3).toString();
                    }
                    str = str + "tt_data=a";
                    str2 = "application/octet-stream;tt-data=a";
                    bArr2 = bArrA;
                } else {
                    str3 = com.alipay.sdk.m.s.a.n;
                    if (!str.endsWith(com.alipay.sdk.m.s.a.n)) {
                        sb = new StringBuilder();
                        str = sb.append(str).append(str3).toString();
                    }
                    str = str + "tt_data=a";
                    str2 = "application/octet-stream;tt-data=a";
                    bArr2 = bArrA;
                }
            }
            return a(str, bArr2, str2, str5, "POST", true, true);
        }
        return new p(201);
    }

    public static p a(String str, String str2) {
        return a(str, str2, b());
    }

    public static p a(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return a(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, str, str2.getBytes(), a.GZIP, MediaTypeUtils.APPLICATION_JSON, z);
            }
            return new p(201);
        } catch (Throwable th) {
            com.apm.insight.o.q.b(th);
            return new p(207, th);
        }
    }

    public static p a(String str, String str2, j.a... aVarArr) {
        return b(str, str2, aVarArr);
    }

    public static p a(String str, String str2, File... fileArr) {
        return b(str, str2, fileArr);
    }

    private static p a(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2) {
        try {
            k kVar = b;
            if (kVar != null) {
                try {
                    str = kVar.a(str, bArr);
                } catch (Throwable unused) {
                }
            }
            HashMap map = new HashMap();
            if (str2 != null) {
                map.put("Content-Type", str2);
            }
            if (str3 != null) {
                map.put("Content-Encoding", str3);
            }
            map.put("os", "Android");
            map.put("Accept-Encoding", "gzip");
            try {
                String strF = com.apm.insight.f.f();
                if (!TextUtils.isEmpty(strF)) {
                    map.put("aid", strF);
                    String strC = com.apm.insight.f.c(strF);
                    if (!TextUtils.isEmpty(strC)) {
                        map.put("x-auth-token", strC);
                    }
                    String strD = com.apm.insight.f.d(strF);
                    if (!TextUtils.isEmpty(strD)) {
                        map.put(com.baidu.mobads.upgrade.remote.gray.c.l, strD);
                    }
                }
            } catch (Throwable unused2) {
            }
            return c(com.apm.insight.g.p().post(str, bArr, map).getResponseBytes());
        } catch (Throwable th) {
            com.apm.insight.o.q.a(th);
            return new p(207, th);
        }
    }

    private static String a(String str, Map map) {
        if (TextUtils.isDigitsOnly(str) || map == null || map.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    if (!sb.toString().endsWith("?")) {
                        sb.append(com.alipay.sdk.m.s.a.n);
                    }
                    sb.append(d(entry.getKey().toString(), "UTF-8"));
                    sb.append("=");
                    sb.append(d(entry.getValue().toString(), "UTF-8"));
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static void a(k kVar) {
        b = kVar;
    }

    public static boolean a() {
        return true;
    }

    public static boolean a(String str, String str2, String str3, String str4, List<String> list) {
        if (Npth.isStopUpload()) {
            return false;
        }
        try {
            HashMap map = new HashMap();
            map.put("aid", str2);
            String strC = com.apm.insight.f.c(str2);
            if (!TextUtils.isEmpty(strC)) {
                map.put("x-auth-token", strC);
            }
            j jVarA = com.apm.insight.g.a(str, "UTF-8", (Map<String, String>) map, false);
            jVarA.a("aid", str2);
            jVarA.a(com.baidu.mobads.upgrade.remote.gray.c.l, str3);
            jVarA.a("os", "Android");
            jVarA.a(ContentProviderManager.PLUGIN_PROCESS_NAME, str4);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists()) {
                    HashMap map2 = new HashMap();
                    map2.put("logtype", "alog");
                    map2.put("scene", "崩溃");
                    jVarA.a(file.getName(), file, map2);
                }
            }
            return new JSONObject(jVarA.a()).optInt("errno", -1) == 200;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] a(String str, Map<String, String> map, byte[] bArr) {
        try {
            return a(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, a(str, map), bArr, a.GZIP, MediaTypeUtils.APPLICATION_JSON, false).b();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public static p b(String str, String str2) {
        return a(str, str2, a());
    }

    public static p b(String str, String str2, j.a... aVarArr) {
        if (Npth.isStopUpload()) {
            return new p(201);
        }
        try {
            HashMap map = new HashMap();
            String strF = com.apm.insight.f.f();
            map.put("aid", strF);
            String strC = com.apm.insight.f.c(strF);
            if (!TextUtils.isEmpty(strC)) {
                map.put("x-auth-token", strC);
            }
            j jVarA = com.apm.insight.g.a(c(str, "have_dump=true&encrypt=true"), "UTF-8", (Map<String, String>) null, true);
            jVarA.a("json", str2, true);
            if (aVarArr != null) {
                jVarA.a(com.sigmob.sdk.base.n.z, (Map<String, String>) null, aVarArr);
            }
            try {
                return new p(0, new JSONObject(jVarA.a()));
            } catch (JSONException e) {
                return new p(0, e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return new p(207);
        }
    }

    public static p b(String str, String str2, File... fileArr) {
        if (Npth.isStopUpload()) {
            return new p(201);
        }
        try {
            String strC = c(str, "have_dump=true&encrypt=true");
            com.apm.insight.o.q.a((Object) ("Upload crash to " + strC));
            j jVarA = com.apm.insight.g.a(strC, "UTF-8", (Map<String, String>) null, true);
            jVarA.a("json", str2, true);
            jVarA.a(com.sigmob.sdk.base.n.z, fileArr);
            String strA = jVarA.a();
            com.apm.insight.o.q.a((Object) ("Finish upload crash to " + strC));
            try {
                return new p(0, new JSONObject(strA));
            } catch (JSONException e) {
                return new p(0, e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return new p(207);
        }
    }

    public static boolean b() {
        return true;
    }

    private static byte[] b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                com.apm.insight.o.q.b(th);
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    private static p c(byte[] bArr) {
        return new p(204, bArr);
    }

    public static String c() {
        return com.apm.insight.g.h().getJavaCrashUploadUrl();
    }

    private static String c(String str, String str2) {
        StringBuilder sbAppend;
        try {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    sbAppend = new StringBuilder().append(str).append("?");
                    str = sbAppend.toString();
                }
            } else if (!str.endsWith(com.alipay.sdk.m.s.a.n)) {
                sbAppend = new StringBuilder().append(str).append(com.alipay.sdk.m.s.a.n);
                str = sbAppend.toString();
            }
            return str + str2;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean c(String str, String str2, File... fileArr) {
        try {
            String strE = com.apm.insight.g.a().e();
            HashMap map = new HashMap();
            map.put("aid", strE);
            String strC = com.apm.insight.f.c(strE);
            if (!TextUtils.isEmpty(strC)) {
                map.put("x-auth-token", strC);
            }
            j jVarA = com.apm.insight.g.a(str, "UTF-8", (Map<String, String>) map, false);
            jVarA.a("aid", strE);
            jVarA.a(com.baidu.mobads.upgrade.remote.gray.c.l, com.apm.insight.g.a().d());
            jVarA.a("os", "Android");
            HashMap map2 = new HashMap();
            map2.put("logtype", SchedulerSupport.CUSTOM);
            map2.put("scene", "crash");
            map2.put("event_time", String.valueOf(System.currentTimeMillis()));
            map2.put("uuid", str2);
            jVarA.a("CustomFile.zip", map2, fileArr);
            jVarA.a();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String d() {
        return com.apm.insight.g.h().getAlogUploadUrl();
    }

    private static String d(String str, String str2) {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String e() {
        return com.apm.insight.g.h().getLaunchCrashUploadUrl();
    }

    public static String f() {
        return com.apm.insight.g.h().getExceptionUploadUrl();
    }

    public static String g() {
        return com.apm.insight.g.h().getNativeCrashUploadUrl();
    }

    public static String h() {
        return com.apm.insight.g.h().getCrashPortraitUploadUrl();
    }
}
