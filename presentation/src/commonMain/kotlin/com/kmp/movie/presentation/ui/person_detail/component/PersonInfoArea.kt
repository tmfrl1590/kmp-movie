package com.kmp.movie.presentation.ui.person_detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        color = Color.White
    )
}

@Composable
private fun PersonBirthDay(
    birthDay: String?,
){
    birthDay?.let {
        Text(
            text = "생년월일 $it",
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
private fun PersonGender(
    gender: String,
){
    Text(
        text = "성별 $gender",
        fontSize = 16.sp,
        color = Color.White
    )
}

@Composable
private fun KnownForDepartment(
    knownForDepartment: String,
){
    Text(
        text = "직업 $knownForDepartment",
        fontSize = 16.sp,
        color = Color.White
    )
}