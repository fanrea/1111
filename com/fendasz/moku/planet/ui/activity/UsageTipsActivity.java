package com.fendasz.moku.planet.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class UsageTipsActivity extends Activity {
    private Context mContext;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.moku_activity_usage_tips);
        this.mContext = this;
        ((ImageButton) findViewById(R.id.image_button)).setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.UsageTipsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PermissionUtils.applyUsageStatsPermissions(UsageTipsActivity.this.mContext);
                UsageTipsActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.appNameTV)).setText(String.format("请找到 %s ，并打开权限", SystemUtils.getAppName(this.mContext)));
    }
}
