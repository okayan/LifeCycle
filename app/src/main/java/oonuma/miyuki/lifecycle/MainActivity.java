package oonuma.miyuki.lifecycle;

import android.arch.lifecycle.GenericLifecycleObserver;
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
public class MainActivity extends AppCompatActivity implements GenericLifecycleObserver{


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
            Log.d(getPackageName(), "on_CREATE " +getLifecycle().getCurrentState().name());
            owner.getLifecycle().removeObserver(lifecycleObserver);
        }


    };

    final LifecycleObserver genericOb = new GenericLifecycleObserver() {
        @Override
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            Log.d(getPackageName(), "LifecycleObserver onStateChanged " +getLifecycle().getCurrentState().name());
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getPackageName(), "onCreate " + getLifecycle().getCurrentState().name());
        getLifecycle().addObserver(lifecycleObserver);
        getLifecycle().addObserver(genericOb);
        Log.d(getPackageName(), "onCreate lifecycleObserver 2");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(getPackageName(), "onSave before " + getLifecycle().getCurrentState().name());

        super.onSaveInstanceState(outState);
        Log.d(getPackageName(), "onSave after " + getLifecycle().getCurrentState().name());

    }

    @Override
    protected void onStart() {
        super.onStart();///INITIALIZED
        Log.d(getPackageName(), "ONSTART " + getLifecycle().getCurrentState().name());

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
        Log.d(getPackageName(), "onD" + getLifecycle().getCurrentState().name());

    }

    @Override
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {

    }
}
