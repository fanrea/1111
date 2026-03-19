package com.kwad.yoga;

import javax.annotation.Nullable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class c {
    public abstract void addChildAt(c cVar, int i);

    public abstract void calculateLayout(float f, float f2);

    public abstract c cloneWithoutChildren();

    public abstract void copyStyle(c cVar);

    public abstract void dirty();

    public abstract YogaAlign getAlignContent();

    public abstract YogaAlign getAlignItems();

    public abstract YogaAlign getAlignSelf();

    public abstract float getAspectRatio();

    public abstract float getBorder(YogaEdge yogaEdge);

    public abstract c getChildAt(int i);

    public abstract int getChildCount();

    @Nullable
    public abstract Object getData();

    public abstract YogaDisplay getDisplay();

    public abstract float getFlex();

    public abstract e getFlexBasis();

    public abstract YogaFlexDirection getFlexDirection();

    public abstract float getFlexGrow();

    public abstract float getFlexShrink();

    public abstract e getHeight();

    public abstract YogaJustify getJustifyContent();

    public abstract float getLayoutBorder(YogaEdge yogaEdge);

    public abstract YogaDirection getLayoutDirection();

    public abstract float getLayoutHeight();

    public abstract float getLayoutMargin(YogaEdge yogaEdge);

    public abstract float getLayoutPadding(YogaEdge yogaEdge);

    public abstract float getLayoutWidth();

    public abstract float getLayoutX();

    public abstract float getLayoutY();

    public abstract e getMargin(YogaEdge yogaEdge);

    public abstract e getMaxHeight();

    public abstract e getMaxWidth();

    public abstract e getMinHeight();

    public abstract e getMinWidth();

    public abstract YogaOverflow getOverflow();

    @Nullable
    public abstract c getOwner();

    public abstract e getPadding(YogaEdge yogaEdge);

    @Nullable
    @Deprecated
    public abstract c getParent();

    public abstract e getPosition(YogaEdge yogaEdge);

    public abstract YogaPositionType getPositionType();

    public abstract YogaDirection getStyleDirection();

    public abstract e getWidth();

    public abstract YogaWrap getWrap();

    public abstract boolean hasNewLayout();

    public abstract int indexOf(c cVar);

    public abstract boolean isBaselineDefined();

    public abstract boolean isDirty();

    public abstract boolean isMeasureDefined();

    public abstract boolean isReferenceBaseline();

    public abstract void markLayoutSeen();

    public abstract void print();

    public abstract c removeChildAt(int i);

    public abstract void reset();

    public abstract void setAlignContent(YogaAlign yogaAlign);

    public abstract void setAlignItems(YogaAlign yogaAlign);

    public abstract void setAlignSelf(YogaAlign yogaAlign);

    public abstract void setAspectRatio(float f);

    public abstract void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction);

    public abstract void setBorder(YogaEdge yogaEdge, float f);

    public abstract void setData(Object obj);

    public abstract void setDirection(YogaDirection yogaDirection);

    public abstract void setDisplay(YogaDisplay yogaDisplay);

    public abstract void setFlex(float f);

    public abstract void setFlexBasis(float f);

    public abstract void setFlexBasisAuto();

    public abstract void setFlexBasisPercent(float f);

    public abstract void setFlexDirection(YogaFlexDirection yogaFlexDirection);

    public abstract void setFlexGrow(float f);

    public abstract void setFlexShrink(float f);

    public abstract void setHeight(float f);

    public abstract void setHeightAuto();

    public abstract void setHeightPercent(float f);

    public abstract void setIsReferenceBaseline(boolean z);

    public abstract void setJustifyContent(YogaJustify yogaJustify);

    public abstract void setMargin(YogaEdge yogaEdge, float f);

    public abstract void setMarginAuto(YogaEdge yogaEdge);

    public abstract void setMarginPercent(YogaEdge yogaEdge, float f);

    public abstract void setMaxHeight(float f);

    public abstract void setMaxHeightPercent(float f);

    public abstract void setMaxWidth(float f);

    public abstract void setMaxWidthPercent(float f);

    public abstract void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction);

    public abstract void setMinHeight(float f);

    public abstract void setMinHeightPercent(float f);

    public abstract void setMinWidth(float f);

    public abstract void setMinWidthPercent(float f);

    public abstract void setOverflow(YogaOverflow yogaOverflow);

    public abstract void setPadding(YogaEdge yogaEdge, float f);

    public abstract void setPaddingPercent(YogaEdge yogaEdge, float f);

    public abstract void setPosition(YogaEdge yogaEdge, float f);

    public abstract void setPositionPercent(YogaEdge yogaEdge, float f);

    public abstract void setPositionType(YogaPositionType yogaPositionType);

    public abstract void setStyleInputs(float[] fArr, int i);

    public abstract void setWidth(float f);

    public abstract void setWidthAuto();

    public abstract void setWidthPercent(float f);

    public abstract void setWrap(YogaWrap yogaWrap);

    public static c create() {
        return new d();
    }

    public static c create(a aVar) {
        return new d(aVar);
    }
}
