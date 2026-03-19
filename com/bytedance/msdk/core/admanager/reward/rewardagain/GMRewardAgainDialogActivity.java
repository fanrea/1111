package com.bytedance.msdk.core.admanager.reward.rewardagain;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class GMRewardAgainDialogActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(jh.h(this, "reward_again_dialog"));
        ImageView imageView = (ImageView) findViewById(jh.an(this, "ra_pic"));
        TextView textView = (TextView) findViewById(jh.an(this, "ra_title"));
        TextView textView2 = (TextView) findViewById(jh.an(this, "ra_btn_ok"));
        TextView textView3 = (TextView) findViewById(jh.an(this, "ra_btn_cancel"));
        hc hcVar = b.b().d;
        if (hcVar != null) {
            textView.setText(hcVar.hc());
            textView2.setText(hcVar.c());
            textView3.setText(hcVar.u());
            if (!TextUtils.isEmpty(hcVar.b())) {
                new com.bytedance.msdk.d.u.hc(imageView).d((Object[]) new String[]{hcVar.b()});
            }
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GMRewardAgainDialogActivity.this.finish();
                Runnable runnable = b.b().hc;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GMRewardAgainDialogActivity.this.finish();
                Runnable runnable = b.b().b;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
