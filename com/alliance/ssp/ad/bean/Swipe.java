package com.alliance.ssp.ad.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alliance.ssp.ad.o0.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class Swipe implements Parcelable {
    public static final Parcelable.Creator<Swipe> CREATOR = new a();
    private static final String TAG = "Swipe: ";
    private String swipeTemplate;

    public class a implements Parcelable.Creator<Swipe> {
        @Override // android.os.Parcelable.Creator
        public Swipe createFromParcel(Parcel parcel) {
            return new Swipe(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Swipe[] newArray(int i) {
            return new Swipe[i];
        }
    }

    public Swipe(Parcel parcel) {
        this.swipeTemplate = "";
        try {
            this.swipeTemplate = parcel.readString();
        } catch (Exception unused) {
            int i = l.a;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSwipeTemplate() {
        return this.swipeTemplate;
    }

    public void setSwipeTemplate(String str) {
        this.swipeTemplate = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.swipeTemplate);
    }
}
