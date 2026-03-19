package com.bytedance.dr.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface a extends IInterface {

    /* renamed from: com.bytedance.dr.aidl.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0190a extends Binder implements a {

        /* renamed from: com.bytedance.dr.aidl.a$a$a, reason: collision with other inner class name */
        public static class C0191a implements a {
            public static a b;
            public IBinder a;

            public C0191a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a(String str) {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (this.a.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC0190a.a() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = ((C0191a) AbstractBinderC0190a.a()).a(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static a a() {
            return C0191a.b;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0191a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
