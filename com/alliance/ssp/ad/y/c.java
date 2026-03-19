package com.alliance.ssp.ad.y;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.alliance.ssp.ad.o0.l;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMRewardVideoAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c extends Handler {
    public final /* synthetic */ com.alliance.ssp.ad.impl.reward.a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.alliance.ssp.ad.impl.reward.a aVar, Looper looper) {
        super(looper);
        this.a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        super.handleMessage(message);
        com.alliance.ssp.ad.impl.reward.a aVar = this.a;
        if (aVar.j) {
            NMRewardVideoActivity.v0 = aVar;
            Intent intent = new Intent(this.a.L0, (Class<?>) NMRewardVideoActivity.class);
            intent.putExtra("extra_name_land_page_ad_data", this.a.h.copy());
            this.a.L0.startActivity(intent);
            int i = l.a;
            return;
        }
        int i2 = aVar.R0 + 100;
        aVar.R0 = i2;
        if (i2 < 4300) {
            aVar.O0.sendEmptyMessageDelayed(0, 100L);
            return;
        }
        aVar.q("", "", aVar.h);
        this.a.u();
        this.a.a("素材加载超时", 100006, "1", "加载超时导致素材不可用");
        int i3 = l.a;
    }
}
