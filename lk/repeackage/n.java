package lk.repeackage;

import android.os.IBinder;
import lk.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import lk.repeackage.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class n implements t.a {
    public n(o oVar) {
    }

    @Override // lk.repeackage.t.a
    public String a(IBinder iBinder) {
        return OpenDeviceIdentifierService.Stub.asInterface(iBinder).getOaid();
    }
}
