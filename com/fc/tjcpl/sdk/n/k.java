package com.fc.tjcpl.sdk.n;

import android.view.View;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class k implements BridgeHandler {
    public final /* synthetic */ CustomViewContent a;

    public k(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        View view = b0.a(this.a.a.a()).e;
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
