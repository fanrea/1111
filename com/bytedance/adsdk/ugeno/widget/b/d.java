package com.bytedance.adsdk.ugeno.widget.b;

import android.content.Context;
import com.bytedance.adsdk.ugeno.widget.frame.UGFrameLayout;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d extends com.bytedance.adsdk.ugeno.hc.d<UGFrameLayout> {
    public d(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d, com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        super.d(str, str2);
        str.hashCode();
        switch (str) {
            case "onVideoProgress":
            case "onVideoFinish":
            case "onVideoPlay":
            case "onVideoResume":
            case "onVideoPause":
                hc(str, str2);
                break;
        }
    }
}
