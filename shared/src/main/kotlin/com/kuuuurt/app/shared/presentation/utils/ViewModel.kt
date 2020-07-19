package com.kuuuurt.app.shared.presentation.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

/**
 * Copyright 2020, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 07/19/2020
 */

actual open class ViewModel actual constructor() : ViewModel() {
    actual val clientScope: CoroutineScope = viewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }
}