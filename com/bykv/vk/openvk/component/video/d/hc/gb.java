package com.bykv.vk.openvk.component.video.d.hc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class gb {
    private final RandomAccessFile d;

    gb(File file, String str) throws d {
        try {
            this.d = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new d(e);
        }
    }

    void d(long j) throws d, IOException {
        try {
            this.d.seek(j);
        } catch (IOException e) {
            throw new d(e);
        }
    }

    void d(byte[] bArr, int i, int i2) throws d, IOException {
        try {
            this.d.write(bArr, i, i2);
        } catch (IOException e) {
            throw new d(e);
        }
    }

    int d(byte[] bArr) throws d {
        try {
            return this.d.read(bArr);
        } catch (IOException e) {
            throw new d(e);
        }
    }

    void d() {
        com.bykv.vk.openvk.component.video.d.b.d.d(this.d);
    }

    static class d extends Exception {
        d(Throwable th) {
            super(th);
        }
    }
}
