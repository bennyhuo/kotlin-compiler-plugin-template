package com.bennyhuo.kotlin.plugin.template.compiler

import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector

lateinit var logger: Logger

class Logger(private val messageCollector: MessageCollector) {

    fun info(message: Any?) {
        println(CompilerMessageSeverity.INFO, message)
    }

    fun warn(message: Any?) {
        println(CompilerMessageSeverity.WARNING, message)
    }

    fun error(message: Any?) {
        println(CompilerMessageSeverity.ERROR, message)
    }

    fun println(level: CompilerMessageSeverity, message: Any?) {
        messageCollector.report(level, "[Kotlin-Compiler-Plugin] ${message.toString()}")
    }

}
