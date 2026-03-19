package lkxssdk.v;

import android.view.View;
import com.lingku.xuanshang.tjlib.apploader.NonWifiWarnActivity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a implements View.OnClickListener {
    public final /* synthetic */ NonWifiWarnActivity a;

    public a(NonWifiWarnActivity nonWifiWarnActivity) {
        this.a = nonWifiWarnActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NonWifiWarnActivity nonWifiWarnActivity = this.a;
        int i = NonWifiWarnActivity.a;
        nonWifiWarnActivity.finish();
        nonWifiWarnActivity.overridePendingTransition(0, 0);
        lkxssdk.a.a.a(false);
    }
}
