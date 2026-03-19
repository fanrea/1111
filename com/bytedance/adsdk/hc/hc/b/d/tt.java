package com.bytedance.adsdk.hc.hc.b.d;

import java.util.Deque;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt extends an {
    @Override // com.bytedance.adsdk.hc.hc.b.d.an
    public int d(String str, int i, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque, com.bytedance.adsdk.hc.hc.b.d dVar) {
        com.bytedance.adsdk.hc.hc.hc.d dVarPollFirst;
        if (')' != d(i, str)) {
            return dVar.d(str, i, deque);
        }
        LinkedList<com.bytedance.adsdk.hc.hc.hc.d> linkedList = new LinkedList();
        while (true) {
            dVarPollFirst = deque.pollFirst();
            if (dVarPollFirst == null || dVarPollFirst.d() == com.bytedance.adsdk.hc.hc.c.hc.METHOD || dVarPollFirst.d() == com.bytedance.adsdk.hc.hc.c.c.LEFT_PAREN) {
                break;
            }
            linkedList.addFirst(dVarPollFirst);
        }
        if (dVarPollFirst == null) {
            throw new IllegalArgumentException(str.substring(0, i));
        }
        if (dVarPollFirst.d() != com.bytedance.adsdk.hc.hc.c.hc.METHOD) {
            deque.push(com.bytedance.adsdk.hc.hc.u.hc.d(linkedList, str, i));
            return i + 1;
        }
        com.bytedance.adsdk.hc.hc.hc.d.tc tcVar = (com.bytedance.adsdk.hc.hc.hc.d.tc) dVarPollFirst;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (com.bytedance.adsdk.hc.hc.hc.d dVar2 : linkedList) {
            if (dVar2.d() == com.bytedance.adsdk.hc.hc.c.c.COMMA) {
                linkedList2.add(com.bytedance.adsdk.hc.hc.u.hc.d(linkedList3, str, i));
                linkedList3.clear();
            } else {
                linkedList3.addLast(dVar2);
            }
        }
        if (!linkedList3.isEmpty()) {
            linkedList2.add(com.bytedance.adsdk.hc.hc.u.hc.d(linkedList3, str, i));
        }
        tcVar.d((com.bytedance.adsdk.hc.hc.hc.d[]) linkedList2.toArray(new com.bytedance.adsdk.hc.hc.hc.d[linkedList2.size()]));
        int i2 = i + 1;
        deque.push(tcVar);
        return i2;
    }
}
