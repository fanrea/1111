package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.PictureSelectorFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.engine.CompressEngine;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.engine.CropEngine;
import com.luck.picture.lib.engine.CropFileEngine;
import com.luck.picture.lib.engine.ExtendLoaderEngine;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.engine.SandboxFileEngine;
import com.luck.picture.lib.engine.UriToFileTransformEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnBitmapWatermarkEventListener;
import com.luck.picture.lib.interfaces.OnCameraInterceptListener;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnGridItemSelectAnimListener;
import com.luck.picture.lib.interfaces.OnInjectLayoutResourceListener;
import com.luck.picture.lib.interfaces.OnMediaEditInterceptListener;
import com.luck.picture.lib.interfaces.OnPermissionDeniedListener;
import com.luck.picture.lib.interfaces.OnPermissionDescriptionListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnPreviewInterceptListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.interfaces.OnRecordAudioInterceptListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.interfaces.OnSelectAnimListener;
import com.luck.picture.lib.interfaces.OnSelectFilterListener;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.interfaces.OnVideoThumbnailEventListener;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PictureSelectionModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionModel(PictureSelector pictureSelector, int i) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.chooseMode = i;
        setMaxVideoSelectNum(selectorConfig.maxVideoSelectNum);
    }

    public PictureSelectionModel setSelectorUIStyle(PictureSelectorStyle pictureSelectorStyle) {
        if (pictureSelectorStyle != null) {
            this.selectionConfig.selectorStyle = pictureSelectorStyle;
        }
        return this;
    }

    public PictureSelectionModel setLanguage(int i) {
        this.selectionConfig.language = i;
        return this;
    }

    public PictureSelectionModel setDefaultLanguage(int i) {
        this.selectionConfig.defaultLanguage = i;
        return this;
    }

    public PictureSelectionModel setImageEngine(ImageEngine imageEngine) {
        this.selectionConfig.imageEngine = imageEngine;
        return this;
    }

    public PictureSelectionModel setVideoPlayerEngine(VideoPlayerEngine videoPlayerEngine) {
        this.selectionConfig.videoPlayerEngine = videoPlayerEngine;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCompressEngine(CompressEngine compressEngine) {
        this.selectionConfig.compressEngine = compressEngine;
        this.selectionConfig.isCompressEngine = true;
        return this;
    }

    public PictureSelectionModel setCompressEngine(CompressFileEngine compressFileEngine) {
        this.selectionConfig.compressFileEngine = compressFileEngine;
        this.selectionConfig.isCompressEngine = true;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropEngine(CropEngine cropEngine) {
        this.selectionConfig.cropEngine = cropEngine;
        return this;
    }

    public PictureSelectionModel setCropEngine(CropFileEngine cropFileEngine) {
        this.selectionConfig.cropFileEngine = cropFileEngine;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setSandboxFileEngine(SandboxFileEngine sandboxFileEngine) {
        if (SdkVersionUtils.isQ()) {
            this.selectionConfig.sandboxFileEngine = sandboxFileEngine;
            this.selectionConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public PictureSelectionModel setSandboxFileEngine(UriToFileTransformEngine uriToFileTransformEngine) {
        if (SdkVersionUtils.isQ()) {
            this.selectionConfig.uriToFileTransformEngine = uriToFileTransformEngine;
            this.selectionConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    @Deprecated
    public PictureSelectionModel setExtendLoaderEngine(ExtendLoaderEngine extendLoaderEngine) {
        this.selectionConfig.loaderDataEngine = extendLoaderEngine;
        this.selectionConfig.isLoaderDataEngine = true;
        return this;
    }

    public PictureSelectionModel setLoaderFactoryEngine(IBridgeLoaderFactory iBridgeLoaderFactory) {
        this.selectionConfig.loaderFactory = iBridgeLoaderFactory;
        this.selectionConfig.isLoaderFactoryEngine = true;
        return this;
    }

    public PictureSelectionModel setMagicalEffectInterpolator(InterpolatorFactory interpolatorFactory) {
        this.selectionConfig.interpolatorFactory = interpolatorFactory;
        return this;
    }

    public PictureSelectionModel setCameraInterceptListener(OnCameraInterceptListener onCameraInterceptListener) {
        this.selectionConfig.onCameraInterceptListener = onCameraInterceptListener;
        return this;
    }

    public PictureSelectionModel setRecordAudioInterceptListener(OnRecordAudioInterceptListener onRecordAudioInterceptListener) {
        this.selectionConfig.onRecordAudioListener = onRecordAudioInterceptListener;
        return this;
    }

    public PictureSelectionModel setPreviewInterceptListener(OnPreviewInterceptListener onPreviewInterceptListener) {
        this.selectionConfig.onPreviewInterceptListener = onPreviewInterceptListener;
        return this;
    }

    public PictureSelectionModel setInjectLayoutResourceListener(OnInjectLayoutResourceListener onInjectLayoutResourceListener) {
        this.selectionConfig.isInjectLayoutResource = onInjectLayoutResourceListener != null;
        this.selectionConfig.onLayoutResourceListener = onInjectLayoutResourceListener;
        return this;
    }

    public PictureSelectionModel setEditMediaInterceptListener(OnMediaEditInterceptListener onMediaEditInterceptListener) {
        this.selectionConfig.onEditMediaEventListener = onMediaEditInterceptListener;
        return this;
    }

    public PictureSelectionModel setPermissionsInterceptListener(OnPermissionsInterceptListener onPermissionsInterceptListener) {
        this.selectionConfig.onPermissionsEventListener = onPermissionsInterceptListener;
        return this;
    }

    public PictureSelectionModel setPermissionDescriptionListener(OnPermissionDescriptionListener onPermissionDescriptionListener) {
        this.selectionConfig.onPermissionDescriptionListener = onPermissionDescriptionListener;
        return this;
    }

    public PictureSelectionModel setPermissionDeniedListener(OnPermissionDeniedListener onPermissionDeniedListener) {
        this.selectionConfig.onPermissionDeniedListener = onPermissionDeniedListener;
        return this;
    }

    public PictureSelectionModel setSelectLimitTipsListener(OnSelectLimitTipsListener onSelectLimitTipsListener) {
        this.selectionConfig.onSelectLimitTipsListener = onSelectLimitTipsListener;
        return this;
    }

    public PictureSelectionModel setSelectFilterListener(OnSelectFilterListener onSelectFilterListener) {
        this.selectionConfig.onSelectFilterListener = onSelectFilterListener;
        return this;
    }

    public PictureSelectionModel setQueryFilterListener(OnQueryFilterListener onQueryFilterListener) {
        this.selectionConfig.onQueryFilterListener = onQueryFilterListener;
        return this;
    }

    public PictureSelectionModel setGridItemSelectAnimListener(OnGridItemSelectAnimListener onGridItemSelectAnimListener) {
        this.selectionConfig.onItemSelectAnimListener = onGridItemSelectAnimListener;
        return this;
    }

    public PictureSelectionModel setSelectAnimListener(OnSelectAnimListener onSelectAnimListener) {
        this.selectionConfig.onSelectAnimListener = onSelectAnimListener;
        return this;
    }

    public PictureSelectionModel setAddBitmapWatermarkListener(OnBitmapWatermarkEventListener onBitmapWatermarkEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onBitmapWatermarkListener = onBitmapWatermarkEventListener;
        }
        return this;
    }

    public PictureSelectionModel setVideoThumbnailListener(OnVideoThumbnailEventListener onVideoThumbnailEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onVideoThumbnailEventListener = onVideoThumbnailEventListener;
        }
        return this;
    }

    public PictureSelectionModel setCustomLoadingListener(OnCustomLoadingListener onCustomLoadingListener) {
        this.selectionConfig.onCustomLoadingListener = onCustomLoadingListener;
        return this;
    }

    public PictureSelectionModel isCameraForegroundService(boolean z) {
        this.selectionConfig.isCameraForegroundService = z;
        return this;
    }

    public PictureSelectionModel isPreloadFirst(boolean z) {
        this.selectionConfig.isPreloadFirst = z;
        return this;
    }

    public PictureSelectionModel isUseSystemVideoPlayer(boolean z) {
        this.selectionConfig.isUseSystemVideoPlayer = z;
        return this;
    }

    public PictureSelectionModel setRequestedOrientation(int i) {
        this.selectionConfig.requestedOrientation = i;
        return this;
    }

    public PictureSelectionModel setSelectionMode(int i) {
        this.selectionConfig.selectionMode = i;
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.maxSelectNum = selectorConfig.selectionMode != 1 ? this.selectionConfig.maxSelectNum : 1;
        return this;
    }

    public PictureSelectionModel isWithSelectVideoImage(boolean z) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isWithVideoImage = selectorConfig.chooseMode == SelectMimeType.ofAll() && z;
        return this;
    }

    public PictureSelectionModel setOfAllCameraType(int i) {
        this.selectionConfig.ofAllCameraType = i;
        return this;
    }

    public PictureSelectionModel isMaxSelectEnabledMask(boolean z) {
        this.selectionConfig.isMaxSelectEnabledMask = z;
        return this;
    }

    public PictureSelectionModel isOriginalControl(boolean z) {
        this.selectionConfig.isOriginalControl = z;
        return this;
    }

    public PictureSelectionModel isSyncCover(boolean z) {
        this.selectionConfig.isSyncCover = z;
        return this;
    }

    public PictureSelectionModel setMaxSelectNum(int i) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode == 1) {
            i = 1;
        }
        selectorConfig.maxSelectNum = i;
        return this;
    }

    public PictureSelectionModel setMinSelectNum(int i) {
        this.selectionConfig.minSelectNum = i;
        return this;
    }

    public PictureSelectionModel isAutomaticTitleRecyclerTop(boolean z) {
        this.selectionConfig.isAutomaticTitleRecyclerTop = z;
        return this;
    }

    public PictureSelectionModel isDirectReturnSingle(boolean z) {
        boolean z2 = false;
        if (z) {
            this.selectionConfig.isFastSlidingSelect = false;
        }
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode == 1 && z) {
            z2 = true;
        }
        selectorConfig.isDirectReturnSingle = z2;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z) {
        this.selectionConfig.isPageStrategy = z;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z, int i) {
        this.selectionConfig.isPageStrategy = z;
        SelectorConfig selectorConfig = this.selectionConfig;
        if (i < 10) {
            i = 60;
        }
        selectorConfig.pageSize = i;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isPageStrategy(boolean z, boolean z2) {
        this.selectionConfig.isPageStrategy = z;
        this.selectionConfig.isFilterInvalidFile = z2;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isPageStrategy(boolean z, int i, boolean z2) {
        this.selectionConfig.isPageStrategy = z;
        SelectorConfig selectorConfig = this.selectionConfig;
        if (i < 10) {
            i = 60;
        }
        selectorConfig.pageSize = i;
        this.selectionConfig.isFilterInvalidFile = z2;
        return this;
    }

    public PictureSelectionModel setAttachViewLifecycle(IBridgeViewLifecycle iBridgeViewLifecycle) {
        this.selectionConfig.viewLifecycle = iBridgeViewLifecycle;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setVideoQuality(int i) {
        this.selectionConfig.videoQuality = i;
        return this;
    }

    public PictureSelectionModel setDefaultAlbumName(String str) {
        this.selectionConfig.defaultAlbumName = str;
        return this;
    }

    public PictureSelectionModel setCameraImageFormat(String str) {
        this.selectionConfig.cameraImageFormat = str;
        return this;
    }

    public PictureSelectionModel setCameraImageFormatForQ(String str) {
        this.selectionConfig.cameraImageFormatForQ = str;
        return this;
    }

    public PictureSelectionModel setCameraVideoFormat(String str) {
        this.selectionConfig.cameraVideoFormat = str;
        return this;
    }

    public PictureSelectionModel setCameraVideoFormatForQ(String str) {
        this.selectionConfig.cameraVideoFormatForQ = str;
        return this;
    }

    public PictureSelectionModel setFilterVideoMaxSecond(int i) {
        this.selectionConfig.filterVideoMaxSecond = i * 1000;
        return this;
    }

    public PictureSelectionModel setFilterVideoMinSecond(int i) {
        this.selectionConfig.filterVideoMinSecond = i * 1000;
        return this;
    }

    public PictureSelectionModel setSelectMaxDurationSecond(int i) {
        this.selectionConfig.selectMaxDurationSecond = i * 1000;
        return this;
    }

    public PictureSelectionModel setSelectMinDurationSecond(int i) {
        this.selectionConfig.selectMinDurationSecond = i * 1000;
        return this;
    }

    public PictureSelectionModel setRecordVideoMaxSecond(int i) {
        this.selectionConfig.recordVideoMaxSecond = i;
        return this;
    }

    public PictureSelectionModel setMaxVideoSelectNum(int i) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.chooseMode == SelectMimeType.ofVideo()) {
            i = 0;
        }
        selectorConfig.maxVideoSelectNum = i;
        return this;
    }

    public PictureSelectionModel setMinVideoSelectNum(int i) {
        this.selectionConfig.minVideoSelectNum = i;
        return this;
    }

    public PictureSelectionModel setMinAudioSelectNum(int i) {
        this.selectionConfig.minAudioSelectNum = i;
        return this;
    }

    public PictureSelectionModel setRecordVideoMinSecond(int i) {
        this.selectionConfig.recordVideoMinSecond = i;
        return this;
    }

    public PictureSelectionModel setImageSpanCount(int i) {
        this.selectionConfig.imageSpanCount = i;
        return this;
    }

    public PictureSelectionModel isEmptyResultReturn(boolean z) {
        this.selectionConfig.isEmptyResultReturn = z;
        return this;
    }

    public PictureSelectionModel isQuickCapture(boolean z) {
        this.selectionConfig.isQuickCapture = z;
        return this;
    }

    public PictureSelectionModel isDisplayCamera(boolean z) {
        this.selectionConfig.isDisplayCamera = z;
        return this;
    }

    public PictureSelectionModel setOutputCameraDir(String str) {
        this.selectionConfig.outPutCameraDir = str;
        return this;
    }

    public PictureSelectionModel setOutputAudioDir(String str) {
        this.selectionConfig.outPutAudioDir = str;
        return this;
    }

    public PictureSelectionModel setOutputCameraImageFileName(String str) {
        this.selectionConfig.outPutCameraImageFileName = str;
        return this;
    }

    public PictureSelectionModel setOutputCameraVideoFileName(String str) {
        this.selectionConfig.outPutCameraVideoFileName = str;
        return this;
    }

    public PictureSelectionModel setOutputAudioFileName(String str) {
        this.selectionConfig.outPutAudioFileName = str;
        return this;
    }

    public PictureSelectionModel setQuerySandboxDir(String str) {
        this.selectionConfig.sandboxDir = str;
        return this;
    }

    public PictureSelectionModel isOnlyObtainSandboxDir(boolean z) {
        this.selectionConfig.isOnlySandboxDir = z;
        return this;
    }

    public PictureSelectionModel isDisplayTimeAxis(boolean z) {
        this.selectionConfig.isDisplayTimeAxis = z;
        return this;
    }

    public PictureSelectionModel setFilterMaxFileSize(long j) {
        if (j >= 1048576) {
            this.selectionConfig.filterMaxFileSize = j;
        } else {
            this.selectionConfig.filterMaxFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionModel setFilterMinFileSize(long j) {
        if (j >= 1048576) {
            this.selectionConfig.filterMinFileSize = j;
        } else {
            this.selectionConfig.filterMinFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionModel setSelectMaxFileSize(long j) {
        if (j >= 1048576) {
            this.selectionConfig.selectMaxFileSize = j;
        } else {
            this.selectionConfig.selectMaxFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionModel setSelectMinFileSize(long j) {
        if (j >= 1048576) {
            this.selectionConfig.selectMinFileSize = j;
        } else {
            this.selectionConfig.selectMinFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionModel setQueryOnlyMimeType(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.selectionConfig.queryOnlyList.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public PictureSelectionModel setSkipCropMimeType(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.selectionConfig.skipCropList.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public PictureSelectionModel setQuerySortOrder(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.selectionConfig.sortOrder = str;
        }
        return this;
    }

    public PictureSelectionModel isGif(boolean z) {
        this.selectionConfig.isGif = z;
        return this;
    }

    public PictureSelectionModel isWebp(boolean z) {
        this.selectionConfig.isWebp = z;
        return this;
    }

    public PictureSelectionModel isBmp(boolean z) {
        this.selectionConfig.isBmp = z;
        return this;
    }

    public PictureSelectionModel isPreviewFullScreenMode(boolean z) {
        this.selectionConfig.isPreviewFullScreenMode = z;
        return this;
    }

    public PictureSelectionModel isPreviewZoomEffect(boolean z) {
        if (this.selectionConfig.chooseMode == SelectMimeType.ofAudio()) {
            this.selectionConfig.isPreviewZoomEffect = false;
        } else {
            this.selectionConfig.isPreviewZoomEffect = z;
        }
        return this;
    }

    @Deprecated
    public PictureSelectionModel isEnableVideoSize(boolean z) {
        this.selectionConfig.isSyncWidthAndHeight = z;
        return this;
    }

    public PictureSelectionModel isSyncWidthAndHeight(boolean z) {
        this.selectionConfig.isSyncWidthAndHeight = z;
        return this;
    }

    public PictureSelectionModel isPreviewAudio(boolean z) {
        this.selectionConfig.isEnablePreviewAudio = z;
        return this;
    }

    public PictureSelectionModel isPreviewImage(boolean z) {
        this.selectionConfig.isEnablePreviewImage = z;
        return this;
    }

    public PictureSelectionModel isPreviewVideo(boolean z) {
        this.selectionConfig.isEnablePreviewVideo = z;
        return this;
    }

    public PictureSelectionModel isAutoVideoPlay(boolean z) {
        this.selectionConfig.isAutoVideoPlay = z;
        return this;
    }

    public PictureSelectionModel isLoopAutoVideoPlay(boolean z) {
        this.selectionConfig.isLoopAutoPlay = z;
        return this;
    }

    public PictureSelectionModel isVideoPauseResumePlay(boolean z) {
        this.selectionConfig.isPauseResumePlay = z;
        return this;
    }

    public PictureSelectionModel isPageSyncAlbumCount(boolean z) {
        this.selectionConfig.isPageSyncAsCount = z;
        return this;
    }

    public PictureSelectionModel isOriginalSkipCompress(boolean z) {
        this.selectionConfig.isOriginalSkipCompress = z;
        return this;
    }

    public PictureSelectionModel isFilterSizeDuration(boolean z) {
        this.selectionConfig.isFilterSizeDuration = z;
        return this;
    }

    public PictureSelectionModel isFastSlidingSelect(boolean z) {
        if (this.selectionConfig.isDirectReturnSingle) {
            this.selectionConfig.isFastSlidingSelect = false;
        } else {
            this.selectionConfig.isFastSlidingSelect = z;
        }
        return this;
    }

    public PictureSelectionModel isOpenClickSound(boolean z) {
        this.selectionConfig.isOpenClickSound = z;
        return this;
    }

    public PictureSelectionModel isCameraAroundState(boolean z) {
        this.selectionConfig.isCameraAroundState = z;
        return this;
    }

    public PictureSelectionModel isCameraRotateImage(boolean z) {
        this.selectionConfig.isCameraRotateImage = z;
        return this;
    }

    public PictureSelectionModel isSelectZoomAnim(boolean z) {
        this.selectionConfig.isSelectZoomAnim = z;
        return this;
    }

    public PictureSelectionModel setSelectedData(List<LocalMedia> list) {
        if (list == null) {
            return this;
        }
        if (this.selectionConfig.selectionMode == 1 && this.selectionConfig.isDirectReturnSingle) {
            this.selectionConfig.selectedResult.clear();
        } else {
            this.selectionConfig.addAllSelectResult(new ArrayList<>(list));
        }
        return this;
    }

    public PictureSelectionModel setRecyclerAnimationMode(int i) {
        this.selectionConfig.animationMode = i;
        return this;
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
        if (this.selectionConfig.imageEngine == null && this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
        }
        activity.startActivity(new Intent(activity, (Class<?>) PictureSelectorSupporterActivity.class));
        activity.overridePendingTransition(this.selectionConfig.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
    }

    public void forResult(int i) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        this.selectionConfig.isResultListenerBack = false;
        this.selectionConfig.isActivityResultBack = true;
        if (this.selectionConfig.imageEngine == null && this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
        }
        Intent intent = new Intent(activity, (Class<?>) PictureSelectorSupporterActivity.class);
        Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        } else {
            activity.startActivityForResult(intent, i);
        }
        activity.overridePendingTransition(this.selectionConfig.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
    }

    public void forResult(ActivityResultLauncher<Intent> activityResultLauncher) {
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
        if (this.selectionConfig.imageEngine == null && this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
        }
        activityResultLauncher.launch(new Intent(activity, (Class<?>) PictureSelectorSupporterActivity.class));
        activity.overridePendingTransition(this.selectionConfig.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
    }

    public PictureSelectorFragment build() {
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (!(activity instanceof IBridgePictureBehavior)) {
            throw new NullPointerException("Use only build PictureSelectorFragment,Activity or Fragment interface needs to be implemented " + IBridgePictureBehavior.class);
        }
        this.selectionConfig.isResultListenerBack = false;
        this.selectionConfig.isActivityResultBack = true;
        this.selectionConfig.onResultCallListener = null;
        return new PictureSelectorFragment();
    }

    public PictureSelectorFragment buildLaunch(int i, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
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
        PictureSelectorFragment pictureSelectorFragment = new PictureSelectorFragment();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(pictureSelectorFragment.getFragmentTag());
        if (fragmentFindFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        supportFragmentManager.beginTransaction().add(i, pictureSelectorFragment, pictureSelectorFragment.getFragmentTag()).addToBackStack(pictureSelectorFragment.getFragmentTag()).commitAllowingStateLoss();
        return pictureSelectorFragment;
    }
}
