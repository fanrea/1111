package com.bytedance.sdk.djx.core.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.djx.core.business.base.FragProxy;
import com.bytedance.sdk.djx.core.business.bureport.DJXReportFragment;
import com.bytedance.sdk.djx.core.business.bureport.DJXReportParams;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXReportActivity extends BaseActivity {
    private static DJXReportParams sReportParams;

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity
    protected void initWindow(Window window) {
    }

    public static void go(DJXReportParams dJXReportParams) {
        Intent intent = new Intent(InnerManager.getContext(), (Class<?>) DJXReportActivity.class);
        intent.addFlags(268435456);
        InnerManager.getContext().startActivity(intent);
        sReportParams = dJXReportParams;
    }

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_activity_report);
    }

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    private void init() {
        findViewById(R.id.djx_close).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.act.DJXReportActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DJXReportActivity.this.finish();
            }
        });
        if (sReportParams == null) {
            sReportParams = DJXReportParams.obtain();
        }
        sReportParams.mReportTopPadding = 0.0f;
        getSupportFragmentManager().beginTransaction().replace(R.id.djx_container, DJXReportFragment.build(true).setReportParams(DJXReportParams.obtain(sReportParams).reportListener(new DJXReportParams.IDJXReportCallback() { // from class: com.bytedance.sdk.djx.core.act.DJXReportActivity.2
            @Override // com.bytedance.sdk.djx.core.business.bureport.DJXReportParams.IDJXReportCallback
            public void onDJXReportResult(boolean z, Map<String, Object> map) {
                if (DJXReportActivity.sReportParams.mListener != null) {
                    DJXReportActivity.sReportParams.mListener.onDJXReportResult(z, map);
                }
                DJXReportActivity.this.finish();
            }

            @Override // com.bytedance.sdk.djx.core.business.bureport.DJXReportParams.IDJXReportCallback
            public void onOpen(FragProxy fragProxy) {
                if (DJXReportActivity.sReportParams.mListener != null) {
                    DJXReportActivity.sReportParams.mListener.onOpen(fragProxy);
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.bureport.DJXReportParams.IDJXReportCallback
            public void onClose(FragProxy fragProxy) {
                if (DJXReportActivity.sReportParams.mListener != null) {
                    DJXReportActivity.sReportParams.mListener.onClose(fragProxy);
                }
            }
        })).getFragment()).commitAllowingStateLoss();
    }
}
