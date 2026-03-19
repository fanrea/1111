package com.bytedance.sdk.djx.core.business.bureport;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.base.BaseContract;
import com.bytedance.sdk.djx.core.business.base.FragProxy;
import com.bytedance.sdk.djx.core.business.bureport.ReportAdapter;
import com.bytedance.sdk.djx.core.business.view.rv.base.BaseViewHolder;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import com.bytedance.sdk.djx.model.ReportModel;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXReportFragment extends FragProxy implements BaseContract.BaseView {
    private static final String TAG = "DJXReportFragment";
    private Button mBtnCommitReport;
    private EditText mEtComplainDes;
    private RecyclerView mRecyclerView;
    private final ReportAdapter.ReportItemListener mReportItemListener = new ReportAdapter.ReportItemListener() { // from class: com.bytedance.sdk.djx.core.business.bureport.DJXReportFragment.1
        @Override // com.bytedance.sdk.djx.core.business.bureport.ReportAdapter.ReportItemListener
        public void onItemClick(int i, ReportModel reportModel, int i2) {
            if (reportModel == null) {
                return;
            }
            DJXReportFragment.this.mReportModel = reportModel;
            DJXReportFragment.this.mBtnCommitReport.setEnabled(true);
            BaseViewHolder baseViewHolder = (BaseViewHolder) DJXReportFragment.this.mRecyclerView.findViewHolderForAdapterPosition(i2);
            if (baseViewHolder != null) {
                ((RadioButton) baseViewHolder.getView(R.id.djx_item_radio_btn)).setChecked(false);
            }
        }
    };
    private ReportModel mReportModel;
    private DJXReportParams mReportParams;
    private TextView mTvReportDesCount;
    private TextView mTvReportDesLimit;

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initData(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseContract.BaseView
    public void showError() {
    }

    public static DJXReportFragment build(boolean z) {
        DJXReportFragment dJXReportFragment = new DJXReportFragment();
        if (z) {
            dJXReportFragment.getFragment();
        } else {
            dJXReportFragment.getFragment2();
        }
        return dJXReportFragment;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_frag_report);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initView(View view) {
        ArrayList arrayList = new ArrayList();
        if (DJXReportParams.DRAW_REPORT_SOURCE.equals(this.mReportParams.mSource)) {
            arrayList.add(new ReportModel(318, "内容质量差"));
            arrayList.add(new ReportModel(304, "低俗色情"));
            arrayList.add(new ReportModel(316, "标题夸张"));
            arrayList.add(new ReportModel(317, "封面反感"));
            arrayList.add(new ReportModel(302, "广告软文"));
            arrayList.add(new ReportModel(301, "内容不实"));
            arrayList.add(new ReportModel(319, "播放问题"));
            arrayList.add(new ReportModel(315, "其他问题"));
        }
        view.setPadding(0, UIUtil.dp2px(this.mReportParams.mReportTopPadding), 0, 0);
        this.mRecyclerView = (RecyclerView) findById(R.id.djx_report_list);
        ReportAdapter reportAdapter = new ReportAdapter(getContext(), arrayList, this.mReportItemListener);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.mRecyclerView.setAdapter(reportAdapter);
        this.mEtComplainDes = (EditText) findById(R.id.djx_report_complain_des);
        this.mTvReportDesCount = (TextView) findById(R.id.djx_report_des_count);
        this.mTvReportDesLimit = (TextView) findById(R.id.djx_report_limit_sum);
        this.mEtComplainDes.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.djx.core.business.bureport.DJXReportFragment.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable == null) {
                    return;
                }
                DJXReportFragment.this.mTvReportDesCount.setText(String.valueOf(editable.toString().length()));
                if (editable.toString().length() > DJXReportFragment.this.mEtComplainDes.getMaxWidth()) {
                    DJXReportFragment.this.mTvReportDesLimit.setTextColor(DJXReportFragment.this.getContext().getResources().getColor(R.color.djx_report_btn_background_enabled));
                    DJXReportFragment.this.mTvReportDesLimit.setTextColor(DJXReportFragment.this.getContext().getResources().getColor(R.color.djx_report_btn_background_enabled));
                } else {
                    DJXReportFragment.this.mTvReportDesLimit.setTextColor(DJXReportFragment.this.getContext().getResources().getColor(R.color.djx_report_et_limit_text_color));
                    DJXReportFragment.this.mTvReportDesLimit.setTextColor(DJXReportFragment.this.getContext().getResources().getColor(R.color.djx_report_et_limit_text_color));
                }
            }
        });
        Button button = (Button) findById(R.id.djx_btn_report_commit);
        this.mBtnCommitReport = button;
        button.setEnabled(commitEnable());
        this.mBtnCommitReport.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.bureport.DJXReportFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DJXReportFragment.this.closeKeyBoard();
                if (NetworkUtils.isActive(DJXReportFragment.this.getContext())) {
                    if (DJXReportFragment.this.mReportModel != null) {
                        if (DJXReportFragment.this.mReportParams.mDramaDetail == null) {
                            DJXReportFragment.this.onReportResponse(false);
                            LG.e(DJXReportFragment.TAG, "dramaDetail is null, skip upload log");
                            return;
                        } else {
                            ReportLog.reportSkit(DJXReportFragment.this.mReportParams.mDramaDetail, DJXReportFragment.this.mReportModel, DJXReportFragment.this.mEtComplainDes.getText().toString());
                            DJXReportFragment.this.onReportResponse(true);
                            return;
                        }
                    }
                    ToastUtil.show(InnerManager.getContext(), DJXReportFragment.this.getMyActivity().getResources().getString(R.string.djx_report_item_select_tip));
                    return;
                }
                ToastUtil.show(InnerManager.getContext(), DJXReportFragment.this.getMyActivity().getResources().getString(R.string.djx_report_fail_tip));
            }
        });
    }

    private boolean commitEnable() {
        return this.mReportModel != null;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void processLogic() {
        if (this.mReportParams.mListener != null) {
            this.mReportParams.mListener.onOpen(this);
        }
    }

    public void closeKeyBoard() {
        ((InputMethodManager) getMyActivity().getSystemService("input_method")).hideSoftInputFromWindow(getMyActivity().getWindow().getDecorView().getRootView().getWindowToken(), 2);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onDetach() {
        super.onDetach();
        if (this.mReportParams.mListener != null) {
            this.mReportParams.mListener.onClose(this);
        }
    }

    public DJXReportFragment setReportParams(DJXReportParams dJXReportParams) {
        this.mReportParams = dJXReportParams;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReportResponse(boolean z) {
        LG.d(TAG, "onDJXReportResult isSucceed = " + z);
        DJXReportParams dJXReportParams = this.mReportParams;
        if (dJXReportParams == null || dJXReportParams.mListener == null) {
            return;
        }
        long groupId = 0;
        if (this.mReportParams.mDramaDetail != null) {
            groupId = this.mReportParams.mDramaDetail.getGroupId();
        } else if (this.mReportParams.mFeed != null) {
            groupId = this.mReportParams.mFeed.getGroupId();
        }
        HashMap map = new HashMap();
        map.put("group_id", Long.valueOf(groupId));
        LG.d(TAG, "onDJXReportResult isSucceed = " + z + ", map = " + map);
        DJXReportParams dJXReportParams2 = this.mReportParams;
        if (dJXReportParams2 == null || dJXReportParams2.mListener == null) {
            return;
        }
        this.mReportParams.mListener.onDJXReportResult(z, map);
    }
}
