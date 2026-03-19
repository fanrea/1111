package com.baidu.mobads.container.components.e;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.mobads.container.util.bn;
import com.baidu.mobads.container.util.bq;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class h {
    public static final String a = "OAdSqlLiteAccessObj";
    private j b;
    private String c;

    public h(Context context) {
        this.b = new j(context);
        this.c = bn.a().a(context);
    }

    public boolean a(String str, String str2) {
        Cursor cursorRawQuery = this.b.getReadableDatabase().rawQuery("select count(*)  from download_info where url=? and local_file=? and process_name=?", new String[]{str, str2, this.c});
        cursorRawQuery.moveToFirst();
        int i = cursorRawQuery.getInt(0);
        cursorRawQuery.close();
        return i > 0;
    }

    public void a(List<i> list) throws SQLException {
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        for (i iVar : list) {
            try {
                writableDatabase.execSQL("insert into download_info(thread_id,url,local_file,start_pos,end_pos,compelete_size,process_name) values (?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(iVar.c()), iVar.b(), iVar.f(), Long.valueOf(iVar.d()), Long.valueOf(iVar.e()), Long.valueOf(iVar.a()), this.c});
            } catch (Exception e) {
                bq.a().c(a, e.getMessage());
            }
        }
    }

    public List<i> b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        int i = 3;
        int i2 = 0;
        int i3 = 1;
        Cursor cursorRawQuery = this.b.getReadableDatabase().rawQuery("select thread_id, url, local_file, start_pos, end_pos,compelete_size from download_info where url=? and local_file=? and process_name=?", new String[]{str, str2, this.c});
        while (cursorRawQuery.moveToNext()) {
            arrayList.add(new i(cursorRawQuery.getInt(i2), cursorRawQuery.getString(i3), cursorRawQuery.getString(2), cursorRawQuery.getInt(i), cursorRawQuery.getInt(4), cursorRawQuery.getInt(5)));
            i = 3;
            i2 = 0;
            i3 = 1;
        }
        cursorRawQuery.close();
        return arrayList;
    }

    public void b(List<i> list) throws SQLException {
        SQLiteDatabase readableDatabase = this.b.getReadableDatabase();
        for (i iVar : list) {
            try {
                readableDatabase.execSQL("update download_info set compelete_size=? where thread_id=? and url=? and local_file=? and process_name=?", new Object[]{Long.valueOf(iVar.a()), Integer.valueOf(iVar.c()), iVar.b(), iVar.f(), this.c});
            } catch (Exception e) {
                bq.a().c(a, e.getMessage());
            }
        }
    }

    public void a() {
        try {
            this.b.close();
        } catch (Exception e) {
            bq.a().c(a, e.getMessage());
        }
    }

    public void a(i iVar) {
        try {
            SQLiteDatabase readableDatabase = this.b.getReadableDatabase();
            readableDatabase.delete(j.b, "url=? and local_file=? and process_name=?", new String[]{iVar.b(), iVar.f(), this.c});
            readableDatabase.close();
        } catch (Exception e) {
            bq.a().c(a, e.getMessage());
        }
    }
}
