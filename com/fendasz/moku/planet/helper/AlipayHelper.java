package com.fendasz.moku.planet.helper;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AlipayHelper {
    private static String TAG = "AlipayHelper";
    private static AlipayHelper alipayHelper;

    private AlipayHelper() {
    }

    public static AlipayHelper getInstance() {
        AlipayHelper alipayHelper2;
        synchronized (AlipayHelper.class) {
            if (alipayHelper == null) {
                alipayHelper = new AlipayHelper();
            }
            alipayHelper2 = alipayHelper;
        }
        return alipayHelper2;
    }

    public void atformapiartapp(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            if (e instanceof ActivityNotFoundException) {
                Toast.makeText(context, "请先安装支付宝", 0).show();
            } else {
                Log.e(TAG, "start alipay error");
            }
        }
    }
}
