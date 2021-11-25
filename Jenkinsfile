pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven 3.8.3"
    }

    stages {
        
        
        stage('Run') {
            steps {

                bat 'mvn spring-boot:run'
                echo 'Servidor Activo'
            }
        }
         stage('getMoto Contructor') {
            steps {

                bat 'localhost:8081/getMoto?marca=Bajaj'
                echo 'Petición Get con filtro por marca (Bajaj)'
             }
        }
                
       
    }   
}
