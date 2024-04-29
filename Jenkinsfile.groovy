pipeline {
    agent any
    withEnv(['YARN_HOME=C:/Users/maiga/AppData/Roaming/npm/node_modules/yarn/bin']) {
        stage('Prepare') {
            steps {
                bat "npm install -g yarn"
                bat "yarn install"
            }

        }
    }
    stages {
        stage('Prepare') {
            steps {
                sh "npm install -g yarn"
                sh "yarn install"
            }

        }

        stage("Build") {
            steps {
                bat " cd C:/Users/maiga/Downloads/accenture_advanced_software_engineering/mock-company-webapp"
                echo "Building Stage Start"
                bat "./gradlew assemble --stacktrace"
                echo "Building Stage End"
            }
        }
        stage("Test") {
            steps {
                echo "Testing Stage Start"
                bat "./gradlew test"
            }
        }
    }
}