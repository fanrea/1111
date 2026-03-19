package com.bykv.vk.openvk.component.video.d.b;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.d.hc.hc.b;
import com.bykv.vk.openvk.component.video.d.hc.tt;
import com.bykv.vk.openvk.component.video.d.hc.u;
import com.bytedance.sdk.component.tc.h;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d {
    private static final Handler hc = new Handler(Looper.getMainLooper());
    public static final Charset d = Charset.forName("UTF-8");

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean d(String str) {
        if (str != null) {
            return str.startsWith("http://") || str.startsWith("https://");
        }
        return false;
    }

    public static int hc(String str) {
        return d(str, 0);
    }

    public static int d(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static String d(com.bykv.vk.openvk.component.video.d.hc.u.d dVar, int i) {
        int iD;
        if (dVar == null || !dVar.hc()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.u().toUpperCase()).append(' ').append(dVar.d()).append(' ').append(dVar.an()).append("\r\n");
        if (u.b) {
            mq.d("TAG_PROXY_headers", dVar.u().toUpperCase() + " " + dVar.d() + " " + dVar.an());
        }
        List<tt.hc> listD = d(dVar.b());
        boolean z = true;
        if (listD != null) {
            int size = listD.size();
            for (int i2 = 0; i2 < size; i2++) {
                tt.hc hcVar = listD.get(i2);
                if (hcVar != null) {
                    String str = hcVar.d;
                    String str2 = hcVar.hc;
                    sb.append(str).append(": ").append(str2).append("\r\n");
                    if ("Content-Range".equalsIgnoreCase(str) || ("Accept-Ranges".equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z = false;
                    }
                }
            }
        }
        if (z && (iD = d(dVar)) > 0) {
            sb.append("Content-Range: bytes ").append(Math.max(i, 0)).append("-").append(iD - 1).append("/").append(iD).append("\r\n");
        }
        sb.append("Connection: close\r\n");
        sb.append("\r\n");
        String string = sb.toString();
        if (u.b) {
            mq.d("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static String d(int i, int i2) {
        String strHc = hc(i, i2);
        if (strHc == null) {
            return null;
        }
        return "bytes=" + strHc;
    }

    public static String hc(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            return i + "-" + i2;
        }
        if (i > 0) {
            return i + "-";
        }
        if (i >= 0 || i2 <= 0) {
            return null;
        }
        return "-" + i2;
    }

    public static List<String> d(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (d(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String d(com.bykv.vk.openvk.component.video.d.hc.hc.d dVar, int i) {
        StringBuilder sb = new StringBuilder();
        if (i <= 0) {
            sb.append("HTTP/1.1 200 OK\r\n");
        } else {
            sb.append("HTTP/1.1 206 Partial Content\r\n");
        }
        sb.append("Accept-Ranges: bytes\r\n");
        sb.append("Content-Type: ").append(dVar.hc).append("\r\n");
        if (i <= 0) {
            sb.append("Content-Length: ").append(dVar.b).append("\r\n");
        } else {
            sb.append("Content-Range: bytes ").append(i).append("-").append(dVar.b - 1).append("/").append(dVar.b).append("\r\n");
            sb.append("Content-Length: ").append(dVar.b - i).append("\r\n");
        }
        sb.append("Connection: close\r\n");
        sb.append("\r\n");
        String string = sb.toString();
        if (u.b) {
            mq.d("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static int d() {
        File[] fileArrListFiles;
        if (Build.VERSION.SDK_INT >= 17) {
            return Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (file.exists() && (fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.bykv.vk.openvk.component.video.d.b.d.1
                private Pattern d = Pattern.compile("^cpu[0-9]+$");

                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return this.d.matcher(str).matches();
                }
            })) != null) {
                return Math.max(fileArrListFiles.length, 1);
            }
        } catch (Throwable unused) {
        }
        return 1;
    }

    public static int d(com.bykv.vk.openvk.component.video.d.hc.u.d dVar) {
        int iLastIndexOf;
        if (dVar == null) {
            return -1;
        }
        if (dVar.d() == 200) {
            return d(dVar.d("Content-Length", null), -1);
        }
        if (dVar.d() == 206) {
            String strD = dVar.d("Content-Range", null);
            if (!TextUtils.isEmpty(strD) && (iLastIndexOf = strD.lastIndexOf("/")) >= 0 && iLastIndexOf < strD.length() - 1) {
                return d(strD.substring(iLastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String d(com.bykv.vk.openvk.component.video.d.hc.u.d dVar, boolean z, boolean z2) {
        String strD;
        if (dVar == null) {
            if (u.b) {
                mq.c("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!dVar.hc()) {
            if (u.b) {
                mq.c("TAG_PROXY_Response", "response code: " + dVar.d());
            }
            return "response code: " + dVar.d();
        }
        String strD2 = dVar.d("Content-Type", null);
        if (!b(strD2)) {
            if (u.b) {
                mq.c("TAG_PROXY_Response", "Content-Type: " + strD2);
            }
            return "Content-Type: " + strD2;
        }
        int iD = d(dVar);
        if (iD <= 0) {
            if (u.b) {
                mq.c("TAG_PROXY_Response", "Content-Length: " + iD);
            }
            return "Content-Length: " + iD;
        }
        if (z && ((strD = dVar.d("Accept-Ranges", null)) == null || !strD.contains("bytes"))) {
            if (u.b) {
                mq.c("TAG_PROXY_Response", "Accept-Ranges: " + strD);
            }
            return "Accept-Ranges: " + strD;
        }
        if (!z2 || dVar.c() != null) {
            return null;
        }
        if (u.b) {
            mq.c("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static boolean b(String str) {
        if (str != null) {
            return str.startsWith("video/") || MediaTypeUtils.APPLICATION_OCTET_STREAM.equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }

    public static boolean hc() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void d(com.bytedance.sdk.component.tc.tt ttVar) {
        if (ttVar != null) {
            if (hc()) {
                h.hc(ttVar);
                if (u.b) {
                    mq.c("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            ttVar.run();
            if (u.b) {
                mq.c("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void d(Runnable runnable) {
        if (runnable != null) {
            if (hc()) {
                runnable.run();
            } else {
                hc.post(runnable);
            }
        }
    }

    public static List<tt.hc> d(List<tt.hc> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (u.b) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                tt.hc hcVar = list.get(i);
                if (hcVar != null) {
                    mq.d("TAG_PROXY_PRE_FILTER", hcVar.d + ": " + hcVar.d);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (tt.hc hcVar2 : list) {
            if ("Host".equals(hcVar2.d) || "Keep-Alive".equals(hcVar2.d) || "Connection".equals(hcVar2.d) || "Proxy-Connection".equals(hcVar2.d)) {
                arrayList.add(hcVar2);
            }
        }
        list.removeAll(arrayList);
        if (u.b) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                tt.hc hcVar3 = list.get(i2);
                if (hcVar3 != null) {
                    mq.d("TAG_PROXY_POST_FILTER", hcVar3.d + ": " + hcVar3.hc);
                }
            }
        }
        return list;
    }

    public static List<tt.hc> d(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : setEntrySet) {
                    arrayList.add(new tt.hc(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        return null;
    }

    public static com.bykv.vk.openvk.component.video.d.hc.hc.d d(com.bykv.vk.openvk.component.video.d.hc.u.d dVar, b bVar, String str, int i) {
        String strHc;
        String str2;
        String string;
        com.bykv.vk.openvk.component.video.d.hc.hc.d dVarQuery = bVar.query(str, i);
        if (dVarQuery != null) {
            return dVarQuery;
        }
        int iD = d(dVar);
        String strD = dVar.d("Content-Type", null);
        if (iD <= 0 || TextUtils.isEmpty(strD)) {
            return dVarQuery;
        }
        com.bykv.vk.openvk.component.video.d.hc.u.u uVarH = dVar.h();
        if (uVarH != null) {
            str2 = uVarH.hc;
            strHc = hc(uVarH.u);
        } else {
            strHc = "";
            str2 = strHc;
        }
        String strHc2 = hc(dVar.b());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestUrl", str2);
            jSONObject.put("requestHeaders", strHc);
            jSONObject.put("responseHeaders", strHc2);
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = "";
        }
        com.bykv.vk.openvk.component.video.d.hc.hc.d dVar2 = new com.bykv.vk.openvk.component.video.d.hc.hc.d(str, strD, iD, i, string);
        bVar.insert(dVar2);
        return dVar2;
    }

    public static String hc(List<tt.hc> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            tt.hc hcVar = list.get(0);
            if (hcVar != null) {
                sb.append(hcVar.d).append(": ").append(hcVar.hc).append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String hc(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append((Object) entry.getKey()).append(": ").append((Object) entry.getValue()).append("\r\n");
        }
        return sb.toString();
    }
}
