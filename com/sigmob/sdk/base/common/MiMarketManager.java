package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.MiMarketManager;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MiMarketManager {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;

    public static class DirectMailStatusReceiver extends BroadcastReceiver {
        private static final String a = "com.xiaomi.market.DIRECT_MAIL_CHECK_RESULT";
        private static final String b = "com.xiaomi.market.DIRECT_MAIL_STATUS";
        private static final String c = "com.xiaomi.market.DIRECT_MAIL_DOWNLOAD_PROGRESS";
        private BaseAdUnit d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("packageName", str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("packageName", str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("packageName", str);
            }
        }

        public void a(Context context, BaseAdUnit adUnit) {
            if (context == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.xiaomi.market.DIRECT_MAIL_CHECK_RESULT");
            intentFilter.addAction("com.xiaomi.market.DIRECT_MAIL_STATUS");
            intentFilter.addAction(c);
            this.d = adUnit;
            t.a(context, this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            final String string;
            StringBuilder sb;
            String str;
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if (TextUtils.isEmpty(action) || extras == null) {
                return;
            }
            action.hashCode();
            switch (action) {
                case "com.xiaomi.market.DIRECT_MAIL_STATUS":
                    int i2 = extras.getInt("statusCode");
                    final String string2 = extras.getString("packageName");
                    SigmobLog.d("MiMarketManager: statusCode:" + i2 + " packageName:" + string2);
                    ac.a("mimarket_status", String.valueOf(i2), this.d, new ac.a() { // from class: com.sigmob.sdk.base.common.MiMarketManager$DirectMailStatusReceiver$$ExternalSyntheticLambda1
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj) {
                            MiMarketManager.DirectMailStatusReceiver.b(string2, obj);
                        }
                    });
                    return;
                case "com.xiaomi.market.DIRECT_MAIL_DOWNLOAD_PROGRESS":
                    i = extras.getInt("downloadProgress");
                    string = extras.getString("packageName");
                    ac.a("mimarket_download_progress", String.valueOf(i), this.d, new ac.a() { // from class: com.sigmob.sdk.base.common.MiMarketManager$DirectMailStatusReceiver$$ExternalSyntheticLambda2
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj) {
                            MiMarketManager.DirectMailStatusReceiver.a(string, obj);
                        }
                    });
                    sb = new StringBuilder();
                    str = "MiMarketManager: downloadProgress:";
                    break;
                case "com.xiaomi.market.DIRECT_MAIL_CHECK_RESULT":
                    i = extras.getInt("styleCheckResult");
                    string = extras.getString("packageName");
                    ac.a("mimarket_check_result", i == 0 ? "1" : "0", this.d, new ac.a() { // from class: com.sigmob.sdk.base.common.MiMarketManager$DirectMailStatusReceiver$$ExternalSyntheticLambda0
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj) {
                            MiMarketManager.DirectMailStatusReceiver.c(string, obj);
                        }
                    });
                    sb = new StringBuilder();
                    str = "MiMarketManager: styleResult:";
                    break;
                default:
                    return;
            }
            SigmobLog.d(sb.append(str).append(i).append(" packageName:").append(string).toString());
        }
    }

    public static void a(Context context, ArrayList<String> packageList) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider/referrer"), null, null, null, null);
        while (cursorQuery != null) {
            try {
                if (!cursorQuery.moveToFirst()) {
                    break;
                }
                cursorQuery.getString(0);
                cursorQuery.getString(1);
                cursorQuery.getString(2);
                cursorQuery.getString(3);
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    public static void b(Context context, ArrayList<String> packageList) {
        ArrayList parcelableArrayList;
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("packageNames", packageList);
        Bundle bundleCall = context.getContentResolver().call(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider/status"), "queryDownloadStatus", (String) null, bundle);
        if (bundleCall == null || (parcelableArrayList = bundleCall.getParcelableArrayList("packageNames")) == null || parcelableArrayList.isEmpty()) {
            return;
        }
        for (Object obj : parcelableArrayList) {
            if (obj != null && (obj instanceof Bundle)) {
                Bundle bundle2 = (Bundle) obj;
                SigmobLog.d("packageName = " + bundle2.getString("packageName") + ", status = " + bundle2.getInt("status") + ", progress = " + bundle2.getInt("progress"));
            }
        }
    }
}
