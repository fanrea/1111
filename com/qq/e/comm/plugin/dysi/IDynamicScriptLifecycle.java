package com.qq.e.comm.plugin.dysi;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface IDynamicScriptLifecycle {
    void onAppBackground();

    void onAppForeground();

    void onBindData(JSONObject jSONObject);

    void onStartAnimation(String str);

    void onViewCreate();

    void onViewDestroy();

    void onWindowBlur();

    void onWindowFocus();
}
