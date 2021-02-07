"$JAVA_HOME"/bin/native-image \
    --macro:truffle --no-fallback --initialize-at-build-time \
    -cp target/micro_jit-1.0-SNAPSHOT-jar-with-dependencies.jar \
    micro.Launcher \
    micro-njit
