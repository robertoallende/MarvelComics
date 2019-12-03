# Marvel Comics

A Marvel Comics catalog Application implmented in Native Android Stack.

## Features

* Gets all data from Marvel API.

* Cache and Offline Support. Once data is loaded, it is stored and reused. 

* Material Design.

* Testing.

* Compatible with Android 4.1.x upto Android 7.0

* Tested in Android 4.1.1, 5.0 and 6.0.


## Android Client

[Watch Demo on youtube.](https://youtu.be/Y2nDMBhNwSw)

### Compiling and running the client

The application was coded running Android Studio 2.1.3. In order to get it running, clone the source code from [Github](https://github.com/robertoallende/MarvelComics). Import the project into Android Studio. 

Before running the client, it is require to setup Marvel's Private and Public Key. Both values are stored into Config.java.

### About the implementation

The code follows MVC Architecture described by Yigit Boyar in the article titled  [A Recipe for writing responsive REST clients on Android](www.birbit.com/a-recipe-for-writing-responsive-rest-clients-on-android/) and in the talk titled [Android Application Architecture (Android Dev Summit 2015)](https://www.youtube.com/watch?v=BlkJzgjzL0c) at the Android Dev Summit 2015.

By defining clear goals for each layer, this architecture allows me to have decouple compoments and apply Single responsibility principle. 

Since this project was built in less than 24 hours man in total, I took decisions in order to deliver and have a fully functional program at the same time. This means that for certain components i chose conservative alternatives, for example, I store data into a local file instead using SQLLite, I use Serializable instead of Parceleable. Although Parceleable is more efficient, requires more boilerplate code. In a 'real world' project, I would use SQLLite and Parceleable.

This project has a test case to show an example of a functional test case made with Espresso but, again in a 'real world' project, testing wout be more exhaustive and cover different cases. I would use mocks to avoid real api calls. 

