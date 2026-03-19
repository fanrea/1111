package com.nativekv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ParcelableNativeKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableNativeKV> CREATOR = new Parcelable.Creator<ParcelableNativeKV>() { // from class: com.nativekv.ParcelableNativeKV.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableNativeKV createFromParcel(Parcel source) {
            String string = source.readString();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(source);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(source);
            String string2 = source.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                return null;
            }
            return new ParcelableNativeKV(string, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), string2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableNativeKV[] newArray(int size) {
            return new ParcelableNativeKV[size];
        }
    };
    private int ashmemFD;
    private int ashmemMetaFD;
    private String cryptKey;
    private final String mmapID;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    public ParcelableNativeKV(NativeKV nativeKV) {
        this.ashmemFD = -1;
        this.ashmemMetaFD = -1;
        this.cryptKey = null;
        this.mmapID = nativeKV.mmapID();
        this.ashmemFD = nativeKV.ashmemFD();
        this.ashmemMetaFD = nativeKV.ashmemMetaFD();
        this.cryptKey = nativeKV.cryptKey();
    }

    private ParcelableNativeKV(String id, int fd, int metaFD, String key) {
        this.mmapID = id;
        this.ashmemFD = fd;
        this.ashmemMetaFD = metaFD;
        this.cryptKey = key;
    }

    public NativeKV toNativeKV() {
        int i;
        int i2 = this.ashmemFD;
        if (i2 < 0 || (i = this.ashmemMetaFD) < 0) {
            return null;
        }
        return NativeKV.nativeKVWithAshmemFD(this.mmapID, i2, i, this.cryptKey);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) throws IOException {
        try {
            dest.writeString(this.mmapID);
            ParcelFileDescriptor parcelFileDescriptorFromFd = ParcelFileDescriptor.fromFd(this.ashmemFD);
            ParcelFileDescriptor parcelFileDescriptorFromFd2 = ParcelFileDescriptor.fromFd(this.ashmemMetaFD);
            int i = flags | 1;
            parcelFileDescriptorFromFd.writeToParcel(dest, i);
            parcelFileDescriptorFromFd2.writeToParcel(dest, i);
            String str = this.cryptKey;
            if (str != null) {
                dest.writeString(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
