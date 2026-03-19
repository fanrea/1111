package com.component.a.g.c;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.by;
import com.component.a.f.e;
import com.component.a.g.c.e;
import com.component.interfaces.RemoteReflectInterface;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g extends e {
    protected final Set<com.component.a.a.d> a;
    protected boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private a f;

    public g(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar, a aVar2) {
        super(context, jVar, aVar);
        this.b = false;
        this.c = true;
        this.d = false;
        this.e = false;
        this.f = aVar2;
        this.a = new HashSet();
    }

    @Override // com.component.a.g.c.e
    public void onCreateView(com.component.a.f.d dVar) {
        com.component.a.f.e eVarF;
        if (dVar != null) {
            View viewE = dVar.e();
            if ((viewE instanceof com.component.a.a.d) && e.d.BUTTON.equals(dVar.k()) && viewE.getVisibility() == 0 && (eVarF = dVar.f()) != null) {
                if (1 == eVarF.i().b(0)) {
                    this.a.add((com.component.a.a.d) viewE);
                }
                com.component.a.a.d dVar2 = (com.component.a.a.d) viewE;
                a(dVar2, this.mAdInfo);
                dVar2.c(true);
                JSONObject jSONObjectC = eVarF.c();
                if (jSONObjectC != null) {
                    int iOptInt = jSONObjectC.optInt("rvideo_dl_pause", 1);
                    this.e = TextUtils.equals(jSONObjectC.optString("long_click", "dl_cancel"), "dl_cancel");
                    if (iOptInt == 0) {
                        this.c = false;
                    } else if (iOptInt == 2) {
                        this.d = true;
                    }
                }
                if (this.f == null) {
                    return;
                }
                this.c = this.f.a;
                this.d = this.f.b;
            }
        }
    }

    public static void a(com.component.a.a.d dVar, com.baidu.mobads.container.adrequest.j jVar) {
        Context context = dVar.getContext();
        com.component.a.f.e eVarC = com.component.a.i.f.c((View) dVar);
        String strS = eVarC.s("");
        e.g gVarI = eVarC.i();
        if (TextUtils.isEmpty(strS)) {
            strS = gVarI.a("");
        }
        if (TextUtils.equals(strS, "cta")) {
            dVar.a(a(context, jVar, true));
        } else if (TextUtils.equals(strS, "ad_btn")) {
            dVar.a(a(context, jVar, false));
        } else {
            dVar.a(eVarC.o(""));
        }
    }

    @Override // com.component.a.g.c.e
    public Animator initViewAnimation(View view, com.component.a.f.e eVar) {
        AnimatorSet animatorSetA;
        if (e.d.BUTTON.equals(eVar.e())) {
            e.g gVarI = eVar.i();
            String strS = eVar.s("");
            if (TextUtils.isEmpty(strS)) {
                strS = gVarI.a("");
            }
            if (TextUtils.equals(strS, "cta") && (animatorSetA = a(view, eVar.h().g(0), eVar.h().f(-2.0f))) != null) {
                return animatorSetA;
            }
        }
        return super.initViewAnimation(view, eVar);
    }

    @Override // com.component.a.g.c.e
    public void buildJsonAnimator(View view, a.c cVar, com.component.a.f.e eVar, e.C0316e c0316e) {
        a.EnumC0133a enumC0133a;
        if (view instanceof com.component.a.a.d) {
            enumC0133a = a.EnumC0133a.PAINT;
        } else {
            enumC0133a = a.EnumC0133a.BACKGROUND;
        }
        cVar.a(enumC0133a);
    }

    @Override // com.component.a.g.c.e
    public void onClickView(com.component.a.f.d dVar) {
        super.onClickView(dVar);
        if (!this.b && this.a.size() > 0) {
            for (com.component.a.a.d dVar2 : this.a) {
                a(dVar2);
                a(dVar2, dVar.f());
            }
        }
    }

    @Override // com.component.a.g.c.e
    public void onCustomEvent(com.component.a.f.d dVar) {
    }

    private AnimatorSet a(View view, int i, float f) {
        int btnStyleType = this.mAdInfo.getBtnStyleType();
        by.b bVarA = this.mFlyweight.a();
        if (bVarA != null) {
            by.a(this.mAppContext, bVarA, (AbstractData) null, this.mAdInfo, 1);
        }
        if (btnStyleType < 1 || btnStyleType > 3) {
            return null;
        }
        int[] iArr = new int[4];
        iArr[0] = -35564;
        iArr[1] = -648683;
        iArr[2] = -3602220;
        iArr[3] = -194648;
        List<String> btnStyleColors = this.mAdInfo.getBtnStyleColors();
        if (btnStyleColors != null && btnStyleColors.size() == 4) {
            for (int i2 = 0; i2 < btnStyleColors.size(); i2++) {
                iArr[i2] = Color.parseColor(btnStyleColors.get(i2));
            }
        }
        return com.baidu.mobads.container.util.animation.j.a(view, i, f, btnStyleType, iArr, a.EnumC0133a.PAINT);
    }

    public static String a(Context context, com.baidu.mobads.container.adrequest.j jVar, boolean z) {
        String str;
        String appPackageName = jVar.getAppPackageName();
        ab.a aVarA = com.baidu.mobads.container.util.ab.a(context, jVar);
        if (ab.a.APP_DOWNLOAD.equals(aVarA)) {
            if (!TextUtils.isEmpty(appPackageName) && RemoteReflectInterface.getDownloadStatus(appPackageName) == 101) {
                return "点击安装";
            }
            str = "立即下载";
        } else if (ab.a.DEEP_LINK.equals(aVarA)) {
            str = "去看看";
        } else {
            str = "查看详情";
        }
        String actRefinedText = jVar.getActRefinedText();
        if (z && !TextUtils.isEmpty(actRefinedText)) {
            return actRefinedText;
        }
        return str;
    }

    private void a(com.component.a.a.d dVar) {
        String appPackageName = this.mAdInfo.getAppPackageName();
        h hVar = new h(this, appPackageName, new WeakReference(dVar));
        if (this.mFlyweight != null) {
            this.mFlyweight.a(appPackageName, hVar);
        }
    }

    public static class a {
        private boolean a = true;
        private boolean b = false;

        public a a(boolean z) {
            this.a = z;
            return this;
        }

        public a b(boolean z) {
            this.b = z;
            return this;
        }
    }

    private void a(com.component.a.a.d dVar, com.component.a.f.e eVar) {
        if (dVar != null) {
            com.component.a.i.c cVar = new com.component.a.i.c(dVar, new i(this, eVar, dVar));
            cVar.a(this.e);
            cVar.a();
        }
    }
}
