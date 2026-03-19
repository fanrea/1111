package com.bytedance.applog.event;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IEventHandler {
    int acceptType();

    EventPolicy onReceive(int i, String str, JSONObject jSONObject);
}
