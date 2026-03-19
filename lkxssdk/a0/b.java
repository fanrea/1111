package lkxssdk.a0;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b {
    public static long a;

    public static int a(float f) {
        return (int) ((f * lkxssdk.a.a.d().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String a(long j) {
        String str;
        String str2;
        long j2 = j / 1000;
        if (j2 >= 3600) {
            str = (j2 / 3600) + ":";
            j2 %= 3600;
        } else {
            str = "00:";
        }
        if (j2 >= 60) {
            str2 = str + (j2 / 60) + ":";
            j2 %= 60;
        } else {
            str2 = str + "00:";
        }
        return (j2 > 9 ? new StringBuilder().append(str2) : new StringBuilder().append(str2).append("0")).append(j2).toString();
    }

    public static String a(boolean z, String str) {
        StringBuilder sb;
        String str2;
        if (TextUtils.isEmpty(str) || !str.startsWith("//")) {
            return str;
        }
        if (z) {
            sb = new StringBuilder();
            str2 = "https:";
        } else {
            sb = new StringBuilder();
            str2 = "http:";
        }
        return sb.append(str2).append(str).toString();
    }

    public static String b(long j) {
        StringBuilder sbAppend;
        String str;
        if (j < 1024) {
            sbAppend = new StringBuilder().append(j);
            str = "B";
        } else if (j < 1048576) {
            sbAppend = new StringBuilder().append(j / 1024);
            str = "KB";
        } else if (j < 1073741824) {
            sbAppend = new StringBuilder().append(String.format("%.1f", Float.valueOf(j / 1048576.0f)));
            str = "MB";
        } else {
            sbAppend = new StringBuilder().append(String.format("%.2f", Float.valueOf(j / 1.0737418E9f)));
            str = "GB";
        }
        return sbAppend.append(str).toString();
    }
}
