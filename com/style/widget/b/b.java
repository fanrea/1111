package com.style.widget.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.component.interfaces.RemoteReflectInterface;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b extends com.component.a.g.b {
    final /* synthetic */ a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b(a aVar, Context context, com.baidu.mobads.container.adrequest.j jVar) {
        super(context, jVar);
        this.a = aVar;
    }

    @Override // com.component.a.g.b
    protected void a(View view, boolean z, String str, com.component.a.f.d dVar) {
        this.a.b("click_button_download");
        if (this.a.j != null) {
            this.a.j.l();
        }
        this.a.dismiss();
    }

    @Override // com.component.a.g.b
    protected void a(View view) {
        String strA = this.a.a("privacy_link");
        if (!TextUtils.isEmpty(strA)) {
            this.a.b("click_button_privacy");
            Intent intent = new Intent();
            intent.putExtra("privacy_link", strA);
            if (this.a.j != null) {
                this.a.j.h();
            }
            com.baidu.mobads.container.util.h.a(this.a.d, intent);
            this.a.a(this.a.d);
        }
    }

    @Override // com.component.a.g.b
    protected void c(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String strA = this.a.a(com.baidu.mobads.container.components.command.j.L);
        if (!TextUtils.isEmpty(strA)) {
            this.a.b("click_button_permission");
            i iVarA = i.a(this.a.d, strA);
            iVarA.a(this.a.l);
            iVarA.a(new c(this));
            iVarA.a();
        }
    }

    @Override // com.component.a.g.b
    protected void a(View view, com.component.a.f.d dVar, String str) {
        if ("close".equals(str)) {
            this.a.b("click_button_close");
            this.a.dismiss();
            return;
        }
        if (this.a.i != null && this.a.i.c() && "cancel".equals(str)) {
            this.a.b("click_background_cancel");
            this.a.dismiss();
        } else if ("pausedownload".equals(str)) {
            RemoteReflectInterface.pauseDlByPk(this.a.e.getAppPackageName(), 3);
            this.a.b("click_dialog_download_pause");
            this.a.dismiss();
        } else if ("dl_cancel".equals(str)) {
            this.a.b("click_dialog_download_cancel");
            com.baidu.mobads.container.components.e.f.a(this.v).c(this.a.e.getAppPackageName());
            this.a.dismiss();
        }
    }
}
