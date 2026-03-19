package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class i50 {
    private static final boolean a;
    private static final boolean b;
    private static volatile Boolean c;
    private static volatile Integer d;

    /* compiled from: A */
    public interface a {
        void a();
    }

    static {
        a = r1.d().f().a("iscfwe", 1) == 1;
        b = r1.d().f().a("gvfwe", 1) == 1;
    }

    public static int a(Context context, String str, String str2, a aVar) {
        return pro.getIresult(3, 1, context, str, str2, aVar);
    }

    private static int a(Context context, String str, String str2, String str3, String str4, int i, a aVar) {
        return pro.getIresult(4, 1, context, str, str2, str3, str4, Integer.valueOf(i), aVar);
    }

    private static int a(Context context, String str, String str2, String str3, String str4, boolean z) {
        return pro.getIresult(5, 1, context, str, str2, str3, str4, Boolean.valueOf(z));
    }

    private static int a(Context context, String str, String str2, String str3, String str4, byte[] bArr) {
        return pro.getIresult(6, 1, context, str, str2, str3, str4, bArr);
    }

    private static int a(Object obj) {
        return pro.getIresult(7, 1, obj);
    }

    private static int a(Object obj, Object obj2) {
        return pro.getIresult(8, 1, obj, obj2);
    }

    private static int a(Object obj, String str) {
        return pro.getIresult(9, 1, obj, str);
    }

    public static int a(String str, String str2, String str3, String str4, Bitmap bitmap) {
        return pro.getIresult(10, 1, str, str2, str3, str4, bitmap);
    }

    public static int a(JSONObject jSONObject, int i) {
        return pro.getIresult(11, 1, jSONObject, Integer.valueOf(i));
    }

    private static int a(JSONObject jSONObject, int i, a aVar) {
        return pro.getIresult(12, 1, jSONObject, Integer.valueOf(i), aVar);
    }

    private static Pair<Integer, Object> a(Context context, String str) {
        return (Pair) pro.getobjresult(13, 1, context, str);
    }

    public static Pair<Integer, Boolean> a(JSONObject jSONObject, a aVar) {
        return (Pair) pro.getobjresult(14, 1, jSONObject, aVar);
    }

    private static Object a(String str, String str2, String str3, byte[] bArr) {
        return pro.getobjresult(15, 1, str, str2, str3, bArr);
    }

    public static String a() {
        return (String) pro.getobjresult(16, 1, new Object[0]);
    }

    public static JSONObject a(k50 k50Var) {
        return (JSONObject) pro.getobjresult(17, 1, k50Var);
    }

    public static boolean a(boolean z) {
        return pro.getZresult(18, 1, Boolean.valueOf(z));
    }

    public static int b() {
        return pro.getIresult(19, 1, new Object[0]);
    }

    private static Boolean b(boolean z) {
        return (Boolean) pro.getobjresult(20, 1, Boolean.valueOf(z));
    }

    public static String c() {
        return (String) pro.getobjresult(21, 1, new Object[0]);
    }

    private static JSONObject d() {
        return (JSONObject) pro.getobjresult(22, 1, new Object[0]);
    }

    public static int e() {
        return pro.getIresult(23, 1, new Object[0]);
    }

    private static Integer f() {
        return (Integer) pro.getobjresult(24, 1, new Object[0]);
    }

    public static void g() {
        pro.getVresult(25, 1, new Object[0]);
    }

    private i50() {
    }
}
