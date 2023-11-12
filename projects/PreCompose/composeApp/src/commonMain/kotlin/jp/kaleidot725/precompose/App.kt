package jp.kaleidot725.precompose

import androidx.compose.runtime.Composable
import jp.kaleidot725.precompose.details.DetailsScreen
import jp.kaleidot725.precompose.home.HomeScreen
import jp.kaleidot725.precompose.home.HomeUiState
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition

@Composable
fun App() {
    PreComposeApp {
        val navigator = rememberNavigator()
        NavHost(
            navigator = navigator,
            navTransition = NavTransition(),
            initialRoute = "/home",
        ) {
            scene(
                route = "/home",
                navTransition = NavTransition(),
            ) {
                HomeScreen(
                    state = HomeUiState(listOf("TEST1", "TEST2", "TEST3", "TEST4")),
                    navigateDetails = { navigator.navigate("/details/$it") }
                )
            }

            scene(route = "/detail/{id}") { backStackEntry ->
                val id: String = backStackEntry.pathMap["id"] ?: "UNKNOWN"
                DetailsScreen(id)
            }
        }
    }
}