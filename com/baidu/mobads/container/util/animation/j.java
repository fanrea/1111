package com.baidu.mobads.container.util.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.animation.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j {
    public static final String a = "translate";
    public static final String b = "alpha";
    public static final String c = "scale";
    public static final String d = "left";
    public static final String e = "right";
    public static final String f = "top";
    public static final String g = "bottom";
    private static final String h = j.class.getSimpleName();

    public static AnimatorSet a(a aVar) {
        AnimatorSet animatorSetB = b(aVar);
        e.a(aVar.a(), animatorSetB, new k());
        return animatorSetB;
    }

    public static AnimatorSet b(a aVar) {
        String strB;
        a.b bVarB = aVar.b();
        View viewA = aVar.a();
        int iA = aVar.a(0);
        int iC = aVar.c(0);
        int iB = aVar.b(0);
        float fA = aVar.a(0.0f);
        float fB = aVar.b(0.0f);
        Interpolator interpolatorA = aVar.a(new LinearInterpolator());
        if (a.b.TRANSLATE_X.equals(bVarB)) {
            fA = com.baidu.mobads.container.util.ab.a(viewA.getContext(), fA);
            fB = com.baidu.mobads.container.util.ab.a(viewA.getContext(), fB);
            strB = "translationX";
        } else if (a.b.TRANSLATE_Y.equals(bVarB)) {
            fA = com.baidu.mobads.container.util.ab.a(viewA.getContext(), fA);
            fB = com.baidu.mobads.container.util.ab.a(viewA.getContext(), fB);
            strB = "translationY";
        } else if (a.b.ABSOLUTE_X.equals(bVarB)) {
            strB = "x";
        } else if (a.b.ABSOLUTE_Y.equals(bVarB)) {
            strB = "y";
        } else if (a.b.SCALE_X.equals(bVarB)) {
            strB = "scaleX";
        } else if (a.b.SCALE_Y.equals(bVarB)) {
            strB = "scaleY";
        } else {
            strB = bVarB.b();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        if ("scale".equals(strB)) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewA, "scaleX", fA, fB);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewA, "scaleY", fA, fB);
            objectAnimatorOfFloat.setRepeatCount(iC);
            objectAnimatorOfFloat2.setRepeatCount(iC);
            animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        } else {
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewA, strB, fA, fB);
            objectAnimatorOfFloat3.setRepeatCount(iC);
            animatorSet.play(objectAnimatorOfFloat3);
        }
        animatorSet.setDuration(iA);
        if (iB > 0) {
            animatorSet.setStartDelay(iB);
        }
        animatorSet.setInterpolator(interpolatorA);
        return animatorSet;
    }

    public static AnimatorSet c(a aVar) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (a.b.GROUP.equals(aVar.b())) {
            View viewA = aVar.a();
            int iC = aVar.c(0);
            int iB = aVar.b(0);
            Interpolator interpolatorA = aVar.a(new LinearInterpolator());
            List<a> listE = aVar.e();
            ArrayList arrayList = new ArrayList();
            Iterator<a> it = listE.iterator();
            while (it.hasNext()) {
                arrayList.add(b(it.next()));
            }
            Collections.sort(arrayList, new u());
            if (arrayList.size() > 0) {
                animatorSet.playTogether(arrayList);
            }
            if (interpolatorA != null) {
                animatorSet.setInterpolator(interpolatorA);
            }
            if (iC == -1 || iC > 0) {
                e.a(animatorSet, iC, -1);
            }
            e.a(viewA, animatorSet, iB, new v(viewA));
        }
        return animatorSet;
    }

    public static AnimatorSet a(View view, int i, int i2, int[] iArr, a.EnumC0133a enumC0133a) {
        return a(view, i, -2.0f, i2, iArr, enumC0133a);
    }

    public static AnimatorSet a(View view, int i, float f2, int i2, int[] iArr, a.EnumC0133a enumC0133a) {
        int[] iArr2 = iArr;
        AnimatorSet animatorSet = new AnimatorSet();
        if (iArr2 == null || iArr2.length != 4) {
            iArr2 = new int[]{-35564, -648683, -3602220, -194648};
        }
        if (i2 == 1) {
            return a(view, 1000, 333, -1, 1.0f, 1.05f);
        }
        if (i2 == 2) {
            return f(a.a(view).a(2000).b(0).c(-1).a(new int[]{-1}).d(i).a(f2).a(enumC0133a).a(a.b.SWIPE));
        }
        if (i2 == 3) {
            return e(a.a(view).a(2000).b(0).c(-1).d(i).a(f2).a(iArr2).a(enumC0133a).a(a.b.GRADIENT));
        }
        return animatorSet;
    }

    public static void a(ViewGroup viewGroup, View view, Animator animator) {
        if (viewGroup == null || view == null || animator == null) {
            return;
        }
        viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
        animator.start();
    }

    public static AnimatorSet a(View view, int i, float f2, float f3) {
        return d(a.a(view).a(i).b(0).c(-1).a(a.EnumC0133a.BACKGROUND).b(String.valueOf(f2)).c(String.valueOf(f3)).a(a.b.BREATHE));
    }

    public static AnimatorSet d(a aVar) {
        View view;
        View viewA = aVar.a();
        int iA = aVar.a(2000);
        int iB = aVar.b(0);
        int iC = aVar.c(-1);
        float fA = aVar.a(1.0f);
        float fB = aVar.b(1.05f);
        JSONArray jSONArrayC = aVar.c();
        float fOptDouble = (float) jSONArrayC.optDouble(0, 0.20000000298023224d);
        float fOptDouble2 = (float) jSONArrayC.optDouble(1, 0.20000000298023224d);
        a.EnumC0133a enumC0133aH = aVar.h();
        if (a.EnumC0133a.BACKGROUND.equals(enumC0133aH)) {
            view = null;
        } else {
            int iF = aVar.f();
            int iA2 = com.component.a.i.r.a(aVar.f(Color.parseColor("#3388FF")), 0.3f);
            float f2 = iF;
            Drawable drawableA = com.component.a.i.r.a(0, GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iA2}, iA2, 0, new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, aVar.g());
            View view2 = new View(viewA.getContext());
            view2.setBackgroundDrawable(drawableA);
            view = view2;
        }
        return e.a(viewA, new w(enumC0133aH, viewA, view, fA, fB, fOptDouble, fOptDouble2, iA, iC, iB));
    }

    public static AnimatorSet a(View view, int i, int i2, int i3, int i4, int[] iArr, a.EnumC0133a enumC0133a) {
        return e(a.a(view).a(i).b(i2).c(i3).d(i4).a(iArr).a(enumC0133a).a(a.b.GRADIENT));
    }

    public static AnimatorSet e(a aVar) {
        View viewA = aVar.a();
        int iA = aVar.a(1000);
        int iB = aVar.b(0);
        int iC = aVar.c(-1);
        int iF = aVar.f();
        float fG = aVar.g();
        a.EnumC0133a enumC0133aH = aVar.h();
        int[] iArr = {-35564, -648683, -3602220, -194648};
        int[] iArrD = aVar.d();
        if (iArrD != null && iArrD.length >= 2) {
            iArr = iArrD;
        }
        int[] iArr2 = new int[iArr.length + 2];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        System.arraycopy(iArr, 0, iArr2, iArr.length, 2);
        return a(viewA, iA, iB, iC, iArr2, iF, fG, enumC0133aH, new y());
    }

    public static AnimatorSet a(View view, int i, int i2, int i3, int i4, int i5, a.EnumC0133a enumC0133a) {
        return f(a.a(view).a(i).b(i2).c(i3).a(new int[]{i4}).d(i5).a(enumC0133a).a(a.b.SWIPE));
    }

    public static AnimatorSet f(a aVar) {
        View viewA = aVar.a();
        int iA = aVar.a(2000);
        int iB = aVar.b(0);
        int iC = aVar.c(-1);
        int iF = aVar.f();
        float fG = aVar.g();
        a.EnumC0133a enumC0133aH = aVar.h();
        int[] iArr = {16777215, (aVar.f(-1) & 16777215) - 2013265920, 16777215};
        return a(viewA, iA, iB, iC, iArr, iF, fG, enumC0133aH, new z(iArr));
    }

    public static AnimatorSet a(View view, int i, int i2, int i3, int[] iArr, int i4, float f2, a.EnumC0133a enumC0133a, e.b bVar) {
        return e.a(view, new aa(enumC0133a, view, f2, i4, bVar, iArr, i, i3, i2));
    }

    public static AnimatorSet g(a aVar) {
        View viewA = aVar.a();
        int iA = aVar.a(2000);
        int iB = aVar.b(0);
        int iC = aVar.c(0);
        a.EnumC0133a enumC0133aH = aVar.h();
        Interpolator interpolatorA = aVar.a(new LinearInterpolator());
        float fD = aVar.d(0);
        float fE = aVar.e(0);
        int[] iArrD = aVar.d();
        return e.a(viewA, iB, new ac(iArrD.length, fD, iArrD, iC, viewA, fE, enumC0133aH, iA, interpolatorA));
    }

    public static AnimatorSet h(a aVar) {
        View viewA = aVar.a();
        int iA = aVar.a(2000);
        int iB = aVar.b(0);
        int iC = aVar.c(-1);
        JSONArray jSONArrayC = aVar.c();
        return e.a(viewA, new ae(viewA, (float) jSONArrayC.optDouble(0, 1.6d), (float) jSONArrayC.optDouble(1, 0.75d), (float) jSONArrayC.optDouble(2, 0.4d), iA, iB, iC));
    }

    public static AnimatorSet a(aj ajVar, int i) {
        AnimatorSet animatorSet = new AnimatorSet();
        a(ajVar, animatorSet, i, 0, -1);
        return animatorSet;
    }

    public static void a(aj ajVar, AnimatorSet animatorSet, int i, int i2, int i3) {
        e.a(ajVar, animatorSet, new l(ajVar, i, i3, i2));
    }

    public static AnimatorSet a(ImageView imageView, int i, int i2, int i3) {
        return e.a(imageView, new n(imageView, i2, i3, i));
    }

    public static AnimatorSet a(ImageView imageView, int i, int i2, float f2, float f3, float f4, float f5) {
        return e.a(imageView, new p(imageView, i, f2, f3, f4, f5, i2));
    }

    public static AnimatorSet a(View view, int i, int i2, int i3, float f2, float f3) {
        return i(a.a(view).a(i).b(i2).c(i3).b(String.valueOf(f2)).c(String.valueOf(f3)).a(a.b.HEARTBEAT));
    }

    public static AnimatorSet i(a aVar) {
        View viewA = aVar.a();
        return e.a(viewA, new q(aVar.a(1.0f), aVar.b(0.9f), viewA, aVar.a(1000), aVar.b(333), aVar.c(-1)));
    }

    public static AnimatorSet j(a aVar) {
        View viewA = aVar.a();
        AnimatorSet animatorSetB = b(viewA, aVar.a(1000), aVar.a(1.15f), aVar.b(0.85f));
        e.a(viewA, animatorSetB, new r());
        return animatorSetB;
    }

    public static AnimatorSet b(View view, int i, float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (view == null) {
            return animatorSet;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", f2, f3, f2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", f2, f3, f2);
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.setDuration(i);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        return animatorSet;
    }

    public static AnimatorSet k(a aVar) {
        View viewA = aVar.a();
        int iA = aVar.a(1000);
        int iB = aVar.b(0);
        int iC = aVar.c(-1);
        float fA = aVar.a(0.4f);
        float fB = aVar.b(1.1f);
        BDCircleView bDCircleView = new BDCircleView(viewA.getContext());
        AnimatorSet animatorSetA = a(bDCircleView, iA, iB, iC, fA, fB);
        e.a(viewA, animatorSetA, new s(viewA, bDCircleView));
        return animatorSetA;
    }

    public static AnimatorSet a(BDCircleView bDCircleView, int i, int i2, int i3, float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (bDCircleView == null) {
            return animatorSet;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(bDCircleView, "alpha", 0.6f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(bDCircleView, "scaleRate", f2, f3);
        objectAnimatorOfFloat.setRepeatCount(i3);
        objectAnimatorOfFloat2.setRepeatCount(i3);
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.setDuration(i);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setStartDelay(i2);
        return animatorSet;
    }

    public static AnimatorSet l(a aVar) {
        View viewA = aVar.a();
        int iA = aVar.a(500);
        int iB = aVar.b(0);
        int iC = aVar.c(0);
        Interpolator interpolatorA = aVar.a(new LinearInterpolator());
        JSONArray jSONArrayC = aVar.c();
        String strOptString = jSONArrayC.optString(0, a);
        String strOptString2 = jSONArrayC.optString(1, d);
        boolean zEquals = a.b.EXIT.equals(aVar.b());
        if (!zEquals) {
            viewA.setVisibility(4);
        }
        return e.a(viewA, iB, new t(viewA, iA, iC, interpolatorA, strOptString, strOptString2, zEquals));
    }
}
