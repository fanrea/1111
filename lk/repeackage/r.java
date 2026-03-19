package lk.repeackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import lk.repeackage.com.bun.lib.MsaIdInterface;
import lk.repeackage.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class r implements d {
    public final Context a;

    public class a implements t.a {
        public a(r rVar) {
        }

        @Override // lk.repeackage.t.a
        public String a(IBinder iBinder) {
            MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
            if (msaIdInterfaceAsInterface == null) {
                throw new e("MsaIdInterface is null");
            }
            if (msaIdInterfaceAsInterface.isSupported()) {
                return msaIdInterfaceAsInterface.getOAID();
            }
            throw new e("MsaIdInterface#isSupported return false");
        }
    }

    public r(Context context) {
        this.a = context;
    }

    @Override // lk.repeackage.d
    public void a(c cVar) {
        if (this.a == null || cVar == null) {
            return;
        }
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (Build.VERSION.SDK_INT < 26) {
                this.a.startService(intent);
            } else {
                this.a.startForegroundService(intent);
            }
        } catch (Exception e) {
            f.a(e);
        }
        Intent intent2 = new Intent("com.bun.msa.action.bindto.service");
        intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent2.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
        t.a(this.a, intent2, cVar, new a(this));
    }

    @Override // lk.repeackage.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e) {
            f.a(e);
            return false;
        }
    }
}
