package com.kwai.middleware.azeroth;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.os.SystemClock;
import com.kwai.middleware.azeroth.configs.SdkConfigManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AzerothLifeCallbacks implements GenericLifecycleObserver {
    private long mEnterApplicationTime = -1;
    private long mLeaveApplicationTime = -1;

    /* renamed from: com.kwai.middleware.azeroth.AzerothLifeCallbacks$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$arch$lifecycle$Lifecycle$Event = new int[Lifecycle.Event.values().length];

        static {
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$arch$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = AnonymousClass1.$SwitchMap$android$arch$lifecycle$Lifecycle$Event[event.ordinal()];
        if (i == 1) {
            onForeground();
        } else {
            if (i != 2) {
                return;
            }
            onBackground();
        }
    }

    private void onForeground() {
        this.mEnterApplicationTime = SystemClock.elapsedRealtime();
        long j = this.mLeaveApplicationTime;
        SdkConfigManager.get().onForeground(j >= 0 ? this.mEnterApplicationTime - j : 0L);
    }

    private void onBackground() {
        this.mLeaveApplicationTime = SystemClock.elapsedRealtime();
    }
}
