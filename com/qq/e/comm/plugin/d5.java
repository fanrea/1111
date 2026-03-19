package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d5 {

    /* compiled from: A */
    class a implements Comparator<tr> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(tr trVar, tr trVar2) {
            return trVar2.q() - trVar.q();
        }
    }

    public static List<tr> a(List<tr> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new a());
        return arrayList;
    }
}
