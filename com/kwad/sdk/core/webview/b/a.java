package com.kwad.sdk.core.webview.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.b.b.a;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    private static volatile a bLR;
    private long aaL;
    private Context mContext;
    private volatile boolean mHasInit = false;
    private final List<com.kwad.sdk.h.a.b> bLS = new CopyOnWriteArrayList();
    private final List<String> bLT = new CopyOnWriteArrayList();
    private final List<String> bLU = new CopyOnWriteArrayList();
    private final NetworkMonitor.a aKk = new NetworkMonitor.a() { // from class: com.kwad.sdk.core.webview.b.a.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.adI();
            }
        }
    };

    private a() {
    }

    public static a adH() {
        if (bLR == null) {
            synchronized (a.class) {
                if (bLR == null) {
                    bLR = new a();
                }
            }
        }
        return bLR;
    }

    public final synchronized void init(final Context context) {
        if (!this.mHasInit && context != null) {
            this.mContext = ServiceProvider.anu();
            this.mHasInit = true;
            h.execute(new bh() { // from class: com.kwad.sdk.core.webview.b.a.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    try {
                        if (e.b(c.byx)) {
                            a.this.aaL = System.currentTimeMillis();
                            a.this.cl(context);
                            a.this.adI();
                            NetworkMonitor.getInstance().a(a.this.mContext, a.this.aKk);
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    public final long tz() {
        return this.aaL;
    }

    public final void adI() {
        if (e.Ys()) {
            h.execute(new bh() { // from class: com.kwad.sdk.core.webview.b.a.3
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    try {
                        List<com.kwad.sdk.h.a.b> listAdJ = a.this.adJ();
                        if (listAdJ != null && !listAdJ.isEmpty()) {
                            a.this.aq(listAdJ);
                            for (com.kwad.sdk.h.a.b bVar : listAdJ) {
                                if (bVar != null && bVar.packageType == 1 && (bVar.loadType == 1 || (bVar.loadType == 2 && ao.isWifiConnected(a.this.mContext)))) {
                                    a.this.a(bVar);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.h.a.b bVar) {
        if (this.bLU.contains(bVar.packageId) || TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        com.kwad.sdk.core.webview.b.b.a.a(bVar, new a.InterfaceC0594a() { // from class: com.kwad.sdk.core.webview.b.a.4
            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0594a
            public final void c(com.kwad.sdk.h.a.b bVar2) {
                a.this.bLU.add(bVar2.packageId);
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "download onStart: " + bVar2.toString());
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0594a
            public final void d(com.kwad.sdk.h.a.b bVar2) {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "download success: " + bVar2.toString());
                if (com.kwad.sdk.core.webview.b.b.b.a(a.this.mContext, bVar2)) {
                    com.kwad.sdk.core.d.c.d("HybridPackageManager", "install success: " + bVar2.toString());
                    a.this.bLS.add(bVar2);
                    a aVar = a.this;
                    aVar.ck(aVar.mContext);
                    com.kwad.sdk.core.webview.b.c.b.a(bVar2, 4);
                }
                a.this.bLU.remove(bVar2.packageId);
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0594a
            public final void e(com.kwad.sdk.h.a.b bVar2) {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "download failure: " + bVar2.toString());
                a.this.bLU.remove(bVar2.packageId);
            }
        });
    }

    public final WebResourceResponse ah(String str, String str2) {
        if (!this.mHasInit) {
            return null;
        }
        String strGs = com.kwad.sdk.core.webview.b.c.a.gs(str);
        if (!TextUtils.isEmpty(strGs)) {
            com.kwad.sdk.core.webview.b.c.b.c(str2, strGs, str);
            WebResourceResponse webResourceResponseAi = ai(strGs, str);
            com.kwad.sdk.core.webview.b.c.b.d(str2, strGs, str);
            return webResourceResponseAi;
        }
        return gn(str);
    }

    private WebResourceResponse ai(String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            b.a aVar = new b.a();
            this.bLT.add(str);
            WebResourceResponse webResourceResponseA = a(str, str2, aVar, false);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (webResourceResponseA != null) {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "load success time:" + jCurrentTimeMillis2 + "--url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 1, "", jCurrentTimeMillis2);
            } else {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "load fail errorMsg:" + aVar.msg + "-url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, aVar.msg, jCurrentTimeMillis2);
            }
            return webResourceResponseA;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th), System.currentTimeMillis() - jCurrentTimeMillis);
            return null;
        }
    }

    private WebResourceResponse gn(String str) {
        try {
            b.a aVar = new b.a();
            synchronized (this.bLS) {
                Iterator<String> it = this.bLT.iterator();
                while (it.hasNext()) {
                    WebResourceResponse webResourceResponseA = a(it.next(), str, aVar, true);
                    if (webResourceResponseA != null) {
                        return webResourceResponseA;
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private WebResourceResponse a(String str, String str2, b.a aVar, boolean z) {
        com.kwad.sdk.h.a.b bVarGp = gp(str);
        if (bVarGp == null) {
            com.kwad.sdk.h.a.b bVarGo = go(str);
            if (bVarGo == null) {
                aVar.msg = "配置文件没有下发该zip资源";
                return null;
            }
            aVar.msg = "资源未下载:" + bVarGo.loadType;
            b(bVarGo);
            return null;
        }
        return b.a(this.mContext, str2, bVarGp, aVar, z);
    }

    private com.kwad.sdk.h.a.b go(String str) {
        List<com.kwad.sdk.h.a.b> listAdJ = adJ();
        if (listAdJ != null && !listAdJ.isEmpty()) {
            for (com.kwad.sdk.h.a.b bVar : listAdJ) {
                if (bq.isEquals(str, bVar.packageId)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private com.kwad.sdk.h.a.b gp(String str) {
        synchronized (this.bLS) {
            if (!TextUtils.isEmpty(str) && this.bLS.size() > 0) {
                for (com.kwad.sdk.h.a.b bVar : this.bLS) {
                    if (TextUtils.equals(str, bVar.packageId)) {
                        return bVar;
                    }
                }
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.kwad.sdk.h.a.b> adJ() {
        List<com.kwad.sdk.h.a.a> list;
        SdkConfigData sdkConfigDataYi = e.Yi();
        if (sdkConfigDataYi == null || (list = sdkConfigDataYi.h5PreloadConfigs) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.kwad.sdk.h.a.a aVar : list) {
            if (aVar != null && aVar.cbl != null) {
                for (com.kwad.sdk.h.a.b bVar : aVar.cbl) {
                    a(bVar, aVar);
                    if (bVar.isValid()) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private void a(com.kwad.sdk.h.a.b bVar, com.kwad.sdk.h.a.a aVar) {
        bVar.packageId = aVar.sceneId;
        if (TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        String strGt = com.kwad.sdk.core.webview.b.c.a.gt(bVar.packageUrl);
        if (TextUtils.isEmpty(strGt)) {
            return;
        }
        bVar.cbm = strGt;
        bVar.cbn = com.kwad.sdk.core.webview.b.c.a.W(this.mContext, bVar.cbm);
    }

    private void b(final com.kwad.sdk.h.a.b bVar) {
        h.execute(new bh() { // from class: com.kwad.sdk.core.webview.b.a.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.h.a.b bVar2 = bVar;
                if (bVar2 != null) {
                    a.this.a(bVar2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(List<com.kwad.sdk.h.a.b> list) {
        synchronized (this.bLS) {
            cl(this.mContext);
            for (com.kwad.sdk.h.a.b bVar : this.bLS) {
                if (list.contains(bVar)) {
                    if (w.im(com.kwad.sdk.core.webview.b.c.a.Y(this.mContext, bVar.cbm))) {
                        list.remove(bVar);
                    }
                } else {
                    w.al(new File(bVar.cbn));
                    this.bLS.remove(bVar);
                }
            }
            ck(this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045 A[Catch: all -> 0x005d, TryCatch #4 {, blocks: (B:7:0x001e, B:16:0x0034, B:17:0x003f, B:19:0x0045, B:21:0x004f, B:22:0x0057, B:24:0x0059, B:25:0x005c, B:15:0x0031), top: B:33:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ck(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.h.a.b> r0 = r4.bLS
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.b.c.a.co(r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.util.List<com.kwad.sdk.h.a.b> r2 = r4.bLS     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            org.json.JSONArray r2 = com.kwad.sdk.utils.aa.aL(r2)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            byte[] r5 = r2.getBytes()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            r3.write(r5)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)     // Catch: java.lang.Throwable -> L5d
            goto L34
        L22:
            r5 = move-exception
            r1 = r3
            goto L59
        L25:
            r1 = r3
            goto L29
        L27:
            r5 = move-exception
            goto L59
        L29:
            java.lang.String r5 = "updatePackageIndexFile"
            java.lang.String r2 = "read packageIndex file error"
            com.kwad.sdk.core.d.c.e(r5, r2)     // Catch: java.lang.Throwable -> L27
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L5d
        L34:
            java.util.List<java.lang.String> r5 = r4.bLT     // Catch: java.lang.Throwable -> L5d
            r5.clear()     // Catch: java.lang.Throwable -> L5d
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.bLS     // Catch: java.lang.Throwable -> L5d
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L5d
        L3f:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L57
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L5d
            com.kwad.sdk.h.a.b r1 = (com.kwad.sdk.h.a.b) r1     // Catch: java.lang.Throwable -> L5d
            boolean r2 = r1.cbp     // Catch: java.lang.Throwable -> L5d
            if (r2 == 0) goto L3f
            java.util.List<java.lang.String> r2 = r4.bLT     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = r1.packageId     // Catch: java.lang.Throwable -> L5d
            r2.add(r1)     // Catch: java.lang.Throwable -> L5d
            goto L3f
        L57:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5d
            return
        L59:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L5d
            throw r5     // Catch: java.lang.Throwable -> L5d
        L5d:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5d
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.b.a.ck(android.content.Context):void");
    }

    @Deprecated
    private static List<com.kwad.sdk.h.a.b> a(String str, com.kwad.sdk.core.c<com.kwad.sdk.h.a.b> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.kwad.sdk.h.a.b bVar = (com.kwad.sdk.h.a.b) cVar.Le();
                bVar.parseJson(jSONObject);
                arrayList.add(bVar);
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:13:0x002a, B:22:0x003b, B:23:0x0045, B:24:0x0050, B:26:0x0056, B:28:0x006a, B:29:0x006f, B:31:0x0073, B:32:0x007b, B:20:0x0036, B:36:0x007f, B:37:0x0082), top: B:41:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056 A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:13:0x002a, B:22:0x003b, B:23:0x0045, B:24:0x0050, B:26:0x0056, B:28:0x006a, B:29:0x006f, B:31:0x0073, B:32:0x007b, B:20:0x0036, B:36:0x007f, B:37:0x0082), top: B:41:0x0004 }] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void cl(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.h.a.b> r0 = r4.bLS
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.b.c.a.co(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            boolean r2 = com.kwad.sdk.utils.w.Y(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            if (r2 == 0) goto L29
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r5.<init>(r2)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            java.lang.String r5 = com.kwad.sdk.crash.utils.h.b(r5)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            com.kwad.sdk.core.webview.b.a$6 r3 = new com.kwad.sdk.core.webview.b.a$6     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r3.<init>()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            java.util.List r5 = a(r5, r3)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r1 = r2
            goto L2a
        L27:
            r5 = move-exception
            goto L33
        L29:
            r5 = r1
        L2a:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L83
            r1 = r5
            goto L39
        L2f:
            r5 = move-exception
            goto L7f
        L31:
            r5 = move-exception
            r2 = r1
        L33:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L7d
            com.kwad.sdk.crash.utils.b.closeQuietly(r2)     // Catch: java.lang.Throwable -> L83
        L39:
            if (r1 == 0) goto L45
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.bLS     // Catch: java.lang.Throwable -> L83
            r5.clear()     // Catch: java.lang.Throwable -> L83
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.bLS     // Catch: java.lang.Throwable -> L83
            r5.addAll(r1)     // Catch: java.lang.Throwable -> L83
        L45:
            java.util.List<java.lang.String> r5 = r4.bLT     // Catch: java.lang.Throwable -> L83
            r5.clear()     // Catch: java.lang.Throwable -> L83
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.bLS     // Catch: java.lang.Throwable -> L83
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L83
        L50:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L7b
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L83
            com.kwad.sdk.h.a.b r1 = (com.kwad.sdk.h.a.b) r1     // Catch: java.lang.Throwable -> L83
            android.content.Context r2 = r4.mContext     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r1.cbm     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = com.kwad.sdk.core.webview.b.c.a.Y(r2, r3)     // Catch: java.lang.Throwable -> L83
            boolean r2 = com.kwad.sdk.utils.w.im(r2)     // Catch: java.lang.Throwable -> L83
            if (r2 != 0) goto L6f
            java.util.List<com.kwad.sdk.h.a.b> r2 = r4.bLS     // Catch: java.lang.Throwable -> L83
            r2.remove(r1)     // Catch: java.lang.Throwable -> L83
        L6f:
            boolean r2 = r1.cbp     // Catch: java.lang.Throwable -> L83
            if (r2 == 0) goto L50
            java.util.List<java.lang.String> r2 = r4.bLT     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = r1.packageId     // Catch: java.lang.Throwable -> L83
            r2.add(r1)     // Catch: java.lang.Throwable -> L83
            goto L50
        L7b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L83
            return
        L7d:
            r5 = move-exception
            r1 = r2
        L7f:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L83
            throw r5     // Catch: java.lang.Throwable -> L83
        L83:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L83
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.b.a.cl(android.content.Context):void");
    }
}
