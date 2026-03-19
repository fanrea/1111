package com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888;

import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import com.netease.htprotect.p020oO.p021O8oO888.p022O8oO888.O8;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Oo0 implements O8, Closeable {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private final int f542O8oO888 = 1179403647;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private final FileChannel f543Ooo;

    public Oo0(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f543Ooo = new FileInputStream(file).getChannel();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static long m1099O8oO888(O8.Ooo ooo, long j, long j2) throws IOException {
        for (long j3 = 0; j3 < j; j3++) {
            O8.AbstractC0683O8 abstractC0683O8Mo1109O8oO888 = ooo.mo1109O8oO888(j3);
            if (abstractC0683O8Mo1109O8oO888.f551O8 == 1 && abstractC0683O8Mo1109O8oO888.f553oO <= j2 && j2 <= abstractC0683O8Mo1109O8oO888.f553oO + abstractC0683O8Mo1109O8oO888.Oo0) {
                return (j2 - abstractC0683O8Mo1109O8oO888.f553oO) + abstractC0683O8Mo1109O8oO888.f552o0o0;
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m1100O8oO888(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < i) {
            int i2 = this.f543Ooo.read(byteBuffer, j + j2);
            if (i2 == -1) {
                throw new EOFException();
            }
            j2 += i2;
        }
        byteBuffer.position(0);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private O8.Ooo m1101Ooo() throws IOException {
        this.f543Ooo.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (m1107Ooo(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sM1103oO = m1103oO(byteBufferAllocate, 4L);
        boolean z = m1103oO(byteBufferAllocate, 5L) == 2;
        if (sM1103oO == 1) {
            return new o0o0(z, this);
        }
        if (sM1103oO == 2) {
            return new oO(z, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private String m1102o0o0(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short sM1103oO = m1103oO(byteBuffer, j);
            if (sM1103oO == 0) {
                return sb.toString();
            }
            sb.append((char) sM1103oO);
            j = j2;
        }
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private short m1103oO(ByteBuffer byteBuffer, long j) throws IOException {
        m1100O8oO888(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    protected final long m1104O8oO888(ByteBuffer byteBuffer, long j) throws IOException {
        m1100O8oO888(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final List m1105O8oO888() throws IOException {
        O8.Ooo oOVar;
        long j;
        long j2;
        O8.O8oO888 o8oO888Mo1108O8oO888;
        long j3;
        this.f543Ooo.position(0L);
        ArrayList arrayList = new ArrayList();
        this.f543Ooo.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (m1107Ooo(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sM1103oO = m1103oO(byteBufferAllocate, 4L);
        boolean z = m1103oO(byteBufferAllocate, 5L) == 2;
        if (sM1103oO == 1) {
            oOVar = new o0o0(z, this);
        } else {
            if (sM1103oO != 2) {
                throw new IllegalStateException("Invalid class type!");
            }
            oOVar = new oO(z, this);
        }
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(8);
        byteBufferAllocate2.order(oOVar.f561o0o0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j4 = oOVar.f564;
        if (j4 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j4 = oOVar.mo1110O8oO888().f565O8oO888;
        }
        long j5 = 0;
        while (true) {
            if (j5 >= j4) {
                j = j4;
                j2 = 0;
                break;
            }
            O8.AbstractC0683O8 abstractC0683O8Mo1109O8oO888 = oOVar.mo1109O8oO888(j5);
            j = j4;
            if (abstractC0683O8Mo1109O8oO888.f551O8 == 2) {
                j2 = abstractC0683O8Mo1109O8oO888.f552o0o0;
                break;
            }
            j5++;
            j4 = j;
        }
        if (j2 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j6 = 0;
        int i = 0;
        do {
            o8oO888Mo1108O8oO888 = oOVar.mo1108O8oO888(j2, i);
            if (o8oO888Mo1108O8oO888.f547o0o0 == 1) {
                arrayList2.add(Long.valueOf(o8oO888Mo1108O8oO888.f548oO));
                j3 = 5;
            } else {
                j3 = 5;
                if (o8oO888Mo1108O8oO888.f547o0o0 == 5) {
                    j6 = o8oO888Mo1108O8oO888.f548oO;
                }
            }
            i++;
        } while (o8oO888Mo1108O8oO888.f547o0o0 != 0);
        if (j6 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jM1099O8oO888 = m1099O8oO888(oOVar, j, j6);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(m1102o0o0(byteBufferAllocate2, ((Long) it.next()).longValue() + jM1099O8oO888));
        }
        return arrayList;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f543Ooo.close();
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    protected final int m1106O8(ByteBuffer byteBuffer, long j) throws IOException {
        m1100O8oO888(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    protected final long m1107Ooo(ByteBuffer byteBuffer, long j) throws IOException {
        m1100O8oO888(byteBuffer, j, 4);
        return byteBuffer.getInt() & C00oOOo.f362O8oO888;
    }
}
