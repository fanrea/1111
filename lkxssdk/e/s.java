package lkxssdk.e;

import com.lingku.xuanshang.xutils.common.Callback;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class s implements Callback.CommonCallback<String> {
    public final /* synthetic */ int a;
    public final /* synthetic */ lkxssdk.k.a b;
    public final /* synthetic */ t c;

    public s(t tVar, int i, lkxssdk.k.a aVar) {
        this.c = tVar;
        this.a = i;
        this.b = aVar;
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
    public void onCancelled(Callback.CancelledException cancelledException) {
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
    public void onError(Throwable th, boolean z) throws JSONException {
        lkxssdk.h0.c.b("post upload file :" + th.getMessage());
        this.c.a(th.getMessage(), this.b);
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
    public void onFinished() {
    }

    @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
    public void onSuccess(String str) throws JSONException {
        lkxssdk.h0.c.b("post upload file :" + str);
        t tVar = this.c;
        int i = this.a;
        lkxssdk.k.a<String> aVar = this.b;
        tVar.getClass();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject.optInt("code", -1) != 0) {
                tVar.a(jSONObject.optString("msg", ""), aVar);
                return;
            }
            String strOptString = jSONObject.optString("data");
            String strA = lkxssdk.a0.c.a("xsw-8ks!2s0x3");
            String[] strArrSplit = strOptString.split(",");
            int length = strArrSplit.length;
            String str2 = "";
            for (int i2 = 0; i2 < length; i2++) {
                int iIntValue = Integer.valueOf(strArrSplit[i2]).intValue();
                int i3 = ((iIntValue & 16) >> 1) | ((iIntValue & 1) << 7) | ((iIntValue & 2) << 5) | ((iIntValue & 4) << 3) | ((iIntValue & 8) << 1) | ((iIntValue & 32) >> 3) | ((iIntValue & 64) >> 5) | ((iIntValue & 128) >> 7);
                if (i2 >= 64 || (i2 + 1) % 2 != 0 || i3 != strA.charAt(i2 / 2)) {
                    str2 = str2 + ((char) i3);
                }
            }
            JSONObject jSONObject3 = new JSONObject(str2);
            JSONArray jSONArray = new JSONArray();
            for (int i4 = 1; i4 <= i; i4++) {
                jSONArray.put(jSONObject3.optString(com.sigmob.sdk.base.n.z + i4, ""));
            }
            jSONObject2.put("result", 1);
            jSONObject2.put("fileUrlArr", jSONArray);
            String string = jSONObject2.toString();
            lkxssdk.h0.c.b("上传成功：" + string);
            aVar.b(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
