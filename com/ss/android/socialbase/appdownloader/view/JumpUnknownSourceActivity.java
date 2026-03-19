package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.b.c;
import com.ss.android.socialbase.appdownloader.b.mq;
import com.ss.android.socialbase.appdownloader.b.uo;
import com.ss.android.socialbase.appdownloader.gb;
import com.ss.android.socialbase.appdownloader.hc;
import com.ss.android.socialbase.appdownloader.tt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class JumpUnknownSourceActivity extends Activity {
    private Intent b;
    private int c;
    private mq d;
    private Intent hc;
    private JSONObject u;

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        gb.d().d(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
        gb.d().d(this);
    }

    private void d() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.hc = intent;
        if (intent != null) {
            this.b = (Intent) intent.getParcelableExtra("intent");
            this.c = intent.getIntExtra("id", -1);
            try {
                this.u = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        if (this.u == null) {
            b.d((Activity) this);
            return;
        }
        hc();
        mq mqVar = this.d;
        if (mqVar != null && !mqVar.hc()) {
            this.d.d();
        } else if (this.d == null) {
            finish();
        }
    }

    private void hc() {
        if (this.d != null || this.hc == null) {
            return;
        }
        try {
            c cVarHc = com.ss.android.socialbase.appdownloader.c.mk().hc();
            uo uoVarD = cVarHc != null ? cVarHc.d(this) : null;
            if (uoVarD == null) {
                uoVarD = new com.ss.android.socialbase.appdownloader.c.d(this);
            }
            int iD = tt.d(this, "tt_appdownloader_tip");
            int iD2 = tt.d(this, "tt_appdownloader_label_ok");
            int iD3 = tt.d(this, "tt_appdownloader_label_cancel");
            String strOptString = this.u.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = getString(tt.d(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            uoVarD.d(iD).d(strOptString).d(iD2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) throws JSONException {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (hc.d(jumpUnknownSourceActivity, jumpUnknownSourceActivity.b, JumpUnknownSourceActivity.this.c, JumpUnknownSourceActivity.this.u)) {
                        hc.b(JumpUnknownSourceActivity.this.c, JumpUnknownSourceActivity.this.u);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        hc.d((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.b, true);
                    }
                    hc.d(JumpUnknownSourceActivity.this.c, JumpUnknownSourceActivity.this.u);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).hc(iD3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) throws JSONException {
                    if (JumpUnknownSourceActivity.this.b != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        hc.d((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.b, true);
                    }
                    hc.hc(JumpUnknownSourceActivity.this.c, JumpUnknownSourceActivity.this.u);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).d(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) throws JSONException {
                    if (JumpUnknownSourceActivity.this.b != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        hc.d((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.b, true);
                    }
                    hc.hc(JumpUnknownSourceActivity.this.c, JumpUnknownSourceActivity.this.u);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).d(false);
            this.d = uoVarD.d();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }
}
