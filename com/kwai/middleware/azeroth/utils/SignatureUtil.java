package com.kwai.middleware.azeroth.utils;

import android.util.Base64;
import android.util.Log;
import com.alipay.sdk.m.s.a;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SignatureUtil {
    private static final String DOUBLE_UNDERLINE = "__";
    private static final String HMAC_SHA256 = "HmacSHA256";

    public static String createStringThatNeedToBeSigned(String str, String str2, Map<String, String> map, Map<String, String> map2, Nonce nonce) {
        return createStringThatNeedToBeSigned(str, str2, mergeParams(map, map2), nonce);
    }

    public static String createStringThatNeedToBeSigned(String str, String str2, Map<String, String> map, Nonce nonce) {
        Utils.checkNotNullOrEmpty(str, "method cannot be null or empty");
        Utils.checkNotNullOrEmpty(str2, "path cannot be null or empty");
        ArrayList arrayList = new ArrayList();
        arrayList.add(str.toUpperCase().trim());
        arrayList.add(str2.trim());
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : new TreeMap(map).entrySet()) {
            if (!((String) entry.getKey()).startsWith(DOUBLE_UNDERLINE)) {
                arrayList2.add(((String) entry.getKey()) + "=" + TextUtils.emptyIfNull((String) entry.getValue()));
            }
        }
        arrayList.addAll(arrayList2);
        if (nonce != null) {
            arrayList.add(nonce.toString().trim());
        }
        return android.text.TextUtils.join(a.n, arrayList);
    }

    public static String createSignature(String str, String str2, Map<String, String> map, Map<String, String> map2, String str3) {
        return TextUtils.isEmpty(str3) ? "" : createSignature(str, str2, mergeParams(map, map2), str3);
    }

    public static String createSignature(String str, String str2, Map<String, String> map, String str3) throws NoSuchAlgorithmException, InvalidKeyException {
        if (TextUtils.isEmpty(str3)) {
            return "";
        }
        Utils.checkNotNullOrEmpty(str, "method cannot be null or empty");
        Utils.checkNotNullOrEmpty(str2, "path cannot be null or empty");
        Nonce nonceNewNonce = Nonce.newNonce();
        byte[] bArrCreateHmacSha256Signature = createHmacSha256Signature(Base64.decode(str3, 0), createStringThatNeedToBeSigned(str, str2, map, nonceNewNonce).getBytes(Charsets.UTF_8));
        return bArrCreateHmacSha256Signature == null ? "" : Base64.encodeToString(concat(nonceNewNonce.toBytes(), bArrCreateHmacSha256Signature), 11);
    }

    public static Map<String, String> mergeParams(Map<String, String> map, Map<String, String> map2) {
        HashMap map3 = new HashMap();
        if (map != null) {
            map3.putAll(map);
        }
        if (map2 != null) {
            map3.putAll(map2);
        }
        return map3;
    }

    private static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] createHmacSha256Signature(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, InvalidKeyException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, HMAC_SHA256);
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            return mac.doFinal(bArr2);
        } catch (Exception e) {
            Log.e("open_azeroth", "Fail to generate the signature", e);
            return new byte[0];
        }
    }
}
