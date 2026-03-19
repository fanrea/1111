package com.kwad.components.offline.api.core.api;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface IEnvironment {
    void addOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener);

    String getAppId();

    String getAppVersion();

    String getBiz();

    Context getContext();

    String getDeviceId();

    String getKpf();

    String getKpn();

    double getLatitude(Context context);

    double getLongitude(Context context);

    String getOperator(Context context);

    String getOsVersion();

    String getProcessName(Context context);

    String getSdkVersion();

    int getStatusBarHeight(Context context);

    String getUserAgent();

    boolean isArm64(Context context);

    boolean isDebug();

    boolean isDevelopEnable();

    boolean isInMainProcess(Context context);

    boolean isTKCrashCollectEnable();

    String localIpAddress();

    void removeOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener);

    boolean requestAudioFocus(Context context, boolean z);
}
