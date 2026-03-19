package ca.da.da;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import ca.da.da.n;
import java.io.IOException;

/* compiled from: OaidVivoImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class q implements n {
    public static final b<Boolean> a = new a();

    /* compiled from: OaidVivoImpl.java */
    public static class a extends b<Boolean> {
        @Override // ca.da.da.b
        public Boolean a(Object[] objArr) {
            return Boolean.valueOf("1".equals(q.a(com.alipay.sdk.m.p0.c.c, "0")));
        }
    }

    public static boolean a() {
        return a.b(new Object[0]).booleanValue();
    }

    @Override // ca.da.da.n
    public boolean b(Context context) {
        return a.b(new Object[0]).booleanValue();
    }

    @Override // ca.da.da.n
    public n.a a(Context context) throws IOException {
        Cursor cursorQuery;
        n.a aVar = new n.a();
        Uri uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        String string = null;
        if (uri != null) {
            try {
                cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToNext()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.d));
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            ca.da.ca.ja.r.a("", th);
                            ca.da.ca.ja.t.a(cursorQuery);
                            aVar.a = string;
                            return aVar;
                        } finally {
                            ca.da.ca.ja.t.a(cursorQuery);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        }
        aVar.a = string;
        return aVar;
    }

    public static /* synthetic */ String a(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
