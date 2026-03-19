package com.bytedance.msdk.gb.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static volatile b d;
    private Uri hc;

    public static b d() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    private b() {
        if (com.bytedance.msdk.core.hc.getContext() != null) {
            this.hc = Uri.parse("content://" + com.bytedance.msdk.core.hc.getContext().getPackageName() + ".TTMultiProvider/gromore_prime_rit_adn_perform");
        }
    }

    public void insert(String str, String str2, String str3, String str4) {
        if (com.bytedance.msdk.core.hc.getContext() == null || this.hc == null) {
            return;
        }
        ContentResolver contentResolver = com.bytedance.msdk.core.hc.getContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("adn_name", str);
        contentValues.put("prime_rit", str2);
        contentValues.put("adn_rit", str3);
        contentValues.put("ad_action", str4);
        contentValues.put("time_stamp", Long.valueOf(System.currentTimeMillis()));
        contentResolver.insert(this.hc, contentValues);
    }

    public List<hc> query(String str, String str2, long j, long j2) {
        String str3;
        String[] strArr;
        if (com.bytedance.msdk.core.hc.getContext() == null || this.hc == null) {
            return null;
        }
        ContentResolver contentResolver = com.bytedance.msdk.core.hc.getContext().getContentResolver();
        String[] strArr2 = {str, str2, String.valueOf(j), String.valueOf(j2)};
        if (TextUtils.isEmpty(str)) {
            strArr = new String[]{str2, String.valueOf(j), String.valueOf(j2)};
            str3 = "prime_rit=? AND time_stamp>=? AND time_stamp<?";
        } else {
            str3 = "adn_name=? AND prime_rit=? AND time_stamp>=? AND time_stamp<?";
            strArr = strArr2;
        }
        Cursor cursorQuery = contentResolver.query(this.hc, null, str3, strArr, null);
        if (cursorQuery == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("adn_name"));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("prime_rit"));
                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("adn_rit"));
                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("ad_action"));
                long j3 = cursorQuery.getLong(cursorQuery.getColumnIndex("time_stamp"));
                hc hcVar = new hc();
                hcVar.b(string);
                hcVar.d(string2);
                hcVar.hc(string3);
                hcVar.c(string4);
                hcVar.d(j3);
                linkedList.add(hcVar);
            } finally {
                cursorQuery.close();
            }
        }
        return linkedList;
    }

    public void d(String str, long j) {
        if (com.bytedance.msdk.core.hc.getContext() == null || this.hc == null || j <= 0) {
            return;
        }
        try {
            com.bytedance.msdk.core.hc.getContext().getContentResolver().delete(this.hc, "prime_rit=? AND time_stamp<?", new String[]{str, String.valueOf(j)});
        } catch (IllegalStateException unused) {
        }
    }
}
