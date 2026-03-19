package com.noober.background.drawable;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DrawableCreator {

    public enum DrawablePosition {
        Left,
        Right,
        Top,
        Bottom
    }

    public enum Shape {
        Rectangle(0),
        Oval(1),
        Line(2),
        Ring(3);

        int value;

        Shape(int i) {
            this.value = i;
        }
    }

    public enum Gradient {
        Linear(0),
        Radial(1),
        Sweep(2);

        int value;

        Gradient(int i) {
            this.value = i;
        }
    }

    public static class Builder {
        private Drawable checkableDrawable;
        private Integer checkableSolidColor;
        private Integer checkableStrokeColor;
        private Integer checkableTextColor;
        private Drawable checkedDrawable;
        private Integer checkedSolidColor;
        private Integer checkedStrokeColor;
        private Integer checkedTextColor;
        private Float cornersBottomLeftRadius;
        private Float cornersBottomRightRadius;
        private Float cornersRadius;
        private Float cornersTopLeftRadius;
        private Float cornersTopRightRadius;
        private Drawable enabledDrawable;
        private Integer enabledSolidColor;
        private Integer enabledStrokeColor;
        private Integer enabledTextColor;
        private Drawable focusedActivated;
        private Drawable focusedDrawable;
        private Drawable focusedHovered;
        private Integer focusedSolidColor;
        private Integer focusedStrokeColor;
        private Integer focusedTextColor;
        private Integer gradientCenterColor;
        private Float gradientCenterX;
        private Float gradientCenterY;
        private Integer gradientEndColor;
        private Float gradientRadius;
        private Integer gradientStartColor;
        private Drawable pressedDrawable;
        private Integer pressedSolidColor;
        private Integer pressedStrokeColor;
        private Integer pressedTextColor;
        private Integer rippleColor;
        private Drawable selectedDrawable;
        private Integer selectedSolidColor;
        private Integer selectedStrokeColor;
        private Integer selectedTextColor;
        private Float sizeHeight;
        private Float sizeWidth;
        private Integer solidColor;
        private Integer strokeColor;
        private Float strokeWidth;
        private int textColorCount;
        private Drawable unCheckableDrawable;
        private Integer unCheckableSolidColor;
        private Integer unCheckableStrokeColor;
        private Integer unCheckableTextColor;
        private Drawable unCheckedDrawable;
        private Integer unCheckedSolidColor;
        private Integer unCheckedStrokeColor;
        private Integer unCheckedTextColor;
        private Drawable unEnabledDrawable;
        private Integer unEnabledSolidColor;
        private Integer unEnabledStrokeColor;
        private Integer unEnabledTextColor;
        private Drawable unFocusedActivated;
        private Drawable unFocusedDrawable;
        private Drawable unFocusedHovered;
        private Integer unFocusedSolidColor;
        private Integer unFocusedStrokeColor;
        private Integer unFocusedTextColor;
        private Drawable unPressedDrawable;
        private Integer unPressedSolidColor;
        private Integer unPressedStrokeColor;
        private Integer unPressedTextColor;
        private Drawable unSelectedDrawable;
        private Integer unSelectedSolidColor;
        private Integer unSelectedStrokeColor;
        private Integer unSelectedTextColor;
        private Shape shape = Shape.Rectangle;
        private int gradientAngle = -1;
        private Gradient gradient = Gradient.Linear;
        private boolean useLevel = false;
        private Rect padding = new Rect();
        private boolean hasSetPadding = false;
        private float strokeDashWidth = 0.0f;
        private float strokeDashGap = 0.0f;
        private boolean rippleEnable = false;
        private float alpha = -1.0f;
        private boolean hasSelectDrawable = false;
        private GradientDrawable baseGradientDrawable = null;
        private StateListDrawable baseStateListDrawable = null;

        public Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
        }

        public Builder setShapeAlpha(float f) {
            this.alpha = f;
            return this;
        }

        public Builder setSolidColor(int i) {
            this.solidColor = Integer.valueOf(i);
            return this;
        }

        public Builder setCornersRadius(float f) {
            this.cornersRadius = Float.valueOf(f);
            return this;
        }

        public Builder setCornersRadius(float f, float f2, float f3, float f4) {
            this.cornersBottomLeftRadius = Float.valueOf(f);
            this.cornersBottomRightRadius = Float.valueOf(f2);
            this.cornersTopLeftRadius = Float.valueOf(f3);
            this.cornersTopRightRadius = Float.valueOf(f4);
            return this;
        }

        public Builder setGradientAngle(int i) {
            this.gradientAngle = i;
            return this;
        }

        public Builder setGradientCenterXY(float f, float f2) {
            this.gradientCenterX = Float.valueOf(f);
            this.gradientCenterY = Float.valueOf(f2);
            return this;
        }

        public Builder setGradientColor(int i, int i2) {
            this.gradientStartColor = Integer.valueOf(i);
            this.gradientEndColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setGradientColor(int i, int i2, int i3) {
            this.gradientStartColor = Integer.valueOf(i);
            this.gradientCenterColor = Integer.valueOf(i2);
            this.gradientEndColor = Integer.valueOf(i3);
            return this;
        }

        public Builder setGradientRadius(float f) {
            this.gradientRadius = Float.valueOf(f);
            return this;
        }

        public Builder setGradient(Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public Builder setUseLevel(boolean z) {
            this.useLevel = z;
            return this;
        }

        public Builder setPadding(float f, float f2, float f3, float f4) {
            this.hasSetPadding = true;
            this.padding.left = (int) f;
            this.padding.top = (int) f2;
            this.padding.right = (int) f3;
            this.padding.bottom = (int) f4;
            return this;
        }

        public Builder setSizeWidth(float f) {
            this.sizeWidth = Float.valueOf(f);
            return this;
        }

        public Builder setSizeHeight(float f) {
            this.sizeHeight = Float.valueOf(f);
            return this;
        }

        public Builder setStrokeWidth(float f) {
            this.strokeWidth = Float.valueOf(f);
            return this;
        }

        public Builder setStrokeColor(int i) {
            this.strokeColor = Integer.valueOf(i);
            return this;
        }

        public Builder setStrokeDashWidth(float f) {
            this.strokeDashWidth = f;
            return this;
        }

        public Builder setStrokeDashGap(float f) {
            this.strokeDashGap = f;
            return this;
        }

        public Builder setRipple(boolean z, int i) {
            this.rippleEnable = z;
            this.rippleColor = Integer.valueOf(i);
            return this;
        }

        public Builder setCheckableStrokeColor(int i, int i2) {
            this.checkableStrokeColor = Integer.valueOf(i);
            this.unCheckableStrokeColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setCheckedStrokeColor(int i, int i2) {
            this.checkedStrokeColor = Integer.valueOf(i);
            this.unCheckedStrokeColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setEnabledStrokeColor(int i, int i2) {
            this.enabledStrokeColor = Integer.valueOf(i);
            this.unEnabledStrokeColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setSelectedStrokeColor(int i, int i2) {
            this.selectedStrokeColor = Integer.valueOf(i);
            this.unSelectedStrokeColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setPressedStrokeColor(int i, int i2) {
            this.pressedStrokeColor = Integer.valueOf(i);
            this.unPressedStrokeColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setFocusedStrokeColor(int i, int i2) {
            this.focusedStrokeColor = Integer.valueOf(i);
            this.unFocusedStrokeColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setCheckableSolidColor(int i, int i2) {
            this.checkableSolidColor = Integer.valueOf(i);
            this.unCheckableSolidColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setCheckedSolidColor(int i, int i2) {
            this.checkedSolidColor = Integer.valueOf(i);
            this.unCheckedSolidColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setEnabledSolidColor(int i, int i2) {
            this.enabledSolidColor = Integer.valueOf(i);
            this.unEnabledSolidColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setSelectedSolidColor(int i, int i2) {
            this.selectedSolidColor = Integer.valueOf(i);
            this.unSelectedSolidColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setPressedSolidColor(int i, int i2) {
            this.pressedSolidColor = Integer.valueOf(i);
            this.unPressedSolidColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setFocusedSolidColor(int i, int i2) {
            this.focusedSolidColor = Integer.valueOf(i);
            this.unFocusedSolidColor = Integer.valueOf(i2);
            return this;
        }

        public Builder setCheckableDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.checkableDrawable = drawable;
            return this;
        }

        public Builder setCheckedDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.checkedDrawable = drawable;
            return this;
        }

        public Builder setEnabledDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.enabledDrawable = drawable;
            return this;
        }

        public Builder setSelectedDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.selectedDrawable = drawable;
            return this;
        }

        public Builder setPressedDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.pressedDrawable = drawable;
            return this;
        }

        public Builder setFocusedDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.focusedDrawable = drawable;
            return this;
        }

        public Builder setFocusedHovered(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.focusedHovered = drawable;
            return this;
        }

        public Builder setFocusedActivated(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.focusedActivated = drawable;
            return this;
        }

        public Builder setUnCheckableDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.unCheckableDrawable = drawable;
            return this;
        }

        public Builder setUnCheckedDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.unCheckedDrawable = drawable;
            return this;
        }

        public Builder setUnEnabledDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.unEnabledDrawable = drawable;
            return this;
        }

        public Builder setUnSelectedDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.unSelectedDrawable = drawable;
            return this;
        }

        public Builder setUnPressedDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.unPressedDrawable = drawable;
            return this;
        }

        public Builder setUnFocusedDrawable(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.unFocusedDrawable = drawable;
            return this;
        }

        public Builder setUnFocusedHovered(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.unFocusedHovered = drawable;
            return this;
        }

        public Builder setUnFocusedActivated(Drawable drawable) {
            this.hasSelectDrawable = true;
            this.unFocusedActivated = drawable;
            return this;
        }

        public Builder setCheckableTextColor(int i) {
            this.checkableTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setCheckedTextColor(int i) {
            this.checkedTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setEnabledTextColor(int i) {
            this.enabledTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setSelectedTextColor(int i) {
            this.selectedTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setPressedTextColor(int i) {
            this.pressedTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setFocusedTextColor(int i) {
            this.focusedTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setUnCheckableTextColor(int i) {
            this.unCheckableTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setUnCheckedTextColor(int i) {
            this.unCheckedTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setUnEnabledTextColor(int i) {
            this.unEnabledTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setUnSelectedTextColor(int i) {
            this.unSelectedTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setUnPressedTextColor(int i) {
            this.unPressedTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setUnFocusedTextColor(int i) {
            this.unFocusedTextColor = Integer.valueOf(i);
            this.textColorCount++;
            return this;
        }

        public Builder setBaseGradientDrawable(GradientDrawable gradientDrawable) {
            this.baseGradientDrawable = gradientDrawable;
            return this;
        }

        public Builder setBaseStateListDrawable(StateListDrawable stateListDrawable) {
            this.baseStateListDrawable = stateListDrawable;
            return this;
        }

        public Drawable build() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            StateListDrawable stateListDrawable;
            GradientDrawable gradientDrawable = null;
            if (this.hasSelectDrawable) {
                stateListDrawable = getStateListDrawable();
            } else {
                gradientDrawable = getGradientDrawable();
                stateListDrawable = null;
            }
            if (this.rippleEnable && this.rippleColor != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (stateListDrawable != null) {
                        gradientDrawable = stateListDrawable;
                    }
                    return new RippleDrawable(ColorStateList.valueOf(this.rippleColor.intValue()), gradientDrawable, gradientDrawable);
                }
                StateListDrawable stateListDrawable2 = new StateListDrawable();
                GradientDrawable gradientDrawable2 = getGradientDrawable();
                gradientDrawable2.setColor(this.rippleColor.intValue());
                stateListDrawable2.addState(new int[]{-16842919}, gradientDrawable);
                stateListDrawable2.addState(new int[]{R.attr.state_pressed}, gradientDrawable2);
                return stateListDrawable2;
            }
            if (gradientDrawable == null) {
                gradientDrawable = stateListDrawable;
            }
            float f = this.alpha;
            if (f != -1.0f) {
                if (f >= 1.0f) {
                    this.alpha = 255.0f;
                } else if (f <= 0.0f) {
                    this.alpha = 0.0f;
                } else {
                    this.alpha = f * 255.0f;
                }
                gradientDrawable.setAlpha((int) this.alpha);
            }
            return gradientDrawable;
        }

        public ColorStateList buildTextColor() {
            if (this.textColorCount > 0) {
                return getColorStateList();
            }
            return null;
        }

        private ColorStateList getColorStateList() {
            int i;
            int i2 = this.textColorCount;
            int[][] iArr = new int[i2][];
            int[] iArr2 = new int[i2];
            Integer num = this.checkableTextColor;
            if (num != null) {
                iArr[0] = new int[]{R.attr.state_checkable};
                iArr2[0] = num.intValue();
                i = 1;
            } else {
                i = 0;
            }
            Integer num2 = this.unCheckableTextColor;
            if (num2 != null) {
                iArr[i] = new int[]{-16842911};
                iArr2[i] = num2.intValue();
                i++;
            }
            Integer num3 = this.checkedTextColor;
            if (num3 != null) {
                iArr[i] = new int[]{R.attr.state_checked};
                iArr2[i] = num3.intValue();
                i++;
            }
            Integer num4 = this.unCheckedTextColor;
            if (num4 != null) {
                iArr[i] = new int[]{-16842912};
                iArr2[i] = num4.intValue();
                i++;
            }
            Integer num5 = this.enabledTextColor;
            if (num5 != null) {
                iArr[i] = new int[]{R.attr.state_enabled};
                iArr2[i] = num5.intValue();
                i++;
            }
            Integer num6 = this.unEnabledTextColor;
            if (num6 != null) {
                iArr[i] = new int[]{-16842910};
                iArr2[i] = num6.intValue();
                i++;
            }
            Integer num7 = this.selectedTextColor;
            if (num7 != null) {
                iArr[i] = new int[]{R.attr.state_selected};
                iArr2[i] = num7.intValue();
                i++;
            }
            Integer num8 = this.unSelectedTextColor;
            if (num8 != null) {
                iArr[i] = new int[]{-16842913};
                iArr2[i] = num8.intValue();
                i++;
            }
            Integer num9 = this.pressedTextColor;
            if (num9 != null) {
                iArr[i] = new int[]{R.attr.state_pressed};
                iArr2[i] = num9.intValue();
                i++;
            }
            Integer num10 = this.unPressedTextColor;
            if (num10 != null) {
                iArr[i] = new int[]{-16842919};
                iArr2[i] = num10.intValue();
                i++;
            }
            Integer num11 = this.focusedTextColor;
            if (num11 != null) {
                iArr[i] = new int[]{R.attr.state_focused};
                iArr2[i] = num11.intValue();
                i++;
            }
            Integer num12 = this.unFocusedTextColor;
            if (num12 != null) {
                iArr[i] = new int[]{-16842908};
                iArr2[i] = num12.intValue();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private StateListDrawable getStateListDrawable() {
            StateListDrawable stateListDrawable = this.baseStateListDrawable;
            if (this.checkableDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{R.attr.state_checkable}, this.checkableDrawable);
            }
            if (this.unCheckableDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{-16842911}, this.unCheckableDrawable);
            }
            if (this.checkedDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{R.attr.state_checked}, this.checkedDrawable);
            }
            if (this.unCheckedDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{-16842912}, this.unCheckedDrawable);
            }
            if (this.enabledDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{R.attr.state_enabled}, this.enabledDrawable);
            }
            if (this.unEnabledDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{-16842910}, this.unEnabledDrawable);
            }
            if (this.selectedDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{R.attr.state_selected}, this.selectedDrawable);
            }
            if (this.unSelectedDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{-16842913}, this.unSelectedDrawable);
            }
            if (this.pressedDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.pressedDrawable);
            }
            if (this.unPressedDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{-16842919}, this.unPressedDrawable);
            }
            if (this.focusedDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{R.attr.state_focused}, this.focusedDrawable);
            }
            if (this.unFocusedDrawable != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{-16842908}, this.unFocusedDrawable);
            }
            if (this.focusedHovered != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{R.attr.state_hovered}, this.focusedHovered);
            }
            if (this.unFocusedHovered != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{-16843623}, this.unFocusedHovered);
            }
            if (this.focusedActivated != null) {
                stateListDrawable = getStateListDrawable(stateListDrawable);
                stateListDrawable.addState(new int[]{R.attr.state_activated}, this.focusedActivated);
            }
            if (this.unFocusedActivated == null) {
                return stateListDrawable;
            }
            StateListDrawable stateListDrawable2 = getStateListDrawable(stateListDrawable);
            stateListDrawable2.addState(new int[]{-16843518}, this.unFocusedActivated);
            return stateListDrawable2;
        }

        private GradientDrawable getGradientDrawable() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            int i;
            Float f;
            GradientDrawable gradientDrawable = this.baseGradientDrawable;
            if (gradientDrawable == null) {
                gradientDrawable = new GradientDrawable();
            }
            GradientDrawable gradientDrawable2 = gradientDrawable;
            gradientDrawable2.setShape(this.shape.value);
            Float f2 = this.cornersRadius;
            if (f2 != null) {
                gradientDrawable2.setCornerRadius(f2.floatValue());
            }
            if (this.cornersBottomLeftRadius != null && this.cornersBottomRightRadius != null && (f = this.cornersTopLeftRadius) != null && this.cornersTopRightRadius != null) {
                gradientDrawable2.setCornerRadii(new float[]{f.floatValue(), this.cornersTopLeftRadius.floatValue(), this.cornersTopRightRadius.floatValue(), this.cornersTopRightRadius.floatValue(), this.cornersBottomRightRadius.floatValue(), this.cornersBottomRightRadius.floatValue(), this.cornersBottomLeftRadius.floatValue(), this.cornersBottomLeftRadius.floatValue()});
            }
            if (this.gradient == Gradient.Linear && (i = this.gradientAngle) != -1) {
                int i2 = i % 360;
                this.gradientAngle = i2;
                if (i2 % 45 == 0) {
                    GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                    int i3 = this.gradientAngle;
                    if (i3 == 0) {
                        orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                    } else if (i3 == 45) {
                        orientation = GradientDrawable.Orientation.BL_TR;
                    } else if (i3 == 90) {
                        orientation = GradientDrawable.Orientation.BOTTOM_TOP;
                    } else if (i3 == 135) {
                        orientation = GradientDrawable.Orientation.BR_TL;
                    } else if (i3 == 180) {
                        orientation = GradientDrawable.Orientation.RIGHT_LEFT;
                    } else if (i3 == 225) {
                        orientation = GradientDrawable.Orientation.TR_BL;
                    } else if (i3 == 270) {
                        orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                    } else if (i3 == 315) {
                        orientation = GradientDrawable.Orientation.TL_BR;
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        gradientDrawable2.setOrientation(orientation);
                    }
                }
            }
            Float f3 = this.gradientCenterX;
            if (f3 != null && this.gradientCenterY != null) {
                gradientDrawable2.setGradientCenter(f3.floatValue(), this.gradientCenterY.floatValue());
            }
            Integer num = this.gradientStartColor;
            if (num != null && this.gradientEndColor != null) {
                int[] iArr = this.gradientCenterColor != null ? new int[]{num.intValue(), this.gradientCenterColor.intValue(), this.gradientEndColor.intValue()} : new int[]{num.intValue(), this.gradientEndColor.intValue()};
                if (Build.VERSION.SDK_INT >= 16) {
                    gradientDrawable2.setColors(iArr);
                }
            }
            Float f4 = this.gradientRadius;
            if (f4 != null) {
                gradientDrawable2.setGradientRadius(f4.floatValue());
            }
            gradientDrawable2.setGradientType(this.gradient.value);
            gradientDrawable2.setUseLevel(this.useLevel);
            if (this.hasSetPadding) {
                if (Build.VERSION.SDK_INT >= 29) {
                    gradientDrawable2.setPadding(this.padding.left, this.padding.top, this.padding.right, this.padding.bottom);
                } else {
                    try {
                        Field declaredField = gradientDrawable2.getClass().getDeclaredField("mPadding");
                        declaredField.setAccessible(true);
                        declaredField.set(gradientDrawable2, this.padding);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchFieldException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            Float f5 = this.sizeWidth;
            if (f5 != null && this.sizeHeight != null) {
                gradientDrawable2.setSize(f5.intValue(), this.sizeHeight.intValue());
            }
            Float f6 = this.strokeWidth;
            if (f6 != null && f6.floatValue() > 0.0f) {
                if (Build.VERSION.SDK_INT >= 21) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    if (this.pressedStrokeColor != null && this.unPressedStrokeColor != null) {
                        arrayList.add(Integer.valueOf(R.attr.state_pressed));
                        arrayList.add(-16842919);
                        arrayList2.add(this.pressedStrokeColor);
                        arrayList2.add(this.unPressedStrokeColor);
                    }
                    if (this.checkableStrokeColor != null && this.unCheckableStrokeColor != null) {
                        arrayList.add(Integer.valueOf(R.attr.state_checkable));
                        arrayList.add(-16842911);
                        arrayList2.add(this.checkableStrokeColor);
                        arrayList2.add(this.unCheckableStrokeColor);
                    }
                    if (this.checkedStrokeColor != null && this.unCheckedStrokeColor != null) {
                        arrayList.add(Integer.valueOf(R.attr.state_checked));
                        arrayList.add(-16842912);
                        arrayList2.add(this.checkedStrokeColor);
                        arrayList2.add(this.unCheckedStrokeColor);
                    }
                    if (this.enabledStrokeColor != null && this.unEnabledStrokeColor != null) {
                        arrayList.add(Integer.valueOf(R.attr.state_enabled));
                        arrayList.add(-16842910);
                        arrayList2.add(this.enabledStrokeColor);
                        arrayList2.add(this.unEnabledStrokeColor);
                    }
                    if (this.selectedStrokeColor != null && this.unSelectedStrokeColor != null) {
                        arrayList.add(Integer.valueOf(R.attr.state_selected));
                        arrayList.add(-16842913);
                        arrayList2.add(this.selectedStrokeColor);
                        arrayList2.add(this.unSelectedStrokeColor);
                    }
                    if (this.focusedStrokeColor != null && this.unFocusedStrokeColor != null) {
                        arrayList.add(Integer.valueOf(R.attr.state_focused));
                        arrayList.add(-16842908);
                        arrayList2.add(this.focusedStrokeColor);
                        arrayList2.add(this.unFocusedStrokeColor);
                    }
                    if (arrayList.size() > 0) {
                        int[][] iArr2 = new int[arrayList.size()][];
                        int[] iArr3 = new int[arrayList.size()];
                        Iterator it = arrayList.iterator();
                        int i4 = 0;
                        while (it.hasNext()) {
                            iArr2[i4] = new int[]{((Integer) it.next()).intValue()};
                            iArr3[i4] = ((Integer) arrayList2.get(i4)).intValue();
                            i4++;
                        }
                        gradientDrawable2.setStroke(this.strokeWidth.intValue(), new ColorStateList(iArr2, iArr3), this.strokeDashWidth, this.strokeDashGap);
                    } else if (this.strokeColor != null) {
                        gradientDrawable2.setStroke(this.strokeWidth.intValue(), this.strokeColor.intValue(), this.strokeDashWidth, this.strokeDashGap);
                    }
                } else if (this.strokeColor != null) {
                    gradientDrawable2.setStroke(this.strokeWidth.intValue(), this.strokeColor.intValue(), this.strokeDashWidth, this.strokeDashGap);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                if (this.pressedSolidColor != null && this.unPressedSolidColor != null) {
                    arrayList3.add(Integer.valueOf(R.attr.state_pressed));
                    arrayList3.add(-16842919);
                    arrayList4.add(this.pressedSolidColor);
                    arrayList4.add(this.unPressedSolidColor);
                }
                if (this.checkableSolidColor != null && this.unCheckableSolidColor != null) {
                    arrayList3.add(Integer.valueOf(R.attr.state_checkable));
                    arrayList3.add(-16842911);
                    arrayList4.add(this.checkableSolidColor);
                    arrayList4.add(this.unCheckableSolidColor);
                }
                if (this.checkedSolidColor != null && this.unCheckedSolidColor != null) {
                    arrayList3.add(Integer.valueOf(R.attr.state_checked));
                    arrayList3.add(-16842912);
                    arrayList4.add(this.checkedSolidColor);
                    arrayList4.add(this.unCheckedSolidColor);
                }
                if (this.enabledSolidColor != null && this.unEnabledSolidColor != null) {
                    arrayList3.add(Integer.valueOf(R.attr.state_enabled));
                    arrayList3.add(-16842910);
                    arrayList4.add(this.enabledSolidColor);
                    arrayList4.add(this.unEnabledSolidColor);
                }
                if (this.selectedSolidColor != null && this.unSelectedSolidColor != null) {
                    arrayList3.add(Integer.valueOf(R.attr.state_selected));
                    arrayList3.add(-16842913);
                    arrayList4.add(this.selectedSolidColor);
                    arrayList4.add(this.unSelectedSolidColor);
                }
                if (this.focusedSolidColor != null && this.unFocusedSolidColor != null) {
                    arrayList3.add(Integer.valueOf(R.attr.state_focused));
                    arrayList3.add(-16842908);
                    arrayList4.add(this.focusedSolidColor);
                    arrayList4.add(this.unFocusedSolidColor);
                }
                if (arrayList3.size() > 0) {
                    int[][] iArr4 = new int[arrayList3.size()][];
                    int[] iArr5 = new int[arrayList3.size()];
                    Iterator it2 = arrayList3.iterator();
                    int i5 = 0;
                    while (it2.hasNext()) {
                        iArr4[i5] = new int[]{((Integer) it2.next()).intValue()};
                        iArr5[i5] = ((Integer) arrayList4.get(i5)).intValue();
                        i5++;
                    }
                    gradientDrawable2.setColor(new ColorStateList(iArr4, iArr5));
                } else {
                    Integer num2 = this.solidColor;
                    if (num2 != null) {
                        gradientDrawable2.setColor(num2.intValue());
                    }
                }
            } else {
                Integer num3 = this.solidColor;
                if (num3 != null) {
                    gradientDrawable2.setColor(num3.intValue());
                }
            }
            return gradientDrawable2;
        }

        StateListDrawable getStateListDrawable(StateListDrawable stateListDrawable) {
            return stateListDrawable == null ? new StateListDrawable() : stateListDrawable;
        }
    }

    public static void setDrawable(Drawable drawable, View view, DrawablePosition drawablePosition) {
        if (!(view instanceof TextView)) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(drawable);
                return;
            } else {
                view.setBackgroundDrawable(drawable);
                return;
            }
        }
        if (drawable != null) {
            if (drawablePosition == DrawablePosition.Left) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ((TextView) view).setCompoundDrawables(drawable, null, null, null);
                return;
            }
            if (drawablePosition == DrawablePosition.Top) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ((TextView) view).setCompoundDrawables(null, drawable, null, null);
                return;
            }
            if (drawablePosition == DrawablePosition.Right) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ((TextView) view).setCompoundDrawables(null, null, drawable, null);
                return;
            } else if (drawablePosition == DrawablePosition.Bottom) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ((TextView) view).setCompoundDrawables(null, null, null, drawable);
                return;
            } else if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(drawable);
                return;
            } else {
                view.setBackgroundDrawable(drawable);
                return;
            }
        }
        TextView textView = (TextView) view;
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (drawablePosition == DrawablePosition.Left) {
            compoundDrawables[0] = null;
        } else if (drawablePosition == DrawablePosition.Top) {
            compoundDrawables[1] = null;
        } else if (drawablePosition == DrawablePosition.Right) {
            compoundDrawables[2] = null;
        } else if (drawablePosition == DrawablePosition.Bottom) {
            compoundDrawables[3] = null;
        }
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }
}
