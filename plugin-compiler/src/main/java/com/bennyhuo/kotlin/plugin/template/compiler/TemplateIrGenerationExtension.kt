package com.bennyhuo.kotlin.plugin.template.compiler

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.expressions.IrConst
import org.jetbrains.kotlin.ir.expressions.IrConstKind
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.IrStringConcatenation
import org.jetbrains.kotlin.ir.util.dump
import org.jetbrains.kotlin.ir.visitors.IrElementTransformerVoid
import org.jetbrains.kotlin.ir.visitors.transformChildrenVoid

class TemplateIrGenerationExtension : IrGenerationExtension {


    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
        // print the original IR of moduleFragment.
        println(moduleFragment.dump())
        moduleFragment.transformChildrenVoid(object : IrElementTransformerVoid() {
            // visit some ir elements and make some changes...
        })
        // print the transformed IR of moduleFragment.
        println(moduleFragment.dump())
    }
}
