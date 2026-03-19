package com.netease.htprotect.p008O;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alipay.sdk.m.k0.a;

/* renamed from: com.netease.htprotect.〇O.〇80o, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface C80o extends IInterface {

    /* renamed from: com.netease.htprotect.〇O.〇80o$O8〇oO8〇88, reason: invalid class name */
    public static abstract class O8oO888 extends Binder implements C80o {

        /* renamed from: com.netease.htprotect.〇O.〇80o$O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
        static class C0667O8oO888 implements C80o {

            /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
            public static C80o f229O8oO888;

            /* renamed from: 〇Ooo, reason: contains not printable characters */
            private IBinder f230Ooo;

            C0667O8oO888(IBinder iBinder) {
                this.f230Ooo = iBinder;
            }

            @Override // com.netease.htprotect.p008O.C80o
            /* renamed from: O8〇oO8〇88 */
            public final String mo680O8oO888() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0051a.a);
                    if (!this.f230Ooo.transact(1, parcelObtain, parcelObtain2, 0) && O8oO888.m682Ooo() != null) {
                        return O8oO888.m682Ooo().mo680O8oO888();
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
                return this.f230Ooo;
            }
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public static C80o m681O8oO888(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0051a.a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof C80o)) ? new C0667O8oO888(iBinder) : (C80o) iInterfaceQueryLocalInterface;
        }

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        public static C80o m682Ooo() {
            return C0667O8oO888.f229O8oO888;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(a.AbstractBinderC0051a.a);
                return true;
            }
            parcel.enforceInterface(a.AbstractBinderC0051a.a);
            String str = mo680O8oO888();
            parcel2.writeNoException();
            parcel2.writeString(str);
            return true;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    String mo680O8oO888() throws RemoteException;
}
