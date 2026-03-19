package com.fendasz.moku.planet.entity;

import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.fendasz.moku.planet.utils.LogUtils;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuCellInfoCallback extends TelephonyManager.CellInfoCallback {
    private static final String TAG = "Moku_CellInfoCallback=>";
    private CellInfoCallBack callBack;

    public interface CellInfoCallBack {
        void cellError(int i, String str);

        void cellSuccess(int i, String str);
    }

    @Override // android.telephony.TelephonyManager.CellInfoCallback
    public void onCellInfo(List<CellInfo> list) {
        String jSONString = JSON.toJSONString(list);
        Log.d(TAG, "cellInfo=>" + jSONString);
        CellInfoCallBack cellInfoCallBack = this.callBack;
        if (cellInfoCallBack != null) {
            cellInfoCallBack.cellSuccess(1, jSONString);
        }
    }

    @Override // android.telephony.TelephonyManager.CellInfoCallback
    public void onError(int i, Throwable th) {
        super.onError(i, th);
        if (th == null) {
            th = new Exception("MokuCellInfoCallback error,unknow detais");
        }
        if (this.callBack != null) {
            LogUtils.logE(TAG, "requestCellInfoUpdate error,code=>" + i + ",message=>" + th.getMessage());
            this.callBack.cellError(0, th.getMessage());
        }
    }

    public CellInfoCallBack getCallBack() {
        return this.callBack;
    }

    public void setCallBack(CellInfoCallBack cellInfoCallBack) {
        this.callBack = cellInfoCallBack;
    }
}
