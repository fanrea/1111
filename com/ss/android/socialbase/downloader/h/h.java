package com.ss.android.socialbase.downloader.h;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h implements Closeable {
    private RandomAccessFile b;
    private BufferedOutputStream d;
    private FileDescriptor hc;

    public h(File file, int i) throws com.ss.android.socialbase.downloader.u.d {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.b = randomAccessFile;
            this.hc = randomAccessFile.getFD();
            if (i > 0) {
                if (i < 8192) {
                    i = 8192;
                } else if (i > 131072) {
                    i = 131072;
                }
                this.d = new BufferedOutputStream(new FileOutputStream(this.b.getFD()), i);
                return;
            }
            this.d = new BufferedOutputStream(new FileOutputStream(this.b.getFD()));
        } catch (IOException e) {
            throw new com.ss.android.socialbase.downloader.u.d(1039, e);
        }
    }

    public void d(byte[] bArr, int i, int i2) throws IOException {
        this.d.write(bArr, i, i2);
    }

    public void d() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.d;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.hc;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void hc() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.d;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void b() throws IOException {
        FileDescriptor fileDescriptor = this.hc;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.ss.android.socialbase.downloader.e.an.d(this.b, this.d);
    }

    public void d(long j) throws IOException {
        this.b.seek(j);
    }

    public void hc(long j) throws IOException {
        this.b.setLength(j);
    }
}
