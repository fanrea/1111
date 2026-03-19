package com.baidu.mobads.container.y;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.baidu.mobads.container.util.b.a.b;
import com.baidu.mobads.container.util.d.d;
import com.baidu.mobads.container.util.o;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class h {
    private final String a;
    private final int b = 5242880;
    private Context c;

    public interface b {
        void a(String str, int i);

        void b(a aVar);
    }

    public h(Context context) {
        this.c = context.getApplicationContext();
        this.a = com.baidu.mobads.container.util.b.a.a(context).a("web_res");
    }

    public WebResourceResponse a(a aVar) {
        File file;
        if (aVar != null) {
            try {
                com.baidu.mobads.container.util.b.g gVarA = com.baidu.mobads.container.util.b.a.a(this.c).a(this.a, 5242880);
                if (gVarA != null) {
                    if (gVarA.a) {
                        com.baidu.mobads.container.util.b.f<File> fVarA = gVarA.a(aVar.a());
                        if (fVarA == null) {
                            file = null;
                        } else {
                            file = fVarA.b();
                        }
                    } else {
                        file = new File(gVarA.a() + aVar.a());
                    }
                    if (file != null && file.exists()) {
                        return new WebResourceResponse(aVar.b(), "utf-8", new FileInputStream(file));
                    }
                }
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
            }
        }
        return null;
    }

    public void a(String str, b bVar) {
        com.baidu.mobads.container.util.b.a.a(this.c).a(new b.a(str).a(d.e.CUSTOM).a(this.a).a(5242880L).b(false).a(), new i(this, bVar));
    }

    public static class a {
        private String a;
        private String b;
        private String c;

        public a(String str, String str2) {
            this.a = "";
            this.b = "";
            this.c = "";
            this.b = str2;
            this.c = str;
            this.a = a(str);
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.a;
        }

        public String c() {
            return this.c;
        }

        private String a(String str) {
            return o.n(str);
        }
    }
}
