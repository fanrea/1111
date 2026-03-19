package com.bytedance.msdk.gb.b.d.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ba.d.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private final com.bytedance.sdk.openadsdk.core.multipro.d d = new com.bytedance.sdk.openadsdk.core.multipro.d(new com.bytedance.sdk.component.gb.hc.hc.hc.d("csj_mediation"));
    private c.d hc;

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        c.d dVarD = d(uri);
        if (dVarD != null) {
            return dVarD.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    public String getType(Uri uri) {
        c.d dVarD = d(uri);
        if (dVarD != null) {
            return dVarD.getType(uri);
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        c.d dVarD = d(uri);
        if (dVarD != null) {
            return dVarD.insert(uri, contentValues);
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        c.d dVarD = d(uri);
        if (dVarD != null) {
            return dVarD.delete(uri, str, strArr);
        }
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        c.d dVarD = d(uri);
        if (dVarD != null) {
            return dVarD.update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    private c.d d(Uri uri) {
        if (uri == null) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "uri is error2");
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "uri is error3");
            return null;
        }
        if (this.hc == null) {
            b bVar = new b();
            this.hc = bVar;
            bVar.init();
        }
        if (str.equals(this.hc.getTableName())) {
            return this.hc;
        }
        if (str.equals(this.d.getTableName())) {
            return this.d;
        }
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "uri is error4");
        return null;
    }
}
