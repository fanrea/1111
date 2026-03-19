package com.qq.e.comm.plugin.apkmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface r extends IInterface {

    /* compiled from: A */
    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void b(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void b(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                b(parcel, list.get(i2), i);
            }
        }
    }

    int a(ApkDownloadTask apkDownloadTask) throws RemoteException;

    boolean a(int i, int i2, long j) throws RemoteException;

    boolean a(ApkDownloadTask apkDownloadTask, boolean z) throws RemoteException;

    boolean a(String str, int i) throws RemoteException;

    int b(String str, int i) throws RemoteException;

    boolean b(ApkDownloadTask apkDownloadTask) throws RemoteException;

    int c(ApkDownloadTask apkDownloadTask) throws RemoteException;

    int c(String str) throws RemoteException;

    int d(String str) throws RemoteException;

    boolean d(int i) throws RemoteException;

    boolean d(ApkDownloadTask apkDownloadTask) throws RemoteException;

    boolean e(String str) throws RemoteException;

    ApkDownloadTask f(int i) throws RemoteException;

    ApkDownloadTask f(String str) throws RemoteException;

    List<ApkDownloadTask> f() throws RemoteException;

    List<ApkDownloadTask> g() throws RemoteException;

    boolean g(int i) throws RemoteException;

    List<ApkDownloadTask> h() throws RemoteException;

    /* compiled from: A */
    public static abstract class a extends Binder implements r {
        public a() {
            attachInterface(this, "com.qq.e.comm.plugin.apkmanager.IDownloadService");
        }

        public static r a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof r)) ? new C0700a(iBinder) : (r) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        int iC = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(iC);
                        return true;
                    case 2:
                        int iD = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(iD);
                        return true;
                    case 3:
                        List<ApkDownloadTask> listG = g();
                        parcel2.writeNoException();
                        b.b(parcel2, listG, 1);
                        return true;
                    case 4:
                        List<ApkDownloadTask> listF = f();
                        parcel2.writeNoException();
                        b.b(parcel2, listF, 1);
                        return true;
                    case 5:
                        List<ApkDownloadTask> listH = h();
                        parcel2.writeNoException();
                        b.b(parcel2, listH, 1);
                        return true;
                    case 6:
                        ApkDownloadTask apkDownloadTaskF = f(parcel.readString());
                        parcel2.writeNoException();
                        b.b(parcel2, apkDownloadTaskF, 1);
                        return true;
                    case 7:
                        ApkDownloadTask apkDownloadTaskF2 = f(parcel.readInt());
                        parcel2.writeNoException();
                        b.b(parcel2, apkDownloadTaskF2, 1);
                        return true;
                    case 8:
                        int iC2 = c((ApkDownloadTask) b.b(parcel, ApkDownloadTask.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(iC2);
                        return true;
                    case 9:
                        int iA = a((ApkDownloadTask) b.b(parcel, ApkDownloadTask.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(iA);
                        return true;
                    case 10:
                        int iB = b(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(iB);
                        return true;
                    case 11:
                        boolean zD = d(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(zD ? 1 : 0);
                        return true;
                    case 12:
                        boolean zG = g(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(zG ? 1 : 0);
                        return true;
                    case 13:
                        boolean zA = a(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(zA ? 1 : 0);
                        return true;
                    case 14:
                        boolean zE = e(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(zE ? 1 : 0);
                        return true;
                    case 15:
                        boolean zB = b((ApkDownloadTask) b.b(parcel, ApkDownloadTask.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(zB ? 1 : 0);
                        return true;
                    case 16:
                        boolean zD2 = d((ApkDownloadTask) b.b(parcel, ApkDownloadTask.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeInt(zD2 ? 1 : 0);
                        return true;
                    case 17:
                        boolean zA2 = a((ApkDownloadTask) b.b(parcel, ApkDownloadTask.CREATOR), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        parcel2.writeInt(zA2 ? 1 : 0);
                        return true;
                    case 18:
                        boolean zA3 = a(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(zA3 ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.qq.e.comm.plugin.apkmanager.IDownloadService");
            return true;
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.apkmanager.r$a$a, reason: collision with other inner class name */
        private static class C0700a implements r {
            private IBinder a;

            C0700a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public boolean a(ApkDownloadTask apkDownloadTask, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    b.b(parcelObtain, apkDownloadTask, 0);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.a.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public int b(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public int c(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    parcelObtain.writeString(str);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public int d(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    parcelObtain.writeString(str);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public List<ApkDownloadTask> f() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(ApkDownloadTask.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public List<ApkDownloadTask> g() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(ApkDownloadTask.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public List<ApkDownloadTask> h() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(ApkDownloadTask.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public ApkDownloadTask f(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    parcelObtain.writeString(str);
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (ApkDownloadTask) b.b(parcelObtain2, ApkDownloadTask.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public int c(ApkDownloadTask apkDownloadTask) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    b.b(parcelObtain, apkDownloadTask, 0);
                    this.a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public boolean d(ApkDownloadTask apkDownloadTask) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    b.b(parcelObtain, apkDownloadTask, 0);
                    this.a.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public boolean a(int i, int i2, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    this.a.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public boolean b(ApkDownloadTask apkDownloadTask) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    b.b(parcelObtain, apkDownloadTask, 0);
                    this.a.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.r
            public ApkDownloadTask f(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    parcelObtain.writeInt(i);
                    this.a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (ApkDownloadTask) b.b(parcelObtain2, ApkDownloadTask.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
