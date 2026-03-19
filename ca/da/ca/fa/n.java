package ca.da.ca.fa;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: NewUserModeLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class n extends c {
    public Context e;

    public n(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) {
        try {
            j.a(this.e);
            if (!ca.da.ca.ja.r.b) {
                return true;
            }
            ca.da.ca.ja.r.a("new user mode = false", (Throwable) null);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
