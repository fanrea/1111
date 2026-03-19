package ca.da.da;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import ca.da.da.n;
import ca.da.da.v;
import ca.ea.ca.a;

/* compiled from: CommonOaidImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class e extends c<ca.ea.ca.a> {
    public e() {
        super("com.mdid.msa");
    }

    @Override // ca.da.da.c, ca.da.da.n
    public n.a a(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.a(context);
    }

    @Override // ca.da.da.c
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    @Override // ca.da.da.c
    public v.b<ca.ea.ca.a, String> a() {
        return new a(this);
    }

    /* compiled from: CommonOaidImpl.java */
    public class a implements v.b<ca.ea.ca.a, String> {
        public a(e eVar) {
        }

        @Override // ca.da.da.v.b
        public String a(ca.ea.ca.a aVar) throws Exception {
            ca.ea.ca.a aVar2 = aVar;
            if (aVar2 == null) {
                return null;
            }
            a.AbstractBinderC0037a.C0038a c0038a = (a.AbstractBinderC0037a.C0038a) aVar2;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                c0038a.a.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // ca.da.da.v.b
        public ca.ea.ca.a a(IBinder iBinder) {
            return a.AbstractBinderC0037a.a(iBinder);
        }
    }
}
