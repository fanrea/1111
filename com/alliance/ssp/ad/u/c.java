package com.alliance.ssp.ad.u;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMBannerAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c extends Handler {
    public final /* synthetic */ com.alliance.ssp.ad.impl.banner.a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.alliance.ssp.ad.impl.banner.a aVar, Looper looper) {
        super(looper);
        this.a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
        View view;
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        super.handleMessage(message);
        com.alliance.ssp.ad.impl.banner.a aVar = this.a;
        if (!aVar.j) {
            int i = aVar.c1 + 100;
            aVar.c1 = i;
            if (i < 3000) {
                aVar.e1.sendEmptyMessageDelayed(0, 100L);
                return;
            } else {
                aVar.u();
                this.a.a("素材加载超时", 100006, "1", "加载超时导致素材不可用");
                return;
            }
        }
        ViewGroup viewGroup = aVar.b1;
        if (viewGroup == null || aVar.h == null || (view = aVar.P0) == null || aVar.J0 == null || view.getParent() != null) {
            aVar.a("Show failure", 100006, "2", "container为空");
        } else {
            viewGroup.removeAllViews();
            viewGroup.addView(view);
        }
        this.a.v();
    }
}
