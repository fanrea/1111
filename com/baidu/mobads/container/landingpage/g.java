package com.baidu.mobads.container.landingpage;

import android.view.View;
import com.component.a.g.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g extends d.c {
    final /* synthetic */ App2Activity a;

    g(App2Activity app2Activity) {
        this.a = app2Activity;
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str, String str2) {
        super.a(view, str, str2);
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str) throws JSONException {
        super.a(view, str);
        if ("lp_go_back".equals(str)) {
            if (this.a.curWebview == null || !this.a.curWebview.canGoBack()) {
                if (!this.a.checkGoBack()) {
                    this.a.updateLpState("backBtnFinish");
                    this.a.closeCause = "topLeftBtn";
                    this.a.exit();
                    this.a.mLandingPageTrackingInfo.R++;
                    return;
                }
                return;
            }
            if (!this.a.checkGoBack()) {
                if (this.a.mOpenBundleForbid && this.a.curWebview.a.equals(this.a.finishUrl)) {
                    this.a.updateLpState("backBtnFinish");
                    this.a.closeCause = "topLeftBtn";
                    this.a.exit();
                    this.a.mLandingPageTrackingInfo.R++;
                }
                this.a.curWebview.goBack();
                return;
            }
            return;
        }
        if ("lp_close".equals(str)) {
            this.a.updateLpState("backBtnFinish");
            this.a.closeCause = "topLeftBtn";
            this.a.exit();
            this.a.mLandingPageTrackingInfo.R++;
            return;
        }
        if ("lp_three_points".equals(str)) {
            if (!"1".equals(this.a.mCustomizedBar)) {
                this.a.showBottomView();
                this.a.mLandingPageTrackingInfo.S++;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("act", "popwindow");
                    com.baidu.mobads.container.activity.d.a().a(this.a.mProxyActivity, jSONObject.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.component.a.g.d.c
    public void a(com.component.a.f.d dVar) {
        super.a(dVar);
    }
}
