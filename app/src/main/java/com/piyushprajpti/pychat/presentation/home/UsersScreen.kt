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
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.presentation.DefaultMargin
import com.piyushprajpti.pychat.ui.theme.Typography

@Composable
fun UsersScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CommonTopBar(pageName = "Users")

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(vertical = 10.dp)
        ) {
            item {
                UserInfoCard(name = "Piyush Prajapati", userName = "@rj02piyush")
            }
            item {
                UserInfoCard(name = "Gaurav Saini", userName = "@gsaini")
            }
            item {
                UserInfoCard(name = "Piyush Prajapati", userName = "@rj02piyush")
            }
            item {
                UserInfoCard(name = "Gaurav Saini", userName = "@gsaini")
            }
            item {
                UserInfoCard(name = "Piyush Prajapati", userName = "@rj02piyush")
            }
        }
    }
}