package com.netease.htprotect.p008O;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alipay.sdk.m.c.b;

/* renamed from: com.netease.htprotect.〇O.O〇, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface O extends IInterface {

    /* renamed from: com.netease.htprotect.〇O.O〇$O8〇oO8〇88, reason: invalid class name */
    public static abstract class O8oO888 extends Binder implements O {

        /* renamed from: com.netease.htprotect.〇O.O〇$O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
        static class C0666O8oO888 implements O {

            /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
            public static O f223O8oO888;

            /* renamed from: 〇Ooo, reason: contains not printable characters */
            private IBinder f224Ooo;

            C0666O8oO888(IBinder iBinder) {
                this.f224Ooo = iBinder;
            }

            @Override // com.netease.htprotect.p008O.O
            /* renamed from: O8〇oO8〇88 */
            public final String mo655O8oO888() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (!this.f224Ooo.transact(1, parcelObtain, parcelObtain2, 0) && O8oO888.m658O8() != null) {
                        return O8oO888.m658O8().mo655O8oO888();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f224Ooo;
            }

            @Override // com.netease.htprotect.p008O.O
            /* renamed from: 〇Ooo */
            public final boolean mo656Ooo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (!this.f224Ooo.transact(2, parcelObtain, parcelObtain2, 0) && O8oO888.m658O8() != null) {
                        return O8oO888.m658O8().mo656Ooo();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public static O m657O8oO888(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(b.a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof O)) ? new C0666O8oO888(iBinder) : (O) iInterfaceQueryLocalInterface;
        }

        /* renamed from: 〇O8, reason: contains not printable characters */
        public static O m658O8() {
            return C0666O8oO888.f223O8oO888;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(b.a);
                String str = mo655O8oO888();
                parcel2.writeNoException();
                parcel2.writeString(str);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(b.a);
                return true;
            }
            parcel.enforceInterface(b.a);
            boolean z = mo656Ooo();
            parcel2.writeNoException();
            parcel2.writeInt(z ? 1 : 0);
            return true;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    String mo655O8oO888() throws RemoteException;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    boolean mo656Ooo() throws RemoteException;
}
