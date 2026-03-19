package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.component.c.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ApkUtil {
    private static final String TAG = "MOKU_Apk_Util=>";

    private enum MarketDirectory {
        XIAOMI_MARKET("com.xiaomi.market"),
        XIAOMI_GAME("com.xiaomi.gamecenter"),
        HUAWEI_MARKET("com.huawei.appmarket"),
        HUAWEI_GAMEBOX("com.huawei.gamebox"),
        OPPO_MARKET("com.oppo.market"),
        OPPO_HEYTAP_MARKET("com.heytap.market"),
        OPPO_GAMECENTER("com.nearme.gamecenter"),
        VIVO_MARKET("com.bbk.appstore"),
        VIVO_GAMECENTER("com.vivo.game"),
        NINE_GAME("cn.ninegame.gamemanager"),
        YINGYONGBAO("com.tencent.android.qqdownloader");

        private String directory;

        MarketDirectory(String str) {
            this.directory = str;
        }

        public String getDirectory() {
            return this.directory;
        }

        public static MarketDirectory fromDirectory(String str) {
            for (MarketDirectory marketDirectory : values()) {
                if (marketDirectory.directory.equalsIgnoreCase(str)) {
                    return marketDirectory;
                }
            }
            throw new IllegalStateException("Unexpected value: " + str);
        }
    }

    public static boolean isApkInMarketExists(Context context, String str, String str2) {
        List<String> listPackageNameFromFiles = packageNameFromFiles(context, filterContainsApk(new File(getApkRootDirectory(), MarketDirectory.fromDirectory(str).directory).getAbsolutePath()));
        if (listPackageNameFromFiles != null) {
            return listPackageNameFromFiles.contains(str2);
        }
        return false;
    }

    public static String getApkRootDirectory() {
        if (isExternalStorageAvailable()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return null;
    }

    public static List<String> getMarketDirectoryWithPackageNameList(String str) {
        String apkRootDirectory = getApkRootDirectory();
        MarketDirectory marketDirectoryFromDirectory = MarketDirectory.fromDirectory(str);
        ArrayList arrayList = new ArrayList();
        int i = AnonymousClass1.$SwitchMap$com$fendasz$moku$planet$utils$ApkUtil$MarketDirectory[marketDirectoryFromDirectory.ordinal()];
        if (i == 1 || i == 2) {
            arrayList.add(apkRootDirectory + "/Android/data");
            arrayList.add(apkRootDirectory + "/.BBKAppStore");
            arrayList.add(".VivoGame");
        } else {
            arrayList.add(apkRootDirectory);
        }
        return arrayList;
    }

    /* renamed from: com.fendasz.moku.planet.utils.ApkUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fendasz$moku$planet$utils$ApkUtil$MarketDirectory;

        static {
            int[] iArr = new int[MarketDirectory.values().length];
            $SwitchMap$com$fendasz$moku$planet$utils$ApkUtil$MarketDirectory = iArr;
            try {
                iArr[MarketDirectory.VIVO_MARKET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$utils$ApkUtil$MarketDirectory[MarketDirectory.VIVO_GAMECENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$utils$ApkUtil$MarketDirectory[MarketDirectory.OPPO_GAMECENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$utils$ApkUtil$MarketDirectory[MarketDirectory.OPPO_HEYTAP_MARKET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$utils$ApkUtil$MarketDirectory[MarketDirectory.OPPO_MARKET.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fendasz$moku$planet$utils$ApkUtil$MarketDirectory[MarketDirectory.YINGYONGBAO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static String getMarketDirectoryWithPackageName(String str) {
        String str2 = getApkRootDirectory() + "Android/data";
        MarketDirectory marketDirectoryFromDirectory = MarketDirectory.fromDirectory(str);
        String unused = marketDirectoryFromDirectory.directory;
        int i = AnonymousClass1.$SwitchMap$com$fendasz$moku$planet$utils$ApkUtil$MarketDirectory[marketDirectoryFromDirectory.ordinal()];
        new File(str2, marketDirectoryFromDirectory.directory);
        return str2;
    }

    public static boolean isQQPackageExists(String str, Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<String> listPackageNameFromFiles = packageNameFromFiles(context, findQQApkFiles());
        LogUtils.logD(TAG, "find qq package used time=>" + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (listPackageNameFromFiles == null || listPackageNameFromFiles.isEmpty()) {
            return false;
        }
        return listPackageNameFromFiles.contains(str);
    }

    public static boolean isWechatPackageExists(String str, Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<String> listPackageNameFromFiles = packageNameFromFiles(context, findWechatApkFiles());
        LogUtils.logD(TAG, "find wechat package used time=>" + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (listPackageNameFromFiles == null || listPackageNameFromFiles.isEmpty()) {
            return false;
        }
        return listPackageNameFromFiles.contains(str);
    }

    public static List<File> findQQApkFiles() {
        ArrayList arrayList = new ArrayList();
        if (isExternalStorageAvailable()) {
            List<File> listFilterContainsApk = filterContainsApk(new File(Environment.getExternalStorageDirectory(), "tencent").getAbsolutePath());
            if (!listFilterContainsApk.isEmpty()) {
                arrayList.addAll(listFilterContainsApk);
            }
        }
        List<File> listFilterContainsApk2 = filterContainsApk(new File(Environment.getExternalStorageDirectory(), "/Android/data/com.tencent.mobileqq/").getAbsolutePath());
        if (!listFilterContainsApk2.isEmpty()) {
            arrayList.addAll(listFilterContainsApk2);
        }
        return arrayList;
    }

    public static List<File> findWechatApkFiles() {
        ArrayList arrayList = new ArrayList();
        if (isExternalStorageAvailable()) {
            List<File> listFilterContainsApk = filterContainsApk(new File(Environment.getExternalStorageDirectory(), "Tencent").getAbsolutePath());
            if (listFilterContainsApk.isEmpty()) {
                arrayList.addAll(listFilterContainsApk);
            }
        }
        List<File> listFilterContainsApk2 = filterContainsApk(new File("/storage/emulated/0/Android/data/com.tencent.mm/").getAbsolutePath());
        if (!listFilterContainsApk2.isEmpty()) {
            arrayList.addAll(listFilterContainsApk2);
        }
        List<File> listFilterContainsApk3 = filterContainsApk(new File("/storage/emulated/0/Android/data/com.tencent.mtt/").getAbsolutePath());
        if (!listFilterContainsApk3.isEmpty()) {
            arrayList.addAll(listFilterContainsApk3);
        }
        return arrayList;
    }

    public static boolean isExternalStorageAvailable() {
        return c.a.equals(Environment.getExternalStorageState());
    }

    public static List<String> findApkFiles(String str) {
        ArrayList arrayList = new ArrayList();
        findApkFilesInDirectory(new File(str), arrayList);
        return arrayList;
    }

    private static void findApkFilesInDirectory(File file, List<String> list) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    findApkFilesInDirectory(file2, list);
                } else if (file2.isFile() && file2.getName().toLowerCase().contains(".apk")) {
                    list.add(file2.getAbsolutePath());
                }
            }
        }
    }

    public static List<String> allPackageNameFromApks(Context context) {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        String apkRootDirectory = getApkRootDirectory();
        if (apkRootDirectory == null) {
            return null;
        }
        List<String> listFindApkFiles = findApkFiles(apkRootDirectory);
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listFindApkFiles.iterator();
        while (it.hasNext()) {
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(it.next(), 0);
            if (packageArchiveInfo != null) {
                arrayList.add(packageArchiveInfo.packageName);
            }
        }
        LogUtils.logD(TAG, "find apk package name used time=>" + Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue() - lValueOf.longValue()));
        return arrayList;
    }

    public static List<String> packageNameFromFiles(Context context, List<File> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            String strPackageNameFromFile = packageNameFromFile(context, it.next());
            if (strPackageNameFromFile != null) {
                arrayList.add(strPackageNameFromFile);
            }
        }
        return arrayList;
    }

    public static String packageNameFromFile(Context context, File file) {
        PackageInfo packageArchiveInfo;
        LogUtils.logD(TAG, "packageNameFromFile_filepath=>" + file.getAbsolutePath());
        PackageManager packageManager = context.getPackageManager();
        if (file == null || !isApkFile(file) || (packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
            return null;
        }
        return packageArchiveInfo.packageName;
    }

    private static List<File> filterContainsApk(String str) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        file.setReadable(true, false);
        file.setWritable(true, false);
        file.setExecutable(true, false);
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                file2.setReadable(true, false);
                file2.setWritable(true, false);
                file2.setExecutable(true, false);
                if (file2.isDirectory()) {
                    arrayList.addAll(filterContainsApk(file2.getAbsolutePath()));
                } else if (file2.isFile() && file2.getName().toLowerCase().contains(".apk")) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static boolean isApkFile(File file) {
        String name = file.getName();
        return name.toLowerCase().endsWith(".apk") || name.toLowerCase().contains(".apk.1");
    }

    public static boolean isContainsApk(File file) {
        return file.getName().toLowerCase().contains(".apk");
    }
}
