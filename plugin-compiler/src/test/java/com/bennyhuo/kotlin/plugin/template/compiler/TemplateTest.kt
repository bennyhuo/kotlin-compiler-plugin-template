package com.bennyhuo.kotlin.plugin.template.compiler

import com.bennyhuo.kotlin.compiletesting.extensions.module.IR_OUTPUT_TYPE_KOTLIN_LIKE_JC
import com.bennyhuo.kotlin.compiletesting.extensions.module.IR_OUTPUT_TYPE_RAW
import com.bennyhuo.kotlin.compiletesting.extensions.module.KotlinModule
import com.bennyhuo.kotlin.compiletesting.extensions.module.checkResult
import com.bennyhuo.kotlin.compiletesting.extensions.source.FileBasedModuleInfoLoader
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.junit.Test

/**
 * Created by benny at 2022/1/15 8:55 PM.
 */
@OptIn(ExperimentalCompilerApi::class)
class TemplateTest {

    @Test
    fun basic() {
        testBase("basic.kt")
    }

    private fun testBase(fileName: String) {
        val loader = FileBasedModuleInfoLoader("testData/$fileName")
        val sourceModuleInfos = loader.loadSourceModuleInfos()

        val modules = sourceModuleInfos.map {
            KotlinModule(it, true, compilerPluginRegistrars = listOf(TemplateCompilerPluginRegistrar()))
        }

        modules.checkResult(
            loader.loadExpectModuleInfos(),
            executeEntries = true,
            checkGeneratedIr = true,
            irOutputType = IR_OUTPUT_TYPE_RAW
        )
    }

}
