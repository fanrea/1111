package com.bytedance.embedapplog;

import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class vv {
    private static final LinkedList<to> d = new LinkedList<>();
    private static final LinkedList<to> hc = new LinkedList<>();

    public static void d(to toVar) {
        LinkedList<to> linkedList = d;
        synchronized (linkedList) {
            if (linkedList.size() > 200) {
                to toVarPoll = linkedList.poll();
                um.hc("drop event in cache", null);
                hc.add(toVarPoll);
            }
            linkedList.add(toVar);
        }
    }

    public static void d() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList<to> linkedList3 = d;
        synchronized (linkedList3) {
            linkedList.addAll(linkedList3);
            LinkedList<to> linkedList4 = hc;
            linkedList2.addAll(linkedList4);
            linkedList3.clear();
            linkedList4.clear();
        }
        while (!linkedList.isEmpty()) {
            de.d((to) linkedList.poll());
        }
    }
}
