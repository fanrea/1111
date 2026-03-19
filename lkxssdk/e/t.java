package lkxssdk.e;

import android.graphics.Bitmap;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class t {
    public BaseActivity a;
    public lkxssdk.k.a<String> b;
    public boolean c;
    public Bitmap d;
    public String e;

    public t(BaseActivity baseActivity) {
        this.a = baseActivity;
    }

    public final void a(String str, lkxssdk.k.a<String> aVar) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            jSONObject.put("errorMsg", str);
            aVar.b(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
