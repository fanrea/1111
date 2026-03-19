package com.baidu.mobads.cid.cesium.c.d;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class c {
    private static final byte[] a = new byte[0];
    private int b;
    private String c = com.baidu.ad.magic.flute.c.a.a.b.a;
    private f d;
    private byte[] e;
    private int f;
    private int g;
    private d h;

    private void a(int i, d dVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        boolean z;
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
        if (!(dVar instanceof d)) {
            throw new InvalidKeyException("only support helios key");
        }
        this.b = z ? 1 : 4;
        this.h = dVar;
        int iA = b.a(this.h.a());
        this.g = iA;
        this.f = 0;
        if (this.c == "NoPadding") {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
            this.d = f.a(3, iA, secureRandom);
            this.e = new byte[iA];
            return;
        }
        if (this.c != com.baidu.ad.magic.flute.c.a.a.b.a) {
            throw new InvalidKeyException("OAEP not supported");
        }
        if (algorithmParameterSpec != null) {
            throw new InvalidAlgorithmParameterException("Parameters not supported");
        }
        this.d = f.a(this.b <= 2 ? 2 : 1, iA, secureRandom);
        if (z) {
            this.e = new byte[this.d.a()];
        } else {
            this.e = new byte[iA];
        }
    }

    private byte[] a() throws IllegalBlockSizeException {
        if (this.f > this.e.length) {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.e.length + " bytes");
        }
        try {
            switch (this.b) {
                case 1:
                    return b.a(this.d.a(this.e, 0, this.f), this.h);
                case 2:
                    throw new UnsupportedOperationException("only verify supported");
                case 3:
                    throw new UnsupportedOperationException("only verify supported");
                case 4:
                    return this.d.b(b.a(b.a(this.e, 0, this.f), this.h));
                default:
                    throw new AssertionError("Internal error");
            }
        } finally {
            this.f = 0;
        }
    }

    private void b(byte[] bArr, int i, int i2) {
        int length;
        if (i2 == 0 || bArr == null) {
            return;
        }
        if (this.f + i2 > this.e.length) {
            length = this.e.length + 1;
        } else {
            System.arraycopy(bArr, i, this.e, this.f, i2);
            length = this.f + i2;
        }
        this.f = length;
    }

    public void a(int i, d dVar, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            a(i, dVar, secureRandom, null);
        } catch (InvalidAlgorithmParameterException e) {
            InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
            invalidKeyException.initCause(e);
            throw invalidKeyException;
        }
    }

    public void a(String str) throws NoSuchPaddingException {
        String str2 = "NoPadding";
        if (!str.equalsIgnoreCase("NoPadding")) {
            str2 = com.baidu.ad.magic.flute.c.a.a.b.a;
            if (!str.equalsIgnoreCase(com.baidu.ad.magic.flute.c.a.a.b.a)) {
                throw new NoSuchPaddingException("Padding " + str + " not supported");
            }
        }
        this.c = str2;
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        b(bArr, i, i2);
        return a();
    }
}
