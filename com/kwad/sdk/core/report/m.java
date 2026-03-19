package com.kwad.sdk.core.report;

import com.kwad.sdk.core.report.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class m<T extends e> implements l<T> {
    private final Map<String, T> aIW = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized void q(T t) {
        this.aIW.put(t.actionId, t);
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        int size;
        size = this.aIW.size();
        com.kwad.sdk.core.d.c.d("MemReportCache", "size() = " + size);
        return size;
    }

    @Override // com.kwad.sdk.core.report.l
    public final List<T> fq(int i) {
        ArrayList arrayList = new ArrayList(this.aIW.size());
        synchronized (this.aIW) {
            Iterator<Map.Entry<String, T>> it = this.aIW.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void ak(List<T> list) {
        for (T t : list) {
            if (t != null) {
                this.aIW.remove(t.actionId);
            }
        }
    }
}
