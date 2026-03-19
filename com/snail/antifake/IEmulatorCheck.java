package com.snail.antifake;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface IEmulatorCheck extends IInterface {

    public static class Default implements IEmulatorCheck {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.snail.antifake.IEmulatorCheck
        public boolean isEmulator() throws RemoteException {
            return false;
        }

        @Override // com.snail.antifake.IEmulatorCheck
        public void kill() throws RemoteException {
        }
    }

    boolean isEmulator() throws RemoteException;

    void kill() throws RemoteException;

    public static abstract class Stub extends Binder implements IEmulatorCheck {
        private static final String DESCRIPTOR = "com.snail.antifake.IEmulatorCheck";
        static final int TRANSACTION_isEmulator = 1;
        static final int TRANSACTION_kill = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IEmulatorCheck asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IEmulatorCheck)) {
                return (IEmulatorCheck) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean zIsEmulator = isEmulator();
                parcel2.writeNoException();
                parcel2.writeInt(zIsEmulator ? 1 : 0);
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            kill();
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IEmulatorCheck {
            public static IEmulatorCheck sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.snail.antifake.IEmulatorCheck
            public boolean isEmulator() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isEmulator();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.snail.antifake.IEmulatorCheck
            public void kill() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().kill();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IEmulatorCheck iEmulatorCheck) {
            if (Proxy.sDefaultImpl != null || iEmulatorCheck == null) {
                return false;
            }
            Proxy.sDefaultImpl = iEmulatorCheck;
            return true;
        }

        public static IEmulatorCheck getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
