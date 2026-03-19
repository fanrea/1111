package com.baidu.mobads.container.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.container.components.command.OtherDLInfoManager;
import com.kuaishou.tk.api.export.sdk.TKErrorCode;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bd extends BroadcastReceiver {
    public static final String a = "com.xiaomi.market.DIRECT_MAIL_CHECK_RESULT";
    public static final String b = "com.xiaomi.market.DIRECT_MAIL_STATUS";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i;
        try {
            Bundle extras = intent.getExtras();
            String string = extras.getString("packageName");
            if (!TextUtils.isEmpty(string) && com.baidu.mobads.container.components.c.g.a().a(string)) {
                com.baidu.mobads.container.components.c.g.a().a(context, intent);
                return;
            }
            String action = intent.getAction();
            if (a.equals(action)) {
                if (extras.getInt("styleCheckResult") == 0) {
                    OtherDLInfoManager.getInstance().a(string + "," + System.currentTimeMillis() + ",111,-1;");
                    return;
                }
                return;
            }
            if (b.equals(action)) {
                switch (extras.getInt("statusCode")) {
                    case 1002:
                        i = 113;
                        break;
                    case 3001:
                        i = 114;
                        break;
                    case 3002:
                        i = 307;
                        break;
                    case TKErrorCode.BUNDLE_FILE_OVER_SIZE /* 3007 */:
                        i = 406;
                        break;
                    case 3008:
                        i = 407;
                        break;
                    case 5001:
                        i = 408;
                        break;
                    default:
                        i = 0;
                        break;
                }
                if (i != 0) {
                    OtherDLInfoManager.getInstance().a(string + "," + System.currentTimeMillis() + "," + i + ",-1;");
                }
            }
        } catch (Throwable th) {
        }
    }
}
