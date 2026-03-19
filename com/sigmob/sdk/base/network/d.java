package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d extends SigmobRequest {
    private final a a;
    private byte[] b;

    public interface a extends Response.ErrorListener {
        void a(JSONObject response);
    }

    public d(String url, BidResponse bidResponse, a listener) {
        super(url, 1, listener);
        this.a = listener;
        setRetryPolicy(new DefaultRetryPolicy(5000, 2, 0.0f));
        setShouldCache(false);
        String strA = a(bidResponse);
        if (strA == null) {
            return;
        }
        try {
            this.b = AESUtil.Encrypt(strA.getBytes(), "KGpfzbYsn4T9Jyuq");
        } catch (Exception unused) {
            SigmobLog.e("feedback body bug");
        }
    }

    private String a(BidResponse bidResponse) {
        try {
            JSONObject jSONObject = new JSONObject(JSONSerializer.Serialize(bidResponse));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("scene");
            if (jSONObjectOptJSONObject != null) {
                a(jSONObjectOptJSONObject, "context");
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ads");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONArray jSONArray = jSONArrayOptJSONArray.getJSONObject(i).getJSONArray("materials");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        a(jSONObject2, "html_snippet");
                        a(jSONObject2, "closecard_html_snippet");
                        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("main_template");
                        if (jSONObjectOptJSONObject2 != null) {
                            a(jSONObjectOptJSONObject2, "context");
                        }
                        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("sub_template");
                        if (jSONObjectOptJSONObject3 != null) {
                            a(jSONObjectOptJSONObject3, "context");
                        }
                    }
                }
            }
            SigmobLog.d("json " + jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            SigmobLog.e("Serialize error", th);
            return null;
        }
    }

    private void a(JSONObject json, String name) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (json == null || (jSONObjectOptJSONObject = json.optJSONObject(name)) == null) {
            return;
        }
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        while (itKeys.hasNext()) {
            Object objOpt = jSONObjectOptJSONObject.opt(itKeys.next());
            if (objOpt instanceof String) {
                String str = (String) objOpt;
                if (TextUtils.isEmpty(str)) {
                    continue;
                } else {
                    String strEncodeToString = Base64.encodeToString(str.getBytes(), 2);
                    json.remove(name);
                    try {
                        json.put(name, strEncodeToString);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public int compareTo(Object o) {
        return 0;
    }

    public void deliverError(VolleyError error) {
        super.deliverError(error);
        a aVar = this.a;
        if (aVar == null) {
            return;
        }
        aVar.onErrorResponse(error);
    }

    protected void deliverResponse(Object response) {
        a aVar = this.a;
        if (aVar == null) {
            return;
        }
        aVar.a(null);
    }

    public byte[] getBody() {
        return this.b;
    }

    public String getBodyContentType() {
        return "application/json";
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        try {
            headers.put("agn", Base64.encodeToString(AESUtil.generateNonce(), 2));
        } catch (NoSuchMethodError unused) {
            headers.put("e", "1");
        }
        return headers;
    }
}
