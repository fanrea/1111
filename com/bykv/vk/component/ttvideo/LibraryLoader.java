package com.bykv.vk.component.ttvideo;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.zw.an;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LibraryLoader {
    private static final String TAG = "LibraryLoader";
    private static Loader sLoader;

    public interface Loader {
        void loadLibrary(String str) throws Exception;

        void loadLibraryFromPath(String str) throws Exception;
    }

    public static void setupLibraryLoader(Loader loader) {
        sLoader = loader;
    }

    public static void loadLibrary(String str) throws Exception {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("Invalid library name.");
        }
        if (loader != null) {
            loader.loadLibrary(str);
        } else {
            an.d(str);
        }
    }

    public static void loadLibraryFromPath(String str) throws Exception {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("Invalid library name.");
        }
        File file = new File(str);
        if (!file.exists()) {
            throw new Exception("Not found library '" + str + "' file.");
        }
        if (loader != null) {
            file.getAbsolutePath();
            loader.loadLibraryFromPath(file.getAbsolutePath());
        } else {
            System.load(file.getAbsolutePath());
        }
    }
}
