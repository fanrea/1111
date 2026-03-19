package com.kwad.sdk.liteapi.encrypt;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.liteapi.KsSecSDKWrapper;
import com.kwad.sdk.liteapi.LiteApiLogger;
import java.util.Arrays;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class LiteKsSig1Util {
    private static final boolean DEBUG = false;
    private static final String JOIN_STRING = "&";
    public static final String PARAM_SIGNATURE = "Ks-Sig1";
    private static final String TAG = "KsSig1Util";

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public static void sigRequest(Context context, String str, Map<String, String> map, String str2) {
        map.put(PARAM_SIGNATURE, atlasSign(context, generateInputString(str, str2)));
    }

    private static String generateInputString(String str, String str2) {
        Uri uri = Uri.parse(str);
        return uri.getPath() + "&" + getSortedQuery(uri.getQuery()) + "&" + str2;
    }

    private static String getSortedQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyIfNull(str);
        }
        String[] strArrSplit = str.split("&");
        Arrays.sort(strArrSplit);
        return TextUtils.join("&", strArrSplit);
    }

    public static String atlasSign(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                String strDoSign = KsSecSDKWrapper.doSign(context, str);
                return strDoSign == null ? "" : strDoSign;
            } catch (Throwable th) {
                LiteApiLogger.printStackTraceOnly(th);
            }
        }
        return "";
    }
}
