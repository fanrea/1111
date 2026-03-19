package com.sigmob.sdk.downloader.core.file;

import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e {
    private final c a = new c();

    public c a() {
        return this.a;
    }

    public d a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info, j store) {
        return new d(task, info, store);
    }

    public void a(d processOutputStream, f task) {
    }

    public void a(f task) throws IOException {
        File fileM = task.m();
        if (fileM != null && fileM.exists() && !fileM.delete()) {
            throw new IOException("Delete file failed!");
        }
    }

    public boolean b(f task) {
        if (!g.j().e().a()) {
            return false;
        }
        if (task.v() != null) {
            return task.v().booleanValue();
        }
        return true;
    }
}
