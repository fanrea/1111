package com.bykv.vk.openvk.component.video.d.hc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq {
    private static final Set<String> d = new HashSet();
    private static final Set<String> hc = new HashSet();
    private int an;
    private final ArrayList<d> b;
    private final int c;
    private final int h;
    private int u = -1;

    mq(List<String> list) {
        int iIntValue;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.c = size;
        this.b = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            d dVar = new d(str);
            if (d.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(dVar);
            } else if (hc.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(dVar);
            } else {
                this.b.add(dVar);
            }
        }
        if (arrayList != null) {
            this.b.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.b.addAll(arrayList2);
        }
        Integer num = u.tt;
        if (num == null || num.intValue() <= 0) {
            iIntValue = this.c >= 2 ? 1 : 2;
        } else {
            iIntValue = num.intValue();
        }
        this.h = iIntValue;
    }

    mq(String str) {
        ArrayList<d> arrayList = new ArrayList<>(1);
        this.b = arrayList;
        arrayList.add(new d(str));
        this.c = 1;
        this.h = 1;
    }

    boolean d() {
        return this.an < this.h;
    }

    d hc() {
        if (!d()) {
            throw new NoSuchElementException();
        }
        int i = this.u + 1;
        if (i >= this.c - 1) {
            this.u = -1;
            this.an++;
        } else {
            this.u = i;
        }
        d dVar = this.b.get(i);
        dVar.hc = (this.an * this.c) + this.u;
        return dVar;
    }

    public class d {
        final String d;
        int hc;

        d(String str) {
            this.d = str;
        }

        void d() {
            mq.d.add(this.d);
        }

        void hc() {
            mq.hc.add(this.d);
        }

        public String toString() {
            return this.d;
        }
    }
}
