package com.netease.htprotect.p008O;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.netease.htprotect.〇O.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface Ooo extends IInterface {

    /* renamed from: com.netease.htprotect.〇O.〇Ooo$O8〇oO8〇88, reason: invalid class name */
    public static abstract class O8oO888 extends Binder implements Ooo {

        /* renamed from: com.netease.htprotect.〇O.〇Ooo$O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
        static class C0670O8oO888 implements Ooo {

            /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
            public static Ooo f238O8oO888;

            /* renamed from: 〇Ooo, reason: contains not printable characters */
            private IBinder f239Ooo;

            C0670O8oO888(IBinder iBinder) {
                this.f239Ooo = iBinder;
            }

            @Override // com.netease.htprotect.p008O.Ooo
            /* renamed from: O8〇oO8〇88 */
            public final String mo691O8oO888() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.f239Ooo.transact(2, parcelObtain, parcelObtain2, 0) && O8oO888.m697o0o0() != null) {
                        return O8oO888.m697o0o0().mo691O8oO888();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.netease.htprotect.p008O.Ooo
            /* renamed from: O8〇oO8〇88 */
            public final String mo692O8oO888(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    parcelObtain.writeString(str);
                    if (!this.f239Ooo.transact(1, parcelObtain, parcelObtain2, 0) && O8oO888.m697o0o0() != null) {
                        return O8oO888.m697o0o0().mo692O8oO888(str);
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
                return this.f239Ooo;
            }

            @Override // com.netease.htprotect.p008O.Ooo
            /* renamed from: 〇O8 */
            public final boolean mo693O8() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.f239Ooo.transact(5, parcelObtain, parcelObtain2, 0) && O8oO888.m697o0o0() != null) {
                        return O8oO888.m697o0o0().mo693O8();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.netease.htprotect.p008O.Ooo
            /* renamed from: 〇Ooo */
            public final String mo694Ooo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.f239Ooo.transact(4, parcelObtain, parcelObtain2, 0) && O8oO888.m697o0o0() != null) {
                        return O8oO888.m697o0o0().mo694Ooo();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.netease.htprotect.p008O.Ooo
            /* renamed from: 〇Ooo */
            public final String mo695Ooo(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    parcelObtain.writeString(str);
                    if (!this.f239Ooo.transact(3, parcelObtain, parcelObtain2, 0) && O8oO888.m697o0o0() != null) {
                        return O8oO888.m697o0o0().mo695Ooo(str);
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
        public static Ooo m696O8oO888(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof Ooo)) ? new C0670O8oO888(iBinder) : (Ooo) iInterfaceQueryLocalInterface;
        }

        /* renamed from: 〇o0〇o0, reason: contains not printable characters */
        public static Ooo m697o0o0() {
            return C0670O8oO888.f238O8oO888;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str;
            if (i == 1) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                str = mo692O8oO888(parcel.readString());
            } else if (i == 2) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                str = mo691O8oO888();
            } else if (i == 3) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                str = mo695Ooo(parcel.readString());
            } else {
                if (i != 4) {
                    if (i != 5) {
                        if (i != 1598968902) {
                            return super.onTransact(i, parcel, parcel2, i2);
                        }
                        parcel2.writeString("com.android.creator.IdsSupplier");
                        return true;
                    }
                    parcel.enforceInterface("com.android.creator.IdsSupplier");
                    boolean z = mo693O8();
                    parcel2.writeNoException();
                    parcel2.writeInt(z ? 1 : 0);
                    return true;
                }
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                str = mo694Ooo();
            }
            parcel2.writeNoException();
            parcel2.writeString(str);
            return true;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    String mo691O8oO888() throws RemoteException;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    String mo692O8oO888(String str) throws RemoteException;

    /* renamed from: 〇O8, reason: contains not printable characters */
    boolean mo693O8() throws RemoteException;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    String mo694Ooo() throws RemoteException;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    String mo695Ooo(String str) throws RemoteException;
}
