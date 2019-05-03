node {
    pproperties([parameters([string(defaultValue: 'IP', description: 'where should i build?', name: 'Environment', trim: false)]), pipelineTriggers([pollSCM('* * * * *')])])
     stage("Pull Repo"){
         git 'https://github.com/dilfuza97/Cool_website.git'
     }
     stage("Websever Install"){
         sh "ssh ec2-user@54.194.169.141  sudo yum install httpd -y "

 }
     stage("Index file"){
         sh "scp index.html ec2-user@54.194.169.141:/tmp"


      
}
   stage("Move index"){
        sh "ssh  ec2-user@54.194.169.141     sudo mv /tmp/index.html        /var/www/html/index.html"
    }
    stage("Restart webserver"){
        sh "ssh  ec2-user@54.194.169.141      sudo systemctl restart httpd "
    }
}