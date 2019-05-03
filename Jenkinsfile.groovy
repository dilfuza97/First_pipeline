node {
     stage("Pull Repo"){
         git 'https://github.com/dilfuza97/Cool_website.git'
     }
     stage("Websever Install"){
         sh "ssh ec2-user@54.194.169.141  sudo yum install httpd -y "

 }
     stage("Index file"){
         sh "scp index.html ec2-user@54.194.169.141:/tmp"


      
}
    stage("Move Index"){
        sh "ssh ec2-user@54.194.169.141  sudo mv/tmp/index.html  /var/www/html/index.html"
}
}