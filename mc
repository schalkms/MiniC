#!/usr/bin/env bash

VERSION="1.0.0-rc2"
LANGUAGE_PATH="./lang/target/mc-1.0-SNAPSHOT.jar"
LAUNCHER_PATH="./main/target/main-1.0-SNAPSHOT.jar"
MAIN_CLASS="ms.minic.Main"

#######################################################################
#            Check if the language and launcher jars exist            #
#######################################################################
if [[ ! -f $LANGUAGE_PATH ]]; then
    echo "Could not find language on $LANGUAGE_PATH. Did you run mvn package?"
    exit
fi

if [[ ! -f $LAUNCHER_PATH ]]; then
    echo "Could not find launcher on $LAUNCHER_PATH. Did you run mvn package?"
    exit
fi

#######################################################################
#               Check the GraalVM version in JAVA_HOME                #
#######################################################################
if [[ "$JAVA_HOME" != "" ]]; then
    GRAALVM_VERSION=$(grep "GRAALVM_VERSION" "$JAVA_HOME"/release)
    if [[ "$GRAALVM_VERSION" != "" ]]; then
        GRAALVM_VERSION=$(echo "$GRAALVM_VERSION" | awk 'BEGIN {FS="="} {print $2}')
        if [[ "$GRAALVM_VERSION" != "$VERSION" ]]; then
            echo "Wrong version of GraalVM in \$JAVA_HOME. Expected: $VERSION, found $GRAALVM_VERSION"
            exit
        fi
    fi
    JAVACMD=${JAVACMD:=$JAVA_HOME/bin/java}
else
    echo "JAVA_HOME is not set"
    exit
fi

#######################################################################
#          Parse arguments, prepare Java command and execute.         #
#######################################################################
if [[ "$GRAALVM_VERSION" != "" ]]; then
    PROGRAM_ARGS=""
    JAVA_ARGS=""

    for opt in "$@"
    do
      case $opt in
        -debug)
          JAVA_ARGS="$JAVA_ARGS -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8000,suspend=y" ;;
        -dump)
          JAVA_ARGS="$JAVA_ARGS -Dgraal.Dump=Truffle:1 -Dgraal.TruffleBackgroundCompilation=false -Dgraal.TraceTruffleCompilation=true -Dgraal.TraceTruffleCompilationDetails=true" ;;
        -disassemble)
          JAVA_ARGS="$JAVA_ARGS -XX:CompileCommand=print,*OptimizedCallTarget.callRoot -XX:CompileCommand=exclude,*OptimizedCallTarget.callRoot -Dgraal.TruffleBackgroundCompilation=false -Dgraal.TraceTruffleCompilation=true -Dgraal.TraceTruffleCompilationDetails=true" ;;
        -J*)
          opt=${opt:2}
          JAVA_ARGS="$JAVA_ARGS $opt" ;;
        *)
          PROGRAM_ARGS="$PROGRAM_ARGS $opt" ;;
      esac
    done
    echo $JAVACMD $JAVA_ARGS -Dtruffle.class.path.append=$LANGUAGE_PATH -cp $LAUNCHER_PATH $MAIN_CLASS $PROGRAM_ARGS

    $JAVACMD $JAVA_ARGS -Dtruffle.class.path.append=$LANGUAGE_PATH -cp $LAUNCHER_PATH $MAIN_CLASS $PROGRAM_ARGS
else
    echo "Warning: Could not find GraalVM on $JAVA_HOME. Running on JDK without support for compilation."
    echo
    PROGRAM_ARGS=""
    JAVA_ARGS=""

    for opt in "$@"
    do
      case $opt in
        -debug)
          JAVA_ARGS="$JAVA_ARGS -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8000,suspend=y" ;;
        -dump)
          echo "NOTE: Ignoring -dump, only supported on GraalVM." ;;
        -disassemble)
          echo "NOTE: Ignoring -disassemble" ;;
        -J*)
          opt=${opt:2}
          JAVA_ARGS="$JAVA_ARGS $opt" ;;
        *)
          PROGRAM_ARGS="$PROGRAM_ARGS $opt" ;;
      esac
    done
    if [[ ! -d $HOME/.m2 ]]; then
        echo "Could not find mvn cache at $HOME/.m2"
        exit
    fi
    GRAAL_SDK_PATH="$HOME/.m2/repository/org/graalvm/graal-sdk/$VERSION/graal-sdk-$VERSION.jar"
    TRUFFLE_API_PATH="$HOME/.m2/repository/com/oracle/truffle/truffle-api/$VERSION/truffle-api-$VERSION.jar"
    echo $JAVACMD -cp $GRAAL_SDK_PATH:$LAUNCHER_PATH:$LANGUAGE_PATH:$TRUFFLE_API_PATH $MAIN_CLASS $PROGRAM_ARGS
    $JAVACMD -cp $GRAAL_SDK_PATH:$LAUNCHER_PATH:$LANGUAGE_PATH:$TRUFFLE_API_PATH $MAIN_CLASS $PROGRAM_ARGS
fi
