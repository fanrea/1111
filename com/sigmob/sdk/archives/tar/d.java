package com.sigmob.sdk.archives.tar;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class d {
    public static final int a = 512;
    public static final int b = 10240;
    private InputStream c;
    private OutputStream d;
    private byte[] e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    public d(InputStream inStream) {
        this(inStream, b);
    }

    public d(InputStream inStream, int blockSize) {
        this(inStream, blockSize, 512);
    }

    public d(InputStream inStream, int blockSize, int recordSize) {
        this.c = inStream;
        this.d = null;
        a(blockSize, recordSize);
    }

    public d(OutputStream outStream) {
        this(outStream, b);
    }

    public d(OutputStream outStream, int blockSize) {
        this(outStream, blockSize, 512);
    }

    public d(OutputStream outStream, int blockSize, int recordSize) {
        this.c = null;
        this.d = outStream;
        a(blockSize, recordSize);
    }

    private void a(int blockSize, int recordSize) {
        this.h = blockSize;
        this.i = recordSize;
        int i = blockSize / recordSize;
        this.j = i;
        this.e = new byte[blockSize];
        if (this.c != null) {
            this.f = -1;
            this.g = i;
        } else {
            this.f = 0;
            this.g = 0;
        }
    }

    private boolean i() throws IOException {
        if (this.c == null) {
            throw new IOException("reading from an output buffer");
        }
        this.g = 0;
        int i = this.h;
        int i2 = 0;
        while (true) {
            if (i <= 0) {
                break;
            }
            long j = this.c.read(this.e, i2, i);
            if (j != -1) {
                i2 = (int) (i2 + j);
                i = (int) (i - j);
            } else {
                if (i2 == 0) {
                    return false;
                }
                Arrays.fill(this.e, i2, i + i2, (byte) 0);
            }
        }
        this.f++;
        return true;
    }

    private void j() throws IOException {
        OutputStream outputStream = this.d;
        if (outputStream == null) {
            throw new IOException("writing to an input buffer");
        }
        outputStream.write(this.e, 0, this.h);
        this.d.flush();
        this.g = 0;
        this.f++;
        Arrays.fill(this.e, (byte) 0);
    }

    public int a() {
        return this.h;
    }

    public void a(byte[] buf, int offset) throws IOException {
        if (this.d == null) {
            if (this.c != null) {
                throw new IOException("writing to an input buffer");
            }
            throw new IOException("Output buffer is closed");
        }
        if (this.i + offset > buf.length) {
            throw new IOException("record has length '" + buf.length + "' with offset '" + offset + "' which is less than the record size of '" + this.i + "'");
        }
        if (this.g >= this.j) {
            j();
        }
        byte[] bArr = this.e;
        int i = this.g;
        int i2 = this.i;
        System.arraycopy(buf, offset, bArr, i * i2, i2);
        this.g++;
    }

    public boolean a(byte[] record) {
        int iB = b();
        for (int i = 0; i < iB; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int b() {
        return this.i;
    }

    public void b(byte[] record) throws IOException {
        if (this.d == null) {
            if (this.c != null) {
                throw new IOException("writing to an input buffer");
            }
            throw new IOException("Output buffer is closed");
        }
        if (record.length != this.i) {
            throw new IOException("record to write has length '" + record.length + "' which is not the record size of '" + this.i + "'");
        }
        if (this.g >= this.j) {
            j();
        }
        byte[] bArr = this.e;
        int i = this.g;
        int i2 = this.i;
        System.arraycopy(record, 0, bArr, i * i2, i2);
        this.g++;
    }

    public void c() throws IOException {
        if (this.c == null) {
            throw new IOException("reading (via skip) from an output buffer");
        }
        if (this.g < this.j || i()) {
            this.g++;
        }
    }

    public byte[] d() throws IOException {
        if (this.c == null) {
            if (this.d == null) {
                throw new IOException("input buffer is closed");
            }
            throw new IOException("reading from an output buffer");
        }
        if (this.g >= this.j && !i()) {
            return null;
        }
        int i = this.i;
        byte[] bArr = new byte[i];
        System.arraycopy(this.e, this.g * i, bArr, 0, i);
        this.g++;
        return bArr;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.g - 1;
    }

    void g() throws IOException {
        if (this.d == null) {
            throw new IOException("writing to an input buffer");
        }
        if (this.g > 0) {
            j();
        }
    }

    public void h() throws IOException {
        if (this.d != null) {
            g();
            if (this.d == System.out || this.d == System.err) {
                return;
            }
            this.d.close();
            this.d = null;
            return;
        }
        InputStream inputStream = this.c;
        if (inputStream != null) {
            if (inputStream != System.in) {
                this.c.close();
            }
            this.c = null;
        }
    }
}
