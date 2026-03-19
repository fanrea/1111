package com.qq.e.comm.plugin;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONException;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class as {
    private static final boolean a;
    private static volatile boolean b;
    private static volatile int c;
    private static volatile String d;
    private static volatile String e;
    private static volatile Pattern f;
    private static volatile Pattern g;
    private static final boolean h;
    private static long i;
    private static volatile zr j;
    private static volatile Network k;
    private static volatile ConnectivityManager l;
    private static volatile int m;
    private static final boolean n;
    private static final CopyOnWriteArrayList<b> o;
    public static final /* synthetic */ int p = 0;

    /* compiled from: A */
    public interface b {
        void a();
    }

    static {
        a = Build.VERSION.SDK_INT < 24;
        b = false;
        c = 2;
        d = "";
        e = "";
        f = Pattern.compile(e, 2);
        g = Pattern.compile(d, 2);
        h = r1.d().f().a("gaape", 0) == 1;
        i = 0L;
        j = zr.UNKNOWN;
        m = 0;
        n = r1.d().f().a("gnwsl", 0) == 1;
        o = new CopyOnWriteArrayList<>();
    }

    public static void a(HttpURLConnection httpURLConnection, URL url) {
        pro.getVresult(89, 1, httpURLConnection, url);
    }

    public static boolean a(int i2) {
        return i2 == 302 || i2 == 301 || i2 == 303;
    }

    private static boolean a(URL url) {
        return pro.getZresult(90, 1, url);
    }

    public static Pair<HttpURLConnection, Boolean> b(HttpURLConnection httpURLConnection, URL url) {
        return (Pair) pro.getobjresult(91, 1, httpURLConnection, url);
    }

    public static int d() {
        if (a) {
            return 0;
        }
        return m;
    }

    private static int e() {
        if (l == null || a) {
            return 0;
        }
        try {
            if (l != null) {
                Network activeNetwork = k;
                if (activeNetwork == null) {
                    activeNetwork = l.getActiveNetwork();
                }
                NetworkCapabilities networkCapabilities = l.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasCapability(16)) {
                        return 1;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return 2;
    }

    public static zr f() {
        return a ? g() : j;
    }

    private static zr g() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) r1.d().a().getSystemService("connectivity");
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
        }
        if (activeNetworkInfo == null) {
            return zr.UNKNOWN;
        }
        int type = activeNetworkInfo.getType();
        return type != 0 ? type != 1 ? zr.UNKNOWN : zr.WIFI : b(connectivityManager);
    }

    public static boolean i() {
        NetworkInfo activeNetworkInfo;
        int iE;
        if (n && (iE = e()) != 0) {
            return iE == 1;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) r1.d().a().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void j() {
        if (o.isEmpty()) {
            return;
        }
        int i2 = 0;
        while (true) {
            CopyOnWriteArrayList<b> copyOnWriteArrayList = o;
            if (i2 >= copyOnWriteArrayList.size()) {
                return;
            }
            b bVar = copyOnWriteArrayList.get(i2);
            if (bVar != null) {
                bVar.a();
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(zr zrVar) {
        if (zrVar == j) {
            return;
        }
        if (b(zrVar)) {
            pr.a().d();
        } else {
            pr.a().e();
        }
        j = zrVar;
    }

    public static String c() {
        int subtype;
        Context contextA = r1.d().a();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) contextA.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                try {
                    subtype = ((TelephonyManager) contextA.getSystemService("phone")).getNetworkType();
                } catch (Exception unused) {
                    subtype = 0;
                }
                if (subtype == 0) {
                    subtype = activeNetworkInfo.getSubtype();
                }
                if (subtype == 13 && Build.VERSION.SDK_INT >= 29 && r1.d().f().a("nsa5g", 1) == 1) {
                    return String.valueOf(a(contextA, subtype));
                }
                return "" + subtype;
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    /* compiled from: A */
    class a extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            as.c(zr.UNKNOWN);
            pr.a().a(true);
            int i = as.p;
            zr unused = as.j;
            Network unused2 = as.k = null;
            as.b((NetworkCapabilities) null);
        }

        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities == null) {
                as.c(zr.UNKNOWN);
            } else if (networkCapabilities.hasTransport(0)) {
                as.c(as.b(as.l));
                Network unused = as.k = network;
            } else {
                pr.a().a(networkCapabilities);
            }
            as.b(networkCapabilities);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkCapabilities networkCapabilities;
            try {
                networkCapabilities = as.l.getNetworkCapabilities(network);
            } catch (Throwable unused) {
                networkCapabilities = null;
            }
            if (networkCapabilities == null) {
                as.c(zr.UNKNOWN);
            } else if (networkCapabilities.hasTransport(1)) {
                as.c(zr.WIFI);
            } else if (networkCapabilities.hasTransport(0)) {
                as.c(as.b(as.l));
            }
            pr.a().a(false);
            int i = as.p;
            zr unused2 = as.j;
            Network unused3 = as.k = network;
            as.b(networkCapabilities);
        }
    }

    public static HttpURLConnection a(HttpURLConnection httpURLConnection) throws IOException {
        return a(httpURLConnection, (Network) null);
    }

    private static int h() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zr b(ConnectivityManager connectivityManager) {
        int subtype;
        qa qaVarC = r1.d().c();
        if (qaVarC == null || !qaVarC.v()) {
            subtype = 0;
        } else {
            try {
                subtype = ((TelephonyManager) r1.d().a().getSystemService("phone")).getNetworkType();
            } catch (Exception unused) {
            }
        }
        if (subtype == 0) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    subtype = activeNetworkInfo.getSubtype();
                }
            } catch (Throwable unused2) {
            }
        }
        switch (subtype) {
            case 1:
            case 2:
            case 16:
                return zr.NET_2G;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 17:
                return zr.NET_3G;
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
                return zr.NET_4G;
            default:
                return zr.UNKNOWN;
        }
    }

    public static boolean b(zr zrVar) {
        return (zrVar == zr.WIFI || zrVar == zr.UNKNOWN) ? false : true;
    }

    public static HttpURLConnection a(HttpURLConnection httpURLConnection, Network network) throws JSONException, IOException {
        if (httpURLConnection == null) {
            return null;
        }
        int iA = r1.d().f().a("httpRedirectMax", 3);
        int connectTimeout = httpURLConnection.getConnectTimeout();
        int readTimeout = httpURLConnection.getReadTimeout();
        Map<String, List<String>> requestProperties = httpURLConnection.getRequestProperties();
        int i2 = 0;
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        while (i2 < iA) {
            httpURLConnection2.connect();
            try {
                if (!a(httpURLConnection2.getResponseCode())) {
                    break;
                }
                String headerField = httpURLConnection2.getHeaderField("location");
                httpURLConnection2.disconnect();
                String strA = wr.a(headerField, 4);
                if (network != null && Build.VERSION.SDK_INT >= 21) {
                    httpURLConnection2 = (HttpURLConnection) network.openConnection(new URL(strA));
                } else {
                    httpURLConnection2 = (HttpURLConnection) new URL(strA).openConnection();
                }
                httpURLConnection2.setConnectTimeout(connectTimeout);
                httpURLConnection2.setReadTimeout(readTimeout);
                if (requestProperties != null) {
                    for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
                        String key = entry.getKey();
                        List<String> value = entry.getValue();
                        if (value != null && !value.isEmpty()) {
                            Iterator<String> it = value.iterator();
                            while (it.hasNext()) {
                                httpURLConnection2.addRequestProperty(key, it.next());
                            }
                        }
                    }
                }
                i2++;
            } catch (IndexOutOfBoundsException e2) {
                throw new IOException(e2.getMessage());
            }
        }
        if (i2 != iA) {
            if (i2 > 0) {
                ja jaVar = new ja();
                jaVar.a("http_from", httpURLConnection.getURL().toString());
                jaVar.a("http_to", httpURLConnection2.getURL().toString());
                b10.a(100342, null, Integer.valueOf(i2), jaVar);
            }
            return httpURLConnection2;
        }
        b10.a(100322, null, Integer.valueOf(iA));
        throw new IOException("HttpURLConnection exceed max redirect " + iA + " " + httpURLConnection2.getURL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
            if (m != 1) {
                m = 1;
                j();
                return;
            }
            return;
        }
        m = 2;
    }

    public static void b(b bVar) {
        if (a || bVar == null) {
            return;
        }
        o.remove(bVar);
    }

    private static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }

    public static void a(Context context) {
        if (a) {
            return;
        }
        try {
            l = (ConnectivityManager) context.getSystemService("connectivity");
            if (l == null) {
                return;
            }
            l.registerDefaultNetworkCallback(new a());
            c(g());
            m = e();
        } catch (Exception unused) {
            c(zr.UNKNOWN);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #1 {all -> 0x005f, blocks: (B:4:0x000e, B:6:0x001d, B:16:0x0052, B:13:0x004b, B:11:0x0045, B:8:0x0022), top: B:24:0x000e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(android.content.Context r7, int r8) {
        /*
            com.qq.e.comm.plugin.r1 r0 = com.qq.e.comm.plugin.r1.d()
            com.qq.e.comm.plugin.qa r0 = r0.c()
            boolean r0 = r0.v()
            if (r0 == 0) goto L63
            java.lang.String r0 = "phone"
            java.lang.Object r7 = r7.getSystemService(r0)     // Catch: java.lang.Throwable -> L5f
            android.telephony.TelephonyManager r7 = (android.telephony.TelephonyManager) r7     // Catch: java.lang.Throwable -> L5f
            int r0 = h()     // Catch: java.lang.Throwable -> L5f
            r1 = -1
            if (r0 != r1) goto L22
            android.telephony.ServiceState r7 = r7.getServiceState()     // Catch: java.lang.Throwable -> L5f
            goto L4f
        L22:
            java.lang.Class<android.telephony.TelephonyManager> r1 = android.telephony.TelephonyManager.class
            java.lang.String r2 = "getServiceStateForSubscriber"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L44
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L44
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Throwable -> L44
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch: java.lang.Throwable -> L44
            r1.setAccessible(r3)     // Catch: java.lang.Throwable -> L44
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L44
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L44
            r2[r6] = r0     // Catch: java.lang.Throwable -> L44
            java.lang.Object r0 = r1.invoke(r7, r2)     // Catch: java.lang.Throwable -> L44
            android.telephony.ServiceState r0 = (android.telephony.ServiceState) r0     // Catch: java.lang.Throwable -> L44
            goto L49
        L44:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L5f
            r0 = 0
        L49:
            if (r0 != 0) goto L50
            android.telephony.ServiceState r7 = r7.getServiceState()     // Catch: java.lang.Throwable -> L5f
        L4f:
            r0 = r7
        L50:
            if (r0 == 0) goto L63
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Throwable -> L5f
            boolean r7 = a(r7)     // Catch: java.lang.Throwable -> L5f
            if (r7 == 0) goto L63
            r8 = 10013(0x271d, float:1.4031E-41)
            goto L63
        L5f:
            r7 = move-exception
            r7.printStackTrace()
        L63:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.as.a(android.content.Context, int):int");
    }

    public static void a(b bVar) {
        if (a || bVar == null) {
            return;
        }
        CopyOnWriteArrayList<b> copyOnWriteArrayList = o;
        if (copyOnWriteArrayList.contains(bVar)) {
            return;
        }
        copyOnWriteArrayList.add(bVar);
        if (m == 1) {
            bVar.a();
        }
    }
}
