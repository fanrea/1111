package com.component.a.b;

import android.os.Handler;
import android.os.Looper;
import com.component.a.a.b;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private final Handler a = new Handler(Looper.getMainLooper());
    private com.component.a.f b;

    public void a(com.component.a.f fVar) {
        this.b = fVar;
    }

    public void a(i iVar, a aVar) {
        int iA = aVar.d.a(b.e.c, 0);
        aVar.d.b(b.e.c, null);
        this.a.postDelayed(new c(this, aVar, iVar), iA);
    }

    public void a(i iVar, List<a> list) {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            a(iVar, it.next());
        }
    }

    public com.component.a.f a() {
        return this.b;
    }
}
