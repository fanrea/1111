package lk.repeackage;

import android.content.Context;
import com.lk.oaid.ErrorCode;
import lk.repeackage.honor.identifier.AdvertisingIdClient;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class m implements d {
    public final Context a;

    public m(Context context) {
        this.a = context;
    }

    @Override // lk.repeackage.d
    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.a == null) {
            cVar.onOAIDGetError(ErrorCode.STATE_CALL_PARAM, new e("context is null !!!"));
            return;
        }
        if (a()) {
            cVar.a("honor sdk support get oaid");
        }
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a);
            if (advertisingIdInfo == null) {
                cVar.onOAIDGetError(ErrorCode.STATE_DEVICE_NOSUPPORT, new e("Honor Advertising identifier info is null"));
            } else {
                cVar.onOAIDGetComplete(advertisingIdInfo.id);
            }
        } catch (Exception e) {
            f.a(e);
            cVar.onOAIDGetError(ErrorCode.STATE_OCCUR_EXCEPTION, e);
        }
    }

    @Override // lk.repeackage.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        return AdvertisingIdClient.isAdvertisingIdAvailable(context);
    }
}
