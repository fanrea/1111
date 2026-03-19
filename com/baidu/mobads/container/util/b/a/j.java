package com.baidu.mobads.container.util.b.a;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.components.g.f;
import com.baidu.mobads.container.util.b.a.k;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j implements f.b {
    final /* synthetic */ b a;
    final /* synthetic */ String b;
    final /* synthetic */ k.a c;
    final /* synthetic */ String d;
    final /* synthetic */ i e;

    j(i iVar, b bVar, String str, k.a aVar, String str2) {
        this.e = iVar;
        this.a = bVar;
        this.b = str;
        this.c = aVar;
        this.d = str2;
    }

    @Override // com.baidu.mobads.container.components.g.f.b
    public void a(String str, com.baidu.mobads.container.components.g.k kVar) {
        long jB;
        InputStream inputStreamF = kVar.f();
        try {
            try {
                if (inputStreamF != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        jB = kVar.c();
                    } else {
                        jB = kVar.b();
                    }
                    this.a.j = TextUtils.equals(this.b, kVar.d()) ? "" : kVar.d();
                    this.c.a(this.d, this.b, jB);
                    this.c.a(this.d, this.b, new com.baidu.mobads.container.util.b.f<>(kVar.f(), jB));
                } else {
                    com.baidu.mobads.container.l.g.b().e("HttpClientInterceptor", "素材请求失败，无数据流");
                    this.c.a(this.d, this.b, com.baidu.mobads.container.util.d.c.c);
                }
            } catch (OutOfMemoryError e) {
                com.baidu.mobads.container.l.g.b().e("HttpClientInterceptor", "素材请求失败，OOM");
                this.c.a(this.d, this.b, com.baidu.mobads.container.util.d.c.b);
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b().e("HttpClientInterceptor", "素材请求失败，解析异常: " + th.getMessage());
                this.c.a(this.d, this.b, com.baidu.mobads.container.util.d.c.a);
            }
        } finally {
            kVar.a(inputStreamF);
        }
    }

    @Override // com.baidu.mobads.container.components.g.f.b
    public void a(String str, int i) {
        com.baidu.mobads.container.util.d.c cVarA;
        com.baidu.mobads.container.l.g.b().e("HttpClientInterceptor", "素材请求失败，onFail: " + str);
        if (i == 1) {
            cVarA = com.baidu.mobads.container.util.d.c.d;
        } else if (i == -1) {
            cVarA = com.baidu.mobads.container.util.d.c.a(i, "素材链接类型异常", str);
        } else {
            cVarA = com.baidu.mobads.container.util.d.c.a(i);
        }
        this.c.a(this.d, this.b, cVarA);
    }
}
