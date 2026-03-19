package com.bytedance.applog.simulate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IPageMeta;
import com.bytedance.applog.annotation.PageMeta;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

@PageMeta(path = "/simulateLaunch", title = "圈选/埋点验证")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SimulateLaunchActivity extends Activity implements IPageMeta {
    public static final String BIND_QUERY = "bind_query";
    public static final String DEBUG_LOG = "debug_log";
    public static final String KEY_URL_PREFIX = "url_prefix";
    public static final String KEY_URL_PREFIX_NO_QR = "url_prefix_no_qr";
    public static final int MODE_NO_QR = 1;
    public static final int MODE_QR = 0;
    public static String entryAppId = "";
    public static int entryMode = 0;
    public static String entryQrParam = "";
    public static String entryType = "";
    public static String entryUrlPrefix = "";
    public TextView a;

    public static void startSimulatorWithoutQR(Context context, String str) {
        startSimulatorWithoutQR(context, AppLog.getAppId(), str);
    }

    public static void startSimulatorWithoutQR(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) SimulateLaunchActivity.class);
        intent.putExtra(KEY_URL_PREFIX_NO_QR, str2);
        intent.putExtra("aid_no_qr", str);
        context.startActivity(intent);
    }

    public final IAppLogLogger a() {
        IAppLogLogger logger = LoggerImpl.getLogger(entryAppId);
        return logger != null ? logger : LoggerImpl.global();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f8  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.simulate.SimulateLaunchActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.applog.IPageMeta
    public JSONObject pageProperties() {
        try {
            return new JSONObject().put("class_name", "SimulateLaunchActivity");
        } catch (JSONException e) {
            a().debug(Collections.singletonList("SimulateLaunchActivity"), "JSON handle failed", e);
            return null;
        }
    }

    @Override // com.bytedance.applog.IPageMeta
    public String path() {
        return "/simulateLaunch";
    }

    @Override // com.bytedance.applog.IPageMeta
    public String title() {
        return "圈选/埋点验证";
    }
}
