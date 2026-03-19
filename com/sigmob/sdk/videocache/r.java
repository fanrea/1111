package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.czhj.sdk.logger.SigmobLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class r {
    static final int a = 8192;
    static final int b = 16;

    static String a(String url) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(url);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    private static String a(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bytes) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return stringBuffer.toString();
    }

    static String a(byte[] data, int length) {
        int iMin = Math.min(16, Math.max(length, 0));
        String string = Arrays.toString(Arrays.copyOfRange(data, 0, iMin));
        return iMin < length ? string.substring(0, string.length() - 1) + ", ...]" : string;
    }

    static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                SigmobLog.e("Error closing resource", e);
            }
        }
    }

    static void a(byte[] buffer, long offset, int length) {
        o.a(buffer, "Buffer must be not null!");
        o.a(offset >= 0, "Data offset must be positive!");
        o.a(length >= 0 && length <= buffer.length, "Length must be in range [0..buffer.length]");
    }

    static String b(String url) {
        try {
            return URLEncoder.encode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    static String c(String url) {
        try {
            return URLDecoder.decode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    public static String d(String string) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(string.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}
