package com.alliance.ssp.ad.i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.alipay.sdk.m.c.b;

/* compiled from: OpenDeviceIdentifierService.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface a extends IInterface {

    /* compiled from: OpenDeviceIdentifierService.java */
    /* renamed from: com.alliance.ssp.ad.i.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0084a extends Binder implements a {
        public static final /* synthetic */ int a = 0;

        /* compiled from: OpenDeviceIdentifierService.java */
        /* renamed from: com.alliance.ssp.ad.i.a$a$a, reason: collision with other inner class name */
        public static class C0085a implements a {
            public IBinder a;

            public C0085a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.alliance.ssp.ad.i.a
            public boolean c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0084a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alliance.ssp.ad.i.a
            public String e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.a);
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0084a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    boolean c();

    String e();
}
