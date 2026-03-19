package com.bytedance.msdk.gb.b.d.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.ba.d.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements c.d {
    private com.bytedance.msdk.gb.d.d d;

    public String getTableName() {
        return "gromore_prime_rit_adn_perform";
    }

    public String getType(Uri uri) {
        return null;
    }

    public void injectContext(Context context) {
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public void init() {
        if (com.bytedance.msdk.core.hc.getContext() != null) {
            this.d = new com.bytedance.msdk.gb.d.d(com.bytedance.msdk.core.hc.getContext());
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.msdk.gb.d.d dVar = this.d;
        if (dVar != null) {
            return dVar.d(str, strArr2);
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.msdk.gb.d.d dVar = this.d;
        if (dVar == null) {
            return null;
        }
        dVar.d(contentValues);
        return uri;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.msdk.gb.d.d dVar = this.d;
        if (dVar == null) {
            return 0;
        }
        dVar.hc(str, strArr);
        return 1;
    }
}
