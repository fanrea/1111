package ca.da.da;

import android.os.IBinder;
import android.os.Parcel;
import android.util.Pair;
import ca.da.da.s;
import ca.da.da.v;

/* compiled from: HWOaidImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class i implements v.b<s, Pair<String, Boolean>> {
    @Override // ca.da.da.v.b
    public Pair<String, Boolean> a(s sVar) throws Exception {
        s sVar2 = sVar;
        if (sVar2 == null) {
            return null;
        }
        s.a.C0036a c0036a = (s.a.C0036a) sVar2;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(com.alipay.sdk.m.c.b.a);
            c0036a.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            parcelObtain = Parcel.obtain();
            parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(com.alipay.sdk.m.c.b.a);
                c0036a.a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                boolean z = parcelObtain2.readInt() != 0;
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return new Pair<>(string, Boolean.valueOf(z));
            } finally {
            }
        } finally {
        }
    }

    @Override // ca.da.da.v.b
    public s a(IBinder iBinder) {
        return s.a.a(iBinder);
    }
}
