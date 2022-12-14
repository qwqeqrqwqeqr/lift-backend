package com.gradation.lift.data.model

enum class Status {
    SUCCESS,
    FAIL,
}

fun statusMapper(status: Status):  String =
    when (status) {
        Status.SUCCESS -> "success"
        Status.FAIL -> "fail"

    }