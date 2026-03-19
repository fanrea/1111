package com.alipay.sdk.m.y;

import com.bytedance.common.utility.StringEncryptUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class b {
    public static String a(String str) throws NoSuchAlgorithmException {
        try {
            if (com.alipay.sdk.m.z.a.a(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance(StringEncryptUtils.SHA_1);
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
