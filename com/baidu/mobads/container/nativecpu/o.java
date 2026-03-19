package com.baidu.mobads.container.nativecpu;

import com.baidu.mobads.container.util.cm;
import com.style.widget.a;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class o implements a.b {
    final /* synthetic */ int a;
    final /* synthetic */ a b;
    final /* synthetic */ j c;

    o(j jVar, int i, a aVar) {
        this.c = jVar;
        this.a = i;
        this.b = aVar;
    }

    @Override // com.style.widget.a.b
    public void a(String str) {
        HashMap map = new HashMap();
        map.put("position", Integer.valueOf(this.a));
        map.put("mislikereason", str);
        this.c.dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.N, (HashMap<String, Object>) map));
        if (this.b != null && !this.b.e) {
            this.b.e = true;
            com.baidu.mobads.container.util.an anVar = new com.baidu.mobads.container.util.an();
            Integer num = anVar.a().get(str);
            if (this.b.d() != null && num != null) {
                anVar.a(num.intValue(), this.b.d().getDislikeTrackers());
            }
        }
    }
}
