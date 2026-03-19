package com.fc.tjcpl.sdk.n;

import android.text.TextUtils;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d implements BridgeHandler {
    public final /* synthetic */ CustomViewContent a;

    public d(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        callBackFunction.onCallBack(CustomViewContent.a(this.a, str) ? "1" : "2");
    }
}
