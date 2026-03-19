package ca.da.da;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import ca.da.da.ca.a;
import ca.da.da.v;

/* compiled from: SamsungOaidImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class u extends c<ca.da.da.ca.a> {

    /* compiled from: SamsungOaidImpl.java */
    public class a implements v.b<ca.da.da.ca.a, String> {
        public a(u uVar) {
        }

        @Override // ca.da.da.v.b
        public ca.da.da.ca.a a(IBinder iBinder) {
            return a.AbstractBinderC0032a.a(iBinder);
        }

        @Override // ca.da.da.v.b
        public String a(ca.da.da.ca.a aVar) throws Exception {
            return ((a.AbstractBinderC0032a.C0033a) aVar).a();
        }
    }

    public u() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // ca.da.da.c
    public v.b<ca.da.da.ca.a, String> a() {
        return new a(this);
    }

    @Override // ca.da.da.c
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
