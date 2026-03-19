package com.baidu.mobads.container.util.b.a;

import com.baidu.mobads.container.util.b.a.k;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a implements k.b {
    private final List<k> a;
    private final int b;
    private final b c;

    public a(List<k> list, int i, b bVar) {
        this.a = list;
        this.b = i;
        this.c = bVar;
    }

    public a a(List<k> list, int i, b bVar) {
        return new a(list, i, bVar);
    }

    @Override // com.baidu.mobads.container.util.b.a.k.b
    public b a() {
        return this.c;
    }

    @Override // com.baidu.mobads.container.util.b.a.k.b
    public com.baidu.mobads.container.util.b.f<?> a(b bVar, k.a aVar) {
        if (this.b >= this.a.size()) {
            aVar.a(bVar.d, bVar.a, com.baidu.mobads.container.util.d.c.c);
        }
        return this.a.get(this.b).a(a(this.a, this.b + 1, bVar), aVar);
    }
}
