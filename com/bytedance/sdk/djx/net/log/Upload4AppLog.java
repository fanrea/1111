package com.bytedance.sdk.djx.net.log;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.AppLogManager;
import com.bytedance.sdk.djx.utils.DJXSdkUtils;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.ToolUtils;
import com.bytedance.sdk.djx.utils.Utils;
import com.bytedance.sdk.djx.utils.debug.DebugInfo;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class Upload4AppLog implements IEventUpload {
    public static Upload4AppLog DEFAULT = new Upload4AppLog();

    private Upload4AppLog() {
    }

    @Override // com.bytedance.sdk.djx.net.log.IEventUpload
    public void send(String str, String str2, JSONObject jSONObject, List<ILogReplace> list) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObjectInjectSecondAppId = injectSecondAppId(str2, jSONObject);
        if (list != null && !list.isEmpty()) {
            for (ILogReplace iLogReplace : list) {
                if (iLogReplace != null) {
                    jSONObjectInjectSecondAppId = iLogReplace.onReplace(jSONObjectInjectSecondAppId);
                }
            }
        }
        AppLogManager.getAppLogInstance().onEventV3("csj_sp_" + str, jSONObjectInjectSecondAppId);
        UploadFilter.DEFAULT.send(str, str2, jSONObject, list);
    }

    @Override // com.bytedance.sdk.djx.net.log.IEventUpload
    public void sendMiscEvent(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppLogManager.getAppLogInstance().onMiscEvent(str, jSONObject);
        UploadFilter.DEFAULT.sendMiscEvent(str, jSONObject);
    }

    private JSONObject injectSecondAppId(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = JSON.build();
        }
        try {
            String userId = TokenHelper.getInstance().getUserId();
            int userType = TokenHelper.getInstance().getUserType();
            int i = 0;
            String str2 = String.format(Locale.getDefault(), "%s_%s", Integer.valueOf(userType), userId);
            JSON.putObject(jSONObject, "params_for_special", "csj_sp");
            JSON.putObject(jSONObject, "traffic_type", FeedReqParams.REQ_TYPE_OPEN);
            JSON.putObject(jSONObject, "user_id", userId);
            JSON.putInt(jSONObject, "user_type", userType);
            JSON.putObject(jSONObject, "user_unique_id", str2);
            JSON.putObject(jSONObject, "utm_source", DevInfo.sPartner);
            JSON.putObject(jSONObject, "site_id", DevInfo.sSiteId);
            JSON.putObject(jSONObject, "applog_aid", DevInfo.sAppId);
            JSON.putObject(jSONObject, ILogConst.Keys.KEY_PKG_NAME, ToolUtils.getPackageName());
            JSON.putObject(jSONObject, "app_name", ToolUtils.getAppName());
            JSON.putObject(jSONObject, "plugin_package_name", DJXSdkUtils.getReportName());
            JSON.putObject(jSONObject, "is_plugin_version", Boolean.valueOf(Utils.IS_P));
            JSON.putObject(jSONObject, "plugin_mode", Integer.valueOf(Utils.pluginMode() ? 1 : 0));
            JSON.putObject(jSONObject, "sdk_version", "2.9.0.2");
            if (!TextUtils.isEmpty(DevInfo.sSiteId)) {
                JSON.putObject(jSONObject, "site_id", DevInfo.sSiteId);
            }
            Map mapPpe = DebugInfo.Bridge.ppe();
            if (mapPpe != null && mapPpe.containsKey("x-use-boe")) {
                i = 1;
            }
            JSON.putObject(jSONObject, "is_boe_data", Integer.valueOf(i));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
