package com.kmp.movie.design.error

import com.kmp.movie.core.domain.DataError

fun DataError.toMessage(): String {
    return when (this) {
        DataError.Remote.NO_INTERNET -> "인터넷 연결을 확인해주세요."
        DataError.Remote.REQUEST_TIMEOUT -> "요청 시간이 초과되었습니다."
        DataError.Remote.UNAUTHORIZED -> "로그인이 필요합니다."
        DataError.Remote.TOO_MANY_REQUESTS -> "잠시 후 다시 시도해주세요."
        DataError.Remote.SERVER -> "서버 오류가 발생했습니다."
        DataError.Remote.SERIALIZATION -> "데이터 처리 중 오류가 발생했습니다."
        DataError.Remote.UNKNOWN -> "알 수 없는 오류가 발생했습니다."
        else -> ""
    }
}