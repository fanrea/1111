package com.netease.htprotect.p010Ooo.p012O8;

import com.netease.htprotect.p010Ooo.p014o0o0.O;
import com.netease.htprotect.p010Ooo.p014o0o0.Oo0;
import com.netease.htprotect.p010Ooo.p014o0o0.Ooo;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C0679;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.O8oO888;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.OO8;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.oO;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.oo0OOO8;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.netease.htprotect.〇Ooo.〇O8.〇o0〇o0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o0o0 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private Oo0 f270O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Oo0 f271O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private ByteBuffer f272Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private Set f273o0o0;

    public o0o0(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        this.f272Ooo = byteBufferDuplicate;
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        this.f273o0o0 = new HashSet();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private com.netease.htprotect.p010Ooo.p017oO.o0o0 m753O8oO888(O8oO888 o8oO888) throws com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888 {
        long jPosition;
        ByteBuffer byteBuffer;
        int i;
        com.netease.htprotect.p010Ooo.p017oO.o0o0 o0o0Var = new com.netease.htprotect.p010Ooo.p017oO.o0o0();
        oO oOVar = new oO(o8oO888);
        o0o0Var.m1069O8oO888(oOVar);
        long jPosition2 = this.f272Ooo.position();
        if (o8oO888.Oo0() > 0) {
            this.f272Ooo.position((int) ((o8oO888.Oo0() + jPosition2) - o8oO888.m970O8()));
            oOVar.m926O8oO888(com.netease.htprotect.p010Ooo.p017oO.oO.m1072O8oO888(this.f272Ooo, (O) m754o0o0()));
        }
        if (o8oO888.m827O() > 0) {
            this.f272Ooo.position((int) ((jPosition2 + o8oO888.m827O()) - o8oO888.m970O8()));
            oOVar.m930Ooo(com.netease.htprotect.p010Ooo.p017oO.oO.m1072O8oO888(this.f272Ooo, (O) m754o0o0()));
        }
        while (true) {
            if (this.f272Ooo.hasRemaining()) {
                Ooo oooM754o0o0 = m754o0o0();
                int i2 = 0;
                switch (oooM754o0o0.m971Ooo()) {
                    case 512:
                        o0o0Var.m1071Ooo((O8oO888) oooM754o0o0);
                        break;
                    case 513:
                        jPosition = this.f272Ooo.position();
                        C00oOOo c00oOOo = (C00oOOo) oooM754o0o0;
                        long[] jArr = new long[(int) c00oOOo.m862oO()];
                        while (i2 < c00oOOo.m862oO()) {
                            jArr[i2] = com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo);
                            i2++;
                        }
                        C0679 c0679 = new C0679(c00oOOo);
                        c0679.m949O8oO888(oOVar.m928Ooo().m954O8oO888(c00oOOo.m861o0o0() - 1));
                        this.f272Ooo.position((int) ((c00oOOo.Oo0() + jPosition) - c00oOOo.m970O8()));
                        ByteBuffer byteBufferSlice = this.f272Ooo.slice();
                        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
                        c0679.m950O8oO888(byteBufferSlice);
                        c0679.m948O8oO888(oOVar.m927O8());
                        c0679.m951O8oO888(jArr);
                        c0679.m953Ooo(this.f270O8oO888);
                        oOVar.m925O8oO888(c0679);
                        this.f273o0o0.add(c0679.m952Ooo());
                        byteBuffer = this.f272Ooo;
                        i = c00oOOo.m969O8oO888();
                        byteBuffer.position((int) (jPosition + i));
                    case 514:
                        jPosition = this.f272Ooo.position();
                        oo0OOO8 oo0ooo8 = (oo0OOO8) oooM754o0o0;
                        long[] jArr2 = new long[(int) oo0ooo8.m851oO()];
                        while (i2 < oo0ooo8.m851oO()) {
                            jArr2[i2] = com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo);
                            i2++;
                        }
                        OO8 oo8 = new OO8(oo0ooo8);
                        oo8.m838O8oO888(jArr2);
                        oo8.m837O8oO888(oOVar.m928Ooo().m954O8oO888(oo0ooo8.m850o0o0() - 1));
                        oOVar.m924O8oO888(oo8);
                        byteBuffer = this.f272Ooo;
                        i = oo0ooo8.m969O8oO888();
                        byteBuffer.position((int) (jPosition + i));
                    default:
                        throw new com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888("unexpected chunk type:" + oooM754o0o0.m971Ooo());
                }
            }
        }
        return o0o0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private Ooo m754o0o0() throws com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888 {
        O o;
        C00oOOo c00oOOo;
        long jPosition = this.f272Ooo.position();
        int i = this.f272Ooo.getShort() & 65535;
        int i2 = this.f272Ooo.getShort() & 65535;
        long jM1066Ooo = com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo);
        if (i == 1) {
            O o2 = new O(i, i2, jM1066Ooo);
            o2.m958O8oO888(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
            o2.m960Ooo(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
            o2.m959O8(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
            o2.m962o0o0(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
            o2.m964oO(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
            o = o2;
        } else if (i != 2) {
            switch (i) {
                case 512:
                    O8oO888 o8oO888 = new O8oO888(i, i2, jM1066Ooo);
                    o8oO888.m825O8oO888(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
                    o8oO888.m826O8oO888(com.netease.htprotect.p010Ooo.p017oO.oO.m1075O8oO888(this.f272Ooo));
                    o8oO888.m829Ooo(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
                    o8oO888.m828O8(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
                    o8oO888.m831o0o0(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
                    o8oO888.m833oO(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
                    o = o8oO888;
                    break;
                case 513:
                    C00oOOo c00oOOo2 = new C00oOOo(i, i2, jM1066Ooo);
                    c00oOOo2.m857O8oO888(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1062O8oO888(this.f272Ooo));
                    c00oOOo2.m860Ooo(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1062O8oO888(this.f272Ooo));
                    c00oOOo2.m854O8oO888(this.f272Ooo.getShort() & 65535);
                    c00oOOo2.m855O8oO888(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
                    c00oOOo2.m859Ooo(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
                    c00oOOo2.m856O8oO888(m755oO());
                    c00oOOo = c00oOOo2;
                    this.f272Ooo.position((int) (jPosition + i2));
                    return c00oOOo;
                case 514:
                    oo0OOO8 oo0ooo8 = new oo0OOO8(i, i2, jM1066Ooo);
                    oo0ooo8.m848O8oO888(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1062O8oO888(this.f272Ooo));
                    oo0ooo8.m849Ooo(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1062O8oO888(this.f272Ooo));
                    oo0ooo8.m846O8oO888(this.f272Ooo.getShort() & 65535);
                    oo0ooo8.m847O8oO888(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
                    c00oOOo = oo0ooo8;
                    this.f272Ooo.position((int) (jPosition + i2));
                    return c00oOOo;
                default:
                    throw new com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888("Unexpected chunk Type:" + Integer.toHexString(i));
            }
        } else {
            com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.O o3 = new com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.O(i, i2, jM1066Ooo);
            o3.m863O8oO888(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo));
            o = o3;
        }
        this.f272Ooo.position((int) (jPosition + i2));
        return o;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Ooo m755oO() {
        long jPosition = this.f272Ooo.position();
        com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Ooo ooo = new com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Ooo();
        long jM1066Ooo = com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo);
        com.netease.htprotect.p010Ooo.p017oO.Ooo.m1065O8(this.f272Ooo, 4);
        ooo.m908O8oO888(new String(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1063O8oO888(this.f272Ooo, 2)).replace("\u0000", ""));
        ooo.m910Ooo(new String(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1063O8oO888(this.f272Ooo, 2)).replace("\u0000", ""));
        com.netease.htprotect.p010Ooo.p017oO.Ooo.m1065O8(this.f272Ooo, (int) (jM1066Ooo - (this.f272Ooo.position() - jPosition)));
        return ooo;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m756O8oO888() throws com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888 {
        int i;
        long jPosition;
        ByteBuffer byteBuffer;
        int i2;
        com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.O o = (com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.O) m754o0o0();
        this.f270O8oO888 = com.netease.htprotect.p010Ooo.p017oO.oO.m1072O8oO888(this.f272Ooo, (O) m754o0o0());
        com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Oo0 oo0 = new com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Oo0();
        this.f271O8 = oo0;
        oo0.m844O8oO888(this.f270O8oO888);
        O8oO888 o8oO888 = (O8oO888) m754o0o0();
        for (int i3 = 0; i3 < o.m864o0o0(); i3 = i + 1) {
            com.netease.htprotect.p010Ooo.p017oO.o0o0 o0o0Var = new com.netease.htprotect.p010Ooo.p017oO.o0o0();
            oO oOVar = new oO(o8oO888);
            o0o0Var.m1069O8oO888(oOVar);
            long jPosition2 = this.f272Ooo.position();
            if (o8oO888.Oo0() > 0) {
                i = i3;
                this.f272Ooo.position((int) ((o8oO888.Oo0() + jPosition2) - o8oO888.m970O8()));
                oOVar.m926O8oO888(com.netease.htprotect.p010Ooo.p017oO.oO.m1072O8oO888(this.f272Ooo, (O) m754o0o0()));
            } else {
                i = i3;
            }
            if (o8oO888.m827O() > 0) {
                this.f272Ooo.position((int) ((jPosition2 + o8oO888.m827O()) - o8oO888.m970O8()));
                oOVar.m930Ooo(com.netease.htprotect.p010Ooo.p017oO.oO.m1072O8oO888(this.f272Ooo, (O) m754o0o0()));
            }
            while (true) {
                if (this.f272Ooo.hasRemaining()) {
                    Ooo oooM754o0o0 = m754o0o0();
                    switch (oooM754o0o0.m971Ooo()) {
                        case 512:
                            o0o0Var.m1071Ooo((O8oO888) oooM754o0o0);
                            continue;
                        case 513:
                            jPosition = this.f272Ooo.position();
                            C00oOOo c00oOOo = (C00oOOo) oooM754o0o0;
                            long[] jArr = new long[(int) c00oOOo.m862oO()];
                            for (int i4 = 0; i4 < c00oOOo.m862oO(); i4++) {
                                jArr[i4] = com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo);
                            }
                            C0679 c0679 = new C0679(c00oOOo);
                            c0679.m949O8oO888(oOVar.m928Ooo().m954O8oO888(c00oOOo.m861o0o0() - 1));
                            this.f272Ooo.position((int) ((c00oOOo.Oo0() + jPosition) - c00oOOo.m970O8()));
                            ByteBuffer byteBufferSlice = this.f272Ooo.slice();
                            byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
                            c0679.m950O8oO888(byteBufferSlice);
                            c0679.m948O8oO888(oOVar.m927O8());
                            c0679.m951O8oO888(jArr);
                            c0679.m953Ooo(this.f270O8oO888);
                            oOVar.m925O8oO888(c0679);
                            this.f273o0o0.add(c0679.m952Ooo());
                            byteBuffer = this.f272Ooo;
                            i2 = c00oOOo.m969O8oO888();
                            break;
                        case 514:
                            jPosition = this.f272Ooo.position();
                            oo0OOO8 oo0ooo8 = (oo0OOO8) oooM754o0o0;
                            long[] jArr2 = new long[(int) oo0ooo8.m851oO()];
                            for (int i5 = 0; i5 < oo0ooo8.m851oO(); i5++) {
                                jArr2[i5] = com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f272Ooo);
                            }
                            OO8 oo8 = new OO8(oo0ooo8);
                            oo8.m838O8oO888(jArr2);
                            oo8.m837O8oO888(oOVar.m928Ooo().m954O8oO888(oo0ooo8.m850o0o0() - 1));
                            oOVar.m924O8oO888(oo8);
                            byteBuffer = this.f272Ooo;
                            i2 = oo0ooo8.m969O8oO888();
                            break;
                        default:
                            throw new com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888("unexpected chunk type:" + oooM754o0o0.m971Ooo());
                    }
                    byteBuffer.position((int) (jPosition + i2));
                }
            }
            this.f271O8.m843O8oO888((oO) o0o0Var.m1068O8oO888());
            o8oO888 = (O8oO888) o0o0Var.m1070Ooo();
        }
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public final Set m757O8() {
        return this.f273o0o0;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Oo0 m758Ooo() {
        return this.f271O8;
    }
}
