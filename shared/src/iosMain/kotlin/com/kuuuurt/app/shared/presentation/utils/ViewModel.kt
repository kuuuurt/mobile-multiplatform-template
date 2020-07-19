package com.kuuuurt.app.shared.presentation.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

/**
 * Copyright 2020, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 07/19/2020
 */

actual open class ViewModel actual constructor() {
    private val viewModelJob = SupervisorJob()
    val viewModelScope: CoroutineScope = CoroutineScope(mainDispatcher + viewModelJob)

    actual val clientScope: CoroutineScope = viewModelScope

    protected actual open fun onCleared() {
        viewModelJob.cancelChildren()
    }
}