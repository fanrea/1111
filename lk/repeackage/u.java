package lk.repeackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.lk.oaid.ErrorCode;
import lk.repeackage.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class u extends v {
    public final Context c;

    public class a implements t.a {
        public a() {
        }

        @Override // lk.repeackage.t.a
        public String a(IBinder iBinder) throws RemoteException {
            try {
                return u.this.a(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (e e2) {
                throw e2;
            } catch (Exception e3) {
                throw new e(e3);
            }
        }
    }

    public u(Context context) {
        super(context);
        this.c = context;
    }

    @Override // lk.repeackage.v, lk.repeackage.d
    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.c == null) {
            cVar.onOAIDGetError(ErrorCode.STATE_CALL_PARAM, new e("context is null !!!"));
        } else {
            if (!a()) {
                cVar.onOAIDGetError(ErrorCode.STATE_DEVICE_NOSUPPORT, new e("oppo device Unsupported"));
                return;
            }
            Intent intent = new Intent("action.com.oplus.stdid.ID_SERVICE");
            intent.setComponent(new ComponentName("com.coloros.mcs", "com.oplus.stdid.IdentifyService"));
            t.a(this.c, intent, cVar, new a());
        }
    }

    @Override // lk.repeackage.v, lk.repeackage.d
    public boolean a() {
        Context context = this.c;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coloros.mcs", 0) != null;
        } catch (Exception e) {
            f.a(e);
            return false;
        }
    }
}
