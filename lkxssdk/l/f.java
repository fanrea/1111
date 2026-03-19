package lkxssdk.l;

import android.os.Build;
import android.text.TextUtils;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import lkxssdk.j.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class f {
    public BaseActivity a;
    public a b;
    public boolean c;

    public interface a {
    }

    public f(BaseActivity baseActivity, a aVar) {
        this.a = baseActivity;
        this.b = aVar;
    }

    public void a(int i) {
        String strD;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.sigmob.sdk.base.n.p, this.a.getPackageName());
            jSONObject.put("app_ver_code", lkxssdk.a.a.e(this.a.getApplication().getPackageName()).d);
            jSONObject.put("app_ver", lkxssdk.a.a.e(this.a.getApplication().getPackageName()).c);
            jSONObject.put("channel_id", (Object) null);
            jSONObject.put("is_tablet", lkxssdk.l0.a.f() ? "1" : "0");
            jSONObject.put("app_unique", lkxssdk.l0.a.e());
            jSONObject.put("mobile_model", Build.MODEL);
            jSONObject.put("sys_ver", Build.VERSION.RELEASE);
            int i2 = Build.VERSION.SDK_INT;
            jSONObject.put("sys_ver_int", String.valueOf(i2));
            jSONObject.put("android_id", lkxssdk.l0.a.a());
            jSONObject.put("screen_resolution", lkxssdk.b.a.b + "x" + lkxssdk.b.a.a);
            jSONObject.put("screen_size", lkxssdk.l0.a.a(this.a, lkxssdk.b.a.a, lkxssdk.b.a.b));
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            if (i == 1) {
                if (i2 >= 29) {
                    strD = lkxssdk.a.a.d;
                    str = "oaid";
                } else {
                    String strB = lkxssdk.l0.a.b();
                    String strA = lkxssdk.l0.a.a(0);
                    String strA2 = lkxssdk.l0.a.a(1);
                    jSONObject.put(com.baidu.mobads.upgrade.remote.gray.c.l, strB);
                    jSONObject.put("imei1", strA);
                    jSONObject.put(com.baidu.mobads.container.adrequest.g.A, strA2);
                    if (TextUtils.isEmpty(strB) && TextUtils.isEmpty(strA) && TextUtils.isEmpty(strA2)) {
                        i = -10;
                    }
                    jSONObject.put("imsi", lkxssdk.l0.a.c());
                    strD = lkxssdk.l0.a.d();
                    str = "serial_number";
                }
                jSONObject.put(str, strD);
            }
            jSONObject.put("id_state", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        lkxssdk.h0.c.b("tag", "device info:" + jSONObject.toString());
        String string = this.c ? jSONObject.toString() : lkxssdk.a.a.d(jSONObject.toString());
        a aVar = this.b;
        if (aVar != null) {
            lkxssdk.h0.c.a("device info:" + string);
            ((a.C0844a) aVar).a.b(string);
        }
    }
}
