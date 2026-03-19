package com.bytedance.pangle.util.hc.d;

import com.bytedance.pangle.util.hc.hc.c;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public c d(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, t.k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (randomAccessFile.length() < 22) {
                throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
            }
            c cVar = new c(str);
            d(randomAccessFile, cVar);
            if (cVar.hc().d() != 0) {
                hc(randomAccessFile, cVar);
                try {
                    randomAccessFile.close();
                } catch (IOException unused) {
                }
                return cVar;
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            return cVar;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    private void d(RandomAccessFile randomAccessFile, c cVar) throws IOException {
        randomAccessFile.seek(b(randomAccessFile, cVar) + 4);
        com.bytedance.pangle.util.hc.hc.hc hcVar = new com.bytedance.pangle.util.hc.hc.hc();
        randomAccessFile.skipBytes(6);
        hcVar.d(cVar.c().hc(randomAccessFile));
        randomAccessFile.skipBytes(4);
        hcVar.d(cVar.c().d(randomAccessFile));
        cVar.d(hcVar);
    }

    private void hc(RandomAccessFile randomAccessFile, c cVar) throws IOException {
        com.bytedance.pangle.util.hc.hc.d dVar = new com.bytedance.pangle.util.hc.hc.d();
        ArrayList arrayList = new ArrayList();
        long jHc = cVar.hc().hc();
        long jD = cVar.hc().d();
        randomAccessFile.seek(jHc);
        for (int i = 0; i < jD; i++) {
            com.bytedance.pangle.util.hc.hc.b bVar = new com.bytedance.pangle.util.hc.hc.b();
            if (cVar.c().d(randomAccessFile) != 33639248) {
                throw new IOException("Expected central directory entry not found (#" + (i + 1) + ")");
            }
            randomAccessFile.skipBytes(6);
            bVar.d(cVar.c().hc(randomAccessFile));
            randomAccessFile.skipBytes(4);
            bVar.d(cVar.c().d(randomAccessFile));
            bVar.hc(cVar.c().d(randomAccessFile));
            bVar.b(cVar.c().d(randomAccessFile));
            int iHc = cVar.c().hc(randomAccessFile);
            bVar.b(iHc);
            bVar.c(cVar.c().hc(randomAccessFile));
            int iHc2 = cVar.c().hc(randomAccessFile);
            randomAccessFile.skipBytes(8);
            bVar.c(cVar.c().d(randomAccessFile));
            if (iHc > 0) {
                byte[] bArr = new byte[iHc];
                randomAccessFile.readFully(bArr);
                bVar.d(d(bArr));
                randomAccessFile.skipBytes(bVar.mk());
                if (iHc2 > 0) {
                    randomAccessFile.skipBytes(iHc2);
                }
                long filePointer = randomAccessFile.getFilePointer();
                randomAccessFile.seek(bVar.uo() + 28);
                bVar.hc(cVar.c().hc(randomAccessFile));
                randomAccessFile.seek(filePointer);
                arrayList.add(bVar);
            } else {
                throw new IOException("Invalid entry name in file header");
            }
        }
        dVar.d(arrayList);
        cVar.d(dVar);
    }

    private long b(RandomAccessFile randomAccessFile, c cVar) throws IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j = length - 22;
        randomAccessFile.seek(j);
        return ((long) cVar.c().d(randomAccessFile)) == 101010256 ? j : c(randomAccessFile, cVar);
    }

    private long c(RandomAccessFile randomAccessFile, c cVar) throws IOException {
        long length = randomAccessFile.length() - 22;
        for (long length2 = randomAccessFile.length() < 65536 ? randomAccessFile.length() : 65536L; length2 > 0 && length > 0; length2--) {
            length--;
            randomAccessFile.seek(length);
            if (cVar.c().d(randomAccessFile) == 101010256) {
                return length;
            }
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private String d(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }
}
