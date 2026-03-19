package com.sigmob.sdk.videoAd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.czhj.sdk.common.ClientMetadata;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.LandscapeAdActivity;
import com.sigmob.sdk.base.common.LandscapeTransparentAdActivity;
import com.sigmob.sdk.base.common.PortraitAdActivity;
import com.sigmob.sdk.base.common.PortraitTransparentAdActivity;
import com.sigmob.sdk.base.common.TransparentAdActivity;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.n;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BaseAdActivity extends Activity {
    public static final String a = "LandPage";
    public static final String b = "reward";
    public static final String c = "mraid";
    public static final String d = "mraid_two";
    public static final String e = "LandNative";
    public static final String f = "DisLike";
    protected static final String g = "ad_view_class_name";
    protected static final String h = "adUnit_requestId_key";
    public static final String i = "land_page_url";
    public static final String j = "new_interstitial";

    private static Intent a(Context context, Class<? extends BaseAdActivity> cls, String broadcastIdentifier, String adCls) {
        Intent intentPutExtra = new Intent(context, cls).setFlags(268435456).putExtra(g, adCls).putExtra(h, broadcastIdentifier);
        int requestedOrientation = context instanceof Activity ? ((Activity) context).getRequestedOrientation() : 3;
        if (requestedOrientation != 7 && requestedOrientation != 6) {
            requestedOrientation = context.getResources().getDisplayMetrics().widthPixels > context.getResources().getDisplayMetrics().heightPixels ? 6 : 7;
        }
        intentPutExtra.putExtra(n.x, requestedOrientation);
        intentPutExtra.putExtra("broadcastIdentifier", broadcastIdentifier);
        return intentPutExtra;
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, BaseAdUnit adUnit) {
        try {
            context.startActivity(a(context, cls, adUnit.getUuid(), a));
        } catch (Throwable th) {
            new HashMap().put("error", th.getMessage());
        }
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, String broadcastIdentifier) {
        a(context, cls, broadcastIdentifier, null, a);
    }

    public static void a(Context context, Class<? extends BaseAdActivity> cls, String broadcastIdentifier, Bundle bundle, String adClass) {
        try {
            int display_orientation = com.sigmob.sdk.base.common.g.c(broadcastIdentifier).getDisplay_orientation();
            if (display_orientation == 0) {
                display_orientation = ClientMetadata.getInstance().getOrientationInt().intValue();
            }
            Intent intentA = a(context, cls == TransparentAdActivity.class ? display_orientation != 1 ? display_orientation != 2 ? TransparentAdActivity.class : LandscapeTransparentAdActivity.class : PortraitTransparentAdActivity.class : display_orientation != 1 ? display_orientation != 2 ? AdActivity.class : LandscapeAdActivity.class : PortraitAdActivity.class, broadcastIdentifier, adClass);
            if (bundle != null) {
                intentA.putExtras(bundle);
            }
            context.startActivity(intentA);
        } catch (Throwable th) {
            HashMap map = new HashMap();
            map.put("error", th.getMessage());
            BaseBroadcastReceiver.a(context, broadcastIdentifier, map, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
        }
    }

    public static void b(Context context, Class<? extends BaseAdActivity> cls, String broadcastIdentifier) {
        try {
            Intent intentPutExtra = new Intent(context, cls).setFlags(268435456).putExtra(g, f).putExtra(h, broadcastIdentifier);
            intentPutExtra.putExtra("broadcastIdentifier", "dislike_broadcastIdentifier");
            context.startActivity(intentPutExtra);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
