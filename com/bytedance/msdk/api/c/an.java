package com.bytedance.msdk.api.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private Map<String, String> gb;
    public final String d = "TTMediationSDK";
    private String hc = "";
    private String b = "";
    private String c = "";
    private int u = 0;
    private String an = "";
    private String h = "";

    public void d(Map<String, String> map) {
        this.gb = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!an(entry.getKey())) {
                    com.bytedance.sdk.component.utils.mq.c("TTMediationSDK", "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (!an(entry.getValue())) {
                    com.bytedance.sdk.component.utils.mq.c("TTMediationSDK", "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                } else {
                    this.gb.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public Map<String, String> d() {
        return this.gb;
    }

    public String hc() {
        return this.hc;
    }

    public void d(String str) {
        if (an(str)) {
            this.hc = str;
        } else {
            com.bytedance.sdk.component.utils.mq.c("TTMediationSDK", "流量分组user_id字段存在不合法输入");
        }
    }

    public String b() {
        return this.b;
    }

    public void hc(String str) {
        if (an(str)) {
            this.b = str;
        } else {
            com.bytedance.sdk.component.utils.mq.c("TTMediationSDK", "流量分组channer字段存在不合法输入");
        }
    }

    public String c() {
        return this.c;
    }

    public void b(String str) {
        if (an(str)) {
            this.c = str;
        } else {
            com.bytedance.sdk.component.utils.mq.c("TTMediationSDK", "流量分组sub_channer字段存在不合法输入");
        }
    }

    public int u() {
        return this.u;
    }

    public void d(int i) {
        this.u = i;
    }

    public String an() {
        return this.an;
    }

    public void c(String str) {
        if (an(str)) {
            this.an = str;
        } else {
            com.bytedance.sdk.component.utils.mq.c("TTMediationSDK", "流量分组gender字段存在不合法输入");
        }
    }

    public String h() {
        return this.h;
    }

    public void u(String str) {
        if (an(str)) {
            this.h = str;
        } else {
            com.bytedance.sdk.component.utils.mq.c("TTMediationSDK", "流量分组user_value_group字段存在不合法输入");
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            an anVar = (an) obj;
            boolean z2 = u() == anVar.u() && TextUtils.equals(h(), anVar.h()) && TextUtils.equals(hc(), anVar.hc()) && TextUtils.equals(b(), anVar.b()) && TextUtils.equals(c(), anVar.c()) && TextUtils.equals(an(), anVar.an());
            Map<String, String> mapD = anVar.d();
            Map<String, String> map = this.gb;
            if (map != null && mapD != null) {
                if (map.size() == mapD.size()) {
                    for (String str : this.gb.keySet()) {
                        if (TextUtils.isEmpty(str) || TextUtils.equals(this.gb.get(str), mapD.get(str))) {
                        }
                    }
                    z = true;
                }
                z = false;
                break;
            }
            if (map != null || mapD != null) {
                z = false;
                break;
            }
            z = true;
            if (z2 && z) {
                return true;
            }
        }
        return false;
    }

    public static boolean an(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }
}
