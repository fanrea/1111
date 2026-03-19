package com.baidu.ad.magic.flute.c.a.a;

import com.bytedance.common.utility.StringEncryptUtils;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class d {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    private static final Map l = Collections.synchronizedMap(new HashMap());
    private final int e;
    private final int f;
    private SecureRandom g;
    private final int h;
    private MessageDigest i;
    private MessageDigest j;
    private byte[] k;

    private d(int i, int i2, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        String digestAlgorithm;
        byte[] value;
        this.e = i;
        this.f = i2;
        this.g = secureRandom;
        if (i2 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        switch (i) {
            case 1:
            case 2:
                i2 -= 11;
                break;
            case 3:
                break;
            case 4:
                String digestAlgorithm2 = StringEncryptUtils.SHA_1;
                if (oAEPParameterSpec != null) {
                    try {
                        digestAlgorithm2 = oAEPParameterSpec.getDigestAlgorithm();
                        String mGFAlgorithm = oAEPParameterSpec.getMGFAlgorithm();
                        if (!mGFAlgorithm.equalsIgnoreCase("MGF1")) {
                            throw new InvalidAlgorithmParameterException("Unsupported MGF algo: " + mGFAlgorithm);
                        }
                        digestAlgorithm = ((MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters()).getDigestAlgorithm();
                        PSource pSource = oAEPParameterSpec.getPSource();
                        String algorithm = pSource.getAlgorithm();
                        if (!algorithm.equalsIgnoreCase("PSpecified")) {
                            throw new InvalidAlgorithmParameterException("Unsupported pSource algo: " + algorithm);
                        }
                        value = ((PSource.PSpecified) pSource).getValue();
                    } catch (NoSuchAlgorithmException e) {
                        throw new InvalidKeyException("Digest " + StringEncryptUtils.SHA_1 + " not available", e);
                    }
                } else {
                    value = null;
                    digestAlgorithm = StringEncryptUtils.SHA_1;
                }
                this.i = MessageDigest.getInstance(digestAlgorithm2);
                this.j = MessageDigest.getInstance(digestAlgorithm);
                this.k = a(this.i, value);
                this.h = (i2 - 2) - (this.k.length * 2);
                if (this.h <= 0) {
                    throw new InvalidKeyException("Key is too short for encryption using OAEPPadding with " + digestAlgorithm2 + " and MGF1" + digestAlgorithm);
                }
                return;
            default:
                throw new InvalidKeyException("Invalid padding: " + i);
        }
        this.h = i2;
    }

    public static d a(int i, int i2) {
        return new d(i, i2, null, null);
    }

    public static d a(int i, int i2, SecureRandom secureRandom) {
        return new d(i, i2, secureRandom, null);
    }

    public static d a(int i, int i2, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        return new d(i, i2, secureRandom, oAEPParameterSpec);
    }

    private void a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws BadPaddingException, DigestException {
        byte[] bArr3 = new byte[4];
        byte[] bArr4 = new byte[20];
        while (i4 > 0) {
            this.j.update(bArr, i, i2);
            this.j.update(bArr3);
            try {
                this.j.digest(bArr4, 0, 20);
                for (int i5 = 0; i5 < 20 && i4 > 0; i5++) {
                    bArr2[i3] = (byte) (bArr4[i5] ^ bArr2[i3]);
                    i4--;
                    i3++;
                }
                if (i4 > 0) {
                    int i6 = 3;
                    while (true) {
                        byte b2 = (byte) (bArr3[i6] + 1);
                        bArr3[i6] = b2;
                        if (b2 != 0 || i6 <= 0) {
                            break;
                        } else {
                            i6--;
                        }
                    }
                }
            } catch (DigestException e) {
                throw new BadPaddingException(e.toString());
            }
        }
    }

    private static byte[] a(MessageDigest messageDigest, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return messageDigest.digest(bArr);
        }
        String algorithm = messageDigest.getAlgorithm();
        byte[] bArr2 = (byte[]) l.get(algorithm);
        if (bArr2 != null) {
            return bArr2;
        }
        byte[] bArrDigest = messageDigest.digest();
        l.put(algorithm, bArrDigest);
        return bArrDigest;
    }

    private byte[] c(byte[] bArr) {
        int i;
        int i2;
        byte[] bArr2 = new byte[this.f];
        System.arraycopy(bArr, 0, bArr2, this.f - bArr.length, bArr.length);
        int length = (this.f - 3) - bArr.length;
        bArr2[0] = 0;
        bArr2[1] = (byte) this.e;
        int i3 = -1;
        int i4 = 2;
        if (this.e != 1) {
            if (this.g == null) {
                this.g = a.a;
            }
            byte[] bArr3 = new byte[64];
            while (true) {
                int i5 = length - 1;
                if (length <= 0) {
                    break;
                }
                while (true) {
                    if (i3 < 0) {
                        this.g.nextBytes(bArr3);
                        i3 = 63;
                    }
                    i = i3 - 1;
                    i2 = bArr3[i3] & 255;
                    if (i2 != 0) {
                        break;
                    }
                    i3 = i;
                }
                bArr2[i4] = (byte) i2;
                i3 = i;
                length = i5;
                i4++;
            }
        } else {
            while (true) {
                int i6 = length - 1;
                if (length <= 0) {
                    break;
                }
                bArr2[i4] = -1;
                i4++;
                length = i6;
            }
        }
        return bArr2;
    }

    private byte[] d(byte[] bArr) throws BadPaddingException {
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        if (bArr[1] != this.e) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        int i = 2;
        while (true) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i3 == 0) {
                int length = bArr.length - i2;
                if (length > this.h) {
                    throw new BadPaddingException("Padding string too short");
                }
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                return bArr2;
            }
            if (i2 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            }
            if (this.e == 1 && i3 != 255) {
                throw new BadPaddingException("Padding byte not 0xff: " + i3);
            }
            i = i2;
        }
    }

    private byte[] e(byte[] bArr) throws BadPaddingException, DigestException {
        if (this.g == null) {
            this.g = a.a;
        }
        int length = this.k.length;
        byte[] bArr2 = new byte[length];
        this.g.nextBytes(bArr2);
        int i = this.f;
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 1, length);
        int i2 = length + 1;
        int i3 = i - i2;
        int length2 = this.f - bArr.length;
        System.arraycopy(this.k, 0, bArr3, i2, length);
        bArr3[length2 - 1] = 1;
        System.arraycopy(bArr, 0, bArr3, length2, bArr.length);
        a(bArr3, 1, length, bArr3, i2, i3);
        a(bArr3, i2, i3, bArr3, 1, length);
        return bArr3;
    }

    private byte[] f(byte[] bArr) throws BadPaddingException, DigestException {
        int length = this.k.length;
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i = length + 1;
        int length2 = bArr.length - i;
        a(bArr, i, length2, bArr, 1, length);
        a(bArr, 1, length, bArr, i, length2);
        for (int i2 = 0; i2 < length; i2++) {
            if (this.k[i2] != bArr[i + i2]) {
                throw new BadPaddingException("lHash mismatch");
            }
        }
        int i3 = i + length;
        while (bArr[i3] == 0) {
            i3++;
            if (i3 >= bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            }
        }
        int i4 = i3 + 1;
        if (bArr[i3] != 1) {
            throw new BadPaddingException("Padding string not terminated by 0x01 byte");
        }
        int length3 = bArr.length - i4;
        byte[] bArr2 = new byte[length3];
        System.arraycopy(bArr, i4, bArr2, 0, length3);
        return bArr2;
    }

    public int a() {
        return this.h;
    }

    public byte[] a(byte[] bArr) throws BadPaddingException {
        if (bArr.length > this.h) {
            throw new BadPaddingException("Data must be shorter than " + (this.h + 1) + " bytes");
        }
        switch (this.e) {
            case 1:
            case 2:
                return c(bArr);
            case 3:
                return bArr;
            case 4:
                return e(bArr);
            default:
                throw new AssertionError();
        }
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        return a(a.a(bArr, i, i2));
    }

    public byte[] b(byte[] bArr) throws BadPaddingException {
        if (bArr.length != this.f) {
            throw new BadPaddingException("Padded length must be " + this.f);
        }
        switch (this.e) {
            case 1:
            case 2:
                return d(bArr);
            case 3:
                return bArr;
            case 4:
                return f(bArr);
            default:
                throw new AssertionError();
        }
    }

    public byte[] b(byte[] bArr, int i, int i2) {
        return b(a.a(bArr, i, i2));
    }
}
