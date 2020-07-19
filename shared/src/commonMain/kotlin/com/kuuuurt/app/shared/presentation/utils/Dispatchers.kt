package com.kuuuurt.app.shared.presentation.utils

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Copyright 2020, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 07/19/2020
 */

expect var mainDispatcher: CoroutineDispatcher
expect var ioDispatcher: CoroutineDispatcher