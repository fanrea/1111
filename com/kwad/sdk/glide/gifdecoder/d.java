package com.kwad.sdk.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    private ByteBuffer bRf;
    private c bRg;
    private final byte[] bRe = new byte[256];
    private int bRh = 0;

    public final d b(ByteBuffer byteBuffer) {
        reset();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.bRf = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.bRf.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public final void clear() {
        this.bRf = null;
        this.bRg = null;
    }

    private void reset() {
        this.bRf = null;
        Arrays.fill(this.bRe, (byte) 0);
        this.bRg = new c();
        this.bRh = 0;
    }

    public final c afC() {
        if (this.bRf == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (afN()) {
            return this.bRg;
        }
        afH();
        if (!afN()) {
            afD();
            if (this.bRg.bQW < 0) {
                this.bRg.status = 1;
            }
        }
        return this.bRg;
    }

    private void afD() {
        fY(Integer.MAX_VALUE);
    }

    private void fY(int i) {
        boolean z = false;
        while (!z && !afN() && this.bRg.bQW <= Integer.MAX_VALUE) {
            int i2 = read();
            if (i2 == 33) {
                int i3 = read();
                if (i3 == 1) {
                    afK();
                } else if (i3 == 249) {
                    this.bRg.bQX = new b();
                    afE();
                } else if (i3 == 254) {
                    afK();
                } else if (i3 == 255) {
                    afL();
                    StringBuilder sb = new StringBuilder();
                    for (int i4 = 0; i4 < 11; i4++) {
                        sb.append((char) this.bRe[i4]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        afG();
                    } else {
                        afK();
                    }
                } else {
                    afK();
                }
            } else if (i2 == 44) {
                if (this.bRg.bQX == null) {
                    this.bRg.bQX = new b();
                }
                afF();
            } else if (i2 != 59) {
                this.bRg.status = 1;
            } else {
                z = true;
            }
        }
    }

    private void afE() {
        read();
        int i = read();
        this.bRg.bQX.bQR = (i & 28) >> 2;
        if (this.bRg.bQX.bQR == 0) {
            this.bRg.bQX.bQR = 1;
        }
        this.bRg.bQX.bQQ = (i & 1) != 0;
        int iAfM = afM();
        if (iAfM < 2) {
            iAfM = 10;
        }
        this.bRg.bQX.delay = iAfM * 10;
        this.bRg.bQX.bQS = read();
        read();
    }

    private void afF() {
        this.bRg.bQX.ix = afM();
        this.bRg.bQX.iy = afM();
        this.bRg.bQX.iw = afM();
        this.bRg.bQX.ih = afM();
        int i = read();
        boolean z = (i & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (i & 7) + 1);
        this.bRg.bQX.bQP = (i & 64) != 0;
        if (z) {
            this.bRg.bQX.bQU = fZ(iPow);
        } else {
            this.bRg.bQX.bQU = null;
        }
        this.bRg.bQX.bQT = this.bRf.position();
        afJ();
        if (afN()) {
            return;
        }
        this.bRg.bQW++;
        this.bRg.bQY.add(this.bRg.bQX);
    }

    private void afG() {
        do {
            afL();
            byte[] bArr = this.bRe;
            if (bArr[0] == 1) {
                this.bRg.bRd = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.bRh <= 0) {
                return;
            }
        } while (!afN());
    }

    private void afH() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) read());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.bRg.status = 1;
            return;
        }
        afI();
        if (!this.bRg.bQZ || afN()) {
            return;
        }
        c cVar = this.bRg;
        cVar.bQV = fZ(cVar.bRa);
        c cVar2 = this.bRg;
        cVar2.bgColor = cVar2.bQV[this.bRg.bRb];
    }

    private void afI() {
        this.bRg.width = afM();
        this.bRg.height = afM();
        this.bRg.bQZ = (read() & 128) != 0;
        this.bRg.bRa = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.bRg.bRb = read();
        this.bRg.bRc = read();
    }

    private int[] fZ(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.bRf.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.bRg.status = 1;
        }
        return iArr;
    }

    private void afJ() {
        read();
        afK();
    }

    private void afK() {
        int i;
        do {
            i = read();
            this.bRf.position(Math.min(this.bRf.position() + i, this.bRf.limit()));
        } while (i > 0);
    }

    private void afL() {
        int i = read();
        this.bRh = i;
        if (i <= 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                i3 = this.bRh;
                if (i2 >= i3) {
                    return;
                }
                i3 -= i2;
                this.bRf.get(this.bRe, i2, i3);
                i2 += i3;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.bRh, e);
                }
                this.bRg.status = 1;
                return;
            }
        }
    }

    private int read() {
        try {
            return this.bRf.get() & 255;
        } catch (Exception unused) {
            this.bRg.status = 1;
            return 0;
        }
    }

    private int afM() {
        return this.bRf.getShort();
    }

    private boolean afN() {
        return this.bRg.status != 0;
    }
}
