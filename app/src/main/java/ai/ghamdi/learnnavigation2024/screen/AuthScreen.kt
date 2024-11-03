package ai.ghamdi.learnnavigation2024.screen

import kotlinx.serialization.Serializable

@Serializable
sealed interface AuthScreen {
    @Serializable
    data object Auth : AuthScreen

    @Serializable
    data object Welcome : AuthScreen

    @Serializable
    data object Login : AuthScreen

    @Serializable
    data object Register : AuthScreen

    @Serializable
    data object ForgotPassword : AuthScreen
}