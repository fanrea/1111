package com.luck.picture.lib.basic;

import android.content.Intent;
import android.os.Bundle;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface IPictureSelectorCommonEvent {
    boolean checkAddBitmapWatermark();

    boolean checkCompressValidity();

    boolean checkCropValidity();

    @Deprecated
    boolean checkOldCompressValidity();

    @Deprecated
    boolean checkOldCropValidity();

    @Deprecated
    boolean checkOldTransformSandboxFile();

    boolean checkOnlyMimeTypeValidity(LocalMedia localMedia, boolean z, String str, String str2, long j, long j2);

    boolean checkTransformSandboxFile();

    boolean checkVideoThumbnail();

    boolean checkWithMimeTypeValidity(LocalMedia localMedia, boolean z, String str, int i, long j, long j2);

    int confirmSelect(LocalMedia localMedia, boolean z);

    void dismissLoading();

    void dispatchCameraMediaResult(LocalMedia localMedia);

    int getResourceId();

    void handlePermissionDenied(String[] strArr);

    void handlePermissionSettingResult(String[] strArr);

    void initAppLanguage();

    void onApplyPermissionsEvent(int i, String[] strArr);

    void onCheckOriginalChange();

    void onCompress(ArrayList<LocalMedia> arrayList);

    void onCreateLoader();

    void onCrop(ArrayList<LocalMedia> arrayList);

    void onEditMedia(Intent intent);

    void onEnterFragment();

    void onExitFragment();

    void onFixedSelectedChange(LocalMedia localMedia);

    void onFragmentResume();

    void onInterceptCameraEvent(int i);

    void onKeyBackFragmentFinish();

    @Deprecated
    void onOldCompress(ArrayList<LocalMedia> arrayList);

    void onOldCrop(ArrayList<LocalMedia> arrayList);

    void onPermissionExplainEvent(boolean z, String[] strArr);

    void onRecreateEngine();

    void onResultEvent(ArrayList<LocalMedia> arrayList);

    void onSelectedChange(boolean z, LocalMedia localMedia);

    void onSelectedOnlyCamera();

    void openImageCamera();

    void openSelectedCamera();

    void openSoundRecording();

    void openVideoCamera();

    void reStartSavedInstance(Bundle bundle);

    void sendChangeSubSelectPositionEvent(boolean z);

    void sendFixedSelectedChangeEvent(LocalMedia localMedia);

    void sendSelectedChangeEvent(boolean z, LocalMedia localMedia);

    void sendSelectedOriginalChangeEvent();

    void showLoading();
}
