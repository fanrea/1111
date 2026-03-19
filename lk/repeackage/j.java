package lk.repeackage;

import android.app.KeyguardManager;
import android.content.Context;
import com.lk.oaid.ErrorCode;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class j implements d {
    public final Context a;
    public final KeyguardManager b;

    public j(Context context) {
        this.a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // lk.repeackage.d
    public void a(c cVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ErrorCode errorCode;
        e eVar;
        if (cVar == null) {
            return;
        }
        if (this.a == null) {
            errorCode = ErrorCode.STATE_CALL_PARAM;
            eVar = new e("context is null !!!");
        } else if (this.b == null) {
            errorCode = ErrorCode.STATE_GET_FAIL;
            eVar = new e("KeyguardManager not found");
        } else {
            if (a()) {
                try {
                    Object objInvoke = this.b.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
                    if (objInvoke == null) {
                        cVar.onOAIDGetError(ErrorCode.STATE_GET_FAIL, new e("OAID obtain failed"));
                        return;
                    }
                    String string = objInvoke.toString();
                    f.a("OAID obtain success: " + string);
                    cVar.onOAIDGetComplete(string);
                    return;
                } catch (Exception e) {
                    f.a(e);
                    cVar.onOAIDGetError(ErrorCode.STATE_OCCUR_EXCEPTION, e);
                    return;
                }
            }
            errorCode = ErrorCode.STATE_DEVICE_NOSUPPORT;
            eVar = new e("coosea device Unsupported");
        }
        cVar.onOAIDGetError(errorCode, eVar);
    }

    @Override // lk.repeackage.d
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            return ((Boolean) Objects.requireNonNull(keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]))).booleanValue();
        } catch (Exception e) {
            f.a(e);
            return false;
        }
    }
}
