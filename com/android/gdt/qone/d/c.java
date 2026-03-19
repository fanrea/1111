package com.android.gdt.qone.d;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c implements e {
    public final IBinder a;

    public c(IBinder iBinder) {
        this.a = iBinder;
    }

    public final String a(String str) {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                parcelObtain.writeString(str);
                this.a.transact(4, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (RemoteException e) {
                e.printStackTrace();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                string = null;
            }
            return string;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    public final String b(String str) {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                parcelObtain.writeString(str);
                this.a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (RemoteException e) {
                e.printStackTrace();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                string = null;
            }
            return string;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
