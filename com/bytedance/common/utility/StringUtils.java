package com.bytedance.common.utility;

import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.Character;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class StringUtils {
    private static final int CHAR_12288 = 12288;
    private static final int CHAR_127 = 127;
    private static final int CHAR_32 = 32;
    private static final int CHAR_65248 = 65248;
    private static final int CHAR_65280 = 65280;
    private static final int CHAR_65375 = 65375;
    private static final int CHAR_MAX = 31;
    public static final String EMPTY = "";
    private static final long G = 1073741824;

    /* renamed from: K, reason: collision with root package name */
    private static final long f753K = 1024;
    private static final long M = 1048576;
    private static final int STRING_MAX_NUM = 255;
    private static final long T = 1099511627776L;
    private static final int XOR_MASK = 5;

    private StringUtils() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean equal(String str, String str2) {
        return (isEmpty(str) && isEmpty(str2)) || (str != null && str.equals(str2));
    }

    public static String ellipsize(String str, int i) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= str.length()) {
                break;
            }
            char cCharAt = str.charAt(i2);
            i3 = (cCharAt <= 0 || cCharAt > 255) ? i3 + 2 : i3 + 1;
            if (i3 > i) {
                sb.append("...");
                break;
            }
            sb.append(cCharAt);
            i2++;
        }
        return sb.toString();
    }

    public static void escapeEcmaScript(StringBuilder sb, String str, boolean z) {
        if (z) {
            sb.append("\"");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                sb.append("\\f");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"' || cCharAt == '\\') {
                sb.append('\\').append(cCharAt);
            } else if (cCharAt != 8232 && cCharAt != 8233) {
                switch (cCharAt) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    default:
                        if (cCharAt <= 31) {
                            sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                            break;
                        } else {
                            sb.append(cCharAt);
                            break;
                        }
                }
            } else {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            }
        }
        if (z) {
            sb.append("\"");
        }
    }

    public static String removeBlank(String str) {
        if (isEmpty(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public static HashMap<String, String> parseResponse(String str) {
        String[] strArrSplit = str.substring(str.indexOf(123) + 1, str.lastIndexOf(125)).split(",");
        for (int i = 0; i < strArrSplit.length; i++) {
            strArrSplit[i] = strArrSplit[i].trim();
        }
        HashMap<String, String> map = new HashMap<>();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split(":", 2);
            map.put(clean(strArrSplit2[0]), clean(strArrSplit2[1]));
        }
        return map;
    }

    public static String clean(String str) {
        int iIndexOf = str.indexOf(34);
        int iLastIndexOf = str.lastIndexOf(34);
        return (iIndexOf < 0 || iLastIndexOf <= iIndexOf) ? str : str.substring(iIndexOf + 1, iLastIndexOf).trim();
    }

    public static String getShortDateTime(String str) {
        int iIndexOf = str.indexOf(45) + 1;
        int iLastIndexOf = str.lastIndexOf(58);
        return (iIndexOf <= 0 || iLastIndexOf <= 0) ? str : str.substring(iIndexOf, iLastIndexOf);
    }

    public static String toSBC(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                charArray[i] = 12288;
            } else if (c < 127 && c > ' ') {
                charArray[i] = (char) (c + CHAR_65248);
            }
        }
        return new String(charArray);
    }

    public static String toDBC(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (isChinese(charArray[i])) {
                char c = charArray[i];
                if (c == 12288) {
                    charArray[i] = ' ';
                } else if (c > 65280 && c < CHAR_65375) {
                    charArray[i] = (char) (c - CHAR_65248);
                }
            }
        }
        return new String(charArray);
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(c);
        return unicodeBlockOf == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlockOf == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlockOf == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlockOf == Character.UnicodeBlock.GENERAL_PUNCTUATION || unicodeBlockOf == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || unicodeBlockOf == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static String handleAdClickTrackUrl(String str) {
        if (isEmpty(str)) {
            return str;
        }
        try {
            return str.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String format(long j, long j2, String str) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        return new DecimalFormat("#.##").format(d) + " " + str;
    }

    public static String bytesToHuman(long j) {
        long[] jArr = {T, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return format(j, j2, strArr[i]);
            }
        }
        return null;
    }

    public static String mapToString(Map<String, String> map) throws JSONException {
        if (map == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (!isEmpty(str) && !isEmpty(str2)) {
                    jSONObject.put(str, str2);
                }
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, String> stringToMap(String str, Map<String, String> map) throws JSONException {
        if (isEmpty(str) || map == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject.getString(next);
                if (!isEmpty(next) && !isEmpty(string)) {
                    map.put(next, string);
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }

    public static String strEncode(String str) {
        if (isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String encryptWithXor(String str) throws UnsupportedEncodingException {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] ^ 5);
            }
            return DigestUtils.toHexString(bytes, 0, bytes.length);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String decryptWithXor(String str, Boolean... boolArr) {
        byte[] bArrHexStringToBytes;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (boolArr != null && boolArr.length > 0 && boolArr[0].booleanValue()) {
                bArrHexStringToBytes = Base64.decode(str, 0);
            } else {
                bArrHexStringToBytes = DigestUtils.hexStringToBytes(str);
            }
            for (int i = 0; i < bArrHexStringToBytes.length; i++) {
                bArrHexStringToBytes[i] = (byte) (bArrHexStringToBytes[i] ^ 5);
            }
            return new String(bArrHexStringToBytes, 0, bArrHexStringToBytes.length, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public static String trimString(String str) {
        return (str == null || str.length() == 0) ? str : str.trim();
    }

    public static String compressWithGzip(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        if (isEmpty(str)) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        }
        try {
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String hexString = DigestUtils.toHexString(byteArray, 0, byteArray.length);
            try {
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
            } catch (Throwable unused) {
            }
            return hexString;
        } catch (Throwable th3) {
            th = th3;
            try {
                Logger.d("Thread", th.getMessage());
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
                return null;
            } finally {
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            }
        }
    }

    public static String decompressWithGzip(String str) throws IOException {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        BufferedReader bufferedReader;
        if (isEmpty(str)) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(DigestUtils.hexStringToBytes(str));
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, "UTF-8"));
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        }
                        String string = sb.toString();
                        try {
                            bufferedReader.close();
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return string;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            Logger.d("Thread", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused2) {
                                    return null;
                                }
                            }
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused3) {
                                }
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (Throwable th3) {
                th = th3;
                gZIPInputStream = null;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            gZIPInputStream = null;
            byteArrayInputStream = null;
            bufferedReader = null;
        }
    }
}
