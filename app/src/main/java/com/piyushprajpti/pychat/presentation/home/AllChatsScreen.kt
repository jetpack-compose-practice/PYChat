package com.piyushprajpti.pychat.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.R

@Composable
fun AllChatsScreen(
    onChatCardClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        CommonTopBar(pageName = "Chats")

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(vertical = 10.dp)
        ) {
            item {
                ChatCard(
                    profilePhoto = R.drawable.me,
                    name = "Piyush Prajapati",
                    latestMessage = "hello world!",
                    messageDate = "02:35 AM",
                    messageCount = 7,
                    onClick = { onChatCardClick() }
                )
            }

            item {
                ChatCard(
                    profilePhoto = R.drawable.me,
                    name = "Piyush Prajapati",
                    latestMessage = "hello world!sdgshsdfa gfadgsxfhfxhdhthrdhdtrhrdthrtfhdf",
                    messageDate = "Yesterday",
                    messageCount = 1,
                    onClick = { onChatCardClick() }
                )
            }

            item {
                ChatCard(
                    profilePhoto = R.drawable.me,
                    name = "Piyush Prajapati",
                    latestMessage = "hello world!",
                    messageDate = "18 feb",
                    messageCount = 0,
                    onClick = { onChatCardClick() }
                )
            }
        }
    }
}