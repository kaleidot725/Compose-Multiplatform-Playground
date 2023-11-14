package jp.kaleidot725.precompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.kaleidot725.precompose.details.DetailsScreen
import jp.kaleidot725.precompose.home.HomeScreen
import jp.kaleidot725.precompose.home.HomeUiState
import jp.kaleidot725.precompose.route.RouteScreen
import jp.kaleidot725.precompose.setting.SettingScreen
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition

@Composable
fun App() {
    PreComposeApp {
        val navigator = rememberNavigator()
        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navigator = navigator,
                navTransition = NavTransition(),
                initialRoute = "/route",
            ) {
                group(route = "/route", initialRoute = "/route/home") {
                    scene(
                        route = "/route/home",
                        navTransition = NavTransition()
                    ) {
                        RouteScreen()
                    }
                }

                group(route = "/main", initialRoute = "/main/home") {
                    scene(
                        route = "/main/home",
                        navTransition = NavTransition(),
                    ) {
                        HomeScreen(
                            state = HomeUiState(listOf("ONE", "TWO", "THREE", "FOUR")),
                            navigateDetails = { navigator.navigate("/main/details/$it") }
                        )
                    }

                    scene(route = "/main/details/{id}") { backStackEntry ->
                        val id = backStackEntry.path<String>("id")
                        DetailsScreen(id ?: "UNKNOWN")
                    }
                }

                group(route = "/setting", initialRoute = "/setting/home") {
                    scene(
                        route = "/setting/home",
                        navTransition = NavTransition(),
                    ) {
                        SettingScreen()
                    }
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp)
            ) {
                Button(
                    onClick = {
                        navigator.navigate("/main")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Naviage Main Group")
                }

                Button(
                    onClick = {
                        navigator.navigate("/setting")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Navigate Setting Group")
                }

                Button(
                    onClick = {
                        navigator.goBack()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Go Back")
                }

                Button(
                    onClick = {
                        navigator.popBackStack()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Pop Back Stack")
                }
            }
        }
    }
}