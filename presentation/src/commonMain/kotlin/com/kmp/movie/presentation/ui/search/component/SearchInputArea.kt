package com.kmp.movie.presentation.ui.search.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.kmp.movie.design.InputField

@Composable
fun SearchInputArea(
    inputText: String,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit,
    onResetInputText: () -> Unit,
){
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    InputField(
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
        ,
        inputText = inputText,
        placeHolder = "영화제목을 입력해주세요",
        onValueChange = onValueChange,
        leadingIcon = {
            IconButton(
                onClick = {
                    keyboardController?.hide()
                    onSearch()
                },
            ){
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search",
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        },
        trailingIcon = {
            if(inputText.isNotEmpty()){
                IconButton(
                    onClick = onResetInputText,
                ){
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "close",
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        },
        focusRequester = focusRequester,
        keyboardActions = KeyboardActions(
            onSearch = {
                focusManager.clearFocus()
                keyboardController?.hide()
                onSearch()
            },
        )
    )
}