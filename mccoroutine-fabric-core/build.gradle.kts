repositories {
    maven {
        url = uri("https://maven.fabricmc.net")
    }
    maven {
        url = uri("https://libraries.minecraft.net") // Brigadier
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

dependencies {
    implementation(project(":mccoroutine-fabric-api"))
    compileOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
    compileOnly("net.fabricmc:fabric-loader:0.14.13")
    compileOnly("net.fabricmc.fabric-api:fabric-api:0.73.0+1.19.3")
    testImplementation("com.mojang:brigadier:1.0.18")
    testImplementation("net.fabricmc:fabric-loader:0.14.13")
    testImplementation("net.fabricmc.fabric-api:fabric-api:0.73.0+1.19.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
}
