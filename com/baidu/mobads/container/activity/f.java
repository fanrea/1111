package com.baidu.mobads.container.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.component.interfaces.RemoteReflectInterface;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f extends com.component.a.g.b {
    final /* synthetic */ DownloadDialogActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f(DownloadDialogActivity downloadDialogActivity, Context context, com.baidu.mobads.container.adrequest.j jVar) {
        super(context, jVar);
        this.a = downloadDialogActivity;
    }

    @Override // com.component.a.g.b
    protected void a(View view, boolean z, String str, com.component.a.f.d dVar) {
        this.a.sendDownloadDialogLog("click_button_download");
        e.a().a(7);
        this.a.finishActivityWithAnim();
    }

    @Override // com.component.a.g.b
    protected void a(View view) {
        String adInfo = this.a.getAdInfo("privacy_link");
        if (!TextUtils.isEmpty(adInfo)) {
            this.a.sendDownloadDialogLog("click_button_privacy");
            Intent intent = new Intent();
            intent.putExtra("privacy_link", adInfo);
            e.a().a(5);
            com.baidu.mobads.container.util.h.a(this.a.activity, intent);
            this.a.registerLpCloseReceiver(this.a.activity, com.baidu.mobads.container.components.k.b.F);
        }
    }

    @Override // com.component.a.g.b
    protected void b(View view) {
        String adInfo = this.a.getAdInfo(com.baidu.mobads.container.components.command.j.M);
        if (!TextUtils.isEmpty(adInfo)) {
            this.a.sendDownloadDialogLog("click_button_function");
            Intent intent = new Intent();
            intent.putExtra("privacy_link", adInfo);
            e.a().a(8);
            com.baidu.mobads.container.util.h.a(this.a.activity, intent);
            this.a.registerLpCloseReceiver(this.a.activity, com.baidu.mobads.container.components.k.b.G);
        }
    }

    @Override // com.component.a.g.b
    protected void c(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String adInfo = this.a.getAdInfo(com.baidu.mobads.container.components.command.j.L);
        if (!TextUtils.isEmpty(adInfo)) {
            this.a.sendDownloadDialogLog("click_button_permission");
            com.style.widget.b.i iVarA = com.style.widget.b.i.a(this.a.activity, adInfo);
            iVarA.a(false);
            iVarA.a(new g(this));
            iVarA.a();
        }
    }

    @Override // com.component.a.g.b
    protected void a(View view, com.component.a.f.d dVar, String str) {
        if ("close".equals(str)) {
            if (this.a.needDlKeepDialog != 1 || this.a.adInfo == null || this.a.mDlKeepDialogEventListener == null || this.a.mApkLinkDialogShow) {
                if (this.a.needDlKeepDialog == 1 && this.a.mApkLinkDialogShow) {
                    this.a.sendWinUrl(404, "promoteDlDialogShow", 201);
                }
                this.a.sendDownloadDialogLog("click_button_close");
                this.a.finishActivityWithAnim();
                return;
            }
            com.baidu.mobads.container.util.h.a(new h(this));
            return;
        }
        if (this.a.mDownloadDialogView != null && this.a.mDownloadDialogView.c() && "cancel".equals(str)) {
            this.a.sendDownloadDialogLog("click_background_cancel");
            this.a.finishActivityWithAnim();
        } else if ("pausedownload".equals(str)) {
            RemoteReflectInterface.pauseDlByPk(this.a.adInfo.getAppPackageName(), 3);
            this.a.sendDownloadDialogLog("click_download_pause");
            this.a.finishActivityWithAnim();
        } else if ("dl_cancel".equals(str)) {
            this.a.sendDownloadDialogLog("click_dialog_download_cancel");
            com.baidu.mobads.container.components.e.f.a(this.v).c(this.a.adInfo.getAppPackageName());
            this.a.finishActivityWithAnim();
        }
    }
}
