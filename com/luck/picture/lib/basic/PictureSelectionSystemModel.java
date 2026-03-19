package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.PictureSelectorSystemFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureConfig;
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
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnPermissionDeniedListener;
import com.luck.picture.lib.interfaces.OnPermissionDescriptionListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.interfaces.OnSelectFilterListener;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.interfaces.OnVideoThumbnailEventListener;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PictureSelectionSystemModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionSystemModel(PictureSelector pictureSelector, int i) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.chooseMode = i;
        selectorConfig.isPreviewFullScreenMode = false;
        selectorConfig.isPreviewZoomEffect = false;
    }

    public PictureSelectionSystemModel setSelectionMode(int i) {
        this.selectionConfig.selectionMode = i;
        return this;
    }

    public PictureSelectionSystemModel isOriginalControl(boolean z) {
        this.selectionConfig.isCheckOriginalImage = z;
        return this;
    }

    public PictureSelectionSystemModel setSkipCropMimeType(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.selectionConfig.skipCropList.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public PictureSelectionSystemModel isOriginalSkipCompress(boolean z) {
        this.selectionConfig.isOriginalSkipCompress = z;
        return this;
    }

    @Deprecated
    public PictureSelectionSystemModel setCompressEngine(CompressEngine compressEngine) {
        this.selectionConfig.compressEngine = compressEngine;
        this.selectionConfig.isCompressEngine = true;
        return this;
    }

    public PictureSelectionSystemModel setCompressEngine(CompressFileEngine compressFileEngine) {
        this.selectionConfig.compressFileEngine = compressFileEngine;
        this.selectionConfig.isCompressEngine = true;
        return this;
    }

    @Deprecated
    public PictureSelectionSystemModel setCropEngine(CropEngine cropEngine) {
        this.selectionConfig.cropEngine = cropEngine;
        return this;
    }

    public PictureSelectionSystemModel setCropEngine(CropFileEngine cropFileEngine) {
        this.selectionConfig.cropFileEngine = cropFileEngine;
        return this;
    }

    @Deprecated
    public PictureSelectionSystemModel setSandboxFileEngine(SandboxFileEngine sandboxFileEngine) {
        if (SdkVersionUtils.isQ()) {
            this.selectionConfig.sandboxFileEngine = sandboxFileEngine;
            this.selectionConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public PictureSelectionSystemModel setSandboxFileEngine(UriToFileTransformEngine uriToFileTransformEngine) {
        if (SdkVersionUtils.isQ()) {
            this.selectionConfig.uriToFileTransformEngine = uriToFileTransformEngine;
            this.selectionConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public PictureSelectionSystemModel setSelectMaxFileSize(long j) {
        if (j >= 1048576) {
            this.selectionConfig.selectMaxFileSize = j;
        } else {
            this.selectionConfig.selectMaxFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionSystemModel setSelectMinFileSize(long j) {
        if (j >= 1048576) {
            this.selectionConfig.selectMinFileSize = j;
        } else {
            this.selectionConfig.selectMinFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionSystemModel setSelectMaxDurationSecond(int i) {
        this.selectionConfig.selectMaxDurationSecond = i * 1000;
        return this;
    }

    public PictureSelectionSystemModel setSelectMinDurationSecond(int i) {
        this.selectionConfig.selectMinDurationSecond = i * 1000;
        return this;
    }

    public PictureSelectionSystemModel setPermissionsInterceptListener(OnPermissionsInterceptListener onPermissionsInterceptListener) {
        this.selectionConfig.onPermissionsEventListener = onPermissionsInterceptListener;
        return this;
    }

    public PictureSelectionSystemModel setPermissionDescriptionListener(OnPermissionDescriptionListener onPermissionDescriptionListener) {
        this.selectionConfig.onPermissionDescriptionListener = onPermissionDescriptionListener;
        return this;
    }

    public PictureSelectionSystemModel setPermissionDeniedListener(OnPermissionDeniedListener onPermissionDeniedListener) {
        this.selectionConfig.onPermissionDeniedListener = onPermissionDeniedListener;
        return this;
    }

    public PictureSelectionSystemModel setSelectLimitTipsListener(OnSelectLimitTipsListener onSelectLimitTipsListener) {
        this.selectionConfig.onSelectLimitTipsListener = onSelectLimitTipsListener;
        return this;
    }

    public PictureSelectionSystemModel setSelectFilterListener(OnSelectFilterListener onSelectFilterListener) {
        this.selectionConfig.onSelectFilterListener = onSelectFilterListener;
        return this;
    }

    public PictureSelectionSystemModel setAddBitmapWatermarkListener(OnBitmapWatermarkEventListener onBitmapWatermarkEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onBitmapWatermarkListener = onBitmapWatermarkEventListener;
        }
        return this;
    }

    public PictureSelectionSystemModel setVideoThumbnailListener(OnVideoThumbnailEventListener onVideoThumbnailEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onVideoThumbnailEventListener = onVideoThumbnailEventListener;
        }
        return this;
    }

    public PictureSelectionSystemModel setCustomLoadingListener(OnCustomLoadingListener onCustomLoadingListener) {
        this.selectionConfig.onCustomLoadingListener = onCustomLoadingListener;
        return this;
    }

    public void forSystemResult(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
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
        this.selectionConfig.onResultCallListener = onResultCallbackListener;
        this.selectionConfig.isResultListenerBack = true;
        this.selectionConfig.isActivityResultBack = false;
        FragmentManager supportFragmentManager = activity instanceof FragmentActivity ? ((FragmentActivity) activity).getSupportFragmentManager() : null;
        if (supportFragmentManager == null) {
            throw new NullPointerException("FragmentManager cannot be null");
        }
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(PictureSelectorSystemFragment.TAG);
        if (fragmentFindFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        FragmentInjectManager.injectSystemRoomFragment(supportFragmentManager, PictureSelectorSystemFragment.TAG, PictureSelectorSystemFragment.newInstance());
    }

    public void forSystemResult() {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (!(activity instanceof IBridgePictureBehavior)) {
            throw new NullPointerException("Use only forSystemResult();,Activity or Fragment interface needs to be implemented " + IBridgePictureBehavior.class);
        }
        this.selectionConfig.isActivityResultBack = true;
        this.selectionConfig.onResultCallListener = null;
        this.selectionConfig.isResultListenerBack = false;
        FragmentManager supportFragmentManager = activity instanceof FragmentActivity ? ((FragmentActivity) activity).getSupportFragmentManager() : null;
        if (supportFragmentManager == null) {
            throw new NullPointerException("FragmentManager cannot be null");
        }
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(PictureSelectorSystemFragment.TAG);
        if (fragmentFindFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        FragmentInjectManager.injectSystemRoomFragment(supportFragmentManager, PictureSelectorSystemFragment.TAG, PictureSelectorSystemFragment.newInstance());
    }

    public void forSystemResultActivity(int i) {
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
        intent.putExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 1);
        Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        } else {
            activity.startActivityForResult(intent, i);
        }
        activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
    }

    public void forSystemResultActivity(ActivityResultLauncher<Intent> activityResultLauncher) {
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
        Intent intent = new Intent(activity, (Class<?>) PictureSelectorTransparentActivity.class);
        intent.putExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 1);
        activityResultLauncher.launch(intent);
        activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
    }

    public void forSystemResultActivity(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
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
        Intent intent = new Intent(activity, (Class<?>) PictureSelectorTransparentActivity.class);
        intent.putExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 1);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
    }
}
