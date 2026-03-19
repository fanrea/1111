package com.ss.android.socialbase.downloader.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.c.an;
import com.ss.android.socialbase.downloader.c.fs;
import com.ss.android.socialbase.downloader.c.gb;
import com.ss.android.socialbase.downloader.c.h;
import com.ss.android.socialbase.downloader.c.j;
import com.ss.android.socialbase.downloader.c.mk;
import com.ss.android.socialbase.downloader.c.r;
import com.ss.android.socialbase.downloader.c.tc;
import com.ss.android.socialbase.downloader.c.tt;
import com.ss.android.socialbase.downloader.c.uo;
import com.ss.android.socialbase.downloader.c.v;
import com.ss.android.socialbase.downloader.c.w;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface d extends IInterface {
    com.ss.android.socialbase.downloader.c.h an() throws RemoteException;

    j b() throws RemoteException;

    uo b(int i) throws RemoteException;

    fs c() throws RemoteException;

    int d(int i) throws RemoteException;

    tc d(int i, int i2) throws RemoteException;

    b d() throws RemoteException;

    r gb() throws RemoteException;

    v h() throws RemoteException;

    com.ss.android.socialbase.downloader.c.an hc() throws RemoteException;

    tc hc(int i) throws RemoteException;

    gb mk() throws RemoteException;

    int mq() throws RemoteException;

    mk tc() throws RemoteException;

    w tt() throws RemoteException;

    tt u() throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.h.d$d, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0789d extends Binder implements d {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0789d() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static d d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof d)) {
                return (d) iInterfaceQueryLocalInterface;
            }
            return new C0790d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    b bVarD = d();
                    parcel2.writeNoException();
                    if (bVarD != null) {
                        parcel2.writeInt(1);
                        bVarD.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.ss.android.socialbase.downloader.c.an anVarHc = hc();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(anVarHc != null ? anVarHc.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iD = d(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iD);
                    return true;
                case 4:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    tc tcVarD = d(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(tcVarD != null ? tcVarD.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    tc tcVarHc = hc(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(tcVarHc != null ? tcVarHc.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    j jVarB = b();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(jVarB != null ? jVarB.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    fs fsVarC = c();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(fsVarC != null ? fsVarC.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    tt ttVarU = u();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(ttVarU != null ? ttVarU.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    com.ss.android.socialbase.downloader.c.h hVarAn = an();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(hVarAn != null ? hVarAn.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    v vVarH = h();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(vVarH != null ? vVarH.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    r rVarGb = gb();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(rVarGb != null ? rVarGb.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    w wVarTt = tt();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(wVarTt != null ? wVarTt.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    mk mkVarTc = tc();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(mkVarTc != null ? mkVarTc.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    gb gbVarMk = mk();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(gbVarMk != null ? gbVarMk.asBinder() : null);
                    return true;
                case 15:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    int iMq = mq();
                    parcel2.writeNoException();
                    parcel2.writeInt(iMq);
                    return true;
                case 16:
                    parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    uo uoVarB = b(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(uoVarB != null ? uoVarB.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.h.d$d$d, reason: collision with other inner class name */
        private static class C0790d implements d {
            public static d d;
            private IBinder hc;

            C0790d(IBinder iBinder) {
                this.hc = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.hc;
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public b d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().d();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? b.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public com.ss.android.socialbase.downloader.c.an hc() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().hc();
                    }
                    parcelObtain2.readException();
                    return an.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public int d(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.hc.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().d(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public tc d(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.hc.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().d(i, i2);
                    }
                    parcelObtain2.readException();
                    return tc.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public tc hc(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.hc.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().hc(i);
                    }
                    parcelObtain2.readException();
                    return tc.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public j b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().b();
                    }
                    parcelObtain2.readException();
                    return j.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public fs c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().c();
                    }
                    parcelObtain2.readException();
                    return fs.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public tt u() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().u();
                    }
                    parcelObtain2.readException();
                    return tt.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public com.ss.android.socialbase.downloader.c.h an() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().an();
                    }
                    parcelObtain2.readException();
                    return h.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public v h() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().h();
                    }
                    parcelObtain2.readException();
                    return v.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public r gb() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(11, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().gb();
                    }
                    parcelObtain2.readException();
                    return r.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public w tt() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(12, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().tt();
                    }
                    parcelObtain2.readException();
                    return w.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public mk tc() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(13, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().tc();
                    }
                    parcelObtain2.readException();
                    return mk.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public gb mk() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(14, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().mk();
                    }
                    parcelObtain2.readException();
                    return gb.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public int mq() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.hc.transact(15, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().mq();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.h.d
            public uo b(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    parcelObtain.writeInt(i);
                    if (!this.hc.transact(16, parcelObtain, parcelObtain2, 0) && AbstractBinderC0789d.uo() != null) {
                        return AbstractBinderC0789d.uo().b(i);
                    }
                    parcelObtain2.readException();
                    return uo.d.d(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static d uo() {
            return C0790d.d;
        }
    }
}
