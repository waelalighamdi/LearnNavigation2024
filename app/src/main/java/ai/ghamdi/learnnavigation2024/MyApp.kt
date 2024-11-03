package ai.ghamdi.learnnavigation2024

import ai.ghamdi.learnnavigation2024.screen.AppScreen
import ai.ghamdi.learnnavigation2024.screen.AuthScreen
import ai.ghamdi.learnnavigation2024.appScreen.AppScreen
import ai.ghamdi.learnnavigation2024.authScreen.AuthScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController


// Top Level Screens
data class Routes<T>(val name: String, val route: T, val icon: ImageVector)

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val appRoutes = listOf(
        Routes(name = "Home", route = AppScreen.Home, icon = Icons.Default.Home),
        Routes(name = "Portfolio", route = AppScreen.Portfolio, icon = Icons.Default.AddCircle),
        Routes(name = "Profile", route = AppScreen.Profile, icon = Icons.Default.AccountCircle),
    )
    val authRoutes = listOf(
        Routes(name = "Welcome", route = AuthScreen.Welcome, icon = Icons.Default.Home),
        Routes(name = "Login", route = AuthScreen.Login, icon = Icons.Default.AccountBox),
        Routes(name = "Register", route = AuthScreen.Register, icon = Icons.Default.Create),
        Routes(name = "ForgotPassword", route = AuthScreen.ForgotPassword, icon = Icons.Default.Info),
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, screenRoutes = appRoutes)
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = AppScreen.App) {
            navigation<AuthScreen.Auth>(startDestination = AuthScreen.Welcome) {
                composable<AuthScreen.Welcome> {
                    AuthScreen(
                        text = "Hello, I'm the Welcome Screen!",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                composable<AuthScreen.Login> {
                    AuthScreen(
                        text = "Hello, I'm the Login Screen!",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                composable<AuthScreen.Register> {
                    AuthScreen(
                        text = "Hello, I'm the Register Screen!",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                composable<AuthScreen.ForgotPassword> {
                    AuthScreen(
                        text = "Hello, I'm the Forgot Password Screen!",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
            navigation<AppScreen.App>(startDestination = AppScreen.Home) {
                composable<AppScreen.Home> {
                    AppScreen(
                        text = "Hello, I'm the Home Screen!",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                composable<AppScreen.Portfolio> {
                    AppScreen(
                        text = "Hello, I'm the Portfolio Screen!",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                composable<AppScreen.Profile> {
                    AppScreen(
                        text = "Hello, I'm the Profile Screen!",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    screenRoutes: List<Routes<out Any>>
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        screenRoutes.forEach { screenRoute ->
            NavigationBarItem(
                icon = { Icon(screenRoute.icon, contentDescription = screenRoute.name) },
                label = { Text(screenRoute.name) },
                selected = currentDestination?.hierarchy?.any { it.hasRoute(screenRoute.route::class) } == true,
                onClick = {
                    navController.navigate(screenRoute.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


