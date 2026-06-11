plugins {
    id("java")
    alias(build.plugins.shadowJar)

}

group = "com.mcpvp"
version = "1.21.11-SNAPSHOT"

dependencies {
    implementation(build.libs.command)
    implementation(build.libs.inventory)
    implementation(build.libs.packets)

    compileOnly(build.libs.leaf)

    compileOnly(build.libs.fastutil)

    compileOnly(build.libs.lombok)
    annotationProcessor(build.libs.lombok)
}

tasks {

    shadowJar {

        relocate("dev.despical.commandframework", "com.mcpvp.relocate.command")
        relocate("me.devnatan.inventoryframework", "com.mcpvp.relocate.menu")
        relocate("com.tcoded.folialib", "com.mcpvp.relocate.folialib")

        dependencies {
            exclude(dependency("com.github.pop4959:Chunky"))
        }

    }

}