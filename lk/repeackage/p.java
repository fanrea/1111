package lk.repeackage;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.lk.oaid.ErrorCode;
import lk.repeackage.com.zui.deviceidservice.IDeviceidInterface;
import lk.repeackage.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class p implements d {
    public final Context a;

    public class a implements t.a {
        public a(p pVar) {
        }

        @Override // lk.repeackage.t.a
        public String a(IBinder iBinder) {
            IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
            if (iDeviceidInterfaceAsInterface == null) {
                throw new e("IDeviceidInterface is null");
            }
            if (iDeviceidInterfaceAsInterface.isSupport()) {
                return iDeviceidInterfaceAsInterface.getOAID();
            }
            throw new e("IDeviceidInterface#isSupport return false");
        }
    }

    public p(Context context) {
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
                cVar.onOAIDGetError(ErrorCode.STATE_DEVICE_NOSUPPORT, new e("lenovo device Unsupported"));
                return;
            }
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
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
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e) {
            f.a(e);
            return false;
        }
    }
}
