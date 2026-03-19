package com.alliance.ssp.ad.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IdsSupplier.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface a extends IInterface {

    /* compiled from: IdsSupplier.java */
    /* renamed from: com.alliance.ssp.ad.b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0068a extends Binder implements a {
        public static final /* synthetic */ int a = 0;

        /* compiled from: IdsSupplier.java */
        /* renamed from: com.alliance.ssp.ad.b.a$a$a, reason: collision with other inner class name */
        public static class C0069a implements a {
            public IBinder a;

            public C0069a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.alliance.ssp.ad.b.a
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0068a.a;
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
