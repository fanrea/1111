package com.baidu.mobads.upgrade.remote.gray;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b implements Parcelable.Creator<DynamicUpgradeInfo> {
    b() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DynamicUpgradeInfo createFromParcel(Parcel parcel) {
        return new DynamicUpgradeInfo(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DynamicUpgradeInfo[] newArray(int i) {
        return new DynamicUpgradeInfo[i];
    }
}
