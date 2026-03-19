package com.kwad.sdk.p;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i extends Resources {
    private final Resources cqx;

    public i(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.cqx = resources2;
    }

    private static boolean hO(int i) {
        return !new StringBuilder("0x").append(Integer.toHexString(i)).toString().startsWith("0x60");
    }

    private static boolean aI(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("ksad_") || !"com.kwad.dy.sdk".equals(str2);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getText(i);
        }
        return super.getText(i);
    }

    @Override // android.content.res.Resources
    public final Typeface getFont(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getFont id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getFont(i);
        }
        return super.getFont(i);
    }

    @Override // android.content.res.Resources
    public final CharSequence getQuantityText(int i, int i2) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getQuantityText id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getQuantityText(i, i2);
        }
        return super.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public final String getString(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getString(i);
        }
        return super.getString(i);
    }

    @Override // android.content.res.Resources
    public final String getString(int i, Object... objArr) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getString(i, objArr);
        }
        return super.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int i, int i2) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getQuantityString(i, i2);
        }
        return super.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int i, int i2, Object... objArr) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getQuantityString(i, i2, objArr);
        }
        return super.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i, CharSequence charSequence) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getText(i, charSequence);
        }
        return super.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public final CharSequence[] getTextArray(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getTextArray id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getTextArray(i);
        }
        return super.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public final String[] getStringArray(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getStringArray id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getStringArray(i);
        }
        return super.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public final int[] getIntArray(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getIntArray id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getIntArray(i);
        }
        return super.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainTypedArray(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "obtainTypedArray id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.obtainTypedArray(i);
        }
        return super.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDimension id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getDimension(i);
        }
        return super.getDimension(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDimensionPixelOffset id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getDimensionPixelOffset(i);
        }
        return super.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDimensionPixelSize id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getDimensionPixelSize(i);
        }
        return super.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public final float getFraction(int i, int i2, int i3) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getFraction id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getFraction(i, i2, i3);
        }
        return super.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawable(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getDrawable(i);
        }
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i, Resources.Theme theme) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getDrawable(i);
        }
        return super.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawableForDensity(int i, int i2) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawableForDensity id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getDrawableForDensity(i, i2);
        }
        return super.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getDrawableForDensity(i, i2, theme);
        }
        return super.getDrawableForDensity(i, i2, theme);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Movie getMovie(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getMovie(i);
        }
        return super.getMovie(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final int getColor(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getColor id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getColor(i);
        }
        return super.getColor(i);
    }

    @Override // android.content.res.Resources
    public final int getColor(int i, Resources.Theme theme) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getColor(i, theme);
        }
        return super.getColor(i, theme);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getBoolean id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getBoolean(i);
        }
        return super.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getInteger id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getInteger(i);
        }
        return super.getInteger(i);
    }

    @Override // android.content.res.Resources
    public final float getFloat(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getFloat id: #0x" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getFloat(i);
        }
        return super.getFloat(i);
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getLayout(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getLayout id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getLayout(i);
        }
        return super.getLayout(i);
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getAnimation(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getAnimation id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getAnimation(i);
        }
        return super.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getXml(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getXml id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getXml(i);
        }
        return super.getXml(i);
    }

    @Override // android.content.res.Resources
    public final InputStream openRawResource(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.openRawResource(i);
        }
        return super.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public final InputStream openRawResource(int i, TypedValue typedValue) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.openRawResource(i, typedValue);
        }
        return super.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "openRawResourceFd id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.openRawResourceFd(i);
        }
        return super.openRawResourceFd(i);
    }

    @Override // android.content.res.Resources
    public final void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            this.cqx.getValue(i, typedValue, z);
        } else {
            super.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getValueForDensity id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            this.cqx.getValueForDensity(i, i2, typedValue, z);
        } else {
            super.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int identifier = getIdentifier(str, TypedValues.Custom.S_STRING, null);
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(identifier));
        if (hO(identifier)) {
            this.cqx.getValue(str, typedValue, z);
        } else {
            super.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public final int getIdentifier(String str, String str2, String str3) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getIdentifier id: 0x# name:" + str + " :defPackage" + str3);
        if (aI(str, str3)) {
            return this.cqx.getIdentifier(str, str2, str3);
        }
        return super.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourceName id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getResourceName(i);
        }
        return super.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourcePackageName id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getResourcePackageName(i);
        }
        return super.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourceTypeName id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getResourceTypeName(i);
        }
        return super.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public final ColorStateList getColorStateList(int i, Resources.Theme theme) {
        try {
            com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getColorStateList: 0x#" + Integer.toHexString(i));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("KSDY/KSResource", Log.getStackTraceString(e));
        }
        if (hO(i)) {
            return this.cqx.getColorStateList(i, theme);
        }
        return super.getColorStateList(i, theme);
    }

    @Override // android.content.res.Resources
    public final ColorStateList getColorStateList(int i) {
        try {
            com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getColorStateList: 0x#" + Integer.toHexString(i));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("KSDY/KSResource", Log.getStackTraceString(e));
        }
        if (hO(i)) {
            return this.cqx.getColorStateList(i);
        }
        return super.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int i) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getResourceEntryName id: 0x#" + Integer.toHexString(i));
        if (hO(i)) {
            return this.cqx.getResourceEntryName(i);
        }
        return super.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        super.parseBundleExtra(str, attributeSet, bundle);
    }
}
