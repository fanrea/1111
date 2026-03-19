package com.bytedance.bmf_mods_api;

import android.util.Log;

/* compiled from: VideoBrightCallbackAPI.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class VideoBrightCallBackAPIDefault implements VideoBrightCallbackAPI {
    @Override // com.bytedance.bmf_mods_api.VideoBrightCallbackAPI
    public void callback(int i, float f, float f2, float f3) {
        Log.d("bmf_mods", "status change:" + i + " cost time:" + f + " bright_before:" + f2 + " bright_after:" + f3);
    }
}
