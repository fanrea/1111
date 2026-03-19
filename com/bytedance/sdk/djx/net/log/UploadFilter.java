package com.bytedance.sdk.djx.net.log;

import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.debug.DebugInfo;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class UploadFilter implements IEventUpload {
    public static UploadFilter DEFAULT = new UploadFilter();
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    UploadFilter() {
    }

    @Override // com.bytedance.sdk.djx.net.log.IEventUpload
    public void send(String str, String str2, JSONObject jSONObject, List<ILogReplace> list) {
        try {
            if (DebugInfo.Bridge.isApplogPrint()) {
                printJson("UploadFilter", jSONObject.toString(), str);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.djx.net.log.IEventUpload
    public void sendMiscEvent(String str, JSONObject jSONObject) {
        try {
            if (DebugInfo.Bridge.isApplogPrint()) {
                printJson("UploadFilter_Misc", jSONObject.toString(), str);
            }
        } catch (Throwable unused) {
        }
    }

    public static void printLine(String str, boolean z) {
        if (z) {
            LG.d(str, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            LG.d(str, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }

    public static void printJson(String str, String str2, String str3) throws JSONException {
        try {
            if (str2.startsWith("{")) {
                str2 = new JSONObject(str2).toString(4);
            } else if (str2.startsWith("[")) {
                str2 = new JSONArray(str2).toString(4);
            }
        } catch (JSONException unused) {
        }
        printLine(str, true);
        StringBuilder sbAppend = new StringBuilder().append(str3);
        String str4 = LINE_SEPARATOR;
        for (String str5 : sbAppend.append(str4).append(str2).toString().split(str4)) {
            LG.d(str, "║ " + str5);
        }
        printLine(str, false);
    }
}
