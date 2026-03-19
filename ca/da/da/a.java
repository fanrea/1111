package ca.da.da;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import ca.da.da.ca.c;
import ca.da.da.v;

/* compiled from: ASUSOaidImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class a extends c<ca.da.da.ca.c> {
    public a() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // ca.da.da.c
    public v.b<ca.da.da.ca.c, String> a() {
        return new C0031a(this);
    }

    @Override // ca.da.da.c
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }

    /* compiled from: ASUSOaidImpl.java */
    /* renamed from: ca.da.da.a$a, reason: collision with other inner class name */
    public class C0031a implements v.b<ca.da.da.ca.c, String> {
        public C0031a(a aVar) {
        }

        @Override // ca.da.da.v.b
        public String a(ca.da.da.ca.c cVar) throws Exception {
            ca.da.da.ca.c cVar2 = cVar;
            if (cVar2 == null) {
                return null;
            }
            c.a.C0035a c0035a = (c.a.C0035a) cVar2;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                c0035a.a.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // ca.da.da.v.b
        public ca.da.da.ca.c a(IBinder iBinder) {
            return c.a.a(iBinder);
        }
    }
}
