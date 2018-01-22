package oonuma.miyuki.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 *
 */
public class MainActivity extends AppCompatActivity {


    // 課題２
    final LifecycleObserver lifecycleObserver = new LifecycleObserver() {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public void createSome(LifecycleOwner owner) {
            Lifecycle lifecycle = getLifecycle();
            Log.d(getPackageName(), "ON_CREATE " + lifecycle.getCurrentState().name());
        }
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void Some(LifecycleOwner owner) {
            Log.d(getPackageName(),"ON_START " + getLifecycle().getCurrentState().name());

        }
        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void stopSome(LifecycleOwner owner) {
            Log.d(getPackageName(), "ON_STOP " +getLifecycle().getCurrentState().name());

        }
        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
        public void anySome(LifecycleOwner owner) {
            Log.d(getPackageName(), "ON_ANY " +getLifecycle().getCurrentState().name());

        }
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void resumeSome(LifecycleOwner owner) {
            Log.d(getPackageName(), "ON_RESUME " +getLifecycle().getCurrentState().name());
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void destroySome(LifecycleOwner owner) {
            Log.d(getPackageName(), "ON_DESTROY " +getLifecycle().getCurrentState().name());
            // 課題2の2
            owner.getLifecycle().removeObserver(lifecycleObserver);
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getPackageName(), "onCreate " + getLifecycle().getCurrentState().name());
        getLifecycle().addObserver(lifecycleObserver);
        getLifecycle().addObserver(lifecycleObserver);
        getLifecycle().addObserver(lifecycleObserver);

        Log.d(getPackageName(), "onCreate lifecycleObserver 2");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(getPackageName(), "onSaveInstanceState before " + getLifecycle().getCurrentState().name());
        super.onSaveInstanceState(outState);
        Log.d(getPackageName(), "onSaveInstanceState after " + getLifecycle().getCurrentState().name());

    }

    @Override
    protected void onStart() {
        super.onStart();///INITIALIZED
        Log.d(getPackageName(), "onStart " + getLifecycle().getCurrentState().name());

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getPackageName(), "onResume " + getLifecycle().getCurrentState().name());

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(getPackageName(), "onPause " + getLifecycle().getCurrentState().name());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(getPackageName(), "onDestroy " + getLifecycle().getCurrentState().name());
        // 課題2の2
        getLifecycle().removeObserver(lifecycleObserver);
    }

}
