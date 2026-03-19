package com.alliance.ssp.ad.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IDeviceIdManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface a extends IInterface {

    /* compiled from: IDeviceIdManager.java */
    /* renamed from: com.alliance.ssp.ad.e.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0075a extends Binder implements a {
        public static final /* synthetic */ int a = 0;

        /* compiled from: IDeviceIdManager.java */
        /* renamed from: com.alliance.ssp.ad.e.a$a$a, reason: collision with other inner class name */
        public static class C0076a implements a {
            public IBinder a;

            public C0076a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.alliance.ssp.ad.e.a
            public String a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0075a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
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
    }

    String a(String str);
}
