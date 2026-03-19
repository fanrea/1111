package com.bytedance.msdk.api.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.msdk.core.hc;
import com.bytedance.msdk.core.mq.an;
import com.bytedance.msdk.core.mq.u;
import com.bytedance.msdk.d.u.b;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class TTDelegateActivity extends Activity {
    private Intent d;

    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
        this.d = getIntent();
        if (hc.getContext() == null) {
            hc.d(this);
        }
    }

    private void d() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (hc.getContext() == null) {
            hc.d(this);
        }
        try {
            setIntent(intent);
            this.d = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            hc();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void hc() {
        try {
            int intExtra = this.d.getIntExtra("type", 0);
            if (intExtra == 1) {
                d(intExtra, this.d.getIntArrayExtra("permissions"));
                return;
            }
            if (intExtra == 2) {
                d(this.d.getStringExtra("permission_id_key"), this.d.getStringArrayExtra("permission_content_key"));
            } else if (intExtra == 3) {
                d(intExtra, (int[]) null);
            } else {
                finish();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    private void d(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                u.d().d(this, strArr, new an() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.1
                    @Override // com.bytedance.msdk.core.mq.an
                    public void d() {
                        com.bytedance.msdk.core.mq.d.d(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.msdk.core.mq.an
                    public void d(String str2) {
                        com.bytedance.msdk.core.mq.d.d(str, str2);
                        TTDelegateActivity.this.finish();
                    }
                });
            } catch (Exception unused) {
                finish();
            }
        } else {
            b.d("TTMediationSDK", "已经有权限");
            finish();
        }
    }

    private void d(int i, int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ArrayList arrayList = new ArrayList();
                if (i != 1) {
                    if (i == 3) {
                        arrayList.add(g.h);
                        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                        arrayList.add("android.permission.READ_PHONE_STATE");
                        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                } else if (iArr != null && iArr.length > 0) {
                    for (int i2 : iArr) {
                        if (i2 == 1) {
                            arrayList.add(g.h);
                            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                        } else if (i2 == 2) {
                            arrayList.add("android.permission.READ_PHONE_STATE");
                        } else if (i2 == 3) {
                            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                        }
                    }
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                u.d().d(this, strArr, new an() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.2
                    @Override // com.bytedance.msdk.core.mq.an
                    public void d() {
                        b.d("TMe", "-------=----- onGranted");
                        com.bytedance.msdk.d.u.an.c(new d());
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.msdk.core.mq.an
                    public void d(String str) {
                        b.d("TMe", "-------=----- onDenied: ".concat(String.valueOf(str)));
                        "android.permission.READ_PHONE_STATE".equals(str);
                        com.bytedance.msdk.d.u.an.c(new d());
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
                finish();
                return;
            }
        }
        b.d("TTMediationSDK", "已经有Read phone state权限");
        finish();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        u.d().d(this, strArr, iArr);
        com.bytedance.msdk.d.u.an.c(new d());
        finish();
    }
}
