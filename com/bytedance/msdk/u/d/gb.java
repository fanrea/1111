package com.bytedance.msdk.u.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb extends SQLiteOpenHelper {
    private static String b() {
        return "ALTER TABLE adevent ADD COLUMN encrypt INTEGER default 0";
    }

    private static String c() {
        return "ALTER TABLE adevent_applog ADD COLUMN encrypt INTEGER default 0";
    }

    private static String d() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    private static String hc() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    public gb(Context context, String str, int i) {
        super((Context) new com.bytedance.sdk.openadsdk.api.plugin.d(context), str, (SQLiteDatabase.CursorFactory) null, i);
        com.bytedance.msdk.d.u.b.d("DBHelper", "DatabaseHelper ........");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            d(sQLiteDatabase);
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        com.bytedance.msdk.d.u.b.d("DBHelper", "initDB........");
        try {
            sQLiteDatabase.execSQL(d());
        } catch (Throwable th) {
            mq.d(th);
        }
        try {
            sQLiteDatabase.execSQL(hc());
        } catch (Throwable th2) {
            mq.d(th2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            com.bytedance.msdk.d.u.b.d("DBHelper", "onUpgrade....数据库版本升级.....");
            if (i == 1 || i == 2) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_freqctl';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_pacing';");
            } else if (i != 3) {
                return;
            }
            sQLiteDatabase.execSQL(hc());
            d(sQLiteDatabase, i, i2);
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL(b());
        } catch (Throwable th) {
            mq.d(th);
        }
        try {
            sQLiteDatabase.execSQL(c());
        } catch (Throwable th2) {
            mq.d(th2);
        }
    }
}
