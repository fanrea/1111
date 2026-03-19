package com.alliance.ssp.ad.o;

import android.util.Base64;
import com.alliance.ssp.ad.o0.l;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: RSAUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    public static final byte[] a = "#PART#".getBytes();

    public static String a(String str) {
        byte[] bArrEncode;
        try {
            bArrEncode = Base64.encode(d(str.getBytes("UTF-8"), a.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP1Kih/K38O5JKETk5bTWQerfE3fxHffwIaz/GTECPC8SsywzwTZexB/BpJqGck9I35Jp4RsD2BlJldLiOEgRlA1bdmY/SOSyxTY9Hkh+vFqADQVo8vWtnLOwloNRkhp5kQiQxEyGEr6zJRd+DLVyFYuhgzlqOhyIS8XYkLnyZqwIDAQAB")), 0);
        } catch (Exception e) {
            e.printStackTrace();
            bArrEncode = null;
        }
        return bArrEncode == null ? "" : new String(bArrEncode);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066 A[Catch: Exception -> 0x00aa, TryCatch #0 {Exception -> 0x00aa, blocks: (B:2:0x0000, B:4:0x0005, B:6:0x000a, B:8:0x0017, B:10:0x001e, B:12:0x002d, B:13:0x0039, B:31:0x0066, B:33:0x0075, B:34:0x0081, B:35:0x0087, B:14:0x003e, B:17:0x0046, B:21:0x004e, B:24:0x0059, B:27:0x005e, B:36:0x0089, B:37:0x0093, B:39:0x0099), top: B:44:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(byte[] r12, byte[] r13) {
        /*
            byte[] r0 = com.alliance.ssp.ad.o.d.a     // Catch: java.lang.Exception -> Laa
            int r0 = r0.length     // Catch: java.lang.Exception -> Laa
            if (r0 > 0) goto La
            byte[] r12 = a(r12, r13)     // Catch: java.lang.Exception -> Laa
            return r12
        La:
            int r1 = r12.length     // Catch: java.lang.Exception -> Laa
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Exception -> Laa
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3)     // Catch: java.lang.Exception -> Laa
            r3 = 0
            r4 = r3
            r5 = r4
        L15:
            if (r4 >= r1) goto L89
            r6 = r12[r4]     // Catch: java.lang.Exception -> Laa
            int r7 = r1 + (-1)
            r8 = 1
            if (r4 != r7) goto L3e
            int r6 = r1 - r5
            byte[] r7 = new byte[r6]     // Catch: java.lang.Exception -> Laa
            java.lang.System.arraycopy(r12, r5, r7, r3, r6)     // Catch: java.lang.Exception -> Laa
            byte[] r5 = a(r7, r13)     // Catch: java.lang.Exception -> Laa
            int r6 = r5.length     // Catch: java.lang.Exception -> Laa
            r7 = r3
        L2b:
            if (r7 >= r6) goto L39
            r9 = r5[r7]     // Catch: java.lang.Exception -> Laa
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)     // Catch: java.lang.Exception -> Laa
            r2.add(r9)     // Catch: java.lang.Exception -> Laa
            int r7 = r7 + 1
            goto L2b
        L39:
            int r5 = r4 + r0
            int r4 = r5 + (-1)
            goto L63
        L3e:
            byte[] r7 = com.alliance.ssp.ad.o.d.a     // Catch: java.lang.Exception -> Laa
            r7 = r7[r3]     // Catch: java.lang.Exception -> Laa
            if (r6 != r7) goto L63
            if (r0 <= r8) goto L61
            int r6 = r4 + r0
            if (r6 >= r1) goto L63
            r7 = r3
            r6 = r8
        L4c:
            if (r6 >= r0) goto L64
            byte[] r9 = com.alliance.ssp.ad.o.d.a     // Catch: java.lang.Exception -> Laa
            r9 = r9[r6]     // Catch: java.lang.Exception -> Laa
            int r10 = r4 + r6
            r10 = r12[r10]     // Catch: java.lang.Exception -> Laa
            if (r9 == r10) goto L59
            goto L64
        L59:
            int r9 = r0 + (-1)
            if (r6 != r9) goto L5e
            r7 = r8
        L5e:
            int r6 = r6 + 1
            goto L4c
        L61:
            r7 = r8
            goto L64
        L63:
            r7 = r3
        L64:
            if (r7 == 0) goto L87
            int r6 = r4 - r5
            byte[] r7 = new byte[r6]     // Catch: java.lang.Exception -> Laa
            java.lang.System.arraycopy(r12, r5, r7, r3, r6)     // Catch: java.lang.Exception -> Laa
            byte[] r5 = a(r7, r13)     // Catch: java.lang.Exception -> Laa
            int r6 = r5.length     // Catch: java.lang.Exception -> Laa
            r7 = r3
        L73:
            if (r7 >= r6) goto L81
            r9 = r5[r7]     // Catch: java.lang.Exception -> Laa
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)     // Catch: java.lang.Exception -> Laa
            r2.add(r9)     // Catch: java.lang.Exception -> Laa
            int r7 = r7 + 1
            goto L73
        L81:
            int r4 = r4 + r0
            int r5 = r4 + (-1)
            r11 = r5
            r5 = r4
            r4 = r11
        L87:
            int r4 = r4 + r8
            goto L15
        L89:
            int r12 = r2.size()     // Catch: java.lang.Exception -> Laa
            byte[] r12 = new byte[r12]     // Catch: java.lang.Exception -> Laa
            java.util.Iterator r13 = r2.iterator()     // Catch: java.lang.Exception -> Laa
        L93:
            boolean r0 = r13.hasNext()     // Catch: java.lang.Exception -> Laa
            if (r0 == 0) goto La9
            java.lang.Object r0 = r13.next()     // Catch: java.lang.Exception -> Laa
            java.lang.Byte r0 = (java.lang.Byte) r0     // Catch: java.lang.Exception -> Laa
            int r1 = r3 + 1
            byte r0 = r0.byteValue()     // Catch: java.lang.Exception -> Laa
            r12[r3] = r0     // Catch: java.lang.Exception -> Laa
            r3 = r1
            goto L93
        La9:
            return r12
        Laa:
            int r12 = com.alliance.ssp.ad.o0.l.a
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.o.d.b(byte[], byte[]):byte[]");
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new X509EncodedKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKeyGeneratePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        int length = bArr.length;
        if (length <= 117) {
            return c(bArr, bArr2);
        }
        ArrayList arrayList = new ArrayList(2048);
        byte[] bArr3 = new byte[117];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            bArr3[i3] = bArr[i2];
            i3++;
            if (i3 == 117 || i2 == length - 1) {
                i4++;
                if (i4 != 1) {
                    for (byte b : a) {
                        arrayList.add(Byte.valueOf(b));
                    }
                }
                for (byte b2 : c(bArr3, bArr2)) {
                    arrayList.add(Byte.valueOf(b2));
                }
                bArr3 = i2 == length + (-1) ? null : new byte[Math.min(117, (length - i2) - 1)];
                i3 = 0;
            }
            i2++;
        }
        byte[] bArr4 = new byte[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bArr4[i] = ((Byte) it.next()).byteValue();
            i++;
        }
        return bArr4;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePrivate(new PKCS8EncodedKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, privateKeyGeneratePrivate);
            return cipher.doFinal(Base64.decode(bArr, 0));
        } catch (Exception unused) {
            int i = l.a;
            return null;
        }
    }
}
