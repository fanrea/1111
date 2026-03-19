package com.baidu.mobads.container.config;

import android.content.Context;
import android.content.Intent;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.util.h;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class PromoteInstallConfig {
    public static int installPopSwitch = 0;
    public static int installPopType = 0;
    public static int installPopTemplate = 0;

    public static boolean isInstallPopSwitch() {
        return installPopSwitch != 0;
    }

    public static int getInstallPopType() {
        return installPopType;
    }

    public static int getInstallPopTemplate() {
        return installPopTemplate;
    }

    public static void startInstallDialogActivity(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("adElementInfo", str);
        h.d(context, intent);
    }

    public static JSONObject getAdDownLoadInfo(Context context, String str) {
        try {
            return j.a(context, str).a();
        } catch (Throwable th) {
            return null;
        }
    }

    public static void handleAdInstall(Context context, String str) {
        try {
            j jVarA = j.a(context, str);
            com.baidu.mobads.container.util.j.a(context, new File(jVarA.T + jVarA.S), jVarA);
        } catch (Throwable th) {
        }
    }
}
