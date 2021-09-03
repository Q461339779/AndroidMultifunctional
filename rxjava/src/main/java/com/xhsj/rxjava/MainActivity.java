package com.xhsj.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //carete();
        //just();
        fromArrayMethod();

    }

    private void fromArrayMethod() {
        Integer[] array = {1,2,3};
    }

    private void just() {
        Observable.just(1,2,3)
                .subscribe(new Observer < Integer > () {
                               @Override
                               public void onSubscribe(Disposable d) {
                                   Log.d(TAG, "=================onSubscribe");
                               }

                               @Override
                               public void onNext(Integer integer) {
                                   Log.d(TAG, "=================onNext " + integer);
                               }

                               @Override
                               public void onError(Throwable e) {
                                   Log.d(TAG, "=================onError ");
                               }

                               @Override
                               public void onComplete() {
                                   Log.d(TAG, "=================onComplete ");
                               }
                           });
    }

    private void carete() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.d(TAG, "=========================currentThread name: " + Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "======================onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "======================onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "======================onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "======================onComplete");
            }
        });
    }
}
