package com.bytedance.sdk.djx.core.business.base;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IViewModelProxy.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/base/IViewModelProxy;", "Landroidx/lifecycle/ViewModelStoreOwner;", "ownedViewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getOwnedViewModelStore", "()Landroid/arch/lifecycle/ViewModelStore;", "setOwnedViewModelStore", "(Landroid/arch/lifecycle/ViewModelStore;)V", "getViewModelStore", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IViewModelProxy extends ViewModelStoreOwner {
    ViewModelStore getOwnedViewModelStore();

    @Override // androidx.lifecycle.ViewModelStoreOwner
    ViewModelStore getViewModelStore();

    void setOwnedViewModelStore(ViewModelStore viewModelStore);

    /* compiled from: IViewModelProxy.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static ViewModelStore getViewModelStore(IViewModelProxy iViewModelProxy) {
            Intrinsics.checkNotNullParameter(iViewModelProxy, "this");
            return iViewModelProxy.getOwnedViewModelStore();
        }
    }
}
