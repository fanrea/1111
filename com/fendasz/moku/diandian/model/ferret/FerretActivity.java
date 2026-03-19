package com.fendasz.moku.diandian.model.ferret;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fendasz.moku.diandian.commons.MokuDianActivity;
import com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity;
import com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.MokuOptions;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataList;
import com.fendasz.moku.planet.ui.view.FlowLayoutView;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.StorageUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FerretActivity extends MokuDianActivity {
    private static final int MAX_FERRET_HOT_SIZE = 8;
    public static final int REQUEST_CODE_FOR_MOKU_DETAIL = 200;
    private static final int REQUEST_SEARCH_RESULT_CODE = 6000;
    private static final String TAG = "Dian_Search_Ferret=>";
    private FlowLayoutView historyFlow;
    private FlowLayoutView hotFlow;
    private ArrayList<ClientSampleTaskData> hotList;
    private TextView hotText;
    private boolean isHotLoading = false;
    private Context mContext;
    private MokuOptions mMokuOptions;
    private LinearLayout rootView;
    private EditText searchEdit;

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_activity_dian_ferret, viewGroup, false);
        this.rootView = linearLayout;
        return linearLayout;
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.ferret.FerretActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FerretActivity.this.finish();
            }
        });
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        super.initTitle(textView);
        if (textView == null || this.mMokuOptions.getString("titleText", null) == null) {
            return;
        }
        textView.setText("搜索");
        textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 70.0f)));
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initView() {
        super.initView();
        this.rootView.setBackgroundColor(-1);
        this.historyFlow = (FlowLayoutView) this.rootView.findViewById(R.id.moku_flow_search_history);
        this.hotFlow = (FlowLayoutView) this.rootView.findViewById(R.id.moku_flow_search_hot);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.historyFlow.getLayoutParams();
        layoutParams.setMargins(50, 30, 50, 0);
        this.historyFlow.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hotFlow.getLayoutParams();
        layoutParams2.setMargins(50, 30, 50, 0);
        this.hotFlow.setLayoutParams(layoutParams2);
        int color = Color.parseColor(this.mMokuOptions.getString("titleColor", "#D2E5CF"));
        int scale = PhoneScreenUtils.getInstance().getScale(this.mContext, 100.0f);
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.moku_iv_ferrent_search);
        imageView.setBackgroundResource(R.drawable.moku_dian_search);
        Drawable background = imageView.getBackground();
        if (Build.VERSION.SDK_INT >= 21) {
            background.setTint(color);
        }
        imageView.setLayoutParams(new LinearLayout.LayoutParams(scale, scale));
        EditText editText = (EditText) this.rootView.findViewById(R.id.moku_edit_ferrent_search);
        this.searchEdit = editText;
        editText.setHintTextColor(-7829368);
        this.searchEdit.setTextColor(color);
        this.searchEdit.setHint("请输入任务名称");
        this.searchEdit.setGravity(19);
        this.searchEdit.setBackgroundColor(-1);
        this.searchEdit.setBackground(null);
        this.searchEdit.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 50.0f)));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.searchEdit.getLayoutParams();
        layoutParams3.height = -1;
        layoutParams3.setMargins(0, 5, 0, 5);
        this.searchEdit.setLayoutParams(layoutParams3);
        TextView textView = (TextView) this.rootView.findViewById(R.id.moku_tv_ferrent_search);
        textView.setText("搜索");
        textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 50.0f)));
        textView.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(10.0f);
        gradientDrawable.setShape(0);
        textView.setTextColor(-1);
        textView.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams4.height = -1;
        layoutParams4.setMargins(0, 20, 10, 20);
        textView.setLayoutParams(layoutParams4);
        TextView textView2 = (TextView) this.rootView.findViewById(R.id.moku_tv_search_history);
        textView2.setTextColor(-16777216);
        textView2.setText("搜索历史");
        textView2.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 50.0f)));
        ((RelativeLayout.LayoutParams) textView2.getLayoutParams()).setMargins(20, 0, 0, 0);
        ImageView imageView2 = (ImageView) this.rootView.findViewById(R.id.moku_iv_delete_history);
        imageView2.setBackgroundResource(R.drawable.moku_search_delete);
        Drawable background2 = imageView2.getBackground();
        if (Build.VERSION.SDK_INT >= 21) {
            background2.setTint(color);
        }
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        layoutParams5.height = 50;
        layoutParams5.width = 50;
        layoutParams5.setMargins(0, 0, 20, 0);
        imageView2.setLayoutParams(layoutParams5);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.ferret.FerretActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StorageUtils.cleanSearchHistory(FerretActivity.this.mContext);
                FerretActivity.this.historyFlow.removeAllViews();
                FerretActivity.this.historyFlow.invalidate();
            }
        });
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setStroke(5, color);
        gradientDrawable2.setCornerRadius(15.0f);
        gradientDrawable2.setShape(0);
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R.id.moku_rv_ferrent);
        linearLayout.setBackground(gradientDrawable2);
        PhoneScreenUtils.getInstance().getWidthPixels(this.mContext);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 120);
        layoutParams6.setMargins(20, 20, 20, 20);
        linearLayout.setGravity(16);
        linearLayout.setPadding(20, 0, 0, 0);
        linearLayout.setLayoutParams(layoutParams6);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.ferret.FerretActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String string = FerretActivity.this.searchEdit.getText().toString();
                if (StringUtils.isEmpty(string)) {
                    FerretActivity.this.showToast("请输入任务名称");
                    return;
                }
                if (string.length() < 30) {
                    List<String> listQueryDianSearchHistory = StorageUtils.queryDianSearchHistory(FerretActivity.this.mContext);
                    Intent intent = new Intent(FerretActivity.this, (Class<?>) SearchResultActivity.class);
                    intent.putExtra("moku_dian_ferret_key", string);
                    FerretActivity.this.startActivityForResult(intent, 6000);
                    if (listQueryDianSearchHistory == null) {
                        StorageUtils.addDianSearchHistory(FerretActivity.this.mContext, string);
                        return;
                    } else {
                        if (listQueryDianSearchHistory.contains(string) || listQueryDianSearchHistory.size() >= 8) {
                            return;
                        }
                        StorageUtils.addDianSearchHistory(FerretActivity.this.mContext, string);
                        return;
                    }
                }
                FerretActivity.this.showToast("输入文字过多，少点儿试试吧~");
            }
        });
        TextView textView3 = (TextView) this.rootView.findViewById(R.id.moku_tv_search_hot);
        this.hotText = textView3;
        textView3.setTextColor(-16777216);
        this.hotText.setText("热门搜索");
        this.hotText.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 50.0f)));
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.hotText.getLayoutParams();
        layoutParams7.setMargins(20, 120, 0, 0);
        this.hotText.setLayoutParams(layoutParams7);
        addKeyboardListener();
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        super.onSuperCreate(bundle);
        this.mContext = this;
        this.mMokuOptions = MokuConfigure.getInstance().getMokuOptions(this.mContext);
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() {
        super.onLoad();
        initHotList();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        initSearchHistory();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            Log.d(TAG, "onConfigurationChanged: 横屏");
        } else if (configuration.orientation == 1) {
            Log.d(TAG, "onConfigurationChanged: 竖屏");
        }
    }

    private void initSearchHistory() {
        this.historyFlow.removeAllViews();
        List<String> listQueryDianSearchHistory = StorageUtils.queryDianSearchHistory(this.mContext);
        if (listQueryDianSearchHistory == null || listQueryDianSearchHistory.isEmpty()) {
            return;
        }
        Iterator<String> it = listQueryDianSearchHistory.iterator();
        while (it.hasNext()) {
            createTextView(this.historyFlow, it.next(), 1, null);
        }
    }

    private void initHotList() {
        ApiDataHelper.getApiDataHelper().getDianTaskList(this, 1, 500, 5, null, null, null, new ApiDataCallBack<ClientSampleTaskDataList>() { // from class: com.fendasz.moku.diandian.model.ferret.FerretActivity.4
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, ClientSampleTaskDataList clientSampleTaskDataList) throws Exception {
                List<ClientSampleTaskData> list = clientSampleTaskDataList.getList();
                if (list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(8);
                    Collections.sort(clientSampleTaskDataList.getList(), new Comparator<ClientSampleTaskData>() { // from class: com.fendasz.moku.diandian.model.ferret.FerretActivity.4.1
                        @Override // java.util.Comparator
                        public int compare(ClientSampleTaskData clientSampleTaskData, ClientSampleTaskData clientSampleTaskData2) {
                            return Integer.compare(clientSampleTaskData.getTopIndex().intValue(), clientSampleTaskData2.getTopIndex().intValue());
                        }
                    });
                    for (ClientSampleTaskData clientSampleTaskData : clientSampleTaskDataList.getList()) {
                        if (arrayList.size() >= 8) {
                            break;
                        } else if (clientSampleTaskData.isTopPosition()) {
                            arrayList.add(clientSampleTaskData);
                        }
                    }
                    FerretActivity.this.hotList = arrayList;
                }
                FerretActivity ferretActivity = FerretActivity.this;
                ferretActivity.invalidateHotView(ferretActivity.hotList);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                if (FerretActivity.this.hotFlow != null) {
                    FerretActivity.this.hotFlow.removeAllViews();
                    FerretActivity.this.hotFlow.invalidate();
                }
                if (FerretActivity.this.hotText != null) {
                    FerretActivity.this.hotText.setVisibility(8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateHotView(ArrayList<ClientSampleTaskData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ClientSampleTaskData clientSampleTaskData = arrayList.get(i);
            if (i >= 8) {
                return;
            }
            createTextView(this.hotFlow, clientSampleTaskData.getShowName(), 2, clientSampleTaskData);
        }
    }

    private void createTextView(FlowLayoutView flowLayoutView, final String str, final int i, final ClientSampleTaskData clientSampleTaskData) {
        TextView textView = new TextView(this.mContext);
        textView.setText(str);
        textView.setTextColor(-16777216);
        textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 50.0f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        int color = Color.parseColor(this.mMokuOptions.getString("titleColor", "#D2E5CF"));
        gradientDrawable.setColor(Color.parseColor("#EDEDED"));
        gradientDrawable.setCornerRadius(50.0f);
        gradientDrawable.setStroke(5, color);
        gradientDrawable.setShape(0);
        textView.setBackground(gradientDrawable);
        textView.setPadding(40, 20, 40, 20);
        flowLayoutView.addView(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.ferret.FerretActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ClientSampleTaskData clientSampleTaskData2;
                int i2 = i;
                if (1 != i2) {
                    if (2 != i2 || (clientSampleTaskData2 = clientSampleTaskData) == null) {
                        return;
                    }
                    FerretActivity.this.gotoDetail(clientSampleTaskData2);
                    return;
                }
                FerretActivity.this.searchEdit.setText(str);
                FerretActivity.this.searchEdit.setSelection(str.length());
                Intent intent = new Intent(FerretActivity.this, (Class<?>) SearchResultActivity.class);
                intent.putExtra("moku_dian_ferret_key", str);
                FerretActivity.this.startActivityForResult(intent, 6000);
            }
        });
    }

    private void addKeyboardListener() {
        this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.fendasz.moku.diandian.model.ferret.FerretActivity.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                FerretActivity.this.rootView.getWindowVisibleDisplayFrame(new Rect());
                if (r1 - r0.bottom > FerretActivity.this.rootView.getRootView().getHeight() * 0.15d) {
                    FerretActivity.this.adjustLayoutForKeyboard(true);
                } else {
                    FerretActivity.this.adjustLayoutForKeyboard(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustLayoutForKeyboard(boolean z) {
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hotFlow.getLayoutParams();
            layoutParams.height = 200;
            this.hotFlow.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hotFlow.getLayoutParams();
            layoutParams2.height = -2;
            this.hotFlow.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoDetail(ClientSampleTaskData clientSampleTaskData) {
        Intent intent;
        Integer taskDataId = clientSampleTaskData.getTaskDataId();
        if (clientSampleTaskData.getCpl() != null && clientSampleTaskData.getCpl().booleanValue()) {
            intent = new Intent(this, (Class<?>) DianCPLDetailActivity.class);
        } else if (clientSampleTaskData.getTaskType() != null && clientSampleTaskData.getTaskType().intValue() == 1) {
            Toast.makeText(this, "任务配置信息错误，请联系客服处理", 0).show();
            intent = null;
        } else {
            intent = new Intent(this, (Class<?>) DianCpaDetailActivity.class);
        }
        intent.putExtra("taskDataId", taskDataId.intValue());
        String gateType = clientSampleTaskData.getGateType();
        if (!TextUtils.isEmpty(gateType)) {
            intent.putExtra("gateType", gateType);
        }
        intent.putExtra("operationType", 100);
        startActivityForResult(intent, 200);
    }
}
