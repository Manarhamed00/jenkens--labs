Welcome to My Awesome Project! This project is designed to demonstrate setting up a Jenkins pipeline for a Django application, including automated testing.

Getting Started

These instructions will help you set up and run the project on your local machine for development and testing purposes.
Prerequisites

Before you begin, make sure you have the following software installed on your machine:

    Python (version 3.6 or higher)
    pip (Python package installer)
    Django (version 3.x)
    Docker
    Jenkins


-Installation

 1- Clone the repository to your local machine:

  git clone https://github.com/Manarhamed00/jenkens--labs.git

 2- Navigate to the project directory:

  cd jenkens--labs

 3- Install project dependencies:

  pip install -r myproject/requirements.txt


 4- Running Tests

 To run the automated tests for this system, execute the following command:

 python myproject/manage.py test

5- Usage

To start the Django development server, run the following command:

python myproject/manage.py runserver

You can now access the application at http://localhost:8000 in your web browser.


6- Tools Used

    Jenkins: Jenkins is used for continuous integration and deployment automation.
    Django: Django is a high-level Python web framework for rapid development.
    Docker: Docker is used for containerization of the Django application.
    Git: Git is a distributed version control system used for collaboration and version management.
    Python: Python is the programming language used for development.


7- Webhooks

To trigger Jenkins pipeline builds automatically on code changes, set up a webhook in your GitHub repository with the following URL:

http://your-jenkins-server/github-webhook/


8- Contributing

We welcome contributions from the community! If you'd like to contribute to this project, please follow these steps:

    Fork the repository on GitHub.
    Create a new branch off of develop for your feature or fix.
    Make your changes and commit them with clear, descriptive commit messages.
    Push your changes to your fork.
    Submit a pull request against the develop branch of the original repository.




    
