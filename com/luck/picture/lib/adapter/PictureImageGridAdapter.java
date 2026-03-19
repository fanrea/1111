package com.luck.picture.lib.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PictureImageGridAdapter extends RecyclerView.Adapter<BaseRecyclerMediaHolder> {
    public static final int ADAPTER_TYPE_AUDIO = 4;
    public static final int ADAPTER_TYPE_CAMERA = 1;
    public static final int ADAPTER_TYPE_IMAGE = 2;
    public static final int ADAPTER_TYPE_VIDEO = 3;
    private boolean isDisplayCamera;
    private OnItemClickListener listener;
    private final SelectorConfig mConfig;
    private final Context mContext;
    private ArrayList<LocalMedia> mData = new ArrayList<>();

    public interface OnItemClickListener {
        void onItemClick(View view, int i, LocalMedia localMedia);

        void onItemLongClick(View view, int i);

        int onSelected(View view, int i, LocalMedia localMedia);

        void openCameraClick();
    }

    public void notifyItemPositionChanged(int i) {
        notifyItemChanged(i);
    }

    public PictureImageGridAdapter(Context context, SelectorConfig selectorConfig) {
        this.mConfig = selectorConfig;
        this.mContext = context;
    }

    public void setDataAndDataSetChanged(ArrayList<LocalMedia> arrayList) {
        if (arrayList != null) {
            this.mData = arrayList;
            notifyDataSetChanged();
        }
    }

    public boolean isDisplayCamera() {
        return this.isDisplayCamera;
    }

    public void setDisplayCamera(boolean z) {
        this.isDisplayCamera = z;
    }

    public ArrayList<LocalMedia> getData() {
        return this.mData;
    }

    public boolean isDataEmpty() {
        return this.mData.size() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        boolean z = this.isDisplayCamera;
        if (z && i == 0) {
            return 1;
        }
        if (z) {
            i--;
        }
        String mimeType = this.mData.get(i).getMimeType();
        if (PictureMimeType.isHasVideo(mimeType)) {
            return 3;
        }
        return PictureMimeType.isHasAudio(mimeType) ? 4 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseRecyclerMediaHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return BaseRecyclerMediaHolder.generate(viewGroup, i, getItemResourceId(i), this.mConfig);
    }

    private int getItemResourceId(int i) {
        if (i == 1) {
            return R.layout.ps_item_grid_camera;
        }
        if (i == 3) {
            int layoutResource = InjectResourceSource.getLayoutResource(this.mContext, 4, this.mConfig);
            return layoutResource != 0 ? layoutResource : R.layout.ps_item_grid_video;
        }
        if (i == 4) {
            int layoutResource2 = InjectResourceSource.getLayoutResource(this.mContext, 5, this.mConfig);
            return layoutResource2 != 0 ? layoutResource2 : R.layout.ps_item_grid_audio;
        }
        int layoutResource3 = InjectResourceSource.getLayoutResource(this.mContext, 3, this.mConfig);
        return layoutResource3 != 0 ? layoutResource3 : R.layout.ps_item_grid_image;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseRecyclerMediaHolder baseRecyclerMediaHolder, int i) {
        if (getItemViewType(i) == 1) {
            baseRecyclerMediaHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.PictureImageGridAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PictureImageGridAdapter.this.listener != null) {
                        PictureImageGridAdapter.this.listener.openCameraClick();
                    }
                }
            });
            return;
        }
        if (this.isDisplayCamera) {
            i--;
        }
        baseRecyclerMediaHolder.bindData(this.mData.get(i), i);
        baseRecyclerMediaHolder.setOnItemClickListener(this.listener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.isDisplayCamera ? this.mData.size() + 1 : this.mData.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }
}
