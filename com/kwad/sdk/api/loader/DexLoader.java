package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DexLoader {
    private static final String DEX_ROOT_DIR_NAME = "ksad_dex";
    private static final String TAG = "DexLoader";
    private static final String TARGET_DEX_NAME = "dexJar.jar";
    private static final String dexJarCheckFileName = "ksaddex_makejar.check";
    private static final String dexJarFileName = "ksad_data.jar";
    private static String sDexPathRoot;

    private static boolean isTargetDexFileExist(Context context) {
        return false;
    }

    public static ClassLoader initDex(Context context, ClassLoader classLoader) {
        q qVarVW = r.VW();
        if (qVarVW != null) {
            qVarVW.onInit(context);
        }
        Log.w(TAG, "initDex liteApi: " + qVarVW);
        DexLoadError dexLoadError = new DexLoadError();
        String strPrepareDexFile = prepareDexFile(context, dexLoadError);
        Log.w(TAG, "initDex after prepareDexFile error: " + dexLoadError);
        if (!dexLoadError.success()) {
            if (qVarVW != null) {
                Log.w(TAG, "initDex after prepareDexFile reportDexLoadError: ");
                qVarVW.reportDexLoadError(context, dexLoadError);
            }
            return null;
        }
        ClassLoader classLoaderCreateDexClassLoader = createDexClassLoader(context, classLoader, strPrepareDexFile, dexLoadError);
        Log.w(TAG, "initDex after createDexClassLoader error: " + dexLoadError);
        if (dexLoadError.success()) {
            return classLoaderCreateDexClassLoader;
        }
        Log.w(TAG, "initDex after createDexClassLoader reportDexLoadError: ");
        if (qVarVW != null) {
            qVarVW.reportDexLoadError(context, dexLoadError);
        }
        return null;
    }

    private static String prepareDexFile(Context context, DexLoadError dexLoadError) throws Throwable {
        Log.d(TAG, "prepareDexFile start");
        String targetDexFilePath = getTargetDexFilePath(context);
        String checkFile = readCheckFile(context);
        String strObtainCheckMd5 = obtainCheckMd5(checkFile);
        int iObtainVersionCode = obtainVersionCode(checkFile);
        Log.d(TAG, "prepareDexFile after read check md5: " + strObtainCheckMd5);
        if (checkLocal(context, strObtainCheckMd5, iObtainVersionCode)) {
            Log.d(TAG, "prepareDexFile checkLocal success");
            return targetDexFilePath;
        }
        File fileCopyAssetsToData = copyAssetsToData(context, dexJarFileName, dexLoadError);
        Log.d(TAG, "prepareDexFile copyAssetsToData done");
        if (fileCopyAssetsToData != null && fileCopyAssetsToData.exists()) {
            String fileMD5 = y.getFileMD5(fileCopyAssetsToData);
            if (Objects.equals(fileMD5, strObtainCheckMd5)) {
                targetDexFilePath = fileCopyAssetsToData.getAbsolutePath();
            } else {
                dexLoadError.setErrorCode(-4);
                dexLoadError.setErrorMsg("targetMd5:" + fileMD5 + ", assetJarFileMd5:" + strObtainCheckMd5);
            }
        }
        Log.d(TAG, "prepareDexFile end with: " + targetDexFilePath);
        return targetDexFilePath;
    }

    private static String obtainCheckMd5(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return null;
        }
        return strArrSplit[0];
    }

    private static int obtainVersionCode(String str) {
        if (str == null) {
            return -1;
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 0) {
            return -1;
        }
        int length = strArrSplit.length;
        for (int i = 0; i < length; i++) {
            String str2 = strArrSplit[i];
            if (str2.startsWith("versionCode:")) {
                try {
                    return Integer.parseInt(str2.replace("versionCode:", "").trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }

    private static boolean checkLocal(Context context, String str, int i) {
        Log.d(TAG, "checkLocal start assetCheckFileMd5: " + str + ", assetCheckVersionCode: " + i);
        if (i != 4063001) {
            return false;
        }
        File file = new File(getTargetDexFilePath(context));
        return file.exists() && Objects.equals(y.getFileMD5(file), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.Closeable, java.io.InputStream] */
    private static String readCheckFile(Context context) throws Throwable {
        Closeable closeable;
        Throwable th;
        BufferedReader bufferedReader;
        ?? assets = context.getAssets();
        try {
            try {
                assets = assets.open(dexJarCheckFileName);
                try {
                    StringBuilder sb = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader((InputStream) assets, "UTF-8"));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                sb.append(line).append("\n");
                            } else {
                                String strTrim = sb.toString().trim();
                                closeQuietly(assets);
                                closeQuietly(bufferedReader);
                                return strTrim;
                            }
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                            closeQuietly(assets);
                            closeQuietly(bufferedReader);
                            return null;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    closeable = null;
                    th = th2;
                    closeQuietly(assets);
                    closeQuietly(closeable);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                assets = 0;
                bufferedReader = null;
            } catch (Throwable th3) {
                closeable = null;
                th = th3;
                assets = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static File copyAssetsToData(Context context, String str, DexLoadError dexLoadError) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpen;
        File file;
        InputStream inputStream = null;
        try {
            AssetManager assets = context.getAssets();
            File file2 = new File(getDexRootPath(context));
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(getTargetDexFilePath(context));
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            inputStreamOpen = assets.open(str);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                inputStream = inputStreamOpen;
                closeQuietly(inputStream);
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStreamOpen = null;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            closeQuietly(inputStream);
            closeQuietly(fileOutputStream);
            throw th;
        }
        try {
            try {
                int iA = p.a(getTargetDexFilePath(context), inputStreamOpen, p.bn(context));
                if (iA != 1 && dexLoadError != null) {
                    dexLoadError.setErrorCode(iA);
                }
                fileOutputStream.flush();
                file.setReadable(true);
                file.setWritable(false);
                closeQuietly(inputStreamOpen);
                closeQuietly(fileOutputStream);
                return file;
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStreamOpen;
                closeQuietly(inputStream);
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            if (dexLoadError != null) {
                dexLoadError.setErrorCode(-3);
                dexLoadError.setErrorMsg(e.getMessage());
            }
            closeQuietly(inputStreamOpen);
            closeQuietly(fileOutputStream);
            return null;
        }
    }

    private static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    private static String getDexRootPath(Context context) {
        String str = sDexPathRoot;
        return str != null ? str : context.getApplicationInfo().dataDir + File.separator + DEX_ROOT_DIR_NAME;
    }

    public static String getTargetDexFilePath(Context context) {
        return getDexRootPath(context) + File.separator + TARGET_DEX_NAME;
    }

    private static ClassLoader createDexClassLoader(Context context, ClassLoader classLoader, String str, DexLoadError dexLoadError) {
        try {
            String strB = z.b(classLoader);
            Log.w(TAG, "createDexClassLoader parent classLoader is: " + classLoader + ", defaultLibPaths is:  " + strB);
            ClassLoader classLoaderA = g.a(context, classLoader, str, context.getCacheDir().getAbsolutePath(), strB);
            Log.w(TAG, "createDexClassLoader KsAdSDKImpl class is: " + classLoaderA.loadClass("com.kwad.sdk.KsAdSDKImpl"));
            return classLoaderA;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            if (dexLoadError == null) {
                return null;
            }
            dexLoadError.setErrorMsg(e.getMessage());
            dexLoadError.setErrorCode(-1);
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            if (dexLoadError == null) {
                return null;
            }
            dexLoadError.setErrorMsg(th.getMessage());
            dexLoadError.setErrorCode(-2);
            return null;
        }
    }

    private static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
