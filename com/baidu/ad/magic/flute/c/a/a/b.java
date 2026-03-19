package com.baidu.ad.magic.flute.c.a.a;

import com.bytedance.common.utility.StringEncryptUtils;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Locale;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class b {
    public static final String a = "PKCS1Padding";
    private static final byte[] b = new byte[0];
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static final int f = 4;
    private static final String g = "NoPadding";
    private static final String h = "OAEP";
    private int i;
    private d k;
    private byte[] m;
    private int n;
    private int o;
    private com.baidu.ad.magic.flute.b.b.a.a p;
    private OAEPParameterSpec l = null;
    private String q = StringEncryptUtils.SHA_1;
    private String j = a;

    private void a(int i, com.baidu.ad.magic.flute.b.b.a.a aVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        boolean z;
        OAEPParameterSpec oAEPParameterSpec;
        switch (i) {
            case 1:
            case 3:
                z = true;
                break;
            case 2:
            case 4:
                z = false;
                break;
            default:
                throw new InvalidKeyException("Unknown mode: " + i);
        }
        if (!(aVar instanceof com.baidu.ad.magic.flute.b.b.a.a)) {
            throw new InvalidKeyException("only support helios key");
        }
        this.i = z ? 1 : 4;
        this.p = aVar;
        int iA = a.a(this.p.a());
        this.o = iA;
        this.n = 0;
        if (this.j == g) {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
            this.k = d.a(3, iA, secureRandom);
            this.m = new byte[iA];
            return;
        }
        if (this.j == a) {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
            this.k = d.a(this.i <= 2 ? 2 : 1, iA, secureRandom);
            if (z) {
                this.m = new byte[this.k.a()];
                return;
            } else {
                this.m = new byte[iA];
                return;
            }
        }
        if (this.i == 3 || this.i == 4) {
            throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
        }
        if (algorithmParameterSpec == null) {
            oAEPParameterSpec = new OAEPParameterSpec(this.q, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
        } else {
            if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
            }
            oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
        }
        this.k = d.a(4, iA, secureRandom, oAEPParameterSpec);
        if (z) {
            this.m = new byte[this.k.a()];
        } else {
            this.m = new byte[iA];
        }
    }

    private byte[] a() throws IllegalBlockSizeException {
        if (this.n > this.m.length) {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.m.length + " bytes");
        }
        try {
            switch (this.i) {
                case 1:
                    return a.a(this.k.a(this.m, 0, this.n), this.p);
                case 2:
                    throw new UnsupportedOperationException("only verify supported");
                case 3:
                    throw new UnsupportedOperationException("only verify supported");
                case 4:
                    return this.k.b(a.a(a.a(this.m, 0, this.n), this.p));
                default:
                    throw new AssertionError("Internal error");
            }
        } finally {
            this.n = 0;
        }
    }

    private void b(byte[] bArr, int i, int i2) {
        int length;
        if (i2 == 0 || bArr == null) {
            return;
        }
        if (this.n + i2 > this.m.length) {
            length = this.m.length + 1;
        } else {
            System.arraycopy(bArr, i, this.m, this.n, i2);
            length = this.n + i2;
        }
        this.n = length;
    }

    public void a(int i, com.baidu.ad.magic.flute.b.b.a.a aVar, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            a(i, aVar, secureRandom, null);
        } catch (InvalidAlgorithmParameterException e2) {
            InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
            invalidKeyException.initCause(e2);
            throw invalidKeyException;
        }
    }

    public void a(String str) throws NoSuchAlgorithmException {
        if (!str.equalsIgnoreCase("ECB")) {
            throw new NoSuchAlgorithmException("Unsupported mode " + str);
        }
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        b(bArr, i, i2);
        return a();
    }

    public void b(String str) throws NoSuchPaddingException {
        String str2 = g;
        if (!str.equalsIgnoreCase(g)) {
            str2 = a;
            if (!str.equalsIgnoreCase(a)) {
                String lowerCase = str.toLowerCase(Locale.ENGLISH);
                if (lowerCase.equals("oaeppadding")) {
                    this.j = h;
                    return;
                } else {
                    if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                        throw new NoSuchPaddingException("Padding " + str + " not supported");
                    }
                    this.j = h;
                    this.q = str.substring(8, str.length() - 14);
                    throw new NoSuchPaddingException("MessageDigest not available for " + str);
                }
            }
        }
        this.j = str2;
    }
}
