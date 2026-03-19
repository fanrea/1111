package com.sigmob.sdk.base.common;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.db.a;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class x {
    private static final HashMap<String, x> h = new HashMap<>();
    public int a;
    public int b;
    public long c;
    public int d = 0;
    public int e = 30;
    public int f;
    public long g;

    public static synchronized x a(String placement) {
        Cursor cursorRawQuery = null;
        if (TextUtils.isEmpty(placement)) {
            return null;
        }
        x xVar = h.get(placement);
        if (xVar == null) {
            xVar = new x();
            try {
                cursorRawQuery = com.sigmob.sdk.base.db.a.a().getReadableDatabase().rawQuery("select * from adload_cache_event where adslot_id = '" + placement + "' group by adslot_id", null);
                a(xVar, cursorRawQuery);
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
            h.put(placement, xVar);
        }
        return xVar;
    }

    private static void a(x cacheItem, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        do {
            cacheItem.a = cursor.getInt(cursor.getColumnIndexOrThrow("media_request_count"));
            cacheItem.b = cursor.getInt(cursor.getColumnIndexOrThrow("media_ready_count"));
            long j = cursor.getLong(cursor.getColumnIndexOrThrow("pre_req_time"));
            cacheItem.c = j;
            cacheItem.g = j;
            cacheItem.d = cursor.getInt(cursor.getColumnIndexOrThrow("req_interval_time"));
            cacheItem.e = cursor.getInt(cursor.getColumnIndexOrThrow("req_pool_size"));
        } while (cursor.moveToNext());
    }

    public static void a(final String placementId, x item) {
        if (TextUtils.isEmpty(placementId) || item == null) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.sigmob.sdk.base.db.a.a().getWritableDatabase();
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName(com.sigmob.sdk.base.db.a.g);
            HashMap map = new HashMap();
            map.put("adslot_id", placementId);
            map.put("media_request_count", Integer.valueOf(item.a));
            map.put("media_ready_count", Integer.valueOf(item.b));
            map.put("pre_req_time", Long.valueOf(item.c));
            map.put("req_interval_time", Integer.valueOf(item.d));
            map.put("req_pool_size", Integer.valueOf(item.e));
            builder.setColumnValues(map);
            com.sigmob.sdk.base.db.a.a().a(writableDatabase, builder.build(), new a.InterfaceC0729a() { // from class: com.sigmob.sdk.base.common.x.1
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
            com.sigmob.sdk.base.db.a.a().getWritableDatabase().delete(com.sigmob.sdk.base.db.a.g, "adslot_id=?", new String[]{placementId});
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }
}
