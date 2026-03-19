package com.kwad.components.core.u;

import com.kwad.sdk.components.t;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j {
    private static final ConcurrentHashMap<Integer, a> aaE = new ConcurrentHashMap<>();
    public static final long aaF = com.kwad.sdk.core.config.e.Za().longValue() * 1000;
    private static final Map<Integer, bh> aaG = new ConcurrentHashMap();
    private static Map<Integer, Long> aaH = new HashMap();

    public static void a(Integer num, t tVar, long j, long j2, long j3, long j4) {
        if (tVar == null && (num == null || num.intValue() == 0)) {
            return;
        }
        try {
            e(num);
            ConcurrentHashMap<Integer, a> concurrentHashMap = aaE;
            a aVar = concurrentHashMap.get(num);
            if (aVar == null) {
                concurrentHashMap.put(num, new a(tVar, j, j2, j3, j4));
            } else {
                aVar.tE();
            }
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    public static t a(Integer num) {
        if (num != null && num.intValue() != 0) {
            try {
                e(num);
                a aVar = aaE.get(num);
                if (aVar == null) {
                    return null;
                }
                aVar.tE();
                return aVar.aaJ;
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
        return null;
    }

    public static a b(Integer num) {
        if (num != null && num.intValue() != 0) {
            try {
                e(num);
                a aVar = aaE.get(num);
                if (aVar == null) {
                    return null;
                }
                aVar.tE();
                return aVar;
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
        return null;
    }

    public static void c(Integer num) {
        if (num == null || num.intValue() == 0) {
            return;
        }
        try {
            a aVar = aaE.get(num);
            if (aVar == null || aVar.tF() != 0) {
                return;
            }
            d(num);
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    private static void d(final Integer num) {
        if (num == null || num.intValue() == 0) {
            return;
        }
        e(num);
        bh bhVar = new bh() { // from class: com.kwad.components.core.u.j.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a aVar = (a) j.aaE.get(num);
                if (aVar != null) {
                    aVar.aaJ.onDestroy();
                }
                j.aaH.remove(num);
                j.aaE.remove(num);
            }
        };
        aaG.put(num, bhVar);
        bx.runOnUiThreadDelay(bhVar, aaF);
    }

    private static void e(Integer num) {
        Map<Integer, bh> map = aaG;
        bh bhVar = map.get(num);
        if (bhVar != null) {
            bx.d(bhVar);
            map.remove(num);
        }
    }

    public static class a {
        private long KA;
        private final t aaJ;
        private final AtomicInteger aaK;
        private long aaL;
        private long aaM;
        private long aaN;

        public a(t tVar, long j, long j2, long j3, long j4) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            this.aaK = atomicInteger;
            this.aaJ = tVar;
            atomicInteger.set(1);
            this.aaL = j;
            this.KA = j2;
            this.aaM = j3;
            this.aaN = j4;
        }

        public final long tz() {
            return this.aaL;
        }

        public final long tA() {
            return this.KA;
        }

        public final long tB() {
            return this.aaM;
        }

        public final long tC() {
            return this.aaN;
        }

        public final t tD() {
            return this.aaJ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tE() {
            this.aaK.incrementAndGet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int tF() {
            return this.aaK.decrementAndGet();
        }
    }
}
