package ca.ca.ca.ca;

import android.content.SharedPreferences;

/* compiled from: outline */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static String a(StringBuilder sb, String str, String str2) {
        return sb.append(str).append(str2).toString();
    }

    public static StringBuilder a(String str) {
        return new StringBuilder().append(str);
    }

    public static void a(SharedPreferences sharedPreferences, String str, String str2) {
        sharedPreferences.edit().putString(str, str2).apply();
    }
}
