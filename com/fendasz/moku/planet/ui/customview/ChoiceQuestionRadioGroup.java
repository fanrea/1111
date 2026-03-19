package com.fendasz.moku.planet.ui.customview;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ChoiceQuestionRadioGroup extends LinearLayout {
    private Map<Integer, Boolean> isClickMap;
    private Config mConfig;
    private Context mContext;
    private List<LinearLayout> mLlAnswerViewList;
    private OnSelectedListener mOnSelectedListener;
    private String[] mOptions;
    private final PhoneScreenUtils mPhoneScreenUtils;

    public interface OnAnswerCallback {
        void callback(boolean z);
    }

    public interface OnSelectedListener {
        boolean onSelect(int i, String str, Integer num, OnAnswerCallback onAnswerCallback);
    }

    public ChoiceQuestionRadioGroup(Context context) {
        super(context);
        this.mOptions = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        this.mContext = context;
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
        this.mLlAnswerViewList = new ArrayList();
        setOrientation(1);
        this.isClickMap = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfig(Config config) {
        this.mConfig = config;
        if (config.answerList != null) {
            refresh();
        }
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.mOnSelectedListener = onSelectedListener;
    }

    public boolean isAllTrue() {
        Map<Integer, Boolean> map = this.isClickMap;
        if (map == null) {
            return true;
        }
        Iterator<Map.Entry<Integer, Boolean>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public void cleanClickMap() {
        Map<Integer, Boolean> map = this.isClickMap;
        if (map != null) {
            map.clear();
        }
    }

    public void refresh() {
        removeAllViews();
        this.mLlAnswerViewList.clear();
        Integer num = this.mConfig.questionNum;
        Map<Integer, Boolean> map = this.isClickMap;
        if (map != null) {
            map.put(num, false);
        }
        if (this.mConfig.answerList != null) {
            for (int i = 0; i < this.mConfig.answerList.size(); i++) {
                String str = this.mConfig.answerList.get(i);
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_answer_item, (ViewGroup) this, false);
                addView(linearLayout);
                if (i != 0) {
                    ScreenAdaptationUtils.setMarginTop(this.mContext, linearLayout, 20);
                }
                linearLayout.setEnabled(true);
                TextView textView = (TextView) linearLayout.findViewById(R.id.tv_answer_error);
                textView.setTextSize(this.mPhoneScreenUtils.getTipsTextSize(this.mContext));
                ScreenAdaptationUtils.setSize(this.mContext, textView, 50, 50);
                ScreenAdaptationUtils.setMarginRight(this.mContext, textView, 15);
                linearLayout.setOnClickListener(new AnonymousClass1(num, i, str, textView));
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.tv_answer_index);
                textView2.setText(this.mOptions[i]);
                ScreenAdaptationUtils.setSize(this.mContext, textView2, 50, 50);
                textView2.setTextSize(this.mPhoneScreenUtils.getTipsTextSize(this.mContext));
                ScreenAdaptationUtils.setMargin(this.mContext, textView2, 15, 15, 15, 15);
                TextView textView3 = (TextView) linearLayout.findViewById(R.id.tv_answer);
                if (Build.VERSION.SDK_INT >= 24) {
                    textView3.setText(Html.fromHtml(str, 63));
                } else {
                    textView3.setText(Html.fromHtml(str));
                }
                textView3.setTextSize(this.mPhoneScreenUtils.getSmallTextSize(this.mContext));
                this.mLlAnswerViewList.add(linearLayout);
            }
        }
    }

    /* renamed from: com.fendasz.moku.planet.ui.customview.ChoiceQuestionRadioGroup$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ String val$answer;
        final /* synthetic */ int val$finalI;
        final /* synthetic */ Integer val$questionNum;
        final /* synthetic */ TextView val$tvAnswerError;

        AnonymousClass1(Integer num, int i, String str, TextView textView) {
            this.val$questionNum = num;
            this.val$finalI = i;
            this.val$answer = str;
            this.val$tvAnswerError = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChoiceQuestionRadioGroup.this.mOnSelectedListener != null) {
                ChoiceQuestionRadioGroup.this.isClickMap.put(this.val$questionNum, true);
                boolean zOnSelect = ChoiceQuestionRadioGroup.this.mOnSelectedListener.onSelect(this.val$finalI, this.val$answer, this.val$questionNum, new OnAnswerCallback() { // from class: com.fendasz.moku.planet.ui.customview.ChoiceQuestionRadioGroup.1.1
                    @Override // com.fendasz.moku.planet.ui.customview.ChoiceQuestionRadioGroup.OnAnswerCallback
                    public void callback(final boolean z) {
                        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.ui.customview.ChoiceQuestionRadioGroup.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z) {
                                    AnonymousClass1.this.val$tvAnswerError.setVisibility(4);
                                } else {
                                    AnonymousClass1.this.val$tvAnswerError.setVisibility(0);
                                }
                                for (int i = 0; i < ChoiceQuestionRadioGroup.this.mLlAnswerViewList.size(); i++) {
                                    ((LinearLayout) ChoiceQuestionRadioGroup.this.mLlAnswerViewList.get(i)).setEnabled(true);
                                }
                            }
                        });
                    }
                });
                LogUtils.log("TaskDialog", "onSelect return");
                if (zOnSelect) {
                    for (int i = 0; i < ChoiceQuestionRadioGroup.this.mLlAnswerViewList.size(); i++) {
                        LinearLayout linearLayout = (LinearLayout) ChoiceQuestionRadioGroup.this.mLlAnswerViewList.get(i);
                        if (i == this.val$finalI) {
                            linearLayout.setEnabled(false);
                            linearLayout.setSelected(true);
                        } else {
                            linearLayout.setEnabled(true);
                            ((TextView) linearLayout.findViewById(R.id.tv_answer_error)).setVisibility(4);
                        }
                    }
                }
            }
        }
    }

    public static class Builder {
        private final Config mConfig;
        Context mContext;

        public Builder(Context context, List<String> list, Integer num) {
            this.mContext = context;
            Config config = new Config();
            this.mConfig = config;
            config.answerList = list;
            config.questionNum = num;
        }

        public ChoiceQuestionRadioGroup build() {
            ChoiceQuestionRadioGroup choiceQuestionRadioGroup = new ChoiceQuestionRadioGroup(this.mContext);
            choiceQuestionRadioGroup.setConfig(this.mConfig);
            return choiceQuestionRadioGroup;
        }
    }

    static class Config {
        List<String> answerList;
        Integer questionNum;

        Config() {
        }
    }
}
