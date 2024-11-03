package ai.ghamdi.learnnavigation2024.screen

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppScreen {
    @Serializable
    data object App : AppScreen

    @Serializable
    data object Home : AppScreen

    @Serializable
    data object Portfolio : AppScreen

    @Serializable
    data object Profile : AppScreen
}
