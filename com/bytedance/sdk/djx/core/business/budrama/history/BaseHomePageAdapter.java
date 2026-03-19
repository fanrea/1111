package com.bytedance.sdk.djx.core.business.budrama.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.params.DJXWidgetDramaHistoryParam;
import com.bytedance.sdk.djx.utils.LG;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class BaseHomePageAdapter<DataType> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_TYPE_EMPTY = 0;
    private static final int ITEM_TYPE_FOOTER = 2;
    private static final int ITEM_TYPE_NORMAL = 1;
    private static final String TAG = "BaseHomePageAdapter";
    private final DJXWidgetDramaHistoryParam.PageType mPageType;
    protected final DJXDramaHistoryViewModel mViewModel;
    private boolean mFromHomePage = false;
    protected final ArrayList<DataType> mDataList = new ArrayList<>();
    private View.OnClickListener mButtonClickListener = null;

    public void bindFooterViewHolder(FooterItemHolder footerItemHolder) {
    }

    protected abstract void bindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i);

    protected abstract RecyclerView.ViewHolder createItemViewHolder(ViewGroup viewGroup, int i);

    public BaseHomePageAdapter(DJXDramaHistoryViewModel dJXDramaHistoryViewModel, DJXWidgetDramaHistoryParam.PageType pageType) {
        this.mViewModel = dJXDramaHistoryViewModel;
        this.mPageType = pageType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mDataList.isEmpty()) {
            return 1;
        }
        return this.mDataList.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new EmptyItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.djx_item_empty_content, viewGroup, false));
        }
        if (i == 1) {
            return createItemViewHolder(viewGroup, i);
        }
        if (i == 2) {
            return new FooterItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getFooterViewLayoutId(), viewGroup, false));
        }
        throw new IllegalArgumentException("BaseHomePageAdapter invalid itemType = " + i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            bindEmptyItemContent((EmptyItemHolder) viewHolder);
        } else if (itemViewType == 1) {
            bindItemViewHolder(viewHolder, i);
        } else {
            if (itemViewType != 2) {
                return;
            }
            bindFooterViewHolder((FooterItemHolder) viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.mDataList.isEmpty()) {
            return 0;
        }
        return i == getItemCount() - 1 ? 2 : 1;
    }

    protected int getFooterViewLayoutId() {
        return R.layout.djx_layout_default_footer;
    }

    public void appendData(List<DataType> list) {
        boolean zIsEmptyDataList = isEmptyDataList();
        if (list != null && !list.isEmpty()) {
            int size = this.mDataList.size();
            this.mDataList.addAll(list);
            if (zIsEmptyDataList) {
                notifyDataSetChanged();
            } else {
                notifyItemRangeInserted(size, list.size());
            }
        }
        notifyItemChanged(getItemCount() - 1);
    }

    public void appendData(DataType datatype) {
        boolean zIsEmptyDataList = isEmptyDataList();
        int size = this.mDataList.size();
        this.mDataList.add(datatype);
        if (zIsEmptyDataList) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeInserted(size, 1);
        }
        notifyItemChanged(getItemCount() - 1);
    }

    public void appendToHead(DataType datatype) {
        boolean zIsEmptyDataList = isEmptyDataList();
        this.mDataList.add(0, datatype);
        if (zIsEmptyDataList) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeInserted(0, 1);
        }
        notifyItemChanged(getItemCount() - 1);
    }

    public void removeItem(int i) {
        try {
            this.mDataList.remove(i);
            notifyItemRangeRemoved(i, 1);
        } catch (Throwable th) {
            LG.e(TAG, "BaseHomePageAdapter removeItem ", th);
        }
    }

    public List<DataType> getDataList() {
        return this.mDataList;
    }

    public DataType getItem(int i) {
        if (this.mDataList.isEmpty() || i == getItemCount() - 1) {
            return null;
        }
        try {
            return this.mDataList.get(i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean isEmptyDataList() {
        return this.mDataList.isEmpty();
    }

    public void setEmptyItemButtonClickListener(View.OnClickListener onClickListener) {
        this.mButtonClickListener = onClickListener;
    }

    /* renamed from: com.bytedance.sdk.djx.core.business.budrama.history.BaseHomePageAdapter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$sdk$djx$params$DJXWidgetDramaHistoryParam$PageType;

        static {
            int[] iArr = new int[DJXWidgetDramaHistoryParam.PageType.values().length];
            $SwitchMap$com$bytedance$sdk$djx$params$DJXWidgetDramaHistoryParam$PageType = iArr;
            try {
                iArr[DJXWidgetDramaHistoryParam.PageType.USER_DRAMA_HISTORY_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void bindEmptyItemContent(EmptyItemHolder emptyItemHolder) {
        if (AnonymousClass2.$SwitchMap$com$bytedance$sdk$djx$params$DJXWidgetDramaHistoryParam$PageType[this.mPageType.ordinal()] != 1) {
            return;
        }
        emptyItemHolder.mEmptyContentIcon.setImageResource(R.drawable.djx_icon_empty_drama_history);
        emptyItemHolder.mEmptyContentHint1.setText(R.string.djx_empty_drama_history_hint1);
        emptyItemHolder.mEmptyContentHint2.setText(R.string.djx_empty_drama_history_hint2);
        emptyItemHolder.mGotoWatchVideo.setVisibility(this.mFromHomePage ? 0 : 8);
        emptyItemHolder.mGotoWatchVideo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.history.BaseHomePageAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BaseHomePageAdapter.this.mButtonClickListener != null) {
                    BaseHomePageAdapter.this.mButtonClickListener.onClick(view);
                }
            }
        });
    }

    public static class EmptyItemHolder extends RecyclerView.ViewHolder {
        public final TextView mEmptyContentHint1;
        public final TextView mEmptyContentHint2;
        public final ImageView mEmptyContentIcon;
        public final LinearLayout mGotoWatchVideo;

        public EmptyItemHolder(View view) {
            super(view);
            this.mEmptyContentIcon = (ImageView) view.findViewById(R.id.djx_empty_content_icon);
            this.mEmptyContentHint1 = (TextView) view.findViewById(R.id.djx_empty_content_hint1);
            this.mEmptyContentHint2 = (TextView) view.findViewById(R.id.djx_empty_content_hint2);
            this.mGotoWatchVideo = (LinearLayout) view.findViewById(R.id.djx_watch_video);
        }
    }

    public static class FooterItemHolder extends RecyclerView.ViewHolder {
        public ImageView mArrowImage;
        public TextView mTextView;

        public FooterItemHolder(View view) {
            super(view);
            this.mTextView = (TextView) view.findViewById(R.id.djx_footer_text);
            this.mArrowImage = (ImageView) view.findViewById(R.id.djx_arrow);
        }
    }
}
