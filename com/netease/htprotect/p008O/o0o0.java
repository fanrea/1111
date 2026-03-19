package com.netease.htprotect.p008O;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.netease.htprotect.〇O.〇o0〇o0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface o0o0 extends IInterface {

    /* renamed from: com.netease.htprotect.〇O.〇o0〇o0$O8〇oO8〇88, reason: invalid class name */
    public static abstract class O8oO888 extends Binder implements o0o0 {

        /* renamed from: com.netease.htprotect.〇O.〇o0〇o0$O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
        static class C0671O8oO888 implements o0o0 {

            /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
            public static o0o0 f240O8oO888;

            /* renamed from: 〇Ooo, reason: contains not printable characters */
            private IBinder f241Ooo;

            C0671O8oO888(IBinder iBinder) {
                this.f241Ooo = iBinder;
            }

            @Override // com.netease.htprotect.p008O.o0o0
            /* renamed from: O8〇oO8〇88 */
            public final boolean mo700O8oO888() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.f241Ooo.transact(1, parcelObtain, parcelObtain2, 0) && O8oO888.m704o0o0() != null) {
                        return O8oO888.m704o0o0().mo700O8oO888();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f241Ooo;
            }

            @Override // com.netease.htprotect.p008O.o0o0
            /* renamed from: 〇O8 */
            public final String mo701O8() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.f241Ooo.transact(3, parcelObtain, parcelObtain2, 0) && O8oO888.m704o0o0() != null) {
                        return O8oO888.m704o0o0().mo701O8();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.netease.htprotect.p008O.o0o0
            /* renamed from: 〇Ooo */
            public final String mo702Ooo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.f241Ooo.transact(2, parcelObtain, parcelObtain2, 0) && O8oO888.m704o0o0() != null) {
                        return O8oO888.m704o0o0().mo702Ooo();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public static o0o0 m703O8oO888(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof o0o0)) ? new C0671O8oO888(iBinder) : (o0o0) iInterfaceQueryLocalInterface;
        }

        /* renamed from: 〇o0〇o0, reason: contains not printable characters */
        public static o0o0 m704o0o0() {
            return C0671O8oO888.f240O8oO888;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str;
            if (i == 1) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                boolean z = mo700O8oO888();
                parcel2.writeNoException();
                parcel2.writeInt(z ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                str = mo702Ooo();
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    return true;
                }
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                str = mo701O8();
            }
            parcel2.writeNoException();
            parcel2.writeString(str);
            return true;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    boolean mo700O8oO888() throws RemoteException;

    /* renamed from: 〇O8, reason: contains not printable characters */
    String mo701O8() throws RemoteException;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    String mo702Ooo() throws RemoteException;
}
