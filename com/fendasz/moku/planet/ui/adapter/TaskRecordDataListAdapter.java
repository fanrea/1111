package com.fendasz.moku.planet.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataRecord;
import com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter;
import com.fendasz.moku.planet.ui.base.adapter.RecyclerViewHolder;
import com.fendasz.moku.planet.ui.fragment.ArbitramentFragment;
import com.fendasz.moku.planet.ui.fragment.UnderReviewFragment;
import com.fendasz.moku.planet.utils.ImageUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.TimeUtil;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskRecordDataListAdapter extends BaseRecyclerAdapter<ClientSampleTaskDataRecord> {
    private static final String TAG = "TaskRecordDataListAdapter";

    @Override // com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter
    public void notifyDataInit() {
    }

    public TaskRecordDataListAdapter(Context context, List<ClientSampleTaskDataRecord> list) {
        super(context, list);
    }

    @Override // com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter
    public int getItemLayoutId(int i) {
        return R.layout.moku_item_taskdata_list;
    }

    @Override // com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter
    public void bindData(RecyclerViewHolder recyclerViewHolder, int i, ClientSampleTaskDataRecord clientSampleTaskDataRecord) {
        PhoneScreenUtils phoneScreenUtils = PhoneScreenUtils.getInstance();
        ScreenAdaptationUtils.setPadding(this.mContext, recyclerViewHolder.itemView, 0, 30, 0, 30);
        LinearLayout linearLayout = (LinearLayout) recyclerViewHolder.getView(R.id.item_layout);
        ScreenAdaptationUtils.setPadding(this.mContext, linearLayout, 30, 0, 30, 0);
        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout, 200);
        final ImageView imageView = recyclerViewHolder.getImageView(R.id.iv_icon);
        ScreenAdaptationUtils.setSize(this.mContext, imageView, 120, 120);
        ScreenAdaptationUtils.setMarginRight(this.mContext, imageView, 20);
        TextView textView = recyclerViewHolder.getTextView(R.id.tv_task_name);
        textView.setTextSize(phoneScreenUtils.getNormalTextSize(this.mContext));
        textView.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_very_deep));
        TextView textView2 = recyclerViewHolder.getTextView(R.id.tv_money);
        textView2.setTextSize(phoneScreenUtils.getNormalTextSize(this.mContext));
        TextView textView3 = recyclerViewHolder.getTextView(R.id.tv_surplus_num);
        textView3.setTextSize(phoneScreenUtils.getNormalTextSize(this.mContext));
        TextView textView4 = recyclerViewHolder.getTextView(R.id.tv_desc);
        textView4.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
        textView4.setTextSize(phoneScreenUtils.getNormalTextSize(this.mContext));
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
        alphaAnimation.setDuration(400L);
        imageView.startAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation2.setDuration(400L);
        textView.setText(clientSampleTaskDataRecord.getShowName());
        ImageUtils.getInstance().setImageView(this.mContext, clientSampleTaskDataRecord.getIcon(), new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.adapter.TaskRecordDataListAdapter.1
            @Override // com.fendasz.moku.planet.interf.functions.Consumer
            public void accept(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        }, Float.valueOf(phoneScreenUtils.getScale(this.mContext, 120.0f)), Float.valueOf(phoneScreenUtils.getScale(this.mContext, 120.0f)));
        textView2.setText(StringUtils.formatMoney(clientSampleTaskDataRecord.getShowMoney().toPlainString()) + clientSampleTaskDataRecord.getCybermoneyName());
        textView2.setTextColor(this.mContext.getResources().getColor(R.color.moku_red));
        String tag = getTag();
        String showName = clientSampleTaskDataRecord.getShowName();
        String str = TAG;
        Log.d(str, "taskname=>" + showName + ",tag=>" + tag);
        int taskId = clientSampleTaskDataRecord.getTaskId();
        if (1000000000 < taskId && taskId < 1500000000) {
            ImageView imageView2 = recyclerViewHolder.getImageView(R.id.iv_arbitrament_icon);
            Log.d(str, "taskId between 1000000000 to 1500000000,task is xs");
            if (clientSampleTaskDataRecord.getRecordTime() != null) {
                textView4.setText(clientSampleTaskDataRecord.getRecordTime().substring(5, 16));
            }
            if (UnderReviewFragment.UNDERREVIEW_FRAGMENT_TAG.equals(tag)) {
                textView3.setText("预计" + clientSampleTaskDataRecord.getShowExpectedAuditingTime() + "审核");
                textView3.setTextColor(this.mContext.getResources().getColor(R.color.moku_yellow_golden));
            } else if ("TASKFAIL_FRAGMENT_TAG".equals(tag)) {
                Integer buttonState = clientSampleTaskDataRecord.getButtonState();
                if (buttonState != null) {
                    int iIntValue = buttonState.intValue();
                    if (iIntValue == 0) {
                        textView3.setText("重新提交");
                        textView3.setTextColor(Color.parseColor("#57945e"));
                        imageView2.setImageResource(R.drawable.moku_arbitrament_icon_resubmit);
                    } else if (iIntValue == 1) {
                        textView3.setText("申请裁决");
                        textView3.setTextColor(Color.parseColor("#3d99d4"));
                        imageView2.setImageResource(R.drawable.moku_arbitrament_icon_apply);
                    } else if (iIntValue == 2) {
                        textView3.setTextColor(Color.parseColor("#797979"));
                        textView3.setText("审核失败");
                    }
                }
                textView3.getPaint().setFlags(8);
                textView3.getPaint().setAntiAlias(true);
            } else if ("TASKCOMPLETED_FRAGMENT_TAG".equals(tag)) {
                textView3.setText("处理成功");
                textView3.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
            } else if (ArbitramentFragment.ARBITRAMENT_FRAGMENT_TAG.equals(tag)) {
                Integer arbitrationStatus = clientSampleTaskDataRecord.getArbitrationStatus();
                if (arbitrationStatus != null) {
                    int iIntValue2 = arbitrationStatus.intValue();
                    if (iIntValue2 == 0) {
                        Log.e(str, "record arbitration status is error,state is 0");
                        textView3.setText("申请裁决");
                    } else if (iIntValue2 == 1) {
                        textView3.setText("官方裁决中");
                        textView3.setTextColor(Color.parseColor("#DEB776"));
                        textView4.setText(TimeUtil.parseTime(clientSampleTaskDataRecord.getRecordTime(), "yyyy-MM-dd HH:mm:ss", "MM-dd HH:mm"));
                    } else if (iIntValue2 == 2) {
                        textView3.setText("裁决成功");
                        textView3.setTextColor(Color.parseColor("#12CF87"));
                    } else if (iIntValue2 == 3) {
                        textView3.setText("裁决失败");
                        textView3.setTextColor(Color.parseColor("#797979"));
                    } else {
                        Log.e(str, "record arbitration status is error,unknow state");
                        textView3.setText("其他状态");
                    }
                } else {
                    Log.e(str, "record arbitration status is error,unknow state");
                    textView3.setText("其他状态");
                }
            }
        } else if (clientSampleTaskDataRecord.getRecordStatus().intValue() == 0 || clientSampleTaskDataRecord.getRecordStatus().intValue() == 1 || (!TextUtils.isEmpty(tag) && tag.equals(UnderReviewFragment.UNDERREVIEW_FRAGMENT_TAG))) {
            if (clientSampleTaskDataRecord.getEasy().booleanValue()) {
                textView3.setVisibility(8);
            } else {
                textView3.setText("预计" + clientSampleTaskDataRecord.getShowExpectedAuditingTime() + "审核");
                textView3.setTextColor(this.mContext.getResources().getColor(R.color.moku_yellow_golden));
            }
            textView4.setText(clientSampleTaskDataRecord.getRecordTime().substring(5, 16));
        } else if (clientSampleTaskDataRecord.getRecordStatus().intValue() == 2) {
            if (clientSampleTaskDataRecord.getEasy().booleanValue()) {
                textView3.setVisibility(8);
            } else {
                textView3.setText("处理成功");
                textView3.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
            }
            textView4.setText(clientSampleTaskDataRecord.getRecordTime().substring(5, 16));
        } else if (clientSampleTaskDataRecord.getRecordStatus().intValue() == -1) {
            textView4.setText(clientSampleTaskDataRecord.getRecordTime().substring(5, 16));
            if (this.mContext.getString(R.string.moku_answer_incorrect_title).equals(clientSampleTaskDataRecord.getTaskDataReviewFailureReason().trim())) {
                textView3.setText("答题失败");
            } else {
                textView3.setText("审核失败");
            }
            textView3.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
            textView3.getPaint().setFlags(8);
            textView3.getPaint().setAntiAlias(true);
        }
        imageView.startAnimation(alphaAnimation2);
    }
}
