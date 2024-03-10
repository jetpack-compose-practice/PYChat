package com.piyushprajpti.pychat.presentation.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActionScope
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
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.presentation.BackButton
import com.piyushprajpti.pychat.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    name: String
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Piyush Prajapati") },

                navigationIcon = { BackButton(onClick = {})},

                actions = {Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search")},

                scrollBehavior = scrollBehavior
            )
        },

        bottomBar = {

            BottomAppBar {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add Media")

                Spacer(modifier = Modifier.width(10.dp))

                OutlinedTextField(
                    value = "", onValueChange = {}, modifier = Modifier.weight(1f)
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
            LazyColumn(modifier = Modifier.padding(it)) {
                for (i in 1..100) {
                    item {
                        Text(text = i.toString(), modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    )
}
