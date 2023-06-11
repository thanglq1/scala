## Run
`docker compose up`

## Note
When running scala akka http service (in development mode), it waits for the user to press <b>Enter.</b>

When inside the container, standard input is not connected to a TTY and thus the read from standard input fails immediately which causes the server to stop, which also exits SBT since the run task was the only one. That's why container stop immediately after start.

Add `addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")` to <b>plugins.sbt</b> and use `sbt ~reStart` to start app
