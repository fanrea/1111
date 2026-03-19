package com.just.agentweb.filechooser;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FileParcel implements Parcelable {
    public static final Parcelable.Creator<FileParcel> CREATOR = new Parcelable.Creator<FileParcel>() { // from class: com.just.agentweb.filechooser.FileParcel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileParcel createFromParcel(Parcel parcel) {
            return new FileParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileParcel[] newArray(int i) {
            return new FileParcel[i];
        }
    };
    private String mContentPath;
    private String mFileBase64;
    private int mId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected FileParcel(Parcel parcel) {
        this.mId = parcel.readInt();
        this.mContentPath = parcel.readString();
        this.mFileBase64 = parcel.readString();
    }

    public FileParcel(int i, String str, String str2) {
        this.mId = i;
        this.mContentPath = str;
        this.mFileBase64 = str2;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public String getContentPath() {
        return this.mContentPath;
    }

    public void setContentPath(String str) {
        this.mContentPath = str;
    }

    public String getFileBase64() {
        return this.mFileBase64;
    }

    public void setFileBase64(String str) {
        this.mFileBase64 = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
        parcel.writeString(this.mContentPath);
        parcel.writeString(this.mFileBase64);
    }

    public String toString() {
        return "FileParcel{mId=" + this.mId + ", mContentPath='" + this.mContentPath + "', mFileBase64='" + this.mFileBase64 + "'}";
    }
}
