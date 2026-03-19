package com.bytedance.sdk.djx.core.business.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.sdk.djx.core.business.base.ILifecycleProxy;
import com.bytedance.sdk.djx.utils.LG;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: ILifecycleEventProxy.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\b\u0010\u0005\u001a\u00020\u0003H\u0017J\b\u0010\u0006\u001a\u00020\u0003H\u0017J\b\u0010\u0007\u001a\u00020\u0003H\u0017J\b\u0010\b\u001a\u00020\u0003H\u0017¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/base/ILifecycleEventProxy;", "Lcom/bytedance/sdk/djx/core/business/base/ILifecycleProxy;", "onCreate", "", "onDestroy", "onPause", "onResume", "onStart", "onStop", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface ILifecycleEventProxy extends ILifecycleProxy {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate();

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy();

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume();

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart();

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop();

    /* compiled from: ILifecycleEventProxy.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Lifecycle getLifecycle(ILifecycleEventProxy iLifecycleEventProxy) {
            Intrinsics.checkNotNullParameter(iLifecycleEventProxy, "this");
            return ILifecycleProxy.DefaultImpls.getLifecycle(iLifecycleEventProxy);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public static void onCreate(ILifecycleEventProxy iLifecycleEventProxy) {
            Intrinsics.checkNotNullParameter(iLifecycleEventProxy, "this");
            iLifecycleEventProxy.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            LG.d("ILifecycleEventProxy", iLifecycleEventProxy.hashCode() + " handle: onCreate in " + ((Object) Reflection.getOrCreateKotlinClass(iLifecycleEventProxy.getClass()).getQualifiedName()));
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public static void onStart(ILifecycleEventProxy iLifecycleEventProxy) {
            Intrinsics.checkNotNullParameter(iLifecycleEventProxy, "this");
            iLifecycleEventProxy.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_START);
            LG.d("ILifecycleEventProxy", iLifecycleEventProxy.hashCode() + " handle: onStart in " + ((Object) Reflection.getOrCreateKotlinClass(iLifecycleEventProxy.getClass()).getQualifiedName()));
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public static void onResume(ILifecycleEventProxy iLifecycleEventProxy) {
            Intrinsics.checkNotNullParameter(iLifecycleEventProxy, "this");
            iLifecycleEventProxy.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            LG.d("ILifecycleEventProxy", iLifecycleEventProxy.hashCode() + " handle: onResume in " + ((Object) Reflection.getOrCreateKotlinClass(iLifecycleEventProxy.getClass()).getQualifiedName()));
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public static void onPause(ILifecycleEventProxy iLifecycleEventProxy) {
            Intrinsics.checkNotNullParameter(iLifecycleEventProxy, "this");
            iLifecycleEventProxy.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
            LG.d("ILifecycleEventProxy", iLifecycleEventProxy.hashCode() + " handle: onPause in " + ((Object) Reflection.getOrCreateKotlinClass(iLifecycleEventProxy.getClass()).getQualifiedName()));
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public static void onStop(ILifecycleEventProxy iLifecycleEventProxy) {
            Intrinsics.checkNotNullParameter(iLifecycleEventProxy, "this");
            iLifecycleEventProxy.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            LG.d("ILifecycleEventProxy", iLifecycleEventProxy.hashCode() + " handle: onStop in " + ((Object) Reflection.getOrCreateKotlinClass(iLifecycleEventProxy.getClass()).getQualifiedName()));
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public static void onDestroy(ILifecycleEventProxy iLifecycleEventProxy) {
            Intrinsics.checkNotNullParameter(iLifecycleEventProxy, "this");
            iLifecycleEventProxy.getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
            LG.d("ILifecycleEventProxy", iLifecycleEventProxy.hashCode() + " handle: onDestroy in " + ((Object) Reflection.getOrCreateKotlinClass(iLifecycleEventProxy.getClass()).getQualifiedName()));
        }
    }
}
