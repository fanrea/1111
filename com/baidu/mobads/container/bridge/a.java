package com.baidu.mobads.container.bridge;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.bridge.b;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.sdk.api.IOAdEvent;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends b {
    private x X;

    public a(Context context, ax axVar, com.baidu.mobads.container.adrequest.j jVar, String str, String str2, x xVar) {
        super(context, axVar, jVar, str, str2);
        this.X = xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x017b  */
    @Override // com.baidu.mobads.container.bridge.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.bridge.a.a(java.lang.String):void");
    }

    @Override // com.baidu.mobads.container.bridge.b, com.baidu.mobads.container.components.c.a.InterfaceC0121a
    public boolean a(Context context, Intent intent) {
        b.a aVar;
        try {
            if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                String dataString = intent.getDataString();
                if (!TextUtils.isEmpty(dataString)) {
                    String strReplace = dataString.replace("package:", "");
                    if (this.T.containsKey(strReplace) && (aVar = this.T.get(strReplace)) != null) {
                        aVar.a = "6";
                        b(aVar.g, aVar.a());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void b(String str) {
        try {
            b.a aVar = this.T.get(str);
            if (aVar == null) {
                return;
            }
            b(aVar);
            JSONObject jSONObjectA = aVar.a();
            if (!TextUtils.isEmpty(aVar.g) && this.V != null) {
                try {
                    if (k(str)) {
                        aVar.a = "6";
                        jSONObjectA = aVar.a();
                    }
                    b(aVar.g, jSONObjectA);
                } catch (Throwable th) {
                    bq.a().b("JmyJsHandler", th.getMessage());
                }
            }
        } catch (Throwable th2) {
            bq.a().b("JmyJsHandler", th2.getMessage());
        }
    }

    @Override // com.baidu.mobads.container.bridge.b, com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            try {
                if (com.baidu.mobads.container.components.k.b.u.equals(iOAdEvent.getType())) {
                    String message = iOAdEvent.getMessage();
                    if (!TextUtils.isEmpty(message) && this.T.containsKey(message)) {
                        b(message);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
