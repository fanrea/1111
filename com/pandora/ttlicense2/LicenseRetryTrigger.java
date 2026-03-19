package com.pandora.ttlicense2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.pandora.ttlicense2.utils.NetWorkUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LicenseRetryTrigger {
    private final LicenseRetryListener mListener;

    interface LicenseRetryListener {
        void onActivityResumed();

        void onNetworkConnectionChanged(NetworkInfo networkInfo);
    }

    LicenseRetryTrigger(LicenseRetryListener listener) {
        this.mListener = listener;
    }

    void init(Context context) {
        registerLifeCycleDetector(context);
        registerNetworkDetector(context);
    }

    private void registerNetworkDetector(Context context) {
        NetWorkUtils.setNetworkInfoListener(context, new NetWorkUtils.NetworkInfoListener() { // from class: com.pandora.ttlicense2.LicenseRetryTrigger.1
            @Override // com.pandora.ttlicense2.utils.NetWorkUtils.NetworkInfoListener
            public void onNetworkConnectionChanged(NetworkInfo networkInfo) {
                LicenseRetryTrigger.this.mListener.onNetworkConnectionChanged(networkInfo);
            }
        });
    }

    private void registerLifeCycleDetector(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.pandora.ttlicense2.LicenseRetryTrigger.2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    NetWorkUtils.setEnable(activity.getApplicationContext(), true);
                    LicenseRetryTrigger.this.mListener.onActivityResumed();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    NetWorkUtils.setEnable(activity.getApplicationContext(), false);
                }
            });
        }
    }
}
