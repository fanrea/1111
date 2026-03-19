package com.kuaishou.security.kste.logic.report;

import com.baidu.mobads.container.util.cm;
import com.kuaishou.security.kste.logic.report.KVGuardPerf;
import com.kuaishou.security.kste.logic.util.KWLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class LogProxy {
    LogProxy() {
    }

    public static void nativeReport(int i, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", i);
            jSONObject.put(cm.V, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        KWLog.debug("native report here " + jSONObject);
        KVGuardPerf.error(KVGuardPerf.RType.ALL, jSONObject.toString(), 999);
    }
}
