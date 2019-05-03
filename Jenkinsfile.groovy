node {
    properties([parameters([string(defaultValue: 'IP', description: 'Where should I build? ', name: 'ENV', trim: true)]), pipelineTriggers([pollSCM('* * * * *')])])

     stage("Pull Repo"){
         git 'https://github.com/dilfuza97/Cool_website.git'
     }
     stage("Websever Install"){
         sh "ssh ec2-user@${ENV}  sudo yum install httpd -y "

 }
     stage("Index file"){
         sh "scp index.html ec2-user${ENV}:/tmp"


      
}
   stage("Move index"){
        sh "ssh  ec2-user@${ENV     sudo mv /tmp/index.html        /var/www/html/index.html"
    }
    stage("Restart webserver"){
        sh "ssh  ec2-user@${ENV}     sudo systemctl restart httpd "
    }
}