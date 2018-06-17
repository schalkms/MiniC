#!/usr/bin/env bash

COMPONENT_DIR="component_temp_dir"
LANGUAGE_PATH="$COMPONENT_DIR/jre/languages/mc"

rm -rf COMPONENT_DIR

mkdir -p "$LANGUAGE_PATH"
cp ../lang/target/minic.jar "$LANGUAGE_PATH"

mkdir -p "$LANGUAGE_PATH/launcher"
cp ../main/target/mc-launcher.jar "$LANGUAGE_PATH/launcher/"

mkdir -p "$LANGUAGE_PATH/bin"
cp ../mc $LANGUAGE_PATH/bin/

mkdir -p "$COMPONENT_DIR/META-INF"
MANIFEST="$COMPONENT_DIR/META-INF/MANIFEST.MF"
touch "$MANIFEST"
echo "Bundle-Name: MiniC" >> "$MANIFEST"
echo "Bundle-Symbolic-Name: schalkms.mc" >> "$MANIFEST"
echo "Bundle-Version: 1.0.0-rc2" >> "$MANIFEST"
echo 'Bundle-RequireCapability: org.graalvm; filter:="(&(graalvm_version=1.0.0-rc2)(os_arch=amd64))"' >> "$MANIFEST"
echo "x-GraalVM-Polyglot-Part: True" >> "$MANIFEST"

cd $COMPONENT_DIR
jar cfm ../mc-component.jar META-INF/MANIFEST.MF .

echo "bin/mc = ../jre/languages/mc/bin/mc" > META-INF/symlinks
jar uf ../mc-component.jar META-INF/symlinks

echo "jre/languages/mc/bin/mc = rwxrwxr-x" > META-INF/permissions
jar uf ../mc-component.jar META-INF/permissions
cd ..
rm -rf $COMPONENT_DIR
