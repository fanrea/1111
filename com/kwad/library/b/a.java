package com.kwad.library.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.library.b.a.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.h;
import com.kwad.sdk.utils.w;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends h {
    private b bhy;
    private Resources bhz;

    public a(String str) {
        super(str);
    }

    public final b Pe() {
        return this.bhy;
    }

    public final Resources getResources() {
        return this.bhz;
    }

    @Override // com.kwad.library.solder.lib.h, com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public final void o(Context context, String str) throws PluginError.LoadError {
        super.o(context, str);
        File file = new File(str);
        try {
            File fileD = d(file);
            try {
                if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                    file.setReadOnly();
                    fileD.setReadOnly();
                }
            } catch (Throwable unused) {
            }
            this.bhy = a(fileD, file);
            try {
                this.bhz = com.kwad.library.b.b.a.a(context, context.getResources(), str);
                new StringBuilder("Install plugin mClassLoader: ").append(this.bhy).append(", mResources: ").append(this.bhz);
            } catch (Exception e) {
                Log.getStackTraceString(e);
                throw new PluginError.LoadError(e, 4006);
            }
        } catch (IOException e2) {
            throw new PluginError.LoadError(e2, 4002);
        }
    }

    private File d(File file) throws IOException {
        File file2 = new File(file.getParentFile(), this.bhV.PL());
        w.ai(file2);
        return file2;
    }

    private b a(File file, File file2) {
        if (Build.VERSION.SDK_INT < 26) {
            if (!file.canRead()) {
                file.setReadable(true);
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            if (!file.canRead() || !file.canWrite()) {
                file = null;
            }
        }
        return new b(new com.kwad.library.b.a.a((BaseDexClassLoader) getClass().getClassLoader()), file2.getAbsolutePath(), file, this.bir.getAbsolutePath(), this.bix.bjl, this.bix.bjk);
    }
}
