package lk.repeackage;

import android.content.Context;
import com.lk.oaid.ErrorCode;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class y implements d {
    public final Context a;
    public Class<?> b;
    public Object c;

    public y(Context context) throws ClassNotFoundException {
        this.a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            f.a(e);
        }
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
        Class<?> cls = this.b;
        if (cls == null || this.c == null) {
            cVar.onOAIDGetError(ErrorCode.STATE_DEVICE_NOSUPPORT, new e("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            cVar.onOAIDGetComplete((String) cls.getMethod("getOAID", Context.class).invoke(this.c, this.a));
        } catch (Exception e) {
            f.a(e);
            cVar.onOAIDGetError(ErrorCode.STATE_OCCUR_EXCEPTION, e);
        }
    }

    @Override // lk.repeackage.d
    public boolean a() {
        return this.c != null;
    }
}
