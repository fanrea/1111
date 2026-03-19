package com.netease.htprotect.p008O;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface Oo0 extends IInterface {

    /* renamed from: com.netease.htprotect.〇O.Oo0$O8〇oO8〇88, reason: invalid class name */
    public static abstract class O8oO888 extends Binder implements Oo0 {

        /* renamed from: com.netease.htprotect.〇O.Oo0$O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
        static class C0665O8oO888 implements Oo0 {

            /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
            public static Oo0 f221O8oO888;

            /* renamed from: 〇Ooo, reason: contains not printable characters */
            private IBinder f222Ooo;

            C0665O8oO888(IBinder iBinder) {
                this.f222Ooo = iBinder;
            }

            @Override // com.netease.htprotect.p008O.Oo0
            /* renamed from: O8〇oO8〇88 */
            public final String mo645O8oO888() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.f222Ooo.transact(2, parcelObtain, parcelObtain2, 0) && O8oO888.m653O8() != null) {
                        return O8oO888.m653O8().mo645O8oO888();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.netease.htprotect.p008O.Oo0
            /* renamed from: O8〇oO8〇88 */
            public final String mo646O8oO888(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.f222Ooo.transact(1, parcelObtain, parcelObtain2, 0) && O8oO888.m653O8() != null) {
                        return O8oO888.m653O8().mo646O8oO888(str);
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
                return this.f222Ooo;
            }

            @Override // com.netease.htprotect.p008O.Oo0
            /* renamed from: 〇O8 */
            public final String mo647O8(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.f222Ooo.transact(4, parcelObtain, parcelObtain2, 0) && O8oO888.m653O8() != null) {
                        return O8oO888.m653O8().mo647O8(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.netease.htprotect.p008O.Oo0
            /* renamed from: 〇Ooo */
            public final String mo648Ooo(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.f222Ooo.transact(3, parcelObtain, parcelObtain2, 0) && O8oO888.m653O8() != null) {
                        return O8oO888.m653O8().mo648Ooo(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.netease.htprotect.p008O.Oo0
            /* renamed from: 〇Ooo */
            public final boolean mo649Ooo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.f222Ooo.transact(7, parcelObtain, parcelObtain2, 0) && O8oO888.m653O8() != null) {
                        return O8oO888.m653O8().mo649Ooo();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.netease.htprotect.p008O.Oo0
            /* renamed from: 〇o0〇o0 */
            public final String mo650o0o0(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.f222Ooo.transact(5, parcelObtain, parcelObtain2, 0) && O8oO888.m653O8() != null) {
                        return O8oO888.m653O8().mo650o0o0(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.netease.htprotect.p008O.Oo0
            /* renamed from: 〇oO */
            public final String mo651oO(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.f222Ooo.transact(6, parcelObtain, parcelObtain2, 0) && O8oO888.m653O8() != null) {
                        return O8oO888.m653O8().mo651oO(str);
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
        public static Oo0 m652O8oO888(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof Oo0)) ? new C0665O8oO888(iBinder) : (Oo0) iInterfaceQueryLocalInterface;
        }

        /* renamed from: 〇O8, reason: contains not printable characters */
        public static Oo0 m653O8() {
            return C0665O8oO888.f221O8oO888;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str;
            if (i == 1598968902) {
                parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    str = mo646O8oO888(parcel.readString());
                    break;
                case 2:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    str = mo645O8oO888();
                    break;
                case 3:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    str = mo648Ooo(parcel.readString());
                    break;
                case 4:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    str = mo647O8(parcel.readString());
                    break;
                case 5:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    str = mo650o0o0(parcel.readString());
                    break;
                case 6:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    str = mo651oO(parcel.readString());
                    break;
                case 7:
                    parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    boolean z = mo649Ooo();
                    parcel2.writeNoException();
                    parcel2.writeInt(z ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            parcel2.writeString(str);
            return true;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    String mo645O8oO888() throws RemoteException;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    String mo646O8oO888(String str) throws RemoteException;

    /* renamed from: 〇O8, reason: contains not printable characters */
    String mo647O8(String str) throws RemoteException;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    String mo648Ooo(String str) throws RemoteException;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    boolean mo649Ooo() throws RemoteException;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    String mo650o0o0(String str) throws RemoteException;

    /* renamed from: 〇oO, reason: contains not printable characters */
    String mo651oO(String str) throws RemoteException;
}
