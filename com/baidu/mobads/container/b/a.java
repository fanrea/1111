package com.baidu.mobads.container.b;

import android.content.Context;
import android.content.Intent;
import com.baidu.mobads.container.activity.DownloadDialogActivity;
import com.baidu.mobads.container.activity.e;
import com.baidu.mobads.container.activity.v;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.k;
import com.baidu.mobads.container.l.g;
import com.baidu.mobads.container.util.h;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private v a;

    public void a(k kVar, j jVar) {
        boolean z;
        if (kVar == null || jVar == null) {
            return;
        }
        if (!(kVar instanceof com.baidu.mobads.container.f.b)) {
            z = true;
        } else {
            z = false;
        }
        t adContainerContext = kVar.getAdContainerContext();
        if (adContainerContext == null) {
            return;
        }
        Context contextT = adContainerContext.t();
        String strK = adContainerContext.k();
        String strZ = adContainerContext.z();
        String strL = adContainerContext.l();
        this.a = new b(this, kVar, jVar);
        try {
            if (!com.baidu.mobads.container.config.b.a().e()) {
                com.style.widget.b.a.a(adContainerContext.u(), jVar).a(z).a(1).a(strZ, strK, strL).a(this.a).a();
            } else {
                e.a().a(this.a);
                Intent intent = new Intent();
                intent.putExtra("adElementInfo", a(jVar));
                intent.putExtra("appsid", strZ);
                intent.putExtra("prod", strK);
                intent.putExtra("apid", strL);
                intent.putExtra(DownloadDialogActivity.AD_DIALOG_TYPE, 1);
                h.b(contextT, intent);
            }
        } catch (Throwable th) {
            g.e(th);
        }
    }

    private String a(j jVar) {
        if (jVar != null) {
            try {
                JSONObject jSONObject = new JSONObject(jVar.getOriginJsonObject().toString());
                jSONObject.remove("ad_html");
                return jSONObject.toString();
            } catch (Throwable th) {
                g.e(th);
                return "";
            }
        }
        return "";
    }
}
