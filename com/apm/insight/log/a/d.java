package com.apm.insight.log.a;

import com.apm.insight.log.a.b;
import java.util.Comparator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class d implements Comparator<b.a> {
    d() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(b.a aVar, b.a aVar2) {
        b.a aVar3 = aVar;
        b.a aVar4 = aVar2;
        if (aVar3.b < aVar4.b) {
            return 1;
        }
        return aVar3.b == aVar4.b ? 0 : -1;
    }
}
