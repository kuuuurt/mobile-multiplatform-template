package com.kuuuurt.app.shared.presentation.utils

import kotlinx.coroutines.*
import platform.darwin.*
import kotlin.coroutines.CoroutineContext

/**
 * Copyright 2020, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 07/19/2020
 */

actual var mainDispatcher: CoroutineDispatcher = IosMainDispatcher
actual var ioDispatcher: CoroutineDispatcher = IosMainDispatcher

@OptIn(InternalCoroutinesApi::class, ExperimentalCoroutinesApi::class)
private object IosMainDispatcher: CoroutineDispatcher(), Delay {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) {
            try {
                block.run()
            } catch (err: Throwable) {
                throw err
            }
        }
    }

    override fun scheduleResumeAfterDelay(timeMillis: Long, continuation: CancellableContinuation<Unit>) {
        dispatch_after(dispatch_time(DISPATCH_TIME_NOW, timeMillis * 1_000_000), dispatch_get_main_queue()) {
            try {
                with(continuation) {
                    resumeUndispatched(Unit)
                }
            } catch (err: Throwable) {
                throw err
            }
        }
    }

    override fun invokeOnTimeout(timeMillis: Long, block: Runnable): DisposableHandle {
        val handle = object : DisposableHandle {
            var disposed = false
                private set

            override fun dispose() {
                disposed = true
            }
        }
        dispatch_after(dispatch_time(DISPATCH_TIME_NOW, timeMillis * 1_000_000), dispatch_get_main_queue()) {
            try {
                if (!handle.disposed) {
                    block.run()
                }
            } catch (err: Throwable) {
                throw err
            }
        }

        return handle
    }
}