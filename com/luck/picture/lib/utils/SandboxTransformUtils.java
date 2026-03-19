package com.luck.picture.lib.utils;

import android.content.Context;
import android.net.Uri;
import com.luck.picture.lib.basic.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SandboxTransformUtils {
    public static String copyPathToSandbox(Context context, String str, String str2) {
        return copyPathToSandbox(context, str, str2, "");
    }

    public static String copyPathToSandbox(Context context, String str, String str2, String str3) {
        InputStream fileInputStream;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (PictureMimeType.isHasHttp(str)) {
            return null;
        }
        String strCreateFilePath = PictureFileUtils.createFilePath(context, str2, str3);
        if (PictureMimeType.isContent(str)) {
            fileInputStream = PictureContentResolver.openInputStream(context, Uri.parse(str));
        } else {
            fileInputStream = new FileInputStream(str);
        }
        if (PictureFileUtils.writeFileFromIS(fileInputStream, new FileOutputStream(strCreateFilePath))) {
            return strCreateFilePath;
        }
        return null;
    }
}
