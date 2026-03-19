package com.kwad.a;

import android.content.Context;
import android.os.Environment;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.tachikoma.t.h;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends TKBaseNativeModule {
    public c(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final String a(V8Object v8Object) {
        b bVar = (b) getNativeModule(v8Object);
        if (bVar == null) {
            return null;
        }
        return h.g(bVar.getFile());
    }

    public final boolean a(V8Object v8Object, String str, int i) {
        b bVar = (b) getNativeModule(v8Object);
        if (bVar == null) {
            return false;
        }
        return h.a(str, i, bVar.getFile());
    }

    public final void a(V8Object v8Object, V8Function v8Function) {
        final b bVar = (b) getNativeModule(v8Object);
        if (bVar == null || bVar.getFile() == null) {
            return;
        }
        new a<String>() { // from class: com.kwad.a.c.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.a.a
            /* renamed from: hF, reason: merged with bridge method [inline-methods] */
            public String hv() {
                return h.g(bVar.getFile());
            }
        }.a(v8Function);
    }

    public final void a(V8Object v8Object, final String str, final int i, V8Function v8Function) {
        final b bVar = (b) getNativeModule(v8Object);
        if (bVar == null || bVar.getFile() == null || !bVar.getFile().exists()) {
            return;
        }
        new a<Boolean>() { // from class: com.kwad.a.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.a.a
            /* renamed from: hy, reason: merged with bridge method [inline-methods] */
            public Boolean hv() {
                return Boolean.valueOf(h.a(str, i, bVar.getFile()));
            }
        }.a(v8Function);
    }

    public final String hz() {
        File externalFilesDir;
        Context context = getContext();
        if (context == null || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    public final String hA() {
        return hB();
    }

    public final String hB() {
        File filesDir;
        Context context = getContext();
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return null;
        }
        return filesDir.getAbsolutePath();
    }

    public final String hC() {
        File externalCacheDir;
        Context context = getContext();
        if (context == null) {
            return null;
        }
        try {
            if (com.component.c.c.a.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                externalCacheDir = context.getExternalCacheDir();
            } else {
                externalCacheDir = context.getCacheDir();
            }
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String hD() {
        File externalStorageDirectory;
        try {
            if (!OfflineHostProvider.getApi().canUseStorage() || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) {
                return null;
            }
            return externalStorageDirectory.getAbsolutePath();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String hE() {
        File dataDir;
        Context context = getContext();
        if (context == null || (dataDir = context.getDataDir()) == null) {
            return null;
        }
        return dataDir.getAbsolutePath();
    }
}
