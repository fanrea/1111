package com.bytedance.bdtracker;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.bdtracker.l0;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class x3 extends SQLiteOpenHelper {
    public final e0 a;

    public x3(e0 e0Var, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(e0Var.b(), str, cursorFactory, i);
        this.a = e0Var;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<t3> it = t3.j().values().iterator();
            while (it.hasNext()) {
                String strA = it.next().a();
                if (strA != null) {
                    sQLiteDatabase.execSQL(strA);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        IAppLogLogger iAppLogLogger = this.a.d.D;
        Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
        iAppLogLogger.debug(5, "Database upgrade from:{} to:{}", objArr);
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<t3> it = t3.j().values().iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().f());
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
                l0.b.a(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
            }
        }
        l0.b.a(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }
}
