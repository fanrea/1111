package com.baidu.mobads.container.w.f;

import android.text.TextUtils;
import com.baidu.mobads.container.w.f.a;
import com.baidu.mobads.container.w.f.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b implements a.InterfaceC0140a {
    float a;
    float b;
    final /* synthetic */ d.C0141d c;

    b(d.C0141d c0141d) {
        this.c = c0141d;
    }

    @Override // com.baidu.mobads.container.w.f.a.InterfaceC0140a
    public void a(String str) {
        String str2;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!str.startsWith(a.g) && !str.startsWith(a.h)) {
                str2 = null;
            } else {
                str2 = str;
            }
            if (str2 != null) {
                float f = Integer.parseInt(str2.split(":")[1].trim().split(" kB")[0]) / 1024.0f;
                if (str.startsWith(a.g)) {
                    this.a = f;
                    this.c.a(f);
                } else if (str.startsWith(a.h)) {
                    this.b = f;
                    this.c.c(f);
                }
                if (this.a != 0.0f && this.b != 0.0f) {
                    this.c.b(1.0f - (this.b / this.a));
                }
            }
        } catch (Throwable th) {
        }
    }
}
