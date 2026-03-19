package com.bytedance.msdk.u;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static volatile hc d;
    private List<d> hc = new CopyOnWriteArrayList();

    public static class d {
        private c d;
        private JSONObject hc;

        public d(c cVar, JSONObject jSONObject) {
            this.d = cVar;
            this.hc = jSONObject;
        }

        public c d() {
            return this.d;
        }

        public JSONObject hc() {
            return this.hc;
        }
    }

    private hc() {
    }

    public static hc d() {
        if (d == null) {
            synchronized (hc.class) {
                if (d == null) {
                    d = new hc();
                }
            }
        }
        return d;
    }

    public List<d> hc() {
        return this.hc;
    }

    public void d(c cVar, JSONObject jSONObject) {
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- 保存到埋点辅助模块");
        this.hc.add(new d(cVar, jSONObject));
    }

    public void b() {
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- 清空埋点辅助模块");
        List<d> list = this.hc;
        if (list != null) {
            list.clear();
        }
    }
}
