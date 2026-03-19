package com.luck.picture.lib.config;

import com.luck.picture.lib.basic.IBridgeLoaderFactory;
import com.luck.picture.lib.basic.IBridgeViewLifecycle;
import com.luck.picture.lib.basic.InterpolatorFactory;
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
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnBitmapWatermarkEventListener;
import com.luck.picture.lib.interfaces.OnCameraInterceptListener;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnExternalPreviewEventListener;
import com.luck.picture.lib.interfaces.OnGridItemSelectAnimListener;
import com.luck.picture.lib.interfaces.OnInjectActivityPreviewListener;
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
import com.luck.picture.lib.magical.BuildRecycleItemViewParams;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.FileDirMap;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class SelectorConfig {
    public int animationMode;
    public String cameraImageFormat;
    public String cameraImageFormatForQ;
    public String cameraPath;
    public String cameraVideoFormat;
    public String cameraVideoFormatForQ;
    public int chooseMode;
    public CompressEngine compressEngine;
    public CompressFileEngine compressFileEngine;
    public CropEngine cropEngine;
    public CropFileEngine cropFileEngine;
    public LocalMediaFolder currentLocalMediaFolder;
    public String defaultAlbumName;
    public int defaultLanguage;
    public long filterMaxFileSize;
    public long filterMinFileSize;
    public int filterVideoMaxSecond;
    public int filterVideoMinSecond;
    public ImageEngine imageEngine;
    public int imageSpanCount;
    public InterpolatorFactory interpolatorFactory;
    public boolean isActivityResultBack;
    public boolean isAutoRotating;
    public boolean isAutoVideoPlay;
    public boolean isAutomaticTitleRecyclerTop;
    public boolean isBmp;
    public boolean isCameraAroundState;
    public boolean isCameraForegroundService;
    public boolean isCameraRotateImage;
    public boolean isCheckOriginalImage;
    public boolean isCompressEngine;
    public boolean isDirectReturnSingle;
    public boolean isDisplayCamera;
    public boolean isDisplayTimeAxis;
    public boolean isEmptyResultReturn;
    public boolean isEnablePreviewAudio;
    public boolean isEnablePreviewImage;
    public boolean isEnablePreviewVideo;
    public boolean isFastSlidingSelect;
    public boolean isFilterInvalidFile;
    public boolean isFilterSizeDuration;
    public boolean isGif;
    public boolean isHidePreviewDownload;
    public boolean isInjectLayoutResource;
    public boolean isLoaderDataEngine;
    public boolean isLoaderFactoryEngine;
    public boolean isLoopAutoPlay;
    public boolean isMaxSelectEnabledMask;
    public boolean isOnlyCamera;
    public boolean isOnlySandboxDir;
    public boolean isOpenClickSound;
    public boolean isOriginalControl;
    public boolean isOriginalSkipCompress;
    public boolean isPageStrategy;
    public boolean isPageSyncAsCount;
    public boolean isPauseResumePlay;
    public boolean isPreloadFirst;
    public boolean isPreviewFullScreenMode;
    public boolean isPreviewZoomEffect;
    public boolean isQuickCapture;
    public boolean isResultListenerBack;
    public boolean isSandboxFileEngine;
    public boolean isSelectZoomAnim;
    public boolean isSyncCover;
    public boolean isSyncWidthAndHeight;
    public boolean isUseSystemVideoPlayer;
    public boolean isWebp;
    public boolean isWithVideoImage;
    public int language;
    public ExtendLoaderEngine loaderDataEngine;
    public IBridgeLoaderFactory loaderFactory;
    public int maxSelectNum;
    public int maxVideoSelectNum;
    public int minAudioSelectNum;
    public int minSelectNum;
    public int minVideoSelectNum;
    public int ofAllCameraType;
    public OnBitmapWatermarkEventListener onBitmapWatermarkListener;
    public OnCameraInterceptListener onCameraInterceptListener;
    public OnCustomLoadingListener onCustomLoadingListener;
    public OnMediaEditInterceptListener onEditMediaEventListener;
    public OnExternalPreviewEventListener onExternalPreviewEventListener;
    public OnInjectActivityPreviewListener onInjectActivityPreviewListener;
    public OnGridItemSelectAnimListener onItemSelectAnimListener;
    public OnInjectLayoutResourceListener onLayoutResourceListener;
    public OnPermissionDeniedListener onPermissionDeniedListener;
    public OnPermissionDescriptionListener onPermissionDescriptionListener;
    public OnPermissionsInterceptListener onPermissionsEventListener;
    public OnPreviewInterceptListener onPreviewInterceptListener;
    public OnQueryFilterListener onQueryFilterListener;
    public OnRecordAudioInterceptListener onRecordAudioListener;
    public OnResultCallbackListener<LocalMedia> onResultCallListener;
    public OnSelectAnimListener onSelectAnimListener;
    public OnSelectFilterListener onSelectFilterListener;
    public OnSelectLimitTipsListener onSelectLimitTipsListener;
    public OnVideoThumbnailEventListener onVideoThumbnailEventListener;
    public String originalPath;
    public String outPutAudioDir;
    public String outPutAudioFileName;
    public String outPutCameraDir;
    public String outPutCameraImageFileName;
    public String outPutCameraVideoFileName;
    public int pageSize;
    public List<String> queryOnlyList;
    public int recordVideoMaxSecond;
    public int recordVideoMinSecond;
    public int requestedOrientation;
    public String sandboxDir;
    public SandboxFileEngine sandboxFileEngine;
    public int selectMaxDurationSecond;
    public long selectMaxFileSize;
    public int selectMinDurationSecond;
    public long selectMinFileSize;
    public int selectionMode;
    public PictureSelectorStyle selectorStyle;
    public List<String> skipCropList;
    public String sortOrder;
    public UriToFileTransformEngine uriToFileTransformEngine;
    public VideoPlayerEngine videoPlayerEngine;
    public int videoQuality;
    public IBridgeViewLifecycle viewLifecycle;
    public final ArrayList<LocalMedia> selectedResult = new ArrayList<>();
    public final ArrayList<LocalMedia> selectedPreviewResult = new ArrayList<>();
    public final ArrayList<LocalMediaFolder> albumDataSource = new ArrayList<>();
    public final ArrayList<LocalMedia> dataSource = new ArrayList<>();

    public SelectorConfig() {
        initDefaultValue();
    }

    private void initDefaultValue() {
        this.chooseMode = SelectMimeType.ofImage();
        this.isOnlyCamera = false;
        this.selectionMode = 2;
        this.selectorStyle = new PictureSelectorStyle();
        this.maxSelectNum = 9;
        this.minSelectNum = 0;
        this.maxVideoSelectNum = 1;
        this.minVideoSelectNum = 0;
        this.minAudioSelectNum = 0;
        this.videoQuality = 1;
        this.language = -2;
        this.defaultLanguage = -1;
        this.filterVideoMaxSecond = 0;
        this.filterVideoMinSecond = 0;
        this.selectMaxDurationSecond = 0;
        this.selectMinDurationSecond = 0;
        this.filterMaxFileSize = 0L;
        this.filterMinFileSize = 0L;
        this.selectMaxFileSize = 0L;
        this.selectMinFileSize = 0L;
        this.recordVideoMaxSecond = 60;
        this.recordVideoMinSecond = 0;
        this.imageSpanCount = 4;
        this.isCameraAroundState = false;
        this.isWithVideoImage = false;
        this.isDisplayCamera = true;
        this.isGif = false;
        this.isWebp = true;
        this.isBmp = true;
        this.isCheckOriginalImage = false;
        this.isDirectReturnSingle = false;
        this.isEnablePreviewImage = true;
        this.isEnablePreviewVideo = true;
        this.isEnablePreviewAudio = true;
        this.isHidePreviewDownload = false;
        this.isOpenClickSound = false;
        this.isEmptyResultReturn = false;
        this.cameraImageFormat = ".jpeg";
        this.cameraVideoFormat = ".mp4";
        this.cameraImageFormatForQ = "image/jpeg";
        this.cameraVideoFormatForQ = "video/mp4";
        this.outPutCameraImageFileName = "";
        this.outPutCameraVideoFileName = "";
        this.outPutAudioFileName = "";
        this.queryOnlyList = new ArrayList();
        this.outPutCameraDir = "";
        this.outPutAudioDir = "";
        this.sandboxDir = "";
        this.originalPath = "";
        this.cameraPath = "";
        this.pageSize = 60;
        this.isPageStrategy = true;
        this.isFilterInvalidFile = false;
        this.isMaxSelectEnabledMask = false;
        this.animationMode = -1;
        this.isAutomaticTitleRecyclerTop = true;
        this.isQuickCapture = true;
        this.isCameraRotateImage = true;
        this.isAutoRotating = true;
        this.isSyncCover = !SdkVersionUtils.isQ();
        this.ofAllCameraType = SelectMimeType.ofAll();
        this.isOnlySandboxDir = false;
        this.requestedOrientation = -1;
        this.isCameraForegroundService = false;
        this.isResultListenerBack = true;
        this.isActivityResultBack = false;
        this.isCompressEngine = false;
        this.isLoaderDataEngine = false;
        this.isLoaderFactoryEngine = false;
        this.isSandboxFileEngine = false;
        this.isPreviewFullScreenMode = true;
        this.isPreviewZoomEffect = this.chooseMode != SelectMimeType.ofAudio();
        this.isOriginalControl = false;
        this.isInjectLayoutResource = false;
        this.isDisplayTimeAxis = true;
        this.isFastSlidingSelect = false;
        this.skipCropList = new ArrayList();
        this.sortOrder = "";
        this.isSelectZoomAnim = true;
        this.defaultAlbumName = "";
        this.isAutoVideoPlay = false;
        this.isLoopAutoPlay = false;
        this.isFilterSizeDuration = true;
        this.isPageSyncAsCount = false;
        this.isPauseResumePlay = false;
        this.isSyncWidthAndHeight = true;
        this.isOriginalSkipCompress = false;
        this.isPreloadFirst = true;
        this.isUseSystemVideoPlayer = false;
    }

    public synchronized ArrayList<LocalMedia> getSelectedResult() {
        return this.selectedResult;
    }

    public int getSelectCount() {
        return this.selectedResult.size();
    }

    public void addSelectResult(LocalMedia localMedia) {
        this.selectedResult.add(localMedia);
    }

    public void addAllSelectResult(ArrayList<LocalMedia> arrayList) {
        this.selectedResult.addAll(arrayList);
    }

    public String getResultFirstMimeType() {
        return this.selectedResult.size() > 0 ? this.selectedResult.get(0).getMimeType() : "";
    }

    public void addSelectedPreviewResult(ArrayList<LocalMedia> arrayList) {
        if (arrayList != null) {
            this.selectedPreviewResult.clear();
            this.selectedPreviewResult.addAll(arrayList);
        }
    }

    public void addAlbumDataSource(List<LocalMediaFolder> list) {
        if (list != null) {
            this.albumDataSource.clear();
            this.albumDataSource.addAll(list);
        }
    }

    public void addDataSource(ArrayList<LocalMedia> arrayList) {
        if (arrayList != null) {
            this.dataSource.clear();
            this.dataSource.addAll(arrayList);
        }
    }

    public void destroy() {
        this.imageEngine = null;
        this.compressEngine = null;
        this.compressFileEngine = null;
        this.cropEngine = null;
        this.cropFileEngine = null;
        this.sandboxFileEngine = null;
        this.uriToFileTransformEngine = null;
        this.loaderDataEngine = null;
        this.onResultCallListener = null;
        this.onCameraInterceptListener = null;
        this.onExternalPreviewEventListener = null;
        this.onInjectActivityPreviewListener = null;
        this.onEditMediaEventListener = null;
        this.onPermissionsEventListener = null;
        this.onLayoutResourceListener = null;
        this.onPreviewInterceptListener = null;
        this.onSelectLimitTipsListener = null;
        this.onSelectFilterListener = null;
        this.onPermissionDescriptionListener = null;
        this.onPermissionDeniedListener = null;
        this.onRecordAudioListener = null;
        this.onQueryFilterListener = null;
        this.onBitmapWatermarkListener = null;
        this.onVideoThumbnailEventListener = null;
        this.viewLifecycle = null;
        this.loaderFactory = null;
        this.interpolatorFactory = null;
        this.onItemSelectAnimListener = null;
        this.onSelectAnimListener = null;
        this.videoPlayerEngine = null;
        this.onCustomLoadingListener = null;
        this.currentLocalMediaFolder = null;
        this.dataSource.clear();
        this.selectedResult.clear();
        this.albumDataSource.clear();
        this.selectedPreviewResult.clear();
        PictureThreadUtils.cancel(PictureThreadUtils.getIoPool());
        BuildRecycleItemViewParams.clear();
        FileDirMap.clear();
        LocalMedia.destroyPool();
    }
}
