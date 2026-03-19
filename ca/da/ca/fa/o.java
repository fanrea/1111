package ca.da.ca.fa;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OaidLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class o extends c {
    public final Context e;
    public final g f;

    public o(Context context, g gVar) {
        super(true, false);
        this.e = context;
        this.f = gVar;
    }

    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) throws JSONException, SecurityException {
        SharedPreferences sharedPreferences = this.f.e;
        Map mapA = ca.da.da.f.a(this.e);
        if (mapA == null) {
            return false;
        }
        jSONObject.put("oaid", new JSONObject(mapA));
        return true;
    }
}
