package com.threedot.reactnativeamplitude;

import android.app.Activity;
import android.app.Application;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.*;

public class ReactNativeAmplitudePackage implements ReactPackage {

    private Activity mActivity = null;
    private Application mApplication = null;

    public ReactNativeAmplitudePackage(Activity activity, Application application) {
        mActivity = activity;
        mApplication = application;
    }
  
    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new AmplitudeAndroidModule(reactContext, mActivity, mApplication));
        return modules;
    }
    
    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

}
