package com.sigmob.sdk.nativead;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.network.e;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.WindNativeAdData;
import com.sigmob.windad.natives.WindNativeAdRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class w implements e.a {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    private List<BaseAdUnit> h;
    private y i;
    private final WindNativeAdRequest j;
    private boolean k;
    private final Handler g = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.nativead.w.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 20481 && w.this.k) {
                w.this.g.removeMessages(20481);
                w.this.a((List<WindNativeAdData>) null, WindAdError.ERROR_SIGMOB_AD_TIME_OUT.getErrorCode(), WindAdError.ERROR_SIGMOB_AD_TIME_OUT.getMessage());
            }
        }
    };
    private final int l = 20481;

    public w(WindNativeAdRequest adRequest, y sigmobNativeAdLoadListener) {
        this.j = adRequest;
        this.i = sigmobNativeAdLoadListener;
    }

    private WindNativeAdData a(BaseAdUnit adUnit) {
        return new ae(adUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, List list, String str) {
        y yVar = this.i;
        if (yVar == null) {
            return;
        }
        if (i == 0) {
            yVar.onNativeAdLoaded(list);
        } else {
            yVar.onNativeAdLoadFail(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<WindNativeAdData> adUnits, final int error, final String message) {
        this.k = false;
        this.g.removeMessages(20481);
        this.g.post(new Runnable() { // from class: com.sigmob.sdk.nativead.w$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(error, adUnits, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(List list, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map options = pointEntitySigmob.getOptions();
            options.put(PointParamKey.AD_COUNT, String.valueOf(list.size()));
            pointEntitySigmob.setOptions(options);
        }
    }

    public int a(int adCount, String bidToken, int bidFloor, String currency, String traceId) {
        int errorCode;
        WindAdError windAdError;
        int i = 1;
        this.k = true;
        com.sigmob.sdk.base.common.x xVarA = com.sigmob.sdk.base.common.x.a(this.j.getPlacementId());
        LoadAdRequest loadAdRequest = new LoadAdRequest(this.j);
        loadAdRequest.setBidToken(bidToken);
        loadAdRequest.setBidFloor(bidFloor);
        loadAdRequest.setCurrency(currency);
        loadAdRequest.setAd_count(adCount);
        loadAdRequest.setTraceId(traceId);
        xVarA.a++;
        com.sigmob.sdk.base.common.y yVarA = com.sigmob.sdk.base.common.y.a(this.j.getPlacementId());
        yVarA.a++;
        if (adCount < 1) {
            errorCode = WindAdError.ERROR_SIGMOB_NATIVE_ADCOUNT.getErrorCode();
            windAdError = WindAdError.ERROR_SIGMOB_NATIVE_ADCOUNT;
        } else {
            if (xVarA.g <= 0 || xVarA.g + (xVarA.d * 1000) <= System.currentTimeMillis()) {
                this.g.sendEmptyMessageDelayed(20481, com.sigmob.sdk.base.o.a().C());
                xVarA.g = System.currentTimeMillis();
                com.sigmob.sdk.base.network.e.a(loadAdRequest, this);
                com.sigmob.sdk.base.common.x.a(this.j.getPlacementId(), xVarA);
                com.sigmob.sdk.base.common.y.a(this.j.getPlacementId(), yVarA);
                return i;
            }
            List<BaseAdUnit> listA = com.sigmob.sdk.base.common.g.a(this.j.getPlacementId(), xVarA.f, adCount);
            if (!listA.isEmpty()) {
                this.h = listA;
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < listA.size(); i2++) {
                    BaseAdUnit baseAdUnit = listA.get(i2);
                    baseAdUnit.setLoad_id(loadAdRequest.getLoadId());
                    arrayList.add(a(baseAdUnit));
                    if (com.sigmob.sdk.manager.b.m(baseAdUnit)) {
                        com.sigmob.sdk.base.common.g.g().f(baseAdUnit);
                    }
                }
                a(this.h.get(0), loadAdRequest);
                xVarA.b += listA.size();
                yVarA.b += listA.size();
                a(arrayList, 0, (String) null);
                i = 0;
                com.sigmob.sdk.base.common.x.a(this.j.getPlacementId(), xVarA);
                com.sigmob.sdk.base.common.y.a(this.j.getPlacementId(), yVarA);
                return i;
            }
            errorCode = WindAdError.ERROR_NO_AD.getErrorCode();
            windAdError = WindAdError.ERROR_NO_AD;
        }
        a((List<WindNativeAdData>) null, errorCode, windAdError.getMessage());
        i = 0;
        com.sigmob.sdk.base.common.x.a(this.j.getPlacementId(), xVarA);
        com.sigmob.sdk.base.common.y.a(this.j.getPlacementId(), yVarA);
        return i;
    }

    public String a() {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.h;
        if (list == null || list.isEmpty() || (baseAdUnit = this.h.get(0)) == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        return String.valueOf(baseAdUnit.bidding_response.ecpm);
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(int error, String message, String request_id, LoadAdRequest loadAdRequest) {
        com.sigmob.sdk.base.common.ac.a(PointCategory.RESPOND, "0", loadAdRequest);
        a((List<WindNativeAdData>) null, error, message);
    }

    public void a(BaseAdUnit adUnit, LoadAdRequest adRequest) {
        com.sigmob.sdk.base.common.ac.a(PointCategory.READY, (String) null, adUnit, adRequest, (ac.a) null);
    }

    public void a(String key, String value) {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.h;
        if (list == null || (baseAdUnit = list.get(0)) == null || baseAdUnit.bidding_response == null) {
            return;
        }
        baseAdUnit.getMacroCommon().addMarcoKey(key, value);
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(final List<BaseAdUnit> baseAdUnitList, LoadAdRequest loadAdRequest) {
        if (com.sigmob.sdk.base.utils.e.a(baseAdUnitList)) {
            a((List<WindNativeAdData>) null, WindAdError.ERROR_NO_AD.getErrorCode(), WindAdError.ERROR_NO_AD.getMessage());
            return;
        }
        com.sigmob.sdk.base.common.ac.a(PointCategory.RESPOND, "1", baseAdUnitList.get(0), loadAdRequest, new ac.a() { // from class: com.sigmob.sdk.nativead.w$$ExternalSyntheticLambda1
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                w.a(baseAdUnitList, obj);
            }
        });
        com.sigmob.sdk.base.common.x xVarA = com.sigmob.sdk.base.common.x.a(this.j.getPlacementId());
        if (xVarA != null && xVarA.e > 0) {
            baseAdUnitList = com.sigmob.sdk.base.common.g.a(this.j.getPlacementId(), xVarA.f, this.j.getAdCount());
            if (com.sigmob.sdk.base.utils.e.a(baseAdUnitList)) {
                this.h = null;
                a((List<WindNativeAdData>) null, WindAdError.ERROR_NO_AD.getErrorCode(), WindAdError.ERROR_NO_AD.getMessage());
                return;
            }
        }
        this.h = baseAdUnitList;
        com.sigmob.sdk.base.common.y yVarA = com.sigmob.sdk.base.common.y.a(this.j.getPlacementId());
        xVarA.b += this.h.size();
        yVarA.b += this.h.size();
        com.sigmob.sdk.base.common.x.a(this.j.getPlacementId(), xVarA);
        com.sigmob.sdk.base.common.y.a(this.j.getPlacementId(), yVarA);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.h.size(); i++) {
            BaseAdUnit baseAdUnit = this.h.get(i);
            arrayList.add(a(baseAdUnit));
            if (com.sigmob.sdk.manager.b.m(baseAdUnit)) {
                com.sigmob.sdk.base.common.g.g().f(baseAdUnit);
            }
        }
        a(this.h.get(0), loadAdRequest);
        a(arrayList, 0, (String) null);
    }

    public Map<String, BiddingResponse> b() {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.h;
        if (list == null || (baseAdUnit = list.get(0)) == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put(baseAdUnit.getRequestId(), baseAdUnit.bidding_response);
        return map;
    }
}
