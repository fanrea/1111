package com.kwai.middleware.azeroth.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Nonce {
    public static final int BYTE_SIZE = 8;
    private static final long LOW_32_BIT = 4294967295L;
    private static final int OFFSET = 32;
    private static final Random sRandom = new Random(System.currentTimeMillis());
    private int minute;
    private int random;
    private long value;

    private Nonce(int i, int i2) {
        this.random = i2;
        this.minute = i;
        this.value = i | (i2 << 32);
    }

    public static Nonce newNonce(int i, int i2) {
        return new Nonce(i, i2);
    }

    public static Nonce newNonce() {
        return new Nonce((int) (System.currentTimeMillis() / TimeUnit.MINUTES.toMillis(1L)), sRandom.nextInt());
    }

    public static Nonce of(byte[] bArr) {
        return of(Longs.fromByteArray(bArr));
    }

    public static Nonce of(long j) {
        return new Nonce((int) (4294967295L & j), (int) (j >>> 32));
    }

    public long getRandom() {
        return this.random;
    }

    public int getMinute() {
        return this.minute;
    }

    public long getValue() {
        return this.value;
    }

    public byte[] toBytes() {
        return Longs.toByteArray(this.value);
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
