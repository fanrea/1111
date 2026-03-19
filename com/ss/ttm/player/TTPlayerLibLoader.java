package com.ss.ttm.player;

import android.util.Log;
import com.ss.ttffmpeg.BuildConfig;
import com.ss.ttm.vcshared.VCBaseKitLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TTPlayerLibLoader {
    private static final int DEGRADED_VERSION = 2925;
    private static final String TAG = "TTPlayerLibLoader";
    private static ILibraryLoader mDebugLibraryLoader;
    private static ILibraryLoader mLibraryLoader;
    private static ILibraryLoader mDefaultLibLoader = new DefaultLibraryLoader();
    private static boolean mLibraryLoaded = false;
    private static boolean IsErrored = false;
    private static String mErrorInfo = null;
    private static int mVersion = 0;
    private static String playerLibName = "";

    private static boolean loadPlayerlibrary(String str) {
        String playerLibraryPath;
        try {
            TTPlayerConfiger.setLibraryName("lib" + str + ".so");
            TTPlayerConfiger.checkDebugTTPlayerLib();
            playerLibraryPath = TTPlayerConfiger.getPlayerLibraryPath();
            if (playerLibraryPath != null && !new File(playerLibraryPath).exists()) {
                playerLibraryPath = null;
            }
            if (playerLibraryPath != null) {
                if (mDebugLibraryLoader != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(playerLibraryPath);
                    Log.d(TAG, "load library path = " + playerLibraryPath);
                    mDebugLibraryLoader.onLoadNativeLibs(arrayList);
                } else {
                    System.load(playerLibraryPath);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            mErrorInfo = "load path library error." + th.toString();
            playerLibraryPath = null;
        }
        if (playerLibraryPath == null) {
            try {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str);
                loadLibs(arrayList2, true);
                mErrorInfo = null;
            } catch (Throwable unused) {
                Log.e(TAG, "load lib failed name = " + str);
                return false;
            }
        }
        return true;
    }

    public static final synchronized void loadLibrary() {
        try {
            if (mVersion == 0) {
                mVersion = TTPlayerConfiger.getValue(13, 0) / 1000;
            }
            VCBaseKitLoader.loadLibrary();
            boolean z = mVersion == DEGRADED_VERSION;
            if (TTPlayerConfiger.getValue(3, false)) {
                if (!z) {
                    TTPlayerConfiger.getValue(30, false);
                    if (!TTPlayerConfiger.getValue(28, false)) {
                        loadPlayerlibrary("ttcrypto");
                        loadPlayerlibrary("ttboringssl");
                    }
                    loadPlayerlibrary("ByteVC1_dec");
                    loadPlayerlibrary(BuildConfig.FFMPEG_LIBNAME);
                }
                if (TTPlayerConfiger.getValue(29, false)) {
                    if (!loadPlayerlibrary("ttmplayerbeta")) {
                        IsErrored = loadPlayerlibrary("ttmplayer") ? false : true;
                    } else {
                        playerLibName = "ttmplayerbeta";
                    }
                } else if (!loadPlayerlibrary("ttmplayer")) {
                    IsErrored = true;
                }
                if (!IsErrored && playerLibName.isEmpty()) {
                    playerLibName = "ttmplayer";
                }
            } else {
                ArrayList arrayList = new ArrayList();
                if (!z) {
                    TTPlayerConfiger.getValue(30, false);
                    if (!TTPlayerConfiger.getValue(28, false)) {
                        arrayList.add("ttcrypto");
                        arrayList.add("ttboringssl");
                    }
                    arrayList.add("ByteVC1_dec");
                    arrayList.add(BuildConfig.FFMPEG_LIBNAME);
                }
                if (TTPlayerConfiger.getValue(29, false)) {
                    boolean z2 = !loadLibs(arrayList, false);
                    IsErrored = z2;
                    if (!z2) {
                        arrayList.clear();
                        arrayList.add("ttmplayerbeta");
                        boolean z3 = !loadLibs(arrayList, true);
                        IsErrored = z3;
                        if (!z3) {
                            playerLibName = "ttmplayerbeta";
                        } else {
                            arrayList.clear();
                            arrayList.add("ttmplayer");
                            IsErrored = loadLibs(arrayList, true) ? false : true;
                        }
                    }
                } else {
                    arrayList.add("ttmplayer");
                    IsErrored = loadLibs(arrayList, false) ? false : true;
                }
                if (!IsErrored && playerLibName.isEmpty()) {
                    playerLibName = "ttmplayer";
                }
            }
        } catch (Throwable th) {
            IsErrored = true;
            th.printStackTrace();
            mErrorInfo = "load default library error." + th.toString();
        }
    }

    public static boolean isError() {
        return IsErrored;
    }

    public static String getErrorInfo() {
        return mErrorInfo;
    }

    public static final void setLibraryLoader(ILibraryLoader iLibraryLoader) {
        mLibraryLoader = iLibraryLoader;
    }

    public static final void setDebugLibraryLoader(ILibraryLoader iLibraryLoader) {
        mDebugLibraryLoader = iLibraryLoader;
    }

    public static String getPlayerLibName() {
        return playerLibName;
    }

    private static boolean loadLibs(List<String> list, boolean z) {
        boolean z2 = mLibraryLoaded;
        if ((!z) && z2) {
            return z2;
        }
        ILibraryLoader iLibraryLoader = mLibraryLoader;
        if (iLibraryLoader != null) {
            try {
                mLibraryLoaded = iLibraryLoader.onLoadNativeLibs(list);
            } catch (Throwable th) {
                mErrorInfo = th.getMessage();
            }
        } else {
            mLibraryLoaded = mDefaultLibLoader.onLoadNativeLibs(list);
        }
        return mLibraryLoaded;
    }

    private static class DefaultLibraryLoader implements ILibraryLoader {
        private DefaultLibraryLoader() {
        }

        @Override // com.ss.ttm.player.ILibraryLoader
        public boolean onLoadNativeLibs(List<String> list) {
            for (String str : list) {
                try {
                    System.loadLibrary(str);
                    Log.d(TTPlayerLibLoader.TAG, "load " + str + " done");
                } catch (Throwable th) {
                    String unused = TTPlayerLibLoader.mErrorInfo = th.getMessage();
                    Log.d(TTPlayerLibLoader.TAG, "load lib failed = " + str + ",error:" + TTPlayerLibLoader.mErrorInfo);
                    return false;
                }
            }
            return true;
        }
    }
}
