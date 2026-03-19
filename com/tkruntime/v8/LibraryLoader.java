package com.tkruntime.v8;

import com.kwad.tachikoma.TkOfflineCompoImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
class LibraryLoader {
    private static final String[] sAndroidNativeLibraries = {TkOfflineCompoImpl.SO_TK_V8, "kwai-j2v8"};
    private static final String[] sAndroidNativeLiteLibraries = {TkOfflineCompoImpl.SO_TK_V8_LITE, "kwai-j2v8-lite"};
    private static final NativeLibraryLoader sAndroidNativeLibraryLoader = new NativeLibraryLoader() { // from class: com.tkruntime.v8.LibraryLoader.1
        private void loadLibraries(String[] strArr) {
            for (String str : strArr) {
                System.loadLibrary(str);
            }
        }

        @Override // com.tkruntime.v8.NativeLibraryLoader
        public final void loadLibraries() {
            try {
                loadLibraries(LibraryLoader.sAndroidNativeLibraries);
            } catch (Throwable unused) {
                loadLibraries(LibraryLoader.sAndroidNativeLiteLibraries);
            }
        }
    };

    LibraryLoader() {
    }

    private static void loadAndroidLibraries(NativeLibraryLoader nativeLibraryLoader) {
        if (nativeLibraryLoader != null) {
            nativeLibraryLoader.loadLibraries();
        } else {
            sAndroidNativeLibraryLoader.loadLibraries();
        }
    }

    static void loadLibrary(String str, NativeLibraryLoader nativeLibraryLoader) {
        loadAndroidLibraries(nativeLibraryLoader);
    }
}
