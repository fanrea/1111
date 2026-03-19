package com.luck.picture.lib;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.luck.picture.lib.adapter.PicturePreviewAdapter;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.adapter.holder.PreviewGalleryAdapter;
import com.luck.picture.lib.adapter.holder.PreviewVideoHolder;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.basic.PictureMediaScannerConnection;
import com.luck.picture.lib.config.Crop;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.decoration.HorizontalItemDecoration;
import com.luck.picture.lib.decoration.WrapContentLinearLayoutManager;
import com.luck.picture.lib.dialog.PictureCommonDialog;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.MediaExtraInfo;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.loader.LocalMediaLoader;
import com.luck.picture.lib.loader.LocalMediaPageLoader;
import com.luck.picture.lib.magical.BuildRecycleItemViewParams;
import com.luck.picture.lib.magical.MagicalView;
import com.luck.picture.lib.magical.OnMagicalViewCallback;
import com.luck.picture.lib.magical.ViewParams;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DownloadFileUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ToastUtils;
import com.luck.picture.lib.utils.ValueOf;
import com.luck.picture.lib.widget.BottomNavBar;
import com.luck.picture.lib.widget.CompleteSelectView;
import com.luck.picture.lib.widget.PreviewBottomNavBar;
import com.luck.picture.lib.widget.PreviewTitleBar;
import com.luck.picture.lib.widget.TitleBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PictureSelectorPreviewFragment extends PictureCommonFragment {
    public static final String TAG = "PictureSelectorPreviewFragment";
    protected PreviewBottomNavBar bottomNarBar;
    protected CompleteSelectView completeSelectView;
    protected int curPosition;
    protected String currentAlbum;
    protected boolean isAnimationStart;
    protected boolean isDisplayDelete;
    protected boolean isExternalPreview;
    protected boolean isInternalBottomPreview;
    protected boolean isSaveInstanceState;
    protected boolean isShowCamera;
    protected PreviewGalleryAdapter mGalleryAdapter;
    protected RecyclerView mGalleryRecycle;
    protected MagicalView magicalView;
    protected int screenHeight;
    protected int screenWidth;
    protected View selectClickArea;
    protected PreviewTitleBar titleBar;
    protected int totalNum;
    protected TextView tvSelected;
    protected TextView tvSelectedWord;
    protected PicturePreviewAdapter viewPageAdapter;
    protected ViewPager2 viewPager;
    protected ArrayList<LocalMedia> mData = new ArrayList<>();
    protected boolean isHasMore = true;
    protected long mBucketId = -1;
    protected boolean needScaleBig = true;
    protected boolean needScaleSmall = false;
    protected List<View> mAnimViews = new ArrayList();
    private boolean isPause = false;
    private final ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.22
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            ArrayList<LocalMedia> arrayList;
            if (PictureSelectorPreviewFragment.this.mData.size() > i) {
                if (i2 < PictureSelectorPreviewFragment.this.screenWidth / 2) {
                    arrayList = PictureSelectorPreviewFragment.this.mData;
                } else {
                    arrayList = PictureSelectorPreviewFragment.this.mData;
                    i++;
                }
                LocalMedia localMedia = arrayList.get(i);
                PictureSelectorPreviewFragment.this.tvSelected.setSelected(PictureSelectorPreviewFragment.this.isSelected(localMedia));
                PictureSelectorPreviewFragment.this.notifyGallerySelectMedia(localMedia);
                PictureSelectorPreviewFragment.this.notifySelectNumberStyle(localMedia);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            PictureSelectorPreviewFragment.this.curPosition = i;
            PictureSelectorPreviewFragment.this.titleBar.setTitle((PictureSelectorPreviewFragment.this.curPosition + 1) + "/" + PictureSelectorPreviewFragment.this.totalNum);
            if (PictureSelectorPreviewFragment.this.mData.size() > i) {
                LocalMedia localMedia = PictureSelectorPreviewFragment.this.mData.get(i);
                PictureSelectorPreviewFragment.this.notifySelectNumberStyle(localMedia);
                if (PictureSelectorPreviewFragment.this.isHasMagicalEffect()) {
                    PictureSelectorPreviewFragment.this.changeMagicalViewParams(i);
                }
                if (!PictureSelectorPreviewFragment.this.selectorConfig.isPreviewZoomEffect) {
                    if (PictureSelectorPreviewFragment.this.selectorConfig.isAutoVideoPlay) {
                        PictureSelectorPreviewFragment.this.startAutoVideoPlay(i);
                    }
                } else if (PictureSelectorPreviewFragment.this.isInternalBottomPreview && PictureSelectorPreviewFragment.this.selectorConfig.isAutoVideoPlay) {
                    PictureSelectorPreviewFragment.this.startAutoVideoPlay(i);
                } else {
                    PictureSelectorPreviewFragment.this.viewPageAdapter.setVideoPlayButtonUI(i);
                }
                PictureSelectorPreviewFragment.this.notifyGallerySelectMedia(localMedia);
                PictureSelectorPreviewFragment.this.bottomNarBar.isDisplayEditor(PictureMimeType.isHasVideo(localMedia.getMimeType()) || PictureMimeType.isHasAudio(localMedia.getMimeType()));
                if (PictureSelectorPreviewFragment.this.isExternalPreview || PictureSelectorPreviewFragment.this.isInternalBottomPreview || PictureSelectorPreviewFragment.this.selectorConfig.isOnlySandboxDir || !PictureSelectorPreviewFragment.this.selectorConfig.isPageStrategy || !PictureSelectorPreviewFragment.this.isHasMore) {
                    return;
                }
                if (i == (PictureSelectorPreviewFragment.this.viewPageAdapter.getItemCount() - 1) - 10 || i == PictureSelectorPreviewFragment.this.viewPageAdapter.getItemCount() - 1) {
                    PictureSelectorPreviewFragment.this.loadMoreData();
                }
            }
        }
    };

    public static PictureSelectorPreviewFragment newInstance() {
        PictureSelectorPreviewFragment pictureSelectorPreviewFragment = new PictureSelectorPreviewFragment();
        pictureSelectorPreviewFragment.setArguments(new Bundle());
        return pictureSelectorPreviewFragment;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment
    public String getFragmentTag() {
        return TAG;
    }

    public void setInternalPreviewData(boolean z, String str, boolean z2, int i, int i2, int i3, long j, ArrayList<LocalMedia> arrayList) {
        this.mPage = i3;
        this.mBucketId = j;
        this.mData = arrayList;
        this.totalNum = i2;
        this.curPosition = i;
        this.currentAlbum = str;
        this.isShowCamera = z2;
        this.isInternalBottomPreview = z;
    }

    public void setExternalPreviewData(int i, int i2, ArrayList<LocalMedia> arrayList, boolean z) {
        this.mData = arrayList;
        this.totalNum = i2;
        this.curPosition = i;
        this.isDisplayDelete = z;
        this.isExternalPreview = true;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public int getResourceId() {
        int layoutResource = InjectResourceSource.getLayoutResource(getContext(), 2, this.selectorConfig);
        return layoutResource != 0 ? layoutResource : R.layout.ps_fragment_preview;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onSelectedChange(boolean z, LocalMedia localMedia) {
        this.tvSelected.setSelected(this.selectorConfig.getSelectedResult().contains(localMedia));
        this.bottomNarBar.setSelectedChange();
        this.completeSelectView.setSelectedChange(true);
        notifySelectNumberStyle(localMedia);
        notifyPreviewGalleryData(z, localMedia);
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onCheckOriginalChange() {
        this.bottomNarBar.setOriginalCheck();
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        reStartSavedInstance(bundle);
        this.isSaveInstanceState = bundle != null;
        this.screenWidth = DensityUtil.getRealScreenWidth(getContext());
        this.screenHeight = DensityUtil.getScreenHeight(getContext());
        this.titleBar = (PreviewTitleBar) view.findViewById(R.id.title_bar);
        this.tvSelected = (TextView) view.findViewById(R.id.ps_tv_selected);
        this.tvSelectedWord = (TextView) view.findViewById(R.id.ps_tv_selected_word);
        this.selectClickArea = view.findViewById(R.id.select_click_area);
        this.completeSelectView = (CompleteSelectView) view.findViewById(R.id.ps_complete_select);
        this.magicalView = (MagicalView) view.findViewById(R.id.magical);
        this.viewPager = new ViewPager2(getContext());
        this.bottomNarBar = (PreviewBottomNavBar) view.findViewById(R.id.bottom_nar_bar);
        this.magicalView.setMagicalContent(this.viewPager);
        setMagicalViewBackgroundColor();
        setMagicalViewAction();
        addAminViews(this.titleBar, this.tvSelected, this.tvSelectedWord, this.selectClickArea, this.completeSelectView, this.bottomNarBar);
        onCreateLoader();
        initTitleBar();
        initViewPagerData(this.mData);
        if (this.isExternalPreview) {
            externalPreviewStyle();
        } else {
            initBottomNavBar();
            initPreviewSelectGallery((ViewGroup) view);
            initComplete();
        }
        iniMagicalView();
    }

    public void addAminViews(View... viewArr) {
        Collections.addAll(this.mAnimViews, viewArr);
    }

    private void setMagicalViewBackgroundColor() {
        ArrayList<LocalMedia> arrayList;
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewBackgroundColor())) {
            this.magicalView.setBackgroundColor(selectMainStyle.getPreviewBackgroundColor());
            return;
        }
        if (this.selectorConfig.chooseMode == SelectMimeType.ofAudio() || ((arrayList = this.mData) != null && arrayList.size() > 0 && PictureMimeType.isHasAudio(this.mData.get(0).getMimeType()))) {
            this.magicalView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ps_color_white));
        } else {
            this.magicalView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ps_color_black));
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void reStartSavedInstance(Bundle bundle) {
        if (bundle != null) {
            this.mPage = bundle.getInt(PictureConfig.EXTRA_CURRENT_PAGE, 1);
            this.mBucketId = bundle.getLong(PictureConfig.EXTRA_CURRENT_BUCKET_ID, -1L);
            this.curPosition = bundle.getInt(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, this.curPosition);
            this.isShowCamera = bundle.getBoolean(PictureConfig.EXTRA_DISPLAY_CAMERA, this.isShowCamera);
            this.totalNum = bundle.getInt(PictureConfig.EXTRA_PREVIEW_CURRENT_ALBUM_TOTAL, this.totalNum);
            this.isExternalPreview = bundle.getBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW, this.isExternalPreview);
            this.isDisplayDelete = bundle.getBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW_DISPLAY_DELETE, this.isDisplayDelete);
            this.isInternalBottomPreview = bundle.getBoolean(PictureConfig.EXTRA_BOTTOM_PREVIEW, this.isInternalBottomPreview);
            this.currentAlbum = bundle.getString(PictureConfig.EXTRA_CURRENT_ALBUM_NAME, "");
            if (this.mData.size() == 0) {
                this.mData.addAll(new ArrayList(this.selectorConfig.selectedPreviewResult));
            }
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onKeyBackFragmentFinish() {
        onKeyDownBackToMin();
    }

    private void iniMagicalView() {
        if (isHasMagicalEffect()) {
            float f = this.isSaveInstanceState ? 1.0f : 0.0f;
            this.magicalView.setBackgroundAlpha(f);
            for (int i = 0; i < this.mAnimViews.size(); i++) {
                if (!(this.mAnimViews.get(i) instanceof TitleBar)) {
                    this.mAnimViews.get(i).setAlpha(f);
                }
            }
            return;
        }
        this.magicalView.setBackgroundAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHasMagicalEffect() {
        return !this.isInternalBottomPreview && this.selectorConfig.isPreviewZoomEffect;
    }

    protected void setMagicalViewAction() {
        if (isHasMagicalEffect()) {
            this.magicalView.setOnMojitoViewCallback(new OnMagicalViewCallback() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.1
                @Override // com.luck.picture.lib.magical.OnMagicalViewCallback
                public void onBeginBackMinAnim() {
                    PictureSelectorPreviewFragment.this.onMojitoBeginBackMinAnim();
                }

                @Override // com.luck.picture.lib.magical.OnMagicalViewCallback
                public void onBeginMagicalAnimComplete(MagicalView magicalView, boolean z) {
                    PictureSelectorPreviewFragment.this.onMojitoBeginAnimComplete(magicalView, z);
                }

                @Override // com.luck.picture.lib.magical.OnMagicalViewCallback
                public void onBackgroundAlpha(float f) {
                    PictureSelectorPreviewFragment.this.onMojitoBackgroundAlpha(f);
                }

                @Override // com.luck.picture.lib.magical.OnMagicalViewCallback
                public void onMagicalViewFinish() {
                    PictureSelectorPreviewFragment.this.onMojitoMagicalViewFinish();
                }

                @Override // com.luck.picture.lib.magical.OnMagicalViewCallback
                public void onBeginBackMinMagicalFinish(boolean z) {
                    PictureSelectorPreviewFragment.this.onMojitoBeginBackMinFinish(z);
                }
            });
        }
    }

    protected void onMojitoBeginBackMinAnim() {
        BasePreviewHolder currentHolder = this.viewPageAdapter.getCurrentHolder(this.viewPager.getCurrentItem());
        if (currentHolder == null) {
            return;
        }
        if (currentHolder.coverImageView.getVisibility() == 8) {
            currentHolder.coverImageView.setVisibility(0);
        }
        if (currentHolder instanceof PreviewVideoHolder) {
            PreviewVideoHolder previewVideoHolder = (PreviewVideoHolder) currentHolder;
            if (previewVideoHolder.ivPlayButton.getVisibility() == 0) {
                previewVideoHolder.ivPlayButton.setVisibility(8);
            }
        }
    }

    protected void onMojitoMagicalViewFinish() {
        if (this.isExternalPreview && isNormalDefaultEnter() && isHasMagicalEffect()) {
            onExitPictureSelector();
        } else {
            onBackCurrentFragment();
        }
    }

    protected void onMojitoBackgroundAlpha(float f) {
        for (int i = 0; i < this.mAnimViews.size(); i++) {
            if (!(this.mAnimViews.get(i) instanceof TitleBar)) {
                this.mAnimViews.get(i).setAlpha(f);
            }
        }
    }

    protected void onMojitoBeginBackMinFinish(boolean z) {
        BasePreviewHolder currentHolder;
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(this.isShowCamera ? this.curPosition + 1 : this.curPosition);
        if (itemViewParams == null || (currentHolder = this.viewPageAdapter.getCurrentHolder(this.viewPager.getCurrentItem())) == null) {
            return;
        }
        currentHolder.coverImageView.getLayoutParams().width = itemViewParams.width;
        currentHolder.coverImageView.getLayoutParams().height = itemViewParams.height;
        currentHolder.coverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void onMojitoBeginAnimComplete(MagicalView magicalView, boolean z) {
        int width;
        int height;
        BasePreviewHolder currentHolder = this.viewPageAdapter.getCurrentHolder(this.viewPager.getCurrentItem());
        if (currentHolder == null) {
            return;
        }
        LocalMedia localMedia = this.mData.get(this.viewPager.getCurrentItem());
        if (localMedia.isCut() && localMedia.getCropImageWidth() > 0 && localMedia.getCropImageHeight() > 0) {
            width = localMedia.getCropImageWidth();
            height = localMedia.getCropImageHeight();
        } else {
            width = localMedia.getWidth();
            height = localMedia.getHeight();
        }
        if (MediaUtils.isLongImage(width, height)) {
            currentHolder.coverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            currentHolder.coverImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (currentHolder instanceof PreviewVideoHolder) {
            PreviewVideoHolder previewVideoHolder = (PreviewVideoHolder) currentHolder;
            if (this.selectorConfig.isAutoVideoPlay) {
                startAutoVideoPlay(this.viewPager.getCurrentItem());
            } else {
                if (previewVideoHolder.ivPlayButton.getVisibility() != 8 || isPlaying()) {
                    return;
                }
                previewVideoHolder.ivPlayButton.setVisibility(0);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PictureConfig.EXTRA_CURRENT_PAGE, this.mPage);
        bundle.putLong(PictureConfig.EXTRA_CURRENT_BUCKET_ID, this.mBucketId);
        bundle.putInt(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, this.curPosition);
        bundle.putInt(PictureConfig.EXTRA_PREVIEW_CURRENT_ALBUM_TOTAL, this.totalNum);
        bundle.putBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW, this.isExternalPreview);
        bundle.putBoolean(PictureConfig.EXTRA_EXTERNAL_PREVIEW_DISPLAY_DELETE, this.isDisplayDelete);
        bundle.putBoolean(PictureConfig.EXTRA_DISPLAY_CAMERA, this.isShowCamera);
        bundle.putBoolean(PictureConfig.EXTRA_BOTTOM_PREVIEW, this.isInternalBottomPreview);
        bundle.putString(PictureConfig.EXTRA_CURRENT_ALBUM_NAME, this.currentAlbum);
        this.selectorConfig.addSelectedPreviewResult(this.mData);
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) throws Resources.NotFoundException {
        if (isHasMagicalEffect()) {
            return null;
        }
        PictureWindowAnimationStyle windowAnimationStyle = this.selectorConfig.selectorStyle.getWindowAnimationStyle();
        if (windowAnimationStyle.activityPreviewEnterAnimation != 0 && windowAnimationStyle.activityPreviewExitAnimation != 0) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity(), z ? windowAnimationStyle.activityPreviewEnterAnimation : windowAnimationStyle.activityPreviewExitAnimation);
            if (z) {
                onEnterFragment();
            } else {
                onExitFragment();
            }
            return animationLoadAnimation;
        }
        return super.onCreateAnimation(i, z, i2);
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void sendChangeSubSelectPositionEvent(boolean z) {
        if (this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewSelectNumberStyle() && this.selectorConfig.selectorStyle.getSelectMainStyle().isSelectNumberStyle()) {
            int i = 0;
            while (i < this.selectorConfig.getSelectCount()) {
                LocalMedia localMedia = this.selectorConfig.getSelectedResult().get(i);
                i++;
                localMedia.setNum(i);
            }
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (isHasMagicalEffect()) {
            int size = this.mData.size();
            int i = this.curPosition;
            if (size > i) {
                LocalMedia localMedia = this.mData.get(i);
                if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                    getVideoRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.2
                        @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                        public void onCall(int[] iArr) {
                            PictureSelectorPreviewFragment.this.changeViewParams(iArr);
                        }
                    });
                } else {
                    getImageRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.3
                        @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                        public void onCall(int[] iArr) {
                            PictureSelectorPreviewFragment.this.changeViewParams(iArr);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeViewParams(int[] iArr) {
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(this.isShowCamera ? this.curPosition + 1 : this.curPosition);
        if (itemViewParams == null || iArr[0] == 0 || iArr[1] == 0) {
            this.magicalView.setViewParams(0, 0, 0, 0, iArr[0], iArr[1]);
            this.magicalView.resetStartNormal(iArr[0], iArr[1], false);
        } else {
            this.magicalView.setViewParams(itemViewParams.left, itemViewParams.top, itemViewParams.width, itemViewParams.height, iArr[0], iArr[1]);
            this.magicalView.resetStart();
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onCreateLoader() {
        IBridgeMediaLoader localMediaLoader;
        if (this.isExternalPreview) {
            return;
        }
        if (this.selectorConfig.loaderFactory != null) {
            this.mLoader = this.selectorConfig.loaderFactory.onCreateLoader();
            if (this.mLoader == null) {
                throw new NullPointerException("No available " + IBridgeMediaLoader.class + " loader found");
            }
        } else {
            if (this.selectorConfig.isPageStrategy) {
                localMediaLoader = new LocalMediaPageLoader(getAppContext(), this.selectorConfig);
            } else {
                localMediaLoader = new LocalMediaLoader(getAppContext(), this.selectorConfig);
            }
            this.mLoader = localMediaLoader;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMoreData() {
        this.mPage++;
        if (this.selectorConfig.loaderDataEngine != null) {
            this.selectorConfig.loaderDataEngine.loadMoreMediaData(getContext(), this.mBucketId, this.mPage, this.selectorConfig.pageSize, this.selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.4
                @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
                public void onComplete(ArrayList<LocalMedia> arrayList, boolean z) {
                    PictureSelectorPreviewFragment.this.handleMoreData(arrayList, z);
                }
            });
        } else {
            this.mLoader.loadPageMediaData(this.mBucketId, this.mPage, this.selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.5
                @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
                public void onComplete(ArrayList<LocalMedia> arrayList, boolean z) {
                    PictureSelectorPreviewFragment.this.handleMoreData(arrayList, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMoreData(List<LocalMedia> list, boolean z) {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        this.isHasMore = z;
        if (z) {
            if (list.size() > 0) {
                int size = this.mData.size();
                this.mData.addAll(list);
                this.viewPageAdapter.notifyItemRangeChanged(size, this.mData.size());
                return;
            }
            loadMoreData();
        }
    }

    private void initComplete() {
        final SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewSelectBackground())) {
            this.tvSelected.setBackgroundResource(selectMainStyle.getPreviewSelectBackground());
        } else if (StyleUtils.checkStyleValidity(selectMainStyle.getSelectBackground())) {
            this.tvSelected.setBackgroundResource(selectMainStyle.getSelectBackground());
        }
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewSelectTextResId())) {
            this.tvSelectedWord.setText(getString(selectMainStyle.getPreviewSelectTextResId()));
        } else if (StyleUtils.checkTextValidity(selectMainStyle.getPreviewSelectText())) {
            this.tvSelectedWord.setText(selectMainStyle.getPreviewSelectText());
        } else {
            this.tvSelectedWord.setText("");
        }
        if (StyleUtils.checkSizeValidity(selectMainStyle.getPreviewSelectTextSize())) {
            this.tvSelectedWord.setTextSize(selectMainStyle.getPreviewSelectTextSize());
        }
        if (StyleUtils.checkStyleValidity(selectMainStyle.getPreviewSelectTextColor())) {
            this.tvSelectedWord.setTextColor(selectMainStyle.getPreviewSelectTextColor());
        }
        if (StyleUtils.checkSizeValidity(selectMainStyle.getPreviewSelectMarginRight())) {
            if (this.tvSelected.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                if (this.tvSelected.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                    ((ConstraintLayout.LayoutParams) this.tvSelected.getLayoutParams()).rightMargin = selectMainStyle.getPreviewSelectMarginRight();
                }
            } else if (this.tvSelected.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.tvSelected.getLayoutParams()).rightMargin = selectMainStyle.getPreviewSelectMarginRight();
            }
        }
        this.completeSelectView.setCompleteSelectViewStyle();
        this.completeSelectView.setSelectedChange(true);
        if (selectMainStyle.isCompleteSelectRelativeTop()) {
            if (this.completeSelectView.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) this.completeSelectView.getLayoutParams()).topToTop = R.id.title_bar;
                ((ConstraintLayout.LayoutParams) this.completeSelectView.getLayoutParams()).bottomToBottom = R.id.title_bar;
                if (this.selectorConfig.isPreviewFullScreenMode) {
                    ((ConstraintLayout.LayoutParams) this.completeSelectView.getLayoutParams()).topMargin = DensityUtil.getStatusBarHeight(getContext());
                }
            } else if ((this.completeSelectView.getLayoutParams() instanceof RelativeLayout.LayoutParams) && this.selectorConfig.isPreviewFullScreenMode) {
                ((RelativeLayout.LayoutParams) this.completeSelectView.getLayoutParams()).topMargin = DensityUtil.getStatusBarHeight(getContext());
            }
        }
        if (selectMainStyle.isPreviewSelectRelativeBottom()) {
            if (this.tvSelected.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) this.tvSelected.getLayoutParams()).topToTop = R.id.bottom_nar_bar;
                ((ConstraintLayout.LayoutParams) this.tvSelected.getLayoutParams()).bottomToBottom = R.id.bottom_nar_bar;
                ((ConstraintLayout.LayoutParams) this.tvSelectedWord.getLayoutParams()).topToTop = R.id.bottom_nar_bar;
                ((ConstraintLayout.LayoutParams) this.tvSelectedWord.getLayoutParams()).bottomToBottom = R.id.bottom_nar_bar;
                ((ConstraintLayout.LayoutParams) this.selectClickArea.getLayoutParams()).topToTop = R.id.bottom_nar_bar;
                ((ConstraintLayout.LayoutParams) this.selectClickArea.getLayoutParams()).bottomToBottom = R.id.bottom_nar_bar;
            }
        } else if (this.selectorConfig.isPreviewFullScreenMode) {
            if (this.tvSelectedWord.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) this.tvSelectedWord.getLayoutParams()).topMargin = DensityUtil.getStatusBarHeight(getContext());
            } else if (this.tvSelectedWord.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.tvSelectedWord.getLayoutParams()).topMargin = DensityUtil.getStatusBarHeight(getContext());
            }
        }
        this.completeSelectView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.6
            /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onClick(android.view.View r5) {
                /*
                    r4 = this;
                    com.luck.picture.lib.style.SelectMainStyle r5 = r2
                    boolean r5 = r5.isCompleteSelectRelativeTop()
                    r0 = 1
                    r1 = 0
                    if (r5 == 0) goto L31
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.access$200(r5)
                    int r5 = r5.getSelectCount()
                    if (r5 != 0) goto L31
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    java.util.ArrayList<com.luck.picture.lib.entity.LocalMedia> r2 = r5.mData
                    com.luck.picture.lib.PictureSelectorPreviewFragment r3 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    androidx.viewpager2.widget.ViewPager2 r3 = r3.viewPager
                    int r3 = r3.getCurrentItem()
                    java.lang.Object r2 = r2.get(r3)
                    com.luck.picture.lib.entity.LocalMedia r2 = (com.luck.picture.lib.entity.LocalMedia) r2
                    int r5 = r5.confirmSelect(r2, r1)
                    if (r5 != 0) goto L2f
                    goto L3d
                L2f:
                    r0 = r1
                    goto L3d
                L31:
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.access$300(r5)
                    int r5 = r5.getSelectCount()
                    if (r5 <= 0) goto L2f
                L3d:
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.access$400(r5)
                    boolean r5 = r5.isEmptyResultReturn
                    if (r5 == 0) goto L59
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.config.SelectorConfig r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.access$500(r5)
                    int r5 = r5.getSelectCount()
                    if (r5 != 0) goto L59
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    r5.onExitPictureSelector()
                    goto L60
                L59:
                    if (r0 == 0) goto L60
                    com.luck.picture.lib.PictureSelectorPreviewFragment r5 = com.luck.picture.lib.PictureSelectorPreviewFragment.this
                    com.luck.picture.lib.PictureSelectorPreviewFragment.access$600(r5)
                L60:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorPreviewFragment.AnonymousClass6.onClick(android.view.View):void");
            }
        });
    }

    private void initTitleBar() {
        if (this.selectorConfig.selectorStyle.getTitleBarStyle().isHideTitleBar()) {
            this.titleBar.setVisibility(8);
        }
        this.titleBar.setTitleBarStyle();
        this.titleBar.setOnTitleBarListener(new TitleBar.OnTitleBarListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.7
            @Override // com.luck.picture.lib.widget.TitleBar.OnTitleBarListener
            public void onBackPressed() {
                if (PictureSelectorPreviewFragment.this.isExternalPreview) {
                    if (!PictureSelectorPreviewFragment.this.selectorConfig.isPreviewZoomEffect) {
                        PictureSelectorPreviewFragment.this.handleExternalPreviewBack();
                        return;
                    } else {
                        PictureSelectorPreviewFragment.this.magicalView.backToMin();
                        return;
                    }
                }
                if (PictureSelectorPreviewFragment.this.isInternalBottomPreview || !PictureSelectorPreviewFragment.this.selectorConfig.isPreviewZoomEffect) {
                    PictureSelectorPreviewFragment.this.onBackCurrentFragment();
                } else {
                    PictureSelectorPreviewFragment.this.magicalView.backToMin();
                }
            }
        });
        this.titleBar.setTitle((this.curPosition + 1) + "/" + this.totalNum);
        this.titleBar.getImageDelete().setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PictureSelectorPreviewFragment.this.deletePreview();
            }
        });
        this.selectClickArea.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PictureSelectorPreviewFragment.this.isExternalPreview) {
                    PictureSelectorPreviewFragment.this.deletePreview();
                    return;
                }
                LocalMedia localMedia = PictureSelectorPreviewFragment.this.mData.get(PictureSelectorPreviewFragment.this.viewPager.getCurrentItem());
                PictureSelectorPreviewFragment pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.this;
                if (pictureSelectorPreviewFragment.confirmSelect(localMedia, pictureSelectorPreviewFragment.tvSelected.isSelected()) == 0) {
                    if (PictureSelectorPreviewFragment.this.selectorConfig.onSelectAnimListener != null) {
                        PictureSelectorPreviewFragment.this.selectorConfig.onSelectAnimListener.onSelectAnim(PictureSelectorPreviewFragment.this.tvSelected);
                    } else {
                        PictureSelectorPreviewFragment.this.tvSelected.startAnimation(AnimationUtils.loadAnimation(PictureSelectorPreviewFragment.this.getContext(), R.anim.ps_anim_modal_in));
                    }
                }
            }
        });
        this.tvSelected.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PictureSelectorPreviewFragment.this.selectClickArea.performClick();
            }
        });
    }

    protected void initPreviewSelectGallery(ViewGroup viewGroup) {
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        if (selectMainStyle.isPreviewDisplaySelectGallery()) {
            this.mGalleryRecycle = new RecyclerView(getContext());
            if (StyleUtils.checkStyleValidity(selectMainStyle.getAdapterPreviewGalleryBackgroundResource())) {
                this.mGalleryRecycle.setBackgroundResource(selectMainStyle.getAdapterPreviewGalleryBackgroundResource());
            } else {
                this.mGalleryRecycle.setBackgroundResource(R.drawable.ps_preview_gallery_bg);
            }
            viewGroup.addView(this.mGalleryRecycle);
            ViewGroup.LayoutParams layoutParams = this.mGalleryRecycle.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                layoutParams2.bottomToTop = R.id.bottom_nar_bar;
                layoutParams2.startToStart = 0;
                layoutParams2.endToEnd = 0;
            }
            WrapContentLinearLayoutManager wrapContentLinearLayoutManager = new WrapContentLinearLayoutManager(getContext()) { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.11
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
                    super.smoothScrollToPosition(recyclerView, state, i);
                    LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.11.1
                        @Override // androidx.recyclerview.widget.LinearSmoothScroller
                        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                            return 300.0f / displayMetrics.densityDpi;
                        }
                    };
                    linearSmoothScroller.setTargetPosition(i);
                    startSmoothScroll(linearSmoothScroller);
                }
            };
            RecyclerView.ItemAnimator itemAnimator = this.mGalleryRecycle.getItemAnimator();
            if (itemAnimator != null) {
                ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            }
            if (this.mGalleryRecycle.getItemDecorationCount() == 0) {
                this.mGalleryRecycle.addItemDecoration(new HorizontalItemDecoration(Integer.MAX_VALUE, DensityUtil.dip2px(getContext(), 6.0f)));
            }
            wrapContentLinearLayoutManager.setOrientation(0);
            this.mGalleryRecycle.setLayoutManager(wrapContentLinearLayoutManager);
            if (this.selectorConfig.getSelectCount() > 0) {
                this.mGalleryRecycle.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getContext(), R.anim.ps_anim_layout_fall_enter));
            }
            this.mGalleryAdapter = new PreviewGalleryAdapter(this.selectorConfig, this.isInternalBottomPreview);
            notifyGallerySelectMedia(this.mData.get(this.curPosition));
            this.mGalleryRecycle.setAdapter(this.mGalleryAdapter);
            this.mGalleryAdapter.setItemClickListener(new PreviewGalleryAdapter.OnItemClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.12
                @Override // com.luck.picture.lib.adapter.holder.PreviewGalleryAdapter.OnItemClickListener
                public void onItemClick(final int i, LocalMedia localMedia, View view) {
                    if (i == -1) {
                        return;
                    }
                    String string = TextUtils.isEmpty(PictureSelectorPreviewFragment.this.selectorConfig.defaultAlbumName) ? PictureSelectorPreviewFragment.this.getString(R.string.ps_camera_roll) : PictureSelectorPreviewFragment.this.selectorConfig.defaultAlbumName;
                    if (PictureSelectorPreviewFragment.this.isInternalBottomPreview || TextUtils.equals(PictureSelectorPreviewFragment.this.currentAlbum, string) || TextUtils.equals(localMedia.getParentFolderName(), PictureSelectorPreviewFragment.this.currentAlbum)) {
                        if (!PictureSelectorPreviewFragment.this.isInternalBottomPreview) {
                            i = PictureSelectorPreviewFragment.this.isShowCamera ? localMedia.position - 1 : localMedia.position;
                        }
                        if (i == PictureSelectorPreviewFragment.this.viewPager.getCurrentItem() && localMedia.isChecked()) {
                            return;
                        }
                        LocalMedia item = PictureSelectorPreviewFragment.this.viewPageAdapter.getItem(i);
                        if (item == null || (TextUtils.equals(localMedia.getPath(), item.getPath()) && localMedia.getId() == item.getId())) {
                            if (PictureSelectorPreviewFragment.this.viewPager.getAdapter() != null) {
                                PictureSelectorPreviewFragment.this.viewPager.setAdapter(null);
                                PictureSelectorPreviewFragment.this.viewPager.setAdapter(PictureSelectorPreviewFragment.this.viewPageAdapter);
                            }
                            PictureSelectorPreviewFragment.this.viewPager.setCurrentItem(i, false);
                            PictureSelectorPreviewFragment.this.notifyGallerySelectMedia(localMedia);
                            PictureSelectorPreviewFragment.this.viewPager.post(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.12.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PictureSelectorPreviewFragment.this.selectorConfig.isPreviewZoomEffect) {
                                        PictureSelectorPreviewFragment.this.viewPageAdapter.setVideoPlayButtonUI(i);
                                    }
                                }
                            });
                        }
                    }
                }
            });
            if (this.selectorConfig.getSelectCount() > 0) {
                this.mGalleryRecycle.setVisibility(0);
            } else {
                this.mGalleryRecycle.setVisibility(4);
            }
            addAminViews(this.mGalleryRecycle);
            final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.13
                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public boolean isLongPressDragEnabled() {
                    return true;
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    viewHolder.itemView.setAlpha(0.7f);
                    return makeMovementFlags(12, 0);
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                    try {
                        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                        int absoluteAdapterPosition2 = viewHolder2.getAbsoluteAdapterPosition();
                        if (absoluteAdapterPosition < absoluteAdapterPosition2) {
                            int i = absoluteAdapterPosition;
                            while (i < absoluteAdapterPosition2) {
                                int i2 = i + 1;
                                Collections.swap(PictureSelectorPreviewFragment.this.mGalleryAdapter.getData(), i, i2);
                                Collections.swap(PictureSelectorPreviewFragment.this.selectorConfig.getSelectedResult(), i, i2);
                                if (PictureSelectorPreviewFragment.this.isInternalBottomPreview) {
                                    Collections.swap(PictureSelectorPreviewFragment.this.mData, i, i2);
                                }
                                i = i2;
                            }
                        } else {
                            for (int i3 = absoluteAdapterPosition; i3 > absoluteAdapterPosition2; i3--) {
                                int i4 = i3 - 1;
                                Collections.swap(PictureSelectorPreviewFragment.this.mGalleryAdapter.getData(), i3, i4);
                                Collections.swap(PictureSelectorPreviewFragment.this.selectorConfig.getSelectedResult(), i3, i4);
                                if (PictureSelectorPreviewFragment.this.isInternalBottomPreview) {
                                    Collections.swap(PictureSelectorPreviewFragment.this.mData, i3, i4);
                                }
                            }
                        }
                        PictureSelectorPreviewFragment.this.mGalleryAdapter.notifyItemMoved(absoluteAdapterPosition, absoluteAdapterPosition2);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return true;
                    }
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
                    if (PictureSelectorPreviewFragment.this.needScaleBig) {
                        PictureSelectorPreviewFragment.this.needScaleBig = false;
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", 1.0f, 1.1f), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", 1.0f, 1.1f));
                        animatorSet.setDuration(50L);
                        animatorSet.setInterpolator(new LinearInterpolator());
                        animatorSet.start();
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.13.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                PictureSelectorPreviewFragment.this.needScaleSmall = true;
                            }
                        });
                    }
                    super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
                    super.onSelectedChanged(viewHolder, i);
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
                    return super.getAnimationDuration(recyclerView, i, f, f2);
                }

                @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
                public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    int lastCheckPosition;
                    viewHolder.itemView.setAlpha(1.0f);
                    if (PictureSelectorPreviewFragment.this.needScaleSmall) {
                        PictureSelectorPreviewFragment.this.needScaleSmall = false;
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(ObjectAnimator.ofFloat(viewHolder.itemView, "scaleX", 1.1f, 1.0f), ObjectAnimator.ofFloat(viewHolder.itemView, "scaleY", 1.1f, 1.0f));
                        animatorSet.setInterpolator(new LinearInterpolator());
                        animatorSet.setDuration(50L);
                        animatorSet.start();
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.13.2
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                PictureSelectorPreviewFragment.this.needScaleBig = true;
                            }
                        });
                    }
                    super.clearView(recyclerView, viewHolder);
                    PictureSelectorPreviewFragment.this.mGalleryAdapter.notifyItemChanged(viewHolder.getAbsoluteAdapterPosition());
                    if (PictureSelectorPreviewFragment.this.isInternalBottomPreview && PictureSelectorPreviewFragment.this.viewPager.getCurrentItem() != (lastCheckPosition = PictureSelectorPreviewFragment.this.mGalleryAdapter.getLastCheckPosition()) && lastCheckPosition != -1) {
                        if (PictureSelectorPreviewFragment.this.viewPager.getAdapter() != null) {
                            PictureSelectorPreviewFragment.this.viewPager.setAdapter(null);
                            PictureSelectorPreviewFragment.this.viewPager.setAdapter(PictureSelectorPreviewFragment.this.viewPageAdapter);
                        }
                        PictureSelectorPreviewFragment.this.viewPager.setCurrentItem(lastCheckPosition, false);
                    }
                    if (!PictureSelectorPreviewFragment.this.selectorConfig.selectorStyle.getSelectMainStyle().isSelectNumberStyle() || ActivityCompatHelper.isDestroy(PictureSelectorPreviewFragment.this.getActivity())) {
                        return;
                    }
                    List<Fragment> fragments = PictureSelectorPreviewFragment.this.getActivity().getSupportFragmentManager().getFragments();
                    for (int i = 0; i < fragments.size(); i++) {
                        Fragment fragment = fragments.get(i);
                        if (fragment instanceof PictureCommonFragment) {
                            ((PictureCommonFragment) fragment).sendChangeSubSelectPositionEvent(true);
                        }
                    }
                }
            });
            itemTouchHelper.attachToRecyclerView(this.mGalleryRecycle);
            this.mGalleryAdapter.setItemLongClickListener(new PreviewGalleryAdapter.OnItemLongClickListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.14
                @Override // com.luck.picture.lib.adapter.holder.PreviewGalleryAdapter.OnItemLongClickListener
                public void onItemLongClick(RecyclerView.ViewHolder viewHolder, int i, View view) {
                    ((Vibrator) PictureSelectorPreviewFragment.this.getActivity().getSystemService("vibrator")).vibrate(50L);
                    if (PictureSelectorPreviewFragment.this.mGalleryAdapter.getItemCount() != PictureSelectorPreviewFragment.this.selectorConfig.maxSelectNum) {
                        itemTouchHelper.startDrag(viewHolder);
                    } else if (viewHolder.getLayoutPosition() != PictureSelectorPreviewFragment.this.mGalleryAdapter.getItemCount() - 1) {
                        itemTouchHelper.startDrag(viewHolder);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyGallerySelectMedia(LocalMedia localMedia) {
        if (this.mGalleryAdapter == null || !this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewDisplaySelectGallery()) {
            return;
        }
        this.mGalleryAdapter.isSelectMedia(localMedia);
    }

    private void notifyPreviewGalleryData(boolean z, LocalMedia localMedia) {
        if (this.mGalleryAdapter == null || !this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewDisplaySelectGallery()) {
            return;
        }
        if (this.mGalleryRecycle.getVisibility() == 4) {
            this.mGalleryRecycle.setVisibility(0);
        }
        if (z) {
            if (this.selectorConfig.selectionMode == 1) {
                this.mGalleryAdapter.clear();
            }
            this.mGalleryAdapter.addGalleryData(localMedia);
            this.mGalleryRecycle.smoothScrollToPosition(this.mGalleryAdapter.getItemCount() - 1);
            return;
        }
        this.mGalleryAdapter.removeGalleryData(localMedia);
        if (this.selectorConfig.getSelectCount() == 0) {
            this.mGalleryRecycle.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePreview() {
        if (!this.isDisplayDelete || this.selectorConfig.onExternalPreviewEventListener == null) {
            return;
        }
        this.selectorConfig.onExternalPreviewEventListener.onPreviewDelete(this.viewPager.getCurrentItem());
        int currentItem = this.viewPager.getCurrentItem();
        this.mData.remove(currentItem);
        if (this.mData.size() == 0) {
            handleExternalPreviewBack();
            return;
        }
        this.titleBar.setTitle(getString(R.string.ps_preview_image_num, Integer.valueOf(this.curPosition + 1), Integer.valueOf(this.mData.size())));
        this.totalNum = this.mData.size();
        this.curPosition = currentItem;
        if (this.viewPager.getAdapter() != null) {
            this.viewPager.setAdapter(null);
            this.viewPager.setAdapter(this.viewPageAdapter);
        }
        this.viewPager.setCurrentItem(this.curPosition, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExternalPreviewBack() {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        if (this.selectorConfig.isPreviewFullScreenMode) {
            hideFullScreenStatusBar();
        }
        onExitPictureSelector();
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onExitFragment() {
        if (this.selectorConfig.isPreviewFullScreenMode) {
            hideFullScreenStatusBar();
        }
    }

    private void initBottomNavBar() {
        this.bottomNarBar.setBottomNavBarStyle();
        this.bottomNarBar.setSelectedChange();
        this.bottomNarBar.setOnBottomNavBarListener(new BottomNavBar.OnBottomNavBarListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.15
            @Override // com.luck.picture.lib.widget.BottomNavBar.OnBottomNavBarListener
            public void onEditImage() {
                if (PictureSelectorPreviewFragment.this.selectorConfig.onEditMediaEventListener != null) {
                    PictureSelectorPreviewFragment.this.selectorConfig.onEditMediaEventListener.onStartMediaEdit(PictureSelectorPreviewFragment.this, PictureSelectorPreviewFragment.this.mData.get(PictureSelectorPreviewFragment.this.viewPager.getCurrentItem()), 696);
                }
            }

            @Override // com.luck.picture.lib.widget.BottomNavBar.OnBottomNavBarListener
            public void onCheckOriginalChange() {
                PictureSelectorPreviewFragment.this.sendSelectedOriginalChangeEvent();
            }

            @Override // com.luck.picture.lib.widget.BottomNavBar.OnBottomNavBarListener
            public void onFirstCheckOriginalSelectedChange() {
                int currentItem = PictureSelectorPreviewFragment.this.viewPager.getCurrentItem();
                if (PictureSelectorPreviewFragment.this.mData.size() > currentItem) {
                    PictureSelectorPreviewFragment.this.confirmSelect(PictureSelectorPreviewFragment.this.mData.get(currentItem), false);
                }
            }
        });
    }

    private void externalPreviewStyle() {
        this.titleBar.getImageDelete().setVisibility(this.isDisplayDelete ? 0 : 8);
        this.tvSelected.setVisibility(8);
        this.bottomNarBar.setVisibility(8);
        this.completeSelectView.setVisibility(8);
    }

    protected PicturePreviewAdapter createAdapter() {
        return new PicturePreviewAdapter(this.selectorConfig);
    }

    public PicturePreviewAdapter getAdapter() {
        return this.viewPageAdapter;
    }

    public ViewPager2 getViewPager2() {
        return this.viewPager;
    }

    private void initViewPagerData(ArrayList<LocalMedia> arrayList) {
        int i;
        PicturePreviewAdapter picturePreviewAdapterCreateAdapter = createAdapter();
        this.viewPageAdapter = picturePreviewAdapterCreateAdapter;
        picturePreviewAdapterCreateAdapter.setData(arrayList);
        this.viewPageAdapter.setOnPreviewEventListener(new MyOnPreviewEventListener());
        this.viewPager.setOrientation(0);
        this.viewPager.setAdapter(this.viewPageAdapter);
        this.selectorConfig.selectedPreviewResult.clear();
        if (arrayList.size() == 0 || this.curPosition >= arrayList.size() || (i = this.curPosition) < 0) {
            onKeyBackFragmentFinish();
            return;
        }
        LocalMedia localMedia = arrayList.get(i);
        this.bottomNarBar.isDisplayEditor(PictureMimeType.isHasVideo(localMedia.getMimeType()) || PictureMimeType.isHasAudio(localMedia.getMimeType()));
        this.tvSelected.setSelected(this.selectorConfig.getSelectedResult().contains(arrayList.get(this.viewPager.getCurrentItem())));
        this.viewPager.registerOnPageChangeCallback(this.pageChangeCallback);
        this.viewPager.setPageTransformer(new MarginPageTransformer(DensityUtil.dip2px(getAppContext(), 3.0f)));
        this.viewPager.setCurrentItem(this.curPosition, false);
        sendChangeSubSelectPositionEvent(false);
        notifySelectNumberStyle(arrayList.get(this.curPosition));
        startZoomEffect(localMedia);
    }

    protected void startZoomEffect(LocalMedia localMedia) {
        if (this.isSaveInstanceState || this.isInternalBottomPreview || !this.selectorConfig.isPreviewZoomEffect) {
            return;
        }
        this.viewPager.post(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.16
            @Override // java.lang.Runnable
            public void run() {
                PictureSelectorPreviewFragment.this.viewPageAdapter.setCoverScaleType(PictureSelectorPreviewFragment.this.curPosition);
            }
        });
        if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
            getVideoRealSizeFromMedia(localMedia, !PictureMimeType.isHasHttp(localMedia.getAvailablePath()), new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.17
                @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                public void onCall(int[] iArr) {
                    PictureSelectorPreviewFragment.this.start(iArr);
                }
            });
        } else {
            getImageRealSizeFromMedia(localMedia, !PictureMimeType.isHasHttp(localMedia.getAvailablePath()), new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.18
                @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                public void onCall(int[] iArr) {
                    PictureSelectorPreviewFragment.this.start(iArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(final int[] iArr) {
        this.magicalView.changeRealScreenHeight(iArr[0], iArr[1], false);
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(this.isShowCamera ? this.curPosition + 1 : this.curPosition);
        if (itemViewParams == null || (iArr[0] == 0 && iArr[1] == 0)) {
            this.viewPager.post(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.19
                @Override // java.lang.Runnable
                public void run() {
                    MagicalView magicalView = PictureSelectorPreviewFragment.this.magicalView;
                    int[] iArr2 = iArr;
                    magicalView.startNormal(iArr2[0], iArr2[1], false);
                }
            });
            this.magicalView.setBackgroundAlpha(1.0f);
            for (int i = 0; i < this.mAnimViews.size(); i++) {
                this.mAnimViews.get(i).setAlpha(1.0f);
            }
        } else {
            this.magicalView.setViewParams(itemViewParams.left, itemViewParams.top, itemViewParams.width, itemViewParams.height, iArr[0], iArr[1]);
            this.magicalView.start(false);
        }
        ObjectAnimator.ofFloat(this.viewPager, "alpha", 0.0f, 1.0f).setDuration(50L).start();
    }

    private class MyOnPreviewEventListener implements BasePreviewHolder.OnPreviewEventListener {
        private MyOnPreviewEventListener() {
        }

        @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder.OnPreviewEventListener
        public void onBackPressed() {
            if (PictureSelectorPreviewFragment.this.selectorConfig.isPreviewFullScreenMode) {
                PictureSelectorPreviewFragment.this.previewFullScreenMode();
                return;
            }
            if (PictureSelectorPreviewFragment.this.isExternalPreview) {
                if (!PictureSelectorPreviewFragment.this.selectorConfig.isPreviewZoomEffect) {
                    PictureSelectorPreviewFragment.this.handleExternalPreviewBack();
                    return;
                } else {
                    PictureSelectorPreviewFragment.this.magicalView.backToMin();
                    return;
                }
            }
            if (PictureSelectorPreviewFragment.this.isInternalBottomPreview || !PictureSelectorPreviewFragment.this.selectorConfig.isPreviewZoomEffect) {
                PictureSelectorPreviewFragment.this.onBackCurrentFragment();
            } else {
                PictureSelectorPreviewFragment.this.magicalView.backToMin();
            }
        }

        @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder.OnPreviewEventListener
        public void onPreviewVideoTitle(String str) {
            if (TextUtils.isEmpty(str)) {
                PictureSelectorPreviewFragment.this.titleBar.setTitle((PictureSelectorPreviewFragment.this.curPosition + 1) + "/" + PictureSelectorPreviewFragment.this.totalNum);
            } else {
                PictureSelectorPreviewFragment.this.titleBar.setTitle(str);
            }
        }

        @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder.OnPreviewEventListener
        public void onLongPressDownload(LocalMedia localMedia) {
            if (!PictureSelectorPreviewFragment.this.selectorConfig.isHidePreviewDownload && PictureSelectorPreviewFragment.this.isExternalPreview) {
                PictureSelectorPreviewFragment.this.onExternalLongPressDownload(localMedia);
            }
        }
    }

    private void onKeyDownBackToMin() {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        if (this.isExternalPreview) {
            if (this.selectorConfig.isPreviewZoomEffect) {
                this.magicalView.backToMin();
                return;
            } else {
                onExitPictureSelector();
                return;
            }
        }
        if (this.isInternalBottomPreview) {
            onBackCurrentFragment();
        } else if (this.selectorConfig.isPreviewZoomEffect) {
            this.magicalView.backToMin();
        } else {
            onBackCurrentFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void previewFullScreenMode() {
        if (this.isAnimationStart) {
            return;
        }
        final boolean z = this.titleBar.getTranslationY() == 0.0f;
        AnimatorSet animatorSet = new AnimatorSet();
        float f = z ? 0.0f : -this.titleBar.getHeight();
        float f2 = z ? -this.titleBar.getHeight() : 0.0f;
        float f3 = z ? 1.0f : 0.0f;
        float f4 = z ? 0.0f : 1.0f;
        for (int i = 0; i < this.mAnimViews.size(); i++) {
            View view = this.mAnimViews.get(i);
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "alpha", f3, f4));
            if (view instanceof TitleBar) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationY", f, f2));
            }
        }
        animatorSet.setDuration(350L);
        animatorSet.start();
        this.isAnimationStart = true;
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.20
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PictureSelectorPreviewFragment.this.isAnimationStart = false;
                if (SdkVersionUtils.isP() && PictureSelectorPreviewFragment.this.isAdded()) {
                    Window window = PictureSelectorPreviewFragment.this.requireActivity().getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    if (z) {
                        attributes.flags |= 1024;
                        attributes.layoutInDisplayCutoutMode = 1;
                        window.setAttributes(attributes);
                        window.addFlags(512);
                        return;
                    }
                    attributes.flags &= -1025;
                    window.setAttributes(attributes);
                    window.clearFlags(512);
                }
            }
        });
        if (z) {
            showFullScreenStatusBar();
        } else {
            hideFullScreenStatusBar();
        }
    }

    private void showFullScreenStatusBar() {
        for (int i = 0; i < this.mAnimViews.size(); i++) {
            this.mAnimViews.get(i).setEnabled(false);
        }
        this.bottomNarBar.getEditor().setEnabled(false);
    }

    private void hideFullScreenStatusBar() {
        for (int i = 0; i < this.mAnimViews.size(); i++) {
            this.mAnimViews.get(i).setEnabled(true);
        }
        this.bottomNarBar.getEditor().setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExternalLongPressDownload(final LocalMedia localMedia) {
        String string;
        if (this.selectorConfig.onExternalPreviewEventListener == null || this.selectorConfig.onExternalPreviewEventListener.onLongPressDownload(getContext(), localMedia)) {
            return;
        }
        if (PictureMimeType.isHasAudio(localMedia.getMimeType()) || PictureMimeType.isUrlHasAudio(localMedia.getAvailablePath())) {
            string = getString(R.string.ps_prompt_audio_content);
        } else if (PictureMimeType.isHasVideo(localMedia.getMimeType()) || PictureMimeType.isUrlHasVideo(localMedia.getAvailablePath())) {
            string = getString(R.string.ps_prompt_video_content);
        } else {
            string = getString(R.string.ps_prompt_image_content);
        }
        PictureCommonDialog.showDialog(getContext(), getString(R.string.ps_prompt), string).setOnDialogEventListener(new PictureCommonDialog.OnDialogEventListener() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.21
            @Override // com.luck.picture.lib.dialog.PictureCommonDialog.OnDialogEventListener
            public void onConfirm() {
                String availablePath = localMedia.getAvailablePath();
                if (PictureMimeType.isHasHttp(availablePath)) {
                    PictureSelectorPreviewFragment.this.showLoading();
                }
                DownloadFileUtils.saveLocalFile(PictureSelectorPreviewFragment.this.getContext(), availablePath, localMedia.getMimeType(), new OnCallbackListener<String>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.21.1
                    @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                    public void onCall(String str) {
                        String string2;
                        PictureSelectorPreviewFragment.this.dismissLoading();
                        if (TextUtils.isEmpty(str)) {
                            if (PictureMimeType.isHasAudio(localMedia.getMimeType())) {
                                string2 = PictureSelectorPreviewFragment.this.getString(R.string.ps_save_audio_error);
                            } else if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                                string2 = PictureSelectorPreviewFragment.this.getString(R.string.ps_save_video_error);
                            } else {
                                string2 = PictureSelectorPreviewFragment.this.getString(R.string.ps_save_image_error);
                            }
                            ToastUtils.showToast(PictureSelectorPreviewFragment.this.getContext(), string2);
                            return;
                        }
                        new PictureMediaScannerConnection(PictureSelectorPreviewFragment.this.getActivity(), str);
                        ToastUtils.showToast(PictureSelectorPreviewFragment.this.getContext(), PictureSelectorPreviewFragment.this.getString(R.string.ps_save_success) + "\n" + str);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAutoVideoPlay(final int i) {
        this.viewPager.post(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.23
            @Override // java.lang.Runnable
            public void run() {
                PictureSelectorPreviewFragment.this.viewPageAdapter.startAutoVideoPlay(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeMagicalViewParams(final int i) {
        LocalMedia localMedia = this.mData.get(i);
        if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
            getVideoRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.24
                @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                public void onCall(int[] iArr) {
                    PictureSelectorPreviewFragment.this.setMagicalViewParams(iArr[0], iArr[1], i);
                }
            });
        } else {
            getImageRealSizeFromMedia(localMedia, false, new OnCallbackListener<int[]>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.25
                @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                public void onCall(int[] iArr) {
                    PictureSelectorPreviewFragment.this.setMagicalViewParams(iArr[0], iArr[1], i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMagicalViewParams(int i, int i2, int i3) {
        this.magicalView.changeRealScreenHeight(i, i2, true);
        if (this.isShowCamera) {
            i3++;
        }
        ViewParams itemViewParams = BuildRecycleItemViewParams.getItemViewParams(i3);
        if (itemViewParams == null || i == 0 || i2 == 0) {
            this.magicalView.setViewParams(0, 0, 0, 0, i, i2);
        } else {
            this.magicalView.setViewParams(itemViewParams.left, itemViewParams.top, itemViewParams.width, itemViewParams.height, i, i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getImageRealSizeFromMedia(final com.luck.picture.lib.entity.LocalMedia r7, boolean r8, final com.luck.picture.lib.interfaces.OnCallbackListener<int[]> r9) {
        /*
            r6 = this;
            int r0 = r7.getWidth()
            int r1 = r7.getHeight()
            boolean r0 = com.luck.picture.lib.utils.MediaUtils.isLongImage(r0, r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L15
            int r8 = r6.screenWidth
            int r0 = r6.screenHeight
            goto L47
        L15:
            int r0 = r7.getWidth()
            int r3 = r7.getHeight()
            if (r8 == 0) goto L45
            if (r0 <= 0) goto L25
            if (r3 <= 0) goto L25
            if (r0 <= r3) goto L45
        L25:
            com.luck.picture.lib.config.SelectorConfig r8 = r6.selectorConfig
            boolean r8 = r8.isSyncWidthAndHeight
            if (r8 == 0) goto L45
            androidx.viewpager2.widget.ViewPager2 r8 = r6.viewPager
            r4 = 0
            r8.setAlpha(r4)
            android.content.Context r8 = r6.getContext()
            java.lang.String r4 = r7.getAvailablePath()
            com.luck.picture.lib.PictureSelectorPreviewFragment$26 r5 = new com.luck.picture.lib.PictureSelectorPreviewFragment$26
            r5.<init>()
            com.luck.picture.lib.utils.MediaUtils.getImageSize(r8, r4, r5)
            r8 = r0
            r0 = r3
            r3 = r1
            goto L48
        L45:
            r8 = r0
            r0 = r3
        L47:
            r3 = r2
        L48:
            boolean r4 = r7.isCut()
            if (r4 == 0) goto L62
            int r4 = r7.getCropImageWidth()
            if (r4 <= 0) goto L62
            int r4 = r7.getCropImageHeight()
            if (r4 <= 0) goto L62
            int r8 = r7.getCropImageWidth()
            int r0 = r7.getCropImageHeight()
        L62:
            if (r3 == 0) goto L6e
            r7 = 2
            int[] r7 = new int[r7]
            r7[r1] = r8
            r7[r2] = r0
            r9.onCall(r7)
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorPreviewFragment.getImageRealSizeFromMedia(com.luck.picture.lib.entity.LocalMedia, boolean, com.luck.picture.lib.interfaces.OnCallbackListener):void");
    }

    private void getVideoRealSizeFromMedia(final LocalMedia localMedia, boolean z, final OnCallbackListener<int[]> onCallbackListener) {
        boolean z2;
        if (!z || ((localMedia.getWidth() > 0 && localMedia.getHeight() > 0 && localMedia.getWidth() <= localMedia.getHeight()) || !this.selectorConfig.isSyncWidthAndHeight)) {
            z2 = true;
        } else {
            this.viewPager.setAlpha(0.0f);
            MediaUtils.getVideoSize(getContext(), localMedia.getAvailablePath(), new OnCallbackListener<MediaExtraInfo>() { // from class: com.luck.picture.lib.PictureSelectorPreviewFragment.27
                @Override // com.luck.picture.lib.interfaces.OnCallbackListener
                public void onCall(MediaExtraInfo mediaExtraInfo) {
                    if (mediaExtraInfo.getWidth() > 0) {
                        localMedia.setWidth(mediaExtraInfo.getWidth());
                    }
                    if (mediaExtraInfo.getHeight() > 0) {
                        localMedia.setHeight(mediaExtraInfo.getHeight());
                    }
                    OnCallbackListener onCallbackListener2 = onCallbackListener;
                    if (onCallbackListener2 != null) {
                        onCallbackListener2.onCall(new int[]{localMedia.getWidth(), localMedia.getHeight()});
                    }
                }
            });
            z2 = false;
        }
        if (z2) {
            onCallbackListener.onCall(new int[]{localMedia.getWidth(), localMedia.getHeight()});
        }
    }

    public void notifySelectNumberStyle(LocalMedia localMedia) {
        if (this.selectorConfig.selectorStyle.getSelectMainStyle().isPreviewSelectNumberStyle() && this.selectorConfig.selectorStyle.getSelectMainStyle().isSelectNumberStyle()) {
            this.tvSelected.setText("");
            for (int i = 0; i < this.selectorConfig.getSelectCount(); i++) {
                LocalMedia localMedia2 = this.selectorConfig.getSelectedResult().get(i);
                if (TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                    localMedia.setNum(localMedia2.getNum());
                    localMedia2.setPosition(localMedia.getPosition());
                    this.tvSelected.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
                }
            }
        }
    }

    protected boolean isSelected(LocalMedia localMedia) {
        return this.selectorConfig.getSelectedResult().contains(localMedia);
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onEditMedia(Intent intent) {
        if (this.mData.size() > this.viewPager.getCurrentItem()) {
            LocalMedia localMedia = this.mData.get(this.viewPager.getCurrentItem());
            Uri output = Crop.getOutput(intent);
            localMedia.setCutPath(output != null ? output.getPath() : "");
            localMedia.setCropImageWidth(Crop.getOutputImageWidth(intent));
            localMedia.setCropImageHeight(Crop.getOutputImageHeight(intent));
            localMedia.setCropOffsetX(Crop.getOutputImageOffsetX(intent));
            localMedia.setCropOffsetY(Crop.getOutputImageOffsetY(intent));
            localMedia.setCropResultAspectRatio(Crop.getOutputCropAspectRatio(intent));
            localMedia.setCut(!TextUtils.isEmpty(localMedia.getCutPath()));
            localMedia.setCustomData(Crop.getOutputCustomExtraData(intent));
            localMedia.setEditorImage(localMedia.isCut());
            localMedia.setSandboxPath(localMedia.getCutPath());
            if (this.selectorConfig.getSelectedResult().contains(localMedia)) {
                LocalMedia compareLocalMedia = localMedia.getCompareLocalMedia();
                if (compareLocalMedia != null) {
                    compareLocalMedia.setCutPath(localMedia.getCutPath());
                    compareLocalMedia.setCut(localMedia.isCut());
                    compareLocalMedia.setEditorImage(localMedia.isEditorImage());
                    compareLocalMedia.setCustomData(localMedia.getCustomData());
                    compareLocalMedia.setSandboxPath(localMedia.getCutPath());
                    compareLocalMedia.setCropImageWidth(Crop.getOutputImageWidth(intent));
                    compareLocalMedia.setCropImageHeight(Crop.getOutputImageHeight(intent));
                    compareLocalMedia.setCropOffsetX(Crop.getOutputImageOffsetX(intent));
                    compareLocalMedia.setCropOffsetY(Crop.getOutputImageOffsetY(intent));
                    compareLocalMedia.setCropResultAspectRatio(Crop.getOutputCropAspectRatio(intent));
                }
                sendFixedSelectedChangeEvent(localMedia);
            } else {
                confirmSelect(localMedia, false);
            }
            this.viewPageAdapter.notifyItemChanged(this.viewPager.getCurrentItem());
            notifyGallerySelectMedia(localMedia);
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment
    protected void onExitPictureSelector() {
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        if (picturePreviewAdapter != null) {
            picturePreviewAdapter.destroy();
        }
        super.onExitPictureSelector();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isPause) {
            resumePausePlay();
            this.isPause = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isPlaying()) {
            resumePausePlay();
            this.isPause = true;
        }
    }

    private void resumePausePlay() {
        BasePreviewHolder currentHolder;
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        if (picturePreviewAdapter == null || (currentHolder = picturePreviewAdapter.getCurrentHolder(this.viewPager.getCurrentItem())) == null) {
            return;
        }
        currentHolder.resumePausePlay();
    }

    private boolean isPlaying() {
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        return picturePreviewAdapter != null && picturePreviewAdapter.isPlaying(this.viewPager.getCurrentItem());
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        PicturePreviewAdapter picturePreviewAdapter = this.viewPageAdapter;
        if (picturePreviewAdapter != null) {
            picturePreviewAdapter.destroy();
        }
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.unregisterOnPageChangeCallback(this.pageChangeCallback);
        }
        super.onDestroy();
    }
}
