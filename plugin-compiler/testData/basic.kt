// SOURCE
// FILE: Main.kt [MainKt#main]
fun main() {
    println("Hello Kotlin Compiler Plugins!")
}

// EXPECT
// FILE: MainKt.main.stdout
Hello Kotlin Compiler Plugins!
// FILE: Main.kt.ir
FILE fqName:<root> fileName:Main.kt
  FUN name:main visibility:public modality:FINAL <> () returnType:kotlin.Unit
    BLOCK_BODY
      CALL 'public final fun println (message: kotlin.Any?): kotlin.Unit [inline] declared in kotlin.io' type=kotlin.Unit origin=null
        message: CONST String type=kotlin.String value="Hello Kotlin Compiler Plugins!"
