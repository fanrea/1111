package com.netease.htprotect.necrash.nis.p003O8oO888;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.alipay.sdk.m.s.a;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.just.agentweb.AgentWebPermissions;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ooo {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final int f148O8oO888 = 10000;
    private static final int Oo0 = 7000;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final int f150O8 = 10002;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final int f151Ooo = 10001;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static final int f152o0o0 = 10000;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static final int f153oO = 10000;

    /* renamed from: 〇O, reason: contains not printable characters */
    private static final Handler f149O = new Handler(Looper.getMainLooper());

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private static final ExecutorService f154o0O0O = Executors.newSingleThreadExecutor();

    /* renamed from: com.netease.htprotect.necrash.nis.O8〇oO8〇88.〇Ooo$O8〇oO8〇88, reason: invalid class name */
    public interface O8oO888 {
        /* renamed from: O8〇oO8〇88 */
        void mo569O8oO888(int i, String str);

        /* renamed from: O8〇oO8〇88 */
        void mo570O8oO888(String str);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m589O8oO888(Map map, String str) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        if (map == null || map.size() == 0) {
            return sb.toString();
        }
        for (Map.Entry entry : map.entrySet()) {
            sb.append((String) entry.getKey()).append("=").append(URLEncoder.encode((String) entry.getValue(), str)).append(a.n);
        }
        return sb.substring(0, sb.length() - 1);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m590O8oO888(Context context, String str, O8oO888 o8oO888) throws IllegalAccessException, InterruptedException, IllegalArgumentException, InvocationTargetException {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 21) {
            o8o0.m581Ooo("system api version >= 21");
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest networkRequestBuild = builder.build();
            Timer timer = new Timer();
            OO8 oo8 = new OO8(timer, new boolean[]{false}, str, o8oO888, connectivityManager);
            connectivityManager.requestNetwork(networkRequestBuild, oo8);
            timer.schedule(new oo0OOO8(connectivityManager, oo8, o8oO888), 7000L);
            return;
        }
        o8o0.m581Ooo("system api version < 21");
        if (connectivityManager != null) {
            try {
                connectivityManager.getClass().getMethod("startUsingNetworkFeature", Integer.TYPE, String.class).invoke(0, "enableHIPRI");
            } catch (Exception unused) {
            }
        }
        for (int i = 0; i < 20; i++) {
            if (connectivityManager != null) {
                if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                    break;
                }
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    o8o0.m579O8(e.getMessage());
                }
            }
        }
        int iIndexOf = str.indexOf("://");
        String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 3) : str;
        int iIndexOf2 = strSubstring.indexOf(58);
        if (iIndexOf2 >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf2);
        }
        int iIndexOf3 = strSubstring.indexOf(47);
        if (iIndexOf3 >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf3);
        }
        int iIndexOf4 = strSubstring.indexOf(63);
        if (iIndexOf4 >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf4);
        }
        int iM586O8oO888 = o08o.m586O8oO888(strSubstring);
        try {
            if (connectivityManager == null) {
                o8oO888.mo569O8oO888(Oo0, "当前状态为wifi和数据流量同时开启，切换到数据流量超时,请重试");
                o8o0.m581Ooo("当前状态为wifi和数据流量同时开启，切换到数据流量失败,系统API < 21");
            } else if (((Boolean) connectivityManager.getClass().getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(5, Integer.valueOf(iM586O8oO888))).booleanValue()) {
                m594O8oO888(str, false, false, null, null, null, o8oO888);
            } else {
                o8oO888.mo569O8oO888(Oo0, "当前状态为wifi和数据流量同时开启，切换到数据流量超时,请重试");
                o8o0.m581Ooo("当前状态为wifi和数据流量同时开启，切换到数据流量失败,系统API < 21");
            }
        } catch (Exception unused2) {
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m591O8oO888(String str, O8oO888 o8oO888) {
        o8o0.m576O8oO888("get request url:".concat(String.valueOf(str)));
        f154o0O0O.execute(new O8(str, o8oO888));
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m592O8oO888(String str, String str2, O8oO888 o8oO888) {
        o8o0.m576O8oO888("post request url:" + str + " args:" + str2);
        f154o0O0O.execute(new O80Oo0O(str, str2, o8oO888));
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static void m593O8oO888(String str, Map map, O8oO888 o8oO888) {
        f154o0O0O.execute(new RunnableC0957Oo(str, map, o8oO888));
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static void m594O8oO888(String str, boolean z, boolean z2, String str2, Map map, Network network, O8oO888 o8oO888) {
        int responseCode;
        String str3;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) ((network == null || Build.VERSION.SDK_INT < 21) ? url.openConnection() : network.openConnection(url));
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(10000);
                httpURLConnection2.setDoInput(true);
                if (z) {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setDoOutput(true);
                } else {
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setDoOutput(false);
                }
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setRequestProperty("Content-Type", z2 ? "application/json" : MediaTypeUtils.APPLICATION_FORM);
                httpURLConnection2.setRequestProperty("connection", "Keep-Alive");
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (str2 != null) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    byte[] bytes = str2.getBytes("UTF-8");
                    dataOutputStream.write(bytes, 0, bytes.length);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                httpURLConnection2.connect();
                if (httpURLConnection2.getResponseCode() == 200) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(new String(line.getBytes("UTF-8")));
                        }
                    }
                    String string = sb.toString();
                    bufferedReader.close();
                    o8oO888.mo570O8oO888(string);
                } else {
                    if (httpURLConnection2.getResponseCode() == 302) {
                        String headerField = httpURLConnection2.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                        if (headerField == null || headerField.isEmpty()) {
                            responseCode = httpURLConnection2.getResponseCode();
                            str3 = "获取重定向url失败";
                        } else {
                            httpURLConnection2.disconnect();
                            m594O8oO888(headerField, z, z2, str2, null, network, o8oO888);
                        }
                    } else {
                        responseCode = httpURLConnection2.getResponseCode();
                        str3 = "与服务端建立连接失败";
                    }
                    o8oO888.mo569O8oO888(responseCode, str3);
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e) {
                o8o0.m579O8(e.getMessage());
                o8oO888.mo569O8oO888(10001, "网络连接出现异常:" + e.toString());
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static void m595Ooo(String str, O8oO888 o8oO888) {
        o8o0.m576O8oO888("get request url:".concat(String.valueOf(str)));
        f154o0O0O.execute(new O(str, o8oO888));
    }
}
