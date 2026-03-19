package com.netease.htprotect.p024.p026Ooo;

import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import com.netease.htprotect.p024.p025O8oO888.O;
import com.netease.htprotect.p024.p025O8oO888.O8;
import com.netease.htprotect.p024.p025O8oO888.Ooo;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: com.netease.htprotect.〇〇.〇Ooo.〇o0〇o0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o0o0 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final int f681O8oO888 = 67324752;

    /* renamed from: OO〇8, reason: contains not printable characters */
    private static final int f682OO8 = 134695760;
    private static final int Oo0 = 22;
    private static final ByteBuffer o8o0 = ByteBuffer.allocate(0);

    /* renamed from: 〇00oOOo, reason: contains not printable characters */
    private static final int f68300oOOo = 12;

    /* renamed from: 〇O, reason: contains not printable characters */
    private static final int f684O = 26;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final int f685O8 = 6;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final int f686Ooo = 30;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static final int f687o0o0 = 14;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static final int f688oO = 18;

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private static final int f689o0O0O = 28;

    /* renamed from: 〇〇, reason: contains not printable characters */
    private static final int f690 = 30;
    private final ByteBuffer Oo;

    /* renamed from: O〇80Oo0O, reason: contains not printable characters */
    private final int f691O80Oo0O;

    /* renamed from: O〇o8ooOo〇, reason: contains not printable characters */
    private final long f692Oo8ooOo;

    /* renamed from: O〇〇〇o, reason: contains not printable characters */
    private final int f693Oo;

    /* renamed from: o0o8〇, reason: contains not printable characters */
    private final long f694o0o8;

    /* renamed from: oo0〇OO〇O8, reason: contains not printable characters */
    private final String f695oo0OOO8;

    /* renamed from: 〇8〇0, reason: contains not printable characters */
    private final long f69680;

    /* renamed from: 〇O8O00oo〇, reason: contains not printable characters */
    private final boolean f697O8O00oo;

    /* renamed from: 〇oO00O, reason: contains not printable characters */
    private final long f698oO00O;

    /* renamed from: com.netease.htprotect.〇〇.〇Ooo.〇o0〇o0$O8〇oO8〇88, reason: invalid class name */
    private static class O8oO888 implements Ooo, Closeable {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private final Ooo f699O8oO888;
        private boolean Oo0;

        /* renamed from: 〇O8, reason: contains not printable characters */
        private byte[] f700O8;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        private Inflater f701Ooo;

        /* renamed from: 〇o0〇o0, reason: contains not printable characters */
        private byte[] f702o0o0;

        /* renamed from: 〇oO, reason: contains not printable characters */
        private long f703oO;

        private O8oO888(Ooo ooo) {
            this.f701Ooo = new Inflater(true);
            this.f699O8oO888 = ooo;
        }

        /* synthetic */ O8oO888(Ooo ooo, byte b) {
            this(ooo);
        }

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        private void m1270Ooo() {
            if (this.Oo0) {
                throw new IllegalStateException("Closed");
            }
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public final long m1271O8oO888() {
            return this.f703oO;
        }

        @Override // com.netease.htprotect.p024.p025O8oO888.Ooo
        /* renamed from: O8〇oO8〇88 */
        public final void mo1195O8oO888(ByteBuffer byteBuffer) throws DataFormatException, IOException {
            m1270Ooo();
            if (byteBuffer.hasArray()) {
                mo1196O8oO888(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.limit());
                return;
            }
            if (this.f702o0o0 == null) {
                this.f702o0o0 = new byte[65536];
            }
            while (byteBuffer.hasRemaining()) {
                int iMin = Math.min(byteBuffer.remaining(), this.f702o0o0.length);
                byteBuffer.get(this.f702o0o0, 0, iMin);
                mo1196O8oO888(this.f702o0o0, 0, iMin);
            }
        }

        @Override // com.netease.htprotect.p024.p025O8oO888.Ooo
        /* renamed from: O8〇oO8〇88 */
        public final void mo1196O8oO888(byte[] bArr, int i, int i2) throws DataFormatException, IOException {
            m1270Ooo();
            this.f701Ooo.setInput(bArr, i, i2);
            if (this.f700O8 == null) {
                this.f700O8 = new byte[65536];
            }
            while (!this.f701Ooo.finished()) {
                try {
                    int iInflate = this.f701Ooo.inflate(this.f700O8);
                    if (iInflate == 0) {
                        return;
                    }
                    this.f699O8oO888.mo1196O8oO888(this.f700O8, 0, iInflate);
                    this.f703oO += iInflate;
                } catch (DataFormatException e) {
                    throw new IOException("Failed to inflate data", e);
                }
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            this.Oo0 = true;
            this.f702o0o0 = null;
            this.f700O8 = null;
            Inflater inflater = this.f701Ooo;
            if (inflater != null) {
                inflater.end();
                this.f701Ooo = null;
            }
        }
    }

    private o0o0(String str, int i, ByteBuffer byteBuffer, long j, long j2, int i2, long j3, boolean z, long j4) {
        this.f695oo0OOO8 = str;
        this.f691O80Oo0O = i;
        this.Oo = byteBuffer;
        this.f694o0o8 = j;
        this.f692Oo8ooOo = j2;
        this.f693Oo = i2;
        this.f69680 = j3;
        this.f697O8O00oo = z;
        this.f698oO00O = j4;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private long m1256O8oO888(O8 o8, Ooo ooo) throws IOException {
        long j = this.f692Oo8ooOo;
        o8.mo1201O8oO888(this.f694o0o8, j, ooo);
        return j;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private long m1257O8oO888(O8 o8, ByteBuffer byteBuffer, Ooo ooo) throws IOException {
        long j = this.f694o0o8;
        int i = this.f691O80Oo0O + 30;
        int iRemaining = byteBuffer.remaining();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i + iRemaining);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        o8.mo1200O8oO888(j, i, byteBufferAllocate);
        byteBufferAllocate.put(byteBuffer.slice());
        byteBufferAllocate.flip();
        Oo0.m1243O8oO888(byteBufferAllocate, 28, iRemaining);
        long jRemaining = byteBufferAllocate.remaining();
        ooo.mo1195O8oO888(byteBufferAllocate);
        long j2 = this.f692Oo8ooOo;
        int i2 = this.f693Oo;
        long j3 = j2 - i2;
        o8.mo1201O8oO888(j + i2, j3, ooo);
        return jRemaining + j3;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static long m1258O8oO888(String str, int i, int i2, byte[] bArr, long j, long j2, Ooo ooo) throws IOException {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 30);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(f681O8oO888);
        Oo0.m1250Ooo(byteBufferAllocate, 20);
        byteBufferAllocate.putShort(Oo0.f670o0o0);
        byteBufferAllocate.putShort((short) 8);
        Oo0.m1250Ooo(byteBufferAllocate, i);
        Oo0.m1250Ooo(byteBufferAllocate, i2);
        Oo0.m1245O8oO888(byteBufferAllocate, j);
        Oo0.m1245O8oO888(byteBufferAllocate, bArr.length);
        Oo0.m1245O8oO888(byteBufferAllocate, j2);
        Oo0.m1250Ooo(byteBufferAllocate, bytes.length);
        Oo0.m1250Ooo(byteBufferAllocate, 0);
        byteBufferAllocate.put(bytes);
        if (byteBufferAllocate.hasRemaining()) {
            throw new RuntimeException("pos: " + byteBufferAllocate.position() + ", limit: " + byteBufferAllocate.limit());
        }
        byteBufferAllocate.flip();
        long jRemaining = byteBufferAllocate.remaining();
        ooo.mo1195O8oO888(byteBufferAllocate);
        long length = jRemaining + bArr.length;
        ooo.mo1196O8oO888(bArr, 0, bArr.length);
        return length;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static o0o0 m1259O8oO888(O8 o8, com.netease.htprotect.p024.p026Ooo.O8oO888 o8oO888, long j, boolean z, boolean z2) throws O, IOException {
        O8 o82;
        ByteBuffer byteBufferMo1199O8oO888;
        long j2;
        String strM1231O8oO888 = o8oO888.m1231O8oO888();
        int iM1234Ooo = o8oO888.m1234Ooo();
        int i = iM1234Ooo + 30;
        long jM1237o0O0O = o8oO888.m1237o0O0O();
        long j3 = i + jM1237o0O0O;
        if (j3 > j) {
            throw new O("Local File Header of " + strM1231O8oO888 + " extends beyond start of Central Directory. LFH end: " + j3 + ", CD start: " + j);
        }
        try {
            ByteBuffer byteBufferMo1199O8oO8882 = o8.mo1199O8oO888(jM1237o0O0O, i);
            byteBufferMo1199O8oO8882.order(ByteOrder.LITTLE_ENDIAN);
            int i2 = byteBufferMo1199O8oO8882.getInt();
            if (i2 != f681O8oO888) {
                throw new O("Not a Local File Header record for entry " + strM1231O8oO888 + ". Signature: 0x" + Long.toHexString(i2 & C00oOOo.f362O8oO888));
            }
            int i3 = byteBufferMo1199O8oO8882.getShort(6) & 8;
            boolean z3 = i3 != 0;
            boolean z4 = (o8oO888.m1233O8() & 8) != 0;
            if (z3 != z4) {
                throw new O("Data Descriptor presence mismatch between Local File Header and Central Directory for entry " + strM1231O8oO888 + ". LFH: " + z3 + ", CD: " + z4);
            }
            long jM1236oO = o8oO888.m1236oO();
            long jOo0 = o8oO888.Oo0();
            long jM1232O = o8oO888.m1232O();
            if (!z3) {
                long jM1248O8 = Oo0.m1248O8(byteBufferMo1199O8oO8882, 14);
                if (jM1248O8 != jM1236oO) {
                    throw new O("CRC-32 mismatch between Local File Header and Central Directory for entry " + strM1231O8oO888 + ". LFH: " + jM1248O8 + ", CD: " + jM1236oO);
                }
                long jM1248O82 = Oo0.m1248O8(byteBufferMo1199O8oO8882, 18);
                if (jM1248O82 != jOo0) {
                    throw new O("Compressed size mismatch between Local File Header and Central Directory for entry " + strM1231O8oO888 + ". LFH: " + jM1248O82 + ", CD: " + jOo0);
                }
                long jM1248O83 = Oo0.m1248O8(byteBufferMo1199O8oO8882, 22);
                if (jM1248O83 != jM1232O) {
                    throw new O("Uncompressed size mismatch between Local File Header and Central Directory for entry " + strM1231O8oO888 + ". LFH: " + jM1248O83 + ", CD: " + jM1232O);
                }
            }
            int iM1239O8oO888 = Oo0.m1239O8oO888(byteBufferMo1199O8oO8882, 26);
            if (iM1239O8oO888 > iM1234Ooo) {
                throw new O("Name mismatch between Local File Header and Central Directory for entry" + strM1231O8oO888 + ". LFH: " + iM1239O8oO888 + " bytes, CD: " + iM1234Ooo + " bytes");
            }
            String strM1226O8oO888 = com.netease.htprotect.p024.p026Ooo.O8oO888.m1226O8oO888(byteBufferMo1199O8oO8882, 30, iM1239O8oO888);
            if (!strM1231O8oO888.equals(strM1226O8oO888)) {
                throw new O("Name mismatch between Local File Header and Central Directory. LFH: \"" + strM1226O8oO888 + "\", CD: \"" + strM1231O8oO888 + "\"");
            }
            int iM1239O8oO8882 = Oo0.m1239O8oO888(byteBufferMo1199O8oO8882, 28);
            long j4 = jM1237o0O0O + 30 + iM1239O8oO888;
            long j5 = iM1239O8oO8882 + j4;
            boolean z5 = o8oO888.m1235o0o0() != 0;
            long j6 = z5 ? jOo0 : jM1232O;
            long j7 = j5 + j6;
            if (j7 > j) {
                throw new O("Local File Header data of " + strM1231O8oO888 + " overlaps with Central Directory. LFH data start: " + j5 + ", LFH data end: " + j7 + ", CD start: " + j);
            }
            ByteBuffer byteBuffer = o8o0;
            if (!z || iM1239O8oO8882 <= 0) {
                o82 = o8;
                byteBufferMo1199O8oO888 = byteBuffer;
            } else {
                o82 = o8;
                byteBufferMo1199O8oO888 = o82.mo1199O8oO888(j4, iM1239O8oO8882);
            }
            if (!z2 || i3 == 0) {
                j2 = jM1232O;
            } else {
                long j8 = 12 + j7;
                j2 = jM1232O;
                if (j8 > j) {
                    throw new O("Data Descriptor of " + strM1231O8oO888 + " overlaps with Central Directory. Data Descriptor end: " + j7 + ", CD start: " + j);
                }
                ByteBuffer byteBufferMo1199O8oO8883 = o82.mo1199O8oO888(j7, 4);
                byteBufferMo1199O8oO8883.order(ByteOrder.LITTLE_ENDIAN);
                if (byteBufferMo1199O8oO8883.getInt() == f682OO8) {
                    j8 += 4;
                    if (j8 > j) {
                        throw new O("Data Descriptor of " + strM1231O8oO888 + " overlaps with Central Directory. Data Descriptor end: " + j7 + ", CD start: " + j);
                    }
                }
                j7 = j8;
            }
            return new o0o0(strM1231O8oO888, iM1234Ooo, byteBufferMo1199O8oO888, jM1237o0O0O, j7 - jM1237o0O0O, iM1239O8oO888 + 30 + iM1239O8oO8882, j6, z5, j2);
        } catch (IOException e) {
            throw new IOException("Failed to read Local File Header of ".concat(String.valueOf(strM1231O8oO888)), e);
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private String m1260O8oO888() {
        return this.f695oo0OOO8;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static void m1261O8oO888(O8 o8, com.netease.htprotect.p024.p026Ooo.O8oO888 o8oO888, long j, Ooo ooo) throws O, IOException {
        o0o0 o0o0VarM1259O8oO888 = m1259O8oO888(o8, o8oO888, j, false, false);
        long j2 = o0o0VarM1259O8oO888.f694o0o8 + o0o0VarM1259O8oO888.f693Oo;
        try {
            if (!o0o0VarM1259O8oO888.f697O8O00oo) {
                o8.mo1201O8oO888(j2, o0o0VarM1259O8oO888.f69680, ooo);
                return;
            }
            try {
                O8oO888 o8oO8882 = new O8oO888(ooo, (byte) 0);
                try {
                    o8.mo1201O8oO888(j2, o0o0VarM1259O8oO888.f69680, o8oO8882);
                    long jM1271O8oO888 = o8oO8882.m1271O8oO888();
                    if (jM1271O8oO888 != o0o0VarM1259O8oO888.f698oO00O) {
                        throw new O("Unexpected size of uncompressed data of " + o0o0VarM1259O8oO888.f695oo0OOO8 + ". Expected: " + o0o0VarM1259O8oO888.f698oO00O + " bytes, actual: " + jM1271O8oO888 + " bytes");
                    }
                    o8oO8882.close();
                } finally {
                }
            } catch (IOException e) {
                if (!(e.getCause() instanceof DataFormatException)) {
                    throw e;
                }
                throw new O("Data of entry " + o0o0VarM1259O8oO888.f695oo0OOO8 + " malformed", e);
            }
        } catch (IOException e2) {
            throw new IOException("Failed to read data of " + (o0o0VarM1259O8oO888.f697O8O00oo ? "compressed" : "uncompressed") + " entry " + o0o0VarM1259O8oO888.f695oo0OOO8, e2);
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static byte[] m1262O8oO888(O8 o8, com.netease.htprotect.p024.p026Ooo.O8oO888 o8oO888, long j) throws O, IOException {
        if (o8oO888.m1232O() > 2147483647L) {
            throw new IOException(o8oO888.m1231O8oO888() + " too large: " + o8oO888.m1232O());
        }
        byte[] bArr = new byte[(int) o8oO888.m1232O()];
        m1261O8oO888(o8, o8oO888, j, new com.netease.htprotect.p024.p025O8oO888.O8oO888(ByteBuffer.wrap(bArr)));
        return bArr;
    }

    private long Oo0() {
        return this.f692Oo8ooOo;
    }

    /* renamed from: 〇O, reason: contains not printable characters */
    private boolean m1263O() {
        return this.f697O8O00oo;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private int m1264O8() {
        return this.f691O80Oo0O + 30;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static o0o0 m1265Ooo(O8 o8, com.netease.htprotect.p024.p026Ooo.O8oO888 o8oO888, long j) throws O, IOException {
        return m1259O8oO888(o8, o8oO888, j, true, true);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private ByteBuffer m1266Ooo() {
        return this.Oo.capacity() > 0 ? this.Oo.slice() : this.Oo;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private void m1267Ooo(O8 o8, Ooo ooo) throws O, IOException {
        long j = this.f694o0o8 + this.f693Oo;
        try {
            if (!this.f697O8O00oo) {
                o8.mo1201O8oO888(j, this.f69680, ooo);
                return;
            }
            try {
                O8oO888 o8oO888 = new O8oO888(ooo, (byte) 0);
                try {
                    o8.mo1201O8oO888(j, this.f69680, o8oO888);
                    long jM1271O8oO888 = o8oO888.m1271O8oO888();
                    if (jM1271O8oO888 != this.f698oO00O) {
                        throw new O("Unexpected size of uncompressed data of " + this.f695oo0OOO8 + ". Expected: " + this.f698oO00O + " bytes, actual: " + jM1271O8oO888 + " bytes");
                    }
                    o8oO888.close();
                } finally {
                }
            } catch (IOException e) {
                if (!(e.getCause() instanceof DataFormatException)) {
                    throw e;
                }
                throw new O("Data of entry " + this.f695oo0OOO8 + " malformed", e);
            }
        } catch (IOException e2) {
            throw new IOException("Failed to read data of " + (this.f697O8O00oo ? "compressed" : "uncompressed") + " entry " + this.f695oo0OOO8, e2);
        }
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private long m1268o0o0() {
        return this.f694o0o8;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private int m1269oO() {
        return this.f693Oo;
    }
}
