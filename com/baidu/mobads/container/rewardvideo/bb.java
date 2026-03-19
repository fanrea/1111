package com.baidu.mobads.container.rewardvideo;

import android.text.TextUtils;
import com.component.a.g.g;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bb extends g.b {
    final /* synthetic */ NativeRewardActivity a;

    bb(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // com.component.a.g.g.b
    public void a(String str, String str2, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectC;
        JSONArray jSONArrayNames;
        if ("rvideo_lp_retain_view".equals(str2)) {
            if (this.a.mAdInstanceInfo != null) {
                this.a.mAdInstanceInfo.setSubTemplate("rvideo_lp_retain_view", jSONObject);
                return;
            }
            return;
        }
        if ("click_reward".equals(str2) && (jSONObjectOptJSONObject = jSONObject.optJSONObject("config")) != null && jSONObjectOptJSONObject.has("amend_info") && (jSONArrayNames = (jSONObjectC = com.component.a.i.n.c(jSONObjectOptJSONObject.optString("amend_info", ""))).names()) != null && jSONArrayNames.length() == 2) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                String strOptString = jSONArrayNames.optString(i);
                if (!TextUtils.equals("segmented_countdown_first_text_hint", strOptString)) {
                    this.a.at = strOptString;
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectC.optJSONObject(strOptString);
                    if (jSONObjectOptJSONObject2 != null) {
                        this.a.au = jSONObjectOptJSONObject2.optString("text");
                    }
                }
            }
        }
    }
}
