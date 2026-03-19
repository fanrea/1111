package lkxssdk.w;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class d {
    public lkxssdk.x.a a;
    public SQLiteDatabase b;

    public d(Context context) {
        this.a = new lkxssdk.x.a(context, "FCLibDown.db", null, 1);
    }

    public void a(String str) {
        SQLiteDatabase sQLiteDatabase;
        try {
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                this.b = writableDatabase;
                writableDatabase.delete("download_thread_info", "taskKey=?", new String[]{str});
                sQLiteDatabase = this.b;
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                sQLiteDatabase = this.b;
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            sQLiteDatabase.close();
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase2 = this.b;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.close();
            }
            throw th;
        }
    }

    public void a(lkxssdk.z.b bVar) {
        SQLiteDatabase sQLiteDatabase;
        try {
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                this.b = writableDatabase;
                writableDatabase.update("download_task_info", bVar.a(), "taskKey=?", new String[]{bVar.a});
                sQLiteDatabase = this.b;
            } catch (Exception e) {
                e.printStackTrace();
                sQLiteDatabase = this.b;
                if (sQLiteDatabase != null) {
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase2 = this.b;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.close();
            }
            throw th;
        }
    }
}
