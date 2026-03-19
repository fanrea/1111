package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.czhj.sdk.common.utils.Preconditions;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class BaseBroadcastReceiver extends BroadcastReceiver {
    private String a;

    public BaseBroadcastReceiver(String broadcastIdentifier) {
        this.a = broadcastIdentifier;
    }

    public static void a(Context context, String broadcastIdentifier, String action) {
        a(context, broadcastIdentifier, null, action, 0);
    }

    public static void a(Context context, String broadcastIdentifier, String action, int delay) {
        a(context, broadcastIdentifier, null, action, delay);
    }

    public static void a(Context context, String broadcastIdentifier, Map<String, Object> extras, String action) {
        a(context, broadcastIdentifier, extras, action, 0);
    }

    public static void a(Context context, String broadcastIdentifier, Map<String, Object> extras, String action, int delay) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(action);
        Intent intent = new Intent(action);
        intent.putExtra("broadcastIdentifier", broadcastIdentifier);
        if (extras != null) {
            for (String str : extras.keySet()) {
                try {
                    Object obj = extras.get(str);
                    if (obj instanceof Number) {
                        intent.putExtra(str, (Number) obj);
                    } else {
                        intent.putExtra(str, (String) obj);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        ah ahVarA = ah.a(context);
        if (ahVarA != null) {
            try {
                ahVarA.a(intent, delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract IntentFilter a();

    public void a(BroadcastReceiver broadcastReceiver) {
        ah ahVarA = ah.a(com.sigmob.sdk.b.e());
        if (ahVarA != null) {
            try {
                ahVarA.a(broadcastReceiver, a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean a(Intent intent) {
        Preconditions.NoThrow.checkNotNull(intent);
        String stringExtra = intent.getStringExtra("broadcastIdentifier");
        return !TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(this.a);
    }

    public void b(BroadcastReceiver broadcastReceiver) {
        ah ahVarA;
        if (broadcastReceiver == null || (ahVarA = ah.a(com.sigmob.sdk.b.e())) == null) {
            return;
        }
        try {
            ahVarA.a(broadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
