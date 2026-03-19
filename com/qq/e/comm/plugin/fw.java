package com.qq.e.comm.plugin;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class fw implements Runnable {
    private final String b;
    private List<String> c;
    private final b d;
    private final int f;
    private int a = 0;
    private boolean g = false;
    private final ConnectivityManager e = (ConnectivityManager) r1.d().a().getSystemService("connectivity");

    /* compiled from: A */
    interface b {
        void a(JSONObject jSONObject);
    }

    fw(String str, b bVar) {
        this.b = str;
        this.d = bVar;
        a();
        this.f = r1.d().f().a("cnrt", 5000);
    }

    private JSONObject a(String str) throws JSONException {
        String str2;
        if (TextUtils.isEmpty(str)) {
            this.a = 1;
        }
        switch (this.a) {
            case 0:
                str2 = "切换网络通道成功";
                break;
            case 1:
                str2 = "网络错误";
                break;
            case 2:
                str2 = "移动网络未连接";
                break;
            case 3:
                str2 = "无切换网络通道权限";
                break;
            case 4:
                str2 = "切换网络通道超时";
                break;
            case 5:
                str2 = "切换网络通道失败";
                break;
            case 6:
                str2 = "域名不在白名单:" + this.b;
                break;
            default:
                str2 = "";
                break;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("response", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("code", Integer.valueOf(this.a));
            jSONObject2.putOpt("msg", str2);
            jSONObject.putOpt("extra", jSONObject2);
        } catch (JSONException e) {
            e.getMessage();
        }
        ja jaVar = new ja();
        if (!TextUtils.isEmpty(str2)) {
            jaVar.a("msg", str2);
        }
        b10.b(1130009, null, Integer.valueOf(this.a), jaVar);
        return jSONObject;
    }

    private JSONObject b(String str) {
        try {
            URL url = new URL(str);
            if (this.e == null) {
                this.a = 5;
                return a(a(url, true));
            }
            String host = url.getHost();
            if (!this.g && !this.c.contains(host)) {
                this.a = 6;
                return a(a(url, true));
            }
            if (!b()) {
                this.a = 2;
                return a(a(url, true));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return a(url);
            }
            return b(url);
        } catch (MalformedURLException unused) {
            this.a = 1;
            return a("");
        }
    }

    /* compiled from: A */
    class a extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ Exchanger a;

        a(Exchanger exchanger) {
            this.a = exchanger;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) throws InterruptedException, TimeoutException {
            try {
                this.a.exchange(network, fw.this.f, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                e.getMessage();
            }
            super.onAvailable(network);
        }
    }

    private boolean c() {
        int i = this.f / 25;
        for (int i2 = 0; i2 < 25; i2++) {
            NetworkInfo networkInfo = this.e.getNetworkInfo(5);
            if (networkInfo == null) {
                break;
            }
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
            SystemClock.sleep(i);
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObjectB = b(this.b);
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(jSONObjectB);
        }
    }

    private JSONObject b(URL url) {
        String strA;
        if (!b(0, "enableHIPRI")) {
            this.a = 5;
            strA = a(url, true);
        } else if (!c()) {
            this.a = 4;
            strA = a(url, true);
        } else {
            strA = a(url, false);
        }
        return a(strA);
    }

    private boolean b() throws NoSuchMethodException, SecurityException {
        Object objA = mv.a((Object) this.e, mv.a(ConnectivityManager.class, "getMobileDataEnabled", true, new Class[0]), true, new Object[0]);
        if (objA instanceof Boolean) {
            return ((Boolean) objA).booleanValue();
        }
        return true;
    }

    private void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private HttpURLConnection b(URL url, Network network, boolean z) throws IOException {
        if (z) {
            return (HttpURLConnection) url.openConnection();
        }
        if (network != null) {
            return (HttpURLConnection) network.openConnection(url);
        }
        if (Build.VERSION.SDK_INT < 21) {
            this.a = a(5, url.getHost()) ? this.a : 5;
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.qq.e.comm.plugin.fw] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.net.Network] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.net.URL r5, android.net.Network r6, boolean r7) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            java.net.HttpURLConnection r5 = r4.b(r5, r6, r7)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L84
            java.lang.String r1 = "GET"
            r5.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L7a
            r1 = 10000(0x2710, float:1.4013E-41)
            r5.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L7a
            r5.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L7a
            java.lang.String r1 = com.qq.e.comm.plugin.r30.b()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L7a
            java.lang.String r2 = com.qq.e.comm.plugin.r30.a()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L7a
            r5.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L7a
            java.net.HttpURLConnection r5 = r4.a(r5, r6, r7)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L7a
            if (r5 == 0) goto L6c
            int r6 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L7a
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L6c
            java.io.InputStream r6 = r5.getInputStream()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L7a
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L6a
            r7.<init>()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L6a
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
        L38:
            int r1 = r6.read(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r2 = -1
            if (r1 == r2) goto L44
            r2 = 0
            r7.write(r0, r2, r1)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            goto L38
        L44:
            r7.flush()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r0 = r5.getContentEncoding()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            if (r1 == 0) goto L53
            java.lang.String r0 = "UTF-8"
        L53:
            java.lang.String r0 = r7.toString(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r4.a(r6)
            r4.a(r7)
            r5.disconnect()
            return r0
        L61:
            r0 = move-exception
            goto L9c
        L63:
            r0 = move-exception
            goto L8b
        L65:
            r7 = move-exception
            r3 = r0
            r0 = r7
            r7 = r3
            goto L9c
        L6a:
            r7 = move-exception
            goto L88
        L6c:
            r4.a(r0)
            r4.a(r0)
            if (r5 == 0) goto L99
            goto L96
        L75:
            r6 = move-exception
            r7 = r0
            r0 = r6
            r6 = r7
            goto L9c
        L7a:
            r6 = move-exception
            r7 = r6
            r6 = r0
            goto L88
        L7e:
            r5 = move-exception
            r6 = r0
            r7 = r6
            r0 = r5
            r5 = r7
            goto L9c
        L84:
            r5 = move-exception
            r7 = r5
            r5 = r0
            r6 = r5
        L88:
            r3 = r0
            r0 = r7
            r7 = r3
        L8b:
            r0.getMessage()     // Catch: java.lang.Throwable -> L61
            r4.a(r6)
            r4.a(r7)
            if (r5 == 0) goto L99
        L96:
            r5.disconnect()
        L99:
            java.lang.String r5 = ""
            return r5
        L9c:
            r4.a(r6)
            r4.a(r7)
            if (r5 == 0) goto La7
            r5.disconnect()
        La7:
            goto La9
        La8:
            throw r0
        La9:
            goto La8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.fw.a(java.net.URL, android.net.Network, boolean):java.lang.String");
    }

    private boolean b(int i, String str) throws SecurityException {
        Object objA = mv.a((Object) this.e, mv.a(ConnectivityManager.class, "startUsingNetworkFeature", true, Integer.TYPE, String.class), true, Integer.valueOf(i), str);
        return (objA instanceof Integer) && ((Integer) objA).intValue() != -1;
    }

    private String a(URL url, boolean z) {
        return a(url, (Network) null, z);
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection, Network network, boolean z) throws IOException {
        if (httpURLConnection == null) {
            return null;
        }
        int connectTimeout = httpURLConnection.getConnectTimeout();
        int readTimeout = httpURLConnection.getReadTimeout();
        Map<String, List<String>> requestProperties = httpURLConnection.getRequestProperties();
        for (int i = 0; i < 5; i++) {
            httpURLConnection.connect();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301 && responseCode != 303) {
                    break;
                }
                String headerField = httpURLConnection.getHeaderField("location");
                httpURLConnection.disconnect();
                httpURLConnection = b(new URL(headerField), network, z);
                httpURLConnection.setConnectTimeout(connectTimeout);
                httpURLConnection.setReadTimeout(readTimeout);
                if (requestProperties != null) {
                    for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
                        String key = entry.getKey();
                        List<String> value = entry.getValue();
                        if (value != null && !value.isEmpty()) {
                            Iterator<String> it = value.iterator();
                            while (it.hasNext()) {
                                httpURLConnection.addRequestProperty(key, it.next());
                            }
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                throw new IOException(e.getMessage());
            }
        }
        return httpURLConnection;
    }

    private boolean a(int i, String str) throws UnknownHostException {
        InetAddress byName;
        try {
            byName = InetAddress.getByName(str);
        } catch (Exception unused) {
            byName = null;
        }
        if (byName != null) {
            return a(i, byName);
        }
        return false;
    }

    private boolean a(int i, InetAddress inetAddress) throws NoSuchMethodException, SecurityException {
        Object objA = mv.a((Object) this.e, mv.a(ConnectivityManager.class, "requestRouteToHostAddress", true, Integer.TYPE, InetAddress.class), true, Integer.valueOf(i), inetAddress);
        if (objA instanceof Boolean) {
            return ((Boolean) objA).booleanValue();
        }
        return false;
    }

    private void a() {
        String strB = r1.d().f().b("cnrhw", "*");
        try {
            if (!TextUtils.isEmpty(strB)) {
                if ("*".equals(strB)) {
                    this.g = true;
                } else {
                    String[] strArrSplit = strB.split(",");
                    if (strArrSplit != null) {
                        this.c = Arrays.asList(strArrSplit);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
    }

    private JSONObject a(URL url) throws JSONException {
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        Exchanger exchanger = new Exchanger();
        a aVar = new a(exchanger);
        Network network = null;
        try {
            this.e.requestNetwork(networkRequestBuild, aVar);
            network = (Network) exchanger.exchange(null, this.f, TimeUnit.MILLISECONDS);
        } catch (SecurityException unused) {
            this.a = 3;
        } catch (Exception e) {
            e.getMessage();
        }
        if (network == null && this.a == 0) {
            this.a = 4;
        }
        JSONObject jSONObjectA = a(a(url, network, false));
        this.e.unregisterNetworkCallback(aVar);
        return jSONObjectA;
    }
}
