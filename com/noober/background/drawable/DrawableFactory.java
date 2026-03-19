package com.noober.background.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DrawableFactory {
    public static GradientDrawable getDrawable(TypedArray typedArray) throws XmlPullParserException {
        return new GradientDrawableCreator(typedArray).create();
    }

    public static GradientDrawable getDrawable(TypedArray typedArray, int i) throws XmlPullParserException {
        return new GradientDrawableCreator(typedArray, i).create();
    }

    public static StateListDrawable getStateGradientDrawable(TypedArray typedArray) throws Exception {
        return new GradientStateDrawableCreator(typedArray).create();
    }

    public static StateListDrawable getSelectorDrawable(TypedArray typedArray, TypedArray typedArray2) throws Exception {
        return (StateListDrawable) new SelectorDrawableCreator(typedArray, typedArray2).create();
    }

    public static StateListDrawable getSelectorPre21Drawable(TypedArray typedArray) throws Exception {
        return new SelectorPre21DrawableCreator(typedArray).create();
    }

    public static StateListDrawable getButtonDrawable(TypedArray typedArray, TypedArray typedArray2) throws Exception {
        return (StateListDrawable) new ButtonDrawableCreator(typedArray, typedArray2).create();
    }

    public static ColorStateList getTextSelectorColor(TypedArray typedArray) {
        return new ColorStateCreator(typedArray).create();
    }

    public static StateListDrawable getPressDrawable(GradientDrawable gradientDrawable, TypedArray typedArray, TypedArray typedArray2) throws Exception {
        return (StateListDrawable) new PressDrawableCreator(gradientDrawable, typedArray, typedArray2).create();
    }

    public static AnimationDrawable getAnimationDrawable(TypedArray typedArray) throws Exception {
        return (AnimationDrawable) new AnimationDrawableCreator(typedArray).create();
    }

    public static StateListDrawable getMultiSelectorDrawable(Context context, TypedArray typedArray, TypedArray typedArray2) {
        return (StateListDrawable) new MultiSelectorDrawableCreator(context, typedArray, typedArray2).create();
    }

    public static ColorStateList getMultiTextColorSelectorColorCreator(Context context, TypedArray typedArray) {
        return new MultiTextColorSelectorColorCreator(context, typedArray).create();
    }
}
