package com.luck.picture.lib.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.utils.SdkVersionUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ForegroundService extends Service {
    private static final String CHANNEL_NAME = "com.luck.picture.lib";
    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "com.luck.picture.lib." + ForegroundService.class.getName();
    private static boolean isForegroundServiceIng = false;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        startForeground(1, createForegroundNotification());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        isForegroundServiceIng = true;
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        isForegroundServiceIng = false;
        stopForeground(true);
        super.onDestroy();
    }

    private Notification createForegroundNotification() {
        int i = SdkVersionUtils.isMaxN() ? 4 : 0;
        if (SdkVersionUtils.isO()) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "com.luck.picture.lib", i);
            notificationChannel.setLightColor(-16776961);
            notificationChannel.canBypassDnd();
            notificationChannel.setBypassDnd(true);
            notificationChannel.setLockscreenVisibility(0);
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        }
        return new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.drawable.ps_ic_trans_1px).setContentTitle(getAppName()).setContentText(getString(SelectorProviders.getInstance().getSelectorConfig().chooseMode == SelectMimeType.ofAudio() ? R.string.ps_use_sound : R.string.ps_use_camera)).setOngoing(true).build();
    }

    private String getAppName() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.loadLabel(getPackageManager()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void startForegroundService(Context context, boolean z) {
        try {
            if (!isForegroundServiceIng && z) {
                Intent intent = new Intent(context, (Class<?>) ForegroundService.class);
                if (SdkVersionUtils.isO()) {
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopService(Context context) {
        try {
            if (isForegroundServiceIng) {
                context.stopService(new Intent(context, (Class<?>) ForegroundService.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
