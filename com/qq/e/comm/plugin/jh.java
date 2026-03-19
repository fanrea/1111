package com.qq.e.comm.plugin;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jh {
    public static final String e = "jh";
    private static volatile jh f;
    private final AtomicBoolean a = new AtomicBoolean(false);
    private volatile boolean b = false;
    private final Map<Integer, Network> c = new ConcurrentHashMap();
    private ConnectivityManager d;

    private boolean g() {
        return r1.d().f().a("snme", sy.g.intValue()) == 1;
    }

    private void k() throws JSONException {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) r1.d().a().getSystemService("connectivity");
            this.d = connectivityManager;
            if (connectivityManager == null || Build.VERSION.SDK_INT < 24) {
                ux.a(1, null);
            } else {
                this.d.registerNetworkCallback(new NetworkRequest.Builder().addCapability(16).addTransportType(1).addTransportType(0).build(), new a());
                this.d.registerDefaultNetworkCallback(new b());
                this.b = true;
            }
        } catch (Exception e2) {
            ja jaVar = new ja();
            jaVar.a("data", Log.getStackTraceString(e2));
            ux.a(2, jaVar);
        }
    }

    public boolean i() {
        return yy.a("litlai", 2147483647L) < ((long) r1.d().f().a("snspcci", sy.b.intValue())) && xc.a("snspcc", "APP", "", sy.f.intValue()) == 2;
    }

    private jh() {
    }

    public void l() throws JSONException {
        if (g() && this.a.compareAndSet(false, true)) {
            k();
        }
    }

    /* compiled from: A */
    class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (network.equals(jh.this.c.get(1))) {
                jh.this.c.remove(1);
            } else if (network.equals(jh.this.c.get(2))) {
                jh.this.c.remove(2);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            jh.this.a(network, networkCapabilities, false);
        }
    }

    /* compiled from: A */
    class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (network.equals(jh.this.c.get(3))) {
                jh.this.c.remove(3);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            jh.this.a(network, networkCapabilities, true);
        }
    }

    public boolean h() {
        return a(1);
    }

    public boolean f() {
        return a(2);
    }

    public int b() {
        Network network = this.c.get(3);
        Network network2 = this.c.get(1);
        Network network3 = this.c.get(2);
        if (network == null || !network.equals(network2)) {
            return (network == null || !network.equals(network3)) ? 4 : 2;
        }
        return 1;
    }

    public int c(h4 h4Var) {
        if (!e() || h4Var == null || h4Var.k() == null) {
            return 0;
        }
        return a(h4Var);
    }

    public static jh c() {
        if (f == null) {
            synchronized (jh.class) {
                if (f == null) {
                    f = new jh();
                }
            }
        }
        return f;
    }

    public Network d() {
        return this.c.get(2);
    }

    public void j() {
        if (i()) {
            qg.b.submit(new c());
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() throws ProtocolException {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://mi.gdt.qq.com/gdt_mview.fcg").openConnection();
                httpURLConnection.setRequestMethod("HEAD");
                if (httpURLConnection.getResponseCode() == 200) {
                    String str = jh.e;
                }
            } catch (Exception unused) {
            }
        }

        c() {
        }
    }

    public void e(h4 h4Var) {
        if (!e() || h4Var == null || h4Var.k() == null) {
            return;
        }
        f(h4Var);
    }

    private boolean e() {
        return Build.VERSION.SDK_INT >= 24 && this.a.get() && this.b;
    }

    private int a(h4 h4Var) {
        e2 e2VarK = h4Var.k();
        if (e2VarK.l()) {
            return a(h4Var, "susocc", 0);
        }
        if (e2VarK.g()) {
            return a(h4Var, "eusocc", 0);
        }
        if (e2VarK.i()) {
            return a(h4Var, "ihsusocc", 0);
        }
        if (e2VarK.h()) {
            return a(h4Var, "ifsusocc", 0);
        }
        if (e2VarK.k()) {
            return a(h4Var, "rvusocc", 0);
        }
        if (e2VarK.j()) {
            return a(h4Var, "nusocc", 0);
        }
        if (e2VarK.f()) {
            return a(h4Var, "busocc", 0);
        }
        return 0;
    }

    private void f(h4 h4Var) {
        e2 e2VarK = h4Var.k();
        if (e2VarK.l()) {
            xc.d().a(h4Var, "susoc", 0).a();
            return;
        }
        if (e2VarK.g()) {
            xc.d().a(h4Var, "eusoc", 0).a();
            return;
        }
        if (e2VarK.i()) {
            xc.d().a(h4Var, "ihsusoc", 0).a();
            return;
        }
        if (e2VarK.h()) {
            xc.d().a(h4Var, "ifsusoc", 0).a();
            return;
        }
        if (e2VarK.k()) {
            xc.d().a(h4Var, "rvusoc", 0).a();
        } else if (e2VarK.j()) {
            xc.d().a(h4Var, "nusoc", 0).a();
        } else if (e2VarK.f()) {
            xc.d().a(h4Var, "busoc", 0).a();
        }
    }

    public int d(h4 h4Var) {
        if (!e() || h4Var == null || h4Var.k() == null) {
            return 0;
        }
        return b(h4Var);
    }

    private int b(h4 h4Var) {
        e2 e2VarK = h4Var.k();
        if (e2VarK.l()) {
            return a(h4Var, "susocv", 0);
        }
        if (e2VarK.g()) {
            return a(h4Var, "eusocv", 0);
        }
        if (e2VarK.i()) {
            return a(h4Var, "ihsusocv", 0);
        }
        if (e2VarK.h()) {
            return a(h4Var, "ifsusocv", 0);
        }
        if (e2VarK.k()) {
            return a(h4Var, "rvusocv", 0);
        }
        if (e2VarK.j()) {
            return a(h4Var, "nusocv", 0);
        }
        if (e2VarK.f()) {
            return a(h4Var, "busocv", 0);
        }
        return 0;
    }

    private int a(e2 e2Var, String str) {
        if (e2Var.l()) {
            return xc.a("susoc", str, 0);
        }
        if (e2Var.g()) {
            return xc.a("eusoc", str, 0);
        }
        if (e2Var.i()) {
            return xc.a("ihsusoc", str, 0);
        }
        if (e2Var.h()) {
            return xc.a("ifsusoc", str, 0);
        }
        if (e2Var.k()) {
            return xc.a("rvusoc", str, 0);
        }
        if (e2Var.j()) {
            return xc.a("nusoc", str, 0);
        }
        if (e2Var.f()) {
            return xc.a("busoc", str, 0);
        }
        return 0;
    }

    public int b(e2 e2Var, String str) {
        if (!e() || e2Var == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        return a(e2Var, str);
    }

    private boolean a(int i) {
        Network network;
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        if (!e()) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT < 24 || (network = this.c.get(Integer.valueOf(i))) == null || (connectivityManager = this.d) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null) {
                return false;
            }
            return networkCapabilities.hasCapability(16);
        } catch (Exception e2) {
            e2.toString();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Network network, NetworkCapabilities networkCapabilities, boolean z) {
        if (Build.VERSION.SDK_INT < 24 || !networkCapabilities.hasCapability(16)) {
            return;
        }
        if (networkCapabilities.hasTransport(1)) {
            if (!network.equals(this.c.get(1))) {
                this.c.put(1, network);
            }
        } else if (networkCapabilities.hasTransport(0) && !network.equals(this.c.get(2))) {
            this.c.put(2, network);
        }
        if (!z || network.equals(this.c.get(3))) {
            return;
        }
        this.c.put(3, network);
    }

    public Pair<Integer, Integer> a(String str) {
        if (TextUtils.equals("1", str) && h() && f()) {
            return a(true);
        }
        if (TextUtils.equals("2", str)) {
            return a(false);
        }
        return new Pair<>(-1, -1);
    }

    private Pair<Integer, Integer> a(boolean z) throws NumberFormatException {
        int iA = xc.a("snsts", "APP", "", sy.a.intValue());
        if (iA > 1) {
            String strB = r1.d().f().b("snsts_" + iA, "");
            if (!TextUtils.isEmpty(strB)) {
                try {
                    String[] strArrSplit = strB.split(",");
                    if (strArrSplit.length == 2) {
                        int i = Integer.parseInt(strArrSplit[0]);
                        int i2 = Integer.parseInt(strArrSplit[1]);
                        if (i > 0 && i2 > 0) {
                            return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        if (z) {
            return new Pair<>(1000, 1500);
        }
        return new Pair<>(1500, 2000);
    }

    public boolean a() {
        return r1.d().f().a("snscdm", sy.c.intValue()) == 1;
    }

    private int a(h4 h4Var, String str, int i) {
        int iA = r1.d().f().a(str, i);
        return iA > 10000 ? com.qq.e.comm.plugin.b.c().a(h4Var.x0(), String.valueOf(iA), i) : iA;
    }
}
