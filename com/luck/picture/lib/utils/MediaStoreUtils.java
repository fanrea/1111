package com.luck.picture.lib.utils;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.component.c.c;
import com.luck.picture.lib.config.SelectorConfig;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MediaStoreUtils {
    public static Uri createCameraOutImageUri(Context context, SelectorConfig selectorConfig) {
        String str;
        if (TextUtils.isEmpty(selectorConfig.outPutCameraImageFileName)) {
            str = "";
        } else {
            str = selectorConfig.isOnlyCamera ? selectorConfig.outPutCameraImageFileName : System.currentTimeMillis() + Config.replace + selectorConfig.outPutCameraImageFileName;
        }
        if (SdkVersionUtils.isQ() && TextUtils.isEmpty(selectorConfig.outPutCameraDir)) {
            Uri uriCreateImageUri = createImageUri(context, str, selectorConfig.cameraImageFormatForQ);
            selectorConfig.cameraPath = uriCreateImageUri != null ? uriCreateImageUri.toString() : "";
            return uriCreateImageUri;
        }
        File fileCreateCameraFile = PictureFileUtils.createCameraFile(context, 1, str, selectorConfig.cameraImageFormat, selectorConfig.outPutCameraDir);
        selectorConfig.cameraPath = fileCreateCameraFile.getAbsolutePath();
        return PictureFileUtils.parUri(context, fileCreateCameraFile);
    }

    public static Uri createCameraOutVideoUri(Context context, SelectorConfig selectorConfig) {
        String str;
        if (TextUtils.isEmpty(selectorConfig.outPutCameraVideoFileName)) {
            str = "";
        } else {
            str = selectorConfig.isOnlyCamera ? selectorConfig.outPutCameraVideoFileName : System.currentTimeMillis() + Config.replace + selectorConfig.outPutCameraVideoFileName;
        }
        if (SdkVersionUtils.isQ() && TextUtils.isEmpty(selectorConfig.outPutCameraDir)) {
            Uri uriCreateVideoUri = createVideoUri(context, str, selectorConfig.cameraVideoFormatForQ);
            selectorConfig.cameraPath = uriCreateVideoUri != null ? uriCreateVideoUri.toString() : "";
            return uriCreateVideoUri;
        }
        File fileCreateCameraFile = PictureFileUtils.createCameraFile(context, 2, str, selectorConfig.cameraVideoFormat, selectorConfig.outPutCameraDir);
        selectorConfig.cameraPath = fileCreateCameraFile.getAbsolutePath();
        return PictureFileUtils.parUri(context, fileCreateCameraFile);
    }

    public static Uri createImageUri(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        ContentValues contentValuesBuildImageContentValues = buildImageContentValues(str, str2);
        if (externalStorageState.equals(c.a)) {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValuesBuildImageContentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, contentValuesBuildImageContentValues);
        }
        return uriArr[0];
    }

    public static ContentValues buildImageContentValues(String str, String str2) {
        String string = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str) || str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith("video")) {
            str2 = "image/jpeg";
        }
        contentValues.put("mime_type", str2);
        if (SdkVersionUtils.isQ()) {
            contentValues.put("datetaken", string);
            contentValues.put("relative_path", "DCIM/Camera");
        }
        return contentValues;
    }

    public static Uri createVideoUri(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        ContentValues contentValuesBuildVideoContentValues = buildVideoContentValues(str, str2);
        if (externalStorageState.equals(c.a)) {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValuesBuildVideoContentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Video.Media.INTERNAL_CONTENT_URI, contentValuesBuildVideoContentValues);
        }
        return uriArr[0];
    }

    public static ContentValues buildVideoContentValues(String str, String str2) {
        String string = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str) || str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("VID_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith("image")) {
            str2 = "video/mp4";
        }
        contentValues.put("mime_type", str2);
        if (SdkVersionUtils.isQ()) {
            contentValues.put("datetaken", string);
            contentValues.put("relative_path", Environment.DIRECTORY_MOVIES);
        }
        return contentValues;
    }
}
