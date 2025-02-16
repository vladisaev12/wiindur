rm -rf build
./gradlew deploy
cp /home/isa/vlad_progs/wiindur/build/libs/wiindur.jar /home/isa/.local/share/Mindustry/mods
java -jar Mindustry.jar
