package com.pandora.common.applog;

import com.pandora.common.Parameter;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface IAppLogEngine {
    void addDataObserver(IApplogObserver observer);

    Parameter getConfig();

    String getDeviceID();

    String getUUID();

    @Deprecated
    void onPause();

    @Deprecated
    void onResume();

    void onUpload(String event, JSONObject jsonObject);
}
