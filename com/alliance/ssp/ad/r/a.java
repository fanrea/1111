package com.alliance.ssp.ad.r;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sigmob.sdk.base.n;

/* compiled from: DbHelper.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "download.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void a(SQLiteDatabase sQLiteDatabase, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("fileName", gVar.a);
        contentValues.put("length", Integer.valueOf(gVar.c));
        contentValues.put("finished", Integer.valueOf(gVar.d));
        sQLiteDatabase.update(n.z, contentValues, "url = ?", new String[]{gVar.b});
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table file(fileName varchar,url varchar,length integer,finished integer)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public g a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query(n.z, null, "url = ?", new String[]{str}, null, null, null, null);
        g gVar = new g();
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("fileName"));
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("length"));
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("finished"));
                gVar.e = false;
                gVar.a = string;
                gVar.b = str;
                gVar.c = i;
                gVar.d = i2;
            }
            cursorQuery.close();
        }
        return gVar;
    }
}
