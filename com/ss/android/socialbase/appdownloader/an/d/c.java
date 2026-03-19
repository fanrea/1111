package com.ss.android.socialbase.appdownloader.an.d;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private int b;
    private InputStream d;
    private boolean hc;

    public c() {
    }

    public c(InputStream inputStream, boolean z) {
        d(inputStream, z);
    }

    public final void d(InputStream inputStream, boolean z) {
        this.d = inputStream;
        this.hc = z;
        this.b = 0;
    }

    public final void d() throws IOException {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            d(null, false);
        }
    }

    public final int hc() throws IOException {
        return d(4);
    }

    public final int d(int i) throws IOException {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.hc) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int i4 = this.d.read();
                    if (i4 == -1) {
                        throw new EOFException();
                    }
                    this.b++;
                    i2 |= i4 << i3;
                }
                return i2;
            }
            int i5 = i * 8;
            int i6 = 0;
            while (i2 != i5) {
                int i7 = this.d.read();
                if (i7 == -1) {
                    throw new EOFException();
                }
                this.b++;
                i6 |= i7 << i2;
                i2 += 8;
            }
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public final int[] hc(int i) throws IOException {
        int[] iArr = new int[i];
        d(iArr, 0, i);
        return iArr;
    }

    public final void d(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = hc();
            i2--;
            i++;
        }
    }

    public final void b(int i) throws IOException {
        if (i > 0) {
            long j = i;
            long jSkip = this.d.skip(j);
            this.b = (int) (this.b + jSkip);
            if (jSkip != j) {
                throw new EOFException();
            }
        }
    }

    public final void b() throws IOException {
        b(4);
    }
}
