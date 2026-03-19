package com.bytedance.adsdk.hc.hc.u;

import com.bytedance.adsdk.hc.hc.c.b;
import com.bytedance.adsdk.hc.hc.c.c;
import com.bytedance.adsdk.hc.hc.hc.d.an;
import com.bytedance.adsdk.hc.hc.hc.d.gb;
import com.bytedance.adsdk.hc.hc.hc.d.k;
import com.bytedance.adsdk.hc.hc.hc.d.mk;
import com.bytedance.adsdk.hc.hc.hc.d.mq;
import com.bytedance.adsdk.hc.hc.hc.d.rf;
import com.bytedance.adsdk.hc.hc.hc.d.tt;
import com.bytedance.adsdk.hc.hc.hc.d.u;
import com.bytedance.adsdk.hc.hc.hc.d.uo;
import com.bytedance.adsdk.hc.hc.hc.d.w;
import com.bytedance.adsdk.hc.hc.hc.d.yo;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static com.bytedance.adsdk.hc.hc.hc.d d(List<com.bytedance.adsdk.hc.hc.hc.d> list, String str, int i) {
        b(list, str, i);
        Deque<com.bytedance.adsdk.hc.hc.hc.d> dequeD = d(hc(list, str, i));
        if (dequeD.size() != 1) {
            throw new IllegalStateException();
        }
        return dequeD.getFirst();
    }

    private static Deque<com.bytedance.adsdk.hc.hc.hc.d> d(Deque<com.bytedance.adsdk.hc.hc.hc.d> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.adsdk.hc.hc.hc.d dVar : deque) {
            if (!linkedList.isEmpty() && ((com.bytedance.adsdk.hc.hc.hc.d) linkedList.peekLast()).d() == b.COLON) {
                linkedList.pollLast();
                com.bytedance.adsdk.hc.hc.hc.d dVar2 = (com.bytedance.adsdk.hc.hc.hc.d) linkedList.pollLast();
                if (((com.bytedance.adsdk.hc.hc.hc.d) linkedList.pollLast()).d() != b.QUESTION) {
                    throw new IllegalStateException();
                }
                com.bytedance.adsdk.hc.hc.hc.d dVar3 = (com.bytedance.adsdk.hc.hc.hc.d) linkedList.pollLast();
                rf rfVar = new rf();
                rfVar.d(dVar3);
                rfVar.hc(dVar2);
                rfVar.b(dVar);
                linkedList.addLast(rfVar);
            } else {
                linkedList.addLast(dVar);
            }
        }
        return linkedList;
    }

    private static Deque<com.bytedance.adsdk.hc.hc.hc.d> hc(List<com.bytedance.adsdk.hc.hc.hc.d> list, String str, int i) {
        LinkedList<com.bytedance.adsdk.hc.hc.hc.d> linkedList = new LinkedList(list);
        int i2 = 5;
        while (i2 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.bytedance.adsdk.hc.hc.hc.d dVar : linkedList) {
                if (!linkedList2.isEmpty() && b.d(((com.bytedance.adsdk.hc.hc.hc.d) linkedList2.peekLast()).d()) && ((b) ((com.bytedance.adsdk.hc.hc.hc.d) linkedList2.peekLast()).d()).hc() == i2) {
                    com.bytedance.adsdk.hc.hc.hc.d dVar2 = (com.bytedance.adsdk.hc.hc.hc.d) linkedList2.pollLast();
                    com.bytedance.adsdk.hc.hc.hc.d dVar3 = (com.bytedance.adsdk.hc.hc.hc.d) linkedList2.pollLast();
                    if (!b.d(dVar3.d()) && !b.d(dVar.d())) {
                        linkedList2.addLast(d(dVar3, dVar2, dVar));
                    } else {
                        throw new IllegalArgumentException(str.substring(0, i));
                    }
                } else {
                    linkedList2.addLast(dVar);
                }
            }
            i2--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static void b(List<com.bytedance.adsdk.hc.hc.hc.d> list, String str, int i) {
        Iterator<com.bytedance.adsdk.hc.hc.hc.d> it = list.iterator();
        while (it.hasNext()) {
            if (c.d(it.next().d())) {
                throw new IllegalArgumentException(str.substring(0, i));
            }
        }
    }

    /* renamed from: com.bytedance.adsdk.hc.hc.u.hc$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[b.values().length];
            d = iArr;
            try {
                iArr[b.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[b.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[b.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[b.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[b.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[b.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                d[b.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                d[b.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                d[b.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                d[b.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                d[b.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                d[b.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                d[b.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static com.bytedance.adsdk.hc.hc.hc.d d(com.bytedance.adsdk.hc.hc.hc.d dVar, com.bytedance.adsdk.hc.hc.hc.d dVar2, com.bytedance.adsdk.hc.hc.hc.d dVar3) {
        w mkVar;
        switch (AnonymousClass1.d[((b) dVar2.d()).ordinal()]) {
            case 1:
                mkVar = new mk();
                break;
            case 2:
                mkVar = new yo();
                break;
            case 3:
                mkVar = new com.bytedance.adsdk.hc.hc.hc.d.d();
                break;
            case 4:
                mkVar = new uo();
                break;
            case 5:
                mkVar = new mq();
                break;
            case 6:
                mkVar = new com.bytedance.adsdk.hc.hc.hc.d.c();
                break;
            case 7:
                mkVar = new k();
                break;
            case 8:
                mkVar = new an();
                break;
            case 9:
                mkVar = new tt();
                break;
            case 10:
                mkVar = new u();
                break;
            case 11:
                mkVar = new gb();
                break;
            case 12:
                mkVar = new com.bytedance.adsdk.hc.hc.hc.d.hc();
                break;
            case 13:
                mkVar = new com.bytedance.adsdk.hc.hc.hc.d.b();
                break;
            default:
                throw new UnsupportedOperationException(dVar2.d().toString());
        }
        mkVar.d(dVar);
        mkVar.hc(dVar3);
        return mkVar;
    }

    public static boolean d(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
