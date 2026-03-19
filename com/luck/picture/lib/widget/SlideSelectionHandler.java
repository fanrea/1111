package com.luck.picture.lib.widget;

import com.luck.picture.lib.widget.SlideSelectTouchListener;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SlideSelectionHandler implements SlideSelectTouchListener.OnAdvancedSlideSelectListener {
    private HashSet<Integer> mOriginalSelection;
    private final ISelectionHandler mSelectionHandler;
    private ISelectionStartFinishedListener mStartFinishedListener = null;

    public interface ISelectionHandler {
        void changeSelection(int i, int i2, boolean z, boolean z2);

        Set<Integer> getSelection();
    }

    public interface ISelectionStartFinishedListener {
        void onSelectionFinished(int i);

        void onSelectionStarted(int i, boolean z);
    }

    public SlideSelectionHandler(ISelectionHandler iSelectionHandler) {
        this.mSelectionHandler = iSelectionHandler;
    }

    public SlideSelectionHandler withStartFinishedListener(ISelectionStartFinishedListener iSelectionStartFinishedListener) {
        this.mStartFinishedListener = iSelectionStartFinishedListener;
        return this;
    }

    @Override // com.luck.picture.lib.widget.SlideSelectTouchListener.OnAdvancedSlideSelectListener
    public void onSelectionStarted(int i) {
        this.mOriginalSelection = new HashSet<>();
        Set<Integer> selection = this.mSelectionHandler.getSelection();
        if (selection != null) {
            this.mOriginalSelection.addAll(selection);
        }
        boolean zContains = this.mOriginalSelection.contains(Integer.valueOf(i));
        this.mSelectionHandler.changeSelection(i, i, !this.mOriginalSelection.contains(Integer.valueOf(i)), true);
        ISelectionStartFinishedListener iSelectionStartFinishedListener = this.mStartFinishedListener;
        if (iSelectionStartFinishedListener != null) {
            iSelectionStartFinishedListener.onSelectionStarted(i, zContains);
        }
    }

    @Override // com.luck.picture.lib.widget.SlideSelectTouchListener.OnAdvancedSlideSelectListener
    public void onSelectionFinished(int i) {
        this.mOriginalSelection = null;
        ISelectionStartFinishedListener iSelectionStartFinishedListener = this.mStartFinishedListener;
        if (iSelectionStartFinishedListener != null) {
            iSelectionStartFinishedListener.onSelectionFinished(i);
        }
    }

    @Override // com.luck.picture.lib.widget.SlideSelectTouchListener.OnSlideSelectListener
    public void onSelectChange(int i, int i2, boolean z) {
        while (i <= i2) {
            checkedChangeSelection(i, i, z != this.mOriginalSelection.contains(Integer.valueOf(i)));
            i++;
        }
    }

    private void checkedChangeSelection(int i, int i2, boolean z) {
        this.mSelectionHandler.changeSelection(i, i2, z, false);
    }
}
