package com.kwad.a;

import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends TKBaseNativeModule {
    private File AB;

    public b(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        if (nativeModuleInitParams.args == null || nativeModuleInitParams.args.length <= 0) {
            return;
        }
        Object obj = nativeModuleInitParams.args[0];
        if (obj instanceof String) {
            this.AB = new File((String) obj);
        }
    }

    public final boolean canRead() {
        File file = this.AB;
        if (file != null) {
            return file.canRead();
        }
        return false;
    }

    public final boolean canWrite() {
        File file = this.AB;
        if (file != null) {
            return file.canWrite();
        }
        return false;
    }

    public final boolean isDirectory() {
        File file = this.AB;
        if (file != null) {
            return file.isDirectory();
        }
        return false;
    }

    public final boolean isFile() {
        File file = this.AB;
        if (file != null) {
            return file.isFile();
        }
        return false;
    }

    public final boolean exists() {
        File file = this.AB;
        if (file != null) {
            return file.exists();
        }
        return false;
    }

    public final boolean canExecute() {
        File file = this.AB;
        if (file != null) {
            return file.canExecute();
        }
        return false;
    }

    public final long lastModified() {
        File file = this.AB;
        if (file != null) {
            return file.lastModified();
        }
        return 0L;
    }

    public final long length() {
        File file = this.AB;
        if (file != null) {
            return file.length();
        }
        return 0L;
    }

    public final boolean hw() {
        File file = this.AB;
        if (file == null) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            com.kwad.tachikoma.e.log().printStackTraceOnly(e);
            return false;
        }
    }

    public final boolean delete() {
        File file = this.AB;
        if (file != null) {
            return file.delete();
        }
        return false;
    }

    public final void b(V8Function v8Function) {
        new a<Boolean>() { // from class: com.kwad.a.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.a.a
            /* renamed from: hy, reason: merged with bridge method [inline-methods] */
            public Boolean hv() {
                if (b.this.AB != null) {
                    return Boolean.valueOf(b.this.AB.delete());
                }
                return Boolean.FALSE;
            }
        }.a(v8Function);
    }

    public final boolean mkdir() {
        File file = this.AB;
        if (file != null) {
            return file.mkdir();
        }
        return false;
    }

    public final boolean mkdirs() {
        File file = this.AB;
        if (file != null) {
            return file.mkdirs();
        }
        return false;
    }

    public final void c(V8Function v8Function) {
        new a<Boolean>() { // from class: com.kwad.a.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.a.a
            /* renamed from: hy, reason: merged with bridge method [inline-methods] */
            public Boolean hv() {
                if (b.this.AB != null) {
                    return Boolean.valueOf(b.this.AB.mkdir());
                }
                return Boolean.FALSE;
            }
        }.a(v8Function);
    }

    public final void d(V8Function v8Function) {
        new a<Boolean>() { // from class: com.kwad.a.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.a.a
            /* renamed from: hy, reason: merged with bridge method [inline-methods] */
            public Boolean hv() {
                if (b.this.AB != null) {
                    return Boolean.valueOf(b.this.AB.mkdirs());
                }
                return Boolean.FALSE;
            }
        }.a(v8Function);
    }

    public final V8Array hx() {
        File file = this.AB;
        if (file == null) {
            return null;
        }
        String[] list = file.list();
        V8Array v8Array = new V8Array(getJsObj().getRuntime());
        for (String str : list) {
            v8Array.push(str);
        }
        return v8Array;
    }

    public final File getFile() {
        return this.AB;
    }
}
