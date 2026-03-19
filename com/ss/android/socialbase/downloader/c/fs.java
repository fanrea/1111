package com.ss.android.socialbase.downloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface fs extends IInterface {
    boolean b(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException;

    boolean d(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException;

    boolean hc(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException;

    public static abstract class d extends Binder implements fs {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public d() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
        }

        public static fs d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof fs)) {
                return (fs) iInterfaceQueryLocalInterface;
            }
            return new C0774d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                boolean zD = d(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.h.b.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zD ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                boolean zHc = hc(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.h.b.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zHc ? 1 : 0);
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            boolean zB = b(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.h.b.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(zB ? 1 : 0);
            return true;
        }

        /* renamed from: com.ss.android.socialbase.downloader.c.fs$d$d, reason: collision with other inner class name */
        private static class C0774d implements fs {
            public static fs d;
            private IBinder hc;

            C0774d(IBinder iBinder) {
                this.hc = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hc;
            }

            @Override // com.ss.android.socialbase.downloader.c.fs
            public boolean d(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    if (bVar != null) {
                        parcelObtain.writeInt(1);
                        bVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.hc.transact(1, parcelObtain, parcelObtain2, 0) && d.d() != null) {
                        return d.d().d(bVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.fs
            public boolean hc(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    if (bVar != null) {
                        parcelObtain.writeInt(1);
                        bVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.hc.transact(2, parcelObtain, parcelObtain2, 0) && d.d() != null) {
                        return d.d().hc(bVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.c.fs
            public boolean b(com.ss.android.socialbase.downloader.h.b bVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    if (bVar != null) {
                        parcelObtain.writeInt(1);
                        bVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.hc.transact(3, parcelObtain, parcelObtain2, 0) && d.d() != null) {
                        return d.d().b(bVar);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static fs d() {
            return C0774d.d;
        }
    }
}
