package com.bytedance.sdk.djx.core.business.budrama.detail;

import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog;
import com.bytedance.sdk.djx.core.business.view.rv2.base.CommonViewHolder;
import com.bytedance.sdk.djx.core.business.view.rv2.base.ItemView;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaDialogItemView extends ItemView<DJXDramaListDialog.DramaItem> {
    private static final float RATIO = 0.6179775f;
    private final OnDramaDialogItemListener mOnDramaDialogItemListener;
    private final RecyclerView mRecyclerView;

    public interface OnDramaDialogItemListener {
        boolean isCurrentIndex(int i);

        boolean isNeedLock(DJXDramaListDialog.DramaItem dramaItem);
    }

    public DramaDialogItemView(RecyclerView recyclerView, DJXDramaListDialog.DramaItem dramaItem, OnDramaDialogItemListener onDramaDialogItemListener) {
        super(dramaItem);
        this.mRecyclerView = recyclerView;
        this.mOnDramaDialogItemListener = onDramaDialogItemListener;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv2.base.ItemView
    public int getLayoutRes() {
        return R.layout.djx_drama_dialog_item_view;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv2.base.ItemView
    public void resizeView(View view) {
        super.resizeView(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            int width = this.mRecyclerView.getWidth();
            if (width > 0) {
                layoutParams.width = (width - (UIUtil.dp2px(6.0f) * 2)) / 3;
                layoutParams.height = (int) (layoutParams.width / RATIO);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.djx.core.business.view.rv2.base.ItemView
    public void bind(CommonViewHolder commonViewHolder) {
        ImageView imageView = (ImageView) commonViewHolder.getView(R.id.djx_drama_cover);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(InnerManager.getContext()).load(getData().coverImage).config(Bitmap.Config.RGB_565).placeholder(R.drawable.djx_drama_default_cover).fit().centerCrop().tag("drama_detail").into(imageView);
        ((TextView) commonViewHolder.getView(R.id.djx_drama_title)).setText(String.format("第%s集", Integer.valueOf(((DJXDramaListDialog.DramaItem) this.mData).index)));
        View view = commonViewHolder.getView(R.id.djx_drama_item_layout);
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DramaDialogItemView.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRoundRect(new Rect(0, 0, view2.getWidth(), view2.getHeight()), UIUtil.dp2px(5.0f));
            }
        });
        view.setClipToOutline(true);
        View view2 = commonViewHolder.getView(R.id.djx_drama_lock_view);
        View view3 = commonViewHolder.getView(R.id.djx_drama_playing_view);
        ImageView imageView2 = (ImageView) commonViewHolder.getView(R.id.djx_drama_playing_icon);
        if (this.mOnDramaDialogItemListener.isNeedLock((DJXDramaListDialog.DramaItem) this.mData)) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
        if (this.mOnDramaDialogItemListener.isCurrentIndex(((DJXDramaListDialog.DramaItem) this.mData).index)) {
            view3.setVisibility(0);
            imageView2.setImageResource(R.drawable.djx_drama_playing_anim);
            if (imageView2.getDrawable() instanceof AnimationDrawable) {
                ((AnimationDrawable) imageView2.getDrawable()).start();
                return;
            }
            return;
        }
        view3.setVisibility(8);
    }
}
