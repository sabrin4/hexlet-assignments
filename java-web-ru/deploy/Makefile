test:
	gradle test

start:
	gradle run

stage:
    task stage(dependsOn: ['clean', 'installDist'])
    installDist.mustRunAfter clean
