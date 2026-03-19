package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.k0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class st extends k0 {
    private final long f;

    public st(InputStream inputStream, long j, File file, il ilVar) {
        super(inputStream, file, ilVar);
        this.f = j;
    }

    @Override // com.qq.e.comm.plugin.k0
    protected int a(FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = this.f;
        this.c.a(this.b.length());
        while (j > 0 && !this.e.get()) {
            try {
                int i = this.a.read(bArr, 0, (int) Math.min(j, 8192));
                if (i <= 0 || this.e.get()) {
                    break;
                }
                try {
                    fileOutputStream.write(bArr, 0, i);
                    this.c.a(this.b.length());
                    j -= i;
                } catch (IOException e) {
                    throw new k0.b(e);
                }
            } catch (IOException e2) {
                throw new k0.a(e2);
            }
        }
        if (j == 0) {
            return 0;
        }
        this.d = "NetworkErrInputStreamDoesNotSupportEnoughBytesAsExpected ";
        return 4194304;
    }

    @Override // com.qq.e.comm.plugin.k0
    public int a() {
        if (this.f <= 0) {
            return 0;
        }
        return super.a();
    }
}
