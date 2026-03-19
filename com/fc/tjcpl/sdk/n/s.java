package com.fc.tjcpl.sdk.n;

import android.graphics.Color;
import android.text.TextUtils;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class s implements BridgeHandler {
    public final /* synthetic */ CustomViewContent a;

    public s(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) {
        com.fc.tjcpl.sdk.i.c.b("tag", "onSetStatusbarColor->" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int color = Color.parseColor(str);
            a aVar = this.a.a;
            if (aVar.b == null) {
                com.fc.tjcpl.sdk.l.e.a(aVar.a(), color);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
