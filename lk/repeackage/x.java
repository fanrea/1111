package lk.repeackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.lk.oaid.ErrorCode;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class x implements d {
    public final Context a;

    public x(Context context) {
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
            if (a()) {
                try {
                    Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                    try {
                        ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                        cVar.onOAIDGetComplete(cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.d)));
                        cursorQuery.close();
                        return;
                    } finally {
                    }
                } catch (Exception e) {
                    f.a(e);
                    cVar.onOAIDGetError(ErrorCode.STATE_OCCUR_EXCEPTION, e);
                    return;
                }
            }
            errorCode = ErrorCode.STATE_DEVICE_NOSUPPORT;
            eVar = new e("vivo device Unsupported");
        }
        cVar.onOAIDGetError(errorCode, eVar);
    }

    @Override // lk.repeackage.d
    public boolean a() {
        return g.a(com.alipay.sdk.m.p0.c.c, "0").equals("1");
    }
}
