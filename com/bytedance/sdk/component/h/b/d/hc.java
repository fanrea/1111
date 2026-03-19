package com.bytedance.sdk.component.h.b.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static boolean d() {
        return com.bytedance.sdk.component.h.b.getContext() != null;
    }

    private static ContentResolver hc() {
        try {
            if (d()) {
                return com.bytedance.sdk.component.h.b.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Context getContext() {
        return com.bytedance.sdk.component.h.b.getContext();
    }

    private static String b() {
        return u.hc + "/t_sp/";
    }

    private static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : "?sp_file_name=".concat(String.valueOf(str));
    }

    private static String b(String str, String str2, String str3) {
        return b() + str + "/" + str2 + b(str3);
    }

    public static synchronized void d(String str, String str2, Boolean bool) {
        if (d()) {
            try {
                ContentResolver contentResolverHc = hc();
                if (contentResolverHc != null) {
                    Uri uri = Uri.parse(b(TypedValues.Custom.S_BOOLEAN, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(com.alipay.sdk.m.p0.b.d, bool);
                    contentResolverHc.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void d(String str, String str2, String str3) {
        if (d()) {
            try {
                ContentResolver contentResolverHc = hc();
                if (contentResolverHc != null) {
                    Uri uri = Uri.parse(b(TypedValues.Custom.S_STRING, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(com.alipay.sdk.m.p0.b.d, str3);
                    contentResolverHc.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void d(String str, String str2, Integer num) {
        if (d()) {
            try {
                ContentResolver contentResolverHc = hc();
                if (contentResolverHc != null) {
                    Uri uri = Uri.parse(b("int", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(com.alipay.sdk.m.p0.b.d, num);
                    contentResolverHc.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void d(String str, String str2, Long l) {
        if (d()) {
            try {
                ContentResolver contentResolverHc = hc();
                if (contentResolverHc != null) {
                    Uri uri = Uri.parse(b("long", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(com.alipay.sdk.m.p0.b.d, l);
                    contentResolverHc.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void d(String str, String str2, Float f) {
        if (d()) {
            try {
                ContentResolver contentResolverHc = hc();
                if (contentResolverHc != null) {
                    Uri uri = Uri.parse(b(TypedValues.Custom.S_FLOAT, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(com.alipay.sdk.m.p0.b.d, f);
                    contentResolverHc.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void d(String str, String str2, Set<String> set) {
        if (d()) {
            try {
                ContentResolver contentResolverHc = hc();
                if (contentResolverHc != null) {
                    Uri uri = Uri.parse(b("string_set", str2, str));
                    ContentValues contentValues = new ContentValues();
                    HashSet hashSet = new HashSet();
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().replace(",", "__COMMA__"));
                    }
                    contentValues.put(com.alipay.sdk.m.p0.b.d, hashSet.toString());
                    contentResolverHc.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String hc(String str, String str2, String str3) {
        String type;
        if (!d()) {
            return str3;
        }
        try {
            ContentResolver contentResolverHc = hc();
            if (contentResolverHc != null && (type = contentResolverHc.getType(Uri.parse(b(TypedValues.Custom.S_STRING, str2, str)))) != null && !type.equals(ILogConst.CACHE_PLAY_REASON_NULL)) {
                if (!TextUtils.isEmpty(type)) {
                    return type;
                }
            }
        } catch (Throwable unused) {
        }
        return str3;
    }

    public static int d(String str, String str2, int i) {
        String type;
        if (!d()) {
            return i;
        }
        try {
            ContentResolver contentResolverHc = hc();
            if (contentResolverHc != null && (type = contentResolverHc.getType(Uri.parse(b("int", str2, str)))) != null && !type.equals(ILogConst.CACHE_PLAY_REASON_NULL) && !TextUtils.isEmpty(type)) {
                return Integer.parseInt(type);
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static float d(String str, String str2, float f) {
        String type;
        if (!d()) {
            return f;
        }
        try {
            ContentResolver contentResolverHc = hc();
            if (contentResolverHc != null && (type = contentResolverHc.getType(Uri.parse(b(TypedValues.Custom.S_FLOAT, str2, str)))) != null && !type.equals(ILogConst.CACHE_PLAY_REASON_NULL) && !TextUtils.isEmpty(type)) {
                return Float.parseFloat(type);
            }
        } catch (Throwable unused) {
        }
        return f;
    }

    public static boolean d(String str, String str2, boolean z) {
        String type;
        if (!d()) {
            return z;
        }
        try {
            ContentResolver contentResolverHc = hc();
            if (contentResolverHc != null && (type = contentResolverHc.getType(Uri.parse(b(TypedValues.Custom.S_BOOLEAN, str2, str)))) != null && !type.equals(ILogConst.CACHE_PLAY_REASON_NULL) && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static long d(String str, String str2, long j) {
        String type;
        if (!d()) {
            return j;
        }
        try {
            ContentResolver contentResolverHc = hc();
            if (contentResolverHc != null && (type = contentResolverHc.getType(Uri.parse(b("long", str2, str)))) != null && !type.equals(ILogConst.CACHE_PLAY_REASON_NULL) && !TextUtils.isEmpty(type)) {
                return Long.parseLong(type);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public static Set<String> hc(String str, String str2, Set<String> set) {
        String type;
        if (!d()) {
            return set;
        }
        try {
            ContentResolver contentResolverHc = hc();
            if (contentResolverHc == null || (type = contentResolverHc.getType(Uri.parse(b("string_set", str2, str)))) == null || type.equals(ILogConst.CACHE_PLAY_REASON_NULL) || TextUtils.isEmpty(type) || !type.matches("\\[.*\\]")) {
                return set;
            }
            String strSubstring = type.substring(1, type.length() - 1);
            String[] strArrSplit = strSubstring.split(", ");
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(strSubstring)) {
                for (String str3 : strArrSplit) {
                    hashSet.add(str3.replace("__COMMA__", ", "));
                }
            }
            return hashSet;
        } catch (Throwable unused) {
        }
        return set;
    }

    public static boolean d(String str, String str2) {
        String type;
        if (!d()) {
            return false;
        }
        try {
            ContentResolver contentResolverHc = hc();
            if (contentResolverHc != null && (type = contentResolverHc.getType(Uri.parse(b("contain", str2, str)))) != null && !type.equals(ILogConst.CACHE_PLAY_REASON_NULL) && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void hc(String str, String str2) {
        if (d()) {
            try {
                ContentResolver contentResolverHc = hc();
                if (contentResolverHc != null) {
                    contentResolverHc.delete(Uri.parse(b("long", str2, str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(String str) {
        if (d()) {
            try {
                ContentResolver contentResolverHc = hc();
                if (contentResolverHc != null) {
                    contentResolverHc.delete(Uri.parse(b() + "clean" + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.HashSet, java.util.Set] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Long] */
    public static Map<String, ?> hc(String str) {
        Cursor cursorQuery;
        String string;
        if (!d()) {
            return null;
        }
        try {
            ContentResolver contentResolverHc = hc();
            if (contentResolverHc != null) {
                cursorQuery = contentResolverHc.query(Uri.parse(b() + "get_all" + b(str)), null, null, null, null);
                try {
                    HashMap map = new HashMap();
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex("cursor_name");
                        int columnIndex2 = cursorQuery.getColumnIndex("cursor_type");
                        int columnIndex3 = cursorQuery.getColumnIndex("cursor_value");
                        do {
                            String string2 = cursorQuery.getString(columnIndex);
                            String string3 = cursorQuery.getString(columnIndex2);
                            if (string3.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
                                String string4 = cursorQuery.getString(columnIndex3);
                                String str2 = string4;
                                boolean zContains = string4.contains("__COMMA__");
                                string = string4;
                                if (zContains) {
                                    String str3 = string4;
                                    boolean zMatches = string4.matches("\\[.*\\]");
                                    string = string4;
                                    if (zMatches) {
                                        String strSubstring = string4.substring(1, string4.length() - 1);
                                        String[] strArrSplit = strSubstring.split(", ");
                                        ?? hashSet = new HashSet();
                                        if (!TextUtils.isEmpty(strSubstring)) {
                                            for (String str4 : strArrSplit) {
                                                hashSet.add(str4.replace("__COMMA__", ", "));
                                            }
                                        }
                                        string = hashSet;
                                    }
                                }
                            } else if (string3.equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
                                string = cursorQuery.getString(columnIndex3);
                            } else if (string3.equalsIgnoreCase("int")) {
                                string = Integer.valueOf(cursorQuery.getInt(columnIndex3));
                            } else if (string3.equalsIgnoreCase("long")) {
                                string = Long.valueOf(cursorQuery.getLong(columnIndex3));
                            } else if (string3.equalsIgnoreCase(TypedValues.Custom.S_FLOAT)) {
                                string = Float.valueOf(cursorQuery.getFloat(columnIndex3));
                            } else {
                                string = string3.equalsIgnoreCase("string_set") ? cursorQuery.getString(columnIndex3) : null;
                            }
                            map.put(string2, string);
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return map;
                } catch (Throwable unused) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return null;
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return null;
    }
}
