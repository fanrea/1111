package com.fc.tjcpl.sdk.n;

import android.os.Handler;
import android.text.TextUtils;
import com.fc.tjcpl.sdk.n.e0;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class h implements BridgeHandler {
    public final /* synthetic */ CustomViewContent a;

    public h(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeHandler
    public void handler(String str, CallBackFunction callBackFunction) throws JSONException {
        Handler handler;
        Runnable d0Var;
        List<String> list;
        this.a.e = true;
        if (this.a.j) {
            return;
        }
        com.fc.tjcpl.sdk.i.c.b("tag", "natAddDownloadTask==" + str);
        com.fc.tjcpl.sdk.a.a aVarD = com.fc.tjcpl.sdk.b.a.d(str);
        if (TextUtils.isEmpty(aVarD.e) || TextUtils.isEmpty(aVarD.h) || TextUtils.isEmpty(aVarD.g)) {
            return;
        }
        e0 e0Var = e0.b.a;
        a aVar = this.a.a;
        e0Var.e = false;
        e0Var.b = aVar;
        com.fc.tjcpl.sdk.b.a.a(e0Var.c);
        com.fc.tjcpl.sdk.a.a aVar2 = e0Var.a;
        if (aVar2 != null && !aVar2.h.equals(aVarD.h)) {
            com.fc.tjcpl.sdk.b.a.k(e0Var.a.h);
        }
        e0Var.a = aVarD;
        com.fc.tjcpl.sdk.f.a aVar3 = new com.fc.tjcpl.sdk.f.a(aVarD.h);
        aVar3.a = aVarD.e;
        aVar3.d = aVarD.g;
        if (aVarD.p && (list = aVarD.q) != null && list.size() > 0) {
            aVar3.e = aVarD.q;
        }
        com.fc.tjcpl.sdk.b.a.a(aVar3);
        com.fc.tjcpl.sdk.b.a.c(aVarD.h);
        int iH = com.fc.tjcpl.sdk.b.a.h(aVarD.h);
        if (iH == 0 || iH == 5) {
            if (com.fc.tjcpl.sdk.b.a.h()) {
                if (e0Var.a.j != 1) {
                    return;
                }
                handler = e0Var.d;
                d0Var = new c0(e0Var);
            } else {
                if (e0Var.a.i != 1) {
                    return;
                }
                handler = e0Var.d;
                d0Var = new d0(e0Var);
            }
            handler.postDelayed(d0Var, 200L);
        }
    }
}
