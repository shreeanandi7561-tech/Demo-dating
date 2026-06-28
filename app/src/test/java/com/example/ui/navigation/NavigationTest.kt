package com.example.ui.navigation

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.viewmodel.MainViewModel
import androidx.test.core.app.ApplicationProvider
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui.screens.ChatScreen
import com.example.data.UserEntity

@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testNavigationToChat() {
        val user = UserEntity("u1", "Ananya", "10/05/2004", 20, "Female", "Mumbai", "Dating", "Cooking,Travel", "", 2, 250, 1500, false, false, "")
        rule.setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "start") {
                composable("start") {
                    androidx.compose.material3.Button(onClick = { navController.navigate("chat/u1") }) {
                        androidx.compose.material3.Text("Go")
                    }
                }
                composable("chat/{userId}") {
                    ChatScreen(user = user, onBack = {})
                }
            }
        }
        rule.onNodeWithText("Go").performClick()
        rule.waitForIdle()
    }
}
