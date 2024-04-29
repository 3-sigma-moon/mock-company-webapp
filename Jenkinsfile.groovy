pipeline {
    agent any
    stages {
        stage("Install") {
            steps {
                bat "npm i -g yarn"
                bat "npm i -l yarn"
            }
        }
        stage("Build") {
            steps {
                echo "Building Stage Start"
                bat "./gradlew assemble --stacktrace"
                echo "Building Stage End"
            }
        }
        stage("Test") {
            steps {
                echo "Testing Stage Start"
                bat "./gradlew test"
                echo "Testing Stage End"
            }
        }
    }
}