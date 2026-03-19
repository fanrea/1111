package com.alliance.ssp.ad.a;

import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.alliance.ssp.ad.l.a;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;

/* compiled from: NMRewardVideoActivity.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class j extends Handler {
    public final /* synthetic */ NMRewardVideoActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(NMRewardVideoActivity nMRewardVideoActivity, Looper looper) {
        super(looper);
        this.a = nMRewardVideoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IllegalStateException, JSONException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        super.handleMessage(message);
        int i = message.what;
        if (i <= 0 || i > 100) {
            return;
        }
        NMRewardVideoActivity nMRewardVideoActivity = this.a;
        if (!nMRewardVideoActivity.t0) {
            nMRewardVideoActivity.U = 1;
            nMRewardVideoActivity.t0 = true;
        }
        NMRewardVideoActivity nMRewardVideoActivity2 = this.a;
        if (i == nMRewardVideoActivity2.u0) {
            return;
        }
        nMRewardVideoActivity2.u0 = i;
        a.b bVar = nMRewardVideoActivity2.p0;
        if (bVar != null) {
            bVar.a(i);
        }
        if (i == 100) {
            this.a.U = 2;
            com.alliance.ssp.ad.impl.reward.a aVar = NMRewardVideoActivity.v0;
            if (aVar != null) {
                aVar.c();
            }
        }
    }
}
