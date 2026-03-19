package com.baidu.mobads.cid.cesium.c.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class e {
    private byte[] a;
    private int b;
    private int c;
    private int f;
    private i g;
    private f h;
    private int d = 0;
    private int e = 0;
    private int i = 1;
    private boolean j = false;

    public e(b bVar, int i) {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.b = i;
        this.c = i;
        this.f = i;
        this.a = new byte[this.b * 2];
        this.h = new d(bVar);
        this.g = new h(this.b);
    }

    private int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) throws IllegalBlockSizeException {
        if (bArr == null || i3 == 0) {
            return 0;
        }
        if (this.i != 2 && this.i != 3 && i3 % this.c != 0 && this.i != 6) {
            if (this.g != null) {
                throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.c + " bytes");
            }
            throw new IllegalBlockSizeException("Input length not multiple of " + this.c + " bytes");
        }
        if (this.j) {
            this.h.d(bArr, i, i3, bArr2, i2);
        } else {
            this.h.c(bArr, i, i3, bArr2, i2);
        }
        return i3;
    }

    int a(int i) {
        int i2 = this.d + i;
        return (this.g == null || this.j) ? i2 : this.c != this.b ? i2 < this.f ? this.f : (this.b + i2) - ((i2 - this.f) % this.b) : i2 + this.g.a(i2);
    }

    int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        byte[] bArr3;
        int i4;
        int iA;
        int i5 = this.d + i2;
        int iA2 = this.c != this.b ? i5 < this.f ? this.f - i5 : this.b - ((i5 - this.f) % this.b) : this.g != null ? this.g.a(i5) : 0;
        if (iA2 > 0 && iA2 != this.b && this.g != null && this.j) {
            throw new IllegalBlockSizeException("Input length must be multiple of " + this.b + " when decrypting with padded cipher");
        }
        int i6 = (this.j || this.g == null) ? i5 : i5 + iA2;
        if (bArr2 == null) {
            throw new ShortBufferException("Output buffer is null");
        }
        int length = bArr2.length - i3;
        if (((!this.j || this.g == null) && length < i6) || (this.j && length < i6 - this.b)) {
            throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i6 + " bytes needed");
        }
        if (this.d == 0 && (this.j || this.g == null)) {
            bArr3 = bArr;
            i4 = i;
        } else {
            byte[] bArr4 = new byte[i6];
            if (this.d != 0) {
                System.arraycopy(this.a, 0, bArr4, 0, this.d);
            }
            if (i2 != 0) {
                System.arraycopy(bArr, i, bArr4, this.d, i2);
            }
            if (!this.j && this.g != null) {
                this.g.a(bArr4, i5, iA2);
            }
            bArr3 = bArr4;
            i4 = 0;
        }
        if (this.j) {
            if (length < i6) {
                this.h.b();
            }
            byte[] bArr5 = new byte[i5];
            iA = a(bArr3, i4, bArr5, 0, i5);
            if (this.g != null && (iA = this.g.b(bArr5, 0, iA)) < 0) {
                throw new BadPaddingException("Given final block not properly padded");
            }
            if (bArr2.length - i3 < iA) {
                this.h.c();
                throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i3) + " bytes given, " + iA + " bytes needed");
            }
            for (int i7 = 0; i7 < iA; i7++) {
                bArr2[i3 + i7] = bArr5[i7];
            }
        } else {
            iA = a(bArr3, i4, bArr2, i3, i6);
        }
        this.d = 0;
        this.f = this.b;
        if (this.i != 0) {
            this.h.a();
        }
        return iA;
    }

    public void a(int i, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.j = i == 2 || i == 4;
        if (this.i == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (this.j) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            if (secureRandom == null) {
                secureRandom = c.a;
            }
            bArr2 = new byte[this.b];
            secureRandom.nextBytes(bArr2);
        }
        this.d = 0;
        this.f = this.b;
        this.h.a(this.j, "", bArr, bArr2);
    }

    public byte[] a(byte[] bArr, int i, int i2) throws BadPaddingException, IllegalBlockSizeException {
        int iA;
        byte[] bArr2;
        int iA2;
        byte[] bArr3 = null;
        try {
            iA = a(i2);
            bArr2 = new byte[iA];
            iA2 = a(bArr, i, i2, bArr2, 0);
        } catch (ShortBufferException e) {
        }
        if (iA2 >= iA) {
            return bArr2;
        }
        bArr3 = new byte[iA2];
        if (iA2 != 0) {
            System.arraycopy(bArr2, 0, bArr3, 0, iA2);
        }
        return bArr3;
    }
}
