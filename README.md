This repository is very much a work in progress. It is meant as a proof of concept more than anything else. The code in this repository is currently not in a 100% working state, it is not meant to be.

### TODO

-   [ ] get hot loader working
-   [ ] get remote debugger working
-   [ ] finish interface for DC motors

### What is working

-   telemetry
-   dc motors
-   custom UI

### How to run

1. yarn
2. `react-native bundle --platform android --dev true --entry-file index.js --bundle-output android/FtcRobotController/src/main/assets/index.android.bundle --assets-dest android/FtcRobotController/src/main/res/`
3. `react-native run-android --appFolder=FtcRobotController/ --main-activity="FtcRobotControllerActivity"`
4. start shared op mode
