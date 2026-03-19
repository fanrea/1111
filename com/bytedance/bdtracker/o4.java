package com.bytedance.bdtracker;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import java.util.ArrayList;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class o4 {
    public static final String[] b = {"tt_data", "device_platform"};
    public static final String[] c = {"aid", "version_code", "ab_version", Config.IID, "device_platform"};
    public static final String[] d = {"aid", "app_version", "tt_data", com.baidu.mobads.upgrade.remote.gray.c.l};
    public final d a;

    public o4(d dVar) {
        this.a = dVar;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; bArr != null && i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] a(byte[] bArr, String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            int length = str.length();
            byte[] bArr2 = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr2[i] = (byte) str.charAt(i);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            int length2 = str2.length();
            byte[] bArr3 = new byte[length2];
            for (int i2 = 0; i2 < length2; i2++) {
                bArr3[i2] = (byte) str2.charAt(i2);
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] b(java.lang.String r7) {
        /*
            r6 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = 8192(0x2000, float:1.148E-41)
            r0.<init>(r1)
            r1 = 0
            com.bytedance.bdtracker.d r2 = r6.a     // Catch: java.lang.Throwable -> L2c
            boolean r2 = r2.E     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "UTF-8"
            if (r2 == 0) goto L21
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L2c
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2c
            byte[] r7 = r7.getBytes(r3)     // Catch: java.lang.Throwable -> L1e
            r2.write(r7)     // Catch: java.lang.Throwable -> L1e
            r1 = r2
            goto L28
        L1e:
            r7 = move-exception
            r1 = r2
            goto L2d
        L21:
            byte[] r7 = r7.getBytes(r3)     // Catch: java.lang.Throwable -> L2c
            r0.write(r7)     // Catch: java.lang.Throwable -> L2c
        L28:
            com.bytedance.bdtracker.l0.b.a(r1)
            goto L42
        L2c:
            r7 = move-exception
        L2d:
            com.bytedance.bdtracker.d r2 = r6.a     // Catch: java.lang.Throwable -> L76
            com.bytedance.applog.log.IAppLogLogger r2 = r2.D     // Catch: java.lang.Throwable -> L76
            java.lang.String r3 = "EncryptUtils"
            java.util.List r3 = java.util.Collections.singletonList(r3)     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = "Convert string to bytes failed"
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L76
            r2.error(r3, r4, r7, r5)     // Catch: java.lang.Throwable -> L76
            com.bytedance.bdtracker.l0.b.a(r1)
        L42:
            byte[] r7 = r0.toByteArray()
            com.bytedance.bdtracker.d r0 = r6.a
            boolean r0 = r0.E
            if (r0 == 0) goto L75
            com.bytedance.bdtracker.d r0 = r6.a
            com.bytedance.applog.InitConfig r0 = r0.getInitConfig()
            if (r0 == 0) goto L70
            com.bytedance.bdtracker.d r0 = r6.a
            com.bytedance.applog.InitConfig r0 = r0.getInitConfig()
            com.bytedance.mpaas.IEncryptor r0 = r0.getEncryptor()
            if (r0 == 0) goto L70
            com.bytedance.bdtracker.d r0 = r6.a
            com.bytedance.applog.InitConfig r0 = r0.getInitConfig()
            com.bytedance.mpaas.IEncryptor r0 = r0.getEncryptor()
            int r1 = r7.length
            byte[] r7 = r0.encrypt(r7, r1)
            goto L75
        L70:
            int r0 = r7.length
            byte[] r7 = com.bytedance.applog.encryptor.EncryptorUtil.encrypt(r7, r0)
        L75:
            return r7
        L76:
            r7 = move-exception
            com.bytedance.bdtracker.l0.b.a(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.o4.b(java.lang.String):byte[]");
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str) || !this.a.E) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String encodedQuery = uri.getEncodedQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : d) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (Pair pair : arrayList) {
            builderBuildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(b(encodedQuery), 8)));
        return builderBuildUpon.build().toString();
    }

    public static HashMap<String, String> a(HashMap<String, String> map, d dVar) {
        map.put("Content-Type", dVar.E ? "application/octet-stream;tt-data=" + ((dVar.getInitConfig() == null || dVar.getInitConfig().getEncryptor() == null || !(dVar.getInitConfig().getEncryptor() instanceof z)) ? "a" : ((z) dVar.getInitConfig().getEncryptor()).encryptorType()) : MediaTypeUtils.APPLICATION_JSON);
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.bytedance.applog.IAppLogInstance r5, org.json.JSONObject r6) {
        /*
            boolean r5 = r5.getEncryptAndCompress()
            if (r5 == 0) goto L6c
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]
            r0 = 1
            r1 = 0
            java.lang.String r2 = "AES"
            javax.crypto.KeyGenerator r2 = javax.crypto.KeyGenerator.getInstance(r2)     // Catch: java.lang.Throwable -> L5b
            java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch: java.lang.Throwable -> L5b
            r3.<init>()     // Catch: java.lang.Throwable -> L5b
            r4 = 128(0x80, float:1.8E-43)
            r2.init(r4, r3)     // Catch: java.lang.Throwable -> L5b
            javax.crypto.SecretKey r2 = r2.generateKey()     // Catch: java.lang.Throwable -> L5b
            byte[] r2 = r2.getEncoded()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r2 = a(r2)     // Catch: java.lang.Throwable -> L5b
            r5[r1] = r2     // Catch: java.lang.Throwable -> L5b
            r2 = 8
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L5b
            r3.nextBytes(r2)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r2 = a(r2)     // Catch: java.lang.Throwable -> L5b
            r5[r0] = r2     // Catch: java.lang.Throwable -> L5b
            r2 = r5[r1]     // Catch: java.lang.Throwable -> L5b
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L5b
            if (r2 != 0) goto L5b
            r2 = r5[r1]     // Catch: java.lang.Throwable -> L5b
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L5b
            r3 = 32
            if (r2 != r3) goto L5b
            r2 = r5[r0]     // Catch: java.lang.Throwable -> L5b
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L5b
            if (r2 != 0) goto L5b
            r2 = r5[r0]     // Catch: java.lang.Throwable -> L5b
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L5b
            r3 = 16
            if (r2 != r3) goto L5b
            goto L5c
        L5b:
            r5 = 0
        L5c:
            if (r5 == 0) goto L6c
            java.lang.String r2 = "key"
            r1 = r5[r1]     // Catch: java.lang.Throwable -> L6c
            r6.put(r2, r1)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r1 = "iv"
            r5 = r5[r0]     // Catch: java.lang.Throwable -> L6c
            r6.put(r1, r5)     // Catch: java.lang.Throwable -> L6c
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.o4.a(com.bytedance.applog.IAppLogInstance, org.json.JSONObject):void");
    }
}
