package com.sigmob.sdk.downloader.core.breakpoint;

import android.util.SparseArray;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class k {
    private final HashMap<String, Integer> a;
    private final SparseArray<String> b;

    k() {
        this(new HashMap(), new SparseArray());
    }

    k(HashMap<String, Integer> keyToIdMap, SparseArray<String> idToKeyMap) {
        this.a = keyToIdMap;
        this.b = idToKeyMap;
    }

    public Integer a(com.sigmob.sdk.downloader.f task) {
        Integer num = this.a.get(b(task));
        if (num != null) {
            return num;
        }
        return null;
    }

    public void a(int id) {
        String str = this.b.get(id);
        if (str != null) {
            this.a.remove(str);
            this.b.remove(id);
        }
    }

    public void a(com.sigmob.sdk.downloader.f task, int id) {
        String strB = b(task);
        this.a.put(strB, Integer.valueOf(id));
        this.b.put(id, strB);
    }

    String b(com.sigmob.sdk.downloader.f task) {
        return task.i() + task.h() + task.d();
    }
}
