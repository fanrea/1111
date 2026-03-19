package com.bytedance.sdk.component.widget.web;

import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.uo.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class hc extends d {
    private final com.bytedance.sdk.component.uo.d d;
    private final WebViewImpl hc;

    public hc(Object obj, String str, com.bytedance.sdk.component.uo.d dVar, WebViewImpl webViewImpl) {
        super(obj, str);
        this.d = dVar;
        this.hc = webViewImpl;
    }

    private boolean d(JSONObject jSONObject) {
        JSONObject jSONObjectHc = hc(jSONObject, "addWebviewListener");
        if (jSONObjectHc == null) {
            return false;
        }
        String strOptString = jSONObjectHc.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.d.d(this.hc, strOptString);
        return true;
    }

    private boolean hc(JSONObject jSONObject) {
        JSONObject jSONObjectHc = hc(jSONObject, "removeWebviewListener");
        if (jSONObjectHc == null) {
            return false;
        }
        String strOptString = jSONObjectHc.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.d.hc(this.hc, strOptString);
        return true;
    }

    private boolean b(JSONObject jSONObject) {
        JSONObject jSONObjectHc = hc(jSONObject, "sendWebviewEvent");
        if (jSONObjectHc == null) {
            return false;
        }
        String strOptString = jSONObjectHc.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null) {
            return true;
        }
        this.d.d(this.hc, hc(), strOptString, jSONObjectHc.opt("param"));
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.web.d
    @JavascriptInterface
    public Object invokeMethod(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("popWebview")) {
            if (u(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("pushWebview")) {
            if (c(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("addWebviewListener")) {
            if (d(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("removeWebviewListener")) {
            if (hc(new JSONObject(str))) {
                return null;
            }
        } else {
            if (str.contains("sendWebviewEvent")) {
                if (b(new JSONObject(str))) {
                    return null;
                }
            }
            return super.invokeMethod(str);
        }
        return super.invokeMethod(str);
    }

    private boolean c(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectHc = hc(jSONObject, "pushWebview");
        if (jSONObjectHc == null) {
            return false;
        }
        int iD = this.d.d(jSONObjectHc.optString("url"));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(iD));
            jSONObject2.putOpt("result", Boolean.valueOf(iD == 0));
        } catch (Exception unused) {
        }
        this.hc.d(hc(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean u(JSONObject jSONObject) throws JSONException {
        if (!d(jSONObject, "popWebview")) {
            return false;
        }
        b bVarD = this.d.d();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(bVarD == null ? 1 : 0));
            jSONObject2.putOpt("result", Boolean.valueOf(bVarD != null));
        } catch (Exception unused) {
        }
        this.hc.d(hc(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean d(JSONObject jSONObject, String str) {
        return jSONObject.optString("func").equals(str);
    }

    private JSONObject hc(JSONObject jSONObject, String str) {
        if (d(jSONObject, str)) {
            return jSONObject.optJSONObject("params");
        }
        return null;
    }
}
