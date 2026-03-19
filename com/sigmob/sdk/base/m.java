package com.sigmob.sdk.base;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.x;
import com.sigmob.sdk.base.db.a;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.WindAdMetaData;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobRequest;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class m {
    private static final HashMap<String, h> b = new HashMap<>();
    private h a;
    private boolean d;
    private String e;
    private int g;
    protected WindAdRequest h;
    public AdStatus mADStatus = AdStatus.AdStatusNone;
    public int pIdEmpty_filters = 0;
    public int init_filters = 0;
    public int loadCount = 0;
    private int c = 0;
    private int f = 0;
    private String i = WindAds.CNY;

    protected m(WindAdRequest windAdRequest, boolean isHalfInterstitial) {
        this.h = windAdRequest;
        windAdRequest.setHalfInterstitial(isHalfInterstitial);
    }

    private h a(String placement) {
        h hVar = new h();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = com.sigmob.sdk.base.db.a.a().getReadableDatabase().rawQuery("select error_code, count(*) as num from adload_event where adslot_id = '" + placement + "' group by adslot_id", null);
            a(hVar, cursorRawQuery);
        } catch (Throwable th) {
            try {
                SigmobLog.e(th.getMessage());
            } finally {
                if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
                    cursorRawQuery.close();
                }
            }
        }
        if (cursorRawQuery != null && !cursorRawQuery.isClosed()) {
        }
        return hVar;
    }

    private void a() {
        this.pIdEmpty_filters = 0;
        b(d());
        this.a.a();
    }

    private void a(h loadFilterItem, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("error_code"));
        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("num"));
        do {
            if (i != 0) {
                loadFilterItem.a = i2;
            }
            loadFilterItem.b += i2;
            switch (i) {
                case 600200:
                case 600201:
                case 600203:
                case 600204:
                    loadFilterItem.g = i2;
                    break;
                case 600900:
                    loadFilterItem.e = i2;
                    break;
                case 600905:
                    loadFilterItem.c = i2;
                    break;
                case 610012:
                    loadFilterItem.h = i2;
                    break;
                case 610013:
                    loadFilterItem.d = i2;
                    break;
            }
        } while (cursor.moveToNext());
    }

    private void a(final String placementId, final int error_code) {
        if (com.sigmob.sdk.base.utils.m.a((CharSequence) placementId)) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.sigmob.sdk.base.db.a.a().getWritableDatabase();
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName(com.sigmob.sdk.base.db.a.f);
            HashMap map = new HashMap();
            map.put("adslot_id", placementId);
            map.put("error_code", Integer.valueOf(error_code));
            map.put(com.alipay.sdk.m.t.a.k, Long.valueOf(System.currentTimeMillis()));
            builder.setColumnValues(map);
            com.sigmob.sdk.base.db.a.a().a(writableDatabase, builder.build(), new a.InterfaceC0729a() { // from class: com.sigmob.sdk.base.m.1
                @Override // com.sigmob.sdk.base.db.a.InterfaceC0729a
                public void a() {
                    SigmobLog.d(placementId + " insert load error event " + error_code + " onSuccess: ");
                }

                @Override // com.sigmob.sdk.base.db.a.InterfaceC0729a
                public void a(Throwable e) {
                    SigmobLog.e(placementId + " insert load error event " + error_code + " onFailed: ", e);
                }
            });
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, x xVar, Object obj) {
        if (obj instanceof PointEntitySigmobRequest) {
            PointEntitySigmobRequest pointEntitySigmobRequest = (PointEntitySigmobRequest) obj;
            pointEntitySigmobRequest.setLoad_count(String.valueOf(this.a.b));
            pointEntitySigmobRequest.setInvalid_load_count(String.valueOf(this.a.a));
            pointEntitySigmobRequest.setGdpr_filters(String.valueOf(this.a.c));
            pointEntitySigmobRequest.setInterval_filters(String.valueOf(this.a.d));
            pointEntitySigmobRequest.setPldempty_filters(String.valueOf(this.pIdEmpty_filters));
            pointEntitySigmobRequest.setInit_filters(String.valueOf(this.a.e));
            pointEntitySigmobRequest.setLoading_filters(String.valueOf(this.a.h));
            pointEntitySigmobRequest.setProguard_filters(String.valueOf(this.a.g));
            pointEntitySigmobRequest.setAdx_id(null);
            if (com.sigmob.sdk.base.utils.m.b(this.e)) {
                pointEntitySigmobRequest.setBid_token(this.e);
            }
            if (com.sigmob.sdk.base.utils.m.b(str)) {
                pointEntitySigmobRequest.setTrace_id(str);
            }
            Map options = pointEntitySigmobRequest.getOptions();
            if (com.sigmob.sdk.base.utils.n.b(xVar)) {
                options.put(PointParamKey.FEED_PRE_REQUEST_COUNT, String.valueOf(xVar.a));
                options.put(PointParamKey.FEED_PRE_READY_COUNT, String.valueOf(xVar.b));
            }
            options.put(PointParamKey.IS_MINOR, i.a().d() ? "0" : "1");
            options.put(PointParamKey.IS_UNPERSONALIZED, i.a().e() ? "0" : "1");
            options.put(PointParamKey.PERSONALIZED_FILTERS, String.valueOf(this.a.f));
            options.put(PointParamKey.REQUEST_SCENE_TYPE, String.valueOf(j.NormalRequest.a()));
            pointEntitySigmobRequest.setOptions(options);
        }
        a();
    }

    private void b(String placementId) {
        if (com.sigmob.sdk.base.utils.m.a((CharSequence) placementId)) {
            return;
        }
        try {
            com.sigmob.sdk.base.db.a.a().getWritableDatabase().delete(com.sigmob.sdk.base.db.a.f, "adslot_id=?", new String[]{placementId});
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    protected void a(final x loadCacheItem, final String traceId) {
        ac.a("request", PointCategory.INIT, this.h, (LoadAdRequest) null, new ac.a() { // from class: com.sigmob.sdk.base.m$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                this.f$0.a(traceId, loadCacheItem, obj);
            }
        });
    }

    protected abstract void a(WindAdError adError);

    protected abstract void a(String key, String value);

    protected void a(boolean isBidType) {
        this.d = isBidType;
    }

    protected abstract Map<String, BiddingResponse> b();

    protected abstract com.sigmob.sdk.manager.b c();

    protected String d() {
        WindAdRequest windAdRequest = this.h;
        if (windAdRequest == null) {
            return null;
        }
        return windAdRequest.getPlacementId();
    }

    protected Integer e() {
        WindAdRequest windAdRequest = this.h;
        if (windAdRequest == null) {
            return null;
        }
        return Integer.valueOf(windAdRequest.getAdType());
    }

    protected boolean f() {
        String strD = d();
        com.sigmob.sdk.manager.b bVarC = c();
        return !com.sigmob.sdk.base.utils.m.a((CharSequence) strD) && bVarC != null && this.mADStatus == AdStatus.AdStatusReady && bVarC.c();
    }

    public int getBidFloor() {
        return this.g;
    }

    public String getBid_token() {
        return this.e;
    }

    public String getCurrency() {
        return this.i;
    }

    public abstract String getEcpm();

    public WindAdMetaData getWindAdMetaData() {
        com.sigmob.sdk.manager.b bVarC = c();
        if (bVarC == null) {
            return null;
        }
        BaseAdUnit baseAdUnitI = bVarC.i();
        if (baseAdUnitI == null) {
            baseAdUnitI = bVarC.e();
        }
        return WindAdMetaData.create(baseAdUnitI);
    }

    public boolean loadAd() {
        this.d = false;
        this.e = null;
        return false;
    }

    public boolean loadAd(String bid_token) {
        this.d = true;
        this.e = bid_token;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean loadAdFilter() {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.m.loadAdFilter():boolean");
    }

    public void sendLossNotificationWithInfo(Map<String, Object> lossInfo) {
        String strValueOf;
        try {
            Map<String, BiddingResponse> mapB = b();
            if (mapB == null) {
                return;
            }
            Set<String> setKeySet = mapB.keySet();
            if (com.sigmob.sdk.base.utils.e.a(setKeySet)) {
                return;
            }
            for (String str : setKeySet) {
                BiddingResponse biddingResponse = mapB.get(str);
                if (biddingResponse != null) {
                    String strReplace = biddingResponse.lose_url;
                    if (!com.sigmob.sdk.base.utils.m.a((CharSequence) strReplace)) {
                        if (com.sigmob.sdk.base.utils.e.b(lossInfo)) {
                            if (lossInfo.get(WindAds.AUCTION_PRICE) != null) {
                                a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(lossInfo.get(WindAds.AUCTION_PRICE)));
                                strReplace = strReplace.replace("__AUCTION_PRICE__", String.valueOf(lossInfo.get(WindAds.AUCTION_PRICE)));
                            }
                            if (lossInfo.get(WindAds.CURRENCY) != null) {
                                a(SigMacroCommon._CURRENCY_, String.valueOf(lossInfo.get(WindAds.CURRENCY)));
                                strValueOf = String.valueOf(lossInfo.get(WindAds.CURRENCY));
                            } else {
                                a(SigMacroCommon._CURRENCY_, this.i);
                                strValueOf = this.i;
                            }
                            strReplace = strReplace.replace("__CURRENCY__", strValueOf);
                            if (lossInfo.get(WindAds.LOSS_REASON) != null) {
                                strReplace = strReplace.replace("_BIDLOSSCODE_", String.valueOf(lossInfo.get(WindAds.LOSS_REASON)));
                            }
                            if (lossInfo.get(WindAds.ADN_ID) != null) {
                                strReplace = strReplace.replace("_WINADNID_", String.valueOf(lossInfo.get(WindAds.ADN_ID)));
                            }
                        }
                        com.sigmob.sdk.base.network.b.a(strReplace, PointCategory.LOSE, this.h, str);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendWinNotificationWithInfo(Map<String, Object> winInfo) {
        String strValueOf;
        try {
            Map<String, BiddingResponse> mapB = b();
            if (mapB == null) {
                return;
            }
            Set<String> setKeySet = mapB.keySet();
            if (com.sigmob.sdk.base.utils.e.a(setKeySet)) {
                return;
            }
            for (String str : setKeySet) {
                BiddingResponse biddingResponse = mapB.get(str);
                if (biddingResponse != null) {
                    String strReplace = biddingResponse.win_url;
                    if (!com.sigmob.sdk.base.utils.m.a((CharSequence) strReplace)) {
                        if (com.sigmob.sdk.base.utils.e.b(winInfo)) {
                            if (winInfo.get(WindAds.AUCTION_PRICE) != null) {
                                a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(winInfo.get(WindAds.AUCTION_PRICE)));
                                strReplace = strReplace.replace("__AUCTION_PRICE__", String.valueOf(winInfo.get(WindAds.AUCTION_PRICE)));
                            }
                            if (winInfo.get(WindAds.HIGHEST_LOSS_PRICE) != null) {
                                a(SigMacroCommon._HIGHESTLOSSPRICE_, String.valueOf(winInfo.get(WindAds.HIGHEST_LOSS_PRICE)));
                                strReplace = strReplace.replace("__HIGHEST_LOSS_PRICE__", String.valueOf(winInfo.get(WindAds.HIGHEST_LOSS_PRICE)));
                            }
                            if (winInfo.get(WindAds.CURRENCY) != null) {
                                a(SigMacroCommon._CURRENCY_, String.valueOf(winInfo.get(WindAds.CURRENCY)));
                                strValueOf = String.valueOf(winInfo.get(WindAds.CURRENCY));
                            } else {
                                a(SigMacroCommon._CURRENCY_, this.i);
                                strValueOf = this.i;
                            }
                            strReplace = strReplace.replace("__CURRENCY__", strValueOf);
                        }
                        com.sigmob.sdk.base.network.b.a(strReplace, PointCategory.WIN, this.h, str);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBidEcpm(int bidEcpm) {
        a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(bidEcpm));
    }

    public void setBidFloor(int bidFloor) {
        this.g = bidFloor;
    }

    public void setCurrency(String currency) {
        this.i = currency;
    }
}
