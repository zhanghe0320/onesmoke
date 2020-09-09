package com.onesmoke.db.base;

/**
 */

public abstract class Singleton<T> {

    private volatile T mInstance;

    protected abstract T newInstance();

    public final T getInstance() {
        if (mInstance == null) {
            synchronized (this) {
                if (mInstance == null) {
                    mInstance = newInstance();
                }
            }
        }
        return mInstance;
    }

    public final void releaseInstance() {
        if (mInstance == null) {
            return;
        }
        synchronized (this) {
            mInstance = null;
        }
    }
}
