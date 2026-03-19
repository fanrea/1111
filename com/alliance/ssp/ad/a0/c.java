package com.alliance.ssp.ad.a0;

import android.content.pm.PackageManager;
import android.view.View;
import com.alliance.ssp.ad.o0.n;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;

/* compiled from: NMStreamAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements View.OnAttachStateChangeListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ b b;

    public c(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.b.J0.c.onAdShow();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        b.a(this.b, this.a);
        i iVar = this.b.J0;
        if (iVar != null && iVar.c != null) {
            n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.a0.c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }
        this.b.B();
        b bVar = this.b;
        bVar.t("", "", bVar.O0);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b.a(this.b);
        this.b.E0.setChecked(false);
    }
}
