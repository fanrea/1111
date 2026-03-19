package com.kwai.middleware.azeroth.network;

import android.text.TextUtils;
import com.alipay.sdk.m.n.a;
import com.kwai.middleware.azeroth.utils.Charsets;
import com.kwai.middleware.azeroth.utils.CloseableUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class RequestUtil {
    private RequestUtil() {
    }

    public static String paramsToString(Map<String, String> map) throws UnsupportedEncodingException {
        String strEncode;
        if (map == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (value != null) {
                try {
                    strEncode = URLEncoder.encode(value, Charsets.UTF_8.name());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                strEncode = "";
            }
            arrayList.add(entry.getKey() + a.h + strEncode);
        }
        return TextUtils.join(com.alipay.sdk.m.s.a.n, arrayList);
    }

    public static String read(InputStream inputStream) throws Throwable {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        if (inputStream == null) {
            return "";
        }
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                    } else {
                        String string = sb.toString();
                        CloseableUtils.closeQuietly(bufferedReader);
                        CloseableUtils.closeQuietly(inputStreamReader);
                        return string;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                CloseableUtils.closeQuietly(bufferedReader);
                CloseableUtils.closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            bufferedReader = null;
        }
    }
}
