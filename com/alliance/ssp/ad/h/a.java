package com.alliance.ssp.ad.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.alipay.sdk.m.k0.a;

/* compiled from: IDeviceIdService.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface a extends IInterface {

    /* compiled from: IDeviceIdService.java */
    /* renamed from: com.alliance.ssp.ad.h.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0082a extends Binder implements a {
        public static final /* synthetic */ int a = 0;

        /* compiled from: IDeviceIdService.java */
        /* renamed from: com.alliance.ssp.ad.h.a$a$a, reason: collision with other inner class name */
        public static class C0083a implements a {
            public IBinder a;

            public C0083a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.alliance.ssp.ad.h.a
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.AbstractBinderC0051a.a);
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0082a.a;
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

    String a();
}
