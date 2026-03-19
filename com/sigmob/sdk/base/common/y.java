package com.sigmob.sdk.base.common;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.db.a;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class y {
    private static final HashMap<String, y> d = new HashMap<>();
    public int a;
    public int b;
    public String c;

    public static synchronized y a(String placement) {
        Cursor cursorRawQuery = null;
        if (TextUtils.isEmpty(placement)) {
            return null;
        }
        y yVar = d.get(placement);
        if (yVar == null) {
            yVar = new y();
            yVar.c = placement;
            try {
                cursorRawQuery = com.sigmob.sdk.base.db.a.a().getReadableDatabase().rawQuery("select * from adload_ready_event where adslot_id = '" + placement + "' group by adslot_id", null);
                a(yVar, cursorRawQuery);
            } catch (Throwable th) {
                try {
                    SigmobLog.e(th.getMessage());
                    if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
                    }
                } finally {
                    if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
                        cursorRawQuery.close();
                    }
                }
            }
            d.put(placement, yVar);
        }
        return yVar;
    }

    public static HashMap<String, y> a() {
        return d;
    }

    private static void a(y cacheItem, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        do {
            cacheItem.a = cursor.getInt(cursor.getColumnIndexOrThrow("media_request_count"));
            cacheItem.b = cursor.getInt(cursor.getColumnIndexOrThrow("media_ready_count"));
        } while (cursor.moveToNext());
    }

    public static void a(final String placementId, y item) {
        if (TextUtils.isEmpty(placementId) || item == null) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.sigmob.sdk.base.db.a.a().getWritableDatabase();
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName(com.sigmob.sdk.base.db.a.h);
            HashMap map = new HashMap();
            map.put("adslot_id", placementId);
            map.put("media_request_count", Integer.valueOf(item.a));
            map.put("media_ready_count", Integer.valueOf(item.b));
            builder.setColumnValues(map);
            com.sigmob.sdk.base.db.a.a().a(writableDatabase, builder.build(), new a.InterfaceC0729a() { // from class: com.sigmob.sdk.base.common.y.1
                @Override // com.sigmob.sdk.base.db.a.InterfaceC0729a
                public void a() {
                    SigmobLog.d(placementId + " insert load cache event " + placementId + " onSuccess: ");
                }

                @Override // com.sigmob.sdk.base.db.a.InterfaceC0729a
                public void a(Throwable e) {
                    SigmobLog.e(placementId + " insert  load cache event " + placementId + " onFailed: ", e);
                }
            });
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    private void b(String placementId) {
        if (TextUtils.isEmpty(placementId)) {
            return;
        }
        try {
            com.sigmob.sdk.base.db.a.a().getWritableDatabase().delete(com.sigmob.sdk.base.db.a.h, "adslot_id=?", new String[]{placementId});
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public static void c() {
        try {
            Cursor cursorRawQuery = com.sigmob.sdk.base.db.a.a().getReadableDatabase().rawQuery("select * from adload_ready_event", null);
            if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            do {
                y yVar = new y();
                yVar.c = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("adslot_id"));
                yVar.a = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("media_request_count"));
                yVar.b = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("media_ready_count"));
                arrayList.add(yVar);
                d.put(yVar.c, yVar);
            } while (cursorRawQuery.moveToNext());
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public void b() {
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        this.a = 0;
        this.b = 0;
        b(this.c);
    }
}
