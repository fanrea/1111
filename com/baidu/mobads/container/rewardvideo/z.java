package com.baidu.mobads.container.rewardvideo;

import com.baidu.mobads.container.components.g.f;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class z implements f.a {
    final /* synthetic */ NativeRewardActivity a;

    z(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("code", 400) != 0) {
                this.a.b("0");
            } else {
                this.a.b(jSONObject.optString("isValid", "0"));
            }
        } catch (Throwable th) {
            this.a.b("0");
        }
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(String str, int i) {
        this.a.b("0");
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(long j) {
    }
}
