package com.example.taskapp.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.taskapp.R

@Composable
fun LoginScreen(successLogin: (String) -> Unit) {
    val viewModel = hiltViewModel<LoginViewModel>()
    val userName = viewModel.userName.collectAsState()
    val password = viewModel.password.collectAsState()
    val navigateToHome = viewModel.navigateToHome.collectAsStateWithLifecycle(false)
    var passwordVisible by remember { mutableStateOf(false) }
    val isLoginButtonEnabled by remember {
        derivedStateOf {
            userName.value.isNotEmpty() && password.value.isNotEmpty()
        }
    }


    LaunchedEffect(navigateToHome.value) {
        if (navigateToHome.value) {
            successLogin(userName.value)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = userName.value,
            onValueChange = viewModel::onChangeUserName,
            label = { Text("Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = viewModel::onChangePassword,
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            trailingIcon = {
                val icon = if (passwordVisible) "🙈" else "👁️"
                TextButton(onClick = { passwordVisible = !passwordVisible }) {
                    Text(icon)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = viewModel::onLoginClick,
            enabled = isLoginButtonEnabled,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.login))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    LoginScreen { str ->
    }
}