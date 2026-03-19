package lk.repeackage;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.lk.oaid.ErrorCode;
import lk.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager;
import lk.repeackage.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class i implements d {
    public final Context a;

    public class a implements t.a {
        public a() {
        }

        @Override // lk.repeackage.t.a
        public String a(IBinder iBinder) {
            IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
            if (iDeviceIdManagerAsInterface != null) {
                return iDeviceIdManagerAsInterface.getOAID(i.this.a.getPackageName());
            }
            throw new e("IDeviceIdManager is null");
        }
    }

    public i(Context context) {
        this.a = context instanceof Application ? context : context.getApplicationContext();
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
                cVar.onOAIDGetError(ErrorCode.STATE_DEVICE_NOSUPPORT, new e("coolpad device Unsupported"));
                return;
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
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
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            f.a(e);
            return false;
        }
    }
}
