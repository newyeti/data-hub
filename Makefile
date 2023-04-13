up:
	docker compose up -d

down:
	docker compose down

build-image-only:
  mvn -s maven_settings.xml clean compile jib:dockerBuild

#Build image and push to registry
build-image:
	mvn -s maven_settings.xml clean compile jib:build