package ms.bz.bd.c.Pgl;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
final class f1 implements FilenameFilter {
    final /* synthetic */ String d;

    f1(String str) {
        this.d = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.d);
    }
}
