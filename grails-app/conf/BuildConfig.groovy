grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

def camelVersion = "2.9.4"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
      excludes 'ehcache', 'antlr'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
      // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

      build("org.apache.camel:camel-core:${camelVersion}") { excludes 'slf4j-api' }
      build("org.apache.camel:camel-spring:${camelVersion}") {
        excludes "spring-aop", "spring-beans", "spring-core", "spring-expression", "spring-asm", "spring-tx", "spring-context"
      }
      runtime("org.apache.camel:camel-groovy:${camelVersion}") {
        excludes "spring-context", "spring-aop", "spring-tx", "groovy-all"
      }
      runtime("org.apache.camel:camel-stream:${camelVersion}")
    }
}
