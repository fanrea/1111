package com.bytedance.msdk.gb;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class sy extends HashMap<String, Object> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        if ("gm_usb".equals(obj)) {
            com.bytedance.msdk.core.d.mk().d(true);
            if (!com.bytedance.msdk.core.hc.hc().mt()) {
                return "接口获取无权限，请联系商务开通";
            }
        } else if ("gm_policy".equals(obj)) {
            if (!com.bytedance.msdk.core.hc.hc().r()) {
                return "接口获取无权限，请联系商务开通";
            }
            Object obj2 = get("prime_rit");
            if (obj2 instanceof String) {
                String str = (String) obj2;
                com.bytedance.msdk.core.hc.hc hcVarBc = com.bytedance.msdk.core.hc.hc().bc();
                if (hcVarBc != null) {
                    return hcVarBc.d(str, this);
                }
            }
        }
        return super.get(obj);
    }

    @Override // java.util.HashMap, java.util.Map
    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        if ("gm_usb".equals(str)) {
            return !com.bytedance.msdk.core.hc.hc().mt() ? super.put(str, "接口获取无权限，请联系商务开通") : super.put(str, obj);
        }
        if ("usePolicy".equals(str) && com.bytedance.msdk.core.hc.hc().r() && (obj instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!com.bytedance.msdk.core.d.mk().c().containsKey(next)) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK", "KEY_USE_POLICY的adLoad参数中存在不合法key：" + next + "，该key将被移除，如需要自定义key 请通过 KEY_USE_POLICY 中的 KEY_USE_POLICY_OBJ_CUSTOM 实现");
                } else {
                    Object objOpt = jSONObject.opt(next);
                    if (objOpt != null && !d(String.valueOf(objOpt))) {
                        com.bytedance.sdk.component.utils.mq.c("TTMediationSDK", "adLoad参数中key为 " + next + " 字段的值，" + objOpt + " 存在不合法输入");
                    }
                }
            }
        }
        return super.put(str, obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends String, ?> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }
}
