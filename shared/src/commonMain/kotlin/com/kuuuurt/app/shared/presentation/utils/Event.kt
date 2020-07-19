package com.kuuuurt.app.shared.presentation.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

/**
 * For one-shot events
 */
class Event<out T>(private val content: T) {
    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContent(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun requireContent(): T = content
}

fun <T> T.toEvent() = Event(this)
fun <T> Flow<Event<T>>.onEachEvent(block: suspend (T) -> Unit) = onEach {
    val content = it.getContent() ?: return@onEach
    block(content)
}


