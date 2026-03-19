package com.alliance.ssp.ad.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IOpenID.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface a extends IInterface {

    /* compiled from: IOpenID.java */
    /* renamed from: com.alliance.ssp.ad.g.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0079a extends Binder implements a {
        public static final /* synthetic */ int a = 0;

        /* compiled from: IOpenID.java */
        /* renamed from: com.alliance.ssp.ad.g.a$a$a, reason: collision with other inner class name */
        public static class C0080a implements a {
            public IBinder a;

            public C0080a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.alliance.ssp.ad.g.a
            public String a(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC0079a.a;
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

    String a(String str, String str2, String str3);
}
