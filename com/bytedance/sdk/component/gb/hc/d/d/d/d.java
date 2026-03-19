package com.bytedance.sdk.component.gb.hc.d.d.d;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.gb.d.an;
import com.bytedance.sdk.component.gb.hc.d.d.hc.c;
import com.bytedance.sdk.component.gb.hc.d.d.hc.h;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends SQLiteOpenHelper {
    final Context d;
    private an hc;

    public d(Context context, an anVar) {
        super((Context) new com.bytedance.sdk.openadsdk.api.plugin.d(context), "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.d = context;
        this.hc = anVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            d(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.gb.hc.d.d.hc.an.c(this.hc.hc()));
        sQLiteDatabase.execSQL(c.hc(this.hc.d()));
        sQLiteDatabase.execSQL(h.c(this.hc.c()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.gb.hc.d.d.hc.d.hc(this.hc.u()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.gb.hc.an.an.hc());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i > i2) {
                hc(sQLiteDatabase);
                d(sQLiteDatabase);
            } else {
                d(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    private void hc(SQLiteDatabase sQLiteDatabase) throws SQLException {
        ArrayList<String> arrayListB = b(sQLiteDatabase);
        if (arrayListB == null || arrayListB.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListB.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private ArrayList<String> b(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
