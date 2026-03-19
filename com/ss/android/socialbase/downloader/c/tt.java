package com.ss.android.socialbase.downloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface tt extends IInterface {
    boolean d() throws RemoteException;

    public static abstract class d extends Binder implements tt {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public d() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        public static tt d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof tt)) {
                return (tt) iInterfaceQueryLocalInterface;
            }
            return new C0781d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            boolean zD = d();
            parcel2.writeNoException();
            parcel2.writeInt(zD ? 1 : 0);
            return true;
        }

        /* renamed from: com.ss.android.socialbase.downloader.c.tt$d$d, reason: collision with other inner class name */
        private static class C0781d implements tt {
            public static tt d;
            private IBinder hc;

            C0781d(IBinder iBinder) {
                this.hc = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hc;
            }

            @Override // com.ss.android.socialbase.downloader.c.tt
            public boolean d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    if (!this.hc.transact(1, parcelObtain, parcelObtain2, 0) && d.hc() != null) {
                        return d.hc().d();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static tt hc() {
            return C0781d.d;
        }
    }
}
