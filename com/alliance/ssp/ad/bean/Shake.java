package com.alliance.ssp.ad.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alliance.ssp.ad.o0.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class Shake implements Parcelable {
    public static final Parcelable.Creator<Shake> CREATOR = new a();
    private static final String TAG = "Shake: ";
    public double acceleration;
    public double operationTime;
    private int resetSensitivity;
    public double rotationAngle;
    private String shakeTemplate;

    public class a implements Parcelable.Creator<Shake> {
        @Override // android.os.Parcelable.Creator
        public Shake createFromParcel(Parcel parcel) {
            return new Shake(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Shake[] newArray(int i) {
            return new Shake[i];
        }
    }

    public Shake(Parcel parcel) {
        this.shakeTemplate = "";
        this.resetSensitivity = 0;
        try {
            this.acceleration = parcel.readDouble();
            this.operationTime = parcel.readDouble();
            this.rotationAngle = parcel.readDouble();
            this.shakeTemplate = parcel.readString();
            this.resetSensitivity = parcel.readInt();
        } catch (Exception unused) {
            int i = l.a;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAcceleration() {
        return this.acceleration;
    }

    public double getOperationTime() {
        return this.operationTime;
    }

    public int getResetSensitivity() {
        return this.resetSensitivity;
    }

    public double getRotationAngle() {
        return this.rotationAngle;
    }

    public String getShakeTemplate() {
        return this.shakeTemplate;
    }

    public void setAcceleration(double d) {
        this.acceleration = d;
    }

    public void setOperationTime(double d) {
        this.operationTime = d;
    }

    public void setResetSensitivity(int i) {
        this.resetSensitivity = i;
    }

    public void setRotationAngle(double d) {
        this.rotationAngle = d;
    }

    public void setShakeTemplate(String str) {
        this.shakeTemplate = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.acceleration);
        parcel.writeDouble(this.operationTime);
        parcel.writeDouble(this.rotationAngle);
        parcel.writeString(this.shakeTemplate);
        parcel.writeInt(this.resetSensitivity);
    }
}
