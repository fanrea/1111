package ca.da.ca.fa;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: CdidLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class e extends c {
    public final g e;

    public e(g gVar) {
        super(true, false);
        this.e = gVar;
    }

    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) {
        try {
            String strA = ca.da.da.f.a(this.e.e);
            if (TextUtils.isEmpty(strA)) {
                jSONObject.put("cdid", "");
            } else {
                jSONObject.put("cdid", strA);
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
