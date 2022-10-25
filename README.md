# android-fragment-backstack-failure

A simple demonstration of a failure case in the current versions of the andorid fragment library;
that is both 'androidx.fragment:fragment-ktx:1.5.4' as well as 'androidx.fragment:fragment-ktx:1.6.0-alpha03'

## Usage

After loading the project in Android Studio and starting the app on a device or emulator of your choice,
either push the buttons in the order that they appear.

The app will crash when attempting to save the backstack,
despite the set of affected fragments being entirely self contained within the set of transactions being saved.

-----

Please excuse the gradle script being slightly messy, but I believe the actual source code should be clear enough to demonstrate the issue.
