def call(String hubuser, String repo, String repotag) {

    sh "docker login -u '$Username' -p '$Password'"
    sh "docker image build -t ${hubuser}/${repo}:${repotag}-v${env.BUILD_NUMBER} ."
    sh "docker image push ${hubuser}/${repo}:${repotag}-v${env.BUILD_NUMBER}"
    sh "docker image rm ${hubuser}/${repo}:${repotag}-v${env.BUILD_NUMBER}"   
}
