package com.fendasz.moku.planet.utils;

import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.Build;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class StorageManagerUtils {
    private static final String TAG = "StorageManagerUtils";
    private static String[] units = {"B", "KB", "MB", "GB", "TB"};

    public static Map<String, String> getBlockSize(Context context) throws NoSuchMethodException, SecurityException {
        long totalSpace;
        long usableSpace;
        StorageManager storageManager;
        long jLongValue;
        Context context2 = context;
        HashMap map = new HashMap();
        StorageManager storageManager2 = (StorageManager) context2.getSystemService("storage");
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            try {
                StorageVolume[] storageVolumeArr = (StorageVolume[]) StorageManager.class.getDeclaredMethod("getVolumeList", new Class[0]).invoke(storageManager2, new Object[0]);
                if (storageVolumeArr != null) {
                    Method declaredMethod = null;
                    totalSpace = 0;
                    usableSpace = 0;
                    for (StorageVolume storageVolume : storageVolumeArr) {
                        if (declaredMethod == null) {
                            declaredMethod = storageVolume.getClass().getDeclaredMethod("getPathFile", new Class[0]);
                        }
                        File file = (File) declaredMethod.invoke(storageVolume, new Object[0]);
                        totalSpace += file.getTotalSpace();
                        usableSpace += file.getUsableSpace();
                    }
                } else {
                    totalSpace = 0;
                    usableSpace = 0;
                }
                map.put("totalSpace", getUnit(totalSpace, 1024.0f));
                map.put("freeSpace", getUnit(usableSpace, 1024.0f));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                long j = 0;
                long freeSpace = 0;
                for (Object obj : (List) StorageManager.class.getDeclaredMethod("getVolumes", new Class[0]).invoke(storageManager2, new Object[0])) {
                    if (obj.getClass().getField("type").getInt(obj) == 1) {
                        if (i >= 26) {
                            jLongValue = getTotalSize(context2, (String) obj.getClass().getDeclaredMethod("getFsUuid", new Class[0]).invoke(obj, new Object[0]));
                        } else {
                            jLongValue = i >= 25 ? ((Long) StorageManager.class.getMethod("getPrimaryStorageSize", new Class[0]).invoke(storageManager2, new Object[0])).longValue() : 0L;
                        }
                        storageManager = storageManager2;
                        if (((Boolean) obj.getClass().getDeclaredMethod("isMountedReadable", new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                            File file2 = (File) obj.getClass().getDeclaredMethod("getPath", new Class[0]).invoke(obj, new Object[0]);
                            if (jLongValue == 0) {
                                jLongValue = file2.getTotalSpace();
                            }
                            file2.getTotalSpace();
                            freeSpace += jLongValue - file2.getFreeSpace();
                            j += jLongValue;
                        }
                        context2 = context;
                        storageManager2 = storageManager;
                    } else {
                        storageManager = storageManager2;
                    }
                    context2 = context;
                    storageManager2 = storageManager;
                }
                map.put("totalSpace", getUnit(j, 1000.0f));
                map.put("freeSpace", getUnit(j - freeSpace, 1000.0f));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return map;
    }

    public static String getUnit(float f, float f2) {
        int i = 0;
        while (f > f2 && i < 4) {
            f /= f2;
            i++;
        }
        return String.format(Locale.CHINA, " %.2f %s ", Float.valueOf(f), units[i]);
    }

    public static long getTotalSize(Context context, String str) {
        UUID uuidFromString;
        try {
            if (str == null) {
                uuidFromString = StorageManager.UUID_DEFAULT;
            } else {
                uuidFromString = UUID.fromString(str);
            }
            return ((StorageStatsManager) context.getSystemService(StorageStatsManager.class)).getTotalBytes(uuidFromString);
        } catch (IOException | NoClassDefFoundError | NoSuchFieldError | NullPointerException e) {
            e.printStackTrace();
            return -1L;
        }
    }
}
