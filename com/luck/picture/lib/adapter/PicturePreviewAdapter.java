package com.luck.picture.lib.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.adapter.holder.PreviewVideoHolder;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PicturePreviewAdapter extends RecyclerView.Adapter<BasePreviewHolder> {
    private List<LocalMedia> mData;
    private final LinkedHashMap<Integer, BasePreviewHolder> mHolderCache;
    private BasePreviewHolder.OnPreviewEventListener onPreviewEventListener;
    private final SelectorConfig selectorConfig;

    public PicturePreviewAdapter() {
        this(SelectorProviders.getInstance().getSelectorConfig());
    }

    public PicturePreviewAdapter(SelectorConfig selectorConfig) {
        this.mHolderCache = new LinkedHashMap<>();
        this.selectorConfig = selectorConfig;
    }

    public BasePreviewHolder getCurrentHolder(int i) {
        return this.mHolderCache.get(Integer.valueOf(i));
    }

    public void setData(List<LocalMedia> list) {
        this.mData = list;
    }

    public void setOnPreviewEventListener(BasePreviewHolder.OnPreviewEventListener onPreviewEventListener) {
        this.onPreviewEventListener = onPreviewEventListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BasePreviewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 2) {
            int layoutResource = InjectResourceSource.getLayoutResource(viewGroup.getContext(), 8, this.selectorConfig);
            if (layoutResource == 0) {
                layoutResource = R.layout.ps_preview_video;
            }
            return BasePreviewHolder.generate(viewGroup, i, layoutResource);
        }
        if (i == 3) {
            int layoutResource2 = InjectResourceSource.getLayoutResource(viewGroup.getContext(), 10, this.selectorConfig);
            if (layoutResource2 == 0) {
                layoutResource2 = R.layout.ps_preview_audio;
            }
            return BasePreviewHolder.generate(viewGroup, i, layoutResource2);
        }
        int layoutResource3 = InjectResourceSource.getLayoutResource(viewGroup.getContext(), 7, this.selectorConfig);
        if (layoutResource3 == 0) {
            layoutResource3 = R.layout.ps_preview_image;
        }
        return BasePreviewHolder.generate(viewGroup, i, layoutResource3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BasePreviewHolder basePreviewHolder, int i) {
        basePreviewHolder.setOnPreviewEventListener(this.onPreviewEventListener);
        LocalMedia item = getItem(i);
        this.mHolderCache.put(Integer.valueOf(i), basePreviewHolder);
        basePreviewHolder.bindData(item, i);
    }

    public LocalMedia getItem(int i) {
        if (i > this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (PictureMimeType.isHasVideo(this.mData.get(i).getMimeType())) {
            return 2;
        }
        return PictureMimeType.isHasAudio(this.mData.get(i).getMimeType()) ? 3 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<LocalMedia> list = this.mData;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(BasePreviewHolder basePreviewHolder) {
        super.onViewAttachedToWindow((PicturePreviewAdapter) basePreviewHolder);
        basePreviewHolder.onViewAttachedToWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(BasePreviewHolder basePreviewHolder) {
        super.onViewDetachedFromWindow((PicturePreviewAdapter) basePreviewHolder);
        basePreviewHolder.onViewDetachedFromWindow();
    }

    public void setCoverScaleType(int i) {
        BasePreviewHolder currentHolder = getCurrentHolder(i);
        if (currentHolder != null) {
            LocalMedia item = getItem(i);
            if (item.getWidth() == 0 && item.getHeight() == 0) {
                currentHolder.coverImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                currentHolder.coverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public void setVideoPlayButtonUI(int i) {
        BasePreviewHolder currentHolder = getCurrentHolder(i);
        if (currentHolder instanceof PreviewVideoHolder) {
            PreviewVideoHolder previewVideoHolder = (PreviewVideoHolder) currentHolder;
            if (previewVideoHolder.isPlaying()) {
                return;
            }
            previewVideoHolder.ivPlayButton.setVisibility(0);
        }
    }

    public void startAutoVideoPlay(int i) {
        BasePreviewHolder currentHolder = getCurrentHolder(i);
        if (currentHolder instanceof PreviewVideoHolder) {
            ((PreviewVideoHolder) currentHolder).startPlay();
        }
    }

    public boolean isPlaying(int i) {
        BasePreviewHolder currentHolder = getCurrentHolder(i);
        return currentHolder != null && currentHolder.isPlaying();
    }

    public void destroy() {
        Iterator<Integer> it = this.mHolderCache.keySet().iterator();
        while (it.hasNext()) {
            BasePreviewHolder basePreviewHolder = this.mHolderCache.get(it.next());
            if (basePreviewHolder != null) {
                basePreviewHolder.release();
            }
        }
    }
}
