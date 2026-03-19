package com.qq.e.comm.plugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class se extends te {
    private final File b;
    public String c;

    public se(File file, String str) throws IOException {
        super(new l10(new FileInputStream(file)));
        this.b = file;
        this.c = str;
    }

    @Override // com.qq.e.comm.plugin.te, com.qq.e.comm.plugin.jv, java.io.InputStream
    public void reset() throws IOException {
        this.a.close();
        this.a = new l10(new FileInputStream(this.b));
    }
}
