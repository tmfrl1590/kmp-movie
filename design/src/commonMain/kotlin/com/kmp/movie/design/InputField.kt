package com.kmp.movie.design

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

val ICON_SIZE = 20.dp
const val SEARCH_BAR_PLACE_HOLDER = "책 이름을 입력해주세요"

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    inputText: String,
    maxLines: Int = 1,
    singleLine: Boolean = true,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    focusRequester: FocusRequester,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Search,
    keyboardActions: KeyboardActions
){
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    TextField(
        modifier = modifier,
        value = inputText,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = SEARCH_BAR_PLACE_HOLDER)
        },
        singleLine = singleLine,
        maxLines = maxLines,
        shape = RoundedCornerShape(8.dp),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.LightGray,
            unfocusedContainerColor = Color.LightGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
        ),
        keyboardActions = keyboardActions,
    )
}