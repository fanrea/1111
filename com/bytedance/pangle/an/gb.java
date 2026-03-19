package com.bytedance.pangle.an;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb implements Closeable {
    private hc[] b;
    private b[] c;
    private final FileInputStream d;
    private d hc;
    private final Map<String, b> u = new HashMap();

    public static boolean d(File file) throws IOException {
        try {
            com.bytedance.pangle.util.h.d(new gb(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.h.d((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.h.d((Closeable) null);
            throw th;
        }
    }

    private gb(File file) throws IOException {
        this.hc = null;
        this.b = null;
        this.c = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.d = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.hc = new d(channel);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
        byteBufferAllocate.limit(this.hc.tc);
        byteBufferAllocate.order(this.hc.d[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.hc.an);
        this.b = new hc[this.hc.mk];
        for (int i = 0; i < this.b.length; i++) {
            hc(channel, byteBufferAllocate, "failed to read phdr.");
            this.b[i] = new hc(byteBufferAllocate, this.hc.d[4]);
        }
        channel.position(this.hc.h);
        byteBufferAllocate.limit(this.hc.mq);
        this.c = new b[this.hc.uo];
        for (int i2 = 0; i2 < this.c.length; i2++) {
            hc(channel, byteBufferAllocate, "failed to read shdr.");
            this.c[i2] = new b(byteBufferAllocate, this.hc.d[4]);
        }
        if (this.hc.k > 0) {
            ByteBuffer byteBufferD = d(this.c[this.hc.k]);
            for (b bVar : this.c) {
                byteBufferD.position(bVar.d);
                bVar.mk = d(byteBufferD);
                this.u.put(bVar.mk, bVar);
            }
        }
    }

    private static String d(ByteBuffer byteBuffer) {
        byte[] bArrArray = byteBuffer.array();
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && bArrArray[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(bArrArray, iPosition, (byteBuffer.position() - iPosition) - 1, Charset.forName("ASCII"));
    }

    private ByteBuffer d(b bVar) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) bVar.an);
        this.d.getChannel().position(bVar.u);
        hc(this.d.getChannel(), byteBufferAllocate, "failed to read section: " + bVar.mk);
        return byteBufferAllocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int i = fileChannel.read(byteBuffer);
        if (i != byteBuffer.limit()) {
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + i + " bytes were read.");
        }
        byteBuffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(int i, int i2, int i3, String str) throws IOException {
        if (i < i2 || i > i3) {
            throw new IOException(str);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
        this.u.clear();
        this.b = null;
        this.c = null;
    }

    private static class d {
        public final long an;
        public final short b;
        public final int c;
        public final byte[] d;
        public final int gb;
        public final long h;
        public final short hc;
        public final short k;
        public final short mk;
        public final short mq;
        public final short tc;
        public final short tt;
        public final long u;
        public final short uo;

        private d(FileChannel fileChannel) throws IOException {
            byte[] bArr = new byte[16];
            this.d = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == 127 && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                gb.hc(bArr[4], 1, 2, "bad elf class: " + ((int) bArr[4]));
                gb.hc(bArr[5], 1, 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                byteBufferAllocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                gb.hc(fileChannel, byteBufferAllocate, "failed to read rest part of ehdr.");
                this.hc = byteBufferAllocate.getShort();
                this.b = byteBufferAllocate.getShort();
                int i = byteBufferAllocate.getInt();
                this.c = i;
                gb.hc(i, 1, 1, "bad elf version: " + i);
                byte b = bArr[4];
                if (b == 1) {
                    this.u = byteBufferAllocate.getInt();
                    this.an = byteBufferAllocate.getInt();
                    this.h = byteBufferAllocate.getInt();
                } else if (b == 2) {
                    this.u = byteBufferAllocate.getLong();
                    this.an = byteBufferAllocate.getLong();
                    this.h = byteBufferAllocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.gb = byteBufferAllocate.getInt();
                this.tt = byteBufferAllocate.getShort();
                this.tc = byteBufferAllocate.getShort();
                this.mk = byteBufferAllocate.getShort();
                this.mq = byteBufferAllocate.getShort();
                this.uo = byteBufferAllocate.getShort();
                this.k = byteBufferAllocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    private static class hc {
        public final long an;
        public final long b;
        public final long c;
        public final int d;
        public final long gb;
        public final long h;
        public final int hc;
        public final long u;

        private hc(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.d = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.u = byteBuffer.getInt();
                this.an = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                this.hc = byteBuffer.getInt();
                this.gb = byteBuffer.getInt();
                return;
            }
            if (i == 2) {
                this.d = byteBuffer.getInt();
                this.hc = byteBuffer.getInt();
                this.b = byteBuffer.getLong();
                this.c = byteBuffer.getLong();
                this.u = byteBuffer.getLong();
                this.an = byteBuffer.getLong();
                this.h = byteBuffer.getLong();
                this.gb = byteBuffer.getLong();
                return;
            }
            throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
        }
    }

    private static class b {
        public final long an;
        public final long b;
        public final long c;
        public final int d;
        public final int gb;
        public final int h;
        public final int hc;
        public String mk;
        public final long tc;
        public final long tt;
        public final long u;

        private b(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.d = byteBuffer.getInt();
                this.hc = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.u = byteBuffer.getInt();
                this.an = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                this.gb = byteBuffer.getInt();
                this.tt = byteBuffer.getInt();
                this.tc = byteBuffer.getInt();
            } else if (i == 2) {
                this.d = byteBuffer.getInt();
                this.hc = byteBuffer.getInt();
                this.b = byteBuffer.getLong();
                this.c = byteBuffer.getLong();
                this.u = byteBuffer.getLong();
                this.an = byteBuffer.getLong();
                this.h = byteBuffer.getInt();
                this.gb = byteBuffer.getInt();
                this.tt = byteBuffer.getLong();
                this.tc = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.mk = null;
        }
    }
}
