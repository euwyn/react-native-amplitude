# react-native-amplitude
Simple React Native wrapper for Amplitude (Android) tracking

## Installation ##
1. `npm install react-native-amplitude --save`

2. Install Amplitude Android SDK [more info here](https://github.com/amplitude/Amplitude-Android)

3. Update Gradle settings

```gradle
// file: android/settings.gradle
...
include ':RNAmplitude'
project(':RNAmplitude').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-amplitude/android')
```

3. Update Gradle build

```gradle
// file: android/app/build.gradle
...

dependencies {
    ...
    compile project(':RNAmplitude');
}
```

4. Register React Package

```java
...
import com.threedot.reactnativeamplitude.ReactNativeAmplitudePackage; // import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {

    private ReactInstanceManager mReactInstanceManager;
    private ReactRootView mReactRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReactRootView = new ReactRootView(this);

        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())

                // register package here
                .addPackage(new ReactNativeAmplitudePackage(this,getApplication()))

                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "AwesomeProject", null);
        setContentView(mReactRootView);
    }
...

```

## Usage ##
```
//Require the module
var Amplitude = require('react-native-amplitude');

//Init Mixpanel SDK with your project token
Amplitude.initialize(YOUR_PROJECT_TOKEN);

//Log an event
Amplitude.logEvent('appStart');