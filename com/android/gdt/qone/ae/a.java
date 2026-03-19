package com.android.gdt.qone.ae;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static Pair a(RandomAccessFile randomAccessFile, int i, int i2) throws IOException {
        Pair pairCreate;
        int i3;
        if (i2 >= 0 && i2 <= 65535) {
            try {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Math.min(i2, i - 22) + 22);
                byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
                long jCapacity = i - byteBufferAllocate.capacity();
                randomAccessFile.seek(jCapacity);
                randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
                int iCapacity = byteBufferAllocate.capacity() - 22;
                int iMin = Math.min(iCapacity, 65535);
                int i4 = 0;
                while (true) {
                    if (i4 >= iMin) {
                        pairCreate = null;
                        break;
                    }
                    int i5 = iCapacity - i4;
                    if (byteBufferAllocate.getInt(i5) == 101010256 && (i3 = byteBufferAllocate.getShort(i5 + 20) & 65535) == i4) {
                        pairCreate = Pair.create(Integer.valueOf(i5), Integer.valueOf(i3 + 22));
                        break;
                    }
                    i4++;
                }
                if (pairCreate == null) {
                    return null;
                }
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(((Integer) pairCreate.second).intValue());
                byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
                byteBufferAllocate.position(((Integer) pairCreate.first).intValue());
                byteBufferAllocate.get(byteBufferAllocate2.array(), byteBufferAllocate2.position(), byteBufferAllocate2.capacity());
                return Pair.create(byteBufferAllocate2, Long.valueOf(jCapacity + ((Integer) pairCreate.first).intValue()));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.ae.a.a(java.lang.String):java.lang.String");
    }
}
