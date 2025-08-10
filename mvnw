#!/bin/sh
# ----------------------------------------------------------------------------
# Maven Start Up Batch script
#
# Required ENV vars:
# ------------------
#   JAVA_HOME - location of a JDK home dir
#
# Optional ENV vars
# -----------------
#   MAVEN_OPTS - parameters passed to the Java VM when running Maven
#     e.g. to debug Maven itself, use
#       set MAVEN_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000
#   MAVEN_SKIP_RC - flag to disable loading of mavenrc files
# ----------------------------------------------------------------------------

# resolve links - $0 may be a link
PRG="$0"

while [ -h "$PRG" ] ; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=`dirname "$PRG"`/"$link"
  fi
done

PRG_DIR=`dirname "$PRG"`
APP_BASE_DIR=`cd "$PRG_DIR"; pwd -P`

# Load environment variables from .mavenrc files, if they exist
if [ -z "$MAVEN_SKIP_RC" ] ; then

  if [ -f /etc/mavenrc ] ; then
    . /etc/mavenrc
  fi

  if [ -f "$HOME/.mavenrc" ] ; then
    . "$HOME/.mavenrc"
  fi

fi

# OS specific support.
unameOut=`uname`
case "$unameOut" in
  CYGWIN*) cygwin=true ;;
  MINGW*) mingw=true ;;
  MSYS*) msys=true ;;
  Darwin*) darwin=true ;;
  *) ;;
esac

# For Cygwin, ensure paths are in UNIX format before anything is touched
if [ "$cygwin" = true ] ; then
  [ -n "$JAVA_HOME" ] && JAVA_HOME=`cygpath --unix "$JAVA_HOME"`
fi

# Locate Java
if [ -z "$JAVA_HOME" ] ; then
  javaExecutable="`which java`"
  if [ -n "$javaExecutable" ] && ! [ -x "$javaExecutable" ] ; then
    # readlink(1) is not available as standard on Solaris 10.
    readLink=`which readlink`
    if [ -n "$readLink" ] ; then
      if $darwin ; then
        javaHome="`dirname \"$javaExecutable\"`/.."
      else
        javaHome="`dirname \"$javaExecutable\"`/.."
      fi
      JAVA_HOME="`cd \"$javaHome\" && pwd -P`"
    fi
  fi
fi

if [ -z "$JAVACMD" ] ; then
  if [ -n "$JAVA_HOME"  ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
      # IBM's JDK on AIX uses strange locations for the executables
      JAVACMD="$JAVA_HOME/jre/sh/java"
    else
      JAVACMD="$JAVA_HOME/bin/java"
    fi
  else
    JAVACMD="java"
  fi
fi

if [ ! -x "$JAVACMD" ] ; then
  echo "Error: JAVA_HOME is not defined correctly." >&2
  echo "  We cannot execute $JAVACMD" >&2
  exit 1
fi

MAVEN_PROJECTBASEDIR=${MAVEN_BASEDIR:-"$APP_BASE_DIR"}

WRAPPER_JAR="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar"
WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain

# Download maven-wrapper.jar if it does not exist
if [ -r "$WRAPPER_JAR" ]; then
    if [ "$MVNW_VERBOSE" = true ]; then
      echo "Found $WRAPPER_JAR"
    fi
else
    if [ "$MVNW_VERBOSE" = true ]; then
      echo "Couldn't find $WRAPPER_JAR, downloading it ..."
    fi
    if command -v curl >/dev/null 2>&1; then
      curl -fsSL -o "$WRAPPER_JAR" "https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"
    elif command -v wget >/dev/null 2>&1; then
      wget -q -O "$WRAPPER_JAR" "https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"
    else
      echo "Error: couldn't find curl or wget to download maven-wrapper.jar" >&2
      exit 1
    fi
fi

# Provide a fallback if the maven wrapper properties file does not exist
MAVEN_WRAPPER_PROPERTIES="${MAVEN_PROJECTBASEDIR}/.mvn/wrapper/maven-wrapper.properties"
if [ ! -f "$MAVEN_WRAPPER_PROPERTIES" ]; then
  mkdir -p "${MAVEN_PROJECTBASEDIR}/.mvn/wrapper"
  cat > "$MAVEN_WRAPPER_PROPERTIES" << EOF
distributionUrl=https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.8/apache-maven-3.9.8-bin.zip
wrapperUrl=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar
EOF
fi

# For Cygwin, switch paths to Windows format before running java
if [ "$cygwin" = true -o "$msys" = true ] ; then
  MAVEN_PROJECTBASEDIR=`cygpath --path --windows "$MAVEN_PROJECTBASEDIR"`
fi

exec "$JAVACMD" \
  $MAVEN_OPTS \
  -classpath "$WRAPPER_JAR" \
  "-Dmaven.multiModuleProjectDirectory=$MAVEN_PROJECTBASEDIR" \
  $WRAPPER_LAUNCHER \
  "$@"