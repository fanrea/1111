package com.bytedance.sdk.component.gb.hc.an;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements u {
    private com.bytedance.sdk.component.gb.d.u d;
    private Context hc;

    public static String b() {
        return "ALTER TABLE trackurl ADD COLUMN extra TEXT";
    }

    public static String c() {
        return "ALTER TABLE trackurl ADD COLUMN encrypt INTEGER default 0";
    }

    public an(com.bytedance.sdk.component.gb.d.u uVar) {
        this.hc = uVar.getContext();
        this.d = uVar;
    }

    @Override // com.bytedance.sdk.component.gb.hc.an.u
    public List<c> d() {
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        Cursor cursorQuery = com.bytedance.sdk.component.gb.hc.d.d.hc.query(this.hc, "trackurl", null, null, null, null, null, null, this.d);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                    boolean z = cursorQuery.getInt(cursorQuery.getColumnIndex("replaceholder")) > 0;
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                    if (i2 > 0) {
                        string3 = com.bytedance.sdk.component.utils.d.b(string3);
                    }
                    try {
                        jSONObject = new JSONObject(string3);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    linkedList.add(new c(string, string2, z, i, jSONObject, i2));
                } catch (Throwable unused2) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                            cursorQuery = null;
                        } finally {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    }
                    if (cursorQuery != null) {
                    }
                }
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.component.gb.hc.an.u
    public void insert(c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", cVar.hc());
        contentValues.put("url", cVar.b());
        contentValues.put("replaceholder", Integer.valueOf(cVar.c() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(cVar.u()));
        contentValues.put("extra", com.bytedance.sdk.component.utils.d.hc(cVar.d().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.gb.hc.d.d.hc.insert(this.hc, "trackurl", contentValues, this.d);
    }

    @Override // com.bytedance.sdk.component.gb.hc.an.u
    public void update(c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", cVar.hc());
        contentValues.put("url", cVar.b());
        contentValues.put("replaceholder", Integer.valueOf(cVar.c() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(cVar.u()));
        contentValues.put("extra", com.bytedance.sdk.component.utils.d.hc(cVar.d().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.gb.hc.d.d.hc.update(this.hc, "trackurl", contentValues, "id=?", new String[]{cVar.hc()}, this.d);
    }

    @Override // com.bytedance.sdk.component.gb.hc.an.u
    public void delete(c cVar) {
        com.bytedance.sdk.component.gb.hc.d.d.hc.delete(this.hc, "trackurl", "id=?", new String[]{cVar.hc()}, this.d);
    }

    public static String hc() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0,retry INTEGER default 0,extra TEXT ,encrypt INTEGER default 0)").toString();
    }
}
