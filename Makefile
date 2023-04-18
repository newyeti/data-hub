# Docker Commands

# Application and its dependent infrastructure
up:
	docker compose up -d
down:
	docker compose down

# Elastic Search
elk-up:
	docker compose -f docker-compose-elk.yml up -d
elk-down:	
	docker compose -f docker-compose-elk.yml down

# Build Commands
#
build-image-only:
  mvn -s maven_settings.xml clean compile jib:dockerBuild

#Build image and push to registry
build-image:
	mvn -s maven_settings.xml clean compile jib:build

build-image-only-local:
  mvn clean compile jib:dockerBuild

#Build image and push to registry
build-image-local:
	mvn clean compile jib:build