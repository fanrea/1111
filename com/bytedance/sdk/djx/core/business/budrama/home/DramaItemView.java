package com.bytedance.sdk.djx.core.business.budrama.home;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.budrama.GridRenderHelper;
import com.bytedance.sdk.djx.core.business.view.rv.base.BaseViewHolder;
import com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView;
import com.bytedance.sdk.djx.core.util.ImageUtil;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.SourceMode;
import com.bytedance.sdk.djx.model.ev.BEHomeFirstFrame;
import com.bytedance.sdk.djx.model.ev.BEHomeLoadFrame;
import com.bytedance.sdk.djx.net.ImageTag;
import com.bytedance.sdk.djx.net.img.Callback;
import com.bytedance.sdk.djx.net.img.MemoryPolicy;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaItemView extends IMultiItemView {
    private static final int COLUMN_SPACING = 10;
    private static final float RATIO = 0.5625f;
    private static final int SPAN_COUNT = 2;
    private int mLayoutWidth;
    private int mPosition;
    private RecyclerView mRecyclerView;

    public void setContainer(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public Object getItemViewLayoutId() {
        View viewInflate = LayoutInflater.from(InnerManager.getContext()).inflate(R.layout.djx_item_drama_vertical_card, (ViewGroup) this.mRecyclerView, false);
        viewInflate.setLayoutParams(GridRenderHelper.handleVerticalLayoutParams(viewInflate.getLayoutParams(), this.mRecyclerView.getWidth(), 10, 2, 0.0f));
        this.mLayoutWidth = GridRenderHelper.getRealSpace(this.mRecyclerView.getWidth(), 10, 2);
        return viewInflate;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public boolean isForViewType(Object obj, int i) {
        return obj instanceof Drama;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public void bindViewHolder(BaseViewHolder baseViewHolder, Object obj, int i) throws Resources.NotFoundException {
        if (baseViewHolder == null || !(obj instanceof Drama)) {
            return;
        }
        this.mPosition = i;
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.djx_drama_cover);
        ViewGroup.LayoutParams layoutParamsHandleVerticalLayoutParams = GridRenderHelper.handleVerticalLayoutParams(imageView.getLayoutParams(), this.mLayoutWidth, 0, 0, RATIO);
        imageView.setLayoutParams(layoutParamsHandleVerticalLayoutParams);
        ((TextView) baseViewHolder.getView(R.id.djx_drama_title)).setMaxEms(9);
        Drama drama = (Drama) obj;
        setImageUrl(InnerManager.getContext(), imageView, ImageUtil.getCover(drama.coverImages2, drama.coverImage), layoutParamsHandleVerticalLayoutParams.width, layoutParamsHandleVerticalLayoutParams.height);
        baseViewHolder.setText(R.id.djx_drama_title, drama.title);
        int i2 = R.id.djx_drama_info;
        String string = this.mRecyclerView.getResources().getString(R.string.djx_drama_info);
        Object[] objArr = new Object[2];
        objArr[0] = drama.status == 0 ? "已完结" : "未完结";
        objArr[1] = Integer.valueOf(drama.total);
        baseViewHolder.setText(i2, String.format(string, objArr));
    }

    @Override // com.bytedance.sdk.djx.core.business.view.rv.base.IMultiItemView
    public void bindViewHolder(BaseViewHolder baseViewHolder, Object obj, int i, List<Object> list) throws Resources.NotFoundException {
        bindViewHolder(baseViewHolder, obj, i);
    }

    private void setImageUrl(Context context, ImageView imageView, String str, int i, int i2) {
        new BEHomeLoadFrame(this.mPosition, SourceMode.PLAYLET).send();
        Picasso.with(context).load(str).config(Bitmap.Config.RGB_565).centerCrop().resize(i, i2).tag(ImageTag.TAG_DRAMA_HOME).placeholder(R.drawable.djx_grid_item_bg).noFade().memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(imageView, new Callback() { // from class: com.bytedance.sdk.djx.core.business.budrama.home.DramaItemView.1
            @Override // com.bytedance.sdk.djx.net.img.Callback
            public void onError() {
            }

            @Override // com.bytedance.sdk.djx.net.img.Callback
            public void onSuccess() {
                new BEHomeFirstFrame(DramaItemView.this.mPosition, SourceMode.PLAYLET).send();
            }
        });
    }
}
