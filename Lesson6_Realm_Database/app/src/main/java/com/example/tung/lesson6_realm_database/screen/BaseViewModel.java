package com.example.tung.lesson6_realm_database.screen;

import android.databinding.BaseObservable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by tung on 6/1/17.
 */

public class BaseViewModel extends BaseObservable {

    private CompositeDisposable mCompositeDisposable;

    public BaseViewModel() {
        mCompositeDisposable = new CompositeDisposable();
    }

    public void onViewAttach() {
    }

    public void onViewDetach() {
        stopSubscriptions();
    }

    public void startSubscriber(Disposable Disposable) {
        mCompositeDisposable.add(Disposable);
    }

    private void stopSubscriptions() {
        mCompositeDisposable.clear();
    }
}
