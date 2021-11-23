pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven 3.8.3"
    }

    stages {
        
        stage('clean') {
            steps {
                // Get some code from a GitHub repository
                bat 'mvn  clean'
                bat 'echo Limpiando'
            }
        }
        stage('Compile') {
            steps {
                // Get some code from a GitHub repository
                bat 'mvn  compile'
                bat 'echo Compilando'
             }
        }   
        stage('Test') {
            steps {
                // Get some code from a GitHub repository
                bat 'mvn test'
                bat 'echo Testeando'
             }
        }   
    }   
}
