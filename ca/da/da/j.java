package ca.da.da;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import ca.da.da.ca.b;
import ca.da.da.v;
import com.alipay.sdk.m.q0.a;

/* compiled from: LenovoOaidImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class j extends c<ca.da.da.ca.b> {
    public j() {
        super("com.zui.deviceidservice");
    }

    @Override // ca.da.da.c
    public v.b<ca.da.da.ca.b, String> a() {
        return new a(this);
    }

    @Override // ca.da.da.c
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    /* compiled from: LenovoOaidImpl.java */
    public class a implements v.b<ca.da.da.ca.b, String> {
        public a(j jVar) {
        }

        @Override // ca.da.da.v.b
        public String a(ca.da.da.ca.b bVar) throws Exception {
            ca.da.da.ca.b bVar2 = bVar;
            if (bVar2 == null) {
                return null;
            }
            b.a.C0034a c0034a = (b.a.C0034a) bVar2;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(a.AbstractBinderC0056a.a);
                c0034a.a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // ca.da.da.v.b
        public ca.da.da.ca.b a(IBinder iBinder) {
            return b.a.a(iBinder);
        }
    }
}
