package com.baidu.mobads.container.preload;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class a implements Parcelable.Creator<XAdMaterialsInfo> {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public XAdMaterialsInfo createFromParcel(Parcel parcel) {
        return new XAdMaterialsInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public XAdMaterialsInfo[] newArray(int i) {
        return new XAdMaterialsInfo[i];
    }
}
