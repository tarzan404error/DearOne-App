package com.example.dearone

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissionLauncher.launch(
                Manifest.permission.POST_NOTIFICATIONS
            )
        }

        setContent {
            DearOneApp()
        }
    }
}

@Composable
fun DearOneApp() {

    val context = LocalContext.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Add Event Screen later
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Event"
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "DearOne ❤️",
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Never Miss a Special Moment"
            )

            Spacer(modifier = Modifier.height(40.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Today's Event 🎉",
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Rahul's Birthday"
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                    NotificationHelper.showNotification(
                        context,
                        "DearOne Reminder 🎂",
                        "Today is Rahul's Birthday. Don't forget to wish!"
                    )
                }
            ) {
                Text("Test Notification")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    // Add Event later
                }
            ) {
                Text("Add Event")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    // View Events later
                }
            ) {
                Text("View Events")
            }
        }
    }
}
