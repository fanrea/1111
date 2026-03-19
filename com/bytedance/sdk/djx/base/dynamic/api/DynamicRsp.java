package com.bytedance.sdk.djx.base.dynamic.api;

import android.text.TextUtils;
import com.bytedance.sdk.djx.base.dynamic.DynamicModel;
import com.bytedance.sdk.djx.net.api.BaseDjxRsp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicRsp extends BaseDjxRsp<JSONObject> {
    private final Map<String, DynamicModel> mMap = new HashMap();

    public void addConfig(String str, DynamicModel dynamicModel) {
        if (TextUtils.isEmpty(str) || dynamicModel == null) {
            return;
        }
        this.mMap.put(str, dynamicModel);
    }

    public DynamicModel getConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mMap.get(str);
    }

    public Map<String, DynamicModel> getMap() {
        return this.mMap;
    }
}
