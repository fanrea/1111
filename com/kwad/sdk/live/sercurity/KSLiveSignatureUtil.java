package com.kwad.sdk.live.sercurity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.kwad.sdk.live.audience.KSLiveInitModule;
import com.kwad.sdk.live.audience.test.KSLiveLogger;
import com.sigmob.sdk.base.n;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveSignatureUtil {
    private static final String FILTER_KEY_PREFIX = "__";
    private static final String JOIN_STRING = "&";
    public static final String PARAM_SIGNATURE = "__sig4";
    public static final String PARAM_SIGNATURE2 = "__pkgId";
    private static String TAG = "KSLiveSignatureUtil";

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public static void sigLiveRequest(String str, Map<String, String> map, Map<String, String> map2) {
        String strGenerateInputString = generateInputString(str, map, map2);
        String strAtlasSign = KSLiveSecurity.atlasSign(strGenerateInputString);
        KSLiveLogger.i("sigRequest", n.l, strGenerateInputString, "result", strAtlasSign);
        map2.put(PARAM_SIGNATURE, strAtlasSign);
        map2.put(PARAM_SIGNATURE2, getPkgId());
    }

    private static String generateInputString(String str, Map<String, String> map, Map<String, String> map2) {
        return str + "&" + TextUtils.join("&", getSortedParamList(map, map2));
    }

    private static List<String> getSortedParamList(Map<String, String> map, Map<String, String> map2) {
        ArrayList arrayList = new ArrayList(map.size() + map2.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!filterKey(key)) {
                arrayList.add(key + "=" + emptyIfNull(entry.getValue()));
            }
        }
        for (Map.Entry<String, String> entry2 : map2.entrySet()) {
            String key2 = entry2.getKey();
            if (!filterKey(key2)) {
                arrayList.add(key2 + "=" + emptyIfNull(entry2.getValue()));
            }
        }
        try {
            Collections.sort(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private static boolean filterKey(String str) {
        return str.startsWith(FILTER_KEY_PREFIX);
    }

    private static String getPkgId() {
        Context appContext = KSLiveInitModule.getInstance().getAppContext();
        if (appContext == null) {
            return "";
        }
        return appContext.getPackageName() + getSignMd5Str(appContext);
    }

    public static String getSignMd5Str(Context context) {
        try {
            Signature[] signatures = getSignatures(context);
            if (signatures != null && signatures.length > 0) {
                return md5ForByte(signatures[0].toByteArray());
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static Signature[] getSignatures(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String md5ForByte(byte[] bArr) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int length = bArrDigest.length;
            for (int i = 0; i < length; i++) {
                int i2 = bArrDigest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
