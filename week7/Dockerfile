FROM ubuntu

# this is a comment
# install required environment

RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install default-jdk

# create hello world java app
RUN echo 'public class HiWorld{public static void main(String[] args){System.out.println("hello world from docker");}}' > HiWorld.java

# Run compiler
RUN javac HiWorld.java

# Run application

CMD ["java", "HiWorld"]