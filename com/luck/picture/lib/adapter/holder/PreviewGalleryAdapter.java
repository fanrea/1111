package com.luck.picture.lib.adapter.holder;

import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.StyleUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PreviewGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final boolean isBottomPreview;
    private OnItemClickListener listener;
    private final List<LocalMedia> mData;
    private OnItemLongClickListener mItemLongClickListener;
    private final SelectorConfig selectorConfig;

    public interface OnItemClickListener {
        void onItemClick(int i, LocalMedia localMedia, View view);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(RecyclerView.ViewHolder viewHolder, int i, View view);
    }

    public PreviewGalleryAdapter(SelectorConfig selectorConfig, boolean z) {
        this.selectorConfig = selectorConfig;
        this.isBottomPreview = z;
        this.mData = new ArrayList(selectorConfig.getSelectedResult());
        for (int i = 0; i < this.mData.size(); i++) {
            LocalMedia localMedia = this.mData.get(i);
            localMedia.setGalleryEnabledMask(false);
            localMedia.setChecked(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int layoutResource = InjectResourceSource.getLayoutResource(viewGroup.getContext(), 9, this.selectorConfig);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        if (layoutResource == 0) {
            layoutResource = R.layout.ps_preview_gallery_item;
        }
        return new ViewHolder(layoutInflaterFrom.inflate(layoutResource, viewGroup, false));
    }

    public List<LocalMedia> getData() {
        return this.mData;
    }

    public void clear() {
        this.mData.clear();
    }

    public void addGalleryData(LocalMedia localMedia) {
        int lastCheckPosition = getLastCheckPosition();
        if (lastCheckPosition != -1) {
            this.mData.get(lastCheckPosition).setChecked(false);
            notifyItemChanged(lastCheckPosition);
        }
        if (this.isBottomPreview && this.mData.contains(localMedia)) {
            int currentPosition = getCurrentPosition(localMedia);
            LocalMedia localMedia2 = this.mData.get(currentPosition);
            localMedia2.setGalleryEnabledMask(false);
            localMedia2.setChecked(true);
            notifyItemChanged(currentPosition);
            return;
        }
        localMedia.setChecked(true);
        this.mData.add(localMedia);
        notifyItemChanged(this.mData.size() - 1);
    }

    public void removeGalleryData(LocalMedia localMedia) {
        int currentPosition = getCurrentPosition(localMedia);
        if (currentPosition != -1) {
            if (this.isBottomPreview) {
                this.mData.get(currentPosition).setGalleryEnabledMask(true);
                notifyItemChanged(currentPosition);
            } else {
                this.mData.remove(currentPosition);
                notifyItemRemoved(currentPosition);
            }
        }
    }

    public void isSelectMedia(LocalMedia localMedia) {
        int lastCheckPosition = getLastCheckPosition();
        if (lastCheckPosition != -1) {
            this.mData.get(lastCheckPosition).setChecked(false);
            notifyItemChanged(lastCheckPosition);
        }
        int currentPosition = getCurrentPosition(localMedia);
        if (currentPosition != -1) {
            this.mData.get(currentPosition).setChecked(true);
            notifyItemChanged(currentPosition);
        }
    }

    public int getLastCheckPosition() {
        for (int i = 0; i < this.mData.size(); i++) {
            if (this.mData.get(i).isChecked()) {
                return i;
            }
        }
        return -1;
    }

    private int getCurrentPosition(LocalMedia localMedia) {
        for (int i = 0; i < this.mData.size(); i++) {
            LocalMedia localMedia2 = this.mData.get(i);
            if (TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final LocalMedia localMedia = this.mData.get(i);
        ColorFilter colorFilter = StyleUtils.getColorFilter(viewHolder.itemView.getContext(), localMedia.isGalleryEnabledMask() ? R.color.ps_color_half_white : R.color.ps_color_transparent);
        if (localMedia.isChecked() && localMedia.isGalleryEnabledMask()) {
            viewHolder.viewBorder.setVisibility(0);
        } else {
            viewHolder.viewBorder.setVisibility(localMedia.isChecked() ? 0 : 8);
        }
        String path = localMedia.getPath();
        if (localMedia.isEditorImage() && !TextUtils.isEmpty(localMedia.getCutPath())) {
            path = localMedia.getCutPath();
            viewHolder.ivEditor.setVisibility(0);
        } else {
            viewHolder.ivEditor.setVisibility(8);
        }
        viewHolder.ivImage.setColorFilter(colorFilter);
        if (this.selectorConfig.imageEngine != null) {
            this.selectorConfig.imageEngine.loadGridImage(viewHolder.itemView.getContext(), path, viewHolder.ivImage);
        }
        viewHolder.ivPlay.setVisibility(PictureMimeType.isHasVideo(localMedia.getMimeType()) ? 0 : 8);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewGalleryAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PreviewGalleryAdapter.this.listener != null) {
                    PreviewGalleryAdapter.this.listener.onItemClick(viewHolder.getAbsoluteAdapterPosition(), localMedia, view);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewGalleryAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (PreviewGalleryAdapter.this.mItemLongClickListener == null) {
                    return true;
                }
                PreviewGalleryAdapter.this.mItemLongClickListener.onItemLongClick(viewHolder, viewHolder.getAbsoluteAdapterPosition(), view);
                return true;
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivEditor;
        ImageView ivImage;
        ImageView ivPlay;
        View viewBorder;

        public ViewHolder(View view) {
            super(view);
            this.ivImage = (ImageView) view.findViewById(R.id.ivImage);
            this.ivPlay = (ImageView) view.findViewById(R.id.ivPlay);
            this.ivEditor = (ImageView) view.findViewById(R.id.ivEditor);
            this.viewBorder = view.findViewById(R.id.viewBorder);
            SelectMainStyle selectMainStyle = PreviewGalleryAdapter.this.selectorConfig.selectorStyle.getSelectMainStyle();
            if (StyleUtils.checkStyleValidity(selectMainStyle.getAdapterImageEditorResources())) {
                this.ivEditor.setImageResource(selectMainStyle.getAdapterImageEditorResources());
            }
            if (StyleUtils.checkStyleValidity(selectMainStyle.getAdapterPreviewGalleryFrameResource())) {
                this.viewBorder.setBackgroundResource(selectMainStyle.getAdapterPreviewGalleryFrameResource());
            }
            int adapterPreviewGalleryItemSize = selectMainStyle.getAdapterPreviewGalleryItemSize();
            if (StyleUtils.checkSizeValidity(adapterPreviewGalleryItemSize)) {
                view.setLayoutParams(new RelativeLayout.LayoutParams(adapterPreviewGalleryItemSize, adapterPreviewGalleryItemSize));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public void setItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mItemLongClickListener = onItemLongClickListener;
    }
}
