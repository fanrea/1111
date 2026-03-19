package com.fc.tjcpl.sdk.n;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class u implements BridgeHandler {
    public final /* synthetic */ CustomViewContent a;

    public u(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        this.a.e = true;
        com.fc.tjcpl.sdk.i.c.c("TJActivity", "handler = setToken, data from web = " + str);
        if (this.a.j) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a.g = jSONObject.optString(NetworkDefine.PARAM_TOKEN, "");
            this.a.h = jSONObject.optString(Config.CUSTOM_USER_ID, "");
            if (TextUtils.isEmpty(this.a.g)) {
                return;
            }
            CustomViewContent customViewContent = this.a;
            if (customViewContent.i != 0) {
                return;
            }
            customViewContent.i = 1;
            com.fc.tjcpl.sdk.i.c.a.b.execute(new n(customViewContent));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
