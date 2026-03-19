package ca.da.ca.ia;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.common.utility.NetworkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EventV3.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g extends b {
    public String l;
    public boolean m;
    public String n;

    public g(String str, boolean z, String str2) {
        this.n = str;
        this.m = z;
        this.l = str2;
    }

    @Override // ca.da.ca.ia.b
    public int a(Cursor cursor) {
        super.a(cursor);
        this.n = cursor.getString(9);
        this.l = cursor.getString(10);
        this.m = cursor.getInt(11) == 1;
        return 12;
    }

    @Override // ca.da.ca.ia.b
    public List<String> b() {
        List<String> listB = super.b();
        ArrayList arrayList = new ArrayList(listB.size());
        arrayList.addAll(listB);
        arrayList.addAll(Arrays.asList(NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar", "is_bav", TypedValues.Custom.S_INT));
        return arrayList;
    }

    @Override // ca.da.ca.ia.b
    public String c() {
        return this.l;
    }

    @Override // ca.da.ca.ia.b
    public String d() {
        return this.n;
    }

    @Override // ca.da.ca.ia.b
    public String e() {
        return "eventv3";
    }

    @Override // ca.da.ca.ia.b
    public JSONObject g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.b);
        jSONObject.put("tea_event_index", this.c);
        jSONObject.put("session_id", this.d);
        long j = this.e;
        if (j > 0) {
            jSONObject.put("user_id", j);
        }
        if (!TextUtils.isEmpty(this.f)) {
            jSONObject.put("user_unique_id", this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject.put("ssid", this.g);
        }
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.n);
        if (this.m) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.l)) {
            jSONObject.put("params", new JSONObject(this.l));
        }
        if (this.i != NetworkUtils.NetworkType.UNKNOWN.getValue()) {
            jSONObject.put("nt", this.i);
        }
        jSONObject.put("datetime", this.j);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ab_sdk_version", this.h);
        }
        return jSONObject;
    }

    @Override // ca.da.ca.ia.b
    public b a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.n = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.l = jSONObject.optString("params", null);
        this.m = jSONObject.optBoolean("is_bav", false);
        return this;
    }

    @Override // ca.da.ca.ia.b
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put(NotificationCompat.CATEGORY_EVENT, this.n);
        contentValues.put("params", this.l);
        contentValues.put("is_bav", Integer.valueOf(this.m ? 1 : 0));
    }
}
