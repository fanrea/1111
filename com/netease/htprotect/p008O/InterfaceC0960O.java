package com.netease.htprotect.p008O;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.netease.htprotect.〇O.〇O, reason: invalid class name and case insensitive filesystem */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface InterfaceC0960O extends IInterface {

    /* renamed from: com.netease.htprotect.〇O.〇O$O8〇oO8〇88, reason: invalid class name */
    public static abstract class O8oO888 extends Binder implements InterfaceC0960O {

        /* renamed from: com.netease.htprotect.〇O.〇O$O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
        static class C0668O8oO888 implements InterfaceC0960O {

            /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
            public static InterfaceC0960O f231O8oO888;

            /* renamed from: 〇Ooo, reason: contains not printable characters */
            private IBinder f232Ooo;

            C0668O8oO888(IBinder iBinder) {
                this.f232Ooo = iBinder;
            }

            @Override // com.netease.htprotect.p008O.InterfaceC0960O
            /* renamed from: O8〇oO8〇88 */
            public final String mo684O8oO888(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.f232Ooo.transact(1, parcelObtain, parcelObtain2, 0) && O8oO888.m685O8oO888() != null) {
                        return O8oO888.m685O8oO888().mo684O8oO888(str, str2, str3);
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
                return this.f232Ooo;
            }
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public static InterfaceC0960O m685O8oO888() {
            return C0668O8oO888.f231O8oO888;
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public static InterfaceC0960O m686O8oO888(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0960O)) ? new C0668O8oO888(iBinder) : (InterfaceC0960O) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.heytap.openid.IOpenID");
                return true;
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String str = mo684O8oO888(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(str);
            return true;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    String mo684O8oO888(String str, String str2, String str3) throws RemoteException;
}
