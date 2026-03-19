package com.apm.insight.m;

import android.content.Context;
import android.os.Handler;
import com.apm.insight.o.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class d {
    private List<a> a = new ArrayList(3);

    private d(Handler handler, Context context) {
        if (com.apm.insight.o.a.b(context)) {
            this.a.add(new c(handler, 0L, 15000L));
        }
    }

    public static d a(Handler handler, Context context) {
        return new d(handler, context);
    }

    public void a() {
        q.a((Object) ("[ScheduleTaskManager] execute, task size=" + this.a.size()));
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                it.next().a();
            } catch (Throwable unused) {
            }
        }
    }
}
