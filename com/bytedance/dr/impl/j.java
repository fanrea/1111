package com.bytedance.dr.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.f5;
import com.bytedance.bdtracker.l0;
import com.bytedance.dr.OaidApi;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class j implements OaidApi {
    public static final f5<Boolean> a = new a();

    public static class a extends f5<Boolean> {
        @Override // com.bytedance.bdtracker.f5
        public Boolean a(Object[] objArr) {
            return Boolean.valueOf("1".equals(j.a(com.alipay.sdk.m.p0.c.c, "0")));
        }
    }

    public static /* synthetic */ String a(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Vivo";
    }

    @Override // com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) throws Throwable {
        Cursor cursorQuery;
        OaidApi.a aVar = new OaidApi.a();
        Uri uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        String string = null;
        string = null;
        string = null;
        string = null;
        Cursor cursor = null;
        if (uri != null) {
            try {
                cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.moveToNext()) {
                                string = cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.d));
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            l0.b.a(cursor);
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        LoggerImpl.global().error(1, "Query oaid failed", e, new Object[0]);
                        l0.b.a(cursorQuery);
                        aVar.a = string;
                        return aVar;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                l0.b.a(cursor);
                throw th;
            }
            l0.b.a(cursorQuery);
        }
        aVar.a = string;
        return aVar;
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        return a.b(new Object[0]).booleanValue();
    }
}
