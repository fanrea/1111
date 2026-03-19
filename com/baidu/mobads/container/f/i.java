package com.baidu.mobads.container.f;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.activity.PermissionDialogActivity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i extends com.component.a.g.b {
    final /* synthetic */ com.style.widget.e.f a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ boolean g;
    final /* synthetic */ b h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    i(b bVar, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar, com.style.widget.e.f fVar, String str, boolean z, String str2, String str3, String str4, boolean z2) {
        super(kVar, jVar);
        this.h = bVar;
        this.a = fVar;
        this.b = str;
        this.c = z;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = z2;
    }

    @Override // com.component.a.g.b
    protected void a(View view, boolean z, String str, com.component.a.f.d dVar) {
        if (this.a != null) {
            this.a.c();
        }
        this.h.a(view, dVar, this.b, this.c, z);
    }

    @Override // com.component.a.g.b
    protected void a(View view) {
        if (!TextUtils.isEmpty(this.d)) {
            this.h.a("privacyClick", this.b, "privacy_link", this.d);
        }
    }

    @Override // com.component.a.g.b
    protected void b(View view) {
        if (!TextUtils.isEmpty(this.e)) {
            this.h.a("functionClick", this.b, com.baidu.mobads.container.components.command.j.M, this.e);
        }
    }

    @Override // com.component.a.g.b
    protected void c(View view) {
        if (!TextUtils.isEmpty(this.f)) {
            this.h.a("permissionClick", this.b, PermissionDialogActivity.PERMISSION_URL, this.f);
        }
    }

    @Override // com.component.a.g.b
    protected void d(View view) {
        this.h.a("unionLogoClick", this.b, "unionUrl", com.baidu.mobads.container.adrequest.h.g);
    }

    @Override // com.component.a.g.b
    protected void a(View view, com.component.a.f.d dVar, String str) {
        if (TextUtils.equals("close", str)) {
            String strJ = dVar.j();
            if ("dislike_view".equals(strJ) && this.h.e(this.b)) {
                dVar.a(4);
                if (this.a != null) {
                    this.a.c();
                }
                this.h.a(view, dVar, this.b, this.c, this.g);
                return;
            }
            if (!"coupon_float_close_view".equals(strJ)) {
                this.h.b(this.b);
            }
        }
    }
}
