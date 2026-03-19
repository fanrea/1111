package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.mb;
import com.qq.e.comm.plugin.op;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.uk;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ANNativeUnifiedAdAdapter extends BaseNativeUnifiedAd implements op, uk {
    private List<NativeUnifiedADData> data;
    private f delegate;
    private ADListener listener;

    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            List list;
            if (aDEvent == null) {
                return;
            }
            if (aDEvent.getType() == 100 && (list = (List) aDEvent.getParam(List.class)) != null) {
                ANNativeUnifiedAdAdapter.this.data = list;
            }
            ANNativeUnifiedAdAdapter.this.listener.onADEvent(aDEvent);
        }
    }

    public ANNativeUnifiedAdAdapter(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
        this.delegate = new f(context, r1.d().b().a(), str2, mb.UNION_ADAPTER, "", new a());
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public int getAdapterPriority() {
        return this.delegate.f();
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionFailureUrls() {
        return this.delegate.a();
    }

    @Override // com.qq.e.comm.plugin.uk
    public String[] getCompetitionWinUrls() {
        return this.delegate.c();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public int getECPM() {
        List<NativeUnifiedADData> list = this.data;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        return this.data.get(0).getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public Map<String, Object> getExtraInfo() {
        List<NativeUnifiedADData> list = this.data;
        return (list == null || list.isEmpty()) ? new HashMap() : this.data.get(0).getExtraInfo();
    }

    @Override // com.qq.e.comm.plugin.op
    public int getMediationPrice() {
        return this.delegate.d();
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public String getReqId() {
        Object obj;
        List<NativeUnifiedADData> list = this.data;
        if (list == null || list.isEmpty() || (obj = this.data.get(0).getExtraInfo().get("request_id")) == null) {
            return null;
        }
        return obj.toString();
    }

    public boolean isContractAd() {
        return false;
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void loadData(int i) {
        this.data = null;
        this.delegate.loadData(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setAdListener(ADListener aDListener) {
        this.listener = aDListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setCategories(List<String> list) {
        this.delegate.setCategories(list);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setECPMLevel(String str) {
        List<NativeUnifiedADData> list = this.data;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<NativeUnifiedADData> it = this.data.iterator();
        while (it.hasNext()) {
            ((e) it.next()).a(str);
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setMaxVideoDuration(int i) {
        this.delegate.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.comm.plugin.op
    public void setMediationId(String str) {
        this.delegate.a(str);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setMinVideoDuration(int i) {
        this.delegate.setMinVideoDuration(i);
    }
}
