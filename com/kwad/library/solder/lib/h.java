package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class h extends g {
    public h(String str) {
        super(str);
    }

    @Override // com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public void o(Context context, String str) {
        ClassLoader classLoader;
        super.o(context, str);
        new StringBuilder("start install so plugin so pluginId:").append(getId());
        File file = new File(str);
        try {
            this.bir = f(file);
            try {
                try {
                    c(a(context, file, this.bir));
                    if (this.bix != null && this.bix.bjm != null) {
                        classLoader = this.bix.bjm;
                    } else {
                        classLoader = getClass().getClassLoader();
                    }
                    synchronized (Runtime.getRuntime()) {
                        try {
                            com.kwad.library.solder.lib.ext.d.c(classLoader, this.bir);
                        } finally {
                            PluginError.LoadError loadError = new PluginError.LoadError(th, 4004);
                        }
                    }
                } catch (PluginError.LoadError e) {
                    w.ad(file);
                    throw e;
                }
            } catch (IOException th) {
                throw new PluginError.LoadError(th, i);
            }
        } catch (IOException e2) {
            throw new PluginError.LoadError(e2, 4003);
        }
    }

    private void c(Set<File> set) throws Throwable {
        if (this.bix == null || this.bix.bjj.size() <= 0 || set == null) {
            return;
        }
        for (Map.Entry<String, String> entry : this.bix.bjj.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(value)) {
                boolean z = false;
                Iterator<File> it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    File next = it.next();
                    String fileMD5Digest = al.getFileMD5Digest(next);
                    if (next.getName().equals(key)) {
                        z = true;
                        if (!TextUtils.equals(fileMD5Digest, value)) {
                            d(set);
                            throw new PluginError.LoadError(new Exception(next.getName() + " Md5 check error,find " + fileMD5Digest + ",except " + value), 4008);
                        }
                    }
                }
                if (!z) {
                    throw new PluginError.LoadError(new Exception(key + " not found"), 4001);
                }
            }
        }
    }

    private static void d(Set<File> set) {
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            w.ad(it.next());
        }
    }

    private File f(File file) throws IOException {
        File file2 = new File(file.getParentFile(), this.bhV.PM());
        w.ai(file2);
        return file2;
    }

    private Set<File> a(Context context, File file, File file2) throws IOException {
        String[] list;
        new StringBuilder("install plugin so libs, destDir = ").append(file2);
        HashSet hashSet = new HashSet();
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            for (String str : list) {
                hashSet.add(new File(file2.getAbsolutePath() + File.separator + str));
            }
            return hashSet;
        }
        File file3 = new File(file2.getParentFile(), this.bhV.PN());
        w.ai(file3);
        for (String str2 : com.kwad.library.solder.lib.d.c.b(file, file3)) {
            new StringBuilder("extractSoLib, soName = ").append(str2);
            File fileA = com.kwad.library.solder.lib.d.c.a(file3, str2, file2);
            if (fileA != null) {
                hashSet.add(fileA);
            }
        }
        w.ad(file3);
        return hashSet;
    }
}
