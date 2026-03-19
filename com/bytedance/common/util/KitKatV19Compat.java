package com.bytedance.common.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class KitKatV19Compat {
    private static BaseImpl mImpl;

    private static class BaseImpl {
        public void setWebContentsDebuggingEnabled(boolean z) {
        }

        private BaseImpl() {
        }

        public void setAlarmTime(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
            if (alarmManager != null) {
                try {
                    alarmManager.set(i, j, pendingIntent);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static class KitKatImpl extends BaseImpl {
        private KitKatImpl() {
            super();
        }

        @Override // com.bytedance.common.util.KitKatV19Compat.BaseImpl
        public void setWebContentsDebuggingEnabled(boolean z) {
            try {
                WebView.setWebContentsDebuggingEnabled(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.bytedance.common.util.KitKatV19Compat.BaseImpl
        public void setAlarmTime(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
            if (alarmManager != null) {
                try {
                    alarmManager.setExact(i, j, pendingIntent);
                } catch (Throwable th) {
                    if (!(th instanceof NoSuchMethodError)) {
                        th.printStackTrace();
                    } else if (alarmManager != null) {
                        try {
                            alarmManager.set(i, j, pendingIntent);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            mImpl = new KitKatImpl();
        } else {
            mImpl = new BaseImpl();
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        mImpl.setWebContentsDebuggingEnabled(z);
    }

    public static void setAlarmTime(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        mImpl.setAlarmTime(alarmManager, i, j, pendingIntent);
    }
}
