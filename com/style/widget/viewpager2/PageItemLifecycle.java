package com.style.widget.viewpager2;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class PageItemLifecycle {
    private State mCurrentState = State.DESTROYED;
    private final PageItem mPageItem;

    public PageItemLifecycle(PageItem pageItem) {
        this.mPageItem = pageItem;
    }

    public void setMinLifecycle(State state) {
        if (!this.mCurrentState.isAtLeast(state)) {
            moveToState(state);
        }
    }

    public void setMaxLifecycle(State state) {
        if (!state.isAtLeast(this.mCurrentState)) {
            moveToState(state);
        }
    }

    public void saveCurrentState(State state) {
        this.mCurrentState = state;
    }

    public State getCurrentState() {
        return this.mCurrentState;
    }

    public boolean isCreated() {
        return this.mCurrentState.isAtLeast(State.CREATED);
    }

    public boolean isStarted() {
        return this.mCurrentState.isAtLeast(State.STARTED);
    }

    public boolean isResumed() {
        return this.mCurrentState.isAtLeast(State.RESUMED);
    }

    public void moveToState(State state) {
        switch (state) {
            case DESTROYED:
            case INITIALIZED:
                moveToDestroyed(this.mCurrentState);
                break;
            case CREATED:
                moveToCreated(this.mCurrentState);
                break;
            case STARTED:
                moveToStart(this.mCurrentState);
                break;
            case RESUMED:
                moveToResume(this.mCurrentState);
                break;
        }
    }

    private void moveToResume(State state) {
        switch (state) {
            case DESTROYED:
            case INITIALIZED:
                this.mPageItem.onPageCreate();
                break;
            case CREATED:
                break;
            case STARTED:
                this.mPageItem.onPageResume();
            default:
                return;
        }
        this.mPageItem.onPageStart();
        this.mPageItem.onPageResume();
    }

    private void moveToStart(State state) {
        switch (state) {
            case DESTROYED:
            case INITIALIZED:
                this.mPageItem.onPageCreate();
                break;
            case CREATED:
                break;
            case STARTED:
            default:
                return;
            case RESUMED:
                this.mPageItem.onPagePause();
                return;
        }
        this.mPageItem.onPageStart();
    }

    private void moveToCreated(State state) {
        switch (state) {
            case DESTROYED:
            case INITIALIZED:
                this.mPageItem.onPageCreate();
                return;
            case CREATED:
            default:
                return;
            case STARTED:
                break;
            case RESUMED:
                this.mPageItem.onPagePause();
                break;
        }
        this.mPageItem.onPageStop();
    }

    private void moveToDestroyed(State state) {
        switch (state) {
            case DESTROYED:
            case INITIALIZED:
            default:
                return;
            case STARTED:
                break;
            case CREATED:
                this.mPageItem.onPageDestroy();
            case RESUMED:
                this.mPageItem.onPagePause();
                break;
        }
        this.mPageItem.onPageStop();
        this.mPageItem.onPageDestroy();
    }
}
