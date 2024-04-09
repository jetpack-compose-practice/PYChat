package com.piyushprajpti.pychat.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.R
import com.piyushprajpti.pychat.presentation.DefaultMargin
import com.piyushprajpti.pychat.ui.theme.ChatBarsDT
import com.piyushprajpti.pychat.ui.theme.ChatBarsLT
import com.piyushprajpti.pychat.ui.theme.DividerDT
import com.piyushprajpti.pychat.ui.theme.DividerLT
import com.piyushprajpti.pychat.ui.theme.LatestMessageGray
import com.piyushprajpti.pychat.ui.theme.MessageCountBackground
import com.piyushprajpti.pychat.ui.theme.MessageCountText
import com.piyushprajpti.pychat.ui.theme.TextDT
import com.piyushprajpti.pychat.ui.theme.Typography

@Composable
fun ChatCard(
    profilePhoto: Int,
    name: String,
//    messageStatus: ImageVector,
    latestMessage: String,
    messageDate: String,
    messageCount: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(vertical = 1.dp, horizontal = DefaultMargin),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(id = profilePhoto),
            contentDescription = "Profile photo",
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .clip(CircleShape)
        )

        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name,
                    style = Typography.bodyLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = true,
                    maxLines = 1
                )

                Text(
                    text = messageDate,
                    style = Typography.labelMedium,
                    color = LatestMessageGray,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = true,
                    maxLines = 1
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Icon(
//                    imageVector = messageStatus,
//                    contentDescription = "message status",
//                    modifier = Modifier
//                        .padding(end = 5.dp)
//                        .size(15.dp)
//                )

                Text(
                    modifier = Modifier.weight(.8f),
                    text = latestMessage,
                    style = Typography.labelLarge,
                    color = LatestMessageGray,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = true,
                    maxLines = 1
                )

                if (messageCount > 0) {
                    Badge(
                        modifier = Modifier.padding(end = 12.dp),
                        containerColor = MessageCountBackground
                    ) {
                        Text(
                            text = messageCount.toString(),
                            style = Typography.labelSmall,
                            color = MessageCountText
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun UserInfoCard(
    name: String,
    userName: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 1.dp, horizontal = DefaultMargin),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.me),
            contentDescription = "Profile photo",
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                style = Typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = userName,
                style = Typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun SentMessageBox(
    message: String,
    messageDate: String
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Row(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomStart = 12.dp,
                        bottomEnd = 0.dp
                    )
                )
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(

            ) {
                Text(
                    text = message,
                    style = Typography.bodyMedium,
                    color = TextDT
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = messageDate,
                    style = Typography.labelSmall,
                    color = LatestMessageGray,
                    textAlign = TextAlign.Right,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}

@Composable
fun ReceivedMessageBox(
    message: String,
    messageDate: String
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
        Row(
            modifier = Modifier
                .background(
                    color = if (isSystemInDarkTheme()) ChatBarsDT else ChatBarsLT,
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 12.dp
                    )
                )
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(

            ) {
                Text(
                    text = message,
                    style = Typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )

                Spacer(modifier = Modifier.height(5.dp))
                
                Text(
                    text = messageDate,
                    style = Typography.labelSmall,
                    color = LatestMessageGray,
                    textAlign = TextAlign.Right
                )
            }
        }
    }
}

@Composable
fun CommonTopBar(
    pageName: String
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, top = 3.dp, bottom = 3.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = pageName, style = Typography.titleLarge)

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search",
                )
            }
        }

        HorizontalDivider(color = if (isSystemInDarkTheme()) DividerDT else DividerLT)
    }
}