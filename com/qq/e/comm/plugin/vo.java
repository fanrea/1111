package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Printer;
import com.qq.e.comm.plugin.uo;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class vo implements Printer {
    private final uo a;
    private final Printer b;

    public vo(uo uoVar, Printer printer) {
        this.a = uoVar;
        this.b = printer;
    }

    @Override // android.util.Printer
    public void println(String str) {
        Printer printer = this.b;
        if (printer != null) {
            printer.println(str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.charAt(0) == '>') {
            b();
        } else if (str.charAt(0) == '<') {
            a();
        }
    }

    public void b() {
        for (uo.d dVar : this.a.b()) {
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    public void a() {
        for (uo.d dVar : this.a.b()) {
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public Printer c() {
        return this.b;
    }
}
