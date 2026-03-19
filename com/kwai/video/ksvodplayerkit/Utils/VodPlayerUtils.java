package com.kwai.video.ksvodplayerkit.Utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.kwai.video.ksvodplayerkit.CacheKeyGenerator;
import com.kwai.video.ksvodplayerkit.Logger.KSVodLogger;
import com.kwai.video.ksvodplayerkit.MultiRate.HlsAdaptationModel;
import com.kwai.video.ksvodplayerkit.MultiRate.HlsAdaptationModel_JsonUtils;
import com.kwai.video.ksvodplayerkit.MultiRate.HlsRepresentation;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VodPlayerUtils {
    static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static volatile CacheKeyGenerator mCacheKeyGenerator;

    public static boolean isLocalVideoPhoto(String str) {
        if (TextUtils.isEmpty(str) || !n.z.equals(Uri.parse(str).getScheme())) {
            return false;
        }
        return new File(Uri.parse(str).getPath()).exists();
    }

    public static boolean isNetworkPlayUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith("http:") || str.toLowerCase().startsWith("https:");
    }

    public static boolean isM3u8(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains(".m3u8");
    }

    public static boolean isHttps(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith("https:");
    }

    public static void setCacheKeyGenerator(CacheKeyGenerator cacheKeyGenerator) {
        mCacheKeyGenerator = cacheKeyGenerator;
    }

    public static String getCacheKey(String str) {
        if (mCacheKeyGenerator != null) {
            return mCacheKeyGenerator.getCacheKey(str);
        }
        String lowerCase = fileTypeByUrl(str).toLowerCase(Locale.US);
        try {
            String path = Uri.parse(str).getPath();
            if (!TextUtils.isEmpty(path)) {
                return md5Hex(path) + lowerCase;
            }
        } catch (Exception e) {
            KSVodLogger.e("VodPlayerUtils", e.getMessage());
        }
        return str;
    }

    public static String fileTypeByUrl(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path == null) {
                    return ".xxx";
                }
                int iLastIndexOf = path.lastIndexOf(46);
                String strSubstring = path.substring(iLastIndexOf);
                return (iLastIndexOf < 0 || iLastIndexOf >= path.length() + (-2)) ? ".mp4" : strSubstring != null ? strSubstring.toLowerCase() : strSubstring;
            } catch (Throwable th) {
                KSVodLogger.e("VodPlayerUtils", "fail to parse ext from url: " + str, th);
            }
        }
        return ".mp4";
    }

    public static String md5Hex(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() == 0) {
            return "";
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(str.getBytes("UTF-8"));
        byte[] bArrDigest = messageDigest.digest();
        if (bArrDigest != null && bArrDigest.length > 0) {
            return toHexString(bArrDigest, 0, bArrDigest.length);
        }
        return null;
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i >= 0 && i + i2 <= bArr.length) {
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = bArr[i5 + i] & 255;
                int i7 = i4 + 1;
                char[] cArr2 = HEX_CHARS;
                cArr[i4] = cArr2[i6 >> 4];
                i4 = i7 + 1;
                cArr[i7] = cArr2[i6 & 15];
            }
            return new String(cArr, 0, i3);
        }
        throw new IndexOutOfBoundsException();
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static List<HlsRepresentation> getHlsRepresentations(String str) {
        ArrayList arrayList = new ArrayList();
        HlsAdaptationModel hlsAdaptationModelFromJson = HlsAdaptationModel_JsonUtils.fromJson(str);
        if (hlsAdaptationModelFromJson != null && hlsAdaptationModelFromJson.adaptationSet != null) {
            arrayList.addAll(hlsAdaptationModelFromJson.adaptationSet.representation);
        }
        return arrayList;
    }

    public static int getFirstScreen(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return new JSONObject(new JSONObject(str).getString("qos")).getJSONObject("rt_cost").getInt("first_screen");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
