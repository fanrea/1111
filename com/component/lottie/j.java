package com.component.lottie;

import android.os.Parcel;
import android.os.Parcelable;
import com.component.lottie.LottieAnimationView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j implements Parcelable.Creator<LottieAnimationView.SavedState> {
    j() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LottieAnimationView.SavedState createFromParcel(Parcel parcel) {
        return new LottieAnimationView.SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LottieAnimationView.SavedState[] newArray(int i) {
        return new LottieAnimationView.SavedState[i];
    }
}
