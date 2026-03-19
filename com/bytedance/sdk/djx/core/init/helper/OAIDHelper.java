package com.bytedance.sdk.djx.core.init.helper;

import android.text.TextUtils;
import com.bytedance.applog.IOaidObserver;
import com.bytedance.sdk.djx.utils.AppLogManager;
import com.bytedance.sdk.djx.utils.DeviceUtils;
import com.bytedance.sdk.djx.utils.thread.TTExecutor;
import com.bytedance.sdk.djx.utils.thread.TTRunnable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OAIDHelper {
    private static final String TAG = "OAIDHelper";

    public static void init() {
        try {
            AppLogManager.getAppLogInstance().setOaidObserver(new IOaidObserver() { // from class: com.bytedance.sdk.djx.core.init.helper.OAIDHelper.1
                @Override // com.bytedance.applog.IOaidObserver
                public void onOaidLoaded(IOaidObserver.Oaid oaid) {
                    try {
                        if (TextUtils.isEmpty(oaid.id)) {
                            return;
                        }
                        OAIDHelper.update(oaid.id);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void update(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TTExecutor.get().executeDefaultTask(new Task(str));
    }

    private static class Task extends TTRunnable {
        String oaid;

        Task(String str) {
            this.oaid = str;
        }

        public void run() {
            if (TextUtils.isEmpty(this.oaid)) {
                return;
            }
            DeviceUtils.setOaid(this.oaid);
        }
    }
}
