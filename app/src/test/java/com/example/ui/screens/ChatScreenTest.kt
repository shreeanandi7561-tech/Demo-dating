package com.example.ui.screens

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.data.UserEntity

@RunWith(AndroidJUnit4::class)
class ChatScreenTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testChatScreenRenders() {
        var didNotCrash = false
        val user = UserEntity("u1", "Ananya", "10/05/2004", 20, "Female", "Mumbai", "Dating", "Cooking,Travel", "", 2, 250, 1500, false, false, "")
        rule.setContent {
            ChatScreen(user = user, onBack = {})
        }
        rule.waitForIdle()
        didNotCrash = true
        assert(didNotCrash)
    }
}
