package com.fendasz.moku.planet.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter;
import com.fendasz.moku.planet.ui.base.adapter.RecyclerViewHolder;
import com.fendasz.moku.planet.utils.DateUtils;
import com.fendasz.moku.planet.utils.ImageUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.pandora.common.utils.Times;
import java.util.Date;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MyParticipateInAdapter extends BaseRecyclerAdapter<ClientSampleTaskData> {
    @Override // com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter
    public void notifyDataInit() {
    }

    public MyParticipateInAdapter(Context context, List<ClientSampleTaskData> list) {
        super(context, list);
    }

    @Override // com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter
    public int getItemLayoutId(int i) {
        return R.layout.moku_item_my_part_in;
    }

    @Override // com.fendasz.moku.planet.ui.base.adapter.BaseRecyclerAdapter
    public void bindData(RecyclerViewHolder recyclerViewHolder, int i, ClientSampleTaskData clientSampleTaskData) {
        PhoneScreenUtils phoneScreenUtils = PhoneScreenUtils.getInstance();
        ScreenAdaptationUtils.setPadding(this.mContext, recyclerViewHolder.itemView, 0, 30, 0, 30);
        LinearLayout linearLayout = (LinearLayout) recyclerViewHolder.findViewById(R.id.ll_rv_item);
        ScreenAdaptationUtils.setPadding(this.mContext, linearLayout, 30, 0, 30, 0);
        ScreenAdaptationUtils.setHeight(this.mContext, linearLayout, 200);
        final ImageView imageView = (ImageView) recyclerViewHolder.findViewById(R.id.iv_icon);
        ScreenAdaptationUtils.setSize(this.mContext, imageView, 120, 120);
        ScreenAdaptationUtils.setMarginRight(this.mContext, imageView, 20);
        TextView textView = (TextView) recyclerViewHolder.findViewById(R.id.tv_task_name);
        textView.setTextSize(phoneScreenUtils.getNormalTextSize(this.mContext));
        textView.setText(clientSampleTaskData.easyTaskName());
        textView.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_very_deep));
        TextView textView2 = (TextView) recyclerViewHolder.findViewById(R.id.tv_task_status);
        textView2.setTextSize(phoneScreenUtils.getNormalTextSize(this.mContext));
        if (clientSampleTaskData.getCpl() != null && clientSampleTaskData.getCpl().booleanValue()) {
            String str = "已赚" + StringUtils.formatMoney(clientSampleTaskData.getShowEarnedMoney().toString()) + clientSampleTaskData.getCybermoneyName() + " | " + clientSampleTaskData.getTimeLeft();
            String timeLeft = clientSampleTaskData.getTimeLeft();
            if (timeLeft != null && clientSampleTaskData.getUrgentLogo() != null) {
                int length = str.length();
                int length2 = length - timeLeft.length();
                SpannableString spannableString = new SpannableString(str);
                if (clientSampleTaskData.getUrgentLogo().intValue() == 1) {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#70C348")), length2, length, 33);
                    textView2.setText(spannableString);
                } else if (clientSampleTaskData.getUrgentLogo().intValue() == 2) {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF9900")), length2, length, 33);
                    textView2.setText(spannableString);
                } else if (clientSampleTaskData.getUrgentLogo().intValue() == 3) {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), length2, length, 33);
                    textView2.setText(spannableString);
                } else {
                    textView2.setText(str);
                }
            } else {
                textView2.setText(str);
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            textView2.setText(Html.fromHtml("已赚" + StringUtils.formatMoney(clientSampleTaskData.getShowEarnedMoney().toString()) + clientSampleTaskData.getCybermoneyName() + " | " + judgeTime(clientSampleTaskData.getOpenDateTime()), 63));
        } else {
            textView2.setText(Html.fromHtml("已赚" + StringUtils.formatMoney(clientSampleTaskData.getShowEarnedMoney().toString()) + clientSampleTaskData.getCybermoneyName() + " | " + judgeTime(clientSampleTaskData.getOpenDateTime())));
        }
        TextView textView3 = (TextView) recyclerViewHolder.findViewById(R.id.tv_task_money);
        textView3.setTextSize(phoneScreenUtils.getBigTextSize(this.mContext));
        textView3.setText(StringUtils.formatMoney(clientSampleTaskData.getShowMoney().toPlainString()) + clientSampleTaskData.getCybermoneyName());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
        alphaAnimation.setDuration(400L);
        imageView.startAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation2.setDuration(400L);
        ImageUtils.getInstance().setImageView(this.mContext, clientSampleTaskData.getIcon(), new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.adapter.MyParticipateInAdapter.1
            @Override // com.fendasz.moku.planet.interf.functions.Consumer
            public void accept(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        }, Float.valueOf(phoneScreenUtils.getScale(this.mContext, 120.0f)), Float.valueOf(phoneScreenUtils.getScale(this.mContext, 120.0f)));
        imageView.startAnimation(alphaAnimation2);
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
}
