package com.luck.picture.lib.loader;

import android.content.Context;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.utils.SortUtils;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class SandboxFileLoader {
    public static LocalMediaFolder loadInAppSandboxFolderFile(Context context, String str) throws NoSuchAlgorithmException, IOException {
        ArrayList<LocalMedia> arrayListLoadInAppSandboxFile = loadInAppSandboxFile(context, str);
        if (arrayListLoadInAppSandboxFile == null || arrayListLoadInAppSandboxFile.size() <= 0) {
            return null;
        }
        SortUtils.sortLocalMediaAddedTime(arrayListLoadInAppSandboxFile);
        LocalMedia localMedia = arrayListLoadInAppSandboxFile.get(0);
        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
        localMediaFolder.setFolderName(localMedia.getParentFolderName());
        localMediaFolder.setFirstImagePath(localMedia.getPath());
        localMediaFolder.setFirstMimeType(localMedia.getMimeType());
        localMediaFolder.setBucketId(localMedia.getBucketId());
        localMediaFolder.setFolderTotalNum(arrayListLoadInAppSandboxFile.size());
        localMediaFolder.setData(arrayListLoadInAppSandboxFile);
        return localMediaFolder;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015b A[PHI: r17
  0x015b: PHI (r17v4 java.io.File[]) = (r17v3 java.io.File[]), (r17v3 java.io.File[]), (r17v3 java.io.File[]), (r17v5 java.io.File[]) binds: [B:77:0x0171, B:74:0x016a, B:68:0x0159, B:82:0x01b7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.luck.picture.lib.entity.LocalMedia> loadInAppSandboxFile(android.content.Context r24, java.lang.String r25) throws java.security.NoSuchAlgorithmException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.loader.SandboxFileLoader.loadInAppSandboxFile(android.content.Context, java.lang.String):java.util.ArrayList");
    }
}
