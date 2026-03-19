package com.ss.texturerender;

import android.opengl.GLES20;
import android.util.AndroidRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Texture implements ITexture {
    private static final String TAG = "ITexture";
    private int mForbidTextureReuse = 0;
    private ReentrantLock mLock;
    private IRef mRef;
    private int mTexTarget;
    private int mTexType;
    private int mTextureId;
    private OnTextureReturnListener mTextureReturnListener;

    public interface OnTextureReturnListener {
        void onTextureReturn(ITexture iTexture);
    }

    public void release() {
        TextureRenderLog.i(this.mTexType, TAG, this + "release = " + this.mTextureId);
        lock();
        GLES20.glDeleteTextures(1, new int[]{this.mTextureId}, 0);
        unlock();
        TextureRenderLog.i(this.mTexType, TAG, this + "release end = " + this.mTextureId);
    }

    public Texture(int i, int i2, OnTextureReturnListener onTextureReturnListener, int i3) {
        this.mTexType = i3;
        TextureRenderLog.i(i3, TAG, "new texture = " + i);
        this.mTextureId = i;
        this.mTextureReturnListener = onTextureReturnListener;
        this.mRef = new Ref();
        this.mLock = new ReentrantLock();
        this.mTexTarget = i2;
    }

    @Override // com.ss.texturerender.ITexture
    public int getTexTarget() {
        return this.mTexTarget;
    }

    @Override // com.ss.texturerender.ITexture
    public int lock() {
        if (this.mLock.isHeldByCurrentThread()) {
            throw new AndroidRuntimeException("Dead lock!!");
        }
        this.mLock.lock();
        return this.mTextureId;
    }

    @Override // com.ss.texturerender.ITexture
    public int tryLock(int i) {
        try {
            if (this.mLock.tryLock(i, TimeUnit.MILLISECONDS)) {
                return this.mTextureId;
            }
            return -1;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    @Override // com.ss.texturerender.ITexture
    public void unlock() {
        this.mLock.unlock();
    }

    @Override // com.ss.texturerender.IRef
    public int addRef() {
        int iAddRef = this.mRef.addRef();
        TextureRenderLog.i(this.mTexType, TAG, this + " add ref " + iAddRef);
        return iAddRef;
    }

    @Override // com.ss.texturerender.IRef
    public int decRef() {
        int iDecRef = this.mRef.decRef();
        TextureRenderLog.i(this.mTexType, TAG, this + " dec ref " + iDecRef);
        if (iDecRef == 1) {
            this.mTextureReturnListener.onTextureReturn(this);
            return 0;
        }
        if (iDecRef >= 1) {
            return 0;
        }
        throw new RuntimeException(new Exception("reference idx " + (iDecRef - 1) + " app abort!!"));
    }

    @Override // com.ss.texturerender.IRef
    public int refCnt() {
        return this.mRef.refCnt();
    }

    public void setForbidTextureReuse(int i) {
        TextureRenderLog.i(this.mTexType, TAG, this + ", setForbidTextureReuse: " + i);
        this.mForbidTextureReuse = i;
    }

    public int getForbidTextureReuse() {
        return this.mForbidTextureReuse;
    }
}
