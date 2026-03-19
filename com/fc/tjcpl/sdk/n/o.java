package com.fc.tjcpl.sdk.n;

import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.CallBackFunction;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class o implements CallBackFunction {
    public o(CustomViewContent customViewContent) {
    }

    @Override // com.github.lzyzsd.jsbridge.CallBackFunction
    public void onCallBack(String str) {
        com.fc.tjcpl.sdk.i.c.b("tag", "RouteBack data:" + str);
    }
}
