package lk.repeackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.lk.oaid.ErrorCode;
import lk.repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface;
import lk.repeackage.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class h implements d {
    public final Context a;

    public class a implements t.a {
        public a(h hVar) {
        }

        @Override // lk.repeackage.t.a
        public String a(IBinder iBinder) {
            IDidAidlInterface iDidAidlInterfaceAsInterface = IDidAidlInterface.Stub.asInterface(iBinder);
            if (iDidAidlInterfaceAsInterface == null) {
                throw new e("IDidAidlInterface is null");
            }
            if (iDidAidlInterfaceAsInterface.isSupport()) {
                return iDidAidlInterfaceAsInterface.getOAID();
            }
            throw new e("IDidAidlInterface#isSupport return false");
        }
    }

    public h(Context context) {
        this.a = context;
    }

    @Override // lk.repeackage.d
    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.a == null) {
            cVar.onOAIDGetError(ErrorCode.STATE_CALL_PARAM, new e("context is null !!!"));
        } else {
            if (!a()) {
                cVar.onOAIDGetError(ErrorCode.STATE_DEVICE_NOSUPPORT, new e("asus device Unsupported"));
                return;
            }
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            t.a(this.a, intent, cVar, new a(this));
        }
    }

    @Override // lk.repeackage.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e) {
            f.a(e);
            return false;
        }
    }
}
