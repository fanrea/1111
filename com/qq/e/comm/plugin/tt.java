package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.k0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class tt extends k0 {
    public tt(InputStream inputStream, File file, il ilVar) {
        super(inputStream, file, ilVar);
    }

    @Override // com.qq.e.comm.plugin.k0
    protected int a(FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[8192];
        this.c.a(this.b.length());
        while (!this.e.get()) {
            try {
                int i = this.a.read(bArr);
                if (i <= 0 || this.e.get()) {
                    break;
                }
                try {
                    fileOutputStream.write(bArr, 0, i);
                    this.c.a(this.b.length());
                } catch (IOException e) {
                    throw new k0.b(e);
                }
            } catch (IOException e2) {
                throw new k0.a(e2);
            }
        }
        return 0;
    }
}
