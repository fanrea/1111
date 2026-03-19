package com.fendasz.moku.planet.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.source.bean.ClientTaskDataRecord;
import com.fendasz.moku.planet.source.bean.Data;
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.ui.dialog.ViewImageDialog;
import com.fendasz.moku.planet.utils.ImageUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AuditActivity extends BaseBackActivity {
    private static final String TAG = "AuditActivity";
    private Context mContext;
    private LinearLayout mLlAudit;
    private LinearLayout mLlRoot;
    private PhoneScreenUtils mPhoneScreenUtils;
    private Integer mStatus;
    private int mSubmitRecordId;

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_activity_audit, viewGroup, false);
        this.mLlRoot = linearLayout;
        return linearLayout;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        String str;
        if (this.mStatus.equals(MokuConstants.TASK_RECORD_UNDER_REVIEW)) {
            str = "审核中";
        } else {
            str = this.mStatus.equals(MokuConstants.TASK_RECORD_FAIL) ? "审核失败" : "";
        }
        if (textView != null) {
            textView.setText(str);
            textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 70.0f)));
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() {
        initLoad();
        initStaticView();
        onReady();
    }

    private void initStaticView() {
        this.mLlAudit = (LinearLayout) this.mLlRoot.findViewById(R.id.ll_audit);
    }

    private void onReady() {
        LoadingDialog.show(this.mContext);
        ApiDataHelper.getApiDataHelper().getTaskRecordDetail(this.mContext, Integer.valueOf(this.mSubmitRecordId), new ApiDataCallBack<ClientTaskDataRecord>() { // from class: com.fendasz.moku.planet.ui.activity.AuditActivity.1
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, ClientTaskDataRecord clientTaskDataRecord) throws Exception {
                LoadingDialog.dismiss();
                AuditActivity.this.setItemTextView("任务名称：", clientTaskDataRecord.getShowName());
                if (AuditActivity.this.mStatus.equals(MokuConstants.TASK_RECORD_UNDER_REVIEW)) {
                    AuditActivity.this.setItemTextView("预计审核时间：", clientTaskDataRecord.getShowExpectedAuditingTime());
                } else if (AuditActivity.this.mStatus.equals(MokuConstants.TASK_RECORD_FAIL)) {
                    AuditActivity.this.setItemTextView("失败原因：", clientTaskDataRecord.getTaskDataReviewFailureReason());
                }
                if (clientTaskDataRecord.getTaskDataSubmitFormList() != null) {
                    for (int i2 = 0; i2 < clientTaskDataRecord.getTaskDataSubmitFormList().size(); i2++) {
                        Data data = clientTaskDataRecord.getTaskDataSubmitFormList().get(i2);
                        AuditActivity.this.setItemTextView(data.getKey() + "：", data.getValue());
                    }
                }
                if (clientTaskDataRecord.getTaskDataSubmitPicList() == null || clientTaskDataRecord.getTaskDataExamplePicList() == null) {
                    return;
                }
                for (int i3 = 0; i3 < clientTaskDataRecord.getTaskDataSubmitPicList().size(); i3++) {
                    Data data2 = clientTaskDataRecord.getTaskDataSubmitPicList().get(i3);
                    String str = clientTaskDataRecord.getTaskDataExamplePicList().get(i3);
                    if (data2 != null && !TextUtils.isEmpty(data2.getKey().trim()) && !TextUtils.isEmpty(str.trim())) {
                        AuditActivity.this.setItemImageView(data2.getKey(), str);
                    }
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                LogUtils.log(AuditActivity.TAG, "code:" + i + " message:" + str);
                Toast.makeText(AuditActivity.this.mContext, str, 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemTextView(String str, String str2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_form_audit, (ViewGroup) this.mLlAudit, false);
        this.mLlAudit.addView(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.tv_key);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.tv_value);
        textView.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
        textView.setText(str);
        textView.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
        textView2.setTextColor(this.mContext.getResources().getColor(R.color.moku_gray_deep));
        textView2.setText(str2);
        textView2.setTextSize(this.mPhoneScreenUtils.getNormalTextSize(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemImageView(String str, String str2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_screenshot_audit, (ViewGroup) this.mLlAudit, false);
        this.mLlAudit.addView(linearLayout);
        setImageView(str, (ImageView) linearLayout.findViewById(R.id.iv_upload_image));
        setImageView(str2, (ImageView) linearLayout.findViewById(R.id.iv_sample));
    }

    private void setImageView(String str, final ImageView imageView) {
        ImageUtils.getInstance().setImageView(this.mContext, str, new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.ui.activity.AuditActivity.2
            @Override // com.fendasz.moku.planet.interf.functions.Consumer
            public void accept(final Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.AuditActivity.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new ViewImageDialog.Builder(AuditActivity.this.mContext).setBitmap(bitmap).create().show();
                    }
                });
            }
        }, null, null);
    }

    private void initLoad() {
        this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
    }

    private void showErrorDialog(String str) {
        new CustomBuildDialog.DialogBuilder(this.mContext).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText(str).setRightBtn(getString(R.string.moku_btn_ok), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.AuditActivity$$ExternalSyntheticLambda0
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public final void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                this.f$0.m404x43266889(textView, customBuildDialog);
            }
        }).setCancelable(false).create().show();
    }

    /* renamed from: lambda$showErrorDialog$0$com-fendasz-moku-planet-ui-activity-AuditActivity, reason: not valid java name */
    /* synthetic */ void m404x43266889(TextView textView, CustomBuildDialog customBuildDialog) {
        customBuildDialog.dismiss();
        finish();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        this.mContext = this;
        if (bundle == null) {
            Intent intent = getIntent();
            this.mStatus = Integer.valueOf(intent.getIntExtra("status", MokuConstants.TASK_RECORD_UNDER_REVIEW.intValue()));
            this.mSubmitRecordId = intent.getIntExtra("submitRecordId", -1);
        } else {
            this.mStatus = Integer.valueOf(bundle.getInt("status", MokuConstants.TASK_RECORD_UNDER_REVIEW.intValue()));
            this.mSubmitRecordId = bundle.getInt("submitRecordId", -1);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("status", this.mStatus.intValue());
        bundle.putInt("submitRecordId", this.mSubmitRecordId);
    }
}
