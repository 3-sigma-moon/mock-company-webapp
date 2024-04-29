pipeline {
    agent any

    stages {

        stage("Build") {
            withEnv(['YARN_HOME=C:/Users/maiga/AppData/Roaming/npm/node_modules/yarn']) {
                bat '$YARN_HOME/bin'
            }
            steps {
                bat " cd C:/Users/maiga/Downloads/accenture_advanced_software_engineering/mock-company-webapp"
                echo "Building Stage Start"
                bat "./gradlew assemble --stacktrace"
                echo "Building Stage End"
            }
        }
        stage("Test") {
            withEnv(['YARN_HOME=C:/Users/maiga/AppData/Roaming/npm/node_modules/yarn']) {
                bat '$YARN_HOME/bin'
            }
            steps {
                echo "Testing Stage Start"
                bat "./gradlew test"
            }
        }
    }
}