package com.bytedance.pangle.util.hc;

import com.bytedance.pangle.util.h;
import com.bytedance.pangle.util.hc.hc.b;
import com.bytedance.pangle.util.hc.hc.c;
import com.bytedance.pangle.util.tt;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private final c d;
    private final com.bytedance.pangle.util.hc.d.hc hc = new com.bytedance.pangle.util.hc.d.hc();

    public d(c cVar) {
        this.d = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0115 A[Catch: all -> 0x013a, TryCatch #4 {all -> 0x013a, blocks: (B:24:0x00c8, B:26:0x012a, B:25:0x0115), top: B:61:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(boolean r24, boolean r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.hc.d.d(boolean, boolean):void");
    }

    private boolean d(b bVar, boolean z, boolean z2) {
        if (z) {
            if (tt.an() && bVar.mq().equals("classes.dex")) {
                return false;
            }
            if (bVar.mq().startsWith("classes") && bVar.mq().endsWith(".dex")) {
                return true;
            }
        }
        return z2 && bVar.mq().startsWith("lib/") && bVar.mq().endsWith(".so");
    }

    void d(File file) throws ZipException {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    void d(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) throws IOException {
        h.d(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }

    private void d(File file, File file2) throws ZipException {
        if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }
}
