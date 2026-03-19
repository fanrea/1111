package com.fc.tjcpl.sdk.n;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.fendasz.moku.planet.utils.QqUtils;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c implements BridgeHandler {
    public final /* synthetic */ CustomViewContent a;

    public c(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        com.fc.tjcpl.sdk.i.c.b("tag", "onOpenQQ==" + str);
        if (!com.fc.tjcpl.sdk.b.a.b(QqUtils.PACKAGENAME_QQ)) {
            com.fc.tjcpl.sdk.l.f.a().a("请先安装QQ", 0);
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("data", "");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(strOptString));
            intent.setFlags(268435456);
            this.a.a.a().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
