package com.luck.picture.lib.utils;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.component.c.c;
import com.luck.picture.lib.basic.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DownloadFileUtils {
    public static void saveLocalFile(final Context context, final String str, final String str2, final OnCallbackListener<String> onCallbackListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<String>() { // from class: com.luck.picture.lib.utils.DownloadFileUtils.1
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public String doInBackground() throws IOException {
                File file;
                Uri uriInsert;
                File file2;
                InputStream fileInputStream;
                File file3;
                try {
                    ContentValues contentValues = new ContentValues();
                    String string = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
                    if (PictureMimeType.isHasAudio(str2)) {
                        contentValues.put("_display_name", DateUtils.getCreateFileName("AUD_"));
                        contentValues.put("mime_type", (TextUtils.isEmpty(str2) || str2.startsWith("video") || str2.startsWith("image")) ? "audio/mpeg" : str2);
                        if (SdkVersionUtils.isQ()) {
                            contentValues.put("datetaken", string);
                            contentValues.put("relative_path", Environment.DIRECTORY_MUSIC);
                        } else {
                            if (TextUtils.equals(Environment.getExternalStorageState(), c.a)) {
                                file3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                            } else {
                                file3 = new File(FileDirMap.getFileDirPath(context, 3));
                            }
                            contentValues.put("_data", file3.getAbsolutePath() + File.separator + DateUtils.getCreateFileName("AUD_") + PictureMimeType.AMR);
                        }
                        uriInsert = context.getContentResolver().insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
                    } else if (PictureMimeType.isHasVideo(str2)) {
                        contentValues.put("_display_name", DateUtils.getCreateFileName("VID_"));
                        contentValues.put("mime_type", (TextUtils.isEmpty(str2) || str2.startsWith("audio") || str2.startsWith("image")) ? "video/mp4" : str2);
                        if (SdkVersionUtils.isQ()) {
                            contentValues.put("datetaken", string);
                            contentValues.put("relative_path", Environment.DIRECTORY_MOVIES);
                        } else {
                            if (TextUtils.equals(Environment.getExternalStorageState(), c.a)) {
                                file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
                            } else {
                                file2 = new File(FileDirMap.getFileDirPath(context, 2));
                            }
                            contentValues.put("_data", file2.getAbsolutePath() + File.separator + DateUtils.getCreateFileName("VID_") + ".mp4");
                        }
                        uriInsert = context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
                    } else {
                        contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
                        contentValues.put("mime_type", (TextUtils.isEmpty(str2) || str2.startsWith("audio") || str2.startsWith("video")) ? "image/jpeg" : str2);
                        if (SdkVersionUtils.isQ()) {
                            contentValues.put("datetaken", string);
                            contentValues.put("relative_path", "DCIM/Camera");
                        } else if (PictureMimeType.isHasGif(str2) || PictureMimeType.isUrlHasGif(str)) {
                            if (TextUtils.equals(Environment.getExternalStorageState(), c.a)) {
                                file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                            } else {
                                file = new File(FileDirMap.getFileDirPath(context, 1));
                            }
                            contentValues.put("_data", file.getAbsolutePath() + File.separator + DateUtils.getCreateFileName("IMG_") + PictureMimeType.GIF);
                        }
                        uriInsert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    }
                    if (uriInsert == null) {
                        return null;
                    }
                    if (PictureMimeType.isHasHttp(str)) {
                        fileInputStream = new URL(str).openStream();
                    } else if (PictureMimeType.isContent(str)) {
                        fileInputStream = PictureContentResolver.openInputStream(context, Uri.parse(str));
                    } else {
                        fileInputStream = new FileInputStream(str);
                    }
                    if (PictureFileUtils.writeFileFromIS(fileInputStream, PictureContentResolver.openOutputStream(context, uriInsert))) {
                        return PictureFileUtils.getPath(context, uriInsert);
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(String str3) {
                PictureThreadUtils.cancel(this);
                OnCallbackListener onCallbackListener2 = onCallbackListener;
                if (onCallbackListener2 != null) {
                    onCallbackListener2.onCall(str3);
                }
            }
        });
    }
}
