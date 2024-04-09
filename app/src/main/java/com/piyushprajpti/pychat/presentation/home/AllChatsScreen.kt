package com.piyushprajpti.pychat.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.R
import com.piyushprajpti.pychat.presentation.DefaultMargin
import com.piyushprajpti.pychat.ui.theme.Typography

@Composable
fun AllChatsScreen(
    onChatCardClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(DefaultMargin)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Chats", style = Typography.titleLarge)

            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
                modifier = Modifier
                    .clickable { }
                    .clip(CircleShape)
            )
        }

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
                    messageCount = 5,
                    onClick = {onChatCardClick()}
                )
            }

            item {
                ChatCard(
                    profilePhoto = R.drawable.me,
                    name = "Piyush Prajapati",
                    latestMessage = "hello world!sdgshsdfa gfadgsxfhfxhdhthrdhdtrhrdthrtfhdf",
                    messageDate = "Yesterday",
                    messageCount = 1,
                    onClick = {onChatCardClick()}
                )
            }

            item {
                ChatCard(
                    profilePhoto = R.drawable.me,
                    name = "Piyush Prajapati",
                    latestMessage = "hello world!",
                    messageDate = "18 feb",
                    messageCount = 0,
                    onClick = {onChatCardClick()}
                )
            }
        }
    }
}