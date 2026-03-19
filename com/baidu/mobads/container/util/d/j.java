package com.baidu.mobads.container.util.d;

import android.view.View;
import android.widget.ImageView;
import com.baidu.mobads.container.util.d.d;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j extends d.f {
    final /* synthetic */ boolean a;
    final /* synthetic */ d.InterfaceC0136d b;
    final /* synthetic */ d.b c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    j(d.b bVar, boolean z, d.InterfaceC0136d interfaceC0136d) {
        super(null);
        this.c = bVar;
        this.a = z;
        this.b = interfaceC0136d;
    }

    @Override // com.baidu.mobads.container.util.d.d.f, com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, int i) {
        if (this.a) {
            this.b.a(str, str2, this.c.j, i);
        }
    }

    @Override // com.baidu.mobads.container.util.d.d.f, com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, c cVar) {
        this.b.a(str, str2, (View) this.c.j, cVar);
    }

    @Override // com.baidu.mobads.container.util.d.d.f, com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, Object obj) throws IOException {
        this.c.a(obj);
        this.b.a(str, str2, (View) this.c.j, (ImageView) this.b.b((d.InterfaceC0136d) obj));
    }
}
