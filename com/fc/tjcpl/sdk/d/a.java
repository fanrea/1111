package com.fc.tjcpl.sdk.d;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends SQLiteOpenHelper {
    public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_task_info(_id INTEGER PRIMARY KEY AUTOINCREMENT,taskKey VARCHAR,url VARCHAR,fileSize INTEGER,acceptRange INTEGER,status INTEGER,saveDir VARCHAR,fileName VARCHAR,appinfo VARCHAR,cacheDir VARCHAR)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_thread_info(_id INTEGER PRIMARY KEY AUTOINCREMENT,taskKey VARCHAR,threadId INTEGER,acceptRange INTEGER,url VARCHAR,start INTEGER,end INTEGER,completeSize INTEGER,cachePath VARCHAR)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_report_info(_id INTEGER PRIMARY KEY AUTOINCREMENT,taskKey VARCHAR,start INTEGER,wait INTEGER,pause INTEGER,continue INTEGER,complete INTEGER,installed INTEGER,open INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
