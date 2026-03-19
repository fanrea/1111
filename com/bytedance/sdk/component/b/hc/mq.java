package com.bytedance.sdk.component.b.hc;

import androidx.core.location.LocationRequestCompat;
import com.alipay.sdk.m.n.a;
import com.baidu.mobads.container.util.bu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class mq {
    private final String an;
    private final String gb;
    private final long h;
    private final boolean mk;
    private final boolean mq;
    private final boolean tc;
    private final String tt;
    private final String u;
    private final boolean uo;
    private static final Pattern d = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern hc = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern b = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern c = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private mq(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.u = str;
        this.an = str2;
        this.h = j;
        this.gb = str3;
        this.tt = str4;
        this.tc = z;
        this.mk = z2;
        this.uo = z3;
        this.mq = z4;
    }

    public String d() {
        return this.u;
    }

    public String hc() {
        return this.an;
    }

    private static boolean d(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.bytedance.sdk.component.b.hc.d.b.b(str);
    }

    public static mq d(rf rfVar, String str) {
        return d(System.currentTimeMillis(), rfVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0 A[PHI: r0
  0x00c0: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:42:0x00be, B:53:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.bytedance.sdk.component.b.hc.mq d(long r23, com.bytedance.sdk.component.b.hc.rf r25, java.lang.String r26) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.mq.d(long, com.bytedance.sdk.component.b.hc.rf, java.lang.String):com.bytedance.sdk.component.b.hc.mq");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long d(java.lang.String r12, int r13, int r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.mq.d(java.lang.String, int, int):long");
    }

    private static int d(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long d(String str) throws NumberFormatException {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                if (str.startsWith("-")) {
                    return Long.MIN_VALUE;
                }
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
            throw e;
        }
    }

    private static String hc(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strD = com.bytedance.sdk.component.b.hc.d.b.d(str);
        if (strD != null) {
            return strD;
        }
        throw new IllegalArgumentException();
    }

    public static List<mq> d(rf rfVar, yo yoVar) {
        List<String> listHc = yoVar.hc("Set-Cookie");
        int size = listHc.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            mq mqVarD = d(rfVar, listHc.get(i));
            if (mqVarD != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(mqVarD);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return d(false);
    }

    String d(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.u);
        sb.append(a.h);
        sb.append(this.an);
        if (this.mq) {
            if (this.h == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(com.bytedance.sdk.component.b.hc.d.b.c.d(new Date(this.h)));
            }
        }
        if (!this.uo) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.gb);
        }
        sb.append("; path=").append(this.tt);
        if (this.tc) {
            sb.append("; secure");
        }
        if (this.mk) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof mq)) {
            return false;
        }
        mq mqVar = (mq) obj;
        return mqVar.u.equals(this.u) && mqVar.an.equals(this.an) && mqVar.gb.equals(this.gb) && mqVar.tt.equals(this.tt) && mqVar.h == this.h && mqVar.tc == this.tc && mqVar.mk == this.mk && mqVar.mq == this.mq && mqVar.uo == this.uo;
    }

    public int hashCode() {
        int iHashCode = (((((((this.u.hashCode() + bu.g) * 31) + this.an.hashCode()) * 31) + this.gb.hashCode()) * 31) + this.tt.hashCode()) * 31;
        long j = this.h;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.tc ? 1 : 0)) * 31) + (!this.mk ? 1 : 0)) * 31) + (!this.mq ? 1 : 0)) * 31) + (!this.uo ? 1 : 0);
    }
}
