package com.bytedance.d.hc.an;

import android.content.Context;
import android.os.Handler;
import com.bytedance.d.hc.gb.tc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class b {
    private List<d> d;

    private b(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.d = arrayList;
        arrayList.add(new hc(handler, 0L, 15000L));
    }

    public static b d(Handler handler, Context context) {
        return new b(handler, context);
    }

    public void d() {
        tc.d("[ScheduleTaskManager] execute, task size=" + this.d.size());
        Iterator<d> it = this.d.iterator();
        while (it.hasNext()) {
            try {
                it.next().d();
            } catch (Throwable unused) {
            }
        }
    }
}
