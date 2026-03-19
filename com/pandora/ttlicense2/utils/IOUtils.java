package com.pandora.ttlicense2.utils;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class IOUtils {
    public static Charset charset() {
        if (Build.VERSION.SDK_INT >= 19) {
            return StandardCharsets.UTF_8;
        }
        return Charset.forName("UTF-8");
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String headerValue(Map<String, List<String>> headers, String name) {
        List<String> list;
        if (headers == null || (list = headers.get(name)) == null || list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static String inputStream2String(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return byteArrayOutputStream.toString(charset().name());
                }
            } catch (IOException unused) {
                return null;
            }
        }
    }
}
