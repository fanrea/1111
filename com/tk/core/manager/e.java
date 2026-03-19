package com.tk.core.manager;

import com.tachikoma.core.TKProviderCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
class e {
    private static final List<com.tk.core.manager.a.d> aio = new ArrayList();
    private static final List<com.tk.core.manager.a.e> aip = new ArrayList();
    private static final List<com.tk.core.manager.a.b> aiq = new ArrayList();
    private static final Map<String, com.tk.core.manager.a.a<?>> air = new HashMap();
    private static final Map<String, com.tk.core.manager.a.a<?>> ais = new HashMap();
    private static final Map<String, com.tk.core.manager.a.a<?>> ait = new HashMap();
    private static final List<String> aiu = new LinkedList();
    private static final Set<String> aiv = new HashSet();

    e() {
    }

    static void init(boolean z) {
        so();
        o(aio);
        o(aip);
        sq();
        sr();
        if (z) {
            sp();
        } else {
            sm();
        }
    }

    private static void sm() {
        o(aiq);
        ss();
    }

    public static Map<String, Object> b(String str, Object obj) {
        com.tk.core.manager.a.a aVarCN = cN(str);
        if (aVarCN instanceof com.tk.core.manager.a.c) {
            return ((com.tk.core.manager.a.c) aVarCN).I(obj);
        }
        return null;
    }

    static void registerExtraLib(String... strArr) {
        synchronized (aiv) {
            if (b(strArr)) {
                return;
            }
            aiv.addAll(Arrays.asList(strArr));
        }
    }

    static String[] sb() {
        if (aiu.isEmpty()) {
            return (String[]) ait.keySet().toArray(new String[0]);
        }
        return (String[]) aiu.toArray(new String[0]);
    }

    static Map<String, com.tk.core.manager.a.a<?>> sc() {
        return air;
    }

    static Map<String, com.tk.core.manager.a.a<?>> sd() {
        return ais;
    }

    static com.tk.core.manager.a.a cN(String str) {
        com.tk.core.manager.a.a<?> aVar = ait.get(str);
        if (aVar != null) {
            return aVar;
        }
        com.tk.core.manager.a.a<?> aVar2 = air.get(str);
        if (aVar2 != null) {
            return aVar2;
        }
        com.tk.core.manager.a.a<?> aVar3 = ais.get(str);
        if (aVar3 != null) {
            return aVar3;
        }
        for (com.tk.core.manager.a.b bVar : aiq) {
            if (bVar.i(str)) {
                com.tk.core.manager.a.a<?> aVarJ = bVar.j(str);
                ait.put(str, aVarJ);
                return aVarJ;
            }
        }
        return aVar3;
    }

    private static void sn() {
        registerExtraLib("com.tachikoma.component");
        synchronized (aiv) {
            Iterator<String> it = aiv.iterator();
            while (it.hasNext()) {
                cP(it.next());
            }
        }
    }

    private static void o(List<? extends b> list) {
        if (list != null) {
            Iterator<? extends b> it = list.iterator();
            while (it.hasNext()) {
                it.next().ae();
            }
        }
    }

    private static void so() {
        a(new TKProviderCollector());
        sn();
    }

    private static void a(IProviderCollector iProviderCollector) {
        for (b bVar : iProviderCollector.collectProviders()) {
            if (bVar instanceof com.tk.core.manager.a.d) {
                a((com.tk.core.manager.a.d) bVar);
            } else if (bVar instanceof com.tk.core.manager.a.e) {
                a((com.tk.core.manager.a.e) bVar);
            } else if (bVar instanceof com.tk.core.manager.a.b) {
                a((com.tk.core.manager.a.b) bVar);
            } else {
                throw new RuntimeException("Unknown provider: " + bVar);
            }
        }
    }

    private static void sp() {
        Iterator<com.tk.core.manager.a.b> it = aiq.iterator();
        while (it.hasNext()) {
            aiu.addAll(Arrays.asList(it.next().hI()));
        }
    }

    private static void a(com.tk.core.manager.a.d dVar) {
        if (aio.contains(dVar)) {
            return;
        }
        aio.add(dVar);
    }

    private static void a(com.tk.core.manager.a.e eVar) {
        if (aip.contains(eVar)) {
            return;
        }
        aip.add(eVar);
    }

    private static void a(com.tk.core.manager.a.b bVar) {
        if (aiq.contains(bVar)) {
            return;
        }
        aiq.add(bVar);
    }

    private static IProviderCollector cO(String str) {
        try {
            return (IProviderCollector) e.class.getClassLoader().loadClass(str).newInstance();
        } catch (Throwable th) {
            com.tk.core.i.a.a("TKProviderCollection", "createProviderCollector exception: " + str, th);
            return null;
        }
    }

    private static void cP(String str) {
        try {
            IProviderCollector iProviderCollectorCO = cO(str + ".TKProviderCollector");
            if (iProviderCollectorCO != null) {
                a(iProviderCollectorCO);
            }
        } catch (Throwable th) {
            com.tk.core.i.a.a("TKProviderCollection", "safelyRegister exception: " + str, th);
        }
    }

    private static void sq() {
        Iterator<com.tk.core.manager.a.d> it = aio.iterator();
        while (it.hasNext()) {
            air.putAll(it.next().hJ());
        }
    }

    private static void sr() {
        Iterator<com.tk.core.manager.a.e> it = aip.iterator();
        while (it.hasNext()) {
            ais.putAll(it.next().hJ());
        }
    }

    private static void ss() {
        Iterator<com.tk.core.manager.a.b> it = aiq.iterator();
        while (it.hasNext()) {
            ait.putAll(it.next().hJ());
        }
    }

    private static boolean b(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }
}
