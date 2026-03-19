package com.netease.htprotect.p008O;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.netease.htprotect.〇O.〇oO, reason: invalid class name and case insensitive filesystem */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface InterfaceC0963oO extends IInterface {

    /* renamed from: com.netease.htprotect.〇O.〇oO$O8〇oO8〇88, reason: invalid class name */
    public static abstract class O8oO888 extends Binder implements InterfaceC0963oO {

        /* renamed from: com.netease.htprotect.〇O.〇oO$O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
        static class C0672O8oO888 implements InterfaceC0963oO {

            /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
            public static InterfaceC0963oO f242O8oO888;

            /* renamed from: 〇Ooo, reason: contains not printable characters */
            private IBinder f243Ooo;

            C0672O8oO888(IBinder iBinder) {
                this.f243Ooo = iBinder;
            }

            @Override // com.netease.htprotect.p008O.InterfaceC0963oO
            /* renamed from: O8〇oO8〇88 */
            public final boolean mo707O8oO888() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f243Ooo.transact(1, parcelObtain, parcelObtain2, 0) && O8oO888.m712oO() != null) {
                        return O8oO888.m712oO().mo707O8oO888();
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
                return this.f243Ooo;
            }

            @Override // com.netease.htprotect.p008O.InterfaceC0963oO
            /* renamed from: 〇O8 */
            public final boolean mo708O8() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f243Ooo.transact(3, parcelObtain, parcelObtain2, 0) && O8oO888.m712oO() != null) {
                        return O8oO888.m712oO().mo708O8();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.netease.htprotect.p008O.InterfaceC0963oO
            /* renamed from: 〇Ooo */
            public final String mo709Ooo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f243Ooo.transact(2, parcelObtain, parcelObtain2, 0) && O8oO888.m712oO() != null) {
                        return O8oO888.m712oO().mo709Ooo();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.netease.htprotect.p008O.InterfaceC0963oO
            /* renamed from: 〇o0〇o0 */
            public final void mo710o0o0() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.f243Ooo.transact(4, parcelObtain, parcelObtain2, 0) || O8oO888.m712oO() == null) {
                        parcelObtain2.readException();
                    } else {
                        O8oO888.m712oO().mo710o0o0();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public static InterfaceC0963oO m711O8oO888(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0963oO)) ? new C0672O8oO888(iBinder) : (InterfaceC0963oO) iInterfaceQueryLocalInterface;
        }

        /* renamed from: 〇oO, reason: contains not printable characters */
        public static InterfaceC0963oO m712oO() {
            return C0672O8oO888.f242O8oO888;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                boolean z = mo707O8oO888();
                parcel2.writeNoException();
                parcel2.writeInt(z ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                String str = mo709Ooo();
                parcel2.writeNoException();
                parcel2.writeString(str);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                boolean z2 = mo708O8();
                parcel2.writeNoException();
                parcel2.writeInt(z2 ? 1 : 0);
                return true;
            }
            if (i != 4) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bun.lib.MsaIdInterface");
                return true;
            }
            parcel.enforceInterface("com.bun.lib.MsaIdInterface");
            mo710o0o0();
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    boolean mo707O8oO888() throws RemoteException;

    /* renamed from: 〇O8, reason: contains not printable characters */
    boolean mo708O8() throws RemoteException;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    String mo709Ooo() throws RemoteException;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    void mo710o0o0() throws RemoteException;
}
