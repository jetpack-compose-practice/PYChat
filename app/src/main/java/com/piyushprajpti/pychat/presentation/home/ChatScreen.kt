package com.piyushprajpti.pychat.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.presentation.BackButton
import com.piyushprajpti.pychat.ui.theme.ChatBackgroundDT
import com.piyushprajpti.pychat.ui.theme.ChatBackgroundLT
import com.piyushprajpti.pychat.ui.theme.ChatBarsDT
import com.piyushprajpti.pychat.ui.theme.ChatBarsLT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    name: String,
    onBackClick: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    val chatMessage = remember {
        mutableStateOf(TextFieldValue(""))
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Piyush Prajapati") },

                navigationIcon = { BackButton(onClick = { onBackClick() }) },

                actions = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search"
                    )
                },

                scrollBehavior = scrollBehavior,

                modifier = Modifier.padding(horizontal = 10.dp),

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (isSystemInDarkTheme()) ChatBarsDT else ChatBarsLT
                )
            )
        },

        bottomBar = {

            BottomAppBar(
                modifier = Modifier.padding(horizontal = 10.dp),
                containerColor = if (isSystemInDarkTheme()) ChatBarsDT else ChatBarsLT
            ) {
                Spacer(modifier = Modifier.width(10.dp))

                OutlinedTextField(
                    value = chatMessage.value,
                    onValueChange = { chatMessage.value = it },
                    modifier = Modifier
                        .weight(1f)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = "Send",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },

        content = {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .background(if (isSystemInDarkTheme()) ChatBackgroundDT else ChatBackgroundLT)
            ) {
                for (i in 1..100) {
                    item {
                        Text(text = i.toString(), modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    )
}
