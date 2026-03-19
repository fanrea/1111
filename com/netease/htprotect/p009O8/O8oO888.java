package com.netease.htprotect.p009O8;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.netease.htprotect.〇O8.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface O8oO888 extends IInterface {

    /* renamed from: com.netease.htprotect.〇O8.O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
    public static class C0674O8oO888 implements O8oO888 {
        @Override // com.netease.htprotect.p009O8.O8oO888
        /* renamed from: O8〇oO8〇88 */
        public final boolean mo715O8oO888() throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.netease.htprotect.p009O8.O8oO888
        /* renamed from: 〇Ooo */
        public final void mo716Ooo() throws RemoteException {
        }
    }

    /* renamed from: com.netease.htprotect.〇O8.O8〇oO8〇88$〇Ooo, reason: invalid class name */
    public static abstract class Ooo extends Binder implements O8oO888 {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        static final int f246O8oO888 = 1;

        /* renamed from: 〇O8, reason: contains not printable characters */
        private static final String f247O8 = "com.netease.htprotect.bundle.IRootCheckInterface";

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        static final int f248Ooo = 2;

        /* renamed from: com.netease.htprotect.〇O8.O8〇oO8〇88$〇Ooo$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
        private static class C0675O8oO888 implements O8oO888 {

            /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
            public static O8oO888 f249O8oO888;

            /* renamed from: 〇Ooo, reason: contains not printable characters */
            private IBinder f250Ooo;

            C0675O8oO888(IBinder iBinder) {
                this.f250Ooo = iBinder;
            }

            /* renamed from: 〇O8, reason: contains not printable characters */
            private static String m720O8() {
                return Ooo.f247O8;
            }

            @Override // com.netease.htprotect.p009O8.O8oO888
            /* renamed from: O8〇oO8〇88 */
            public final boolean mo715O8oO888() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Ooo.f247O8);
                    if (!this.f250Ooo.transact(1, parcelObtain, parcelObtain2, 0) && Ooo.m719O8() != null) {
                        return Ooo.m719O8().mo715O8oO888();
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
                return this.f250Ooo;
            }

            @Override // com.netease.htprotect.p009O8.O8oO888
            /* renamed from: 〇Ooo */
            public final void mo716Ooo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Ooo.f247O8);
                    if (this.f250Ooo.transact(2, parcelObtain, parcelObtain2, 0) || Ooo.m719O8() == null) {
                        parcelObtain2.readException();
                    } else {
                        Ooo.m719O8().mo716Ooo();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Ooo() {
            attachInterface(this, f247O8);
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private static O8oO888 m717O8oO888(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f247O8);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof O8oO888)) ? new C0675O8oO888(iBinder) : (O8oO888) iInterfaceQueryLocalInterface;
        }

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        private static boolean m718O8oO888(O8oO888 o8oO888) {
            if (C0675O8oO888.f249O8oO888 != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (o8oO888 == null) {
                return false;
            }
            C0675O8oO888.f249O8oO888 = o8oO888;
            return true;
        }

        /* renamed from: 〇O8, reason: contains not printable characters */
        public static O8oO888 m719O8() {
            return C0675O8oO888.f249O8oO888;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(f247O8);
                boolean z = mo715O8oO888();
                parcel2.writeNoException();
                parcel2.writeInt(z ? 1 : 0);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(f247O8);
                return true;
            }
            parcel.enforceInterface(f247O8);
            mo716Ooo();
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    boolean mo715O8oO888() throws RemoteException;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    void mo716Ooo() throws RemoteException;
}
