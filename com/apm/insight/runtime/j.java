package com.apm.insight.runtime;

import android.content.Context;
import com.apm.applog.AppLog;
import com.apm.insight.ICommonParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class j {
    public static d a(Context context) {
        return new d(context, new ICommonParams() { // from class: com.apm.insight.runtime.j.1
            @Override // com.apm.insight.ICommonParams
            public Map<String, Object> getCommonParams() {
                return new HashMap();
            }

            @Override // com.apm.insight.ICommonParams
            public String getDeviceId() {
                AppLog appLog = AppLog.getInstance(com.apm.insight.g.a().e());
                return appLog != null ? appLog.getDid() : "";
            }

            @Override // com.apm.insight.ICommonParams
            public List<String> getPatchInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public Map<String, Integer> getPluginInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public String getSessionId() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public long getUserId() {
                return 0L;
            }
        });
    }
}
