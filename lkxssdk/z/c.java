package lkxssdk.z;

import android.content.ContentValues;
import android.database.Cursor;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class c {
    public String a;
    public int b;
    public int c;
    public String d;
    public long e;
    public long f;
    public long g;
    public String h;

    public c() {
    }

    public c(Cursor cursor) {
        this.a = cursor.getString(cursor.getColumnIndex("taskKey"));
        this.d = cursor.getString(cursor.getColumnIndex("url"));
        this.b = cursor.getInt(cursor.getColumnIndex("threadId"));
        this.c = cursor.getInt(cursor.getColumnIndex("acceptRange"));
        this.e = cursor.getInt(cursor.getColumnIndex("start"));
        this.f = cursor.getInt(cursor.getColumnIndex(PointCategory.END));
        this.g = cursor.getInt(cursor.getColumnIndex("completeSize"));
        this.h = cursor.getString(cursor.getColumnIndex("cachePath"));
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("taskKey", this.a);
        contentValues.put("url", this.d);
        contentValues.put("acceptRange", Integer.valueOf(this.c));
        contentValues.put("cachePath", this.h);
        contentValues.put("completeSize", Long.valueOf(this.g));
        contentValues.put("start", Long.valueOf(this.e));
        contentValues.put(PointCategory.END, Long.valueOf(this.f));
        contentValues.put("threadId", Integer.valueOf(this.b));
        return contentValues;
    }

    public String toString() {
        return ((((((("threadInfo:{\ntaskKey:" + this.a + ",\n") + "threadId:" + this.b + ",\n") + "acceptRange:" + this.c + ",\n") + "url:" + this.d + ",\n") + "start:" + this.e + ",\n") + "end:" + this.f + ",\n") + "completeSize:" + this.g + ",\n") + "cachePath:" + this.h + ",\n";
    }
}
