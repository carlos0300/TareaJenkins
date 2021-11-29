pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven 3.8.3"
    }

    stages {
        
        
        stage('Test') {
            steps {

                bat 'mvn test'
                echo 'test de agregar, mostrar, editar, y eliminar completados'
            }
        }
        
        
                
       
    }   
}
