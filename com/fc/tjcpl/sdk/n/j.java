package com.fc.tjcpl.sdk.n;

import android.text.TextUtils;
import com.fc.tjcpl.sdk.n.e0;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class j implements BridgeHandler {
    public j(CustomViewContent customViewContent) {
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("IDTask", "");
            String strOptString2 = jSONObject.optString("UrlDownload", "");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                com.fc.tjcpl.sdk.l.f.a().a("交互数据错误", 0);
                return;
            }
            e0 e0Var = e0.b.a;
            com.fc.tjcpl.sdk.b.a.b(e0Var.c);
            if (com.fc.tjcpl.sdk.b.a.a()) {
                com.fc.tjcpl.sdk.c.j.a().b.a.b.set(false);
            }
            if (com.fc.tjcpl.sdk.b.a.h(strOptString2) == 2) {
                com.fc.tjcpl.sdk.l.f.a().a("已暂停任务下载", 0);
            }
            com.fc.tjcpl.sdk.b.a.k(strOptString2);
            e0Var.e = true;
        } catch (Exception e) {
            e.printStackTrace();
            com.fc.tjcpl.sdk.l.f.a().a("数据解析错误", 0);
        }
    }
}
