package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static HandlerThread cbA = null;
    private static Handler cbB = null;
    private static int cbq = -1;
    private static volatile boolean cbr;
    private static c cbz;
    private static List<HttpDnsInfo.IpInfo> cbs = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> cbt = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> cbu = new CopyOnWriteArrayList();
    private static List<c> cbv = new CopyOnWriteArrayList();
    private static List<c> cbw = new CopyOnWriteArrayList();
    private static PriorityBlockingQueue<c> cbx = new PriorityBlockingQueue<>();
    private static AtomicInteger cby = new AtomicInteger(0);
    private static volatile boolean cbC = false;
    private static float cbD = -1.0f;
    private static float cbE = -1.0f;
    private static float cbF = -1.0f;
    private static int cbG = 0;
    private static volatile boolean cbH = false;
    private static volatile boolean cbI = false;
    private static NetworkMonitor.a cbJ = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange");
            if (a.cbI) {
                a.access$102(true);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
            } else {
                a.access$002(true);
            }
        }
    };
    private static Runnable cbK = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.akm();
        }
    };

    static /* synthetic */ boolean access$002(boolean z) {
        cbI = true;
        return true;
    }

    static /* synthetic */ boolean access$102(boolean z) {
        cbH = true;
        return true;
    }

    private static void init() {
        if (cbA != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        cbA = handlerThread;
        handlerThread.start();
        cbB = new Handler(cbA.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    a.akm();
                    a.akn();
                } else {
                    if (i != 2) {
                        return;
                    }
                    a.akv();
                }
            }
        };
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            NetworkMonitor.getInstance().a(fVar.getContext(), cbJ);
        }
    }

    private static void akh() {
        Handler handler;
        if (cbC || (handler = cbB) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    public static String aki() {
        c cVar = cbz;
        return cVar != null ? cVar.getIp() : "";
    }

    public static float akj() {
        return cbD;
    }

    public static float akk() {
        return cbE;
    }

    public static float akl() {
        return cbF;
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean zUm = hVar.Um();
        cbr = zUm;
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isEnable:" + zUm);
        if (zUm) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", httpDnsInfo.toString());
            cbs = httpDnsInfo.recommendList;
            cbt = httpDnsInfo.backUpList;
            cbu = httpDnsInfo.otherList;
            if (cbs.isEmpty() && cbt.isEmpty() && cbu.isEmpty()) {
                com.kwad.sdk.core.d.c.w("IpDirect_Helper", "HttpDnsInfo is empty");
            } else {
                init();
                akh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void akm() {
        akr();
        List<HttpDnsInfo.IpInfo> list = cbs;
        List<HttpDnsInfo.IpInfo> list2 = cbt;
        clear();
        if (cbC) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "start pick");
        cbC = true;
        ay(list);
        az(list2);
        if (cbv.isEmpty() && cbw.isEmpty()) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar == null) {
                cbC = false;
                return;
            } else {
                if (!hVar.Un()) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isIpPreferEnable:false");
                    cbC = false;
                    return;
                }
                akp();
            }
        }
        cbC = false;
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "end pick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void akn() {
        if (ako()) {
            return;
        }
        akq();
    }

    private static boolean ako() {
        List<c> list = cbv;
        List<c> list2 = cbw;
        if (!list.isEmpty()) {
            cbz = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from recommend:" + cbz);
            cbG = 1;
            return true;
        }
        int i = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        int weight = 0;
        for (c cVar : list2) {
            if (cVar != null) {
                weight += cVar.getWeight();
            }
        }
        if (weight <= 0) {
            return false;
        }
        int iNextInt = random.nextInt(weight);
        int i2 = 0;
        while (true) {
            if (i2 >= list2.size()) {
                break;
            }
            if (list2.get(i2) != null) {
                iNextInt -= list2.get(i2).getWeight();
            }
            if (iNextInt < 0) {
                i = i2;
                break;
            }
            i2++;
        }
        cbz = list2.get(i);
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from backUp:" + cbz);
        cbG = 2;
        return true;
    }

    public static int getType() {
        return cbG;
    }

    private static void clear() {
        cbv.clear();
        cbw.clear();
        cbx.clear();
    }

    private static void akp() {
        List<HttpDnsInfo.IpInfo> list = cbu;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                c cVarH = b.h(ipInfo.ip, cbq);
                if (cVarH.isSuccess()) {
                    cbx.offer(cVarH);
                }
            }
        }
        c cVarPeek = cbx.peek();
        if (cVarPeek != null) {
            cbF = cVarPeek.akD();
        }
    }

    private static void akq() {
        if (cbx.isEmpty()) {
            return;
        }
        c cVarPeek = cbx.peek();
        if (cVarPeek.akD() < cbq) {
            cbz = cVarPeek;
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from Other:" + cbz);
            cbG = 3;
        }
    }

    private static void c(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", ipInfo.toString());
                c cVarH = b.h(ipInfo.ip, cbq);
                cVarH.gx(ipInfo.weight);
                if (cVarH.isSuccess() && cVarH.akD() < cbq) {
                    list2.add(cVarH);
                }
            }
        }
    }

    private static void ay(List<HttpDnsInfo.IpInfo> list) {
        c(list, cbv);
        if (cbv.isEmpty()) {
            return;
        }
        Iterator<c> it = cbv.iterator();
        float fAkD = 0.0f;
        while (it.hasNext()) {
            fAkD += it.next().akD();
        }
        cbD = fAkD / cbv.size();
    }

    private static void az(List<HttpDnsInfo.IpInfo> list) {
        c(list, cbw);
        if (cbw.isEmpty()) {
            return;
        }
        int weight = 0;
        float weight2 = 0.0f;
        for (c cVar : cbw) {
            if (cVar != null) {
                weight += cVar.getWeight();
                weight2 += cVar.getWeight() * cVar.akD();
            }
        }
        if (weight != 0) {
            cbE = weight2 / weight;
        }
    }

    private static void akr() {
        if (cbq == -1) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar != null) {
                cbq = hVar.Uo();
            } else {
                cbq = 200;
            }
        }
    }

    private static boolean aks() {
        if (cbH) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i = cby.get();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "value:" + i);
        return i <= 3;
    }

    private static void akt() {
        cby.getAndIncrement();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "addFailedTimes:" + cby.intValue());
    }

    public static String ht(String str) {
        if (!cbr) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "getIpByHost return by sIpDirectEnable false");
            return "";
        }
        if (hu(str)) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isHostInvalid:false ：" + str);
            return "";
        }
        if (!aks()) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "canUseIpDirect:false");
            return "";
        }
        String strAki = aki();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "getIpByHost ip:" + strAki);
        return strAki;
    }

    private static boolean hu(String str) {
        boolean z = !TextUtils.equals("https://" + str, com.kwad.sdk.h.SV());
        if (z) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "非核心域名 current host:" + com.kwad.sdk.h.SV() + "try direct host:https://" + str);
        }
        return z;
    }

    public static void aku() {
        c cVar;
        Handler handler;
        if (!cbr || (cVar = cbz) == null || TextUtils.isEmpty(cVar.getIp()) || (handler = cbB) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    public static void akv() {
        akt();
        akw();
        akx();
        cbG = 0;
        akn();
        akm();
    }

    private static void akw() {
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo next;
        c cVar = cbz;
        String ip = cVar == null ? "" : cVar.getIp();
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = cbs.iterator();
        while (true) {
            ipInfo = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && TextUtils.equals(ip, next.ip)) {
                break;
            }
        }
        if (next != null) {
            cbs.remove(next);
            next = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = cbt.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next2 = it2.next();
            if (next2 != null && TextUtils.equals(ip, next2.ip)) {
                next = next2;
                break;
            }
        }
        if (next != null) {
            cbt.remove(next);
        } else {
            ipInfo = next;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = cbu.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next3 = it3.next();
            if (next3 != null && TextUtils.equals(ip, next3.ip)) {
                ipInfo = next3;
                break;
            }
        }
        if (ipInfo != null) {
            cbu.remove(ipInfo);
        }
    }

    private static void akx() {
        c next;
        if (cbz == null) {
            return;
        }
        List<c> list = cbv;
        if (list != null && !list.isEmpty() && cbv.contains(cbz)) {
            cbv.remove(cbz);
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sRecommendEntityList remove:" + cbz);
        }
        List<c> list2 = cbw;
        if (list2 != null && !list2.isEmpty()) {
            if (cbw.contains(cbz)) {
                cbw.remove(cbz);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + cbz);
            }
            Iterator<c> it = cbw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && TextUtils.equals(next.getIp(), cbz.getIp())) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set removeEntity:" + next.getIp());
                    break;
                }
            }
            if (next != null) {
                cbw.remove(next);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + next);
            }
        }
        c cVarPeek = cbx.peek();
        if (cVarPeek != null && cVarPeek == cbz) {
            cbx.poll();
        }
        cbz = null;
    }
}
