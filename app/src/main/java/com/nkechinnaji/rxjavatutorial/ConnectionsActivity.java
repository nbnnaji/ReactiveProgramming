package com.nkechinnaji.rxjavatutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ConnectionsActivity extends AppCompatActivity {
    private static final String TAG = "myApp";
    private final Integer[] greetings = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private Observable<Integer > myObservable;
    private DisposableObserver<Integer > myObserver;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private TextView myGreetingView;
    private TextView myGreetingView2;
    private TextView myGreetingView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connections);
        myGreetingView = findViewById(R.id.tvGreeting);
        myGreetingView2 = findViewById(R.id.tvGreeting2);
        myGreetingView3 = findViewById(R.id.tvGreeting3);

        myObservable = Observable.fromArray(greetings);
        compositeDisposable.add(
                myObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(getObserver())
        );

    }


    private DisposableObserver<Integer> getObserver() {
        myObserver = new DisposableObserver<Integer >() {
            ArrayList<Integer> nums = new ArrayList<>();
            @Override
            public void onNext(@NonNull Integer strings) {
                Log.i(TAG, " onNext invoked");
                Integer result = (strings);

                nums.add(strings);
                Log.i(TAG, " onNext numbers showing " + nums.toString());
                //String resultValue = result.substring(1, result.length() -1);

                myGreetingView.setText(strings.toString());

                Toast.makeText(getApplicationContext(), strings.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, " onError invoked");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, " onComplete invoked");
                Toast.makeText(getApplicationContext(), nums.toString(), Toast.LENGTH_LONG).show();
                myGreetingView2.setText(nums.toString());
                myGreetingView3.setText(nums.toString().substring(5,9));
            }
        };
        return myObserver;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}