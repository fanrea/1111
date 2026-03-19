package com.luck.picture.lib.adapter.holder;

import android.view.View;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.OnViewTapListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PreviewImageHolder extends BasePreviewHolder {
    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void findViews(View view) {
    }

    public PreviewImageHolder(View view) {
        super(view);
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void loadImage(LocalMedia localMedia, int i, int i2) {
        if (this.selectorConfig.imageEngine != null) {
            String availablePath = localMedia.getAvailablePath();
            if (i == -1 && i2 == -1) {
                this.selectorConfig.imageEngine.loadImage(this.itemView.getContext(), availablePath, this.coverImageView);
            } else {
                this.selectorConfig.imageEngine.loadImage(this.itemView.getContext(), this.coverImageView, availablePath, i, i2);
            }
        }
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void onClickBackPressed() {
        this.coverImageView.setOnViewTapListener(new OnViewTapListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewImageHolder.1
            @Override // com.luck.picture.lib.photoview.OnViewTapListener
            public void onViewTap(View view, float f, float f2) {
                if (PreviewImageHolder.this.mPreviewEventListener != null) {
                    PreviewImageHolder.this.mPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    @Override // com.luck.picture.lib.adapter.holder.BasePreviewHolder
    protected void onLongPressDownload(final LocalMedia localMedia) {
        this.coverImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.luck.picture.lib.adapter.holder.PreviewImageHolder.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (PreviewImageHolder.this.mPreviewEventListener == null) {
                    return false;
                }
                PreviewImageHolder.this.mPreviewEventListener.onLongPressDownload(localMedia);
                return false;
            }
        });
    }
}
