gpush msg:
  git add . && git commit -m "{{msg}}" && git push

clean install:
  mvn clean install

install only:
  mvn clean install -Dmaven.test.skip=true