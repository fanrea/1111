package com.bytedance.sdk.djx.core.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.sdk.djx.utils.PluginUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class FragmentClear implements Application.ActivityLifecycleCallbacks {
    Fragment fragment;
    android.app.Fragment fragmentV11;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public FragmentClear(Fragment fragment) {
        this.fragment = fragment;
    }

    public FragmentClear(android.app.Fragment fragment) {
        this.fragmentV11 = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
        Fragment fragment = this.fragment;
        try {
            if (fragment != null) {
                if (PluginUtils.check(fragment, activity)) {
                    Object obj = bundle.get("androidx.lifecycle.BundlableSavedStateRegistry.key");
                    if (obj != null) {
                        ((Bundle) obj).remove("android:support:fragments");
                    }
                    bundle.remove("android:support:fragments");
                    return;
                }
                return;
            }
            android.app.Fragment fragment2 = this.fragmentV11;
            if (fragment2 == null || !PluginUtils.check(fragment2, activity)) {
                return;
            }
            Object obj2 = bundle.get("androidx.lifecycle.BundlableSavedStateRegistry.key");
            if (obj2 != null) {
                ((Bundle) obj2).remove("android:support:fragments");
            }
            bundle.remove("android:support:fragments");
        } catch (Exception unused) {
        }
    }
}
