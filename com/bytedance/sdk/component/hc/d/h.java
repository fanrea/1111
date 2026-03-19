package com.bytedance.sdk.component.hc.d;

import com.alipay.sdk.m.l.a;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import okhttp3.HttpUrl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h {
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String an;
    final int b;
    final String d;
    private final List<String> gb;
    private final List<String> h;
    final String hc;
    private final String tc;
    private final String tt;
    private final String u;

    h(d dVar) {
        this.d = dVar.d;
        this.u = d(dVar.hc, false);
        this.an = d(dVar.b, false);
        this.hc = dVar.c;
        this.b = dVar.d();
        this.h = d(dVar.an, false);
        this.gb = dVar.h != null ? d(dVar.h, true) : null;
        this.tt = dVar.gb != null ? d(dVar.gb, false) : null;
        this.tc = dVar.toString();
    }

    public URL d() {
        try {
            return new URL(this.tc);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String hc() {
        if (this.u.isEmpty()) {
            return "";
        }
        int length = this.d.length() + 3;
        String str = this.tc;
        return this.tc.substring(length, com.bytedance.sdk.component.hc.d.hc.tc.d(str, length, str.length(), ":@"));
    }

    public String b() {
        if (this.an.isEmpty()) {
            return "";
        }
        return this.tc.substring(this.tc.indexOf(58, this.d.length() + 3) + 1, this.tc.indexOf(64));
    }

    public static int d(String str) {
        if (str.equals(a.r)) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static void d(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> c() {
        int iIndexOf = this.tc.indexOf(47, this.d.length() + 3);
        String str = this.tc;
        int iD = com.bytedance.sdk.component.hc.d.hc.tc.d(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iD) {
            int i = iIndexOf + 1;
            int iD2 = com.bytedance.sdk.component.hc.d.hc.tc.d(this.tc, i, iD, '/');
            arrayList.add(this.tc.substring(i, iD2));
            iIndexOf = iD2;
        }
        return arrayList;
    }

    public String u() {
        if (this.gb == null) {
            return null;
        }
        int iIndexOf = this.tc.indexOf(63) + 1;
        String str = this.tc;
        return this.tc.substring(iIndexOf, com.bytedance.sdk.component.hc.d.hc.tc.d(str, iIndexOf, str.length(), '#'));
    }

    static void hc(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(com.alipay.sdk.m.n.a.h);
                sb.append(str2);
            }
        }
    }

    static List<String> hc(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public String query() {
        if (this.gb == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        hc(sb, this.gb);
        return sb.toString();
    }

    public String an() {
        if (this.tt == null) {
            return null;
        }
        return this.tc.substring(this.tc.indexOf(35) + 1);
    }

    public d h() {
        d dVar = new d();
        dVar.d = this.d;
        dVar.hc = hc();
        dVar.b = b();
        dVar.c = this.hc;
        dVar.u = this.b != d(this.d) ? this.b : -1;
        dVar.an.clear();
        dVar.an.addAll(c());
        dVar.c(u());
        dVar.gb = an();
        return dVar;
    }

    public static h b(String str) {
        d dVar = new d();
        if (dVar.d((h) null, str) == d.EnumC0280d.SUCCESS) {
            return dVar.hc();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof h) && ((h) obj).tc.equals(this.tc);
    }

    public int hashCode() {
        return this.tc.hashCode();
    }

    public String toString() {
        return this.tc;
    }

    public static final class d {
        final List<String> an;
        String c;
        String d;
        String gb;
        List<String> h;
        String hc = "";
        String b = "";
        int u = -1;

        /* renamed from: com.bytedance.sdk.component.hc.d.h$d$d, reason: collision with other inner class name */
        enum EnumC0280d {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public d() {
            ArrayList arrayList = new ArrayList();
            this.an = arrayList;
            arrayList.add("");
        }

        public d d(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(a.r)) {
                this.d = a.r;
            } else if (str.equalsIgnoreCase("https")) {
                this.d = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public d hc(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strU = u(str, 0, str.length());
            if (strU == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.c = strU;
            return this;
        }

        int d() {
            int i = this.u;
            return i != -1 ? i : h.d(this.d);
        }

        public d b(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegments == null");
            }
            return d(str, true);
        }

        private d d(String str, boolean z) {
            int i = 0;
            do {
                int iD = com.bytedance.sdk.component.hc.d.hc.tc.d(str, i, str.length(), "/\\");
                d(str, i, iD, iD < str.length(), z);
                i = iD + 1;
            } while (i <= str.length());
            return this;
        }

        public d query(String str) {
            this.h = str != null ? h.hc(h.d(str, HttpUrl.QUERY_ENCODE_SET, false, false, true, true)) : null;
            return this;
        }

        public d c(String str) {
            this.h = str != null ? h.hc(h.d(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public d d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.h == null) {
                this.h = new ArrayList();
            }
            this.h.add(h.d(str, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            this.h.add(str2 != null ? h.d(str2, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true) : null);
            return this;
        }

        public h hc() {
            if (this.d == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.c == null) {
                throw new IllegalStateException("host == null");
            }
            return new h(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.d);
            sb.append("://");
            if (!this.hc.isEmpty() || !this.b.isEmpty()) {
                sb.append(this.hc);
                if (!this.b.isEmpty()) {
                    sb.append(':');
                    sb.append(this.b);
                }
                sb.append('@');
            }
            if (this.c.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.c);
                sb.append(']');
            } else {
                sb.append(this.c);
            }
            int iD = d();
            if (iD != h.d(this.d)) {
                sb.append(':');
                sb.append(iD);
            }
            h.d(sb, this.an);
            if (this.h != null) {
                sb.append('?');
                h.hc(sb, this.h);
            }
            if (this.gb != null) {
                sb.append('#');
                sb.append(this.gb);
            }
            return sb.toString();
        }

        EnumC0280d d(h hVar, String str) throws NumberFormatException {
            int iD;
            int i;
            int iD2 = com.bytedance.sdk.component.hc.d.hc.tc.d(str, 0, str.length());
            int iHc = com.bytedance.sdk.component.hc.d.hc.tc.hc(str, iD2, str.length());
            if (hc(str, iD2, iHc) != -1) {
                if (str.regionMatches(true, iD2, "https:", 0, 6)) {
                    this.d = "https";
                    iD2 += 6;
                } else if (str.regionMatches(true, iD2, "http:", 0, 5)) {
                    this.d = a.r;
                    iD2 += 5;
                } else {
                    return EnumC0280d.UNSUPPORTED_SCHEME;
                }
            } else if (hVar != null) {
                this.d = hVar.d;
            } else {
                return EnumC0280d.MISSING_SCHEME;
            }
            int iB = b(str, iD2, iHc);
            char c = '?';
            char c2 = '#';
            if (iB >= 2 || hVar == null || !hVar.d.equals(this.d)) {
                boolean z = false;
                boolean z2 = false;
                int i2 = iD2 + iB;
                while (true) {
                    iD = com.bytedance.sdk.component.hc.d.hc.tc.d(str, i2, iHc, "@/\\?#");
                    char cCharAt = iD != iHc ? str.charAt(iD) : (char) 65535;
                    if (cCharAt == 65535 || cCharAt == c2 || cCharAt == '/' || cCharAt == '\\' || cCharAt == c) {
                        break;
                    }
                    if (cCharAt == '@') {
                        if (!z) {
                            int iD3 = com.bytedance.sdk.component.hc.d.hc.tc.d(str, i2, iD, ':');
                            i = iD;
                            String strD = h.d(str, i2, iD3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strD = this.hc + "%40" + strD;
                            }
                            this.hc = strD;
                            if (iD3 != i) {
                                this.b = h.d(str, iD3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = iD;
                            this.b += "%40" + h.d(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                        c = '?';
                        c2 = '#';
                    }
                }
                int iC = c(str, i2, iD);
                int i3 = iC + 1;
                if (i3 < iD) {
                    this.c = u(str, i2, iC);
                    int iAn = an(str, i3, iD);
                    this.u = iAn;
                    if (iAn == -1) {
                        return EnumC0280d.INVALID_PORT;
                    }
                } else {
                    this.c = u(str, i2, iC);
                    this.u = h.d(this.d);
                }
                if (this.c == null) {
                    return EnumC0280d.INVALID_HOST;
                }
                iD2 = iD;
            } else {
                this.hc = hVar.hc();
                this.b = hVar.b();
                this.c = hVar.hc;
                this.u = hVar.b;
                this.an.clear();
                this.an.addAll(hVar.c());
                if (iD2 == iHc || str.charAt(iD2) == '#') {
                    c(hVar.u());
                }
            }
            int iD4 = com.bytedance.sdk.component.hc.d.hc.tc.d(str, iD2, iHc, "?#");
            d(str, iD2, iD4);
            if (iD4 < iHc && str.charAt(iD4) == '?') {
                int iD5 = com.bytedance.sdk.component.hc.d.hc.tc.d(str, iD4, iHc, '#');
                this.h = h.hc(h.d(str, iD4 + 1, iD5, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                iD4 = iD5;
            }
            if (iD4 < iHc && str.charAt(iD4) == '#') {
                this.gb = h.d(str, 1 + iD4, iHc, "", true, false, false, false, null);
            }
            return EnumC0280d.SUCCESS;
        }

        private void d(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.an.clear();
                this.an.add("");
                i++;
            } else {
                List<String> list = this.an;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = com.bytedance.sdk.component.hc.d.hc.tc.d(str, i3, i2, "/\\");
                boolean z = i < i2;
                d(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void d(String str, int i, int i2, boolean z, boolean z2) {
            String strD = h.d(str, i, i2, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, null);
            if (u(strD)) {
                return;
            }
            if (an(strD)) {
                b();
                return;
            }
            if (this.an.get(r11.size() - 1).isEmpty()) {
                this.an.set(r11.size() - 1, strD);
            } else {
                this.an.add(strD);
            }
            if (z) {
                this.an.add("");
            }
        }

        private boolean u(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean an(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void b() {
            if (this.an.remove(r0.size() - 1).isEmpty() && !this.an.isEmpty()) {
                this.an.set(r0.size() - 1, "");
            } else {
                this.an.add("");
            }
        }

        private static int hc(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int b(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int c(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String u(String str, int i, int i2) {
            return com.bytedance.sdk.component.hc.d.hc.tc.d(h.d(str, i, i2, false));
        }

        private static int an(String str, int i, int i2) throws NumberFormatException {
            int i3;
            try {
                i3 = Integer.parseInt(h.d(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i3 <= 0 || i3 > 65535) {
                return -1;
            }
            return i3;
        }
    }

    static String d(String str, boolean z) {
        return d(str, 0, str.length(), z);
    }

    private List<String> d(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? d(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String d(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                com.bytedance.sdk.component.hc.d.hc.d dVar = new com.bytedance.sdk.component.hc.d.hc.d();
                dVar.d(str, i, i3);
                d(dVar, str, i3, i2, z);
                return dVar.b();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void d(com.bytedance.sdk.component.hc.d.hc.d r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = com.bytedance.sdk.component.hc.d.hc.tc.d(r2)
            char r3 = r6.charAt(r1)
            int r3 = com.bytedance.sdk.component.hc.d.hc.tc.d(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.hc(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.hc(r1)
            goto L3c
        L39:
            r5.d(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.hc.d.h.d(com.bytedance.sdk.component.hc.d.hc.d, java.lang.String, int, int, boolean):void");
    }

    static boolean d(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.bytedance.sdk.component.hc.d.hc.tc.d(str.charAt(i + 1)) != -1 && com.bytedance.sdk.component.hc.d.hc.tc.d(str.charAt(i3)) != -1;
    }

    static String d(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || d(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    com.bytedance.sdk.component.hc.d.hc.d dVar = new com.bytedance.sdk.component.hc.d.hc.d();
                    dVar.d(str, i, iCharCount);
                    d(dVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                    return dVar.b();
                }
            } else {
                com.bytedance.sdk.component.hc.d.hc.d dVar2 = new com.bytedance.sdk.component.hc.d.hc.d();
                dVar2.d(str, i, iCharCount);
                d(dVar2, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return dVar2.b();
            }
        }
        return str.substring(i, i2);
    }

    static void d(com.bytedance.sdk.component.hc.d.hc.d dVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.component.hc.d.hc.d dVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    dVar.d(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !d(str, i, i2)))))) {
                    if (dVar2 == null) {
                        dVar2 = new com.bytedance.sdk.component.hc.d.hc.d();
                    }
                    if (charset == null || charset.equals(com.bytedance.sdk.component.hc.d.hc.tc.d)) {
                        dVar2.d(iCodePointAt);
                    } else {
                        dVar2.d(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!dVar2.d()) {
                        int iHc = dVar2.hc() & 255;
                        dVar.hc(37);
                        char[] cArr = c;
                        dVar.hc((int) cArr[(iHc >> 4) & 15]);
                        dVar.hc((int) cArr[iHc & 15]);
                    }
                } else {
                    dVar.d(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static String d(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return d(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
