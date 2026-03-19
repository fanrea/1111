package com.android.gdt.qone.e;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a extends Binder implements b {
    public a() {
        attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            parcel.readInt();
            parcel.readLong();
            parcel.readInt();
            parcel.readFloat();
            parcel.readDouble();
            parcel.readString();
            if (parcel2 != null) {
                parcel2.writeNoException();
            }
            return true;
        }
        if (i == 2) {
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            parcel.readInt();
            a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            if (parcel2 != null) {
                parcel2.writeNoException();
            }
            return true;
        }
        if (i == 1598968902) {
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            return true;
        }
        try {
            return super.onTransact(i, parcel, parcel2, i2);
        } catch (RemoteException e) {
            com.android.gdt.qone.af.b.a("honor onTransact exception." + e.toString());
            return false;
        }
    }
}
