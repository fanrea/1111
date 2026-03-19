package com.netease.htprotect.p008O;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alipay.sdk.m.q0.a;

/* renamed from: com.netease.htprotect.〇O.〇O8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface O8 extends IInterface {

    /* renamed from: com.netease.htprotect.〇O.〇O8$O8〇oO8〇88, reason: invalid class name */
    public static abstract class O8oO888 extends Binder implements O8 {

        /* renamed from: com.netease.htprotect.〇O.〇O8$O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
        static class C0669O8oO888 implements O8 {

            /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
            public static O8 f233O8oO888;

            /* renamed from: 〇Ooo, reason: contains not printable characters */
            private IBinder f234Ooo;

            C0669O8oO888(IBinder iBinder) {
                this.f234Ooo = iBinder;
            }

            @Override // com.netease.htprotect.p008O.O8
            /* renamed from: O8〇oO8〇88 */
            public final String mo687O8oO888() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0056a.a);
                    if (!this.f234Ooo.transact(1, parcelObtain, parcelObtain2, 0) && O8oO888.m689Ooo() != null) {
                        return O8oO888.m689Ooo().mo687O8oO888();
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
                return this.f234Ooo;
            }
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public static O8 m688O8oO888(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0056a.a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof O8)) ? new C0669O8oO888(iBinder) : (O8) iInterfaceQueryLocalInterface;
        }

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        public static O8 m689Ooo() {
            return C0669O8oO888.f233O8oO888;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(a.AbstractBinderC0056a.a);
                return true;
            }
            parcel.enforceInterface(a.AbstractBinderC0056a.a);
            String str = mo687O8oO888();
            parcel2.writeNoException();
            parcel2.writeString(str);
            return true;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    String mo687O8oO888() throws RemoteException;
}
