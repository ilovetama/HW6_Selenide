for launch with firefox or chrome driver use:  

clean -Dgroups=test1(or test2, test3) test -DdriverType=firefox  
(or leave blank to use chrome by default)
-----------------------------------------
for launch with remote driver on selenium Grid use:  

clean test -Dselenide.remote=http://localhost:4444/ -Dselenide.browser=firefox  
(or leave blank to use chrome by default)
-----------------------------------------
if use  
clean test -DdriverType=firefox  
all tests will be start in parallel mode
