package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.pandora.common.utils.Times;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class m10 {
    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c);
            sb.append((char) 8203);
        }
        return sb.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Charset charset = d6.a;
        return new String(Base64.decode(str.getBytes(charset), 10), charset);
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(str.getBytes(d6.a), 10);
    }

    public static Pair<String, String> a(long j) {
        double d;
        String str = "B";
        if (j <= 0) {
            return new Pair<>("0", "B");
        }
        if (j < 1000) {
            d = j;
        } else if (j < 1000000) {
            double d2 = j;
            Double.isNaN(d2);
            d = d2 / 1000.0d;
            str = "KB";
        } else if (j < 1000000000) {
            double d3 = j;
            Double.isNaN(d3);
            d = d3 / 1000000.0d;
            str = "MB";
        } else {
            double d4 = j;
            Double.isNaN(d4);
            d = d4 / 1.0E9d;
            str = "GB";
        }
        return new Pair<>(String.format(Locale.getDefault(), "%.1f", Double.valueOf(d)), str);
    }

    public static String a(String str, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (str != null && i != 0) {
                    stringBuffer.append(str);
                }
                stringBuffer.append(strArr[i]);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean b(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static float a(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (Throwable unused) {
            return f;
        }
    }

    public static int a(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i;
        }
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                sb.append("\t");
                sb.append(stackTraceElement);
            }
        }
        return sb.toString();
    }

    public static String a() {
        return new SimpleDateFormat(Times.YYYY_MM_DD, Locale.getDefault()).format(new Date());
    }
}
