package aegon.chrome.base;

import aegon.chrome.base.task.AsyncTask;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class PathUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CACHE_DIRECTORY = 2;
    private static final int DATA_DIRECTORY = 0;
    private static final int NUM_DIRECTORIES = 3;
    private static final String TAG = "PathUtils";
    private static final int THUMBNAIL_DIRECTORY = 1;
    private static final String THUMBNAIL_DIRECTORY_NAME = "textures";
    private static String sCacheSubDirectory;
    private static String sDataDirectorySuffix;
    private static FutureTask<String[]> sDirPathFetchTask;
    private static final AtomicBoolean sInitializationStarted = new AtomicBoolean();

    private PathUtils() {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class Holder {
        private static final String[] DIRECTORY_PATHS = PathUtils.getOrComputeDirectoryPaths();

        private Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] getOrComputeDirectoryPaths() {
        try {
            if (sDirPathFetchTask.cancel(false)) {
                StrictModeContext strictModeContextAllowDiskWrites = StrictModeContext.allowDiskWrites();
                try {
                    String[] privateDataDirectorySuffixInternal = setPrivateDataDirectorySuffixInternal();
                    if (strictModeContextAllowDiskWrites != null) {
                        $closeResource(null, strictModeContextAllowDiskWrites);
                    }
                    return privateDataDirectorySuffixInternal;
                } finally {
                }
            } else {
                return sDirPathFetchTask.get();
            }
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) throws Exception {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private static void chmod(String str, int i) throws ErrnoException {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        try {
            Os.chmod(str, i);
        } catch (Exception unused) {
            Log.e(TAG, "Failed to set permissions for path \"" + str + "\"", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] setPrivateDataDirectorySuffixInternal() throws ErrnoException {
        String[] strArr = new String[3];
        Context applicationContext = ContextUtils.getApplicationContext();
        String path = applicationContext.getDir(sDataDirectorySuffix, 0).getPath();
        strArr[0] = path;
        chmod(path, 448);
        strArr[1] = applicationContext.getDir(THUMBNAIL_DIRECTORY_NAME, 0).getPath();
        if (applicationContext.getCacheDir() != null) {
            if (sCacheSubDirectory == null) {
                strArr[2] = applicationContext.getCacheDir().getPath();
            } else {
                strArr[2] = new File(applicationContext.getCacheDir(), sCacheSubDirectory).getPath();
            }
        }
        return strArr;
    }

    public static void setPrivateDataDirectorySuffix(String str, String str2) {
        if (sInitializationStarted.getAndSet(true)) {
            return;
        }
        sDataDirectorySuffix = str;
        sCacheSubDirectory = str2;
        sDirPathFetchTask = new FutureTask<>(PathUtils$$Lambda$1.instance);
        AsyncTask.THREAD_POOL_EXECUTOR.execute(sDirPathFetchTask);
    }

    public static void setPrivateDataDirectorySuffix(String str) {
        setPrivateDataDirectorySuffix(str, null);
    }

    private static String getDirectoryPath(int i) {
        return Holder.DIRECTORY_PATHS[i];
    }

    public static String getDataDirectory() {
        return getDirectoryPath(0);
    }

    public static String getCacheDirectory() {
        return getDirectoryPath(2);
    }

    public static String getThumbnailCacheDirectory() {
        return getDirectoryPath(1);
    }

    private static String getDownloadsDirectory() throws Exception {
        StrictModeContext strictModeContextAllowDiskReads = StrictModeContext.allowDiskReads();
        try {
            if (BuildInfo.isAtLeastQ()) {
                String str = getAllPrivateDownloadsDirectories()[0];
                if (strictModeContextAllowDiskReads != null) {
                    $closeResource(null, strictModeContextAllowDiskReads);
                }
                return str;
            }
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            if (strictModeContextAllowDiskReads != null) {
                $closeResource(null, strictModeContextAllowDiskReads);
            }
            return path;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (strictModeContextAllowDiskReads != null) {
                    $closeResource(th, strictModeContextAllowDiskReads);
                }
                throw th2;
            }
        }
    }

    public static String[] getAllPrivateDownloadsDirectories() throws Exception {
        File[] externalFilesDirs;
        if (Build.VERSION.SDK_INT >= 19) {
            StrictModeContext strictModeContextAllowDiskWrites = StrictModeContext.allowDiskWrites();
            try {
                externalFilesDirs = ContextUtils.getApplicationContext().getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);
                if (strictModeContextAllowDiskWrites != null) {
                    $closeResource(null, strictModeContextAllowDiskWrites);
                }
            } finally {
            }
        } else {
            externalFilesDirs = new File[]{Environment.getExternalStorageDirectory()};
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < externalFilesDirs.length; i++) {
            File file = externalFilesDirs[i];
            if (file != null && !TextUtils.isEmpty(file.getAbsolutePath())) {
                arrayList.add(externalFilesDirs[i].getAbsolutePath());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String getNativeLibraryDirectory() {
        ApplicationInfo applicationInfo = ContextUtils.getApplicationContext().getApplicationInfo();
        return ((applicationInfo.flags & 128) != 0 || (applicationInfo.flags & 1) == 0) ? applicationInfo.nativeLibraryDir : "/system/lib/";
    }

    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
}
