package com.lingku.xuanshang.xutils.db.table;

import android.text.TextUtils;
import java.util.Date;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class DbModel {
    public final HashMap<String, String> a = new HashMap<>();

    public void add(String str, String str2) {
        this.a.put(str, str2);
    }

    public boolean getBoolean(String str) {
        String str2 = this.a.get(str);
        if (str2 != null) {
            return str2.length() == 1 ? "1".equals(str2) : Boolean.valueOf(str2).booleanValue();
        }
        return false;
    }

    public HashMap<String, String> getDataMap() {
        return this.a;
    }

    public Date getDate(String str, long j) {
        return new Date(getLong(str, j));
    }

    public double getDouble(String str, double d) {
        String str2 = this.a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return d;
        }
        try {
            return Double.valueOf(str2).doubleValue();
        } catch (Throwable unused) {
            return d;
        }
    }

    public float getFloat(String str, float f) {
        String str2 = this.a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return f;
        }
        try {
            return Float.valueOf(str2).floatValue();
        } catch (Throwable unused) {
            return f;
        }
    }

    public int getInt(String str, int i) {
        String str2 = this.a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return i;
        }
        try {
            return Integer.valueOf(str2).intValue();
        } catch (Throwable unused) {
            return i;
        }
    }

    public long getLong(String str, long j) {
        String str2 = this.a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return j;
        }
        try {
            return Long.valueOf(str2).longValue();
        } catch (Throwable unused) {
            return j;
        }
    }

    public java.sql.Date getSqlDate(String str, long j) {
        return new java.sql.Date(getLong(str, j));
    }

    public String getString(String str) {
        return this.a.get(str);
    }

    public boolean isEmpty(String str) {
        return TextUtils.isEmpty(this.a.get(str));
    }
}
