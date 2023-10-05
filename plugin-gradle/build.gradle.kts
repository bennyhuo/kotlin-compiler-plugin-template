plugins {
    id("java-gradle-plugin")
    kotlin("jvm")
    id("com.github.gmazzo.buildconfig")
}

dependencies {
    implementation(kotlin("gradle-plugin-api"))
    implementation(kotlin("stdlib"))
}

buildConfig {
    val compilerPluginProject = project(":plugin-compiler-embeddable")
    packageName("${compilerPluginProject.group}.plugin.template")
    buildConfigField("String", "KOTLIN_PLUGIN_ID", "\"${property("KOTLIN_PLUGIN_ID")}\"")
    buildConfigField("String", "KOTLIN_PLUGIN_GROUP", "\"${compilerPluginProject.group}\"")
    buildConfigField("String", "KOTLIN_PLUGIN_NAME", "\"${compilerPluginProject.property("POM_ARTIFACT_ID")}\"")
    buildConfigField("String", "KOTLIN_PLUGIN_VERSION", "\"${compilerPluginProject.version}\"")
}

gradlePlugin {
    plugins {
        create("TemplateGradlePlugin") {
            id = project.properties["KOTLIN_PLUGIN_ID"] as String
            displayName = "Template plugin"
            description = "Template plugin"
            implementationClass = "com.bennyhuo.kotlin.plugin.template.gradle.TemplateGradlePlugin"
        }
    }
}
