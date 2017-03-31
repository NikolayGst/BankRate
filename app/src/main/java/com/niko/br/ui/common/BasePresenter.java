package com.niko.br.ui.common;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class BasePresenter<T extends MvpView> extends MvpPresenter<T> {

  private CompositeSubscription compositeSubscription;

  protected BasePresenter() {
    compositeSubscription = new CompositeSubscription();
  }

  public void unsubscribeOnDestroy(Subscription subscription) {
    compositeSubscription.add(subscription);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    compositeSubscription.clear();
  }
}
