# TwoActivities (with Lifecycle Management)
This is my working through of the three Codelab lessons:
* [https://codelabs.developers.google.com/codelabs/android-training-create-an-activity/#0](https://codelabs.developers.google.com/codelabs/android-training-create-an-activity/#0)
* [https://codelabs.developers.google.com/codelabs/android-training-activity-lifecycle-and-state/#0](https://codelabs.developers.google.com/codelabs/android-training-activity-lifecycle-and-state/#0)
* [https://codelabs.developers.google.com/codelabs/android-training-espresso-for-ui-testing/index.html?index=..%2F..%2Fandroid-training#0](https://codelabs.developers.google.com/codelabs/android-training-espresso-for-ui-testing/index.html?index=..%2F..%2Fandroid-training#0)
Most of the code is copy-pasted, but I believe I improved the suggested code in a few ways:
* I prefer to encode the English value of a string resource in its name.  For example, the string value, "Message Reply," is declared as follows:

```java
<string name="EnterYourMessageHere">Enter Your Message Here</string>
```
* The code suggested by Google allows a user to send an empty reply from
the second activity to the first.  This looks odd to me, so, I added a guard
in the second activity to finish itself only if there is a non-blank reply.
(In real-life, I'd go further and disable the Reply button of the second
activity unless there is some actual text in the reply.)
