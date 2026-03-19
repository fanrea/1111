package com.bytedance.msdk.an.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class tc extends c {
    protected String d;

    public tc() {
        super(null);
        com.bytedance.msdk.core.tc.d dVarH = h();
        if (dVarH != null) {
            this.d = dVarH.d();
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = com.bytedance.msdk.core.d.mk().mq();
        }
    }

    public tc(com.bytedance.msdk.api.c.mk mkVar) {
        super(mkVar);
        if (mkVar != null) {
            this.d = mkVar.b();
        }
    }

    public static tc tt() {
        if (com.bytedance.msdk.core.d.mk().mt()) {
            return new mk();
        }
        return new tt();
    }

    public static tc hc(com.bytedance.msdk.api.c.mk mkVar) {
        if (com.bytedance.msdk.core.d.mk().mt()) {
            return new mk(mkVar);
        }
        return new tt(mkVar);
    }

    @Override // com.bytedance.msdk.an.d.b
    protected Map<String, Object> d() {
        HashMap map = new HashMap();
        map.put(com.alipay.sdk.m.k.b.D0, this.d);
        map.put("pangle_app_name", com.bytedance.msdk.core.d.mk().sy());
        map.put("pangle_is_pangle_paid", Boolean.valueOf(com.bytedance.msdk.core.d.mk().e()));
        map.put("pangle_title_bar_theme", Integer.valueOf(com.bytedance.msdk.core.d.mk().de()));
        map.put("pangle_is_pangle_allow_show_notify", Boolean.valueOf(com.bytedance.msdk.core.d.mk().k()));
        map.put("pangle_is_pangle_allow_show_page_when_screen_lock", Boolean.valueOf(com.bytedance.msdk.core.d.mk().jh()));
        map.put("pangle_direct_download_networktype", com.bytedance.msdk.core.d.mk().rf());
        map.put("pangle_need_clear_task_reset", com.bytedance.msdk.core.d.mk().v());
        map.put("pangle_keywords", com.bytedance.msdk.core.d.mk().vv());
        map.put("pangle_support_multi_process", Boolean.valueOf(com.bytedance.msdk.core.d.mk().uo()));
        return map;
    }

    @Override // com.bytedance.msdk.an.d.b
    protected String b() {
        if (!TextUtils.isEmpty(this.d)) {
            return "";
        }
        com.bytedance.msdk.core.tc.d dVarH = h();
        if (dVarH != null) {
            this.d = dVarH.d();
        }
        return TextUtils.isEmpty(this.d) ? "appId为空" : "";
    }
}
