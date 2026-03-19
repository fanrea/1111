package com.baidu.mobads.upgrade.remote.mtj;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class MTJDexLoaderImpl implements com.baidu.mobads.container.m.a {
    @Override // com.baidu.mobads.container.m.a
    public void initMtj(Context context) {
        a.a().a(context);
    }

    @Override // com.baidu.mobads.container.m.a
    public void closeMtj() {
        a.a().b();
    }

    @Override // com.baidu.mobads.container.m.a
    public void saveBqtLog(JSONObject jSONObject) {
        a.a().a(jSONObject);
    }
}
