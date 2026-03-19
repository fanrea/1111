package com.bytedance.sdk.djx.core.business.budrama.history;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.budrama.DramaManager;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDetailHelper;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.log.SdkTLog;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.net.ImageTag;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.params.DJXWidgetDramaDetailParams;
import com.bytedance.sdk.djx.params.DJXWidgetDramaHistoryParam;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaHistoryAdapter extends BaseHomePageAdapter<Drama> {
    private int mLatestItemPosition;
    private final DJXWidgetDramaHistoryParam mParam;
    private final RecyclerView mRecycleView;
    private final SdkTLog mTLog;

    public DramaHistoryAdapter(DJXDramaHistoryViewModel dJXDramaHistoryViewModel, DJXWidgetDramaHistoryParam dJXWidgetDramaHistoryParam, RecyclerView recyclerView) {
        super(dJXDramaHistoryViewModel, DJXWidgetDramaHistoryParam.PageType.USER_DRAMA_HISTORY_PAGE);
        this.mLatestItemPosition = -1;
        this.mTLog = new SdkTLog();
        this.mParam = dJXWidgetDramaHistoryParam;
        this.mRecycleView = recyclerView;
    }

    public void refreshData() {
        if (this.mLatestItemPosition != -1) {
            if (DramaManager.getInstance().getLatestHistory(1).isEmpty()) {
                return;
            }
            Drama drama = DramaManager.getInstance().getLatestHistory(1).get(0);
            if (drama != null && drama.equal((Drama) this.mDataList.get(this.mLatestItemPosition))) {
                this.mRecycleView.scrollToPosition(0);
                this.mDataList.remove(this.mLatestItemPosition);
                notifyItemRemoved(this.mLatestItemPosition);
                this.mDataList.add(0, drama);
                notifyItemInserted(0);
                notifyItemRangeChanged(this.mLatestItemPosition, this.mDataList.size() - this.mLatestItemPosition);
            }
        }
        this.mLatestItemPosition = -1;
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.history.BaseHomePageAdapter
    protected RecyclerView.ViewHolder createItemViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.djx_item_drama_history, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
        layoutParams.width = -1;
        viewInflate.setLayoutParams(layoutParams);
        return new DramaHistoryViewHolder(viewInflate);
    }

    @Override // com.bytedance.sdk.djx.core.business.budrama.history.BaseHomePageAdapter
    protected void bindItemViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        DramaHistoryViewHolder dramaHistoryViewHolder = (DramaHistoryViewHolder) viewHolder;
        Context context = dramaHistoryViewHolder.itemView.getContext();
        final Drama drama = (Drama) this.mDataList.get(i);
        setImageUrl(context, dramaHistoryViewHolder.cover, drama.coverImage);
        dramaHistoryViewHolder.title.setText(String.format(Locale.getDefault(), "%s", drama.title));
        dramaHistoryViewHolder.info.setText(String.format(Locale.getDefault(), "观看至第 %d 集", Integer.valueOf(drama.index)));
        dramaHistoryViewHolder.totalNum.setText(String.format(Locale.getDefault(), "%d集全", Integer.valueOf(drama.total)));
        dramaHistoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.history.DramaHistoryAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Drama dramaCopy = Drama.copy(drama);
                if (drama.index < drama.total) {
                    dramaCopy.index = drama.index + 1;
                }
                DramaDetailHelper.getInstance().start(dramaCopy, 0, DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DRAMA_HISTORY, "", DramaHistoryAdapter.this.mParam.mDramaDetailConfig, DramaHistoryAdapter.this.mParam.mEnterDelegate);
                DramaHistoryAdapter.this.mLatestItemPosition = i;
                DramaHistoryAdapter.this.mTLog.sendPageEvent(ILogConst.Params.SCENE_HISTORY_PAGE, ILogConst.EVENT_T_CLICK, drama, null);
            }
        });
        dramaHistoryViewHolder.enterBtn.setVisibility(drama.index >= drama.total ? 4 : 0);
    }

    private static class DramaHistoryViewHolder extends RecyclerView.ViewHolder {
        private final ImageView cover;
        private final TextView enterBtn;
        private final TextView info;
        private final TextView title;
        private final TextView totalNum;

        public DramaHistoryViewHolder(View view) {
            super(view);
            this.cover = (ImageView) view.findViewById(R.id.djx_drama_cover);
            this.title = (TextView) view.findViewById(R.id.djx_drama_title);
            this.info = (TextView) view.findViewById(R.id.djx_drama_info);
            this.totalNum = (TextView) view.findViewById(R.id.djx_drama_total_num);
            this.enterBtn = (TextView) view.findViewById(R.id.djx_drama_history_enter_btn);
        }
    }

    private void setImageUrl(Context context, ImageView imageView, String str) {
        Picasso.with(context).load(str).config(Bitmap.Config.RGB_565).fit().centerCrop().tag(ImageTag.TAG_DRAW_VIDEO).into(imageView);
    }
}
