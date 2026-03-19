package ca.da.ca.fa;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ServerIdLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class s extends c {
    public final g e;

    public s(Context context, g gVar, h hVar) {
        super(true, false, false);
        this.e = gVar;
    }

    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferences = this.e.e;
        String string = sharedPreferences.getString("bd_did", null);
        h.a(jSONObject, "bd_did", string);
        String string2 = sharedPreferences.getString("install_id", null);
        String string3 = sharedPreferences.getString(this.e.i(), null);
        h.a(jSONObject, "install_id", string2);
        h.a(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = sharedPreferences.getLong("register_time", 0L);
        if ((ca.da.ca.ja.t.a(string2) && (ca.da.ca.ja.t.a((String) null) || ca.da.ca.ja.t.a(string))) || j2 == 0) {
            j = j2;
        } else {
            this.e.e.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
