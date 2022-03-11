package com.github.shynixn.mccoroutine.contract

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

interface CoroutineSession {
    /**
     * Gets the scope.
     */
    val scope: CoroutineScope

    /**
     * Gets the event service.
     */
    val eventService: EventService

    /**
     * Gets the command service.
     */
    val commandService: CommandService

    /**
     * Gets the minecraft dispatcher.
     */
    val dispatcherMinecraft: CoroutineContext

    /**
     * Gets the async dispatcher.
     */
    val dispatcherAsync: CoroutineContext

    /**
     * A minecraft dispatcher which manipulates thread locks.
     * Do not use it.
     */
    val manipulatedDispatcherMinecraft: CoroutineContext

    /**
     * An async dispatcher which manipulates thread locks.
     * Do not use it.
     */
    val manipulatedDispatcherAsync: CoroutineContext

    /**
     * Launches the given function on the plugin coroutine scope.
     * @return Cancelable coroutine job.
     */
    fun launch(
        context: CoroutineContext,
        start: CoroutineStart,
        block: suspend CoroutineScope.() -> Unit
    ): Job

    /**
     * Disposes the session.
     */
    fun dispose()
}
