package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class q extends d {
    private static volatile q bFW;
    private o bFX;

    @Override // com.kwad.sdk.core.report.d
    protected final String abg() {
        return "ksad_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String getTag() {
        return "ReportActionDBManager";
    }

    private q(Context context) {
        super(new p(context, p.Pl));
        this.bFX = new i();
    }

    public static q bS(Context context) {
        if (bFW == null) {
            synchronized (q.class) {
                if (bFW == null) {
                    bFW = new q(context);
                }
            }
        }
        return bFW;
    }

    public final void a(o oVar) {
        this.bFX = oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public synchronized n f(Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Uu()) {
            return this.bFX.g(string2, string, false);
        }
        return this.bFX.g(string2, string, true);
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String[] abh() {
        return new String[]{"aLog", "actionId"};
    }
}
