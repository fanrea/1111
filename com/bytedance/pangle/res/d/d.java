package com.bytedance.pangle.res.d;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static final Logger an = Logger.getLogger(d.class.getName());
    private final h b;
    private final u c;
    private final byte[] d;
    private final gb hc;
    private C0256d u;

    public d(byte[] bArr, gb gbVar) {
        u uVar = new u(new ByteArrayInputStream(bArr));
        this.c = uVar;
        this.b = new h(new tt(uVar));
        this.d = bArr;
        this.hc = gbVar;
    }

    public void d() throws IOException {
        b(2);
        int i = this.b.readInt();
        mq.d(this.b);
        mk();
        for (int i2 = 0; i2 < i; i2++) {
            hc();
        }
    }

    private void hc() throws IOException {
        hc(512);
        this.b.readInt();
        this.b.skipBytes(256);
        this.b.d();
        this.b.d();
        this.b.d();
        this.b.d();
        if (this.u.hc == 288 && this.b.readInt() > 0) {
            throw new RuntimeException("don't support");
        }
        mq.d(this.b);
        mq.d(this.b);
        mk();
        boolean z = true;
        while (z) {
            short s = this.u.d;
            if (s == 514) {
                c();
            } else if (s != 515) {
                z = false;
            } else {
                b();
            }
        }
    }

    private void b() throws IOException {
        hc(515);
        int i = this.b.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.b.readInt();
            this.b.skipBytes(256);
        }
        while (mk().d == 513) {
            c();
        }
    }

    private void c() throws IOException {
        u();
        short s = mk().d;
        while (s == 514) {
            u();
            s = mk().d;
        }
        while (s == 513) {
            an();
            if (this.c.d() < this.u.u) {
                an.warning("Unknown data detected. Skipping: " + (this.u.u - this.c.d()) + " byte(s)");
                this.c.skip(this.u.u - this.c.d());
            }
            s = mk().d;
        }
    }

    private void u() throws IOException {
        hc(514);
        this.b.readUnsignedByte();
        this.b.skipBytes(3);
        this.b.skipBytes(this.b.readInt() * 4);
    }

    private void an() throws IOException {
        hc(513);
        this.b.readUnsignedByte();
        this.b.readByte();
        this.b.skipBytes(2);
        int i = this.b.readInt();
        int i2 = this.b.readInt();
        tc();
        int i3 = (this.u.c + i2) - (i * 4);
        if (i3 != this.c.d()) {
            an.warning("Invalid data detected. Skipping: " + (i3 - this.c.d()) + " byte(s)");
            this.b.skipBytes(i3 - this.c.d());
        }
        int[] iArrD = this.b.d(i);
        HashSet hashSet = new HashSet();
        for (int i4 : iArrD) {
            if (i4 != -1 && !hashSet.contains(Integer.valueOf(i4))) {
                h();
                hashSet.add(Integer.valueOf(i4));
            }
        }
    }

    private void h() throws IOException {
        if (this.b.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short s = this.b.readShort();
        this.b.readInt();
        if ((s & 1) == 0) {
            tt();
        } else {
            gb();
        }
    }

    private void gb() throws IOException {
        int iD = mk.d(this.b);
        mk.d(this.d, this.b.readInt(), iD, this.hc);
        int i = this.b.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            int iD2 = mk.d(this.b);
            mk.d(this.d, this.b.readInt(), iD2, this.hc);
            tt();
        }
    }

    private void tt() throws IOException {
        this.b.d((short) 8);
        this.b.d((byte) 0);
        byte b = this.b.readByte();
        int iD = mk.d(this.b);
        int i = this.b.readInt();
        if (b == 1) {
            mk.d(this.d, i, iD, this.hc);
        }
        if (b == 2) {
            mk.d(this.d, i, iD, this.hc);
        }
    }

    private void tc() throws IOException {
        int i = this.b.readInt();
        int i2 = 28;
        if (i < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.b.readShort();
        this.b.readShort();
        this.b.readByte();
        this.b.readByte();
        this.b.readByte();
        this.b.readByte();
        this.b.readByte();
        this.b.readByte();
        this.b.readUnsignedShort();
        this.b.readByte();
        this.b.readByte();
        this.b.readByte();
        this.b.skipBytes(1);
        this.b.readShort();
        this.b.readShort();
        this.b.readShort();
        this.b.skipBytes(2);
        if (i >= 32) {
            this.b.readByte();
            this.b.readByte();
            this.b.readShort();
            i2 = 32;
        }
        if (i >= 36) {
            this.b.readShort();
            this.b.readShort();
            i2 = 36;
        }
        if (i >= 48) {
            d(4).toCharArray();
            d(8).toCharArray();
            i2 = 48;
        }
        if (i >= 52) {
            this.b.readByte();
            this.b.readByte();
            this.b.skipBytes(2);
            i2 = 52;
        }
        if (i >= 56) {
            this.b.skipBytes(4);
            i2 = 56;
        }
        int i3 = i - 56;
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            i2 += i3;
            this.b.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                an.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                an.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(i), bigInteger));
            }
        }
        int i4 = i - i2;
        if (i4 > 0) {
            this.b.skipBytes(i4);
        }
    }

    private String d(int i) throws IOException {
        int i2;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || this.b.readByte() == 0) {
                break;
            }
            sb.append((char) s);
            i = i2;
        }
        this.b.skipBytes(i2);
        return sb.toString();
    }

    private C0256d mk() throws IOException {
        C0256d c0256dD = C0256d.d(this.b, this.c);
        this.u = c0256dD;
        return c0256dD;
    }

    private void hc(int i) {
        if (this.u.d != i) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.u.d)));
        }
    }

    private void b(int i) throws IOException {
        mk();
        hc(i);
    }

    /* renamed from: com.bytedance.pangle.res.d.d$d, reason: collision with other inner class name */
    public static class C0256d {
        public final int b;
        public final int c;
        public final short d;
        public final int hc;
        public final int u;

        public C0256d(short s, int i, int i2, int i3) {
            this.d = s;
            this.hc = i;
            this.b = i2;
            this.c = i3;
            this.u = i3 + i2;
        }

        public static C0256d d(h hVar, u uVar) throws IOException {
            int iD = uVar.d();
            try {
                return new C0256d(hVar.readShort(), hVar.readShort(), hVar.readInt(), iD);
            } catch (EOFException unused) {
                return new C0256d((short) -1, 0, 0, uVar.d());
            }
        }
    }
}
