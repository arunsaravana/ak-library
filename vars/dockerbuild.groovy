def call(String hubuser, String repo, String repotag, String hubcred) {
            def image= "${hubuser}/${repo}:${repotag}-v${env.BUILD_NUMBER}"
            echo "${image}"
withCredentials([usernamePassword(
            credentialsId: "${hubcred}",
            usernameVariable: "Username",
            passwordVariable: "Password"
        )]) {
    sh "docker login -u '$Username' -p '$Password'"
    sh "docker image build -t ${hubuser}/${repo}:${repotag}-v${env.BUILD_NUMBER} ."
    sh "docker image push ${hubuser}/${repo}:${repotag}-v${env.BUILD_NUMBER}"
    sh "docker image rm ${hubuser}/${repo}:${repotag}-v${env.BUILD_NUMBER}"   
    
}
    
    //sh 'sed -i s/"IMAGEID"/"${hubuser}/${repo}:${repotag}-v${env.BUILD_NUMBER}"/g  app-deployment.yaml'
}
