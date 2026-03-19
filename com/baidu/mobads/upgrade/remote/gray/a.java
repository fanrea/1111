package com.baidu.mobads.upgrade.remote.gray;

import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static final String a = "MD5";
    private PublicKey b;
    private String c;
    private DynamicUpgradeInfo d;

    public a(DynamicUpgradeInfo dynamicUpgradeInfo, String str) {
        this.d = dynamicUpgradeInfo;
        this.c = str;
        if (this.d != null) {
            try {
                this.b = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Throwable th) {
                this.b = null;
            }
        }
    }

    public boolean a() {
        try {
            if (this.d != null) {
                String strA = a(new File(this.c));
                String strB = b(this.d.a());
                if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB)) {
                    return strB.equalsIgnoreCase(strA);
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private PublicKey a(String str) {
        try {
            return KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Throwable th) {
            return null;
        }
    }

    private String a(File file) {
        DigestInputStream digestInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                digestInputStream = new DigestInputStream(fileInputStream2, messageDigest);
            } catch (Throwable th) {
                digestInputStream = null;
            }
            try {
                while (digestInputStream.read(new byte[4096]) != -1) {
                }
                String str = "";
                for (byte b : messageDigest.digest()) {
                    str = str + Integer.toString((b & 255) + 256, 16).substring(1);
                }
                try {
                    fileInputStream2.close();
                    digestInputStream.close();
                } catch (Throwable th2) {
                }
                return str;
            } catch (Throwable th3) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                        return "";
                    }
                }
                if (digestInputStream == null) {
                    return "";
                }
                digestInputStream.close();
                return "";
            }
        } catch (Throwable th5) {
            digestInputStream = null;
        }
    }

    private String b(String str) {
        if (this.b != null) {
            try {
                byte[] bArrDecode = Base64.decode(str, 0);
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, this.b);
                return new String(cipher.doFinal(bArrDecode), "UTF-8").trim();
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }
}
