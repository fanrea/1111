package com.bytedance.pangle.h.d;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private InputStream d;
    private int hc;

    public hc(InputStream inputStream) {
        d(inputStream);
    }

    public final void d(InputStream inputStream) {
        this.d = inputStream;
        this.hc = 0;
    }

    public final void d() throws IOException {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            d((InputStream) null);
        }
    }

    public final int hc() throws IOException {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int i3 = this.d.read();
            if (i3 == -1) {
                throw new EOFException();
            }
            this.hc++;
            i |= i3 << i2;
        }
        return i;
    }

    public final int[] d(int i) throws IOException {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = hc();
            i--;
            i2++;
        }
        return iArr;
    }

    public final void b() throws IOException {
        long jSkip = this.d.skip(4L);
        this.hc = (int) (this.hc + jSkip);
        if (jSkip != 4) {
            throw new EOFException();
        }
    }

    public void hc(int i) throws IOException {
        int iHc = hc();
        if (iHc != i) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i), Integer.valueOf(iHc)));
        }
    }
}
