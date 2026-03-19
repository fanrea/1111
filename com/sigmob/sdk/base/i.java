package com.sigmob.sdk.base;

import android.content.Context;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobPrivacy;
import com.sigmob.sdk.base.mta.PointType;
import com.sigmob.windad.consent.WindAdConsentInformation;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class i {
    private static i e;
    private int b;
    private int d;
    private boolean f;
    private int g;
    private Boolean h;
    private boolean a = true;
    private boolean c = true;

    private i() {
        Context contextE = com.sigmob.sdk.b.e();
        this.b = com.sigmob.sdk.base.utils.p.a(contextE, (String) null, "age_restricted_status", 0);
        this.d = com.sigmob.sdk.base.utils.p.a(contextE, (String) null, "user_age", 0);
        this.g = com.sigmob.sdk.base.utils.p.a(contextE, (String) null, "consent_status", 0);
        this.f = com.sigmob.sdk.base.utils.p.a(contextE, (String) null, "gdpr_region", false);
    }

    public static synchronized i a() {
        if (e == null) {
            synchronized (i.class) {
                e = new i();
            }
        }
        return e;
    }

    private void a(int userAge) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAge(String.valueOf(userAge));
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category("coppa");
        pointEntitySigmobPrivacy.setCategory("privacy");
        pointEntitySigmobPrivacy.commit();
    }

    private void a(boolean isAdult) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category(PointCategory.ADULT);
        pointEntitySigmobPrivacy.setCategory("privacy");
        pointEntitySigmobPrivacy.setIs_minor(isAdult ? "0" : "1");
        pointEntitySigmobPrivacy.commit();
    }

    private void b(int age_restricted) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAge_restricted(String.valueOf(age_restricted));
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category("coppa");
        pointEntitySigmobPrivacy.setCategory("privacy");
        pointEntitySigmobPrivacy.commit();
    }

    private void b(boolean isPersonalizedAdvertisingOn) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category(PointCategory.PERSONALIZED);
        pointEntitySigmobPrivacy.setCategory("privacy");
        pointEntitySigmobPrivacy.setIs_unpersonalized(isPersonalizedAdvertisingOn ? "0" : "1");
        pointEntitySigmobPrivacy.commit();
    }

    private void j() {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setUser_consent(String.valueOf(g()));
        String str = "1";
        pointEntitySigmobPrivacy.setGdpr_region(h() ? "1" : "0");
        try {
            if (!WindAdConsentInformation.getInstance(com.sigmob.sdk.b.e()).isRequestLocationInEeaOrUnknown()) {
                str = "0";
            }
            pointEntitySigmobPrivacy.setGdpr_dialog_region(str);
        } catch (Throwable unused) {
        }
        pointEntitySigmobPrivacy.setSub_category(PointCategory.CONSENT);
        pointEntitySigmobPrivacy.setCategory("gdpr");
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.commit();
    }

    public void a(int userAge, boolean sendTrack) {
        this.d = userAge;
        com.sigmob.sdk.base.utils.p.b(com.sigmob.sdk.b.e(), (String) null, "user_age", this.d);
        if (sendTrack) {
            a(userAge);
        }
    }

    public void a(Boolean extGDPRRegion) {
        if (extGDPRRegion != null) {
            com.sigmob.sdk.base.utils.p.b(com.sigmob.sdk.b.e(), (String) null, "gdpr_region", extGDPRRegion.booleanValue());
            this.f = extGDPRRegion.booleanValue();
        }
        if (i()) {
            j();
            b(this.c);
            a(this.a);
            b(this.b);
            a(this.d);
        }
    }

    public void a(boolean isAdult, boolean sendTrack) {
        SigmobLog.i("PrivacyManager -> setAdult " + isAdult);
        this.a = isAdult;
        if (sendTrack) {
            a(isAdult);
        }
    }

    public int b() {
        return this.d;
    }

    public void b(int age_restricted, boolean sendTrack) {
        this.b = age_restricted;
        com.sigmob.sdk.base.utils.p.b(com.sigmob.sdk.b.e(), (String) null, "age_restricted_status", this.b);
        if (sendTrack) {
            b(age_restricted);
        }
    }

    public void b(boolean isPersonalizedAdvertisingOn, boolean sendTrack) {
        if (this.h == null) {
            this.h = Boolean.valueOf(isPersonalizedAdvertisingOn);
        }
        SigmobLog.i("PrivacyManager -> setPersonalized " + isPersonalizedAdvertisingOn);
        this.c = isPersonalizedAdvertisingOn;
        if (sendTrack) {
            b(isPersonalizedAdvertisingOn);
        }
    }

    public int c() {
        return this.b;
    }

    public void c(int gdprConSentStatus, boolean sendtrack) {
        this.g = gdprConSentStatus;
        com.sigmob.sdk.base.utils.p.b(com.sigmob.sdk.b.e(), (String) null, "consent_status", gdprConSentStatus);
        if (sendtrack) {
            j();
        }
    }

    public boolean d() {
        return this.a;
    }

    public boolean e() {
        return this.c;
    }

    public boolean f() {
        Boolean bool = this.h;
        return bool == null || bool.booleanValue() != this.c;
    }

    public int g() {
        return this.g;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return (g() == 1) || !h();
    }
}
