package com.netease.htprotect.p024.p025O8oO888;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.Attributes;

/* renamed from: com.netease.htprotect.〇〇.O8〇oO8〇88.〇oO, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class oO {

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static final byte[] f638oO = new byte[0];

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final byte[] f639O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private int f640O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private int f641Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private byte[] f642o0o0;

    /* renamed from: com.netease.htprotect.〇〇.O8〇oO8〇88.〇oO$O8〇oO8〇88, reason: invalid class name */
    public static class O8oO888 {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private final String f643O8oO888;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        private final String f644Ooo;

        public O8oO888(String str, String str2) {
            this.f643O8oO888 = str;
            this.f644Ooo = str2;
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public final String m1215O8oO888() {
            return this.f643O8oO888;
        }

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        public final String m1216Ooo() {
            return this.f644Ooo;
        }
    }

    /* renamed from: com.netease.htprotect.〇〇.O8〇oO8〇88.〇oO$〇Ooo, reason: invalid class name */
    public static class Ooo {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private final int f645O8oO888;

        /* renamed from: 〇O8, reason: contains not printable characters */
        private final String f646O8;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        private final int f647Ooo;

        /* renamed from: 〇o0〇o0, reason: contains not printable characters */
        private final List f648o0o0;

        /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Ooo(int r2, int r3, java.util.List r4) {
            /*
                r1 = this;
                r1.<init>()
                r1.f645O8oO888 = r2
                r1.f647Ooo = r3
                boolean r2 = r4.isEmpty()
                if (r2 != 0) goto L25
                r2 = 0
                java.lang.Object r2 = r4.get(r2)
                com.netease.htprotect.〇〇.O8〇oO8〇88.〇oO$O8〇oO8〇88 r2 = (com.netease.htprotect.p024.p025O8oO888.oO.O8oO888) r2
                java.lang.String r3 = r2.m1215O8oO888()
                java.lang.String r0 = "Name"
                boolean r3 = r0.equalsIgnoreCase(r3)
                if (r3 == 0) goto L25
                java.lang.String r2 = r2.m1216Ooo()
                goto L26
            L25:
                r2 = 0
            L26:
                r1.f646O8 = r2
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>(r4)
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.f648o0o0 = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.netease.htprotect.p024.p025O8oO888.oO.Ooo.<init>(int, int, java.util.List):void");
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private String m1217O8oO888(Attributes.Name name) {
            return m1220O8oO888(name.toString());
        }

        /* renamed from: 〇o0〇o0, reason: contains not printable characters */
        private List m1218o0o0() {
            return this.f648o0o0;
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public final String m1219O8oO888() {
            return this.f646O8;
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public final String m1220O8oO888(String str) {
            for (O8oO888 o8oO888 : this.f648o0o0) {
                if (o8oO888.m1215O8oO888().equalsIgnoreCase(str)) {
                    return o8oO888.m1216Ooo();
                }
            }
            return null;
        }

        /* renamed from: 〇O8, reason: contains not printable characters */
        public final int m1221O8() {
            return this.f647Ooo;
        }

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        public final int m1222Ooo() {
            return this.f645O8oO888;
        }
    }

    public oO(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private oO(byte[] bArr, int i) {
        this.f639O8oO888 = bArr;
        this.f641Ooo = 0;
        this.f640O8 = i + 0;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static O8oO888 m1208O8oO888(String str) {
        int iIndexOf = str.indexOf(": ");
        return iIndexOf == -1 ? new O8oO888(str, "") : new O8oO888(str.substring(0, iIndexOf), str.substring(iIndexOf + 2));
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static byte[] m1209O8oO888(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = new byte[bArr.length + i];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 1, bArr3, bArr.length, i);
        return bArr3;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private String m1210O8() {
        byte[] bArrM1211o0o0 = m1211o0o0();
        if (bArrM1211o0o0 == null) {
            return null;
        }
        return bArrM1211o0o0.length == 0 ? "" : new String(bArrM1211o0o0, StandardCharsets.UTF_8);
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private byte[] m1211o0o0() {
        byte[] bArr = this.f642o0o0;
        if (bArr != null && bArr.length == 0) {
            this.f642o0o0 = null;
            return f638oO;
        }
        byte[] bArrM1212oO = m1212oO();
        if (bArrM1212oO == null) {
            byte[] bArr2 = this.f642o0o0;
            if (bArr2 == null) {
                return null;
            }
            this.f642o0o0 = null;
            return bArr2;
        }
        if (bArrM1212oO.length == 0) {
            byte[] bArr3 = this.f642o0o0;
            if (bArr3 == null) {
                return f638oO;
            }
            this.f642o0o0 = f638oO;
            return bArr3;
        }
        byte[] bArr4 = this.f642o0o0;
        if (bArr4 != null) {
            if (bArrM1212oO.length == 0 || bArrM1212oO[0] != 32) {
                this.f642o0o0 = bArrM1212oO;
                return bArr4;
            }
            this.f642o0o0 = null;
            bArrM1212oO = m1209O8oO888(bArr4, bArrM1212oO, bArrM1212oO.length - 1);
        }
        while (true) {
            byte[] bArrM1212oO2 = m1212oO();
            if (bArrM1212oO2 == null) {
                return bArrM1212oO;
            }
            if (bArrM1212oO2.length == 0) {
                this.f642o0o0 = f638oO;
                return bArrM1212oO;
            }
            if (bArrM1212oO2[0] != 32) {
                this.f642o0o0 = bArrM1212oO2;
                return bArrM1212oO;
            }
            bArrM1212oO = m1209O8oO888(bArrM1212oO, bArrM1212oO2, bArrM1212oO2.length - 1);
        }
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private byte[] m1212oO() {
        int i;
        int i2;
        int i3 = this.f641Ooo;
        if (i3 >= this.f640O8) {
            return null;
        }
        int i4 = i3;
        while (true) {
            i = this.f640O8;
            if (i4 >= i) {
                i4 = -1;
                i2 = -1;
                break;
            }
            byte[] bArr = this.f639O8oO888;
            byte b = bArr[i4];
            if (b == 13) {
                i2 = i4 + 1;
                if (i2 < i && bArr[i2] == 10) {
                    i2++;
                }
            } else {
                if (b == 10) {
                    i2 = i4 + 1;
                    break;
                }
                i4++;
            }
        }
        if (i4 == -1) {
            i4 = i;
        } else {
            i = i2;
        }
        this.f641Ooo = i;
        return i4 == i3 ? f638oO : Arrays.copyOfRange(this.f639O8oO888, i3, i4);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final List m1213O8oO888() {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Ooo oooM1214Ooo = m1214Ooo();
            if (oooM1214Ooo == null) {
                return arrayList;
            }
            arrayList.add(oooM1214Ooo);
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final Ooo m1214Ooo() {
        int i;
        String strM1210O8;
        do {
            i = this.f641Ooo;
            strM1210O8 = m1210O8();
            if (strM1210O8 == null) {
                return null;
            }
        } while (strM1210O8.length() == 0);
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(m1208O8oO888(strM1210O8));
            strM1210O8 = m1210O8();
            if (strM1210O8 == null) {
                break;
            }
        } while (strM1210O8.length() != 0);
        return new Ooo(i, this.f641Ooo - i, arrayList);
    }
}
