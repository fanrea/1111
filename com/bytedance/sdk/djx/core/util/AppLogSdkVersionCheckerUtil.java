package com.bytedance.sdk.djx.core.util;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IDataObserver;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.internal.utils.DJXLogger;
import com.bytedance.sdk.djx.utils.HostContext;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AppLogSdkVersionCheckerUtil {
    private static final String MIN_APPLOG_SDK_VERSION = "6.2.2";
    private static final String TAG = "AdSdkVersionCheckUtil";
    private static String sAppLogCheckerMessage = "";
    private static final Handler sHandler = new Handler(Looper.getMainLooper());

    public static void checkAppLogSdkVersion() {
        sAppLogCheckerMessage = "";
        if (DevInfo.sIsDebug) {
            if (AppLog.getHeader() == null) {
                AppLog.addDataObserver(new IDataObserver() { // from class: com.bytedance.sdk.djx.core.util.AppLogSdkVersionCheckerUtil.1
                    @Override // com.bytedance.applog.IDataObserver
                    public void onAbVidsChange(String str, String str2) {
                    }

                    @Override // com.bytedance.applog.IDataObserver
                    public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
                    }

                    @Override // com.bytedance.applog.IDataObserver
                    public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
                    }

                    @Override // com.bytedance.applog.IDataObserver
                    public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
                    }

                    @Override // com.bytedance.applog.IDataObserver
                    public void onIdLoaded(String str, String str2, String str3) {
                        AppLogSdkVersionCheckerUtil.checkAppLogVersion();
                        AppLogSdkVersionCheckerUtil.versionCheckerToast();
                    }
                });
            } else {
                checkAppLogVersion();
                versionCheckerToast();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkAppLogVersion() {
        JSONObject header = AppLog.getHeader();
        if (header != null) {
            try {
                String string = header.getString("sdk_version_name");
                if (compareVersion(string, MIN_APPLOG_SDK_VERSION) < 0) {
                    sAppLogCheckerMessage = "AppLog版本过低，推荐版本为6.2.2";
                }
                DJXLogger.d(TAG, "applog version: " + String.valueOf(string));
            } catch (Throwable th) {
                DJXLogger.e(TAG, "checkAppLogVersion: ", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void versionCheckerToast() {
        if (TextUtils.isEmpty(sAppLogCheckerMessage)) {
            return;
        }
        sHandler.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.util.AppLogSdkVersionCheckerUtil.2
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(HostContext.getContext(), AppLogSdkVersionCheckerUtil.sAppLogCheckerMessage, 1).show();
            }
        });
    }

    private static int compareVersion(String str, String str2) throws NumberFormatException {
        try {
            String[] strArrSplit = str2.split("\\.");
            String[] strArrSplit2 = str.split("\\.");
            if (strArrSplit.length != strArrSplit2.length) {
                return 1;
            }
            for (int i = 0; i < strArrSplit.length; i++) {
                int i2 = Integer.parseInt(strArrSplit2[i]);
                int i3 = Integer.parseInt(strArrSplit[i]);
                if (i2 != i3) {
                    return i2 > i3 ? 1 : -1;
                }
            }
            return 0;
        } catch (Exception unused) {
            return 1;
        }
    }
}
