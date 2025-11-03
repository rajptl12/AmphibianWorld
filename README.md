<<<<<<< HEAD
# AmphibianWorld
=======
HW #5 – Build Amphibians App
Reference & Summary Report

References:
Jetpack Compose Documentation – https://developer.android.com/jetpack/compose
Android Developers Guide – https://developer.android.com/guide
Retrofit Official Documentation – Square Open Source Library- https://square.github.io/retrofit/
Android Developers – Guide to App Architecture (MVVM)-https://developer.android.com/topic/architecture

Class lectures and my own practice notes
1. Project Overview
My project is called Amphibian World .
The main goal of this app is to show a list of amphibians with their image, name, type, and description. The data comes from an online JSON link using Retrofit.
I used Jetpack Compose with Material3 for the UI and followed the MVVM (Model–View–ViewModel) architecture.
The app has proper loading and error states, and I also added a small animation when expanding cards for a bonus effect.

2. App Features
Main Features
The app fetches data from the Amphibians API and displays it using a LazyColumn.
Each amphibian card shows an image, name, and type.
When tapped, the card expands to show a full description using AnimatedVisibility.
If data is still loading, a circular progress bar appears.
If there’s a network problem, an error message with a “Retry” button is shown.
The data is managed with StateFlow inside a ViewModel.

I also added Bonus Features
Click-to-expand animation for each amphibian card.
Custom title added at the top of the list.
Personalized colors and clean layout using Material3.
Fun touch with a frog emoji 🐸 in error messages.

O
>>>>>>> c5fbc79 (Added README.md file)
