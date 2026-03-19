package com.android.gdt.qone.m;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.alipay.sdk.m.k0.a;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a implements c {
    public final IBinder a;

    public a(IBinder iBinder) {
        this.a = iBinder;
    }

    public final String a(String str) {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken(a.AbstractBinderC0051a.a);
                parcelObtain.writeString(str);
                this.a.transact(3, parcelObtain, parcelObtain2, 0);
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
        return this.a;
    }

    public final String a() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken(a.AbstractBinderC0051a.a);
                this.a.transact(1, parcelObtain, parcelObtain2, 0);
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
