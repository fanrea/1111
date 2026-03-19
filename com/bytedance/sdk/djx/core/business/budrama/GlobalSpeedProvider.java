package com.bytedance.sdk.djx.core.business.budrama;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.alipay.sdk.m.p0.b;
import com.bytedance.sdk.djx.core.business.base.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalSpeedProvider.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/budrama/GlobalSpeedProvider;", "Lcom/bytedance/sdk/djx/core/business/base/BaseViewModel;", "()V", "mGlobalSpeed", "Landroidx/lifecycle/MutableLiveData;", "", "getMGlobalSpeed", "()Landroid/arch/lifecycle/MutableLiveData;", "setMGlobalSpeed", "(Landroid/arch/lifecycle/MutableLiveData;)V", "getMyVariable", "Landroidx/lifecycle/LiveData;", "setGlobalSpeed", "", b.d, "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class GlobalSpeedProvider extends BaseViewModel {
    private MutableLiveData<Float> mGlobalSpeed = new MutableLiveData<>();

    public final MutableLiveData<Float> getMGlobalSpeed() {
        return this.mGlobalSpeed;
    }

    public final void setMGlobalSpeed(MutableLiveData<Float> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mGlobalSpeed = mutableLiveData;
    }

    public final void setGlobalSpeed(float value) {
        this.mGlobalSpeed.setValue(Float.valueOf(value));
    }

    public final LiveData<Float> getMyVariable() {
        return this.mGlobalSpeed;
    }
}
