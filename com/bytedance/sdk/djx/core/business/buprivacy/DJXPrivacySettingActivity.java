package com.bytedance.sdk.djx.core.business.buprivacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.djx.IDJXRecSwitchCallback;
import com.bytedance.sdk.djx.core.act.BaseActivity;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import com.bytedance.sdk.djx.core.business.buprivacy.DJXPrivacyDialog;
import com.bytedance.sdk.djx.core.business.view.DJXSwitchButton;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.StatusBarUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXPrivacySettingActivity extends BaseActivity {
    public static final String CATEGORY = "category";
    private String mCategory;
    private DJXSwitchButton mPersonalizedRecSwitch;

    public static void go(String str) {
        Intent intent = new Intent(InnerManager.getContext(), (Class<?>) DJXPrivacySettingActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("category", str);
        InnerManager.getContext().startActivity(intent);
    }

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity
    protected void initWindow(Window window) {
        StatusBarUtil.setDarkMode(this);
        StatusBarUtil.setColor(this, -1);
    }

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_activity_privacy_setting);
    }

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initView();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mCategory = intent.getStringExtra("category");
        }
    }

    private void initView() {
        this.mPersonalizedRecSwitch = (DJXSwitchButton) findViewById(R.id.djx_switch_personalized_recommendation);
        this.mPersonalizedRecSwitch.setChecked(TokenHelper.getInstance().getRecommendSwitch());
        this.mPersonalizedRecSwitch.setShadowEffect(true);
        this.mPersonalizedRecSwitch.setOnCheckedChangeListener(new DJXSwitchButton.OnCheckedChangeListener() { // from class: com.bytedance.sdk.djx.core.business.buprivacy.DJXPrivacySettingActivity.1
            @Override // com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.OnCheckedChangeListener
            public void onCheckedChanged(DJXSwitchButton dJXSwitchButton, boolean z) {
                if (z) {
                    if (TokenHelper.getInstance().getRecommendSwitch()) {
                        BLogAgent.build(DJXPrivacySettingActivity.this.mCategory, ILogConst.E_CLICK_PRIVATE_BUTTON, null).putString("action_type", FeedReqParams.REQ_TYPE_OPEN).send();
                    }
                    LG.d("PersonalRec", "open personal rec");
                    DJXPrivacySettingActivity.this.changeRecommendSwitch(true);
                    return;
                }
                new DJXPrivacyDialog(DJXPrivacySettingActivity.this, new DJXPrivacyDialog.OnPrivacyDialogListener() { // from class: com.bytedance.sdk.djx.core.business.buprivacy.DJXPrivacySettingActivity.1.1
                    @Override // com.bytedance.sdk.djx.core.business.buprivacy.DJXPrivacyDialog.OnPrivacyDialogListener
                    public void settle() {
                        LG.d("PersonalRec", "close personal rec");
                        DJXPrivacySettingActivity.this.changeRecommendSwitch(false);
                        BLogAgent.build(DJXPrivacySettingActivity.this.mCategory, ILogConst.E_CLICK_PRIVATE_BUTTON, null).putString("action_type", "close").send();
                    }

                    @Override // com.bytedance.sdk.djx.core.business.buprivacy.DJXPrivacyDialog.OnPrivacyDialogListener
                    public void cancel() {
                        DJXPrivacySettingActivity.this.mPersonalizedRecSwitch.setChecked(true);
                    }
                }).show();
            }
        });
        findViewById(R.id.djx_close).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.buprivacy.DJXPrivacySettingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DJXPrivacySettingActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeRecommendSwitch(boolean z) {
        TokenHelper.getInstance().setRecommendSwitch(z, new IDJXRecSwitchCallback() { // from class: com.bytedance.sdk.djx.core.business.buprivacy.DJXPrivacySettingActivity.3
            @Override // com.bytedance.sdk.djx.IDJXRecSwitchCallback
            public void onResult(boolean z2, int i, String str) {
                if (z2) {
                    return;
                }
                ToastUtil.show(InnerManager.getContext(), DJXPrivacySettingActivity.this.getResources().getString(R.string.djx_str_no_network_tip));
            }
        });
    }
}
