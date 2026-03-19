package com.bytedance.bdtracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k1 {
    public final LinkedList<t3> a = new LinkedList<>();
    public final LinkedList<String> b = new LinkedList<>();

    public int a(ArrayList<t3> arrayList) {
        int size;
        synchronized (this.a) {
            size = this.a.size();
            arrayList.addAll(this.a);
            this.a.clear();
        }
        return size;
    }

    public void a(t3 t3Var) {
        synchronized (this.a) {
            if (this.a.size() > 300) {
                this.a.poll();
            }
            this.a.add(t3Var);
        }
    }

    public void a(String[] strArr) {
        synchronized (this.b) {
            if (this.b.size() > 300) {
                this.b.poll();
            }
            this.b.addAll(Arrays.asList(strArr));
        }
    }
}
