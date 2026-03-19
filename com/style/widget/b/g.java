package com.style.widget.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.component.a.i.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements n.a {
    final /* synthetic */ Context a;
    final /* synthetic */ e b;

    g(e eVar, Context context) {
        this.b = eVar;
        this.a = context;
    }

    @Override // com.component.a.i.n.a
    public void a(String str, com.component.a.f.e eVar) {
        if (eVar != null) {
            String strM = eVar.m("");
            if (!TextUtils.isEmpty(strM)) {
                if ("app_name".equals(strM)) {
                    this.b.a(eVar, this.b.m.b, "app_name");
                    return;
                }
                if (Config.INPUT_DEF_VERSION.equals(strM)) {
                    this.b.a(eVar, this.b.m.b, "app_info");
                    return;
                }
                if (com.baidu.mobads.container.components.command.j.I.equals(strM)) {
                    this.b.a(eVar, this.b.m.b, "app_info");
                    return;
                }
                if ("privacy".equals(strM)) {
                    this.b.a(eVar, this.b.m.b, "pri_info");
                    return;
                }
                if ("permission".equals(strM)) {
                    this.b.a(eVar, this.b.m.b, "pri_info");
                    return;
                }
                if ("dl_btn".equals(strM)) {
                    this.b.a(eVar, this.b.m.b, "dl_btn");
                    return;
                }
                if ("adaptive_dialog".equals(strM)) {
                    this.b.a(this.a, eVar);
                    this.b.a(eVar, this.b.m.b);
                } else if ("dialog_scroll".equals(strM)) {
                    this.b.a(eVar, this.b.m.b);
                } else if ("dl_cancel".equals(strM)) {
                    this.b.a(eVar);
                }
            }
        }
    }
}
