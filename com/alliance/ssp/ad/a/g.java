package com.alliance.ssp.ad.a;

import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.alliance.ssp.ad.l.d;
import com.alliance.ssp.ad.o0.l;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMRewardVideoActivity.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g implements d.c {
    public final /* synthetic */ NMRewardVideoActivity a;

    public g(NMRewardVideoActivity nMRewardVideoActivity) {
        this.a = nMRewardVideoActivity;
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void a(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        ((TextView) view).setHighlightColor(0);
        NMRewardVideoActivity nMRewardVideoActivity = this.a;
        NMRewardVideoActivity.a(nMRewardVideoActivity, nMRewardVideoActivity.J.getPermissionUrl());
        int i = l.a;
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void b(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        ((TextView) view).setHighlightColor(0);
        NMRewardVideoActivity nMRewardVideoActivity = this.a;
        NMRewardVideoActivity.a(nMRewardVideoActivity, nMRewardVideoActivity.J.getPrivacyUrl());
        int i = l.a;
    }

    @Override // com.alliance.ssp.ad.l.d.c
    public void c(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        ((TextView) view).setHighlightColor(0);
        NMRewardVideoActivity nMRewardVideoActivity = this.a;
        NMRewardVideoActivity.a(nMRewardVideoActivity, nMRewardVideoActivity.J.getAppIntro());
        int i = l.a;
    }
}
