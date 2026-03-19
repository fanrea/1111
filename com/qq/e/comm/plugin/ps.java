package com.qq.e.comm.plugin;

import android.net.Uri;
import com.qq.e.comm.plugin.vg;

/* compiled from: A */
@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ps extends x0 {
    private final zk e;

    public ps(jm jmVar, zk zkVar) {
        super(jmVar);
        this.e = zkVar;
    }

    public zk a() {
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.bm
    public ih<String> a(String str) {
        return new ih<>(null);
    }

    @Override // com.qq.e.comm.plugin.bm
    public void b(String str) {
        a(new String[0]);
        try {
            Uri uri = Uri.parse(str);
            if (a30.b(uri)) {
                ug ugVarA = a(uri);
                if (ugVarA != null) {
                    c30 c30VarA = this.c.a(ugVarA.a());
                    if (c30VarA != null) {
                        c30VarA.a(this.a, ugVarA);
                    } else {
                        a(new vg(ugVarA, vg.a.HANDLER_NOT_FOUND_EXCEPTION, "handler not found."));
                    }
                } else {
                    String.format("ParseJSRequestReturn Null,reqUrl=%s", str);
                }
            }
        } catch (Throwable unused) {
            String.format("ExceptionWhileHandleJSRequest,reqUrl=%s", str);
        }
    }
}
