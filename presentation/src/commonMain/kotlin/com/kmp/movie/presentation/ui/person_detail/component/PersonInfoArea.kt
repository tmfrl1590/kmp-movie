package com.kmp.movie.presentation.ui.person_detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmp.movie.core.Resources
import org.jetbrains.compose.resources.stringResource

@Composable
fun PersonInfoArea(
    name: String,
    birthDay: String?,
    gender: String,
    knownForDepartment: String,
){
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ){
        PersonName(
            name = name
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        PersonBirthDay(
            birthDay = birthDay
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        PersonGender(
            gender = gender,
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        KnownForDepartment(
            knownForDepartment = knownForDepartment,
        )
    }
}

@Composable
private fun PersonName(
    name: String,
){
    Text(
        text = name,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
private fun PersonBirthDay(
    birthDay: String?,
){
    birthDay?.let {
        Text(
            text = "${stringResource(Resources.String.birthDay)} $it",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
private fun PersonGender(
    gender: String,
){
    Text(
        text = "${stringResource(Resources.String.gender)} $gender",
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
private fun KnownForDepartment(
    knownForDepartment: String,
){
    Text(
        text = "${stringResource(Resources.String.knownForDepartment)} $knownForDepartment",
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.primary
    )
}