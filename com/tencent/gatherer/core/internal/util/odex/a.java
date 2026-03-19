package com.tencent.gatherer.core.internal.util.odex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class a {

    /* compiled from: A */
    /* renamed from: com.tencent.gatherer.core.internal.util.odex.a$a, reason: collision with other inner class name */
    static class C0801a implements c {
        private byte[] b;
        int c = 0;
        private d d;
        private byte[] e;

        /* compiled from: A */
        /* renamed from: com.tencent.gatherer.core.internal.util.odex.a$a$a, reason: collision with other inner class name */
        class C0802a implements d {
            private short a = e();
            private short b = e();
            private int c;
            private short d;
            private short e;
            private short f;
            private g[] g;

            /* compiled from: A */
            /* renamed from: com.tencent.gatherer.core.internal.util.odex.a$a$a$a, reason: collision with other inner class name */
            class C0803a extends g {
                final /* synthetic */ C0801a c;
                final /* synthetic */ int d;

                C0803a(C0801a c0801a, int i) {
                    this.c = c0801a;
                    this.d = i;
                }

                @Override // com.tencent.gatherer.core.internal.util.odex.g
                public Object a() {
                    return C0802a.this.new b(this.d);
                }
            }

            /* compiled from: A */
            /* renamed from: com.tencent.gatherer.core.internal.util.odex.a$a$a$b */
            class b implements e {
                private int a;
                private int b;
                private int c;
                private int d;
                private int e;
                private g[] f;
                private g g;

                /* compiled from: A */
                /* renamed from: com.tencent.gatherer.core.internal.util.odex.a$a$a$b$a, reason: collision with other inner class name */
                class C0804a extends g {
                    final /* synthetic */ C0802a c;
                    final /* synthetic */ int d;
                    final /* synthetic */ int e;

                    C0804a(C0802a c0802a, int i, int i2) {
                        this.c = c0802a;
                        this.d = i;
                        this.e = i2;
                    }

                    @Override // com.tencent.gatherer.core.internal.util.odex.g
                    public Object a() {
                        return C0802a.this.new c(this.d, this.e);
                    }
                }

                b(int i) throws com.tencent.gatherer.core.internal.util.odex.b {
                    C0802a.this.b(i);
                    this.a = C0802a.this.d();
                    this.b = C0802a.this.d();
                    C0802a.this.b(C0802a.this.f() + 8);
                    this.c = C0802a.this.d();
                    this.d = C0802a.this.d();
                    this.e = C0802a.this.d();
                    C0802a.this.b(C0802a.this.f() + 12);
                    int i2 = this.b;
                    if (i2 != 2) {
                        if (i2 == 3) {
                            this.g = new C0804a(C0802a.this, this.c, this.d);
                            return;
                        } else if (i2 != 11) {
                            return;
                        }
                    }
                    this.f = new g[this.d / this.e];
                }

                @Override // com.tencent.gatherer.core.internal.util.odex.e
                public int a() {
                    return this.c;
                }

                @Override // com.tencent.gatherer.core.internal.util.odex.e
                public f b() {
                    g gVar = this.g;
                    if (gVar != null) {
                        return (f) gVar.b();
                    }
                    return null;
                }

                @Override // com.tencent.gatherer.core.internal.util.odex.e
                public int c() {
                    return this.d;
                }

                @Override // com.tencent.gatherer.core.internal.util.odex.e
                public String d() {
                    if (this.a == 0) {
                        return null;
                    }
                    return C0801a.this.a().b().get(this.a);
                }
            }

            /* compiled from: A */
            /* renamed from: com.tencent.gatherer.core.internal.util.odex.a$a$a$c */
            class c implements f {
                private byte[] a;
                private int b;

                c(int i, int i2) throws com.tencent.gatherer.core.internal.util.odex.b {
                    C0802a.this.b(i);
                    byte[] bArr = new byte[i2];
                    this.a = bArr;
                    int iA = C0802a.this.a(bArr);
                    if (iA != i2) {
                        throw new com.tencent.gatherer.core.internal.util.odex.b("Error reading string table (read " + iA + "bytes, expected to read " + this.a.length + "bytes).");
                    }
                    int i3 = 0;
                    this.b = 0;
                    while (true) {
                        byte[] bArr2 = this.a;
                        if (i3 >= bArr2.length) {
                            return;
                        }
                        if (bArr2[i3] == 0) {
                            this.b++;
                        }
                        i3++;
                    }
                }

                @Override // com.tencent.gatherer.core.internal.util.odex.f
                public String get(int i) {
                    int i2 = i;
                    while (true) {
                        byte[] bArr = this.a;
                        if (bArr[i2] == 0) {
                            return new String(bArr, i, i2 - i);
                        }
                        i2++;
                    }
                }
            }

            C0802a() throws com.tencent.gatherer.core.internal.util.odex.b {
                b(f() + 12);
                this.c = d();
                b(f() + 10);
                this.d = e();
                this.e = e();
                this.f = e();
                this.g = new g[this.e];
                for (int i = 0; i < this.e; i++) {
                    com.tencent.gatherer.core.internal.util.d.a("i: " + i + ", sh_offset:" + this.c + ", sh_entry_size:" + ((int) this.d));
                    this.g[i] = new C0803a(C0801a.this, this.c + (this.d * i));
                }
            }

            public e a(int i) {
                return (e) this.g[i].b();
            }

            @Override // com.tencent.gatherer.core.internal.util.odex.d
            public f b() {
                return a(this.f).b();
            }

            public short c() {
                return this.e;
            }

            int f() {
                return C0801a.this.c;
            }

            void b(int i) {
                int length = C0801a.this.b.length;
                C0801a.this.c = i;
            }

            int d() {
                byte[] bArr = new byte[4];
                a(bArr);
                return a(bArr, ByteOrder.LITTLE_ENDIAN);
            }

            short e() {
                byte[] bArr = new byte[2];
                a(bArr);
                return b(bArr, ByteOrder.LITTLE_ENDIAN);
            }

            @Override // com.tencent.gatherer.core.internal.util.odex.d
            public byte[] a() {
                byte[] bArr = new byte[0];
                for (int i = 1; i < c(); i++) {
                    e eVarA = a(i);
                    if (".rodata".equals(eVarA.d())) {
                        int iA = eVarA.a();
                        int iC = eVarA.c();
                        byte[] bArr2 = new byte[iC];
                        System.arraycopy(C0801a.this.b, iA, bArr2, 0, iC);
                        bArr = bArr2;
                    }
                }
                return bArr;
            }

            public short b(byte[] bArr, ByteOrder byteOrder) {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                byteBufferWrap.order(byteOrder);
                return byteBufferWrap.getShort();
            }

            int a(byte[] bArr) {
                int length = C0801a.this.b.length - C0801a.this.c;
                if (length < 1) {
                    return length;
                }
                int iMin = Math.min(length, bArr.length);
                System.arraycopy(C0801a.this.b, C0801a.this.c, bArr, 0, iMin);
                C0801a.this.c += iMin;
                return iMin;
            }

            private int a(byte[] bArr, ByteOrder byteOrder) {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                byteBufferWrap.order(byteOrder);
                return byteBufferWrap.getInt();
            }
        }

        C0801a(byte[] bArr) throws b {
            byte[] bArr2 = new byte[16];
            this.e = bArr2;
            this.b = bArr;
            int iA = a(bArr2);
            if (iA == this.e.length) {
                if (!Arrays.equals(b(), c.a)) {
                    throw new b("Bad magic number for file.");
                }
                this.d = new C0802a();
            } else {
                throw new b("Error reading elf header (read " + iA + "bytes, expected to read " + this.e.length + "bytes).");
            }
        }

        public byte[] b() {
            byte[] bArr = this.e;
            return new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]};
        }

        int a(byte[] bArr) {
            int iMin = Math.min(this.b.length - this.c, bArr.length);
            System.arraycopy(this.b, this.c, bArr, 0, iMin);
            this.c += iMin;
            return iMin;
        }

        @Override // com.tencent.gatherer.core.internal.util.odex.c
        public d a() {
            return this.d;
        }
    }

    public static c a(byte[] bArr) throws b {
        return new C0801a(bArr);
    }
}
