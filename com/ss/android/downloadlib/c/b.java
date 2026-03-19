package com.ss.android.downloadlib.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.ss.android.downloadlib.addownload.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private static volatile b hc;
    private SQLiteDatabase d;

    public static b d() {
        if (hc == null) {
            synchronized (b.class) {
                if (hc == null) {
                    hc = new b();
                }
            }
        }
        return hc;
    }

    private b() throws JSONException {
        try {
            this.d = new hc(mq.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.u.b.d().d(th, "ClickEventHelper");
        }
    }

    public boolean hc() {
        return com.ss.android.socialbase.downloader.uo.d.b().d("click_event_switch", 0) == 1;
    }

    public boolean b() {
        return com.ss.android.socialbase.downloader.uo.d.b().d("click_event_switch", 0) == 2;
    }

    public void d(long j, String str) {
        String strOptString;
        SQLiteDatabase sQLiteDatabase = this.d;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            strOptString = new JSONObject(str).optString(g.o);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(IDJXAd.AD_CODE_ID, Long.valueOf(j));
        contentValues.put(g.o, strOptString);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        this.d.insert("click_event", null, contentValues);
        b(j, str);
    }

    public boolean hc(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.d;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                String strOptString = new JSONObject(str).optString(g.o);
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                cursorQuery = this.d.query("click_event", hc.d, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString}, null, null, null, null);
                boolean z = cursorQuery.getCount() > 0;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return z;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private void b(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.d;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString(g.o);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.d.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString});
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }
}
