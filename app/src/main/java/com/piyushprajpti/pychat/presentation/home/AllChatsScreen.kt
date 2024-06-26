package com.piyushprajpti.pychat.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.firestore
import com.piyushprajpti.pychat.R

@Composable
fun AllChatsScreen(
    onChatCardClick: () -> Unit
) {
    val db = Firebase.firestore
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

            item {
                Button(onClick = {
                    val r = db.collection("users").where(
                        Filter.and(
                            Filter.equalTo("username", "username"),
                            Filter.equalTo("email", "emadil")
                        )
                    ).get()
                        .addOnSuccessListener {
                            Log.d("TAG", "AllChatsScreen: ${it}")
                        }
                        .addOnFailureListener {
                            Log.d("TAG", "AllChatsScreen: $it")
                        }
                }) {
                    Text(text = "Button")
                }
            }
        }
    }
}