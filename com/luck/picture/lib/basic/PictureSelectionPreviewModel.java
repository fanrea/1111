package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.PictureSelectorPreviewFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnExternalPreviewEventListener;
import com.luck.picture.lib.interfaces.OnInjectActivityPreviewListener;
import com.luck.picture.lib.interfaces.OnInjectLayoutResourceListener;
import com.luck.picture.lib.magical.BuildRecycleItemViewParams;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DoubleUtils;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PictureSelectionPreviewModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionPreviewModel(PictureSelector pictureSelector) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.isPreviewZoomEffect = false;
    }

    public PictureSelectionPreviewModel setImageEngine(ImageEngine imageEngine) {
        this.selectionConfig.imageEngine = imageEngine;
        return this;
    }

    public PictureSelectionPreviewModel setVideoPlayerEngine(VideoPlayerEngine videoPlayerEngine) {
        this.selectionConfig.videoPlayerEngine = videoPlayerEngine;
        return this;
    }

    public PictureSelectionPreviewModel setSelectorUIStyle(PictureSelectorStyle pictureSelectorStyle) {
        if (pictureSelectorStyle != null) {
            this.selectionConfig.selectorStyle = pictureSelectorStyle;
        }
        return this;
    }

    public PictureSelectionPreviewModel setLanguage(int i) {
        this.selectionConfig.language = i;
        return this;
    }

    public PictureSelectionPreviewModel setDefaultLanguage(int i) {
        this.selectionConfig.defaultLanguage = i;
        return this;
    }

    public PictureSelectionPreviewModel setInjectLayoutResourceListener(OnInjectLayoutResourceListener onInjectLayoutResourceListener) {
        this.selectionConfig.isInjectLayoutResource = onInjectLayoutResourceListener != null;
        this.selectionConfig.onLayoutResourceListener = onInjectLayoutResourceListener;
        return this;
    }

    public PictureSelectionPreviewModel setAttachViewLifecycle(IBridgeViewLifecycle iBridgeViewLifecycle) {
        this.selectionConfig.viewLifecycle = iBridgeViewLifecycle;
        return this;
    }

    public PictureSelectionPreviewModel isUseSystemVideoPlayer(boolean z) {
        this.selectionConfig.isUseSystemVideoPlayer = z;
        return this;
    }

    public PictureSelectionPreviewModel isPreviewFullScreenMode(boolean z) {
        this.selectionConfig.isPreviewFullScreenMode = z;
        return this;
    }

    public PictureSelectionPreviewModel isPreviewZoomEffect(boolean z, ViewGroup viewGroup) {
        return isPreviewZoomEffect(z, this.selectionConfig.isPreviewFullScreenMode, viewGroup);
    }

    @Deprecated
    public PictureSelectionPreviewModel isEnableVideoSize(boolean z) {
        this.selectionConfig.isSyncWidthAndHeight = z;
        return this;
    }

    public PictureSelectionPreviewModel isSyncWidthAndHeight(boolean z) {
        this.selectionConfig.isSyncWidthAndHeight = z;
        return this;
    }

    public PictureSelectionPreviewModel isPreviewZoomEffect(boolean z, boolean z2, ViewGroup viewGroup) {
        if ((viewGroup instanceof RecyclerView) || (viewGroup instanceof ListView)) {
            if (z) {
                if (z2) {
                    BuildRecycleItemViewParams.generateViewParams(viewGroup, 0);
                } else {
                    BuildRecycleItemViewParams.generateViewParams(viewGroup, DensityUtil.getStatusBarHeight(this.selector.getActivity()));
                }
            }
            this.selectionConfig.isPreviewZoomEffect = z;
            return this;
        }
        throw new IllegalArgumentException(viewGroup.getClass().getCanonicalName() + " Must be " + RecyclerView.class + " or " + ListView.class);
    }

    public PictureSelectionPreviewModel isAutoVideoPlay(boolean z) {
        this.selectionConfig.isAutoVideoPlay = z;
        return this;
    }

    public PictureSelectionPreviewModel isLoopAutoVideoPlay(boolean z) {
        this.selectionConfig.isLoopAutoPlay = z;
        return this;
    }

    public PictureSelectionPreviewModel isVideoPauseResumePlay(boolean z) {
        this.selectionConfig.isPauseResumePlay = z;
        return this;
    }

    public PictureSelectionPreviewModel setExternalPreviewEventListener(OnExternalPreviewEventListener onExternalPreviewEventListener) {
        this.selectionConfig.onExternalPreviewEventListener = onExternalPreviewEventListener;
        return this;
    }

    public PictureSelectionPreviewModel setInjectActivityPreviewFragment(OnInjectActivityPreviewListener onInjectActivityPreviewListener) {
        this.selectionConfig.onInjectActivityPreviewListener = onInjectActivityPreviewListener;
        return this;
    }

    public PictureSelectionPreviewModel setCustomLoadingListener(OnCustomLoadingListener onCustomLoadingListener) {
        this.selectionConfig.onCustomLoadingListener = onCustomLoadingListener;
        return this;
    }

    public PictureSelectionPreviewModel isHidePreviewDownload(boolean z) {
        this.selectionConfig.isHidePreviewDownload = z;
        return this;
    }

    public void startFragmentPreview(int i, boolean z, ArrayList<LocalMedia> arrayList) {
        startFragmentPreview(null, i, z, arrayList);
    }

    public void startFragmentPreview(PictureSelectorPreviewFragment pictureSelectorPreviewFragment, int i, boolean z, ArrayList<LocalMedia> arrayList) {
        String fragmentTag;
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (this.selectionConfig.imageEngine == null && this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
        }
        if (arrayList == null || arrayList.size() == 0) {
            throw new NullPointerException("preview data is null");
        }
        FragmentManager supportFragmentManager = activity instanceof FragmentActivity ? ((FragmentActivity) activity).getSupportFragmentManager() : null;
        if (supportFragmentManager == null) {
            throw new NullPointerException("FragmentManager cannot be null");
        }
        if (pictureSelectorPreviewFragment != null) {
            fragmentTag = pictureSelectorPreviewFragment.getFragmentTag();
        } else {
            fragmentTag = PictureSelectorPreviewFragment.TAG;
            pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.newInstance();
        }
        if (ActivityCompatHelper.checkFragmentNonExits((FragmentActivity) activity, fragmentTag)) {
            ArrayList<LocalMedia> arrayList2 = new ArrayList<>(arrayList);
            pictureSelectorPreviewFragment.setExternalPreviewData(i, arrayList2.size(), arrayList2, z);
            FragmentInjectManager.injectSystemRoomFragment(supportFragmentManager, fragmentTag, pictureSelectorPreviewFragment);
        }
    }

    public void startActivityPreview(int i, boolean z, ArrayList<LocalMedia> arrayList) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (this.selectionConfig.imageEngine == null && this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
        }
        if (arrayList == null || arrayList.size() == 0) {
            throw new NullPointerException("preview data is null");
        }
        Intent intent = new Intent(activity, (Class<?>) PictureSelectorTransparentActivity.class);
        this.selectionConfig.addSelectedPreviewResult(arrayList);
        intent.putExtra(PictureConfig.EXTRA_EXTERNAL_PREVIEW, true);
        intent.putExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 2);
        intent.putExtra(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, i);
        intent.putExtra(PictureConfig.EXTRA_EXTERNAL_PREVIEW_DISPLAY_DELETE, z);
        Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivity(intent);
        } else {
            activity.startActivity(intent);
        }
        if (this.selectionConfig.isPreviewZoomEffect) {
            activity.overridePendingTransition(R.anim.ps_anim_fade_in, R.anim.ps_anim_fade_in);
        } else {
            activity.overridePendingTransition(this.selectionConfig.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
        }
    }
}
