package com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888;

import com.netease.htprotect.p010Ooo.p014o0o0.Oo0;
import com.netease.htprotect.p010Ooo.p017oO.Ooo;
import com.netease.htprotect.p010Ooo.p017oO.oO;
import java.nio.ByteBuffer;
import java.util.Locale;

/* renamed from: com.netease.htprotect.〇Ooo.〇o0〇o0.O8〇oO8〇88.〇〇, reason: contains not printable characters */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class C0679 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private String f422O8oO888;
    private long[] Oo0;

    /* renamed from: 〇O, reason: contains not printable characters */
    private Oo0 f423O;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private Locale f424O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private short f425Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private Oo0 f426o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private ByteBuffer f427oO;

    public C0679(C00oOOo c00oOOo) {
        this.f425Ooo = c00oOOo.m861o0o0();
        this.f424O8 = new Locale(c00oOOo.m858O().m907O8oO888(), c00oOOo.m858O().m909Ooo());
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m938O8oO888(Locale locale) {
        this.f424O8 = locale;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m939O8oO888(short s) {
        this.f425Ooo = s;
    }

    private Oo0 Oo0() {
        return this.f426o0o0;
    }

    /* renamed from: 〇O, reason: contains not printable characters */
    private ByteBuffer m940O() {
        return this.f427oO;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private O8 m941O8() {
        long jPosition = this.f427oO.position();
        O8 o8 = new O8();
        o8.m867O8oO888(this.f427oO.getShort() & 65535);
        o8.m872Ooo(this.f427oO.getShort() & 65535);
        o8.m869O8oO888(this.f426o0o0.m954O8oO888(this.f427oO.getInt()));
        if ((o8.m871Ooo() & 1) == 0) {
            this.f427oO.position((int) (jPosition + o8.m865O8oO888()));
            o8.m868O8oO888(oO.m1073O8oO888(this.f427oO, this.f423O));
            return o8;
        }
        o0o0 o0o0Var = new o0o0(o8);
        o0o0Var.m912O8oO888(Ooo.m1066Ooo(this.f427oO));
        o0o0Var.m914Ooo(Ooo.m1066Ooo(this.f427oO));
        this.f427oO.position((int) (jPosition + o8.m865O8oO888()));
        o0O0O[] o0o0oArr = new o0O0O[(int) o0o0Var.m915oO()];
        for (int i = 0; i < o0o0Var.m915oO(); i++) {
            o0O0O o0o0o = new o0O0O();
            o0o0o.m935O8oO888(Ooo.m1066Ooo(this.f427oO));
            o0o0o.m936O8oO888(oO.m1073O8oO888(this.f427oO, this.f423O));
            o0o0oArr[i] = o0o0o;
        }
        o0o0Var.m913O8oO888(o0o0oArr);
        return o0o0Var;
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private o0O0O m942o0o0() {
        o0O0O o0o0o = new o0O0O();
        o0o0o.m935O8oO888(Ooo.m1066Ooo(this.f427oO));
        o0o0o.m936O8oO888(oO.m1073O8oO888(this.f427oO, this.f423O));
        return o0o0o;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private String m943oO() {
        return this.f422O8oO888;
    }

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private long[] m944o0O0O() {
        return this.Oo0;
    }

    /* renamed from: 〇〇, reason: contains not printable characters */
    private Oo0 m945() {
        return this.f423O;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final O8 m946O8oO888(int i) {
        long[] jArr = this.Oo0;
        if (i >= jArr.length) {
            return null;
        }
        long j = jArr[i];
        if (j == C00oOOo.f362O8oO888) {
            return null;
        }
        this.f427oO.position((int) j);
        long jPosition = this.f427oO.position();
        O8 o8 = new O8();
        o8.m867O8oO888(this.f427oO.getShort() & 65535);
        o8.m872Ooo(this.f427oO.getShort() & 65535);
        o8.m869O8oO888(this.f426o0o0.m954O8oO888(this.f427oO.getInt()));
        if ((o8.m871Ooo() & 1) == 0) {
            this.f427oO.position((int) (jPosition + o8.m865O8oO888()));
            o8.m868O8oO888(oO.m1073O8oO888(this.f427oO, this.f423O));
            return o8;
        }
        o0o0 o0o0Var = new o0o0(o8);
        o0o0Var.m912O8oO888(Ooo.m1066Ooo(this.f427oO));
        o0o0Var.m914Ooo(Ooo.m1066Ooo(this.f427oO));
        this.f427oO.position((int) (jPosition + o8.m865O8oO888()));
        o0O0O[] o0o0oArr = new o0O0O[(int) o0o0Var.m915oO()];
        for (int i2 = 0; i2 < o0o0Var.m915oO(); i2++) {
            o0O0O o0o0o = new o0O0O();
            o0o0o.m935O8oO888(Ooo.m1066Ooo(this.f427oO));
            o0o0o.m936O8oO888(oO.m1073O8oO888(this.f427oO, this.f423O));
            o0o0oArr[i2] = o0o0o;
        }
        o0o0Var.m913O8oO888(o0o0oArr);
        return o0o0Var;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final short m947O8oO888() {
        return this.f425Ooo;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m948O8oO888(Oo0 oo0) {
        this.f426o0o0 = oo0;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m949O8oO888(String str) {
        this.f422O8oO888 = str;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m950O8oO888(ByteBuffer byteBuffer) {
        this.f427oO = byteBuffer;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m951O8oO888(long[] jArr) {
        this.Oo0 = jArr;
    }

    public final String toString() {
        return "Type{name='" + this.f422O8oO888 + "', id=" + ((int) this.f425Ooo) + ", locale=" + this.f424O8 + '}';
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final Locale m952Ooo() {
        return this.f424O8;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final void m953Ooo(Oo0 oo0) {
        this.f423O = oo0;
    }
}
