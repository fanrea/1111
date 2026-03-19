package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.gb;
import java.io.File;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class w3 {
    private static final String a = "w3";

    /* compiled from: A */
    interface b {
        void a(String str);

        void a(String str, int i);
    }

    static void a(h4 h4Var, String str, b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fb.a().a(new gb.b().d(str).a(gu.c(str)).a(gu.o()).d(true).c("Audio").a(f5.a(h4Var)).a(), new a(bVar, str));
    }

    /* compiled from: A */
    class a extends ez {
        final /* synthetic */ b a;
        final /* synthetic */ String b;

        a(b bVar, String str) {
            this.a = bVar;
            this.b = str;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            String unused = w3.a;
            this.a.a(w3.a(this.b));
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            String unused = w3.a;
            dbVar.a();
            dbVar.b();
            this.a.a(this.b, dbVar.a());
        }
    }

    static String a(String str) {
        File fileC = f40.c(str);
        if (fileC != null) {
            return fileC.getAbsolutePath();
        }
        return null;
    }
}
