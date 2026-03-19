package com.bytedance.msdk.core.gb;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc {
    private static final String d = "TTMediationSDK_tc";
    private com.bytedance.msdk.u.d.b<tt> b;
    private Map<String, tt> hc;

    private tc() {
        this.b = new com.bytedance.msdk.u.d.c(com.bytedance.msdk.core.hc.getContext());
        this.hc = new ConcurrentHashMap();
    }

    public static tc d() {
        return d.d;
    }

    private static class d {
        private static tc d = new tc();
    }

    public void d(String str, long j) {
        if (this.b != null) {
            Map<String, tt> map = this.hc;
            tt ttVar = map != null ? map.get(str) : null;
            if (ttVar != null) {
                ttVar.d(j);
            }
            this.b.d(str, j);
        }
    }

    public void d(String str, String str2, long j) {
        if (this.b != null) {
            Map<String, tt> map = this.hc;
            tt ttVar = map != null ? map.get(str + Config.replace + str2) : null;
            if (ttVar != null) {
                ttVar.d(j);
            }
            this.b.d(str, str2, j);
        }
    }

    public void d(String str) {
        if (this.b != null) {
            Map<String, tt> map = this.hc;
            if (map != null) {
                map.remove(str);
            }
            this.b.delete(str);
        }
    }

    public void d(String str, String str2) {
        if (this.b != null) {
            Map<String, tt> map = this.hc;
            if (map != null) {
                map.remove(str + Config.replace + str2);
            }
            this.b.delete(str, str2);
        }
    }

    public void d(tt ttVar) {
        if (this.b == null || TextUtils.isEmpty(ttVar.tc())) {
            return;
        }
        Map<String, tt> map = this.hc;
        if (map != null) {
            map.put(ttVar.c(), ttVar);
        }
        this.b.hc(ttVar);
    }

    public tt hc(String str) {
        if (this.b == null) {
            return null;
        }
        Map<String, tt> map = this.hc;
        tt ttVar = map != null ? map.get(str) : null;
        if (ttVar != null) {
            return ttVar;
        }
        tt ttVarQuery = this.b.query(str);
        if (ttVarQuery != null) {
            this.hc.put(ttVarQuery.hc(), ttVarQuery);
        }
        return ttVarQuery;
    }

    public tt hc(String str, String str2) {
        if (this.b == null) {
            return null;
        }
        Map<String, tt> map = this.hc;
        tt ttVar = map != null ? map.get(str + Config.replace + str2) : null;
        if (ttVar != null) {
            return ttVar;
        }
        tt ttVarQuery = this.b.query(str, str2);
        if (ttVarQuery != null) {
            this.hc.put(ttVarQuery.c(), ttVarQuery);
        }
        return ttVarQuery;
    }
}
