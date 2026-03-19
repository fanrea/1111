package com.getkeepsafe.relinker.a;

import com.getkeepsafe.relinker.a.c;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class f implements c, Closeable {
    private final int MAGIC = 1179403647;
    private final FileChannel xE;

    public f(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.xE = new FileInputStream(file).getChannel();
    }

    private c.b fP() throws IOException {
        this.xE.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (c(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sE = e(byteBufferAllocate, 4L);
        boolean z = e(byteBufferAllocate, 5L) == 2;
        if (sE == 1) {
            return new d(z, this);
        }
        if (sE == 2) {
            return new e(z, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    public final List<String> fQ() throws IOException {
        long j;
        this.xE.position(0L);
        ArrayList arrayList = new ArrayList();
        c.b bVarFP = fP();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bVarFP.xr ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = bVarFP.xv;
        int i = 0;
        if (j2 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j2 = bVarFP.br(0).xC;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            c.AbstractC0388c abstractC0388cJ = bVarFP.j(j3);
            if (abstractC0388cJ.xz == 2) {
                j = abstractC0388cJ.offset;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j4 = 0;
        while (true) {
            c.a aVarA = bVarFP.a(j, i);
            long j5 = j;
            if (aVarA.xp == 1) {
                arrayList2.add(Long.valueOf(aVarA.xq));
            } else if (aVarA.xp == 5) {
                j4 = aVarA.xq;
            }
            i++;
            if (aVarA.xp == 0) {
                break;
            }
            j = j5;
        }
        if (j4 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jA = a(bVarFP, j2, j4);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(a(byteBufferAllocate, ((Long) it.next()).longValue() + jA));
        }
        return arrayList;
    }

    private static long a(c.b bVar, long j, long j2) {
        for (long j3 = 0; j3 < j; j3++) {
            c.AbstractC0388c abstractC0388cJ = bVar.j(j3);
            if (abstractC0388cJ.xz == 1 && abstractC0388cJ.xA <= j2 && j2 <= abstractC0388cJ.xA + abstractC0388cJ.xB) {
                return (j2 - abstractC0388cJ.xA) + abstractC0388cJ.offset;
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.xE.close();
    }

    private String a(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short sE = e(byteBuffer, j);
            if (sE != 0) {
                sb.append((char) sE);
                j = j2;
            } else {
                return sb.toString();
            }
        }
    }

    protected final long b(ByteBuffer byteBuffer, long j) throws IOException {
        a(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    protected final long c(ByteBuffer byteBuffer, long j) throws IOException {
        a(byteBuffer, j, 4);
        return byteBuffer.getInt() & C00oOOo.f362O8oO888;
    }

    protected final int d(ByteBuffer byteBuffer, long j) throws IOException {
        a(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    private short e(ByteBuffer byteBuffer, long j) throws IOException {
        a(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    private void a(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < i) {
            int i2 = this.xE.read(byteBuffer, j + j2);
            if (i2 == -1) {
                throw new EOFException();
            }
            j2 += i2;
        }
        byteBuffer.position(0);
    }
}
