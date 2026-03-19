package com.bytedance.sdk.djx.core.business.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.sdk.djx.core.business.base.BaseViewModel;
import com.bytedance.sdk.djx.params.DJXWidgetParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseMVVMLayout.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u00052\u00020\u0006B%\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/base/BaseMVVMLayout;", "VM", "Lcom/bytedance/sdk/djx/core/business/base/BaseViewModel;", "P", "Lcom/bytedance/sdk/djx/params/DJXWidgetParam;", "Lcom/bytedance/sdk/djx/core/business/base/BaseLifecycleLayout;", "Lcom/bytedance/sdk/djx/core/business/base/IViewModelProxy;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ownedViewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getOwnedViewModelStore", "()Landroid/arch/lifecycle/ViewModelStore;", "setOwnedViewModelStore", "(Landroid/arch/lifecycle/ViewModelStore;)V", "viewModel", "getViewModel", "()Lcom/bytedance/sdk/djx/core/business/base/BaseViewModel;", "getViewModelStore", "onDestroy", "", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class BaseMVVMLayout<VM extends BaseViewModel, P extends DJXWidgetParam> extends BaseLifecycleLayout<P> implements IViewModelProxy {
    public Map<Integer, View> _$_findViewCache;
    public ViewModelStore ownedViewModelStore;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseMVVMLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseMVVMLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout
    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        if (viewFindViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public abstract VM getViewModel();

    public /* synthetic */ BaseMVVMLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMVVMLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.IViewModelProxy
    public ViewModelStore getOwnedViewModelStore() {
        ViewModelStore viewModelStore = this.ownedViewModelStore;
        if (viewModelStore != null) {
            return viewModelStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ownedViewModelStore");
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.IViewModelProxy
    public void setOwnedViewModelStore(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "<set-?>");
        this.ownedViewModelStore = viewModelStore;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.IViewModelProxy, androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getContext() instanceof ViewModelStoreOwner) {
            Object context = getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.arch.lifecycle.ViewModelStoreOwner");
            }
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) context).getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "context as ViewModelStoreOwner).viewModelStore");
            return viewModelStore;
        }
        if (this.ownedViewModelStore == null) {
            setOwnedViewModelStore(new ViewModelStore());
        }
        return getOwnedViewModelStore();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout, com.bytedance.sdk.djx.core.business.base.ILifecycleEventProxy
    public void onDestroy() {
        super.onDestroy();
        if (this.ownedViewModelStore == null) {
            getOwnedViewModelStore().clear();
        }
    }
}
