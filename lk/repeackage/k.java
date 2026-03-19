package lk.repeackage;

import android.content.Context;
import com.lk.oaid.ErrorCode;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class k implements d {
    public final Context a;

    public k(Context context) {
        this.a = context;
    }

    @Override // lk.repeackage.d
    public void a(c cVar) {
        ErrorCode errorCode;
        e eVar;
        if (cVar == null) {
            return;
        }
        if (this.a == null) {
            errorCode = ErrorCode.STATE_CALL_PARAM;
            eVar = new e("context is null !!!");
        } else {
            errorCode = ErrorCode.STATE_MANUFACTURER_NOSUPPORT;
            eVar = new e("Manufacturer Unsupported");
        }
        cVar.onOAIDGetError(errorCode, eVar);
    }

    @Override // lk.repeackage.d
    public boolean a() {
        return false;
    }
}
