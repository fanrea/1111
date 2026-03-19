package com.alliance.ssp.ad.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IDidAidlInterface.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface a extends IInterface {

    /* compiled from: IDidAidlInterface.java */
    /* renamed from: com.alliance.ssp.ad.c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0070a extends Binder implements a {
        public static final /* synthetic */ int a = 0;

        /* compiled from: IDidAidlInterface.java */
        /* renamed from: com.alliance.ssp.ad.c.a$a$a, reason: collision with other inner class name */
        public static class C0071a implements a {
            public IBinder a;

            public C0071a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.alliance.ssp.ad.c.a
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0070a.a;
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

            @Override // com.alliance.ssp.ad.c.a
            public boolean b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0070a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    String a();

    boolean b();
}
