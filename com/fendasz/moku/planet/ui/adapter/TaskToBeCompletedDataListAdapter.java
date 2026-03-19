package com.fendasz.moku.planet.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.ui.base.adapter.RecyclerViewHolder;
import com.fendasz.moku.planet.utils.DateUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.pandora.common.utils.Times;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskToBeCompletedDataListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "TaskToBeCompletedDataListAdapter";
    private OnItemClickListener mClickListener;
    private List<ClientSampleTaskData> mClientSampleTaskDataList;
    private final Context mContext;
    private final int TYPE_ITEM = 1;
    private final int TYPE_FOOTER = 2;
    private int loadState = 2;
    public final int LOADING = 1;
    public final int LOADING_COMPLETE = 2;
    public final int LOADING_END = 3;
    private ScheduledExecutorService scheduled = null;
    private Long currentTime = null;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public TaskToBeCompletedDataListAdapter(Context context, List<ClientSampleTaskData> list) {
        this.mContext = context;
        this.mClientSampleTaskDataList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i + 1 == getItemCount() ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 2) {
            return new FootViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.moku_layout_refresh_footer, viewGroup, false));
        }
        return new RecyclerViewHolder(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.moku_item_taskdata_list, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
        if (viewHolder instanceof FootViewHolder) {
            PhoneScreenUtils phoneScreenUtils = PhoneScreenUtils.getInstance();
            FootViewHolder footViewHolder = (FootViewHolder) viewHolder;
            ScreenAdaptationUtils.setHeight(this.mContext, footViewHolder.rlFooterContainer, 200);
            TextView textView = footViewHolder.tvLoadMore;
            textView.setTextSize(phoneScreenUtils.getNormalTextSize(this.mContext));
            ProgressBar progressBar = footViewHolder.pbLoading;
            ScreenAdaptationUtils.setSize(this.mContext, progressBar, 80, 80);
            ScreenAdaptationUtils.setMarginRight(this.mContext, progressBar, 50);
            TextView textView2 = footViewHolder.tvLoading;
            textView2.setTextSize(phoneScreenUtils.getNormalTextSize(this.mContext));
            LinearLayout linearLayout = footViewHolder.llEnd;
            TextView textView3 = footViewHolder.tvEnd;
            textView3.setTextSize(phoneScreenUtils.getNormalTextSize(this.mContext));
            int i2 = this.loadState;
            if (i2 == 1) {
                textView.setVisibility(8);
                progressBar.setVisibility(0);
                textView2.setVisibility(0);
                linearLayout.setVisibility(8);
                textView3.setVisibility(8);
                return;
            }
            if (i2 == 2) {
                textView.setVisibility(0);
                progressBar.setVisibility(8);
                textView2.setVisibility(8);
                linearLayout.setVisibility(8);
                textView3.setVisibility(8);
                return;
            }
            if (i2 != 3) {
                return;
            }
            textView.setVisibility(8);
            progressBar.setVisibility(8);
            textView2.setVisibility(8);
            linearLayout.setVisibility(0);
            textView3.setVisibility(0);
            return;
        }
        if (this.mClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.adapter.TaskToBeCompletedDataListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TaskToBeCompletedDataListAdapter.this.mClickListener.onItemClick(viewHolder.itemView, viewHolder.getLayoutPosition());
                }
            });
        }
        bindData(viewHolder, i, this.mClientSampleTaskDataList.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ClientSampleTaskData> list = this.mClientSampleTaskDataList;
        if (list != null) {
            return list.size() + 1;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void bindData(androidx.recyclerview.widget.RecyclerView.ViewHolder r28, int r29, final com.fendasz.moku.planet.source.bean.ClientSampleTaskData r30) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.ui.adapter.TaskToBeCompletedDataListAdapter.bindData(androidx.recyclerview.widget.RecyclerView$ViewHolder, int, com.fendasz.moku.planet.source.bean.ClientSampleTaskData):void");
    }

    private String judgeTime(String str) {
        Date date = DateUtils.getDate(str, "yyyy-MM-dd HH:mm:ss");
        String formatDate = DateUtils.getFormatDate(SharedPreferencesUtils.getInstance(this.mContext).getLong("mokuTime", System.currentTimeMillis()), "yyyy-MM-dd HH:mm:ss");
        Date date2 = DateUtils.getDate(formatDate, "yyyy-MM-dd HH:mm:ss");
        if (date.equals(date2) || date.before(date2)) {
            return "<font color=\"#66CC33\">待完成</font>";
        }
        Date date3 = DateUtils.getDate(str, Times.YYYY_MM_DD);
        long time = (date3.getTime() - DateUtils.getDate(formatDate, Times.YYYY_MM_DD).getTime()) / 86400000;
        if (time == 0) {
            return "今日开启";
        }
        if (time == 1) {
            return "明日开启";
        }
        return DateUtils.getFormatDate(date3.getTime(), "MM月dd日") + "开启";
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mClickListener = onItemClickListener;
    }

    public void setLoadState(int i) {
        this.loadState = i;
        notifyItemChanged(getItemCount() - 1);
    }

    public void notifyDataInit() {
        initCountDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCountDown() {
        ScheduledExecutorService scheduledExecutorService = this.scheduled;
        if (scheduledExecutorService != null) {
            if (!scheduledExecutorService.isShutdown()) {
                this.scheduled.shutdownNow();
            }
            this.scheduled = null;
        }
        this.currentTime = null;
    }

    private static class FootViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llEnd;
        ProgressBar pbLoading;
        RelativeLayout rlFooterContainer;
        TextView tvEnd;
        TextView tvLoadMore;
        TextView tvLoading;

        FootViewHolder(View view) {
            super(view);
            this.pbLoading = (ProgressBar) view.findViewById(R.id.pb_loading);
            this.tvLoading = (TextView) view.findViewById(R.id.tv_loading);
            this.tvLoadMore = (TextView) view.findViewById(R.id.tv_load_more);
            this.tvEnd = (TextView) view.findViewById(R.id.tv_end);
            this.llEnd = (LinearLayout) view.findViewById(R.id.ll_end);
            this.rlFooterContainer = (RelativeLayout) view.findViewById(R.id.rl_footer_container);
        }
    }

    public void setList(List<ClientSampleTaskData> list) {
        this.mClientSampleTaskDataList = list;
    }
}
