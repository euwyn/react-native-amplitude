package com.threedot.reactnativeamplitude;

import com.amplitude.api.Amplitude;

import android.app.Activity;
import android.app.Application;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;

public class AmplitudeAndroidModule extends ReactContextBaseJavaModule {

  private Activity mActivity = null;
  private Application mApplication = null;
  
  public AmplitudeAndroidModule(ReactApplicationContext reactContext, Activity mActivity, Application mApplication) {
    super(reactContext);
    this.mActivity = mActivity;
    this.mApplication = mApplication;
  }
  
  @Override
  public String getName() {
    return "AmplitudeAndroid";
  }
  
  @ReactMethod
  public void initialize(String apiKey) {
    Amplitude.getInstance().initialize(this.mActivity, apiKey).enableForegroundTracking(this.mApplication);
  }
  
  @ReactMethod
  public void logEvent(String identifier) {
    Amplitude.getInstance().logEvent(identifier);
  }
  
  @ReactMethod
  public void trackSessionEvents(boolean bool) {
    Amplitude.getInstance().trackSessionEvents(bool);
  }
  
  @ReactMethod
  public void setUserId(String id) {
    Amplitude.getInstance().setUserId(id);
  }
     
}