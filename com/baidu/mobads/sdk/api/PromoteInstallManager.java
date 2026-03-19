package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.aq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class PromoteInstallManager {
    private PromoteInstallListener promoteInstallListener;
    private aq promoteInstallProd;

    public interface PromoteInstallListener {
        void onFail(String str);

        void onSuccess();
    }

    public PromoteInstallManager(Context context, PromoteInstallListener promoteInstallListener) {
        this.promoteInstallListener = promoteInstallListener;
        if (context != null) {
            this.promoteInstallProd = aq.a(context, promoteInstallListener);
        } else if (promoteInstallListener != null) {
            promoteInstallListener.onFail("context为空 初始化失败");
        }
    }

    public boolean hasPromoteInstallApp() {
        aq aqVar = this.promoteInstallProd;
        if (aqVar != null && aqVar.b()) {
            return this.promoteInstallProd.a();
        }
        PromoteInstallListener promoteInstallListener = this.promoteInstallListener;
        if (promoteInstallListener == null) {
            return false;
        }
        promoteInstallListener.onFail("功能暂不可用，请联系商务同学");
        return false;
    }

    public void showPromoteInstallDialog() {
        aq aqVar = this.promoteInstallProd;
        if (aqVar != null && aqVar.b() && this.promoteInstallProd.c() == 0) {
            this.promoteInstallProd.a(true);
            return;
        }
        PromoteInstallListener promoteInstallListener = this.promoteInstallListener;
        if (promoteInstallListener != null) {
            promoteInstallListener.onFail("功能暂不可用，请联系商务同学");
        }
    }

    public IPromoteInstallAdInfo getPromoteInstallAdInfo() {
        aq aqVar = this.promoteInstallProd;
        if (aqVar != null && aqVar.b() && this.promoteInstallProd.c() == 1) {
            return this.promoteInstallProd.a(false);
        }
        PromoteInstallListener promoteInstallListener = this.promoteInstallListener;
        if (promoteInstallListener != null) {
            promoteInstallListener.onFail("功能暂不可用，请联系商务同学");
        }
        return null;
    }
}
