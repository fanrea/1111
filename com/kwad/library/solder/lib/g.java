package com.kwad.library.solder.lib;

import android.content.Context;
import com.kwad.library.solder.lib.ext.PluginError;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class g extends com.kwad.library.solder.lib.a.a {
    public g(String str) {
        super(str);
    }

    @Override // com.kwad.library.solder.lib.a.a
    public void o(Context context, String str) throws PluginError.LoadError {
        new StringBuilder("start install plugin installPath: ").append(str);
        e(new File(str));
    }

    private static void e(File file) throws PluginError.LoadError {
        if (!file.exists()) {
            throw new PluginError.LoadError("Apk file not exist.", 4001);
        }
        if (file.getAbsolutePath().trim().startsWith("/data/")) {
            return;
        }
        new StringBuilder("Apk file seems to locate in external path (not executable), path = ").append(file.getAbsolutePath());
    }
}
