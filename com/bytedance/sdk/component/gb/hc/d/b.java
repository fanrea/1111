package com.bytedance.sdk.component.gb.hc.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements u {
    private final Queue<String> b;
    private com.bytedance.sdk.component.gb.d.u c;
    private final u d;
    private final c hc;
    private com.bytedance.sdk.component.gb.hc.hc.b.b u;

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public List<com.bytedance.sdk.component.gb.d.hc> d(int i, com.bytedance.sdk.component.gb.d.hc hcVar, boolean z, List<String> list) {
        return null;
    }

    public b(com.bytedance.sdk.component.gb.d.u uVar, com.bytedance.sdk.component.gb.hc.hc.b.b bVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.b = concurrentLinkedQueue;
        this.c = uVar;
        this.u = bVar;
        this.d = new an(concurrentLinkedQueue, this.c);
        this.hc = new c(this.c);
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public synchronized void d(com.bytedance.sdk.component.gb.d.hc hcVar) {
        if (!com.bytedance.sdk.component.gb.hc.b.d.tt(hcVar, this.c) || !this.u.c()) {
            this.d.d(hcVar);
        }
        if (hcVar != null) {
            this.hc.d(hcVar);
        }
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public synchronized hc d(int i, List<com.bytedance.sdk.component.gb.d.hc> list, int i2) {
        hc hcVarD;
        try {
            Iterator<com.bytedance.sdk.component.gb.d.hc> it = list.iterator();
            while (it.hasNext()) {
                this.b.remove(it.next().b());
            }
        } catch (Throwable th) {
            hc hcVar = new hc();
            hcVar.d(false);
            hcVar.d("sending exception:" + th.getMessage());
            com.bytedance.sdk.component.gb.hc.b.b.b(th.getMessage(), this.c);
        }
        try {
            this.d.d(i, list, i2);
        } catch (Throwable th2) {
            hc hcVar2 = new hc();
            hcVar2.d(false);
            hcVar2.d("mem exception:" + th2.getMessage());
            com.bytedance.sdk.component.gb.hc.b.b.b(th2.getMessage(), this.c);
        }
        try {
            hcVarD = this.hc.d(i, list, i2);
        } catch (Exception e) {
            hc hcVar3 = new hc();
            hcVar3.d(false);
            hcVar3.d("db exception:" + e.getMessage());
            com.bytedance.sdk.component.gb.hc.b.b.b(e.getMessage(), this.c);
            hcVarD = hcVar3;
        }
        return hcVarD;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public synchronized List<com.bytedance.sdk.component.gb.d.hc> d(int i, com.bytedance.sdk.component.gb.d.hc hcVar, boolean z, String str) {
        List<com.bytedance.sdk.component.gb.d.hc> list;
        boolean z2;
        List<com.bytedance.sdk.component.gb.d.hc> listD = this.d.d(i, hcVar, z, (List<String>) null);
        if (listD != 0 && listD.size() != 0) {
            int size = listD.size();
            list = listD;
            if (com.bytedance.sdk.component.gb.hc.b.d.d(i)) {
                List<com.bytedance.sdk.component.gb.d.hc> listD2 = this.hc.d((com.bytedance.sdk.component.gb.d.hc) listD.get(0), size, i, z);
                list = listD;
                if (listD2 != null) {
                    list = listD;
                    if (listD2.size() != 0) {
                        listD2.size();
                        HashMap map = new HashMap();
                        for (com.bytedance.sdk.component.gb.d.hc hcVar2 : listD2) {
                            map.put(hcVar2.b(), hcVar2);
                        }
                        ArrayList arrayList = new ArrayList(this.b);
                        arrayList.size();
                        for (com.bytedance.sdk.component.gb.d.hc hcVar3 : listD2) {
                            Iterator it = arrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                if (TextUtils.equals(hcVar3.b(), (String) it.next())) {
                                    z2 = true;
                                    break;
                                }
                            }
                            if (z2) {
                                map.remove(hcVar3.b());
                            }
                        }
                        for (com.bytedance.sdk.component.gb.d.hc hcVar4 : listD) {
                            map.put(hcVar4.b(), hcVar4);
                        }
                        listD.clear();
                        Set setKeySet = map.keySet();
                        map.size();
                        Iterator it2 = setKeySet.iterator();
                        while (it2.hasNext()) {
                            listD.add(map.get((String) it2.next()));
                        }
                        listD2.clear();
                        list = listD;
                    }
                }
            }
        } else {
            ArrayList<String> arrayList2 = new ArrayList(this.b);
            int size2 = arrayList2.size();
            List<com.bytedance.sdk.component.gb.d.hc> listD3 = this.hc.d(i, hcVar, z, arrayList2);
            if (listD3 != 0 && listD3.size() != 0) {
                listD3.size();
                HashMap map2 = new HashMap();
                for (com.bytedance.sdk.component.gb.d.hc hcVar5 : listD3) {
                    map2.put(hcVar5.b(), hcVar5);
                }
                if (size2 != 0) {
                    for (String str2 : arrayList2) {
                        if (map2.get(str2) != null) {
                            map2.remove(str2);
                        }
                    }
                }
                listD3.clear();
                Set setKeySet2 = map2.keySet();
                map2.size();
                Iterator it3 = setKeySet2.iterator();
                while (it3.hasNext()) {
                    listD3.add(map2.get((String) it3.next()));
                }
            }
            list = listD3;
        }
        if (list != null && !list.isEmpty()) {
            list.size();
            Iterator<com.bytedance.sdk.component.gb.d.hc> it4 = list.iterator();
            while (it4.hasNext()) {
                this.b.offer(it4.next().b());
            }
            return list;
        }
        return new ArrayList();
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.u
    public synchronized boolean d(int i, String str, com.bytedance.sdk.component.gb.d.hc hcVar) {
        if (this.d.d(i, str, hcVar)) {
            com.bytedance.sdk.component.gb.hc.b.b.hc("_opt", "cacheManager check result : memory meet ".concat(String.valueOf(str)), this.c);
            return true;
        }
        if (!com.bytedance.sdk.component.gb.hc.b.d.d(i) || !this.hc.d(i, str, hcVar)) {
            return false;
        }
        com.bytedance.sdk.component.gb.hc.b.b.hc("_opt", "cacheManager check result : db meet ".concat(String.valueOf(str)), this.c);
        return true;
    }
}
