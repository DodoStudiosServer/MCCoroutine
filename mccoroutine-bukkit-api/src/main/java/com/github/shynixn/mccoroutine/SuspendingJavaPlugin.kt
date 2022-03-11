package com.github.shynixn.mccoroutine

import kotlinx.coroutines.runBlocking
import org.bukkit.plugin.java.JavaPlugin

/**
 * Extension to the JavaPlugin for suspendable lifecycle functions.
 */
open class SuspendingJavaPlugin : JavaPlugin(), SuspendingPlugin {
    /**
     * Called when this plugin is enabled
     */
    override suspend fun onEnableAsync() {
    }

    /**
     * Called when this plugin is disabled.
     */
    override suspend fun onDisableAsync() {
    }

    /**
     * Called after a plugin is loaded but before it has been enabled.
     *
     *
     * When multiple plugins are loaded, the onLoad() for all plugins is
     * called before any onEnable() is called.
     */
    override suspend fun onLoadAsync() {
    }

    /**
     * Called when this plugin is enabled
     */
    override fun onEnable() {
        runBlocking(mcCoroutine.getCoroutineSession(this).manipulatedDispatcherMinecraft) {
            onEnableAsync()
        }
    }

    /**
     * Called when this plugin is disabled
     */
    override fun onDisable() {
        runBlocking {
            onDisableAsync()
        }
    }

    /**
     * Called after a plugin is loaded but before it has been enabled.
     *
     *
     * When multiple plugins are loaded, the onLoad() for all plugins is
     * called before any onEnable() is called.
     */
    override fun onLoad() {
        runBlocking {
            onLoadAsync()
        }
    }
}
