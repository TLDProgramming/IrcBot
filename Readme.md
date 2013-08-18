#IrcBot
This is a simple irc bot that can output the subject of an email message to an irc channel

##Usage
You need a config.txt file in the same directory as the ircbot.jar file
The config.txt should look something like this;

```
# Lines starting with # are comments and will be ignored
# The server has to be a pop3 server, and for best results have it set to not delete messages
Server: pop.gmail.com
# This is the pop3 server port
Port: 995
# The email address username, e.g. foo@bar.com would have the foo username
Username: foo
# The password to the email account
Password: bar
# The nick for the irc bot
Nick: Bot1 
# The irc server to join
IrcServer: irc.foobar.com
# The channel on the server for it to output messgaes to
Channel: #foobar

```

Then you just need to run the jar file with java, either from command line or from a batch/shell script