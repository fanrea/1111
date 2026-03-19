package com.component.a.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.cf;
import com.component.a.d.b;
import com.component.a.d.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class p {
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 4;
    private static final int d = 8;
    private static final int e = 16;
    private static final int f = 32;
    private static final int g = 414;
    private static final int h = 828;

    public static void a(View view, cf.a aVar) {
        cf.a(view, aVar);
    }

    @Deprecated
    public static void a(ViewGroup viewGroup, View view, com.component.a.f.e eVar) {
        a(viewGroup, view, eVar, -1, (RelativeLayout.LayoutParams) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(ViewGroup viewGroup, View view, com.component.a.f.e eVar, int i, RelativeLayout.LayoutParams layoutParams) {
        f lifeCycle;
        if (viewGroup == null || view == 0 || eVar == null || view.getParent() != null) {
            return;
        }
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        view.setId(i);
        String strL = eVar.l("");
        if (!TextUtils.isEmpty(strL)) {
            view.setTag(strL);
        }
        Context context = viewGroup.getContext();
        boolean z = layoutParams instanceof c.a;
        if (z) {
            a(context, (c.a) layoutParams, eVar);
        } else {
            a(context, viewGroup.getWidth(), viewGroup.getHeight(), layoutParams, eVar);
        }
        View viewA = a(eVar.f(""), viewGroup);
        if (z && viewA != null) {
            ((c.a) layoutParams).a(viewA.getId());
        } else {
            a(layoutParams, eVar.c(a(layoutParams)));
            a(layoutParams, eVar, viewGroup);
        }
        int[] iArrA = eVar.a(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        layoutParams.setMargins(ab.a(context, iArrA[0]), ab.a(context, iArrA[1]), ab.a(context, iArrA[2]), ab.a(context, iArrA[3]));
        a(context, layoutParams, eVar);
        b(context, layoutParams, eVar);
        if ((view instanceof com.component.a.c.c) && (lifeCycle = ((com.component.a.c.c) view).getLifeCycle()) != null) {
            lifeCycle.a((ViewGroup.LayoutParams) layoutParams);
        }
        viewGroup.addView(view, layoutParams);
    }

    public static void a(Context context, c.a aVar, com.component.a.f.e eVar) {
        int iA = eVar.a(aVar.width);
        if (iA > 0) {
            iA = ab.a(context, iA);
        }
        aVar.width = iA;
        int iB = eVar.b(aVar.height);
        if (iB > 0) {
            iB = ab.a(context, iB);
        }
        aVar.height = iB;
        b.C0314b c0314bA = aVar.a();
        float fB = eVar.b(-1.0f);
        if (fB > 0.0f) {
            c0314bA.a = fB;
        }
        float fC = eVar.c(-1.0f);
        if (fC > 0.0f) {
            c0314bA.b = fC;
        }
        float fA = eVar.a(-2.0f);
        if (fA > 0.0f) {
            c0314bA.u = fA;
        }
    }

    public static void a(Context context, int i, int i2, ViewGroup.LayoutParams layoutParams, com.component.a.f.e eVar) {
        float fA = eVar.a(-1.0f);
        int iA = eVar.a(layoutParams.width);
        if (iA > 0) {
            iA = ab.a(context, iA);
        }
        layoutParams.width = a(eVar.b(-1.0f), iA, i);
        if (layoutParams.width > 0 && fA > 0.0f) {
            layoutParams.height = (int) (layoutParams.width / fA);
            return;
        }
        int iB = eVar.b(layoutParams.height);
        if (iB > 0) {
            iB = ab.a(context, iB);
        }
        layoutParams.height = a(eVar.c(-1.0f), iB, i2);
        if (layoutParams.height > 0 && fA > 0.0f) {
            layoutParams.width = (int) (layoutParams.height * fA);
        }
    }

    private static void a(Context context, RelativeLayout.LayoutParams layoutParams, com.component.a.f.e eVar) {
        float[] fArrA = eVar.a(0.0f, 0.0f, 0.0f, 0.0f);
        if (fArrA[0] == 0.0f && fArrA[1] == 0.0f && fArrA[2] == 0.0f && fArrA[3] == 0.0f) {
            return;
        }
        int iB = a.b(context, a.c(context));
        int iB2 = a.b(context, a.d(context));
        float f2 = fArrA[0];
        float f3 = fArrA[1];
        float f4 = fArrA[2];
        float f5 = fArrA[3];
        if (layoutParams instanceof c.a) {
            b.C0314b c0314bA = ((c.a) layoutParams).a();
            int iA = a.a(context, 414.0f);
            int iA2 = a.a(context, 828.0f);
            if (f2 == -1.0f) {
                c0314bA.e = layoutParams.leftMargin / iA;
            } else if (f2 == 1.0f) {
                c0314bA.f = layoutParams.leftMargin / iA2;
            } else if (f2 > -1.0f && f2 < 0.0f) {
                c0314bA.c = -f2;
            } else if (f2 > 0.0f && f2 < 1.0f) {
                c0314bA.d = f2;
            }
            if (f3 == -1.0f) {
                c0314bA.i = layoutParams.topMargin / iA;
            } else if (f3 == 1.0f) {
                c0314bA.j = layoutParams.topMargin / iA2;
            } else if (f3 > -1.0f && f3 < 0.0f) {
                c0314bA.g = -f3;
            } else if (f3 > 0.0f && f3 < 1.0f) {
                c0314bA.h = f3;
            }
            if (f4 == -1.0f) {
                c0314bA.m = layoutParams.rightMargin / iA;
            } else if (f4 == 1.0f) {
                c0314bA.n = layoutParams.rightMargin / iA2;
            } else if (f4 > -1.0f && f4 < 0.0f) {
                c0314bA.k = -f4;
            } else if (f4 > 0.0f && f4 < 1.0f) {
                c0314bA.l = f4;
            }
            if (f5 == -1.0f) {
                c0314bA.q = layoutParams.bottomMargin / iA;
                return;
            }
            if (f5 == 1.0f) {
                c0314bA.r = layoutParams.bottomMargin / iA2;
                return;
            }
            if (f5 > -1.0f && f5 < 0.0f) {
                c0314bA.o = -f5;
                return;
            } else {
                if (f5 > 0.0f && f5 < 1.0f) {
                    c0314bA.p = f5;
                    return;
                }
                return;
            }
        }
        float f6 = iB / 414.0f;
        float f7 = iB2 / 828.0f;
        if (f2 == -1.0f) {
            layoutParams.leftMargin = (int) (layoutParams.leftMargin * f6);
        } else if (f2 == 1.0f) {
            layoutParams.leftMargin = (int) (layoutParams.leftMargin * f7);
        }
        if (f3 == -1.0f) {
            layoutParams.topMargin = (int) (layoutParams.topMargin * f6);
        } else if (f3 == 1.0f) {
            layoutParams.topMargin = (int) (layoutParams.topMargin * f7);
        }
        if (f4 == -1.0f) {
            layoutParams.rightMargin = (int) (layoutParams.rightMargin * f6);
        } else if (f4 == 1.0f) {
            layoutParams.rightMargin = (int) (layoutParams.rightMargin * f7);
        }
        if (f5 == -1.0f) {
            layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * f6);
        } else if (f5 == 1.0f) {
            layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * f7);
        }
    }

    private static void b(Context context, RelativeLayout.LayoutParams layoutParams, com.component.a.f.e eVar) {
        if (layoutParams instanceof c.a) {
            int[] iArrB = eVar.b(0, 0, 0, 0);
            if (iArrB[0] == 0 && iArrB[1] == 0 && iArrB[2] == 0 && iArrB[3] == 0) {
                return;
            }
            c.a aVar = (c.a) layoutParams;
            aVar.b = ab.a(context, iArrB[0]);
            aVar.c = ab.a(context, iArrB[1]);
            aVar.d = ab.a(context, iArrB[2]);
            aVar.e = ab.a(context, iArrB[3]);
            aVar.f = eVar.d(0);
        }
    }

    private static int a(float f2, int i, int i2) {
        if (f2 >= 0.0f && f2 <= 1.0f) {
            return (int) (i2 * f2);
        }
        return i;
    }

    public static void a(RelativeLayout.LayoutParams layoutParams, com.component.a.f.e eVar, ViewGroup viewGroup) {
        if (layoutParams != null && eVar != null && viewGroup != null) {
            a(layoutParams, 0, a(eVar.d(""), viewGroup));
            a(layoutParams, 2, a(eVar.b(""), viewGroup));
            a(layoutParams, 1, a(eVar.e(""), viewGroup));
            a(layoutParams, 3, a(eVar.c(""), viewGroup));
            a(layoutParams, 6, a(eVar.g(""), viewGroup));
            a(layoutParams, 8, a(eVar.h(""), viewGroup));
            String strK = eVar.k("");
            if (!TextUtils.isEmpty(strK)) {
                a(layoutParams, 5, a(strK, viewGroup));
                a(layoutParams, 7, a(strK, viewGroup));
            } else {
                a(layoutParams, 5, a(eVar.i(""), viewGroup));
                a(layoutParams, 7, a(eVar.j(""), viewGroup));
            }
        }
    }

    private static void a(RelativeLayout.LayoutParams layoutParams, int i, View view) {
        if (layoutParams != null && view != null) {
            layoutParams.addRule(i, view.getId());
        }
    }

    private static View a(String str, ViewGroup viewGroup) {
        if (!TextUtils.isEmpty(str) && viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null && TextUtils.equals(str, (String) childAt.getTag())) {
                    return childAt;
                }
            }
            return null;
        }
        return null;
    }

    private static int a(RelativeLayout.LayoutParams layoutParams) {
        int[] rules;
        if (layoutParams == null || (rules = layoutParams.getRules()) == null) {
            return 0;
        }
        return a(rules, 10, 1) + 0 + a(rules, 12, 2) + a(rules, 9, 4) + a(rules, 11, 8) + a(rules, 14, 16) + a(rules, 15, 32);
    }

    private static int a(int[] iArr, int i, int i2) {
        if (iArr[i] == -1) {
            return i2;
        }
        return 0;
    }

    public static void a(RelativeLayout.LayoutParams layoutParams, int i) {
        if (layoutParams != null && i > 0) {
            a(layoutParams, i, 1, 10);
            a(layoutParams, i, 2, 12);
            a(layoutParams, i, 4, 9);
            a(layoutParams, i, 8, 11);
            a(layoutParams, i, 16, 14);
            a(layoutParams, i, 32, 15);
        }
    }

    private static void a(RelativeLayout.LayoutParams layoutParams, int i, int i2, int i3) {
        if ((i & i2) == i2) {
            layoutParams.addRule(i3);
        }
    }
}
