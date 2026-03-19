package com.bytedance.sdk.djx.core.business.base;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.sdk.djx.core.business.base.ILifecycleProxy;
import com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifecycleHolderBase.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J-\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/base/LifecycleHolderBase;", "DT", "Lcom/bytedance/sdk/djx/core/business/budrama/draw/HolderBase;", "Lcom/bytedance/sdk/djx/core/business/base/ILifecycleProxy;", "()V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry", "()Landroid/arch/lifecycle/LifecycleRegistry;", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "bindHolder", "", "isCache", "", "data", "position", "", "itemView", "Landroid/view/View;", "(ZLjava/lang/Object;ILandroid/view/View;)V", "destroy", "onHolderPause", "onHolderResume", "onHolderShow", "onHolderStop", "onRegisterLifecycle", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class LifecycleHolderBase<DT> extends HolderBase<DT> implements ILifecycleProxy {

    /* renamed from: lifecycleRegistry$delegate, reason: from kotlin metadata */
    private final Lazy lifecycleRegistry = LazyKt.lazy(new Function0<LifecycleRegistry>(this) { // from class: com.bytedance.sdk.djx.core.business.base.LifecycleHolderBase$lifecycleRegistry$2
        final /* synthetic */ LifecycleHolderBase<DT> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LifecycleRegistry m352invoke() {
            return this.this$0.onRegisterLifecycle();
        }
    });

    @Override // com.bytedance.sdk.djx.core.business.base.ILifecycleProxy, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return ILifecycleProxy.DefaultImpls.getLifecycle(this);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ILifecycleProxy
    public LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.lifecycleRegistry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LifecycleRegistry onRegisterLifecycle() {
        return new LifecycleRegistry(this);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    protected void bindHolder(boolean isCache, DT data, int position, View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderShow() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderResume() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderPause() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.draw.HolderBase
    public void onHolderStop() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder
    protected void destroy() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }
}
