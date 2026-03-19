package com.bytedance.d.hc.hc.hc;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.d.hc.gb.tc;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends d<com.bytedance.d.hc.hc.d.d> {
    public hc() {
        super("duplicatelog");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L2e
            boolean r1 = android.text.TextUtils.isEmpty(r12)
            if (r1 == 0) goto La
            goto L2e
        La:
            r1 = 1
            java.lang.String r3 = r10.hc     // Catch: java.lang.Exception -> L26
            r4 = 0
            java.lang.String r5 = "path=?"
            java.lang.String[] r6 = new java.lang.String[r1]     // Catch: java.lang.Exception -> L26
            r6[r0] = r12     // Catch: java.lang.Exception -> L26
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r11
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L26
            int r12 = r11.getCount()     // Catch: java.lang.Exception -> L26
            r11.close()     // Catch: java.lang.Exception -> L24
            goto L2b
        L24:
            r11 = move-exception
            goto L28
        L26:
            r11 = move-exception
            r12 = r0
        L28:
            com.bytedance.d.hc.gb.tc.hc(r11)
        L2b:
            if (r12 <= 0) goto L2e
            return r1
        L2e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.d.hc.hc.hc.hc.d(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    @Override // com.bytedance.d.hc.hc.hc.d
    public void insert(SQLiteDatabase sQLiteDatabase, com.bytedance.d.hc.hc.d.d dVar) throws SQLException {
        if (dVar == null || d(sQLiteDatabase, dVar.d)) {
            return;
        }
        super.insert(sQLiteDatabase, (SQLiteDatabase) dVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.hc + " where _id in (select _id from " + this.hc + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            tc.hc(e);
        }
    }

    @Override // com.bytedance.d.hc.hc.hc.d
    protected HashMap<String, String> d() {
        HashMap<String, String> map = new HashMap<>();
        map.put("path", "TEXT");
        map.put("insert_time", "INTEGER");
        map.put("ext1", "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.d.hc.hc.hc.d
    public ContentValues d(com.bytedance.d.hc.hc.d.d dVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", dVar.d);
        contentValues.put("insert_time", Long.valueOf(dVar.hc));
        return contentValues;
    }
}
