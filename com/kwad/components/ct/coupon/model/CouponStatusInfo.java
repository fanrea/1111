package com.kwad.components.ct.coupon.model;

import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.a.a;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CouponStatusInfo extends a implements b, Serializable {
    private static final long serialVersionUID = -6390497068195603159L;
    public int statusCode = -1;
    public String statusName = "";
    public double currTotalAmount = 0.0d;
    public int couponLeftTimes = 0;
    public boolean isNewUser = false;
}
