package com.baidu.mobads.container;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b implements Parcelable.Creator<XAdInstanceInfoExt> {
    b() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public XAdInstanceInfoExt createFromParcel(Parcel parcel) {
        return new XAdInstanceInfoExt(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public XAdInstanceInfoExt[] newArray(int i) {
        return new XAdInstanceInfoExt[i];
    }
}
