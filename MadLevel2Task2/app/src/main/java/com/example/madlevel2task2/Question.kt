package com.example.madlevel2task2

data class Question (var question: String, val iscorrect: Boolean) {

    companion object {

        val QUESTIONS_VALUES= arrayOf(
            Question("a val and var are the same.",false),
            Question("Mobile Application Development grants 12ECTS.", true),
            Question("A Unit in Kotlin corresponds to avoid in Java.", true),
            Question("In Kotlin when teplaces the switch operator in Java.", false)
        )


    }
}