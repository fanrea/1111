package ca.da.ca.fa;

import android.content.Context;
import com.bytedance.apm.common.utility.NetworkUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class m extends c {
    public final Context e;

    public m(Context context) {
        super(true, true);
        this.e = context;
    }

    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) throws JSONException {
        h.a(jSONObject, "access", NetworkUtils.getNetworkAccessType(this.e));
        return true;
    }
}
