package com.kwad.sdk.init;

import aegon.chrome.base.Log;
import android.app.Application;
import android.content.Context;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHttpRequestListenerDelegate;
import com.kwad.sdk.live.audience.KSLiveInitModule;
import com.kwad.sdk.live.audience.KSLiveLog;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveInitHelper {
    public static void initLiveSDK(Context context, String str, AdLiveHttpRequestListenerDelegate adLiveHttpRequestListenerDelegate) {
        KSLiveInitModule.getInstance().bindApplication((Application) context).setKSLiveHttpConfig(new KSLiveRequestConfigImpl(context, str)).setLongConnectionConfig(new KSLiveLongConnectionConfigImpl(OfflineHostProvider.getApi().env().getDeviceId(), context, str)).setLiveHttpDelegate(new KSHttpDelegate()).setLog(new KSLiveLog() { // from class: com.kwad.sdk.init.LiveInitHelper.1
            @Override // com.kwad.sdk.live.audience.KSLiveLog
            public void i(String str2, String str3) {
                Log.e(str2 + "KSLiveLog", str3, new Object[0]);
            }

            @Override // com.kwad.sdk.live.audience.KSLiveLog
            public void e(String str2, String str3, Throwable th) {
                Log.e(str2 + "KSLiveLog", str3, new Object[0]);
            }
        }).init();
        LiveStreamLogger.inject(new LiveStreamLogger.ILogClient() { // from class: com.kwad.sdk.init.LiveInitHelper.2
            @Override // com.yxcorp.livestream.longconnection.LiveStreamLogger.ILogClient
            public boolean isDebug() {
                return false;
            }

            @Override // com.yxcorp.livestream.longconnection.LiveStreamLogger.ILogClient
            public void log(String str2, String str3, Object... objArr) {
                Log.d(str2 + "KSLiveLog", str3, objArr);
            }

            @Override // com.yxcorp.livestream.longconnection.LiveStreamLogger.ILogClient
            public void debugLog(String str2, String str3, Object... objArr) {
                Log.d(str2 + "KSLiveLogDebug", str3, objArr);
            }
        });
    }
}
