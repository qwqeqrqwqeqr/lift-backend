import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.5"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.gradation"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.springframework.boot:spring-boot-starter-hateoas")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
	runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.4")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:1.6.4")



	implementation ("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation ("com.github.jasync-sql:jasync-r2dbc-mysql:2.0.8")
	runtimeOnly("io.r2dbc:r2dbc-postgresql")

	testImplementation("io.kotest:kotest-runner-junit5:5.5.1")
	testImplementation("io.kotest:kotest-assertions-core:5.5.1")
	testImplementation("io.mockk:mockk:1.12.0")


	//fasterxml
	implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
	implementation("com.fasterxml.jackson.core:jackson-core:2.13.3")
	implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.+")

	//swagger
	implementation("io.springfox:springfox-swagger2:3.0.0")
	implementation("io.springfox:springfox-swagger-ui:3.0.0")
	implementation("io.springfox:springfox-boot-starter:3.0.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
