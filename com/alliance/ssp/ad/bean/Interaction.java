package com.alliance.ssp.ad.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alliance.ssp.ad.o0.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class Interaction implements Parcelable {
    public static final Parcelable.Creator<Interaction> CREATOR = new a();
    private static final String TAG = "Interaction: ";
    private Click auto;
    public int autoCloseCountdownTime;
    private Click click;
    public int clickArea;
    private Shake shake;
    private Swipe swipe;

    public class a implements Parcelable.Creator<Interaction> {
        @Override // android.os.Parcelable.Creator
        public Interaction createFromParcel(Parcel parcel) {
            return new Interaction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Interaction[] newArray(int i) {
            return new Interaction[i];
        }
    }

    public Interaction(Parcel parcel) {
        this.clickArea = -1;
        try {
            this.clickArea = parcel.readInt();
            this.shake = (Shake) parcel.readParcelable(Shake.class.getClassLoader());
            this.swipe = (Swipe) parcel.readParcelable(Swipe.class.getClassLoader());
            this.click = (Click) parcel.readParcelable(Click.class.getClassLoader());
            this.auto = (Click) parcel.readParcelable(Click.class.getClassLoader());
            this.autoCloseCountdownTime = parcel.readInt();
        } catch (Exception unused) {
            int i = l.a;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Click getAuto() {
        return this.auto;
    }

    public Integer getAutoCloseCountdownTime() {
        return Integer.valueOf(this.autoCloseCountdownTime);
    }

    public Click getClick() {
        return this.click;
    }

    public int getClickArea() {
        return this.clickArea;
    }

    public Shake getShake() {
        return this.shake;
    }

    public Swipe getSwipe() {
        return this.swipe;
    }

    public void setAuto(Click click) {
        this.auto = click;
    }

    public void setAutoCloseCountdownTime(Integer num) {
        this.autoCloseCountdownTime = num.intValue();
    }

    public void setClick(Click click) {
        this.click = click;
    }

    public void setClickArea(int i) {
        this.clickArea = i;
    }

    public void setShake(Shake shake) {
        this.shake = shake;
    }

    public void setSwipe(Swipe swipe) {
        this.swipe = swipe;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.clickArea);
            parcel.writeParcelable(this.shake, i);
            parcel.writeParcelable(this.swipe, i);
            parcel.writeParcelable(this.click, i);
            parcel.writeParcelable(this.auto, i);
            parcel.writeInt(this.autoCloseCountdownTime);
        } catch (Exception unused) {
            int i2 = l.a;
        }
    }
}
