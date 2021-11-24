pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven 3.8.3"
    }

    stages {
        
        
        stage('cleanyackage') {
            steps {
                // Get some code from a GitHub repository
                bat 'mvn  clean package'
            }
        }
         stage('clean') {
            steps {
                // Get some code from a GitHub repository
                bat 'mvn  clean'
             }
        }
            
          stage('package') {
            steps {
                // Get some code from a GitHub repository
                bat 'mvn  package'
             }
        }

                

       
    }   
}
