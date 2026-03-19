package lk.repeackage;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.lk.oaid.ErrorCode;
import java.security.MessageDigest;
import lk.repeackage.com.heytap.openid.IOpenID;
import lk.repeackage.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class v implements d {
    public final Context a;
    public String b;

    public class a implements t.a {
        public a() {
        }

        @Override // lk.repeackage.t.a
        public String a(IBinder iBinder) throws RemoteException {
            try {
                return v.this.a(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (e e2) {
                throw e2;
            } catch (Exception e3) {
                throw new e(e3);
            }
        }
    }

    public v(Context context) {
        this.a = context instanceof Application ? context : context.getApplicationContext();
    }

    public String a(IBinder iBinder) {
        String packageName = this.a.getPackageName();
        String str = this.b;
        if (str != null) {
            IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
            if (iOpenIDAsInterface != null) {
                return iOpenIDAsInterface.getSerID(packageName, str, "OUID");
            }
            throw new e("IOpenID is null");
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.b = string;
        IOpenID iOpenIDAsInterface2 = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface2 != null) {
            return iOpenIDAsInterface2.getSerID(packageName, string, "OUID");
        }
        throw new e("IOpenID is null");
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
                cVar.onOAIDGetError(ErrorCode.STATE_DEVICE_NOSUPPORT, new e("oppo device Unsupported"));
                return;
            }
            Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            t.a(this.a, intent, cVar, new a());
        }
    }

    @Override // lk.repeackage.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            f.a(e);
            return false;
        }
    }
}
