package com.bytedance.sdk.djx.net.log;

import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IEventUpload {
    void send(String str, String str2, JSONObject jSONObject, List<ILogReplace> list);

    void sendMiscEvent(String str, JSONObject jSONObject);
}
