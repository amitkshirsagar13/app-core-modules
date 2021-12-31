gpush msg:
  git add . && git commit -m "{{msg}}" && git push

install:
  mvn install --no-transfer-progress

clean install:
  mvn clean install --no-transfer-progress

install-only:
  mvn clean install -Dmaven.test.skip=true --no-transfer-progress