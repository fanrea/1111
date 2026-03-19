package com.netease.htprotect.p024.p026Ooo;

import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;

/* renamed from: com.netease.htprotect.〇〇.〇Ooo.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static final Comparator f649O8oO888 = new C0688O8oO888(0);
    private static final int Oo0 = 46;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final int f650O8 = 46;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final int f651Ooo = 33639248;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static final int f652o0o0 = 8;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static final int f653oO = 42;

    /* renamed from: OO〇8, reason: contains not printable characters */
    private final int f654OO8;
    private final long Oo;

    /* renamed from: O〇80Oo0O, reason: contains not printable characters */
    private final long f655O80Oo0O;

    /* renamed from: O〇o8ooOo〇, reason: contains not printable characters */
    private final String f656Oo8ooOo;

    /* renamed from: O〇〇〇o, reason: contains not printable characters */
    private final int f657Oo;

    /* renamed from: o0o8〇, reason: contains not printable characters */
    private final long f658o0o8;

    /* renamed from: oo0〇OO〇O8, reason: contains not printable characters */
    private final long f659oo0OOO8;

    /* renamed from: 〇00oOOo, reason: contains not printable characters */
    private final int f66000oOOo;

    /* renamed from: 〇O, reason: contains not printable characters */
    private final ByteBuffer f661O;

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private final short f662o0O0O;

    /* renamed from: 〇〇, reason: contains not printable characters */
    private final short f663;

    /* renamed from: com.netease.htprotect.〇〇.〇Ooo.O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
    private static class C0688O8oO888 implements Comparator {
        private C0688O8oO888() {
        }

        /* synthetic */ C0688O8oO888(byte b) {
            this();
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private static int m1238O8oO888(O8oO888 o8oO888, O8oO888 o8oO8882) {
            long jM1237o0O0O = o8oO888.m1237o0O0O();
            long jM1237o0O0O2 = o8oO8882.m1237o0O0O();
            if (jM1237o0O0O > jM1237o0O0O2) {
                return 1;
            }
            return jM1237o0O0O < jM1237o0O0O2 ? -1 : 0;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            long jM1237o0O0O = ((O8oO888) obj).m1237o0O0O();
            long jM1237o0O0O2 = ((O8oO888) obj2).m1237o0O0O();
            if (jM1237o0O0O > jM1237o0O0O2) {
                return 1;
            }
            return jM1237o0O0O < jM1237o0O0O2 ? -1 : 0;
        }
    }

    private O8oO888(ByteBuffer byteBuffer, short s, short s2, int i, int i2, long j, long j2, long j3, long j4, String str, int i3) {
        this.f661O = byteBuffer;
        this.f662o0O0O = s;
        this.f663 = s2;
        this.f654OO8 = i2;
        this.f66000oOOo = i;
        this.f659oo0OOO8 = j;
        this.f655O80Oo0O = j2;
        this.Oo = j3;
        this.f658o0o8 = j4;
        this.f656Oo8ooOo = str;
        this.f657Oo = i3;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private O8oO888 m1223O8oO888(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f661O.remaining());
        byteBufferAllocate.put(this.f661O.slice());
        byteBufferAllocate.flip();
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        Oo0.m1244O8oO888(byteBufferAllocate, 42, j);
        return new O8oO888(byteBufferAllocate, this.f662o0O0O, this.f663, this.f66000oOOo, this.f654OO8, this.f659oo0OOO8, this.f655O80Oo0O, this.Oo, j, this.f656Oo8ooOo, this.f657Oo);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static O8oO888 m1224O8oO888(String str, int i, int i2, long j, long j2, long j3, long j4) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 46);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(f651Ooo);
        Oo0.m1250Ooo(byteBufferAllocate, 20);
        Oo0.m1250Ooo(byteBufferAllocate, 20);
        byteBufferAllocate.putShort(Oo0.f670o0o0);
        byteBufferAllocate.putShort((short) 8);
        Oo0.m1250Ooo(byteBufferAllocate, i);
        Oo0.m1250Ooo(byteBufferAllocate, i2);
        Oo0.m1245O8oO888(byteBufferAllocate, j);
        Oo0.m1245O8oO888(byteBufferAllocate, j2);
        Oo0.m1245O8oO888(byteBufferAllocate, j3);
        Oo0.m1250Ooo(byteBufferAllocate, bytes.length);
        Oo0.m1250Ooo(byteBufferAllocate, 0);
        Oo0.m1250Ooo(byteBufferAllocate, 0);
        Oo0.m1250Ooo(byteBufferAllocate, 0);
        Oo0.m1250Ooo(byteBufferAllocate, 0);
        Oo0.m1245O8oO888(byteBufferAllocate, 0L);
        Oo0.m1245O8oO888(byteBufferAllocate, j4);
        byteBufferAllocate.put(bytes);
        if (byteBufferAllocate.hasRemaining()) {
            throw new RuntimeException("pos: " + byteBufferAllocate.position() + ", limit: " + byteBufferAllocate.limit());
        }
        byteBufferAllocate.flip();
        return new O8oO888(byteBufferAllocate, Oo0.f670o0o0, (short) 8, i, i2, j, j2, j3, j4, str, bytes.length);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static O8oO888 m1225O8oO888(ByteBuffer byteBuffer) throws Exception {
        Oo0.m1252o0o0(byteBuffer);
        if (byteBuffer.remaining() < 46) {
            throw new Exception("Input too short. Need at least: 46 bytes, available: " + byteBuffer.remaining() + " bytes", new BufferUnderflowException());
        }
        int iPosition = byteBuffer.position();
        int i = byteBuffer.getInt();
        if (i != f651Ooo) {
            throw new Exception("Not a Central Directory record. Signature: 0x" + Long.toHexString(i & C00oOOo.f362O8oO888));
        }
        byteBuffer.position(iPosition + 8);
        short s = byteBuffer.getShort();
        short s2 = byteBuffer.getShort();
        int i2 = byteBuffer.getShort() & 65535;
        int i3 = byteBuffer.getShort() & 65535;
        long jM1253oO = Oo0.m1253oO(byteBuffer);
        long jM1253oO2 = Oo0.m1253oO(byteBuffer);
        long jM1253oO3 = Oo0.m1253oO(byteBuffer);
        int i4 = byteBuffer.getShort() & 65535;
        int i5 = byteBuffer.getShort() & 65535;
        int i6 = byteBuffer.getShort() & 65535;
        byteBuffer.position(iPosition + 42);
        long jM1253oO4 = Oo0.m1253oO(byteBuffer);
        byteBuffer.position(iPosition);
        int i7 = i4 + 46 + i5 + i6;
        if (i7 > byteBuffer.remaining()) {
            throw new Exception("Input too short. Need: " + i7 + " bytes, available: " + byteBuffer.remaining() + " bytes", new BufferUnderflowException());
        }
        String strM1226O8oO888 = m1226O8oO888(byteBuffer, iPosition + 46, i4);
        byteBuffer.position(iPosition);
        int iLimit = byteBuffer.limit();
        int i8 = iPosition + i7;
        try {
            byteBuffer.limit(i8);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBuffer.limit(iLimit);
            byteBuffer.position(i8);
            return new O8oO888(byteBufferSlice, s, s2, i2, i3, jM1253oO, jM1253oO2, jM1253oO3, jM1253oO4, strM1226O8oO888, i4);
        } catch (Throwable th) {
            byteBuffer.limit(iLimit);
            throw th;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    static String m1226O8oO888(ByteBuffer byteBuffer, int i, int i2) {
        byte[] bArrArray;
        int iArrayOffset;
        if (byteBuffer.hasArray()) {
            bArrArray = byteBuffer.array();
            iArrayOffset = byteBuffer.arrayOffset() + i;
        } else {
            bArrArray = new byte[i2];
            int iPosition = byteBuffer.position();
            try {
                byteBuffer.position(i);
                byteBuffer.get(bArrArray);
                byteBuffer.position(iPosition);
                iArrayOffset = 0;
            } catch (Throwable th) {
                byteBuffer.position(iPosition);
                throw th;
            }
        }
        return new String(bArrArray, iArrayOffset, i2, StandardCharsets.UTF_8);
    }

    /* renamed from: OO〇8, reason: contains not printable characters */
    private int m1227OO8() {
        return this.f654OO8;
    }

    /* renamed from: 〇00oOOo, reason: contains not printable characters */
    private int m122800oOOo() {
        return this.f66000oOOo;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private void m1229Ooo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f661O.slice());
    }

    /* renamed from: 〇〇, reason: contains not printable characters */
    private int m1230() {
        return this.f661O.remaining();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final String m1231O8oO888() {
        return this.f656Oo8ooOo;
    }

    public final long Oo0() {
        return this.f655O80Oo0O;
    }

    /* renamed from: 〇O, reason: contains not printable characters */
    public final long m1232O() {
        return this.Oo;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public final short m1233O8() {
        return this.f662o0O0O;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final int m1234Ooo() {
        return this.f657Oo;
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    public final short m1235o0o0() {
        return this.f663;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    public final long m1236oO() {
        return this.f659oo0OOO8;
    }

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    public final long m1237o0O0O() {
        return this.f658o0o8;
    }
}
