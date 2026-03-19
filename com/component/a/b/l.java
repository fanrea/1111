package com.component.a.b;

import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class l extends o {
    public Object a(String str, Object obj) {
        b(str, obj);
        return obj;
    }

    public void a(n nVar) {
        Iterator<String> it = iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (nVar.a(next)) {
                a(next, nVar.b(next));
            }
        }
    }
}
