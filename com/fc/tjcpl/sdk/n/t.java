package com.fc.tjcpl.sdk.n;

import com.fc.tjcpl.sdk.TJActivity;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class t implements BridgeHandler {
    public final /* synthetic */ CustomViewContent a;

    public t(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        com.fc.tjcpl.sdk.i.c.c("TJActivity", "handler = onExit, data from web = " + str);
        TJActivity tJActivity = this.a.a.a;
        if (tJActivity != null) {
            tJActivity.a(true);
        }
    }
}
