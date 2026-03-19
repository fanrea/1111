package com.baidu.mobads.container.util;

import android.telephony.CellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class al extends com.baidu.mobads.container.d.a<Object> {
    final /* synthetic */ CellLocation a;
    final /* synthetic */ DeviceUtils b;

    al(DeviceUtils deviceUtils, CellLocation cellLocation) {
        this.b = deviceUtils;
        this.a = cellLocation;
    }

    @Override // com.baidu.mobads.container.d.a
    public Object a() {
        try {
            if (this.a == null) {
                this.b.e = "null_null_null";
            } else {
                String[] strArr = new String[3];
                if (this.a instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) this.a;
                    strArr[0] = gsmCellLocation.getCid() + "";
                    strArr[1] = gsmCellLocation.getLac() + "";
                    strArr[2] = "0";
                } else {
                    String[] strArrSplit = this.a.toString().replace("[", "").replace("]", "").split(",");
                    if (strArrSplit.length > 4) {
                        strArr[0] = strArrSplit[0];
                        strArr[1] = strArrSplit[3];
                        strArr[2] = strArrSplit[4];
                    }
                }
                this.b.e = TextUtils.join(Config.replace, strArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.b.e = "null_null_null";
        }
        return this.b.e;
    }
}
