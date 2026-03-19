package com.alliance.ssp.ad.x;

import android.content.pm.PackageManager;
import android.view.View;
import com.alliance.ssp.ad.l.l;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMNativeFeedAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g implements View.OnClickListener {
    public final /* synthetic */ c a;

    public g(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            if (this.a.a("user", 0)) {
                this.a.E();
                l lVar = this.a.g1;
                if (lVar != null) {
                    lVar.b();
                }
            }
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 005: ")), e);
        }
    }
}
