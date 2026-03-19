package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.PictureOnlyCameraFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.engine.CompressEngine;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.engine.CropEngine;
import com.luck.picture.lib.engine.CropFileEngine;
import com.luck.picture.lib.engine.SandboxFileEngine;
import com.luck.picture.lib.engine.UriToFileTransformEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnBitmapWatermarkEventListener;
import com.luck.picture.lib.interfaces.OnCameraInterceptListener;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnPermissionDeniedListener;
import com.luck.picture.lib.interfaces.OnPermissionDescriptionListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnRecordAudioInterceptListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.interfaces.OnVideoThumbnailEventListener;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PictureSelectionCameraModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionCameraModel(PictureSelector pictureSelector, int i) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.chooseMode = i;
        selectorConfig.isOnlyCamera = true;
        selectorConfig.isDisplayTimeAxis = false;
        selectorConfig.isPreviewFullScreenMode = false;
        selectorConfig.isPreviewZoomEffect = false;
        selectorConfig.isOpenClickSound = false;
    }

    public PictureSelectionCameraModel setLanguage(int i) {
        this.selectionConfig.language = i;
        return this;
    }

    public PictureSelectionCameraModel setDefaultLanguage(int i) {
        this.selectionConfig.defaultLanguage = i;
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setCompressEngine(CompressEngine compressEngine) {
        this.selectionConfig.compressEngine = compressEngine;
        this.selectionConfig.isCompressEngine = true;
        return this;
    }

    public PictureSelectionCameraModel setCompressEngine(CompressFileEngine compressFileEngine) {
        this.selectionConfig.compressFileEngine = compressFileEngine;
        this.selectionConfig.isCompressEngine = true;
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setCropEngine(CropEngine cropEngine) {
        this.selectionConfig.cropEngine = cropEngine;
        return this;
    }

    public PictureSelectionCameraModel setCropEngine(CropFileEngine cropFileEngine) {
        this.selectionConfig.cropFileEngine = cropFileEngine;
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setSandboxFileEngine(SandboxFileEngine sandboxFileEngine) {
        if (SdkVersionUtils.isQ()) {
            this.selectionConfig.sandboxFileEngine = sandboxFileEngine;
            this.selectionConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public PictureSelectionCameraModel setSandboxFileEngine(UriToFileTransformEngine uriToFileTransformEngine) {
        if (SdkVersionUtils.isQ()) {
            this.selectionConfig.uriToFileTransformEngine = uriToFileTransformEngine;
            this.selectionConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public PictureSelectionCameraModel setRequestedOrientation(int i) {
        this.selectionConfig.requestedOrientation = i;
        return this;
    }

    public PictureSelectionCameraModel setCameraInterceptListener(OnCameraInterceptListener onCameraInterceptListener) {
        this.selectionConfig.onCameraInterceptListener = onCameraInterceptListener;
        return this;
    }

    public PictureSelectionCameraModel setRecordAudioInterceptListener(OnRecordAudioInterceptListener onRecordAudioInterceptListener) {
        this.selectionConfig.onRecordAudioListener = onRecordAudioInterceptListener;
        return this;
    }

    public PictureSelectionCameraModel setPermissionsInterceptListener(OnPermissionsInterceptListener onPermissionsInterceptListener) {
        this.selectionConfig.onPermissionsEventListener = onPermissionsInterceptListener;
        return this;
    }

    public PictureSelectionCameraModel setPermissionDescriptionListener(OnPermissionDescriptionListener onPermissionDescriptionListener) {
        this.selectionConfig.onPermissionDescriptionListener = onPermissionDescriptionListener;
        return this;
    }

    public PictureSelectionCameraModel setPermissionDeniedListener(OnPermissionDeniedListener onPermissionDeniedListener) {
        this.selectionConfig.onPermissionDeniedListener = onPermissionDeniedListener;
        return this;
    }

    public PictureSelectionCameraModel setSelectLimitTipsListener(OnSelectLimitTipsListener onSelectLimitTipsListener) {
        this.selectionConfig.onSelectLimitTipsListener = onSelectLimitTipsListener;
        return this;
    }

    public PictureSelectionCameraModel setAddBitmapWatermarkListener(OnBitmapWatermarkEventListener onBitmapWatermarkEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onBitmapWatermarkListener = onBitmapWatermarkEventListener;
        }
        return this;
    }

    public PictureSelectionCameraModel setVideoThumbnailListener(OnVideoThumbnailEventListener onVideoThumbnailEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onVideoThumbnailEventListener = onVideoThumbnailEventListener;
        }
        return this;
    }

    public PictureSelectionCameraModel setCustomLoadingListener(OnCustomLoadingListener onCustomLoadingListener) {
        this.selectionConfig.onCustomLoadingListener = onCustomLoadingListener;
        return this;
    }

    public PictureSelectionCameraModel isCameraForegroundService(boolean z) {
        this.selectionConfig.isCameraForegroundService = z;
        return this;
    }

    public PictureSelectionCameraModel setOfAllCameraType(int i) {
        this.selectionConfig.ofAllCameraType = i;
        return this;
    }

    public PictureSelectionCameraModel isOriginalControl(boolean z) {
        this.selectionConfig.isOriginalControl = z;
        this.selectionConfig.isCheckOriginalImage = z;
        return this;
    }

    public PictureSelectionCameraModel isOriginalSkipCompress(boolean z) {
        this.selectionConfig.isOriginalSkipCompress = z;
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setVideoQuality(int i) {
        this.selectionConfig.videoQuality = i;
        return this;
    }

    private PictureSelectionCameraModel setMaxSelectNum(int i) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode == 1) {
            i = 1;
        }
        selectorConfig.maxSelectNum = i;
        return this;
    }

    public PictureSelectionCameraModel setMaxVideoSelectNum(int i) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.chooseMode == SelectMimeType.ofVideo()) {
            i = 0;
        }
        selectorConfig.maxVideoSelectNum = i;
        return this;
    }

    public PictureSelectionCameraModel setSelectMaxFileSize(long j) {
        if (j >= 1048576) {
            this.selectionConfig.selectMaxFileSize = j;
        } else {
            this.selectionConfig.selectMaxFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionCameraModel setSelectMinFileSize(long j) {
        if (j >= 1048576) {
            this.selectionConfig.selectMinFileSize = j;
        } else {
            this.selectionConfig.selectMinFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionCameraModel setCameraImageFormat(String str) {
        this.selectionConfig.cameraImageFormat = str;
        return this;
    }

    public PictureSelectionCameraModel setCameraImageFormatForQ(String str) {
        this.selectionConfig.cameraImageFormatForQ = str;
        return this;
    }

    public PictureSelectionCameraModel setCameraVideoFormat(String str) {
        this.selectionConfig.cameraVideoFormat = str;
        return this;
    }

    public PictureSelectionCameraModel setCameraVideoFormatForQ(String str) {
        this.selectionConfig.cameraVideoFormatForQ = str;
        return this;
    }

    public PictureSelectionCameraModel setRecordVideoMaxSecond(int i) {
        this.selectionConfig.recordVideoMaxSecond = i;
        return this;
    }

    public PictureSelectionCameraModel setRecordVideoMinSecond(int i) {
        this.selectionConfig.recordVideoMinSecond = i;
        return this;
    }

    public PictureSelectionCameraModel setSelectMaxDurationSecond(int i) {
        this.selectionConfig.selectMaxDurationSecond = i * 1000;
        return this;
    }

    public PictureSelectionCameraModel setSelectMinDurationSecond(int i) {
        this.selectionConfig.selectMinDurationSecond = i * 1000;
        return this;
    }

    public PictureSelectionCameraModel setOutputCameraDir(String str) {
        this.selectionConfig.outPutCameraDir = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputAudioDir(String str) {
        this.selectionConfig.outPutAudioDir = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputCameraImageFileName(String str) {
        this.selectionConfig.outPutCameraImageFileName = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputCameraVideoFileName(String str) {
        this.selectionConfig.outPutCameraVideoFileName = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputAudioFileName(String str) {
        this.selectionConfig.outPutAudioFileName = str;
        return this;
    }

    public PictureSelectionCameraModel setSelectedData(List<LocalMedia> list) {
        if (list == null) {
            return this;
        }
        setMaxSelectNum(list.size() + 1);
        setMaxVideoSelectNum(list.size() + 1);
        if (this.selectionConfig.selectionMode == 1 && this.selectionConfig.isDirectReturnSingle) {
            this.selectionConfig.selectedResult.clear();
        } else {
            this.selectionConfig.addAllSelectResult(new ArrayList<>(list));
        }
        return this;
    }

    public PictureSelectionCameraModel isQuickCapture(boolean z) {
        this.selectionConfig.isQuickCapture = z;
        return this;
    }

    public PictureSelectionCameraModel isCameraAroundState(boolean z) {
        this.selectionConfig.isCameraAroundState = z;
        return this;
    }

    public PictureSelectionCameraModel isCameraRotateImage(boolean z) {
        this.selectionConfig.isCameraRotateImage = z;
        return this;
    }

    public void forResult() {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        this.selectionConfig.isResultListenerBack = false;
        this.selectionConfig.isActivityResultBack = true;
        FragmentManager supportFragmentManager = activity instanceof FragmentActivity ? ((FragmentActivity) activity).getSupportFragmentManager() : null;
        if (supportFragmentManager == null) {
            throw new NullPointerException("FragmentManager cannot be null");
        }
        if (!(activity instanceof IBridgePictureBehavior)) {
            throw new NullPointerException("Use only camera openCamera mode,Activity or Fragment interface needs to be implemented " + IBridgePictureBehavior.class);
        }
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(PictureOnlyCameraFragment.TAG);
        if (fragmentFindFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        FragmentInjectManager.injectSystemRoomFragment(supportFragmentManager, PictureOnlyCameraFragment.TAG, PictureOnlyCameraFragment.newInstance());
    }

    public void forResult(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (onResultCallbackListener == null) {
            throw new NullPointerException("OnResultCallbackListener cannot be null");
        }
        this.selectionConfig.isResultListenerBack = true;
        this.selectionConfig.isActivityResultBack = false;
        this.selectionConfig.onResultCallListener = onResultCallbackListener;
        FragmentManager supportFragmentManager = activity instanceof FragmentActivity ? ((FragmentActivity) activity).getSupportFragmentManager() : null;
        if (supportFragmentManager == null) {
            throw new NullPointerException("FragmentManager cannot be null");
        }
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(PictureOnlyCameraFragment.TAG);
        if (fragmentFindFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        FragmentInjectManager.injectSystemRoomFragment(supportFragmentManager, PictureOnlyCameraFragment.TAG, PictureOnlyCameraFragment.newInstance());
    }

    public PictureOnlyCameraFragment build() {
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (!(activity instanceof IBridgePictureBehavior)) {
            throw new NullPointerException("Use only build PictureOnlyCameraFragment,Activity or Fragment interface needs to be implemented " + IBridgePictureBehavior.class);
        }
        this.selectionConfig.isResultListenerBack = false;
        this.selectionConfig.isActivityResultBack = true;
        this.selectionConfig.onResultCallListener = null;
        return new PictureOnlyCameraFragment();
    }

    public PictureOnlyCameraFragment buildLaunch(int i, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (onResultCallbackListener == null) {
            throw new NullPointerException("OnResultCallbackListener cannot be null");
        }
        this.selectionConfig.isResultListenerBack = true;
        this.selectionConfig.isActivityResultBack = false;
        this.selectionConfig.onResultCallListener = onResultCallbackListener;
        FragmentManager supportFragmentManager = activity instanceof FragmentActivity ? ((FragmentActivity) activity).getSupportFragmentManager() : null;
        if (supportFragmentManager == null) {
            throw new NullPointerException("FragmentManager cannot be null");
        }
        PictureOnlyCameraFragment pictureOnlyCameraFragment = new PictureOnlyCameraFragment();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(pictureOnlyCameraFragment.getFragmentTag());
        if (fragmentFindFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        supportFragmentManager.beginTransaction().add(i, pictureOnlyCameraFragment, pictureOnlyCameraFragment.getFragmentTag()).addToBackStack(pictureOnlyCameraFragment.getFragmentTag()).commitAllowingStateLoss();
        return pictureOnlyCameraFragment;
    }

    public void forResultActivity(int i) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        this.selectionConfig.isResultListenerBack = false;
        this.selectionConfig.isActivityResultBack = true;
        Intent intent = new Intent(activity, (Class<?>) PictureSelectorTransparentActivity.class);
        Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        } else {
            activity.startActivityForResult(intent, i);
        }
        activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
    }

    public void forResultActivity(ActivityResultLauncher<Intent> activityResultLauncher) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (activityResultLauncher == null) {
            throw new NullPointerException("ActivityResultLauncher cannot be null");
        }
        this.selectionConfig.isResultListenerBack = false;
        this.selectionConfig.isActivityResultBack = true;
        activityResultLauncher.launch(new Intent(activity, (Class<?>) PictureSelectorTransparentActivity.class));
        activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
    }

    public void forResultActivity(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (onResultCallbackListener == null) {
            throw new NullPointerException("OnResultCallbackListener cannot be null");
        }
        this.selectionConfig.isResultListenerBack = true;
        this.selectionConfig.isActivityResultBack = false;
        this.selectionConfig.onResultCallListener = onResultCallbackListener;
        activity.startActivity(new Intent(activity, (Class<?>) PictureSelectorTransparentActivity.class));
        activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
    }
}
