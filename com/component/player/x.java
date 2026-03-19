package com.component.player;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class x implements Runnable {
    final /* synthetic */ File a;
    final /* synthetic */ w b;

    x(w wVar, File file) {
        this.b = wVar;
        this.a = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        File[] fileArrListFiles = this.a.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                String name = file.getName();
                if (file.isFile() && name.endsWith(".v1.exo")) {
                    file.delete();
                }
            }
        }
    }
}
