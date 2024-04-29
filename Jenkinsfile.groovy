pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                cd "C:\\Users\\maiga\\Downloads\\accenture_advanced_software_engineering\\mock-company-webapp"
                bat "yarn install"
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