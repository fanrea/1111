package com.baidu.mobads.container.adrequest;

import android.content.Context;
import android.net.Uri;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.util.ah;
import com.sigmob.windad.WindAds;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e extends o {
    private String A;
    private final com.baidu.mobads.container.n.f B;
    private JSONObject y;
    private int z;

    public e(Context context, ProdAdRequestInfo prodAdRequestInfo) {
        super(context, prodAdRequestInfo);
        this.B = new com.baidu.mobads.container.n.f(this.c, prodAdRequestInfo);
        H();
        try {
            com.baidu.mobads.container.util.f.z.a(this.b);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject) {
        this.y = jSONObject;
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public void a() throws JSONException {
        b();
        c(this.j.optString("appid"));
        this.z = this.j.optInt("channel");
        this.A = ah.a(this.y, "outerId", "outerId");
        if (this.z != 1080) {
            this.y.remove("city");
        }
        if (this.z == 1090) {
            try {
                this.y.put(WindAds.AD_SCENE_ID, "2");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        w wVar = new w(this.b, this.z, z());
        wVar.a(this.A);
        boolean zOptBoolean = false;
        if (this.y != null) {
            zOptBoolean = this.y.optBoolean("isInitNovelSDK", false);
            this.y.remove("isInitNovelSDK");
        }
        wVar.a(zOptBoolean);
        String strA = wVar.a();
        if (this.y == null) {
            this.y = new JSONObject();
        }
        try {
            this.y.put("appPackage", com.baidu.mobads.container.util.t.f(this.b));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            a(new v("{'ad':[{'id':99999999,'html':'" + a(this.y, strA).build().toString() + "', type='" + j.a.HTML.b() + "'}],'n':1}"));
            if (this.f != null && this.f.o().size() > 0) {
                this.g = this.f.b();
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        g();
    }

    private Uri.Builder a(JSONObject jSONObject, String str) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        if (jSONObject != null && jSONObject.length() > 0) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                builderBuildUpon.appendQueryParameter(next, jSONObject.optString(next, ""));
            }
        }
        return builderBuildUpon;
    }

    @Override // com.baidu.mobads.container.adrequest.o
    public void a(JSONObject jSONObject, Map<String, Object> map) {
        if (this.B != null) {
            this.B.a(jSONObject, map);
        }
    }

    private void H() {
        if (this.B != null) {
            this.B.a(new f(this));
        }
    }
}
