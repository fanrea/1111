package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static final int bDE;
    private final Random avb;
    private final Map<String, String> bDA;
    private final com.kwad.sdk.core.network.idc.a.b bDB;
    private final Map<String, AtomicBoolean> bDC;
    private final Map<String, com.kwad.sdk.core.network.idc.a.a> bDD;
    private volatile int bDF;
    private volatile boolean bDG;
    private Context mContext;

    /* synthetic */ a(byte b) {
        this();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.bDG = false;
        return false;
    }

    /* renamed from: com.kwad.sdk.core.network.idc.a$a, reason: collision with other inner class name */
    static final class C0590a {
        private static final a bDJ = new a(0);
    }

    private a() {
        this.bDA = new ConcurrentHashMap(8);
        this.bDB = new com.kwad.sdk.core.network.idc.a.b();
        this.avb = new Random(System.currentTimeMillis());
        HashMap map = new HashMap();
        this.bDC = map;
        this.bDD = new ConcurrentHashMap(4);
        this.bDF = 0;
        this.bDG = false;
        map.put("api", new AtomicBoolean(false));
        map.put("ulog", new AtomicBoolean(false));
        map.put("zt", new AtomicBoolean(false));
        map.put("cdn", new AtomicBoolean(false));
    }

    public static a aaw() {
        return C0590a.bDJ;
    }

    static {
        bDE = com.kwad.framework.a.a.qr.booleanValue() ? 0 : 60000;
    }

    public final void init(final Context context) {
        this.mContext = context.getApplicationContext();
        this.bDG = true;
        h.execute(new bh() { // from class: com.kwad.sdk.core.network.idc.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.bDA.putAll(b.bP(context));
                a.this.aax();
                if (!a.this.bDB.isEmpty()) {
                    Iterator<String> it = a.this.bDB.aaD().iterator();
                    while (it.hasNext()) {
                        a.this.fs(it.next());
                    }
                }
                c.d("IdcManager", "idc prepare done.");
                a.a(a.this, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aax() {
        com.kwad.sdk.core.network.idc.a.b bVarBO = b.bO(this.mContext);
        if (bVarBO.isEmpty()) {
            bVarBO = b.bN(this.mContext);
        }
        this.bDB.a(bVarBO);
    }

    public final void a(com.kwad.sdk.core.network.idc.a.b bVar, int i) {
        this.bDF = i * 1000;
        c.d("IdcManager", "updateIdcData,rollback interval = " + i);
        if (i == 0) {
            this.bDD.clear();
        }
        this.bDB.a(bVar);
        h.execute(new bh() { // from class: com.kwad.sdk.core.network.idc.a.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                b.a(a.this.mContext, a.this.bDB);
            }
        });
    }

    private void ac(String str, String str2) {
        String host;
        StringBuilder sb;
        List<String> listFv = this.bDB.fv(str2);
        if (listFv.isEmpty() || (host = Uri.parse(str).getHost()) == null || host.isEmpty()) {
            return;
        }
        c.d("IdcManager", ">>> switchHost start, try get lock, type = " + str2 + ", old host = " + host);
        AtomicBoolean atomicBoolean = this.bDC.get(str2);
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                String strFt = ft(str2);
                if ((TextUtils.isEmpty(strFt) || host.equals(strFt)) ? false : true) {
                    atomicBoolean.set(false);
                    sb = new StringBuilder("<<< switchHost end, type = ");
                } else {
                    int size = listFv.size();
                    int iIndexOf = listFv.indexOf(host);
                    boolean z = iIndexOf >= 0;
                    if (z) {
                        size--;
                    }
                    if (size <= 0) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int iNextInt = this.avb.nextInt(size) + 1;
                        if (z) {
                            iNextInt += iIndexOf;
                        }
                        int size2 = iNextInt % listFv.size();
                        String str3 = listFv.get(size2);
                        c.d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + listFv + ", key = " + size2);
                        ae(str2, str3);
                        if (u(str2, size2)) {
                            fq(str2);
                        }
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    }
                }
                c.d("IdcManager", sb.append(str2).append(", old host = ").append(host).toString());
            } catch (Throwable th) {
                atomicBoolean.set(false);
                c.d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                throw th;
            }
        }
    }

    private boolean u(String str, int i) {
        return "api".equals(str) && i > 0 && !this.bDD.containsKey(str) && this.bDF > 0;
    }

    private void fq(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        c.d("IdcManager", "save switched host, type = " + str);
        this.bDD.put(str, new com.kwad.sdk.core.network.idc.a.a(jElapsedRealtime, false));
    }

    public final boolean aay() {
        return !this.bDD.isEmpty();
    }

    public final void fr(String str) {
        int i = this.bDF;
        if (this.bDG || i <= 0) {
            c.d("IdcManager", "performHostRollback is invalid, by in prepare = " + this.bDG + ",rollbackInterval = " + i);
            return;
        }
        com.kwad.sdk.core.network.idc.a.a aVar = this.bDD.get(str);
        if (aVar != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - aVar.aaB();
            boolean z = jElapsedRealtime > ((long) Math.max(i, bDE));
            c.d("IdcManager", "handleHostRollback: isAvailable = " + z + ",interval = " + jElapsedRealtime + ",rollbackInterval = " + i + ",hostType = hostType");
            if (z) {
                AtomicBoolean atomicBoolean = this.bDC.get(str);
                try {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        boolean zAaA = aVar.aaA();
                        c.d("IdcManager", "handleHostRollback: isInRollback = " + zAaA);
                        if (!zAaA) {
                            aVar.cw(true);
                            if (fs(str)) {
                                this.bDD.remove(str);
                                c.d("IdcManager", "handleHostRollback success,remove switched host, type = " + str);
                            } else {
                                c.d("IdcManager", "rollbackToMainHost failed, reset attempt time.");
                                fq(str);
                            }
                        }
                    }
                } catch (Exception e) {
                    c.e("IdcManager", "handleHostRollback failed by " + e.getMessage());
                } finally {
                    atomicBoolean.set(false);
                    c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fs(String str) {
        boolean zIw;
        String strFt = ft(str);
        List<String> listFv = this.bDB.fv(str);
        if (listFv.isEmpty()) {
            return false;
        }
        String str2 = listFv.get(0);
        if (TextUtils.equals(str2, strFt)) {
            return true;
        }
        if ("api".equals(str)) {
            zIw = c(com.kwad.framework.a.a.qr.booleanValue() ? "beta2-ad-open-api.test.gifshow.com" : str2, this.mContext);
        } else {
            zIw = ao.iw(str2);
        }
        c.d("IdcManager", "perform ping action for " + str + ",mainHost = " + str2 + ",isSuccess = " + zIw);
        if (zIw) {
            ae(str, str2);
        }
        return zIw;
    }

    public final String ad(String str, String str2) {
        String str3 = this.bDA.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    private String ft(String str) {
        return this.bDA.get(str);
    }

    private void ae(String str, String str2) {
        c.d("IdcManager", "updateCurrentIdc: hostType = " + str + ",new host = " + str2);
        this.bDA.put(str, str2);
        h.execute(new bh() { // from class: com.kwad.sdk.core.network.idc.a.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                b.a(a.this.mContext, (Map<String, String>) a.this.bDA);
            }
        });
    }

    public final void a(String str, int i, Throwable th) {
        a(str, "ulog", new DomainException(i, th));
    }

    public final void h(String str, Throwable th) {
        a(str, "cdn", new DomainException(th));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str == null || domainException == null || !a(domainException)) {
            return;
        }
        ac(str, str2);
    }

    private static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }

    public final String fu(String str) {
        return af(str, "cdn");
    }

    public final String af(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strFt = ft(str2);
        if (strFt == null || strFt.isEmpty()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(uri.getPath()) || strFt.equals(uri.getHost())) {
            return str;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.authority(strFt);
        if (TextUtils.isEmpty(uri.getScheme())) {
            builder.scheme("https");
        } else {
            builder.scheme(uri.getScheme());
        }
        builder.path(uri.getPath());
        if (!TextUtils.isEmpty(uri.getQuery())) {
            builder.query(uri.getQuery());
        }
        return URLDecoder.decode(builder.build().toString());
    }

    private static boolean c(final String str, Context context) {
        boolean zIsNetworkConnected = ao.isNetworkConnected(context);
        c.d("IdcManager", "connect host = " + str + ",isNetworkConnected = " + zIsNetworkConnected);
        if (zIsNetworkConnected && str != null) {
            AdHttpProxy adHttpProxyST = g.ST();
            d dVar = new d() { // from class: com.kwad.sdk.core.network.idc.a.4
                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseBody() {
                }

                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseHeader() {
                }

                @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                public final String getUrl() {
                    return com.kwad.sdk.h.dv("https://" + str);
                }
            };
            com.kwad.sdk.core.network.c cVarDoGet = adHttpProxyST.doGet(dVar.getUrl(), Collections.emptyMap());
            c.d("IdcManager", "perform connect host:" + dVar.getUrl());
            if (cVarDoGet != null) {
                c.d("IdcManager", "connect host response, rawCode = " + cVarDoGet.bCq + ",body = " + cVarDoGet.bCs);
                if (cVarDoGet.bCq == 200) {
                    return true;
                }
            }
        }
        return false;
    }
}
