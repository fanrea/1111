package com.alliance.ssp.ad.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: MsaIdInterface.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface a extends IInterface {

    /* compiled from: MsaIdInterface.java */
    /* renamed from: com.alliance.ssp.ad.d.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0073a extends Binder implements a {
        public static final /* synthetic */ int a = 0;

        /* compiled from: MsaIdInterface.java */
        /* renamed from: com.alliance.ssp.ad.d.a$a$a, reason: collision with other inner class name */
        public static class C0074a implements a {
            public IBinder a;

            public C0074a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.alliance.ssp.ad.d.a
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0073a.a;
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

            @Override // com.alliance.ssp.ad.d.a
            public boolean f() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0073a.a;
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

    boolean f();
}
