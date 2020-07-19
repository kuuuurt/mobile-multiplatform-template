package com.kuuuurt.app.shared.presentation.utils

import kotlinx.coroutines.CoroutineScope

/**
 * Copyright 2020, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 07/19/2020
 */


expect open class ViewModel() {
    val clientScope: CoroutineScope
    protected open fun onCleared()
}