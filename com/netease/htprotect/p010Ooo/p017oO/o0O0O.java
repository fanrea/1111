package com.netease.htprotect.p010Ooo.p017oO;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* renamed from: com.netease.htprotect.〇Ooo.〇oO.〇o〇0O〇0O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o0O0O {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m1083O8oO888(NamedNodeMap namedNodeMap, String str) {
        Node namedItem = namedNodeMap.getNamedItem(str);
        if (namedItem == null) {
            if (str.startsWith("android:")) {
                str = str.substring(8);
            }
            namedItem = namedNodeMap.getNamedItem(str);
            if (namedItem == null) {
                return null;
            }
        }
        return namedItem.getNodeValue();
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static Integer m1084O8(NamedNodeMap namedNodeMap, String str) {
        String strM1083O8oO888 = m1083O8oO888(namedNodeMap, str);
        if (strM1083O8oO888 == null) {
            return null;
        }
        return Integer.valueOf(strM1083O8oO888);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static Long m1085Ooo(NamedNodeMap namedNodeMap, String str) {
        String strM1083O8oO888 = m1083O8oO888(namedNodeMap, str);
        if (strM1083O8oO888 == null) {
            return null;
        }
        return Long.valueOf(strM1083O8oO888);
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static boolean m1086o0o0(NamedNodeMap namedNodeMap, String str) {
        String strM1083O8oO888 = m1083O8oO888(namedNodeMap, str);
        Boolean boolValueOf = strM1083O8oO888 == null ? null : Boolean.valueOf(strM1083O8oO888);
        if (boolValueOf == null) {
            return false;
        }
        return boolValueOf.booleanValue();
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static Boolean m1087oO(NamedNodeMap namedNodeMap, String str) {
        String strM1083O8oO888 = m1083O8oO888(namedNodeMap, str);
        if (strM1083O8oO888 == null) {
            return null;
        }
        return Boolean.valueOf(strM1083O8oO888);
    }
}
