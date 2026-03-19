package com.fc.tjcpl.sdk.n;

import android.text.TextUtils;
import com.fc.tjcpl.sdk.n.e0;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class i implements BridgeHandler {
    public i(CustomViewContent customViewContent) {
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("IDTask", "");
            String strOptString2 = jSONObject.optString("UrlDownload", "");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                com.fc.tjcpl.sdk.l.f.a().a("交互数据错误", 0);
            } else {
                e0.b.a.a(strOptString2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.fc.tjcpl.sdk.l.f.a().a("数据解析错误", 0);
        }
    }
}
