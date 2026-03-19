package com.fc.tjcpl.sdk.n;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class f implements BridgeHandler {
    public final /* synthetic */ CustomViewContent a;

    public f(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        try {
            String strOptString = new JSONObject(str).optString("url", "");
            if (TextUtils.isEmpty(strOptString)) {
                callBackFunction.onCallBack("{\"result\":-1}");
            } else {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(strOptString));
                intent.setFlags(268435456);
                this.a.a.a().startActivity(intent);
                callBackFunction.onCallBack("{\"result\":1}");
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            callBackFunction.onCallBack("{\"result\":0}");
        } catch (JSONException e2) {
            e2.printStackTrace();
            callBackFunction.onCallBack("{\"result\":-1}");
        }
    }
}
