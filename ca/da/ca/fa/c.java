package ca.da.ca.fa;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class c {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;

    public c(boolean z, boolean z2) {
        this.b = z;
        this.c = z2;
        this.d = false;
    }

    public abstract boolean a(JSONObject jSONObject) throws JSONException, SecurityException;

    public c(boolean z, boolean z2, boolean z3) {
        this.b = z;
        this.c = z2;
        this.d = z3;
    }
}
