package com.tencent.turingfd.sdk.ams.au;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Octans {
    public static String a(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] bArrDigest;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            bArrDigest = messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            bArrDigest = null;
        }
        return Date.a(bArrDigest);
    }
}
