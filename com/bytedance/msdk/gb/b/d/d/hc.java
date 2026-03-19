package com.bytedance.msdk.gb.b.d.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.ba.d.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements c.d {
    private static volatile hc d;
    private d hc = new d();

    public String getTableName() {
        return "";
    }

    public void init() {
    }

    public void injectContext(Context context) {
    }

    private hc() {
    }

    public static hc d() {
        if (d == null) {
            synchronized (hc.class) {
                if (d == null) {
                    d = new hc();
                }
            }
        }
        return d;
    }

    public String getType(Uri uri) {
        return this.hc.getType(uri);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.hc.query(uri, strArr, str, strArr2, str2);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.hc.insert(uri, contentValues);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.hc.delete(uri, str, strArr);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.hc.update(uri, contentValues, str, strArr);
    }
}
