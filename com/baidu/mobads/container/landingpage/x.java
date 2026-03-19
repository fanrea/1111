package com.baidu.mobads.container.landingpage;

import android.view.View;
import android.widget.RelativeLayout;
import com.component.a.g.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class x extends d.c {
    final /* synthetic */ App2Activity a;

    x(App2Activity app2Activity) {
        this.a = app2Activity;
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str, String str2) {
        if (!"int".equals(this.a.mTmpExtraInfo.a) || !"int_lp_retain_view".equals(str2)) {
            if ("rsplash".equals(this.a.mTmpExtraInfo.a) && "splash_lp_retain_view".equals(str2)) {
                if (view instanceof com.component.a.d.c) {
                    this.a.mRetainDialogView = (RelativeLayout) view;
                    this.a.mRetainDialogView.setVisibility(4);
                }
            } else if ("rvideo_lp_retain_view".equals(str2) && (view instanceof com.component.a.d.c)) {
                this.a.mRetainDialogView = (RelativeLayout) view;
                this.a.mRetainDialogView.setVisibility(4);
            }
        } else if (view instanceof com.component.a.d.c) {
            this.a.mRetainDialogView = (RelativeLayout) view;
            this.a.mRetainDialogView.setVisibility(4);
        }
        super.a(view, str, str2);
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str) {
        if ("close".equals(str)) {
            this.a.runActivityExitAnimation();
        } else if ("dismiss".equals(str) && this.a.mRetainDialogView != null) {
            this.a.mRetainDialogView.setVisibility(4);
        }
        super.a(view, str);
    }
}
