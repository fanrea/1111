package com.noober.background.drawable;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import com.noober.background.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GradientDrawableCreator implements ICreateDrawable {
    private int gradientState;
    private TypedArray typedArray;

    GradientDrawableCreator(TypedArray typedArray) {
        this.gradientState = -1;
        this.typedArray = typedArray;
    }

    GradientDrawableCreator(TypedArray typedArray, int i) {
        this.typedArray = typedArray;
        this.gradientState = i;
    }

    @Override // com.noober.background.drawable.ICreateDrawable
    public GradientDrawable create() throws XmlPullParserException, IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        float f;
        float f2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        float[] fArr = new float[8];
        Rect rect = new Rect();
        int i = 0;
        int i2 = 0;
        int color = 0;
        int color2 = 0;
        int color3 = 0;
        int color4 = 0;
        int color5 = 0;
        int i3 = 0;
        int integer = 0;
        float dimension = 0.0f;
        float dimension2 = 0.0f;
        float dimension3 = -1.0f;
        float dimension4 = 0.0f;
        float dimension5 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i2 < this.typedArray.getIndexCount()) {
            int index = this.typedArray.getIndex(i2);
            if (index == R.styleable.background_bl_shape) {
                gradientDrawable.setShape(this.typedArray.getInt(index, i));
            } else {
                if (index == R.styleable.background_bl_solid_color) {
                    color = this.typedArray.getColor(index, i);
                } else if (index == R.styleable.background_bl_corners_radius) {
                    gradientDrawable.setCornerRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (index == R.styleable.background_bl_corners_bottomLeftRadius) {
                    fArr[6] = this.typedArray.getDimension(index, 0.0f);
                    fArr[7] = this.typedArray.getDimension(index, 0.0f);
                } else {
                    if (index == R.styleable.background_bl_corners_bottomRightRadius) {
                        fArr[4] = this.typedArray.getDimension(index, 0.0f);
                        f = f3;
                        fArr[5] = this.typedArray.getDimension(index, 0.0f);
                    } else {
                        f = f3;
                        if (index == R.styleable.background_bl_corners_topLeftRadius) {
                            fArr[0] = this.typedArray.getDimension(index, 0.0f);
                            fArr[1] = this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_corners_topRightRadius) {
                            fArr[2] = this.typedArray.getDimension(index, 0.0f);
                            fArr[3] = this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_corners_leftRadius) {
                            fArr[0] = this.typedArray.getDimension(index, 0.0f);
                            fArr[1] = this.typedArray.getDimension(index, 0.0f);
                            fArr[6] = this.typedArray.getDimension(index, 0.0f);
                            fArr[7] = this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_corners_topRadius) {
                            fArr[0] = this.typedArray.getDimension(index, 0.0f);
                            fArr[1] = this.typedArray.getDimension(index, 0.0f);
                            fArr[2] = this.typedArray.getDimension(index, 0.0f);
                            fArr[3] = this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_corners_rightRadius) {
                            fArr[2] = this.typedArray.getDimension(index, 0.0f);
                            fArr[3] = this.typedArray.getDimension(index, 0.0f);
                            fArr[4] = this.typedArray.getDimension(index, 0.0f);
                            fArr[5] = this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_corners_bottomRadius) {
                            fArr[4] = this.typedArray.getDimension(index, 0.0f);
                            fArr[5] = this.typedArray.getDimension(index, 0.0f);
                            fArr[6] = this.typedArray.getDimension(index, 0.0f);
                            fArr[7] = this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_gradient_angle || index == R.styleable.background_bl_checkable_gradient_angle || index == R.styleable.background_bl_unCheckable_gradient_angle || index == R.styleable.background_bl_checked_gradient_angle || index == R.styleable.background_bl_unChecked_gradient_angle || index == R.styleable.background_bl_enabled_gradient_angle || index == R.styleable.background_bl_unEnabled_gradient_angle || index == R.styleable.background_bl_selected_gradient_angle || index == R.styleable.background_bl_unSelected_gradient_angle || index == R.styleable.background_bl_pressed_gradient_angle || index == R.styleable.background_bl_unPressed_gradient_angle || index == R.styleable.background_bl_focused_gradient_angle || index == R.styleable.background_bl_unFocused_gradient_angle) {
                            int i4 = this.gradientState;
                            if (i4 == -1) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (i4 == 16842911 && index == R.styleable.background_bl_checkable_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (this.gradientState == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (this.gradientState == 16842912 && index == R.styleable.background_bl_checked_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (this.gradientState == -16842912 && index == R.styleable.background_bl_unChecked_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (this.gradientState == 16842910 && index == R.styleable.background_bl_enabled_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (this.gradientState == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (this.gradientState == 16842913 && index == R.styleable.background_bl_selected_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (this.gradientState == -16842913 && index == R.styleable.background_bl_unSelected_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (this.gradientState == 16842919 && index == R.styleable.background_bl_pressed_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (this.gradientState == -16842919 && index == R.styleable.background_bl_unPressed_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (this.gradientState == 16842908 && index == R.styleable.background_bl_focused_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            } else if (this.gradientState == -16842908 && index == R.styleable.background_bl_unFocused_gradient_angle) {
                                integer = this.typedArray.getInteger(index, 0);
                            }
                        } else if (index == R.styleable.background_bl_gradient_centerX || index == R.styleable.background_bl_checkable_gradient_centerX || index == R.styleable.background_bl_unCheckable_gradient_centerX || index == R.styleable.background_bl_checked_gradient_centerX || index == R.styleable.background_bl_unChecked_gradient_centerX || index == R.styleable.background_bl_enabled_gradient_centerX || index == R.styleable.background_bl_unEnabled_gradient_centerX || index == R.styleable.background_bl_selected_gradient_centerX || index == R.styleable.background_bl_unSelected_gradient_centerX || index == R.styleable.background_bl_pressed_gradient_centerX || index == R.styleable.background_bl_unPressed_gradient_centerX || index == R.styleable.background_bl_focused_gradient_centerX || index == R.styleable.background_bl_unFocused_gradient_centerX) {
                            int i5 = this.gradientState;
                            if (i5 == -1) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (i5 == 16842911 && index == R.styleable.background_bl_checkable_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == 16842912 && index == R.styleable.background_bl_checked_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842912 && index == R.styleable.background_bl_unChecked_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == 16842910 && index == R.styleable.background_bl_enabled_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == 16842913 && index == R.styleable.background_bl_selected_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842913 && index == R.styleable.background_bl_unSelected_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == 16842919 && index == R.styleable.background_bl_pressed_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842919 && index == R.styleable.background_bl_unPressed_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == 16842908 && index == R.styleable.background_bl_focused_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842908 && index == R.styleable.background_bl_unFocused_gradient_centerX) {
                                f2 = this.typedArray.getFloat(index, -1.0f);
                            }
                            f3 = f2;
                        } else if (index == R.styleable.background_bl_gradient_centerY || index == R.styleable.background_bl_checkable_gradient_centerY || index == R.styleable.background_bl_unCheckable_gradient_centerY || index == R.styleable.background_bl_checked_gradient_centerY || index == R.styleable.background_bl_unChecked_gradient_centerY || index == R.styleable.background_bl_enabled_gradient_centerY || index == R.styleable.background_bl_unEnabled_gradient_centerY || index == R.styleable.background_bl_selected_gradient_centerY || index == R.styleable.background_bl_unSelected_gradient_centerY || index == R.styleable.background_bl_pressed_gradient_centerY || index == R.styleable.background_bl_unPressed_gradient_centerY || index == R.styleable.background_bl_focused_gradient_centerY || index == R.styleable.background_bl_unFocused_gradient_centerY) {
                            int i6 = this.gradientState;
                            if (i6 == -1) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (i6 == 16842911 && index == R.styleable.background_bl_checkable_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == 16842912 && index == R.styleable.background_bl_checked_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842912 && index == R.styleable.background_bl_unChecked_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == 16842910 && index == R.styleable.background_bl_enabled_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == 16842913 && index == R.styleable.background_bl_selected_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842913 && index == R.styleable.background_bl_unSelected_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == 16842919 && index == R.styleable.background_bl_pressed_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842919 && index == R.styleable.background_bl_unPressed_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == 16842908 && index == R.styleable.background_bl_focused_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            } else if (this.gradientState == -16842908 && index == R.styleable.background_bl_unFocused_gradient_centerY) {
                                f4 = this.typedArray.getFloat(index, -1.0f);
                            }
                        } else if (index == R.styleable.background_bl_gradient_centerColor || index == R.styleable.background_bl_checkable_gradient_centerColor || index == R.styleable.background_bl_unCheckable_gradient_centerColor || index == R.styleable.background_bl_checked_gradient_centerColor || index == R.styleable.background_bl_unChecked_gradient_centerColor || index == R.styleable.background_bl_enabled_gradient_centerColor || index == R.styleable.background_bl_unEnabled_gradient_centerColor || index == R.styleable.background_bl_selected_gradient_centerColor || index == R.styleable.background_bl_unSelected_gradient_centerColor || index == R.styleable.background_bl_pressed_gradient_centerColor || index == R.styleable.background_bl_unPressed_gradient_centerColor || index == R.styleable.background_bl_focused_gradient_centerColor || index == R.styleable.background_bl_unFocused_gradient_centerColor) {
                            int i7 = this.gradientState;
                            if (i7 == -1) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (i7 == 16842911 && index == R.styleable.background_bl_checkable_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842912 && index == R.styleable.background_bl_checked_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842912 && index == R.styleable.background_bl_unChecked_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842910 && index == R.styleable.background_bl_enabled_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842913 && index == R.styleable.background_bl_selected_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842913 && index == R.styleable.background_bl_unSelected_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842919 && index == R.styleable.background_bl_pressed_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842919 && index == R.styleable.background_bl_unPressed_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842908 && index == R.styleable.background_bl_focused_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842908 && index == R.styleable.background_bl_unFocused_gradient_centerColor) {
                                color3 = this.typedArray.getColor(index, 0);
                            }
                        } else if (index == R.styleable.background_bl_gradient_endColor || index == R.styleable.background_bl_checkable_gradient_endColor || index == R.styleable.background_bl_unCheckable_gradient_endColor || index == R.styleable.background_bl_checked_gradient_endColor || index == R.styleable.background_bl_unChecked_gradient_endColor || index == R.styleable.background_bl_enabled_gradient_endColor || index == R.styleable.background_bl_unEnabled_gradient_endColor || index == R.styleable.background_bl_selected_gradient_endColor || index == R.styleable.background_bl_unSelected_gradient_endColor || index == R.styleable.background_bl_pressed_gradient_endColor || index == R.styleable.background_bl_unPressed_gradient_endColor || index == R.styleable.background_bl_focused_gradient_endColor || index == R.styleable.background_bl_unFocused_gradient_endColor) {
                            int i8 = this.gradientState;
                            if (i8 == -1) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (i8 == 16842911 && index == R.styleable.background_bl_checkable_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842912 && index == R.styleable.background_bl_checked_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842912 && index == R.styleable.background_bl_unChecked_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842910 && index == R.styleable.background_bl_enabled_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842913 && index == R.styleable.background_bl_selected_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842913 && index == R.styleable.background_bl_unSelected_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842919 && index == R.styleable.background_bl_pressed_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842919 && index == R.styleable.background_bl_unPressed_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842908 && index == R.styleable.background_bl_focused_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842908 && index == R.styleable.background_bl_unFocused_gradient_endColor) {
                                color5 = this.typedArray.getColor(index, 0);
                            }
                        } else if (index == R.styleable.background_bl_gradient_startColor || index == R.styleable.background_bl_checkable_gradient_startColor || index == R.styleable.background_bl_unCheckable_gradient_startColor || index == R.styleable.background_bl_checked_gradient_startColor || index == R.styleable.background_bl_unChecked_gradient_startColor || index == R.styleable.background_bl_enabled_gradient_startColor || index == R.styleable.background_bl_unEnabled_gradient_startColor || index == R.styleable.background_bl_selected_gradient_startColor || index == R.styleable.background_bl_unSelected_gradient_startColor || index == R.styleable.background_bl_pressed_gradient_startColor || index == R.styleable.background_bl_unPressed_gradient_startColor || index == R.styleable.background_bl_focused_gradient_startColor || index == R.styleable.background_bl_unFocused_gradient_startColor) {
                            int i9 = this.gradientState;
                            if (i9 == -1) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (i9 == 16842911 && index == R.styleable.background_bl_checkable_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842912 && index == R.styleable.background_bl_checked_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842912 && index == R.styleable.background_bl_unChecked_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842910 && index == R.styleable.background_bl_enabled_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842913 && index == R.styleable.background_bl_selected_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842913 && index == R.styleable.background_bl_unSelected_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842919 && index == R.styleable.background_bl_pressed_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842919 && index == R.styleable.background_bl_unPressed_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == 16842908 && index == R.styleable.background_bl_focused_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            } else if (this.gradientState == -16842908 && index == R.styleable.background_bl_unFocused_gradient_startColor) {
                                color4 = this.typedArray.getColor(index, 0);
                            }
                        } else if (index == R.styleable.background_bl_gradient_gradientRadius || index == R.styleable.background_bl_checkable_gradient_gradientRadius || index == R.styleable.background_bl_unCheckable_gradient_gradientRadius || index == R.styleable.background_bl_checked_gradient_gradientRadius || index == R.styleable.background_bl_unChecked_gradient_gradientRadius || index == R.styleable.background_bl_enabled_gradient_gradientRadius || index == R.styleable.background_bl_unEnabled_gradient_gradientRadius || index == R.styleable.background_bl_selected_gradient_gradientRadius || index == R.styleable.background_bl_unSelected_gradient_gradientRadius || index == R.styleable.background_bl_pressed_gradient_gradientRadius || index == R.styleable.background_bl_unPressed_gradient_gradientRadius || index == R.styleable.background_bl_focused_gradient_gradientRadius || index == R.styleable.background_bl_unFocused_gradient_gradientRadius) {
                            int i10 = this.gradientState;
                            if (i10 == -1) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (i10 == 16842911 && index == R.styleable.background_bl_checkable_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (this.gradientState == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (this.gradientState == 16842912 && index == R.styleable.background_bl_checked_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (this.gradientState == -16842912 && index == R.styleable.background_bl_unChecked_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (this.gradientState == 16842910 && index == R.styleable.background_bl_enabled_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (this.gradientState == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (this.gradientState == 16842913 && index == R.styleable.background_bl_selected_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (this.gradientState == -16842913 && index == R.styleable.background_bl_unSelected_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (this.gradientState == 16842919 && index == R.styleable.background_bl_pressed_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (this.gradientState == -16842919 && index == R.styleable.background_bl_unPressed_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (this.gradientState == 16842908 && index == R.styleable.background_bl_focused_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            } else if (this.gradientState == -16842908 && index == R.styleable.background_bl_unFocused_gradient_gradientRadius) {
                                gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                            }
                        } else if (index == R.styleable.background_bl_gradient_type || index == R.styleable.background_bl_checkable_gradient_type || index == R.styleable.background_bl_unCheckable_gradient_type || index == R.styleable.background_bl_checked_gradient_type || index == R.styleable.background_bl_unChecked_gradient_type || index == R.styleable.background_bl_enabled_gradient_type || index == R.styleable.background_bl_unEnabled_gradient_type || index == R.styleable.background_bl_selected_gradient_type || index == R.styleable.background_bl_unSelected_gradient_type || index == R.styleable.background_bl_pressed_gradient_type || index == R.styleable.background_bl_unPressed_gradient_type || index == R.styleable.background_bl_focused_gradient_type || index == R.styleable.background_bl_unFocused_gradient_type) {
                            int i11 = this.gradientState;
                            if (i11 == -1) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (i11 == 16842911 && index == R.styleable.background_bl_checkable_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (this.gradientState == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (this.gradientState == 16842912 && index == R.styleable.background_bl_checked_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (this.gradientState == -16842912 && index == R.styleable.background_bl_unChecked_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (this.gradientState == 16842910 && index == R.styleable.background_bl_enabled_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (this.gradientState == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (this.gradientState == 16842913 && index == R.styleable.background_bl_selected_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (this.gradientState == -16842913 && index == R.styleable.background_bl_unSelected_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (this.gradientState == 16842919 && index == R.styleable.background_bl_pressed_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (this.gradientState == -16842919 && index == R.styleable.background_bl_unPressed_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (this.gradientState == 16842908 && index == R.styleable.background_bl_focused_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            } else if (this.gradientState == -16842908 && index == R.styleable.background_bl_unFocused_gradient_type) {
                                i3 = this.typedArray.getInt(index, 0);
                            }
                            int i12 = i3;
                            gradientDrawable.setGradientType(i12);
                            i3 = i12;
                        } else if (index == R.styleable.background_bl_gradient_useLevel || index == R.styleable.background_bl_checkable_gradient_useLevel || index == R.styleable.background_bl_unCheckable_gradient_useLevel || index == R.styleable.background_bl_checked_gradient_useLevel || index == R.styleable.background_bl_unChecked_gradient_useLevel || index == R.styleable.background_bl_enabled_gradient_useLevel || index == R.styleable.background_bl_unEnabled_gradient_useLevel || index == R.styleable.background_bl_selected_gradient_useLevel || index == R.styleable.background_bl_unSelected_gradient_useLevel || index == R.styleable.background_bl_pressed_gradient_useLevel || index == R.styleable.background_bl_unPressed_gradient_useLevel || index == R.styleable.background_bl_focused_gradient_useLevel || index == R.styleable.background_bl_unFocused_gradient_useLevel) {
                            int i13 = this.gradientState;
                            if (i13 == -1) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (i13 == 16842911 && index == R.styleable.background_bl_checkable_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (this.gradientState == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (this.gradientState == 16842912 && index == R.styleable.background_bl_checked_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (this.gradientState == -16842912 && index == R.styleable.background_bl_unChecked_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (this.gradientState == 16842910 && index == R.styleable.background_bl_enabled_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (this.gradientState == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (this.gradientState == 16842913 && index == R.styleable.background_bl_selected_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (this.gradientState == -16842913 && index == R.styleable.background_bl_unSelected_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (this.gradientState == 16842919 && index == R.styleable.background_bl_pressed_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (this.gradientState == -16842919 && index == R.styleable.background_bl_unPressed_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (this.gradientState == 16842908 && index == R.styleable.background_bl_focused_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            } else if (this.gradientState == -16842908 && index == R.styleable.background_bl_unFocused_gradient_useLevel) {
                                gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                            }
                        } else if (index == R.styleable.background_bl_padding_left) {
                            rect.left = (int) this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_padding_top) {
                            rect.top = (int) this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_padding_right) {
                            rect.right = (int) this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_padding_bottom) {
                            rect.bottom = (int) this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_size_width) {
                            dimension = this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_size_height) {
                            dimension2 = this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_stroke_width) {
                            dimension3 = this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_stroke_color) {
                            color2 = this.typedArray.getColor(index, 0);
                        } else if (index == R.styleable.background_bl_stroke_dashWidth) {
                            dimension4 = this.typedArray.getDimension(index, 0.0f);
                        } else if (index == R.styleable.background_bl_stroke_dashGap) {
                            dimension5 = this.typedArray.getDimension(index, 0.0f);
                        }
                    }
                    f3 = f;
                }
                i2++;
                i = 0;
            }
            f = f3;
            f3 = f;
            i2++;
            i = 0;
        }
        float f5 = f3;
        if (hasSetRadius(fArr)) {
            gradientDrawable.setCornerRadii(fArr);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_size_width) && this.typedArray.hasValue(R.styleable.background_bl_size_height)) {
            gradientDrawable.setSize((int) dimension, (int) dimension2);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.typedArray.hasValue(R.styleable.background_bl_pressed_solid_color)) {
                arrayList.add(Integer.valueOf(android.R.attr.state_pressed));
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_pressed_solid_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_unPressed_solid_color)) {
                arrayList.add(-16842919);
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unPressed_solid_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_checkable_solid_color)) {
                arrayList.add(Integer.valueOf(android.R.attr.state_checkable));
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checkable_solid_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_unCheckable_solid_color)) {
                arrayList.add(-16842911);
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unCheckable_solid_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_checked_solid_color)) {
                arrayList.add(Integer.valueOf(android.R.attr.state_checked));
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checked_solid_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_unChecked_solid_color)) {
                arrayList.add(-16842912);
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unChecked_solid_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_enabled_solid_color)) {
                arrayList.add(Integer.valueOf(android.R.attr.state_enabled));
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_enabled_solid_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_unEnabled_solid_color)) {
                arrayList.add(-16842910);
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unEnabled_solid_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_selected_solid_color)) {
                arrayList.add(Integer.valueOf(android.R.attr.state_selected));
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_selected_solid_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_unSelected_solid_color)) {
                arrayList.add(-16842913);
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unSelected_solid_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_focused_solid_color)) {
                arrayList.add(Integer.valueOf(android.R.attr.state_focused));
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_focused_solid_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_unFocused_solid_color)) {
                arrayList.add(-16842908);
                arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unFocused_solid_color, 0)));
            }
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                if (this.typedArray.hasValue(R.styleable.background_bl_solid_color)) {
                    size++;
                }
                int[][] iArr = new int[size][];
                int[] iArr2 = new int[size];
                Iterator it = arrayList.iterator();
                int i14 = 0;
                while (it.hasNext()) {
                    iArr[i14] = new int[]{((Integer) it.next()).intValue()};
                    iArr2[i14] = ((Integer) arrayList2.get(i14)).intValue();
                    i14++;
                }
                if (this.typedArray.hasValue(R.styleable.background_bl_solid_color)) {
                    iArr[i14] = new int[0];
                    iArr2[i14] = color;
                }
                gradientDrawable.setColor(new ColorStateList(iArr, iArr2));
            } else if (this.typedArray.hasValue(R.styleable.background_bl_solid_color)) {
                gradientDrawable.setColor(color);
            }
        } else if (this.typedArray.hasValue(R.styleable.background_bl_solid_color)) {
            gradientDrawable.setColor(color);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_stroke_width)) {
            if (Build.VERSION.SDK_INT >= 21) {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                if (this.typedArray.hasValue(R.styleable.background_bl_pressed_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unPressed_stroke_color)) {
                    arrayList3.add(Integer.valueOf(android.R.attr.state_pressed));
                    arrayList3.add(-16842919);
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_pressed_stroke_color, 0)));
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unPressed_stroke_color, 0)));
                }
                if (this.typedArray.hasValue(R.styleable.background_bl_checkable_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unCheckable_stroke_color)) {
                    arrayList3.add(Integer.valueOf(android.R.attr.state_checkable));
                    arrayList3.add(-16842911);
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checkable_stroke_color, 0)));
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unCheckable_stroke_color, 0)));
                }
                if (this.typedArray.hasValue(R.styleable.background_bl_checked_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unChecked_stroke_color)) {
                    arrayList3.add(Integer.valueOf(android.R.attr.state_checked));
                    arrayList3.add(-16842912);
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checked_stroke_color, 0)));
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unChecked_stroke_color, 0)));
                }
                if (this.typedArray.hasValue(R.styleable.background_bl_enabled_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unEnabled_stroke_color)) {
                    arrayList3.add(Integer.valueOf(android.R.attr.state_enabled));
                    arrayList3.add(-16842910);
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_enabled_stroke_color, 0)));
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unEnabled_stroke_color, 0)));
                }
                if (this.typedArray.hasValue(R.styleable.background_bl_selected_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unSelected_stroke_color)) {
                    arrayList3.add(Integer.valueOf(android.R.attr.state_selected));
                    arrayList3.add(-16842913);
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_selected_stroke_color, 0)));
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unSelected_stroke_color, 0)));
                }
                if (this.typedArray.hasValue(R.styleable.background_bl_focused_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unFocused_stroke_color)) {
                    arrayList3.add(Integer.valueOf(android.R.attr.state_focused));
                    arrayList3.add(-16842908);
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_focused_stroke_color, 0)));
                    arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unFocused_stroke_color, 0)));
                }
                if (arrayList3.size() > 0) {
                    int[][] iArr3 = new int[arrayList3.size()][];
                    int[] iArr4 = new int[arrayList3.size()];
                    Iterator it2 = arrayList3.iterator();
                    int i15 = 0;
                    while (it2.hasNext()) {
                        iArr3[i15] = new int[]{((Integer) it2.next()).intValue()};
                        iArr4[i15] = ((Integer) arrayList4.get(i15)).intValue();
                        i15++;
                    }
                    gradientDrawable.setStroke((int) dimension3, new ColorStateList(iArr3, iArr4), dimension4, dimension5);
                } else if (this.typedArray.hasValue(R.styleable.background_bl_stroke_color)) {
                    gradientDrawable.setStroke((int) dimension3, color2, dimension4, dimension5);
                }
            } else if (this.typedArray.hasValue(R.styleable.background_bl_stroke_color)) {
                gradientDrawable.setStroke((int) dimension3, color2, dimension4, dimension5);
            }
        }
        if ((this.typedArray.hasValue(R.styleable.background_bl_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_checkable_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unCheckable_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_checked_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unChecked_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_enabled_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unEnabled_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_selected_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unSelected_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_pressed_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unPressed_gradient_centerY)) || (this.typedArray.hasValue(R.styleable.background_bl_focused_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unFocused_gradient_centerY)))))))) {
            gradientDrawable.setGradientCenter(f5, f4);
        }
        if ((this.typedArray.hasValue(R.styleable.background_bl_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_checkable_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unCheckable_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_checked_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unChecked_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_enabled_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unEnabled_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_selected_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unSelected_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_pressed_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unPressed_gradient_endColor)) || (this.typedArray.hasValue(R.styleable.background_bl_focused_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unFocused_gradient_endColor) && Build.VERSION.SDK_INT >= 16))))))) {
            gradientDrawable.setColors(this.typedArray.hasValue(R.styleable.background_bl_gradient_centerColor) ? new int[]{color4, color3, color5} : new int[]{color4, color5});
        }
        if (i3 == 0 && Build.VERSION.SDK_INT >= 16 && (this.typedArray.hasValue(R.styleable.background_bl_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_checkable_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_checked_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_enabled_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_selected_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_pressed_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_focused_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unCheckable_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unChecked_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unEnabled_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unSelected_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unPressed_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unFocused_gradient_angle))) {
            int i16 = integer % 360;
            if (i16 % 45 != 0) {
                throw new XmlPullParserException(this.typedArray.getPositionDescription() + "<gradient> tag requires 'angle' attribute to be a multiple of 45");
            }
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            if (i16 == 0) {
                orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            } else if (i16 == 45) {
                orientation = GradientDrawable.Orientation.BL_TR;
            } else if (i16 == 90) {
                orientation = GradientDrawable.Orientation.BOTTOM_TOP;
            } else if (i16 == 135) {
                orientation = GradientDrawable.Orientation.BR_TL;
            } else if (i16 == 180) {
                orientation = GradientDrawable.Orientation.RIGHT_LEFT;
            } else if (i16 == 225) {
                orientation = GradientDrawable.Orientation.TR_BL;
            } else if (i16 == 270) {
                orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            } else if (i16 == 315) {
                orientation = GradientDrawable.Orientation.TL_BR;
            }
            gradientDrawable.setOrientation(orientation);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_padding_left) && this.typedArray.hasValue(R.styleable.background_bl_padding_top) && this.typedArray.hasValue(R.styleable.background_bl_padding_right) && this.typedArray.hasValue(R.styleable.background_bl_padding_bottom)) {
            if (Build.VERSION.SDK_INT >= 29) {
                gradientDrawable.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            } else {
                try {
                    Field declaredField = gradientDrawable.getClass().getDeclaredField("mPadding");
                    declaredField.setAccessible(true);
                    declaredField.set(gradientDrawable, rect);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return gradientDrawable;
    }

    private boolean hasSetRadius(float[] fArr) {
        for (float f : fArr) {
            if (f != 0.0f) {
                return true;
            }
        }
        return false;
    }
}
