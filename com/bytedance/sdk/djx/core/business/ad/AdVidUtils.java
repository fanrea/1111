package com.bytedance.sdk.djx.core.business.ad;

import com.alipay.sdk.m.p0.b;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.DeviceUtils;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AdVidUtils {
    public static int[] buildVid() {
        List<Integer> vidVersions = SettingData.getInstance().getVidVersions();
        if (vidVersions != null) {
            int size = vidVersions.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = vidVersions.get(i).intValue();
            }
            LG.d("AdVidUtils", "vid: " + Arrays.toString(iArr));
            return iArr;
        }
        LG.d("AdVidUtils", "vid: null");
        return new int[0];
    }

    public static String buildUserData(AdKey adKey) {
        JSONArray vidOthers = SettingData.getInstance().getVidOthers();
        if (vidOthers == null) {
            vidOthers = JSON.buildArr();
        }
        vidOthers.put(buildJSON("personal_traffic_source_type", "1"));
        vidOthers.put(buildJSON("pangrowth_content_site_id", DevInfo.sSiteId));
        vidOthers.put(buildJSON("pangrowth_content_did", DeviceUtils.getDid()));
        vidOthers.put(buildJSON("pangrowth_content_local_id", DeviceUtils.getLocalDid()));
        vidOthers.put(buildJSON("pangrowth_content_sdk_version", "2.9.0.2"));
        vidOthers.put(buildJSON("pangrowth_content_uid", TokenHelper.getInstance().getUserId()));
        vidOthers.put(buildJSON("content_did", TokenHelper.getInstance().getUtUid()));
        vidOthers.put(buildJSON("content_utmsource", DevInfo.sPartner));
        vidOthers.put(buildJSON("content_sdk_version", "2.9.0.2"));
        vidOthers.put(buildJSON("scene", "MVID"));
        if (adKey != null) {
            vidOthers.put(buildJSON("featureValues", adKey.getFeatureValues()));
        }
        LG.d("AdVidUtils", "others: " + vidOthers);
        return vidOthers.toString();
    }

    private static JSONObject buildJSON(String str, String str2) {
        JSONObject jSONObjectBuild = JSON.build();
        JSON.putObject(jSONObjectBuild, "name", str);
        JSON.putObject(jSONObjectBuild, b.d, str2);
        return jSONObjectBuild;
    }
}
