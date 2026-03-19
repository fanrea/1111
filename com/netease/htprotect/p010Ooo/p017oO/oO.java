package com.netease.htprotect.p010Ooo.p017oO;

import com.alipay.sdk.m.u.i;
import com.baidu.mobstat.forbes.Config;
import com.kuaishou.weapon.p0.t;
import com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888;
import com.netease.htprotect.p010Ooo.p014o0o0.O;
import com.netease.htprotect.p010Ooo.p014o0o0.Oo0;
import com.netease.htprotect.p010Ooo.p014o0o0.o0o0;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C0679;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.O8;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.OO8;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.internal.ws.WebSocketProtocol;

/* renamed from: com.netease.htprotect.〇Ooo.〇oO.〇oO, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class oO {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static final Charset f525O8oO888 = Charset.forName("UTF-8");

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static Oo0 m1072O8oO888(ByteBuffer byteBuffer, O o) {
        String strM1067Ooo;
        long jPosition = byteBuffer.position();
        int iM961o0o0 = (int) o.m961o0o0();
        long[] jArr = new long[iM961o0o0];
        if (o.m961o0o0() > 0) {
            for (int i = 0; i < o.m961o0o0(); i++) {
                jArr[i] = Ooo.m1066Ooo(byteBuffer);
            }
        }
        boolean z = (o.m963oO() & 256) != 0;
        long jOo0 = (o.Oo0() + jPosition) - o.m970O8();
        byteBuffer.position((int) jOo0);
        com.netease.htprotect.p010Ooo.p012O8.oO[] oOVarArr = new com.netease.htprotect.p010Ooo.p012O8.oO[iM961o0o0];
        for (int i2 = 0; i2 < iM961o0o0; i2++) {
            oOVarArr[i2] = new com.netease.htprotect.p010Ooo.p012O8.oO(i2, jArr[i2] + jOo0);
        }
        String str = null;
        long j = -1;
        Oo0 oo0 = new Oo0((int) o.m961o0o0());
        for (int i3 = 0; i3 < iM961o0o0; i3++) {
            com.netease.htprotect.p010Ooo.p012O8.oO oOVar = oOVarArr[i3];
            if (oOVar.f275Ooo == j) {
                oo0.m955O8oO888(oOVar.f274O8oO888, str);
            } else {
                byteBuffer.position((int) oOVar.f275Ooo);
                j = oOVar.f275Ooo;
                if (z) {
                    m1080Ooo(byteBuffer);
                    strM1067Ooo = new String(Ooo.m1063O8oO888(byteBuffer, m1080Ooo(byteBuffer)), f525O8oO888);
                    Ooo.m1062O8oO888(byteBuffer);
                } else {
                    int i4 = byteBuffer.getShort() & 65535;
                    if ((32768 & i4) != 0) {
                        i4 = (((i4 & 32767) << 15) | 0) + (65535 & byteBuffer.getShort());
                    }
                    strM1067Ooo = Ooo.m1067Ooo(byteBuffer, i4);
                    byteBuffer.getShort();
                }
                oo0.m955O8oO888(oOVar.f274O8oO888, strM1067Ooo);
                str = strM1067Ooo;
            }
        }
        byteBuffer.position((int) (jPosition + o.m969O8oO888()));
        return oo0;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0036. Please report as an issue. */
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static com.netease.htprotect.p010Ooo.p014o0o0.oO m1073O8oO888(ByteBuffer byteBuffer, Oo0 oo0) {
        com.netease.htprotect.p010Ooo.p014o0o0.oO oOVar;
        com.netease.htprotect.p010Ooo.p014o0o0.oO oOVar2;
        o0o0 o0o0Var = new o0o0();
        o0o0Var.m1023O8oO888(byteBuffer.getShort() & 65535);
        o0o0Var.m1025O8oO888(Ooo.m1062O8oO888(byteBuffer));
        o0o0Var.m1027Ooo(Ooo.m1062O8oO888(byteBuffer));
        short sM1022O8oO888 = o0o0Var.m1022O8oO888();
        if (sM1022O8oO888 != 0) {
            if (sM1022O8oO888 == 1) {
                oOVar = new com.netease.htprotect.p010Ooo.p014o0o0.oO(Ooo.m1066Ooo(byteBuffer));
            } else if (sM1022O8oO888 == 3) {
                int i = byteBuffer.getInt();
                if (i >= 0) {
                    oOVar = new com.netease.htprotect.p010Ooo.p014o0o0.oO(oo0.m954O8oO888(i));
                }
            } else if (sM1022O8oO888 != 5) {
                if (sM1022O8oO888 != 6) {
                    switch (sM1022O8oO888) {
                        case 16:
                        case 17:
                            oOVar2 = new com.netease.htprotect.p010Ooo.p014o0o0.oO(byteBuffer.getInt());
                            break;
                        case 18:
                            oOVar2 = new com.netease.htprotect.p010Ooo.p014o0o0.oO(byteBuffer.getInt() != 0);
                            break;
                        default:
                            switch (sM1022O8oO888) {
                                case 28:
                                case 30:
                                    oOVar = new com.netease.htprotect.p010Ooo.p014o0o0.oO(m1076O8oO888(byteBuffer, 8));
                                    break;
                                case 29:
                                case 31:
                                    oOVar2 = new com.netease.htprotect.p010Ooo.p014o0o0.oO(m1076O8oO888(byteBuffer, 6));
                                    break;
                                default:
                                    oOVar2 = new com.netease.htprotect.p010Ooo.p014o0o0.oO("{" + ((int) o0o0Var.m1022O8oO888()) + ":" + Ooo.m1066Ooo(byteBuffer) + i.d);
                                    break;
                            }
                    }
                } else {
                    long jM1066Ooo = Ooo.m1066Ooo(byteBuffer);
                    short s = (short) (15 & jM1066Ooo);
                    oOVar2 = new com.netease.htprotect.p010Ooo.p014o0o0.oO(Float.intBitsToFloat((int) (jM1066Ooo >> 4)) + (s != 0 ? s != 1 ? "unknown type:0x" + Integer.toHexString(s) : "%p" : "%"));
                }
                o0o0Var.m1024O8oO888(oOVar2);
            } else {
                long jM1066Ooo2 = Ooo.m1066Ooo(byteBuffer);
                short s2 = (short) (255 & jM1066Ooo2);
                oOVar = new com.netease.htprotect.p010Ooo.p014o0o0.oO((jM1066Ooo2 >> 8) + (s2 != 0 ? s2 != 1 ? s2 != 2 ? s2 != 3 ? s2 != 4 ? s2 != 5 ? "unknown unit:0x" + Integer.toHexString(s2) : "mm" : "in" : Config.PLATFORM_TYPE : "sp" : t.q : "px"));
            }
            o0o0Var.m1024O8oO888(oOVar);
        } else {
            o0o0Var.m1024O8oO888(new com.netease.htprotect.p010Ooo.p014o0o0.oO(""));
        }
        return o0o0Var.m1026Ooo();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m1074O8oO888(long j, com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Oo0 oo0, Locale locale) {
        if (j > 16973824 && j < 16977920) {
            return "@android:style/" + ((String) com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Oo0.f355O8oO888.get((int) j));
        }
        String str = "resourceId:0x" + Long.toHexString(j);
        if (oo0 == null) {
            return str;
        }
        short s = (short) ((j >> 24) & 255);
        short s2 = (short) ((j >> 16) & 255);
        int i = (int) (j & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.oO oOVarM842O8oO888 = oo0.m842O8oO888(s);
        if (oOVarM842O8oO888 == null) {
            return str;
        }
        OO8 oo8M922O8oO888 = oOVarM842O8oO888.m922O8oO888(Short.valueOf(s2));
        List listM929Ooo = oOVarM842O8oO888.m929Ooo(Short.valueOf(s2));
        if (oo8M922O8oO888 == null || listM929Ooo == null || !oo8M922O8oO888.m839O8oO888(i)) {
            return str;
        }
        int i2 = -1;
        Iterator it = listM929Ooo.iterator();
        O8 o8 = null;
        String strM870O8 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0679 c0679 = (C0679) it.next();
            O8 o8M946O8oO888 = c0679.m946O8oO888(i);
            if (o8M946O8oO888 != null && (o8M946O8oO888.m873o0o0() == null || o8M946O8oO888.m873o0o0().m1030O8oO888() != 0 || o8M946O8oO888.m873o0o0().m1032Ooo() != null)) {
                strM870O8 = o8M946O8oO888.m870O8();
                int iM1061O8oO888 = O8.m1061O8oO888(locale, c0679.m952Ooo());
                if (iM1061O8oO888 == 2) {
                    o8 = o8M946O8oO888;
                    break;
                }
                if (iM1061O8oO888 > i2) {
                    i2 = iM1061O8oO888;
                    o8 = o8M946O8oO888;
                }
            }
        }
        return (locale == null || o8 == null) ? "@" + oo8M922O8oO888.m836O8oO888() + "/" + strM870O8 : o8.mo866O8oO888(oo0, locale);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m1075O8oO888(ByteBuffer byteBuffer) {
        String strM1067Ooo = Ooo.m1067Ooo(byteBuffer, 128);
        for (int i = 0; i < strM1067Ooo.length(); i++) {
            if (strM1067Ooo.charAt(i) == 0) {
                return strM1067Ooo.substring(0, i);
            }
        }
        return strM1067Ooo;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m1076O8oO888(ByteBuffer byteBuffer, int i) {
        long jM1066Ooo = Ooo.m1066Ooo(byteBuffer);
        StringBuilder sb = new StringBuilder();
        for (int i2 = (i / 2) - 1; i2 >= 0; i2--) {
            sb.append(Integer.toHexString((int) ((jM1066Ooo >> (i2 * 8)) & 255)));
        }
        return sb.toString();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m1077O8oO888(ByteBuffer byteBuffer, boolean z) {
        if (z) {
            m1080Ooo(byteBuffer);
            String str = new String(Ooo.m1063O8oO888(byteBuffer, m1080Ooo(byteBuffer)), f525O8oO888);
            Ooo.m1062O8oO888(byteBuffer);
            return str;
        }
        int i = byteBuffer.getShort() & 65535;
        if ((32768 & i) != 0) {
            i = (((i & 32767) << 15) | 0) + (65535 & byteBuffer.getShort());
        }
        String strM1067Ooo = Ooo.m1067Ooo(byteBuffer, i);
        byteBuffer.getShort();
        return strM1067Ooo;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static void m1078O8oO888(int i) throws O8oO888 {
        if (1 != i) {
            throw new O8oO888("Expect chunk type:" + Integer.toHexString(1) + ", but got:" + Integer.toHexString(i));
        }
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static int m1079O8(ByteBuffer byteBuffer) {
        int i = byteBuffer.getShort() & 65535;
        return (32768 & i) != 0 ? (((i & 32767) << 15) | 0) + (byteBuffer.getShort() & 65535) : i;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static int m1080Ooo(ByteBuffer byteBuffer) {
        short sM1062O8oO888 = Ooo.m1062O8oO888(byteBuffer);
        return (sM1062O8oO888 & 128) != 0 ? (((sM1062O8oO888 & 127) << 7) | 0) + Ooo.m1062O8oO888(byteBuffer) : sM1062O8oO888;
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static String m1081o0o0(ByteBuffer byteBuffer) {
        long jM1066Ooo = Ooo.m1066Ooo(byteBuffer);
        short s = (short) (255 & jM1066Ooo);
        return (jM1066Ooo >> 8) + (s != 0 ? s != 1 ? s != 2 ? s != 3 ? s != 4 ? s != 5 ? "unknown unit:0x" + Integer.toHexString(s) : "mm" : "in" : Config.PLATFORM_TYPE : "sp" : t.q : "px");
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static String m1082oO(ByteBuffer byteBuffer) {
        long jM1066Ooo = Ooo.m1066Ooo(byteBuffer);
        short s = (short) (15 & jM1066Ooo);
        return Float.intBitsToFloat((int) (jM1066Ooo >> 4)) + (s != 0 ? s != 1 ? "unknown type:0x" + Integer.toHexString(s) : "%p" : "%");
    }
}
