package com.alliance.ssp.ad.g0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;
import java.util.Objects;

/* compiled from: VivoImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class p implements com.alliance.ssp.ad.f0.c {
    public final Context a;

    public p(Context context) {
        this.a = context;
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.alliance.ssp.ad.f0.d.a(com.alipay.sdk.m.p0.c.c, "0").equals("1");
    }

    @Override // com.alliance.ssp.ad.f0.c
    public void a(com.alliance.ssp.ad.f0.b bVar) {
        if (this.a == null || bVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.d));
                if (string != null && string.length() != 0) {
                    bVar.a(string);
                    cursorQuery.close();
                    return;
                }
                throw new YTOAIDException("OAID query failed");
            } finally {
            }
        } catch (Exception e) {
            bVar.a(e);
        }
    }
}
