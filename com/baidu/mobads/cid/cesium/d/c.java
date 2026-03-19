package com.baidu.mobads.cid.cesium.d;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class c {
    public static byte[] a(byte[] bArr) {
        try {
            MessageDigest messageDigestA = d.a("1-AHS");
            if (messageDigestA == null) {
                return null;
            }
            return messageDigestA.digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
