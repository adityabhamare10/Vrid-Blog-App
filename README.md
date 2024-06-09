![Untitled design](https://github.com/adityabhamare10/Vrid-Blog-App/assets/108888187/39596386-323f-4c25-8eb0-50e0018eeaa3)# Blog App

This is an Android application that fetches and displays blog posts from a WordPress blog using Retrofit and Room for offline caching.

## Features

- Fetch blog posts from a remote API
- Display a list of blog posts
- View blog post details
- Cache blog posts for offline access
- MVVM architecture
- Uses Retrofit for network operations
- Uses Room for local database

## Architecture

This app follows the Model-View-ViewModel (MVVM) architecture pattern:
- `Model`: Represents the data and business logic of the app (BlogPost, Room entities, Retrofit API).
- `View`: Displays the data to the user and allows interaction (Activity, Fragments).
- `ViewModel`: Manages UI-related data and survives configuration changes (AndroidViewModel).

## Libraries Used

- [Retrofit](https://square.github.io/retrofit/) for network operations
- [Room](https://developer.android.com/jetpack/androidx/releases/room) for local database
- [Coroutines](https://developer.android.com/kotlin/coroutines) for asynchronous operations
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) to handle data in a lifecycle-aware manner
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) to manage UI-related data
## Media
![design](https://github.com/adityabhamare10/Vrid-Blog-App/assets/108888187/59ad0414-99aa-44a8-b679-bf5f70ef9d72)

https://github.com/adityabhamare10/Vrid-Blog-App/assets/108888187/1169545b-fa44-4a5f-91a4-a169039ea19d

