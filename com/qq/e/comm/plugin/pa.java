package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.kuaishou.socket.nano.SocketMessages;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class pa {
    private static List<String> a;
    private static final boolean b;
    private static final boolean c;

    static {
        b = r1.d().f().a("mipaddr", 1) == 1 && !b("mipaddr");
        c = r1.d().f().a("wipaddr", 1) == 1 && !b("wipaddr");
    }

    public static int a(Intent intent) {
        return pro.getIresult(488, 1, intent);
    }

    public static long a() {
        return pro.getJresult(489, 1, new Object[0]);
    }

    private static boolean a(int i) throws IOException {
        return pro.getZresult(SocketMessages.PayloadType.SC_AUTHOR_MUSIC_OPENED, 1, Integer.valueOf(i));
    }

    private static boolean a(Context context) {
        return pro.getZresult(SocketMessages.PayloadType.SC_AUTHOR_MUSIC_CLOSED, 1, context);
    }

    public static int b(Intent intent) {
        return pro.getIresult(492, 1, intent);
    }

    private static boolean b(int i) throws IOException {
        return pro.getZresult(493, 1, Integer.valueOf(i));
    }

    private static boolean b(Context context) throws IllegalStateException {
        return pro.getZresult(494, 1, context);
    }

    public static Intent c(Context context) {
        return (Intent) pro.getobjresult(495, 1, context);
    }

    public static String c() {
        return (String) pro.getobjresult(496, 1, new Object[0]);
    }

    public static boolean c(Intent intent) {
        return pro.getZresult(497, 1, intent);
    }

    private static String d() {
        return (String) pro.getobjresult(498, 1, new Object[0]);
    }

    public static boolean d(Context context) {
        return pro.getZresult(499, 1, context);
    }

    public static boolean d(Intent intent) {
        return pro.getZresult(500, 1, intent);
    }

    public static boolean e() {
        return pro.getZresult(501, 1, new Object[0]);
    }

    public static boolean e(Context context) {
        return pro.getZresult(502, 1, context);
    }

    public static boolean f(Context context) {
        return pro.getZresult(503, 1, context);
    }

    private static String d(String str) throws Throwable {
        BufferedReader bufferedReader;
        StringBuilder sb;
        try {
            sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), d6.a));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            String str2 = "";
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb.append(str2);
                sb.append(line);
                str2 = "\n";
            }
            String string = sb.toString();
            bufferedReader.close();
            return string;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    private static String c(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    private static boolean c(String str) {
        if (a == null) {
            String[] strArrSplit = r1.d().f().b("oflt", "device_id,android_id,taid,oaid,netop,mipaddr,wipaddr,caes").split(",");
            if (strArrSplit.length > 0) {
                a = Arrays.asList(strArrSplit);
            } else {
                a = new ArrayList();
            }
        }
        return a.contains(str);
    }

    private static boolean a(String str) {
        JSONObject jSONObjectOptJSONObject = GlobalSetting.getSettings().optJSONObject(GlobalSetting.AGREE_PRIVACY_KEY);
        return (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.optBoolean(str, true)) ? false : true;
    }

    public static boolean b(String str) {
        return a(str) && c(str);
    }

    public static Pair<Integer, Integer> b() {
        Display defaultDisplay = ((WindowManager) r1.d().a().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return new Pair<>(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
    }
}
