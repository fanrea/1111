package com.fc.tjcpl.sdk.f;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b {
    public String a;
    public String b;
    public long c;
    public int d;
    public String e;
    public String f;
    public String g;
    public int h;
    public a i;
    public long j;
    public int k;

    public b(Cursor cursor) {
        this.a = cursor.getString(cursor.getColumnIndex("taskKey"));
        this.b = cursor.getString(cursor.getColumnIndex("url"));
        this.c = cursor.getLong(cursor.getColumnIndex("fileSize"));
        this.d = cursor.getInt(cursor.getColumnIndex("acceptRange"));
        this.e = cursor.getString(cursor.getColumnIndex("saveDir"));
        this.f = cursor.getString(cursor.getColumnIndex("fileName"));
        this.g = cursor.getString(cursor.getColumnIndex("cacheDir"));
        this.h = cursor.getInt(cursor.getColumnIndex("status"));
        String string = cursor.getString(cursor.getColumnIndex("appinfo"));
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            String strOptString = jSONObject.optString("appId", "");
            String strOptString2 = jSONObject.optString("appUrl", "");
            String strOptString3 = jSONObject.optString("channelId", "");
            String strOptString4 = jSONObject.optString("appPackage", "");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("verifyKey");
            ArrayList arrayList = null;
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                arrayList = new ArrayList();
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i));
                }
            }
            a aVar = new a(strOptString2);
            aVar.a(strOptString).c(strOptString3).b(strOptString4).a(arrayList);
            this.i = aVar;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("taskKey", this.a);
        contentValues.put("url", this.b);
        contentValues.put("acceptRange", Integer.valueOf(this.d));
        contentValues.put("cacheDir", this.g);
        contentValues.put("fileName", this.f);
        contentValues.put("fileSize", Long.valueOf(this.c));
        contentValues.put("saveDir", this.e);
        contentValues.put("status", Integer.valueOf(this.h));
        contentValues.put("appinfo", this.i.a());
        return contentValues;
    }

    public String toString() {
        return ((((((((("taskinfo:{\ntaskKey:" + this.a + ",\n") + "url:" + this.b + ",\n") + "fileSize:" + this.c + ",\n") + "acceptRange:" + this.d + ",\n") + "saveDir:" + this.e + ",\n") + "fileName:" + this.f + ",\n") + "cacheDir:" + this.g + ",\n") + "status:" + this.h + ",\n") + "appInfo:" + this.i.a() + ",\n") + i.d;
    }
}
