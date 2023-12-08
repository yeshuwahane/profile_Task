package com.yeshuwahane.connect.presentain.favorite

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yeshuwahane.connect.data.remote.dto.Data
import com.yeshuwahane.connect.presentain.MainViewModel

@Composable
fun FavoriteScreen(viewModel: MainViewModel) {

    viewModel.getLocalData()
    Log.d("alien", "data ${viewModel.localData.value}")

    val profileList by remember {
        viewModel.localData
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(profileList) { item ->
            ProfileView(viewModel, profileData = item)
        }

    }
}


@Composable
fun ProfileView(mainViewModel: MainViewModel, profileData: Data) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = profileData.avatar,
            contentDescription = "profileImage",
            modifier = Modifier.clip(CircleShape)
        )

        Column {
            Text(text = "${profileData.first_name} ${profileData.last_name}")
            profileData.email?.let { Text(text = it) }

        }

        Image(imageVector = Icons.Default.Delete, contentDescription = "",
            Modifier.clickable {
                mainViewModel.removeFromFavorite(profileData)
                mainViewModel.showToast("Deleted")
                mainViewModel.getLocalData()
            })

    }


}