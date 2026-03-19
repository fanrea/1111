package com.kuaishou.security.kste.logic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class PerfUtils {
    private static final String DEVICE_ID = "3";
    private static final String DRMCLIENTSDK_SESSION_ID = "0";
    private static final String ERRORCODE_ID = "8";
    private static final String EXCEPTION_DESC_ID = "9";
    private static final String KPN_ID = "5";
    public static final String LOG_ID_DRM_DG_TOKEN = "800100";
    public static final String LOG_ID_DRM_ERR_REPORT = "800101";
    private static final String NATIVE_SECURITY_SESSION_ID = "-1";
    private static final String OTHERINFO_ID = "7";
    private static final String PLATFORM_ID = "4";
    private static final String PLAYER_SESSION_ID = "6";
    private static final String RANDOM_ID = "-2";
    private static final String TOKEN_ID = "1";
    private static final String USER_ID = "2";
    private final boolean isPrepareHandler = false;

    public enum DRMCLIENTERROR {
        ERROR_SERVER_NO_RESPONSE(20010001),
        ERROR_REQUEST_FAIL(20010002),
        ERROR_SERVER_UNKNOWN(20010003),
        ERROR_SERVER_MISSING_PARAMETER(20010004),
        ERROR_SERVER_INVALID_PARAMETER(20010005),
        ERROR_SERVER_TOKEN_EXPIRED(20010006),
        ERROR_SERVER_SIGNATURE_NOT_MATCH(20010007),
        ERROR_SERVER_TOKEN_INVALID(20010008),
        ERROR_NETWORK_UNKNOWN(20010009),
        ERROR_NETWORK_UNSUPPORTED(20010010),
        ERROR_NETWORK_RESOLVE(20010011),
        ERROR_NETWORK_CONNECT_TIMEOUT(20010012),
        ERROR_NETWORK_COULD_NOT_CONNECT(20010013),
        ERROR_NETWORK_HTTP_403(20010014),
        ERROR_NETWORK_HTTP_404(20010015),
        ERROR_NETWORK_HTTP_4XX(20010016),
        ERROR_NETWORK_HTTP_5XX(20010017),
        ERROR_KSDRM_UNKNOWN(20012001),
        ERROR_KSDRM_EXTRADECTYPE_UNIMPLEMENTED(20012002),
        ERROR_KSDRM_TOKEN_KEY_NOTFOUND(20012003),
        ERROR_KSDRM_DECRYPT_ERROR(20012004);

        private final int value;

        DRMCLIENTERROR(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    final class Holder {
        private static final PerfUtils sInstance = new PerfUtils();

        private Holder() {
        }
    }

    public static String bytesToHex(byte[] bArr) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = charArray[i2 >>> 4];
            cArr[i3 + 1] = charArray[i2 & 15];
        }
        return new String(cArr);
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static PerfUtils get() {
        return Holder.sInstance;
    }

    public static String getFileMD5(File file) throws NoSuchAlgorithmException, IOException {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int i = fileInputStream.read(bArr, 0, 1024);
                if (i == -1) {
                    fileInputStream.close();
                    return bytesToHexString(messageDigest.digest());
                }
                messageDigest.update(bArr, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void reportJavaException(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", "");
            jSONObject.put("2", "");
            jSONObject.put("3", "");
            jSONObject.put("4", "ANDROID");
            jSONObject.put("5", "KUAISHOU");
            jSONObject.put("6", "");
            jSONObject.put("7", "");
            jSONObject.put("8", i);
            jSONObject.put("9", str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void reportNativeExceptionInfo(String str) {
    }
}
