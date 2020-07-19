package com.kuuuurt.app.shared.presentation.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Copyright 2020, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 07/19/2020
 */

actual var mainDispatcher: CoroutineDispatcher = Dispatchers.Main
actual var ioDispatcher: CoroutineDispatcher = Dispatchers.IO