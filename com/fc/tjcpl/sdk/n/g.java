package com.fc.tjcpl.sdk.n;

import android.app.Activity;
import android.text.TextUtils;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class g implements BridgeHandler {
    public final /* synthetic */ CustomViewContent a;

    public g(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        try {
            String strOptString = new JSONObject(str).optString("package", "");
            if (!TextUtils.isEmpty(strOptString)) {
                if (!com.fc.tjcpl.sdk.b.a.b(strOptString)) {
                    callBackFunction.onCallBack("{\"result\":0}");
                    return;
                }
                Activity activityA = this.a.a.a();
                if (activityA != null) {
                    try {
                        activityA.startActivity(activityA.getPackageManager().getLaunchIntentForPackage(strOptString));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                callBackFunction.onCallBack("{\"result\":1}");
                return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        callBackFunction.onCallBack("{\"result\":-1}");
    }
}
