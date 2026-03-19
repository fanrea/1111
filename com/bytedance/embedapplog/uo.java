package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.alipay.sdk.m.k0.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface uo extends IInterface {
    String d();

    String d(String str);

    String hc(String str);

    public static abstract class d extends Binder implements uo {
        public static uo d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0051a.a);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof uo)) {
                return (uo) iInterfaceQueryLocalInterface;
            }
            return new C0205d(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(a.AbstractBinderC0051a.a);
                String strD = d();
                parcel2.writeNoException();
                parcel2.writeString(strD);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(a.AbstractBinderC0051a.a);
                String strD2 = d(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strD2);
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(a.AbstractBinderC0051a.a);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(a.AbstractBinderC0051a.a);
            String strHc = hc(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strHc);
            return true;
        }

        /* renamed from: com.bytedance.embedapplog.uo$d$d, reason: collision with other inner class name */
        static class C0205d implements uo {
            private IBinder d;

            C0205d(IBinder iBinder) {
                this.d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.d;
            }

            @Override // com.bytedance.embedapplog.uo
            public String d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0051a.a);
                    this.d.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.uo
            public String d(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0051a.a);
                    parcelObtain.writeString(str);
                    this.d.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.uo
            public String hc(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0051a.a);
                    parcelObtain.writeString(str);
                    this.d.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
