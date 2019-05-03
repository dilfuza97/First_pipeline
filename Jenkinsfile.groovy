node {
     stage("Pull Repo"){
         git 'https://github.com/dilfuza97/Cool_website.git'
     }
     stage("Websever Install"){
         sh "ssh ec2-user@54.194.169.141  sudo yum install http -y "

 }
      
