package com.qq.e.comm.plugin;

import android.content.Context;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import com.qq.e.mediation.interfaces.IS2SAdapter;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class a5 {

    /* compiled from: A */
    public interface b {
        void a(JSONArray jSONArray, Map<Integer, tr> map);
    }

    private static JSONObject e(tr trVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NetworkDefine.PARAM_TOKEN, c(trVar).getBidderToken(r1.d().a()));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    static void a(List<tr> list, b bVar) {
        qg.c.execute(new a(list, bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject d(tr trVar) throws JSONException {
        jn jnVar = new jn(e(trVar));
        jnVar.a("adnet_id", trVar.a()).a(com.alipay.sdk.m.k.b.D0, trVar.b()).a(PointParamKey.PLACEMENT_ID, trVar.p()).a("adnsdk_version", b(trVar));
        jnVar.a("auction_json", new jn(trVar.j()).a().optString("auction_json"));
        return jnVar.a();
    }

    private static String b(tr trVar) {
        try {
            return c(trVar).getSDKVersion();
        } catch (Exception unused) {
            return "";
        }
    }

    private static IS2SAdapter c(tr trVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        return (IS2SAdapter) Class.forName(trVar.e()).asSubclass(IS2SAdapter.class).getDeclaredConstructor(Context.class, String.class, String.class, String.class).newInstance(r1.d().a(), trVar.b(), trVar.p(), trVar.j());
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ b b;

        a(List list, b bVar) {
            this.a = list;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap map = new HashMap();
            List list = this.a;
            if (list != null && list.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (tr trVar : this.a) {
                    trVar.w();
                    trVar.c(2);
                    jSONArray.put(a5.d(trVar));
                    map.put(Integer.valueOf(trVar.a()), trVar);
                }
                this.b.a(jSONArray, map);
                return;
            }
            this.b.a(new JSONArray(), map);
        }
    }
}
