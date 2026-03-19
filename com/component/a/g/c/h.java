package com.component.a.g.c;

import android.text.TextUtils;
import com.component.interfaces.RemoteReflectInterface;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements com.baidu.mobads.container.components.command.b {
    final /* synthetic */ String a;
    final /* synthetic */ WeakReference b;
    final /* synthetic */ g c;

    h(g gVar, String str, WeakReference weakReference) {
        this.c = gVar;
        this.a = str;
        this.b = weakReference;
    }

    @Override // com.baidu.mobads.container.components.command.b
    public void a() {
        int downloadStatus = RemoteReflectInterface.getDownloadStatus(this.a);
        com.component.a.a.d dVar = (com.component.a.a.d) this.b.get();
        if (dVar == null) {
            return;
        }
        dVar.c(true);
        String str = "去看看";
        if (downloadStatus < 0) {
            dVar.f(dVar.b());
            if (!com.baidu.mobads.container.util.j.b(this.c.mAppContext, this.a)) {
                str = "立即下载";
            }
        } else if (downloadStatus < 101) {
            str = downloadStatus + "%";
            dVar.c(false);
            dVar.f(downloadStatus);
        } else if (downloadStatus == 101) {
            dVar.f(dVar.b());
            if (!com.baidu.mobads.container.util.j.b(this.c.mAppContext, this.a)) {
                str = "点击安装";
            }
        } else if (downloadStatus == 102) {
            str = "继续下载";
        } else if (downloadStatus != 104) {
            str = "";
        } else {
            dVar.f(dVar.b());
            str = "重新下载";
        }
        if (!TextUtils.isEmpty(str)) {
            dVar.a(str);
        }
        dVar.postInvalidate();
    }
}
