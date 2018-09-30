# TwoActivities
This is my working through of [https://codelabs.developers.google.com/codelabs/android-training-create-an-activity/#0](https://codelabs.developers.google.com/codelabs/android-training-create-an-activity/#0)

The tutorial tells you exactly what to do, so, for the most part this is simply copy/pasted.
I did add one thing: as given by Google, the application
allows one to "reply" with no text--you can click the Reply
button, and, your (empty) message is reported back to the
main activity.  I added an 'if' such that the replying activity
finishes if and only if the message isn't empty.

Classier would be to disable the Reply button as well, unless
the reply-text is non-empty.

