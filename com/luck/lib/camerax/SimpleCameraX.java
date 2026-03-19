package com.luck.lib.camerax;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.luck.lib.camerax.listener.OnSimpleXPermissionDeniedListener;
import com.luck.lib.camerax.listener.OnSimpleXPermissionDescriptionListener;
import com.luck.lib.camerax.utils.FileUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SimpleCameraX {
    public static final String EXTRA_AUTO_ROTATION = "com.luck.lib.camerax.isAutoRotation";
    public static final String EXTRA_CAMERA_AROUND_STATE = "com.luck.lib.camerax.CameraAroundState";
    public static final String EXTRA_CAMERA_FILE_NAME = "com.luck.lib.camerax.CameraFileName";
    public static final String EXTRA_CAMERA_IMAGE_FORMAT = "com.luck.lib.camerax.CameraImageFormat";
    public static final String EXTRA_CAMERA_IMAGE_FORMAT_FOR_Q = "com.luck.lib.camerax.CameraImageFormatForQ";
    public static final String EXTRA_CAMERA_MODE = "com.luck.lib.camerax.CameraMode";
    public static final String EXTRA_CAMERA_VIDEO_FORMAT = "com.luck.lib.camerax.CameraVideoFormat";
    public static final String EXTRA_CAMERA_VIDEO_FORMAT_FOR_Q = "com.luck.lib.camerax.CameraVideoFormatForQ";
    public static final String EXTRA_CAPTURE_LOADING_COLOR = "com.luck.lib.camerax.CaptureLoadingColor";
    public static final String EXTRA_DISPLAY_RECORD_CHANGE_TIME = "com.luck.lib.camerax.DisplayRecordChangeTime";
    public static final String EXTRA_MANUAL_FOCUS = "com.luck.lib.camerax.isManualFocus";
    public static final String EXTRA_OUTPUT_PATH_DIR = "com.luck.lib.camerax.OutputPathDir";
    private static final String EXTRA_PREFIX = "com.luck.lib.camerax";
    public static final String EXTRA_RECORD_VIDEO_MAX_SECOND = "com.luck.lib.camerax.RecordVideoMaxSecond";
    public static final String EXTRA_RECORD_VIDEO_MIN_SECOND = "com.luck.lib.camerax.RecordVideoMinSecond";
    public static final String EXTRA_VIDEO_BIT_RATE = "com.luck.lib.camerax.VideoBitRate";
    public static final String EXTRA_VIDEO_FRAME_RATE = "com.luck.lib.camerax.VideoFrameRate";
    public static final String EXTRA_ZOOM_PREVIEW = "com.luck.lib.camerax.isZoomPreview";
    private final Intent mCameraIntent = new Intent();
    private final Bundle mCameraBundle = new Bundle();

    public static SimpleCameraX of() {
        return new SimpleCameraX();
    }

    private SimpleCameraX() {
    }

    public void start(Activity activity, int i) {
        if (CustomCameraConfig.imageEngine == null) {
            throw new NullPointerException("Missing ImageEngine,please implement SimpleCamerax.setImageEngine");
        }
        activity.startActivityForResult(getIntent(activity), i);
    }

    public void start(Context context, Fragment fragment, int i) {
        if (CustomCameraConfig.imageEngine == null) {
            throw new NullPointerException("Missing ImageEngine,please implement SimpleCamerax.setImageEngine");
        }
        fragment.startActivityForResult(getIntent(context), i);
    }

    public Intent getIntent(Context context) {
        this.mCameraIntent.setClass(context, PictureCameraActivity.class);
        this.mCameraIntent.putExtras(this.mCameraBundle);
        return this.mCameraIntent;
    }

    public SimpleCameraX setImageEngine(CameraImageEngine cameraImageEngine) {
        CustomCameraConfig.imageEngine = cameraImageEngine;
        return this;
    }

    public SimpleCameraX setPermissionDescriptionListener(OnSimpleXPermissionDescriptionListener onSimpleXPermissionDescriptionListener) {
        CustomCameraConfig.explainListener = onSimpleXPermissionDescriptionListener;
        return this;
    }

    public SimpleCameraX setPermissionDeniedListener(OnSimpleXPermissionDeniedListener onSimpleXPermissionDeniedListener) {
        CustomCameraConfig.deniedListener = onSimpleXPermissionDeniedListener;
        return this;
    }

    public SimpleCameraX setCameraMode(int i) {
        this.mCameraBundle.putInt(EXTRA_CAMERA_MODE, i);
        return this;
    }

    public SimpleCameraX setVideoFrameRate(int i) {
        this.mCameraBundle.putInt(EXTRA_VIDEO_FRAME_RATE, i);
        return this;
    }

    public SimpleCameraX setVideoBitRate(int i) {
        this.mCameraBundle.putInt(EXTRA_VIDEO_BIT_RATE, i);
        return this;
    }

    public SimpleCameraX setCameraAroundState(boolean z) {
        this.mCameraBundle.putBoolean(EXTRA_CAMERA_AROUND_STATE, z);
        return this;
    }

    public SimpleCameraX setOutputPathDir(String str) {
        this.mCameraBundle.putString(EXTRA_OUTPUT_PATH_DIR, str);
        return this;
    }

    public SimpleCameraX setCameraOutputFileName(String str) {
        this.mCameraBundle.putString(EXTRA_CAMERA_FILE_NAME, str);
        return this;
    }

    public SimpleCameraX setRecordVideoMaxSecond(int i) {
        this.mCameraBundle.putInt(EXTRA_RECORD_VIDEO_MAX_SECOND, (i * 1000) + 500);
        return this;
    }

    public SimpleCameraX setRecordVideoMinSecond(int i) {
        this.mCameraBundle.putInt(EXTRA_RECORD_VIDEO_MIN_SECOND, i * 1000);
        return this;
    }

    public SimpleCameraX setCameraImageFormat(String str) {
        this.mCameraBundle.putString(EXTRA_CAMERA_IMAGE_FORMAT, str);
        return this;
    }

    public SimpleCameraX setCameraImageFormatForQ(String str) {
        this.mCameraBundle.putString(EXTRA_CAMERA_IMAGE_FORMAT_FOR_Q, str);
        return this;
    }

    public SimpleCameraX setCameraVideoFormat(String str) {
        this.mCameraBundle.putString(EXTRA_CAMERA_VIDEO_FORMAT, str);
        return this;
    }

    public SimpleCameraX setCameraVideoFormatForQ(String str) {
        this.mCameraBundle.putString(EXTRA_CAMERA_VIDEO_FORMAT_FOR_Q, str);
        return this;
    }

    public SimpleCameraX setCaptureLoadingColor(int i) {
        this.mCameraBundle.putInt(EXTRA_CAPTURE_LOADING_COLOR, i);
        return this;
    }

    public SimpleCameraX isDisplayRecordChangeTime(boolean z) {
        this.mCameraBundle.putBoolean(EXTRA_DISPLAY_RECORD_CHANGE_TIME, z);
        return this;
    }

    public SimpleCameraX isManualFocusCameraPreview(boolean z) {
        this.mCameraBundle.putBoolean(EXTRA_MANUAL_FOCUS, z);
        return this;
    }

    public SimpleCameraX isZoomCameraPreview(boolean z) {
        this.mCameraBundle.putBoolean(EXTRA_ZOOM_PREVIEW, z);
        return this;
    }

    public SimpleCameraX isAutoRotation(boolean z) {
        this.mCameraBundle.putBoolean(EXTRA_AUTO_ROTATION, z);
        return this;
    }

    public static void putOutputUri(Intent intent, Uri uri) {
        intent.putExtra("output", uri);
    }

    public static String getOutputPath(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("output");
        return uri == null ? "" : FileUtils.isContent(uri.toString()) ? uri.toString() : uri.getPath();
    }
}
